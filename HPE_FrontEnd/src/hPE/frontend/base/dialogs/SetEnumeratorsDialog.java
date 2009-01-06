package hPE.frontend.base.dialogs;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ListSelectionModel;


public class SetEnumeratorsDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneEnumerators = null;
	private JTable jTableEnumerators = null;
	/**
	 * @param owner
	 */
	
	Map<String,Integer> enumerators = null;

	public SetEnumeratorsDialog(Frame owner, String[] enumerators, int[] enumValuation) {
		super(owner);
		this.enumerators = new HashMap<String,Integer>();
        int i=0;
        if (enumValuation == null) {
        	enumValuation = new int[enumerators.length];
        }
        for (i=0; i<enumerators.length; i++) {
            this.enumerators.put(enumerators[i], enumValuation[i]);
        }
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(231, 194);
		this.setContentPane(getJContentPane());
		this.setTitle("Configure Enumerators");
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneEnumerators(), null);
			jContentPane.add(getJButtonRun(), null);
			jContentPane.add(getJButtonCancel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneEnumerators	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneEnumerators() {
		if (jScrollPaneEnumerators == null) {
			jScrollPaneEnumerators = new JScrollPane(jTableEnumerators);
			jScrollPaneEnumerators.setBounds(new Rectangle(15, 15, 106, 138));
			jScrollPaneEnumerators.setViewportView(getJTableEnumerators());
		}
		return jScrollPaneEnumerators;
	}

	/**
	 * This method initializes jTableEnumerators	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableEnumerators() {
		if (jTableEnumerators == null) {
			String[] columnNames = new String[] {"Name","Value"}; 
			Object[][] data = new Object[this.enumerators.size()][2];
			int i = 0;
			for (Entry<String, Integer> e : this.enumerators.entrySet()) {
				String k = e.getKey();
				Integer v = e.getValue();
				data[i][0] = k;
				data[i][1] = v;
				i++;
			}
			
			jTableEnumerators = new JTable(new EnumeratorsTableModel(columnNames, data));			
			jTableEnumerators.setCellSelectionEnabled(true);
			jTableEnumerators.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableEnumerators.setToolTipText("cardinality of enumerators");
			jTableEnumerators.getColumnModel().getColumn(1).setCellEditor(new IntegerEditor(0));
		}
		return jTableEnumerators;
	}

	class EnumeratorsTableModel extends AbstractTableModel {
	    
		private String[] columnNames;
	    private Object[][] data;
	    
	    public EnumeratorsTableModel(String[] columnNames, Object[][] data) {
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
            return col==1;
	    }

	    public void setValueAt(Object value, int row, int col) {

	    	data[row][col] = value;
            fireTableCellUpdated(row, col);

        }	    
	}

	boolean canceled = false;
	private JButton jButtonRun = null;
	private JButton jButtonCancel = null;
	
	public boolean getCanceled() {
		// TODO Auto-generated method stub
		return canceled;
	}

	private int[] enumValuation = null;
	
	/**
	 * This method initializes jButtonRun	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRun() {
		if (jButtonRun == null) {
			jButtonRun = new JButton();
			jButtonRun.setBounds(new Rectangle(135, 15, 76, 31));
			jButtonRun.setText("Run");
			final JDialog thisDialog = this;
			jButtonRun.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						JTable table = getJTableEnumerators();
					
						TableModel tm = (TableModel) table.getModel();
						enumValuation = new int[tm.getRowCount()];
						for (int i=0; i<tm.getRowCount(); i++) {
						    enumValuation[i] = (Integer) tm.getValueAt(i, 1);
						    if (enumValuation[i] == 0) 
						    	throw new NumberFormatException();
						}
						thisDialog.setVisible(false);
					} catch (NumberFormatException ne) {
						enumValuation = null;
						JOptionPane.showMessageDialog(rootPane, "One or more enumerators are set to zero or non-integer values");
					}
			}});
			
		}
		return jButtonRun;
	}

	/**
	 * This method initializes jButtonCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setBounds(new Rectangle(135, 60, 76, 31));
			jButtonCancel.setText("Cancel");
			final JDialog thisDialog = this;
			jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					canceled = true;
					thisDialog.setVisible(false);
				}
			});
		}
		return jButtonCancel;
	}


	public int[] getEnumValuation() {
		return enumValuation;
	}

	/**
	 * Implements a cell editor that uses a formatted text field
	 * to edit Integer values.
	 */
	public class IntegerEditor extends DefaultCellEditor {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 7893195084763921931L;
		
		JFormattedTextField ftf;
	    NumberFormat integerFormat;
	    private Integer minimum/*, maximum*/;
	    private boolean DEBUG = false;

	    public IntegerEditor(int min /*, int max*/) {
	        super(new JFormattedTextField());
	        ftf = (JFormattedTextField)getComponent();
	        minimum = new Integer(min);
	        // maximum = new Integer(max);

	        //Set up the editor for the integer cells.
	        integerFormat = NumberFormat.getIntegerInstance();
	        NumberFormatter intFormatter = new NumberFormatter(integerFormat);
	        intFormatter.setFormat(integerFormat);
	        intFormatter.setMinimum(minimum);
	        // intFormatter.setMaximum(maximum);

	        ftf.setFormatterFactory(
	                new DefaultFormatterFactory(intFormatter));
	        ftf.setValue(minimum);
	        ftf.setHorizontalAlignment(JTextField.TRAILING);
	        ftf.setFocusLostBehavior(JFormattedTextField.PERSIST);

	        //React when the user presses Enter while the editor is
	        //active.  (Tab is handled as specified by
	        //JFormattedTextField's focusLostBehavior property.)
	        ftf.getInputMap().put(KeyStroke.getKeyStroke(
	                                        KeyEvent.VK_ENTER, 0),
	                                        "check");
	        ftf.getActionMap().put("check", new AbstractAction() {
	            /**
				 * 
				 */
				private static final long serialVersionUID = -1757136867113951279L;

				public void actionPerformed(ActionEvent e) {
			if (!ftf.isEditValid()) { //The text is invalid.
	                    if (userSaysRevert()) { //reverted
			        ftf.postActionEvent(); //inform the editor
			    }
	                } else try {              //The text is valid,
	                    ftf.commitEdit();     //so use it.
	                    ftf.postActionEvent(); //stop editing
	                } catch (java.text.ParseException exc) { }
	            }
	        });
	    }

	    //Override to invoke setValue on the formatted text field.
	    public Component getTableCellEditorComponent(JTable table,
	            Object value, boolean isSelected,
	            int row, int column) {
	        JFormattedTextField ftf =
	            (JFormattedTextField)super.getTableCellEditorComponent(
	                table, value, isSelected, row, column);
	        ftf.setValue(value);
	        return ftf;
	    }

	    //Override to ensure that the value remains an Integer.
	    public Object getCellEditorValue() {
	        JFormattedTextField ftf = (JFormattedTextField)getComponent();
	        Object o = ftf.getValue();
	        if (o instanceof Integer) {
	            return o;
	        } else if (o instanceof Number) {
	            return new Integer(((Number)o).intValue());
	        } else {
	            if (DEBUG) {
	                System.out.println("getCellEditorValue: o isn't a Number");
	            }
	            try {
	                return integerFormat.parseObject(o.toString());
	            }
	            catch (java.text.ParseException e) {
	                System.err.println("getCellEditorValue: can't parse o: " + o);
	                return null;
				}
	        }
	    }

	    //Override to check whether the edit is valid,
	    //setting the value if it is and complaining if
	    //it isn't.  If it's OK for the editor to go
	    //away, we need to invoke the superclass's version 
	    //of this method so that everything gets cleaned up.
	    public boolean stopCellEditing() {
	        JFormattedTextField ftf = (JFormattedTextField)getComponent();
	        if (ftf.isEditValid()) {
	            try {
	                ftf.commitEdit();
	            } catch (java.text.ParseException exc) { }
		    
	        } else { //text is invalid
	            if (!userSaysRevert()) { //user wants to edit
		        return false; //don't let the editor go away
		    } 
	        }
	        return super.stopCellEditing();
	    }

	    /** 
	     * Lets the user know that the text they entered is 
	     * bad. Returns true if the user elects to revert to
	     * the last good value.  Otherwise, returns false, 
	     * indicating that the user wants to continue editing.
	     */
	    protected boolean userSaysRevert() {
	        Toolkit.getDefaultToolkit().beep();	
	        ftf.selectAll();
	        Object[] options = {"Edit",
	                            "Revert"};
	        int answer = JOptionPane.showOptionDialog(
	            SwingUtilities.getWindowAncestor(ftf),
	            "The value must be an integer between "
	            + minimum + " and "
	            // + maximum + ".\n"
	            + "You can either continue editing "
	            + "or revert to the last valid value.",
	            "Invalid Text Entered",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.ERROR_MESSAGE,
	            null,
	            options,
	            options[1]);
		    
	        if (answer == 1) { //Revert!
	            ftf.setValue(ftf.getValue());
		    return true;
	        }
		return false;
	    }
	}	
}  //  @jve:decl-index=0:visual-constraint="220,20"
