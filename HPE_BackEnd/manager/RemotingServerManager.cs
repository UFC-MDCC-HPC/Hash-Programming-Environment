using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Collections;
using System.Runtime.Remoting.Activation;
using CommandLine.Utility;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.backend.DGAC
{
    public partial class ManagerService	  : System.ServiceProcess.ServiceBase
    {
        private IpcChannel channelManagerServer;
		private string session_id = null;
		private int port = -1;

        public ManagerService(string[] args)
        {
			readArguments (args, out port, out session_id);
            InitializeComponent();
        }

        public static void Main(string[] args)
        {
            System.ServiceProcess.ServiceBase[] ServicesToRun;
            ServicesToRun = new System.ServiceProcess.ServiceBase[] { new ManagerService(args) };
            System.ServiceProcess.ServiceBase.Run(ServicesToRun);
        }

        private ManagerObject manager = null;

        private void startManagerServer()
        {
            Trace.WriteLine("Starting Manager ");

            System.Runtime.Remoting.Channels.BinaryServerFormatterSinkProvider server_provider = new System.Runtime.Remoting.Channels.BinaryServerFormatterSinkProvider();
            System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider client_provider = new System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider();
            server_provider.TypeFilterLevel = System.Runtime.Serialization.Formatters.TypeFilterLevel.Full;
            IDictionary prop = new Hashtable();
            prop["portName"] = Constants.MANAGER_PORT_NAME;
            channelManagerServer = new IpcChannel(prop, client_provider, server_provider);

            ChannelServices.RegisterChannel(channelManagerServer, false);
			
			RemotingConfiguration.ApplicationName = /*"ManagerHost"; */ Constants.MANAGER_PORT_NAME + (session_id == null ? "" : "-" + session_id);
            RemotingConfiguration.RegisterActivatedServiceType(typeof(ManagerObject));

			Trace.WriteLine("Manager Service " + RemotingConfiguration.ApplicationName +  " running ...");

		}

        private void stopManagerServer() 
        {
            Trace.WriteLine("Manager is stopping !");
            channelManagerServer.StopListening(null);
            ChannelServices.UnregisterChannel(channelManagerServer);
            Trace.WriteLine("Manager Service Finished ");
        }

        protected override void OnStart(string[] args)
        {
			Trace.Write("OnStart called...");
            startManagerServer();
            BackEnd.startWorkers(session_id);
			Trace.WriteLine("OK !");
        }

        protected override void OnStop()
        {
			Trace.Write("OnStop called...");
            BackEnd.stopWorkers(session_id);
            stopManagerServer();
			Trace.WriteLine("OK !");
       }

        private void InitializeComponent()
        {
            this.ServiceName = "HPE.BackEnd.Manager";
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
