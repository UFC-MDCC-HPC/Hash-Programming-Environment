package hPE.frontend.kinds;

import hPE.HPEProperties;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Class responsible to load kinds at runtime and make them accessible to the frontend.
 * @author Rafael Sales - rafaelcds@gmail.com
 */
public final class KindManager {
	
	/**
	 * Stores a set of every kind's KindConfiguration loaded. 
	 */
	private static Set<KindConfiguration> kindsConfigurations = new HashSet<KindConfiguration>();
	
	private KindManager() {
	}
	
	/**
	 * Loads the extra kinds configured in HPE
	 * @return
	 */
	public static Set<KindConfiguration> getKinds() {
		//Load the kinds and stores its classes in kindsConfiguration and kindsClasses
		if (kindsConfigurations.isEmpty()) {
			try {
				List<File> kindsPaths = HPEProperties.getInstance().getKindsPaths();
				if (kindsPaths.isEmpty()) {
					return kindsConfigurations;
				}
				
				List<String> kindsConfigClassesNames = new ArrayList<String>(kindsPaths.size());
				List<URL> kindsUrls = new ArrayList<URL>(kindsPaths.size());
				 
				for (File kindPath : kindsPaths) {
					Manifest manifestFile;
					if (kindPath.isDirectory()) {
						//This case is a path to a directory containing bin and META-INF directories
						//The URI directory path always ends with File.separatorChar:
						kindsUrls.add(new URL(kindPath.toURI().toString() + "bin" + File.separatorChar));
						//The File absolute path never ends with File.separatorChar:
						String manifestAbsolutePath = kindPath.getAbsolutePath() + File.separatorChar + "META-INF" + File.separatorChar + "MANIFEST.MF";
						manifestFile = new Manifest(new FileInputStream(manifestAbsolutePath));
					} else {
						//This case is a path to a JAR file
						kindsUrls.add(kindPath.toURI().toURL());
						manifestFile = new JarFile(kindPath).getManifest();
					}
					Attributes kindManifestAttributes = manifestFile.getMainAttributes();
					kindsConfigClassesNames.add(kindManifestAttributes.getValue("KindConfiguration-Class"));						
				}
				//Loads the kinds classes:
				URLClassLoader urlClassLoader = URLClassLoader.newInstance(kindsUrls.toArray(new URL[0]), Thread.currentThread().getContextClassLoader());

				for (String kindConfigClassName : kindsConfigClassesNames) {
					Class<?> kindConfigurationClass = urlClassLoader.loadClass(kindConfigClassName);
					if (KindConfiguration.class.isAssignableFrom(kindConfigurationClass)) {
						KindConfiguration kindConfiguration = (KindConfiguration) kindConfigurationClass.newInstance();
						kindsConfigurations.add(kindConfiguration);
					}
				}
			} catch (Exception e) {
				throw new RuntimeException("Error ocurred while loading external kinds", e);
			}
		}
		
		return kindsConfigurations;
	}
	
	public static void main(String[] args) {
		Set<KindConfiguration> kinds = getKinds();
		System.out.println(kinds);
	}
	
	/**
	 * Find the kind configuration given its name
	 * @param name
	 * @return
	 */
	public static KindConfiguration findByName(String name) {
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
}
