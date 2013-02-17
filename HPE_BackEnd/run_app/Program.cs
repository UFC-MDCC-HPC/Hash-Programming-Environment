using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using CommandLine.Utility;
using System.Threading;
using System.Xml;

using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.connector.load;
using br.ufc.pargo.hpe.ConnectorImpl;

using gov.cca;

namespace Back_End_Test
{
	class Program
	{

			static BackEnd dgac = null;
		
			static string instantiator_string_file;
			static string user;
			static string password;
			static string curDir;
			static int rounds;
			static string prefix;
			static string instantiator_string;
		
			static AbstractFramework[] workers;
		
		static void Main (string[] args)
		{
			
			try {
				readArguments (args, out instantiator_string_file, out user, out password, out curDir, out rounds, out prefix);
				
				dgac = new BackEnd ();
				instantiator_string = File.ReadAllText (instantiator_string_file);

				Thread thread = new Thread(new ThreadStart(run));
				thread.Start();

				string instruction;
				while(true)
				{
					Console.WriteLine("");
					Console.WriteLine("[HPE_Run.Main] Enter your command: 'select <key>' or 'reconfigure <file-path>'");
					Console.Write("> ");
					instruction = Console.ReadLine();
					if(dgac.Manager != null)
					{
						if(dgac.Manager.WorkerFramework != null)
						{
							workers = dgac.Manager.WorkerFramework;
							
							if(instruction.StartsWith("select")) {
								string key;
								
								if(instruction.Length > 7) {
									key = instruction.Substring(7);
								} else {
									key = "";
								}
								selectComponent(key);
								
							} else if(instruction.StartsWith("reconfigure")) {
								string xml = instruction.Substring(12);
								
								Reconfigure(xml);
							} else if (instruction.Equals("r1")) {
								Reconfigure("/home/juliano/hpe/temp/reconf1.xml");
							} else if (instruction.Equals("r2")) {
								Reconfigure("/home/juliano/hpe/temp/reconf2.xml");
							}
						} else
						{
							Console.WriteLine("[HPE_Run.Main] Ainda não está pronto para reconfiguração");
						}
					} else
					{
						Console.WriteLine("[HPE_Run.Main] Ainda não está pronto para reconfiguração");
					}
				}

			} catch (Exception e) {
				Console.Error.WriteLine ("[HPE_Run.Main] Error trying to run an application: " + e.Message);
				Console.Error.WriteLine ("[HPE_Run.Main] Stack trace: " + e.StackTrace);
				Console.Error.WriteLine ("[HPE_Run.Main] Inner Exception: " + e.InnerException);
			}
			
			
            
			//  byte[] data = dgac.readEnvironmentTest();
		}
		
		protected static void selectComponent(string key)
		{
			
			if(!key.StartsWith("-e")) {
				Console.WriteLine("Components who name contains '{0}'", key);
				Console.WriteLine("");
			}
			
			foreach(string name in ((WorkerObject) workers[0]).ComponentIDs.Keys) {
				
				if(key.StartsWith("-e")) {
					if(name.Equals(key.Substring(3))) {
						Console.WriteLine("Component found: {0}", name);
						break;
					}
					
				} else {
					if(name.Contains(key)) {
						Console.WriteLine("Component: {0}", name);
					}
				}
			}
		}
		
		protected static void Reconfigure(string xml)
		{
				XmlDocument document = new XmlDocument ();
				XmlNode nodeRequest, data;
            
				document.Load (xml);
				nodeRequest = document.SelectSingleNode ("reconfigurationRequest");
				data = nodeRequest.SelectSingleNode ("targetComponent");
			
				string targetComponent = data.InnerText;
			
			List<IConnectorImpl> connectors = new List<IConnectorImpl>();
			IConnectorImpl connimpl;
			IUnit unit;
			int i = 0;
			foreach(AbstractFramework ab in workers)
			{
				WorkerObject worker = (WorkerObject) ab;
				if (worker.UnitInstances.TryGetValue(targetComponent, out unit)) {
					if((unit as IConnectorImpl) != null) {
						Console.WriteLine("[HPE_Run.Reconfigure] Worker {0} : Conector Encontrado!", i++);
						connimpl = (IConnectorImpl) unit;
						connimpl.ConfigurationPort.BuildService = worker;
						connectors.Add(connimpl);
					} else {
						Console.WriteLine("[HPE_Run.Reconfigure] Worker {0} : O componente {1} não é um conector HCL!", i++, targetComponent);
					}
				}
			}
			// reconfigure /home/juliano/hpe/temp/reconf1.xml
			bool sucess = true;
			foreach(IConnectorImpl conn in connectors) {
			
				Console.WriteLine("[HPE_Run.Reconfigure] Avaliando a Reconfiguração no Conector {0}", conn.Id_unit);
				
				if(conn.ConfigurationPort.Ready) {
					//medição
					DateTime t_initial = DateTime.Now;
					
					bool result = conn.ConfigurationPort.EvaluateReconfiguration(xml);
					
					//medição
					DateTime t_end = DateTime.Now;
					TimeSpan t_diff = t_end.Subtract(t_initial);
					Console.WriteLine("[HPE_Run.Reconfigure] Tempo de Avaliação: " + t_diff.Milliseconds + " ms"); 

					if(!result) {
						
						Console.WriteLine("[HPE_Run.Reconfigure] A Reconfiguração não pode ser aplicada ao Conector {0}", conn.Id_unit);
						Console.WriteLine("[HPE_Run.Reconfigure] O processo de reconfiguração será cancelado");
						sucess = false;
						break;
					}
					
				} else {
					Console.WriteLine("[HPE_Run.Reconfigure] A Reconfiguração não pode ser aplicada ao Conector {0}", conn.Id_unit);
					Console.WriteLine("[HPE_Run.Reconfigure] O ConfigurationManager ainda está em processo de formação.");
					Console.WriteLine("[HPE_Run.Reconfigure] O processo de reconfiguração será cancelado");
					sucess = false;
					break;				
				}
			}
			
			Console.WriteLine("[HPE_Run.Reconfigure] Finalizando o procedimento!");
			foreach(IConnectorImpl conn in connectors) {
				if(sucess) {
					
					//medição
					DateTime t_initial = DateTime.Now;
					
					conn.ConfigurationPort.CommitReconfiguration();
					
					//medição
					DateTime t_end = DateTime.Now;
					TimeSpan t_diff = t_end.Subtract(t_initial);
					Console.WriteLine("[HPE_Run.Reconfigure] Tempo de Commit: " + t_diff.Milliseconds + "ms"); 
				} else {
					conn.ConfigurationPort.CancelReconfiguration();
				}
			}
			
			if(sucess) {
				Console.WriteLine("[HPE_Run.Reconfigure] Reconfiguração aplicada com sucesso!");
			} else {
				Console.WriteLine("[HPE_Run.Reconfigure] Não foi possível aplicar a reconfiguração em um ou mais nós. O procedimento foi abortado");
			}
		}
		
		protected static void run ()
		{
			Console.WriteLine("[HPE_Run.Run] run in new thread");
			
			string[] output = null;
			if (prefix == null) {					
				output = dgac.runApplication (instantiator_string, user, password, curDir);
			} else {
				output = dgac.runApplicationNTimes (instantiator_string, user, password, curDir, rounds, prefix);
			}

			int i = 0;
			foreach (string o in output) {
				Console.WriteLine ("--- Process " + (i++) + " ----------- ");
				Console.WriteLine (o);
			}
			
			Console.WriteLine("[HPE_Run.Reconfigure] End of Execution!");
		}

		static void readArguments (string[] args,
			                   out string instantiator_string_file, 
//			                   out string eId, 
//			                   out int eVl, 
			                   out string user, 
			                   out string password, 
			                   out string curDir,
			                   out int rounds, 
			                   out string prefix)
		{
			instantiator_string_file = "";
			user = "";
			password = "";
			curDir = "";
//			eId = "";
//			eVl = 0;	
			rounds = 1;
			prefix = null;

			Arguments CommandLine = new Arguments (args);			
			
			if (CommandLine ["instantiator_file"] != null) {
				instantiator_string_file = CommandLine ["instantiator_file"];
				Console.WriteLine ("--instantiator_file = " + instantiator_string_file);
			} else {
				Console.Error.WriteLine ("'-instantiatior_file = <path>' is required");
				Environment.Exit (0);
			}            
			
			if (CommandLine ["user"] != null) {
				user = CommandLine ["user"];
				Console.WriteLine ("--user = " + user);
			}
			
			if (CommandLine ["password"] != null) {
				password = CommandLine ["password"];
				Console.WriteLine ("--password = " + password);
			}
			
			if (CommandLine ["current_dir"] != null) {
				curDir = CommandLine ["current_dir"];
				Console.WriteLine ("--current_dir = " + curDir);
			}
			
/*			if(CommandLine["enumerator_id"] != null) 
			{
               eId = CommandLine["enumerator_id"];
			   Console.WriteLine("--enumerator_id = " + eId);
			}
			else 
			{
			   Console.Error.WriteLine("'-enumerator_id = <string>' is required");
			   Environment.Exit(0);
			}
           
			if(CommandLine["enumerator_value"] != null) 
			{
               eVl = Int32.Parse(CommandLine["enumerator_value"]);
			   Console.WriteLine("--enumerator_value = " + eVl);
			}
			else 
			{
			   Console.Error.WriteLine("'-enumerator_value = <integer>' is required");
			   Environment.Exit(0);
			}
*/			
			if (CommandLine ["rounds"] != null) {
				if (!Int32.TryParse (CommandLine ["rounds"], out rounds)) {
					Console.Error.WriteLine ("'-rounds <integer>' is expected");
					Environment.Exit (0);
				}
				Console.WriteLine ("--rounds = " + rounds);
			}

			if (CommandLine ["prefix"] != null) {
				prefix = CommandLine ["prefix"];
				Console.WriteLine ("--prefix = " + prefix);
			}
			
		}

		
	}
}
