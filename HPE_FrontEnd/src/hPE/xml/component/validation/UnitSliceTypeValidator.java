/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.VisualElementAttributes;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hPE.xml.component.UnitSliceType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface UnitSliceTypeValidator {
	boolean validate();

	boolean validateVisualDescription(VisualElementAttributes value);
	boolean validatePort(EList<String> value);
	boolean validateSliceName(String value);
	boolean validateTransitive(boolean value);
}
