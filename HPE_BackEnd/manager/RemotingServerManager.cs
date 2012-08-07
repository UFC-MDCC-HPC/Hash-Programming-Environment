using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Collections;
using System.Runtime.Remoting.Activation;

namespace br.ufc.pargo.hpe.backend.DGAC
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

        private void startManagerServer()
        {
            Console.WriteLine("Starting Manager ");

            System.Runtime.Remoting.Channels.BinaryServerFormatterSinkProvider server_provider = new System.Runtime.Remoting.Channels.BinaryServerFormatterSinkProvider();
            System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider client_provider = new System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider();
            server_provider.TypeFilterLevel = System.Runtime.Serialization.Formatters.TypeFilterLevel.Full;
            IDictionary prop = new Hashtable();
            prop["portName"] = Constants.MANAGER_PORT_NAME;
            channelManagerServer = new IpcChannel(prop, client_provider, server_provider);

            ChannelServices.RegisterChannel(channelManagerServer, false);
			
			RemotingConfiguration.ApplicationName = "ManagerHost";
            RemotingConfiguration.RegisterActivatedServiceType(typeof(ManagerObject));
/*			
            //RemotingConfiguration.RegisterWellKnownServiceType(typeof(ManagerObject),
            //                                                  "ManagerHost.rem",
            //                                                  WellKnownObjectMode.Singleton);
            ManagerObject o = null;

            try
            {
				object[] activateAttribute = 
			              {new UrlAttribute("ipc://ManagerHost")};
				o = (ManagerObject) Activator.CreateInstance(typeof(ManagerObject), null, activateAttribute);
                // o = (ManagerObject)Activator.GetObject(typeof(ManagerObject), "ipc://ManagerHost/ManagerHost.rem");
                Console.WriteLine("Manager Service Running on ");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message + ", INNER EXCEPTION: " + e.InnerException.Message);
            }

            return o;*/
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
            startManagerServer();
            //if (manager != null)
            //{
            //    manager.startWorkerClients();
            //}
            //else
            //{
             //   Console.Error.WriteLine("Error initializing the manager object !");
            //}             
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
