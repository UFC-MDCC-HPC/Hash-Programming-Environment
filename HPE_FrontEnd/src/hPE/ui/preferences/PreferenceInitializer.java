package hPE.ui.preferences;

import hPE.HPEPlugin;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 * 
 * @author Juliano Efson Sales
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = HPEPlugin.getDefault().getPreferenceStore();

		String defaultHpeHome = System.getProperty("user.home")
				+ System.getProperty("file.separator") + "hpe";

		store.setDefault(PreferenceConstants.HPE_HOME, defaultHpeHome);
		store.setDefault(PreferenceConstants.EXTERNAL_REFERENCES_XML,
				defaultHpeHome + System.getProperty("file.separator")
						+ "references.xml");

		// Default values for WIN
		//TODO valor padr‹o para o Win.
		store.setDefault(PreferenceConstants.WIN
				+ PreferenceConstants.MONO_BIN_PATH, "");

		// Default values for MAC
		store.setDefault(PreferenceConstants.MACOS
				+ PreferenceConstants.MONO_BIN_PATH,
				"/Library/Frameworks/Mono.framework/Versions/Current/bin");

		// Default values for UNIX (default os)
		//TODO valor padr‹o para o Win.
		store.setDefault(PreferenceConstants.UNIX
				+ PreferenceConstants.MONO_BIN_PATH, "");
	}
}
