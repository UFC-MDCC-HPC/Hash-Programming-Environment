
using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using DGAC.utils;
using System.Collections;
using MPI;
using System.Threading;

namespace DGAC.database
{
	public class WorkerService : System.ServiceProcess.ServiceBase
	{		
        private IpcServerChannel ch;

        private MPI.Environment mpi = null;
        Intracommunicator global_communicator = null;
        int number_of_workers = -1;

		public WorkerService()			
		{
            string[] args = System.Environment.GetCommandLineArgs();
            mpi = new MPI.Environment(ref args);
            this.global_communicator = MPI.Communicator.world;
            number_of_workers = this.global_communicator.Size;
        }		

		public static void Main (string[] args) { 
		    System.ServiceProcess.ServiceBase[] ServicesToRun; 
		    ServicesToRun = new System.ServiceProcess.ServiceBase[] { new WorkerService() }; 
		    System.ServiceProcess.ServiceBase.Run(ServicesToRun);  
		}		
		
		protected override void OnStart(string[] args)
		{ 
            IDictionary prop = new Hashtable();
            prop["portName"] = "WorkerHost";

            Console.WriteLine("Starting Worker on node " + MPI.Environment.ProcessorName);
            ch = new IpcServerChannel(prop, null);            
                
	        ChannelServices.RegisterChannel(ch,false);
	       
			RemotingConfiguration.RegisterWellKnownServiceType(typeof(ServerObject),
			                                                   "WorkerHost.rem",
			                                                   WellKnownObjectMode.SingleCall);

            ServerObject o = (ServerObject) Activator.GetObject(typeof(ServerObject), "ipc://WorkerHost/WorkerHost.rem");
            o.GlobalCommunicator = this.global_communicator;

            mpi_listener = new Thread(mpi_listening);
            mpi_listener.Start();

            Console.WriteLine("Worker Service Running ! on " + MPI.Environment.ProcessorName);
		}

        protected Thread mpi_listener = null;


        protected void mpi_listening()
        {
            int req = this.global_communicator.Receive<int>(0, MPIWorkerMessagingConstants.DEFAULT_TAG);
            switch (req)
            {
                case MPIWorkerMessagingConstants.CREATE_INSTANCE:
                    Console.WriteLine("CREATE_INSTANCE on " + this.global_communicator.Rank);
                    break;
            }


        }

        protected override void OnStop()
        {
            mpi_listener.Abort();
            mpi.Dispose();
            ch.StopListening(null);
            ChannelServices.UnregisterChannel(ch);
        }

        private void InitializeComponent()
        {
            // 
            // WorkerService
            // 
            this.ServiceName = "HPE.BackEnd";

        }		
				
	}
}
