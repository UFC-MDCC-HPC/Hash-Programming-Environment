using System;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.database;

namespace TestService
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			//string[] platform_config = new string[2];
		//	platform_config [0] = "http://127.0.0.1:8081";
			//platform_config [1] = "4";

			//BackEndService.BackEnd backend_service = new BackEndService.BackEnd ();
			//backend_service.deploy (platform_config);

		//	Platform.Platform platform_service = new Platform.Platform ("http://127.0.0.1:8082/Platform.asmx");
		//	platform_service.deploy ("system");

			CoreService.Core core_service = new CoreService.Core ("http://127.0.0.1:8080/Core.asmx");

			// resolve contract Mapper
			string contract_platform_data = File.ReadAllText("PlatformData.cc");
			string[] resolution_result_platform_data = core_service.resolve (contract_platform_data);

			// resolve contract Mapper
			string contract_platform_map = File.ReadAllText("PlatformMap.cc");
			string[] resolution_result_platform_map = core_service.resolve (contract_platform_map);

			// resolve contract Mapper
			string contract_platform_reduce = File.ReadAllText("PlatformReduce.cc");
			string[] resolution_result_platform_reduce = core_service.resolve (contract_platform_map);

			// resolve contract Data Source
			string contract_data_source = File.ReadAllText("DataSource.cc");
			string[] resolution_result_data_source = core_service.resolve (contract_data_source);

			// resolve contract Data Sink
			string contract_data_sink = File.ReadAllText("DataSink.cc");
			string[] resolution_result_data_sink = core_service.resolve (contract_data_sink);

			// resolve contract Mapper
			string contract_mapper = File.ReadAllText("Mapper.cc");
			string[] resolution_result_mapper = core_service.resolve (contract_mapper);

			// resolve contract Reducer
			string contract_reducer = File.ReadAllText("Reducer.cc");
			string[] resolution_result_reducer = core_service.resolve (contract_reducer);

			// resolve contract Splitter
			string contract_splitter = File.ReadAllText("Splitter.cc");
			string[] resolution_result_splitter = core_service.resolve (contract_splitter);

			// resolve contract Shuffler
			string contract_shuffler = File.ReadAllText("Shuffler.cc");
			string[] resolution_result_shuffler = core_service.resolve (contract_shuffler);

			string arch_desc_xml = File.ReadAllText("../../shelf_mapreduce.xml");
			//string arch_ref = null;
			//string component_ref = null;
			string[] c_ids = new string[9]{"platform_data", "platform_map", "platform_reduce","data_source","data_sink", "mapper", "reducer", "splitter", "shuffler"};
			string[] c_contracts = new string[9] 
			{
				contract_platform_data, 
				contract_platform_map, 
				contract_platform_reduce, 
				contract_data_source,
				contract_data_sink,
				contract_mapper, 
				contract_reducer, 
				contract_splitter, 
				contract_shuffler
			};

			string unitmapping_platform_data = File.ReadAllText("PlatformData.um");
			string unitmapping_platform_map = File.ReadAllText("PlatformMap.um");
			string unitmapping_platform_reduce = File.ReadAllText("PlatformReduce.um");
			string unitmapping_data_source = File.ReadAllText("DataSource.um");
			string unitmapping_data_sink = File.ReadAllText("DataSink.um");
			string unitmapping_mapper = File.ReadAllText("Mapper.um");
			string unitmapping_reducer = File.ReadAllText("Reducer.um");
			string unitmapping_splitter = File.ReadAllText("Splitter.um");
			string unitmapping_shuffler = File.ReadAllText("Shuffler.um");

			string[] c_unit_mapping = new string[9] 
			{
				unitmapping_platform_data,
				unitmapping_platform_map,
				unitmapping_platform_reduce,
				unitmapping_data_source,
				unitmapping_data_sink,
				unitmapping_mapper, 
				unitmapping_reducer, 
				unitmapping_splitter, 
				unitmapping_shuffler
			};

			string[] c_choices = new string[9] 
			{ 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_platform_data[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_platform_map[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_platform_reduce[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_data_source[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_data_sink[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_mapper[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_reducer[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_splitter[0]).component_ref, 
				LoaderApp.deserialize<ComponentReference.ComponentReference> (resolution_result_shuffler[0]).component_ref
			};
			
			string platform_address_SAFe = null;

			core_service.Timeout = int.MaxValue;

			// DEPLOY MAP PLATFORM
			core_service.deploy (arch_desc_xml, "platform_data", c_ids, c_contracts, c_choices, c_unit_mapping, platform_address_SAFe);

			// DEPLOY MAP PLATFORM
			core_service.deploy (arch_desc_xml, "platform_map", c_ids, c_contracts, c_choices, c_unit_mapping, platform_address_SAFe);

			// DEPLOY REDUCE PLATFORM
			core_service.deploy (arch_desc_xml, "platform_reduce", c_ids, c_contracts, c_choices, c_unit_mapping, platform_address_SAFe);

			// DEPLOY MAPPER
			core_service.deploy (arch_desc_xml, "mapper", null, null, null, null, platform_address_SAFe);

			// DEPLOY REDUCER
			core_service.deploy (arch_desc_xml, "reducer", null, null, null, null, platform_address_SAFe);

			// DEPLOY SPLITTER
			core_service.deploy (arch_desc_xml, "splitter", null, null, null, null, platform_address_SAFe);

			// DEPLOY SHUFFLER
			core_service.deploy (arch_desc_xml, "shuffler", null, null, null, null, platform_address_SAFe);



			// INSTANTIATE MAP PLATFORM
			core_service.instantiate (arch_desc_xml, "platform_map", platform_address_SAFe);

			// INSTANTIATE REDUCE PLATFORM
			core_service.instantiate (arch_desc_xml, "platform_reduce", platform_address_SAFe);

			// INSTANTIATE MAPPER
			core_service.instantiate (arch_desc_xml, "mapper", platform_address_SAFe);

			// INSTANTIATE REDUCER
			core_service.instantiate (arch_desc_xml, "reducer", platform_address_SAFe);

			// INSTANTIATE SPLITTER
			core_service.instantiate (arch_desc_xml, "splitter", platform_address_SAFe);

			// INSTANTIATE SHUFFLER
			core_service.instantiate (arch_desc_xml, "shuffler", platform_address_SAFe);


		}
	}
}
