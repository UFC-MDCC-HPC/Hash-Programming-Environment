package hPE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class HPEProperties {

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
	    	
	    	    defaultValues.put("backend_locations", homeDir + "BackEndLocations.xml");
	    	    defaultValues.put("references_location", homeDir + "extenalreferences.xml");
	    	    defaultValues.put("core_locations", homeDir + "CoreLocations.xml");
	    	    defaultValues.put("dgac_path", homeDir + "DGAC.dll");
	    	    defaultValues.put("sn_path", "sn");
	    	    defaultValues.put("gacutil_path", "gacutil");
	    	    defaultValues.put("cache_root", homeDir + "hpe_cache");
	    	    defaultValues.put("mono_path", null);
	    	    defaultValues.put("mono_lib_version", "1.0");	    	 
	    	    defaultValues.put("local_location", "http://localhost:8081/HPE_Location/HPE_Location_Server.jws");	    	 	            props = new Properties(); 	            
	    	    defaultValues.put("compiler_flag_unsafe","false");
	    	    defaultValues.put("compiler_flag_optimize","true");
	    	    defaultValues.put("compiler_flag_debug","true");

	    	    checkPropertiesFileUpdate();
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

	    
	    public List<File> getKindsPaths() throws IOException {
	    	List<File> kindsJarFiles = new ArrayList<File>();
	    	String kindsJarPaths = getValue("kinds_jars");
	    	if (kindsJarPaths != null && !kindsJarPaths.isEmpty()) {
		    	String[] arrayKindsJarPaths = kindsJarPaths.split(",");
		    	for (int i = 0; i < arrayKindsJarPaths.length; i++) {
		    		File file = new File(arrayKindsJarPaths[i]);
		    		if (file.exists()) {
		    			kindsJarFiles.add(file);
		    		} else {
		    			throw new FileNotFoundException("File or path not found: " + file.getAbsolutePath());
		    		}
		    	}
	    	}
	    	return kindsJarFiles;
	    }
}
