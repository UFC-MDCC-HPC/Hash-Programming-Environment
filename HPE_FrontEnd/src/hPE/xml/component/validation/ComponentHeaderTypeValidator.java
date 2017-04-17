/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.BaseTypeType;
import hPE.xml.component.FacetConfigurationType;
import hPE.xml.component.SupportedKinds;
import hPE.xml.component.VersionType;
import hPE.xml.component.VisualElementAttributes;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hPE.xml.component.ComponentHeaderType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ComponentHeaderTypeValidator {
	boolean validate();

	boolean validateBaseType(BaseTypeType value);
	boolean validateVersions(EList<VersionType> value);
	boolean validateVisualAttributes(VisualElementAttributes value);
	boolean validateFacetConfiguration(EList<FacetConfigurationType> value);

	boolean validateHashComponentUID(String value);
	boolean validateIsAbstract(boolean value);
	boolean validateKind(SupportedKinds value);
	boolean validateLocationURI(String value);
	boolean validateName(String value);
	boolean validatePackagePath(String value);
}
