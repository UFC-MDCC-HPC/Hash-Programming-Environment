using System;
using gov.cca.ports;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC;
using System.Collections.Generic;
using System.Threading;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Diagnostics;
using br.ufc.pargo.hpe.ports;

namespace br.ufc.hpe.backend.DGAC
{

	public class MultipleGoPortImpl : MultipleGoPort
	{
		private IList<GoPort> ports = new List<GoPort>();

		public void addPort(GoPort port)
		{
			ports.Add(port);
		}

		public int go()
		{
			foreach (GoPort port in ports)
				port.go();

            return 0;
		}
	}


	public class GoPortImpl : GoPort
	{
		private ManagerComponentID mcid = null;
		private string session_id_string = null;
		private Port[] wgo_ports = null;
		
		public GoPortImpl(ManagerServices services, Port[] wgo_ports)
		{
		   this.mcid = (ManagerComponentID) services.getComponentID();
		   this.session_id_string = mcid.getInstanceName();
		   this.wgo_ports = wgo_ports;
		}

		#region GoPort implementation
		public int go ()
		{
            IDictionary<Thread, GoThread> thread_list = new Dictionary<Thread,GoThread>();
            for (int i = 0; i < wgo_ports.Length; i++)
            {
                Port wgo_port = wgo_ports[i];
                GoThread thread = new GoThread((GoPort)wgo_port);
                Thread t = new Thread(thread.Run);
                thread_list.Add(t, thread);
                t.Start();
            }

            foreach (KeyValuePair<Thread, GoThread> t in thread_list)
            {
                try
                {
                    t.Key.Join();
                    Console.WriteLine("Worker thread arrived GO : " + session_id_string);
                    // outputs[t.Value.Node] = t.Value.Output;
                }
                catch (Exception e)
                {
                    Console.WriteLine("Worker failed GO : " + session_id_string + ". error =" + e.Message);
                }
            }			
            Console.Error.WriteLine("Joined Threads GO: " + session_id_string);
            
            return 0;			
			
		}
		#endregion

        internal class GoThread
        {
			private gov.cca.ports.GoPort worker_go_port;

            public GoThread(gov.cca.ports.GoPort worker_go_port)
            {
				this.worker_go_port = worker_go_port;
            }

            public void Run()
            {
				Console.WriteLine("GO BEFORE !!!! ");
				worker_go_port.go();				
				Console.WriteLine("GO AFTER !!!! ");
            }

        }

	}

}

