//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.backend.DGAC;
using MPI;
using System.Runtime.Remoting.Channels.Tcp;
using System.IO;
using System.Runtime.Remoting.Channels;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Threading;
using gov.cca;


namespace br.ufc.pargo.hpe.backend.DGAC
{ 
		//MANAGER
    public class ManagerObject : MarshalByRefObject, gov.cca.AbstractFramework, 
	                                                 gov.cca.ports.BuilderService, 
	                                                 gov.cca.ports.ComponentRepository
    {
            public ManagerObject() 
            {
                Console.Out.WriteLine("Manager Object UP !");
            }

            private IDictionary<string, ComponentID> componentIDs = new Dictionary<string, ComponentID>();
            private IDictionary<ComponentID, TypeMap> componentProperties = new Dictionary<ComponentID, TypeMap>();
            private IList<ConnectionID> connectionList = new List<ConnectionID>();
            private IDictionary<ConnectionID, TypeMap> connectionProperties = new Dictionary<ConnectionID, TypeMap>();
            private IDictionary<string, ConnectionID> connByUserPort = new Dictionary<string, ConnectionID>();
            private IDictionary<string, ConnectionID> connByProviderPort = new Dictionary<string, ConnectionID>();
        
            private void registerComponentID(ComponentID cid, TypeMap properties)
            {
                componentIDs.Add(cid.getInstanceName(), cid);
                componentProperties.Add(cid, properties);
            }


            #region AbstractFramework Members

            public TypeMap createTypeMap()
            {
                return new TypeMapImpl();
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public gov.cca.Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties)
            {

                throw new CCAExceptionImpl("This operation is not allowed in the framework manager");


/*                int[] nodes = this.fetchNodes((HPETypeMap)selfProperties);

                ManagerComponentID cid = new ManagerComponentIDImpl(selfInstanceName);
                this.registerComponentID(cid, selfProperties);

                ManagerServices manager_services = new ManagerServicesImpl(this, cid);

                foreach (int i in nodes)
                {
                    WorkerObject w = worker[i];
                    WorkerServices worker_services = (WorkerServices) w.getServices(selfInstanceName, selfClassName, selfProperties);
                    manager_services.addWorkerServicesObject(i, worker_services);
                }

                return manager_services; */
            }

           // private IDictionary<Services, ComponentRelease> releaseRegister = new Dictionary<Services, ComponentRelease>();

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void releaseServices(gov.cca.Services services)
            {
                // Since getServices cannot be called, there is no sense to call releaseServices
                throw new CCAExceptionImpl("This operation is not allowed in the framework manager");

                /*  if (releaseRegister.ContainsKey(services))
                  {
                      ComponentRelease callBack;
                      releaseRegister.TryGetValue(services, out callBack);
                      callBack.releaseServices(services);
                  } */
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void shutdownFramework()
            {
                foreach (WorkerObject w in worker) 
                {
                    w.shutdownFramework();
                }
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public AbstractFramework createEmptyFramework()
            {
                throw new CCAExceptionImpl("This CCA framework forbids creation of another framework instance.");
            }

            #endregion

        
            #region BuilderService Members

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID createInstance(string instanceName, string className, TypeMap properties)
            {
                string[] unit_ids;
                int[] indexes;
                int[] cid_nodes;
                this.createInstanceImpl(instanceName, className, (TypeMapImpl) properties, out cid_nodes, out unit_ids, out indexes);
                ComponentID cid = new ManagerComponentIDImpl(instanceName, cid_nodes, unit_ids, indexes);
                this.registerComponentID(cid, properties);
                return cid;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID[] getComponentIDs()
            {
                ComponentID[] cids = new WorkerComponentIDImpl[componentIDs.Count];
                componentIDs.Values.CopyTo(cids, 0);
                return cids;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getComponentProperties(ComponentID cid)
            {
                TypeMap properties;
                componentProperties.TryGetValue(cid, out properties);
                return properties;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setComponentProperties(ComponentID cid, TypeMap map)
            {
                if (componentProperties.ContainsKey(cid))
                {
                    componentProperties.Remove(cid);
                }

                componentProperties.Add(cid, map);
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID getDeserialization(string s)
            {
                return null; /* TODO: XML serialization */
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID getComponentID(string componentInstanceName)
            {
                ComponentID cid = null;
                componentIDs.TryGetValue(componentInstanceName, out cid);
                return cid;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void destroyInstance(ComponentID toDie, float timeout)
            {
                // CALL DESTROY FOR EACH UNIT ...
                ManagerComponentID toDie_ = (ManagerComponentID)toDie;
                int[] list = toDie_.WorkerNodes;
                // foreach (KeyValuePair<WorkerComponentID, int> pair in list)
                foreach (int node in list)
                {
                     WorkerObject worker = this.worker[node];
                     WorkerComponentID wcid = toDie_.WorkerComponentID;
                     worker.destroyInstance(wcid, timeout);
                }
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getProvidedPortNames(ComponentID cid)
            {
			    IDictionary<string, IList<int>> ports = this.getUsedPorts(cid);
			
			    string[] return_ports = new string[ports.Count];
			    ports.Keys.CopyTo(return_ports, 0);
                return return_ports;
		    }

            public IDictionary<string, IList<int>> getProvidedPorts(ComponentID cid)
            {
			    IDictionary<string, IList<int>> ports = new Dictionary<string,IList<int>>();
			    ManagerComponentID cid_ = (ManagerComponentID)cid;
                WorkerComponentID wcid = cid_.WorkerComponentID;
                int[] list = cid_.WorkerNodes;
                // foreach (KeyValuePair<WorkerComponentID, int> pair in list)
                foreach (int node in list)
                {
                    WorkerObject worker = this.worker[node];
                    string[] portNames = worker.getProvidedPortNames(wcid);
                    foreach (string portName in portNames)
                    {
                        IList<int> node_indexes;
                        if (ports.ContainsKey(portName))
                        {
                            ports.TryGetValue(portName, out node_indexes);
                        }
                        else
                        {
                            node_indexes = new List<int>();
                            ports.Add(portName, node_indexes);
                        }
                        node_indexes.Add(node);
                    }
                }
			
			    return ports;
		    }

		    [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getUsedPortNames(ComponentID cid)
            {
			    IDictionary<string, IList<int>> ports = this.getUsedPorts(cid);
			
			    string[] return_ports = new string[ports.Count];
			    ports.Keys.CopyTo(return_ports, 0);
                return return_ports;
            }

            public IDictionary<string, IList<int>> getUsedPorts(ComponentID cid)
            {
                IDictionary<string, IList<int>> ports = new Dictionary<string, IList<int>>();
                ManagerComponentID cid_ = (ManagerComponentID)cid;
                WorkerComponentID wcid = cid_.WorkerComponentID;
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {
                    WorkerObject worker = this.worker[node];
                    string[] portNames = worker.getUsedPortNames(wcid);
                    foreach (string portName in portNames)
                    {
                        IList<int> node_indexes;
                        if (ports.ContainsKey(portName))
                        {
                            ports.TryGetValue(portName, out node_indexes);
                        }
                        else
                        {
                            node_indexes = new List<int>();
                            ports.Add(portName, node_indexes);
                        }
                        node_indexes.Add(node);
                    }
                }

                return ports;
            }

		    [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getPortProperties(ComponentID cid, string portName)
            {
                HPETypeMap result = new TypeMapImpl();

                ManagerComponentID cid_ = (ManagerComponentID)cid;
                WorkerComponentID wcid = cid_.WorkerComponentID;
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {
                    WorkerObject worker = this.worker[node];
                    HPETypeMap properties = (HPETypeMap) worker.getPortProperties(wcid, portName);
                    
                    foreach (KeyValuePair<string, object> p in properties)
                    {
                        string key = p.Key;
                        object value = p.Value;

                        object o_;
                        IDictionary<int, object> o;
                        if (result.ContainsKey(key))
                        {
                            result.TryGetValue(key, out o_);
                            o = (IDictionary<int, object>) o_;
                        }
                        else
                        {
                            o = new Dictionary<int, object>();
                            result.Add(key, o);
                        }
                        o.Add(node, value);                      

                    }
                }

                return result;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setPortProperties(ComponentID cid, string portName, TypeMap map)
            {
                ManagerComponentID cid_ = (ManagerComponentID)cid;
                WorkerComponentID wcid = cid_.WorkerComponentID;
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {                    
                    WorkerObject worker = this.worker[node];
                    worker.setPortProperties(cid, portName, map);
                }
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName)
            {
                ManagerComponentID user_ = (ManagerComponentID)user;
                ManagerComponentID provider_ = (ManagerComponentID)provider;

                WorkerComponentID cid_user = new WorkerComponentIDImpl(user_.getInstanceName());
                WorkerComponentID cid_prov = new WorkerComponentIDImpl(provider_.getInstanceName());
                IDictionary<string, IList<int>> used_ports = this.getUsedPorts(cid_user);
                IDictionary<string, IList<int>> prov_ports = this.getProvidedPorts(cid_prov);

                IList<int> nodes_user, nodes_prov;
                used_ports.TryGetValue(usingPortName, out nodes_user);
                prov_ports.TryGetValue(providingPortName, out nodes_prov);

                if (nodes_prov.Count != nodes_user.Count)
                {
                    throw new CCAExceptionImpl("The ports are not placed in the same set of locations. it is impossible to align them.");
                }

                IList<int> nodes_list = new List<int>();

                // The node sets must be equivalent.
                foreach (int node in nodes_prov)
                {
                    if (!nodes_user.Contains(node))
                    {
                        throw new CCAExceptionImpl("The ports are not placed in the same set of locations. it is impossible to align them.");
                    }

                    ConnectionID conn = worker[node].connect(cid_user, usingPortName, cid_prov, providingPortName);
                    nodes_list.Add(node);
                }

                int[] nodes = new int[nodes_list.Count];
                nodes_list.CopyTo(nodes, 0);

                ConnectionID connection = new ManagerConnectionIDImpl(user, usingPortName, provider, providingPortName, nodes);
                connectionList.Add(connection);
                connByProviderPort.Add(providingPortName, connection);
                connByUserPort.Add(usingPortName, connection);

                return connection;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ConnectionID[] getConnectionIDs(ComponentID[] componentList)
            {
                IList<ComponentID> componentListList = new List<ComponentID>(componentList);

                IList<ConnectionID> connectionsFilter = new List<ConnectionID>();
                foreach (ConnectionID conn in connectionList)
                {
                    ComponentID user = conn.getUser();
                    ComponentID provider = conn.getProvider();

                    if (componentListList.Contains(user) || componentListList.Contains(provider))
                    {
                        connectionsFilter.Add(conn);
                    }
                }

                ConnectionID[] connectionArray = new ConnectionID[connectionsFilter.Count];
                connectionsFilter.CopyTo(connectionArray, 0);

                return connectionArray;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getConnectionProperties(ConnectionID connID)
            {
               TypeMap properties = null;
               connectionProperties.TryGetValue(connID, out properties);
               return properties;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setConnectionProperties(ConnectionID connID, TypeMap map)
            {
	            if (connectionProperties.ContainsKey(connID))
	            {
	                connectionProperties.Remove(connID);
	            }
	            connectionProperties.Add(connID, map);
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void disconnect(ConnectionID connID, float timeout)
            {
	            WorkerConnectionID hpeconnID = (WorkerConnectionID) connID;
	
	            if (hpeconnID.Fetched)
	            {
	                throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
	            }
	
	            connectionList.Remove(connID);
	            connByUserPort.Remove(connID.getUserPortName());
	            connByProviderPort.Remove(connID.getProviderPortName());
	
	            if (connectionProperties.ContainsKey(connID))
	            {
	                connectionProperties.Remove(connID);
	            }
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void disconnectAll(ComponentID id1, ComponentID id2, float timeout)
            {
                if (id1 == null)
                {
                    throw new CCAExceptionImpl(CCAExceptionType.BadPortName);
                }

                ManagerComponentID id1_m = (ManagerComponentID)id1;
                ManagerComponentID id2_m = (ManagerComponentID) id2;

                WorkerComponentID id1_w = id1_m.WorkerComponentID;
                WorkerComponentID id2_w = id2_m.WorkerComponentID;

                int[] id1_ws = id1_m.WorkerNodes;
                int[] id2_ws = id2_m.WorkerNodes;

                if (id1_ws.Length != id2_ws.Length)
                {
                    throw new CCAExceptionImpl("Impossible to disconnect these components. They are not placed in the same set of nodes.");
                }

                IDictionary<int, ComponentID> id2_ws_inv = new Dictionary<int, ComponentID>();
                foreach (int node in id2_ws)
                {
                    id2_ws_inv.Add(node, id2_w);
                }

                foreach (int node in id1_ws) 
                {
                    ComponentID cid1 = id1_w;
                    ComponentID cid2;
                    if (id2_ws_inv.ContainsKey(node))
                    {
                        id2_ws_inv.TryGetValue(node, out cid2);
                        WorkerObject w = worker[node];
                        w.disconnectAll(cid1, cid2, timeout);
                    }
                    else
                    {
                        throw new CCAExceptionImpl("Impossible to disconnect these components. They are not placed in the same set of nodes.");
                    }
                }
            }

            #endregion

        
        
            #region ComponentRepository Members

            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentClassDescription[] getAvailableComponentClasses()
            {
	            Connector.openConnection();
	
	            ComponentClassDescription[] classArray;
	            IList<ComponentClassDescription> classList = new List<ComponentClassDescription>();
	
	            foreach (br.ufc.pargo.hpe.backend.DGAC.database.Component c in BackEnd.cdao.list())
	            {
                    string cname = c.Library_path;
                    classList.Add(new ManagerComponentClassDescriptionImpl(cname));
	            }
	
	            classArray = new ComponentClassDescription[classList.Count];
	            classList.CopyTo(classArray, 0);
	
	            Connector.closeConnection();
	
	            return classArray;
            }

            #endregion

        

            private int[] fetchNodes(HPETypeMap properties)
            {
                Object nodesObj = null;
                int[] nodes = null;
                if (!properties.TryGetValue(Constants.NODES_KEY, out nodesObj))
                {
                    // Se NODES_KEY não está disponível, considerar todos.
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
                return nodes;
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public int[] createInstanceImpl(
                string instanceName,
                string className,
                TypeMapImpl properties,
                out int[] cid_nodes,
                out string[] unit_ids,
                out int[] indexes
                )
            {
                IList<int> cid_nodes_list = new List<int>();
                IList<string> unit_ids_list = new List<string>();
                IList<int> indexes_list = new List<int>();

                try
                {

                    Connector.openConnection();

                    /* BEGIN FOM RunApplication */

                    Console.WriteLine("ENTROU createInstance manager");

                    IDictionary<string, int> files = new Dictionary<string, int>();

                    IDictionary<string, int>  enums = readEnumerators(properties);


                    int[] nodes = this.fetchNodes(properties);

                    br.ufc.pargo.hpe.backend.DGAC.database.Component c = BackEnd.cdao.retrieve_libraryPath(className);
                    string hash_component_uid = c.Hash_component_UID;

                    IList<br.ufc.pargo.hpe.backend.DGAC.database.Interface> iList = BackEnd.idao.list(c.Id_abstract);

                    int nprocs = 0;
                    int aprocs = nodes.Length; // number of informed processors.

                    foreach (br.ufc.pargo.hpe.backend.DGAC.database.Interface i in iList)
                    {
                        //br.ufc.lia.hpe.backend.DGAC.database.Unit u = BackEnd.udao.retrieve(c.Id_concrete, i.Id_interface, -1);
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
                            files.Add(i.Id_interface, count);
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

                    IDictionary<Thread, GoWorker> go_objs = new Dictionary<Thread, GoWorker>();
                    IDictionary<Thread, int> thread_node = new Dictionary<Thread, int>();
                    IDictionary<Thread, string> thread_unit_id = new Dictionary<Thread, string>();
                    IDictionary<Thread, int> thread_index = new Dictionary<Thread, int>();

                    IList<Thread> wthreads = new List<Thread>();
                    int k = 0;
                    foreach (KeyValuePair<string, int> unit in files)
                    {
                        for (int j = 0; j < unit.Value; j++)
                        {
                            TypeMapImpl worker_properties = new TypeMapImpl(properties);
                            worker_properties[Constants.KEY_KEY] = k;
                            worker_properties[Constants.UID_KEY] = hash_component_uid;
                            GoWorker gw = new GoWorker(worker[nodes[k]], instanceName + "." + unit.Key, unit.Key, worker_properties);
                            Thread t = new Thread(gw.Run);
                            t.Start();
                            wthreads.Add(t);
                            go_objs.Add(t, gw);
                            thread_node.Add(t, nodes[k]);
                            thread_unit_id.Add(t, unit.Key);
                            thread_index.Add(t, 0);
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
                    {
                        t.Join();
                        if (go_objs.ContainsKey(t))
                        {
                            GoWorker go_obj;
                            go_objs.TryGetValue(t, out go_obj);
                            int node;
                            string unit_id;
                            int index;
                            thread_node.TryGetValue(t, out node);
                            thread_unit_id.TryGetValue(t, out unit_id);
                            thread_index.TryGetValue(t,out index);
                            WorkerComponentID wcid = go_obj.WorkerCID;
                            cid_nodes_list.Add(node);
                            unit_ids_list.Add(unit_id);
                            indexes_list.Add(index);
                        }
                    }

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

                cid_nodes = new int[cid_nodes_list.Count];
                indexes = new int[indexes_list.Count];
                unit_ids = new string[unit_ids_list.Count];
                cid_nodes_list.CopyTo(cid_nodes, 0);
                indexes_list.CopyTo(indexes, 0);
                unit_ids_list.CopyTo(unit_ids, 0);
                return cid_nodes;

            }

            private IDictionary<string, int> readEnumerators(HPETypeMap properties)
            {
                IDictionary<string, int> enums = new Dictionary<string, int>();
                string[] enums_ = null;
                object enumsObj;
                if (!properties.TryGetValue(Constants.ENUMS_KEY, out enumsObj))
                {
                    enums_ = new string[0];
                }
                else
                {
                    enums_ = (string[])enumsObj;
                    for (int i = 0; i < enums_.Length; i += 2)
                    {
                        enums.Add(enums_[i], int.Parse(enums_[i + 1]));
                    }
                }
                return enums;
            }


            protected class GoWorker 
            {
                 private string instanceName = null; 
                 private string className = null; 
                 private TypeMap properties = null;
                 private WorkerObject worker = null;
			     private WorkerComponentID worker_cid = null;
				
                 public GoWorker(WorkerObject worker, string instanceName, string className, TypeMap properties) 
                 { 
                     this.instanceName = instanceName;
                     this.className = className;
                     this.properties = properties;
                     this.worker = worker;
                 }

                 public void Run() 
                 {
                     Console.WriteLine("Calling worker. Instanting " + instanceName + " " + className);
                     ComponentID worker_cid = worker.createInstance(instanceName, className, properties);
                 }
			
			     public WorkerComponentID WorkerCID {
				     get 
				     {
					    return worker_cid;
				     }
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
               // private TcpChannel tcpChannel = null;

                private string workerFails = null;
                private int failsCount = 0;

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void startWorkerClients()
                {
                    Console.WriteLine("Starting worker clients !");

                    int i = 0;

                    try
                    {
                        /* Read nodes file, and fill the node array */

                        System.Threading.Thread.Sleep(10000);

                        IList<string> nodeList = new List<string>();
                        using (TextReader tr = new StreamReader(Constants.hosts_file))
                        {
                            string one_line;
                            while ((one_line = tr.ReadLine()) != null)
                            {
                                nodeList.Add(one_line);
                                Console.WriteLine(one_line); // Write to console.
                            }
                            node = new string[nodeList.Count];
                            nodeList.CopyTo(node, 0);
                        }
                        

                        worker = new WorkerObject[node.Length];

                       // tcpChannel = new TcpChannel();
                       // ChannelServices.RegisterChannel(tcpChannel, false);

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
                                failsCount++;
                                workerFails = (e.Message == null ? "NULL" : e.Message) + "  ---  "; // + e.InnerException.Message == null ? "NULL" : e.InnerException.Message;
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
                 //   TcpChannel ch = tcpChannel;
                 //   ch.StopListening(null);
                 //   ChannelServices.UnregisterChannel(ch);
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
