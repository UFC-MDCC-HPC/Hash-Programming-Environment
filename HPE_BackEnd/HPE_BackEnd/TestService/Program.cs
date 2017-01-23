using System;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Collections.Generic;

namespace TestService
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			string arch_desc_xml = File.ReadAllText("../../shelf_mapreduce.xml");
			string[] p_ids = new string[5] {
				"platform_SAFe",
				"platform_data_source",
				"platform_data_sink",
				"platform_map",
				"platform_reduce"
			};
			string[] c_ids = new string[6] {
				"data_source",
				"data_sink",
				"mapper",
				"reducer",
				"splitter",
				"shuffler"
			};
			string[] p_contracts = new string[5] {
				"PlatformSAFe.cc",
				"PlatformDataSource.cc",
				"PlatformDataSink.cc",
				"PlatformMap.cc",
				"PlatformReduce.cc"
			};
			string[] c_contracts = new string[6] {
				"DataSource.cc",
				"DataSink.cc",
				"Mapper.cc",
				"Reducer.cc",
				"Splitter.cc",
				"Shuffler.cc"
			};
			string[] p_unit_mappings = new string[5] {
				"PlatformSAFe.um",
				"PlatformDataSource.um",
				"PlatformDataSink.um",
				"PlatformMap.um",
				"PlatformReduce.um"
			};
			string[] c_unit_mappings = new string[6] {
				"DataSource.um",
				"DataSink.um",
				"Mapper.um",
				"Reducer.um",
				"Splitter.um",
				"Shuffler.um"
			};
			string[] b_ids = new string[12] {
				"task_reduce",
				"intermediate_pairs_global",
				"intermediate_pairs_local",
				"task_map",
				"output_pairs",
				"input_pairs",
				"task_binding_split_first",
				"task_binding_split_next",
				"task_binding_data",
				"task_binding_shuffle",
				"input_data",
				"output_data"
			};

			WorkflowCoreServices.WorkflowCoreServices core_service = new WorkflowCoreServices.WorkflowCoreServices ();
			core_service.Timeout = int.MaxValue;

			int workflow_handle = core_service.openWorkflowSession (arch_desc_xml);

			try 
			{
				// REGISTER

				for (int i = 0; i < p_ids.Length; i++) 
				{
					string contract_content = File.ReadAllText(p_contracts [i]);
					string unit_mapping_content = File.ReadAllText(p_unit_mappings [i]);
					core_service.registerContract (workflow_handle, p_ids [i], contract_content, unit_mapping_content);
				}

				for (int i = 0; i < c_ids.Length; i++) 
				{
					string contract_content = File.ReadAllText(c_contracts [i]);
					string unit_mapping_content = File.ReadAllText(c_unit_mappings [i]);
					core_service.registerContract (workflow_handle, c_ids [i], contract_content, unit_mapping_content);
				}

				// RESOLVE

				foreach (string p_id in p_ids) 
					core_service.resolve (workflow_handle, p_id);

				foreach (string c_id in c_ids) 
					core_service.resolve (workflow_handle, c_id);

				// DEPLOY

				foreach (string p_id in p_ids) 
					core_service.deploy (workflow_handle, p_id);

				foreach (string c_id in c_ids) 
					core_service.deploy (workflow_handle, c_id);

				// INSTANTIATE

				foreach (string p_id in p_ids)
					core_service.instantiate (workflow_handle, p_id);

				foreach (string b_id in b_ids)
					core_service.instantiate (workflow_handle, b_id);

				foreach (string c_id in c_ids)
					core_service.instantiate (workflow_handle, c_id);
				
				core_service.instantiate(workflow_handle,"workflow");
				core_service.instantiate(workflow_handle,"application");

				/// RUN

				foreach (string c_id in c_ids)
					core_service.run (workflow_handle, c_id);
					
				core_service.run(workflow_handle,"workflow");
				core_service.run(workflow_handle,"application");

				core_service.wait(workflow_handle);

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
			finally 
			{
				core_service.closeWorkflowSession (workflow_handle);
			}

		}
	}
}
