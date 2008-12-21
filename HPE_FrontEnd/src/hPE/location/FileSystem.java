package hPE.location;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import hPE.location.Packages.Package;

public class FileSystem {
	
	
	private static final String dirBase = System.getenv("LOCATION_ENTRY") + "/";
	
	public static void createFile(String name){
		File file = new File(dirBase+name.trim());
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

	public static void deleteFile(String name){		
	   	    
	    File file = new File(dirBase+name.trim());
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
		File file = new File(dirBase+name.trim());
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
	
	public static void verifyConsistency(Packages packages){
		Iterator i = packages.getPackage().iterator();
		while(i.hasNext()){  	 
		     Package p = (Package) i.next();		     
		     createDir(p.getPath());
		     System.err.println("Folder " + p.getPath() + " does not Exist ! Creating ! ");
		     Iterator i2 = p.fetchComponents().getComponent().iterator();
		     while(i2.hasNext()){
		    	 String componentName = (String) i2.next();		    	
		    	 // createFile(p.getPath().trim()+"/"+componentName.trim()+".xml");
		    	 System.err.println("File" +  componentName + ".xml does not Exist !");
		     }
		}		
	}
	
	public static String getText(String path){
		
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
}
