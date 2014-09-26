
using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Collections;
using MPI;
using System.Threading;
using System.Runtime.Remoting.Channels.Http;
using System.Runtime.Remoting.Channels.Ipc;
using CommandLine.Utility;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.backend.DGAC
{
    public class WorkerService : System.ServiceProcess.ServiceBase
    {
        private TcpChannel ch;
        private int port = Constants.WORKER_PORT;
		private string session_id = null;

        private MPI.Environment mpi = null;
        private Intracommunicator global_communicator = null;
        int my_rank = -1;
        int number_of_workers = -1;

        public WorkerService(string[] args)
        {            
			readArguments (args, out port, out session_id);
            InitializeComponent();
            StartMPI(args);
        }
 
        public void StartMPI(string[] args)
        {
            Trace.WriteLine("Starting MPI ... ");
            mpi = new MPI.Environment(ref args, Threading.Multiple);
            Trace.Write("ok !");
            this.global_communicator = MPI.Communicator.world;
            number_of_workers = this.global_communicator.Size;
            my_rank = this.global_communicator.Rank;
            Trace.WriteLine("Rank #" + my_rank + " at processor " + MPI.Environment.ProcessorName + " - threading is " + MPI.Environment.Threading);
        }


        public static void Main(string[] args)
        {
            Trace.WriteLine("Initializing Worker");
            System.ServiceProcess.ServiceBase[] ServicesToRun;
            ServicesToRun = new System.ServiceProcess.ServiceBase[] { new WorkerService(args) };
            System.ServiceProcess.ServiceBase.Run(ServicesToRun);
        }


        private void startWorkerServer()
        {
          try 
          {  
			string service_name = Constants.WORKER_SERVICE_NAME + (session_id == null ? "" : "-" + session_id) + "-" + my_rank;	
				
            if (port < 0) 
                port = Constants.WORKER_PORT + my_rank;
 
            Trace.WriteLine("Starting " + service_name + " listening on port ... " + port);

            ch = new TcpChannel(port/*, server_provider */);

            ChannelServices.RegisterChannel(ch);
				
			RemotingConfiguration.ApplicationName = service_name;
            RemotingConfiguration.RegisterActivatedServiceType(typeof(WorkerObject));
				
            Trace.WriteLine("Worker #" + my_rank + " running !");
          }
          catch (Exception e)
          {
            Trace.WriteLine(e.Message);
          }
        }

        private void stopWorkerServer()
        {
            Trace.WriteLine("Worker is stopping !");
            ch.StopListening(null);
            ChannelServices.UnregisterChannel(ch);
            Trace.WriteLine("Worker Service Finished ");
        }

        protected override void OnStart(string[] args)
        {
            this.startWorkerServer();

         }

        protected override void OnStop()
        {
            mpi.Dispose();
            this.stopWorkerServer();
        }

        private void InitializeComponent()
        {
            // 
            // WorkerService
            // 
			this.ServiceName = Constants.WORKER_SERVICE_NAME + (session_id == null ? "" : "-" + session_id) + my_rank;

        }

		static void readArguments(string[] args,
		                          out int port, 
		                          out string session_id) 
		{
			port = -1;
			session_id = null;

			Arguments CommandLine = new Arguments(args);			

			if(CommandLine["port"] != null) 
			{
               if (!Int32.TryParse(CommandLine["port"], out port)) 
			   {
				   Console.Error.WriteLine("'-port <integer>' is expected");
				   System.Environment.Exit(0);
			   }
			   Trace.WriteLine("--port " + port);
			}

			if(CommandLine["session"] != null) 
			{
               session_id = CommandLine["session"];
			   Trace.WriteLine("--session " + session_id);
			}
			
		}
    }
}
