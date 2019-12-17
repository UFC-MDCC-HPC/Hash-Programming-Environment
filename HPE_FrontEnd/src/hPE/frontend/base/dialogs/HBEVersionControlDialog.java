package hPE.frontend.base.dialogs;

import hPE.HPEVersionEditor;
import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterface.ListHBESourceVersion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


public class HBEVersionControlDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2656379304120849626L;
	private JPanel jContentPane = null;
	private JTable jTable = null;
	private JPanel jPanel = null;
	private JButton jButtonRefs = null;
	private JButton jButton2 = null;
	private JButton jButtonSair = null;
	
	
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
    	for (HBEAbstractSynthesizer s : listSynthesizers) {
    		this.typesOfSourceV.put(s.toString(),s);
    	}
    	
    }
	
	/**
	 * This method initializes this
	 * @param onlyEdit TODO
	 * 
	 * @return void
	 */
	private void initialize(boolean onlyEdit) {

		this.addSynthesizers(i.getSupportedSynthesizers());
		
		this.setSize(384, 151);
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
  		    
		    JComboBox comboBox = new JComboBox(typesOfSource);		    

		    ListHBESourceVersion l = i.getSourceVersionList();
  		    l.reset();
			jTable = new JTable(l);
			l.setTable(jTable);
		    jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    
			ListSelectionModel selectionModel = jTable.getSelectionModel();
			selectionModel.addListSelectionListener((ListSelectionListener) new SelectionListener(jTable, l));
		    
		    
		    // jTable.setCellSelectionEnabled(true);

		    comboBox.addComponentListener(new ComponentAdapter() {
		      public void componentShown(ComponentEvent e) {
		        final JComponent c = (JComponent)e.getSource();
		        SwingUtilities.invokeLater(new Runnable() {
		          public void run () {
		            c.requestFocus();
		          }
		        });
		      }
		    });
		 

		    TableColumn c = jTable.getColumn("Source Type");
		    c.setCellEditor(new DefaultCellEditor(comboBox));
		

		    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();  
		    renderer.setToolTipText("Click here to select source type ...");  
		    comboBox.setName("Source Type");  
		    c.setCellRenderer(renderer);
		    try {
		    if (jTable.getRowCount() > 0) {
		        jTable.changeSelection(0, 0, false, false);		        
		        jTable.setRowSelectionInterval(0, 0);
		    }
		    } catch (Exception e) {
		    	System.out.print(".");
		    }

	     }
		return jTable;
	}

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
			jPanel.add(getJButtonRefs(), null);
			jPanel.add(getJButton2(), null);
			jPanel.add(getJButtonSair(), null);
			if (!onlyEdit)  {
			}
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Open");
			jButton2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (jTable.getSelectedColumn()>=0 && getSeletectedSourceType() != null) {
	            	   buttonPressed = BUTTON_EDIT;
	            	   setVisible(false);            	
	            	   i.getSourceVersionList().clear();
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
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRefs() {
		if (jButtonRefs == null) {
			jButtonRefs = new JButton();
			jButtonRefs.setText("References");
			jButtonRefs.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (jTable.getSelectedColumn()>=0) {
	            		  int row = jTable.getSelectedRow();
	            		  HBESourceVersion version = (HBESourceVersion) jTable.getValueAt(row, 0);
	            		  String fileName = (String) jTable.getValueAt(row, 2);

	            		  
	            		  HBEAbstractSourceCodeFile ff = null;
	            		  for (HBEAbstractSourceCodeFile f : version.getFiles()) {
	            			  if (f.getFileName().equals(fileName)) {
	            				  ff = f;
	            			  }
	            		  }
	            		  if (ff != null) {
		            		  AddReferencesDialog dialog = new AddReferencesDialog(null, ff);
		            		  dialog.setAlwaysOnTop(true);
		            		  dialog.setModal(true);
		            		  dialog.setVisible(true);
		            		  ff.addExternalReferences(dialog.getSelectedReferences());
	            		  } else {
	            			  JOptionPane.showMessageDialog(null, "File " + fileName + " not found.", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
	            		  }
	            		  // addExternalReferences(dialog.getSelectedReferences());
	            	} else {
	                	JOptionPane.showMessageDialog(null,
	                		    "A source version must be selected.",
	                		    "Source Version Error",
	                		    JOptionPane.ERROR_MESSAGE);
	            	}
	                
	            }
			});
		}
		return jButtonRefs;
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
	
	private Map<String,HBEAbstractSynthesizer> typesOfSourceV = new HashMap<String,HBEAbstractSynthesizer>();  //  @jve:decl-index=0:
		
	public HBEAbstractSynthesizer getSeletectedSourceType() {
		String v = (String) getJTable().getValueAt(jTable.getSelectedRow(),1);
		return (HBEAbstractSynthesizer) this.typesOfSourceV.get(v);
	}
	
	public HBESourceVersion getSelectedSourceVersion () {
		return (HBESourceVersion) getJTable().getValueAt(jTable.getSelectedRow(),0);
	}
	
	private int buttonPressed = -1;
	
	public int getButtonPressed() { return buttonPressed; }
	
	
	public static int BUTTON_EXIT = 0;
	public static int BUTTON_EDIT = 1;
	
	/**
	 * This method initializes jButtonSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSair() {
		if (jButtonSair == null) {
			jButtonSair = new JButton();
			jButtonSair.setText("Cancel");
			jButtonSair.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	   buttonPressed = BUTTON_EXIT;
	            	   setVisible(false);
	            	   i.getSourceVersionList().clear();
	            }
			});
		}
		return jButtonSair;
	}
	
	
	
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
