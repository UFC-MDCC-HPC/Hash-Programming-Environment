package hPE.ui.preferences;

/**
 * 
 * @author Juliano Efson Sales
 * @since Aug 2011
 */
public class BackendPreferencePage extends AddressConfigurationPreferencePage {

	public BackendPreferencePage() {
		super(HPEPreferenceStore.BACKEND);
		setDescription("Manage the backend's address list.");
	}

}
