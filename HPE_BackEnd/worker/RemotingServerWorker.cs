
using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using DGAC.utils;
using System.Collections;
using MPI;
using System.Threading;

namespace DGAC
{
    public class WorkerService : System.ServiceProcess.ServiceBase
    {
        private TcpChannel ch;

        private MPI.Environment mpi = null;
        private Intracommunicator global_communicator = null;
        int my_rank = -1;
        int number_of_workers = -1;

        public WorkerService(string[] args)
        {
            InitializeComponent();

            mpi = new MPI.Environment(ref args, Threading.Multiple);
            this.global_communicator = MPI.Communicator.world;
            number_of_workers = this.global_communicator.Size;
            my_rank = this.global_communicator.Rank;
            Console.WriteLine("Threading = " + MPI.Environment.Threading);
        }

        public static void Main(string[] args)
        {
            System.ServiceProcess.ServiceBase[] ServicesToRun;
            ServicesToRun = new System.ServiceProcess.ServiceBase[] { new WorkerService(args) };
            System.ServiceProcess.ServiceBase.Run(ServicesToRun);
        }


        private void startWorkerServer()
        {
          try 
          {
            Console.WriteLine("Starting Worker ");

            ch = new TcpChannel(Constants.WORKER_PORT);
            ChannelServices.RegisterChannel(ch, false);

            Type commonInterfaceType = typeof(WorkerObject);

            RemotingConfiguration.RegisterWellKnownServiceType(commonInterfaceType, Constants.WORKER_SERVICE_NAME, WellKnownObjectMode.Singleton);
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

            mpi_listener = new Thread(mpi_listening);
            mpi_listener.Start();
        }

        protected Thread mpi_listener = null;

        protected ReceiveRequest request = null;

        protected bool cancel = false;

        protected void mpi_listening()
        {

            do
            {
                Console.WriteLine("Worker " + my_rank + " is listening !");

                request = this.global_communicator.ImmediateReceive<int>(Communicator.anySource, MPIWorkerMessagingConstants.DEFAULT_TAG);

                if (!cancel)
                {

                    int v = (int)request.GetValue();

                    switch (v)
                    {
                        case MPIWorkerMessagingConstants.CREATE_INSTANCE:
                            Console.WriteLine("CREATE_INSTANCE on " + this.global_communicator.Rank);
                            break;
                    }
                }
            } while (!cancel);

            Console.WriteLine("Worker is no more listening !");
        }

        protected override void OnStop()
        {
            cancel = true;
            request.Cancel();
            mpi_listener.Join();
            mpi.Dispose();
            this.stopWorkerServer();
        }

        private void InitializeComponent()
        {
            // 
            // WorkerService
            // 
            this.ServiceName = "HPE.BackEnd.Worker";

        }

    }
}
