package hPE.frontend.base.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DialogChangeVarName extends JDialog {

	private JPanel jContentPane = null;
	private JComboBox jComboBoxVarName = null;
	private JTextField jTextFieldNewVarName = null;
	private JButton jButtonOK = null;
	private JButton jButtonCancel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	/**
	 * This is the default constructor
	 */
	public DialogChangeVarName() {
		super();
		initialize();
	}
	
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(464, 124);
		this.setResizable(false);
		this.setLocation(new java.awt.Point(100,100));
		this.setModal(true);
		this.setTitle("Change Parameter Name");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("New Variable Name");
			jLabel2.setSize(new java.awt.Dimension(153,25));
			jLabel2.setLocation(new java.awt.Point(178,15));
			jLabel1 = new JLabel();
			jLabel1.setText("Current Variable Name");
			jLabel1.setSize(new java.awt.Dimension(154,25));
			jLabel1.setLocation(new java.awt.Point(14,15));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJComboBoxVarName(), null);
			jContentPane.add(getJTextFieldNewVarName(), null);
			jContentPane.add(getJButtonOK(), null);
			jContentPane.add(getJButtonCancel(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBoxVarName	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxVarName() {
		if (jComboBoxVarName == null) {
			jComboBoxVarName = new JComboBox();
			jComboBoxVarName.setLocation(new java.awt.Point(15,47));
			jComboBoxVarName.setSize(new java.awt.Dimension(153,25));
		}
		return jComboBoxVarName;
	}

	/**
	 * This method initializes jTextFieldNewVarName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNewVarName() {
		if (jTextFieldNewVarName == null) {
			jTextFieldNewVarName = new JTextField();
			jTextFieldNewVarName.setLocation(new java.awt.Point(177,47));
			jTextFieldNewVarName.setSize(new java.awt.Dimension(153,25));
		}
		return jTextFieldNewVarName;
	}
	
	public void addVarName(Object varName) {
		 this.jComboBoxVarName.addItem(varName);
		
	}

	public Object getOldVarName() {
		return this.jComboBoxVarName.getSelectedItem();
	}
	
	public String getNewVarName() {
		return this.jTextFieldNewVarName.getText();
	}

	/**
	 * This method initializes jButtonOK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("Ok");
			jButtonOK.setSize(new java.awt.Dimension(80,25));
			jButtonOK.setLocation(new java.awt.Point(359,15));
			jButtonOK.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (!jTextFieldNewVarName.getText().equals("") && jTextFieldNewVarName.getText() != null) {	            	
	            	   buttonPressed = BUTTON_OK;
	            	   setVisible(false);
	                } else {
	                	JOptionPane.showMessageDialog(null,
	                		    "A Parameter ID must be given.",
	                		    "Invalid Parameter Setup",
	                		    JOptionPane.ERROR_MESSAGE);
	                }
	            }
			});
		}
		return jButtonOK;
	}

	private int buttonPressed = -1;
	
	public int getButtonPressed() { return buttonPressed; }

	public static int BUTTON_OK = 0;
	public static int BUTTON_CANCEL = 1;

	/**
	 * This method initializes jButtonCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("Cancel");
			jButtonCancel.setSize(new java.awt.Dimension(80,25));
			jButtonCancel.setLocation(new java.awt.Point(359,45));
			jButtonCancel.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	   buttonPressed = BUTTON_CANCEL;
	            	   setVisible(false);
	            }
			});
		}
		return jButtonCancel;
	}
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
