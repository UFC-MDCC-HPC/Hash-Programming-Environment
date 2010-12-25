/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.util;

import hPE.xml.component.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;


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
public class ComponentSwitch<T> {
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
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ComponentPackage.ACTION_ACTIVATE_TYPE: {
				ActionActivateType actionActivateType = (ActionActivateType)theEObject;
				T result = caseActionActivateType(actionActivateType);
				if (result == null) result = caseActionType(actionActivateType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_COMBINATOR_ALT_TYPE: {
				ActionCombinatorAltType actionCombinatorAltType = (ActionCombinatorAltType)theEObject;
				T result = caseActionCombinatorAltType(actionCombinatorAltType);
				if (result == null) result = caseActionCombinatorType(actionCombinatorAltType);
				if (result == null) result = caseActionType(actionCombinatorAltType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_COMBINATOR_PAR_TYPE: {
				ActionCombinatorParType actionCombinatorParType = (ActionCombinatorParType)theEObject;
				T result = caseActionCombinatorParType(actionCombinatorParType);
				if (result == null) result = caseActionCombinatorType(actionCombinatorParType);
				if (result == null) result = caseActionType(actionCombinatorParType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_COMBINATOR_SEQ_TYPE: {
				ActionCombinatorSeqType actionCombinatorSeqType = (ActionCombinatorSeqType)theEObject;
				T result = caseActionCombinatorSeqType(actionCombinatorSeqType);
				if (result == null) result = caseActionCombinatorType(actionCombinatorSeqType);
				if (result == null) result = caseActionType(actionCombinatorSeqType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_COMBINATOR_TYPE: {
				ActionCombinatorType actionCombinatorType = (ActionCombinatorType)theEObject;
				T result = caseActionCombinatorType(actionCombinatorType);
				if (result == null) result = caseActionType(actionCombinatorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_SIGNAL_TYPE: {
				ActionSignalType actionSignalType = (ActionSignalType)theEObject;
				T result = caseActionSignalType(actionSignalType);
				if (result == null) result = caseActionType(actionSignalType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_SKIP_TYPE: {
				ActionSkipType actionSkipType = (ActionSkipType)theEObject;
				T result = caseActionSkipType(actionSkipType);
				if (result == null) result = caseActionType(actionSkipType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_TYPE: {
				ActionType actionType = (ActionType)theEObject;
				T result = caseActionType(actionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ACTION_WAIT_TYPE: {
				ActionWaitType actionWaitType = (ActionWaitType)theEObject;
				T result = caseActionWaitType(actionWaitType);
				if (result == null) result = caseActionType(actionWaitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
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
			case ComponentPackage.ENUMERABLE_COMPONENT_TYPE: {
				EnumerableComponentType enumerableComponentType = (EnumerableComponentType)theEObject;
				T result = caseEnumerableComponentType(enumerableComponentType);
				if (result == null) result = caseEnumerableType(enumerableComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE: {
				EnumerableEntryType enumerableEntryType = (EnumerableEntryType)theEObject;
				T result = caseEnumerableEntryType(enumerableEntryType);
				if (result == null) result = caseEnumerableType(enumerableEntryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENUMERABLE_TYPE: {
				EnumerableType enumerableType = (EnumerableType)theEObject;
				T result = caseEnumerableType(enumerableType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE: {
				EnumerableUnitSliceType enumerableUnitSliceType = (EnumerableUnitSliceType)theEObject;
				T result = caseEnumerableUnitSliceType(enumerableUnitSliceType);
				if (result == null) result = caseEnumerableType(enumerableUnitSliceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENUMERABLE_UNIT_TYPE: {
				EnumerableUnitType enumerableUnitType = (EnumerableUnitType)theEObject;
				T result = caseEnumerableUnitType(enumerableUnitType);
				if (result == null) result = caseEnumerableType(enumerableUnitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENUMERATOR_FROM_RECURSION_TYPE: {
				EnumeratorFromRecursionType enumeratorFromRecursionType = (EnumeratorFromRecursionType)theEObject;
				T result = caseEnumeratorFromRecursionType(enumeratorFromRecursionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENUMERATOR_REF_TYPE: {
				EnumeratorRefType enumeratorRefType = (EnumeratorRefType)theEObject;
				T result = caseEnumeratorRefType(enumeratorRefType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.ENUMERATOR_TYPE: {
				EnumeratorType enumeratorType = (EnumeratorType)theEObject;
				T result = caseEnumeratorType(enumeratorType);
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
			case ComponentPackage.QUANTIFICATION_VAR_TYPE: {
				QuantificationVarType quantificationVarType = (QuantificationVarType)theEObject;
				T result = caseQuantificationVarType(quantificationVarType);
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
			case ComponentPackage.UNIT_BOUNDS_TYPE: {
				UnitBoundsType unitBoundsType = (UnitBoundsType)theEObject;
				T result = caseUnitBoundsType(unitBoundsType);
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
	 * Returns the result of interpreting the object as an instance of '<em>Action Activate Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Activate Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionActivateType(ActionActivateType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Combinator Alt Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Combinator Alt Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionCombinatorAltType(ActionCombinatorAltType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Combinator Par Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Combinator Par Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionCombinatorParType(ActionCombinatorParType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Combinator Seq Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Combinator Seq Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionCombinatorSeqType(ActionCombinatorSeqType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Combinator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Combinator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionCombinatorType(ActionCombinatorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Signal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Signal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionSignalType(ActionSignalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Skip Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Skip Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionSkipType(ActionSkipType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionType(ActionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Wait Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Wait Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionWaitType(ActionWaitType object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Enumerable Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerable Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerableComponentType(EnumerableComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerable Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerable Entry Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerableEntryType(EnumerableEntryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerable Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerable Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerableType(EnumerableType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerable Unit Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerable Unit Slice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerableUnitSliceType(EnumerableUnitSliceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerable Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerable Unit Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerableUnitType(EnumerableUnitType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerator From Recursion Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerator From Recursion Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeratorFromRecursionType(EnumeratorFromRecursionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerator Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerator Ref Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeratorRefType(EnumeratorRefType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeratorType(EnumeratorType object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Quantification Var Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quantification Var Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuantificationVarType(QuantificationVarType object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //ComponentSwitch
