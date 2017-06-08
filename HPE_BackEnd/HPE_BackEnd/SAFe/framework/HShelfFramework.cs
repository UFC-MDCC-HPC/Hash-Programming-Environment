using System;
using gov.cca;
using br.ufc.pargo.hpe.kinds;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.mdcc.hpcshelf.backend.platform;
using br.ufc.mdcc.hpcshelf.core;
using br.ufc.pargo.hpe.basic;

namespace br.ufc.mdcc.hpc.shelf.SAFe
{

	public class HShelfFramework : gov.cca.AbstractFramework
	{
		private string architectural_code = null;
		private WorkerObject baseFramework = null;
		private int workflow_handle;

		private WorkflowCoreServices core_services;
		private SAFePlatformServices platform_services;

		private IUnit application_unit = null;

		private string app_name = null;

		public HShelfFramework (string architectural_code)
		{
			this.architectural_code = architectural_code;

			core_services = new WorkflowCoreServices ();
			platform_services = new SAFePlatformServices ();
			platform_services.Address = "http://127.0.0.1/PlatformServices.asmx";
			baseFramework = (WorkerObject) ((ManagerObject) platform_services.Session).WorkerFramework;

			workflow_handle = core_services.openWorkflowSession (architectural_code, platform_services);

			this.app_name = core_services.getAppName(workflow_handle);

			core_services.instantiate (workflow_handle, "workflow");
		}


		public TypeMap createTypeMap()
		{
			return baseFramework.createTypeMap ();
		}

		public Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties)
		{
			core_services.instantiate (workflow_handle, "application");
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

