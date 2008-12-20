using System;
using System.Xml;
using System.IO;
using System.Web.Services;
using System.Collections;
using System.Xml.Serialization;
using DGAC; 
using DGAC.utils;
using DGAC.database;

namespace backEndServices{

public class BackEndWS:System.Web.Services.WebService {
	
	
	
	private DGAC.BackEnd dgac;
	
	public BackEndWS(){
		
		
		dgac = new DGAC.BackEnd();
		
	
	}
	
	[WebMethod]
	/*
	 * XML é visto como um array de bytes, chamado data.
	 * esse array é salvo em "path" e lido por AppLoader gerando um objeto Component Type,
	 * passado ao DGAC 
     */
	public String deployConfigurationXML(byte[] data){
		string filename = "newConfig";
		string path = Constants.PATH_TEMP_WORKER+filename+".xml";
		if(data!=null){
			FileUtil.saveByteArraIntoFile(data,path);
		    ComponentType c = LoaderApp.DeserializeObject(path);
		    dgac.registerConcreteComponent(c);
		}
			
		return "ok";
	}

	 
	
	
	    
}

}//namespace
