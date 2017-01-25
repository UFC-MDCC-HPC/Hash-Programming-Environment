using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using CommandLine.Utility;
using System.Diagnostics;
using br.ufc.pargo.hpe.backend.DGAC;

namespace Back_End_Test
{
    class Program
    {
        static void Main(string[] args)
        {
			
			string instantiator_string_file;
			string user;
			string password;
			string curDir;
			int rounds;
			string prefix;

			TextWriterTraceListener writer = new TextWriterTraceListener(System.Console.Out);
			Trace.Listeners.Add(writer);

			try 
			{
				readArguments(args, out instantiator_string_file, out user, out password, out curDir, out rounds, out prefix);
										
                string instantiator_string = File.ReadAllText(instantiator_string_file);

				string[] output = null;
				if (prefix == null) 
				{					
				  output = BackEnd.runApplication(instantiator_string, prefix/*, user, password, curDir*/);
				} 
				else 
				{
				  output = BackEnd.runApplicationNTimes(instantiator_string, /*user, password, curDir,*/ rounds, prefix);
//					dgac.testReconfiguration(instantiator_string_1, instantiator_string_2, prefix);
				}

                int i = 0;
                foreach (string o in output) 
                {
                    Console.WriteLine("--- Process " + (i++) + " ----------- ");
                    Console.WriteLine(o);
                }


			} 
			catch (Exception e)
			{
			   Console.Error.WriteLine("Error trying to run an application: " + e.Message);
			   Console.Error.WriteLine("Stack trace: " + e.StackTrace);
			   Console.Error.WriteLine("Inner Exception: " + e.InnerException);
			}
			finally 
			{

			}
			
			
            
          //  byte[] data = dgac.readEnvironmentTest();
        }

     static void readArguments(string[] args,
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

			Arguments CommandLine = new Arguments(args);			
			
			if(CommandLine["instantiator_file"] != null) 
			{
               instantiator_string_file = CommandLine["instantiator_file"];
			   Console.WriteLine("--instantiator_file = " + instantiator_string_file);
			}
            else 
			{
			   Console.Error.WriteLine("'-instantiatior_file = <path>' is required");
			   Environment.Exit(0);
			}            
			
			if(CommandLine["user"] != null) 
			{
               user = CommandLine["user"];
			   Console.WriteLine("--user = " + user);
			}
			
			if(CommandLine["password"] != null) 
			{
               password = CommandLine["password"];
			   Console.WriteLine("--password = " + password);
			}
			
			if(CommandLine["current_dir"] != null) 
			{
               curDir = CommandLine["current_dir"];
			   Console.WriteLine("--current_dir = " + curDir);
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
			if(CommandLine["rounds"] != null) 
			{
               if (!Int32.TryParse(CommandLine["rounds"], out rounds)) 
			   {
				   Console.Error.WriteLine("'-rounds <integer>' is expected");
				   Environment.Exit(0);
			   }
			   Console.WriteLine("--rounds = " + rounds);
			}

			if(CommandLine["prefix"] != null) 
			{
               prefix = CommandLine["prefix"];
			   Console.WriteLine("--prefix = " + prefix);
			}
			
		}

		
    }
}
