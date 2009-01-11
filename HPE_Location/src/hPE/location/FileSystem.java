package hPE.location;


import hPE.location.xml.ComponentType;
import hPE.location.xml.FileType;
import hPE.location.xml.InterfaceType;
import hPE.location.xml.PackageListType;
import hPE.location.xml.PackageType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;


public class FileSystem {
	
	static final String CONFIG_HPE = "configuration.xml";
	
	private static final String dirBase = fetchDirBase();
	
	private static String fetchDirBase() {
		Properties properties = Parser.getPropertiesFile();
		String path = properties.getProperty("LOCATION_HOME");
		return path;
	}
	
	public static void createFile(String pk, String componentName){
		
		String dirName = pk.trim() + "." + componentName.trim();
		String name = dirName + "/" + CONFIG_HPE;
		
		createDir(dirName);
		
		File file = new File(dirBase + name.trim());
		if (!file.exists()){
			try{
		      file.createNewFile();
		      System.out.println("arquivo criado");		    
			}
			catch(Exception e){
				System.out.println("falha ao criar arquivo");
			}
		}		
	}

	public static void deleteFile(String pk,String componentName){		
	   	    
		String name = pk.trim()+"."+componentName.trim()+"/"+CONFIG_HPE;

		File file = new File(dirBase + name.trim());
		if (file.exists()){
			try{
		      file.delete();
		      System.out.println("arquivo deletado");		    
			}
			catch(Exception e){
				System.out.println("falha ao deletar arquivo");
			}
		}		
	}

	public static void createDir(String name){
		System.out.println("NAME: " + name);
		File file = new File(dirBase + name.trim());
		if (!file.exists()){
			try{
		       file.mkdirs();
			   System.out.println("diretorio criado");
			}catch(Exception e){				
				System.out.println("falha ao criar diretorio");
			}	    
		}				
	}
	
	public static void deleteDir(String name){		
	    File file = new File(dirBase+name.trim());
	    if(file.exists()){
	    	try{
	    		file.delete();
	    	}
	    	catch(Exception e){
	    		System.out.println("falha ao deletar diretorio");
	    	}	    	
	    }	
	}

	
	public static void verifyConsistency(PackageListType packages){
		Iterator<PackageType> i = packages.getPackage().iterator();
		while(i.hasNext()){
		     PackageType p = i.next();		     
		     Iterator<ComponentType> i2 = p.getComponent().iterator();
		     while(i2.hasNext()) {
		    	 ComponentType component = i2.next();
			     FileSystem.createFile(p.getPath(),component.getName());
		     }
		}
	}
	
	
	public static String getText(String pk, String componentName){
		
		String path = pk.trim()+"."+componentName.trim()+"\\"+CONFIG_HPE;

		String texto="";
		
		System.out.println("PATH = " + dirBase + path);
		
		try {
	        BufferedReader in = new BufferedReader(new FileReader(dirBase+path));
	        String str = in.readLine();  
	        while (str!=null){
	        	texto += str+"\n";
	        	str = in.readLine();	        	
	        }
	        in.close();
	    }
		catch (IOException e){e.printStackTrace();}
		
		return texto;
	}
	
	public static void setText(String pk, String componentName, String content){

		String path = pk.trim()+"."+componentName.trim()+"/"+CONFIG_HPE;

		System.out.println("PATH = " + dirBase + path);
		
		try {
			FileOutputStream fos = new FileOutputStream(dirBase+path);
			fos.write(content.getBytes());
		}
		catch (FileNotFoundException e1) {e1.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}

}
