
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

namespace br.ufc.pargo.hpe.backend.DGAC
{
    public class WorkerService : System.ServiceProcess.ServiceBase
    {
        private TcpChannel ch;
        private static int port = Constants.WORKER_PORT;

        private MPI.Environment mpi = null;
        private Intracommunicator global_communicator = null;
        int my_rank = -1;
        int number_of_workers = -1;

        public WorkerService(string[] args)
        {            
            InitializeComponent();
            StartMPI(args);
        }
 
        public void StartMPI(string[] args)
        {
            Console.WriteLine("Starting MPI ... ");
            mpi = new MPI.Environment(ref args, Threading.Multiple);
            Console.Write("ok !");
            this.global_communicator = MPI.Communicator.world;
            number_of_workers = this.global_communicator.Size;
            my_rank = this.global_communicator.Rank;
            Console.WriteLine("Rank #" + my_rank + " at processor " + MPI.Environment.ProcessorName + " - threading is " + MPI.Environment.Threading);
        }


        public static void Main(string[] args)
        {
            port = args.Length == 0 ? -1 : System.Convert.ToInt32(args[0], 10);
            Console.WriteLine("Initializing Worker");
            System.ServiceProcess.ServiceBase[] ServicesToRun;
            ServicesToRun = new System.ServiceProcess.ServiceBase[] { new WorkerService(args) };
            System.ServiceProcess.ServiceBase.Run(ServicesToRun);
        }


        private void startWorkerServer()
        {
          try 
          {  
			string service_name = Constants.WORKER_SERVICE_NAME + "-" + my_rank;	
				
            if (port < 0) 
            {          
                port = Constants.WORKER_PORT + my_rank;
            }

            Console.WriteLine("Starting " + service_name + " listening on port ... " + port);

            //System.Runtime.Remoting.Channels.BinaryServerFormatterSinkProvider server_provider = new System.Runtime.Remoting.Channels.BinaryServerFormatterSinkProvider();
            //server_provider.TypeFilterLevel = System.Runtime.Serialization.Formatters.TypeFilterLevel.Full;
            //IDictionary prop = new Hashtable();
            //prop["port"] = port;
            ch = new TcpChannel(port/*, server_provider */);

            ChannelServices.RegisterChannel(ch);
				
			RemotingConfiguration.ApplicationName = service_name;
            RemotingConfiguration.RegisterActivatedServiceType(typeof(WorkerObject));
				
			//string uri_str = "tcp://" + "localhost" + ":" + Constants.MANAGER_PORT + "/" + Constants.MANAGER_SERVICE_NAME;
			//RemotingConfiguration.RegisterActivatedClientType(typeof(WorkerServicesImpl), uri_str);
				
//			TcpServerChannel channel = new TcpServerChannel(port);
//		    ChannelServices.RegisterChannel(channel, false);
//		    WorkerObject remoteObject = new WorkerObject();     
//		    RemotingServices.Marshal(remoteObject, "WorkerObject.rem");	
				
				
            //RemotingConfiguration.RegisterWellKnownServiceType(typeof(WorkerObject), Constants.WORKER_SERVICE_NAME, WellKnownObjectMode.Singleton);
            Console.WriteLine("Worker #" + my_rank + " running !");
          }
          catch (Exception e)
          {
            Console.WriteLine(e.Message);
          }
        }

        private void stopWorkerServer()
        {
            Console.WriteLine("Worker is stopping !");
            ch.StopListening(null);
            ChannelServices.UnregisterChannel(ch);
            Console.WriteLine("Worker Service Finished ");
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
            this.ServiceName = Constants.WORKER_SERVICE_NAME;

        }

    }
}
