// /home/jefferson/projetos/appexample/appexample/kinds/ApplicationKind.cs created with MonoDevelop
// User: jefferson at 13:21 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.ServiceModel;
using System.IO;

namespace br.ufc.pargo.hpe.kinds
{
    public interface IProxyKind : IActivateKind, IUnit
    {
		void publishBindingService(string app_session_id, 
			                       object service, 
			                       Type port_type, 
			                       string binding_type_library_path);
    }
	
	//[Serializable]
	public class Proxy : Activate, IProxyKind
    {
		public override void main ()
		{
		} 

		// APPLICATION AS A CLIENT
		public void publishBindingService(string app_session_id, 
			                              object service, 
			                              Type port_type, 
			                              string binding_type_library_path)
		{
			string address = null;            // TODO:
			int port_number = default(int);   // TODO:

			var binding = new WSHttpBinding ();
			var uri_address = new Uri (address);
			var host = new ServiceHost (service);
			host.AddServiceEndpoint (port_type, binding, uri_address);
			host.Open ();		

			string container_path = 
				br.ufc.pargo.hpe.backend.DGAC.utils.Constants.HOME_PATH
				+ Path.PathSeparator
				+ Constants.DIRECTORY_NAME_BINDING_WEB_SERVICES
				+ Path.PathSeparator 
				+ app_session_id;

			br.ufc.pargo.hpe.backend.DGAC.utils.CommandLineUtil.runCommand
			("cp", br.ufc.pargo.hpe.backend.DGAC.utils.Constants.PATH_DGAC 
				+ Path.PathSeparator 
				+ binding_type_library_path + ".dll"
				+ " "
				+ Path.PathSeparator 
				+ container_path 
				+ Path.PathSeparator 
				+ "bin" 
				+ Path.PathSeparator);

			br.ufc.pargo.hpe.backend.DGAC.utils.CommandLineUtil.runCommand ("xsp4", "--port " + port_number);
		}



	}
}
