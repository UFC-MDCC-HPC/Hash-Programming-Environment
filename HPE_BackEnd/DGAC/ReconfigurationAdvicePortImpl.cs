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
		private Port[] w_advice_ports = null;
		
		public ReconfigurationAdvicePortImpl(ManagerServices services, Port[] w_advice_ports)
		{
		   this.mcid = (ManagerComponentID) services.getComponentID();
		   this.session_id_string = mcid.getInstanceName();
		   this.w_advice_ports = w_advice_ports;
		}

		#region AutomaticSlicesPort implementation
		public void changePort (string portName)
		{
			
            IDictionary<Thread, ReconfigureThread> thread_list = new Dictionary<Thread,ReconfigureThread>();
            for (int i=0; i<w_advice_ports.Length; i++)
            {		       
				ReconfigureThread thread = new ReconfigureThread(portName, (ReconfigurationAdvicePort) w_advice_ports[i]);
                Thread t = new Thread(thread.Run);
                thread_list.Add(t,thread);
                t.Start();
            }
            foreach (KeyValuePair<Thread,ReconfigureThread> t in thread_list)
            {
                try 
                {
					t.Key.Join();
                   Console.Error.WriteLine("Worker thread arrived : " + session_id_string);
                } 
                catch (Exception e)
                {
                   Trace.WriteLine("Worker failed : " + session_id_string + ". error =" + e.Message);
                }
            }			
            Console.Error.WriteLine("Joined Threads : " + session_id_string);
            
			
		}
		#endregion

        internal class ReconfigureThread
        {
			private ReconfigurationAdvicePort worker_advice_port;
			private string portName;

            public ReconfigureThread(string portName, ReconfigurationAdvicePort worker_advice_port)
            {
				this.worker_advice_port = worker_advice_port;
				this.portName = portName;
            }

            public void Run()
            {
				try 
				{
					worker_advice_port.changePort(portName);				
				}
				catch (Exception e)
				{
					throw e;
				}
            }

        }


	}

}

