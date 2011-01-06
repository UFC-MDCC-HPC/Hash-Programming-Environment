package hPE;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
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
		   }
	   }

//		   MenuManager menu1 = new MenuManager("Compile HCL", "1");
//		   menu1.add(new Action("Action 1") {});
//		   mainMenu.add(menu1);
//		   MenuManager menu2 = new MenuManager("Menu &2", "2");
//		   menu2.add(new Action("Action 2") {});
//		   menu1.add(menu2);

		
	}
	
	
	
	
	

}
