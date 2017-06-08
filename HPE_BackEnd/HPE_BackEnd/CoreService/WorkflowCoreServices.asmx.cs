using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend;
using System.Threading;
using System.Diagnostics;
using SAFeSWL;
using br.ufc.mdcc.hpcshelf.backend.platform;
using br.ufc.pargo.hpe.basic;


namespace br.ufc.mdcc.hpcshelf.core
{
    /// <summary>
    /// Summary description for Service1
    /// </summary>
    //[WebService(Namespace = "http://WorkflowServices.core.hpcshelf.mdcc.ufc.br/")]
    //[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    //[ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    //[System.Xml.Serialization.XmlInclude(typeof(ConcreteComponentDescriptionImpl))]


	public class WorkflowCoreServices : System.Web.Services.WebService, IWorkflowServices
    {
 
        #region Service Methods

		private static IDictionary<int,IDictionary<string,Instantiator.ComponentFunctorApplicationType>> workflow_contract = new Dictionary<int, IDictionary<string, Instantiator.ComponentFunctorApplicationType>> ();
		private static IDictionary<int,IDictionary<string,string[]>> workflow_resolution = new Dictionary<int, IDictionary<string, string[]>> ();
		private static IDictionary<int,IDictionary<string,string>> workflow_platform_address = new Dictionary<int, IDictionary<string, string>> ();
		private static IDictionary<int,IDictionary<string,int>> workflow_base_binding_port = new Dictionary<int, IDictionary<string, int>> ();
		private static IDictionary<int,IDictionary<string,int>> workflow_nodes = new Dictionary<int, IDictionary<string, int>> ();
		private static IDictionary<int,Tuple<Tuple<ComponentType,ComponentType>,   
									   Tuple<ComponentType,ComponentType>,   
									   Tuple<ComponentType,ComponentType>>> workflow_system = new Dictionary<int, Tuple<Tuple<ComponentType, ComponentType>, Tuple<ComponentType, ComponentType>, Tuple<ComponentType, ComponentType>>>();

		private IDictionary<int, IList<string>> delayed_contracts = new Dictionary<int, IList<string>>();

		private SAFePlatformServices platform_SAFe;

		public int openWorkflowSession (string arch_desc_xml, SAFePlatformServices platform_SAFe)
		{
			this.platform_SAFe = platform_SAFe;
			return openWorkflowSession (arch_desc_xml);
		}

		public string getAppName(int workflow_handle) 
		{			
			return active_workflows[workflow_handle].application_name; 
		}

		[WebMethod]
		public int openWorkflowSession (string arch_desc_xml)
		{
			int workflow_handle = WorkflowHandle;

			workflow_contract.Add (workflow_handle, new Dictionary<string, Instantiator.ComponentFunctorApplicationType> ());
			workflow_resolution.Add (workflow_handle, new Dictionary<string, string[]> ());
			workflow_platform_address.Add (workflow_handle, new Dictionary<string, string> ());
			workflow_base_binding_port.Add (workflow_handle, new Dictionary<string, int> ());
			workflow_nodes.Add (workflow_handle, new Dictionary<string, int> ());
			delayed_contracts.Add (workflow_handle, new List<string> ());

			SAFeSWL_Architecture arch_desc = CoreServicesUtil.readArchitecture (arch_desc_xml);
			active_workflows.Add (workflow_handle, arch_desc);

			SAFeSWL_Component[] cs = arch_desc.solution;
			foreach (SAFeSWL_Component c in cs)
				if (c.contract != null && c.contract.Item is Instantiator.ComponentFunctorApplicationType) 
					registerContract (workflow_handle, c.id_component, (Instantiator.ComponentFunctorApplicationType) c.contract.Item);
				else if (c.contract != null && c.contract.Item is string) { /* TODO: read from URI */ }
				else // there is no contract (c.contract==null)	
					delayed_contracts [workflow_handle].Add(c.id_component);	

			// TODO: using the manually built and deployed system componentes ..
			// CREATE SYSTEM COMPONENTS IF ALL CONTRACTS ARE AVAILABLE.
			 tryCreateSystem (workflow_handle);


			return workflow_handle;
		}

		[WebMethod]
		public void registerContract(int workflow_handle, string c_ref, string contract)
		{
			Instantiator.ComponentFunctorApplicationType contextual_type = LoaderApp.deserialize<Instantiator.ComponentFunctorApplicationType> (contract);
			registerContract (workflow_handle, c_ref, contextual_type);
			delayed_contracts[workflow_handle].Remove (c_ref);

			// CREATE SYSTEM COMPONENTS IF ALL CONTRACTS ARE AVAILABLE.
			tryCreateSystem (workflow_handle);
		}

		private void tryCreateSystem(int workflow_handle)
		{
			if (delayed_contracts [workflow_handle].Count == 0) 
			{
                Connector.openConnection();

				SAFeSWL_Architecture arch_desc = active_workflows[workflow_handle];

				IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping;
				unit_mapping = compute_unit_mapping (workflow_handle);

				Tuple<Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>> system = null;
				system = CoreServicesUtil.createSystem (active_workflows[workflow_handle], workflow_contract[workflow_handle], unit_mapping, ref platforms);

                if (system != null)
                {
                    workflow_system.Add(workflow_handle, system);

                    ComponentType c_appplication_abstract = system.Item1.Item1;
                    ComponentType c_application_concrete = system.Item1.Item2;
                    ComponentType c_workflow_abstract = system.Item2.Item1;
                    ComponentType c_workflow_concrete = system.Item2.Item2;
                    ComponentType c_system_abstract = system.Item3.Item1;
                    ComponentType c_system_concrete = system.Item3.Item2;

                    string application_abstract = LoaderApp.serialize<ComponentType>(c_appplication_abstract);
                    string application_concrete = LoaderApp.serialize<ComponentType>(c_application_concrete);
                    string workflow_abstract = LoaderApp.serialize<ComponentType>(c_workflow_abstract);
                    string workflow_concrete = LoaderApp.serialize<ComponentType>(c_workflow_concrete);
                    string system_abstract = LoaderApp.serialize<ComponentType>(c_system_abstract);
                    string system_concrete = LoaderApp.serialize<ComponentType>(c_system_concrete);

                    string system_dir = System.Environment.GetEnvironmentVariable(Constants.SYSTEM_COMPONENT_PATH) + Path.DirectorySeparatorChar + workflow_handle + Path.DirectorySeparatorChar;

                    File.WriteAllText(system_dir + arch_desc.application_name + ".Application/Application.hpe", application_abstract);
                    File.WriteAllText(system_dir + arch_desc.application_name + ".Workflow/Workflow.hpe", workflow_abstract);
                    File.WriteAllText(system_dir + arch_desc.application_name + ".System/System.hpe", system_abstract);

                    File.WriteAllText(system_dir + arch_desc.application_name + ".impl.ApplicationImpl/ApplicationImpl.hpe", application_concrete);
                    File.WriteAllText(system_dir + arch_desc.application_name + ".impl.WorkflowImpl/WorkflowImpl.hpe", workflow_concrete);
                    File.WriteAllText(system_dir + arch_desc.application_name + ".impl.SystemImpl/SystemImpl.hpe", system_concrete);
                }
                Connector.closeConnection();
			}
		}

		IDictionary<string,Instantiator.UnitMappingType[]> compute_unit_mapping(int workflow_handle)
		{
			IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping = new Dictionary<string, Instantiator.UnitMappingType[]> ();

			SAFeSWL_Architecture arch_desc = active_workflows [workflow_handle];

			IDictionary<string, int> system_platform_facet_mapping = new Dictionary<string, int> ();

			// Traverse platforms and determine the peer units.
			int peer_index = 0;
			foreach (SAFeSWL_Component c in arch_desc.solution) 
				if (c is SAFeSWL_Platform)
				{
					SAFeSWL_Platform p = (SAFeSWL_Platform)c;

					traverse_component (workflow_handle, c, peer_index, unit_mapping);

					// REMEMBER THE PEER INDEX OF THE UNIT WHERE EACH PLATFORM IS ...
					system_platform_facet_mapping.Add (p.id_component, peer_index);

					peer_index++;
				}

			IDictionary<string, string> placement = new Dictionary<string, string> ();

			// LOOK FOR PLACEMENT BINDINGS OF COMPUTATIONS AND DATA SOURCES.
			foreach (SAFeSWL_BindingService binding in arch_desc.service_binding)
				if (system_platform_facet_mapping.ContainsKey (binding.provider_port.id_component))  // is it a placement port ?
					placement.Add (binding.user_port.id_component, binding.provider_port.id_component);

			// Traverse computations and data sources to determine the peer units where they are sitted on top.
			foreach (SAFeSWL_Component c in arch_desc.solution)
				if (c is SAFeSWL_Computation || c is SAFeSWL_DataSource) 
				{
					int peer_index_of_c = system_platform_facet_mapping[placement[c.id_component]]; 
					traverse_component (workflow_handle, c, peer_index_of_c, unit_mapping);
				}

            Instantiator.UnitMappingType um;
			
            // WORKFLOW COMPONENT
			int peer_index_of_w = system_platform_facet_mapping [placement [arch_desc.workflow.id_component]];
		    um = new Instantiator.UnitMappingType();
			um.facet = 0;
			um.facetSpecified = true;
			um.facet_instance = 0;
			um.facet_instanceSpecified = true;
			um.unit_id = arch_desc.workflow.id_component;
			um.unit_index = 0;
			um.node = new int[1];
			um.node[0] = peer_index_of_w;
            unit_mapping.Add(arch_desc.workflow.id_component, new Instantiator.UnitMappingType[1] {um});

			// APPLICATION COMPONENT
			int peer_index_of_a = system_platform_facet_mapping [placement [arch_desc.application.id_component]];
			um = new Instantiator.UnitMappingType();
			um.facet = 0;
			um.facetSpecified = true;
			um.facet_instance = 0;
			um.facet_instanceSpecified = true;
			um.unit_id = arch_desc.application.id_component;
			um.unit_index = 0;
			um.node = new int[1];
			um.node[0] = peer_index_of_a;
            unit_mapping.Add(arch_desc.application.id_component, new Instantiator.UnitMappingType[1] { um });

			IDictionary<string, IDictionary<int,int>> connector_bindings = new Dictionary<string, IDictionary<int,int>> ();

			// Traverse connectors to determine the peer units where they are sitted on top.
			foreach (SAFeSWL_Component c in arch_desc.solution)
				if (c is SAFeSWL_Connector) 
					connector_bindings[c.id_component] = new Dictionary<int, int> ();

			foreach (SAFeSWL_BindingService binding in arch_desc.service_binding)
				if (!system_platform_facet_mapping.ContainsKey (binding.provider_port.id_component)) // ignore placement bindings
				{
					if (connector_bindings.ContainsKey (binding.user_port.id_component)) 
						check_facet_aligment (connector_bindings, binding.user_port, binding.provider_port, system_platform_facet_mapping, placement);
					
					if (connector_bindings.ContainsKey (binding.provider_port.id_component)) 
						check_facet_aligment (connector_bindings, binding.provider_port, binding.user_port, system_platform_facet_mapping, placement);
				}
			
			foreach (SAFeSWL_BindingAction binding in arch_desc.action_binding)
				foreach (SAFeSWL_Port peer in binding.peer)
					foreach (SAFeSWL_Port other_peer in binding.peer)
						if (peer != other_peer)
							if (connector_bindings.ContainsKey (peer.id_component)) 
							    check_facet_aligment (connector_bindings, peer, other_peer, system_platform_facet_mapping, placement);
			
			foreach (KeyValuePair<string, IDictionary<int,int>> kv in connector_bindings)
			{
				IList<Instantiator.UnitMappingType> um_list = new List<Instantiator.UnitMappingType>();
				string c_id = kv.Key;
				IDictionary<int,int> c_ports = kv.Value;

				foreach (KeyValuePair<int,int> connector_facet in c_ports) 
				{

					string cRef = workflow_contract [workflow_handle] [c_id].component_ref;

					AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath (cRef);
					IList<Interface> unit_list = BackEnd.idao.listByFacet (acf.Id_abstract, connector_facet.Key);

					// single unit expected here, called "node".
					foreach (Interface unit in unit_list) 
					{
						Instantiator.UnitMappingType umb = new Instantiator.UnitMappingType ();
						umb.facet = connector_facet.Key;
						umb.facetSpecified = true;
						umb.facet_instance = connector_facet.Key;
						umb.facet_instanceSpecified = true;
						umb.unit_id = unit.Id_interface;
						umb.unit_index = 0;
						umb.node = new int[1];
						umb.node [0] = connector_facet.Value;

						um_list.Add (umb);
					}

				}
				unit_mapping.Add(c_id, um_list.ToArray());
			}

			return unit_mapping;
		}

		void check_facet_aligment (IDictionary<string, IDictionary<int,int>> connector_bindings, SAFeSWL_Port port_connector, SAFeSWL_Port port_computation, IDictionary<string, int> system_platform_facet_mapping, IDictionary<string, string> placement)
		{
			int host_facet = system_platform_facet_mapping [placement [port_computation.id_component]];
			int new_host_facet = host_facet;
			if (!connector_bindings [port_connector.id_component].ContainsKey (port_connector.facet))
				connector_bindings [port_connector.id_component] [port_connector.facet] = new_host_facet;
			else
				host_facet = connector_bindings [port_connector.id_component] [port_connector.facet];
            if (new_host_facet != host_facet)
                Console.WriteLine("INDIRECT BINDING {0}.{1} - {2}.{3}", port_connector.id_component, port_connector.id_port, port_computation.id_component, port_computation.id_port);			
		}

		void traverse_component (int workflow_handle, SAFeSWL_Component c, int peer_index_of_c, IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping)
		{
			IList<Instantiator.UnitMappingType> um_list = new List<Instantiator.UnitMappingType> ();

			string cRef = workflow_contract [workflow_handle] [c.id_component].component_ref;

			AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath (cRef);
			IList<Interface> unit_list = BackEnd.idao.list (acf.Id_abstract);

			// single unit expected here, called "node".
			foreach (Interface unit in unit_list) 
			{
				Instantiator.UnitMappingType um = new Instantiator.UnitMappingType ();
				um.facet = 0;
				um.facetSpecified = true;
				um.facet_instance = 0;
				um.facet_instanceSpecified = true;
				um.unit_id = unit.Id_interface;
				um.unit_index = 0;
				um.node = new int[1];
				um.node [0] = peer_index_of_c;

				um_list.Add (um);
			}

			unit_mapping.Add (c.id_component, um_list.ToArray ());

		}

		void registerContract(int workflow_handle, string c_ref, Instantiator.ComponentFunctorApplicationType contextual_type)
		{
			IDictionary<string,Instantiator.ComponentFunctorApplicationType> cs = null;
			if (!workflow_contract.TryGetValue (workflow_handle, out cs)) 
			{
				cs = new Dictionary<string, Instantiator.ComponentFunctorApplicationType> ();
				workflow_contract.Add (workflow_handle, cs);
			}

			if (workflow_contract.ContainsKey (workflow_handle) && workflow_contract [workflow_handle].ContainsKey (c_ref))
				cs.Remove (c_ref);

			cs.Add (c_ref, contextual_type);
		}

		[WebMethod]
		public void resolve(int workflow_handle, string c_ref)
		{
			Instantiator.ComponentFunctorApplicationType contract = workflow_contract [workflow_handle] [c_ref];
			string[] resolution_result = resolve (contract);
			registerResolution (workflow_handle, c_ref, resolution_result);
		}
			

		[WebMethod]
		public string deploy (int workflow_handle,   // código SAFeSWL arquitetural.
						      string arch_ref        // referência do componente no código arquitetural.
		)   
		{
			Console.WriteLine ("DEPLOYING 0 - " + workflow_handle);
			string result = null;

			SAFeSWL_Architecture arch_desc = active_workflows[workflow_handle]; //CoreServiceUtils.readArchitecture (arch_desc_xml);

			string[] c_ids = workflow_contract [workflow_handle].Keys.ToArray();

			IDictionary<string,string> choices = new Dictionary<string, string> ();
			IDictionary<string,string> addresses = new Dictionary<string, string> ();

            for (int i = 0; i < c_ids.Length; i++)
            {
                string cid = c_ids[i];
                if (workflow_resolution.ContainsKey(workflow_handle) && workflow_resolution[workflow_handle].ContainsKey(cid))
                    if (workflow_resolution[workflow_handle][cid].Length > 0)
                        choices[cid] = LoaderApp.deserialize<ComponentReference.ComponentReference>(workflow_resolution[workflow_handle][cid][0]).component_ref;
				if (workflow_platform_address.ContainsKey(workflow_handle) && workflow_platform_address[workflow_handle].ContainsKey(cid))
					addresses [cid] = workflow_platform_address[workflow_handle][cid];
			}

			bool is_platform = CoreServicesUtil.checkIsPlatform (arch_desc, arch_ref);

			if (is_platform) 
			{   
				if (!arch_ref.Equals ("platform_SAFe")) 
				{
					Tuple<string, int, int> platform_info = deployPlatform (arch_desc, arch_ref, choices, workflow_handle);
					result = platform_info.Item1;
					workflow_nodes [workflow_handle] [arch_ref] = platform_info.Item2;
					workflow_base_binding_port [workflow_handle] [arch_ref] = platform_info.Item3;
				} 
				else 
				{
					deployPlatform (arch_desc, arch_ref, workflow_handle, platform_SAFe);
					result = ((SAFePlatformServices)platform_SAFe).Address;
					workflow_nodes [workflow_handle] [arch_ref] = 1;
					workflow_base_binding_port [workflow_handle] [arch_ref] = platform_SAFe.getBaseBindingPort();
				}

				workflow_platform_address[workflow_handle][arch_ref] = result;

				if (delayed_instantiations.ContainsKey(arch_ref))
	                foreach (Thread t in delayed_instantiations[arch_ref])
	                {
						t.Start(platforms.IndexOf(arch_ref));
						t.Join();
					}
			}
			else
				result = deployComponent (arch_desc, arch_ref, choices, addresses);

			return result;
		}

        private IDictionary<string, IList<Thread>> delayed_instantiations = new Dictionary<string, IList<Thread>>();

		[WebMethod]
		public string instantiate (int workflow_handle, string arch_ref)
		{
			try 
			{				
				SAFeSWL_Architecture arch_desc = active_workflows[workflow_handle]; //CoreServiceUtils.readArchitecture (arch_desc_xml);

				string[] c_ids = workflow_contract [workflow_handle].Keys.ToArray();

				IDictionary<string,string> platform_address_list = new Dictionary<string, string> ();

 				IList<Thread> bag_of_threads = new List<Thread>();
				
                for (int i = 0; i < platforms.Count; i++)
                {
                    string platform_ref = platforms[i];
					Thread t = new Thread(new ParameterizedThreadStart(delegate (object o)
                        {
	                        int facet_instance = (int)o;
	                        platform_ref = platforms[facet_instance];
	                        string platform_address = workflow_platform_address[workflow_handle][platform_ref];

							int[] facet = new int[platforms.Count];
							string[] facet_address = new string[platforms.Count];
							int[] nodes = new int[platforms.Count];

                            for (int j = 0; j < platforms.Count; j++)
	                        {
                                int base_binding_port_a = workflow_base_binding_port[workflow_handle].ContainsKey(platforms[j]) ? workflow_base_binding_port[workflow_handle][platforms[j]] : 100;
                                Uri uri_a = workflow_platform_address[workflow_handle].ContainsKey(platforms[j]) ? new Uri(workflow_platform_address[workflow_handle][platforms[j]]) : new Uri("http://127.0.0.1:100");
								facet_address[j] = "http://" + uri_a.Host + ":" + base_binding_port_a;
								nodes[j] = workflow_nodes[workflow_handle].ContainsKey(platforms[j]) ? workflow_nodes[workflow_handle][platforms[j]] : 1;
                                facet[j] = j;
							}

							if (!platform_ref.Equals("platform_SAFe"))
							{
								ServiceUtils.PlatformServices.PlatformServices platform_access = new ServiceUtils.PlatformServices.PlatformServices(platform_address);
								platform_access.Timeout = int.MaxValue;
                                Console.WriteLine("BEGIN CORE INSTANTIATE {0} on {1}", arch_ref, platform_ref);
                                platform_access.instantiate(arch_desc.application_name, arch_ref, facet_instance, facet, facet_address, nodes);
								Console.WriteLine("END CORE INSTANTIATE {0} on {1}", arch_ref, platform_ref);
							}
							else
							{
								Console.WriteLine("BEGIN CORE INSTANTIATE {0} on {1}", arch_ref, platform_ref);
								platform_SAFe.instantiate(arch_desc.application_name, arch_ref, facet_instance, facet, facet_address, nodes);
								Console.WriteLine("END CORE INSTANTIATE {0} on {1}", arch_ref, platform_ref);
							}
						}));
					
                    if (workflow_platform_address.ContainsKey(workflow_handle) && workflow_platform_address[workflow_handle].ContainsKey(platform_ref))
                    {
                        t.Start(platforms.IndexOf(platform_ref));
						bag_of_threads.Add(t);
					}
                    else 
                    {
                        if (!delayed_instantiations.ContainsKey(platform_ref))
                            delayed_instantiations[platform_ref] = new List<Thread>();
                        delayed_instantiations[platform_ref].Add(t);   
                    }
                }
				
                // BARRIER (waiting completion)
				foreach (Thread t in bag_of_threads) t.Join ();

			}
			catch (Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				Console.Error.WriteLine (e.StackTrace);
				if (e.InnerException != null) 
				{
					Console.Error.WriteLine (e.InnerException.Message);
					Console.Error.WriteLine (e.InnerException.StackTrace);
				}					
			}

			return null;
		}

		[WebMethod]
		public void run(int workflow_handle, string arch_ref)
		{
			try 
			{
				SAFeSWL_Architecture arch_desc = active_workflows[workflow_handle]; //CoreServiceUtils.readArchitecture (arch_desc_xml);

                for (int i = 0; i < platforms.Count; i++)
				{
					string platform_ref = platforms[i];
                    if (workflow_platform_address[workflow_handle].ContainsKey(platform_ref))
                    {
						Console.WriteLine("RUN {0} on {1}", arch_ref, platform_ref);
						string platform_address = workflow_platform_address[workflow_handle][platform_ref];
                        if (!platform_ref.Equals("platform_SAFe"))
                        {
                            ServiceUtils.PlatformServices.PlatformServices platform_access = new ServiceUtils.PlatformServices.PlatformServices(platform_address);
                            platform_access.Timeout = int.MaxValue;
                            platform_access.run(arch_ref);
                        }
                        else
                        {
                            platform_SAFe.run(arch_ref);
                        }
                    }
				}





				//SAFeSWL_Architecture arch_desc = active_workflows[workflow_handle];
				//string[] c_ids = workflow_contract [workflow_handle].Keys.ToArray();

				//IDictionary<string,string> platform_address_list = new Dictionary<string, string> ();
				//for (int i = 0; i < c_ids.Length; i++) 
				//{
				//	string cid = c_ids [i]; 
				//	if (workflow_platform_address.ContainsKey(workflow_handle) && workflow_platform_address[workflow_handle].ContainsKey(cid))
				//		platform_address_list [c_ids [i]] = workflow_platform_address[workflow_handle][cid];
				//}
					
				////IList<Thread> bag = new List<Thread>();

				//foreach (KeyValuePair<string, string> platform_info in platform_address_list) 
				//{ 
				//	string platform_ref = platform_info.Key;
				//	string platform_address = platform_info.Value;
				//	bool is_platform = CoreServicesUtil.checkIsPlatform (arch_desc, platform_ref);
				//	if (is_platform)
				//	{
				//		ServiceUtils.PlatformServices.PlatformServices platform_access = new ServiceUtils.PlatformServices.PlatformServices (platform_address);
				//		platform_access.Timeout = int.MaxValue;
				//		platform_access.run (arch_ref);
				//	}
				//}


			}
			catch (Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				Console.Error.WriteLine (e.StackTrace);
				if (e.InnerException != null) 
				{
					Console.Error.WriteLine (e.InnerException.Message);
					Console.Error.WriteLine (e.InnerException.StackTrace);
				}					
			}
		}

		[WebMethod]
		public void wait(int workflow_handle)
		{
			IList<Thread> bag = new List<Thread> ();

			foreach (string pid in platforms) 
			{
				string platform_address = workflow_platform_address [workflow_handle] [pid];

				Thread t = new Thread (new ThreadStart (delegate() 
				{
					ServiceUtils.PlatformServices.PlatformServices platform_access = new ServiceUtils.PlatformServices.PlatformServices (platform_address);
					platform_access.Timeout = int.MaxValue;
					platform_access.wait ();
				}));

				t.Start ();
				bag.Add (t);
			}

			foreach (Thread t_join in bag)
				t_join.Join ();

		}

		[WebMethod]
		public void closeWorkflowSession (int workflow_handle)
		{
			active_workflows.Remove (workflow_handle);
			if (free_workflow_handles == null)
				free_workflow_handles = new List<int> ();
			free_workflow_handles.Add (workflow_handle);
			workflow_contract.Remove (workflow_handle);
			workflow_resolution.Remove (workflow_handle);
			workflow_platform_address.Remove (workflow_handle);
			workflow_base_binding_port.Remove (workflow_handle);
			workflow_nodes.Remove (workflow_handle);
			workflow_system.Remove (workflow_handle);

		}

		private string[] resolve (Instantiator.ComponentFunctorApplicationType contextual_type)
        {
			AbstractComponentFunctorApplication acfaRef = BackEnd.loadACFAFromInstantiator(contextual_type);

			string[] cdesc_list = null;
			try{

			br.ufc.pargo.hpe.backend.DGAC.database.Component[] cs = Resolution.findHashComponentAll(acfaRef); 			
			cdesc_list = buildComponentDescription (cs);

			}
			catch (Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				throw e;
			}


			return cdesc_list;           
        }
			

		/* A operação deploy tem o comportamento dependente da espécie do componente que recebe. 
		 * 1) Caso se trata de um componente plataforma, deve ler o arquivo SAFeSWL para gerar os componentes do sistema computacional. 
		 *    Para isso, chama a operação LoaderSystem.deploySystemComponent, que já está prototipada.
		 *    Para descobrir o endereço do Back-End, deve consultar o catálogo do componente, buscando o componente escolhido.
		 *    Finalmente, invoca a operação deploy para implantar os componentes do sistema computacional na plataforma.
		 * 2) Caso se trate de um componente de computação ou conector, deve ler o arquivo SAFeSWL para descobrir os endereços dos serviços Platform das plataformas
		 *    nas quais as facetas do componente irão ser instaladas. Então, invoca a operaçao deploy de cada serviço Platform, passando como argumento os arquivos 
		 *    ".hpe" dos componentes necessários para carregar o componente na instanciação. Inclusive, deve implantar as facetas dos bindings com a aplicação no serviço
		 *    Platform do lado do SAFe. 
		 */

		private static IDictionary<int,SAFeSWL_Architecture> active_workflows = new Dictionary<int, SAFeSWL_Architecture>();

		private static int next_workflow_handle = 0;
		private static IList<int> free_workflow_handles = null;

		private static object lock_wh = new object ();
		private static int WorkflowHandle {
			get {
					int wh = -1;

					if (free_workflow_handles != null && free_workflow_handles.Count > 0) 
					{
						wh = free_workflow_handles [0];
						free_workflow_handles.RemoveAt (0);
					}
					else 
						lock (lock_wh) 
						   wh = next_workflow_handle++;
					return wh;
				}
		}



		public void registerResolution(int workflow_handle, string c_ref, string[] resolution_result)
		{
			IDictionary<string,string[]> cs = null;
			if (!workflow_resolution.TryGetValue (workflow_handle, out cs)) 
			{
				cs = new Dictionary<string, string[]> ();
				workflow_resolution.Add (workflow_handle, cs);
			}

			if (workflow_resolution.ContainsKey (workflow_handle) && workflow_resolution [workflow_handle].ContainsKey (c_ref))
				cs.Remove (c_ref);

			cs.Add (c_ref, resolution_result);
		}

			
		private static Tuple<string,int,int> 
					   deployPlatform(SAFeSWL_Architecture arch_desc, 
									  string arch_ref, 
			                          IDictionary<string,string> choices, 
		                              int workflow_handle)
		{
			string component_ref = choices [arch_ref];

			// descobrir o endereço do Back-End do mantenedor que ofereceu esse componente plataforma
			string[] config = CoreServicesUtil.fetchPlatformConfiguration (component_ref);

			string backend_address = config[0];

			Tuple<Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>> system = null;
			workflow_system.TryGetValue (workflow_handle, out system);

			// criar a plataforma
			Tuple<string,int,int> platform_address = CoreServicesUtil.invokeBackEndDeploy (arch_ref, backend_address, config);

			// Deploy component contracts and system component.
			//CoreServicesUtil.invokeDeployPlatform (arch_desc, arch_ref, platform_address.Item1, system.Item1.Item1, system.Item1.Item2, system.Item2.Item1, system.Item2.Item2, system.Item3.Item1, system.Item3.Item2);

			return new Tuple<string,int,int> (platform_address.Item1, platform_address.Item3, platform_address.Item2);
		}

		private static void 
		deployPlatform(SAFeSWL_Architecture arch_desc, 
			string arch_ref, 
			int workflow_handle,
			IPlatformServices platform_SAFe)
		{
	
			Tuple<Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>> system = null;
			workflow_system.TryGetValue (workflow_handle, out system);

			// TODO: using the manually built and deployed system componentes ...
			// Deploy component contracts and system component.
			// CoreServicesUtil.invokeDeployPlatform (arch_desc, arch_ref, platform_SAFe, system.Item1.Item1, system.Item1.Item2, system.Item2.Item1, system.Item2.Item2, system.Item3.Item1, system.Item3.Item2);

		}

		private static IList<string> platforms = null;

		private static string deployComponent(SAFeSWL_Architecture arch_desc, string arch_ref, 
			                                  IDictionary<string,string> choices, 
			                                  IDictionary<string,string> platform_address_list)
		{
			try 
			{
				string component_ref = choices [arch_ref];

				// determinar as plataformas onde cada componente da arquitetura deve instanciar suas facetas.
				IDictionary<string,Tuple<int,string>[]> platform_placement_list = LoaderSystem.placementOfComponents (arch_desc);
				// determinar quais as plataformas para o componente identificado como arch_ref no código arquitetural.
				Tuple<int,string>[] platform_placement = platform_placement_list [arch_ref];

				for (int facet_instance = 0; facet_instance < platform_placement.Length; facet_instance++) 
				{
					string platform_ref = platform_placement [facet_instance].Item2;

					// determinar qual o endereço da plataforma onde deve ser instanciada a facet-ésima faceta do componente arch_ref.
					string platform_address = platform_address_list [platform_ref];

					string config_filename = Constants.PATH_TEMP_WORKER + component_ref + ".hpe";
					string config_contents = File.ReadAllText (config_filename);

					// invocar o serviço de implantação na plataforma do endereço platform_address para cada componente.
					CoreServicesUtil.invokeDeployComponent (platform_address, config_contents);
				}
			}
			catch (Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				if (e.InnerException != null)
					Console.Error.Write (e.InnerException.Message);
			}

			return "deployed";
		}



		private string instantiatePlatform(int workflow_handle,
			                               SAFeSWL_Architecture arch_desc, 
										   string arch_ref, 
										   IDictionary<string,string> platform_address_list)
		{			

			int[] facet = new int[platforms.Count];
			string[] facet_address = new string[platforms.Count];
			int[] nodes = new int[platforms.Count];
			for (int i = 0; i < platforms.Count; i++) 
			{
				facet [i] = i;
				int base_binding_port = workflow_base_binding_port [workflow_handle] [platforms [i]];
				string a = workflow_platform_address [workflow_handle] [platforms [i]];
				Uri uri_a = new Uri (a);
				facet_address [i] = "http://" + uri_a.Host + ":" + base_binding_port;
				nodes [i] = workflow_nodes [workflow_handle].ContainsKey (platforms [i]) ? workflow_nodes [workflow_handle] [platforms [i]] : 0;
			}

			// Efetuar a invocação da operação instantiate do componente sistema na plataforma platform_address.

			IList<Thread> bag_of_threads = new List<Thread> ();
			foreach (KeyValuePair<string, string> platform_info in platform_address_list) 
			{ 
				string platform_ref = platform_info.Key;
				string platform_address = platform_info.Value;
				int facet_instance = platforms.IndexOf (platform_ref);
				bool is_platform = CoreServicesUtil.checkIsPlatform (arch_desc, platform_ref);
				if (is_platform)
				{
					Thread t = new Thread(new ThreadStart(delegate() 
						{
							ServiceUtils.PlatformServices.PlatformServices platform_access = new ServiceUtils.PlatformServices.PlatformServices (platform_address);
							platform_access.Timeout = int.MaxValue;
							platform_access.instantiate (arch_desc.application_name, arch_ref, facet_instance, facet, facet_address, nodes);
						}));
					t.Start();
					bag_of_threads.Add (t);
					//t.Join ();
				}
			}

			// BARRIER (waiting completion)
			foreach (Thread t in bag_of_threads) t.Join ();


			return "instantiated";
		}


        #endregion
		
		
		private string[] buildComponentDescription (br.ufc.pargo.hpe.backend.DGAC.database.Component[] cs)
		{
			IList<string> cDescList = new List<string> ();

			foreach (br.ufc.pargo.hpe.backend.DGAC.database.Component c in cs) 
			{
				Instantiator.ComponentFunctorApplicationType contract;

				AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve (c.Id_functor_app);
				contract = BackEnd.saveACFAToInstantiator (acfa);

				ComponentReference.ComponentReference cref = new ComponentReference.ComponentReference ();
				cref.component_ref = c.Library_path;
				cref.contract = contract;

				string cref_string = LoaderApp.serialize<ComponentReference.ComponentReference> (cref);

				cDescList.Add (cref_string);
			}

			string[] cDescArr = new  string[cDescList.Count];
			cDescList.CopyTo (cDescArr, 0);
			return cDescArr;
		}

	}
		


		
}
