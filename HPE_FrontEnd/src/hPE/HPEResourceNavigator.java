package hPE;

import hPE.frontend.backend.HPEPlatform;
import hPE.frontend.base.dialogs.BrowseAndRunBackEndDialog;
import hPE.frontend.base.model.HComponent;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.views.navigator.ResourceNavigator;

import br.ufc.mdcc.hclc.frontend.HCLCompile;

@SuppressWarnings("deprecation")
public class HPEResourceNavigator extends ResourceNavigator {

	private static final String DEPRECATION = "deprecation";

	public HPEResourceNavigator() {
		super();
		initialize();

	}

	private void initialize() {
	
	   
		
	}
	
	IPath pathIn = null;
	IPath pathOut = null;
	
	@SuppressWarnings(DEPRECATION)
	protected void fillContextMenu(IMenuManager menu) {
		   
	   super.fillContextMenu(menu);		 
		   
	   TreeSelection s = (TreeSelection) this.getTreeViewer().getSelection();
	   Object r = s.getFirstElement();
	   if (r instanceof IFile) {
		   
		   pathIn = ResourcesPlugin.getWorkspace().getRoot().getFile(((IFile) r).getFullPath()).getLocation();
		   
		   if (pathIn.getFileExtension().equals("hcl")) {
			   pathOut = pathIn.removeFileExtension().addFileExtension("hpe");
			   String fname = pathOut.lastSegment();
			   IMenuManager mainMenu = menu;//get ref to main menu manager
			   mainMenu.add(
					   new Action("Compile HCL (build " + fname + ")") {
						   public void run() { 							   
                                    try {
										HCLCompile.hclc(pathIn.toString(), pathOut.toString());
									} catch (IOException e) {
										e.printStackTrace();
									}
						   }
						}
				);
		   } else if (pathIn.getFileExtension().equals("hpe")) {
			   String fname = pathIn.lastSegment();
			   IMenuManager mainMenu = menu;//get ref to main menu manager
			   mainMenu.add(
					   new Action("Deploy " + fname) {
						   public void run() { 							   
                                    try {
										String password = null;
										String curDir = "";
										String userName = null;
										String urlWS = "http://castanhao.lia.ufc.br/hpe_backend/BackEndWS.asmx";
										
//										BrowseAndRunBackEndDialog.getCurrentEditor().doSave(null);
										
										URI uri = URI.createFileURI(pathIn.makeAbsolute().toOSString());
										HComponent c = HPEPlatform.getConfiguration(uri);

										String result = HPEPlatform.deploy(urlWS, c, userName, password, curDir);
										
										if (result != null)
										    JOptionPane.showMessageDialog(null, result);
										else
											JOptionPane.showMessageDialog(null, "The component " + c.getComponentName() + " has been succesfully deployed !");
									} catch (IOException e) {
										e.printStackTrace();
									} catch (ServiceException e) {										
										e.printStackTrace();
									}
						   }
						}
				);
			   
		   }
	   }

	}
	
	
	
	
	

}
