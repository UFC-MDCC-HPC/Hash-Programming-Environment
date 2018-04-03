

//Remoting!
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Threading;
using br.ufc.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using gov.cca;
using gov.cca.ports;


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
				instantiateWorker();
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
			   ManagerComponentID cid = new ManagerComponentIDImpl(selfInstanceName, selfClassName);				
			   ManagerServices manager_services = new ManagerServicesImpl(this, cid);

			   // Register the host in the worker frameworks
			   manager_services.WorkerServices  = (WorkerServices) WorkerFramework.getServices(selfInstanceName,selfInstanceName, selfProperties);

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

			    WorkerFramework.releaseServices(services_.WorkerServices);
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void shutdownFramework()
            {
				foreach (ManagerServices services in host_services.Values)
				{
					this.releaseServices(services);
				}
			
				WorkerFramework.shutdownFramework ();				
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

			    ((gov.cca.Component) WorkerFramework).setServices(frw_services.WorkerServices);


			}
		#endregion


		#region BuilderService Members


			[MethodImpl(MethodImplOptions.Synchronized)]
            public ComponentID createInstance(string instanceName, string className, TypeMap properties)
            {
                ManagerComponentID cid = null;
                try
                {
                    IList<string>[] unit_ids;
                    int[] indexes;
                    int[] cid_nodes;
				    int id_functor_app = default(int);
					WorkerComponentID worker_cid = null;
				    int kind = default(int);

				    string portName = (string)((TypeMapImpl)properties)[Constants.PORT_NAME];
				    bool ignore = (bool) properties.getBool(Constants.IGNORE,false);
 

					if (!ignore)
					{
                      
						this.createInstanceImpl(instanceName, 
					                            className,
					                            (TypeMapImpl)properties, 
					                            out unit_ids, 
					                            out id_functor_app, 
					                            out kind,
					                            out worker_cid);
				
	                    cid = new ManagerComponentIDImpl(instanceName, 
					                                 	 className,
					                                     unit_ids, 
					                                     id_functor_app,
					                                     kind, 
					                                 	 portName);

                        ManagerServices cservices = new ManagerServicesImpl(this, cid);
                    	cservices.WorkerServices = new WorkerServicesImpl((IWorkerObject)WorkerFramework, worker_cid);
						this.registerComponent(cid, cservices, properties);
				    }   
					else 
				    {  
                        id_functor_app = properties.getInt(Constants.ID_FUNCTOR_APP, 0);
                        kind = properties.getInt(Constants.COMPONENT_KIND, 0);

						cid = new ManagerIgnoredComponentIDImpl (instanceName, className, id_functor_app, kind, portName);

						ManagerServices cservices = new ManagerServicesImpl(this, cid);
						this.registerComponent(cid, cservices, properties);

    					Console.WriteLine("CREATE INSTANCE --- Ignoring " + instanceName);
				    }	
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

             WorkerComponentID wcid = toDie_.WorkerComponentID;
			 WorkerBuilder.destroyInstance(wcid, timeout);
		
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
			    IDictionary<string, int[]> ports = this.getProvidedPorts(cid);
			Console.WriteLine ("getProvidedPortNames #2");
			    string[] return_ports = new string[ports.Count];
			Console.WriteLine ("getProvidedPortNames #3");
			    ports.Keys.CopyTo(return_ports, 0);
			Console.WriteLine ("getProvidedPortNames #4");
                return return_ports;
		    }
	


		    // OK
            public IDictionary<string, int[]> getProvidedPorts(ComponentID cid)
            {
			    IDictionary<string, IList<int>> ports = new Dictionary<string,IList<int>>();
			    ManagerComponentID cid_ = (ManagerComponentID)cid;
                
                WorkerComponentID wcid = cid_.WorkerComponentID;
                gov.cca.ports.BuilderService builder = this.WorkerBuilder;
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
                    node_indexes.Add(0);
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
			Console.WriteLine ("getUsedPortNames #1");
			    IDictionary<string, int[]> ports = this.getUsedPorts(cid);
			Console.WriteLine ("getUsedPortNames #2");
			    string[] return_ports = new string[ports.Count];
			Console.WriteLine ("getUsedPortNames #3");
				ports.Keys.CopyTo(return_ports, 0);
			Console.WriteLine ("getUsedPortNames #4 " + (return_ports == null));
                return return_ports;
            }
		
		    // OK
            public IDictionary<string, int[]> getUsedPorts(ComponentID cid)
            {
                IDictionary<string, IList<int>> ports = new Dictionary<string, IList<int>>();
                ManagerComponentID cid_ = (ManagerComponentID)cid;

				WorkerComponentID wcid = cid_.WorkerComponentID;

            Console.WriteLine("getUsedPorts {0} {1}", cid == null, wcid == null);

                gov.cca.ports.BuilderService builder = WorkerBuilder;
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
                    node_indexes.Add(0);
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
 
				WorkerComponentID wcid = cid_.WorkerComponentID;
                gov.cca.ports.BuilderService builder = this.WorkerBuilder;
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
                    o.Add(0, value);                      

                }
 
                return result;
            }
		
			// OK
            [MethodImpl(MethodImplOptions.Synchronized)]
            public void setPortProperties(ComponentID cid, string portName, TypeMap map)
            {
                ManagerComponentID cid_ = (ManagerComponentID)cid;

				WorkerComponentID wcid = cid_.WorkerComponentID;
                gov.cca.ports.BuilderService builder = this.WorkerBuilder;
                builder.setPortProperties(cid, portName, map);
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
		
		 		ConnectionID connection = null;

				if (!(mcid_provider is ManagerIgnoredComponentID))
				{				
				    gov.cca.ports.BuilderService wb = WorkerBuilder;
				    WorkerComponentID pcid = (WorkerComponentID) mcid_provider.WorkerComponentID;
			        WorkerComponentID ucid = (WorkerComponentID) mcid_user.WorkerComponentID;
					WorkerConnectionID worker_connection = (WorkerConnectionID) wb.connect(ucid, usingPortName, pcid, providingPortName);							   

					connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName, worker_connection);
				}
				else
				{
                	connection = new ManagerConnectionIDImpl(provider, providingPortName, user, usingPortName);
					Console.WriteLine ("connect_h2c -- IGNORE CONNECTION -- " + provider.getInstanceName ());
				}
                				
		 		return connection;
			
			}
		
			private ConnectionID connect_c2c (ComponentID user, 
		                                      string usingPortName, 
		                                  	  string usingPortNameQ,
		                                      ComponentID provider, 
		                                      string providingPortName,
		                                      string providingPortNameQ)
			{
				ConnectionID connection = null;

                Console.WriteLine("connect_c2c -3 " + (user == null));
                ManagerComponentID user_ = (ManagerComponentID)user;
                ManagerComponentID provider_ = (ManagerComponentID)provider;

				if (!(user is ManagerIgnoredComponentID) && !(provider is ManagerIgnoredComponentID))
				{
		            IDictionary<string, int[]> used_ports = this.getUsedPorts(user_);

	                int[] user_nodes;
	                used_ports.TryGetValue(usingPortNameQ, out user_nodes);

					Console.WriteLine("connect_c2c -2.1 " + (usingPortNameQ) + ", " + (user_nodes==null) + ", used_ports.Count=" + used_ports.Count);
					foreach (string k in used_ports.Keys)
						Console.WriteLine ("-------------------- " + k);
				
				    IDictionary<int,int> user_nodes_inv = new Dictionary<int,int> ();
					for (int i=0; i<user_nodes.Length; i++)
					    user_nodes_inv.Add (user_nodes [i], i);

				    Console.WriteLine("connect_c2c -2.2 ");

					Console.WriteLine("connect_c2c -1");
				
					WorkerConnectionID worker_connection = null;	
				
					Console.WriteLine("connect_c2c 0");

					if (user_nodes_inv.ContainsKey (0)) 
					{
						WorkerComponentID cid_user = user_.WorkerComponentID ; 
						WorkerComponentID cid_prov = provider_.WorkerComponentID ; 
						worker_connection = (WorkerConnectionID)WorkerBuilder.connect (cid_user, usingPortName, cid_prov, providingPortName);
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
			
				//Console.WriteLine ("DISCONNECTING 1 " + usesPortName + " <- " + providesPortName);
		
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
					WorkerConnectionID conn_id = ((ManagerConnectionID)connID).WorkerConnectionID;
			
					if (conn_id != null)
						try 
						{
							this.WorkerBuilder.disconnect (conn_id, timeout);     
						} 
						catch (CCAExceptionImpl e) 
						{
				//			Console.WriteLine ("DISCONNECTING 3.2 - EXCEPTION: " + e.getCCAExceptionType ());
						}
				}
			
			//	Console.WriteLine ("DISCONNECTING 4 " + usesPortName + " <- " + providesPortName);

	            connectionList.Remove(connID);
	            connByUserPortName.Remove(usesPortName);
	            connByProviderPortName.Remove(providesPortName);

			
			//Console.WriteLine ("DISCONNECTING 5 " + usesPortName + " <- " + providesPortName);


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

                IDictionary<int, ComponentID> id2_ws_inv = new Dictionary<int, ComponentID>();
                WorkerComponentID id2_w = id2_m.WorkerComponentID;
                id2_ws_inv.Add(0, id2_w);

                WorkerComponentID id1_w = id1_m.WorkerComponentID;
                ComponentID cid1 = id1_w;
                ComponentID cid2;
                if (id2_ws_inv.ContainsKey(0))
                {
                    id2_ws_inv.TryGetValue(0, out cid2);
                    gov.cca.ports.BuilderService builder = WorkerBuilder;
                    builder.disconnectAll(cid1, cid2, timeout);
                }
                else
                {
                    throw new CCAExceptionImpl("Impossible to disconnect these components. They are not placed in the same set of nodes.");
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

	            ManagerComponentID mcid = (ManagerComponentID)conn.getUser();
	            ManagerComponentID wcid = (ManagerComponentID)conn.getProvider();
	            ManagerServices ms = null;
	            this.host_services.TryGetValue(mcid.getInstanceName(), out ms);

	            WorkerServices ws = ms.WorkerServices;

	            gov.cca.Port port_worker = null;

	            WorkerConnectionID wconn = ((ManagerConnectionIDImpl)conn).WorkerConnectionID;
	            WorkerServices ws_ = ws;
	            port_worker = wconn != null ? ws_.getPortNonblocking(wconn.getUserPortName()) : null;

	            //string user_port_name = conn.getUserPortName();
	            gov.cca.Port port = null;

	            /* TODO: It is still necessary to implement a general mechanism
	             * for connecting to applications, where an application may provide
	             * arbitrary ports for the host and vice-versa
	             */
	            if (user_port_name.EndsWith(Constants.GO_PORT_NAME))
	            {
	                port = new GoPortImpl(ms, port_worker);
	            }
	            else if (user_port_name.EndsWith(Constants.INITIALIZE_PORT_NAME))
	            {
	                port = new InitializePortImpl(ms, port_worker);
	            }
	            else if (user_port_name.EndsWith(Constants.RECONFIGURE_PORT_NAME))
	            {
	                port = new ReconfigurationAdvicePortImpl(ms, port_worker);
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


			public void resolve_topology (DGAC.database.AbstractComponentFunctorApplication acfaRef, 
									  int[] unit_mapping,
		                              out string[] interface_ids, 
		                              out int[] nodes)
			{
					IList<Interface> iList;

					nodes = unit_mapping;
				    interface_ids = new string[nodes.Length];
				
                    iList = BackEnd.idao.list(acfaRef.Id_abstract);
				    if (iList.Count == 1) // SPMD
				    {
					    for (int i = 0; i < nodes.Length; i++) {
						    interface_ids[i] = iList[0].Id_interface;
					    }
				    } 
					else
					{
						throw new Exception("ManagerObject.resolve_topology: In simple SPMD case, the component must have a single parallel unit." + acfaRef.Id_abstract);
					}


			}


			public void resolve_topology (DGAC.database.AbstractComponentFunctorApplication acfaRef, 
									      Instantiator.UnitMappingType[] unit_mapping,
										  out IList<string> interface_ids,
										  int facet_instance)
			{
			//	Console.WriteLine("BEGIN resolve_topology");

				interface_ids = null;
			    IList<Interface> iList = null;
				
			//	Console.WriteLine("resolve_topology 1 " + (unit_mapping == null) + ", length="+ (unit_mapping.Length));

				int count_nodes;
				IDictionary<string,IList<Tuple<int,int[],int>>> unit_mapping_dict;
			 
			    // Note: only the units associated to the current facet are considered for instantiation.
				BackEnd.copy_unit_mapping_to_dictionary(facet_instance, unit_mapping, out unit_mapping_dict, out count_nodes);

			 //   Console.WriteLine("resolve_topology 2 - count_nodes = " + count_nodes);

				interface_ids = new List<string>();

                iList = BackEnd.idao.list(acfaRef.Id_abstract);

			//	Console.WriteLine("resolve_topology 3 - " + acfaRef.Id_abstract);

			    foreach (Interface unit in iList)
				{					
					IList<Tuple<int,int[],int>> node_list;

				   if (unit_mapping_dict.TryGetValue (unit.Id_interface_super_top, out node_list)) 
				    {
					    foreach (Tuple<int,int[],int> um in node_list) 
						{
							if (um.Item1 == facet_instance) 
							    interface_ids.Add(unit.Id_interface);
							//else 
							//	Console.WriteLine ("Unit " + unit.Id_interface_super_top + " does not belong to this facet ");
						}
					}
				}


			//	Console.WriteLine("END resolve_topology");
		}


		public string[] calculatePortNames (int id_abstract, string id_interface)
		{
            IList<Slice> sList = BackEnd.sdao.listByInterface(id_abstract, id_interface);
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
			portNameList.CopyTo (portNameArray, 0);
			
			return portNameArray;
		}


		private void binding_calculate_ports_locally (int binding_sequential, int[] facet_access_port_base, ref int[] facet_access_port)
		{
			Trace.Write("binding_calculate_ports_locally - BEGIN: ");

			facet_access_port = new int[facet_access_port_base.Length];

			for (int i = 0; i < facet_access_port_base.Length; i++) 
				facet_access_port [i] = facet_access_port_base[i] + binding_sequential*256;

		}


        [MethodImpl(MethodImplOptions.Synchronized)]
        public void createInstanceImpl(
            string instanceName,
            string componentName,
            TypeMapImpl properties,
            out IList<string>[] unit_ids,
            out int id_functor_app,
            out int kind,
            out WorkerComponentID worker_cid
            )
		{
			    Console.WriteLine("CREATE INSTANCE IMPL #1");
                IList<IList<string>> unit_ids_list = new List<IList<string>>();

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

					object unit_mapping = properties[Constants.NODES_KEY];

				    // MPMD case, also covering SPMD.
					IList<string> id_interface_list;
					resolve_topology(acfaRef, (Instantiator.UnitMappingType[]) unit_mapping,out id_interface_list, this_facet_instance);

					/* BINDING:
					   If the component is a binding, it is necessary to include the root unit, which is not referred in the instantiation file.
				       The root unit is instantiated in the master worker. */				       
					Console.WriteLine(kind);	

                    Connector.commitTransaction();
				                    
			
					Instantiator.UnitMappingType[] unit_mapping_ = (Instantiator.UnitMappingType[]) unit_mapping;
					foreach (Instantiator.UnitMappingType ooo in unit_mapping_)
					{
						ooo.facetSpecified = true;
						ooo.facet_instanceSpecified = true;
					}
					string unit_mapping_xml = LoaderApp.serialize<Instantiator.UnitMappingType[]>(unit_mapping_);
					Console.WriteLine("UNIT MAPPING --- " + unit_mapping_xml);

				    DGAC.database.Unit u = DGAC.BackEnd.takeUnit(c, id_interface_list[0]); // TODO: consider all the interfaces in the list ...
					AbstractComponentFunctor acf = DGAC.BackEnd.acfdao.retrieve(c.Id_abstract);

					Console.WriteLine("CREATE INSTANCE IMPL 2 " + u.Id_interface);

			        // SETUP PROPERTIES
                    TypeMapImpl worker_properties = new TypeMapImpl(properties);
                    worker_properties[Constants.KEY_KEY] = 0;
                    worker_properties[Constants.COMPONENT_KEY] = acf.Library_path;
					worker_properties[Constants.UNIT_KEY] = u.Id_interface ;
				    worker_properties[Constants.ASSEMBLY_STRING_KEY] = u.Assembly_string;
					worker_properties[Constants.PORT_NAMES_KEY] = calculatePortNames(c.Id_abstract, u.Id_interface);
					worker_properties[Constants.KIND_KEY] = c.Kind;			

				    worker_properties[Constants.NODES_KEY] = unit_mapping_xml;

					Console.WriteLine("CREATE INSTANCE IMPL 3");

				    int[] facet_topology = (int[]) properties[Constants.FACET_TOPOLOGY];  Console.WriteLine("FACET_TOPOLOGY ok");
					worker_properties[Constants.FACET_INSTANCE] = this_facet_instance;
					//worker_properties[Constants.FACET] = this_facet;
					worker_properties[Constants.FACET_TOPOLOGY] = facet_topology;

					// Inform to the root unit the communication addresses of the other binding facets. 
				    if (kind == Constants.KIND_BINDING)
					{
						Console.WriteLine("createInstanceImpl - ENTERING BINDING --- instance_name" + componentName + ", id_unit=" + u.Id_unit);

						if (!properties.ContainsKey(Constants.FACET_IP_ADDRESS) || !properties.ContainsKey(Constants.FACET_PORT))
							throw new Exception ("createInstanceImpl: UNABLE TO CREATE BINGING INSTANCE - no access information for binding facets");

						string[] facet_access_address = (string[]) properties[Constants.FACET_IP_ADDRESS];
						int[] facet_access_port = (int[]) properties[Constants.FACET_PORT];
						
						/* TODO: promover uma sincronização de números de portas entre as facetas. 
						 * Cada faceta deve oferecer um número de porta livre e informá-la as demais,
						 * através do endereço e porta base de cada plataforma.							 * 
						 */

						Console.WriteLine("CREATE INSTANCE IMPL 3.2");

						IList<int> facet_instance_list = new List<int>();
						Console.WriteLine("CREATE INSTANCE IMPL 3.3 " + facet_topology.Length);


						 // binding_exchange_ports_N(facet_index, facet_instance_list, ref facet_access_address, ref facet_access_port);
						 int binding_sequential = (int) properties[Constants.BINDING_SEQUENTIAL];
						 int[] facet_access_port_local = null;
						 Console.WriteLine("CREATE INSTANCE IMPL 4 -- binding_sequential=" + binding_sequential);
					     binding_calculate_ports_locally (binding_sequential, facet_access_port, ref facet_access_port_local);
					     Console.WriteLine("CREATE INSTANCE IMPL 5 facet_topology.Length=" + facet_topology.Length);

					     worker_properties[Constants.FACET_IP_ADDRESS] = facet_access_address;
					     worker_properties[Constants.FACET_PORT] = facet_access_port_local;
				    }

                    string class_name_worker;
                    
					Console.WriteLine("createInstanceImpl2 - GOING TO calculateActualParams ...");

					System.Type[] arguments_new;	
					IList<System.Type[]> arguments_new_all = new List<System.Type[]>();
					int type_count = 0; 
					foreach (string id_interface in id_interface_list)
					{
						Console.WriteLine("createInstanceImpl2 -- LOOP BEGIN " + id_interface);
						System.Type[] arguments_new_;
					    DGAC.BackEnd.calculateActualParams(c.Arguments, arguments, acfaRef, id_interface, out arguments_new_);
						type_count += arguments_new_.Length;
						arguments_new_all.Add(arguments_new_);
						Console.WriteLine("createInstanceImpl2 -- LOOP END" + id_interface);
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


				BuilderService worker = WorkerBuilder;
				
                DGAC.BackEnd.calculateGenericClassName(u, arguments_new, out class_name_worker);

				    // INSTANTIATE THE UNITS ACCROSS THE WORKERS


					Console.WriteLine("Calling worker. Instanting " + instanceName + " " + class_name_worker + " null ? " + (worker == null));
					WorkerComponentID wcid = (WorkerComponentID) worker.createInstance(instanceName, class_name_worker, worker_properties);

					worker_cid = wcid;
					unit_ids_list.Add(id_interface_list); 

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

                unit_ids = new IList<string>[unit_ids_list.Count];
 			
                return;
		}




		
				
				//just for test
				[MethodImpl(MethodImplOptions.Synchronized)]
				public void sayHi(){
					Console.WriteLine("Hi!");
				}


				/* The Worker Object of each computing node */
		        private gov.cca.AbstractFramework worker_framework = null;
		
		        public gov.cca.AbstractFramework WorkerFramework 
		        {
			       get {   
				           if (worker_framework == null) 
				           {
					          instantiateWorker();
				           }
				           return worker_framework;			
			           } 
		        }


                private gov.cca.ports.BuilderService worker_builder = null;
		
				private  gov.cca.ports.BuilderService WorkerBuilder 
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
					gov.cca.Services srv = this.frw_services.WorkerServices;

					worker_builder = (gov.cca.ports.BuilderService) srv.getPort(Constants.BUILDER_SERVICE_PORT_NAME);
                    Console.WriteLine("CONNECT TO WORKER BUILDERS " + (worker_builder == null));
				}
		
     			

                [MethodImpl(MethodImplOptions.Synchronized)]
                public void instantiateWorker()
                {
					worker_framework = BackEnd.getFrameworkWorkerInstanceLocal ();
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
