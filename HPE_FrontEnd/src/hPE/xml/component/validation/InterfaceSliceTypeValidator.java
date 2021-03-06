/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.InterfaceRefType;
import hPE.xml.component.VisualElementAttributes;

/**
 * A sample validator interface for {@link hPE.xml.component.InterfaceSliceType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InterfaceSliceTypeValidator {
	boolean validate();

	boolean validateOriginRef(InterfaceRefType value);
	boolean validateVisualDescription(VisualElementAttributes value);
	boolean validateIsRef(String value);
}
