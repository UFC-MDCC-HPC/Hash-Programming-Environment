using System;
using gov.cca.ports;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC;
using System.Collections.Generic;
using System.Threading;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.ports;
using System.Diagnostics;

namespace br.ufc.hpe.backend.DGAC
{
	public class InitializePortImpl : InitializePort
	{
		private ManagerComponentID mcid = null;
		private string session_id_string = null;
		private Port worker_init_port = null;
		
		public InitializePortImpl(ManagerServices services, Port worker_init_port)
		{
		   this.mcid = (ManagerComponentID) services.getComponentID();
		   this.session_id_string = mcid.getInstanceName();
		   this.worker_init_port = worker_init_port;
		}

		#region AutomaticSlicesPort implementation
		public void on_initialize ()
		{			
			((InitializePort)worker_init_port).on_initialize ();
		}
		#endregion

 
		#region AutomaticSlicesPort implementation
		public void after_initialize ()
		{
			((InitializePort)worker_init_port).after_initialize ();
		}
		#endregion

	}
}

