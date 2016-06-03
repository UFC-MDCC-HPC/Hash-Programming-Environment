using System;
using System.Web;
using System.Web.Services;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.IO;
using System.Threading;
using System.Collections.Generic;
using System.Diagnostics;

namespace BackEndService
{
	/* In the BackEnd server, the maintainer must do:
	 * 1) set the environment variable HPE_NEXT_FREE_WORKER_PORT
	 * 2) set the environment variable HPE_NEXT_FREE_PLATFORM_SERVICE_PORT
	 * 3) set the environment variable HPE_PLATFORM_ACCESS
	 * 4) copy the WorkerService.exe executable to $HOME/hpe_work/worker/bin
	 * 5) copy the platform service to $HOME/hpe_work/worker 
	 */

	public class BackEnd : System.Web.Services.WebService
	{
		[WebMethod]
		public int howManyRunningPlatforms()
		{
			Debug.Assert (proc_w.Count == proc_p.Count);
			return proc_w.Count;
		}

		[WebMethod]
		public int killPlatform (int killed)
		{
			Debug.Assert (proc_w.Count == proc_p.Count);
			if (killed < proc_p.Count) 
			{
				System.Diagnostics.Process pp = proc_p [killed];
				System.Diagnostics.Process pw = proc_w [killed];

				proc_p.RemoveAt (killed);
				proc_w.RemoveAt (killed);

				pw.Kill();
				pp.Kill();
			}

			return howManyRunningPlatforms ();
		}

		[WebMethod]
		public string deploy(string[] platform_config)
		{
			Console.WriteLine (platform_config[0]);
			Console.WriteLine (platform_config[1]);

			int nodes = int.Parse(platform_config [1]);

			// The next free communication port of a worker (it begins with 4865).
			int port_worker_base = int.Parse(Environment.GetEnvironmentVariable ("HPE_NEXT_FREE_WORKER_PORT")); 

			// The next free communication port of a platform service (it begins witn 8081).
			int port_platform = int.Parse(Environment.GetEnvironmentVariable ("HPE_NEXT_FREE_PLATFORM_SERVICE_PORT")); 

			// The url of the platform (e.g. http://castanhao.lia.ufc.br).
			string platform_address = Environment.GetEnvironmentVariable("HPE_PLATFORM_ACCESS");

			string path_worker = Environment.GetEnvironmentVariable("HPE_PATH_WORKER");
			string path_platform_service = Environment.GetEnvironmentVariable("HPE_PATH_PLATFORM_SERVICE");

			string[] contents_configfile = new string[nodes];
			for (int i = 0; i < contents_configfile.Length; i++) 
				contents_configfile[i] = "-n 1 /usr/bin/mono-service -l:Worker" + (port_worker_base + i) + ".lock bin/WorkerService.exe --port " + (port_worker_base + i) + " --debug --no-deamon";

			string configfile_name = Path.GetTempFileName ();
			File.WriteAllLines (configfile_name, contents_configfile);

			Tuple<string,string>[] environment_w = new Tuple<string, string>[0];

			Tuple<string,string>[] environment_p = new Tuple<string, string>[2];
			string[] contents_nodesfile = new string[nodes];
			for (int i = 0; i < contents_nodesfile.Length; i++) 
				contents_nodesfile[i] = platform_address + " " + (port_worker_base + i);

			string nodesfile_name = Path.GetTempFileName ();
			File.WriteAllLines (nodesfile_name, contents_nodesfile);
			environment_p [0] = new Tuple<string, string> ("PATH_HOSTS_FILE", nodesfile_name);
			environment_p [1] = new Tuple<string, string> ("BASE_BINDING_FACET_PORT", "5000");

			Thread tw = new Thread (launchWorker);
			Thread tp = new Thread (launchPlatformService);

			tw.Start (new Tuple<string,string,Tuple<string,string>[]> (path_worker, configfile_name, environment_w));
			tp.Start (new Tuple<string,int,Tuple<string,string>[]> (path_platform_service, port_platform, environment_p));

			Environment.SetEnvironmentVariable ("HPE_NEXT_FREE_WORKER_PORT", (port_worker_base + nodes).ToString());
			Environment.SetEnvironmentVariable ("HPE_NEXT_FREE_PLATFORM_SERVICE_PORT", (port_platform + 1).ToString());

			return "http://" + platform_address + ":" + port_platform + "/Platform.asmx";
		}

		private static IList<System.Diagnostics.Process> proc_w = new List<System.Diagnostics.Process> ();
		private static IList<System.Diagnostics.Process> proc_p = new List<System.Diagnostics.Process> ();

     	private void launchWorker(object config_)
		{
			Tuple<string,string,Tuple<string,string>[]> config = (Tuple<string,string,Tuple<string,string>[]>)config_;
			string path_worker = config.Item1;
			string filename = config.Item2;
			Tuple<string,string>[] environment = config.Item3;
			var proc = CommandLineUtil.runCommandStart ("/usr/bin/mpirun", "--configfile " + filename, path_worker, environment);
			proc_w.Add (proc);

			try
			{
				CommandLineUtil.runCommandComplete (proc);
			}
			catch(Exception e)
			{
				Trace.WriteLine ("EXCEPTION: " + e.Message);
				Trace.WriteLine ("INNER EXCEPTION: " + e.InnerException.Message);
			}
			finally 
			{
				proc_w.Remove (proc);
			}
		}

		private void launchPlatformService(object config_)
		{
			Tuple<string,int,Tuple<string,string>[]> config = (Tuple<string,int,Tuple<string,string>[]>)config_;
			string path_platform_service = config.Item1;
			int port_platform = config.Item2;
			Tuple<string,string>[] environment = config.Item3;
			var proc = CommandLineUtil.runCommandStart ("/usr/bin/xsp4", "--nonstop --port " + port_platform, path_platform_service, environment);
			proc_p.Add (proc);

			try
			{
				CommandLineUtil.runCommandComplete (proc);
			}
			catch(Exception e)
			{
				Trace.WriteLine ("EXCEPTION: " + e.Message);
				Trace.WriteLine ("INNER EXCEPTION: " + e.InnerException.Message);
			}
			finally 
			{
				proc_p.Remove (proc);
			}
		}
	}
}

