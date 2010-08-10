//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using DGAC.utils;
using DGAC;
using MPI;
using System.Runtime.Remoting.Channels.Tcp;
using System.IO;
using System.Runtime.Remoting.Channels;
using DGAC.database;
// using cca;

namespace DGAC
{ 
		//MANAGER
        public class ManagerObject: MarshalByRefObject{

            public ManagerObject() { Console.WriteLine("NEW MANAGER OBJECT"); }
 
    	    /**
	     * 	Creates an instance of a CCA component of the type defined by the 
	     * 	string className.  The string classname uniquely defines the
	     * 	"type" of the component, e.g.
	     * 	    doe.cca.Library.GaussianElmination. 
	     * 	It has an instance name given by the string instanceName.
	     * 	The instanceName may be empty (zero length) in which case
	     * 	the instanceName will be assigned to the component automatically.
	     * 	@throws CCAException If the Component className is unknown, or if the
	     * 		instanceName has already been used, a CCAException is thrown.
	     * 	@return A ComponentID corresponding to the created component. Destroying
	     * 		the returned ID does not destroy the component; 
	     * 		see destroyInstance instead.
	     */
            [MethodImpl(MethodImplOptions.Synchronized)]
            public void createInstance(string instanceName, string className , IDictionary<string,Object> properties )
            {
  //           try {

                 /* BEGIN FOM RunApplication */

                 IDictionary<Unit, int> files = new Dictionary<Unit, int>();
                 Object enumsObj = null;
                 IDictionary<string, int> enums = null;

                 if (!properties.TryGetValue("enums", out enumsObj))
                     enums = new Dictionary<string, int>();
                 else
                 {
                     enums = (IDictionary<string, int>)enumsObj;
                 }

                 Object nodesObj = null;
                 int[] nodes = null;
                 if (!properties.TryGetValue("nodes", out nodesObj))
                 {
                     nodes = new int[worker.Length];
                     for (int i = 0; i < nodes.Length; i++)
                     {
                         nodes[i] = i;
                     }
                 }
                 else
                 {
                     nodes = (int[])nodesObj;
                 }

                 Component c = BackEnd.cdao.retrieve_libraryPath(className);

                 IList<DGAC.database.Interface> iList = BackEnd.idao.list(c.Id_abstract);

                 int nprocs = 0;
                 int aprocs = nodes.Length; // number of informed processors.

                 foreach (DGAC.database.Interface i in iList)
                 {
                     DGAC.database.Unit u = BackEnd.udao.retrieve(c.Id_concrete, i.Id_interface, -1);
                     IList<EnumerationInterface> eiList = BackEnd.exitdao.listByInterface(c.Id_abstract, i.Id_interface);
                     int count = 1;
                     IDictionary<string, int> m = new Dictionary<string, int>();
                     foreach (EnumerationInterface ei in eiList)
                     {
                         Enumerator e = BackEnd.edao.retrieve(ei.Id_abstract, ei.Id_enumerator);
                         int v;
                         if (!m.TryGetValue(e.Variable, out v))
                         {
                             v = 1;
                             enums.TryGetValue(e.Variable, out v);
                             count *= v > 0 ? v : 1;
                             m.Add(e.Variable, v);
                         }
                     }
                     try
                     {
                         files.Add(u, count);
                     }
                     catch (ArgumentException)
                     {
                         throw new Exception("Argument Exception there !");
                     }
                     nprocs += count;
                 }


                 if (nprocs != aprocs)
                 {
                     throw new Exception("Unmatching number of nodes.");
                 }

                 /* END FOM RunApplication */
                 
                 bool[] node_marking = new bool[worker.Length];
                 for (int i = 0; i < node_marking.Length; i++)
                     node_marking[i] = false;

                 int k = 0;
                 foreach (KeyValuePair<Unit, int> unit in files)
                 {
                     for (int j = 0; j < unit.Value; j++)
                     {
                         IDictionary<string, Object> worker_properties = new Dictionary<string, Object>(properties);
                         worker_properties.Add("Key", k);
                         worker[nodes[k]].createInstance(instanceName, unit.Key, properties);
                         node_marking[nodes[k]] = true;
                         k++;
                     }
                 }

                 for (int i = 0; i < node_marking.Length; i++)
                 {
                     if (!node_marking[i])
                     {
                         worker[i].createInstanceNull();
                     }

                 }
//             } 
//             catch (Exception e) 
//             {
//                Console.WriteLine(e.Message);
//             }
            }

            /**
            * Salva arquivo fonte lido como um array de bytes em data, com o nome filename
            * em pasta definida pela classe Constants
            */
                [MethodImpl(MethodImplOptions.Synchronized)]
				public void saveData(byte[] data, string filename){

                    Console.WriteLine("Worker writing file " + filename);
                    //saving source file
					if(data!=null)
						FileUtil.saveByteArrayIntoFile(data,Constants.PATH_TEMP_WORKER+filename+".cs");
					
				}
		        
		        /*
		         *Compila fonte salvo pelo método anterior. O resultado por ser uma DLL ou arquivo executável,
                 *dependendo do parâmetro outFile, definido pela classe CONSTANTS.
		         *Se o fonte resultar em uma dll, ela é instalada no GAC, na pasta "HASH"
                 *Se o fonte for um executável, então ele é salvo numa pasta temporária, definida pela 
		         *classe Constants 
		         */
                [MethodImpl(MethodImplOptions.Synchronized)]
                public string compileClass
                    (string library_path,                                            
                     string contents, 
                     string moduleName, 
                     string[] references, 
                     int outFile, 
                     string userName, 
                     string password, 
                     string curDir)
                {
                    string publicKeyToken = null; 
                    string moduleNameWithoutExtension = moduleName.Split('.')[0];
                    Console.WriteLine("Compiling " + moduleName);
                    Console.WriteLine("password = " + password);
                    if (outFile == Constants.EXE_OUT)
                    {
                        CommandLineUtil.compile_to_exe(contents, moduleName, references, userName, password, curDir);
                    }
                    else
                    {
                        //creates the strong key, for new assembly
                        publicKeyToken = CommandLineUtil.create_strong_key(moduleName, userName, password, curDir);
                        //compile, generate dll 
                        CommandLineUtil.compile_source(contents, moduleName, references, userName, password, curDir);
                        //installing on local GAC
                        CommandLineUtil.gacutil_install(library_path, moduleNameWithoutExtension, 1, userName, password);
                    }
                    // Erase temporary files.
                    // CommandLineUtil.clean(moduleNameWithoutExtension);
                    return publicKeyToken;
                }
		        
		        /*
		         *Roda arquivos executáveis gerados pelo metodo anterior
                 */
		        [MethodImpl(MethodImplOptions.Synchronized)]
                public void runClass
                    (IDictionary<string, int> files, 
                     IDictionary<string, int> enums, 
                     int session_id, 
                     string userName, 
                     string password, 
                     String curDir)
                {
					CommandLineUtil.run_exe(files, enums, session_id, userName, password, curDir);
		        }
				
				//just for test
				[MethodImpl(MethodImplOptions.Synchronized)]
				public void sayHi(){
					Console.WriteLine("Hi!");
				}

                /* The Worker Object of each computing node */
                private WorkerObject[] worker = null;
                private string[] node = null;
                private TcpChannel tcpChannel = null;

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void startWorkerClients()
                {
                    Console.WriteLine("Starting worker clients !");

                    int i = 0;

                    try
                    {
                        /* Read nodes file, and fill the node array */
                        TextReader tr = new StreamReader(Constants.hosts_file);

                        string hstr = tr.ReadToEnd();
                        tr.Close();
                        node = hstr.Split('\n');

                        worker = new WorkerObject[node.Length - 1];

                        tcpChannel = new TcpChannel();
                        ChannelServices.RegisterChannel(tcpChannel, false);

                        /* Create each worker object and fill the worker array */
                        foreach (string n in node)
                        {
                            try
                            {
                                createWorkerObject(i++, n);
                                Console.WriteLine("CONNECTED TO WORKER " + n);
                            }
                            catch (Exception e)
                            {
                                i--;
                                Console.WriteLine("ERROR CONNECTING TO WORKER " + n + ". Exception : " + e.Message);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }

                    Console.WriteLine(worker.Length + " Worker clients started !");
                }

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void stopWorkerClients()
                {
                    TcpChannel ch = tcpChannel;
                    ch.StopListening(null);
                    ChannelServices.UnregisterChannel(ch);
                }

                private void createWorkerObject(int i, string node)
                {
                    WorkerObject wo = null;

                    Type requiredType = typeof(WorkerObject);

                    wo = (WorkerObject)Activator.GetObject(requiredType,
                        "tcp://" + node + ":" + Constants.WORKER_PORT + "/" + Constants.WORKER_SERVICE_NAME);

                    wo.sayHi();

                    worker[i] = wo;
                }

        }

        
}
