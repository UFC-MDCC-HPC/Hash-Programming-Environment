using System;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.mdcc.hpcshelf.backend.platform;
using br.ufc.pargo.hpe.basic;
using br.ufc.mdcc.hpcshelf.core;
using System.Collections.Generic;
using System.Threading;
using br.ufc.pargo.hpe.kinds;

namespace br.ufc.mdcc.hpc.shelf.SAFe
{
	public class HShelfApplication 
	{
		public HShelfApplication ()
		{
		}
			
		protected class HShelfFramework : gov.cca.AbstractFramework
		{
			private string architectural_code = null;
			private WorkerObject baseFramework = null;
			private int workflow_handle;

			private WorkflowCoreServices core_services;
			private SAFePlatformServices platform_services;

			private IUnit application_unit = null;

			private string app_name = null;

			public HShelfFramework (string architectural_code, IDictionary<string,string> contracts)
			{
				init(architectural_code,delegate() {

					foreach (KeyValuePair<string,string> contract in contracts) 
					{
						string cid = contract.Key;
						string contract_content = contract.Value;
						core_services.registerContract (workflow_handle, cid, contract_content);
					}

				});
			}

			public HShelfFramework (string architectural_code)
			{
				init(architectural_code, delegate() {});
			}

			public delegate void ProvideContracts();

			private void init(string architectural_code, ProvideContracts provide_contracts)
			{
				this.architectural_code = architectural_code;

				core_services = new WorkflowCoreServices ();
				platform_services = new SAFePlatformServices ();
				platform_services.Address = "http://127.0.0.1/PlatformServices.asmx";

				workflow_handle = core_services.openWorkflowSession (architectural_code, platform_services);
				this.app_name = core_services.getAppName(workflow_handle);

                core_services.registerContract(workflow_handle,"application","");
				core_services.registerContract(workflow_handle, "workflow","");
				provide_contracts ();

				core_services.deploy (workflow_handle,"platform_SAFe");

	            core_services.instantiate (workflow_handle, "platform_SAFe");
				core_services.instantiate (workflow_handle, "swl_port");
				core_services.instantiate (workflow_handle, "application");
				core_services.instantiate (workflow_handle, "workflow");
				
                baseFramework = (WorkerObject)((ManagerObject)platform_services.Session.Framework).WorkerFramework;
				Console.WriteLine(this.app_name + "-workflow");
				foreach (string k in baseFramework.UnitOf.Keys)
					Console.WriteLine("UnitOf[{0}] !", k);
				((IWorkflowKind)(baseFramework.UnitOf[this.app_name + "-workflow"])).CoreServices = core_services;

				Thread run = new Thread(new ThreadStart(delegate
                {
                    core_services.run(workflow_handle, "application");
                    core_services.run(workflow_handle, "workflow");
                }));

                run.Start();

			}

			public TypeMap createTypeMap()
			{
				return baseFramework.createTypeMap ();
			}

			public Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties)
			{

                Console.WriteLine(this.app_name + "-application");
                foreach (string k in baseFramework.UnitOf.Keys)
                    Console.WriteLine("UnitOf[{0}] !", k);

				application_unit = baseFramework.UnitOf[this.app_name + "-application"];

				return application_unit.Services;
			}


			public void releaseServices(Services services)
			{
				baseFramework.releaseServices (services);
			}

			public void shutdownFramework()
			{
				baseFramework.shutdownFramework ();
			}

			public AbstractFramework createEmptyFramework()
			{
				return new HShelfFramework(architectural_code);
			}
		}

	}
}

