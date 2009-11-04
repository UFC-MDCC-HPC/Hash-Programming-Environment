package hPE.frontend.base.dialogs;

import java.util.Map;

import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.ComboListener;
import hPE.frontend.base.model.HInterface.ListHBESourceVersion;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionListener implements ListSelectionListener {

	private ListHBESourceVersion l = null;
	private JTable jTable = null;
	
	public SelectionListener(JTable table, ListHBESourceVersion l) {
		this.l = l;
		this.jTable = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		JComboBox theComboBox = l.getComboBox();

		int rowIndex = jTable.getSelectedRow();

		System.out.println(rowIndex);
	    ComboListener.getInstance().setRowIndex(rowIndex);

    	HBESourceVersion<HBEAbstractFile> srcVersion = l.getSourceVersionList().get(rowIndex);
		
	    Map<Integer, String> selectedFileNames = ComboListener.getInstance().getSelectedFileNames();
	    String fileName = selectedFileNames.get(new Integer(rowIndex));

	    theComboBox.setEnabled(false);
		theComboBox.removeAllItems();
	    for (HBEAbstractFile file : srcVersion.getFiles()) {
		     theComboBox.addItem(file.getFileName());	
	    }
	    theComboBox.setEnabled(true);
	    
	    
	    if (fileName != null && !fileName.equals("")) {
	       selectedFileNames.put(new Integer(rowIndex), fileName);
	       theComboBox.setSelectedItem(fileName);
	    } else {
	       theComboBox.setSelectedIndex(0);
	    }
	    
	    

	}

}
