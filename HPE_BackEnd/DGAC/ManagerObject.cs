//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using br.ufc.hpe.backend.DGAC.utils;
using br.ufc.hpe.backend.DGAC;
using MPI;
using System.Runtime.Remoting.Channels.Tcp;
using System.IO;
using System.Runtime.Remoting.Channels;
using br.ufc.hpe.backend.DGAC.database;
using System.Threading;
using gov.cca;

namespace br.ufc.hpe.backend.DGAC
{ 
		//MANAGER
    public class ManagerObject : MarshalByRefObject, gov.cca.AbstractFramework, 
	                                                 gov.cca.ports.BuilderService, 
	                                                 gov.cca.ports.ComponentRepository
    {

            public ManagerObject() { }


            // ABSTRACT FRAMEWORK ====================================================================================================

            public TypeMap createTypeMap()
            {
                return null;
            }

            public gov.cca.Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties)
            {
                return null;
            }

            public void releaseServices(gov.cca.Services services)
            {
            }


            public void shutdownFramework()
            {

            }

            public AbstractFramework createEmptyFramework()
            {
                return null;
            }




            // BUILDER SERVICE ====================================================================================================


            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID createInstance(string instanceName, string className, TypeMap properties)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID[] getComponentIDs()
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getComponentProperties(ComponentID cid)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setComponentProperties(ComponentID cid, TypeMap map)
            {
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID getDeserialization(string s)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID getComponentID(string componentInstanceName)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void destroyInstance(ComponentID toDie, float timeout)
            {
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getProvidedPortNames(ComponentID cid)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getUsedPortNames(ComponentID cid)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getPortProperties(ComponentID cid, string portName)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setPortProperties(ComponentID cid, string portName, TypeMap map)
            {
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ConnectionID[] getConnectionIDs(ComponentID[] componentList)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getConnectionProperties(ConnectionID connID)
            {
                return null;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setConnectionProperties(ConnectionID connID, TypeMap map)
            {
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void disconnect(ConnectionID connID, float timeout)
            {
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void disconnectAll(ComponentID id1, ComponentID id2, float timeout)
            {
            }



            // COMPONENT REPOSITORY ====================================================================================================

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentClassDescription[] getAvailableComponentClasses()
            {
                return null;
            }




            [MethodImpl(MethodImplOptions.Synchronized)]
            public void createInstance(string instanceName, string className , IDictionary<int,Object> properties )
            {
             try {

                 Connector.openConnection();

                 /* BEGIN FOM RunApplication */

                Console.WriteLine("ENTROU createInstance manager");
               
                 IDictionary<Unit, int> files = new Dictionary<Unit, int>();
                 Object enumsObj = null;
                 IDictionary<string, int> enums = null;

                 if (!properties.TryGetValue(Constants.ENUMS_KEY, out enumsObj))
                 {
                     enums = new Dictionary<string, int>();
                 }
                 else
                 {
                     enums = (IDictionary<string, int>)enumsObj;
                 }

                 Object nodesObj = null;
                 int[] nodes = null;
                 if (!properties.TryGetValue(Constants.NODES_KEY, out nodesObj))
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

                 br.ufc.hpe.backend.DGAC.database.Component c = BackEnd.cdao.retrieve_libraryPath(className);
                 string hash_component_uid = c.Hash_component_UID;

                 IList<br.ufc.hpe.backend.DGAC.database.Interface> iList = BackEnd.idao.list(c.Id_abstract);

                 int nprocs = 0;
                 int aprocs = nodes.Length; // number of informed processors.

                 foreach (br.ufc.hpe.backend.DGAC.database.Interface i in iList)
                 {
                     br.ufc.hpe.backend.DGAC.database.Unit u = BackEnd.udao.retrieve(c.Id_concrete, i.Id_interface, -1);
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
                     // throw new Exception("Unmatching number of nodes.");
                 }

                 /* END FOM RunApplication */
                 
                 bool[] node_marking = new bool[worker.Length];
                 for (int i = 0; i < node_marking.Length; i++)
                     node_marking[i] = false;

                 
                 IList<Thread> wthreads = new List<Thread>();
                 int k = 0;
                 foreach (KeyValuePair<Unit, int> unit in files)
                 {
                     for (int j = 0; j < unit.Value; j++)
                     {
                         IDictionary<int, Object> worker_properties = new Dictionary<int, Object>(properties);
                         worker_properties.Add(Constants.KEY_KEY, k);
                         worker_properties.Add(Constants.UID_KEY, hash_component_uid);
                         GoWorker gw = new GoWorker(worker[nodes[k]], instanceName, unit.Key, worker_properties);
                         Thread t = new Thread(gw.Run);
                         t.Start();
                         wthreads.Add(t);    
                         // worker[nodes[k]].createInstance(instanceName, unit.Key, properties);
                         node_marking[nodes[k]] = true;
                         k++;
                     }
                 }

                 for (int i = 0; i < node_marking.Length; i++)
                 {
                     if (!node_marking[i])
                     {
                         Thread t = new Thread(worker[i].createInstanceNull);
                         wthreads.Add(t);
                         t.Start();
                     }

                 }

                 foreach (Thread t in wthreads) 
                          t.Join();

             } 
             catch (Exception e) 
             {
                Console.WriteLine(e.Message);
                throw e;
             } 
             finally 
             {
                Connector.closeConnection();
             }
            }

 

            protected class GoWorker 
            {
                 private string instanceName = null; 
                 private br.ufc.hpe.backend.DGAC.database.Unit key = null; 
                 private IDictionary<int, Object> properties = null;
                 private WorkerObject worker = null;
                 public GoWorker(WorkerObject worker_, string instanceName_, br.ufc.hpe.backend.DGAC.database.Unit key_, IDictionary<int, Object> properties_) 
                 { 
                     instanceName = instanceName_;
                     key = key_;
                     properties = properties_;
                     worker = worker_;
                 }

                 public void Run() 
                 {
                     worker.createInstance(instanceName, key, properties);
                 }
            } 

            /**
            * Salva arquivo fonte lido como um array de bytes em data, com o nome filename
            * em pasta definida pela classe Constants
            */
                [MethodImpl(MethodImplOptions.Synchronized)]
				public void saveData(byte[] data, string filename){

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

                    System.Type requiredType = typeof(WorkerObject);

                    wo = (WorkerObject)Activator.GetObject(requiredType,
                        "tcp://" + node + ":" + Constants.WORKER_PORT + "/" + Constants.WORKER_SERVICE_NAME);

                    wo.sayHi();

                    worker[i] = wo;
                }

        }

        
}
