package hPE.frontend.base.dialogs;

import javax.swing.JOptionPane;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;

public class NewVersionShell {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="232,38"
	private Spinner spinner1 = null;
	private Spinner spinner2 = null;
	private Spinner spinner3 = null;
	private Spinner spinner4 = null;
	private List listVersions = null;
	private Button buttonAdd = null;
	private Button buttonRemove = null;
	private Button buttonOK = null;
	private Button buttonCancel = null;
	
	private NewVersionShell me = this;
	
	public NewVersionShell(HComponent c) {
		createSShell(c);
	}
	
	/**
	 * This method initializes sShell
	 * @param c 
	 */
	private void createSShell(HComponent c) {
		sShell = new Shell(SWT.ON_TOP | SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		sShell.setText("Manage Versions");
		sShell.setLayout(null);
		sShell.setVisible(true);
		sShell.setSize(new Point(261, 140));
		spinner1 = new Spinner(sShell, SWT.NONE);
		spinner1.setBounds(new Rectangle(5, 5, 41, 17));
		spinner2 = new Spinner(sShell, SWT.NONE);
		spinner2.setBounds(new Rectangle(51, 5, 41, 17));
		spinner3 = new Spinner(sShell, SWT.NONE);
		spinner3.setBounds(new Rectangle(97, 5, 41, 17));
		spinner4 = new Spinner(sShell, SWT.NONE);
		spinner4.setBounds(new Rectangle(143, 5, 41, 17));
		listVersions = new List(sShell, SWT.NONE);
		listVersions.setBounds(new Rectangle(75, 30, 109, 68));
		buttonAdd = new Button(sShell, SWT.NONE);
		buttonAdd.setBounds(new Rectangle(40, 30, 31, 23));
		buttonAdd.setText(">");
		buttonAdd.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				String v =HInterface.toStringVersion(new Integer[] {spinner1.getSelection(), spinner2.getSelection(), spinner2.getSelection(), spinner4.getSelection()});
				if (!(listVersions.indexOf(v) >= 0)) 
					listVersions.add(v);
				else {
					JOptionPane.showMessageDialog(null, "Version already registered !", "Alert !", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buttonRemove = new Button(sShell, SWT.NONE);
		buttonRemove.setBounds(new Rectangle(40, 55, 31, 23));
		buttonRemove.setText("<");
		buttonRemove
		.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				if (listVersions.getItemCount() > 1) {
				   listVersions.remove(listVersions.getSelectionIndex());
				} else {
					JOptionPane.showMessageDialog(null, "At least one version must exist !", "Alert !", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buttonOK = new Button(sShell, SWT.NONE);
		buttonOK.setBounds(new Rectangle(190, 5, 56, 32));
		buttonOK.setText("Exit");
		buttonOK.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				buttonPressed = BUTTON_EXIT;
				me.c.setVersions(me.getVersions());
				sShell.close();
			}
		});
		buttonCancel = new Button(sShell, SWT.NONE);
		buttonCancel.setBounds(new Rectangle(190, 40, 56, 31));
		buttonCancel.setText("Cancel");
		buttonCancel
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						buttonPressed = BUTTON_CANCEL;
						sShell.close();
					}
				});
		this.c = c;
		this.addVersions(this.c.getVersions());
	}

	private HComponent c = null;  //  @jve:decl-index=0:
	
	public static int BUTTON_EXIT = 0;
	public static int BUTTON_CANCEL = 1;
	
	private int buttonPressed = BUTTON_CANCEL;
	
	public int getButtonPressed() {
	    return buttonPressed;   	
	}
	
	public java.util.List<Integer[]> getVersions() {
		
		java.util.List<Integer[]> l = new java.util.ArrayList<Integer[]>();
		
		for (String v : listVersions.getItems()) {
			l.add(HInterface.toVersion(v));
			
		}
		return l;
	}
	
	public void addVersions(java.util.List<Integer[]> versions) {
		for (Integer[] v : versions) {
			listVersions.add(HInterface.toStringVersion(v));
		}
			
	}


}
