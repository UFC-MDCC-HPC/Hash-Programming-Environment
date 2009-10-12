
using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using DGAC.utils;

namespace DGAC.database
{
	public class WorkerService : System.ServiceProcess.ServiceBase
	{
		
        private int port = 5000;		
        private IpcChannel ch;

		public WorkerService()			
		{
		}
		

		public static void Main (string[] args) 
        {
		    System.ServiceProcess.ServiceBase[] ServicesToRun; 
                    Console.WriteLine("STARTING WORKER SERVICE");	
	
		    ServicesToRun = new System.ServiceProcess.ServiceBase[] { new WorkerService() }; 
		    System.ServiceProcess.ServiceBase.Run(ServicesToRun);  
                    Console.WriteLine("WORKER SERVICE FINISHED.");		
		}		
		
		protected override void OnStart(string[] args)
		{ 
            if (args.Length > 0) {
   	            port = Convert.ToInt32(Constants.getArgVal("--port"));
            } else {
                Console.WriteLine("Port was not informed in the command line. Using default port (5000).");                             
            }

		    Console.WriteLine("Starting Worker");
	        ch = new IpcChannel("WorkerHost");
                
	        ChannelServices.RegisterChannel (ch,false);
	       
			RemotingConfiguration.RegisterWellKnownServiceType(typeof(ServerObject),
			                                                   "WorkerHost.rem",
			                                                   WellKnownObjectMode.SingleCall);

            ServerObject o = (ServerObject) Activator.GetObject(typeof(ServerObject), 
                                                                       "ipc://WorkerHost/WorkerHost.rem");
						

            Console.WriteLine("Worker " /* + serviceName */ + " Running on port " + port + " and ip {0} " /*+addr[0].ToString()*/);
		}		

		protected override void OnStop()
		{ 
  		     ch.StopListening(null);
		}		
				
	}
}
