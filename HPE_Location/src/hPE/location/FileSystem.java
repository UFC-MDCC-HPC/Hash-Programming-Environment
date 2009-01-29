package hPE.location;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class FileSystem {
	
	static final String CONFIG_HPE = "configuration.xml";
	
	private static final String dirBase = fetchDirBase();
	
	private static String fetchDirBase() {
		Properties properties = Parser.getPropertiesFile();
		String path = properties.getProperty("LOCATION_HOME");
		return path;
	}
	
	public static void createFile(String pk, String componentName, String version){
		
		String dirName = pk.trim() + "." + componentName.trim() + (version != null ? "-" + version : "");
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

	public static boolean testFile(String pk, String componentName, String version){
		
		String dirName = pk.trim() + "." + componentName.trim() + (version != null ? "-" + version : "");
		String name = dirName + "/" + CONFIG_HPE;
				
		File file = new File(dirBase + name.trim());
		return file.exists();	
	}

	public static void deleteFile(String pk, String componentName, String version){		
	   	    
		String dirName = pk.trim() + "." + componentName.trim() + (version != null ? "-" + version : "");
		String name = dirName + "/" + CONFIG_HPE;

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

	
	
	
	public static String getText(String pk, String componentName, String version){
		
		String dirName = pk.trim() + "." + componentName.trim() + (version != null ? "-" + version : "");
		String path = dirName + "/" + CONFIG_HPE;

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
	
	public static void setText(String pk, String componentName, String version, String content){

		String dirName = pk.trim() + "." + componentName.trim() + (version != null ? "-" + version : "");
		String path = dirName + "/" + CONFIG_HPE;

		System.out.println("PATH = " + dirBase + path);
		
		try {
			FileOutputStream fos = new FileOutputStream(dirBase+path);
			fos.write(content.getBytes());
		}
		catch (FileNotFoundException e1) {e1.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static byte[] getDataBinaryFile(String path, String componentName, String version, String fileName) {
		
		String dirName = path.trim() + "." + componentName.trim() + (version != null ? "-" + version : "") + "/bin";
		String name = dirName + "/" + fileName; 
		
		try {
	       InputStream is = new FileInputStream(dirBase + name.trim()); 
	       byte[] contents = new byte[is.available()]; 
	       is.read(contents);	       	      
	       return contents;
	    }
		catch (IOException e){e.printStackTrace();}

		return null;
	}

	public static void createBinaryFile(String path, String componentName,
			String version, String fileName, byte[] contents) {
		
		
		String dirName = path.trim() + "." + componentName.trim() + (version != null ? "-" + version : "") + "/bin";
		String name = dirName + "/" + fileName; 
		
		createDir(dirName);
		
		File file = new File(dirBase + name.trim());
		if (!file.exists()){
			try {
		      file.createNewFile();
			  FileOutputStream fos = new FileOutputStream(dirBase + name.trim());
			  fos.write(contents);
		    }
			catch(Exception e){
				System.out.println("Error creating " + dirBase + name.trim());
			}
		}		
		
		
	}

}
