package hPE.frontend.edits.policies.base;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class Teste2 {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Table tableVersion = null;
	private Button buttonNew = null;
	private Button buttonEdit = null;
	private Button buttonDelete = null;
	private Combo comboSourceType = null;
	private Text text = null;
	private Label label = null;
	private Label label1 = null;

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Source Version Control");
		createTableVersion();
		sShell.setSize(new org.eclipse.swt.graphics.Point(497,200));
		buttonNew = new Button(sShell, SWT.NONE);
		buttonNew.setBounds(new org.eclipse.swt.graphics.Rectangle(270,129,66,23));
		buttonNew.setText("New");
		buttonEdit = new Button(sShell, SWT.NONE);
		buttonEdit.setBounds(new org.eclipse.swt.graphics.Rectangle(344,128,68,23));
		buttonEdit.setText("Edit");
		buttonDelete = new Button(sShell, SWT.NONE);
		buttonDelete.setBounds(new org.eclipse.swt.graphics.Rectangle(419,128,58,23));
		buttonDelete.setText("Delete");
		createComboSourceType();
		text = new Text(sShell, SWT.BORDER);
		text.setBounds(new org.eclipse.swt.graphics.Rectangle(27,129,76,19));
		label = new Label(sShell, SWT.NONE);
		label.setBounds(new org.eclipse.swt.graphics.Rectangle(165,113,93,16));
		label.setText("Source Type");
		label1 = new Label(sShell, SWT.NONE);
		label1.setBounds(new org.eclipse.swt.graphics.Rectangle(28,115,76,13));
		label1.setText("Version ID");
	}

	/**
	 * This method initializes tableVersion	
	 *
	 */
	private void createTableVersion() {
		tableVersion = new Table(sShell, SWT.NONE);
		tableVersion.setHeaderVisible(true);
		tableVersion.setLinesVisible(true);
		tableVersion.setBounds(new org.eclipse.swt.graphics.Rectangle(26,14,451,92));
	}

	/**
	 * This method initializes comboSourceType	
	 *
	 */
	private void createComboSourceType() {
		comboSourceType = new Combo(sShell, SWT.NONE);
		comboSourceType.setBounds(new org.eclipse.swt.graphics.Rectangle(165,128,93,21));
		
		
		
	}

	
	
}
