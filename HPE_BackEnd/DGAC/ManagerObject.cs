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


namespace br.ufc.pargo.hpe.backend.DGAC
{ 
	//MANAGER
    public class ManagerObject : MarshalByRefObject, gov.cca.AbstractFramework, 
	                                                 gov.cca.ports.BuilderService, 
	                                                 gov.cca.ports.ComponentRepository,
	                                                 gov.cca.Component,
													 gov.cca.Services,
													 gov.cca.ports.ServiceRegistry
    {
		    private PortUsageManager port_manager = new PortUsageManager();
		
            public ManagerObject() 
            {
                Console.Out.WriteLine("Manager Object UP !");
				instantiateWorkers();
				gov.cca.Services frw_services = getServices("manager_framework", "ManagerObject",new TypeMapImpl());
                this.setServices(frw_services);		        
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
			   
			   int[] nodes = new int[WorkerFramework.Length];
			   for (int i=0; i<nodes.Length; i++)
					nodes[i] = i;
			
			   ManagerComponentID cid = new ManagerComponentIDImpl(selfInstanceName, selfClassName, nodes);				
			   ManagerServices manager_services = new ManagerServicesImpl(this, cid);
			
			   // Register the host in the worker frameworks
			   for (int i=0; i < WorkerFramework.Length; i ++)
			   {
				    WorkerServices worker_service = (WorkerServices) WorkerFramework[i].getServices(selfInstanceName,selfInstanceName, selfProperties);
                    manager_services.registerWorkerService(i, worker_service);
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
			    for (int node=0; node < WorkerFramework.Length; node ++)
			    {
                    WorkerFramework[node].releaseServices(services_.WorkerServices[node]);
                }
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void shutdownFramework()
            {
				foreach (ManagerServices services in host_services.Values)
				{
					this.releaseServices(services);
				}
			
                foreach (WorkerObject w in WorkerFramework) 
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

			    for (int i=0; i<WorkerFramework.Length; i++)
				{
					((gov.cca.Component) WorkerFramework[i]).setServices(frw_services.WorkerServices[i]);
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
                    int id_functor_app;
                    WorkerComponentID[] worker_cids;
                    int kind;
				
				    string portName = (string) ((TypeMapImpl)properties)[Constants.PORT_NAME];

                    this.createInstanceImpl2(instanceName, 
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
				
					ManagerServices cservices = new ManagerServicesImpl(this, cid);
					int[] nodes = cid.WorkerNodes;
					for (int i=0; i<nodes.Length; i++) 
					{
						WorkerComponentID wcid = worker_cids[i];
						WorkerServices worker_services = ((WorkerObject)worker_framework[nodes[i]]).getServicesObjectOf(wcid.getInstanceName());
						cservices.registerWorkerService(nodes[i], worker_services);
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
			
          	// CALL DESTROY FOR EACH UNIT ...
            ManagerComponentID toDie_ = (ManagerComponentID)toDie;
            			
		    ManagerServices services = null;
			
			string[] usesPorts = frw_builder.getUsedPortNames(toDie);			
			string[] providesPorts = frw_builder.getProvidedPortNames(toDie);
			
			if (usesPorts.Length > 0 || providesPorts.Length > 0)
			{
				Console.WriteLine("The component must unregister its uses ports " +
												   "and remove provides ports before destruction.");
				throw new CCAExceptionImpl(CCAExceptionType.Unexpected);				
			}
						
            foreach (int node in toDie_.WorkerNodes)
            {
                 gov.cca.ports.BuilderService builder = this.WorkerBuilder[node];
                 WorkerComponentID wcid = toDie_.getWorkerComponentID(node);
                 builder.destroyInstance(wcid, timeout);
            }
		
		    this.componentIDs.Remove(toDie.getInstanceName());
			this.component_services.Remove(toDie.getInstanceName());
			if (host_services.ContainsKey(toDie.getInstanceName()))
				host_services.Remove(toDie.getInstanceName());
		    this.componentProperties.Remove(toDie.getInstanceName());
			
        }
		
		
		
		    // OK.
            [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getProvidedPortNames(ComponentID cid)
            {
			    IDictionary<string, int[]> ports = this.getProvidedPorts(cid);
			
			    string[] return_ports = new string[ports.Count];
			    ports.Keys.CopyTo(return_ports, 0);
                return return_ports;
		    }
		
		    // OK
            public IDictionary<string, int[]> getProvidedPorts(ComponentID cid)
            {
			    IDictionary<string, IList<int>> ports = new Dictionary<string,IList<int>>();
			    ManagerComponentID cid_ = (ManagerComponentID)cid;
                
                 int[] nodeList = cid_.WorkerNodes;
			    for (int i=0; i<nodeList.Length; i++)
                // foreach (KeyValuePair<WorkerComponentID, int> pair in list)
                //foreach (int node in list)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(i);
                    gov.cca.ports.BuilderService builder = this.WorkerBuilder[nodeList[i]];
                    string[] portNames = builder.getProvidedPortNames(wcid);
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
                        node_indexes.Add(nodeList[i]);
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
		
		    // OK
		    [MethodImpl(MethodImplOptions.Synchronized)]
            public string[] getUsedPortNames(ComponentID cid)
            {
			    IDictionary<string, int[]> ports = this.getUsedPorts(cid);
			    string[] return_ports = new string[ports.Count];
				ports.Keys.CopyTo(return_ports, 0);
                return return_ports;
            }
		
		    // OK
            public IDictionary<string, int[]> getUsedPorts(ComponentID cid)
            {
                IDictionary<string, IList<int>> ports = new Dictionary<string, IList<int>>();
                ManagerComponentID cid_ = (ManagerComponentID)cid;
                int[] nodeList = cid_.WorkerNodes;
			    for (int i=0; i<nodeList.Length; i++)
                //foreach (int node in nodes)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(nodeList[i]);
                    gov.cca.ports.BuilderService builder = WorkerBuilder[nodeList[i]];
                    string[] portNames = builder.getUsedPortNames(wcid);
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
                        node_indexes.Add(nodeList[i]);
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
		
		    // OK
		    [MethodImpl(MethodImplOptions.Synchronized)]
            public TypeMap getPortProperties(ComponentID cid, string portName)
            {
                HPETypeMap result = new TypeMapImpl();

                ManagerComponentID cid_ = (ManagerComponentID)cid;
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(node);
                    gov.cca.ports.BuilderService builder = this.WorkerBuilder[node];
                    HPETypeMap properties = (HPETypeMap) builder.getPortProperties(wcid, portName);
                    
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
		
			// OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setPortProperties(ComponentID cid, string portName, TypeMap map)
            {
                ManagerComponentID cid_ = (ManagerComponentID)cid;
                int[] list = cid_.WorkerNodes;
                foreach (int node in list)
                {
                    WorkerComponentID wcid = cid_.getWorkerComponentID(node);
                    gov.cca.ports.BuilderService builder = this.WorkerBuilder[node];
                    builder.setPortProperties(cid, portName, map);
                }
            }
		
			
            [MethodImpl(MethodImplOptions.Synchronized)]
            public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName)
            {
				
				string usingPortNameQ = user.getInstanceName() + ":" + usingPortName;
				string providingPortNameQ = provider.getInstanceName() + ":" + providingPortName;
									
				Console.WriteLine("CONNECT " + usingPortNameQ + " to " + providingPortNameQ);
			
				ConnectionID connection = null;
			
			    if (this.host_services.ContainsKey(user.getInstanceName()))
			    {
					Console.WriteLine("BEGIN CONNECT_H2C ");
				    connection = connect_h2c(user,usingPortName, usingPortNameQ, provider,providingPortName, providingPortNameQ);
					Console.WriteLine("END CONNECT_H2C ");
			    }
			    else
			    {
					string usingPortNameQ1 = user.getInstanceName() + ":" + usingPortName;
					string providingPortNameQ1 = provider.getInstanceName() + ":" + providingPortName;
			    	connection = connect_c2c(user, usingPortName, usingPortNameQ1, provider, providingPortName, providingPortNameQ1);
			    }
			    
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
		                                      string usingPortNameQ, 
		                                      ComponentID provider, 
		                                      string providingPortName,
		                                      string providingPortNameQ
		                                  )
			{		
				ManagerComponentID mcid_provider = (ManagerComponentID) provider;
		        ManagerComponentID mcid_user = (ManagerComponentID) user;
		
    			int[] nodes = mcid_provider.WorkerNodes; // all workers must participates.
			
		        WorkerConnectionID[] worker_connection = new WorkerConnectionID[nodes.Length];
		
		        for (int i=0; i<nodes.Length; i++)
				{
				   gov.cca.ports.BuilderService wb = worker_builder[nodes[i]];
				   WorkerComponentID pcid = (WorkerComponentID) mcid_provider.getWorkerComponentID(nodes[i]);
			       WorkerComponentID ucid = (WorkerComponentID) mcid_user.getWorkerComponentID(nodes[i]);
				Console.WriteLine("BEGIN 4 connect_h2c LOOP " + i + ", " + (ucid==null) + ", " + (pcid==null) + "," + mcid_user.getInstanceName() + ", " + mcid_provider.getInstanceName());
				   worker_connection[i] = (WorkerConnectionID) wb.connect(ucid, usingPortName, pcid, providingPortName);							   
				Console.WriteLine("END connect_h2c LOOP " + i);
				}
		
				ConnectionID connection = null;
                connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName, nodes, worker_connection);
                				
		 		return connection;
			
			}
		
			private ConnectionID connect_c2c (ComponentID user, 
		                                      string usingPortName, 
		                                  	  string usingPortNameQ,
		                                      ComponentID provider, 
		                                      string providingPortName,
		                                      string providingPortNameQ)
			{
				Console.WriteLine("connect_c2c -3");
                ManagerComponentID user_ = (ManagerComponentID)user;
                ManagerComponentID provider_ = (ManagerComponentID)provider;

			Console.WriteLine("connect_c2c -2 " + (user_ == null));
                IDictionary<string, int[]> used_ports = this.getUsedPorts(user_);

                int[] nodes;
                used_ports.TryGetValue(usingPortNameQ, out nodes);
				Console.WriteLine("connect_c2c -1");
			
				WorkerConnectionID[] worker_connection = new WorkerConnectionID[nodes.Length];	
			
				Console.WriteLine("connect_c2c 0");

                //foreach (int node in nodes)
				for (int i=0; i<nodes.Length; i++)
                {
	                WorkerComponentID cid_user = user_.getWorkerComponentID(nodes[i]); 
					Console.WriteLine("start connect_c2c 0 loop user node " + nodes[i] + " - " + (cid_user==null));
					WorkerComponentID cid_prov = provider_.getWorkerComponentID(nodes[i]); 
					Console.WriteLine("start connect_c2c 0 loop provide  node " + nodes[i] + " - "+ (cid_prov==null));
					worker_connection[i] = (WorkerConnectionID) WorkerBuilder[nodes[i]].connect(cid_user, usingPortName, cid_prov, providingPortName);
					Console.WriteLine("end connect_c2c 0 loop node " + node);
                }

				Console.WriteLine("connect_c2c 1");
			
				ConnectionID connection = null;
                connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName, nodes, worker_connection);
				Console.WriteLine("connect_c2c 2");
                
                return connection;
			}            
            
		
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
			
				Console.WriteLine ("DISCONNECTING 1 " + usesPortName + " <- " + providesPortName);
		
				if (!port_manager.isReleased(usesPortName))
				{
					throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
				}
			
				Console.WriteLine ("DISCONNECTING 2 " + usesPortName + " <- " + providesPortName);

				if (!connectionList.Contains(connID))
				{
					throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
				}

			
				Console.WriteLine ("DISCONNECTING 3 " + usesPortName + " <- " + providesPortName);

				ManagerComponentID cid_provider = (ManagerComponentID) connID.getProvider();
				
				int[] nodes = cid_provider.WorkerNodes;
				for (int i=0; i < nodes.Length; i++) 
				{
					WorkerConnectionID conn_id = ((ManagerConnectionID)connID).getWorkerConnectionID (i);
					Console.WriteLine ("DISCONNECTING 3.1 i=" + i + " - nodes[i]=" + nodes[i] + " conn_id is null ? " + (conn_id == null));

					if (conn_id != null)
					try 
					{
						this.WorkerBuilder[nodes[i]].disconnect(conn_id, timeout);     
					}
					catch (CCAExceptionImpl e) 
					{
						Console.WriteLine ("DISCONNECTING 3.2 - EXCEPTION: " + e.getCCAExceptionType());
					}
				}
	
			
			Console.WriteLine ("DISCONNECTING 4 " + usesPortName + " <- " + providesPortName);

	            connectionList.Remove(connID);
	            connByUserPortName.Remove(usesPortName);
	            connByProviderPortName.Remove(providesPortName);

			
			Console.WriteLine ("DISCONNECTING 5 " + usesPortName + " <- " + providesPortName);


	            if (connectionProperties.ContainsKey(connID))
	                connectionProperties.Remove(connID);
			
			Console.WriteLine ("DISCONNECTING 6 " + usesPortName + " <- " + providesPortName);

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
                        gov.cca.ports.BuilderService builder = WorkerBuilder[node];
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
			    
				for (int i=0; i<nodes.Length; i++)
				{
					WorkerConnectionID wconn = ((ManagerConnectionIDImpl)conn).getWorkerConnectionID(i);
				    WorkerServices ws_ = ws[nodes[i]];
					ports[i] = ws_.getPortNonblocking(wconn.getUserPortName());
				}		
			    			
			    //string user_port_name = conn.getUserPortName();
			    gov.cca.Port port = null;
			
				/* TODO: It is still necessary to implement a general mechanism
				 * for connecting to applications, where an application may provide
				 * arbitrary ports for the host and vice-versa
				 */
				if (user_port_name.EndsWith(":" + Constants.GO_PORT_NAME))
				{
					port = new GoPortImpl(ms, ports);
			    } 
				else if (user_port_name.EndsWith(":" + Constants.INITIALIZE_PORT_NAME))
				{
					port = new InitializePortImpl(ms, ports);
				}
				else if (user_port_name.EndsWith(":" + Constants.RECONFIGURE_PORT_NAME))
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
				return (ManagerServices) component_services[cid.getInstanceName()];
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
                    nodes = new int[WorkerFramework.Length];
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
									  out int[] unit_indexes,
		                              out IList<Interface> iList, 
		                              out int[] nodes)
			{
					nodes = unit_mapping;

				    interface_ids = new string[nodes.Length];
				    unit_indexes = new int[nodes.Length];
				
                    iList = BackEnd.idao.list(acfaRef.Id_abstract);
				    if (iList.Count == 1) // SPMD
				    {
					    for (int i = 0; i < nodes.Length; i++) {
						    interface_ids[i] = iList[0].Id_interface;
						    unit_indexes[i] = 0;
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
									  out int[] unit_indexes,
		                              out IList<Interface> iList, 
									  out int[] nodes)
			{
				Console.WriteLine("BEGIN resolve_topology");

				interface_ids = null;
				unit_indexes = null;
				iList = null;
				nodes = null;

				
			Console.WriteLine("resolve_topology 1 " + (unit_mapping == null) + ", length="+ (unit_mapping.Length));

				int count_nodes;
				IDictionary<string,int[]> unit_mapping_dict;
				BackEnd.copy_unit_mapping_to_dictionary(unit_mapping, out unit_mapping_dict, out count_nodes);

				Console.WriteLine("resolve_topology 2 - count_nodes=" + count_nodes);

				interface_ids = new string[count_nodes];
				unit_indexes = new int[count_nodes];
				nodes = new int[count_nodes];

                iList = BackEnd.idao.list(acfaRef.Id_abstract);

				Console.WriteLine("resolve_topology 3 - " + acfaRef.Id_abstract);

				int i = 0;
				foreach (Interface unit in iList)
				{
					int[] node_list;
					Console.WriteLine("resolve_topology - retrieving " + unit.Id_interface + unit.Unit_replica + "..." + unit_mapping.Length);
					foreach (KeyValuePair<string,int[]> ttt in unit_mapping_dict)
						Console.WriteLine("unit_mapping_dict - key="+ttt.Key);
					unit_mapping_dict.TryGetValue(unit.Id_interface_super_top + unit.Unit_replica_super_top, out node_list);
				    Console.WriteLine (node_list == null);
					foreach (int node in node_list)
					{
						Console.WriteLine("unit " + unit.Id_interface + "[" + unit.Unit_replica + "] at node " + node);
						interface_ids[i] = unit.Id_interface;
						unit_indexes[i] = unit.Unit_replica;
						nodes[i] = node;
						i++;
					}
				}

				Console.WriteLine("resolve_topology 4");

				// ASSERT {i == count_nodes}

				Console.WriteLine("END resolve_topology");
			}

			public void resolve_topology_obsolete (DGAC.database.AbstractComponentFunctorApplication acfaRef, 
		                              string[] unit_ids, int[] partition_indexes,
		                              IList<Interface> iList, 
		                              int[] node_list)
		{
			int id_functor_app = acfaRef.Id_functor_app;
				
		    IDictionary<string, int> actualParameters_new;
		    DGAC.BackEnd.determineArguments(new Dictionary<string, int>(),
		                                           id_functor_app,
		                                           out actualParameters_new);
		    
		    InnerComponent ic = BackEnd.icdao.retrieve(acfaRef.Id_abstract,"topology");
		
		    AbstractComponentFunctorApplication acfaRefTopology = BackEnd.acfadao.retrieve(ic.Id_functor_app);
		
		    br.ufc.pargo.hpe.backend.DGAC.database.Component c_topology = DGAC.BackEnd.resolveUnit(acfaRefTopology,actualParameters_new,actualParameters_new);
			AbstractComponentFunctor acf_topology = DGAC.BackEnd.acfdao.retrieve(c_topology.Id_abstract);
		
		    Unit u_topology = BackEnd.udao.retrieve(c_topology.Id_concrete, 1);
		    string class_name = null;   
		    
			string id_interface = u_topology.Id_interface;
			
		    Interface i_topology = BackEnd.idao.retrieveSuper(c_topology.Id_abstract, id_interface, u_topology.Unit_replica);
            System.Type[] actualParams = DGAC.BackEnd.calculateActualClassParameteres(i_topology, acfaRefTopology.Id_functor_app, actualParameters_new);
		
		    DGAC.BackEnd.calculateGenericClassName(u_topology, actualParams, out class_name);
		
		    string assembly_string = u_topology.Assembly_string;					
		    
		    ObjectHandle obj = Activator.CreateInstance(assembly_string, class_name);
            hpe.kinds.ITopologyKind unit_topology = (hpe.kinds.ITopologyKind) obj.Unwrap();
		   // unit_topology.Id_unit = u_topology.Id_unit;
		    
		    unit_topology.PartitionCount = acf_topology.getPartitionCount(id_interface);
					
			int k = 0;
			foreach (int node in node_list)
			{
				unit_topology.Rank = node;
				int partition_index = unit_topology.PartitionIndex;
				Slice s_topology = DGAC.BackEnd.sdao.retrieve(acf_topology.Id_abstract,"topology",0,"topology",partition_index);
				unit_ids[k] = s_topology.Id_interface;
				partition_indexes[k] = partition_index;				
				k++;
			}
			
			
			throw new NotImplementedException ();
		}

		public string[] calculatePortNames (int id_abstract, string id_interface, int partition_index)
		{
            IList<Slice> sList = BackEnd.sdao.listByInterface(id_abstract, id_interface, partition_index);
			IList<string> portNameList = new List<string>();
            foreach (Slice slice in sList)
            {
			   InnerComponent ic = BackEnd.icdao.retrieve(slice.Id_abstract, slice.Id_inner);
			   AbstractComponentFunctor acf_inner = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);
				
			   int slice_kind_inner = Constants.kindMapping[acf_inner.Kind];
               
               if (slice_kind_inner != Constants.KIND_QUALIFIER) {		
			   	   portNameList.Add(slice.Id_inner);
			   }
            }
			
			string[] portNameArray = new string[portNameList.Count];
			portNameList.CopyTo(portNameArray,0);
			
			return portNameArray;
		}

        [MethodImpl(MethodImplOptions.Synchronized)]
        public int[] createInstanceImpl2(
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
                IList<int> cid_nodes_list = new List<int>();
                IList<string> unit_ids_list = new List<string>();
                IList<int> indexes_list = new List<int>();
                IList<WorkerComponentID> worker_cids_list = new List<WorkerComponentID>();

                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();

                    Console.WriteLine("createInstance manager");

				    id_functor_app = (int) properties[Constants.ID_FUNCTOR_APP];
					IDictionary<string,int> arguments = (IDictionary<string,int>) properties[Constants.ENCLOSING_ARGUMENTS];
				
				    DGAC.database.Component c = BackEnd.cdao.retrieve_libraryPath(componentName);
					kind = Constants.kindMapping[c.Kind];
				
					AbstractComponentFunctorApplication acfaRef = BackEnd.acfadao.retrieve(id_functor_app);

					//int[] nodes = properties.getIntArray(Constants.NODES_KEY, new int[] {});
				    string[] interface_ids;
				    int[] unit_indexes;
                    IList<Interface> iList;
					int[] nodes;

					object unit_mapping = properties[Constants.NODES_KEY];
					if (unit_mapping is int[])
					{
						// Simple SPMD case - obsolete
						resolve_topology(acfaRef,  
										 (int[]) unit_mapping,
										 out interface_ids, 
										 out unit_indexes, 
										 out iList, 
										 out nodes);
					} 
					else
					{
						// MPMD case, also covering SPMD.
						resolve_topology(acfaRef,  
										 (Instantiator.UnitMappingType[]) unit_mapping,
										 out interface_ids, 
										 out unit_indexes, 
										 out iList, 
										 out nodes);
					}
				

                    Connector.commitTransaction();

                    bool[] node_marking = new bool[WorkerFramework.Length];
                    for (int i = 0; i < node_marking.Length; i++) node_marking[i] = false; 
                    
                    IDictionary<Thread, GoWorker> go_objs = new Dictionary<Thread, GoWorker>();
                    IDictionary<Thread, int> thread_node = new Dictionary<Thread, int>();
                    IDictionary<Thread, string> thread_unit_id = new Dictionary<Thread, string>();
                    IDictionary<Thread, int> thread_index = new Dictionary<Thread, int>();

                    IList<Thread> wthreads = new List<Thread>();
				
				    for (int k = 0; k < nodes.Length; k++)
                    {                        
				        string id_interface = interface_ids[k];
					    int partition_index = unit_indexes[k];

					    DGAC.database.Unit u = DGAC.BackEnd.takeUnit(c, id_interface, partition_index);
						AbstractComponentFunctor acf = DGAC.BackEnd.acfdao.retrieve(c.Id_abstract);
					
				        // SETUP PROPERTIES
                        TypeMapImpl worker_properties = new TypeMapImpl(properties);
                        worker_properties[Constants.KEY_KEY] = k;
                        worker_properties[Constants.COMPONENT_KEY] = acf.Library_path;
                        worker_properties[Constants.UNIT_KEY] = id_interface ;
 					    worker_properties[Constants.ASSEMBLY_STRING_KEY] = u.Assembly_string;
					    worker_properties[Constants.PORT_NAMES_KEY] = calculatePortNames(c.Id_abstract, id_interface, partition_index);
						worker_properties[Constants.KIND_KEY] = c.Kind;
					
                        string class_name_worker;
                        
                        System.Type[] arguments_new;
					Console.WriteLine("createInstanceImpl2 - GOING TO calculateActualParams ...");
                        DGAC.BackEnd.calculateActualParams(arguments, acfaRef, id_interface, partition_index, out arguments_new);
					Console.WriteLine("createInstanceImpl2 - GOING TO calculateGenericClassName ...");
                        DGAC.BackEnd.calculateGenericClassName(u, arguments_new, out class_name_worker);
					Console.WriteLine("createInstanceImpl2 - FINISHED calculateActualParams ...");
					
					    // INSTANTIATE THE UNITS ACCROSS THE WORKERS
                        GoWorker gw = new GoWorker(WorkerBuilder[nodes[k]], instanceName /*+ "." + id_interface*/, class_name_worker, worker_properties);
                        Thread t = new Thread(gw.Run);
                        t.Start();
				    Console.WriteLine("START THREAD #" + k + " in " + nodes[k]);
                        wthreads.Add(t);
                        go_objs.Add(t, gw);
                        thread_node.Add(t, nodes[k]);
                        thread_unit_id.Add(t, id_interface);
                        thread_index.Add(t, 0);
                        node_marking[nodes[k]] = true;
                    }
				
                    for (int i = 0; i < node_marking.Length; i++)
                    {
                        if (!node_marking[i])
                        {
                            Thread t = new Thread(((WorkerObject)WorkerBuilder[i]).createInstance);
                            wthreads.Add(t);
                            t.Start();
				    		Console.WriteLine("START NULL THREAD #" + i);
                        }

                    }
				    Console.WriteLine("START JOIN");
				
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
							Console.WriteLine("JOINED CREATE INSTANCE THREAD " + node + ", " + unit_id);
                        }
						else Console.WriteLine("JOINED CREATE INSTANCE THREAD ");		
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
		
/*            [MethodImpl(MethodImplOptions.Synchronized)]
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

                    Console.WriteLine("createInstance manager");

                    FileInfo file = FileUtil.writeToFile(instanceName + ".xml", instantiator_string);
                    ComponentFunctorApplicationType instantiator = LoaderApp.DeserializeInstantiator(file.FullName);
                    
                    int[] nodes = instantiator.node;
				
                    DGAC.database.AbstractComponentFunctorApplication acfaRef = DGAC.BackEnd.loadACFAFromInstantiator(instantiator);
                    id_functor_app = acfaRef.Id_functor_app;
				
				    // RUN THE RESOLUTION PROCEDURE		
                    DGAC.database.Component c = DGAC.BackEnd.resolveUnit(acfaRef);
                    kind = Constants.kindMapping[c.Kind];

				    string[] interface_ids = new string[nodes.Length];
				    int[] partition_indexes = new int[nodes.Length];
				
                    IList<Interface> iList = BackEnd.idao.list(c.Id_abstract);
				    if (iList.Count == 1) // SPMD
				    {
					    for (int i = 0; i < nodes.Length; i++) {
						    interface_ids[i] = iList[0].Id_interface;
						    partition_indexes[i] = 0;
					    }
				    }
				    else //MPMD
				    {
					    resolve_topology(acfaRef, interface_ids, partition_indexes, iList, nodes);
			    	}

                    Connector.commitTransaction();

                    bool[] node_marking = new bool[WorkerFramework.Length];
                    for (int i = 0; i < node_marking.Length; i++) node_marking[i] = false; 
                    
                    IDictionary<Thread, GoWorker> go_objs = new Dictionary<Thread, GoWorker>();
                    IDictionary<Thread, int> thread_node = new Dictionary<Thread, int>();
                    IDictionary<Thread, string> thread_unit_id = new Dictionary<Thread, string>();
                    IDictionary<Thread, int> thread_index = new Dictionary<Thread, int>();

                    IList<Thread> wthreads = new List<Thread>();
				
				    for (int k = 0; k < nodes.Length; k++)
                    {                        
				        string id_interface = interface_ids[k];
					    int partition_index = partition_indexes[k];

					    DGAC.database.Unit u = DGAC.BackEnd.takeUnit(c, id_interface, partition_index);
					
				        // SETUP PROPERTIES
                        TypeMapImpl worker_properties = new TypeMapImpl(properties);
                        worker_properties[Constants.KEY_KEY] = k;
                        worker_properties[Constants.COMPONENT_KEY] = c.Library_path;
                        worker_properties[Constants.UNIT_KEY] = id_interface ;
                        worker_properties[Constants.ID_FUNCTOR_APP] = acfaRef.Id_functor_app;
					
                        string class_name_worker;
                        
                        System.Type[] actualParams;
                        DGAC.BackEnd.calculateActualParams(acfaRef, id_interface, partition_index, out actualParams);
                        DGAC.BackEnd.calculateGenericClassName(u, actualParams, out class_name_worker);
					
					    // INSTANTIATE THE UNITS ACCROSS THE WORKERS
                        GoWorker gw = new GoWorker(WorkerBuilder[nodes[k]], instanceName , class_name_worker, worker_properties);
                        Thread t = new Thread(gw.Run);
                        t.Start();
				    Console.WriteLine("START THREAD #" + k + " in " + nodes[k]);
                        wthreads.Add(t);
                        go_objs.Add(t, gw);
                        thread_node.Add(t, nodes[k]);
                        thread_unit_id.Add(t, id_interface);
                        thread_index.Add(t, 0);
                        node_marking[nodes[k]] = true;
                    }
				
                    for (int i = 0; i < node_marking.Length; i++)
                    {
                        if (!node_marking[i])
                        {
                            Thread t = new Thread(((WorkerObject)WorkerBuilder[i]).createInstance);
                            wthreads.Add(t);
                            t.Start();
				    Console.WriteLine("START NULL THREAD #" + i);
                        }

                    }
				    Console.WriteLine("START JOIN");
				
                    foreach (Thread t in wthreads)
                    {
                        t.Join();
					    Console.WriteLine("JOINED CREATE INSTANCE THREAD ");
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


*/		


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

		
				
				//just for test
				[MethodImpl(MethodImplOptions.Synchronized)]
				public void sayHi(){
					Console.WriteLine("Hi!");
				}

                /* The Worker Object of each computing node */
                private gov.cca.AbstractFramework[] worker_framework = null;
		
		        public gov.cca.AbstractFramework[] WorkerFramework 
		        {
			       get {   
				           if (worker_framework == null) 
				           {
					          instantiateWorkers();
				           }
				           return worker_framework;			
			           } 
		        }
		
                private gov.cca.ports.BuilderService[] worker_builder = null;
		
		        private gov.cca.ports.BuilderService[] WorkerBuilder 
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
					worker_builder = new BuilderService[WorkerFramework.Length];
			
				    for (int node=0; node < WorkerFramework.Length; node++)
					{
						//worker_builder[node] = (gov.cca.ports.BuilderService) worker_framework[node];
				
				        gov.cca.Services srv = this.frw_services.WorkerServices[node]; //.getServices("Manager", "ManagerObject", new TypeMapImpl());
				        //srv.registerUsesPort(Constants.BUILDER_SERVICE_PORT_NAME, Constants.BUILDER_SERVICE_PORT_TYPE, new TypeMapImpl());
				        worker_builder[node] = (gov.cca.ports.BuilderService) srv.getPort(Constants.BUILDER_SERVICE_PORT_NAME);				          				          
					}
					
				}
		
                private string[] node = null;
                private int[] port = null;

               // private TcpChannel tcpChannel = null;

                private string workerFails = null;
                private int failsCount = 0;

                [MethodImpl(MethodImplOptions.Synchronized)]
                public string[] instantiateWorkers()
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
                            }
                            node = new string[nodeList.Count];
                            port = new int[portList.Count];
                            nodeList.CopyTo(node, 0);
                            portList.CopyTo(port, 0);
                        }
                        

                        worker_framework = new gov.cca.AbstractFramework[node.Length];
				
                        int i = 0;
                        /* Create each worker object and fill the worker array */
                        foreach (string n in node)
                        {
                            try
                            {   
                                worker_framework[i] = BackEnd.getFrameworkWorkerInstance(n, port[i], i);
						
                                Console.WriteLine("CONNECTED TO WORKER #" + i + " in " + n + ":" + port[i]);
                            }
                            catch (Exception e)
                            {
								Console.WriteLine("ERROR CONNECTING TO WORKER #" + i + " in " + n + ":" + port[i]);
                                failsCount++;
								
//                                workerFails = (e.Message == null ? "NULL" : e.Message) + "  ---  "; // + e.InnerException.Message == null ? "NULL" : e.InnerException.Message;
                              //  Console.WriteLine("ERROR CONNECTING TO WORKER " + n + ". Exception : " + e.Message + ", STACK: " + e.StackTrace + ", INNER EXCEPTION: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));								
                            } 
							finally
							{
								i++;
							}
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine("EXCEPTION: " + e.Message);
                        Console.WriteLine("INNER EXCEPTION: " + e.InnerException.Message);
                        Console.WriteLine("STACK TRACE: " + e.StackTrace);
                    }

                    Console.WriteLine(WorkerFramework.Length + " Worker clients started !");
			
					return node;
                }

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void stopWorkerClients()
                {
                 //   TcpChannel ch = tcpChannel;
                 //   ch.StopListening(null);
                 //   ChannelServices.UnregisterChannel(ch);
                }


/*                [MethodImpl(MethodImplOptions.Synchronized)]
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
				       
                        RunApplicationThread thread = new RunApplicationThread(node, (WorkerObject)WorkerFramework[node], session_id_string, mcid, rounds);
                        Thread t = new Thread(thread.Run);
                        thread_list.Add(t,thread);
                        t.Start();
                    }
                    foreach (KeyValuePair<Thread,RunApplicationThread> t in thread_list)
                    {
                        try 
                        {
                           t.Key.Join();
                           Console.WriteLine("Worker thread arrived : " + session_id_string);
                           outputs[t.Value.Node] = t.Value.Output;
                        } 
                        catch (Exception e)
                        {
                           Console.WriteLine("Worker failed : " + session_id_string + ". error =" + e.Message);
                        }
                    }
                    Console.WriteLine("Joined Threads : " + session_id_string);
                    
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
		 */
				#region DEPLOYER
		
		
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
		
			#endregion
     
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
