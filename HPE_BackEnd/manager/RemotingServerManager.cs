using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using DGAC.utils;
using System.Collections;
using System.Runtime.Remoting.Channels.Tcp;
using System.IO;

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
        private TcpChannel tcpChannel = null;

        private void startWorkerClients() 
        {
           Console.WriteLine("Starting worker clients !");

           try
           {
             int i = 0;
             
             /* Read nodes file, and fill the node array */
             TextReader tr = new StreamReader(Constants.hosts_file);

             string hstr = tr.ReadToEnd();
             tr.Close();
             node = hstr.Split('\n');
 
             worker = new WorkerObject[node.Length];

             tcpChannel = new TcpChannel();
             ChannelServices.RegisterChannel(tcpChannel, false);

             /* Create each worker object and fill the worker array */
             foreach (string n in node) 
             {
               try
               {
                 createWorkerObject(i++,n);
                 Console.WriteLine("CONNECTED TO WORKER " + n);
               }
               catch (Exception e) 
               {
                 Console.WriteLine("ERROR CONNECTING TO WORKER " + n + ". Exception : " + e.Message);
               }
             }
           }
           catch (Exception e) 
           {
               Console.WriteLine(e.Message);
           }

           Console.WriteLine("Worker clients started !");
        }


        private void stopWorkerClients()
        {
            TcpChannel ch = tcpChannel;
            ch.StopListening(null);
            ChannelServices.UnregisterChannel(ch);
        }

        private void createWorkerObject(int i, string node)
        {
            WorkerObject wo = null;

            Type requiredType = typeof(WorkerObject);

            wo = (WorkerObject)Activator.GetObject(requiredType,
                "tcp://" + node + ":" + Constants.WORKER_PORT + "/" + Constants.WORKER_SERVICE_NAME);
            
            wo.sayHi();

            worker[i] = wo;
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
