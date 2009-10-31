package hPE.frontend.base.dialogs;

import hPE.HPEPlugin;
import hPE.core.library.HPEComponentLibraryView;
import hPE.core.library.HPELocationFileTraversor;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterface;
import hPE.location.HPE_Location_Server;
import hPE.location.HPE_Location_ServerService;
import hPE.location.HPE_Location_ServerServiceLocator;
import hPE.xml.component.ComponentType;
import hPE.xml.factory.HComponentFactory;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedRefInnerException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedSliceNamesException;
import hPE.xml.factory.HComponentFactoryImpl.UndefinedRefInnerException;

import java.awt.Frame;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import java.awt.Dimension;

public class RegisterComponentDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private HComponent c;  //  @jve:decl-index=0:
	private JComboBox jComboBoxLocations = null;
	private JCheckBox jCheckBoxFreeSource = null;
	private JButton jButtonRegister = null;
	private JButton jButtonInfo = null;
	private Map<String, URI> locations = new HashMap<String,URI>();  //  @jve:decl-index=0:
	private JComboBox jComboBoxVersions = null;
	private JLabel jLabelLocation = null;
	private JLabel jLabelVersion = null;
	private JButton jButtonRegisterMarkObsolete = null;
	private JButton jButtonUnregisterComponent = null;

	/**
	 * @param owner
	 * @param c 
	 */
	public RegisterComponentDialog(Frame owner, HComponent c) {
		super(owner);
		this.setComponent(c);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(421, 168);
		this.setTitle("Register " + c.getComponentName() + " in a Location");
		this.setContentPane(getJContentPane());
		HPELocationFileTraversor locationFileTraversor = new HPELocationFileTraversor();
		
		List<URI> l = locationFileTraversor.fetchLocations();
		for (URI uri : l) {
			String locationName = fetchLocationName(uri);
			if (locationName != null) {
			   this.locations.put(locationName, uri);
		       this.getJComboBoxLocations().addItem(locationName);
			} else {
				JOptionPane.showMessageDialog(null, "Unable to reach location at \n" + uri.toString(), "Location Fetch Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		List<Integer[]> vs = c.getVersions();
		for (Integer[] v : vs) {
		    this.getJComboBoxVersions().addItem(HInterface.toStringVersion(v));
		}
		this.getJComboBoxVersions().setSelectedIndex(vs.size()-1);
	}

	private String fetchLocationName(URI uri)  {
		String name = null;
		
		try {

			List<String> packagesList = new ArrayList<String>();
		
			String urlWS = uri.toString(); //EX: "http://localhost:8080/WSLocationServer/services/LocationService";

			URL url;
			url = new URL(urlWS);
		
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			
		    HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
				
			name = server.getName();
		
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
		
		return name;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelVersion = new JLabel();
			jLabelVersion.setBounds(new Rectangle(15, 55, 62, 16));
			jLabelVersion.setText("Version");
			jLabelLocation = new JLabel();
			jLabelLocation.setBounds(new Rectangle(15, 10, 69, 16));
			jLabelLocation.setText("Location");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJComboBoxLocations(), null);
			jContentPane.add(getJCheckBoxFreeSource(), null);
			jContentPane.add(getJButtonRegister(), null);
			jContentPane.add(getJButtonInfo(), null);
			jContentPane.add(getJComboBoxVersions(), null);
			jContentPane.add(jLabelLocation, null);
			jContentPane.add(jLabelVersion, null);
			jContentPane.add(getJButtonRegisterMarkObsolete(), null);
			jContentPane.add(getJButtonUnregisterComponent(), null);
			jLabelVersion.setVisible(!c.isAbstract());
			
		}
		return jContentPane;
	}

	private void setComponent(HComponent c) {
		this.c = c;
	}

	private HComponent getComponent() {
		return c;
	}

	/**
	 * This method initializes jComboBoxLocations	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxLocations() {
		if (jComboBoxLocations == null) {
			jComboBoxLocations = new JComboBox();
			jComboBoxLocations.setBounds(new Rectangle(15, 25, 231, 21));
		}
		return jComboBoxLocations;
	}

	/**
	 * This method initializes jCheckBoxFreeSource	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxFreeSource() {
		if (jCheckBoxFreeSource == null) {
			jCheckBoxFreeSource = new JCheckBox();
			jCheckBoxFreeSource.setBounds(new Rectangle(15, 100, 161, 21));
			jCheckBoxFreeSource.setSelected(true);
			jCheckBoxFreeSource.setText("Open Source");
		}
		return jCheckBoxFreeSource;
	}

	/**
	 * This method initializes jButtonRegister	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRegister() {
		if (jButtonRegister == null) {
			jButtonRegister = new JButton();
			jButtonRegister.setBounds(new Rectangle(265, 40, 141, 26));
			jButtonRegister.setText("Register");
			jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String locationName = (String) getJComboBoxLocations().getSelectedItem();
					URI uri = locations.get(locationName);
					String version = c.isAbstract() ? null : (String) getJComboBoxVersions().getSelectedItem(); 
					registerComponent(uri, version, getJCheckBoxFreeSource().isSelected());
				}
			});
		}
		return jButtonRegister;
	}

	private void registerComponent(URI uri, String version, boolean freeSource) {
		
		String errorMessage = null;
		
		if (c.versionSupplied(version == null ? "1.0.0.0" : version)) {
			if (c.versionCompiled(version == null ? "1.0.0.0" : version)){
				try {
		
					String urlWS = uri.toString(); //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
		
					URL url;
					url = new URL(urlWS);
				
					HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
					
				    HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
						
					String pkName = c.getPackagePath().toString();
					String ctName = c.getComponentName();	
					String savedUri = c.getRemoteLocation();
					c.setRemoteURI(uri);
					
					HComponentFactory factory = HComponentFactoryImpl.eInstance; 
					ComponentType cX = factory.marshallComponent(c);
					prepareForRegistering(cX, freeSource);
					IPath filePath = (new Path(c.getLocalLocation())).removeLastSegments(1).append("temp").append("temp.xml");
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath); /*TODO: Which file ?*/
					factory.saveComponent(cX, file, null);
					String contents = readTextFile(file);
					file.delete(true, null);
					
					HashMap<String,byte[]> resources = new HashMap<String,byte[]>();
					fillWithBinaries(version == null ? "1.0.0.0" : version, resources);					
					
					String message = server.registerComponent(pkName, ctName, version, contents, resources);

					JOptionPane.showMessageDialog(null, message, "Location Answer", JOptionPane.INFORMATION_MESSAGE);
					if (savedUri!=null) {
					   c.setRemoteURI(URI.createURI(savedUri));
					} else {
					   c.setRemoteURI(null);
					}
					
 			        HPEPlugin plugin = HPEPlugin.getDefault();
 			        plugin.notifyListeners(HPEComponentLibraryView.PROPERTY_LOCATION_CHANGED);

					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (ServiceException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (RemoteException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (IOException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (CoreException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (UndefinedRefInnerException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (DuplicatedRefInnerException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} catch (DuplicatedSliceNamesException e) {
					e.printStackTrace();
					errorMessage = e.getMessage();
				} finally {
					if (errorMessage != null)
					    JOptionPane.showMessageDialog(null, errorMessage, "Register Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				if (!c.isAbstract()) {
				   JOptionPane.showMessageDialog(null, "Version " + version + " of " + c.getComponentName() + " has uncompiled sources !", "Error",JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, c.getComponentName() + " has uncompiled sources !", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else {
			if (!c.isAbstract()) {
   			     JOptionPane.showMessageDialog(null, " The sources for version " + version + " of " + c.getComponentName() + " must be generated !\n hint: execute \"Edit Source\" on the pop-up menu of each interface of " + c.getComponentName() + ".", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				 JOptionPane.showMessageDialog(null, " The sources for " + c.getComponentName() + " must be generated !\n hint: execute \"Edit Source\" on the pop-up menu of each interface of " + c.getComponentName() + ".", "Error",JOptionPane.ERROR_MESSAGE);	
			}
		} 
		
		
	}

	private void fillWithBinaries(String version, HashMap<String, byte[]> resources) throws CoreException, IOException {
		
			for (HInterface i : c.getInterfaces()) {
				if (i.getConfiguration() == c) {
                    HBESourceVersion srcVersion = i.getSourceVersion(version);
                    for (Object objFile : srcVersion.getFiles()) {
                    	HBEAbstractFile file = (HBEAbstractFile) objFile;
                    	IPath binPath = file.getBinaryPath();
                    	IFile binFile = ResourcesPlugin.getWorkspace().getRoot().getFile(binPath);
                    	InputStream is = binFile.getContents();                    	
            			byte[] contents = new byte[is.available()];            			
            			is.read(contents);            			
            			String fileID = makeFileID(i, file);
            			resources.put(fileID, contents);            			
            			is.close();
                    }
				}
			
		}
		
	}

	private String makeFileID(HHasExternalReferences i, HBEAbstractFile file) {
		IPath filePath = new Path(file.getFileName());
		String fileName = filePath.removeFileExtension().addFileExtension(file.getBinaryExtension()).toString();
		
		return fileName;
	}

	private String readTextFile(IFile file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file.getLocation().toOSString()));
		String texto ="";
        String str = in.readLine();  
        while (str!=null){
        	texto += str+"\n";
        	str = in.readLine();	        	
        }
        in.close();
        return texto;
	}

	private void prepareForRegistering(ComponentType cx, boolean freeSource) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method initializes jButtonInfo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInfo() {
		if (jButtonInfo == null) {
			jButtonInfo = new JButton();
			jButtonInfo.setBounds(new Rectangle(265, 10, 141, 26));
			jButtonInfo.setText("About Location");
			jButtonInfo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String locationName = (String) getJComboBoxLocations().getSelectedItem();
					URI uri = locations.get(locationName);
					String message = getLocationPresentationMessage(uri);					
					
					JOptionPane.showMessageDialog(null,message, "About " + locationName,JOptionPane.INFORMATION_MESSAGE);
				}

			});
		}
		return jButtonInfo;
	}

	private String getLocationPresentationMessage(URI uri) {

		String message = "fail";
		
		try {

			List<String> packagesList = new ArrayList<String>();
		
			String urlWS = uri.toString(); //EX: "http://localhost:8080/WSLocationServer/services/LocationService";

			URL url;
			url = new URL(urlWS);
		
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			
			HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
				
			message = server.getPresentationMessage();
		
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
		
		return message;
	}

	/**
	 * This method initializes jComboBoxVersions	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxVersions() {
		if (jComboBoxVersions == null) {
			jComboBoxVersions = new JComboBox();
			jComboBoxVersions.setBounds(new Rectangle(15, 70, 129, 21));
			jComboBoxVersions.setVisible(!c.isAbstract());
		}
		return jComboBoxVersions;
	}

	/**
	 * This method initializes jButtonRegisterMarkObsolete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRegisterMarkObsolete() {
		if (jButtonRegisterMarkObsolete == null) {
			jButtonRegisterMarkObsolete = new JButton();
			jButtonRegisterMarkObsolete.setBounds(new Rectangle(265, 100, 141, 26));
			jButtonRegisterMarkObsolete.setText("Make Obsolete");
			jButtonRegisterMarkObsolete
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String locationName = (String) getJComboBoxLocations().getSelectedItem();
							URI uri = locations.get(locationName);
							String version = c.isAbstract() ? null : (String) getJComboBoxVersions().getSelectedItem(); 
							markAsObsolete(uri, version);
						}

					});
		}
		return jButtonRegisterMarkObsolete;
	}

	protected void markAsObsolete(URI uri, String version) {
		try {
			String urlWS = uri.toString(); //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
			
			URL url = new URL(urlWS);
		
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			
		    HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
				
			String pkName = c.getPackagePath().toString();
			String ctName = c.getComponentName();					
					
			String message = server.markAsObsolete(pkName, ctName, version);
	
			JOptionPane.showMessageDialog(null, message, "Location Answer", JOptionPane.INFORMATION_MESSAGE);
			
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

	/**
	 * This method initializes jButtonUnregisterComponent	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonUnregisterComponent() {
		if (jButtonUnregisterComponent == null) {
			jButtonUnregisterComponent = new JButton();
			jButtonUnregisterComponent.setBounds(new Rectangle(265, 70, 141, 26));
			jButtonUnregisterComponent.setText("Unregister");
			jButtonUnregisterComponent
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String locationName = (String) getJComboBoxLocations().getSelectedItem();
							URI uri = locations.get(locationName);
							String version = c.isAbstract() ? null : (String) getJComboBoxVersions().getSelectedItem(); 
							unregisterComponent(uri, version);
						}
					});
		}
		return jButtonUnregisterComponent;
	}

	protected void unregisterComponent(URI uri, String version) {
		try {
			String urlWS = uri.toString(); //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
			
			URL url = new URL(urlWS);
		
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			
		    HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
				
			String pkName = c.getPackagePath().toString();
			String ctName = c.getComponentName();					
					
			String message = server.unregisterComponent(pkName, ctName, version);
	
			JOptionPane.showMessageDialog(null, message, "Location Answer", JOptionPane.INFORMATION_MESSAGE);
			
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
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
