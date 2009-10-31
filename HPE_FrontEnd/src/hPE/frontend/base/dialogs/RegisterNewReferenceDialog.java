package hPE.frontend.base.dialogs;

import hPE.frontend.base.dialogs.AddReferencesDialog.Reference;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class RegisterNewReferenceDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JEditorPane jEditorPaneDescription = null;
	private JLabel jLabelDetailedName = null;
	private JLabel jLabelDescription = null;
	private JLabel jLabelPath = null;
	private JLabel jLabelRequired = null;
	private JTextField jTextFieldDetailedName = null;
	private JTextField jTextFieldLocalPath = null;
	private JButton jButtonRegister = null;
	private JButton jButtonCancel = null;
	private JButton jButtonFileChooser = null;

	private Reference ref = null;
	
	/**
	 * @param owner
	 */
	public RegisterNewReferenceDialog(Frame owner) {
		super(owner);
		this.setRef(ref);
		initialize();		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(411, 267);
		this.setTitle("Register New Reference");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelRequired = new JLabel();
			jLabelRequired.setBounds(new Rectangle(15, 95, 266, 16));
			jLabelRequired.setFont(new Font("Dialog", Font.BOLD, 10));
			jLabelRequired.setText("* Required for compilation of units.");
			jLabelPath = new JLabel();
			jLabelPath.setBounds(new Rectangle(15, 60, 266, 16));
			jLabelPath.setText("Local Path*");
			jLabelDescription = new JLabel();
			jLabelDescription.setBounds(new Rectangle(15, 120, 266, 16));
			jLabelDescription.setText("Description");
			jLabelDetailedName = new JLabel();
			jLabelDetailedName.setBounds(new Rectangle(15, 15, 266, 16));
			jLabelDetailedName.setText("Name (will append \".dll\")");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJEditorPaneDescription(), null);
			jContentPane.add(jLabelDetailedName, null);
			jContentPane.add(jLabelDescription, null);
			jContentPane.add(jLabelPath, null);
			jContentPane.add(jLabelRequired, null);
			jContentPane.add(getJTextFieldDetailedName(), null);
			jContentPane.add(getJTextFieldLocalPath(), null);
			jContentPane.add(getJButtonFileChooser(), null);
			jContentPane.add(getJButtonRegister(), null);
			jContentPane.add(getJButtonCancel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jEditorPaneDescription	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPaneDescription() {
		if (jEditorPaneDescription == null) {
			jEditorPaneDescription = new JEditorPane();
			jEditorPaneDescription.setBounds(new Rectangle(15, 135, 266, 86));
		}
		return jEditorPaneDescription;
	}

	/**
	 * This method initializes jTextFieldDetailedName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDetailedName() {
		if (jTextFieldDetailedName == null) {
			jTextFieldDetailedName = new JTextField();
			jTextFieldDetailedName.setBounds(new Rectangle(15, 30, 265, 21));
		}
		return jTextFieldDetailedName;
	}

	/**
	 * This method initializes jTextFieldLocalPath	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLocalPath() {
		if (jTextFieldLocalPath == null) {
			jTextFieldLocalPath = new JTextField();
			jTextFieldLocalPath.setBounds(new Rectangle(15, 75, 266, 21));
		}
		return jTextFieldLocalPath;
	}

	/**
	 * This method initializes JButtonFileChooser	
	 * 	
	 * @return javax.swing.JFileChooser
	 */
	private JButton getJButtonFileChooser() {
		if (jButtonFileChooser == null) {
			jButtonFileChooser = new JButton();
			jButtonFileChooser.setBounds(new Rectangle(285, 30, 116, 31));
			jButtonFileChooser.setToolTipText("Opens a file dialog.");
			jButtonFileChooser.setText("File");
			jButtonFileChooser.addActionListener(this);
		}
		return jButtonFileChooser;
	}
	
	/**
	 * This method initializes jButtonRegister	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRegister() {
		if (jButtonRegister == null) {
			jButtonRegister = new JButton();
			jButtonRegister.setBounds(new Rectangle(285, 155, 116, 31));
			jButtonRegister.setToolTipText("Register a new reference with the provided data and exit.");
			jButtonRegister.setText("Register");
			jButtonRegister.addActionListener(this);
		}
		return jButtonRegister;
	}

	/**
	 * This method initializes jButtonCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setBounds(new Rectangle(285, 190, 116, 31));
			jButtonCancel.setToolTipText("Ignore provided data and exit.");
			jButtonCancel.setText("Cancel");
			jButtonCancel.addActionListener(this);
		}
		return jButtonCancel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		
		if(source == this.getJButtonFileChooser()) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("DLL files", "dll", "DLL");
			int returnVal;
			
			fileChooser.addChoosableFileFilter(fileFilter);
			fileChooser.setAcceptAllFileFilterUsed(false);
			returnVal = fileChooser.showOpenDialog(this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				String completePath = file.getPath();
				String localPath = completePath.substring(0, completePath.lastIndexOf(File.separatorChar)+1);
				String detailedName = completePath.substring(completePath.lastIndexOf(File.separatorChar)+1, completePath.length()-4);
				
				this.getJTextFieldDetailedName().setText(detailedName);
				this.getJTextFieldLocalPath().setText(localPath);				
			}
		}
		
		if (source == this.getJButtonRegister()) {
			String name = this.getJTextFieldDetailedName().getText();
			String pathStr = this.getJTextFieldLocalPath().getText();
			String desciption = this.getJEditorPaneDescription().getText();
			
		  if (testFile(name,pathStr)) {
			   this.setRef(new Reference(name, new File(pathStr), desciption, true));
			   result = JOptionPane.OK_OPTION;
			   this.setVisible(false);
		  } else {
			  JOptionPane.showMessageDialog(null, "File " + name + ".dll not found in " + pathStr + " !", "New Reference Not Found", JOptionPane.ERROR_MESSAGE);
		  }
		} else if (source == this.getJButtonCancel()) {
		   result = JOptionPane.CANCEL_OPTION;
		   this.setVisible(false);
		}
		
	}
	

	private boolean testFile(String name, String pathStr) {
		IPath path = new Path(pathStr);
		path = path.append(name + ".dll");
		File file = new File(path.toString());
		return file.exists();
	}

	public int getResult() {
		return result;
	}

	private void setRef(Reference ref) {
		this.ref = ref;
	}

	public Reference getRef() {
		return ref;
	}

	private int result = JOptionPane.OK_CANCEL_OPTION;
	
	


}  //  @jve:decl-index=0:visual-constraint="10,10"
