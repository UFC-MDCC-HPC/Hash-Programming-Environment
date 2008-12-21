package hPE.location;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;




public class Parser implements Observer{

	private static Parser instance=null;
	private LocationService ls;
	private JAXBContext jc;
	private Unmarshaller unmarshaller;
	private Marshaller marshaller;
	private File file = new File(System.getenv("LOCATION_ENTRY").concat("/location.xml"));
	
	public Parser() {
		
	}
	
	public static Parser getInstance(){
		if(instance==null) 
			instance = new Parser();		
		return instance;		
	}
	
	public void setLS(LocationService ls){
		this.ls = ls;
	}
	
	public Packages getLocationXml() {         
		try {			 
			 jc = JAXBContext.newInstance("hPE.location");
			 unmarshaller = jc.createUnmarshaller();				 
			 return (Packages) unmarshaller.unmarshal(file);		     			 		 
		}
		catch(Exception e){ 
			e.printStackTrace();			
			return null;
		}			
	}
	
	public void setLocationXml(){			
		try{
		   jc = JAXBContext.newInstance("hPE.location");
		 
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
}
