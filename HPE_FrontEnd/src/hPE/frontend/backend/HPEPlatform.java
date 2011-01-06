package hPE.frontend.backend;

import hPE.backend.BackEnd_WSLocator;
import hPE.backend.BackEnd_WSSoap;
import hPE.frontend.BackEndLocationList;
import hPE.frontend.BackEndLocationList.BackEndLocationInfo;
import hPE.frontend.BackEndLocationList.DeployedComponentInfo;
import hPE.frontend.base.model.HComponent;
import hPE.xml.factory.HComponentFactoryImpl;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.Path;

public class HPEPlatform {
	
	public static String deploy(String urlWS, HComponent c, String userName, String password, String curDir) throws IOException, ServiceException {

		String fileName = c.getLocalLocation();
	
		java.io.File file = HComponentFactoryImpl.getFileInWorkspace(new Path(fileName));
		
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
	
	
}
	
	

