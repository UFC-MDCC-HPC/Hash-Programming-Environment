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
	public class ReconfigurationAdvicePortImpl : ReconfigurationAdvicePort
	{
		private ManagerComponentID mcid = null;
		private string session_id_string = null;
		private Port worker_advice_port = null;
		
		public ReconfigurationAdvicePortImpl(ManagerServices services, Port worker_advice_port)
		{
		   this.mcid = (ManagerComponentID) services.getComponentID();
		   this.session_id_string = mcid.getInstanceName();
		   this.worker_advice_port = worker_advice_port;
		}

		#region AutomaticSlicesPort implementation
		public void changePort (string portName)
		{			
			((ReconfigurationAdvicePort)worker_advice_port).changePort (portName);
		}
		#endregion

	}
}