package hPE.ui.preferences;

import hPE.HPEPlugin;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * 
 * @author Juliano Efson Sales
 * 
 */

public class HPEPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public HPEPreferencePage() {
		super(GRID);
		setPreferenceStore(HPEPlugin.getDefault().getPreferenceStore());
		setDescription("General HPE preferences.\n\nCurrent OS: "
				+ System.getProperty("os.name") + "\n\n");
		
		new PreferenceInitializer().initializeDefaultPreferences();
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		DirectoryFieldEditor hpe = new DirectoryFieldEditor(
				PreferenceConstants.HPE_HOME, PreferenceConstants.HPE_HOME_D,
				getFieldEditorParent());
		addField(hpe);

		DirectoryFieldEditor mono = new DirectoryFieldEditor(
				PreferenceConstants.MONO_BIN_PATH,
				PreferenceConstants.MONO_BIN_PATH_D, getFieldEditorParent());
		addField(mono);

		StringFieldEditor xreferences = new StringFieldEditor(
				PreferenceConstants.EXTERNAL_REFERENCES_XML,
				PreferenceConstants.EXTERNAL_REFERENCES_XML_D,
				getFieldEditorParent());
		addField(xreferences);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}