package hPE.frontend.dialogs.base;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SetParameterDialog extends JDialog {

	private JPanel jContentPane = null;
	private JPanel jPanelParameterIdentifier = null;
	private JLabel jLabelParameterId = null;
	private JTextField jTextFieldParameterId = null;
	private JPanel jPanelButtons = null;
	private JButton jButtonOK = null;
	private JButton jButtonCancel = null;
	/**
	 * This is the default constructor
	 */
	public SetParameterDialog() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(324, 100);
		this.setTitle("Parameter Configuration");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanelParameterIdentifier(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJPanelButtons(), java.awt.BorderLayout.EAST);
		}
		return jContentPane;
	}



	/**
	 * This method initializes jPanelParameterIdentifier	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelParameterIdentifier() {
		if (jPanelParameterIdentifier == null) {
			jLabelParameterId = new JLabel();
			jLabelParameterId.setText("Parameter Identifier");
			jPanelParameterIdentifier = new JPanel();
			jPanelParameterIdentifier.add(jLabelParameterId, null);
			jPanelParameterIdentifier.add(getJTextFieldParameterId(), null);
		}
		return jPanelParameterIdentifier;
	}	/**
	 * This method initializes jTextFieldParameterId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldParameterId() {
		if (jTextFieldParameterId == null) {
			jTextFieldParameterId = new JTextField();
			jTextFieldParameterId.setText("                                                       ");
		}
		return jTextFieldParameterId;
	}

	/**
	 * This method initializes jPanelButtons	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelButtons() {
		if (jPanelButtons == null) {
			jPanelButtons = new JPanel();
			jPanelButtons.add(getJButtonOK(), null);
			jPanelButtons.add(getJButtonCancel(), null);
		}
		return jPanelButtons;
	}

	private int buttonPressed = -1;
	
	public int getButtonPressed() { return buttonPressed; }

	public static int BUTTON_OK = 0;
	public static int BUTTON_CANCEL = 1;

	/**
	 * This method initializes jButtonOK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("Ok");
			jButtonOK.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (!jTextFieldParameterId.getText().equals("") && jTextFieldParameterId.getText() != null) 
	            	{	            	
	            	   buttonPressed = BUTTON_OK;
	            	   setVisible(false);
	                } else {
	                	JOptionPane.showMessageDialog(null,
	                		    "A Parameter ID must be given and a type quantification must be selected.",
	                		    "Invalid Parameter Setup",
	                		    JOptionPane.ERROR_MESSAGE);
	                }
	            }
			});
		}
		return jButtonOK;
	}

	/**
	 * This method initializes jButtonCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("Cancel");
			jButtonCancel.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	   buttonPressed = BUTTON_CANCEL;
	            	   setVisible(false);
	            }
			});
		}
		return jButtonCancel;
	}


	public String getParId() {
		return jTextFieldParameterId.getText();
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
