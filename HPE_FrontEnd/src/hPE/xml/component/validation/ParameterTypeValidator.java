/**
 *
 * $Id$
 */
package hPE.xml.component.validation;


/**
 * A sample validator interface for {@link hPE.xml.component.ParameterType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ParameterTypeValidator {
	boolean validate();

	boolean validateComponentRef(String value);
	boolean validateFormFieldId(String value);
	boolean validateOrder(int value);
	boolean validateVarName(String value);
}
