using System;
using gov.cca.ports;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC;
using System.Collections.Generic;
using System.Threading;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.ports;

namespace br.ufc.hpe.backend.DGAC
{
	public class AutomaticSlicesPortImpl : AutomaticSlicesPort
	{
		private ManagerComponentID mcid = null;
		private string session_id_string = null;
		private Port[] wgo_ports = null;
		
		public AutomaticSlicesPortImpl(ManagerServices services, Port[] wcreate_slices_ports)
		{
		   this.mcid = (ManagerComponentID) services.getComponentID();
		   this.session_id_string = mcid.getInstanceName();
		   this.wgo_ports = wcreate_slices_ports;
		}

		#region AutomaticSlicesPort implementation
		public void create_slices ()
		{
            IDictionary<Thread, GoThread> thread_list = new Dictionary<Thread,GoThread>();
            for (int i=0; i<wgo_ports.Length; i++)
            {		       
				GoThread thread = new GoThread((AutomaticSlicesPort) wgo_ports[i]);
                Thread t = new Thread(thread.Run);
                thread_list.Add(t,thread);
                t.Start();
            }
            foreach (KeyValuePair<Thread,GoThread> t in thread_list)
            {
                try 
                {
					t.Key.Join();
                   Console.Error.WriteLine("Worker thread arrived : " + session_id_string);
                  // outputs[t.Value.Node] = t.Value.Output;
                } 
                catch (Exception e)
                {
                   Console.WriteLine("Worker failed : " + session_id_string + ". error =" + e.Message);
                }
            }			
            Console.Error.WriteLine("Joined Threads : " + session_id_string);
            
			
		}
		#endregion

        internal class GoThread
        {
			private AutomaticSlicesPort worker_create_slices_port;

            public GoThread(AutomaticSlicesPort worker_create_slices_port)
            {
				this.worker_create_slices_port = worker_create_slices_port;
            }

            public void Run()
            {
				worker_create_slices_port.create_slices();				
            }

        }

		#region AutomaticSlicesPort implementation
		public void destroy_slices ()
		{
			throw new NotImplementedException ();
		}
		#endregion


	}

}

