//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using MPI;
using br.ufc.pargo.hpe.basic;
using System.Reflection;
using System.Threading;
using gov.cca;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.database;
using gov.cca.ports;
using br.ufc.pargo.hpe.ports;
//using br.ufc.lia.hpe.kinds;


delegate void GoMethod();

namespace br.ufc.pargo.hpe.backend.DGAC
{ 
	//WORKER
    public class WorkerObject : MarshalByRefObject, gov.cca.AbstractFramework, 
	                                                gov.cca.ports.BuilderService,
		                                            gov.cca.Services,
                                                    gov.cca.Component,
													gov.cca.ports.ServiceRegistry
    {
		
		#region Tables
		
		private IDictionary<string, br.ufc.pargo.hpe.basic.IUnit> unitInstances = new Dictionary<string, br.ufc.pargo.hpe.basic.IUnit>();
		private IDictionary<string, ComponentID> componentIDs = new Dictionary<string, ComponentID>();
		private IDictionary<ComponentID, TypeMap> unitProperties = new Dictionary<ComponentID, TypeMap>();

        private IDictionary<string, IList<string>> providesPortNames = new Dictionary<string, IList<string>>();
        private IDictionary<string, IList<string>> usesPortNames = new Dictionary<string, IList<string>>();
        private IDictionary<string, ComponentID> usesPortNamesInv = new Dictionary<string, ComponentID>();
        private IDictionary<string, ComponentID> providesPortNamesInv = new Dictionary<string, ComponentID>();
        private IDictionary<string, string> usesPortTypes = new Dictionary<string, string>();
        private IDictionary<string, string> providesPortTypes = new Dictionary<string, string>();

        private IDictionary<string, Port> providesPorts = new Dictionary<string, Port>();
        private IDictionary<string, TypeMap> portProperties = new Dictionary<string, TypeMap>();

        private IDictionary<string, ConnectionID> connectionList = new Dictionary<string, ConnectionID>();
        private IDictionary<ConnectionID, TypeMap> connectionProperties = new Dictionary<ConnectionID, TypeMap>();
        private IDictionary<string, ConnectionID> connByUserPort = new Dictionary<string, ConnectionID>();
        private IDictionary<string, IList<ConnectionID>> connByProviderPort = new Dictionary<string, IList<ConnectionID>>();

        private IDictionary<string, Services> componentServices = new Dictionary<string, Services>();

		
		private void registerProvidesPortInfo(ComponentID cid, Port port, string portName, string type, TypeMap properties) 
		{
			IList<string> portList;
			if (providesPortNames.ContainsKey(cid.getInstanceName())) 
			{
				providesPortNames.TryGetValue(cid.getInstanceName(),out portList);
			} 
			else 
			{
				portList = new List<string>();				
				providesPortNames.Add(cid.getInstanceName(),portList);
			}

            providesPortNamesInv.Add(portName, cid);
			portList.Add(portName);
            portProperties.Add(portName, properties);
			providesPortTypes.Add(portName, type);
            providesPorts.Add(portName, port);
        }
		
		private void unregisterProvidesPortInfo(ComponentID cid, string portName) 
		{
			IList<string> portList;
			if (providesPortNames.TryGetValue(cid.getInstanceName(),out portList)) 
			{
                portList.Remove(portName);
                if (portList.Count == 0)
                    providesPortNames.Remove(cid.getInstanceName());
                providesPortNamesInv.Remove(portName);
                portProperties.Remove(portName);
                providesPorts.Remove(portName);
			} 
			else 
			{
				throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
			}
			
		}
		
		private void registerUsesPortInfo(ComponentID cid, string portName, string type, TypeMap properties) 
		{
			IList<string> portList;
			if (usesPortNames.ContainsKey(cid.getInstanceName())) 
			{
				usesPortNames.TryGetValue(cid.getInstanceName(), out portList);
			} 
			else 
			{
				portList = new List<string>();				
				usesPortNames.Add(cid.getInstanceName(),portList);
			}
		//	System.Diagnostics.Debug.WriteLine("registerUsesPortInfo -- " + portName);
			usesPortTypes.Add (portName, type);
            usesPortNamesInv.Add(portName, cid);
			portList.Add(portName);
            portProperties.Add(portName, properties);
		}

		
		public void registerComponentID(ComponentID cid, Services services, br.ufc.pargo.hpe.basic.IUnit unit) 
		{
            if (!componentIDs.ContainsKey(cid.getInstanceName()))
            {
                unitInstances.Add(cid.getInstanceName(), unit);
                componentIDs.Add(cid.getInstanceName(), cid);
                componentServices.Add(cid.getInstanceName(), services);
                unit.CID = cid;
            }
		}

        public void registerComponentID(ComponentID cid, Services services)
        {
            if (!componentIDs.ContainsKey(cid.getInstanceName()))
            {
                componentIDs.Add(cid.getInstanceName(), cid);
                componentServices.Add(cid.getInstanceName(), services);
            }
        }

        private void unregisterComponentID(ComponentID cid) 
		{
			componentIDs.Remove(cid.getInstanceName());
			unitInstances.Remove(cid.getInstanceName());
		}

		private gov.cca.Services frw_services = null;
		
		private PortUsageManager port_manager = null;
		
		public WorkerObject() 
		{
			//gov.cca.Services frw_services = getServices("worker_framework","WorkerObject",new TypeMapImpl());
            //this.setServices(frw_services);
			
			port_manager = new PortUsageManager();
			
            DGAC.BackEnd.worker_framework = this;

            this.global_communicator = MPI.Communicator.world;
            my_rank = this.global_communicator.Rank;

        }
		
		#endregion

		public WorkerServices getServicesObjectOf(string instanceName)
		{
			Services services;
			this.componentServices.TryGetValue(instanceName, out services);
			return (WorkerServices) services;
		}
		
		// ==========================================================================================================
        // BEGIN - CCA INTERFACES (Abstract Framework, Builder Services, Services) ==================================
		// ==========================================================================================================


        #region AbstractFramework Members

        public TypeMap createTypeMap()
        {
            return new TypeMapImpl();
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public gov.cca.Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties)
        {
            ComponentID cid = new WorkerComponentIDImpl(selfInstanceName);
            unitProperties.Add(cid, selfProperties);
            WorkerServicesImpl services = new WorkerServicesImpl(this, cid);
            this.registerComponentID(cid, services);
			
			//TcpServerChannel channel = new TcpServerChannel(port);
     		//ChannelServices.RegisterChannel(channel, false);     
     		//RemotingServices.Marshal(services, "WorkerServices.rem");	
			
            return services;            
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void releaseServices(gov.cca.Services services)
        {
            if (releaseRegister.ContainsKey(services))
            {
                ComponentRelease callBack;
                releaseRegister.TryGetValue(services, out callBack);
                callBack.releaseServices(services);
            }           
        }


        [MethodImpl(MethodImplOptions.Synchronized)]
        public void shutdownFramework()
        {
			// EMPTY
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public AbstractFramework createEmptyFramework()
        {
            throw new CCAExceptionImpl("This CCA framework forbids creation of another framework instance.");
        }

        #endregion


        #region Component Members

		private ServiceRegistry frw_registry = null;
		private BuilderService frw_builder = null;
		
        public void setServices(Services services)
        {
			this.frw_services = services;
			frw_registry = (ServiceRegistry) frw_services.getPort (Constants.REGISTRY_PORT_NAME);
			frw_registry.addSingletonService(Constants.BUILDER_SERVICE_PORT_TYPE, this);
			frw_builder = (BuilderService) frw_services.getPort (Constants.BUILDER_SERVICE_PORT_NAME);
        }

        #endregion


        #region BuilderService Members


        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID createInstance(string instanceName,
                                          string className,    // unit name (data)
                                          TypeMap properties)
        {
            ComponentID cid = null;

            Connector.openConnection();

            string library_path = properties.getString(Constants.COMPONENT_KEY, "not found");
            br.ufc.pargo.hpe.backend.DGAC.database.Component c = DGAC.BackEnd.cdao.retrieve_libraryPath(library_path);
            
            int kind = Constants.kindMapping[c.Kind];
            
            switch (kind)
            {
                case Constants.KIND_APPLICATION: cid = createInstanceForApplications(instanceName, className, properties); break;
                case Constants.KIND_COMPUTATION:
                case Constants.KIND_DATASTRUCTURE:
                case Constants.KIND_ENUMERATOR:
                case Constants.KIND_ENVIRONMENT:
                case Constants.KIND_PLATFORM:
                case Constants.KIND_QUALIFIER:
                case Constants.KIND_SERVICE:
                case Constants.KIND_SYNCHRONIZER: cid = createInstanceBaseForAllKinds(instanceName, className, properties); break;
                case Constants.KIND_UNRECOGNIZED: throw new CCAExceptionImpl(CCAExceptionType.Unexpected); 
            }

            // REGISTER CREATESLICES PORT
            

            Connector.closeConnection();

            return cid;
        }


        private ComponentID createInstanceForApplications(string instanceName, string class_name, TypeMap properties)
        {
            try
            {
              //  int key = properties.getInt(Constants.KEY_KEY, my_rank);                
             //   string id_unit = properties.getString(Constants.UNIT_KEY, "");
              //  string library_path = properties.getString(Constants.COMPONENT_KEY, "");
             //   int id_functor_app = properties.getInt(Constants.ID_FUNCTOR_APP, -1);

                ComponentID cid_app = createInstanceBaseForAllKinds(instanceName, class_name, properties);

                IUnit unit_slice;
                unitInstances.TryGetValue(cid_app.getInstanceName(), out unit_slice);
                br.ufc.pargo.hpe.kinds.IApplicationKind pmain = (br.ufc.pargo.hpe.kinds.IApplicationKind)unit_slice;

                // This part is only performed by applications.
//                DGAC.BackEnd.calculateInitialTopology(cid_app, library_path, id_unit, id_functor_app, pmain);

				
				//pmain.setUpParameters(id_functor_app);
                //pmain.ActualParametersTop = pmain.ActualParameters;

				//System.Diagnostics.Debug.WriteLine("BEGIN - Worker " + my_rank + ": Split " + key + " !!!");
                //pmain.WorldComm = (MPI.Intracommunicator)this.global_communicator.Split(1, key);
                //System.Diagnostics.Debug.WriteLine("END - Worker " + my_rank + ": Split " + key + " !!!");
                //pmain.GlobalRank = pmain.WorldComm.Rank;
				
                //pmain.createSlices();
                
                // --------------------------------------------

                //pmain.perform_initialize();

                return cid_app;

            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
                System.Diagnostics.Debug.WriteLine(e.StackTrace);
                throw e;
            }

        }

        private ComponentID createInstanceBaseForAllKinds(string instanceName, string class_name, TypeMap properties)
        {
            ComponentID cid = new WorkerComponentIDImpl(instanceName);
            unitProperties.Add(cid, properties);
			
            string id_unit = properties.getString(Constants.UNIT_KEY, "");
            string library_path = properties.getString(Constants.COMPONENT_KEY, "");
			string assembly_string = properties.getString(Constants.ASSEMBLY_STRING_KEY, "");
			string[] portNames = properties.getStringArray(Constants.PORT_NAMES_KEY, new string[0]);
			int kind = Constants.kindMapping[properties.getString(Constants.KIND_KEY, "")];
			
            ObjectHandle obj = Activator.CreateInstance(assembly_string, class_name);
            hpe.basic.IUnit unit_slice = (hpe.basic.IUnit) obj.Unwrap();
			unit_slice.Id_unit = id_unit;
			unit_slice.PortNames = portNames;
			unit_slice.Kind = kind;
			unit_slice.ClassName = class_name;
			unit_slice.QualifiedComponentTypeName = library_path;

            Services services = new WorkerServicesImpl(this, cid, unit_slice);
            unit_slice.setServices(services);
                        
            if (properties.hasKey(Constants.KEY_KEY)) {
                int key = properties.getInt(Constants.KEY_KEY, my_rank);
				System.Diagnostics.Debug.WriteLine("--- BEGIN - Worker " + my_rank + ": Split " + key + " !!!");
	            unit_slice.WorldComm = (MPI.Intracommunicator)this.global_communicator.Split(1, key);
	            System.Diagnostics.Debug.WriteLine("--- END - Worker " + my_rank + ": Split " + key + " !!!");
	            unit_slice.GlobalRank = unit_slice.WorldComm.Rank;
            }

            return cid;
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
            }
            for (int i = 0; i < enums_.Length; i += 2)
            {
                enums.Add(enums_[i], int.Parse(enums_[i + 1]));
            }
            return enums;
        }


        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID[] getComponentIDs()
        {
			ComponentID[] cids = new WorkerComponentIDImpl[unitInstances.Count];
            int i = 0;
            foreach (KeyValuePair<string, IUnit> pair in unitInstances)
            {
                cids[i++] = pair.Value.CID;
            }
            //unitInstances.Keys.CopyTo(cids, 0);
			return cids;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public TypeMap getComponentProperties(ComponentID cid)
        {
			TypeMap properties;
            unitProperties.TryGetValue(cid, out properties);
			return properties;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void setComponentProperties(ComponentID cid, TypeMap map)
        {
			if (unitProperties.ContainsKey(cid)) 
			{
				unitProperties.Remove(cid);
			} 
			
			unitProperties.Add(cid,map);			
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
			/* It is supposed that the user has disconnected and unregistered 
			 * the uses and provides ports of the component 'toDie' 
			 */
			Services services = null;
			componentServices.TryGetValue(toDie.getInstanceName(), out services);
			
			string[] usesPorts = frw_builder.getUsedPortNames(toDie);
			string[] providesPorts = frw_builder.getProvidedPortNames(toDie);
			
			if (usesPorts.Length > 0 || providesPorts.Length > 0)
			{
				System.Diagnostics.Debug.WriteLine("The component must unregister its uses ports " +
												   "and remove provides ports before destruction.");
				throw new CCAExceptionImpl(CCAExceptionType.Unexpected);				
			}
						
			// Remove instance id from tables
			componentIDs.Remove(toDie.getInstanceName());
			unitInstances.Remove(toDie.getInstanceName ());
						
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public string[] getProvidedPortNames(ComponentID cid)
        {
		    IList<string> portList;
			if (componentIDs.ContainsKey(cid.getInstanceName()))
			{
				if (providesPortNames.ContainsKey(cid.getInstanceName()))
				{
					providesPortNames.TryGetValue(cid.getInstanceName(), out portList);			
					string[] ports = new string[portList.Count];
					portList.CopyTo(ports,0);
		            return ports;
				}
				else
				{
					return new string[] {};
				}
			}
			else 
			{
				throw new CCAExceptionImpl("Undefined Component (id=" + cid.getInstanceName() + ")");
			}
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public string[] getUsedPortNames(ComponentID cid)
        {
			if (componentIDs.ContainsKey(cid.getInstanceName()))
			{
			    IList<string> portList;
				if (usesPortNames.ContainsKey(cid.getInstanceName())) 
				{
					usesPortNames.TryGetValue(cid.getInstanceName(), out portList);			
					string[] ports = new string[portList.Count];
					portList.CopyTo(ports,0);
		            return ports;
				} 
				else
				{
					return new string[] {};
				}
			}
			else
			{	
				foreach (string k in usesPortNames.Keys)
					Console.WriteLine("KEY = " + k);
				
				throw new CCAExceptionImpl("Undefined Component (id=" + cid.getInstanceName() + ")");
			}
			
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public TypeMap getPortProperties(ComponentID cid, string portName)
        {
            string key =portName;
            if (portProperties.ContainsKey(key))
            {
                TypeMap properties;
                portProperties.TryGetValue(key, out properties);
                return properties;
            }
            else
            {
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }

        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void setPortProperties(ComponentID cid, string portName, TypeMap map)
        {
            string key = portName;
            if (portProperties.ContainsKey(key))
            {
                portProperties.Remove(key);
                portProperties.Add(key, map);                
            }
            else
            {
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName)
        {
			string user_port_name = user.getInstanceName() + ":" + usingPortName;
			string provider_port_name = provider.getInstanceName() + ":" + providingPortName;
			
			if (!usesPortNamesInv.ContainsKey(user_port_name))
            {				
				foreach (string p in usesPortNamesInv.Keys)
				{
					System.Diagnostics.Debug.WriteLine("U KEY = " + p);
				}
			   throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);	
			}
			
			if (!providesPortNamesInv.ContainsKey(provider_port_name))
			{
				foreach (string p in providesPortNamesInv.Keys)
				{
					System.Diagnostics.Debug.WriteLine("P KEY = " + p);
				}
				throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);	
			}						
			
			//if (port_manager.isReleased(user_port_name))
			//{
			//	throw new CCAExceptionImpl(CCAExceptionType.PortNotInUse);
			//}
			
			Console.WriteLine("connect " + user_port_name + " to " + provider_port_name);
			
            ConnectionID connection = new WorkerConnectionIDImpl(provider, providingPortName, user, usingPortName);
            connectionList.Add(connection.ToString(), connection);
            bool first_connection = addConnByProviderPort(provider_port_name, connection);
          //  System.Diagnostics.Debug.WriteLine(my_rank + ": CONNECT !" + user.getInstanceName() + ":" + usingPortName);
            connByUserPort.Add(user_port_name, connection);			
			port_manager.resetPort(user_port_name);
            this.tryAwakeConnectingUserPort(user_port_name);

            IUnit user_unit, provider_unit;
            this.unitInstances.TryGetValue(user.getInstanceName(), out user_unit);
            this.unitInstances.TryGetValue(provider.getInstanceName(), out provider_unit);

            if (user_unit != null)
            {
                provider_unit.GlobalRank = user_unit.GlobalRank;
                provider_unit.WorldComm = user_unit.WorldComm;
				
				/* --- TODO: NOT VALID FOR MPMD */
				provider_unit.Rank = provider_unit.GlobalRank;
				provider_unit.Size = provider_unit.WorldComm.Size;
			
				//provider_unit.addContainerSlice(user_unit, usingPortName);
				user_unit.addSlice(provider_unit,usingPortName);
            }

            return connection;
        }

        private bool addConnByProviderPort(string portName, ConnectionID connection)
        {
            IList<ConnectionID> listConn;
            bool first_connection = true;
            if (!connByProviderPort.TryGetValue(portName, out listConn))
            {
                listConn = new List<ConnectionID>();
                connByProviderPort.Add(portName, listConn);
            }
            else
            {
                first_connection = false;
            }
            listConn.Add(connection);

            return first_connection;
        }

        private void tryAwakeConnectingUserPort(string usingPortName)
        {
            AutoResetEvent wait_handle = null;
            if (waitingUserPorts.TryGetValue(usingPortName, out wait_handle))
            {
//				System.Diagnostics.Debug.WriteLine ("AWAKENING " + usingPortName);   
                wait_handle.Set();
                waitingUserPorts.Remove(usingPortName);
            }
			else
			{
//				System.Diagnostics.Debug.WriteLine ("NOTHING TO AWAKE - " + usingPortName);
			}
				
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ConnectionID[] getConnectionIDs(ComponentID[] componentList)
        {
            IList<ComponentID> componentListList = new List<ComponentID>(componentList);

            IList<ConnectionID> connectionsFilter = new List<ConnectionID>();
            foreach (ConnectionID conn in connectionList.Values) 
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
			
			string user_port_name = connID.getUser().getInstanceName() + ":" + connID.getUserPortName();
			string provider_port_name = connID.getProvider().getInstanceName() + ":" + connID.getProviderPortName();
			
			if (!port_manager.isReleased(user_port_name))
			{
				throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
			}
						
			if (!connectionList.ContainsKey(connID.ToString()))
			{
				throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
			}
			
            connectionList.Remove(connID.ToString ());
			Console.WriteLine("disconnecting " + user_port_name + " from " + provider_port_name);

            connByUserPort.Remove(user_port_name);
            connByProviderPort.Remove(provider_port_name);

            if (connectionProperties.ContainsKey(connID))
            {
                connectionProperties.Remove(connID);
            }
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void disconnectAll(ComponentID id1, ComponentID id2, float timeout)
        {           
            // TODO: IT IS NECESSARY TO IMPLEMEMENT THE timeout
            if (id1 == null)
            {
                throw new CCAExceptionImpl(CCAExceptionType.BadPortName);
            }

            IList<ConnectionID> willDisconnect = new List<ConnectionID>();

            try
            {
                // TEST IF ALL PORTS CAN BE DISCONNECT.
                foreach (ConnectionID conn in connectionList.Values)
                {
                    ComponentID user = conn.getUser();
                    ComponentID provider = conn.getProvider();
                    if ((user.Equals(id1) && provider.Equals(id2)) ||
                        (user.Equals(id2) && provider.Equals(id1)) ||
                        (id2 == null && (user.Equals(id1) || provider.Equals(id1))))
                    {
                        WorkerConnectionID hpeconn = (WorkerConnectionID)conn;
                        //hpeconn.blockFetched();
                        willDisconnect.Add(conn);

                    }
                }
            }
            catch (CCAExceptionImpl e)
            {
                foreach (ConnectionID conn in willDisconnect)
                {
                    WorkerConnectionID hpeconn = (WorkerConnectionID)conn;
                    //hpeconn.unblockFetched();
                }
                throw e;
            }


            // ONLY EXECUTE THIS LOOP IF ALL CONNECTIONS ARE RELEASED.
            foreach (ConnectionID conn in willDisconnect)
            {
                disconnect(conn, timeout);
            }

        }

        #endregion
        #region Services Members

        private Port getPortProceed(string portName)
        {
            ConnectionID conn;
            connByUserPort.TryGetValue(portName, out conn);
            WorkerConnectionID hpeconn = (WorkerConnectionID)conn;
			
            string providesPortName = conn.getProvider().getInstanceName() + ":" + conn.getProviderPortName();

            Port providesPort;
            providesPorts.TryGetValue(providesPortName, out providesPort);
            
			//System.Diagnostics.Debug.WriteLine("PORT TYPE of " + providesPortName + " = " + providesPort.GetType());
			
			port_manager.addPortFetch(portName);
			
            return providesPort;
        }

        private IDictionary<string, AutoResetEvent> waitingUserPorts = new Dictionary<string, AutoResetEvent>();

        	public Port getServicePort(ComponentID user, string usedPortName)
			{
				//System.Diagnostics.Debug.WriteLine("checking service port " + usedPortName);
				string portType;
				if (usesPortTypes.TryGetValue(usedPortName, out portType))
				{
				  //  System.Diagnostics.Debug.WriteLine("port type is " + portType);
					Port singleton_service_port = null;
					ServiceProvider service_provider = null;
					if (usedPortName.EndsWith(Constants.REGISTRY_PORT_NAME)) 
					{
						return this;
					}				
					else if (this.provided_service_table.TryGetValue(portType,out service_provider))
				    { 
						string providedPortName = service_provider.createService(portType);
					    ConnectionID conn = frw_builder.connect(user, usedPortName, frw_services.getComponentID(), providedPortName);
					
						return getPortProceed(usedPortName);
				    }
					else if (this.singleton_provided_port_table.TryGetValue(portType, out singleton_service_port))
				    { 
						return singleton_service_port;
				    }
				}
				return null;
			}

//		[MethodImpl(MethodImplOptions.Synchronized)]
        public Port getPort(string portName)
        {
            Console.WriteLine("Worker" + my_rank + ": BEGIN getPort " + portName);
            if (!usesPortNamesInv.ContainsKey(portName))
            {
				Console.WriteLine("PORT NOT FOUND is " + portName);
				foreach (string p in usesPortNamesInv.Keys)
				{
					Console.WriteLine("KEY = " + p);
				}
				
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }

            if (!connByUserPort.ContainsKey(portName))
            {
                // WAIT UNTIL THE PORT IS AVAILABLE.
				
				Console.WriteLine("Waiting for " + portName);
				foreach (string p in connByUserPort.Keys)
				{
					Console.WriteLine("KEY = " + p);
				}
                AutoResetEvent wait_handle = new AutoResetEvent(false);
                waitingUserPorts.Add(portName, wait_handle);
                wait_handle.WaitOne();
            }

            Port port = this.getPortProceed(portName);
            Console.WriteLine("Worker" + my_rank + ": END getPort " + portName + " TYPE:" + port.GetType());
            return port;

        }

//        [MethodImpl(MethodImplOptions.Synchronized)]
        public Port getPortNonblocking(string portName)
        {
            if (!usesPortNamesInv.ContainsKey(portName))
            {
				Console.WriteLine("PORT NOT FOUND is " + portName);
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }

            if (!connByUserPort.ContainsKey(portName))
            {
                //throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
                return null;
            }

            return this.getPortProceed(portName);
        }
        
        [MethodImpl(MethodImplOptions.Synchronized)]
        public void releasePort(string portName)
        {
            if (!usesPortNamesInv.ContainsKey(portName))
            {
				System.Diagnostics.Debug.WriteLine("Port {0} not defined. It cannot be released.", portName);
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }

            ConnectionID conn;
            connByUserPort.TryGetValue(portName, out conn);
            WorkerConnectionID hpeconn = (WorkerConnectionID)conn;

            port_manager.addPortRelease(portName);
        }


        /* <instanceName>.<portName>, where <instanceName> may be used to fetch the unit object, and <portName> is the inner component name.
         * 
         */
        [MethodImpl(MethodImplOptions.Synchronized)]
        public void registerUsesPort(string portName, string type, TypeMap properties)
        {
			Console.WriteLine("registering port " + portName);
			
			if (usesPortNamesInv.ContainsKey(portName))
			{
				throw new CCAExceptionImpl(CCAExceptionType.PortAlreadyDefined);
			}
			
            HPETypeMap hpe_properties = (HPETypeMap) properties;

            Connector.openConnection();

            string instanceName; 
            string id_inner;
            readPortName(portName, out instanceName, out id_inner);

            ComponentID cid;
            if (componentIDs.ContainsKey(instanceName))
            {
                componentIDs.TryGetValue(instanceName, out cid);
            }
            else
            {
                throw new CCAExceptionImpl("Bad Instance Name");
            }

            this.registerUsesPortInfo(cid, portName, type, properties);
            
            Connector.closeConnection();            
        }

        private void readPortName(string portName, out string instanceName, out string innerName)
        {
            string[] portNamePart = portName.Split(':');
            if (portNamePart.Length != 2)
                throw new CCAExceptionImpl(CCAExceptionType.BadPortName);
            instanceName = portNamePart[0];
            innerName = portNamePart[1];

/*            int index = portName.LastIndexOf("[.]");
            if (index < 0)
                throw new CCAExceptionImpl(CCAExceptionType.BadPortName);
            instanceName = portName.Substring(0, index - 1);
            innerName = portName.Substring(index + 1, portName.Length - 1); */
        }
        
        [MethodImpl(MethodImplOptions.Synchronized)]
        public void unregisterUsesPort(string portName)
        {
			Console.WriteLine("Trying to unregister port " + portName);
			
            if (connByUserPort.ContainsKey(portName))
            {
				throw new CCAExceptionImpl("CCA Exception (worker): it is not possible" +
										   " to unregister a connected uses port " +
										   " (" + portName + "). Try disconnect it first.");
            }

            if (usesPortNamesInv.ContainsKey(portName))
            {
                ComponentID cid;
                usesPortNamesInv.TryGetValue(portName, out cid);
                usesPortNamesInv.Remove(portName);
                IList<string> portList;
                usesPortNames.TryGetValue(cid.getInstanceName(), out portList);
                portList.Remove(portName);
				if (portList.Count == 0)
                    usesPortNames.Remove(cid.getInstanceName());
                if (portProperties.ContainsKey(portName))
                    portProperties.Remove(portName);
				if (usesPortTypes.ContainsKey(portName))
					usesPortTypes.Remove(portName);
				port_manager.resetPort(portName);
            } 
			else 
			{
				throw new CCAExceptionImpl("CCA Exception (worker): it is not possible" +
										   " to unregister a port that was not registered port(" + portName + ")");
			}
        }
		
		private void unregisterUsesPortInfo(ComponentID cid, string portName) 
		{
			if (usesPortNames.ContainsKey(cid.getInstanceName())) 
			{
				IList<string> portList;
				usesPortNames.TryGetValue(cid.getInstanceName(), out portList);
				portList.Remove(portName);           
                if (portList.Count == 0)
                    usesPortNames.Remove(cid.getInstanceName());
                usesPortNamesInv.Remove(portName);   
                portProperties.Remove(portName);     
				usesPortTypes.Remove(portName);
				port_manager.resetPort(portName);
			} 
			else 
			{
				throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
			}
		}
		
        
        [MethodImpl(MethodImplOptions.Synchronized)]
        public void addProvidesPort(Port inPort, string portName, string type, TypeMap properties)
        {
			Console.WriteLine("addProvidesPort (WorkerObject.cs): " + portName);
            string instanceName;
            string portName_;

            readPortName(portName, out instanceName, out portName_);

			if (this.providesPorts.ContainsKey(portName))
			{
				Console.WriteLine("addProvidesPort (WorkerObject.cs): " + portName + " already defined");
				throw new CCAExceptionImpl(CCAExceptionType.PortAlreadyDefined);
			}

			ComponentID cid;
            if (componentIDs.ContainsKey(instanceName))
            {
                componentIDs.TryGetValue(instanceName, out cid);
            }
            else
            {
                throw new CCAExceptionImpl("Bad Instance Name");
            }

            this.registerProvidesPortInfo(cid, inPort, portName, type, properties);
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public TypeMap getPortProperties(string name)
        {
            TypeMap properties;
            portProperties.TryGetValue(name, out properties);
            return properties;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void removeProvidesPort(string portName)
        {
            if (connByProviderPort.ContainsKey(portName))
            {
				throw new CCAExceptionImpl("CCA Exception (worker): it is not possible" +
										   " to unregister a connected provides port." +
										   " Try disconnect it first.");
            }
			
            if (providesPortNamesInv.ContainsKey(portName))
            {
                ComponentID cid;
                providesPortNamesInv.TryGetValue(portName, out cid);
                unregisterProvidesPortInfo(cid, portName);
            }
            else
            {
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);

            }
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID getComponentID()
        {
            return frw_services.getComponentID();
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void registerForRelease(ComponentRelease callBack)
        {
            this.frw_services.registerForRelease(callBack);
        }

        private IDictionary<Services, ComponentRelease> releaseRegister = new Dictionary<Services, ComponentRelease>();

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void registerForRelease(Services services, ComponentRelease callBack)
        {
            releaseRegister.Add(services, callBack);
        }

        #endregion

        
        // ==========================================================================================================
        // END - CCA INTERFACES (Abstract Framework, Builder Services, Services) ====================================
        // ==========================================================================================================
		
        public void redirectSlice(ComponentID user_id,
                                  string user_portName,
                                  ComponentID container_id,
                                  string container_portName)
        {
            ConnectionID conn_id;
            this.connByUserPort.TryGetValue(container_id.getInstanceName() + ":" + container_portName, out conn_id);
            ComponentID provider_id = conn_id.getProvider();
            string provider_portName = conn_id.getProviderPortName();
            this.connect(user_id, user_portName, provider_id, provider_portName);
        }

		private int my_rank = -1;

        private MPI.Intracommunicator global_communicator = null;

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
        public void createInstance()
        {
            my_rank = this.global_communicator.Rank;
				System.Diagnostics.Debug.WriteLine("BEGIN - NULL Worker " + my_rank + ": Split " + " !!!");
            this.global_communicator.Split(0, my_rank);
			System.Diagnostics.Debug.WriteLine("END - NULL Worker " + my_rank + ": Split " +  " !!!");
        }


		
		//just for test
		[MethodImpl(MethodImplOptions.Synchronized)]
		public void sayHi(){
			System.Diagnostics.Debug.WriteLine("Hi, Manager ! :-)");
		}
	


        // private IList<IUnit> slices = null;


        private IDictionary<string, int> removePrefixes(string id_inner, IDictionary<string, int> d)
        {
            IDictionary<string, int> d2 = new Dictionary<string, int>();
            foreach (KeyValuePair<string, int> kvp in d)
            {
                int c = kvp.Key.IndexOf(id_inner + ".");
                if (c >= 0)
                {
                    d2.Add(kvp.Key.Substring(c + (id_inner + ".").Length), kvp.Value);
                }
                else
                {
                    d2.Add(kvp.Key, kvp.Value);
                }
            }
            return d2;
        }

		private IDictionary<string, ServiceProvider> provided_service_table = new Dictionary<string,ServiceProvider>();
		private IDictionary<string, Port> singleton_provided_port_table = new Dictionary<string,Port>();
		
		#region ServiceRegistry implementation
		public bool addService (string serviceType, ServiceProvider portProvider)
		{
			if (!provided_service_table.ContainsKey(serviceType))
			{
				provided_service_table.Add(serviceType, portProvider);
				return true;
			}
			else return false;
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
			if (provided_service_table.ContainsKey(serviceType)) 
			{
				provided_service_table.Remove(serviceType);
			}  
			else if (singleton_provided_port_table.ContainsKey(serviceType))
			{
				singleton_provided_port_table.Remove(serviceType);
			}			
			else
				throw new CCAExceptionImpl("CCA Exception (WorkerObject.removeService): there is another service registered for type " + serviceType);
			
		}
		#endregion
		
		
    }

       

        
}
