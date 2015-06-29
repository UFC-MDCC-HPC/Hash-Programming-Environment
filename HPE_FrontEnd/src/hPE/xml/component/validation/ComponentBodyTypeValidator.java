/**
 *
 * $Id$
 */
package hPE.xml.component.validation;

import hPE.xml.component.EnumeratorType;
import hPE.xml.component.ExternalLibraryType;
import hPE.xml.component.FusionType;
import hPE.xml.component.FusionsOfReplicatorsType;
import hPE.xml.component.InnerComponentType;
import hPE.xml.component.InnerRenamingType;
import hPE.xml.component.InterfaceType;
import hPE.xml.component.ParameterSupplyType;
import hPE.xml.component.ParameterType;
import hPE.xml.component.RecursiveEntryType;
import hPE.xml.component.SplitType;
import hPE.xml.component.UnitType;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * A sample validator interface for {@link hPE.xml.component.ComponentBodyType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ComponentBodyTypeValidator {
	boolean validate();

	boolean validateGroup(FeatureMap value);
	boolean validateInnerComponent(EList<InnerComponentType> value);
	boolean validateParameter(EList<ParameterType> value);
	boolean validateSupplyParameter(EList<ParameterSupplyType> value);
	boolean validateInnerRenaming(EList<InnerRenamingType> value);
	boolean validateFusion(EList<FusionType> value);
	boolean validateSplit(EList<SplitType> value);
	boolean validateRecursiveEntry(EList<RecursiveEntryType> value);
	boolean validateInterface(EList<InterfaceType> value);
	boolean validateUnit(EList<UnitType> value);
	boolean validateEnumerator(EList<EnumeratorType> value);
	boolean validateFusionsOfReplicators(EList<FusionsOfReplicatorsType> value);

	boolean validateExternalLibrary(EList<ExternalLibraryType> value);
}
