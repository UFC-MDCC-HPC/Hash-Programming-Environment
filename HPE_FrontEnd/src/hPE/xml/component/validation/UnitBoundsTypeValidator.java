/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.VisualElementAttributes;

/**
 * A sample validator interface for {@link hPE.xml.component.UnitBoundsType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface UnitBoundsTypeValidator {
	boolean validate();

	boolean validateVisualDescription(VisualElementAttributes value);
	boolean validateFacet(int value);

	boolean validateFacetInstance(int value);

	boolean validateFacetInstanceEnclosing(int value);

	boolean validateParallel(boolean value);
	boolean validateReplica(long value);
	boolean validateSliceReplica(int value);
	boolean validateUnitReplica(int value);
	boolean validateURef(String value);
}
