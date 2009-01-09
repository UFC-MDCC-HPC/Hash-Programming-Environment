package hPE;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HPEProperties {

	    private Properties props;  
	    private String propertiesFile = "hpe.frontend.properties";  
	  
	    static private HPEProperties eInstance = null;
	    
	    static public HPEProperties getInstance() {
	    	if (eInstance == null) {
	    		eInstance = new HPEProperties();
	    	}
	    	return eInstance;
	    }
	    
	    protected HPEProperties(){  
	            props = new Properties();  
	            InputStream in = this.getClass().getResourceAsStream(propertiesFile);  
	            try{  
	                    props.load(in);  
	                    in.close();  
	            }  
	            catch(IOException e){e.printStackTrace();}  
	    }  
	  
	    public String getValue(String key){  
	            return (String)props.getProperty(key);  
	    }  
	    
}
