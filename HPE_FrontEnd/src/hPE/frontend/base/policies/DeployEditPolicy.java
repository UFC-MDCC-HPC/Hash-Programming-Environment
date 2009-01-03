package hPE.frontend.base.policies;

import hPE.HPEVersionEditor;
import hPE.frontend.base.dialogs.DeployComponentDialog;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.model.HComponent;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


public class DeployEditPolicy extends ComponentEditPolicy {

public DeployEditPolicy() {
	super();
}
	
private static final String
	DEPLOY_REQUEST = "Deploy";  //$NON-NLS-1$

public Command getCommand(Request request) {
		
	if (DEPLOY_REQUEST.equals(request.getType()))
		return new DeployCommand((ConfigurationEditPart)this.getHost());
	return 
	    super.getCommand(request);
	
	
	
}

static class DeployCommand 
extends org.eclipse.gef.commands.Command{

private ConfigurationEditPart part;

private HComponent c = null;
private HPEVersionEditor editor = null;


public DeployCommand(ConfigurationEditPart part){

  this.part = part;
  c = (HComponent) part.getModel();

      
}

public void execute(){


	
	// try {
	
		DeployComponentDialog dialog = new DeployComponentDialog(null, c);

		dialog.setModal(true);
	//	dialog.pack();
		dialog.setVisible(true);
		
	/*	String fileName = c.toString();
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileName));
		
		InputStream is = file.getContents();
		
		byte[] t = new byte[is.available()];
		
		is.read(t);
		
		String urlWS = "http://localhost:3494/teste/BackEndWS.asmx"; //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
	
		BackEnd_WSLocator server = new BackEnd_WSLocator();
		server.setBackEnd_WSSoapEndpointAddress(urlWS);
		
		BackEnd_WSSoap backend = server.getBackEnd_WSSoap();
		
		String s = backend.deployHashComponent(t);
		
	    s= s; */
	
/* } catch (javax.xml.rpc.ServiceException e)	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (CoreException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} */
	
	
	
}


public void undo(){

}

public void redo(){
   execute();
}

public boolean canExecute() {
/*	if (i.isUnamed()) {
		JOptionPane.showMessageDialog(null, "Unamed Interface !","Edit Source Code Error", JOptionPane.ERROR_MESSAGE);
		return false;
	} else
		return true; */
	return true;
}

}





}
