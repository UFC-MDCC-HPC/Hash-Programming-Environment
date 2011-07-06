package hPE;

import hPE.frontend.backend.HPEPlatform;
import hPE.frontend.base.dialogs.BrowseAndRunBackEndDialog;
import hPE.frontend.base.model.HComponent;
import hPE.xml.factory.HComponentFactory;
import hPE.xml.factory.HComponentFactoryImpl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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
						   public void run()  {
							        DataInputStream in = null;
                                    try{
									    // Open the file that is the first 
									    // command line parameter
									    FileInputStream fstream = new FileInputStream("/home/heron/to_deploy.txt");
									    // Get the object of DataInputStream
									    in = new DataInputStream(fstream);
									    BufferedReader br = new BufferedReader(new InputStreamReader(in));
									    HComponentFactory factory = HComponentFactory.eInstance;
									    String strLine;
									    //Read File Line By Line
									    while ((strLine = br.readLine()) != null)   {
									        int i = strLine.lastIndexOf('.');
									        String p = strLine + Path.SEPARATOR + strLine.substring(i+1) + ".hpe";
									    	
											System.out.println("started: deploying " + p);
											java.io.File file2 = new File(p);
											URI uri = URI.createFileURI(p);
											HComponent c = HComponentFactoryImpl.eInstance.loadComponent(uri,true, false, false, false, false);
											factory.saveComponent(c,file2,null);
											
										    HPEPlatform.deployByPath(p);
										    System.out.println("finished: deploying " + p);
									    }
									    
								    	JOptionPane.showMessageDialog(null, "Finished ! All deployed !");
									       
									    }
                                    catch (Exception e)
									{//Catch exception if any
									      //System.err.println("Error: " + e.getMessage());
									    	JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
									}
									finally {
									  	if (in != null) {
											try {
												in.close();
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
									  	}
									}
						   }
						}
				);
			   
		   }
	   }

	}
	
	
	
	
	

}
