package hPE.frontend.base.dialogs;

import hPE.frontend.base.model.HComponent;
import hPE.util.Pair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogChangeVarName extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5247580388611042742L;
	/**
	 * 
	 */
	private JPanel jContentPane = null;
	private JComboBox jComboBoxVarName = null;
	private JTextField jTextFieldNewVarName = null;
	private JButton jButtonSet = null;
	private JButton jButtonClose = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	/**
	 * This is the default constructor
	 * @param c 
	 */
	
	private HComponent c = null;

	public DialogChangeVarName(HComponent c) {
		super();
		this.c = c;
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
		this.setAlwaysOnTop(true);
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
			jComboBoxVarName.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					
					Pair<String, List<HComponent>> item = (Pair<String,List<HComponent>>) getJComboBoxVarName().getSelectedItem();					
					HComponent cVar = item.snd().get(0); 
					String varId = cVar.getVariableName((HComponent) cVar.getConfiguration());
					
					jTextFieldNewVarName.setText(varId);
					
				}});
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
		if (jButtonSet == null) {
			jButtonSet = new JButton();
			jButtonSet.setText("Set");
			jButtonSet.setSize(new java.awt.Dimension(80,25));
			jButtonSet.setLocation(new java.awt.Point(359,15));
			jButtonSet.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (!jTextFieldNewVarName.getText().equals("") && jTextFieldNewVarName.getText() != null) {	            	
	            	   buttonPressed = BUTTON_SET;
	            	   
	       	        Pair<String, List<HComponent>> varToBeChanged = (Pair<String, List<HComponent>>) getOldVarName();
	    	        String newVarName = getNewVarName();
	            	   
                    changeVarName(varToBeChanged, newVarName);
	    	        
	                } else {
	                	JOptionPane.showMessageDialog(null,
	                		    "A Parameter ID must be given.",
	                		    "Invalid Parameter Setup",
	                		    JOptionPane.ERROR_MESSAGE);
	                }
	            }
			});
		}
		return jButtonSet;
	}

	private int buttonPressed = -1;
	
	public int getButtonPressed() { return buttonPressed; }

	public static int BUTTON_SET = 0;
	public static int BUTTON_CLOSE = 1;

	/**
	 * This method initializes jButtonCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancel() {
		if (jButtonClose == null) {
			jButtonClose = new JButton();
			jButtonClose.setText("Close");
			jButtonClose.setSize(new java.awt.Dimension(80,25));
			jButtonClose.setLocation(new java.awt.Point(359,45));
			jButtonClose.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	   buttonPressed = BUTTON_CLOSE;
	            	   setVisible(false);
	            }
			});
		}
		return jButtonClose;
	}
	
    private void changeVarName(Pair<String, List<HComponent>> varToBeChanged, String newVarName) {
        HComponent topC = (HComponent) c.getTopConfiguration();
        
        if (newVarName != null && !newVarName.equals("")) 
        {
            boolean allowed = true;
	        // TODO: TOP LEVEL PARAMETERS ...
	        //	for (HComponent c : varToBeChanged.snd()) {
	        //		allowed &= c.isDirectSonOfTheTopConfiguration();
	        //	}
        		        	
	        if (c.isTopConfiguration() && !allowed) {
	        	JOptionPane.showMessageDialog(null, "Don't make the things more difficult to programmers ! \n It is not allowed to change the name of a non top-level variable !", "Invalid Operation", JOptionPane.ERROR_MESSAGE);
	        } else {		        
	        	for (HComponent innerC : varToBeChanged.snd()) {
	        		//if (!c.isTopConfiguration() && topC.getVars().contains(innerC.getVariableName(c))) {
			        //	JOptionPane.showMessageDialog(null, "Don't make the things more difficult to programmers ! \n It is not allowed to change the name of a bound variable !", "Invalid Operation", JOptionPane.ERROR_MESSAGE);
			        //	break;
			        //} 
	        		
	        		// innerC.setVariableName(newVarName);
	        		String oldVarName = innerC.getVariableName((HComponent) innerC.getTopConfiguration());
	        		HComponent ownerOfinnerC = (HComponent) innerC.getConfiguration();
	        		ownerOfinnerC.changeVariableName(oldVarName, newVarName);
	        		
		        }
	        }
        } else {
        	System.err.println("Invalid Variable Name !! (ChangeVariableNameCommand.execute())");
        	
        }
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
