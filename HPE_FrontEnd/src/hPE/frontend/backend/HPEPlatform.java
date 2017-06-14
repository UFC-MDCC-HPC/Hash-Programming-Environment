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

import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class HPEPlatform {
	
	public static String deploy(String urlWS, HComponent c, String userName, String password, String curDir, boolean compile) throws IOException, ServiceException 
	{
		String fileName = c.getLocalLocation();
		
		IPath filePath = new Path(fileName);
		java.io.File file = HComponentFactoryImpl.getFileInWorkspace(filePath.setDevice(null));
				
		InputStream is = new FileInputStream(file);	
		byte[] t = new byte[is.available()];		
		is.read(t);
		
		//IPath filePathHCL = filePath.removeFileExtension().addFileExtension("hcl");
		//java.io.File fileHCL = HComponentFactoryImpl.getFileInWorkspace(filePathHCL.setDevice(null));

		//byte[] t_hcl = null;
		//if (fileHCL.exists()	)
		//{
	//		InputStream is_hcl = new FileInputStream(fileHCL);	
		//	t_hcl = new byte[is_hcl.available()];		
		//	is_hcl.read(t_hcl);
	//	}		
		
		BackEnd_WSLocator server = new BackEnd_WSLocator();
		server.setBackEnd_WSSoapEndpointAddress(urlWS);
		
		BackEnd_WSSoap backend = server.getBackEnd_WSSoap();
		
		String result = null;
		//if (t_hcl != null)
		//	result = backend.deployHashConfiguration(t, t_hcl, userName, password, curDir);
		//else
			result = backend.deployHashComponent(t, userName, password, curDir, compile);

		return result;
			
	}	
	
	public static String[] run(String urlWS, int cid, String[] enumerators, int[] enumValuation, String userName, String password, String curdir) throws ServiceException, RemoteException {			
		String[] result = null;

		BackEnd_WSLocator server = new BackEnd_WSLocator();
		server.setBackEnd_WSSoapEndpointAddress(urlWS);
	
		BackEnd_WSSoap backend;
		backend = server.getBackEnd_WSSoap();				
				
		result = backend.runApplication("","");			

		return result;
	}
	
	public static HComponent getConfiguration(URI uri) {
		
		HComponent c = null;
				
		try {
			c = HComponentFactoryImpl.eInstance.loadComponent(uri,true, false, false, false, false).get(0);
		} catch (HPEInvalidComponentResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return c;
	}

	public static void deployByPath(String pathIn, boolean compile_flag) throws Exception 
	{
		String password = null;
		String curDir = "";
		String userName = null;
		 //String urlWS = "http://castanhao.lia.ufc.br/hpe_backend/BackEndWS.asmx";
		// String urlWS = "http://localhost:8081/BackEndWS.asmx";
		//String urlWS = "http://200.19.177.96:8081/BackEndWS.asmx";
		 String urlWS = "http://200.19.177.101:8080/BackEndWS.asmx";
		
//		BrowseAndRunBackEndDialog.getCurrentEditor().doSave(null);
		
		URI uri = URI.createFileURI(pathIn);
		HComponent c = HPEPlatform.getConfiguration(uri);

		String result = HPEPlatform.deploy(urlWS, c, userName, password, curDir, compile_flag);
		
		if (result != null)
		    throw new Exception(result); //JOptionPane.showMessageDialog(null, result);
		else
			System.out.println("The component " + c.getComponentName() + " has been succesfully deployed !");
		
	}

	
}
	
	

