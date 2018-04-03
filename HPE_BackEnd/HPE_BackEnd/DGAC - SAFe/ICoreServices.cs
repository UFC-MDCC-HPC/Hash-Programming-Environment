namespace br.ufc.mdcc.hpcshelf.core
{

	public interface ICoreServices
	{
		int    openWorkflowSession  (string arch_desc_xml);
		void   registerContract     (int workflow_handle, string arch_ref, string contract);
		void   resolve              (int workflow_handle, string arch_ref);
		string deploy               (int workflow_handle, string arch_ref);
		string instantiate          (int workflow_handle, string arch_ref);
		void   run                  (int workflow_handle, string arch_ref);
		void   closeWorkflowSession (int workflow_handle);
	}
}
