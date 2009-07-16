package hPE.frontend.base.dialogs;

import hPE.backend.BackEnd_WSLocator;
import hPE.backend.BackEnd_WSSoap;
import hPE.backend.SecureString;
import hPE.frontend.BackEndLocationList;
import hPE.frontend.BackEndLocationList.BackEndLocationInfo;
import hPE.frontend.BackEndLocationList.DeployedComponentInfo;
import hPE.frontend.BackEndLocationList.DeployedComponentInfoParameter;
import hPE.frontend.base.model.HComponent;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.editors.text.NonExistingFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import java.awt.Dimension;

public class BrowseAndRunBackEndDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox jComboBoxBackEnd = null;
	private JTable jTableBrowseAbstract = null;
	private JTable jTableBrowseConcrete = null;
	private JLabel jLabel = null;
	private JButton jButtonRunApp = null;
	private JPanel jPanel = null;
	private JRadioButton jRadioButtonByPackage = null;
	private JRadioButton jRadioButtonByName = null;
	private JRadioButton jRadioButtonByKind = null;
	private JLabel jLabel1 = null;
	private JCheckBox jCheckBoxApplication = null;
	private JCheckBox jCheckBoxComputation = null;
	private JCheckBox jCheckBoxSynchronizer = null;
	private JCheckBox jCheckBoxData = null;
	private JCheckBox jCheckBoxEnvironment = null;
	private JCheckBox jCheckBoxArchitecture = null;
	private JCheckBox jCheckBoxQualifier = null;
	private HComponent c = null;
	/**
	 * @param owner
	 */
	public BrowseAndRunBackEndDialog(Frame owner, HComponent c) {
		super(owner);
		this.c = c;
		initialize();
	}

	public BrowseAndRunBackEndDialog(Frame owner) {
		super(owner);
		initialize();
	}
	
	CheckBoxListener myListener = null;
	
	private Map<String,BackEndLocationInfo> backendList = null;  //  @jve:decl-index=0:

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		myListener = new CheckBoxListener();
		dcList = new ArrayList<DeployedComponentInfo>();
		
		this.setSize(1026, 300);
		this.setTitle("Back-End Connection");
		this.setContentPane(getJContentPane());
		this.loadBackEndsInfo();
		this.browseUpdate();
		
	}

	private static String EDIT_LABEL = "manage ...";  //  @jve:decl-index=0:
	
	private void loadBackEndsInfo() {
		// TODO Auto-generated method stub
		backendList = new HashMap<String,BackEndLocationInfo>();
		BackEndLocationList.loadBackEndsInfo(backendList);		
		
		getJComboBoxBackEnd().addItem(new BackEndLocationInfo("", null, null, null, null)); 
		for (BackEndLocationInfo b : backendList.values()) {
			getJComboBoxBackEnd().addItem(b);
		}			
		getJComboBoxBackEnd().addItem(new BackEndLocationInfo(EDIT_LABEL, null, null, null, null)); 
		
		if (backendList.size() > 0) 
			getJComboBoxBackEnd().setSelectedIndex(0);

		jComboBoxBackEnd.addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						JComboBox jComboBoxBackEnd = (JComboBox) e.getSource();
						BackEndLocationInfo b = (BackEndLocationInfo) jComboBoxBackEnd.getSelectedItem();							
						if (b.name.equals(EDIT_LABEL)) {
							dcList = new ArrayList<DeployedComponentInfo>();
						    browseUpdate();
							DeployComponentDialog dialog = new DeployComponentDialog(null);
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);				
							jButtonDeploy.setEnabled(false);
						} else if (b.name.equals("")) {
							dcList = new ArrayList<DeployedComponentInfo>();
						    browseUpdate();
							jButtonDeploy.setEnabled(false);
						}
						else {
							dcList = new ArrayList<DeployedComponentInfo>();
						    browseUpdate();
//							loadComponents(b);
							jButtonDeploy.setEnabled(c != null);
						}
					}


				}
		);
	}

	private void loadComponents(BackEndLocationInfo b) {
		try {
			dcList = BackEndLocationList.loadDeployedComponentsInfo(b,c.getLocalLocation(),dcListAbstract,dcListConcrete,rootPane);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(rootPane, e1.getMessage());
		} catch (ServiceException e1) {
			JOptionPane.showMessageDialog(rootPane, e1.getMessage());
		}							
	    browseUpdate();
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1Parameters = new JLabel();
			jLabel1Parameters.setBounds(new Rectangle(685, 70, 326, 16));
			jLabel1Parameters.setText("Parameters");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(140, 50, 556, 16));
			jLabel1.setText("Deployed Components");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(140, 10, 201, 16));
			jLabel.setText("Back-End");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJComboBoxBackEnd(), null);
			jContentPane.add(getJTableBrowseAbstract(), null);
			jContentPane.add(getJTableBrowseConcrete(), null);
		//	jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonRunApp(), null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJCheckBoxApplication(), null);
			jContentPane.add(getJCheckBoxComputation(), null);
			jContentPane.add(getJCheckBoxSynchronizer(), null);
			jContentPane.add(getJCheckBoxData(), null);
			jContentPane.add(getJCheckBoxEnvironment(), null);
			jContentPane.add(getJCheckBoxArchitecture(), null);
			jContentPane.add(getJCheckBoxQualifier(), null);
			jContentPane.add(getJButtonClose(), null);
			jContentPane.add(getJButtonDeploy(), null);
			jContentPane.add(getJTabbedPane(), null);
			jContentPane.add(getJScrollPaneAbstract(), null);
			jContentPane.add(getJScrollPaneParameter(), null);
			jContentPane.add(jLabel1Parameters, null);
			jContentPane.add(getJButtonLoad(), null);
			jContentPane.add(getJScrollPaneBrowse(), null);
		}
		return jContentPane;
	}

	private List<DeployedComponentInfo> dcList;  //  @jve:decl-index=0:
	
	private Map<Integer,DeployedComponentInfo> dcListAbstract = new HashMap<Integer,DeployedComponentInfo>();  //  @jve:decl-index=0:
	private Map<Integer,DeployedComponentInfo> dcListConcrete = new HashMap<Integer,DeployedComponentInfo>();  //  @jve:decl-index=0:

	private static int BY_PACKAGE = 0;
	private static int BY_NAME = 1;
	private static int BY_KIND = 2;
	
	private static String groupingStr[] = {"package","name","kind","enumerators"};  //  @jve:decl-index=0:
	
	private int[] grouping = {BY_PACKAGE, BY_NAME, BY_KIND};
	private int[] invgrouping = new int[grouping.length];
	
	static private int APPLICATION = 0;
	static private int COMPUTATION = 1;
	static private int SYNCHRONIZER = 2;
	static private int DATASTRUCTURE = 3;
	static private int ENVIRONMENT = 4;
	static private int ARCHITECTURE = 5;
	static private int QUALIFIER = 6;

	boolean[] kinds = {true, false, false, false, false, false, false};
	
	String[] kindsStr = {"application", "computation", "synchronizer", "data structure", "environment", "architecture", "qualifier"};
	
	private JButton jButtonClose = null;
	// private JScrollPane jScrollPane = null;
	private JButton jButtonDeploy = null;
	private JTabbedPane jTabbedPane = null;
	private JScrollPane jScrollPaneAbstract = null;
	private JScrollPane jScrollPaneBrowse = null;
	private JScrollPane jScrollPaneParameter = null;
	private JTree jTreeParameter = null;
	private JLabel jLabel1Parameters = null;
	private JButton jButtonLoad = null;
	/**
	 * This method initializes jComboBoxBackEnd	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxBackEnd() {
		if (jComboBoxBackEnd == null) {
			jComboBoxBackEnd = new JComboBox();
			jComboBoxBackEnd.setBounds(new Rectangle(140, 25, 201, 21));
		}
		return jComboBoxBackEnd;
	}

	
	private class BrowseSelectionListener implements ListSelectionListener {

		private JTable table = null;
		
		public BrowseSelectionListener(JTable table) {
			this.table = table;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent event) {
			
			if( event.getSource() == table.getSelectionModel()&& event.getFirstIndex() >= 0 ) {			
				updateParameters(table);	
			}			
		}				
	}
	

	/**
	 * This method initializes jTableBrowseAbstract	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableBrowseAbstract() {
		if (jTableBrowseAbstract == null) {
			jTableBrowseAbstract = new JTable();
			jTableBrowseAbstract.setBounds(new Rectangle(125, 70, 401, 191));
			jTableBrowseAbstract.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableBrowseAbstract.setName("");
			ListSelectionModel selectionModel = jTableBrowseAbstract.getSelectionModel();
			selectionModel.addListSelectionListener(new BrowseSelectionListener(jTableBrowseAbstract));
			
		}
		return jTableBrowseAbstract;
	}

	public void updateParameters(JTable table) {
		TableModel tm = (TableModel) table.getModel();
		if (table.getSelectedRow() >= 0) {
		    Object b = tm.getValueAt(table.getSelectedRow(), invgrouping[BY_NAME]);
		    if (b instanceof DeployedComponentInfo) {
		    	DeployedComponentInfo deployed = (DeployedComponentInfo) b;
		    	
				DefaultMutableTreeNode nodeRoot = new DefaultMutableTreeNode(deployed.cidBase >= 0 ? dcListAbstract.get(deployed.cidBase).name : dcListAbstract.get(deployed.cid).name);				    	
				
				boolean isAbstract = deployed.isAbstract;
				
				getJButtonRunApp().setEnabled(!isAbstract && deployed.kind == APPLICATION);
				
				if (deployed.parameters.length > 0) {
					for (DefaultMutableTreeNode node : loadParameters(deployed.parameters, isAbstract)) {
                       nodeRoot.add(node);							
					}
				}
				
				DefaultTreeModel model = (DefaultTreeModel) getJTreeParameter().getModel();
				
				model.setRoot(nodeRoot);
		    } else {
				DefaultTreeModel model = (DefaultTreeModel) getJTreeParameter().getModel();
				model.setRoot(null);
				getJButtonRunApp().setEnabled(false);
		    }
		} else {
			DefaultTreeModel model = (DefaultTreeModel) getJTreeParameter().getModel();
			model.setRoot(null);
			getJButtonRunApp().setEnabled(false);
		}
		
	}

	private DefaultMutableTreeNode[] loadParameters(DeployedComponentInfoParameter[] parameters, boolean isAbstract) {
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[parameters.length];
		if (parameters.length > 0) {
			int i = 0;
			for (DeployedComponentInfoParameter d : parameters) {
					String parameterId = d.parameter_id;
					String actual = dcListAbstract.get(d.component_name).name;
					node[i] = new DefaultMutableTreeNode(parameterId + (isAbstract ? " <= " : " = ") + actual);						
					for (DefaultMutableTreeNode nodeSon: loadParameters(d.parameter,isAbstract))  					
						node[i].add(nodeSon);
					i++;
			}
		}
		return node;
	}
	
	/**
	 * This method initializes jTableBrowseAbstract	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableBrowseConcrete() {
		if (jTableBrowseConcrete == null) {
			jTableBrowseConcrete = new JTable();
			jTableBrowseConcrete.setBounds(new Rectangle(0, 0, 0, 0));
			jTableBrowseConcrete.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableBrowseConcrete.setName("");
			ListSelectionModel selectionModel = jTableBrowseConcrete.getSelectionModel();
			selectionModel.addListSelectionListener(new BrowseSelectionListener(jTableBrowseConcrete));
			
		}
		return jTableBrowseConcrete;
	}
		
	/**
	 * This method initializes jButtonRunApp	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRunApp() {
		if (jButtonRunApp == null) {
			jButtonRunApp = new JButton();
			jButtonRunApp.setBounds(new Rectangle(780, 20, 66, 26));
			jButtonRunApp.setText("Run");
			jButtonRunApp.addActionListener(this);
			jButtonRunApp.setEnabled(false);
}
		return jButtonRunApp;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
/*			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.gridy = 0;
			gridBagConstraints.gridx = 1;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 2;*/
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(357, 16, 314, 44));
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "Sort", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel.add(getJRadioButtonByKind(), null);
			jPanel.add(getJRadioButtonByPackage(), null);
			jPanel.add(getJRadioButtonByName(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jRadioButtonByPackage	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonByPackage() {
		if (jRadioButtonByPackage == null) {
			jRadioButtonByPackage = new JRadioButton();
			jRadioButtonByPackage.setText("By Package");
			jRadioButtonByPackage.setBounds(new Rectangle(15, 15, 111, 24));
			jRadioButtonByPackage.setSelected(true);
			jRadioButtonByPackage.addActionListener(this);
		}
		return jRadioButtonByPackage;
	}

	/**
	 * This method initializes jRadioButtonByName	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonByName() {
		if (jRadioButtonByName == null) {
			jRadioButtonByName = new JRadioButton();
			jRadioButtonByName.setText("By Name");
			jRadioButtonByName.setHorizontalTextPosition(SwingConstants.RIGHT);
			jRadioButtonByName.setBounds(new Rectangle(130, 15, 86, 24));
			jRadioButtonByName.setHorizontalAlignment(SwingConstants.LEFT);
			jRadioButtonByName.addActionListener(this);
		}
		return jRadioButtonByName;
	}

	/**
	 * This method initializes jRadioButtonByKind	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonByKind() {
		if (jRadioButtonByKind == null) {
			jRadioButtonByKind = new JRadioButton();
			jRadioButtonByKind.setText("By Kind");
			jRadioButtonByKind.setBounds(new Rectangle(225, 15, 81, 24));
			jRadioButtonByKind.addActionListener(this);
		}
		return jRadioButtonByKind;
	}

	/**
	 * This method initializes jCheckBoxApplication	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxApplication() {
		if (jCheckBoxApplication == null) {
			jCheckBoxApplication = new JCheckBox();
			jCheckBoxApplication.setBounds(new Rectangle(5, 25, 111, 21));
			jCheckBoxApplication.setText("Application");
			jCheckBoxApplication.addItemListener(myListener);
			jCheckBoxApplication.setSelected(true);
		}
		return jCheckBoxApplication;
	}

	/**
	 * This method initializes jCheckBoxComputation	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxComputation() {
		if (jCheckBoxComputation == null) {
			jCheckBoxComputation = new JCheckBox();
			jCheckBoxComputation.setBounds(new Rectangle(5, 60, 121, 24));
			jCheckBoxComputation.setText("Computation");
			jCheckBoxComputation.addItemListener(myListener);
		}
		return jCheckBoxComputation;
	}

	/**
	 * This method initializes jCheckBoxSynchronizer	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxSynchronizer() {
		if (jCheckBoxSynchronizer == null) {
			jCheckBoxSynchronizer = new JCheckBox();
			jCheckBoxSynchronizer.setBounds(new Rectangle(5, 95, 126, 24));
			jCheckBoxSynchronizer.setText("Synchronizer");
			jCheckBoxSynchronizer.addItemListener(myListener);
		}
		return jCheckBoxSynchronizer;
	}

	/**
	 * This method initializes jCheckBoxData	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxData() {
		if (jCheckBoxData == null) {
			jCheckBoxData = new JCheckBox();
			jCheckBoxData.setBounds(new Rectangle(5, 130, 131, 24));
			jCheckBoxData.setText("Data Structure");
			jCheckBoxData.addItemListener(myListener);
		}
		return jCheckBoxData;
	}

	/**
	 * This method initializes jCheckBoxEnvironment	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxEnvironment() {
		if (jCheckBoxEnvironment == null) {
			jCheckBoxEnvironment = new JCheckBox();
			jCheckBoxEnvironment.setBounds(new Rectangle(5, 165, 126, 24));
			jCheckBoxEnvironment.setText("Environment");
			jCheckBoxEnvironment.addItemListener(myListener);
		}
		return jCheckBoxEnvironment;
	}

	/**
	 * This method initializes jCheckBoxArchitecture	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxArchitecture() {
		if (jCheckBoxArchitecture == null) {
			jCheckBoxArchitecture = new JCheckBox();
			jCheckBoxArchitecture.setBounds(new Rectangle(5, 200, 126, 24));
			jCheckBoxArchitecture.setText("Architecture");
			jCheckBoxArchitecture.addItemListener(myListener);
		}
		return jCheckBoxArchitecture;
	}

	/**
	 * This method initializes jCheckBoxQualifier	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxQualifier() {
		if (jCheckBoxQualifier == null) {
			jCheckBoxQualifier = new JCheckBox();
			jCheckBoxQualifier.setBounds(new Rectangle(5, 235, 111, 24));
			jCheckBoxQualifier.setText("Qualifier");
			jCheckBoxQualifier.addItemListener(myListener);
		}
		return jCheckBoxQualifier;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
		if (source == jButtonRunApp) {
			this.runSelectedApp();
		} else if (source == jButtonDeploy) {
			this.deploy();
		} else if (source == jButtonClose) {
			this.setVisible(false);
		} else if (source == jRadioButtonByPackage) {			
			jRadioButtonByKind.setSelected(false);
			jRadioButtonByName.setSelected(false);
			reorderGrouping(BY_PACKAGE);			
			browseUpdate();
		} else if (source == jRadioButtonByName) {
			jRadioButtonByPackage.setSelected(false);
			jRadioButtonByKind.setSelected(false);
			reorderGrouping(BY_NAME);
			browseUpdate();
		} else if (source == jRadioButtonByKind) {
			jRadioButtonByPackage.setSelected(false);
			jRadioButtonByName.setSelected(false);
            reorderGrouping(BY_KIND);
			browseUpdate();
		}
		
	}

	private void browseUpdate() {
		browseAbstractUpdate();
		browseConcreteUpdate();
	}

	private void deploy() {

		try {
			String fileName = c.getLocalLocation()
			;
		
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileName));
			
			InputStream is;
			is = file.getContents();
		
			byte[] t = new byte[is.available()];
			
			is.read(t);
			
			String urlWS = ((BackEndLocationInfo)jComboBoxBackEnd.getSelectedItem()).locURI;      //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
		
			BackEnd_WSLocator server = new BackEnd_WSLocator();
			server.setBackEnd_WSSoapEndpointAddress(urlWS);
			
			BackEnd_WSSoap backend = server.getBackEnd_WSSoap();
			
			String userName = null;
			String password = null;
			String result = backend.deployHashComponent(t,userName, password, null);
			if (result != null)
			    JOptionPane.showMessageDialog(rootPane, result);
			else
				JOptionPane.showMessageDialog(rootPane, "The component " + c.getComponentName() + " has succesfully been deployed !");
			
			this.browseUpdate();
			
		} catch (CoreException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		} 

	}
	
    private void reorderGrouping(int grouping_type) {
	    int j = 1;
	    int[] grouping_ = new int[3];
		grouping_[0] = grouping_type;
		for (int i=0;i<3;i++) {
			if (grouping[i] != grouping_type) {
				grouping_[j++] = grouping[i];
			}
		}
		grouping = grouping_;
	}

	private void runSelectedApp() {
		
		try {
			DeployedComponentInfo deployed = null;
		
			JTable table = getJTableBrowseConcrete();
			TableModel tm = (TableModel) table.getModel();
			if (table.getSelectedRow() >= 0) {
				Object b = tm.getValueAt(table.getSelectedRow(), invgrouping[BY_NAME]);
			
			    if (b instanceof DeployedComponentInfo) {
			    	deployed = (DeployedComponentInfo) b; 
			    }
			}
		    
			boolean canceled = false;
			if (deployed.enumerators.length > 0) {
				SetEnumeratorsDialog dialog = new SetEnumeratorsDialog(null, deployed.enumerators, deployed.enumValuation);
				dialog.setAlwaysOnTop(true);
				dialog.setModal(true);
				dialog.setVisible(true);
				canceled = dialog.getCanceled();
				deployed.enumValuation = dialog.getEnumValuation();
			}
			
			if (!canceled) {
				
				BackEndLocationInfo loc = (BackEndLocationInfo)jComboBoxBackEnd.getSelectedItem();
				
			    String urlWS = loc.locURI;      //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
			
			    RunApplicationThread runapp = new RunApplicationThread(urlWS, deployed, loc);

				RunningApplicationDialog d = new RunningApplicationDialog(null);
				d.setTitle("Running " + deployed.name + " on " + loc.name + ". Waiting ...");
				runapp.setDialog(d);
				runapp.start();
				
				d.setAlwaysOnTop(true);
			    d.setVisible(true);

				/* AXIS 2	
			    
			    BackEnd_WSStub service = new BackEnd_WSStub(urlWS); 
			    
				BackEnd_WSStub.RunApplication runapp = null;
				runapp = (BackEnd_WSStub.RunApplication) getObject(BackEnd_WSStub.RunApplication.class);
			    runapp.setId_concrete(deployed.cid);
			    ArrayOfString EIds = new ArrayOfString();
  	            EIds.setString(deployed.enumerators);
				runapp.setEIds(EIds);
			    ArrayOfInt EVls = new ArrayOfInt();
                EVls.set_int(deployed.enumValuation);
				runapp.setEVls(EVls);
				
			    MyCallBackHandler callback = new MyCallBackHandler();
				service.startrunApplication(runapp, callback); // ASYNCHRONOUS 
			    RunApplicationResponse response = service.runApplication(runapp); // SYNCHRONOUS 
			    
			    String[] result = response.getRunApplicationResult().getString();
				
			    */
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		} 
		
	}
	
	class RunApplicationThread extends Thread {
		
		private String urlWS = null;
		private RunningApplicationDialog d = null;
		private BackEndLocationInfo loc = null;
		private DeployedComponentInfo deployed = null;
		
		public RunApplicationThread(String urlWS, DeployedComponentInfo deployed, BackEndLocationInfo loc) {		
			this.urlWS = urlWS;
			this.loc = loc;
			this.deployed = deployed;
		}
		
		public void setDialog(RunningApplicationDialog d) {
		    this.d = d;	
		}
		
		public void run() {			
			try {
			BackEnd_WSLocator server = new BackEnd_WSLocator();
			server.setBackEnd_WSSoapEndpointAddress(urlWS);
	
			BackEnd_WSSoap backend;
				backend = server.getBackEnd_WSSoap();				
				
			String password = loc.password;			
			String userName = loc.login;
			String curdir = loc.curdir.toString();
			String[] result = backend.runApplication(deployed.cid, deployed.enumerators, deployed.enumValuation, userName, password, curdir); 

			if (result.length > 1) {
				d.setTitle("Running of " + deployed.name + "has finished on " + loc.name + " ! See below console output of the processes." );
				Integer i = 0;
				for (String s : result) {
					String processId = "Process " + i.toString(); i++;
				    d.newTab(processId, s);
				}
			} else {
				d.setTitle("Running of " + deployed.name + "has FAILED on " + loc.name + "!");
			    if (result.length==1) 
			    	d.newTab("Error Message", result[0]);
			}	
			
			
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
   // public org.apache.axis2.databinding.ADBBean getObject(java.lang.Class type) throws java.lang.Exception{
   //     return (org.apache.axis2.databinding.ADBBean) type.newInstance();
   //  }

 /*   public class MyCallBackHandler extends BackEnd_WSCallbackHandler {
		 public MyCallBackHandler() {
			 super();
		 }
         public void receiveResultrunApplication(BackEnd_WSStub.RunApplicationResponse result) {
				for (String s : result.getRunApplicationResult().getString())
			       JOptionPane.showMessageDialog(rootPane, s);  
        	 
        }
	} */
	
	// based on current kinds and grouping ...
	private void browseAbstractUpdate() {
		
		String[] columnNames = new String[4];
	    Object[][] data = new Object[dcList.size()][4];
	    DeployedComponentInfo[] dataItem = new DeployedComponentInfo[dcList.size()];
	    
	    for (int i=0; i<3; i++)
	        columnNames[i] = groupingStr[grouping[i]];
	    columnNames[3] = groupingStr[3]; 
	    
	   
	    for (int i=0;i<grouping.length;i++) {
	    	invgrouping[grouping[i]] = i;
	    }
	    
	    int j=0;
	    for (DeployedComponentInfo dci : dcList) {
	    	if (kinds[dci.kind] && dci.isAbstract){
		    	data[j][invgrouping[0]] = buildName(dci.thePackage,".");
		    	data[j][invgrouping[1]] = dci;
		    	data[j][invgrouping[2]] = kindsStr[dci.kind];
		    	data[j][3] = buildName(dci.enumerators,", ");	    	
		    	j++;
	    	} 	  
	    }
	    
	    for (;j<dcList.size(); j++) {
	    	data[j][invgrouping[0]] = "";
	    	data[j][invgrouping[1]] = "";
	    	data[j][invgrouping[2]] = "";
	    	data[j][3] = "";
	    }
	    
	    data = sort(data,invgrouping);
	    
	    BrowseTableModel btmAbs = new BrowseTableModel(columnNames,data);
		jTableBrowseAbstract.setModel(btmAbs);
		
	}

	// based on current kinds and grouping ...
	private void browseConcreteUpdate() {
		
		String[] columnNames = new String[4];
	    Object[][] data = new Object[dcList.size()][4];
	    
	    for (int i=0; i<3; i++)
	        columnNames[i] = groupingStr[grouping[i]];
	    columnNames[3] = groupingStr[3]; 
	    
	    int[] invgrouping = new int[grouping.length];
	    for (int i=0;i<grouping.length;i++) {
	    	invgrouping[grouping[i]] = i;
	    }
	    
	    int j=0;
	    for (DeployedComponentInfo dci : dcList) {
	    	if (kinds[dci.kind] && !dci.isAbstract){	
		    	data[j][invgrouping[0]] = buildName(dci.thePackage,".");
		    	data[j][invgrouping[1]] = dci;
		    	data[j][invgrouping[2]] = kindsStr[dci.kind];
		    	data[j][3] = buildName(dci.enumerators,", ");	    	
		    	j++;
	    	} 	  
	    }
	    
	    for (;j<dcList.size(); j++) {
	    	data[j][invgrouping[0]] = "";
	    	data[j][invgrouping[1]] = "";
	    	data[j][invgrouping[2]] = "";
	    	data[j][3] = "";
	    }
	    
	    data = sort(data,invgrouping);
	    
	    BrowseTableModel btmCon = new BrowseTableModel(columnNames,data);
		jTableBrowseConcrete.setModel(btmCon);
		
	}

	
	private Object[][] sort(Object[][] data, int[] invgrouping) {

		if (data.length > 1) {
		
			Object[] pivot = data[0];
			List<Object[]> ll = new ArrayList<Object[]>();
			List<Object[]> lu = new ArrayList<Object[]>();
			for (int i=1; i<data.length; i++) {
			  	if ( (!data[i][0].equals("")) && 
			  		(data[i][0].toString().compareTo(pivot[0].toString()) < 0 || 
		  		    (data[i][0].toString().equals(pivot[0].toString()) && data[i][1].toString().compareTo(pivot[1].toString()) < 0) || 
		  		    (data[i][0].toString().equals(pivot[0].toString()) && data[i][1].toString().equals(pivot[1].toString()) && data[i][2].toString().compareTo(pivot[2].toString()) < 0))) {
			  	        ll.add(data[i]);
			  	} else {
			  		lu.add(data[i]);
			  	}
			}
			
			Object[][] arrl = new Object[ll.size()][4];
			Object[][] arru = new Object[lu.size()][4];
			
			int k=0;
			for (Object[] ss : ll) {
				arrl[k++] = ss;
			}
			
			k=0;
			for (Object[] ss : lu) {
				arru[k++] = ss;
			}

			arrl = sort(arrl, invgrouping);
			arru = sort(arru, invgrouping);
						
			Object[][] arr = new Object[arrl.length + arru.length + 1][4]; 
			System.arraycopy(arrl,0,arr,0,arrl.length);
			arr[arrl.length] = pivot;
			System.arraycopy(arru,0,arr,arrl.length+1,arru.length);
			
			return arr;
		
		} else {
		   return data;
		}
	}
		

	private String buildName(String[] strs, String sep) {
        String s = strs.length > 0 ? strs[0] : "";
		for (int i=1; i<strs.length; i++) {
			s += (sep + strs[i]);
		}
        
		return s;
	}

	//Listens to the check boxes events
    class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {

        	 Object source = event.getSource();
			 if (source == jCheckBoxApplication) {
				 kinds[APPLICATION] = event.getStateChange() == ItemEvent.SELECTED;
				 browseUpdate();
			 } else if (source == jCheckBoxComputation) {
				 kinds[COMPUTATION] = event.getStateChange() == ItemEvent.SELECTED;
				 browseUpdate();
			 } else if (source == jCheckBoxSynchronizer) {
				 kinds[SYNCHRONIZER] = event.getStateChange() == ItemEvent.SELECTED;
				 browseUpdate();
			 } else if (source == jCheckBoxData) {
				 kinds[DATASTRUCTURE] = event.getStateChange() == ItemEvent.SELECTED;				 
				 browseUpdate();
			 } else if (source == jCheckBoxEnvironment) {
				 kinds[ENVIRONMENT] = event.getStateChange() == ItemEvent.SELECTED;
				 browseUpdate();
			 } else if (source == jCheckBoxArchitecture) { 
				 kinds[ARCHITECTURE] = event.getStateChange() == ItemEvent.SELECTED;
				 browseUpdate();
			 } else if (source == jCheckBoxQualifier) {
				 kinds[QUALIFIER] = event.getStateChange() == ItemEvent.SELECTED;
				 browseUpdate();
			 }

        }
    }


	/**
	 * This method initializes jButtonClose	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClose() {
		if (jButtonClose == null) {
			jButtonClose = new JButton();
			jButtonClose.setBounds(new Rectangle(940, 20, 76, 26));
			jButtonClose.setText("Close");
			jButtonClose.addActionListener(this);
		}
		return jButtonClose;
	}	
	
	
	
	class BrowseTableModel extends AbstractTableModel {
	    
		private String[] columnNames;
	    private Object[][] data;
	    
	    public BrowseTableModel(String[] columnNames, Object[][] data) {
            this.columnNames = columnNames;
            this.data = data;
	    }

	    public int getColumnCount() {
	        return columnNames.length;
	    }

	    public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }

	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }

	    /*
	     * Don't need to implement this method unless your table's
	     * editable.
	     */
	    public boolean isCellEditable(int row, int col) {
            return false;
	    }

	}


	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
/*	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane(getJTableBrowse());
			jScrollPane.setBounds(new Rectangle(125, 70, 486, 191));
			jScrollPane.setVisible(false);
		}
		return jScrollPane;
	} */

	/**
	 * This method initializes jButtonDeploy	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDeploy() {
		if (jButtonDeploy == null) {
			jButtonDeploy = new JButton();
			jButtonDeploy.setBounds(new Rectangle(850, 20, 86, 26));
			jButtonDeploy.setText("Deploy");
			jButtonDeploy.addActionListener(this);
			jButtonDeploy.setEnabled(false);
		}
		return jButtonDeploy;
	}

	/**
	 * This method initializes jScrollPaneAbstract	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneAbstract() {
		if (jScrollPaneAbstract == null) {
			jScrollPaneAbstract = new JScrollPane(/*getJTableBrowseAbstract()*/);
			jScrollPaneAbstract.setBounds(new Rectangle(0, 0, 0, 0));
		}
		return jScrollPaneAbstract;
	}

	/**
	 * This method initializes jScrollPaneBrowse	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneBrowse() {
		if (jScrollPaneBrowse == null) {
			jScrollPaneBrowse = new JScrollPane(getJTabbedPane());
			jScrollPaneBrowse.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jScrollPaneBrowse.setBounds(new Rectangle(140, 70, 536, 191));
		}
		return jScrollPaneBrowse;
	}	
	

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setBounds(new Rectangle(140, 70, 526, 191));
			jTabbedPane.addTab("Abstract",getJTableBrowseAbstract());
			jTabbedPane.addTab("Concrete",getJTableBrowseConcrete());
			//jTabbedPane.addTab(null, null, getJScrollPaneBrowse(), null);
			jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					Object src = e.getSource();
					JTabbedPane pane = (JTabbedPane) src;
				    JTable table = (JTable) pane.getSelectedComponent();
				    updateParameters(table);
				}
			});
			
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jScrollPaneParameter	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneParameter() {
		if (jScrollPaneParameter == null) {
			jScrollPaneParameter = new JScrollPane();
			jScrollPaneParameter.setBounds(new Rectangle(685, 90, 331, 171));
			jScrollPaneParameter.setViewportView(getJTreeParameter());
		}
		return jScrollPaneParameter;
	}

	/**
	 * This method initializes jTreeParameter	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTreeParameter() {
		if (jTreeParameter == null) {
			jTreeParameter = new JTree();
			DefaultTreeModel model = (DefaultTreeModel) jTreeParameter.getModel();
			model.setRoot(null);
		}
		return jTreeParameter;
	}

	/**
	 * This method initializes jButtonLoad	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLoad() {
		if (jButtonLoad == null) {
			jButtonLoad = new JButton();
			jButtonLoad.setBounds(new Rectangle(685, 20, 91, 26));
			jButtonLoad.setText("Browse");
			jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JComboBox jComboBoxBackEnd = getJComboBoxBackEnd();
					BackEndLocationInfo b = (BackEndLocationInfo) jComboBoxBackEnd.getSelectedItem();							
					if (b.name.equals(EDIT_LABEL)) {
						dcList = new ArrayList<DeployedComponentInfo>();
					    browseUpdate();
						DeployComponentDialog dialog = new DeployComponentDialog(null);
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);				
						jButtonDeploy.setEnabled(false);
					} else if (b.name.equals("")) {
						dcList = new ArrayList<DeployedComponentInfo>();
					    browseUpdate();
						jButtonDeploy.setEnabled(false);
					}
					else {
						dcList = new ArrayList<DeployedComponentInfo>();
					    browseUpdate();
						loadComponents(b);
						jButtonDeploy.setEnabled(c != null);
					}
				}
			});
		}
		return jButtonLoad;
	}


		



	
}  //  @jve:decl-index=0:visual-constraint="149,-11"
