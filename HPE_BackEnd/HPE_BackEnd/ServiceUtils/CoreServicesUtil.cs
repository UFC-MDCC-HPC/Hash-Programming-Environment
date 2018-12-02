using System;
using System.Collections.Generic;
using System.IO;
using System.Threading;
using System.Xml;
using System.Xml.Serialization;
using br.ufc.mdcc.hpcshelf.backend.platform;
using br.ufc.pargo.hpe.backend;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using SAFeSWL;

namespace br.ufc.mdcc.hpcshelf.core
{
    public interface IBackendServices 
	{
		string deploy (string platform_config);
	}

	public class CoreServicesUtil
	{

		#region processing SAFeSWL

		public static SAFeSWL_Architecture readArchitecture (string arch_desc_xml)
		{
			string filename = System.IO.Path.GetTempFileName ();
			File.WriteAllText (filename, arch_desc_xml);
			SAFeSWL_Architecture arch_desc = CoreServicesUtil.DeserializeArchitecture_SAFeSWL(filename);
			return arch_desc;
		}

		private static SAFeSWL_Architecture DeserializeArchitecture_SAFeSWL(string filename)
		{
			// Declare an object variable of the type to be deserialized.
			SAFeSWL_Architecture i = null;
			FileStream fs = null;
			try
			{
				// Create an instance of the XmlSerializer specifying type and namespace.
				XmlSerializer serializer = new XmlSerializer(typeof(SAFeSWL_Architecture));

				// A FileStream is needed to read the XML document.
				fs = new FileStream(filename, FileMode.Open);

				XmlReader reader = new XmlTextReader(fs);

				// Use the Deserialize method to restore the object's state.
				i = (SAFeSWL_Architecture)serializer.Deserialize(reader);
			}
			catch (Exception e)
			{
				Console.Error.WriteLine (e.Message);
				Console.WriteLine(e.StackTrace);
			}
			finally
			{
				if (fs != null)
					fs.Close();
			}

			return i;

		}

		public static bool checkIsPlatform (SAFeSWL_Architecture arch_desc, string arch_ref)
		{
			SAFeSWL_Component[] cs = arch_desc.solution;
			foreach (SAFeSWL_Component c in cs) 
			{
				if (c.id_component.Equals (arch_ref) && c is SAFeSWL_Platform)
					return true;
			}

			return false;
		}

/*		public static IDictionary<string,string> readPlatformAddresses (SAFeSWL_Architecture arch_desc)
		{
			IDictionary<string,string> result = new Dictionary<string, string> ();

			SAFeSWL_Component[] cs = arch_desc.solution;
			foreach (SAFeSWL_Component c in cs) 
			{
				if (c is SAFeSWL_Platform)
					result.Add(c.id_component,((SAFeSWL_Platform)c).platform_address);
			}

			return result;
		}

		public static string determineSystemComponentRef(SAFeSWL_Architecture arch_desc)
		{
			return arch_desc.application_name;
		}

*/


		#endregion


		#region accessing the catalog



		public static string[] fetchPlatformConfiguration (string component_ref)
		{
			/* The concrete platform component has a single unit (homogenous platform), so-called "node", which carries a xml file describing some properties.
			 * Besides to provide some information about the platform features that are not decribed in the contract,
			 * these properties also help the Back-End on how to instantiate the platform. 
			 * NOTE: In this first version, it carries only a string with the address of the Back-End ... 
			 */
			br.ufc.pargo.hpe.backend.DGAC.database.Connector.openConnection ();

			br.ufc.pargo.hpe.backend.DGAC.database.Component c = BackEnd.cdao.retrieve_libraryPath (component_ref);
			IList<SourceCode> sc_list = BackEnd.scdao.listByFileType ('u', c.Id_concrete, "node", "platform_settings");
			SourceCode sc = sc_list[0]; 
			string config = sc.Contents;
			string[] data =  config.Split (new char[1] { '\n' });

			br.ufc.pargo.hpe.backend.DGAC.database.Connector.closeConnection ();

			return data;
		}
			
		#endregion

		#region calling services


		private static IDictionary<string, string> backend_services = new Dictionary<string, string> 
		                      {  
								 {"http://200.19.177.89:8001/backendservices/","ServiceUtils.LIABackendServices.BackEndService"}, 
								 {"http://127.0.0.1:8081/BackendServices.asmx","ServiceUtils.BackendServices.BackendServices"}
		                      };


		public static Tuple<string,int,int> invokeBackEndDeploy (string arch_ref, string backend_address, string[] config)
		{
			//ServiceUtils.BackendServices.BackendServices backend_access = new ServiceUtils.BackendServices.BackendServices (backend_address);
			//backend_access.Timeout = int.MaxValue;

			//string platform_address = backend_access.deploy (config);

			// ACESSANDO O BACKEND DO CLUSTER DO LIA ...
			//ServiceUtils.LIABackendServices.BackEndService backend_access = new ServiceUtils.LIABackendServices.BackEndService (backend_address);
			//backend_access.Timeout = int.MaxValue;



			IBackendServices backend_access = (IBackendServices) Activator.CreateInstance(Type.GetType(backend_services [backend_address]), new string[1] {backend_address});

			string platform_address = backend_access.deploy (config[1]);

			Console.WriteLine ("PLATFORM ADDRESS (" + arch_ref + "): " + platform_address);

			platform_address = platform_address.Replace ("Platform.asmx", "PlatformServices.asmx");

			Thread.Sleep (5000);

			ServiceUtils.PlatformServices.PlatformServices platform_access = new ServiceUtils.PlatformServices.PlatformServices (platform_address);
			platform_access.Timeout = int.MaxValue;
			int base_binding_address = platform_access.getBaseBindingPort();
			platform_access.setPlatformRef (arch_ref);

			int nodes = platform_access.getNumberOfNodes ();

			return new Tuple<string,int,int> (platform_address, base_binding_address, nodes);
		}


		public static void invokeDeployPlatform (SAFeSWL_Architecture arch_desc, 
												 string arch_ref, 
												 object platform_address, 
												 ComponentType appplication_abstract,
												 ComponentType application_concrete,
												 ComponentType workflow_abstract,
												 ComponentType workflow_concrete,
												 ComponentType system_abstract,
												 ComponentType system_concrete)
		{
		//	invokeDeployContracts (arch_desc, arch_ref, contracts, platform_address);

		
			invokeDeploySystem (arch_desc, arch_ref, platform_address, appplication_abstract, application_concrete, workflow_abstract, workflow_concrete, system_abstract, system_concrete);
		}

		public static void invokeDeployContracts (SAFeSWL_Architecture arch_desc, 
			                                      string arch_ref, 
			                                      IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, 
			                                      object platform_address)
		{
			br.ufc.pargo.hpe.backend.DGAC.database.Connector.openConnection ();

			IPlatformServices platform_access = null;
			if (platform_address is string)
			{
				// Deploy the components of the system.
				ServiceUtils.PlatformServices.PlatformServices platform_access_ = new ServiceUtils.PlatformServices.PlatformServices ((string)platform_address);
				platform_access_.Timeout = int.MaxValue;
				platform_access = (IPlatformServices) platform_access_;
			}
			else if (platform_address is IPlatformServices)
			{
				platform_access = (IPlatformServices) platform_address;
			}

			IDictionary<string, int[]> cs = LoaderSystem.componentsInPlatform (arch_desc, arch_ref);			

			foreach (string c in cs.Keys) 
				if (contracts.ContainsKey(c))
				{
					AbstractComponentFunctorApplication acfaRef = BackEnd.loadACFAFromInstantiator (contracts[c]);

					string[] config_dependencies = calculateDependenciesOf (acfaRef.Id_functor_app);

					foreach (string cRef in config_dependencies) 
					{
						string config_filename = Constants.PATH_TEMP_WORKER + cRef + ".hpe";
						string config_contents = File.ReadAllText (config_filename);

						platform_access.deploy (config_contents);
					}
				}
			br.ufc.pargo.hpe.backend.DGAC.database.Connector.closeConnection ();
		}
		

		private static string[] calculateDependenciesOf (int id_functor_app)
		{
			IDictionary<int,string> dependency_list = new Dictionary<int,string> ();
			calculateDependenciesOf_ (id_functor_app, dependency_list);
			string[] result = new string[dependency_list.Count];
			dependency_list.Values.CopyTo (result, 0);
			return result;
		}

		private static void calculateDependenciesOf_ (int id_functor_app, IDictionary<int,string> dependency_list)
		{
			AbstractComponentFunctorApplication acfaRef = BackEnd.acfadao.retrieve (id_functor_app);
			AbstractComponentFunctor acfRef = BackEnd.acfdao.retrieve (acfaRef.Id_abstract);

			IList<SupplyParameter> sp_list = BackEnd.spdao.list (id_functor_app);
			foreach (SupplyParameter sp in sp_list) 
			{
				if (sp is SupplyParameterComponent) 
				{
					SupplyParameterComponent spc = (SupplyParameterComponent)sp;
					calculateDependenciesOf_ (spc.Id_functor_app_actual, dependency_list);
				}
			}

			IList<InnerComponent> inner_list = BackEnd.icdao.list (acfRef.Id_abstract);
			foreach (InnerComponent inner in inner_list) 
				calculateDependenciesOf_ (inner.Id_functor_app, dependency_list);

			if (acfRef.Id_functor_app_supertype > 0) 
				calculateDependenciesOf_(acfRef.Id_functor_app_supertype, dependency_list);
			
			if (!dependency_list.ContainsKey (acfRef.Id_abstract))
				dependency_list.Add (acfRef.Id_abstract, acfRef.Library_path);
		}

		public static 
		        Tuple<Tuple<ComponentType,ComponentType>,   // application component (abstract + concrete)
				      Tuple<ComponentType,ComponentType>,   // workflow component (abstract + concrete)
				      Tuple<ComponentType,ComponentType>>
					createSystem(SAFeSWL_Architecture arch_desc, 
							 	 IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, 
								 IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping,
								 ref IList<string> platforms)
		{
			
			string app_name = null;
			string application_component_name = null;
			string workflow_component_name = null;;
			IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application = null; 
			IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow = null; 
			IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system = null; 
			IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task = null; 

			LoaderSystem.readArchitecture (arch_desc,
				ref app_name, 
				ref application_component_name, 
				ref workflow_component_name, 
				ref bindings_application, 
				ref bindings_workflow, 
				ref bindings_system, 
				ref bindings_task,
				ref platforms);

			// Take the configuration files of components of the system.
			Tuple<Tuple<ComponentType, ComponentType>,   
				  Tuple<ComponentType, ComponentType>,   
				  Tuple<ComponentType, ComponentType>> system = null; //LoaderSystem.createSystemComponent (app_name, application_component_name, workflow_component_name, contracts, unit_mapping, bindings_application, bindings_workflow, bindings_system, bindings_task, platforms);

			return system;
		}
			
		public static void invokeDeploySystem (SAFeSWL_Architecture arch_desc, 
			                                   string arch_ref, 
			                                   object platform_address, 
											   ComponentType c_appplication_abstract,
											   ComponentType c_application_concrete,
											   ComponentType c_workflow_abstract,
											   ComponentType c_workflow_concrete,
											   ComponentType c_system_abstract,
											   ComponentType c_system_concrete)
		{
			try
			{				
				IPlatformServices platform_access = null;
				if (platform_address is string)
				{
					// Deploy the components of the system.
					ServiceUtils.PlatformServices.PlatformServices platform_access_ = new ServiceUtils.PlatformServices.PlatformServices ((string)platform_address);
					platform_access_.Timeout = int.MaxValue;
					platform_access = (IPlatformServices) platform_access_;
				}
				else if (platform_address is IPlatformServices)
				{
					platform_access = (IPlatformServices) platform_address;
				}

				string application_abstract = LoaderApp.serialize<ComponentType>(c_appplication_abstract);
				string application_concrete = LoaderApp.serialize<ComponentType>(c_application_concrete);
				string workflow_abstract    = LoaderApp.serialize<ComponentType>(c_workflow_abstract   );
				string workflow_concrete    = LoaderApp.serialize<ComponentType>(c_workflow_concrete   );
				string system_abstract      = LoaderApp.serialize<ComponentType>(c_system_abstract     );
				string system_concrete      = LoaderApp.serialize<ComponentType>(c_system_concrete     );

				Console.Error.WriteLine(platform_access.deploy (application_abstract));
				Console.Error.WriteLine(platform_access.deploy (workflow_abstract));
				Console.Error.WriteLine(platform_access.deploy (system_abstract));

 				Console.Error.WriteLine(platform_access.deploy (application_concrete));
				Console.Error.WriteLine(platform_access.deploy (workflow_concrete));
				Console.Error.WriteLine(platform_access.deploy (system_concrete));
			}
			catch(Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				Console.Error.WriteLine (e.StackTrace);
				if (e.InnerException != null) {
					Console.Error.WriteLine (e.InnerException.Message);				
					Console.Error.WriteLine (e.InnerException.StackTrace);				
				}
			}

			//return 0;
		}
				

		public static void invokeDeployComponent (object platform_address, string component)
		{
			IPlatformServices platform_access = null;
			if (platform_address is string)
			{
				// Deploy the components of the system.
				ServiceUtils.PlatformServices.PlatformServices platform_access_ = new ServiceUtils.PlatformServices.PlatformServices ((string)platform_address);
				platform_access_.Timeout = int.MaxValue;
				platform_access = (IPlatformServices) platform_access_;
			}
			else if (platform_address is IPlatformServices)
			{
				platform_access = (IPlatformServices) platform_address;
			}

			platform_access.deploy (component);
		}
			

		#endregion

	}
}

