package hPE;

import hPE.frontend.backend.HPEPlatform;
import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.policies.OpenSourceEditPolicy;
import hPE.frontend.connector.xml.XMLConfigurationGenerator;
import hPE.ui.preferences.PreferenceConstants;
import hPE.xml.factory.HComponentFactory;
import hPE.xml.factory.HComponentFactoryImpl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.swing.JOptionPane;

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
					   new Action("Save ALL") {
						   public void run()  {
							        DataInputStream in = null;
                                    try{
									    // Open the file that is the first 
									    // command line parameter
                                    	String path = HPEProperties.get(PreferenceConstants.HPE_HOME) + Path.SEPARATOR + "to_save.txt";
									    FileInputStream fstream = new FileInputStream(path);
									    // Get the object of DataInputStream
									    in = new DataInputStream(fstream);
									    BufferedReader br = new BufferedReader(new InputStreamReader(in));
									    HComponentFactory factory = HComponentFactory.eInstance;
									    String strLine;
									    //Read File Line By Line
									    while ((strLine = br.readLine()) != null)
									    	if (strLine.startsWith("STOP"))
										    	break;
									    	else if (!strLine.startsWith("#"))
										    {	
									    		//boolean compile_flag = strLine.lastIndexOf('*') < 0;
									    		//if (!compile_flag)
									    		//	strLine = strLine.substring(0,strLine.lastIndexOf('*'));									    		
									    		
										        int i = strLine.lastIndexOf('.');
										        
										        String base_path = "/home/heron/Dropbox/Copy/ufc_mdcc_hpc/HPC-Shelf/BackendServices_EC2/platforms";
										        
										        String p = base_path + Path.SEPARATOR + strLine + Path.SEPARATOR + strLine.substring(i+1) + ".hpe";
										    	
												System.out.println("started: saving " + p);
												java.io.File file2 = new File(p);
												URI uri = URI.createFileURI(p);
												HComponent c = HComponentFactoryImpl.eInstance.loadComponent(uri,true, false, false, false, false).get(0);
												
												List<HInterface> it_list = new ArrayList<HInterface>(c.getInterfaces());
												HInterface it = it_list.get(it_list.size()-1);
																		
												HBESourceVersion version = null;
												HBEAbstractSynthesizer synthesizer = null;
												Collection<HBESourceVersion> vs = it.getSourceVersions();
												if (vs.size()==1) {
													Object[] vsa = vs.toArray();
													version = (HBESourceVersion) vsa[0];
													synthesizer = it.getSupportedSynthesizers().get(0);
												} else {
													throw new Exception("Unexpected interface with more than one version (OpenSourceEditPolicy)");
												}
										    	 HBESourceVersion code = synthesizer.synthesize(it,version.getVersionID());

										    	 for (HBEAbstractSourceCodeFile srcFile : code.getFiles()) 
										    		{ 
										    			srcFile.persistSourceFile();

										    		}												
												
												
												factory.saveComponent(c,file2,null);
												
											    //HPEPlatform.deployByPath(p, compile_flag);
											    System.out.println("finished: saving " + p);
										    } 
										    
								    	JOptionPane.showMessageDialog(null, "Finished !");
									       
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
			   
			   mainMenu.add(
					   new Action("Generate HCL (xml) for " + fname) {
						   public void run()  {
							        DataInputStream in = null;
                                    try{
								    	IPath pathIn_output = pathIn.removeFileExtension().addFileExtension("hcl");
                                    	
										java.io.File file = new File(pathIn_output.toOSString());
										URI uri = URI.createFileURI(pathIn.toOSString());
										
									    HComponent c = HComponentFactoryImpl.eInstance.loadComponent(uri,true, false, false, false, false).get(0);
									    
                                    	XMLConfigurationGenerator.saveComponent(c, file);
                                    	
                                    	JOptionPane.showMessageDialog(null, "Finished ! " + file.toString() + " created !");   
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
