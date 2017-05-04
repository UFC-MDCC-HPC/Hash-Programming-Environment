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
		string SWLOrchestration { set; }
		int WorkflowHandle { set; }
		WorkflowCoreServices CoreServices { set; }
	}

	public abstract class Workflow : Activate, IWorkflowKind 
	{	 

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
		public WorkflowCoreServices CoreServices 
		{ 
			set 
			{
				this.core_services = value;
			} 
		}

		private int workflow_handle;
		public int WorkflowHandle 
		{ 
			set 
			{
				this.workflow_handle = value;
			} 
		}

		public override void main()
		{
			w_tree.accept (new SWLVisitorOrchestrate (this.Services, workflow_handle, core_services));
		}
			
	}
		
}
