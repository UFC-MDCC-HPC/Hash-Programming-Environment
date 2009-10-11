//Remoting
using System;
using System.Net;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using DGAC.utils;

namespace DGAC.database
{

        class RemotingServerWorker
        {
        		int port = 5000;
		        /*
		         *Inicia um ServerObject em uma porta definida como entrada.
		         *A compilação desta classe gera um executável (o worker.exe, ver script make_worker.rsp) 
                 */
        		public RemotingServerWorker(int port){
        		
        			this.port = port;
        			//String strHostName = "";
					//strHostName = Dns.GetHostName();
					//Console.WriteLine("--: "+strHostName);
					
					IPHostEntry ipEntry = Dns.GetHostEntry("localhost");
					IPAddress [] addr = ipEntry.AddressList;
		
					
			        Console.WriteLine("Starting Worker");
		            TcpChannel ch = new TcpChannel(this.port);
                    
		            ChannelServices.RegisterChannel (ch,true);
		       
		            ServerObject so = new ServerObject();
		            string serviceName = Constants.SERVICE_NAME;
		            RemotingServices.Marshal(so,serviceName);

                    ch.StartListening(null);

		            Console.WriteLine("Worker " + serviceName + " Running on port " + port + " and ip {0} "+addr[0].ToString());
		            Console.ReadLine();
		
		            ch.StopListening (null);
        		
        		}
        		
                public static void Main (string[] args) 
                {
                        int port = 5000;
                        if (args.Length > 0) {
			                port = Convert.ToInt32(Constants.getArgVal("--port"));
                        } else {
                            Console.WriteLine("Port was not informed in the command line. Using default port (5000).");                             
                        }
                        new RemotingServerWorker(port);
					 
                }


        }
}
