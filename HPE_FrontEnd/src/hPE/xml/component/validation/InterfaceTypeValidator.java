/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.InterfaceParameterType;
import hPE.xml.component.InterfacePortType;
import hPE.xml.component.InterfaceSliceType;
import hPE.xml.component.ProtocolChoiceType;
import hPE.xml.component.SourceType;
import hPE.xml.component.UnitActionType;
import hPE.xml.component.UnitConditionType;
import hPE.xml.component.VisualElementAttributes;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hPE.xml.component.InterfaceType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InterfaceTypeValidator {
	boolean validate();

	boolean validateSlice(EList<InterfaceSliceType> value);
	boolean validateSources(EList<SourceType> value);
	boolean validateVisualDescription(VisualElementAttributes value);
	boolean validatePort(EList<InterfacePortType> value);
	boolean validateExternalReferences(EList<String> value);
	boolean validateParameter(EList<InterfaceParameterType> value);
	boolean validateAction(EList<UnitActionType> value);
	boolean validateCondition(EList<UnitConditionType> value);
	boolean validateProtocol(ProtocolChoiceType value);
	boolean validateIRef(String value);
	boolean validateNArgs(int value);
}
