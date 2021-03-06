using System;
using System.IO;
using System.Net;
using System.Diagnostics;
using System.Reflection;
using System.Collections.Generic;
using System.Text;

namespace br.ufc.pargo.hpe.backend.DGAC.utils{

public class CommandLineUtil {

    
  /// <summary>
  /// Method to run an exe
  /// </summary>
  /// <param file="path">The string that include the exe name.</param>
  /// <returns>bool</returns>
    public static bool run_exe(IDictionary<string, int> files, 
                               IDictionary<string, int> enums, 
                               int session_id, string userName, 
                               string password, 
                               String curDir)
    {
     
     System.Diagnostics.Process proc = new System.Diagnostics.Process();
     proc.EnableRaisingEvents=false;

     string eStr = "";
     foreach (KeyValuePair<string, int> k in enums)
         eStr += " --enumerator " + k.Key + " " + k.Value;

     eStr += " --session " + session_id;

     string uStr = "";
     bool firstPass = true;
     
     foreach (KeyValuePair<string, int> k in files)
     {
         uStr += (firstPass ? "" : " :") + " -np " + k.Value + " " + Constants.mpi_run_flags + " " + Constants.cli_runtime + " " + Constants.PATH_BIN + k.Key + "Main.exe " + eStr;
         firstPass = false;
     }

     runCommand(Constants.mpi_run, uStr, userName, password, curDir);

     return true;
  }
  
  /// <summary>
  /// Method to compile a source and create an exe
  /// </summary>
  /// <param path="file">The string that include source name</param>
  /// <returns>bool</returns>
  public static bool compile_to_exe
      (string contents, 
       string moduleName, 
       string[] references,
       string userName, 
       string password, 
       string curDir){

          string moduleNameWithoutExtension = moduleName.Split('.')[0];
          
          //references
          string mounted_references = "";
          if (references != null && references.Length > 0)
              foreach (string reference in references)
                  mounted_references += " -r:\"" + reference + (reference.EndsWith(".dll") ? "" : ".dll") + "\"";
              
          Console.WriteLine(mounted_references);

          // CREATE THE FILE <moduleName>.cs in the temporary directory with <contents> as the contents:

          createFile(contents, moduleName);

          runCommand(Constants.cs_compiler, " /noconfig -lib:" + Constants.PATH_DGAC + "," + Constants.UNIT_PACKAGE_PATH + " -r:DGAC.dll" + " /target:exe /out:" + Constants.PATH_BIN + moduleNameWithoutExtension + ".exe " + Constants.PATH_TEMP_WORKER + moduleNameWithoutExtension + ".cs " + mounted_references, userName, password, curDir);

          return true;      
           
  }
  
  /// <summary>
  /// Method to generate strong key file.
  /// </summary>
  /// <param name="name">The string that include de source file name, wich will be the key file name. Null means that will be used the default name.</param>
  /// <returns>bool</returns>
  public static string create_strong_key(string nameWithoutExtension, string userName, string password, string curDir){

      // string nameWithoutExtension = name.Split('.')[0];

      String snkFileName = Constants.PATH_TEMP_WORKER + nameWithoutExtension + ".snk";

      if (!File.Exists(snkFileName))
      {
          runCommand(Constants.key_generator, "-k " + snkFileName, userName, password, curDir);
      }

      FileStream f = File.Open(snkFileName, FileMode.Open);

      StrongNameKeyPair rr = new StrongNameKeyPair(f);
      string skp = BitConverter.ToString(rr.PublicKey);
      f.Close();

     return skp.Replace("-","");
  }

   

  /// <summary>
  /// Method to generate DLL assembly from source code C#.
  /// asseblies are saved in Constants.PATH_TEMP_WORKER
  /// </summary>
  /// <param name="file">The command line that includes de source file name</param>
  /// <returns>bool</returns>
  /// 
  public static bool compile_source(Tuple<string,string>[] sourceContents, string moduleName, string[] references, 
		                            string userName, string password, String curDir)
	{
			Console.WriteLine ("Module NAME is " + moduleName);

          
          //references

          string mounted_references = "";
          if (references != null && references.Length > 0)
              foreach (string reference in references)
              {
                  mounted_references += " -r:\"" + reference + (reference.EndsWith(".dll") ? "" : ".dll") + "\"";
              }
          Console.WriteLine(mounted_references);

          // CREATE THE FILE <moduleName>.cs in the temporary directory with <contents> as the contents:

		  string sourceCompileString = " ";
		  foreach (Tuple<string,string> sourceContentsItem in sourceContents) 
		  {
			string sourceName = sourceContentsItem.Item1 + ".cs";
			createFile (sourceContentsItem.Item2, sourceName);
			sourceCompileString += Constants.PATH_TEMP_WORKER + sourceName + " ";
		  }

          runCommand(Constants.cs_compiler, Constants.cs_compiler_flags 
			           + " -lib:" + Constants.PATH_DGAC + "," + Constants.UNIT_PACKAGE_PATH + " -r:DGAC.dll" 
			           + " /target:library /out:" + Constants.PATH_TEMP_WORKER + moduleName + ".dll" 
			           + " /keyfile:" + Constants.PATH_TEMP_WORKER + moduleName + ".snk" 
			           + sourceCompileString  
			           + mounted_references, userName, password, curDir);
          // -r:mpibasicimpl\\IMPIBasicImpl.dll 
          return true;
  }

    private static void createFile(string contents, string fileName)
    {
        // throw new Exception("The method or operation is not implemented.");
        FileUtil.writeToFile(fileName, contents);
    }
  
 
  /// <summary>
  /// Method to install an assembly from gac
  /// assemblies were saved by worker in Constants.PATH_TEMP_WORKER
  /// assemblies will be installed in <gac_dir>/HASH wich must be in MONO_PATH
  /// </summary>
  /// <param name="assembly">The assembly name</param>
  /// <returns>bool</returns>
  public static bool gacutil_install(string library_path, string assembly, int gac, string userName, string password){

      runCommand(Constants.gac_util, "-u " + assembly);
      runCommand(Constants.gac_util, "-i " + Constants.PATH_TEMP_WORKER + assembly + ".dll" + " -package " + library_path, userName, password, null);

//      runCommand("copy", Constants.PATH_TEMP_WORKER + assembly + ".dll" + " " + Constants.UNIT_PACKAGE_PATH + Path.DirectorySeparatorChar + cuid );

      string package_path = Constants.UNIT_PACKAGE_PATH.Replace("\"", "");
      string fileSource = Constants.PATH_TEMP_WORKER + assembly + ".dll";
      string pathTarget = package_path + Path.DirectorySeparatorChar + library_path;
      string fileTarget = pathTarget + Path.DirectorySeparatorChar + assembly + ".dll";
      if (!Directory.Exists(pathTarget))
      {
	  	  Console.WriteLine("From " + fileSource + " to " + fileTarget);
          Directory.CreateDirectory(pathTarget);
      }
      File.Copy(fileSource, fileTarget, true);

      return true;
  }
  
  /// <summary>
  /// Method to unninstal an assembly from gac
  /// </summary>
  /// <param name="assemblyPath">The assembly path</param>
  /// <returns>bool</returns>
  public static bool gacutil_uninstall(string assembly, string userName, string password){

      runCommand(Constants.gac_util, "-u " + assembly, userName, password, null);

      return true;
  }

    public static void clean(string assembly){
	    //cleaning temp files
         string[] filesToDelete = new string[]{".cs",".sh",".dll",".snk"};
         foreach(string item in filesToDelete){
     	    FileUtil.deleteFile(Constants.PATH_TEMP_WORKER + assembly + item);
         }
    }


	public static int runCommandComplete(System.Diagnostics.Process proc) 
	{
		int ExitCode = -1;
		try
		{
			proc.WaitForExit();

			ExitCode = proc.ExitCode;
			proc.Close();

			if (ExitCode > 0)
			{
				string message = "Error executing command: " + proc.StartInfo.FileName + " " + proc.StartInfo.Arguments + "\n" + output_str;
				throw new Exception(message);
			}
		}
		catch (System.ComponentModel.Win32Exception w)
		{
			Console.WriteLine("Message: " + w.Message);
			Console.WriteLine("ErrorCode: " + w.ErrorCode.ToString());
			Console.WriteLine("NativeErrorCode: " + w.NativeErrorCode.ToString());
			Console.WriteLine("StackTrace: " + w.StackTrace);
			Console.WriteLine("Source: " + w.Source);
			Exception e = w.GetBaseException();
			Console.WriteLine("Base Exception Message: " + e.Message);

			throw w;
		}
		finally
		{
		}
		return ExitCode;
	}

		public static System.Diagnostics.Process runCommandStart(string cmd, string args, string userName, string password_, String curDir, Tuple<string,string>[] environment) 
	{
			int ExitCode;

			System.Security.SecureString password = null;

			if (password_ != null)
			{
				password = new System.Security.SecureString();
				foreach (char c in password_)
					password.AppendChar(c);
				password.MakeReadOnly();
			}

			output_str = "";

			System.Diagnostics.Process proc = new System.Diagnostics.Process();
			proc.EnableRaisingEvents = false;
			proc.StartInfo.CreateNoWindow = false; //true
			proc.StartInfo.UseShellExecute = false; 
			foreach (Tuple<string,string> env in environment)
				proc.StartInfo.EnvironmentVariables.Add (env.Item1,env.Item2);
			proc.StartInfo.FileName = cmd;
			proc.StartInfo.Arguments = args;
			proc.StartInfo.RedirectStandardError = false; //true;
			proc.StartInfo.RedirectStandardOutput = false; // true;
			//proc.ErrorDataReceived += new DataReceivedEventHandler(OutputHandler);
			//proc.OutputDataReceived += new DataReceivedEventHandler(OutputHandler);
			if (userName != null) proc.StartInfo.UserName = userName;
			if (password != null) proc.StartInfo.Password = password;
			if (curDir != null)
			{
				string homeDir = System.Environment.GetEnvironmentVariable("HOME");
				if (homeDir != null)
				{
					proc.StartInfo.WorkingDirectory = Path.Combine(homeDir, curDir);
				}
				else
				{
					proc.StartInfo.WorkingDirectory = curDir;
				}
			}

			Console.WriteLine(userName + " runs " + cmd + args + " on " + curDir);

			proc.Start();

			//proc.BeginErrorReadLine();
			//proc.BeginOutputReadLine();

			return proc;
	}

	public static System.Diagnostics.Process runCommand(string cmd, string args) {
        return runCommand(cmd, args, null, null, null);			
    }

	public static System.Diagnostics.Process runCommand(string cmd, string args, Tuple<string,string>[] environment) {
		return runCommand(cmd, args, null, null, null, environment);			
	}

	public static System.Diagnostics.Process runCommand(string cmd, string args, string curDir) {
		return runCommand(cmd, args, null, null, curDir);			
	}

	public static System.Diagnostics.Process runCommand(string cmd, string args, string curDir, Tuple<string,string>[] environment) {
		return runCommand(cmd, args, null, null, curDir, environment);			
	}

	public static System.Diagnostics.Process runCommand(string cmd, string args, string userName, string password_, string curDir)
	{
		return runCommand (cmd, args, userName, password_, curDir, new Tuple<string,string>[0]);
	}

	public static System.Diagnostics.Process runCommand(string cmd, string args, string userName, string password_, string curDir, Tuple<string,string>[] environment)
    {
		System.Diagnostics.Process proc = runCommandStart(cmd, args, userName, password_, curDir, environment);			
		runCommandComplete (proc);
		Console.WriteLine (output_str);
		return proc;
    }

		public static System.Diagnostics.Process runCommandStart(string cmd, string args) {
			return runCommandStart(cmd, args, null, null, null);			
		}

		public static System.Diagnostics.Process runCommandStart(string cmd, string args, Tuple<string,string>[] environment) {
			return runCommandStart(cmd, args, null, null, null, environment);			
		}

		public static System.Diagnostics.Process runCommandStart(string cmd, string args, string curDir) {
			return runCommandStart(cmd, args, null, null, curDir);			
		}

		public static System.Diagnostics.Process runCommandStart(string cmd, string args, string curDir, Tuple<string,string>[] environment) {
			return runCommandStart(cmd, args, null, null, curDir, environment);			
		}

		public static System.Diagnostics.Process runCommandStart(string cmd, string args, string userName, string password_, string curDir)
		{
			return runCommandStart (cmd, args, userName, password_, curDir, new Tuple<string,string>[0]);
		}



    private static string output_str = null;

    private static void OutputHandler(object sendingProcess, DataReceivedEventArgs outLine)
    {
        //This event handler is not called until process is finished.
        //When process is finished it gets called once for each line
        if (!String.IsNullOrEmpty(outLine.Data))
        {
            output_str += (Environment.NewLine + outLine.Data);     
        }
    }


}//CommandLineUtil

}//namespace
