using System;
using System.IO;
using System.Net;
using System.Diagnostics;
using System.Reflection;
using System.Collections.Generic;
using System.Text;

namespace DGAC.utils{

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

          runCommand(Constants.cs_compiler, " /noconfig -lib:" + Constants.UNIT_PACKAGE_PATH + "," + Constants.PATH_DGAC + " -r:DGAC.dll" + " /target:exe /out:" + Constants.PATH_BIN + moduleNameWithoutExtension + ".exe " + Constants.PATH_TEMP_WORKER + moduleNameWithoutExtension + ".cs " + mounted_references, userName, password, curDir);

          return true;      
           
  }
  
  /// <summary>
  /// Method to generate strong key file.
  /// </summary>
  /// <param name="name">The string that include de source file name, wich will be the key file name. Null means that will be used the default name.</param>
  /// <returns>bool</returns>
  public static string create_strong_key(string name, string userName, string password, string curDir){

      string nameWithoutExtension = name.Split('.')[0];

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
  public static bool compile_source(string contents, string moduleName, string[] references, 
		                            string userName, string password, String curDir){
          string moduleNameWithoutExtension = moduleName.Split('.')[0];
          
          //references

          string mounted_references = "";
          if (references != null && references.Length > 0)
              foreach (string reference in references)
              {
                  mounted_references += " -r:\"" + reference + (reference.EndsWith(".dll") ? "" : ".dll") + "\"";
              }
          Console.WriteLine(mounted_references);

          // CREATE THE FILE <moduleName>.cs in the temporary directory with <contents> as the contents:

          createFile(contents, moduleName);

          runCommand(Constants.cs_compiler, Constants.cs_compiler_flags + " -lib:" + Constants.UNIT_PACKAGE_PATH + "," + Constants.PATH_DGAC + " -r:DGAC.dll" + " /target:library /out:" + Constants.PATH_TEMP_WORKER + moduleNameWithoutExtension + ".dll /keyfile:" + Constants.PATH_TEMP_WORKER + moduleNameWithoutExtension + ".snk " + Constants.PATH_TEMP_WORKER + moduleName + mounted_references, userName, password, curDir);
          // -r:mpibasicimpl\\IMPIBasicImpl.dll 
          return true;
  }

    private static void createFile(string contents, string fileName)
    {
        // throw new Exception("The method or operation is not implemented.");
        FileUtil.writingToFile(fileName, contents);
    }
  
 
  /// <summary>
  /// Method to install an assembly from gac
  /// assemblies were saved by worker in Constants.PATH_TEMP_WORKER
  /// assemblies will be installed in <gac_dir>/HASH wich must be in MONO_PATH
  /// </summary>
  /// <param name="assembly">The assembly name</param>
  /// <returns>bool</returns>
  public static bool gacutil_install(string cuid, string assembly, int gac, string userName, string password){

      // runCommand(Constants.gac_util, "-u " + assembly);
      runCommand(Constants.gac_util, "-i " + Constants.PATH_TEMP_WORKER + assembly + ".dll" + " -package " + cuid, userName, password, null);

      
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

    public static int runCommand(string cmd, string args) {
        return runCommand(cmd, args, null, null, null);			
    }

    public static int runCommand(string cmd, string args, string userName, string password_, String curDir)
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
        proc.StartInfo.CreateNoWindow = true;
        proc.StartInfo.UseShellExecute = false;
        proc.StartInfo.FileName = cmd;
        proc.StartInfo.Arguments = args;
        proc.StartInfo.RedirectStandardError = true;
        proc.StartInfo.RedirectStandardOutput = true;
        proc.ErrorDataReceived += new DataReceivedEventHandler(OutputHandler);
        proc.OutputDataReceived += new DataReceivedEventHandler(OutputHandler);
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

        try {

          proc.Start();

          proc.BeginErrorReadLine();
          proc.BeginOutputReadLine();

          proc.WaitForExit();

          ExitCode = proc.ExitCode;
          proc.Close();

          if (ExitCode > 0)
          {
              string message = "Error executing command: " + cmd + " " + args + "\n" + output_str;
              throw new Exception(message);
          }
        } catch(System.ComponentModel.Win32Exception w) {
		Console.WriteLine(w.Message);
		Console.WriteLine(w.ErrorCode.ToString());
		Console.WriteLine(w.NativeErrorCode.ToString());
		Console.WriteLine(w.StackTrace);
		Console.WriteLine(w.Source);
		Exception e = w.GetBaseException();
		Console.WriteLine(e.Message);

                throw w;
 	} finally {
        }



        return ExitCode;

    }


    private static string output_str = null;

    private static void OutputHandler(object sendingProcess,
    DataReceivedEventArgs outLine)
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
