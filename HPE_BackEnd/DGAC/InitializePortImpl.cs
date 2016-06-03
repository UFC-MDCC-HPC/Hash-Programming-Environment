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
		private Port[] w_initialize_port = null;
		
		public InitializePortImpl(ManagerServices services, Port[] winitialize_ports)
		{
		   this.mcid = (ManagerComponentID) services.getComponentID();
		   this.session_id_string = mcid.getInstanceName();
		   this.w_initialize_port = winitialize_ports;
		}

		#region AutomaticSlicesPort implementation
		public void on_initialize ()
		{			
            IDictionary<Thread, InitializeThread> thread_list = new Dictionary<Thread,InitializeThread>();
			foreach (Port port in w_initialize_port)
            {		       
				InitializeThread thread = new InitializeThread((InitializePort) port);
                Thread t = new Thread(thread.Run);
                thread_list.Add(t,thread);
                t.Start();
            }
            foreach (KeyValuePair<Thread,InitializeThread> t in thread_list)
            {
                try 
                {
					t.Key.Join();
                   Console.Error.WriteLine("Worker thread arrived : " + session_id_string);
                  // outputs[t.Value.Node] = t.Value.Output;
                } 
                catch (Exception e)
                {
                   Trace.WriteLine("Worker failed : " + session_id_string + ". error =" + e.Message);
                }
            }			
            Console.Error.WriteLine("Joined Threads : " + session_id_string);
            
			
		}
		#endregion

        internal class InitializeThread
        {
			private InitializePort worker_initialize_port;

            public InitializeThread(InitializePort worker_initialize_port)
            {
				this.worker_initialize_port = worker_initialize_port;
            }

            public void Run()
            {
				try {
					worker_initialize_port.on_initialize();				
				}
				catch (Exception e)
				{
					throw e;
				}
            }

        }

		#region AutomaticSlicesPort implementation
		public void after_initialize ()
		{
			
            IDictionary<Thread, AfterInitializeThread> thread_list = new Dictionary<Thread,AfterInitializeThread>();
            for (int i=0; i<w_initialize_port.Length; i++)
            {		       
				AfterInitializeThread thread = new AfterInitializeThread((InitializePort) w_initialize_port[i]);
                Thread t = new Thread(thread.Run);
                thread_list.Add(t,thread);
                t.Start();
            }
            foreach (KeyValuePair<Thread,AfterInitializeThread> t in thread_list)
            {
                try 
                {
					t.Key.Join();
                   Console.Error.WriteLine("Worker thread arrived : " + session_id_string);
                  // outputs[t.Value.Node] = t.Value.Output;
                } 
                catch (Exception e)
                {
                   Trace.WriteLine("Worker failed : " + session_id_string + ". error =" + e.Message);
                }
            }			
            Console.Error.WriteLine("Joined Threads : " + session_id_string);
		}
		#endregion

        internal class AfterInitializeThread
        {
			private InitializePort worker_initialize_port;

            public AfterInitializeThread(InitializePort worker_initialize_port)
            {
				this.worker_initialize_port = worker_initialize_port;
            }

            public void Run()
            {
				worker_initialize_port.after_initialize();				
            }

        }

	}

}

