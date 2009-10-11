
using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using DGAC.utils;

namespace DGAC.database
{
	
	
	public class WorkerService : System.ServiceProcess.ServiceBase
	{
		
                private int port = 5000;		
//		private System.Diagnostics.EventLog eventLog1;
                private TcpChannel ch;

		public WorkerService()			
		{
			// This call is required by the Windows.Forms Component Designer.
			InitializeComponent();

//			if(!System.Diagnostics.EventLog.SourceExists("WorkerLogSource"))
//		        System.Diagnostics.EventLog.CreateEventSource("WorkerLogSource", "WorkerLog");
//		
//		    eventLog1.Source = "WorkerLogSource";
//		
//		    eventLog1.Log = "WorkerLog";			
		}
		
		private void InitializeComponent()
		{
//			this.eventLog1 = new System.Diagnostics.EventLog();
//			((System.ComponentModel.ISupportInitialize)(this.eventLog1)).BeginInit();
			// 
			// eventLog1
			// 
//			this.eventLog1.Log = "WorkerLog";
//			this.eventLog1.Source = "WorkerLogSource";
			// 
			// Service1
			// 
//			this.ServiceName = "WorkerService";
//			((System.ComponentModel.ISupportInitialize)(this.eventLog1)).EndInit();

		}

		public static void Main (string[] args) 
        {
		    System.ServiceProcess.ServiceBase[] ServicesToRun; 
		
		    ServicesToRun = new System.ServiceProcess.ServiceBase[] { new WorkerService() }; 
		    System.ServiceProcess.ServiceBase.Run(ServicesToRun);  
                    Console.WriteLine("SERVICE STARTED.");		
	
		}		
		
		protected override void OnStart(string[] args)
		{ 
                     
                     if (args.Length > 0) {
       	                 port = Convert.ToInt32(Constants.getArgVal("--port"));
                     } else {
                         Console.WriteLine("Port was not informed in the command line. Using default port (5000).");                             
                     }

    			//String strHostName = "";
				//strHostName = Dns.GetHostName();
				//Console.WriteLine("--: "+strHostName);
				
		     IPHostEntry ipEntry = Dns.GetHostEntry("localhost");
		     IPAddress [] addr = ipEntry.AddressList;
	
				
		     Console.WriteLine("Starting Worker");
	             ch = new TcpChannel(this.port);
                
	             ChannelServices.RegisterChannel (ch,false);
	       
	             ServerObject so = new ServerObject();
	             string serviceName = Constants.SERVICE_NAME;
	             RemotingServices.Marshal(so,serviceName);

                     ch.StartListening(null);

	            Console.WriteLine("Worker " + serviceName + " Running on port " + port + " and ip {0} "+addr[0].ToString());
		}		

		protected override void OnStop()
		{ 
    		     ch.StopListening(null);
		}		
		
		protected override void OnContinue()
		{
//		    eventLog1.WriteEntry("my service is continuing in working");
		}		
		
	}
}
