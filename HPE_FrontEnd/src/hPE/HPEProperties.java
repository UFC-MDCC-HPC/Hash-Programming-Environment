package hPE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HPEProperties {

	    private Properties props;  
	    private static final String propertiesFile = "hpe.frontend.properties";  
		public static final String curDir =System.getProperty("user.dir")+File.separatorChar;
	  
	    static private HPEProperties eInstance = null;
	    
	    static public HPEProperties getInstance() {
	    	if (eInstance == null) {
	    		eInstance = new HPEProperties();
	    	}
	    	return eInstance;
	    }
	    
	    protected HPEProperties(){  
	            props = new Properties();  
	            try{  
	                    props.load(new FileInputStream(getPropertiesFile()));  
	            }  
	            catch(IOException e){e.printStackTrace();}  
	    }  
	  
	    public String getValue(String key){  
	            return (String)props.getProperty(key);  
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
        			s = curDir + propertiesFile;
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
