
package hPE.core.library;

//import hPE.core.HLocationService;
//import hPE.core.LocationService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.rpc.ServiceException;

import localhost.axis.LocationServer_jws.LocationServer;
import localhost.axis.LocationServer_jws.LocationServerService;
import localhost.axis.LocationServer_jws.LocationServerServiceLocator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class HPELocationEntry {
	
	public static Hashtable <String, String>htable = new Hashtable<String, String>();	
	
	
	public static List<String> fetchPackagesFromLocation(URI locationSite) throws RemoteException, ServiceException {
		// try {
			//Dada a uri de uma location, retorne a lista de packages.
			List<String> packagesList = new ArrayList<String>();
			
			String urlWS = locationSite.toString(); //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
	
			/* BEGIN WITHOUT WEB SERVICE */
			// HLocationService loc = new LocationService();		
	        // String str = loc.fetchPackages();
			/* END WITHOUT WEB SERVICE */
			LocationServerService locationServerService = new LocationServerServiceLocator();
			
		    LocationServer server = locationServerService.getLocationServer(); 
				
			String str = server.fetchPackages();
			
	//		String operation = "fetchPackages"; 
	//		Object [] param = {}; //argumentos da operacao
	//		String str = (String)callWebService(operation, urlWS, param); 
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
//		 }
//		 catch (RemoteException e) {
		     // MessageDialog.
	//		 return null;
	//	 }
		// catch (ServiceException e) {
		 //    return null;
		 //}
		 		
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
				fetchPackagesFromLocation(locationSite);
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

	public static java.io.File getComponent(String[] pkName, String componentName, URI locationSite) 
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
		
		String urlWS = locationSite.toString();

		LocationServerService locationServerService = new LocationServerServiceLocator();
		
	    LocationServer server = locationServerService.getLocationServer(); 
		
	    String str = server.getComponent(pk, componentName);
		
		// BEGIN NO WEB SERVICE
		// HLocationService loc = new LocationService();		
        // String str = loc.getComponent(pk, componentName);
        // END NO WEB SERVICE
			
		if (!(str == null)) {
			try {
				String cFileName = componentName + ".tmp.hpe";  
				file = java.io.File.createTempFile("fileName",".hpe");; // createFile(pk,cFileName);
				// String fname = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().getPath().toString() + file.getFullPath().toPortableString();
				String fname = file.getAbsolutePath();
				BufferedWriter out = new BufferedWriter(new FileWriter(fname));
				out.write(str);
				out.close();        
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			throw new HPEComponentFileNotFound();
		}
		} catch (RemoteException e) {
			e.printStackTrace();
		
		} catch (ServiceException e) {
			e.printStackTrace();
			
		//} catch (HPEInvalidComponentResourceException e) {
		//	e.printStackTrace();
		}
		return file;
	}
	
	public static IFile createFile(String dirBase, String name){
		IPath path = new Path(dirBase + "//" + name);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return file;
	}

}
