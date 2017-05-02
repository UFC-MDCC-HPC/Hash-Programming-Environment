using System;
using System.IO;
using System.Collections.Generic;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.backend.DGAC.utils
{
    public class MPIWorkerMessagingConstants
    {
        public const int DEFAULT_TAG = 999;
        public const int CREATE_INSTANCE = 0;
    }

	public enum EnvironmentPortType { user, provider, platform_user, platform_provider};

    public class Constants
    {

        public static string PROPERTIES_FILE = getPropertiesFilePath(); 

        private static string getPropertiesFilePath()
        {
			Trace.Write("LOADING PROPERTIES FILE: ---- " + HOME_PATH);
            string properties_file_path = getArgVal("--properties");
            Console.WriteLine(properties_file_path);
            if (properties_file_path == null)
            {
               properties_file_path = Environment.GetEnvironmentVariable("BACKEND_PROPERTIES_FILE");
               if (properties_file_path == null)
                    properties_file_path = Path.Combine(HOME_PATH, "hpe.backend.properties");
            }
			Console.WriteLine(properties_file_path);
            return properties_file_path;
        }

		private static int base_binding_facet_port = -1;
		public static int BASE_BINDING_FACET_PORT { 
			get 
			{  
				if (base_binding_facet_port == -1) 
				{
					string v = Environment.GetEnvironmentVariable ("BASE_BINDING_FACET_PORT");
					base_binding_facet_port = v != null ? int.Parse (v) : 5000;
				}
				return base_binding_facet_port;
			}
		}

		private static int NEXT_FREE_BINDING_FACET_PORT = BASE_BINDING_FACET_PORT;

		public static Object binding_facet_port_lock = new Object();

		public static  int FREE_BINDING_FACET_PORT
		{
			get 
			{
				int result = 0;
				lock (binding_facet_port_lock) 
				{
					result = NEXT_FREE_BINDING_FACET_PORT ++;
				} 	
				return result;
			}
		}

		private static string home_path = null;

		public static string HOME_PATH { 
			get 
			{  
				if (home_path == null)
				    home_path = (Environment.OSVersion.Platform == PlatformID.Unix || Environment.OSVersion.Platform == PlatformID.MacOSX)
					   			   ? Environment.GetEnvironmentVariable("HOME") : Environment.ExpandEnvironmentVariables("%HOMEDRIVE%%HOMEPATH%");
			    return home_path;
            }
		}

		public static string SYSTEM_COMPONENT_PATH = "SYSTEM_COMPONENT_PATH";

		public static string DIRECTORY_NAME_BINDING_WEB_SERVICES;

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

		public static string IP_ADDRESS_BINDING_ROOT = FileUtil.readConstant ("ip_address_binding_root","0.0.0.0");
		public static string SITE_NAME = FileUtil.readConstant("site_name", "unnamed");
		public static string SITE_URL = FileUtil.readConstant("site_url");
        public static string PATH_TEMP_WORKER = FileUtil.readConstant("path_temp_worker");
        public static string PATH_DGAC = FileUtil.readConstant("path_dgac");
        public static string UNIT_PACKAGE_PATH = FileUtil.readConstant("unit_package_path"); // HASH_UNIT_PACKAGE";
        public static string PATH_BIN = FileUtil.readConstant("path_bin");
        public static string cs_compiler = FileUtil.readConstant("cs_compiler","dmcs"); // "mcs"
        public static string cs_compiler_flags = FileUtil.readConstant("cs_compiler_flags"); // "mcs"
        public static string cli_runtime = FileUtil.readConstant("cli_runtime"); // "mono"
        public static string key_generator = FileUtil.readConstant("key_generator");
        public static string gac_util = FileUtil.readConstant("gac_util");
        public static string mpi_run = FileUtil.readConstant("mpi_run");
        public static string mpi_run_flags = FileUtil.readConstant("mpi_run_flags");
        public static string connectionString = FileUtil.readConstant("connection_string");
        public static string externalRefsFile = FileUtil.readConstant("external_references_file");

		public static string HOSTS_FILE 
		{ 							    
			get 
			{
				string path_hosts_file = Environment.GetEnvironmentVariable ("PATH_HOSTS_FILE");
				Console.WriteLine ("PATH_HOSTS_FILE is null ? " + (path_hosts_file == null));
				if (path_hosts_file == null)
					path_hosts_file = FileUtil.readConstant("hosts_file", Path.Combine(HOME_PATH, "hpe_nodes"));
				Console.WriteLine ("PATH_HOSTS_FILE is " + path_hosts_file);
				return path_hosts_file;
			}
		}

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

		public const string FACET_IP_ADDRESS = "facet_ip_address";
		public const string FACET_PORT = "facet_ip_port";
		public static string FACET_INSTANCE = "facet_instance";
		public static string ENCLOSING_FACET_INSTANCE = "enclosing_facet_instance";
		public static string FACET = "facet";
		public static string ENCLOSING_FACET = "enclosing_facet";
		public static string FACET_TOPOLOGY = "facet_topology";
		public static string BINDING_SEQUENTIAL = "binding_sequential";
		public static string IGNORE = "ignore";

        public static string INITIALIZE_PORT_NAME = "initialize_port";
        public static string INITIALIZE_PORT_TYPE = "br.ufc.pargo.hpe.ports.AutomaticSlicesPort";
        public static string RECONFIGURE_PORT_NAME = "reconfigure_port";
        public static string RECONFIGURE_PORT_TYPE = "br.ufc.pargo.hpe.ports.ReconfigurationAdvicePort";
        public const string GO_PORT_TYPE = "gov.cca.ports.GoPort";
        public const string GO_PORT_NAME = "go";
        public const string PARAMETER_PORT_TYPE = "gov.cca.ports.ParameterPort";
        public const string PARAMETER_PORT_NAME = "parameter";


		public const string LIFECYCLE_INSTANTIATE = "instantiate";
		public const string LIFECYCLE_DEPLOY = "deploy";
		public const string LIFECYCLE_RESOLVE = "resolve";
		public const string LIFECYCLE_CERTIFY = "certify";

		public const int KIND_UNRECOGNIZED = -1;
		public const int KIND_APPLICATION = 0;
		public const int KIND_COMPUTATION = 1;
		public const int KIND_SYNCHRONIZER = 2;
		public const int KIND_ENVIRONMENT = 3;
		public const int KIND_PLATFORM = 4;
		public const int KIND_QUALIFIER = 5;
		public const int KIND_DATASTRUCTURE = 6;
		public const int KIND_BINDING = 7;
		public const int KIND_SYSTEM = 8;
		public const int KIND_CERTIFIER = 9;
		public const int KIND_TACTICAL = 10;

		public const string KIND_APPLICATION_NAME = "Application";
        public const string KIND_COMPUTATION_NAME = "Computation";
        public const string KIND_SYNCHRONIZER_NAME = "Synchronizer";
        public const string KIND_ENVIRONMENT_NAME = "Environment";
        public const string KIND_PLATFORM_NAME      = "Platform";
        public const string KIND_QUALIFIER_NAME = "Qualifier";
        public const string KIND_DATASTRUCTURE_NAME = "Data";
        public const string KIND_TOPOLOGY_NAME = "Topology";
		public const string KIND_BINDING_NAME = "Binding";
		public const string KIND_SYSTEM_NAME = "System";
		public const string KIND_CERTIFIER_NAME = "Certifier";
		public const string KIND_TACTICAL_NAME = "Tactical";

		public static IDictionary<VarianceType, string> varianceValue = new Dictionary<VarianceType, string>()
		{
			{VarianceType.invariant, "invariant"},
			{VarianceType.covariant, "covariant"},
			{VarianceType.contravariant, "contravariant"}
		};

		public static IDictionary<string, VarianceType> varianceValueInv = new Dictionary<string, VarianceType>()
		{
			{"invariant", VarianceType.invariant},
			{"covariant", VarianceType.covariant},
			{"contravariant", VarianceType.contravariant}
		};


		public static IDictionary<EnvironmentPortType, string> envUnitName = new Dictionary<EnvironmentPortType, string>()
		{
			{EnvironmentPortType.user,"client"},
			{EnvironmentPortType.provider, "server"},
			{EnvironmentPortType.platform_user, "node"},
			{EnvironmentPortType.platform_provider, "node"}
		};

		public static string tskUnitName = "peer";

		public static IDictionary<EnvironmentPortType, string> envInterfaceName = new Dictionary<EnvironmentPortType, string>()
		{
			{EnvironmentPortType.user,"IClient"},
			{EnvironmentPortType.provider, "IServer"},
			{EnvironmentPortType.platform_provider, "IProcessingNode"},
			{EnvironmentPortType.platform_user, "IProcessingNode"}
		};

        public static Dictionary<string, int> kindMapping = new Dictionary<string, int>()
        {
			{KIND_APPLICATION_NAME, Constants.KIND_APPLICATION},
			{KIND_PLATFORM_NAME, Constants.KIND_PLATFORM},
			{KIND_COMPUTATION_NAME, Constants.KIND_COMPUTATION},
			{KIND_DATASTRUCTURE_NAME,Constants.KIND_DATASTRUCTURE},
			{KIND_ENVIRONMENT_NAME,Constants.KIND_ENVIRONMENT},
			{KIND_QUALIFIER_NAME,Constants.KIND_QUALIFIER},
			{KIND_SYNCHRONIZER_NAME, Constants.KIND_SYNCHRONIZER},
			{KIND_BINDING_NAME, Constants.KIND_BINDING},
			//{KIND_TOPOLOGY_NAME, Constants.KIND_TOPOLOGY},
			{KIND_SYSTEM_NAME, Constants.KIND_SYSTEM},
			{KIND_CERTIFIER_NAME, Constants.KIND_CERTIFIER},
			{KIND_TACTICAL_NAME, Constants.KIND_TACTICAL}
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
