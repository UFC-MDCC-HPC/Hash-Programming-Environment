using System;
using gov.cca.ports;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC;
using System.Collections.Generic;
using System.Threading;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Diagnostics;

namespace br.ufc.hpe.backend.DGAC
{
	public class GoPortImpl : GoPort
	{
		private ManagerComponentID mcid = null;
		private string session_id_string = null;
		private Port worker_go_port = null;
		
		public GoPortImpl(ManagerServices services, Port wgo_port)
		{
		    this.mcid = (ManagerComponentID) services.getComponentID();
		    this.session_id_string = mcid.getInstanceName();
			this.worker_go_port = wgo_port;
		}

		#region GoPort implementation
		public int go ()
		{
            if (this.worker_go_port == null)
                return 0;
            
			return ((GoPort)worker_go_port).go ();            
		}
		#endregion

 
	}

}

