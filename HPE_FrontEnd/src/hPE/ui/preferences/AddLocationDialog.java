package hPE.ui.preferences;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @since Created on Jul 04, 2011
 * @author Juliano Efson Sales
 */

/*
 * This code was based on FileAssociateInputDlg.java
 */
public class AddLocationDialog extends Dialog {

	protected StringFieldEditor addessField;

	protected StringFieldEditor keyField;

	protected StringFieldEditor loginField;

	protected StringFieldEditor passwordField;

	protected String address;

	protected String key;

	protected String login;

	protected String password;

	public static final int CANCEL = -17;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 */
	public AddLocationDialog(Shell parentShell, String key, String address) {
		super(parentShell);
		this.key = key;
		this.address = address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets
	 * .Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		getShell().setText("Add/Edit Location");
		//getShell().setImage(new Image("icons/sample.gif")); //$NON-NLS-1$

		GridData data = new GridData();
		data.widthHint = 700;

		Composite dlgArea = (Composite) super.createDialogArea(parent);
		Composite comp = new Composite(dlgArea, SWT.NONE);
		comp.setLayoutData(data);

		keyField = new StringFieldEditor("key", "Location Key: ", comp);

		addessField = new StringFieldEditor("addess", "Location URI: ", comp);

		loginField = new StringFieldEditor("login", "Login: ", comp);

		passwordField = new StringFieldEditor("password", "Password: ", comp);

		if (key != null) {
			keyField.setStringValue(key);
		}

		if (address != null) {
			addessField.setStringValue(address);
		}

		if (login != null) {
			loginField.setStringValue(login);
		}

		if (password != null) {
			passwordField.setStringValue(password);
		}

		return dlgArea;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	protected void okPressed() {
		if (keyField.getStringValue() != null
				&& !keyField.getStringValue().trim().equals("")
				&& addessField.getStringValue() != null
				&& !addessField.getStringValue().trim().equals("")) {
			address = this.addessField.getStringValue();
			key = this.keyField.getStringValue();
			login = this.loginField.getStringValue();
			password = this.passwordField.getStringValue();
			super.okPressed();
			setReturnCode(0);
		} else {
			MessageDialog message = new MessageDialog(getShell(), "Error!",
					null, "The key and URI values are required!",
					MessageDialog.INFORMATION, new String[] { "Ok" }, 0);
			message.open();
			message.close();
		}
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
		setReturnCode(CANCEL);
	}

	public boolean close() {
		keyField.dispose();
		addessField.dispose();
		loginField.dispose();
		passwordField.dispose();

		return super.close();
	}

	public String getAddress() {
		return address;
	}

	public String getKey() {
		return key;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
}