/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.ComponentInUseType;
import hPE.xml.component.ExtensionTypeType;

/**
 * A sample validator interface for {@link hPE.xml.component.BaseTypeType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface BaseTypeTypeValidator {
	boolean validate();

	boolean validateExtensionType(ExtensionTypeType value);
	boolean validateComponent(ComponentInUseType value);
}
