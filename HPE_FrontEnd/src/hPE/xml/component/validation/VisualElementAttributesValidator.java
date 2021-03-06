/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.ColorComplexType;

/**
 * A sample validator interface for {@link hPE.xml.component.VisualElementAttributes}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface VisualElementAttributesValidator {
	boolean validate();

	boolean validateColor(ColorComplexType value);
	boolean validateH(long value);
	boolean validateW(long value);
	boolean validateX(long value);
	boolean validateY(long value);
}
