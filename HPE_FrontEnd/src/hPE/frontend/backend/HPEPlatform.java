package hPE.frontend.backend;

import hPE.backend.BackEnd_WSLocator;
import hPE.backend.BackEnd_WSSoap;
import hPE.frontend.base.model.HComponent;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HPEInvalidComponentResourceException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class HPEPlatform {
	
	public static String deploy(String urlWS, HComponent c, String userName, String password, String curDir) throws IOException, ServiceException {

		String fileName = c.getLocalLocation();
	
		java.io.File file = HComponentFactoryImpl.getFileInWorkspace((new Path(fileName)).setDevice(null));
		
		InputStream is = new FileInputStream(file);
	
		byte[] t = new byte[is.available()];
		
		is.read(t);
			
		BackEnd_WSLocator server = new BackEnd_WSLocator();
		server.setBackEnd_WSSoapEndpointAddress(urlWS);
		
		BackEnd_WSSoap backend = server.getBackEnd_WSSoap();
		
		String result = backend.deployHashComponent(t,userName, password, curDir);

		return result;
			
	}	
	
	public static String[] run(String urlWS, int cid, String[] enumerators, int[] enumValuation, String userName, String password, String curdir) throws ServiceException, RemoteException {			
		String[] result = null;

		BackEnd_WSLocator server = new BackEnd_WSLocator();
		server.setBackEnd_WSSoapEndpointAddress(urlWS);
	
		BackEnd_WSSoap backend;
		backend = server.getBackEnd_WSSoap();				
				
		result = backend.runApplication(cid, enumerators, enumValuation, userName, password, curdir);			

		return result;
	}
	
	public static HComponent getConfiguration(URI uri) {
		
		HComponent c = null;
				
		try {
			c = HComponentFactoryImpl.eInstance.loadComponent(uri,true, false, false, false, false);
		} catch (HPEInvalidComponentResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return c;
	}

	
}
	
	

