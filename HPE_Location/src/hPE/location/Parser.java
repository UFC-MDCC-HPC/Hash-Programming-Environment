package hPE.location;

import hPE.location.interfaces.Observer;
import hPE.location.xml.PackageListType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class Parser implements Observer{

	private static Parser instance=null;
	private LocationService ls;
	private JAXBContext jc;
	private Unmarshaller unmarshaller;
	private Marshaller marshaller;
	private File file; 
	public static final String curDir =System.getProperty("user.dir")+File.separatorChar;
	
	
	public Parser() {
		Properties properties = Parser.getPropertiesFile();
		String path = properties.getProperty("LOCATION_HOME");
		System.out.println("PATH: " + path);
		
	    file =  new File(path + "location.xml");
    }
	
	public static Parser getInstance(){
		if(instance==null) 
			instance = new Parser();		
		return instance;		
	}

	public void setLS(LocationService ls){
		this.ls = ls;
	}
	
	public PackageListType getLocationXml() {         
		try {
			 jc = JAXBContext.newInstance("hPE.location.xml", this.getClass().getClassLoader());
			 unmarshaller = jc.createUnmarshaller();
			 //JAXBElement<PackageListType> o = (JAXBElement<PackageListType>) unmarshaller.unmarshal(file);
			 return (PackageListType) unmarshaller.unmarshal(file);
			 //return (PackageListType) o.getValue();
		}
		catch(Exception e){ 
			e.printStackTrace();			
			return null;
		}			
	}
	
	public void setLocationXml(){			
		try{
		   jc = JAXBContext.newInstance("hPE.location.xml", this.getClass().getClassLoader());
		   marshaller = jc.createMarshaller(); 
		   FileOutputStream fileOut = new FileOutputStream(file); 
		   // define que a saida no documento XML sera formatada
		   marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		   // le o objeto e gera o XML		   
		   marshaller.marshal((this.ls.getPackages()) , fileOut);
		}
		catch(Exception e){
		   e.printStackTrace();
		}
	}
	
	public void update(){		
		setLocationXml();		
	}
	
	 /*
     * Pegando o properties
     */
    public static Properties getPropertiesFile(){
    	Properties properties = new Properties();
    	 
        try {
        	String s = null;

        	s = getArgVal("--properties");
        	if (s == null) {
        		s = System.getenv("HPE_LOCATION_PROPERTIES");
        		if (s == null) {
        			s = curDir + "hpe.location.properties";
        		}
        	}
        	
        	
        	
            properties.load(new FileInputStream(s));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return properties;
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

