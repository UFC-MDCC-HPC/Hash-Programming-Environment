package hPE.frontend.base.model;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTable;

public class ComboListener implements ItemListener {

	private int rowIndex;
	
	public ComboListener() {
	}

	private JComboBox combo = null;
	
	@Override
	public void itemStateChanged(ItemEvent e) {			
		
		if (getCombo() != null && getCombo().getSelectedItem() != null && jtable.getSelectedRow() == rowIndex) {
			System.out.println("1: " + this.getSelectedFileNames() + "rowIndex = " + rowIndex);
			this.getSelectedFileNames().put(new Integer(rowIndex), getCombo().getSelectedItem().toString());
			System.out.println("2: " + this.getSelectedFileNames());
		}
	}
	
	private static ComboListener listener = null;
	
	public static ComboListener getInstance() {
		if (listener == null) {
		   listener = new ComboListener();
		}
		return listener;				
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getRowIndex() {
		return rowIndex;
	}
	
	public void setSelectedFileNames(Map<Integer, String> selectedFileNames) {
		this.selectedFileNames = selectedFileNames;
	}

	public Map<Integer, String> getSelectedFileNames() {
		return selectedFileNames;
	}

	public void setCombo(JComboBox combo) {
		this.combo = combo;
	}

	public JComboBox getCombo() {
		return combo;
	}

	private Map<Integer, String> selectedFileNames;

	private JTable jtable;
	
	public void setTable(JTable table) {
       this.jtable = table;
		
	}
}
