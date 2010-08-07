using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using DGAC.utils;
using System.Collections;

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

        private ManagerObject manager = null;

        private ManagerObject startManagerServer()
        {
            Console.WriteLine("Starting Manager ");
            channelManagerServer = new IpcChannel("ManagerHost");

            ChannelServices.RegisterChannel(channelManagerServer, false);

            RemotingConfiguration.RegisterWellKnownServiceType(typeof(ManagerObject),
                                                              "ManagerHost.rem",
                                                              WellKnownObjectMode.SingleCall);
            ManagerObject o = null;

            try
            {
                o = (ManagerObject)Activator.GetObject(typeof(ManagerObject), "ipc://ManagerHost/ManagerHost.rem");
                Console.WriteLine("Manager Service Running on ");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            return o;
        }

        private void stopManagerServer() 
        {
            Console.WriteLine("Manager is stopping !");
            channelManagerServer.StopListening(null);
            ChannelServices.UnregisterChannel(channelManagerServer);
            Console.WriteLine("Manager Service Finished ");
        }




        protected override void OnStart(string[] args)
        {
            manager = startManagerServer();
            if (manager != null)
            {
                manager.startWorkerClients();
            }
            else
            {
                Console.Error.WriteLine("Error initializing the manager object !");
            }
             
        }

        protected override void OnStop()
        {
            if (manager != null)
               manager.stopWorkerClients();

            stopManagerServer();
        }

        private void InitializeComponent()
        {
            this.ServiceName = "HPE.BackEnd.Manager";
        }
    }
}
