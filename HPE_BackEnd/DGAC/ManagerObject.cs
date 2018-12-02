

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
using System.Runtime.Remoting.Activation;
using br.ufc.hpe.backend.DGAC;
using gov.cca.ports;
using System.Diagnostics;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Diagnostics.Contracts;

namespace br.ufc.pargo.hpe.backend.DGAC
{ 
	//MANAGER
	public class ManagerObject : MarshalByRefObject, gov.cca.Services,
	                                                 gov.cca.AbstractFramework, 
	                                                 gov.cca.ports.BuilderService, 
	                                                 gov.cca.ports.ComponentRepository,
	                                                 gov.cca.Component,													 
													 gov.cca.ports.ServiceRegistry
    {
		    private PortUsageManager port_manager = new PortUsageManager();

		    private static ManagerObject single_manager_object = null;

			public static ManagerObject SingleManagerObject
			{ 
			    get { 
					if (single_manager_object == null)
						single_manager_object = new ManagerObject ();
					return single_manager_object;
				}
		    }	

            private ManagerObject() 
            {
                Console.WriteLine("Manager Object UP !");
				instantiateWorkers();
				gov.cca.Services frw_services = getServices("manager_framework", "ManagerObject",new TypeMapImpl());
				Console.WriteLine("setServices BEFORE");
				this.setServices(frw_services);		        
				Console.WriteLine("setServices AFTER");
            }

            private IDictionary<string, ComponentID> componentIDs = new Dictionary<string, ComponentID>();
            private IDictionary<string, TypeMap> componentProperties = new Dictionary<string, TypeMap>();

            private IList<ConnectionID> connectionList = new List<ConnectionID>();
            private IDictionary<ConnectionID, TypeMap> connectionProperties = new Dictionary<ConnectionID, TypeMap>();
            private IDictionary<string, ConnectionID> connByUserPortName = new Dictionary<string, ConnectionID>();
            private IDictionary<string, ConnectionID> connByProviderPortName = new Dictionary<string, ConnectionID>();
        
		    private IDictionary<string, ManagerServices> host_services = new Dictionary<string, ManagerServices>();
		    private IDictionary<string, ManagerServices> component_services = new Dictionary<string, ManagerServices>();

	        private IDictionary<string, Port> providesPorts = new Dictionary<string, Port>();
            private IDictionary<string, TypeMap> portProperties = new Dictionary<string, TypeMap>();
	        private IDictionary<string, string> usesPortTypes = new Dictionary<string, string>();
            private IDictionary<string, string> providesPortTypes = new Dictionary<string, string>();
	
        	private IDictionary<string, AutoResetEvent> waitingUserPorts = new Dictionary<string, AutoResetEvent>();

		    private ManagerServices frw_services = null;
		    private BuilderService frw_builder = null;

			public bool isConnected (ManagerComponentID cid, object portName)
			{
				ConnectionID conn;
				return connByUserPortName.TryGetValue(cid.getInstanceName() + ":" + portName, out conn);
			}		


            #region AbstractFramework Members

            public TypeMap createTypeMap()
            {
                return new TypeMapImpl();
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public gov.cca.Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties)
            {			   
			   int[] nodes = new int[WorkerFramework.Count];
				for (int i=0; i<nodes.Length; i++)
					nodes [i] = i - 1;
			
			   ManagerComponentID cid = new ManagerComponentIDImpl(selfInstanceName, selfClassName, nodes);				
			   ManagerServices manager_services = new ManagerServicesImpl(this, cid);

            // Register the host in the worker frameworks
               int j = 0;
			   foreach (int i in WorkerFramework.Keys)
			   {
				    Console.WriteLine ("BEFORE getServices ...0");
				    WorkerServices worker_service = (WorkerServices) WorkerFramework[i].getServices(selfInstanceName,selfInstanceName, selfProperties);

				    Console.WriteLine ("AFTER getServices ... 1 " + (worker_service == null));
                    manager_services.registerWorkerService(j++, worker_service);
				    Console.WriteLine ("AFTER getServices ... 2");
			   }
			
			   this.registerComponent(cid, manager_services, selfProperties);
			   this.registerHostService(cid, manager_services);
			   
			   return manager_services;
            }

           // private IDictionary<Services, ComponentRelease> releaseRegister = new Dictionary<Services, ComponentRelease>();

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void releaseServices(gov.cca.Services services)
            {
				ManagerServices services_ = (ManagerServices) services;
                this.host_services.Remove (services_.getComponentID().getInstanceName());
                for (int node = 0; node < WorkerFramework.Keys.Count; node++)
	            {
	                WorkerServices worker_services = services_.WorkerServices[node];
		            WorkerFramework[node].releaseServices(worker_services);
	            }
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void shutdownFramework()
            {
				foreach (ManagerServices services in host_services.Values)
				{
					this.releaseServices(services);
				}
			
                foreach (IWorkerObject w in WorkerFramework.Values) 
                {
                    w.shutdownFramework();
                }				
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public AbstractFramework createEmptyFramework()
            {
                return BackEnd.getFrameworkInstance();
            }

            #endregion
		
		    private ServiceRegistry frw_registry = null;
		
	  		#region Component implementation
			public void setServices(gov.cca.Services services)
			{				
	        	frw_services = (ManagerServices) services;			

			    // FETCH THE REGISTRY PORT TO DECLARE THE BUILDER SERVICE
			    frw_services.registerUsesPort(Constants.REGISTRY_PORT_NAME, Constants.REGISTRY_PORT_TYPE, new TypeMapImpl());
				frw_registry = (ServiceRegistry) frw_services.getPort (Constants.REGISTRY_PORT_NAME);
				frw_registry.addSingletonService(Constants.BUILDER_SERVICE_PORT_TYPE, this);			

				// FETCH THE BUILDER SERVICE
				frw_services.registerUsesPort(Constants.BUILDER_SERVICE_PORT_NAME, Constants.BUILDER_SERVICE_PORT_TYPE, new TypeMapImpl());
				frw_builder = (BuilderService) frw_services.getPort(Constants.BUILDER_SERVICE_PORT_NAME);

                int j = 0;
                foreach (int i in WorkerFramework.Keys)
                {
	                WorkerServices worker_services = frw_services.WorkerServices[j++];
	                ((gov.cca.Component)WorkerFramework[i]).setServices(worker_services);
	            }
			}
			#endregion
      
		
            #region BuilderService Members

			
            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID createInstance(string instanceName, string className, TypeMap properties)
            {
                ManagerComponentID cid = null;
                try
                {
                    string[] unit_ids;
                    int[] indexes;
                    int[] cid_nodes;
				    int id_functor_app = default(int);
                    WorkerComponentID[] worker_cids = null;
				    int kind = default(int);

				    string portName = (string)((TypeMapImpl)properties)[Constants.PORT_NAME];
				    bool ignore = (bool) properties.getBool(Constants.IGNORE,false);
 

					if (!ignore)
					{
						this.createInstanceImpl(instanceName, 
					                            className,
					                            (TypeMapImpl)properties, 
					                            out cid_nodes, 
					                            out unit_ids, 
					                            out indexes, 
					                            out id_functor_app, 
					                            out kind,
					                            out worker_cids);
				
	                    cid = new ManagerComponentIDImpl(instanceName, 
					                                 	 className,
					                                     cid_nodes, 
					                                     unit_ids, 
					                                     indexes, 
					                                     id_functor_app,
					                                     kind, 
					                                 	 portName);
				    }
					else 
				    {	
					    id_functor_app = properties.getInt(Constants.ID_FUNCTOR_APP,0);  
					    DGAC.database.Component c = BackEnd.cdao.retrieve_libraryPath(className);
					    kind = Constants.kindMapping[c.Kind];

						cid = new ManagerIgnoredComponentIDImpl (instanceName, className, id_functor_app, kind, portName);
						Console.WriteLine("CREATE INSTANCE --- Ignoring " + instanceName);
				    }	
				
					ManagerServices cservices = new ManagerServicesImpl(this, cid);

				    if (!ignore)
				    {
						int[] nodes = cid.WorkerNodes;
	                    for (int i = 0; i < nodes.Length; i++)
	                    {
	                        Console.WriteLine("CREATEINSTANCEIMPL 1 " + nodes[i]);
	                        WorkerComponentID wcid = worker_cids[i];
	                        Console.WriteLine("CREATEINSTANCEIMPL 2 " + (wcid == null));

	                        IWorkerObject worker_object = (IWorkerObject)WorkerFramework[nodes[i]];
	                        RemoteWorkerServicesImpl worker_services = new RemoteWorkerServicesImpl(worker_object, wcid);
	                        worker_object.linkToRemoteServices(worker_services.RemoteKey, wcid);

	                        Console.WriteLine("CREATEINSTANCEIMPL 3 " + nodes[i] + " , " + (worker_services == null));
	                        cservices.registerWorkerService(i, worker_services);
	                        Console.WriteLine("CREATEINSTANCEIMPL 4 " + nodes[i]);
	                    }
					}

                    this.registerComponent(cid, cservices, properties);
					
                }
                catch (Exception e)
                {
                    Console.WriteLine("Exception: " + e.Message);
                    Console.WriteLine("Inner Exception: " + (e.InnerException != null ? e.InnerException.Message : ""));
                    Console.WriteLine("Stack Trace: " + e.StackTrace);
                }

                return cid;
            }
		
		    // OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID[] getComponentIDs()
            {
                ComponentID[] cids = new ManagerComponentIDImpl[componentIDs.Count];
                componentIDs.Values.CopyTo(cids, 0);
                return cids;
            }
		
		    // OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getComponentProperties(ComponentID cid)
            {
                TypeMap properties;
                componentProperties.TryGetValue(cid.getInstanceName(), out properties);
                return properties;
            }
		
		    // OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setComponentProperties(ComponentID cid, TypeMap map)
            {
                if (componentProperties.ContainsKey(cid.getInstanceName()))
                {
                    componentProperties.Remove(cid.getInstanceName());
                }

                componentProperties.Add(cid.getInstanceName(), map);
            }
		
		    // OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID getDeserialization(string s)
            {
                return null; /* TODO: XML serialization */
            }
		
		    // OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID getComponentID(string componentInstanceName)
            {
                ComponentID cid = null;
                componentIDs.TryGetValue(componentInstanceName, out cid);
                return cid;
            }

			public void checkThereAreConnections (ComponentID toDie)
			{
				string[] provider_ports = this.getProvidedPortNames(toDie);
				string[] user_ports = this.getUsedPortNames(toDie);
				
				foreach (string port_name in provider_ports)
				{
					ConnectionID conn;
					if (connByProviderPortName.TryGetValue(port_name, out conn))
					{
						throw new CCAExceptionImpl("CCA Exception: the component instance cannot be destroyed because it has using connections.");
					}
				}
				
				foreach (string port_name in user_ports)
				{
					ConnectionID conn;
					if (connByUserPortName.TryGetValue(port_name, out conn))
					{
						throw new CCAExceptionImpl("CCA Exception: the component instance cannot be destroyed because it has providing connections.");
					}
				}
				
				
				
				
				throw new CCAExceptionImpl("CCA Exception: Cannot destroy " + toDie.getInstanceName() + " because it has connections.");
			}
		
		    // OK.
	        [MethodImpl(MethodImplOptions.Synchronized)]
	        public void destroyInstance(ComponentID toDie, float timeout)
	        {
				Console.WriteLine ("BEGIN DESTROY INSTANCE #1 " + toDie.getInstanceName() + " frw_builder == null ? " + (frw_builder == null));	

				// CALL DESTROY FOR EACH UNIT ...
	            ManagerComponentID toDie_ = (ManagerComponentID)toDie;
	            			
			    ManagerServices services = null;
				
				string[] usesPorts = frw_builder.getUsedPortNames(toDie);			
				string[] providesPorts = frw_builder.getProvidedPortNames(toDie);
				
				Console.WriteLine ("BEGIN DESTROY INSTANCE #2 " + toDie.getInstanceName());	

				if (usesPorts.Length > 0 || providesPorts.Length > 0)
				{
					Console.WriteLine("The component must unregister its uses ports " +
													   "and remove provides ports before destruction.");
					foreach (string portName in usesPorts) Console.WriteLine ("REMAINING USES PORT: " + portName);
					foreach (string portName in providesPorts) Console.WriteLine ("REMAINING PROVIDES PORT " + portName);
					throw new CCAExceptionImpl(CCAExceptionType.Unexpected);				
				}
							
				Console.WriteLine ("BEGIN DESTROY INSTANCE #3 " + toDie.getInstanceName());

	            int[] nodes = toDie_.WorkerNodes;

	            // foreach (int i in toDie_.WorkerNodes)
	            for (int i = 0; i < nodes.Length; i++)
	            {
					Console.WriteLine ("ENTERING DESTROY INSTANCE UNIT i=" + i);
	                gov.cca.ports.BuilderService builder = this.WorkerBuilder[nodes[i]];
	                WorkerComponentID wcid = toDie_.getWorkerComponentID(i);
	                Console.WriteLine("ENTERING DESTROY INSTANCE UNIT wcid=" + wcid.getInstanceName());
	                builder.destroyInstance(wcid, timeout);
	                Console.WriteLine("EXIT DESTROY INSTANCE UNIT node=" + i + "wcid=" + wcid.getInstanceName());
	            }
			
				Console.WriteLine ("BEGIN DESTROY INSTANCE #4 " + toDie.getInstanceName());	

				this.componentIDs.Remove(toDie.getInstanceName());

				Console.WriteLine ("REMOVING component_services[" + toDie.getInstanceName() + "]");
				this.component_services.Remove(toDie.getInstanceName());
				if (host_services.ContainsKey(toDie.getInstanceName()))
					host_services.Remove(toDie.getInstanceName());
			    this.componentProperties.Remove(toDie.getInstanceName());
				
				Console.WriteLine ("END DESTROY INSTANCE" + toDie.getInstanceName());	
	        }
			
			
			
		    // OK.
            [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getProvidedPortNames(ComponentID cid)
            {
			Console.WriteLine ("getProvidedPortNames #1");
			    IDictionary<string, Tuple<int, int>[]> ports = this.getProvidedPorts(cid);
			Console.WriteLine ("getProvidedPortNames #2");
			    string[] return_ports = new string[ports.Count];
			Console.WriteLine ("getProvidedPortNames #3");
			    ports.Keys.CopyTo(return_ports, 0);
			Console.WriteLine ("getProvidedPortNames #4");
                return return_ports;
		    }
	


		    // OK
            public IDictionary<string, Tuple<int, int>[]> getProvidedPorts(ComponentID cid)
            {
				Console.WriteLine ("getProvidedPorts #1");
			    IDictionary<string, IList<Tuple<int,int>>> ports = new Dictionary<string,IList<Tuple<int, int>>>();
			    ManagerComponentID cid_ = (ManagerComponentID)cid;
				Console.WriteLine ("getProvidedPorts #2");
                
                 int[] nodeList = cid_.WorkerNodes;
			    for (int i=0; i<nodeList.Length; i++)
                // foreach (KeyValuePair<WorkerComponentID, int> pair in list)
                //foreach (int node in list)
                {
  				    Console.WriteLine ("getProvidedPorts #3 i=" + i);
                    WorkerComponentID wcid = cid_.getWorkerComponentID(i);
                    Console.WriteLine("getProvidedPorts #4 i=" + i);
                    gov.cca.ports.BuilderService builder = this.WorkerBuilder[nodeList[i]];
                    Console.WriteLine("getProvidedPorts #5 nodeList[i]=" + nodeList[i] + " builder ? " + (builder.GetHashCode()));
                    string[] portNames = builder.getProvidedPortNames(wcid);
                    Console.WriteLine("getProvidedPorts #6 i=" + i);
                    foreach (string portName in portNames)
                    {
                        Console.WriteLine("getProvidedPorts #7 i=" + i + " portName=" + portName);
                        IList<Tuple<int, int>> node_indexes;
                        if (!ports.TryGetValue(portName, out node_indexes))
                        {
                            node_indexes = new List<Tuple<int, int>>();
                            ports[portName] = node_indexes;
                        }
                        Console.WriteLine("getProvidedPorts #8 i=" + i + " portName=" + portName);
                        node_indexes.Add(new Tuple<int, int>(nodeList[i], i));
                        Console.WriteLine("getProvidedPorts #9 i=" + i + " portName=" + portName);
                    }
                }

                IDictionary<string, Tuple<int, int>[]> ports_ = new Dictionary<string, Tuple<int, int>[]>();
                foreach (KeyValuePair<string, IList<Tuple<int, int>>> p in ports)
                {
				    Console.WriteLine ("getProvidedPorts #10 p.Key = " + p.Key);
                    Tuple<int, int>[] nodes = new Tuple<int, int>[p.Value.Count];
                    p.Value.CopyTo(nodes, 0);
                    ports_.Add(p.Key, nodes);
				    Console.WriteLine ("getProvidedPorts #11 p.Key = " + p.Key);
                }

                return ports_;
            }
		
		    // OK
		    [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getUsedPortNames(ComponentID cid)
            {
			Console.WriteLine ("getUsedPortNames #1");
			    IDictionary<string, Tuple<int, int>[]> ports = this.getUsedPorts(cid);
			Console.WriteLine ("getUsedPortNames #2");
			    string[] return_ports = new string[ports.Count];
			Console.WriteLine ("getUsedPortNames #3");
				ports.Keys.CopyTo(return_ports, 0);
			Console.WriteLine ("getUsedPortNames #4 " + (return_ports == null));
                return return_ports;
            }
		
		    // OK
            public IDictionary<string, Tuple<int,int>[]> getUsedPorts(ComponentID cid)
            {
			    Console.WriteLine("getUsedPorts BEGIN cid={0}", cid.getInstanceName());
 
                IDictionary<string, IList<Tuple<int,int>>> port_nodes = new Dictionary<string, IList<Tuple<int, int>>>();
                ManagerComponentID cid_ = (ManagerComponentID)cid;
                int[] nodeList = cid_.WorkerNodes;

	            for (int i = 0; i < nodeList.Length; i++)
	            {
	                WorkerComponentID wcid = cid_.getWorkerComponentID(i);
	                Console.WriteLine("getUsedPorts 0 node={1}, cid={0}", cid.getInstanceName(), nodeList[i]);
	                gov.cca.ports.BuilderService builder = WorkerBuilder[nodeList[i]];
	                string[] portNames = builder.getUsedPortNames(wcid);
	                foreach (string portName in portNames)
	                {
	                    Console.WriteLine("getUsedPorts 1 node={0}, wcid={1}, portName={2}", nodeList[i], wcid.getInstanceName(), portName);
	                    IList<Tuple<int, int>> node_indexes;
	                    if (!port_nodes.TryGetValue(portName, out node_indexes))
	                    {
	                        node_indexes = new List<Tuple<int,int>>();
	                        port_nodes.Add(portName, node_indexes);
	                    }
                        node_indexes.Add(new Tuple<int, int>(nodeList[i], i));
				    }
	            }

                IDictionary<string, Tuple<int, int>[]> ports_ = new Dictionary<string, Tuple<int, int>[]>();
                foreach (KeyValuePair<string, IList<Tuple<int, int>>> p in port_nodes)
                {
                    Tuple<int,int>[] nodes = new Tuple<int, int>[p.Value.Count];
				    p.Value.CopyTo(nodes, 0);
                    ports_.Add(p.Key, nodes);
                }

			    Console.WriteLine("getUsedPorts END cid={0}", cid.getInstanceName());

			return ports_;
            }
		
		    // OK
		    [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getPortProperties(ComponentID cid, string portName)
            {
                HPETypeMap result = new TypeMapImpl();

                ManagerComponentID cid_ = (ManagerComponentID)cid;
                int[] nodes = cid_.WorkerNodes;
                //foreach (int node in list)
                for (int i = 0; i < nodes.Length; i++)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(i);
                    gov.cca.ports.BuilderService builder = this.WorkerBuilder[nodes[i]];
                    HPETypeMap properties = (HPETypeMap)builder.getPortProperties(wcid, portName);

                    foreach (KeyValuePair<string, object> p in properties)
                    {
                        string key = p.Key;
                        object value = p.Value;

                        object o_;
                        IDictionary<int, object> o;
                        if (result.ContainsKey(key))
                        {
                            result.TryGetValue(key, out o_);
                            o = (IDictionary<int, object>)o_;
                        }
                        else
                        {
                            o = new Dictionary<int, object>();
                            result.Add(key, o);
                        }
                        o.Add(i, value);

                    }
                }

                return result;
            }
		
			// OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setPortProperties(ComponentID cid, string portName, TypeMap map)
            {
                ManagerComponentID cid_ = (ManagerComponentID)cid;
			    int[] nodes = cid_.WorkerNodes;
			    //foreach (int node in list)
			    for (int i = 0; i < nodes.Length; i++)
			    {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(i);
                    gov.cca.ports.BuilderService builder = this.WorkerBuilder[nodes[i]];
                    builder.setPortProperties(cid, portName, map);
                }
            }
		
			
            [MethodImpl(MethodImplOptions.Synchronized)]
            public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName)
            {
			    string usingPortNameQ = user.getInstanceName() + ":" + usingPortName;
				string providingPortNameQ = provider.getInstanceName() + ":" + providingPortName;
									
                Console.WriteLine("CONNECT {0}.{1} TO {2}.{3}", user.getInstanceName(), usingPortName, provider.getInstanceName(), providingPortName);
			
				ConnectionID connection = null;
			
			    if (this.host_services.ContainsKey(user.getInstanceName()))
                    connection = connect_h2c(user, usingPortName, provider, providingPortName);
			    else
			    	connection = connect_c2c(user, usingPortName, provider, providingPortName);
			    
				Console.WriteLine("CONNECT - STEP 1");

				connectionList.Add(connection);
                //connByProviderPortName.Add(providingPortNameQ, connection);
                connByUserPortName.Add(usingPortNameQ, connection);
				port_manager.resetPort(usingPortNameQ);
			
		        AutoResetEvent waiting_handle = null;
				if (waitingUserPorts.TryGetValue(usingPortNameQ, out waiting_handle))
				   waiting_handle.Set();
			
				return connection;
			
            }
		
			private ConnectionID connect_h2c (ComponentID user, 
		                                      string usingPortName,  
		                                      ComponentID provider, 
		                                      string providingPortName)
			{
			    Console.WriteLine("BEGIN CONNECT_H2C ");

			    ConnectionID connection = null;

			    ManagerComponentID mcid_provider = (ManagerComponentID)provider;
			    ManagerComponentID mcid_user = (ManagerComponentID)user;

	            if (!(mcid_provider is ManagerIgnoredComponentID))
	            {
	                int[] user_nodes = mcid_user.WorkerNodes;
	                IDictionary<int, IList<WorkerComponentID>> user_nodes_inv = new Dictionary<int, IList<WorkerComponentID>>();
	                //foreach (int node in node_user_list)
	                for (int i = 0; i < user_nodes.Length; i++)
	                {
	                    IList<WorkerComponentID> user_cids_in_node;
	                    if (!user_nodes_inv.TryGetValue(user_nodes[i], out user_cids_in_node))
	                    {
	                        user_cids_in_node = new List<WorkerComponentID>();
	                        user_nodes_inv[user_nodes[i]] = user_cids_in_node;
	                    }
	                    user_cids_in_node.Add(mcid_user.getWorkerComponentID(i));
	                }

	                // GROUP BY NODES
	                int[] provider_nodes = mcid_provider.WorkerNodes;
	                WorkerConnectionID[] worker_connection = new WorkerConnectionID[provider_nodes.Length];

                    IDictionary<int, IList<Tuple<WorkerComponentID, int, WorkerComponentID>>> worker_cid_list = new Dictionary<int, IList<Tuple<WorkerComponentID, int, WorkerComponentID>>>();
	                for (int i = 0; i < provider_nodes.Length; i++)
	                {
	                    IList<Tuple<WorkerComponentID, int, WorkerComponentID>> worker_cids_of_node;
	                    if (!worker_cid_list.TryGetValue(provider_nodes[i], out worker_cids_of_node))
	                    {
	                        worker_cids_of_node = new List<Tuple<WorkerComponentID, int, WorkerComponentID>>();
	                        worker_cid_list[provider_nodes[i]] = worker_cids_of_node;
	                    }
	                    worker_cids_of_node.Add(new Tuple<WorkerComponentID, int, WorkerComponentID>(user_nodes_inv[provider_nodes[i]][0], i, mcid_provider.getWorkerComponentID(i)));
	                }

	                int node_count = -1;
	                foreach (KeyValuePair<int, IList<Tuple<WorkerComponentID, int, WorkerComponentID>>> node in worker_cid_list)
	                {
	                    if (node.Value.Count == 1 && (node_count == -1 || node_count == 1))
	                    {
                            Console.WriteLine("CONNECT H2C 1 node={0}",node.Key);
	                        node_count = 1;
	                        gov.cca.ports.BuilderService wb = WorkerBuilder[node.Key];
	                        int i = node.Value[0].Item2;
	                        WorkerComponentID ucid = node.Value[0].Item1;
	                        WorkerComponentID pcid = node.Value[0].Item3;
	                        worker_connection[i] = (WorkerConnectionID)wb.connect(ucid, usingPortName, pcid, providingPortName);
	                    }
	                    // Se há mais de dois, então devem ter wcids com nomes de instância diferentes.
	                    else if (node.Value.Count > 1 && (node_count == -1 || node_count == node.Value.Count))
	                    {
							node_count = node.Value.Count;
						
                            Console.WriteLine("CONNECT H2C 2 node={0} instances={1}", node.Key, node_count);

                            foreach (Tuple<WorkerComponentID, int, WorkerComponentID> a in node.Value)
	                        {
	                            gov.cca.ports.BuilderService wb = WorkerBuilder[node.Key];
	                            int i = a.Item2;
	                            WorkerComponentID ucid = a.Item1;
	                            WorkerComponentID pcid = a.Item3;
								Console.WriteLine("CONNECT H2C 3 index={0} ucid={1} pcid={2} ", node.Key, ucid.getInstanceName(), pcid.getInstanceName());
								worker_connection[i] = (WorkerConnectionID)wb.connect(ucid, usingPortName + "$" + i, pcid, providingPortName);
	                            Console.WriteLine("CONNECT H2C 4 index={0} ucid={1} uport={3} pcid={2} pport={4}", node.Key, worker_connection[i].getUser().getInstanceName(), worker_connection[i].getProvider().getInstanceName(), worker_connection[i].getUserPortName(),worker_connection[i].getProviderPortName());
						    }
	                    }
	                    else
	                    {
	                        const string V = "connect_h2c (EXCEPTION): UNMATCHED ports ";
	                        Console.WriteLine(V);
	                        throw new Exception(V);
	                    }
	                }


	                connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName, worker_connection);
	            }
				else
				{
					connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName);
					Console.WriteLine("connect_h2c -- IGNORE CONNECTION -- " + provider.getInstanceName());
				}

    		    Console.WriteLine("END CONNECT_H2C ");

			    return connection;
			
			}

        private ConnectionID connect_c2c(ComponentID user,
                                          string usingPortName,
                                          ComponentID provider,
                                          string providingPortName)
        {
            ConnectionID connection = null;

            ManagerComponentID user_ = (ManagerComponentID)user;
            ManagerComponentID provider_ = (ManagerComponentID)provider;

            if (!(user is ManagerIgnoredComponentID) && !(provider is ManagerIgnoredComponentID))
            {

                IDictionary<Tuple<string, string>, Tuple<int, int>[]> used_ports = this.selectPorts(this.getUsedPorts(user_), usingPortName);
                IDictionary<Tuple<string, string>, Tuple<int, int>[]> provided_ports = this.selectPorts(this.getProvidedPorts(provider_), providingPortName);

                // ALIGN WORKER PORTS

                IDictionary<int, Tuple<IList<Tuple<string, int>>, IList<Tuple<string, int>>>> r = new Dictionary<int, Tuple<IList<Tuple<string, int>>, IList<Tuple<string, int>>>>();

                foreach (KeyValuePair<Tuple<string, string>, Tuple<int, int>[]> p in used_ports)
                    foreach (Tuple<int, int> n in p.Value) if (n.Item1 >= 0)
                    {
                        Tuple<IList<Tuple<string, int>>, IList<Tuple<string, int>>> t;
                        if (!r.TryGetValue(n.Item1, out t))
                            t = new Tuple<IList<Tuple<string, int>>, IList<Tuple<string, int>>>(new List<Tuple<string, int>>(), new List<Tuple<string, int>>());
                        t.Item1.Add(new Tuple<string, int>(p.Key.Item2, n.Item2));
                        r[n.Item1] = t;
                    }

                foreach (KeyValuePair<Tuple<string, string>, Tuple<int, int>[]> p in provided_ports)
                    foreach (Tuple<int, int> n in p.Value) if (n.Item1 >= 0)
                        r[n.Item1].Item2.Add(new Tuple<string, int>(p.Key.Item1, n.Item2));

                int[] provider_nodes = provider_.WorkerNodes;
                WorkerConnectionID[] worker_connection = new WorkerConnectionID[provider_nodes.Length];

                foreach (int node in r.Keys) if (node >= 0)
                {
                    IList<Tuple<string, int>> port_user_list = r[node].Item1;
                    IList<Tuple<string, int>> port_prov_list = r[node].Item2;

                    if (port_prov_list.Count == 1)
                    {
                        WorkerComponentID cid_prov = provider_.getWorkerComponentID(port_prov_list[0].Item2);

                        foreach (Tuple<string, int> port_user in port_user_list)
                        {
                            WorkerComponentID cid_user = user_.getWorkerComponentID(port_user.Item2);
                            Console.WriteLine("CONNECT_C2C 1 ---- {0}.{1} TO {2}.{3}",cid_user.getInstanceName(), port_user.Item1, cid_prov.getInstanceName(), providingPortName);
                            worker_connection[node] = (WorkerConnectionID)WorkerBuilder[node].connect(cid_user, port_user.Item1, cid_prov, providingPortName);
                        }
                    }
                    else if (port_prov_list.Count == port_user_list.Count)
                    {
                        foreach (Tuple<string, int> port_user in port_user_list)
                        {
                            WorkerComponentID cid_user = user_.getWorkerComponentID(port_user.Item2);
                            foreach (Tuple<string, int> port_prov in port_prov_list)
                                if (port_prov.Item1.EndsWith(port_user.Item1))
                                {
                                    WorkerComponentID cid_prov = provider_.getWorkerComponentID(port_prov.Item2);
										Console.WriteLine("CONNECT_C2C 2 ---- {0}.{1} TO {2}.{3}", cid_user.getInstanceName(), port_user.Item1, cid_prov.getInstanceName(), providingPortName);
										worker_connection[node] = (WorkerConnectionID)WorkerBuilder[node].connect(cid_user, port_user.Item1, cid_prov, providingPortName);
                                }
                        }
                    }
                    else
                    {
                        Console.WriteLine("connect_c2c: unmatch user and provider --- user count = {0} / provider count = {1}", port_user_list.Count, port_prov_list.Count);
                        throw new Exception("connect_c2c: unmatch user and provider");
                    }
                }
				connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName, worker_connection);
			}
			else
			{
				connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName);
				Console.WriteLine("connect_c2c -- IGNORE CONNECTION -- " + provider.getInstanceName());
			}

			return connection;
		}

        private IDictionary<Tuple<string,string>, Tuple<int, int>[]> selectPorts(IDictionary<string, Tuple<int, int>[]> used_ports, string usingPortName)
        {
            IDictionary<Tuple<string, string>, Tuple<int, int>[]> output = new Dictionary<Tuple<string, string>, Tuple<int, int>[]>();

            foreach (KeyValuePair<string, Tuple<int, int>[]> p in used_ports)
            {
                string[] w = p.Key.Split(new char[1] { ':' });
                Console.WriteLine("selectPorts --- w[0]={0}   w[1]={1}", w[0], w[1]);

                string port_name_q = w[1];
                string port_name = port_name_q.Split(new char[1] { '.' })[0];
                if (port_name.Equals(usingPortName))
                {
                    string worker_instance_name = w[0];
                    output[new Tuple<string, string>(worker_instance_name, port_name_q)] = p.Value;
                    Console.Write("selectPorts --- output[{0}/{1}]=", worker_instance_name, port_name_q);
                    foreach (Tuple<int, int> node in p.Value)
                        Console.Write("{0}/{1},", node.Item1, node.Item2);
                    Console.WriteLine(".");
                }
            }

            return output;
        }

   /*     private ConnectionID connect_c2c_ (ComponentID user, 
		                                      string usingPortName, 
		                                  	  string usingPortNameQ,
		                                      ComponentID provider, 
		                                      string providingPortName,
		                                      string providingPortNameQ)
			{
				ConnectionID connection = null;

                ManagerComponentID user_ = (ManagerComponentID)user;
                ManagerComponentID provider_ = (ManagerComponentID)provider;

				if (!(user is ManagerIgnoredComponentID) && !(provider is ManagerIgnoredComponentID))
				{

				    IDictionary<string, Tuple<int, int>[]> used_ports = this.getUsedPorts(user_);
				Console.WriteLine("CONNECT C2C AAAAA ");
				this.selectPorts(used_ports, usingPortName);
				Console.WriteLine("CONNECT C2C BBBBB ");
				this.selectPorts(this.getProvidedPorts(provider_), providingPortName);
				Console.WriteLine("CONNECT C2C CCCCC ");


				IDictionary<string,IDictionary<int, int>> user_nodes_inv_dict = new Dictionary<string,IDictionary<int, int>>();
    
                    int[] provider_nodes = provider_.WorkerNodes;

                    Console.WriteLine("connect_c2c 0 " + (user.getInstanceName() + ":" + usingPortName) + ", used_ports.Count=" + used_ports.Count);
				    foreach (string k in used_ports.Keys)
				           Console.WriteLine ("-------------------- " + k);

				    WorkerConnectionID[] worker_connection = new WorkerConnectionID[provider_nodes.Length];	
				
	                // A NULL worker_connection must exist for partially connected providers.
                    for (int i=0; i<provider_nodes.Length; i++) if (provider_nodes[i] >= 0)
	                {
					    Console.WriteLine("connect_c2c 1 node={0}", provider_nodes[i]);

					    WorkerComponentID cid_user = user_.getWorkerComponentID(provider_nodes[i]);  // TODO: ???????????????????
					    string worker_instance_name = cid_user.getInstanceName();
                        string using_port_name_worker = worker_instance_name + ":" + usingPortName;

                        Console.WriteLine("connect_c2c 1 using_port_name_worker = {0}", using_port_name_worker);

                        IDictionary<int, int> user_nodes_inv;
                        if (!user_nodes_inv_dict.TryGetValue(using_port_name_worker, out user_nodes_inv))
                        {
                            user_nodes_inv_dict[using_port_name_worker] = user_nodes_inv = new Dictionary<int, int>();
                            int[] user_nodes = used_ports[using_port_name_worker];
                            for (int k = 0; k < user_nodes.Length; k++)
							    user_nodes_inv_dict[using_port_name_worker][user_nodes[k]] = k;
					    }

					    if (user_nodes_inv.ContainsKey (provider_nodes [i])) 
						{   							
							Console.WriteLine ("start connect_c2c 0 loop user node " + provider_nodes [i] + " - " + (cid_user == null));
							WorkerComponentID cid_prov = provider_.getWorkerComponentID (i); 
							Console.WriteLine ("start connect_c2c 0 loop provide node " + provider_nodes [i] + " - " + (cid_prov == null));
							worker_connection [i] = (WorkerConnectionID)WorkerBuilder [provider_nodes [i]].connect (cid_user, usingPortName, cid_prov, providingPortName);
							Console.WriteLine ("end connect_c2c 0 loop node " + provider_nodes [i]);
						}
	                }
					Console.WriteLine("connect_c2c 1");
					
					connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName, worker_connection);
					Console.WriteLine("connect_c2c 2");
				}
			    else
			    {
				    connection = new ManagerConnectionIDImpl (provider, providingPortName, user, usingPortName);
					Console.WriteLine ("connect_c2c -- IGNORE CONNECTION -- " + provider.getInstanceName ());
	            }
                
                return connection;
			}            
            */
		
		    // OK
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

			// OK
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
		
		    // OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getConnectionProperties(ConnectionID connID)
            {
               TypeMap properties = null;
               connectionProperties.TryGetValue(connID, out properties);
               return properties;
            }
		
		    // OK
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
				string userInstanceName = connID.getUser().getInstanceName();
			 	string usesPortName = userInstanceName + ":" +  connID.getUserPortName();
			
				string providerInstanceName = connID.getProvider().getInstanceName();
			 	string providesPortName = providerInstanceName + ":" +  connID.getProviderPortName();
			
			//	Console.WriteLine ("DISCONNECTING 1 " + usesPortName + " <- " + providesPortName);
		
				if (!port_manager.isReleased(usesPortName))
				{
					throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
				}
			
			//	Console.WriteLine ("DISCONNECTING 2 " + usesPortName + " <- " + providesPortName);

				if (!connectionList.Contains(connID))
				{
					throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
				}
			
			//	Console.WriteLine ("DISCONNECTING 3 " + usesPortName + " <- " + providesPortName);

				ManagerComponentID cid_provider = (ManagerComponentID) connID.getProvider();
			    ManagerComponentID cid_user = (ManagerComponentID) connID.getUser();

				if (!(cid_user is ManagerIgnoredComponentID) && !(cid_provider is ManagerIgnoredComponentID)) 
			 	{
					int[] nodes = cid_provider.WorkerNodes;
					for (int i = 0; i < nodes.Length; i++) 
					{
						WorkerConnectionID conn_id = ((ManagerConnectionID)connID).getWorkerConnectionID (i);
				//		Console.WriteLine ("DISCONNECTING 3.1 i=" + i + " - nodes[i]=" + nodes [i] + " conn_id is null ? " + (conn_id == null));

						if (conn_id != null)
							try 
							{
								this.WorkerBuilder [nodes [i]].disconnect (conn_id, timeout);     
							} 
							catch (CCAExceptionImpl e) 
							{
				//				Console.WriteLine ("DISCONNECTING 3.2 - EXCEPTION: " + e.getCCAExceptionType ());
							}
					}
				}
			
				//Console.WriteLine ("DISCONNECTING 4 " + usesPortName + " <- " + providesPortName);

	            connectionList.Remove(connID);
	            connByUserPortName.Remove(usesPortName);
	            connByProviderPortName.Remove(providesPortName);

			
		//	Console.WriteLine ("DISCONNECTING 5 " + usesPortName + " <- " + providesPortName);


	            if (connectionProperties.ContainsKey(connID))
	                connectionProperties.Remove(connID);
			
		//	Console.WriteLine ("DISCONNECTING 6 " + usesPortName + " <- " + providesPortName);

            }
		
			// OK
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

                IDictionary<int, ComponentID> id2_ws_inv = new Dictionary<int, ComponentID>();
                for (int node = 0; node < id2_ws.Length; node++)
                {
                    WorkerComponentID id2_w = id2_m.getWorkerComponentID(node);
                    id2_ws_inv.Add(node, id2_w);
                }

                for (int node = 0; node < id1_ws.Length; node++) 
                {
                    WorkerComponentID id1_w = id1_m.getWorkerComponentID(node);
                    ComponentID cid1 = id1_w;
                    ComponentID cid2;
                    if (id2_ws_inv.ContainsKey(node))
                    {
                        id2_ws_inv.TryGetValue(node, out cid2);
                        gov.cca.ports.BuilderService builder = WorkerBuilder[id1_ws[node]];
                        builder.disconnectAll(cid1, cid2, timeout);
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
				   string fname = Constants.PATH_TEMP_WORKER + "deployed-" + d.cid + ".xml";
				   string cname = LoaderApp.SerializeDeployedComponentInfoType(fname, d);
				   classList.Add(new ManagerComponentClassDescriptionImpl(cname));
			    }
			
	            classArray = new ComponentClassDescription[classList.Count];
	            classList.CopyTo(classArray, 0);
	
	            Connector.closeConnection();
	
	            return classArray;
            }

            #endregion

        	public Port getServicePort(ComponentID user, string usedPortName)
			{
				string portType;
				if (usesPortTypes.TryGetValue(usedPortName, out portType))
				{
					Port singleton_service_port = null;
					ServiceProvider service_provider = null;
					if (usedPortName.EndsWith(Constants.REGISTRY_PORT_NAME)) 
					{
						return this;
					}				
					else if (this.provided_services_table.TryGetValue(portType,out service_provider))
				    { 
						string providedPortName = service_provider.createService(portType);
					    ConnectionID conn = frw_builder.connect(user, usedPortName, frw_services.getComponentID(), providedPortName);
					
						return getPortProceed(conn, usedPortName);
				    }
					else if (this.singleton_provided_port_table.TryGetValue(portType, out singleton_service_port))
				    { 
						return singleton_service_port;
				    }
				}
				return null;
			}
			
		
			#region Services implementation
			
			public Port getPort(string portName)
			{
				Console.WriteLine ("MANAGER OBJECT - getPort " + portName);
			    ConnectionID conn = null;
			
				if (usesPortTypes.ContainsKey(portName))
				{				
					if (connByUserPortName.TryGetValue(portName, out conn)) 
					{
					    return getPortProceed(conn, portName);
					} 
					else
					{					    
						Console.WriteLine("Wait for port " + portName);
					
		                AutoResetEvent wait_handle = new AutoResetEvent(false);
		                waitingUserPorts.Add(portName, wait_handle);
		                wait_handle.WaitOne();
						
						connByUserPortName.TryGetValue(portName, out conn);
					    return getPortProceed(conn, portName);
					}
				}
				else {
					
					throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
				}
			}
	
			public Port getPortNonblocking (string portName)
			{
			    ConnectionID conn = null;
				if (connByUserPortName.TryGetValue(portName, out conn)) 
				{
				    return getPortProceed(conn, portName);
				}
				else
				{
				   throw new CCAExceptionImpl("ERROR: Port not connected - name=" + portName);
				}
			}
			
		    public Port getPortProceed(ConnectionID conn, string user_port_name)
			{
				ManagerComponentID mcid = (ManagerComponentID) conn.getUser();
			    ManagerComponentID wcid = (ManagerComponentID) conn.getProvider();
				ManagerServices ms = null;
				this.host_services.TryGetValue(mcid.getInstanceName(), out ms);
			
			    IDictionary<int, WorkerServices> ws = ms.WorkerServices; 
				int[] nodes = wcid.WorkerNodes;			
				gov.cca.Port[] ports = new gov.cca.Port[nodes.Length];

	            foreach (int i in ws.Keys)
	                Console.WriteLine("getPortProceed {0} *********************** ", i);

				for (int i=0; i<nodes.Length; i++)
				{
					WorkerConnectionID wconn = ((ManagerConnectionIDImpl)conn).getWorkerConnectionID(i);
                    Console.WriteLine("BEGIN GET PORT PROCEED {0} ", wconn.getUserPortName());
                    ports[i] = ws[nodes[i]+1].getPortNonblocking(wconn.getUserPortName());
				    Console.WriteLine("END GET PORT PROCEED {0} ", wconn.getUserPortName());
			    }		
			    			
			    //string user_port_name = conn.getUserPortName();
			    gov.cca.Port port = null;
			
				/* TODO: It is still necessary to implement a general mechanism
				 * for connecting to applications, where an application may provide
				 * arbitrary ports for the host and vice-versa
				 */
				if (user_port_name.EndsWith(Constants.GO_PORT_NAME))
				{
					port = new GoPortImpl(ms, ports);
			    } 
				else if (user_port_name.EndsWith(Constants.INITIALIZE_PORT_NAME))
				{
					port = new InitializePortImpl(ms, ports);
				}
				else if (user_port_name.EndsWith(Constants.RECONFIGURE_PORT_NAME))
				{
					port = new ReconfigurationAdvicePortImpl(ms, ports);
				}
				else
					throw new CCAExceptionImpl("CCA Exception (manager): Port not supported for host connections.");
				
				port_manager.addPortFetch(user_port_name);
			
				return port;
			
			}
		
			


	
			public void releasePort (string portName)
			{
			    port_manager.addPortRelease(portName);
				
			}
	
			public void registerUsesPort (string portName, string type, gov.cca.TypeMap properties)
			{
				if (usesPortTypes.ContainsKey(portName))
				{
					throw new CCAExceptionImpl(CCAExceptionType.PortAlreadyDefined);
				}
			
	            portProperties.Add(portName, properties);
				usesPortTypes.Add (portName, type);
			}
	
			public void unregisterUsesPort (string portName)
			{
				if (!usesPortTypes.ContainsKey(portName))
				{
					// It is a component uses port.
					//throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
				}
			
				if (connByUserPortName.ContainsKey(portName))
				{
					throw new CCAExceptionImpl("CCA Exception (manager): it is not possible" +
											   " to unregister a connected uses port." +
											   " Try disconnect it first.");
				}			
			
				portProperties.Remove(portName);
				usesPortTypes.Remove(portName);
				port_manager.resetPort(portName);
			}
	
			public void addProvidesPort (Port inPort, string portName, string type, gov.cca.TypeMap properties)
			{
				if (providesPorts.ContainsKey(portName))
				{
					throw new CCAExceptionImpl(CCAExceptionType.PortAlreadyDefined);
				}
			
	            portProperties.Add(portName, properties);
				providesPortTypes.Add(portName, type);
	            providesPorts.Add(portName, inPort);
			    //throw new CCAExceptionImpl("Host programs cannot yet provide ports to applications.");
			}
	
			public gov.cca.TypeMap getPortProperties (string name)
			{
				if (!portProperties.ContainsKey(name))
				{
					throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
				}
			
				TypeMap properties = null;
				portProperties.TryGetValue(name, out properties);
				return properties;
			}
	
			public void removeProvidesPort (string portName)
			{
			//	if (!providesPorts.ContainsKey(portName))
			//	{
			//		throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
			//	}
			
				if (connByProviderPortName.ContainsKey(portName))
				{
					throw new CCAExceptionImpl("CCA Exception (manager): it is not possible" +
											   " to unregister a connected provides port." +
											   " Try disconnect it first.");
				}
			
				portProperties.Remove(portName);
				providesPortTypes.Remove(portName);
				providesPorts.Remove(portName);
			}
	
			public ComponentID getComponentID ()
			{
				return frw_services.getComponentID();
			}
		
		    private IList<ComponentRelease> callBackReleases = new List<ComponentRelease>();
	
			public void registerForRelease (ComponentRelease callBack)
			{
				callBackReleases.Add(callBack);
			}
		
			#endregion
		
		
			public ManagerServices getComponentServices(ManagerComponentID cid)
			{
				Console.WriteLine ("getComponentServices " + cid.getInstanceName());
				foreach (string sss in component_services.Keys)
					Console.WriteLine ("getComponentServices [" + sss + "]");
				//return (ManagerServices) component_services[cid.getInstanceName()];
			    ManagerServices result = null;
				if (component_services.TryGetValue (cid.getInstanceName (), out result))
					return result;
				else 
					return null;
			}
		
            private void registerComponent(ComponentID cid, ManagerServices services, TypeMap properties)
            {
                component_services.Add (cid.getInstanceName(), services);
				componentIDs.Add(cid.getInstanceName(), cid);
                componentProperties.Add(cid.getInstanceName(), properties);
            }
        
            private void registerHostService(ComponentID cid, ManagerServices services)
            {
                host_services.Add(cid.getInstanceName(), services);
            }

            private int[] fetchNodes(HPETypeMap properties)
            {
                Object nodesObj = null;
                int[] nodes = null;
                if (!properties.TryGetValue(Constants.NODES_KEY, out nodesObj))
                {
                    // Se NODES_KEY não está disponível, considerar todos.
                    nodes = new int[WorkerFramework.Count];
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

			public void resolve_topology (DGAC.database.AbstractComponentFunctorApplication acfaRef, 
									  int[] unit_mapping,
		                              out string[] interface_ids, 
									 // out int[] unit_indexes, 
		                              out int[] nodes)
			{
					IList<Interface> iList;

					nodes = unit_mapping;
				    interface_ids = new string[nodes.Length];
				  //  unit_indexes = new int[nodes.Length];
				
                    iList = BackEnd.idao.list(acfaRef.Id_abstract);
				    if (iList.Count == 1) // SPMD
				    {
					    for (int i = 0; i < nodes.Length; i++) {
						    interface_ids[i] = iList[0].Id_interface;
						   // unit_indexes[i] = 0;
					    }
				    } 
					else
					{
						throw new Exception("ManagerObject.resolve_topology: In simple SPMD case, the component must have a single parallel unit." + acfaRef.Id_abstract);
					}


			}


			public void resolve_topology (DGAC.database.AbstractComponentFunctorApplication acfaRef, 
									      Instantiator.UnitMappingType[] unit_mapping,
		                                  out string[] interface_ids, 
									      out int[] nodes,
			                              int facet_instance)
			{
				Console.WriteLine("BEGIN resolve_topology");

				interface_ids = null;
			    IList<Interface> iList = null;
				nodes = null;
				
				Console.WriteLine("resolve_topology 1 " + (unit_mapping == null) + ", length="+ (unit_mapping.Length));

				int count_nodes;
				IDictionary<string,IList<Tuple<int,int[],int>>> unit_mapping_dict;
			 
			    // Note: only the units associated to the current facet are considered for instantiation.
				BackEnd.copy_unit_mapping_to_dictionary(facet_instance, unit_mapping, out unit_mapping_dict, out count_nodes);

			    Console.WriteLine("resolve_topology 2 - count_nodes = " + count_nodes);

				interface_ids = new string[count_nodes];
				nodes = new int[count_nodes];

                iList = BackEnd.idao.list(acfaRef.Id_abstract);

				Console.WriteLine("resolve_topology 3 - " + acfaRef.Id_abstract);

			    int i = 0;
				foreach (Interface unit in iList)
				{					
					Console.WriteLine ("resolve_topology 4 - unit " + unit.Id_interface + ", facet " + unit.Facet);
					IList<Tuple<int,int[],int>> node_list;
					Console.WriteLine ("resolve_topology #1");

				   if (unit_mapping_dict.TryGetValue (unit.Id_interface_super_top, out node_list)) 
				   {
						Console.WriteLine ("resolve_topology #2 - " + unit.Id_interface_super_top);

						foreach (Tuple<int,int[],int> um in node_list) 
						{
						    Console.WriteLine ("resolve_topology #2.1 " + um.Item1 + "," + facet_instance);
							if (um.Item1 == facet_instance) 
							{
								Console.WriteLine ("resolve_topology #2.2");

							    foreach (int node in um.Item2) 
								{
									Console.WriteLine ("resolve_topology #2.3");
									Console.WriteLine ("unit " + unit.Id_interface + " at node " + node);
									interface_ids [i] = unit.Id_interface;
									nodes [i] = node;
									i++;
									Console.WriteLine ("resolve_topology #2.4");
								}

							}
							else 
							{
                            Console.WriteLine ("Unit " + unit.Id_interface_super_top + " does not belong to facet {0}", facet_instance);
							}
						}
				   }
				   Console.WriteLine ("resolve_topology #3");
				}


				// ASSERT {i == count_nodes}

				//Console.WriteLine("END resolve_topology");
		}


		public string[] calculatePortNames (int id_abstract, string id_interface)
		{
            IList<Slice> sList = BackEnd.sdao.listByInterface(id_abstract, id_interface);
			IDictionary<string, Slice> portNameList = new Dictionary<string, Slice>();
            IList<string> replicated_port_name = new List<string>();

            foreach (Slice slice in sList)
            {
			   InnerComponent ic = BackEnd.icdao.retrieve(slice.Id_abstract, slice.Id_inner);
			   AbstractComponentFunctor acf_inner = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);
				
			   int slice_kind_inner = Constants.kindMapping[acf_inner.Kind];
               
               if (slice_kind_inner != Constants.KIND_QUALIFIER) 
               {
					Console.WriteLine("calculatePortNames 1 --- {0}", slice.Id_inner);
					Slice other_slice;
                    if (!portNameList.TryGetValue(slice.Id_inner, out other_slice))
                    {
                        portNameList[slice.Id_inner /*+ "." + slice.Id_interface_slice*/] = slice;
                    }
                    else
                    {
                        Console.WriteLine("calculatePortNames 2 --- multiple slices of the same inner --- {0}.{1} / {2}.{3}", slice.Id_inner, slice.Id_interface_slice, other_slice.Id_inner, other_slice.Id_interface_slice);
                        if (!replicated_port_name.Contains(slice.Id_inner)) replicated_port_name.Add(slice.Id_inner);
                        portNameList[slice.Id_inner + "." + slice.Id_interface_slice] = slice;
						portNameList[other_slice.Id_inner + "." + other_slice.Id_interface_slice] = other_slice;
					}
			   }
            }

            foreach (string port_name_delete in replicated_port_name)
                portNameList.Remove(port_name_delete);
			
			string[] portNameArray = new string[portNameList.Count];
            portNameList.Keys.CopyTo(portNameArray,0);
			
			return portNameArray;
		}

		void create_server (string server_address, int server_port, out Socket listener)
		{
			// CREATE MY SERVER
			IPAddress ipAddress = IPAddress.Parse (server_address);	
			IPEndPoint localEndPoint = new IPEndPoint (ipAddress, server_port);

			Console.WriteLine ("binding_exchange_port N - CREATE SERVER - ipHostInfo: " + ipAddress + ":" + server_port);

			listener = new Socket (AddressFamily.InterNetwork, SocketType.Stream, System.Net.Sockets.ProtocolType.Tcp);

			listener.Bind (localEndPoint);
			listener.Listen (10);		

		}

		void connect_to_the_next_server (string client_address, int client_port, out Socket sender)
		{
			// LINK TO THE OTHER SERVER
			IPAddress ipAddressClient = IPAddress.Parse (client_address);
			IPEndPoint remoteEP = new IPEndPoint (ipAddressClient, client_port);

			Console.WriteLine ("binding_exchange_port N - LINK CLIENT - ipHostInfo: " + ipAddressClient + ":" + client_port);

			// Create a TCP/IP  socket.
			sender = new Socket (AddressFamily.InterNetwork, SocketType.Stream, System.Net.Sockets.ProtocolType.Tcp);
			bool isConnected = false;
			int tries = 0;
			while (!isConnected && tries <=30) 
			{
				try 
				{
					sender.Connect (remoteEP);
					isConnected = true;
				}
				catch (Exception e) 
				{
					tries ++;
					isConnected = false;
					Console.Error.WriteLine("CONNECTION FAILED N --- ATTEMPT #" + tries);
					Thread.Sleep(1000);
				}
			}
			if (!isConnected)
				throw new Exception("binding-exchange-port N --- It was not possible to talk to the other side");

			Console.WriteLine("binding_exchange_port N - CONNECTED.");
		}

		void send_to_the_next (Socket sender, string current_address, int current_port)
		{
			Console.WriteLine ("binding_exchange_ports N --- this FACET will send " + current_address + ":" + current_port + " to the other FACET -- " + sender.Connected);

			byte[] msgSent = Encoding.ASCII.GetBytes (current_address + ":" + current_port + "#");
			int bytesSent = sender.Send (msgSent);

			Console.WriteLine ("binding_exchange_ports N --- this FACET sent " + current_address + ":" + current_port + " to the other FACET");

		}

		void receive_from_the_previous (Socket handler, ref IList<string> previous_address, ref IList<int> previous_port)
		{
			Console.WriteLine ("binding_exchange_ports N *** this FACET will receive from the previous FACET *** ");

			byte[] msgReceived = new byte[1024];
			int bytesReceived = handler.Receive (msgReceived);
			string previous_address_port = Encoding.ASCII.GetString (msgReceived, 0, bytesReceived);
			string[] r = previous_address_port.Split(new char[] {'#'});
			for (int i = 0; i < r.Length - 1; i++) 
			{
				string[] s = r[i].Split (new char[] { ':' });
				string previous_address_item = s [0];
				int previous_port_item = int.Parse (s [1]);
				previous_address.Add (previous_address_item);
				previous_port.Add (previous_port_item);
				Console.WriteLine (i + " -- binding_exchange_ports N *** this FACET received END " + previous_address_item + ":" + previous_port_item + " from the previous FACET *** " + bytesReceived);
			}

		}

		private void binding_calculate_ports_locally (int binding_sequential, int[] facet_access_port_base, ref int[] facet_access_port)
		{
			facet_access_port = new int[facet_access_port_base.Length];

			for (int i = 0; i < facet_access_port_base.Length; i++)
				facet_access_port [i] = facet_access_port_base [i] + binding_sequential * 256;
		}

		private void binding_exchange_ports_N (int facet_index, IList<int> facet_list, ref string[] facet_access_address, ref int[] facet_access_port)
		{
			Trace.Write("binding_exchange_ports_N - BEGIN: " + facet_index + " === ");
			foreach (int fl in facet_list)
				Trace.Write (fl + ",");
			Console.WriteLine ("END");			

			int N = facet_list.Count;

			string this_facet_address = null;
			int this_facet_port = -1;
			calculate_this_facet_address(ref this_facet_address, ref this_facet_port);

			Console.WriteLine ("binding_exchange_ports N - this_facet_address is " + this_facet_address + " / this_facet_port is " + this_facet_port);	

			int next_facet;    
			Math.DivRem (facet_index + 1, N, out next_facet);

			Console.WriteLine ("binding_exchange_ports_N - this facet is " + facet_list[facet_index] + ", next facet is " + next_facet + " ... N=" + N);

			// CREATE SERVER
			Socket receiver = null;
			Socket sender = null;
			create_server (facet_access_address [facet_list[facet_index]], facet_access_port [facet_list[facet_index]], out receiver);

			// CONNECT TO THE NEXT SERVER
			Socket handler = null;
			ThreadStart ts = delegate { 
				Console.WriteLine("binding_exchange_ports_N - Awaiting ACCEPT ...");
				handler = receiver.Accept (); 
				Console.WriteLine("binding_exchange_ports_N - .. ACCEPT OK ! ");
			};
			Thread t = new Thread (ts);
			t.Start ();
			connect_to_the_next_server (facet_access_address [next_facet], facet_access_port [next_facet], out sender);				
			t.Join ();

			int current_facet = facet_index; 

			IList<string> current_address = new List<string> (); ;
			IList<int> current_port = new List<int> ();

			current_address.Add (this_facet_address);
			current_port.Add (this_facet_port);

			int i = 0;
			while (i < N)
			{
				Console.WriteLine ("binding_exchange_ports_N XXXXX BEGIN - current facet is " + current_facet);
				while (current_address.Count > 0) 
				{
					string current_address_item = current_address [0];
					int current_port_item = current_port [0];

					current_address.RemoveAt (0);
					current_port.RemoveAt (0);
					
					facet_access_address [facet_list [current_facet]] = current_address_item;
					facet_access_port [facet_list [current_facet]] = current_port_item;

					i++;

					if (i < N) 
					{
						/*while (!sender.Connected) 
						{
							sender.Shutdown (SocketShutdown.Both);
							sender.Close ();

							ThreadStart ts1 = delegate { handler = receiver.Accept (); };
							Thread t1 = new Thread (ts1);
							t1.Start ();
							connect_to_the_next_server (facet_access_address [next_facet], facet_access_port [next_facet], out sender);				
							t1.Join ();
						}*/
						send_to_the_next (sender, current_address_item, current_port_item);

						Math.DivRem (current_facet + 1, N, out current_facet);
					}
				}

				if (i < N)
				    receive_from_the_previous (handler, ref current_address, ref current_port);

				Console.WriteLine ("binding_exchange_ports_N XXXXX END - current facet is " + current_facet);
			}

			Console.WriteLine ("binding_exchange_ports_N - END 1");

			receiver.Disconnect (false);

			handler.Shutdown (SocketShutdown.Both);
			handler.Close ();

			sender.Shutdown (SocketShutdown.Both);
			sender.Close ();

			Console.WriteLine ("binding_exchange_ports_N - END 2");
		}

		void calculate_this_facet_address (ref string this_facet_address, ref int this_facet_port)
		{
			this_facet_address = Constants.IP_ADDRESS_BINDING_ROOT;
			this_facet_port = Constants.FREE_BINDING_FACET_PORT;
			Console.WriteLine ("######## calculate_this_facet_address --- " + this_facet_address + ":" + this_facet_port);
		}

        [MethodImpl(MethodImplOptions.Synchronized)]
        public int[] createInstanceImpl(
            string instanceName,
            string componentName,
            TypeMapImpl properties,
            out int[] cid_nodes,
            out string[] unit_ids,
            out int[] indexes,
            out int id_functor_app,
            out int kind,
            out WorkerComponentID[] worker_cids
            )
		{
			    Console.WriteLine("CREATE INSTANCE IMPL #1");
                IList<int> cid_nodes_list = new List<int>();
                IList<string> unit_ids_list = new List<string>();
                IList<int> indexes_list = new List<int>();
                IList<WorkerComponentID> worker_cids_list = new List<WorkerComponentID>();

                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();

                    Console.WriteLine("createInstance manager " + instanceName + ", " + componentName);

					id_functor_app = (int) properties[Constants.ID_FUNCTOR_APP];  Console.WriteLine("ID_FUNCTOR_APP ok");
					IDictionary<string,int> arguments = (IDictionary<string,int>) properties[Constants.ENCLOSING_ARGUMENTS];Console.WriteLine("ENCLOSING_ARGUMENTS ok");
					int this_facet_instance= (int) properties[Constants.FACET_INSTANCE];Console.WriteLine("FACET_INSTANCE ok");
					//int this_facet = (int) properties[Constants.FACET];Console.WriteLine("FACET ok");
					
					Console.WriteLine("createInstanceImpl - this_facet_instance = " + this_facet_instance);

				    DGAC.database.Component c = BackEnd.cdao.retrieve_libraryPath(componentName);
					kind = Constants.kindMapping[c.Kind];
				
					AbstractComponentFunctorApplication acfaRef = BackEnd.acfadao.retrieve(id_functor_app);

				    IList<string>[] interface_ids=null;;
					int[] nodes = null;

					object unit_mapping = properties[Constants.NODES_KEY];
					if (unit_mapping is int[])
					{
						string[] interface_ids_;
						int[] nodes_;
						// Simple SPMD case - obsolete
						resolve_topology(acfaRef,  
										 (int[]) unit_mapping,
					                     out interface_ids_, 
										 out nodes_);
					} 
					else
					{
						// MPMD case, also covering SPMD.
						string[] interface_ids_;
						int[] nodes_;
						resolve_topology(acfaRef,  
										 (Instantiator.UnitMappingType[]) unit_mapping,
										 out interface_ids_, 
										 out nodes_,
						                 this_facet_instance);

						group_colocated_units(nodes_, interface_ids_, ref nodes, ref interface_ids);
					}

					/* BINDING:
					   If the component is a binding, it is necessary to include the root unit, which is not referred in the instantiation file.
				       The root unit is instantiated in the master worker. */				       
					Console.WriteLine(kind);

					if (kind.Equals(Constants.KIND_BINDING))
					{
					   // Console.WriteLine("BEGIN BINDING KIND !!! Adding root." + nodes.Length);
						IList<string>[] interface_ids_ = new IList<string>[interface_ids.Length + 1];
						int[] nodes_ = new int[nodes.Length + 1];
						interface_ids.CopyTo(interface_ids_,1);
						nodes.CopyTo(nodes_,1);
						interface_ids_[0] = new List<string>();
						interface_ids_[0].Add("root"); // the default name of the root unit of a binding component is "root".
						nodes_[0] = -1;
						interface_ids = interface_ids_;
						nodes = nodes_;
						//Console.WriteLine("END BINDING KIND !!! Adding root." + nodes.Length);
					}

					// CHECK FACET

                    Connector.commitTransaction();

				    IDictionary<int,bool> node_marking = new Dictionary<int,bool>();
                    foreach (int i in WorkerFramework.Keys) node_marking[i] = false; 
                    
                    IDictionary<Thread, GoWorker> go_objs = new Dictionary<Thread, GoWorker>();
                    IDictionary<Thread, int> thread_node = new Dictionary<Thread, int>();
                    IDictionary<Thread, string> thread_unit_id = new Dictionary<Thread, string>();
                    IDictionary<Thread, int> thread_index = new Dictionary<Thread, int>();

                    IList<Thread> wthreads = new List<Thread>();

					for (int k = 0; k < nodes.Length; k++)
					{
                        Console.WriteLine(this_facet_instance + ": &&&***************** k=" +k + ", nodes["+k+"]="+nodes[k] + ", id_interface = " + interface_ids[k].Count);
					}

					Instantiator.UnitMappingType[] unit_mapping_ = (Instantiator.UnitMappingType[]) unit_mapping;
					foreach (Instantiator.UnitMappingType ooo in unit_mapping_)
					{
						ooo.facetSpecified = true;
						ooo.facet_instanceSpecified = true;
					}
					string unit_mapping_xml = LoaderApp.serialize<Instantiator.UnitMappingType[]>(unit_mapping_);
					Console.WriteLine(this_facet_instance + ": UNIT MAPPING --- " + unit_mapping_xml);

					for (int k = 0; k < nodes.Length; k++)
                    {
                        IList<string> id_unit_list = interface_ids[k];
                        foreach (string id_unit in id_unit_list)
                        {
                        	Console.WriteLine(this_facet_instance + ": CREATE INSTANCE IMPL 1 " + id_unit_list.Count);

                            DGAC.database.Unit u = DGAC.BackEnd.takeUnit(c, id_unit); 
							AbstractComponentFunctor acf = DGAC.BackEnd.acfdao.retrieve(c.Id_abstract);

							Console.WriteLine(this_facet_instance + ": CREATE INSTANCE IMPL 2 " + u.Id_interface);

					        // SETUP PROPERTIES
	                        TypeMapImpl worker_properties = new TypeMapImpl(properties);
	                        worker_properties[Constants.KEY_KEY] = k;
	                        worker_properties[Constants.COMPONENT_KEY] = acf.Library_path;
							worker_properties[Constants.UNIT_KEY] = u.Id_interface ;
	 					    worker_properties[Constants.ASSEMBLY_STRING_KEY] = u.Assembly_string;
							worker_properties[Constants.PORT_NAMES_KEY] = calculatePortNames(c.Id_abstract, u.Id_interface);
							worker_properties[Constants.KIND_KEY] = c.Kind;			

						    worker_properties[Constants.NODES_KEY] = unit_mapping_xml;

							Console.WriteLine(this_facet_instance + ": CREATE INSTANCE IMPL 3");

							worker_properties[Constants.FACET_INSTANCE] = this_facet_instance;
	                       // worker_properties[Constants.FACET] = this_facet;
							worker_properties[Constants.FACET_TOPOLOGY] = (int[]) properties[Constants.FACET_TOPOLOGY];  Console.WriteLine("FACET_TOPOLOGY ok");;

							// Inform to the root unit the communication addresses of the other binding facets. 
						    if (kind == Constants.KIND_BINDING)
							{
								Console.WriteLine(this_facet_instance + ": createInstanceImpl k=" + k + "- ENTERING BINDING --- instance_name" + componentName + ", id_unit=" + u.Id_unit);

								if (k==0) 
								{
									if (!properties.ContainsKey(Constants.FACET_IP_ADDRESS) || !properties.ContainsKey(Constants.FACET_PORT))
										throw new Exception ("createInstanceImpl: UNABLE TO CREATE BINGING INSTANCE - no access information for binding facets");

									Console.WriteLine(this_facet_instance + ": CREATE INSTANCE IMPL 3.1");

									string[] facet_access_address = (string[]) properties[Constants.FACET_IP_ADDRESS];
									int[] facet_access_port = (int[]) properties[Constants.FACET_PORT];
									
									/* TODO: promover uma sincronização de números de portas entre as facetas. 
									 * Cada faceta deve oferecer um número de porta livre e informá-la as demais,
									 * através do endereço e porta base de cada plataforma.							 * 
									 */

									Console.WriteLine(this_facet_instance + ": CREATE INSTANCE IMPL 3.2");

							//		IList<int> facet_instance_list = new List<int>();
							//		Console.WriteLine("CREATE INSTANCE IMPL 3.3 " + facet_topology.Length);

							//		for (int facet_instance=0; facet_instance < facet_topology.Length; facet_instance++)
							//		{
							//		    Console.WriteLine("CREATE INSTANCE IMPL 3.4 " + facet_instance);
							//			int facet = facet_topology[facet_instance];
							//			if (facet == this_facet)
							//				facet_instance_list.Add(facet_instance);
							//		}

									// binding_exchange_ports_N(facet_index, facet_instance_list, ref facet_access_address, ref facet_access_port);
									int binding_sequential = (int) properties[Constants.BINDING_SEQUENTIAL];
									int[] facet_access_port_local = null;
									Console.WriteLine(this_facet_instance + ": CREATE INSTANCE IMPL 4 -- binding_sequential=" + binding_sequential);
								    binding_calculate_ports_locally (binding_sequential, facet_access_port, ref facet_access_port_local);
								    Console.WriteLine(this_facet_instance + ": CREATE INSTANCE IMPL 5");

									for (int ii=0; ii<facet_access_address.Length; ii++) Console.WriteLine("AFTER binding_exchange_ports_N : facet_access_address[" + ii + "] =" + facet_access_address[ii]);
									for (int ii=0; ii<facet_access_port.Length; ii++) Console.WriteLine("AFTER binding_exchange_ports_N :facet_access_port_local[" + ii + "] =" + facet_access_port_local[ii]);

								    worker_properties[Constants.FACET_IP_ADDRESS] = facet_access_address;
								    worker_properties[Constants.FACET_PORT] = facet_access_port_local;
								}
						    }

	                        string class_name_worker;
	                        
							Console.WriteLine(this_facet_instance + ": createInstanceImpl2 - GOING TO calculateActualParams ...");

							System.Type[] arguments_new;	
							IList<System.Type[]> arguments_new_all = new List<System.Type[]>();
							int type_count = 0;

	                        {
	                            Console.WriteLine(this_facet_instance + ": createInstanceImpl2 -- LOOP BEGIN " + id_unit);
	                            System.Type[] arguments_new_;
	                            DGAC.BackEnd.calculateActualParams(c.Arguments, arguments, acfaRef, id_unit, out arguments_new_);
	                            type_count += arguments_new_.Length;
	                            arguments_new_all.Add(arguments_new_);
	                            Console.WriteLine(this_facet_instance + ": createInstanceImpl2 -- LOOP END " + id_unit);
	                        }	

							arguments_new = new System.Type[type_count];
							int type_counter = 0;
							foreach (System.Type[] arguments_new_ in arguments_new_all)
							{
								foreach (System.Type a in arguments_new_)
								{
									arguments_new[type_counter] = a;
									type_counter++;
								}
							}					    

							
							Console.WriteLine(this_facet_instance + ": createInstanceImpl2 - GOING TO calculateGenericClassName ... {0}", arguments_new.Length);
	                        DGAC.BackEnd.calculateGenericClassName(u, arguments_new, out class_name_worker);
							Console.WriteLine(this_facet_instance + ": createInstanceImpl2 - FINISHED calculateActualParams ...");
						
						    // INSTANTIATE THE UNITS ACCROSS THE WORKERS

							Console.WriteLine(this_facet_instance + ": nodes[" + k + "]=" + nodes[k] + " / WorkerBuilder.Count = " + WorkerBuilder.Count);
							foreach (int key in WorkerBuilder.Keys) 
								Console.WriteLine(this_facet_instance + ": key=" + key);

							BuilderService worker = WorkerBuilder[nodes[k]] ;
	                        GoWorker gw = new GoWorker(worker, instanceName + "." + id_unit, class_name_worker, worker_properties);
	                        Thread t = new Thread(gw.Run);
	                        t.Start();
					    	Console.WriteLine(this_facet_instance + ": START THREAD #" + k + " in " + nodes[k]);
	                        wthreads.Add(t);
	                        go_objs.Add(t, gw);
	                        thread_node.Add(t, nodes[k]);
                            thread_unit_id.Add(t, id_unit);
	                        thread_index.Add(t, 0);
	                        node_marking[nodes[k]] = true;
                        }
                    }					

					Console.WriteLine(this_facet_instance + ": START JOIN 1");

				    foreach (int i in node_marking.Keys)
                    {
                        if (!node_marking[i])
                        {
                            Thread t = new Thread(((IWorkerObject)WorkerBuilder[i]).createInstanceNull);
                            wthreads.Add(t);
                            t.Start();
				    		Console.WriteLine(this_facet_instance + ": START NULL THREAD #" + i);
                        }

                    }
				    Console.WriteLine(this_facet_instance + ": START JOIN 2");
				
                    foreach (Thread t in wthreads)
                    {
                        t.Join();
					    
                        if (go_objs.ContainsKey(t))
                        {
                            GoWorker go_obj;
                            go_obj = go_objs[t];
							int node;
                            string unit_id;
                            int index;
							node = thread_node[t];
                            unit_id = thread_unit_id[t];
                            index = thread_index[t];
                            WorkerComponentID wcid = go_obj.WorkerCID;
                            worker_cids_list.Add(wcid);
                            cid_nodes_list.Add(node);
                            unit_ids_list.Add(unit_id);
                            indexes_list.Add(index);
							Console.WriteLine(this_facet_instance + ": JOINED CREATE INSTANCE THREAD " + node + ", " + unit_id);
                        }
						else 
							Console.WriteLine(this_facet_instance + ": JOINED CREATE INSTANCE THREAD ");		
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


            protected class GoWorker 
            {
                 private string instanceName = null; 
                 private string className = null; 
                 private TypeMap properties = null;
                 private gov.cca.ports.BuilderService worker = null;
			     private WorkerComponentID worker_cid = null;
				
                 public GoWorker(gov.cca.ports.BuilderService worker, string instanceName, string className, TypeMap properties) 
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
                         Console.WriteLine(e.Message);
                         Console.WriteLine(e.StackTrace);
                     }
                 }
			
			     public WorkerComponentID WorkerCID {
				     get 
				     {
					    return worker_cid;
				     }
			     }
            }

		private void group_colocated_units(int[] nodes_, string[] interface_ids_, ref int[] nodes, ref IList<string>[] interface_ids)
		{
			IDictionary<int,IList<string>> nodes_dict = new Dictionary<int,IList<string>>();
			for (int k = 0; k < nodes_.Length; k++)
			{
				int node = nodes_[k];
				string id_interface = interface_ids_[k];						    

				IList<string> interface_id_list;
				if (!nodes_dict.TryGetValue(node, out interface_id_list))
				{
					interface_id_list = new List<string>();
					nodes_dict[node] = interface_id_list;	
				}								

				interface_id_list.Add(id_interface);
			}
			int i=0;
			nodes = new int[nodes_dict.Count];
			interface_ids = new IList<string>[nodes_dict.Count];
			foreach (KeyValuePair<int,IList<string>> nodes_item in nodes_dict)
			{
				nodes[i] = nodes_item.Key;
				interface_ids[i] = nodes_item.Value;
				i++;
			}

			for (int j = 0; j < nodes.Length; j++)
				foreach (string interface_id in interface_ids[j])
				     Console.WriteLine ("group_colocated_units: j=" + j + " / nodes[i]=" + nodes[j] + " / interface_ids[i]=" + interface_id);
				
		}

		
				
				//just for test
				[MethodImpl(MethodImplOptions.Synchronized)]
				public void sayHi(){
					Console.WriteLine("Hi!");
				}


				/* The Worker Object of each computing node */
		        private IDictionary<int, gov.cca.AbstractFramework> worker_framework = null;
		
		        public IDictionary<int, gov.cca.AbstractFramework> WorkerFramework 
		        {
			       get {   
				           if (worker_framework == null) 
				           {
					          instantiateWorkers();
				           }
				           return worker_framework;			
			           } 
		        }


                private IDictionary<int, gov.cca.ports.BuilderService> worker_builder = null;
		
				private IDictionary<int, gov.cca.ports.BuilderService> WorkerBuilder 
		        {
			       get {   
				           if (worker_builder == null) 
				           {							  
					          this.connectToWorkerBuilders();
				           }
				           return worker_builder;			
			           } 
		        }


				private void connectToWorkerBuilders ()
				{
					worker_builder = new Dictionary<int, gov.cca.ports.BuilderService>(); // BuilderService[WorkerFramework.Length];

                    int j = 0;
				    foreach (int node in WorkerFramework.Keys)
					{
                        gov.cca.Services srv = this.frw_services.WorkerServices[j++];
	                    worker_builder[node] = (gov.cca.ports.BuilderService)srv.getPort(Constants.BUILDER_SERVICE_PORT_NAME);
	                    Console.WriteLine("connectToWorkerBuilders - node=" + node + " worker_builder[node] = " + worker_builder[node].GetHashCode());
					}
					
				}

		        private void readNodesFile(out string node_master, out int port_master, out IList<string> nodeList, out IList<int> portList)
				{
					node_master = null;
					port_master = -1;

					nodeList = new List<string>();
					portList = new List<int>();

					Console.WriteLine ("HOST FILE : " + Constants.HOSTS_FILE);

					using (TextReader tr = new StreamReader(Constants.HOSTS_FILE))
					{
						string one_line;
						if ((one_line = tr.ReadLine()) != null)
						{
							int my_port = Constants.WORKER_PORT;
							string[] s = one_line.Split(' ');                                
							if (s.Length > 1)
								my_port = System.Convert.ToInt32(s[1], 10);
							node_master = s[0];
							port_master = my_port;
						}
						while ((one_line = tr.ReadLine()) != null)
						{
							int my_port = Constants.WORKER_PORT;
							string[] s = one_line.Split(' ');                                
							if (s.Length > 1)
								my_port = System.Convert.ToInt32(s[1], 10);
							nodeList.Add(s[0]);
							portList.Add(my_port);
						}
						//node = new string[nodeList.Count];
						//port = new int[portList.Count];
						//nodeList.CopyTo(node, 0);
						//portList.CopyTo(port, 0);
					}

				}


                private string workerFails = null;
                private int failsCount = 0;

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void instantiateWorkers()
                {
					Console.WriteLine("Starting worker clients !");                  

					string node_master = null;
					IList<string> node = null;

                    try
                    {
                        /* Read nodes file, and fill the node array */

						int port_master;
						IList<int> port;

						readNodesFile(out node_master, out port_master, out node, out port);

						Console.WriteLine("READ NODE FILES - " + node.Count + "," + port.Count + "," + node_master + "," + port_master); 

						worker_framework = new Dictionary<int, gov.cca.AbstractFramework>();

						// CONNECT TO THE ROOT WORKER 
						
						try
						{   
					        worker_framework[-1] = BackEnd.getFrameworkWorkerInstanceWCF(node_master, port_master, 0);
                            Console.WriteLine("CONNECTED TO MASTER in {0} : {1} --- {2}", node_master, port_master, worker_framework[-1].GetHashCode());
						}
						catch (Exception e)
						{
							Console.Error.WriteLine("ERROR CONNECTING TO MASTER in " + node_master + ":" + port_master);
							Console.Error.WriteLine("EXCEPTION: " + e.Message);
							Console.Error.WriteLine("INNER EXCEPTION: " + e.InnerException.Message);
							failsCount++;
						} 
						finally
						{
						}

						int i = 0;
				 		// CREATE THE COMPUTATION WORKERS
                        /* Create each worker object and fill the worker array */
						
                        foreach (string n in node)
                        {
                            try
                            {
                                worker_framework[i] = BackEnd.getFrameworkWorkerInstanceWCF(n, port[i], i + 1);
						
                                Console.WriteLine("CONNECTED TO WORKER #{0} in {1} : {2} --- {3}", i, n, port[i], worker_framework.GetHashCode());
                            }
                            catch (RemotingException e)
                            {
								Console.Error.WriteLine("ERROR CONNECTING TO WORKER #" + i + " in " + n + ":" + port[i]);
								//Console.WriteLine(e.InnerException.Message);
                                failsCount++;
                            } 
							finally
							{
								i++;
							}
                        }

						
						IList<Thread> threads = new List<Thread>();
						foreach (AbstractFramework wf in WorkerFramework.Values)
						{
							IWorkerObject wfo = (IWorkerObject) wf;
							Thread t1 = new Thread(wfo.setUpCommunicationScope); 
							threads.Add(t1);
						}

						foreach (Thread t in threads) t.Start();
						foreach (Thread t in threads) t.Join();
                    }
                    catch (Exception e)
                    {
						Console.Error.WriteLine("EXCEPTION: " + e.Message);
						Console.Error.WriteLine("INNER EXCEPTION: " + e.InnerException.Message);
						Console.Error.WriteLine("STACK TRACE: " + e.StackTrace);
                    }

					Console.WriteLine(WorkerFramework.Count + " Worker clients started !");
                }

 
     
		#region ServiceRegistry implementation
		private IDictionary<string, ServiceProvider> provided_services_table = new Dictionary<string,ServiceProvider>();
		private IDictionary<string, Port> singleton_provided_port_table = new Dictionary<string,Port>();
		
		public bool addService (string serviceType, ServiceProvider portProvider)
		{
			if (!provided_services_table.ContainsKey(serviceType)) {
				provided_services_table.Add(serviceType, portProvider);
				return true;
			}
			else
				return false;
		}

		public bool addSingletonService (string serviceType, Port server)
		{
			if (!singleton_provided_port_table.ContainsKey(serviceType)) 
			{
				singleton_provided_port_table.Add(serviceType, server);
				return true;
			}
			else
				return false;
		}

		public void removeService (string serviceType)
		{			
			if (provided_services_table.ContainsKey(serviceType)) 
			{
				provided_services_table.Remove(serviceType);
			}   
			else if (singleton_provided_port_table.ContainsKey(serviceType))
			{
				singleton_provided_port_table.Remove(serviceType);
			}			
			else
				throw new CCAExceptionImpl("CCA Exception (Manager.removeService): there is another service registered for type " + serviceType);
			
		}
		
		#endregion
		

    }

        
}
