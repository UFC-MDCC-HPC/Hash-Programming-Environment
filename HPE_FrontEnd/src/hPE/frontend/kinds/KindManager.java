package hPE.frontend.kinds;

import hPE.HPEProperties;
import hPE.frontend.base.exceptions.HPEException;
import hPE.frontend.base.model.HComponent;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.eclipse.gef.ui.actions.SelectionAction;

/**
 * Class responsible to load kinds at runtime and make them accessible to the frontend.
 * @author Rafael Sales - rafaelcds@gmail.com
 */
public final class KindManager {

	/**
	 * Stores a set of every kind's KindConfiguration loaded.
	 */
	private static Set<KindConfiguration> kindsConfigurations = new TreeSet<KindConfiguration>();

	private KindManager() {
	}

	/**
	 * Loads the extra kinds configured in HPE
	 * @return
	 */
	public static Set<KindConfiguration> getKinds() throws HPEException {
		//Load the kinds and stores its classes in kindsConfiguration and kindsClasses
		if (kindsConfigurations.isEmpty()) {
			try {
				List<File> kindsPaths = HPEProperties.getInstance().getKindsPaths();
				if (kindsPaths.isEmpty()) {
					return kindsConfigurations;
				}

				List<String> kindsConfigClassesNames = new ArrayList<String>(kindsPaths.size());
				List<URL> kindsBinUrls = new ArrayList<URL>(kindsPaths.size());

				for (File kindPath : kindsPaths) {
					Manifest manifestFile;
					if (kindPath.isDirectory()) {
						//This case is a path to a directory containing bin and META-INF directories
						//The URI directory path always ends with File.separatorChar:
						kindsBinUrls.add(new URL(kindPath.toURI().toString() + "bin" + File.separatorChar));
						//The File absolute path never ends with File.separatorChar:
						String manifestAbsolutePath = kindPath.getAbsolutePath() + File.separatorChar + "META-INF" + File.separatorChar + "MANIFEST.MF";
						manifestFile = new Manifest(new FileInputStream(manifestAbsolutePath));
					} else {
						//This case is a path to a JAR file
						kindsBinUrls.add(kindPath.toURI().toURL());
						manifestFile = new JarFile(kindPath).getManifest();
					}
					Attributes kindManifestAttributes = manifestFile.getMainAttributes();
					kindsConfigClassesNames.addAll(Arrays.asList(kindManifestAttributes.getValue("KindConfiguration-Classes").split(",")));
				}
				//Loads the kinds classes:
				URLClassLoader urlClassLoader = URLClassLoader.newInstance(kindsBinUrls.toArray(new URL[0]), Thread.currentThread().getContextClassLoader());

				for (String kindConfigClassName : kindsConfigClassesNames) {
					Class<?> kindConfigurationClass = urlClassLoader.loadClass(kindConfigClassName.trim());
					if (KindConfiguration.class.isAssignableFrom(kindConfigurationClass)) {
						KindConfiguration kindConfiguration = (KindConfiguration) kindConfigurationClass.newInstance();
						kindsConfigurations.add(kindConfiguration);
					}
				}
			} catch (Exception e) {
				throw new HPEException("Error ocurred while loading external kinds", e);
			}
		}

		return kindsConfigurations;
	}

	public static void main(String[] args) {
		try {
			Set<KindConfiguration> kinds = getKinds();
			System.out.println(kinds);
		} catch (HPEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Find the kind configuration given its name
	 * @param name
	 * @return
	 * @throws HPEException
	 */
	public static KindConfiguration findByName(String name) throws HPEException {
		for (KindConfiguration kindConfiguration : getKinds()) {
			if (kindConfiguration.getName().equals(name)) {
				return kindConfiguration;
			}
		}
		return null;
	}

	/**
	 * Discover the KindConfiguration instance of the kind owner of <code>clazz</code>.
	 * @param clazz
	 * @return returns the proper KindConfiguration, otherwise returns null (not expected)
	 */
	public static KindConfiguration discoverKindConfiguration(Class<?> clazz) {
		Kind kindAnnotation = clazz.getAnnotation(Kind.class);
		if (kindAnnotation != null) {
			Class<? extends KindConfiguration> kindConfigurationClass = kindAnnotation.kindConfigurationClass();
			for (KindConfiguration kindConfiguration : kindsConfigurations) {
				if (kindConfigurationClass.isInstance(kindConfigurationClass)) {
					return kindConfiguration;
				}
			}
		}
		return null;
	}

	public static List<SelectionAction> createActionsForConfiguration(HComponent configuration) {
		List<SelectionAction> actions = new ArrayList<SelectionAction>();
		for (KindConfiguration kindConfiguration : kindsConfigurations) {
			actions.addAll(kindConfiguration.createActionsForConfiguration(configuration));
		}
		return actions;
	}
}
