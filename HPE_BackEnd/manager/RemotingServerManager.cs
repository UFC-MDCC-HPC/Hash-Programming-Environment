using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using DGAC.utils;
using System.Collections;
using System.Runtime.Remoting.Channels.Tcp;

namespace DGAC
{
    public partial class ManagerService : System.ServiceProcess.ServiceBase
    {
        private IpcChannel channelManagerServer;

        public ManagerService()
        {
            InitializeComponent();
        }

        public static void Main(string[] args)
        {
            System.ServiceProcess.ServiceBase[] ServicesToRun;
            ServicesToRun = new System.ServiceProcess.ServiceBase[] { new ManagerService() };
            System.ServiceProcess.ServiceBase.Run(ServicesToRun);
        }

        private void startManagerServer()
        {
            Console.WriteLine("Starting Manager ");
            channelManagerServer = new IpcChannel("ManagerHost");

            ChannelServices.RegisterChannel(channelManagerServer, false);

            RemotingConfiguration.RegisterWellKnownServiceType(typeof(ManagerObject),
                                                              "ManagerHost.rem",
                                                              WellKnownObjectMode.SingleCall);
            try
            {
                ManagerObject o = (ManagerObject)Activator.GetObject(typeof(ManagerObject), "ipc://ManagerHost/ManagerHost.rem");
                Console.WriteLine("Manager Service Running on ");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }

        private void stopManagerServer() 
        {
            Console.WriteLine("Manager is stopping !");
            channelManagerServer.StopListening(null);
            ChannelServices.UnregisterChannel(channelManagerServer);
            Console.WriteLine("Manager Service Finished ");
        }


        /* The Worker Object of each computing node */
        private WorkerObject[] worker = null;
        private string[] node = null;
        private TcpChannel[] channelWorkerServer = null;

        private void startWorkerClients() 
        {
           int i = 0;
           /* Read nodes file, and fill the node array */
           TextReader tr = new StreamReader(Constants.hosts_file);

           string hstr = tr.ReadToEnd();
           tr.Close();
           node = hstr.Split("\n");

           /* Create each worker object and fill the worker array */
           foreach (string n in node) 
           {
               createWorkerObject(i++,n);
           }
        }


        private void stopWorkerClients()
        {
            foreach (TcpChannel ch in channelWorkerServer)
            {
                ch.StopListening(null);
                ChannelServices.UnregisterChannel(ch);
            }
        }

        private void createWorkerObject(int i, string node)
        {
            WorkerObject wo = null;

            TcpChannel tcpChannel = new TcpChannel();
            ChannelServices.RegisterChannel(tcpChannel, false);

            Type requiredType = typeof(WorkerObject);

            wo = (WorkerObject)Activator.GetObject(requiredType,
                "tcp://" + node + ":" + Constants.WORKER_PORT + "/" + Constants.WORKER_SERVICE_NAME);

            worker[i] = wo;
            channelWorkerServer[i] = tcpChannel;            
        }



        protected override void OnStart(string[] args)
        {
            startManagerServer();
            startWorkerClients();
        }

        protected override void OnStop()
        {
            stopWorkerClients();
            stopManagerServer();
        }

        private void InitializeComponent()
        {
            this.ServiceName = "HPE.BackEnd.Manager";
        }
    }
}
