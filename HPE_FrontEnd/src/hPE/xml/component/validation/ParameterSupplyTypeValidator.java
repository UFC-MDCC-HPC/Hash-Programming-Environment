/**
 *
 * $Id$
 */
package hPE.xml.component.validation;


/**
 * A sample validator interface for {@link hPE.xml.component.ParameterSupplyType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ParameterSupplyTypeValidator {
	boolean validate();

	boolean validateCRef(String value);
	boolean validateDirect(boolean value);
	boolean validateVarName(String value);
}
