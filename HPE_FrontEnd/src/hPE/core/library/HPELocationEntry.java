
package hPE.core.library;

//import hPE.core.HLocationService;
//import hPE.core.LocationService;
import hPE.HPEProperties;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.location.HPE_Location_Server;
import hPE.location.HPE_Location_ServerService;
import hPE.location.HPE_Location_ServerServiceLocator;
import hPE.util.CommandLine;
import hPE.xml.factory.HComponentFactoryImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.rpc.ServiceException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class HPELocationEntry {
	
	public static Hashtable<String, String> htable = new Hashtable<String, String>();	
	
	
	public static List<String> fetchPackagesFromLocation(URI locationSite, boolean showObsolete) throws RemoteException, ServiceException {
		try {
			//Dada a uri de uma location, retorne a lista de packages.
			List<String> packagesList = new ArrayList<String>();
			
			String urlWS = locationSite.toString(); //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
	
			URL url = new URL(urlWS);	
			
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			
			HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
				
			String str = server.fetchPackages(showObsolete);			
			
			/**
			 * o valor dessa string retornada pelo webservice � algo do seguinte formato:
			 * package1 ( component1 component2 ... ) package2 ( ) package3 ( component1 ) ...
			 * cada package � seguida pelo conjunto de components que possui. 
			 * Se houver algum erro, o valor da str ser� null
			 */
			if(str!=null){
				
				StringTokenizer token = new StringTokenizer(str);
				String p;
				String c = "";
				String aux;
							
				while(token.hasMoreTokens()){
					p = token.nextToken();	//package		
					
					aux = token.nextToken(); // aux recebe (
					aux = token.nextToken(); // aux recebe ) ou Component
					
					while(token.hasMoreTokens() && !aux.equals(")")){						
						c += aux+" "; //vai armazenar os components de um package separados por espa�o
						aux = token.nextToken(); // aux recebe ) ou Component					
					}			
					packagesList.add(p);			
					htable.put(p, c); //adiciona uma chave package e seus components
					c = "";
				}
			  }
			 return packagesList;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;		 		
	}

	public static List<String> fetchComponents(URI locationSite, String[] packagePath) {
		/**
		 * retorne a lista de componentes de uma package relativa a uma location (lembre-se que uma package
		 * pode estar espalhada em varias locations)
		 */
		
		List<String> componentsList = new ArrayList<String>();
		
		String pk="";
		pk = packagePath[0];
		for(int i = 1; i<packagePath.length;i++){
			pk += "." + packagePath[i];
		}
		
		if(!htable.containsKey(pk)){ //se a package ainda n�o est� na tabelahash devemos fzr um fetchpackages para adiciona-la
			try {
				fetchPackagesFromLocation(locationSite,false);
			} catch (RemoteException e) {
			    e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		
		String str = htable.get(pk); //retorna todos o components numa string separados por espa�o
		
		if(str!=null){
			StringTokenizer token= new StringTokenizer(str); 
			String c;
			while(token.hasMoreTokens()){
				c = token.nextToken();										
				componentsList.add(c);					
			}			
		}				
		
		return componentsList;
	}

	public static java.io.File getComponent(String[] pkName, String componentName, String version, URI locationSite) 
	         throws HPEComponentFileNotFound
	{
		java.io.File file = null;
		try {
		/**
		 * o codigo que escrevi abaixo pega o conteudo do component e escreve num arquivo xml
		 * nomeado como: packagename.component
		 */
		String pk="";
		pk = pkName[0];
		for(int i = 1; i<pkName.length;i++){
			pk += "."+pkName[i];
		}
		
		file = HComponentFactoryImpl.getCachePath(pk, componentName, version);
		
		if (!file.exists()) {

			URL url = new URL(locationSite.toString());
			
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
		    String contents = server.getComponent(pk, componentName, version);
			
			if (!(contents == null)) {
				try {
					file.createNewFile();
					
					String fname = file.getAbsolutePath();
					BufferedWriter out = new BufferedWriter(new FileWriter(fname));
					out.write(contents);
					out.close();        
				
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} else {
				throw new HPEComponentFileNotFound();
			}
		}
		
		} catch (RemoteException e) {
			e.printStackTrace();
		
		} catch (ServiceException e) {
			e.printStackTrace();
			
		//} catch (HPEInvalidComponentResourceException e) {
		//	e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	public static IFile createFile(String dirBase, String name){
		IPath path = new Path(dirBase + "//" + name);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return file;
	}

	public static void getBinaryFile(String packageName, String componentName, String versionID, HBEAbstractFile binFile, URI locationSite) {
		
		try {
			URL url = new URL(locationSite.toString());
	
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
			String fileName = (new Path(binFile.getFileName())).removeFileExtension().addFileExtension(binFile.getBinaryExtension()).toString();
		    byte[] contents = server.getBinaryFile(packageName, componentName, versionID, fileName);
		    
		    File file = binFile.getBinaryPath().toFile();
		    
		    String path = file.getParent();
		    File folder = new File(path);
		    if (!folder.exists()) {
		    	folder.mkdir();
		    }
		    
			if (!file.exists()){
				try {
			      file.createNewFile();
				  FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
				  fos.write(contents);
				  fos.close();
				  
				  String gacutil_path = HPEProperties.getInstance().getValue("gacutil_path");
				  
 			      CommandLine.runCommand(new String[] {gacutil_path, "-i", fileName}, null, folder);
			    }
				catch(Exception e){
					e.printStackTrace();
				}
			}		
		    
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
