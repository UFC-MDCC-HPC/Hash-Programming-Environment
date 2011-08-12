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
               

                int[] nodes = this.fetchNodes((HPETypeMap)selfProperties);

                ManagerComponentID cid = new ManagerComponentIDImpl(selfInstanceName);
                this.registerComponentID(cid, selfProperties);

                ManagerServices manager_services = new ManagerServices(cid);

                foreach (int i in nodes)
                {
                    WorkerObject w = Worker[i];
                    WorkerServices worker_services = (WorkerServices) w.getServices(selfInstanceName, selfClassName, selfProperties);
                    manager_services.addWorkerServicesObject(i, worker_services);
                }

                return manager_services; 
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
                foreach (WorkerObject w in Worker) 
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
                ComponentID cid = null;
                try
                {
                    string[] unit_ids;
                    int[] indexes;
                    int[] cid_nodes;
                    int id_functor_app;
                    WorkerComponentID[] worker_cids;
                    int kind;
                    this.createInstanceImpl(instanceName, className, (TypeMapImpl)properties, out cid_nodes, out unit_ids, out indexes, out id_functor_app, out kind, out worker_cids);
                    cid = new ManagerComponentIDImpl(instanceName, cid_nodes, unit_ids, indexes, worker_cids, id_functor_app, kind);
                    this.registerComponentID(cid, properties);
                }
                catch (Exception e)
                {
                    Console.Error.WriteLine(e.Message);
                    Console.Error.WriteLine(e.StackTrace);
                }

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
                     WorkerObject worker = this.Worker[node];
                     WorkerComponentID wcid = toDie_.getWorkerComponentID(node);
                     worker.destroyInstance(wcid, timeout);
                }
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getProvidedPortNames(ComponentID cid)
            {
			    IDictionary<string, int[]> ports = this.getUsedPorts(cid);
			
			    string[] return_ports = new string[ports.Count];
			    ports.Keys.CopyTo(return_ports, 0);
                return return_ports;
		    }

            public IDictionary<string, int[]> getProvidedPorts(ComponentID cid)
            {
			    IDictionary<string, IList<int>> ports = new Dictionary<string,IList<int>>();
			    ManagerComponentID cid_ = (ManagerComponentID)cid;
                
                int[] list = cid_.WorkerNodes;
                // foreach (KeyValuePair<WorkerComponentID, int> pair in list)
                foreach (int node in list)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(node);
                    WorkerObject worker = this.Worker[node];
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

                IDictionary<string, int[]> ports_ = new Dictionary<string, int[]>();
                foreach (KeyValuePair<string, IList<int>> p in ports)
                {
                    int[] nodes = new int[p.Value.Count];
                    p.Value.CopyTo(nodes, 0);
                    ports_.Add(p.Key, nodes);
                }

                return ports_;
            }

		    [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getUsedPortNames(ComponentID cid)
            {
			    IDictionary<string, int[]> ports = this.getUsedPorts(cid);
			
			    string[] return_ports = new string[ports.Count];
			    ports.Keys.CopyTo(return_ports, 0);
                return return_ports;
            }

            public IDictionary<string, int[]> getUsedPorts(ComponentID cid)
            {
                IDictionary<string, IList<int>> ports = new Dictionary<string, IList<int>>();
                ManagerComponentID cid_ = (ManagerComponentID)cid;
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(node);
                    WorkerObject worker = this.Worker[node];
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

                IDictionary<string, int[]> ports_ = new Dictionary<string, int[]>();
                foreach (KeyValuePair<string, IList<int>> p in ports)
                {
                    int[] nodes = new int[p.Value.Count];
                    p.Value.CopyTo(nodes, 0);
                    ports_.Add(p.Key, nodes);
                }

                return ports_;
            }

		    [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getPortProperties(ComponentID cid, string portName)
            {
                HPETypeMap result = new TypeMapImpl();

                ManagerComponentID cid_ = (ManagerComponentID)cid;
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(node);
                    WorkerObject worker = this.Worker[node];
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
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(node);
                    WorkerObject worker = this.Worker[node];
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

                int kind_user = user_.Kind;
                int kind_prov = provider_.Kind;

                int kind_user_port;
                int id_functor_app_user_port;
                findPortKindAndType(user_.Id_functor_app, usingPortName, out kind_user_port, out id_functor_app_user_port);
                int kind_prov_port;
                int id_functor_app_prov_port;
                findPortKindAndType(provider_.Id_functor_app, providingPortName, out kind_prov_port, out id_functor_app_prov_port);

                IDictionary<string, int[]> used_ports = this.getUsedPorts(cid_user);
                IDictionary<string, int[]> prov_ports = this.getProvidedPorts(cid_prov);

                int[] nodes_user, nodes_prov;
                used_ports.TryGetValue(usingPortName, out nodes_user);
                prov_ports.TryGetValue(providingPortName, out nodes_prov);
                 
                int[] nodes;
                int result = compare_nodes_sets(nodes_user, nodes_prov, out nodes);

                ConnectionID connection = null;

                switch (result)
                {
                    case EQUAL:
                        direct_connect(nodes, cid_user, usingPortName, cid_prov, providingPortName);
                        connection = new ManagerDirectConnectionID(user, usingPortName, provider, providingPortName, nodes);
                        break;
                    case DISJOINT:
                        if (kind_user == Constants.KIND_APPLICATION && kind_prov == Constants.KIND_APPLICATION &&
                            kind_user_port == Constants.KIND_SERVICE && kind_prov_port == Constants.KIND_SERVICE)
                        {
                            ManagerComponentID cid_binding;
                            ManagerConnectionID conn_user, conn_prov;
                            indirect_connect(nodes_user, nodes_prov, cid_user, usingPortName, cid_prov, providingPortName, id_functor_app_user_port, out cid_binding, out conn_user, out conn_prov);
                            connection = new ManagerIndirectConnectionID(user, usingPortName, provider, providingPortName, cid_binding, conn_user, conn_prov, nodes_user, nodes_prov);                            
                        }
                        else
                        {
                            throw new CCAExceptionImpl("The nodes sets are disjoint and the ports are not of service kind.");
                        }
                        break;
                    case SIMILAR:
                    case OVERLAPPING:
                        throw new CCAExceptionImpl("The nodes sets must be EQUAL or DISJOINT to perform a indirect connection.");
                }

                
                connectionList.Add(connection);
                connByProviderPort.Add(providingPortName, connection);
                connByUserPort.Add(usingPortName, connection);

                return connection;
            }

            /* */
            private int findPortKindAndType(int id_functor_app, string id_inner, out int kind, out int id_functor_app_service)
            {
                Connector.openConnection();

                AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app);
                InnerComponent ic = BackEnd.icdao.retrieve(acfa.Id_abstract, id_inner);
                AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);

                id_functor_app_service = ic.Id_functor_app;

                Connector.closeConnection();

                kind = Constants.kindMapping[acf.Kind];
                return kind;                
            }

            private void indirect_connect(
                int[] nodes_user, 
                int[] nodes_prov, 
                WorkerComponentID cid_user, string usingPortName, 
                WorkerComponentID cid_prov, string providingPortName, 
                int id_functor_app_service, 
                out ManagerComponentID cid_binding,
                out ManagerConnectionID conn_user,
                out ManagerConnectionID conn_prov)
            {
                // RESOLVES AND CREATE INSTANCE OF A SERVICE COMPONENT 
                //    with server units residing in nodes_user and client units residing nodes_prov
                string instantiator_string = null;
                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();
                    ComponentFunctorApplicationType instantiator = DGAC.BackEnd.buildInstantiator(id_functor_app_service);
                    instantiator_string = LoaderApp.serializeInstantiatorToString(instantiator);
                    Connector.commitTransaction();
                }
                catch (Exception e)
                {
                    Connector.rollBackTransaction();
                    CCAExceptionImpl cca_e = new CCAExceptionImpl("Error creating the service binding.", e);
                    throw cca_e;
                }
                finally
                {
                    Connector.closeConnection();
                }

                string instanceName = "service_" + id_functor_app_service;

                TypeMapImpl properties = new TypeMapImpl();
                properties[Constants.NODES_KEY] = null; //TODO
                cid_binding = (ManagerComponentID) this.createInstance(instanceName, instantiator_string, properties);
                
                // CONNECT THE USER PORT THE SERVICE PROVIDES PORT
                conn_user = (ManagerConnectionID) this.connect(cid_user, usingPortName, cid_binding, Constants.DEFAULT_PROVIDES_PORT_SERVICE);                

                // CONNECT THE SERVICE USES PORT TO THE PROVIDER PORT
                conn_prov = (ManagerConnectionID) this.connect(cid_binding, Constants.DEFAULT_USES_PORT_SERVICE, cid_prov, providingPortName);
            }


            private void direct_connect(int[] nodes, WorkerComponentID cid_user, string usingPortName, WorkerComponentID cid_prov, string providingPortName)
            {
                foreach (int node in nodes)
                {
                    ConnectionID conn = Worker[node].connect(cid_user, usingPortName, cid_prov, providingPortName);
                }
            }

            private const int EQUAL = 0;
            private const int SIMILAR = 1;
            private const int OVERLAPPING = 2;
            private const int DISJOINT = 3;

            // POG 
            private int compare_nodes_sets(int[] nodes_user, int[] nodes_prov, out int[] nodes)
            {
                int[] nodes_user_sorted = (int[])nodes_user.Clone();
                int[] nodes_prov_sorted = (int[])nodes_prov.Clone();
                int size = nodes_user_sorted.Length > nodes_prov_sorted.Length ? nodes_user_sorted.Length - 1 : nodes_prov_sorted.Length - 1;
                int[] nodes_user_sorted_inv = new int[nodes_user_sorted[size]];
                int[] nodes_prov_sorted_inv = new int[nodes_prov_sorted[size]];

                Array.Sort<int>(nodes_user_sorted);
                Array.Sort<int>(nodes_prov_sorted);

                for (int i = 0; i < nodes_user_sorted_inv.Length; i++)
                    nodes_user_sorted_inv[i] = -1;
                for (int i = 0; i < nodes_prov_sorted_inv.Length; i++)
                    nodes_prov_sorted_inv[i] = -1;

                for (int i = 0; i < nodes_user_sorted.Length; i++)
                    nodes_user_sorted_inv[nodes_user_sorted[i]] = i;
                for (int i = 0; i < nodes_prov_sorted.Length; i++)
                    nodes_prov_sorted_inv[nodes_prov_sorted[i]] = i;

                nodes = null;

                bool isEqual = true;
                bool isSimilar = true;
                bool isOverlapping = true;
                bool isDisjoint = true;
                if (nodes_user_sorted.Length != nodes_prov_sorted.Length)
                {
                    isEqual = false;
                    isSimilar = false;
                    for (int i = 0; i < nodes_user_sorted.Length; i++)
                    {
                        if (nodes_prov_sorted_inv[nodes_user_sorted[i]] > 0)
                        {
                            isDisjoint = false;
                            return OVERLAPPING;
                        }
                    }
                    for (int i = 0; i < nodes_prov_sorted.Length; i++)
                    {
                        if (nodes_user_sorted_inv[nodes_prov_sorted[i]] > 0)
                        {
                            isDisjoint = false;
                            return OVERLAPPING;
                        }
                    }
                    return DISJOINT;
                }
                else
                {
                    int count = 4;

                    for (int i = 0; i < nodes_user_sorted.Length; i++)
                    {
                        if (nodes_user_sorted[i] == nodes_prov_sorted[i])
                        {
                            isDisjoint = false; count--;
                        }
                        else if (nodes_user_sorted[i] != nodes_prov_sorted[i])
                        {
                            isEqual = false; count--;
                        }
                        else if (nodes_prov_sorted_inv[nodes_user_sorted[i]] > 0 && nodes_user_sorted_inv[nodes_prov_sorted[i]] > 0)
                        {
                            isSimilar = false; count--;
                        }
                        if (count == 1)
                        {
                            return OVERLAPPING;
                        }
                    }
                }

                if (isEqual) { nodes = nodes_user; return EQUAL; }
                else if (isSimilar) return SIMILAR;
                else if (isDisjoint) return DISJOINT;
                else if (isOverlapping) return OVERLAPPING;
                else return -1;
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


                int[] id1_ws = id1_m.WorkerNodes;
                int[] id2_ws = id2_m.WorkerNodes;

                if (id1_ws.Length != id2_ws.Length)
                {
                    throw new CCAExceptionImpl("Impossible to disconnect these components. They are not placed in the same set of nodes.");
                }

                IDictionary<int, ComponentID> id2_ws_inv = new Dictionary<int, ComponentID>();
                foreach (int node in id2_ws)
                {
                    WorkerComponentID id2_w = id2_m.getWorkerComponentID(node);
                    id2_ws_inv.Add(node, id2_w);
                }

                foreach (int node in id1_ws) 
                {
                    WorkerComponentID id1_w = id1_m.getWorkerComponentID(node);
                    ComponentID cid1 = id1_w;
                    ComponentID cid2;
                    if (id2_ws_inv.ContainsKey(node))
                    {
                        id2_ws_inv.TryGetValue(node, out cid2);
                        WorkerObject w = Worker[node];
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
				
                IList<DeployedComponentInfoType> eabs =  DGAC.BackEnd.readEnvironmentAbstract();
			    foreach (DeployedComponentInfoType d in eabs)
			    {
				   string fname = Constants.PATH_TEMP_WORKER + "deployed.xml";
				   string cname = LoaderApp.SerializeDeployedComponentInfoType(fname, d);
				   File.Delete(fname);
				   ManagerComponentClassDescriptionImpl desc = new ManagerComponentClassDescriptionImpl();
				   desc.ComponentClassName = cname;
				   //Console.WriteLine(cname);
				   classList.Add(desc);
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
                    nodes = new int[Worker.Length];
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
                string instantiator_string,
                TypeMapImpl properties,
                out int[] cid_nodes,
                out string[] unit_ids,
                out int[] indexes,
                out int id_functor_app,
                out int kind,
                out WorkerComponentID[] worker_cids
                )
            {
                IList<int> cid_nodes_list = new List<int>();
                IList<string> unit_ids_list = new List<string>();
                IList<int> indexes_list = new List<int>();
                IList<WorkerComponentID> worker_cids_list = new List<WorkerComponentID>();

                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();

                    /* BEGIN FOM RunApplication */

                    Console.Error.WriteLine("createInstance manager");

                    IDictionary<string, int> files = new Dictionary<string, int>();
                    IDictionary<string, int> enums = readEnumerators(properties);

                    FileInfo file = FileUtil.writingToFile(instanceName + ".xml", instantiator_string);
                    ComponentFunctorApplicationType instantiator = LoaderApp.DeserializeInstantiator(file.FullName);
                    
                    int[] nodes = instantiator.node;
                    Console.Error.Write("Number of nodes = " + nodes.Length + ": ");
                    foreach (int n in nodes) Console.Write(n + ", ");
                    Console.WriteLine("end");

                    DGAC.database.AbstractComponentFunctorApplication acfaRef = DGAC.BackEnd.loadACFAFromInstantiator(instantiator);
                    id_functor_app = acfaRef.Id_functor_app;

                    DGAC.database.Component c = DGAC.BackEnd.resolveUnit(acfaRef);
                    kind = Constants.kindMapping[c.Kind];

                    string hash_component_uid = c.Hash_component_UID;

                    IList<br.ufc.pargo.hpe.backend.DGAC.database.Interface> iList = BackEnd.idao.list(c.Id_abstract);

                    int nprocs = 0;
                    int aprocs = nodes.Length; // number of informed processors.

                    foreach (br.ufc.pargo.hpe.backend.DGAC.database.Interface i in iList)
                    {
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

                    Console.Error.WriteLine("Number of processes = " + nprocs);

                    Connector.commitTransaction();

                    if (nprocs != aprocs)
                    {
                        // throw new Exception("Unmatching number of nodes.");
                    }

                    /* END FOM RunApplication */

                   //Console.WriteLine("PASS 1 ?" + (worker == null));

                    bool[] node_marking = new bool[Worker.Length];
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
                            worker_properties[Constants.COMPONENT_KEY] = c.Library_path;
                            worker_properties[Constants.UNIT_KEY] = unit.Key ;
                            worker_properties[Constants.ID_FUNCTOR_APP] = acfaRef.Id_functor_app;

                            // DGAC.database.Unit u = DGAC.BackEnd.udao.retrieve(c.Id_concrete, unit.Key, -1);
                            DGAC.database.Unit u = DGAC.BackEnd.takeUnit(c, unit.Key);

                            string class_name_worker;
                            
                            System.Type[] actualParams;
                            DGAC.BackEnd.calculateActualParams(acfaRef, unit.Key, out actualParams);
                            DGAC.BackEnd.calculateGenericClassName(u, actualParams, out class_name_worker);

                            GoWorker gw = new GoWorker(Worker[nodes[k]], instanceName + "." + unit.Key, class_name_worker, worker_properties);
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
                            Thread t = new Thread(Worker[i].createInstanceNull);
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
                            worker_cids_list.Add(wcid);
                            cid_nodes_list.Add(node);
                            unit_ids_list.Add(unit_id);
                            indexes_list.Add(index);
                        }
                    }


                }
                catch (Exception e)
                {
                    Connector.endTransaction();
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
                worker_cids = new WorkerComponentID[worker_cids_list.Count];
                cid_nodes_list.CopyTo(cid_nodes, 0);
                indexes_list.CopyTo(indexes, 0);
                unit_ids_list.CopyTo(unit_ids, 0);
                worker_cids_list.CopyTo(worker_cids, 0);
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
                     try
                     {
                         Console.WriteLine("Calling worker. Instanting " + instanceName + " " + className + " null ? " + (worker == null));
                         worker_cid = (WorkerComponentID) worker.createInstance(instanceName, className, properties);
                     }
                     catch (Exception e)
                     {
                         Console.Error.WriteLine(e.Message);
                         Console.Error.WriteLine(e.StackTrace);
                     }
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
                     string moduleName_, 
                     string[] references, 
                     int outFile, 
                     string userName, 
                     string password, 
                     string curDir)
                {
                    string moduleName = library_path + "." + moduleName_;
                    string publicKeyToken = null; 
                    string moduleNameWithoutExtension = moduleName; // .Split('.')[0];

                    if (outFile == Constants.EXE_OUT)
                    {
                        CommandLineUtil.compile_to_exe(contents, moduleName, references, userName, password, curDir);
                    }
                    else
                    {
                        //creates the strong key, for new assembly
                        publicKeyToken = CommandLineUtil.create_strong_key(moduleNameWithoutExtension, userName, password, curDir);
                        //compile, generate dll 
                        CommandLineUtil.compile_source(contents, moduleNameWithoutExtension, references, userName, password, curDir);
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
		
		        private WorkerObject[] Worker 
		        {
			       get {   
				           if (worker == null) 
				           {
					          startWorkerClients();
				           }
				           return worker;			
			           } 
		        }
		
		
                private string[] node = null;
                private int[] port = null;

               // private TcpChannel tcpChannel = null;

                private string workerFails = null;
                private int failsCount = 0;

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void startWorkerClients()
                {
                    Console.WriteLine("Starting worker clients !");                  

                    try
                    {
                        /* Read nodes file, and fill the node array */

                        //System.Threading.Thread.Sleep(10000);

                        IList<string> nodeList = new List<string>();
                        IList<int> portList = new List<int>();
                        using (TextReader tr = new StreamReader(Constants.hosts_file))
                        {
                            string one_line;
                            while ((one_line = tr.ReadLine()) != null)
                            {
                                int my_port = Constants.WORKER_PORT;
                                string[] s = one_line.Split(' ');                                
                                if (s.Length > 1)
                                   my_port = System.Convert.ToInt32(s[1], 10);
                                nodeList.Add(s[0]);
                                portList.Add(my_port);
                                Console.Write(s[0]); Console.WriteLine(" - port = " + my_port);
                            }
                            node = new string[nodeList.Count];
                            port = new int[portList.Count];
                            nodeList.CopyTo(node, 0);
                            portList.CopyTo(port, 0);
                        }
                        

                        worker = new WorkerObject[node.Length];

                        int i = 0;
                        /* Create each worker object and fill the worker array */
                        foreach (string n in node)
                        {
                            try
                            {   
                                createWorkerObject(i, n, port[i]);
                                i++;
                                Console.WriteLine("CONNECTED TO WORKER " + n);
                            }
                            catch (Exception e)
                            {
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

                    Console.WriteLine(Worker.Length + " Worker clients started !");
                }

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void stopWorkerClients()
                {
                 //   TcpChannel ch = tcpChannel;
                 //   ch.StopListening(null);
                 //   ChannelServices.UnregisterChannel(ch);
                }

                private void createWorkerObject(int i, string node, int port)
                {
                    WorkerObject wo = null;

                    System.Type requiredType = typeof(WorkerObject);

                    wo = (WorkerObject)Activator.GetObject(requiredType,
                        "tcp://" + node + ":" + port /* Constants.WORKER_PORT */ + "/" + Constants.WORKER_SERVICE_NAME);

                    wo.sayHi();

                    worker[i] = wo;
                }

                [MethodImpl(MethodImplOptions.Synchronized)]
                public string[] runApplication(string session_id_string, ManagerComponentID mcid)
		        {
					return runApplication(session_id_string, mcid, 1);
		        }
		
                [MethodImpl(MethodImplOptions.Synchronized)]
                public string[] runApplication(string session_id_string, ManagerComponentID mcid, int rounds)
                {
                    string[] outputs = new String[mcid.WorkerNodes.Length]; 
                    IDictionary<Thread, RunApplicationThread> thread_list = new Dictionary<Thread,RunApplicationThread>();
                    foreach (int node in mcid.WorkerNodes)
                    {
				       
                        RunApplicationThread thread = new RunApplicationThread(node, Worker[node], session_id_string, mcid, rounds);
                        Thread t = new Thread(thread.Run);
                        thread_list.Add(t,thread);
                        t.Start();
                    }
                    foreach (KeyValuePair<Thread,RunApplicationThread> t in thread_list)
                    {
                        try 
                        {
                           t.Key.Join();
                           Console.Error.WriteLine("Worker thread arrived : " + session_id_string);
                           outputs[t.Value.Node] = t.Value.Output;
                        } 
                        catch (Exception e)
                        {
                           Console.WriteLine("Worker failed : " + session_id_string + ". error =" + e.Message);
                        }
                    }
                    Console.Error.WriteLine("Joined Threads : " + session_id_string);
                    
                    return outputs;
                }

                internal class RunApplicationThread
                {
                    private string session_id_string;
                    private ManagerComponentID mcid;
                    private int node;
                    public int Node {get {return node;}}
                    private WorkerObject worker;
                    private string result;
			        private int rounds;
                    public string Output {get {return result;}}

                    public RunApplicationThread(int node, WorkerObject worker, string session_id_string, ManagerComponentID mcid, int rounds)
                    {
                        this.session_id_string = session_id_string;
                        this.mcid = mcid;
                        this.node = node;
                        this.worker = worker;
				        this.rounds = rounds;
                    }

                    public void Run()
                    {
                        result = worker.runApplication(session_id_string, mcid.getWorkerComponentID(node), rounds);
                    }

                }


     
    }

        
}
