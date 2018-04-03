using System;
using br.ufc.mdcc.hpc.shelf.SAFe;
using System.IO;
using gov.cca;
using br.ufc.mdcc.hpcshelf.workflow.environment.SWLPortType;
using br.ufc.mdcc.hpcshelf.workflow.environment.SWLWorkflowBinding;
using System.Collections.Generic;

namespace TestSAFe
{
    // MainClass will make the role of the Application component.
	class MainClass2 : HShelfApplication
	{
		public static void Main2 (string[] args)
		{
            string path_contracts = "/home/heron/Dropbox/Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd/Run-Gust-PR/";
            string path_architecture_file = Environment.GetEnvironmentVariable("SWL_ARCHITECTURE_FILE_LOCATION");
			
            // The contracts will be provided by explicit files. However, it is possible to put
			// the contracts inside the architectural code, or even infom a URL for download.
			IDictionary<string, string> contracts = new Dictionary<string, string> ();

			for (int i = 0; i < p_ids.Length; i++) 
				contracts [p_ids[i]] = File.ReadAllText(path_contracts + p_contracts[i]); 

			for (int i = 0; i < c_ids.Length; i++) 
				contracts [c_ids[i]] = File.ReadAllText(path_contracts + c_contracts[i]);

			string solution_architecture_xml = File.ReadAllText(path_architecture_file);
			
            AbstractFramework frw = new HShelfFramework (solution_architecture_xml, contracts);
			// 1. After the framework creation, the Workflow and Application components are instantiated. 
			//    For beginnint the orchestration, the Workflow component is waiting from the application,
			//    through the "swl_port", an object that will provide the orchestration code.
			// 2. It is not necessary a connection to a "builder service", since all the components
			//    and their bindings are specified in the architectural code.          

			// Through the frwServices object, this class makes the role of the application component
			Services appServices = frw.getServices ("Me", "HShelfApplication", frw.createTypeMap());

            // Take the "swl_port".
            ISWLWorkflowBinding swl_port = (ISWLWorkflowBinding)appServices.getPort ("swl_port");

            // Provide the orchestration code that will executed by the Workflow component.
            swl_port.Server = new SWLPortTypeImpl ();
		}

		public class SWLPortTypeImpl : ISWLPortType
		{
			public string Workflow { 
				get 
				{
					string file_name = Environment.GetEnvironmentVariable ("SWL_ORQUESTRATION_FILE_LOCATION");
					string swl_code = File.ReadAllText (file_name);
					return swl_code;
				} 
			}
		}

		static string[] p_ids = new string[5] {
			"platform_SAFe",
			"platform_data_source",
			"platform_data_sink",
			"platform_reduce_1",
			"platform_reduce_2"
		};

		static string[] c_ids = new string[6] {
			"source",
			"sink",
			"reducer_1",
			"reducer_2",
            "flatten_output",
			"shuffler"
		};

		static string[] p_contracts = new string[5] {
			"PlatformSAFe.cc",
			"PlatformDataSource.cc",
			"PlatformDataSink.cc",
			"PlatformReduce_1.cc",
			"PlatformReduce_2.cc"
		};

		static string[] c_contracts = new string[6] {
			"DataSource.cc",
			"DataSink.cc",
			"Reducer_1.cc",
			"Reducer_2.cc",
            "FlattenOutput.cc",
			"Shuffler.cc"
		};
	}
}
