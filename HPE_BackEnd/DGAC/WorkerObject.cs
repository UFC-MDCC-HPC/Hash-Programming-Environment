

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
using System.Diagnostics;
using br.ufc.pargo.hpe.kinds;
using System.ServiceModel;
using System.Runtime.Serialization;
using System.Collections;
using br.ufc.hpe.backend.DGAC;

delegate void GoMethod();

namespace br.ufc.pargo.hpe.backend.DGAC
{ 

	[ServiceContract(SessionMode = SessionMode.Allowed)]
	//[ServiceKnownType(typeof(TypeMapImpl))]
	public interface IWorkerObject : gov.cca.Services, gov.cca.Component, gov.cca.ports.BuilderService, gov.cca.AbstractFramework
	{
		[OperationContract]
		RemoteGoPort getRemoteGoPort(string portName);

		[OperationContract]
		RemoteGoPort getRemoteGoPortNonBlocking(string portName);

		[OperationContract]
		int perform_go(int id);

		//[OperationContract]
		//int PerformGo(int id);

		[OperationContractAttribute(AsyncPattern=true)]
		IAsyncResult BeginPerformGo(int id, AsyncCallback callback, object asyncState);

		// Note: There is no OperationContractAttribute for the end method.
		int EndPerformGo(IAsyncResult result);

		[OperationContract]
		RemoteInitializePort getRemoteInitializePort(string portName);

		[OperationContract]
		RemoteInitializePort getRemoteInitializePortNonBlocking(string portName);

		[OperationContract]
		void perform_on_initialize(int id);

		[OperationContract]
		void perform_after_initialize(int id);

		[OperationContract]
		TypeMap createTypeMap();
			
		[OperationContract]
		void createRemoteServices(int key, ComponentID cid, TypeMap selfProperties);

		[OperationContract]
		void linkToRemoteServices(int key, ComponentID cid);

		[OperationContract]
		void releaseServices(Services services);

		[OperationContract]
		void shutdownFramework();

		[OperationContract]
		AbstractFramework createEmptyFramework(); 

		[OperationContract]
		WorkerServices getServicesObjectOf(string instanceName);

		[OperationContract]
		void createInstanceNull();

		[OperationContract]
		void setUpCommunicationScope();

		[OperationContract]
		void registerComponentID_unit(ComponentID cid, Services services, br.ufc.pargo.hpe.basic.IUnit unit);

		[OperationContract]
		void registerComponentID(ComponentID cid, Services services);

		[OperationContract]
		void registerForReleaseServices(Services services, ComponentRelease callBack);

		[OperationContract]
		Port getServicePort(ComponentID user, string usedPortName);

		[OperationContract]
		void setServicesByKey(int services);

        [OperationContract]
        int getServicesHashCode(int services);
	}

	// Simple async result implementation.
	class GoAsyncResult : IAsyncResult
	{
		int r;

		public GoAsyncResult(int r)
		{ this.r = r; }

		public int Data
		{ get { return r; } }

		#region IAsyncResult Members
		public object AsyncState
		{ get { return (object)r; } }

		public WaitHandle AsyncWaitHandle
		{ get { throw new Exception("The method or operation is not implemented."); } }

		public bool CompletedSynchronously
		{ get { return true; } }

		public bool IsCompleted
		{ get { return true; } }
		#endregion
	}

//		 [DataContract]
	[ServiceBehavior(InstanceContextMode=InstanceContextMode.Single,
		              ConcurrencyMode=ConcurrencyMode.Multiple)]
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
		private IDictionary<string, int> providesPortsMultiple = new Dictionary<string, int>();

		private IDictionary<string, TypeMap> portProperties = new Dictionary<string, TypeMap>();

        private IDictionary<string, IList<ConnectionID>> connectionList = new Dictionary<string, IList<ConnectionID>>();
        private IDictionary<ConnectionID, TypeMap> connectionProperties = new Dictionary<ConnectionID, TypeMap>();
        private IDictionary<string, IList<ConnectionID>> connByUserPort = new Dictionary<string, IList<ConnectionID>>();
        private IDictionary<string, IList<ConnectionID>> connByProviderPort = new Dictionary<string, IList<ConnectionID>>();

		private IDictionary<string, Services> componentServices = new Dictionary<string, Services>();
				
		private void registerProvidesPortInfo(ComponentID cid, Port port, string portName, string type, TypeMap properties) 
		{
			Console.WriteLine("registerProvidesPortInfo {0}", portName);

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
            Console.WriteLine("unregisterProvidesPortInfo {0}", portName);

			IList<string> portList;
            if (providesPortNames.TryGetValue(cid.getInstanceName(), out portList))
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
            Console.WriteLine("REGISTER USES PORT INFO: {0} {1}", cid.getInstanceName(), portName);

			IList<string> portList;
            if (!usesPortNames.TryGetValue(cid.getInstanceName(), out portList))
			{
				portList = new List<string>();				
				usesPortNames[cid.getInstanceName()] = portList;
			}

            /* NOTE (09/Fev/2018): it is now possible to exist more multiple units (e.g. feeder and collector) of the same 
			 * inner component (e.g. shuffler) as slices of a unit (e.g. peer_3/peer_4). In such a case, if the units have slices 
			 * of the same inner component (e.g. shuffler_channel) the host component (shuffler) will try to register multiple times the
			 * same uses port for the shared inner component (e.g. shuffler_channel). So, registerUsesPort will accept such an attempt.
			 */

            if (!portList.Contains(portName) && usesPortNamesInv.ContainsKey(portName))
			{
				Console.WriteLine("throw new CCAExceptionImpl(CCAExceptionType.PortAlreadyDefined); ");
				throw new CCAExceptionImpl(CCAExceptionType.PortAlreadyDefined);
			} 
            else if (!portList.Contains(portName) && !usesPortNamesInv.ContainsKey(portName))
            {
                usesPortNamesInv[portName] = cid;
                portList.Add(portName);
                usesPortTypes[portName] = type;
                portProperties[portName] = properties;
            }
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
			//gov.cca.Services frw_services = getServices("worker_framework","WorkerObject",new TypeMapImpl());
            //this.setServices(frw_services);

			port_manager = new PortUsageManager();
			
            DGAC.BackEnd.worker_framework = this;

            this.global_communicator = MPI.Communicator.world;
            my_global_rank = this.global_communicator.Rank;

			Console.WriteLine ("WORKER OBJECT - MY RANK is " + my_global_rank + ", size = " + MPI.Communicator.world.Size + ", id=" + this.GetHashCode());

			if (!ThreadPool.SetMinThreads (16, 16))
				Console.WriteLine ("SET MIN THREADS FAIL !");
			
			if (!ThreadPool.SetMaxThreads (800, 800))
				Console.WriteLine ("SET MAX THREAD FAIL !");

			int workerThreadsMin, completionPortThreadsMin;
			ThreadPool.GetMinThreads (out workerThreadsMin, out completionPortThreadsMin);

			int workerThreadsMax, completionPortThreadsMax;
			ThreadPool.GetMaxThreads (out workerThreadsMax, out completionPortThreadsMax);

			Console.WriteLine ("MIN THREADS = " + workerThreadsMin + "/" + completionPortThreadsMin);
			Console.WriteLine ("MAX THREADS = " + workerThreadsMax + "/" + completionPortThreadsMax);
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

        private IDictionary<int, Services> remote_services = new Dictionary<int, Services>();

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
		public void linkToRemoteServices(int key, ComponentID cid)
		{
			WorkerServicesImpl services = (WorkerServicesImpl) this.getServicesObjectOf (cid.getInstanceName ());
			if (remote_services.ContainsKey (key))
				Console.WriteLine (this.my_global_rank + ": linkToRemoteServices - key " + key + " ALREADY REGISTERED in remote_services -- " + cid.getInstanceName());
			Console.WriteLine (this.my_global_rank + ": linkToRemoteServices - REGISTERING " + key + " in remote_services -- " + cid.getInstanceName());
			remote_services.Add (key, services);
			registerComponentID (cid, services);
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

 
		void configure_facet_address (IBindingRootKind unit_slice, string[] ip_address_facets, int[] port_facets)
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

        public ComponentID createInstance(string instanceName, string class_name, TypeMap properties)
        {
			int this_facet_instance = properties.getInt(Constants.FACET_INSTANCE, 0);
            Console.WriteLine("CREATE INSTANCE {0}/{1}", instanceName, this_facet_instance);
			Console.WriteLine(my_global_rank + ": createInstance --- " + properties.getString(Constants.KIND_KEY, "") + " " + instanceName + " --- " + class_name);

			Connector.openConnection();

			ComponentID cid = new WorkerComponentIDImpl(instanceName);
			try {
                Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 1 ", instanceName, this_facet_instance);
	            unitProperties.Add(cid, properties);
				
				Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 2", instanceName, this_facet_instance);
	            string id_unit = properties.getString(Constants.UNIT_KEY, "");
	            string library_path = properties.getString(Constants.COMPONENT_KEY, "");
				string assembly_string = properties.getString(Constants.ASSEMBLY_STRING_KEY, "");
				string[] portNames = properties.getStringArray(Constants.PORT_NAMES_KEY, new string[0]);
				int kind = Constants.kindMapping[properties.getString(Constants.KIND_KEY, "")];
				string unit_mapping_xml = properties.getString(Constants.NODES_KEY, "");
				Instantiator.UnitMappingType[] unit_mapping = LoaderApp.deserialize<Instantiator.UnitMappingType[]>(unit_mapping_xml);

				Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 3 ; assembly_string = " + assembly_string + "; class name = "+  class_name, instanceName, this_facet_instance);
	
				ObjectHandle obj = Activator.CreateInstance(assembly_string, class_name);
	            hpe.basic.IUnit unit_slice = (hpe.basic.IUnit) obj.Unwrap();
				unit_slice.Id_unit = id_unit;
				unit_slice.PortNames = portNames;
				unit_slice.Kind = kind;
				unit_slice.ClassName = class_name;
				unit_slice.QualifiedComponentTypeName = library_path;

				Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 4", instanceName, this_facet_instance);

				Services services = new WorkerServicesImpl(this, cid, unit_slice);
	            unit_slice.setServices(services);
	
				Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 6", instanceName, this_facet_instance);

				if (properties.hasKey(Constants.KEY_KEY)) {
	                int key = properties.getInt(Constants.KEY_KEY, my_global_rank);
					Console.WriteLine(my_global_rank +  ": --- BEGIN - Worker {0}/{1} -- " + my_global_rank + ": Split " + key + " !!!", instanceName, this_facet_instance);

					unit_slice.WorldComm = /*this.global_communicator;*/ this.worker_communicator; // HERON ----
					Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 61", instanceName, this_facet_instance);
					unit_slice.Communicator = (MPI.Intracommunicator) unit_slice.WorldComm.Split(1, key);
					Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 62", instanceName, this_facet_instance);
					unit_slice.PeerComm =  (MPI.Intracommunicator) unit_slice.Communicator.Split(Math.Abs(id_unit.GetHashCode()), unit_slice.Rank);
					Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 63", instanceName, this_facet_instance);

					// BRIDGE BINDING INTER-COMMUNICATOR
                    Console.WriteLine(my_global_rank +  "," + unit_slice.Communicator.Rank + ": createInstanceBaseForAllKinds {0}/{1} - 7", instanceName, this_facet_instance);

                    int[] facet_topology = properties.getIntArray(Constants.FACET_TOPOLOGY, new int[0]);
					int this_facet = properties.getInt(Constants.FACET, 0);
					unit_slice.ThisFacetInstance = this_facet_instance;
                    unit_slice.ThisFacet = facet_topology[this_facet_instance];

                    Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 7.1 - PASSOU DIRETO", instanceName, this_facet_instance);

					unit_slice.configure_facet_topology(facet_topology, unit_mapping);
					unit_slice.calculate_topology();

					Console.WriteLine(my_global_rank + ": createInstanceBaseForAllKinds {0}/{1} - 7.2 - PASSOU DIRETO", instanceName, this_facet_instance);

                    if (kind == Constants.KIND_BINDING)
					{
						IBindingKind unit_slice_binding = (IBindingKind) unit_slice; 
						unit_slice_binding.RootCommunicator = new MPI.Intercommunicator(unit_slice.Communicator, 0, global_communicator, my_global_rank == 0 ? 1 : 0, 999);

                        Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 8", instanceName, this_facet_instance);

						if (unit_slice is IBindingRootKind)
						{
							IBindingRootKind unit_slice_binding_root = (IBindingRootKind) unit_slice;
							string[] ip_address_facets = properties.getStringArray(Constants.FACET_IP_ADDRESS, new string[0]);
							int[] port_facets = properties.getIntArray(Constants.FACET_PORT, new int[0]);
							Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 9" + ip_address_facets.Length + "," + port_facets.Length, instanceName, this_facet_instance);
							configure_facet_address(unit_slice_binding_root, ip_address_facets, port_facets);
							Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 10", instanceName, this_facet_instance);
						}

						Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - 11 ", instanceName, this_facet_instance);

					}

					Console.WriteLine(this.my_global_rank + ": createInstanceForAllKinds {0}/{1}: BEGIN TOPOLOGY - SIZE", instanceName, this_facet_instance);
					foreach (KeyValuePair<string, int> unit_size in unit_slice.UnitSize)
						Console.WriteLine(this.my_global_rank + ": createInstanceForAllKinds {0}:" + unit_size.Key + "=" + unit_size.Value);

					Console.WriteLine(this.my_global_rank + ": createInstanceForAllKinds {0}/{1}: BEGIN TOPOLOGY - RANK", instanceName, this_facet_instance);
					foreach (KeyValuePair<string, int[]> unit_ranks in unit_slice.UnitRanks)
						foreach (int r in unit_ranks.Value)
							Console.WriteLine(this.my_global_rank + ": createInstanceForAllKinds {0}: " + unit_ranks.Key + "[" + r + "]");

                    Console.WriteLine(this.my_global_rank + ": createInstanceForAllKinds {0}/{1}: END TOPOLOGY", instanceName, this_facet_instance);

                    Console.WriteLine(my_global_rank +  ": --- END  - Worker {0}/{1} -- " + my_global_rank + ": Split " + key + " !!!", instanceName, this_facet_instance);
	            } else {
					Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1}- NO SPLIT", instanceName, this_facet_instance);
				}
	
			}
			catch (Exception e) 
			{
                Console.WriteLine(my_global_rank +  ": createInstanceBaseForAllKinds {0}/{1} - EXCEPTION", instanceName, this_facet_instance);
				Console.WriteLine(my_global_rank +  ": EXCEPTION MESSAGE -" + e.Message);
                if (e.InnerException != null) 
                    Console.WriteLine(my_global_rank +  ": INNER EXCEPTION MESSAGE -" + e.InnerException.Message);
				throw e;
			}

			Connector.closeConnection();
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
        private bool checkUsesPort(string user_port_name)
        {
            string user_port_name_key;
            return checkUsesPort(user_port_name, out user_port_name_key);
        }

        private bool checkUsesPort(string user_port_name, out string user_port_name_key)
        {
            string[] user_port_name_parts = user_port_name.Split(':');
			string userInstanceName = user_port_name_parts[0];
			string usingPortName = user_port_name_parts[1];

            if (!usesPortNamesInv.ContainsKey(user_port_name))
            {
                string[] w = usingPortName.Split('$');
                int i = -1;
                if (w.Length == 2)
                    i = int.Parse(w[1]);

                string usingPortName_ = w[0];
                string user_port_name_ = userInstanceName + ":" + usingPortName_;
                if (!usesPortNamesInv.ContainsKey(user_port_name_))
                {
                    Console.WriteLine("USES PORT NOT DEFINED ! " + user_port_name);
                    foreach (string p in usesPortNamesInv.Keys)
                    {
                        Console.WriteLine("U KEY = " + p);
                    }
                    user_port_name_key = null;
                    return false;
                }
                else
                {
                    user_port_name_key = user_port_name_;
                }
            }
            else
                user_port_name_key = user_port_name;
            return true;
		}

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName)
        {
            ConnectionID connection = null;

            try
            {
                string user_port_name = user.getInstanceName() + ":" + usingPortName;
                string provider_port_name = provider.getInstanceName() + ":" + providingPortName;

                Console.WriteLine(my_global_rank + ": begin connect " + user_port_name + " to " + provider_port_name);

                if (!checkUsesPort(user_port_name))
                    throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);

                Console.WriteLine("connect worker -- PASSED 1");

                if (!providesPortNamesInv.ContainsKey(provider_port_name))
                {
                    Console.WriteLine("PROVIDES PORT NOT DEFINED ! " + provider_port_name);
                    foreach (string p in providesPortNamesInv.Keys)
                    {
                        Console.WriteLine("P KEY = " + p);
                    }
                    throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
                }

				Console.WriteLine("connect worker -- PASSED 2");

				connection = new WorkerConnectionIDImpl(provider, providingPortName, user, usingPortName);

                IList<ConnectionID> l;
                if (!connectionList.TryGetValue(connection.ToString(),out l))
                {
                    l = new List<ConnectionID>();
                    connectionList[connection.ToString()] = l;
                }
                l.Add(connection);

                bool first_connection = addConnByProviderPort(provider_port_name, connection);
                Console.WriteLine("{0}: connect 4 -- {1} -- {2}", my_global_rank, this.GetHashCode(), connByUserPort.ContainsKey(user_port_name));

                IList<ConnectionID> cList;
                if (!connByUserPort.TryGetValue(user_port_name, out cList))
                {
                    cList = new List<ConnectionID>();
                    connByUserPort[user_port_name] = cList;
                }
                cList.Add(connection);

                port_manager.resetPort(user_port_name);

                this.tryAwakeConnectingUserPort(user_port_name);

                IUnit user_unit, provider_unit;
                this.unitInstances.TryGetValue(user.getInstanceName(), out user_unit);
                this.unitInstances.TryGetValue(provider.getInstanceName(), out provider_unit);

                if (user_unit != null)
                    user_unit.addSlice(provider_unit, usingPortName);

                Console.WriteLine(my_global_rank + ": end connect " + user_port_name + " to " + provider_port_name + " (" + (connection == null) + ")");
            }
            catch (Exception e)
            {
                Console.WriteLine("worker connect EXCEPTION: message = " + e.Message);
                Console.WriteLine("worker connect EXCEPTION: stack = " + e.StackTrace);
                if (e.InnerException != null)
                {
                    Console.WriteLine("worker connect INNER EXCEPTION: message = " + e.InnerException.Message);
                    Console.WriteLine("worker connect INNER EXCEPTION: stack = " + e.InnerException.StackTrace);
                    throw e;
                }
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
            foreach (IList<ConnectionID> conn_list in connectionList.Values)
                foreach (ConnectionID conn in conn_list)
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
            try
            {
				Console.WriteLine ("WORKER OBJECT - disconnecting ...");

	            WorkerConnectionID hpeconnID = (WorkerConnectionID) connID;
				
				string user_port_name = connID.getUser().getInstanceName() + ":" + connID.getUserPortName();
				string provider_port_name = connID.getProvider().getInstanceName() + ":" + connID.getProviderPortName();
				
				if (!port_manager.isReleased(user_port_name))
				{
					Console.WriteLine (my_global_rank + ": DISCONNECT - EXCEPTION RELEASE PORT - " + user_port_name);
					throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
				}
							
                if (!connectionList.ContainsKey(connID.ToString()))
				{
					throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
				}
				
                connectionList.Remove(connID.ToString());
				Console.WriteLine(my_global_rank + ": disconnecting " + user_port_name + " from " + provider_port_name);

	            connByUserPort.Remove(user_port_name);
	            connByProviderPort.Remove(provider_port_name);

	            if (connectionProperties.ContainsKey(connID))
	            {
	                connectionProperties.Remove(connID);
	            }
			}
			catch (Exception e)
			{
				Console.WriteLine("worker disconnect EXCEPTION: message = " + e.Message);
				Console.WriteLine("worker disconnect EXCEPTION: stack = " + e.StackTrace);
				if (e.InnerException != null)
				{
					Console.WriteLine("worker disconnect INNER EXCEPTION: message = " + e.InnerException.Message);
					Console.WriteLine("worker disconnect INNER EXCEPTION: stack = " + e.InnerException.StackTrace);
					throw e;
				}
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
                foreach (IList<ConnectionID> conn_list in connectionList.Values)
                    foreach (ConnectionID conn in conn_list)
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
            Port providesPort = null;

			IList<ConnectionID> conn_list;
            conn_list = connByUserPort[portName];

            if (conn_list.Count > 1)
            {
                Port multiple_provides_port = null; 
                foreach (ConnectionID conn in conn_list)
                {
                    string providesPortName = conn.getProvider().getInstanceName() + ":" + conn.getProviderPortName();

                    providesPorts.TryGetValue(providesPortName, out providesPort);

                    Console.WriteLine("MULTIPLE PORT TYPE of " + providesPortName + " = " + providesPort.GetType());

                    if (providesPort is InitializePort)
                    {
                        if (multiple_provides_port == null) multiple_provides_port = new MultipleInitializePortImpl();
                        ((MultipleInitializePort)multiple_provides_port).addPort((InitializePort)providesPort);
                    }
                    else if (providesPort is GoPort)
                    {
                        if (multiple_provides_port == null) multiple_provides_port = new MultipleGoPortImpl();
						((MultipleGoPortImpl)multiple_provides_port).addPort((GoPort)providesPort);
					}
                    else
                    {
                        const string V = "gerPortProceed : UNEXPECTED MULTIPLE PORT";
                        Console.WriteLine(V);
                        throw new Exception(V);
                    }
				}
				port_manager.addPortFetch(portName);
				providesPort = multiple_provides_port;
            }
            else 
            {
                ConnectionID conn =  connByUserPort[portName][0];
				string providesPortName = conn.getProvider().getInstanceName() + ":" + conn.getProviderPortName();

				providesPorts.TryGetValue(providesPortName, out providesPort);

				Console.WriteLine("PORT TYPE of " + providesPortName + " = " + providesPort.GetType());

				port_manager.addPortFetch(portName);
			}
        
			
            return providesPort;
        }

        private IDictionary<string, AutoResetEvent> waitingUserPorts = new Dictionary<string, AutoResetEvent>();

        	public Port getServicePort(ComponentID user, string usedPortName)
			{
				Console.WriteLine("WorkerObject.getServicePort(" + usedPortName + "): checking service port " + usedPortName);
				string portType;	
                if (usesPortTypes.TryGetValue(usedPortName, out portType))
				{
					Console.WriteLine("WorkerObject.getServicePort(" + usedPortName + "):port type is " + portType);
					Port singleton_service_port = null;
					ServiceProvider service_provider = null;
					if (usedPortName.EndsWith(Constants.REGISTRY_PORT_NAME)) 
					{
						Console.WriteLine("WorkerObject.getServicePort(" + usedPortName + "): return 1");
						return this;
					}				
					else if (this.provided_service_table.TryGetValue(portType,out service_provider))
				    { 
						string providedPortName = service_provider.createService(portType);
					    ConnectionID conn = frw_builder.connect(user, usedPortName, frw_services.getComponentID(), providedPortName);
					
						Console.WriteLine("WorkerObject.getServicePort(" + usedPortName + "): return 2");
						return getPortProceed(usedPortName);
				    }
					else if (this.singleton_provided_port_table.TryGetValue(portType, out singleton_service_port))
				    { 
						Console.WriteLine("WorkerObject.getServicePort(" + usedPortName + "): return 3");
						return singleton_service_port;
				    }
				}
   			    Console.WriteLine("WorkerObject.getServicePort(" + usedPortName + "): return null");
				return null;
			}

		public Port getPort(string portName)
        {
            Console.WriteLine("Worker" + my_global_rank + ": BEGIN getPort " + portName);

            if (!checkUsesPort(portName))
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);

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
            Console.WriteLine("Worker" + my_global_rank + ": END getPort " + portName + " TYPE:" + port.GetType());
            return port;

        }
			

        public Port getPortNonblocking(string portName)
        {
            
            if (!checkUsesPort(portName))
                 throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
 
            if (!connByUserPort.ContainsKey(portName))
            {
                Console.WriteLine("CONN NOT FOUND is {0} --- {1}", portName, this.GetHashCode());
                foreach (string key in connByUserPort.Keys)
                    Console.WriteLine("connByUserPort[{0}]", key);
                //throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
                return null;
            }

            return this.getPortProceed(portName);
        }
        
		private IDictionary<int, Port> remote_ports_dict = null;

		public RemoteGoPort getRemoteGoPort(string portName)
		{
			GoPort go_port = (GoPort) this.getPort (portName);

			if (remote_ports_dict == null)
				remote_ports_dict = new Dictionary<int, Port> ();

			int id = go_port.GetHashCode ();

			RemoteGoPort remote_go_port = new RemoteGoPort (id);
			remote_ports_dict.Add (id, go_port);

			return remote_go_port;
		}

		public RemoteGoPort getRemoteGoPortNonBlocking(string portName)
		{
			GoPort go_port = (GoPort) this.getPortNonblocking (portName);
            Console.WriteLine("getRemoteGoPortNonBlocking 1 {0} -- {1}", portName, go_port == null);

			if (remote_ports_dict == null)
				remote_ports_dict = new Dictionary<int, Port> ();

			Console.WriteLine("getRemoteGoPortNonBlocking 2" + portName);

			int id = go_port.GetHashCode ();

			Console.WriteLine("getRemoteGoPortNonBlocking 3" + portName);

			RemoteGoPort remote_go_port = new RemoteGoPort (id);
			Console.WriteLine("getRemoteGoPortNonBlocking 4" + portName);
			remote_ports_dict.Add (id, go_port);
			Console.WriteLine("getRemoteGoPortNonBlocking 5" + portName);

			return remote_go_port;
		}

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
	
		public IAsyncResult BeginPerformGo(int id, AsyncCallback callback, object asyncState)
		{
			int a1,a2;
			ThreadPool.GetAvailableThreads (out a1,out a2);

			Console.WriteLine ("BEGIN PERFORM GO ASYNC - WORKER OBJECT " + this.GetHashCode() + " --- AVAILABLE THREADS for " + this.GetHashCode() + ":" + a1 + "/" + a2);
			Thread t = new Thread (new ThreadStart (delegate() {
				int res = ((GoPort)remote_ports_dict[id]).go();
			}));
			t.Start ();
			Console.WriteLine ("END PERFORM GO ASYNC -  WORKER OBJECT " + this.GetHashCode());
			return new GoAsyncResult (t.GetHashCode());
		}

		public int EndPerformGo(IAsyncResult r)
		{
			GoAsyncResult result = r as GoAsyncResult;
			return result.Data;
		}
			
		public RemoteInitializePort getRemoteInitializePort(string portName)
		{
			InitializePort init_port = (InitializePort) this.getPort (portName);

			if (remote_ports_dict == null)
				remote_ports_dict = new Dictionary<int, Port> ();

			int id = init_port.GetHashCode ();

			RemoteInitializePort remote_init_port;
			if (!remote_ports_dict.ContainsKey(id))
				remote_ports_dict[id] = init_port;
			remote_init_port = new RemoteInitializePort(id);

			return remote_init_port;
		}

		public RemoteInitializePort getRemoteInitializePortNonBlocking(string portName)
		{
			try{

			Console.WriteLine ("getRemoteInitializePortNonBlocking 1 - " + portName);
			InitializePort init_port = (InitializePort) this.getPortNonblocking (portName);
			int id = init_port.GetHashCode ();
			Console.WriteLine ("getRemoteInitializePortNonBlocking 2 - " + portName + ", id = " + id);

			if (remote_ports_dict == null)
				remote_ports_dict = new Dictionary<int, Port> ();

			Port remote_init_port;
            if (!remote_ports_dict.ContainsKey(id))
                remote_ports_dict[id] = init_port;
			remote_init_port = new RemoteInitializePort (id);
			
			Console.WriteLine ("getRemoteInitializePortNonBlocking 3 - " + portName + ", type = " + remote_init_port.GetType());

			return (RemoteInitializePort) remote_init_port;
			}
			catch (Exception e) 
			{
				Console.Error.WriteLine("EXCEPTION = " + e.Message);
				Console.Error.WriteLine("STACK TRACE : " + e.StackTrace);
				if (e.InnerException != null) 
				{
					Console.Error.WriteLine("INNER EXCEPTION = " + e.InnerException.Message);
					Console.Error.WriteLine("INNER STACK TRACE : " + e.InnerException.StackTrace);
				}
				throw e;
			}

		}

		public void perform_on_initialize(int id)
		{
			((InitializePort)remote_ports_dict[id]).on_initialize();
		}

		public void perform_after_initialize(int id)
		{
            Console.WriteLine("PERFORM_AFTER_INITIALIZE BEGIN " + id);
			((InitializePort)remote_ports_dict[id]).after_initialize();
			Console.WriteLine("PERFORM_AFTER_INITIALIZE END " + id);
		}

		[MethodImpl(MethodImplOptions.Synchronized)]
        public void releasePort(string portName)
        {
			Console.WriteLine (my_global_rank + ": RELEASE PORT " + portName + " ATTEMPT");
            if (!checkUsesPort(portName))
            {
				Console.WriteLine(my_global_rank + ": RELEASE PORT " + portName + " FAIL. Port cannot be released.");
				//foreach (string key in usesPortNamesInv.Keys) Console.WriteLine ("key = " + key);
                throw new CCAExceptionImpl(CCAExceptionType.PortNotDefined);
            }

            //IList<ConnectionID> connL = connByUserPort[portName];
            //WorkerConnectionID hpeconn = (WorkerConnectionID)conn;

            port_manager.addPortRelease(portName);
			Console.WriteLine (my_global_rank + ": RELEASE PORT " + portName + " SUCCESS");
			//foreach (string key in usesPortNamesInv.Keys) Console.WriteLine ("key = " + key);
        }


        /* <instanceName>.<portName>, where <instanceName> may be used to fetch the unit object, and <portName> is the inner component name.
         * 
         */
        [MethodImpl(MethodImplOptions.Synchronized)]
        public void registerUsesPort(string portName, string type, TypeMap properties)
        {
            try
            {
                HPETypeMap hpe_properties = (HPETypeMap)properties;

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
                    Console.WriteLine("throw new CCAExceptionImpl: Bad Instance Name " + instanceName);
                    throw new CCAExceptionImpl("Bad Instance Name: " + instanceName);
                }

                this.registerUsesPortInfo(cid, portName, type, properties);

                Connector.closeConnection();
            }
            catch (Exception e)
            {
                Console.WriteLine("EXCEPTION: {0}", e.Message);
                if (e.InnerException != null)
                    Console.WriteLine("INNER EXCEPTION: {0}", e.InnerException.Message);
                Console.WriteLine("STACK TRACE:D {0}", e.StackTrace);
                //throw e;
            }
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
        public void unregisterUsesPort(string portName_)
        {
			//Console.WriteLine("Trying to unregister port #1" + portName);
			
            if (connByUserPort.ContainsKey(portName_))
            {
				throw new CCAExceptionImpl("CCA Exception (worker): it is not possible" +
										   " to unregister a connected uses port " +
										   " (" + portName_ + "). Try disconnect it first.");
            }

            string portName;
            if (checkUsesPort(portName_, out portName))
            //if (usesPortNamesInv.ContainsKey(portName))
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

                checkUsesPort(portName);
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
            Console.WriteLine("{0} addProvidesPort (WorkerObject.cs): {1}", this.my_global_rank, portName);
            string instanceName;
            string portName_;

            readPortName(portName, out instanceName, out portName_);

			ComponentID cid;
			if (componentIDs.ContainsKey(instanceName))
			{
				componentIDs.TryGetValue(instanceName, out cid);
			}
			else
			{
				throw new CCAExceptionImpl("Bad Instance Name");
			}

            int cardinality = 0;
            Port inPort_prime;
            if (providesPortsMultiple.TryGetValue(portName, out cardinality))
            {
                Console.WriteLine("{0}: addProvidesPort {1} MULTIPLE 0 {2}", this.my_global_rank, portName, cardinality);
                this.registerProvidesPortInfo(cid, inPort, portName + "*" + cardinality, type, properties);
                this.providesPortsMultiple.Remove(portName);
                this.providesPortsMultiple[portName] = cardinality++;
            }
            else if (providesPorts.TryGetValue(portName, out inPort_prime))
            {
				Console.WriteLine("{0}: addProvidesPort {1} MULTIPLE 1", this.my_global_rank, portName);
				this.removeProvidesPort(portName);
                this.registerProvidesPortInfo(cid, inPort_prime, portName + "*0", type, properties);
				this.registerProvidesPortInfo(cid, inPort, portName + "*1", type, properties);
                this.providesPortsMultiple[portName] = 2;
			}
            else
            {
                this.registerProvidesPortInfo(cid, inPort, portName, type, properties);
            }
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
            IList<ConnectionID> conn_id_list;
            this.connByUserPort.TryGetValue(container_id.getInstanceName() + ":" + container_portName, out conn_id_list);
            foreach (ConnectionID conn_id in conn_id_list)
            {
                ComponentID provider_id = conn_id.getProvider();
                string provider_portName = conn_id.getProviderPortName();
                this.connect(user_id, user_portName, provider_id, provider_portName);
			}
		}

		private int my_global_rank = -1;
		private int my_worker_rank = -1;

        private MPI.Intracommunicator global_communicator = null;
		private MPI.Intracommunicator worker_communicator = null;

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
			Console.WriteLine("BEGIN - NULL Worker " + my_global_rank + ": Split " + " !!!");
            this/*.global_communicator*/.worker_communicator.Split(0, my_global_rank); // HERON ----
			Console.WriteLine("END - NULL Worker " + my_global_rank + ": Split " +  " !!!");
        }

		private Intercommunicator binding_bridge_communicator = null;

		[MethodImpl(MethodImplOptions.Synchronized)]
		public void setUpCommunicationScope()
		{

			Console.WriteLine (my_global_rank + ": BEGIN - setUpCommunicationScope " + (my_global_rank == 0 ? 0 : 1));

			// CREATE THE WORKER COMMUNICATOR
			worker_communicator = (MPI.Intracommunicator) this.global_communicator.Split (my_global_rank == 0 ? 0 : 1, my_global_rank);
			my_worker_rank = worker_communicator.Rank;

			// CREATE THE INTERCOMMUNICATOR
			binding_bridge_communicator = new MPI.Intercommunicator (worker_communicator, 0, global_communicator, my_global_rank == 0 ? 1 : 0, 999);

			Console.WriteLine (my_global_rank + ": END - setUpCommunicationScope - rank = " + my_worker_rank + ", inter-rank=" + binding_bridge_communicator.Rank);
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

        public int getServicesHashCode(int services)
        {
            return remote_services[services].GetHashCode();
        }
        #endregion

    }

	[ServiceContract]
	[ServiceKnownType(typeof(IWorkerObject))]
	public interface IWorkerObjectFactory
	{
		[OperationContract]
		WorkerObject createWorkerObject();
	}

	[ServiceBehavior(InstanceContextMode=InstanceContextMode.Single)]
	public class WorkerObjectFactory : IWorkerObjectFactory
	{
		public int instance_counter = 0;

		public WorkerObject createWorkerObject()
		{
			instance_counter++;
			return new WorkerObject ();
		}
	}

	public class RemoteWorkerObjectFactory : ClientBase<IWorkerObjectFactory>, IWorkerObjectFactory
	{
		public RemoteWorkerObjectFactory (System.ServiceModel.Channels.Binding binding, EndpointAddress address) : base (binding, address) { }

		public WorkerObject createWorkerObject()
		{
			return Channel.createWorkerObject ();
		}				
	}


	public class RemoteWorkerObject : ClientBase<IWorkerObject>, IWorkerObject, gov.cca.AbstractFramework
	{
		private IDictionary<string, Services> componentServices = new Dictionary<string, Services>();
		private IDictionary<string, ComponentID> componentIDs = new Dictionary<string, ComponentID>();
		private IDictionary<ComponentID, TypeMap> unitProperties = new Dictionary<ComponentID, TypeMap>();

		public RemoteWorkerObject (System.ServiceModel.Channels.Binding binding, EndpointAddress address) : base (binding, address) 
		{ 
			this.InnerChannel.OperationTimeout = new TimeSpan(23,0,0); 
		}

		public TypeMap createTypeMap() 
		{
			return Channel.createTypeMap ();	
		}

		public Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties) 
		{
			//return Channel.getServices (selfInstanceName, selfClassName, selfProperties);

			ComponentID cid = new WorkerComponentIDImpl(selfInstanceName);
			unitProperties.Add(cid, selfProperties);
			RemoteWorkerServicesImpl services = new RemoteWorkerServicesImpl(this, cid);
			this.createRemoteServices(services.RemoteKey, cid, selfProperties);
			Console.WriteLine ("MyWorkerObject - getServices " + services.getComponentID().getInstanceName());
			return services;
		}

		public void createRemoteServices(int key, ComponentID cid, TypeMap selfProperties)
		{
			Channel.createRemoteServices (key, cid, selfProperties);
		}

		public void linkToRemoteServices(int key, ComponentID cid)
		{
			Channel.linkToRemoteServices (key, cid);
		}

		public void releaseServices(Services services) 
		{
			Channel.releaseServices (services);
		}

		public void shutdownFramework() 
		{
			Channel.shutdownFramework ();
		}

		public AbstractFramework createEmptyFramework() 
		{
			return Channel.createEmptyFramework ();
		}

		public WorkerServices getServicesObjectOf(string instanceName)
		{
			Services services;
			this.componentServices.TryGetValue (instanceName, out services);
			//	return Channel.getServicesObjectOf (instanceName);
			return (WorkerServices) services;
		}

		public void createInstanceNull()
		{
			Channel.createInstanceNull ();
		}

		public void setUpCommunicationScope()
		{
			Channel.setUpCommunicationScope ();
		}

		public void registerComponentID_unit(ComponentID cid, Services services, br.ufc.pargo.hpe.basic.IUnit unit) 
		{
			Channel.registerComponentID_unit (cid, services, unit);
		}

		public void registerComponentID(ComponentID cid, Services services)
		{
			//Channel.registerComponentID (cid, services);

			if (!componentIDs.ContainsKey(cid.getInstanceName()))
			{
				componentIDs.Add(cid.getInstanceName(), cid);
				componentServices.Add(cid.getInstanceName(), services);
			}
		}

        private bool isSpecialPortName(string port_name, String port_name_suffix)
        {
            return port_name.EndsWith(port_name_suffix) || (port_name.LastIndexOf('$') >= 0 && port_name.Split('$')[0].EndsWith(port_name_suffix));
        }

		public Port getPort(string portName)
		{
			if (isSpecialPortName(portName,"go")) 
			{
				Console.WriteLine ("REMOTE WORKER OBJECT - getPort(go)");
				return getRemoteGoPort (portName);
			}
			else if (isSpecialPortName(portName, "initialize_port")) 
			{
				Console.WriteLine ("REMOTE WORKER OBJECT - getPort(initialize_port)");
				return getRemoteInitializePort (portName);
			}

			Console.WriteLine ("REMOTE WORKER OBJECT - getPort(*)");
			return Channel.getPort (portName);
		}

		public Port getPortNonblocking(string portName)
		{
			if (isSpecialPortName(portName, "go")) 
			{
				Console.WriteLine ("REMOTE WORKER OBJECT - getPort(go)");
				return getRemoteGoPortNonBlocking (portName);
			}
			if (isSpecialPortName(portName, "initialize_port")) 
			{
				Console.WriteLine ("REMOTE WORKER OBJECT - getPort(initialize)");
				return getRemoteInitializePortNonBlocking (portName);
			}

			Console.WriteLine ("REMOTE WORKER OBJECT - getPort(*)");
			return Channel.getPortNonblocking (portName);
		}

		public RemoteGoPort getRemoteGoPort(string portName)
		{
			RemoteGoPort remote_go_port = Channel.getRemoteGoPort (portName);
			remote_go_port.Framework = this;
			return remote_go_port;
		}

		public RemoteGoPort getRemoteGoPortNonBlocking(string portName)
		{
			RemoteGoPort remote_go_port = Channel.getRemoteGoPortNonBlocking (portName);
			remote_go_port.Framework = this;
			return remote_go_port;
		}

		public int perform_go(int id)
		{			
			int res = 0;
			Console.Error.WriteLine ("BEGIN PERFORM GO - REMOTE WORKER OBJECT $$$ " + this.GetHashCode());
			res = Channel.perform_go (id);
			Console.Error.WriteLine("END PERFORM GO - REMOTE WORKER OBJECT $$$ " + this.GetHashCode());
			return res;

			//Console.WriteLine ("BEGIN PERFORM GO 1 - REMOTE WORKER OBJECT ### " + this.GetHashCode());
			//IAsyncResult res = Channel.BeginPerformGo (id, null, null);
			//Console.WriteLine ("BEGIN PERFORM GO 2 - REMOTE WORKER OBJECT ### " + this.GetHashCode());
			//res.AsyncWaitHandle.WaitOne ();
			//Console.WriteLine("END PERFORM GO - REMOTE WORKER OBJECT ###" + this.GetHashCode());
			//return Channel.EndPerformGo (res);
		}
			
		public IAsyncResult BeginPerformGo(int id, AsyncCallback callback, object asyncState)
		{
			Console.WriteLine ("BEGIN PERFORM GO ASYNC - REMOTE WORKER OBJECT ###" + this.GetHashCode());
			int res = perform_go (id);
			Console.WriteLine ("END PERFORM GO ASYNC -  REMOTE WORKER OBJECT ###" + this.GetHashCode());
			return new GoAsyncResult (res);
		}

		public int EndPerformGo(IAsyncResult r)
		{
			GoAsyncResult result = r as GoAsyncResult;
			return result.Data;
		}

		public RemoteInitializePort getRemoteInitializePort(string portName)
		{
			RemoteInitializePort remote_init_port = Channel.getRemoteInitializePort (portName);
			remote_init_port.Framework = this;
			return remote_init_port;
		}

		public RemoteInitializePort getRemoteInitializePortNonBlocking(string portName)
		{
			RemoteInitializePort remote_init_port = Channel.getRemoteInitializePortNonBlocking (portName);
			remote_init_port.Framework = this;
			return remote_init_port;
		}

		public void perform_on_initialize(int id)
		{
			Channel.perform_on_initialize (id);
		}

		public void perform_after_initialize(int id)
		{
			Channel.perform_after_initialize (id);
		}

		public void releasePort(string portName)
		{
			Channel.releasePort (portName);
		}

		public void registerUsesPort(string portName, string type, TypeMap properties)
		{
			Channel.registerUsesPort (portName, type, properties);
		}

		public void unregisterUsesPort(string portName)
		{
			Channel.unregisterUsesPort (portName);
		}

		public void addProvidesPort(Port inPort, string portName, string type, TypeMap properties)
		{
			Channel.addProvidesPort (inPort, portName, type, properties);
		}

		public TypeMap getPortProperties(string name)
		{
			return Channel.getPortProperties (name);
		}

		public void removeProvidesPort(string portName)
		{
			Channel.removeProvidesPort (portName);
		}

		public ComponentID getComponentID()
		{
			return Channel.getComponentID ();
		}

		public void registerForRelease(ComponentRelease callBack)
		{
			Channel.registerForRelease (callBack);
		}

		public void registerForReleaseServices(Services services, ComponentRelease callBack)
		{
			Channel.registerForReleaseServices(services, callBack);
		}

		public Port getServicePort(ComponentID user, string usedPortName)
		{
			if (usedPortName.EndsWith("builder_service")) 
			{
				Console.WriteLine ("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& 9");
				return this;
			}
			Console.WriteLine ("********************************** 3");
			return Channel.getServicePort (user, usedPortName);
		}

		public void setServicesByKey(int services)
		{
			Channel.setServicesByKey (services);
		}

        public int getServicesHashCode(int services)
        {
            return Channel.getServicesHashCode(services);
        }

		public void setServices(Services services)
		{					
			Channel.setServicesByKey (((RemoteWorkerServicesImpl)services).RemoteKey);
		}

		public ComponentID createInstance(string instanceName, string className, TypeMap properties) 
		{ 
			return Channel.createInstance(instanceName,className,properties);
		}

		public ComponentID[] getComponentIDs() { return Channel.getComponentIDs(); }

		public TypeMap getComponentProperties(ComponentID cid) { return Channel.getComponentProperties(cid); }

		public void setComponentProperties(ComponentID cid, TypeMap map) { Channel.setComponentProperties(cid,map); }

		public ComponentID getDeserialization(string s) { return Channel.getDeserialization(s); }

		public ComponentID getComponentID(string componentInstanceName) { return Channel.getComponentID(componentInstanceName); }

		public void destroyInstance(ComponentID toDie, float timeout) { Channel.destroyInstance(toDie, timeout); }

		public string[] getProvidedPortNames(ComponentID cid) { return Channel.getProvidedPortNames(cid); }

		public string[] getUsedPortNames(ComponentID cid) 
		{ 
			return Channel.getUsedPortNames(cid); 
		}

		public TypeMap getPortProperties(ComponentID cid, string portName) { return Channel.getPortProperties(cid,portName); }

		public void setPortProperties(ComponentID cid, string portName, TypeMap map) { Channel.setPortProperties(cid,portName,map); }

		public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName) {Console.WriteLine("RemoteWorkerObject - connecting ..."); return Channel.connect(user,usingPortName,provider,providingPortName); }

		public ConnectionID[] getConnectionIDs(ComponentID[] componentList) { return Channel.getConnectionIDs(componentList); }

		public TypeMap getConnectionProperties(ConnectionID connID) { return Channel.getConnectionProperties(connID); }

		public void setConnectionProperties(ConnectionID connID, TypeMap map) { Channel.setConnectionProperties(connID, map); }

		public void disconnect(ConnectionID connID, float timeout) {Console.WriteLine("RemoteWorkerObject - disconnecting ..."); Channel.disconnect(connID, timeout); }

		public void disconnectAll(ComponentID id1, ComponentID id2,float timeout) { Channel.disconnectAll(id1,id2,timeout); }// throws cca.CCAException ; 

	} // end interface BuilderService

}
