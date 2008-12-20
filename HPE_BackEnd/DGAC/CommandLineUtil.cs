using System;
using System.IO;
using System.Net;
using System.Diagnostics;
using System.Reflection;

namespace DGAC.utils{

public class CommandLineUtil{

    
  /// <summary>
  /// Method to run an exe
  /// </summary>
  /// <param file="path">The string that include the exe name.</param>
  /// <returns>bool</returns>
  public static bool run_exe(string file){
     
     System.Diagnostics.Process proc = new System.Diagnostics.Process();
     proc.EnableRaisingEvents=false;

     runCommand("mono ", Constants.PATH_BIN + file + ".exe");

     return true;
  }
  
  /// <summary>
  /// Method to compile a source and create an exe
  /// </summary>
  /// <param path="file">The string that include source name</param>
  /// <returns>bool</returns>
  public static bool compile_to_exe(string contents, string moduleName, string[] references){

          string moduleNameWithoutExtension = moduleName.Split('.')[0];
          
          //references
          string mounted_references = "";
          if (references != null && references.Length > 0)
              foreach (string reference in references)
                  mounted_references += " -r:" + reference + ".dll";
              
          Console.WriteLine(mounted_references);

          // CREATE THE FILE <moduleName>.cs in the temporary directory with <contents> as the contents:

          createFile(contents, moduleName);

          runCommand(Constants.cs_compiler, " /noconfig /define:DEBUG;TRACE -lib:" + Constants.UNIT_PACKAGE_PATH + "," + Constants.PATH_DGAC + " -r:DGAC.dll" + " /target:exe /out:" + Constants.PATH_BIN + moduleNameWithoutExtension + ".exe " + Constants.PATH_TEMP_WORKER + moduleNameWithoutExtension + ".cs " + mounted_references);

          return true;      
           
  }
  
  /// <summary>
  /// Method to generate strong key file.
  /// </summary>
  /// <param name="name">The string that include de source file name, wich will be the key file name. Null means that will be used the default name.</param>
  /// <returns>bool</returns>
  public static string create_strong_key(string name){

      string nameWithoutExtension = name.Split('.')[0];

      runCommand(Constants.key_generator, "-k " + Constants.PATH_TEMP_WORKER + nameWithoutExtension + ".snk");

      FileStream f = File.Open(Constants.PATH_TEMP_WORKER + nameWithoutExtension + ".snk",FileMode.Open);

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
  public static bool compile_source(string contents, string moduleName, string[] references){
          string moduleNameWithoutExtension = moduleName.Split('.')[0];
          

          //references

          string mounted_references = "";
          if (references != null && references.Length > 0)
              foreach (string reference in references)
              {
                  mounted_references += " -r:" + reference + ".dll";
              }
          Console.WriteLine(mounted_references);

          // CREATE THE FILE <moduleName>.cs in the temporary directory with <contents> as the contents:

          createFile(contents, moduleName);

          runCommand(Constants.cs_compiler, "-r:mpibasicimpl\\IMPIBasicImpl.dll /noconfig /define:DEBUG;TRACE /debug+ /debug:full /optimize- -lib:" + Constants.UNIT_PACKAGE_PATH + "," + Constants.PATH_DGAC + " -r:DGAC.dll" + " /target:library /out:" + Constants.PATH_TEMP_WORKER + moduleNameWithoutExtension + ".dll /keyfile:" + Constants.PATH_TEMP_WORKER + moduleNameWithoutExtension + ".snk " + Constants.PATH_TEMP_WORKER + moduleName + mounted_references + " -r:MPI.NET" + Path.DirectorySeparatorChar + "MPI.dll");
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
  public static bool gacutil_install(string cuid, string assembly, int gac){

      runCommand(Constants.gac_util, "-u " + assembly);
      runCommand(Constants.gac_util, "-i " + Constants.PATH_TEMP_WORKER + assembly + ".dll" + " -package " + cuid);

      
      return true;
  }
  
  /// <summary>
  /// Method to unninstal an assembly from gac
  /// </summary>
  /// <param name="assemblyPath">The assembly path</param>
  /// <returns>bool</returns>
  public static bool gacutil_uninstall(string assembly){

      runCommand(Constants.gac_util, "-u " + assembly);

      return true;
  }

    public static void clean(string assembly){
	    //cleaning temp files
         string[] filesToDelete = new string[]{".cs",".sh",".dll",".snk"};
         foreach(string item in filesToDelete){
     	    FileUtil.deleteFile(Constants.PATH_TEMP_WORKER + assembly + item);
         }
    }

    public static int runCommand(string cmd, string args)
    {

        int ExitCode;

        System.Diagnostics.Process proc = new System.Diagnostics.Process();
        proc.EnableRaisingEvents = false;
        proc.StartInfo.CreateNoWindow = true;
        proc.StartInfo.WorkingDirectory = Constants.PATH_TEMP_WORKER;
        proc.StartInfo.UseShellExecute = false;
        proc.StartInfo.FileName = cmd;
        proc.StartInfo.Arguments = args;

        Console.WriteLine(cmd + args);

        proc.Start();
        proc.WaitForExit();
        ExitCode = proc.ExitCode;
        proc.Close();

        if (ExitCode > 0)
        {
            Console.WriteLine("Error executing command: " + cmd + " " + args);
            throw new Exception("Error executing command: " + cmd + " " + args);
        }

        return ExitCode;

    }


}//CommandLineUtil

}//namespace
