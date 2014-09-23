/**
 *
 * $Id$
 */
package hPE.xml.component.validation;


/**
 * A sample validator interface for {@link hPE.xml.component.InterfaceParameterType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InterfaceParameterTypeValidator {
	boolean validate();

	boolean validateIname(String value);
	boolean validateOrder(int value);
	boolean validateParid(String value);
	boolean validateUname(String value);
	boolean validateVarid(String value);
}
