using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using CommandLine.Utility;

namespace Back_End_Test
{
    class Program
    {

        static br.ufc.pargo.hpe.backend.DGAC.BackEnd dgac = null;

        static void Main(string[] args)
        {
			
			string instantiator_string_file;
			string user;
			string password;
			string curDir;
			string eId;
			int eVl;
			
			try {
				readArguments(args, out instantiator_string_file, out eId, out eVl, out user, out password, out curDir);
						
				string[] eIds = new string[] {eId};
				int[] eVls = new int[] {eVl};
				
	                        dgac = new br.ufc.pargo.hpe.backend.DGAC.BackEnd();
				
                 	        string instantiator_string = File.ReadAllText(instantiator_string_file);
				
				string[] output = dgac.runApplicationNew(instantiator_string, eIds, eVls, user, password, curDir);

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
			
			
            
          //  byte[] data = dgac.readEnvironmentTest();
        }

     static void readArguments(string[] args,
			                   out string instantiator_string_file, 
			                   out string eId, 
			                   out int eVl, 
			                   out string user, 
			                   out string password, 
			                   out string curDir) 
	 {
			instantiator_string_file = "";
			user = "";
			password = "";
			curDir = "";
			eId = "";
			eVl = 0;		

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
			
			if(CommandLine["enumerator_id"] != null) 
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

		}

		
    }
}
