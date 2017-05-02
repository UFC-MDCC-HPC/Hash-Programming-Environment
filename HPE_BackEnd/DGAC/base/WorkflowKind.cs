// /home/jefferson/projetos/appexample/appexample/kinds/SynchronizerKind.cs created with MonoDevelop
// User: jefferson at 13:20 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using System.Collections.Generic;
using System.Threading;
using SAFeSWL;
using System.Xml.Serialization;
using System.Xml;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.hpe.backend.DGAC.WorkflowCoreServices;

namespace br.ufc.pargo.hpe.kinds
{

    public interface IWorkflowKind : IActivateKind, GoPort
	{
		string SWLArchitecture { set; }
		string SWLOrchestration { set; }
		void registerContract (string cid, string contract);
	}

	public abstract class Workflow : Activate, IWorkflowKind 
	{	 
		private string arch_desc_xml;

		public string SWLArchitecture 
		{ 
			set 
			{
				arch_desc_xml = value;
			} 
		}

		private SWLWorkflow<bool> w_tree = null;

		public string SWLOrchestration 
		{ 
			set 
			{
				SAFeSWL_OperationAnyType w = FileUtil.readXML<SAFeSWL_OperationAnyType> (value);
				w_tree = WorkflowParser.convertoToSWLAbstractTree (w);
			} 
		}

		private WorkflowCoreServices core_services;
		private int workflow_handle;

		public override void main()
		{
			WorkflowCoreServices core_services = core_services = new WorkflowCoreServices ();
			core_services.Timeout = int.MaxValue;

			int workflow_handle = workflow_handle = core_services.openWorkflowSession (arch_desc_xml);

			w_tree.accept (new SWLVisitorOrchestrate (this.Services, workflow_handle, core_services));

			core_services.closeWorkflowSession (workflow_handle);
		}

		public void registerContract (string cid, string contract)
		{
			core_services.registerContract (workflow_handle, cid, contract);
		}

	}
		
}
