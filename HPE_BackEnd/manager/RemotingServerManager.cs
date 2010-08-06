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
        private IpcChannel ch;

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
            ch = new IpcChannel("ManagerHost");

            ChannelServices.RegisterChannel(ch, false);

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

        /* The Worker Object of each computing node */
        private WorkerObject[] worker = null;
        private string[] node = null;

        private void startWorkerClients() 
        {
           int i = 0;
           /* Read nodes file, and fill the node array */             
           

           /* Create each worker object and fill the worker array */
           foreach (string n in node) 
           {
               worker[i++] = createWorkerObject(n);
           }
        }

        private WorkerObject createWorkerObject(string node) 
        {
            WorkerObject wo = null;

            return wo;
        }



        protected override void OnStart(string[] args)
        {
            startManagerServer();
            startWorkerClients();
        }

        protected override void OnStop()
        {
            Console.WriteLine("Manager is stopping !");
            ch.StopListening(null);
            ChannelServices.UnregisterChannel(ch);
            Console.WriteLine("Manager Service Finished ");
        }

        private void InitializeComponent()
        {
            this.ServiceName = "HPE.BackEnd.Manager";
        }
    }
}
