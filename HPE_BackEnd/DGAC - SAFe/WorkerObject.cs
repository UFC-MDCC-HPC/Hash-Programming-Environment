

//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.basic;
using System.Reflection;
using System.Threading;
using gov.cca;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.database;
using gov.cca.ports;
using br.ufc.pargo.hpe.ports;
using System.Diagnostics;
using br.ufc.pargo.hpe.kinds;
using System.ServiceModel;
using System.Runtime.Serialization;
using System.Collections;


delegate void GoMethod();

namespace br.ufc.pargo.hpe.backend.DGAC
{ 

	public interface IWorkerObject : gov.cca.Services, gov.cca.Component, gov.cca.ports.BuilderService, gov.cca.AbstractFramework
	{
		int perform_go(int id);

		void perform_on_initialize(int id);

		void perform_after_initialize(int id);

		TypeMap createTypeMap();
			
		void createRemoteServices(int key, ComponentID cid, TypeMap selfProperties);

		void releaseServices(Services services);

		void shutdownFramework();

		AbstractFramework createEmptyFramework(); 

		WorkerServices getServicesObjectOf(string instanceName);

		void createInstanceNull();
	
		void registerComponentID_unit(ComponentID cid, Services services, br.ufc.pargo.hpe.basic.IUnit unit);

		void registerComponentID(ComponentID cid, Services services);

		void registerForReleaseServices(Services services, ComponentRelease callBack);

		Port getServicePort(ComponentID user, string usedPortName);

		void setServicesByKey(int services);
	}
		
	 public class WorkerObject : gov.cca.AbstractFramework, 
                                 gov.cca.ports.BuilderService,
                                 gov.cca.Services,
                                 gov.cca.Component,
								 gov.cca.ports.ServiceRegistry, 
							     IWorkerObject
    {		
		#region Tables
		
		private IDictionary<string, br.ufc.pargo.hpe.basic.IUnit> unitInstances = new Dictionary<string, br.ufc.pargo.hpe.basic.IUnit>();
		public IDictionary<string, br.ufc.pargo.hpe.basic.IUnit> UnitInstances {
			get {return unitInstances;}
		}
		
		private IDictionary<string, ComponentID> componentIDs = new Dictionary<string, ComponentID>();
		public IDictionary<string, ComponentID> ComponentIDs {
			get {return componentIDs;}
		}
		
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
		//	Console.WriteLine("registerUsesPortInfo -- " + portName);
			usesPortTypes.Add (portName, type);
            usesPortNamesInv.Add(portName, cid);
			portList.Add(portName);
            portProperties.Add(portName, properties);
		}

		
		public void registerComponentID_unit(ComponentID cid, Services services, br.ufc.pargo.hpe.basic.IUnit unit) 
		{
            if (!componentIDs.ContainsKey(cid.getInstanceName()))
            {
                unitInstances.Add(cid.getInstanceName(), unit);
                componentIDs.Add(cid.getInstanceName(), cid);
				Console.WriteLine ("regiterComponentID_unit " + cid.getInstanceName());
                componentServices.Add(cid.getInstanceName(), services);
                unit.CID = cid;
            }
		}

        public void registerComponentID(ComponentID cid, Services services)
        {
            if (!componentIDs.ContainsKey(cid.getInstanceName()))
            {
                componentIDs.Add(cid.getInstanceName(), cid);
				Console.WriteLine ("registerComponentID " + cid.getInstanceName() + ", componentIDs.Count=" + componentIDs.Count + " this = " + this.GetHashCode());
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

			port_manager = new PortUsageManager();
			
            DGAC.BackEnd.worker_framework = this;

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
            //this.registerComponentID(cid, services);

			return services;
        }

		private IDictionary<int,Services> remote_services = new Dictionary<int,Services>();

		[MethodImpl(MethodImplOptions.Synchronized)]
		public void createRemoteServices(int key, ComponentID cid, TypeMap selfProperties)
		{
			Console.WriteLine ("createRemoteServices 1 " + cid.getInstanceName());
			unitProperties.Add(cid, selfProperties);
			WorkerServicesImpl services = new WorkerServicesImpl(this, cid);
			remote_services.Add (key, services);
			registerComponentID (cid, services);
			Console.WriteLine ("createRemoteServices 2 " + cid.getInstanceName());
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

		public void setServicesByKey(int services)
		{
			setServices (remote_services [services]);
		}


        #region BuilderService Members



		void configure_facet_address (IBindingKind unit_slice, string[] ip_address_facets, int[] port_facets)
		{
			foreach (KeyValuePair<int,int[]> facet in unit_slice.FacetIndexes) 
			{
				foreach (int i in facet.Value) 
				{
					FacetAccess facet_access = new FacetAccess (ip_address_facets [i], port_facets [i]);
					unit_slice.addFacetAccessInfo (i, facet_access);
					Console.WriteLine ("ADDING FACET TO UNIT SLICE - fact=" + i + ", address = " + ip_address_facets [i] + ", port = " + port_facets [i]);
				}
			}

		}

		public IDictionary<string, hpe.basic.IUnit> UnitOf {get { return unit_registry; } }

		public IDictionary<string, hpe.basic.IUnit> unit_registry = new Dictionary<string, IUnit>();

        public ComponentID createInstance(string instanceName, string class_name, TypeMap properties)
        {
			Console.WriteLine("CREATE INSTANCE");
			Connector.openConnection();

			ComponentID cid = new WorkerComponentIDImpl(instanceName);

			try {
				Console.WriteLine("createInstanceBaseForAllKinds - 1 " + instanceName);
	            unitProperties.Add(cid, properties);
				
				Console.WriteLine("createInstanceBaseForAllKinds - 2");
	            string id_unit = properties.getString(Constants.UNIT_KEY, "");
	            string library_path = properties.getString(Constants.COMPONENT_KEY, "");
				string assembly_string = properties.getString(Constants.ASSEMBLY_STRING_KEY, "");
				string[] portNames = properties.getStringArray(Constants.PORT_NAMES_KEY, new string[0]);
				int kind = Constants.kindMapping[properties.getString(Constants.KIND_KEY, "")];
				string unit_mapping_xml = properties.getString(Constants.NODES_KEY, "");
				Instantiator.UnitMappingType[] unit_mapping = LoaderApp.deserialize<Instantiator.UnitMappingType[]>(unit_mapping_xml);

				Console.WriteLine("createInstanceBaseForAllKinds - 3 ; assembly_string = " + assembly_string + "; class name = "+  class_name);
	
				ObjectHandle obj = Activator.CreateInstance(assembly_string, class_name);
	            hpe.basic.IUnit unit_slice = (hpe.basic.IUnit) obj.Unwrap();
				unit_slice.Id_unit = id_unit;
				unit_slice.PortNames = portNames;
				unit_slice.Kind = kind;
				unit_slice.ClassName = class_name;
				unit_slice.QualifiedComponentTypeName = library_path;

				unit_registry.Add(instanceName, unit_slice);

				Console.WriteLine("createInstanceBaseForAllKinds - 4");

				Services services = new WorkerServicesImpl(this, cid, unit_slice);
	            unit_slice.setServices(services);
	
				Console.WriteLine("createInstanceBaseForAllKinds - 6");

				if (properties.hasKey(Constants.KEY_KEY)) 
				{
					int this_facet_instance = properties.getInt(Constants.FACET_INSTANCE, 0);
					int this_facet = properties.getInt(Constants.FACET, 0);
					unit_slice.ThisFacetInstance = this_facet_instance;
					unit_slice.ThisFacet = this_facet;

					Console.WriteLine("createInstanceBaseForAllKinds - 7 - PASSOU DIRETO");

					unit_slice.configure_facet_topology(properties.getIntArray(Constants.FACET_TOPOLOGY,new int[0]), unit_mapping);

					if (kind == Constants.KIND_BINDING)
					{
						Console.WriteLine("createInstanceBaseForAllKinds - 8");

							IBindingKind unit_slice_binding_root = (IBindingKind) unit_slice;
							string[] ip_address_facets = properties.getStringArray(Constants.FACET_IP_ADDRESS, new string[0]);
							int[] port_facets = properties.getIntArray(Constants.FACET_PORT, new int[0]);
							Console.WriteLine("createInstanceBaseForAllKinds - 9" + ip_address_facets.Length + "," + port_facets.Length);
							configure_facet_address(unit_slice_binding_root, ip_address_facets, port_facets);
							Console.WriteLine("createInstanceBaseForAllKinds - 10");

						Console.WriteLine("createInstanceBaseForAllKinds - 11 ");
					}
	            } 
				else 
				{
					Console.WriteLine("createInstanceBaseForAllKinds - NO SPLIT");
				}
	
			}
			catch (Exception e) 
			{
				Console.WriteLine("createInstanceBaseForAllKinds - EXCEPTION");
				Console.WriteLine("EXCEPTION MESSAGE -" + e.Message);
				Console.WriteLine("INNER EXCEPTION MESSAGE -" + e.InnerException.Message);
				throw e;
			}

			Connector.closeConnection();

            return cid;
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
				Console.WriteLine("The component must unregister its uses ports and remove provides ports before destruction.");
				throw new CCAExceptionImpl(CCAExceptionType.Unexpected);				
			}
						
			// Remove instance id from tables
			componentIDs.Remove(toDie.getInstanceName());
			unitInstances.Remove(toDie.getInstanceName ());
						
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public string[] getProvidedPortNames(ComponentID cid)
        {
			Console.WriteLine ("getProvidedPortNames #1 " + cid.getInstanceName());
		    IList<string> portList;
			if (componentIDs.ContainsKey(cid.getInstanceName()))
			{
				Console.WriteLine ("getProvidedPortNames #2 " + cid.getInstanceName());
				if (providesPortNames.ContainsKey(cid.getInstanceName()))
				{
					Console.WriteLine ("getProvidedPortNames #3 " + cid.getInstanceName());
					providesPortNames.TryGetValue(cid.getInstanceName(), out portList);			
					Console.WriteLine ("getProvidedPortNames #4 " + cid.getInstanceName());
					string[] ports = new string[portList.Count];
					Console.WriteLine ("getProvidedPortNames #5 " + cid.getInstanceName());
					portList.CopyTo(ports,0);
					Console.WriteLine ("getProvidedPortNames #6 " + cid.getInstanceName());
		            return ports;
				}
				else
				{
					Console.WriteLine ("getProvidedPortNames #7 " + cid.getInstanceName());
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
            Console.WriteLine("getUsedPortNames 1 " + (cid==null));
            foreach (ComponentID n in componentIDs.Values)
                Console.WriteLine("cid {0} {1}", n.getInstanceName(), cid.getInstanceName());
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
			
			Console.WriteLine( ": begin connect " + user_port_name + " to " + provider_port_name);

			if (!usesPortNamesInv.ContainsKey(user_port_name))
            {		
				Console.WriteLine ("USES PORT NOT DEFINED ! " + user_port_name);
				foreach (string p in usesPortNamesInv.Keys)
				{
					Console.WriteLine("U KEY = " + p);
				}
			   throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);	
			}
			
			if (!providesPortNamesInv.ContainsKey(provider_port_name))
			{
				Console.WriteLine ("PROVIDES PORT NOT DEFINED ! " + provider_port_name);
				foreach (string p in providesPortNamesInv.Keys)
				{
					Console.WriteLine("P KEY = " + p);
				}
				throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);	
			}						

//			Console.WriteLine( ": connect 1");			
            ConnectionID connection = new WorkerConnectionIDImpl(provider, providingPortName, user, usingPortName);
//			Console.WriteLine( ": connect 2 " + (connection.ToString()));
            connectionList.Add(connection.ToString(), connection);
//			Console.WriteLine( ": connect 3");
            bool first_connection = addConnByProviderPort(provider_port_name, connection);
//			Console.WriteLine ( ": connect 4 " + connByUserPort.ContainsKey (user_port_name));
            connByUserPort.Add(user_port_name, connection);			
//			Console.WriteLine( ": connect 5");
			port_manager.resetPort(user_port_name);
//			Console.WriteLine( ": connect 6");
            this.tryAwakeConnectingUserPort(user_port_name);
//			Console.WriteLine( ": connect 7");

            IUnit user_unit, provider_unit;
            this.unitInstances.TryGetValue(user.getInstanceName(), out user_unit);
//			Console.WriteLine( ": connect 8");
            this.unitInstances.TryGetValue(provider.getInstanceName(), out provider_unit);
//			Console.WriteLine( ": connect 9");

            if (user_unit != null)
				user_unit.addSlice(provider_unit,usingPortName);

			Console.WriteLine( ": end connect " + user_port_name + " to " + provider_port_name + " (" + (connection==null) + ")");

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
//				Console.WriteLine ("AWAKENING " + usingPortName);   
                wait_handle.Set();
                waitingUserPorts.Remove(usingPortName);
            }
			else
			{
//				Console.WriteLine ("NOTHING TO AWAKE - " + usingPortName);
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
			Console.WriteLine ("WORKER OBJECT - disconnecting ...");

            WorkerConnectionID hpeconnID = (WorkerConnectionID) connID;
			
			string user_port_name = connID.getUser().getInstanceName() + ":" + connID.getUserPortName();
			string provider_port_name = connID.getProvider().getInstanceName() + ":" + connID.getProviderPortName();
			
			if (!port_manager.isReleased(user_port_name))
			{
				Console.WriteLine ( ": DISCONNECT - EXCEPTION RELEASE PORT - " + user_port_name);
				throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
			}
						
			if (!connectionList.ContainsKey(connID.ToString()))
			{
				throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
			}
			
            connectionList.Remove(connID.ToString ());
			Console.WriteLine( ": disconnecting " + user_port_name + " from " + provider_port_name);

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
            
			Console.WriteLine("PORT TYPE of " + providesPortName + " = " + providesPort.GetType());
			
			port_manager.addPortFetch(portName);
			
            return providesPort;
        }

        private IDictionary<string, AutoResetEvent> waitingUserPorts = new Dictionary<string, AutoResetEvent>();

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

		public Port getPort(string portName)
        {
            if (!usesPortNamesInv.ContainsKey(portName))
            {
				Console.WriteLine("PORT NOT FOUND is " + portName);
				foreach (string p in usesPortNamesInv.Keys)
				//{
				//	Console.WriteLine("KEY = " + p);
				//}
				
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }

            if (!connByUserPort.ContainsKey(portName))
            {
                // WAIT UNTIL THE PORT IS AVAILABLE.
				
				Console.WriteLine("Waiting for " + portName);
				//foreach (string p in connByUserPort.Keys)
				//{
				//	Console.WriteLine("KEY = " + p);
				//}
                AutoResetEvent wait_handle = new AutoResetEvent(false);
                waitingUserPorts.Add(portName, wait_handle);
                wait_handle.WaitOne();
            }

            Port port = this.getPortProceed(portName);
            return port;

        }
			

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
        
		private IDictionary<int, Port> remote_ports_dict = null;



		public int perform_go(int id)
		{
			Console.WriteLine ("BEGIN PERFORM GO - WORKER OBJECT " + this.GetHashCode());
			Thread t = new Thread (new ThreadStart (delegate() {
				int res = ((GoPort)remote_ports_dict[id]).go();
			}));
			t.Start ();
			//t.Join ();
			Console.WriteLine ("END PERFORM GO -  WORKER OBJECT " + this.GetHashCode());
			return 0;
		}
	
			

		public void perform_on_initialize(int id)
		{
			((InitializePort)remote_ports_dict[id]).on_initialize();
		}

		public void perform_after_initialize(int id)
		{
			((InitializePort)remote_ports_dict[id]).after_initialize();
		}

		[MethodImpl(MethodImplOptions.Synchronized)]
        public void releasePort(string portName)
        {
            if (!usesPortNamesInv.ContainsKey(portName))
            {
				//foreach (string key in usesPortNamesInv.Keys) Console.WriteLine ("key = " + key);
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }

            ConnectionID conn;
            connByUserPort.TryGetValue(portName, out conn);
            WorkerConnectionID hpeconn = (WorkerConnectionID)conn;

            port_manager.addPortRelease(portName);
			//foreach (string key in usesPortNamesInv.Keys) Console.WriteLine ("key = " + key);
        }


        /* <instanceName>.<portName>, where <instanceName> may be used to fetch the unit object, and <portName> is the inner component name.
         * 
         */
        [MethodImpl(MethodImplOptions.Synchronized)]
        public void registerUsesPort(string portName, string type, TypeMap properties)
        {
			if (usesPortNamesInv.ContainsKey(portName))
			{
				Console.WriteLine("throw new CCAExceptionImpl(CCAExceptionType.PortAlreadyDefined);");
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
				throw new CCAExceptionImpl("Bad Instance Name: " + instanceName);
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
		//	Console.WriteLine("Trying to unregister port #1" + portName);
			
            if (connByUserPort.ContainsKey(portName))
            {
				throw new CCAExceptionImpl("CCA Exception (worker): it is not possible" +
										   " to unregister a connected uses port " +
										   " (" + portName + "). Try disconnect it first.");
            }

            if (usesPortNamesInv.ContainsKey(portName))
            {
			//	Console.WriteLine ("Trying to unregister port #2" + portName);
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
				string exception_message = "CCA Exception (worker): it is not possible" +
					" to unregister a port that was not registered port(" + portName + ")";
				Console.WriteLine (exception_message);
				throw new CCAExceptionImpl(exception_message);
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
        public void registerForReleaseServices(Services services, ComponentRelease callBack)
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
        public void createInstanceNull()
        {
        }


		private int sum(int a, int b) { return a + b; }
		
		//just for test
		[MethodImpl(MethodImplOptions.Synchronized)]
		public void sayHi(){
			Console.WriteLine("Hi, Manager ! :-)");
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
