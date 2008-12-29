package hPE.frontend.base.dialogs;

import hPE.frontend.BackEndLocationList;
import hPE.frontend.BackEndLocationList.BackEndLocationInfo;
import hPE.frontend.BackEndLocationList.DeployedComponentInfo;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class BrowseAndRunBackEndDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox jComboBoxBackEnd = null;
	private JTable jTableBrowse = null;
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
	/**
	 * @param owner
	 */
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
		
		this.setSize(539, 306);
		this.setTitle("Browse Back-End");
		this.setContentPane(getJContentPane());
		this.loadBackEndsInfo();
		this.browseUpdate();
		
	}

	private void loadBackEndsInfo() {
		// TODO Auto-generated method stub
		backendList = new HashMap<String,BackEndLocationInfo>();
		BackEndLocationList.loadBackEndsInfo(backendList);		
		for (BackEndLocationInfo b : backendList.values()) {
			getJComboBoxBackEnd().addItem(b);
		}		
		if (backendList.size() > 0) 
			getJComboBoxBackEnd().setSelectedIndex(0);
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(125, 52, 401, 16));
			jLabel1.setText("Deployed Components");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(125, 10, 201, 16));
			jLabel.setText("Back-End");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJComboBoxBackEnd(), null);
			jContentPane.add(getJTableBrowse(), null);
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
		}
		return jContentPane;
	}

	private List<DeployedComponentInfo> dcList;
	
	private static int BY_PACKAGE = 0;
	private static int BY_NAME = 1;
	private static int BY_KIND = 2;
	
	private int[] grouping = {BY_PACKAGE,BY_NAME,BY_KIND};
	
	static private int APPLICATION = 0;
	static private int COMPUTATION = 1;
	static private int SYNCHRONIZER = 2;
	static private int DATASTRUCTURE = 3;
	static private int ENVIRONMENT = 4;
	static private int ARCHITECTURE = 5;
	static private int QUALIFIER = 6;

	boolean[] kinds = {true, false, false, false, false, false, false};
	private JButton jButtonClose = null;

	/**
	 * This method initializes jComboBoxBackEnd	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxBackEnd() {
		if (jComboBoxBackEnd == null) {
			jComboBoxBackEnd = new JComboBox();
			jComboBoxBackEnd.setBounds(new Rectangle(125, 25, 201, 21));
			jComboBoxBackEnd.addActionListener(
					new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							JComboBox jComboBoxBackEnd = (JComboBox) e.getSource();
							BackEndLocationInfo b = (BackEndLocationInfo) jComboBoxBackEnd.getSelectedItem();							
							dcList = BackEndLocationList.loadDeployedComponentsInfo(b);
							browseUpdate();
						}

					}
			);
		}
		return jComboBoxBackEnd;
	}

	
	/**
	 * This method initializes jTableBrowse	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableBrowse() {
		if (jTableBrowse == null) {
			jTableBrowse = new JTable();
			jTableBrowse.setBounds(new Rectangle(125, 70, 401, 191));
			jTableBrowse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableBrowse.setName("");
			
		}
		return jTableBrowse;
	}

		
	/**
	 * This method initializes jButtonRunApp	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRunApp() {
		if (jButtonRunApp == null) {
			jButtonRunApp = new JButton();
			jButtonRunApp.setBounds(new Rectangle(330, 20, 126, 26));
			jButtonRunApp.setText("Run Application");
			jButtonRunApp.addActionListener(this);
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
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.gridy = 2;
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.gridy = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 3;
			gridBagConstraints.gridx = 1;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 2;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBounds(new Rectangle(10, 10, 92, 72));
			jPanel.add(getJRadioButtonByKind(), gridBagConstraints);
			jPanel.add(getJRadioButtonByPackage(), gridBagConstraints9);
			jPanel.add(getJRadioButtonByName(), gridBagConstraints21);
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
			jCheckBoxApplication.setBounds(new Rectangle(10, 85, 111, 21));
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
			jCheckBoxComputation.setBounds(new Rectangle(10, 110, 111, 24));
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
			jCheckBoxSynchronizer.setBounds(new Rectangle(10, 135, 116, 24));
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
			jCheckBoxData.setBounds(new Rectangle(10, 160, 111, 24));
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
			jCheckBoxEnvironment.setBounds(new Rectangle(10, 185, 111, 24));
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
			jCheckBoxArchitecture.setBounds(new Rectangle(10, 210, 111, 24));
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
			jCheckBoxQualifier.setBounds(new Rectangle(10, 235, 111, 24));
			jCheckBoxQualifier.setText("Qualifier");
			jCheckBoxQualifier.addItemListener(myListener);
		}
		return jCheckBoxQualifier;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
		if (source == jButtonRunApp) {
			runSelectedApp();
		} else if (source == jButtonClose) {
			this.setVisible(false);
		} else if (source == jRadioButtonByPackage) {			
			reorderGrouping(BY_PACKAGE);			
			browseUpdate();
		} else if (source == jRadioButtonByName) {
			reorderGrouping(BY_NAME);
			browseUpdate();
		} else if (source == jRadioButtonByKind) {
            reorderGrouping(BY_KIND);
			browseUpdate();
		}
		
	}

	
    private void reorderGrouping(int grouping_type) {
	    int j = 1;
	    int[] grouping_ = new int[3];
		grouping_[0] = BY_PACKAGE;
		for (int i=0;i<3;i++) {
			if (grouping[i] != grouping_type) {
				grouping_[j++] = grouping[i];
			}
		}
		grouping = grouping_;
	}

	private void runSelectedApp() {
		// TODO Auto-generated method stub		
		
	}

	// based on current kinds and grouping ...
	private void browseUpdate() {
		// TODO Auto-generated method stub
		
	}

	//Listens to the check boxes events
    class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {

        	 Object source = event.getSource();
			 if (source == jCheckBoxApplication) {
				 kinds[APPLICATION] = event.getStateChange() == ItemEvent.SELECTED;
			 } else if (source == jCheckBoxComputation) {
				 kinds[COMPUTATION] = event.getStateChange() == ItemEvent.SELECTED;
			 } else if (source == jCheckBoxSynchronizer) {
				 kinds[SYNCHRONIZER] = event.getStateChange() == ItemEvent.SELECTED;
			 } else if (source == jCheckBoxData) {
				 kinds[DATASTRUCTURE] = event.getStateChange() == ItemEvent.SELECTED;				 
			 } else if (source == jCheckBoxEnvironment) {
				 kinds[ENVIRONMENT] = event.getStateChange() == ItemEvent.SELECTED;
			 } else if (source == jCheckBoxArchitecture) { 
				 kinds[ARCHITECTURE] = event.getStateChange() == ItemEvent.SELECTED;
			 } else if (source == jCheckBoxQualifier) {
				 kinds[QUALIFIER] = event.getStateChange() == ItemEvent.SELECTED;
			 } else if (source instanceof String) {
				 String s = (String) source;
				 if (s.equals("manage...")) {
					DeployComponentDialog dialog = new DeployComponentDialog(null);
					dialog.setModal(true);
					dialog.setVisible(true);
				 }
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
			jButtonClose.setBounds(new Rectangle(460, 20, 66, 26));
			jButtonClose.setText("Close");
			jButtonClose.addActionListener(this);
		}
		return jButtonClose;
	}	
}  //  @jve:decl-index=0:visual-constraint="10,10"
