package hPE.frontend.kinds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * The @Kind should be used to annotate all the class and interfaces of a kind
 * referencing the same KindConfiguration class
 * @author Rafael Sales - rafaelcds@gmail.com
 */
@Target(value = ElementType.TYPE)
public @interface Kind {
	Class<? extends KindConfiguration> kindConfigurationClass();
}
