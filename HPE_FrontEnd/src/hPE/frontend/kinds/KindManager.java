package hPE.frontend.kinds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class responsible to load kinds at runtime and make them accessible to the frontend.
 * @author Rafael Sales - rafaelcds@gmail.com
 */
public final class KindManager {
	
	/**
	 * Stores a set of KindConfiguration of every loaded kind. 
	 */
	private static Set<KindConfiguration> kindsConfiguration = new HashSet<KindConfiguration>();
	
	/**
	 * Maps the kinds classes to its KindConfiguration class.
	 * Used to discover the KindConfiguration class given a class belonging to the same kind.
	 */
	private static Map<Class<?>, KindConfiguration> kindsClasses = new HashMap<Class<?>, KindConfiguration>();
	
	private KindManager() {
	}
	
	public static Set<KindConfiguration> getKinds() {
		//Load the kinds and stores its classes in kindsConfiguration and kindsClasses
		return kindsConfiguration;
	}
	
	/**
	 * Gets the KindConfiguration of the kind owner of <code>kindClass</code>.
	 * @param kindClass
	 * @return returns the proper KindConfiguration, otherwise returns null (not expected)
	 */
	public static KindConfiguration getKindConfiguration(Class<?> kindClass) {
		return kindsClasses.get(kindClass);
	}
	
	public static KindConfiguration findByName(String name) {
		for (KindConfiguration kindConfiguration : getKinds()) {
			if (kindConfiguration.getName().equals(name)) {
				return kindConfiguration;
			}
		}
		return null;
	}
}
