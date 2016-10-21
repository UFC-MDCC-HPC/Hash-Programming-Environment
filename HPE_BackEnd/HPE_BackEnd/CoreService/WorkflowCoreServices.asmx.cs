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

	public interface IWorkflowServices
	{
		int    openWorkflowSession  (string arch_desc_xml);
		void   registerContract     (int workflow_handle, string arch_ref, string contract, string unit_mapping);
		void   resolve              (int workflow_handle, string arch_ref);
		string deploy               (int workflow_handle, string arch_ref);
		string instantiate          (int workflow_handle, string arch_ref);
		void   run                  (int workflow_handle, string arch_ref);
		void   closeWorkflowSession (int workflow_handle);
	}

	public class WorkflowCoreServices : System.Web.Services.WebService, IWorkflowServices
    {
 
        #region Service Methods

		private static IDictionary<int,IDictionary<string,string>> workflow_contract = new Dictionary<int, IDictionary<string, string>> ();
		private static IDictionary<int,IDictionary<string,string>> workflow_unit_mapping = new Dictionary<int, IDictionary<string, string>> ();
		private static IDictionary<int,IDictionary<string,string[]>> workflow_resolution = new Dictionary<int, IDictionary<string, string[]>> ();
		private static IDictionary<int,IDictionary<string,string>> workflow_platform_address = new Dictionary<int, IDictionary<string, string>> ();
		private static IDictionary<int,IDictionary<string,int>> workflow_base_binding_port = new Dictionary<int, IDictionary<string, int>> ();
		private static IDictionary<int,IDictionary<string,int>> workflow_nodes = new Dictionary<int, IDictionary<string, int>> ();
		private static IDictionary<int,Tuple<Tuple<ComponentType,ComponentType>,   
									   Tuple<ComponentType,ComponentType>,   
									   Tuple<ComponentType,ComponentType>>> workflow_system = new Dictionary<int, Tuple<Tuple<ComponentType, ComponentType>, Tuple<ComponentType, ComponentType>, Tuple<ComponentType, ComponentType>>>();



		[WebMethod]
		public int openWorkflowSession (string arch_desc_xml)
		{
			int workflow_handle = WorkflowHandle;
			SAFeSWL.Architecture arch_desc = CoreServicesUtil.readArchitecture (arch_desc_xml);
			active_workflows.Add (workflow_handle, arch_desc);

			workflow_contract.Add (workflow_handle, new Dictionary<string, string> ());
			workflow_resolution.Add (workflow_handle, new Dictionary<string, string[]> ());
			workflow_unit_mapping.Add (workflow_handle, new Dictionary<string, string> ());
			workflow_platform_address.Add (workflow_handle, new Dictionary<string, string> ());
			workflow_base_binding_port.Add (workflow_handle, new Dictionary<string, int> ());
			workflow_nodes.Add (workflow_handle, new Dictionary<string, int> ());

			//workflow_address [workflow_handle].Add ("platform_SAFe", SAFe_address);

			return workflow_handle;
		}

		[WebMethod]
		public void registerContract(int workflow_handle, string c_ref, string contract, string unit_mapping)
		{
			registerContract (workflow_handle, c_ref, contract);
			registerUnitMapping (workflow_handle, c_ref, unit_mapping);
		}

		[WebMethod]
		public void resolve(int workflow_handle, string c_ref)
		{
			string contract = workflow_contract [workflow_handle] [c_ref];
			string[] resolution_result = resolve (contract);
			registerResolution (workflow_handle, c_ref, resolution_result);
		}
			

		[WebMethod]
		public string deploy (int workflow_handle,   // código SAFeSWL arquitetural.
			string arch_ref        // referência do componente no código arquitetural.
		)   
		{
			Console.WriteLine ("DEPLOYING " + workflow_handle);

			SAFeSWL.Architecture arch_desc = active_workflows[workflow_handle]; //CoreServiceUtils.readArchitecture (arch_desc_xml);
			string[] c_ids = workflow_contract [workflow_handle].Keys.ToArray();

			bool is_platform = CoreServicesUtil.checkIsPlatform (arch_desc, arch_ref);

			IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts = new Dictionary<string, Instantiator.ComponentFunctorApplicationType> ();
			IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping = new Dictionary<string, Instantiator.UnitMappingType[]> ();
			IDictionary<string,string> choices = new Dictionary<string, string> ();
			IDictionary<string,string> addresses = new Dictionary<string, string> ();

			for (int i = 0; i < c_ids.Length; i++) 
			{
				string cid = c_ids [i]; 
				if (workflow_contract.ContainsKey(workflow_handle) && workflow_contract[workflow_handle].ContainsKey(cid))
					contracts [cid] = LoaderApp.deserialize<Instantiator.ComponentFunctorApplicationType> (workflow_contract[workflow_handle][cid]);
				if (workflow_resolution.ContainsKey(workflow_handle) && workflow_resolution[workflow_handle].ContainsKey(cid))
					choices [cid] = LoaderApp.deserialize<ComponentReference.ComponentReference> (workflow_resolution[workflow_handle][cid][0]).component_ref;
				if (workflow_platform_address.ContainsKey(workflow_handle) && workflow_platform_address[workflow_handle].ContainsKey(cid))
					addresses [c_ids [i]] = workflow_platform_address[workflow_handle][cid];
				if (workflow_unit_mapping.ContainsKey(workflow_handle) && workflow_unit_mapping[workflow_handle].ContainsKey(cid))
					unit_mapping [c_ids [i]] = LoaderApp.deserialize<Instantiator.UnitMappingDescriptionType> (workflow_unit_mapping[workflow_handle][cid]).unit;
			}

			string result = null;

			if (is_platform) 
			{   
				Tuple<string, int, int> platform_info = deployPlatform (arch_desc, arch_ref, contracts, choices, unit_mapping, workflow_handle);
				result = platform_info.Item1;
				workflow_nodes [workflow_handle].Add (arch_ref, platform_info.Item2);
				workflow_base_binding_port [workflow_handle].Add (arch_ref, platform_info.Item3);
			}
			else
				result = deployComponent (arch_desc, arch_ref, contracts, choices, addresses);

			workflow_platform_address [workflow_handle].Add (arch_ref, result);

			return result;
		}

		[WebMethod]
		public string instantiate (int workflow_handle, string arch_ref)
		{
			try 
			{				
				SAFeSWL.Architecture arch_desc = active_workflows[workflow_handle];
				string[] c_ids = workflow_contract [workflow_handle].Keys.ToArray();

				IDictionary<string,string> platform_address_list = new Dictionary<string, string> ();
				for (int i = 0; i < c_ids.Length; i++) 
				{
					string cid = c_ids [i]; 
					if (workflow_platform_address.ContainsKey(workflow_handle) && workflow_platform_address[workflow_handle].ContainsKey(cid))
						platform_address_list [c_ids [i]] = workflow_platform_address[workflow_handle][cid];
				}

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
				SAFeSWL.Architecture arch_desc = active_workflows[workflow_handle];
				string[] c_ids = workflow_contract [workflow_handle].Keys.ToArray();

				IDictionary<string,string> platform_address_list = new Dictionary<string, string> ();
				for (int i = 0; i < c_ids.Length; i++) 
				{
					string cid = c_ids [i]; 
					if (workflow_platform_address.ContainsKey(workflow_handle) && workflow_platform_address[workflow_handle].ContainsKey(cid))
						platform_address_list [c_ids [i]] = workflow_platform_address[workflow_handle][cid];
				}
					
				//IList<Thread> bag = new List<Thread>();

				foreach (KeyValuePair<string, string> platform_info in platform_address_list) 
				{ 
					string platform_ref = platform_info.Key;
					string platform_address = platform_info.Value;
					bool is_platform = CoreServicesUtil.checkIsPlatform (arch_desc, platform_ref);
					if (is_platform)
					{
						//Thread t = new Thread(new ThreadStart(delegate() 
						//	{
								ServiceUtils.PlatformServices.PlatformServices platform_access = new ServiceUtils.PlatformServices.PlatformServices (platform_address);
								platform_access.Timeout = int.MaxValue;
								platform_access.run (arch_ref);
						//	}));
						//bag.Add(t);
						//t.Start();
					}
				}

				//foreach (Thread t_join in bag)
				//	t_join.Join();

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
			workflow_unit_mapping.Remove (workflow_handle);
			workflow_system.Remove (workflow_handle);
		}

		private string[] resolve (string contract)
        {
			Instantiator.ComponentFunctorApplicationType contextual_type = LoaderApp.deserialize<Instantiator.ComponentFunctorApplicationType> (contract);
			AbstractComponentFunctorApplication acfaRef = BackEnd.loadACFAFromInstantiator(contextual_type);

			string[] cdesc_list = null;
			try{

			br.ufc.pargo.hpe.backend.DGAC.database.Component[] cs = Resolution.findHashComponentAll(acfaRef); 			
			cdesc_list = buildComponentDescription (cs);

			}
			catch (Exception e) 
			{
				Console.WriteLine (e.Message);
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

		private static IDictionary<int,SAFeSWL.Architecture> active_workflows = new Dictionary<int, SAFeSWL.Architecture>();

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



		public void registerContract(int workflow_handle, string c_ref, string contract)
		{
			IDictionary<string,string> cs = null;
			if (!workflow_contract.TryGetValue (workflow_handle, out cs)) 
			{
				cs = new Dictionary<string, string> ();
				workflow_contract.Add (workflow_handle, cs);
			}

			if (workflow_contract.ContainsKey (workflow_handle) && workflow_contract [workflow_handle].ContainsKey (c_ref))
				cs.Remove (c_ref);
			
			cs.Add (c_ref, contract);
		}

		public void registerUnitMapping(int workflow_handle, string c_ref, string unit_mapping)
		{
			IDictionary<string,string> cs = null;
			if (!workflow_unit_mapping.TryGetValue (workflow_handle, out cs)) 
			{
				cs = new Dictionary<string, string> ();
				workflow_unit_mapping.Add (workflow_handle, cs);
			}

			if (workflow_unit_mapping.ContainsKey (workflow_handle) && workflow_unit_mapping [workflow_handle].ContainsKey (c_ref))
				cs.Remove (c_ref);
			
			cs.Add (c_ref, unit_mapping);
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
								deployPlatform(SAFeSWL.Architecture arch_desc, 
									  string arch_ref, 
			                          IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, 
			                          IDictionary<string,string> choices, 
								      IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping,
		                              int workflow_handle)
		{
			string component_ref = choices [arch_ref];

			// descobrir o endereço do Back-End do mantenedor que ofereceu esse componente plataforma
			string[] config = CoreServicesUtil.fetchPlatformConfiguration (component_ref);

			string backend_address = config[0];

			// criar a plataforma
			Tuple<string,int> platform_address = CoreServicesUtil.invokeBackEndDeploy (arch_ref, backend_address, config);   

			Tuple<Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>, Tuple<ComponentType,ComponentType>> system = null;
			if (!workflow_system.TryGetValue (workflow_handle, out system)) 
			{
				system = CoreServicesUtil.createSystem (arch_desc, contracts, unit_mapping, ref platforms);
				workflow_system.Add (workflow_handle, system);
			}

			// Deploy component contracts and system component.
			int nodes = CoreServicesUtil.invokeDeployPlatform (arch_desc, arch_ref, contracts, unit_mapping, platform_address.Item1, system.Item1.Item1, system.Item1.Item2, system.Item2.Item1, system.Item2.Item2, system.Item3.Item1, system.Item3.Item2);

			return new Tuple<string,int,int> (platform_address.Item1, int.Parse(config[1]), platform_address.Item2);
		}

		private static IList<string> platforms = null;

		private static string deployComponent(SAFeSWL.Architecture arch_desc, string arch_ref, 
			                           IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, 
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

				// determinar os endereços dos serviços Platform de cada plataforma.
				//IDictionary<string,string> platform_address_list = CoreServiceUtils.readPlatformAddresses (arch_desc);

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
			                               SAFeSWL.Architecture arch_desc, 
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

				//Tuple<string,string> cDesc = new Tuple<string,string> (c.Library_path, contract_string);
				cDescList.Add (cref_string);
			}

			string[] cDescArr = new  string[cDescList.Count];
			cDescList.CopyTo (cDescArr, 0);
			return cDescArr;
		}

	}
		


		
}
