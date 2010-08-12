package hPE.frontend.kinds;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible to load kinds at runtime and make them accessible to the frontend.
 * @author Rafael Sales - rafaelcds@gmail.com
 */
public final class KindManager {
	private KindManager() {
	}

	public static List<KindConfiguration> getKinds() {
		List<KindConfiguration> kinds = new ArrayList<KindConfiguration>();
		
		return kinds;
	}
	
	/**
	 * Search for the kind that defines the <code>relatedClass</code>
	 * @param relatedClass - a class returned by any public get method of the KindConfiguration
	 * @return
	 */
	public static KindConfiguration findKindConfiguration(Class<?> relatedClass) {
		for (KindConfiguration kindConfiguration : getKinds()) {
			if (kindConfiguration.getClassAssignableFrom(relatedClass) != null) {
				return kindConfiguration;
			}
		}
		return null;
	}
	
	/**
	 * Gets the class assignable from the <code>baseClass</code> of the kind that defines
	 * the <code>relatedClass</code>
	 * @param <T>
	 * @param baseClass
	 * @param relatedClass - a class returned by any public get method of the KindConfiguration
	 * @return
	 */
	public static <T> Class<? extends T> getClassAssignableFrom(Class<T> baseClass, Class<?> relatedClass) {
		KindConfiguration kindConfiguration = findKindConfiguration(relatedClass);
		if (kindConfiguration != null) {
			return findKindConfiguration(relatedClass).getClassAssignableFrom(baseClass);			
		}
		return null;
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
