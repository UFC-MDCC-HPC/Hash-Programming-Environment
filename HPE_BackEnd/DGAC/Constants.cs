using System;

namespace DGAC.utils{

public class Constants {

    public const string PROPERTIES_FILE = "h:\\temp\\hpe.backend.properties.xml";

    public const int DLL_OUT = 0;
    public const int EXE_OUT = 1;
    public static string PATH_TEMP_WORKER = FileUtil.readConstant("path_temp_worker");
    public static string PATH_DGAC = FileUtil.readConstant("path_dgac");
    // public static string PATH_MONO_BIN = FileUtil.readConstant("path_dgac");
    public static string UNIT_PACKAGE_PATH = FileUtil.readConstant("unit_package_path"); // HASH_UNIT_PACKAGE";
    public static string PATH_BIN = FileUtil.readConstant("path_bin");
    public static string SERVICE_NAME = FileUtil.readConstant("service_name");

    public static string cs_compiler = FileUtil.readConstant("cs_compiler"); // "mcs"
    public static string cli_runtime = FileUtil.readConstant("cli_runtime"); // "mono"
    public static string key_generator = FileUtil.readConstant("key_generator");
    public static string gac_util = FileUtil.readConstant("gac_util");
    public static string mpi_run = FileUtil.readConstant("mpi_run");

    /*
    public const string PATH_TEMP_WORKER = "h:\\temp\\";
    public const string PATH_DGAC = "\"C:\\Program Files\\Mono-2.0.1\\lib\\mono\\DGAC\"";
    public const string PATH_MONO_BIN = "\"C:\\Program Files\\Mono-2.0.1\\bin\\\"";
    public const string UNIT_PACKAGE_PATH = "\"C:\\Program Files\\Mono-2.0.1\\lib\\mono\""; // HASH_UNIT_PACKAGE";
    public const string PATH_BIN = "h:\\temp\\";
    public const string SERVICE_NAME = "worker.rem";
    public const string PROPERTIES_FILE = "h:\\temp\\properties.xml";

    public const string cs_compiler = "\"C:\\Program Files\\Mono-2.0.1\\bin\\gmcs.bat\""; // "mcs"
    public const string key_generator = "sn";
    public const string gac_util = "\"C:\\Program Files\\Mono-2.0.1\\bin\\gacutil.bat\"";
    */
}

}
