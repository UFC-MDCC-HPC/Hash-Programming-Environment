package hPE.ui.preferences;

/**
 * Constant definitions for plug-in preferences
 * 
 * @author Juliano Efson Sales
 */
public class PreferenceConstants {

	/*
	 * TODO temporariamente vamos utilizar um campo para indicar o XML contendo
	 * as referencias (EXTERNAL_REFERENCES_XML). num segundo momento, essas dll
	 * ser�o atribuidas diretamente ao projeto HPE em aba espec�fica.
	 * 
	 * De forma semelhante, as propriedades COMPILER* devem ser avaliadas para
	 * saber qual o melhor local de sua localiza��o.
	 * 
	 * LOCAL_LOCATION existe apenas tempor�riamente para fazer funcionar com uma
	 * refatoracao menor.
	 */

	public static final String HPE_HOME = "hpe_home";
	public static final String MONO_BIN_PATH = "mono_bin_path";	
	public static final String EXTERNAL_REFERENCES_XML = "x-references";
	public static final String BACKEND_LOCATIONS_XML = "backend_locations";

	public static final String CACHE_PATH = "cache_path";
	public static final String LIB_PATH = "lib_path";
	public static final String GACUTIL_PATH = "gacutil";
	public static final String SN_PATH = "sn";

	static final String HPE_HOME_D = "HPE Home Path: ";
	static final String MONO_BIN_PATH_D = "MONO Bin Path: ";
	static final String EXTERNAL_REFERENCES_XML_D = "External References XML: ";
	static final String BACKEND_LOCATIONS_XML_D = "BackEnd Locations XML: ";

	// TEMPORARIOS
	public static final String COMPILER_FLAG_DEBUG = "compiler_flag_debug";
	public static final String COMPILER_FLAG_OPTIMIZE = "compiler_flag_optimize";
	public static final String COMPILER_FLAG_UNSAFE = "compiler_flag_unsafe";
	public static final String LOCAL_LOCATION = "local-location";

	public static final String MACOS = "mac";
	public static final String WIN = "win";
	public static final String UNIX = "unix";
}