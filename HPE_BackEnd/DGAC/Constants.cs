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
			Console.Write("LOADING PROPERTIES FILE: ");
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
			Console.WriteLine(properties_file_path);
            return properties_file_path;
        }
        public static int WORKER_PORT = 4865;
        public static int MANAGER_PORT = 4864;
        public static string WORKER_SERVICE_NAME = "WorkerService";
        public static string MANAGER_SERVICE_NAME = "ManagerService";
		public const string BUILDER_SERVICE_PORT_NAME = "builder_service";
		public const string BUILDER_SERVICE_PORT_TYPE = "gov.cca.BuilderService";
		public const string REGISTRY_PORT_NAME = "registry";
		public const string REGISTRY_PORT_TYPE = "gov.cca.ports.ServiceRegistry";
        public static string MANAGER_PORT_NAME = "ManagerHost";
        public const int DLL_OUT = 0;
        public const int EXE_OUT = 1;

		public static string SITE_NAME = FileUtil.readConstant("site_name", "unnamed");
		public static string SITE_URL = FileUtil.readConstant("site_url");
        public static string PATH_TEMP_WORKER = FileUtil.readConstant("path_temp_worker");
        public static string PATH_DGAC = FileUtil.readConstant("path_dgac");
        // public static string PATH_MONO_BIN = FileUtil.readConstant("path_dgac");
        public static string UNIT_PACKAGE_PATH = FileUtil.readConstant("unit_package_path"); // HASH_UNIT_PACKAGE";
        public static string PATH_BIN = FileUtil.readConstant("path_bin");
 //       public static string SERVICE_NAME = FileUtil.readConstant("service_name");
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

        public const string ENUMS_KEY = "enumerator";
        public const string NODES_KEY = "nodes";
        public const string KEY_KEY = "key";      
        public const string UID_KEY = "uid";
        public const string SESSION_KEY = "session";
        //public static string ASSEMBLY_STRING_KEY = "assembly_string";
        public const string COMPONENT_KEY = "id_concrete";
        public const string ID_FUNCTOR_APP = "id_functor_app";
        //public static string ID_ABSTRACT_KEY = "id_abstract";
        //public static string ID_INNER_KEY = "id_inner";
        public const string UNIT_KEY = "id_interface";
        public const string PORT_NAME = "port_name";
        public const string ENCLOSING_ARGUMENTS = "arguments";
		public const string ASSEMBLY_STRING_KEY = "assembly_string";
		public const string PORT_NAMES_KEY = "port_name";
	//	public const string CLASS_NAME_KEY = "class_name";
        public static string KIND_KEY = "kind";
        public static string PARTITION_INDEX_KEY = "partition_index";

        public const string DEFAULT_PROVIDES_PORT_IMPLEMENTS = "implements";
        //public const string DEFAULT_CREATESLICES_PORT_IMPLEMENTS = "create_slices";
        public const string DEFAULT_PROVIDES_PORT_SERVICE = "service_client";
        public const string DEFAULT_USES_PORT_SERVICE = "service_server";

        public static string INITIALIZE_PORT_NAME = "initialize_port";
        public static string INITIALIZE_PORT_TYPE = "br.ufc.pargo.hpe.ports.AutomaticSlicesPort";
        public static string RECONFIGURE_PORT_NAME = "recnfigure_port";
        public static string RECONFIGURE_PORT_TYPE = "br.ufc.pargo.hpe.ports.ReconfigurationAdvicePort";
        public const string GO_PORT_TYPE = "gov.cca.ports.GoPort";
        public const string GO_PORT_NAME = "go";
        public const string PARAMETER_PORT_TYPE = "gov.cca.ports.ParameterPort";
        public const string PARAMETER_PORT_NAME = "parameter";

        public const int KIND_UNRECOGNIZED = -1;
        public const int KIND_APPLICATION = 0;
        public const int KIND_COMPUTATION = 1;
        public const int KIND_SYNCHRONIZER = 2;
        public const int KIND_ENVIRONMENT = 3;
        public const int KIND_PLATFORM = 4;
        public const int KIND_ENUMERATOR = 5;
        public const int KIND_QUALIFIER = 6;
        public const int KIND_SERVICE = 7;
        public const int KIND_DATASTRUCTURE = 8;
        public const int KIND_TOPOLOGY = 8;
		
		public const string KIND_APPLICATION_NAME = "Application";
        public const string KIND_COMPUTATION_NAME = "Computation";
        public const string KIND_SYNCHRONIZER_NAME = "Synchronizer";
        public const string KIND_ENVIRONMENT_NAME = "Environment";
        public const string KIND_PLATFORM_NAME      = "Platform";
        public const string KIND_ENUMERATOR_NAME    = "Enumerator";
        public const string KIND_QUALIFIER_NAME = "Qualifier";
        public const string KIND_SERVICE_NAME = "Service";
        public const string KIND_DATASTRUCTURE_NAME = "Data";
        public const string KIND_TOPOLOGY_NAME = "Topology";

        public static Dictionary<string, int> kindMapping = new Dictionary<string, int>()
        {
            {"Application", Constants.KIND_APPLICATION},
            {"Platform", Constants.KIND_PLATFORM},
            {"Computation", Constants.KIND_COMPUTATION},
            {"Data",Constants.KIND_DATASTRUCTURE},
            {"Enumerator",Constants.KIND_ENUMERATOR},
            {"Environment",Constants.KIND_ENVIRONMENT},
            {"Qualifier",Constants.KIND_QUALIFIER},
            {"Synchronizer", Constants.KIND_SYNCHRONIZER},
            {"Service", Constants.KIND_SERVICE},
            {"Topology", Constants.KIND_TOPOLOGY}
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
