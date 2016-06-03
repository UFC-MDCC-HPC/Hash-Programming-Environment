﻿using System;
using System.Collections.Generic;
using SAFeSWL;
using System.Diagnostics;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.pargo.hpe.backend.DGAC;
using System.Xml.Serialization;
using System.Xml;
using br.ufc.pargo.hpe.backend;

namespace br.ufc.mdcc.hpe.CoreService
{
	public class CoreServiceUtils
	{

		#region processing SAFeSWL

		public static SAFeSWL.Architecture readArchitecture (string arch_desc_xml)
		{
			string filename = System.IO.Path.GetTempFileName ();
			File.WriteAllText (filename, arch_desc_xml);
			SAFeSWL.Architecture arch_desc = CoreServiceUtils.DeserializeArchitecture_SAFeSWL(filename);
			return arch_desc;
		}

		private static SAFeSWL.Architecture DeserializeArchitecture_SAFeSWL(string filename)
		{
			// Declare an object variable of the type to be deserialized.
			SAFeSWL.Architecture i = null;
			FileStream fs = null;
			try
			{
				// Create an instance of the XmlSerializer specifying type and namespace.
				XmlSerializer serializer = new XmlSerializer(typeof(SAFeSWL.Architecture));

				// A FileStream is needed to read the XML document.
				fs = new FileStream(filename, FileMode.Open);

				XmlReader reader = new XmlTextReader(fs);

				// Use the Deserialize method to restore the object's state.
				i = (SAFeSWL.Architecture)serializer.Deserialize(reader);
			}
			catch (Exception e)
			{
				Console.WriteLine (e.Message);
				Trace.WriteLine(e.StackTrace);
			}
			finally
			{
				if (fs != null)
					fs.Close();
			}

			return i;

		}

		public static bool checkIsPlatform (SAFeSWL.Architecture arch_desc, string arch_ref)
		{
			SAFeSWL.Component[] cs = arch_desc.body;
			foreach (SAFeSWL.Component c in cs) 
			{
				if (c.name.Equals (arch_ref) && c is SAFeSWL.Platform)
					return true;
			}

			return false;
		}

		public static IDictionary<string,string> readPlatformAddresses (SAFeSWL.Architecture arch_desc)
		{
			IDictionary<string,string> result = new Dictionary<string, string> ();

			SAFeSWL.Component[] cs = arch_desc.body;
			foreach (SAFeSWL.Component c in cs) 
			{
				if (c is SAFeSWL.Platform)
					result.Add(c.name,((SAFeSWL.Platform)c).platform_address);
			}

			return result;
		}

		public static string determineSystemComponentRef(SAFeSWL.Architecture arch_desc)
		{
			return arch_desc.application_name;
		}




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



		public static string invokeBackEndDeploy (string backend_address, string[] config)
		{
			ServiceUtils.BackEndService.BackEnd backend_access = new ServiceUtils.BackEndService.BackEnd (backend_address);
			string platform_address = backend_access.deploy (config);

			return platform_address;
		}

		public static void invokeDeployPlatform (SAFeSWL.Architecture arch_desc, 
			                                     IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, 
												 IDictionary<string,string> choices, 
												 IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping, 
												 string arch_ref, 
												 string platform_address)
		{
			//invokeDeployContracts (arch_desc, arch_ref, contracts, platform_address);
			invokeDeploySystem (arch_desc, arch_ref, contracts, unit_mapping, platform_address);
		}

		public static void invokeDeployContracts (SAFeSWL.Architecture arch_desc, string arch_ref, IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, string platform_address)
		{
			br.ufc.pargo.hpe.backend.DGAC.database.Connector.openConnection ();

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

						ServiceUtils.PlatformService.Platform platform_access = new ServiceUtils.PlatformService.Platform (platform_address);
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



		public static void invokeDeploySystem (SAFeSWL.Architecture arch_desc, 
			                                   string arch_ref, 
			                                   IDictionary<string,Instantiator.ComponentFunctorApplicationType> all_contracts, 
											   IDictionary<string,Instantiator.UnitMappingType[]> all_unit_mapping, 
			                                   string platform_address)
		{
			try{
				string app_name = null;
				string application_component_name = null;
				string workflow_component_name = null;;
				IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application = null; 
				IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow = null; 
				IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system = null; 
				IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task = null; 
				IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts = null;
				IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping = null;

				LoaderSystem.readArchitecture (arch_desc, 
						                       arch_ref, 
						                       all_contracts, 
											   all_unit_mapping,
						                       ref app_name, 
						                       ref application_component_name, 
						                       ref workflow_component_name, 
						                       ref bindings_application, 
						                       ref bindings_workflow, 
						                       ref bindings_system, 
						                       ref bindings_task, 
						                       ref contracts,
						                       ref unit_mapping);

				// Take the configuration files of components of the system.
				var system = LoaderSystem.createSystemComponent (app_name,arch_ref, application_component_name, workflow_component_name, contracts, unit_mapping, bindings_application, bindings_workflow, bindings_system, bindings_task); 
				string application_abstract = LoaderApp.serialize<ComponentType>(system.Item1.Item1);
				string application_concrete = LoaderApp.serialize<ComponentType>(system.Item1.Item2);
				string workflow_abstract = LoaderApp.serialize<ComponentType>(system.Item2.Item1);
				string workflow_concrete = LoaderApp.serialize<ComponentType>(system.Item2.Item2);
				string system_abstract = LoaderApp.serialize<ComponentType>(system.Item3.Item1);
				string system_concrete = LoaderApp.serialize<ComponentType>(system.Item3.Item2);

				File.WriteAllText ("/home/heron/Copy/ufc_mdcc_hpc/HPC-Shelf-MapReduce/mapreduce." + /*arch_ref + */"Application/Application.hpe", application_abstract);
				File.WriteAllText ("/home/heron/Copy/ufc_mdcc_hpc/HPC-Shelf-MapReduce/mapreduce." + /*arch_ref + */"Workflow/Workflow.hpe", workflow_abstract);
				File.WriteAllText ("/home/heron/Copy/ufc_mdcc_hpc/HPC-Shelf-MapReduce/mapreduce." + /*arch_ref + */"System/System.hpe", system_abstract);

				File.WriteAllText ("/home/heron/Copy/ufc_mdcc_hpc/HPC-Shelf-MapReduce/mapreduce." + /*arch_ref + */"impl.ApplicationImpl/ApplicationImpl.hpe", application_concrete);
				File.WriteAllText ("/home/heron/Copy/ufc_mdcc_hpc/HPC-Shelf-MapReduce/mapreduce." + /*arch_ref + */"impl.WorkflowImpl/WorkflowImpl.hpe", workflow_concrete);
				File.WriteAllText ("/home/heron/Copy/ufc_mdcc_hpc/HPC-Shelf-MapReduce/mapreduce." + /*arch_ref + */"impl.SystemImpl/SystemImpl.hpe", system_concrete);

				// Deploy the components of the system.
				ServiceUtils.PlatformService.Platform platform_access = new ServiceUtils.PlatformService.Platform (platform_address);
				Console.WriteLine(platform_access.deploy (application_abstract));
				Console.WriteLine(platform_access.deploy (workflow_abstract));
				Console.WriteLine(platform_access.deploy (system_abstract));

 				Console.WriteLine(platform_access.deploy (application_concrete));
				Console.WriteLine(platform_access.deploy (workflow_concrete));
				Console.WriteLine(platform_access.deploy (system_concrete));

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
		}

		public static void invokeInstantiatePlatform (string system_ref, string platform_address)
		{
			// Instantiate the system component
			ServiceUtils.PlatformService.Platform platform_access = new ServiceUtils.PlatformService.Platform (platform_address);
			platform_access.instantiate (system_ref, 0 , null, null);
		}
	

		public static void invokeDeployComponent (string platform_address, string component)
		{
			ServiceUtils.PlatformService.Platform platform_access = new ServiceUtils.PlatformService.Platform (platform_address);
			platform_access.deploy (component);
		}

		/* Instancia o componente identificado por component_ref na arquitetura do sistema computacional */
		public static void invokeInstantiateComponent (string platform_address, string component_ref, int facet_instance, int[] facet, string[] facet_address )
		{
			ServiceUtils.PlatformService.Platform platform_access = new ServiceUtils.PlatformService.Platform (platform_address);
			platform_access.instantiate(component_ref, facet_instance, facet, facet_address);
		}


		#endregion

	}
}

