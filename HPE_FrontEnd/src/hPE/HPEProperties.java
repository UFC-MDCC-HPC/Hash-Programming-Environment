package hPE;

import static hPE.ui.preferences.PreferenceConstants.CACHE_PATH;
import static hPE.ui.preferences.PreferenceConstants.COMPILER_FLAG_DEBUG;
import static hPE.ui.preferences.PreferenceConstants.COMPILER_FLAG_OPTIMIZE;
import static hPE.ui.preferences.PreferenceConstants.COMPILER_FLAG_UNSAFE;
import static hPE.ui.preferences.PreferenceConstants.EXTERNAL_REFERENCES_XML;
import static hPE.ui.preferences.PreferenceConstants.GACUTIL_PATH;
import static hPE.ui.preferences.PreferenceConstants.HPE_HOME;
import static hPE.ui.preferences.PreferenceConstants.LIB_PATH;
import static hPE.ui.preferences.PreferenceConstants.LOCAL_LOCATION;
import static hPE.ui.preferences.PreferenceConstants.MONO_BIN_PATH;
import static hPE.ui.preferences.PreferenceConstants.SN_PATH;
import hPE.ui.preferences.HPEPreferenceStore;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

public class HPEProperties implements IPropertyChangeListener {

	private HPEPreferenceStore store;

	private Map<String, String> map = new HashMap<String, String>();

	private static HPEProperties eInstance = null;

	private static final String CACHE_DIR = System
			.getProperty("file.separator")
			+ System.getProperty("user.name")
			+ System.getProperty("file.separator") + "cache";

	private static final String LIB_DIR = System.getProperty("file.separator")
			+ "lib";

	static public HPEProperties getInstance() {
		if (eInstance == null) {
			eInstance = new HPEProperties();
		}
		return eInstance;
	}

	protected HPEProperties() {
		store = (HPEPreferenceStore) HPEPlugin.getDefault()
				.getPreferenceStore();
		store.addPropertyChangeListener(this);
		initialize();
	}

	private void initialize() {
		map.put(MONO_BIN_PATH, store.getString(MONO_BIN_PATH));
		map.put(CACHE_PATH, store.getString(HPE_HOME) + CACHE_DIR);
		map.put(LIB_PATH, store.getString(HPE_HOME) + LIB_DIR);

		String extension = "";
		if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
			extension = ".bat";
		}
		map.put(GACUTIL_PATH, store.getString(MONO_BIN_PATH) + "gacutil"
				+ extension);
		map.put(SN_PATH,
				store.getString(MONO_BIN_PATH)
						+ System.getProperty("file.separator") + "sn"
						+ extension);

		map.put(EXTERNAL_REFERENCES_XML,
				store.getString(EXTERNAL_REFERENCES_XML));

		// TODO os valores est‹o fixos. Qual o n’vel de variabilidade: por
		// componente? Por application? Determinar essa variabilidade para
		// definir a melhor forma de atribuir a propriedade.
		map.put(COMPILER_FLAG_DEBUG, "true");
		map.put(COMPILER_FLAG_OPTIMIZE, "true");
		map.put(COMPILER_FLAG_UNSAFE, "false");

		// TODO n‹o Ž para existir: Tempor‡rio
		map.put(LOCAL_LOCATION,
				"http://localhost:8080/HPE_Location/HPE_Location_Server.jws");
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		initialize();
	}

	public String getValue(String key) {
		return map.get(key);
	}

	public static String get(String key) {
		return getInstance().getValue(key);
	}
}