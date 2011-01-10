using System;
using System.IO;
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.backend.DGAC.utils
{
    public class MPIWorkerMessagingConstants
    {
        public const int DEFAULT_TAG = 999;
        public const int CREATE_INSTANCE = 0;
    }

    public class Constants
    {


        public static string PROPERTIES_FILE = getPropertiesFilePath(); // "h:\\temp\\hpe.backend.properties";

        private static string getPropertiesFilePath()
        {
            string properties_file_path = getArgVal("--properties");
            Console.WriteLine(properties_file_path);
            if (properties_file_path == null)
            {
                properties_file_path = Environment.GetEnvironmentVariable("BACKEND_PROPERTIES_FILE");
               if (properties_file_path == null)
                {
                    string homePath = (Environment.OSVersion.Platform == PlatformID.Unix ||
                                       Environment.OSVersion.Platform == PlatformID.MacOSX)
                                          ? Environment.GetEnvironmentVariable("HOME")
                                          : Environment.ExpandEnvironmentVariables("%HOMEDRIVE%%HOMEPATH%");

                    properties_file_path = Path.Combine(homePath, "hpe.backend.properties");
                }
            }
            return properties_file_path;
        }
        public static int WORKER_PORT = 4865;
        public static string WORKER_SERVICE_NAME = "WorkerService";
        public static string MANAGER_PORT_NAME = "ManagerHost";
        public const int DLL_OUT = 0;
        public const int EXE_OUT = 1;
        public static string PATH_TEMP_WORKER = FileUtil.readConstant("path_temp_worker");
        public static string PATH_DGAC = FileUtil.readConstant("path_dgac");
        // public static string PATH_MONO_BIN = FileUtil.readConstant("path_dgac");
        public static string UNIT_PACKAGE_PATH = FileUtil.readConstant("unit_package_path"); // HASH_UNIT_PACKAGE";
        public static string PATH_BIN = FileUtil.readConstant("path_bin");
        public static string SERVICE_NAME = FileUtil.readConstant("service_name");

        public static string cs_compiler = FileUtil.readConstant("cs_compiler"); // "mcs"
        public static string cs_compiler_flags = FileUtil.readConstant("cs_compiler_flags"); // "mcs"
        public static string cli_runtime = FileUtil.readConstant("cli_runtime"); // "mono"
        public static string key_generator = FileUtil.readConstant("key_generator");
        public static string gac_util = FileUtil.readConstant("gac_util");
        public static string mpi_run = FileUtil.readConstant("mpi_run");
        public static string mpi_run_flags = FileUtil.readConstant("mpi_run_flags");
        public static string hosts_file = FileUtil.readConstant("hosts_file", Path.DirectorySeparatorChar + "etc" + Path.DirectorySeparatorChar + "hpe_nodes");
        public static string connectionString = FileUtil.readConstant("connection_string");
        public static string externalRefsFile = FileUtil.readConstant("external_references_file");

        public static string ENUMS_KEY = "enumerator";
        public static string NODES_KEY = "nodes";
        public static string KEY_KEY = "key";      
        public static string UID_KEY = "uid";
        public static string SESSION_KEY = "session";
        //public static string ASSEMBLY_STRING_KEY = "assembly_string";
        public static string COMPONENT_KEY = "id_concrete";
        //public static string ID_ABSTRACT_KEY = "id_abstract";
        //public static string ID_INNER_KEY = "id_inner";
        public static string UNIT_KEY = "id_interface";
       // public static string KIND_KEY = "kind";

        public static string DEFAULT_PROVIDE_PORT_IMPLEMENTS = "implements";

        public const int KIND_UNRECOGNIZED = -1;
        public const int KIND_APPLICATION   = 0;
        public const int KIND_COMPUTATION = 1;
        public const int KIND_SYNCHRONIZER = 2;
        public const int KIND_ENVIRONMENT = 3;
        public const int KIND_PLATFORM      = 4;
        public const int KIND_ENUMERATOR    = 5;
        public const int KIND_QUALIFIER = 6;
        public const int KIND_SERVICE = 7;
        public const int KIND_DATASTRUCTURE = 8;

        public static Dictionary<string, int> kindMapping = new Dictionary<string, int>()
        {
            {"Application", Constants.KIND_APPLICATION},
            {"Architecture", Constants.KIND_PLATFORM},
            {"Computation", Constants.KIND_COMPUTATION},
            {"Data",Constants.KIND_DATASTRUCTURE},
            {"Enumerator",Constants.KIND_ENUMERATOR},
            {"Environment",Constants.KIND_ENVIRONMENT},
            {"Qualifier",Constants.KIND_QUALIFIER},
            {"Synchronizer", Constants.KIND_SYNCHRONIZER}
        };

        public static string getArgVal(string argId)
        {
            string[] args = Environment.GetCommandLineArgs();
            int pos = 0;
            foreach (string arg in args)
            {
                if (arg.Equals(argId))
                {
                    if (pos <= args.Length)
                    {
                        return args[pos + 1];
                    }
                    else
                    {
                        return null;
                    }
                }
                pos++;
            }
            return null;
        }


    }

}
