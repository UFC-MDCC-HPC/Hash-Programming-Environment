package hPE.frontend.base.dialogs;

import hPE.frontend.BackEndLocationList;
import hPE.frontend.BackEndLocationList.BackEndLocationInfo;
import hPE.frontend.base.model.HComponent;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.tempuri.BackEnd_WSLocator;
import org.tempuri.BackEnd_WSSoap;

public class DeployComponentDialog extends JDialog 
                                   implements	ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextField_BackEndURI = null;
	private JLabel jLabelBackEndURI = null;
	private JTextField jTextFieldBackEndName = null;
	private JLabel jLabelBackEndName = null;
	private JTextField jTextFieldBackEndLogIn = null;
	private JLabel jLabelBackEndLogin = null;
	private JTextField jTextFieldBackEndPassword = null;
	private JLabel jLabelBackEndPassword = null;
	private JButton jButtonClose = null;
	private JButton jButtonDeploy = null;
	private JList jListBackEnds = null;
	private JLabel jLabelBackEnds = null;
	private JEditorPane jEditorPaneBackEndDescription = null;
	private JLabel jLabelBackEndDescription = null;
	private JButton jButtonAddBackEnd = null;
	/**
	 * @param owner
	 * @param c 
	 */
	
	private HComponent c = null;
	
	public DeployComponentDialog(Frame owner, HComponent c) {
		super(owner);
		this.c = c;
		initialize();
	}

	public DeployComponentDialog(Frame owner) {
		super(owner);
		this.c = null;
		initialize();
		jButtonDeploy.setEnabled(false);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(526, 328);
		this.setTitle("Deploy Component");
		this.setContentPane(getJContentPane());
		this.loadBackEndsInfo();
	}

	private void loadBackEndsInfo() {
		// TODO Auto-generated method stub
		backendList = new HashMap<String,BackEndLocationInfo>();
		BackEndLocationList.loadBackEndsInfo(backendList);		
		Object[] backendArray = (Object[]) backendList.values().toArray();
		getJListBackEnds().setListData(backendArray);
		
	}

	private Map<String,BackEndLocationInfo> backendList = null;  //  @jve:decl-index=0:
	private JButton jButtonSaveBackEndInfo = null;
	
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelBackEndDescription = new JLabel();
			jLabelBackEndDescription.setBounds(new Rectangle(15, 150, 256, 16));
			jLabelBackEndDescription.setText("Description");
			jLabelBackEnds = new JLabel();
			jLabelBackEnds.setBounds(new Rectangle(285, 15, 136, 16));
			jLabelBackEnds.setText("Available Back-End's");
			jLabelBackEndPassword = new JLabel();
			jLabelBackEndPassword.setBounds(new Rectangle(150, 105, 121, 16));
			jLabelBackEndPassword.setText("Password");
			jLabelBackEndLogin = new JLabel();
			jLabelBackEndLogin.setBounds(new Rectangle(15, 105, 106, 16));
			jLabelBackEndLogin.setText("Login");
			jLabelBackEndName = new JLabel();
			jLabelBackEndName.setBounds(new Rectangle(15, 15, 170, 16));
			jLabelBackEndName.setText("Back-End Site Name");
			jLabelBackEndURI = new JLabel();
			jLabelBackEndURI.setBounds(new Rectangle(15, 60, 256, 16));
			jLabelBackEndURI.setText("Back-End Service URI");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextField_BackEndURI(), null);
			jContentPane.add(jLabelBackEndURI, null);
			jContentPane.add(getJTextFieldBackEndName(), null);
			jContentPane.add(jLabelBackEndName, null);
			jContentPane.add(getJTextFieldBackEndLogIn(), null);
			jContentPane.add(jLabelBackEndLogin, null);
			jContentPane.add(getJTextFieldBackEndPassword(), null);
			jContentPane.add(jLabelBackEndPassword, null);
			jContentPane.add(getJButtonClose(), null);
			jContentPane.add(getJButtonDeploy(), null);
			jContentPane.add(getJListBackEnds(), null);
			jContentPane.add(jLabelBackEnds, null);
			jContentPane.add(getJEditorPaneBackEndDescription(), null);
			jContentPane.add(jLabelBackEndDescription, null);
			jContentPane.add(getJButtonAddBackEnd(), null);
			jContentPane.add(getJButtonSaveBackEndInfo(), null);
			jContentPane.add(getJButtonDeleteBackEnd(), null);
		}
		return jContentPane;
	}


	/**
	 * This method initializes jTextField_BackEndURI	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_BackEndURI() {
		if (jTextField_BackEndURI == null) {
			jTextField_BackEndURI = new JTextField();
			jTextField_BackEndURI.setBounds(new Rectangle(15, 75, 256, 20));
		}
		return jTextField_BackEndURI;
	}

	/**
	 * This method initializes jTextFieldBackEndName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldBackEndName() {
		if (jTextFieldBackEndName == null) {
			jTextFieldBackEndName = new JTextField();
			jTextFieldBackEndName.setBounds(new Rectangle(15, 30, 172, 20));
			jTextFieldBackEndName.addActionListener(this);
		}
		return jTextFieldBackEndName;
	}

	/**
	 * This method initializes jTextFieldBackEndLogIn	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldBackEndLogIn() {
		if (jTextFieldBackEndLogIn == null) {
			jTextFieldBackEndLogIn = new JTextField();
			jTextFieldBackEndLogIn.setBounds(new Rectangle(15, 120, 106, 20));
		}
		return jTextFieldBackEndLogIn;
	}

	/**
	 * This method initializes jTextFieldBackEndPassword	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldBackEndPassword() {
		if (jTextFieldBackEndPassword == null) {
			jTextFieldBackEndPassword = new JTextField();
			jTextFieldBackEndPassword.setBounds(new Rectangle(150, 120, 121, 20));
		}
		return jTextFieldBackEndPassword;
	}

	/**
	 * This method initializes jButtonClose	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClose() {
		if (jButtonClose == null) {
			jButtonClose = new JButton();
			jButtonClose.setBounds(new Rectangle(435, 60, 76, 31));
			jButtonClose.setText("Close");
			jButtonClose.addActionListener(this);
		}
		return jButtonClose;
	}

	/**
	 * This method initializes jButtonDeploy	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDeploy() {
		if (jButtonDeploy == null) {
			jButtonDeploy = new JButton();
			jButtonDeploy.setBounds(new Rectangle(435, 15, 76, 31));
			jButtonDeploy.setText("Deploy");
			jButtonDeploy.addActionListener(this);
		}
		return jButtonDeploy;
	}

	/**
	 * This method initializes jListBackEnds	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListBackEnds() {
		if (jListBackEnds == null) {
			jListBackEnds = new JList();
			jListBackEnds.addListSelectionListener(this);
			jListBackEnds.setBounds(new Rectangle(285, 30, 136, 256));
		}
		return jListBackEnds;
	}

	/**
	 * This method initializes jEditorPaneBackEndDescription	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPaneBackEndDescription() {
		if (jEditorPaneBackEndDescription == null) {
			jEditorPaneBackEndDescription = new JEditorPane();
			jEditorPaneBackEndDescription.setBounds(new Rectangle(15, 165, 256, 76));
			jEditorPaneBackEndDescription.setEnabled(false);
		}
		return jEditorPaneBackEndDescription;
	}

	/**
	 * This method initializes jButtonAddBackEnd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAddBackEnd() {
		if (jButtonAddBackEnd == null) {
			jButtonAddBackEnd = new JButton();
			jButtonAddBackEnd.setBounds(new Rectangle(15, 255, 76, 31));
			jButtonAddBackEnd.setText("Clear");
			jButtonAddBackEnd.addActionListener(this);
		}
		return jButtonAddBackEnd;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
	    
		if (event.getSource() == jButtonDeploy) {
	        this.deploy();	
		} else if (event.getSource() == jButtonClose) {
			this.setVisible(false);
		} else if (event.getSource() == jButtonAddBackEnd) {
	        this.clearFields();
		} else if (event.getSource() == jButtonSaveBackEndInfo) {
			BackEndLocationInfo b;
			if (backendList.containsKey(jTextFieldBackEndName.getText())) {
			    b = backendList.get(jTextFieldBackEndName.getText());
			} else {
				b = new BackEndLocationInfo();
			}
		    b.name = jTextFieldBackEndName.getText();
		    b.locURI = jTextField_BackEndURI.getText();
		    b.login = jTextFieldBackEndLogIn.getText();
		    b.password = jTextFieldBackEndPassword.getText();
		    backendList.put(b.name, b);
		    
		    BackEndLocationList.saveData(backendList);
			this.loadBackEndsInfo();
		} else if (event.getSource() == jButtonDeleteBackEnd) {
		    backendList.remove(jTextFieldBackEndName.getText());	
		    BackEndLocationList.saveData(backendList);
			this.loadBackEndsInfo();
			this.clearFields();
		}
			
	}

	private void deploy() {

		try {
			String fileName = c.toString();
		
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileName));
			
			InputStream is;
			is = file.getContents();
		
			byte[] t = new byte[is.available()];
			
			is.read(t);
			
			String urlWS = jTextField_BackEndURI.getText();   //EX: "http://localhost:8080/WSLocationServer/services/LocationService";
		
			BackEnd_WSLocator server = new BackEnd_WSLocator();
			server.setBackEnd_WSSoapEndpointAddress(urlWS);
			
			BackEnd_WSSoap backend = server.getBackEnd_WSSoap();
			
			String s = backend.deployHashComponent(t);
			
			System.out.println(s);
			
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


	private JButton jButtonDeleteBackEnd = null;

	private void clearFields() {
		jTextFieldBackEndName.setText(null);
		jTextField_BackEndURI.setText(null);
		jTextFieldBackEndLogIn.setEnabled(true);
		jTextFieldBackEndLogIn.setText(null);
		jTextFieldBackEndPassword.setEnabled(true);			
	    jTextFieldBackEndPassword.setText(null);
		jEditorPaneBackEndDescription.setText(null);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		
		if (event.getSource() == jListBackEnds) {
			BackEndLocationInfo bel = (BackEndLocationInfo) jListBackEnds.getSelectedValue();
			if (bel != null) {
				jTextFieldBackEndName.setText(bel.name);
				jTextField_BackEndURI.setText(bel.locURI);
				if (bel.login != null) { 
					jTextFieldBackEndLogIn.setEnabled(true);
					jTextFieldBackEndLogIn.setText(bel.login);
				}
				else  { 
					jTextFieldBackEndLogIn.setEnabled(false);
					jTextFieldBackEndLogIn.setText(null);
				}
				if (bel.password != null) {
					jTextFieldBackEndPassword.setEnabled(true);			
				    jTextFieldBackEndPassword.setText(bel.password);
				} else { 
					jTextFieldBackEndPassword.setEnabled(false);
					jTextFieldBackEndPassword.setText(null);
				}
				
				jEditorPaneBackEndDescription.setText("NOT YET IMPLEMENTED !");
			}
		} else if (event.getSource() == jTextFieldBackEndName) {
		    if (jTextFieldBackEndName.getText().equals("") || jTextFieldBackEndName.getText() == null) {
		       jButtonSaveBackEndInfo.setEnabled(false);
		    } else {
		       jButtonSaveBackEndInfo.setEnabled(true);
		    }
		}
		
	}

	/**
	 * This method initializes jButtonSaveBackEndInfo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSaveBackEndInfo() {
		if (jButtonSaveBackEndInfo == null) {
			jButtonSaveBackEndInfo = new JButton();
			jButtonSaveBackEndInfo.setBounds(new Rectangle(105, 255, 76, 31));
			jButtonSaveBackEndInfo.setText("Save");
			jButtonSaveBackEndInfo.addActionListener(this);
		}
		return jButtonSaveBackEndInfo;
	}

	/**
	 * This method initializes jButtonDeleteBackEnd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDeleteBackEnd() {
		if (jButtonDeleteBackEnd == null) {
			jButtonDeleteBackEnd = new JButton();
			jButtonDeleteBackEnd.setBounds(new Rectangle(195, 255, 76, 31));
			jButtonDeleteBackEnd.setText("Delete");
			jButtonDeleteBackEnd.addActionListener(this);

		}
		return jButtonDeleteBackEnd;
	}
	
	


}  //  @jve:decl-index=0:visual-constraint="10,10"
