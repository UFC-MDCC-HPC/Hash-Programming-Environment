namespace br.ufc.mdcc.hpcshelf.backend.platform
{
	public interface IPlatformServices 
	{
		int    getNumberOfNodes   ();
		int    getBaseBindingPort ();
		string deploy             (string config_contents);
		void   setPlatformRef     (string arch_ref);
		string getPlatformRef     ();
		string instantiate        (string app_name, string component_ref, int facet_instance, int[] facet, string[] facet_address, int[] nodes);
		void   run                (string component_ref);
		string getStatus          ();
	}
}
