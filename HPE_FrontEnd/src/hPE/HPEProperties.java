package hPE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.Path;

public class HPEProperties {

	    public static final String PLATFORM_LINUX_LOCAL = "Linux-local";
		public static final String PLATFORM_LINUX_SYSTEM = "Linux-system";
		public static final String PLATFORM_WIN64_32 = "Win64-32";
		public static final String PLATFORM_WIN64_64 = "Win64-64";
		public static final String PLATFORM_WIN32 = "Win32";
		public static final String COMPILER_FLAG_DEBUG = "compiler_flag_debug";
		public static final String COMPILER_FLAG_OPTIMIZE = "compiler_flag_optimize";
		public static final String COMPILER_FLAG_UNSAFE = "compiler_flag_unsafe";
		public static final String LOCAL_LOCATION = "local_location";
		public static final String MONO_LIB_VERSION = "mono_lib_version";
		public static final String CACHE_ROOT = "cache_root";
		public static final String CORE_LOCATIONS = "core_locations";
		public static final String REFERENCES_LOCATION = "references_location";
		public static final String BACKEND_LOCATIONS = "backend_locations";
		public static final String GACUTIL_PATH = "gacutil_path";
		public static final String DGAC_PATH = "dgac_path";
		public static final String SN_PATH = "sn_path";
		public static final String MONO_PATH = "mono_path";
		public static final String MONO_VERSION = "mono_version";
		public static final String PLATFORM_SO = "platform_so";
		
		private Properties props;  
	    private static final String propertiesFile = "hpe.frontend.properties";  
		public static final String homeDir =System.getProperty("user.home") + File.separatorChar;
	    private Map<String, String> defaultValues = new HashMap<String,String>(); 
		
	    static private HPEProperties eInstance = null;
	    
	    static public HPEProperties getInstance() {
	    	if (eInstance == null) {
	    		eInstance = new HPEProperties();
	    	}
	    	return eInstance;
	    }
	    
	    protected HPEProperties(){
	    	
	    	    defaultValues.put(HPEProperties.BACKEND_LOCATIONS, homeDir + "BackEndLocations.xml");
	    	    defaultValues.put(HPEProperties.REFERENCES_LOCATION, homeDir + "extenalreferences.xml");
	    	    defaultValues.put(HPEProperties.CORE_LOCATIONS, homeDir + "CoreLocations.xml");
	    	    defaultValues.put(HPEProperties.DGAC_PATH, homeDir + "DGAC.dll");
	    	    defaultValues.put(HPEProperties.SN_PATH, "sn");
	    	    defaultValues.put(HPEProperties.GACUTIL_PATH, "gacutil");
	    	    defaultValues.put(HPEProperties.CACHE_ROOT, homeDir + "hpe_cache");
	    	    defaultValues.put(HPEProperties.MONO_VERSION, "2.10");
	    	    defaultValues.put(HPEProperties.MONO_PATH, buildMonoPath(defaultValues.get(HPEProperties.MONO_VERSION)));
	    	    defaultValues.put(HPEProperties.MONO_LIB_VERSION, "1.0");	    	 
	    	    defaultValues.put(HPEProperties.LOCAL_LOCATION, "http://localhost:8081/HPE_Location/HPE_Location_Server.jws");
	    	    defaultValues.put(HPEProperties.COMPILER_FLAG_UNSAFE,"false");
	    	    defaultValues.put(HPEProperties.COMPILER_FLAG_OPTIMIZE,"true");
	    	    defaultValues.put(HPEProperties.COMPILER_FLAG_DEBUG,"true");
	    	    defaultValues.put(HPEProperties.PLATFORM_SO,HPEProperties.PLATFORM_WIN32);
	    	    
	    	    props = new Properties();

	    	    checkPropertiesFileUpdate();
	    }  
	    
	    private String buildMonoPath(String version) {
			
	    	String path = "c:/Program Files (x86)/Mono-" + version + + File.separatorChar;
	    	
			return path;
		}

		private long lastUpdate = 0L;
	  
	    public String getValue(String key){  
	    	checkPropertiesFileUpdate();
	    	String s = props.getProperty(key);
	    	if (s==null) {
	    		return defaultValues.get(key);
	    	} else {
	    	    return s.trim();	
	    	}	    	
	    }  
	    
		 private void checkPropertiesFileUpdate() {
	            try{
					java.io.File propertiesFile = new java.io.File(getPropertiesFile());
					if (propertiesFile.lastModified() > lastUpdate) {
						
			              props.load(new FileInputStream(getPropertiesFile()));
			              lastUpdate = propertiesFile.lastModified();
			              
			              String platform_so = props.getProperty(HPEProperties.PLATFORM_SO);
			              String mono_version_value = props.getProperty(HPEProperties.MONO_VERSION);
			              String mono_path_value = props.getProperty(HPEProperties.MONO_PATH);
			              
			              if (mono_path_value == null && platform_so != null) 
			              {
			                 if (platform_so.equals(HPEProperties.PLATFORM_WIN32) && mono_version_value != null) {
			                	 mono_path_value = "C:\\Program Files\\Mono-" + mono_version_value + "\\";
			                     props.put(HPEProperties.MONO_PATH, mono_path_value);
			                 } else if (platform_so.equals(HPEProperties.PLATFORM_WIN64_64) && mono_version_value != null) {
			                	 mono_path_value = "C:\\Program Files\\Mono-" + mono_version_value + "\\";
			                	 props.put(HPEProperties.MONO_PATH, mono_path_value);
			                 } else if (platform_so.equals(HPEProperties.PLATFORM_WIN64_32) && mono_version_value != null) {
			                	 mono_path_value = "C:\\Program Files (x86)\\Mono-" + mono_version_value + "\\";
				                 props.put(HPEProperties.MONO_PATH, mono_path_value);
			                 } else if (platform_so.equals(HPEProperties.PLATFORM_LINUX_SYSTEM)) {
			                	 mono_path_value = Path.SEPARATOR + "usr" + Path.SEPARATOR;
					             props.put(HPEProperties.MONO_PATH, mono_path_value);
			                 } else if (platform_so.equals(HPEProperties.PLATFORM_LINUX_LOCAL)) {
			                	 mono_path_value = Path.SEPARATOR + "usr" + Path.SEPARATOR + "local" + Path.SEPARATOR;
					             props.put(HPEProperties.MONO_PATH, mono_path_value);
			                 }			                 
			              }
			              
			              String sn_path_value = props.getProperty(HPEProperties.SN_PATH);
			              if (sn_path_value == null &&  mono_path_value != null) 
			              {
			            	  props.put(HPEProperties.SN_PATH, mono_path_value + "bin" + Path.SEPARATOR + "sn.bat");
			              }
			              
			              String dgac_path_value = props.getProperty(HPEProperties.DGAC_PATH);
			              if (dgac_path_value == null &&  mono_path_value != null) 
			              {
			            	  props.put(HPEProperties.DGAC_PATH, mono_path_value + "lib" + Path.SEPARATOR + "mono" + Path.SEPARATOR + "DGAC" + Path.SEPARATOR + "DGAC.dll");
			              }
			              
			              String gacutil_path_value = props.getProperty(HPEProperties.GACUTIL_PATH);
			              if (gacutil_path_value == null &&  mono_path_value != null) 
			              {
			            	  props.put(HPEProperties.GACUTIL_PATH, mono_path_value + "bin" + Path.SEPARATOR + "gacutil.bat");
			              }
					}
		         }  
		         catch(IOException e) { 
		         	e.printStackTrace();	            	
		         }  
		}

		/*
	     * Pegando o properties
	     */
	    public static String getPropertiesFile(){
	    	 
        	String s = null;

        	s = getArgVal("--properties");
        	if (s == null) {
        		s = System.getenv("HPE_FRONTEND_PROPERTIES");
        		if (s == null) {
        			s = homeDir + propertiesFile;
        		}
        	}	        		        	
        	
            return s;                	        
	    }
	    
	    public static String[] args = {};
	    
	    public static String getArgVal(String argId)
	    {      
	        int pos = 0;
	        for (String arg : args)
	        {
	            if (arg.equals(argId))
	            {
	                if (pos <= args.length)
	                {
	                    return args[pos+1];
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
