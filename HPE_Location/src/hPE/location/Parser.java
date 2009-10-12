package hPE.location;

import hPE.location.interfaces.Observer;
import hPE.location.xml.ComponentType;
import hPE.location.xml.PackageListType;
import hPE.location.xml.PackageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

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
	public static final String homeDir =System.getProperty("user.home") + File.separatorChar;
	public static  Properties properties = null; // Parser.getPropertiesFile();
	
	
	public Parser() {
		properties = Parser.getPropertiesFile();
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

			 Map<String,List<String>> pks = new HashMap<String, List<String>>();
			 Map<String, String> cversions = new HashMap<String,String>();
			 
			 Properties properties = Parser.getPropertiesFile();
			 File dir = new File(properties.getProperty("LOCATION_HOME"));
			 File[] dirs = dir.listFiles();
			 for (File d : dirs) if (d.isDirectory())  {			     
				 String dname = d.getName();
				 boolean isAbstract = dname.matches("(([A-Za-z0-9]+)\\.)*[A-Za-z0-9]+");
				 boolean isConcrete = dname.matches("((([A-Za-z0-9]+)\\.)*[A-Za-z0-9]+)\\-([0-9]*\\.[0-9]*\\.[0-9]*\\.[0-9]*)");
				 String version = null;
				 if (isConcrete) {
					 String s[] = dname.split("\\-");
					 dname = s[0];
					 version = s[1];
				 }
				 
				 String cname = dname.substring(dname.lastIndexOf('.') + 1);
			     String pkname = dname.substring(0, dname.lastIndexOf('.'));
			     List<String> cs = null;
				 if (!pks.containsKey(pkname)) {
					 cs = new ArrayList<String>();					 
					 pks.put(pkname, cs);
				 } else {
					 cs = pks.get(pkname);
				 }
				 cversions.put(pkname + "." + cname, version);
				 cs.add(cname);
			 }
			 
			 PackageListType pkList = new PackageListType();
			 List<PackageType> packages = pkList.getPackage();
			 
			 for (Entry<String, List<String>> e : pks.entrySet()) {
			     PackageType pk = new PackageType();
			     String pkname = e.getKey();
			     pk.setPath(pkname);
			     List<ComponentType> cs = pk.getComponent();
			     for (String cname : e.getValue()) {
			    	 ComponentType ct = new ComponentType();
			    	 ct.setName(cname);
			    	 String version = cversions.get(pkname + "." + cname);
			    	 File f = new File(dir.getAbsolutePath() + File.separatorChar + pkname + "." + cname + (version != null ? ("-" + version) : "") + "/" + "obsolete"); 
			    	 ct.setObsolete(f.exists());
			    	 ct.setVersion(version);
			    	 cs.add(ct);
			     }
			     packages.add(pk);
			 }
			 
			// return (PackageListType) unmarshaller.unmarshal(file);
			 return pkList;
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
        			s = homeDir + "hpe.location.properties";
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

