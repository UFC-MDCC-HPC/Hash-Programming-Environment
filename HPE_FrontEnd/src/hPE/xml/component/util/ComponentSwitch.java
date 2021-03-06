/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.util;

import hPE.xml.component.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hPE.xml.component.ComponentPackage
 * @generated
 */
public class ComponentSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComponentPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSwitch() {
		if (modelPackage == null) {
			modelPackage = ComponentPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ComponentPackage.BASE_TYPE_TYPE: {
				BaseTypeType baseTypeType = (BaseTypeType)theEObject;
				T result = caseBaseTypeType(baseTypeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.COLOR_COMPLEX_TYPE: {
				ColorComplexType colorComplexType = (ColorComplexType)theEObject;
				T result = caseColorComplexType(colorComplexType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.COMPONENT_BODY_TYPE: {
				ComponentBodyType componentBodyType = (ComponentBodyType)theEObject;
				T result = caseComponentBodyType(componentBodyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.COMPONENT_HEADER_TYPE: {
				ComponentHeaderType componentHeaderType = (ComponentHeaderType)theEObject;
				T result = caseComponentHeaderType(componentHeaderType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.COMPONENT_IN_USE_TYPE: {
				ComponentInUseType componentInUseType = (ComponentInUseType)theEObject;
				T result = caseComponentInUseType(componentInUseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.COMPONENT_TYPE: {
				ComponentType componentType = (ComponentType)theEObject;
				T result = caseComponentType(componentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.CONDITION_TYPE: {
				ConditionType conditionType = (ConditionType)theEObject;
				T result = caseConditionType(conditionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENTRY_TYPE: {
				EntryType entryType = (EntryType)theEObject;
				T result = caseEntryType(entryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.EXPOSE_PORT_TYPE: {
				ExposePortType exposePortType = (ExposePortType)theEObject;
				T result = caseExposePortType(exposePortType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.EXTENDS_TYPE: {
				ExtendsType extendsType = (ExtendsType)theEObject;
				T result = caseExtendsType(extendsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.EXTENSION_TYPE_TYPE: {
				ExtensionTypeType extensionTypeType = (ExtensionTypeType)theEObject;
				T result = caseExtensionTypeType(extensionTypeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.EXTERNAL_LIBRARY_TYPE: {
				ExternalLibraryType externalLibraryType = (ExternalLibraryType)theEObject;
				T result = caseExternalLibraryType(externalLibraryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.FACET_CONFIGURATION_TYPE: {
				FacetConfigurationType facetConfigurationType = (FacetConfigurationType)theEObject;
				T result = caseFacetConfigurationType(facetConfigurationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.FACET_MULTIPLE_TYPE: {
				FacetMultipleType facetMultipleType = (FacetMultipleType)theEObject;
				T result = caseFacetMultipleType(facetMultipleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.FACET_MULTIPLICITY_TYPE: {
				FacetMultiplicityType facetMultiplicityType = (FacetMultiplicityType)theEObject;
				T result = caseFacetMultiplicityType(facetMultiplicityType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE: {
				FusionOfReplicatorsType fusionOfReplicatorsType = (FusionOfReplicatorsType)theEObject;
				T result = caseFusionOfReplicatorsType(fusionOfReplicatorsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE: {
				FusionsOfReplicatorsType fusionsOfReplicatorsType = (FusionsOfReplicatorsType)theEObject;
				T result = caseFusionsOfReplicatorsType(fusionsOfReplicatorsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.FUSION_TYPE: {
				FusionType fusionType = (FusionType)theEObject;
				T result = caseFusionType(fusionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.GUARD_CONDITION_TYPE: {
				GuardConditionType guardConditionType = (GuardConditionType)theEObject;
				T result = caseGuardConditionType(guardConditionType);
				if (result == null) result = caseGuardType(guardConditionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.GUARD_TYPE: {
				GuardType guardType = (GuardType)theEObject;
				T result = caseGuardType(guardType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HEXTERNAL_LIBRARY_TYPE: {
				HExternalLibraryType hExternalLibraryType = (HExternalLibraryType)theEObject;
				T result = caseHExternalLibraryType(hExternalLibraryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.IMPLEMENTS_TYPE: {
				ImplementsType implementsType = (ImplementsType)theEObject;
				T result = caseImplementsType(implementsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INNER_COMPONENT_TYPE: {
				InnerComponentType innerComponentType = (InnerComponentType)theEObject;
				T result = caseInnerComponentType(innerComponentType);
				if (result == null) result = caseComponentInUseType(innerComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INNER_RENAMING_TYPE: {
				InnerRenamingType innerRenamingType = (InnerRenamingType)theEObject;
				T result = caseInnerRenamingType(innerRenamingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INTERFACE_PARAMETER_TYPE: {
				InterfaceParameterType interfaceParameterType = (InterfaceParameterType)theEObject;
				T result = caseInterfaceParameterType(interfaceParameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INTERFACE_PORT_TYPE: {
				InterfacePortType interfacePortType = (InterfacePortType)theEObject;
				T result = caseInterfacePortType(interfacePortType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INTERFACE_REF_TYPE: {
				InterfaceRefType interfaceRefType = (InterfaceRefType)theEObject;
				T result = caseInterfaceRefType(interfaceRefType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE: {
				InterfaceSliceRefType interfaceSliceRefType = (InterfaceSliceRefType)theEObject;
				T result = caseInterfaceSliceRefType(interfaceSliceRefType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INTERFACE_SLICE_TYPE: {
				InterfaceSliceType interfaceSliceType = (InterfaceSliceType)theEObject;
				T result = caseInterfaceSliceType(interfaceSliceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.INTERFACE_TYPE: {
				InterfaceType interfaceType = (InterfaceType)theEObject;
				T result = caseInterfaceType(interfaceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PARAMETER_RENAMING: {
				ParameterRenaming parameterRenaming = (ParameterRenaming)theEObject;
				T result = caseParameterRenaming(parameterRenaming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PARAMETER_SUPPLY_TYPE: {
				ParameterSupplyType parameterSupplyType = (ParameterSupplyType)theEObject;
				T result = caseParameterSupplyType(parameterSupplyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PARAMETER_TYPE: {
				ParameterType parameterType = (ParameterType)theEObject;
				T result = caseParameterType(parameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PORT_SLICE_TYPE: {
				PortSliceType portSliceType = (PortSliceType)theEObject;
				T result = casePortSliceType(portSliceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PORT_TYPE: {
				PortType portType = (PortType)theEObject;
				T result = casePortType(portType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_CHOICE_TYPE: {
				ProtocolChoiceType protocolChoiceType = (ProtocolChoiceType)theEObject;
				T result = caseProtocolChoiceType(protocolChoiceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_COMBINATOR_TYPE: {
				ProtocolCombinatorType protocolCombinatorType = (ProtocolCombinatorType)theEObject;
				T result = caseProtocolCombinatorType(protocolCombinatorType);
				if (result == null) result = caseProtocolType(protocolCombinatorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_COMBINATOR_VISUAL_TYPE: {
				ProtocolCombinatorVisualType protocolCombinatorVisualType = (ProtocolCombinatorVisualType)theEObject;
				T result = caseProtocolCombinatorVisualType(protocolCombinatorVisualType);
				if (result == null) result = caseProtocolCombinatorType(protocolCombinatorVisualType);
				if (result == null) result = caseProtocolType(protocolCombinatorVisualType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_PERFORM_TYPE: {
				ProtocolPerformType protocolPerformType = (ProtocolPerformType)theEObject;
				T result = caseProtocolPerformType(protocolPerformType);
				if (result == null) result = caseProtocolType(protocolPerformType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_PERFORM_VISUAL_TYPE: {
				ProtocolPerformVisualType protocolPerformVisualType = (ProtocolPerformVisualType)theEObject;
				T result = caseProtocolPerformVisualType(protocolPerformVisualType);
				if (result == null) result = caseProtocolPerformType(protocolPerformVisualType);
				if (result == null) result = caseProtocolType(protocolPerformVisualType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_TYPE: {
				ProtocolType protocolType = (ProtocolType)theEObject;
				T result = caseProtocolType(protocolType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.RECURSIVE_ENTRY_TYPE: {
				RecursiveEntryType recursiveEntryType = (RecursiveEntryType)theEObject;
				T result = caseRecursiveEntryType(recursiveEntryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.SOURCE_FILE_TYPE: {
				SourceFileType sourceFileType = (SourceFileType)theEObject;
				T result = caseSourceFileType(sourceFileType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.SOURCE_TYPE: {
				SourceType sourceType = (SourceType)theEObject;
				T result = caseSourceType(sourceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.SPLIT_ENUMERATOR_TYPE: {
				SplitEnumeratorType splitEnumeratorType = (SplitEnumeratorType)theEObject;
				T result = caseSplitEnumeratorType(splitEnumeratorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.SPLIT_LINK_TYPE: {
				SplitLinkType splitLinkType = (SplitLinkType)theEObject;
				T result = caseSplitLinkType(splitLinkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.SPLIT_TYPE: {
				SplitType splitType = (SplitType)theEObject;
				T result = caseSplitType(splitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.UNIT_ACTION_TYPE: {
				UnitActionType unitActionType = (UnitActionType)theEObject;
				T result = caseUnitActionType(unitActionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.UNIT_BOUNDS_TYPE: {
				UnitBoundsType unitBoundsType = (UnitBoundsType)theEObject;
				T result = caseUnitBoundsType(unitBoundsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.UNIT_CONDITION_TYPE: {
				UnitConditionType unitConditionType = (UnitConditionType)theEObject;
				T result = caseUnitConditionType(unitConditionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.UNIT_REF_TYPE: {
				UnitRefType unitRefType = (UnitRefType)theEObject;
				T result = caseUnitRefType(unitRefType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.UNIT_SLICE_TYPE: {
				UnitSliceType unitSliceType = (UnitSliceType)theEObject;
				T result = caseUnitSliceType(unitSliceType);
				if (result == null) result = caseUnitRefType(unitSliceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.UNIT_TYPE: {
				UnitType unitType = (UnitType)theEObject;
				T result = caseUnitType(unitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.VERSION_TYPE: {
				VersionType versionType = (VersionType)theEObject;
				T result = caseVersionType(versionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.VISUAL_ELEMENT_ATTRIBUTES: {
				VisualElementAttributes visualElementAttributes = (VisualElementAttributes)theEObject;
				T result = caseVisualElementAttributes(visualElementAttributes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseTypeType(BaseTypeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Complex Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorComplexType(ColorComplexType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Body Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Body Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentBodyType(ComponentBodyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Header Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Header Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentHeaderType(ComponentHeaderType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Use Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Use Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentInUseType(ComponentInUseType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentType(ComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionType(ConditionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryType(EntryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expose Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expose Port Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExposePortType(ExposePortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsType(ExtendsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionTypeType(ExtensionTypeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Library Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Library Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalLibraryType(ExternalLibraryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Configuration Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Configuration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetConfigurationType(FacetConfigurationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Multiple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Multiple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetMultipleType(FacetMultipleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Multiplicity Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Multiplicity Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetMultiplicityType(FacetMultiplicityType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fusion Of Replicators Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fusion Of Replicators Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFusionOfReplicatorsType(FusionOfReplicatorsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fusions Of Replicators Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fusions Of Replicators Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFusionsOfReplicatorsType(FusionsOfReplicatorsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fusion Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fusion Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFusionType(FusionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Condition Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Condition Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardConditionType(GuardConditionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardType(GuardType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HExternal Library Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HExternal Library Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHExternalLibraryType(HExternalLibraryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implements Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implements Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementsType(ImplementsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inner Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inner Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInnerComponentType(InnerComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inner Renaming Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inner Renaming Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInnerRenamingType(InnerRenamingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceParameterType(InterfaceParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Port Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfacePortType(InterfacePortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Ref Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceRefType(InterfaceRefType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Slice Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Slice Ref Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceSliceRefType(InterfaceSliceRefType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Slice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceSliceType(InterfaceSliceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceType(InterfaceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Renaming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Renaming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterRenaming(ParameterRenaming object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Supply Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Supply Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterSupplyType(ParameterSupplyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterType(ParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Slice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortSliceType(PortSliceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortType(PortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Choice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Choice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolChoiceType(ProtocolChoiceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Combinator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Combinator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolCombinatorType(ProtocolCombinatorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Combinator Visual Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Combinator Visual Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolCombinatorVisualType(ProtocolCombinatorVisualType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Perform Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Perform Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolPerformType(ProtocolPerformType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Perform Visual Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Perform Visual Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolPerformVisualType(ProtocolPerformVisualType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolType(ProtocolType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recursive Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recursive Entry Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecursiveEntryType(RecursiveEntryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source File Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source File Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceFileType(SourceFileType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceType(SourceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Split Enumerator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Split Enumerator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSplitEnumeratorType(SplitEnumeratorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Split Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Split Link Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSplitLinkType(SplitLinkType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Split Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Split Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSplitType(SplitType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Action Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Action Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitActionType(UnitActionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Bounds Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Bounds Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitBoundsType(UnitBoundsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Condition Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Condition Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitConditionType(UnitConditionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Ref Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitRefType(UnitRefType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Slice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitSliceType(UnitSliceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitType(UnitType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Version Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Version Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersionType(VersionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visual Element Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visual Element Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisualElementAttributes(VisualElementAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ComponentSwitch
