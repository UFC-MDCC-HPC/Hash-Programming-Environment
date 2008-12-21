package hPE.frontend.dialogs.base;

import hPE.HPEVersionEditor;
import hPE.backend.cluster.synthesizer.HBEAbstractFile;
import hPE.backend.cluster.synthesizer.HBEAbstractSynthesizer;
import hPE.backend.cluster.synthesizer.HBESourceVersion;
import hPE.backend.cluster.synthesizer.C.HBESynthesizerDataTypeRawForC;
import hPE.backend.cluster.synthesizer.C.HBESynthesizerForC;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;
import java.awt.FlowLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

import hPE.model.base.HInterface;

import javax.swing.JTextField;


public class HBEVersionControlDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2656379304120849626L;
	private JPanel jContentPane = null;
	private JTable jTable = null;
	private JPanel jPanel = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;

	/**
	 * This is the default constructor
	 * @param onlyEdit TODO
	 */
	public HBEVersionControlDialog(HInterface i, boolean onlyEdit) {
		super();
		this.i = i;
		this.editor = editor;		
		initialize(onlyEdit);
	}
	
	private HPEVersionEditor editor;
	
	private HInterface i;

    public void addSynthesizers(List<HBEAbstractSynthesizer> listSynthesizers) {
    	this.typesOfSource.addAll(listSynthesizers);
    	
    }
	
	/**
	 * This method initializes this
	 * @param onlyEdit TODO
	 * 
	 * @return void
	 */
	private void initialize(boolean onlyEdit) {

		this.addSynthesizers(i.getSupportedSynthesizers());
		
		this.setSize(672, 151);
		this.setContentPane(getJContentPane(onlyEdit));
		this.setTitle("Version Control for ".concat(i.getName(false,true)));
		
	}

	/**
	 * This method initializes jContentPane
	 * @param onlyEdit TODO
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane(boolean onlyEdit) {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTable().getTableHeader(), BorderLayout.PAGE_START);
			jContentPane.add(getJTable(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel(onlyEdit), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(i.getSourceVersionList());
			
			TableColumn  column0 = jTable.getColumnModel().getColumn(0);

			// Set properties of the 1st column.
			
			TableColumn  column1 = jTable.getColumnModel().getColumn(1);
			
			// Set properties of the 2nd column.
			 
			
		}
		return jTable;
	}

	private JComboBox jComboBox = null;
	private JTextPane jTextPane = null;
	/**
	 * This method initializes jPanel	
	 * @param onlyEdit TODO
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel(boolean onlyEdit) {
		if (jPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.RIGHT);
			jPanel = new JPanel();
			jPanel.setLayout(flowLayout);
			jPanel.add(getJTextPane1(), null);
			jPanel.add(getJComboBox(), null);
			if (!onlyEdit)  {
				jPanel.add(getJTextPane(), null);
				jPanel.add(getJTextField(), null);
				jPanel.add(getJButton1(), null);
			}
			jPanel.add(getJButton2(), null);
			jPanel.add(getJButton3(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("New");
			jButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (!jTextField.getText().equals("") && jTextField.getText() != null) {	            	
	            	   buttonPressed = BUTTON_NEW;
	            	   setVisible(false);
	                } else {
	                	JOptionPane.showMessageDialog(null,
	                		    "A Version ID must be given.",
	                		    "VersionID Error",
	                		    JOptionPane.ERROR_MESSAGE);
	                }
	            }
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Edit");
			jButton2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (jTable.getSelectedColumn()>=0) {
	            	   buttonPressed = BUTTON_EDIT;
	            	   setVisible(false);            	
	            	} else {
	                	JOptionPane.showMessageDialog(null,
	                		    "A source version must be selected.",
	                		    "Source Version Error",
	                		    JOptionPane.ERROR_MESSAGE);
	            	}
	                
	            }
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Delete");
			jButton3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (jTable.getSelectedColumn()>=0) {
  	            	   buttonPressed = BUTTON_DELETE;
	            	   setVisible(false);
	            	} else {
	                	JOptionPane.showMessageDialog(null,
	                		    "A source version must be selected.",
	                		    "Source Version Error",
	                		    JOptionPane.ERROR_MESSAGE);
	            	}
	            }
			});
		}
		return jButton3;
	}
	
	public void addLine() {
		
	}

	/**
	 * This method initializes jComboBox	
	 * @return   javax.swing.JComboBox
	 * @uml.property   name="typesOfSource"
	 * @uml.associationEnd   multiplicity="(0 -1)" elementType="hPE.backend.cluster.synthesizer.HBEAbstractSynthesizer"
	 */
	
	private Vector<HBEAbstractSynthesizer> typesOfSource = new Vector<HBEAbstractSynthesizer>();
		
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			   jComboBox = new JComboBox(typesOfSource);
  			   jComboBox.setPreferredSize(new java.awt.Dimension(180,25));
			   jComboBox.setSelectedIndex(0);			
		}
		return jComboBox;
	}
	
	public HBEAbstractSynthesizer getSeletectedSourceType() {
		return (HBEAbstractSynthesizer) getJComboBox().getSelectedItem();
	}
	
	public HBESourceVersion<HBEAbstractFile> getSelectedSourceVersion () {
		return (HBESourceVersion<HBEAbstractFile>) getJTable().getValueAt(jTable.getSelectedRow(),0);
	}

	public String getVersionID () {
		return (String) getJTextField().getText();
	}
	
	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBackground(new java.awt.Color(238,238,238));
			jTextPane.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
			jTextPane.setText("Version ID:");
		}
		return jTextPane;
	}
	
	
	private int buttonPressed = -1;
	
	public int getButtonPressed() { return buttonPressed; }
	
	
	public static int BUTTON_NEW = 0;
	public static int BUTTON_EDIT = 1;
	public static int BUTTON_DELETE = 2;
	private JTextField jTextField = null;
	private JTextPane jTextPane1 = null;

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setPreferredSize(new java.awt.Dimension(100,20));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextPane1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setBackground(new java.awt.Color(238,238,238));
			jTextPane1.setText("Type of Source:");
			jTextPane1.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
		}
		return jTextPane1;
	}
	
	
	
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
