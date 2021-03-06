/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentFactoryImpl extends EFactoryImpl implements ComponentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComponentFactory init() {
		try {
			ComponentFactory theComponentFactory = (ComponentFactory)EPackage.Registry.INSTANCE.getEFactory(ComponentPackage.eNS_URI);
			if (theComponentFactory != null) {
				return theComponentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComponentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComponentPackage.BASE_TYPE_TYPE: return createBaseTypeType();
			case ComponentPackage.COLOR_COMPLEX_TYPE: return createColorComplexType();
			case ComponentPackage.COMPONENT_BODY_TYPE: return createComponentBodyType();
			case ComponentPackage.COMPONENT_HEADER_TYPE: return createComponentHeaderType();
			case ComponentPackage.COMPONENT_IN_USE_TYPE: return createComponentInUseType();
			case ComponentPackage.COMPONENT_TYPE: return createComponentType();
			case ComponentPackage.CONDITION_TYPE: return createConditionType();
			case ComponentPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case ComponentPackage.ENTRY_TYPE: return createEntryType();
			case ComponentPackage.EXPOSE_PORT_TYPE: return createExposePortType();
			case ComponentPackage.EXTENDS_TYPE: return createExtendsType();
			case ComponentPackage.EXTENSION_TYPE_TYPE: return createExtensionTypeType();
			case ComponentPackage.EXTERNAL_LIBRARY_TYPE: return createExternalLibraryType();
			case ComponentPackage.FACET_CONFIGURATION_TYPE: return createFacetConfigurationType();
			case ComponentPackage.FACET_MULTIPLE_TYPE: return createFacetMultipleType();
			case ComponentPackage.FACET_MULTIPLICITY_TYPE: return createFacetMultiplicityType();
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE: return createFusionOfReplicatorsType();
			case ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE: return createFusionsOfReplicatorsType();
			case ComponentPackage.FUSION_TYPE: return createFusionType();
			case ComponentPackage.GUARD_CONDITION_TYPE: return createGuardConditionType();
			case ComponentPackage.GUARD_TYPE: return createGuardType();
			case ComponentPackage.HEXTERNAL_LIBRARY_TYPE: return createHExternalLibraryType();
			case ComponentPackage.IMPLEMENTS_TYPE: return createImplementsType();
			case ComponentPackage.INNER_COMPONENT_TYPE: return createInnerComponentType();
			case ComponentPackage.INNER_RENAMING_TYPE: return createInnerRenamingType();
			case ComponentPackage.INTERFACE_PARAMETER_TYPE: return createInterfaceParameterType();
			case ComponentPackage.INTERFACE_PORT_TYPE: return createInterfacePortType();
			case ComponentPackage.INTERFACE_REF_TYPE: return createInterfaceRefType();
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE: return createInterfaceSliceRefType();
			case ComponentPackage.INTERFACE_SLICE_TYPE: return createInterfaceSliceType();
			case ComponentPackage.INTERFACE_TYPE: return createInterfaceType();
			case ComponentPackage.PARAMETER_RENAMING: return createParameterRenaming();
			case ComponentPackage.PARAMETER_SUPPLY_TYPE: return createParameterSupplyType();
			case ComponentPackage.PARAMETER_TYPE: return createParameterType();
			case ComponentPackage.PORT_SLICE_TYPE: return createPortSliceType();
			case ComponentPackage.PORT_TYPE: return createPortType();
			case ComponentPackage.PROTOCOL_CHOICE_TYPE: return createProtocolChoiceType();
			case ComponentPackage.PROTOCOL_COMBINATOR_TYPE: return createProtocolCombinatorType();
			case ComponentPackage.PROTOCOL_COMBINATOR_VISUAL_TYPE: return createProtocolCombinatorVisualType();
			case ComponentPackage.PROTOCOL_PERFORM_TYPE: return createProtocolPerformType();
			case ComponentPackage.PROTOCOL_PERFORM_VISUAL_TYPE: return createProtocolPerformVisualType();
			case ComponentPackage.RECURSIVE_ENTRY_TYPE: return createRecursiveEntryType();
			case ComponentPackage.SOURCE_FILE_TYPE: return createSourceFileType();
			case ComponentPackage.SOURCE_TYPE: return createSourceType();
			case ComponentPackage.SPLIT_ENUMERATOR_TYPE: return createSplitEnumeratorType();
			case ComponentPackage.SPLIT_LINK_TYPE: return createSplitLinkType();
			case ComponentPackage.SPLIT_TYPE: return createSplitType();
			case ComponentPackage.UNIT_ACTION_TYPE: return createUnitActionType();
			case ComponentPackage.UNIT_BOUNDS_TYPE: return createUnitBoundsType();
			case ComponentPackage.UNIT_CONDITION_TYPE: return createUnitConditionType();
			case ComponentPackage.UNIT_REF_TYPE: return createUnitRefType();
			case ComponentPackage.UNIT_SLICE_TYPE: return createUnitSliceType();
			case ComponentPackage.UNIT_TYPE: return createUnitType();
			case ComponentPackage.VERSION_TYPE: return createVersionType();
			case ComponentPackage.VISUAL_ELEMENT_ATTRIBUTES: return createVisualElementAttributes();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ComponentPackage.QUANTIFICATION_TYPE:
				return createQuantificationTypeFromString(eDataType, initialValue);
			case ComponentPackage.SUPPORTED_KINDS:
				return createSupportedKindsFromString(eDataType, initialValue);
			case ComponentPackage.VARIANCE_TYPE:
				return createVarianceTypeFromString(eDataType, initialValue);
			case ComponentPackage.QUANTIFICATION_TYPE_OBJECT:
				return createQuantificationTypeObjectFromString(eDataType, initialValue);
			case ComponentPackage.SUPPORTED_KINDS_OBJECT:
				return createSupportedKindsObjectFromString(eDataType, initialValue);
			case ComponentPackage.VARIANCE_TYPE_OBJECT:
				return createVarianceTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ComponentPackage.QUANTIFICATION_TYPE:
				return convertQuantificationTypeToString(eDataType, instanceValue);
			case ComponentPackage.SUPPORTED_KINDS:
				return convertSupportedKindsToString(eDataType, instanceValue);
			case ComponentPackage.VARIANCE_TYPE:
				return convertVarianceTypeToString(eDataType, instanceValue);
			case ComponentPackage.QUANTIFICATION_TYPE_OBJECT:
				return convertQuantificationTypeObjectToString(eDataType, instanceValue);
			case ComponentPackage.SUPPORTED_KINDS_OBJECT:
				return convertSupportedKindsObjectToString(eDataType, instanceValue);
			case ComponentPackage.VARIANCE_TYPE_OBJECT:
				return convertVarianceTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseTypeType createBaseTypeType() {
		BaseTypeTypeImpl baseTypeType = new BaseTypeTypeImpl();
		return baseTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorComplexType createColorComplexType() {
		ColorComplexTypeImpl colorComplexType = new ColorComplexTypeImpl();
		return colorComplexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentBodyType createComponentBodyType() {
		ComponentBodyTypeImpl componentBodyType = new ComponentBodyTypeImpl();
		return componentBodyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentHeaderType createComponentHeaderType() {
		ComponentHeaderTypeImpl componentHeaderType = new ComponentHeaderTypeImpl();
		return componentHeaderType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInUseType createComponentInUseType() {
		ComponentInUseTypeImpl componentInUseType = new ComponentInUseTypeImpl();
		return componentInUseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType createComponentType() {
		ComponentTypeImpl componentType = new ComponentTypeImpl();
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionType createConditionType() {
		ConditionTypeImpl conditionType = new ConditionTypeImpl();
		return conditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryType createEntryType() {
		EntryTypeImpl entryType = new EntryTypeImpl();
		return entryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExposePortType createExposePortType() {
		ExposePortTypeImpl exposePortType = new ExposePortTypeImpl();
		return exposePortType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsType createExtendsType() {
		ExtendsTypeImpl extendsType = new ExtendsTypeImpl();
		return extendsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionTypeType createExtensionTypeType() {
		ExtensionTypeTypeImpl extensionTypeType = new ExtensionTypeTypeImpl();
		return extensionTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalLibraryType createExternalLibraryType() {
		ExternalLibraryTypeImpl externalLibraryType = new ExternalLibraryTypeImpl();
		return externalLibraryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetConfigurationType createFacetConfigurationType() {
		FacetConfigurationTypeImpl facetConfigurationType = new FacetConfigurationTypeImpl();
		return facetConfigurationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetMultipleType createFacetMultipleType() {
		FacetMultipleTypeImpl facetMultipleType = new FacetMultipleTypeImpl();
		return facetMultipleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetMultiplicityType createFacetMultiplicityType() {
		FacetMultiplicityTypeImpl facetMultiplicityType = new FacetMultiplicityTypeImpl();
		return facetMultiplicityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FusionOfReplicatorsType createFusionOfReplicatorsType() {
		FusionOfReplicatorsTypeImpl fusionOfReplicatorsType = new FusionOfReplicatorsTypeImpl();
		return fusionOfReplicatorsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FusionsOfReplicatorsType createFusionsOfReplicatorsType() {
		FusionsOfReplicatorsTypeImpl fusionsOfReplicatorsType = new FusionsOfReplicatorsTypeImpl();
		return fusionsOfReplicatorsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FusionType createFusionType() {
		FusionTypeImpl fusionType = new FusionTypeImpl();
		return fusionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardConditionType createGuardConditionType() {
		GuardConditionTypeImpl guardConditionType = new GuardConditionTypeImpl();
		return guardConditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardType createGuardType() {
		GuardTypeImpl guardType = new GuardTypeImpl();
		return guardType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HExternalLibraryType createHExternalLibraryType() {
		HExternalLibraryTypeImpl hExternalLibraryType = new HExternalLibraryTypeImpl();
		return hExternalLibraryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementsType createImplementsType() {
		ImplementsTypeImpl implementsType = new ImplementsTypeImpl();
		return implementsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InnerComponentType createInnerComponentType() {
		InnerComponentTypeImpl innerComponentType = new InnerComponentTypeImpl();
		return innerComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InnerRenamingType createInnerRenamingType() {
		InnerRenamingTypeImpl innerRenamingType = new InnerRenamingTypeImpl();
		return innerRenamingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceParameterType createInterfaceParameterType() {
		InterfaceParameterTypeImpl interfaceParameterType = new InterfaceParameterTypeImpl();
		return interfaceParameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfacePortType createInterfacePortType() {
		InterfacePortTypeImpl interfacePortType = new InterfacePortTypeImpl();
		return interfacePortType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceRefType createInterfaceRefType() {
		InterfaceRefTypeImpl interfaceRefType = new InterfaceRefTypeImpl();
		return interfaceRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceSliceRefType createInterfaceSliceRefType() {
		InterfaceSliceRefTypeImpl interfaceSliceRefType = new InterfaceSliceRefTypeImpl();
		return interfaceSliceRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceSliceType createInterfaceSliceType() {
		InterfaceSliceTypeImpl interfaceSliceType = new InterfaceSliceTypeImpl();
		return interfaceSliceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceType createInterfaceType() {
		InterfaceTypeImpl interfaceType = new InterfaceTypeImpl();
		return interfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterRenaming createParameterRenaming() {
		ParameterRenamingImpl parameterRenaming = new ParameterRenamingImpl();
		return parameterRenaming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterSupplyType createParameterSupplyType() {
		ParameterSupplyTypeImpl parameterSupplyType = new ParameterSupplyTypeImpl();
		return parameterSupplyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType createParameterType() {
		ParameterTypeImpl parameterType = new ParameterTypeImpl();
		return parameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortSliceType createPortSliceType() {
		PortSliceTypeImpl portSliceType = new PortSliceTypeImpl();
		return portSliceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortType createPortType() {
		PortTypeImpl portType = new PortTypeImpl();
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolChoiceType createProtocolChoiceType() {
		ProtocolChoiceTypeImpl protocolChoiceType = new ProtocolChoiceTypeImpl();
		return protocolChoiceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolCombinatorType createProtocolCombinatorType() {
		ProtocolCombinatorTypeImpl protocolCombinatorType = new ProtocolCombinatorTypeImpl();
		return protocolCombinatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolCombinatorVisualType createProtocolCombinatorVisualType() {
		ProtocolCombinatorVisualTypeImpl protocolCombinatorVisualType = new ProtocolCombinatorVisualTypeImpl();
		return protocolCombinatorVisualType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolPerformType createProtocolPerformType() {
		ProtocolPerformTypeImpl protocolPerformType = new ProtocolPerformTypeImpl();
		return protocolPerformType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolPerformVisualType createProtocolPerformVisualType() {
		ProtocolPerformVisualTypeImpl protocolPerformVisualType = new ProtocolPerformVisualTypeImpl();
		return protocolPerformVisualType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecursiveEntryType createRecursiveEntryType() {
		RecursiveEntryTypeImpl recursiveEntryType = new RecursiveEntryTypeImpl();
		return recursiveEntryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFileType createSourceFileType() {
		SourceFileTypeImpl sourceFileType = new SourceFileTypeImpl();
		return sourceFileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceType createSourceType() {
		SourceTypeImpl sourceType = new SourceTypeImpl();
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SplitEnumeratorType createSplitEnumeratorType() {
		SplitEnumeratorTypeImpl splitEnumeratorType = new SplitEnumeratorTypeImpl();
		return splitEnumeratorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SplitLinkType createSplitLinkType() {
		SplitLinkTypeImpl splitLinkType = new SplitLinkTypeImpl();
		return splitLinkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SplitType createSplitType() {
		SplitTypeImpl splitType = new SplitTypeImpl();
		return splitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitActionType createUnitActionType() {
		UnitActionTypeImpl unitActionType = new UnitActionTypeImpl();
		return unitActionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitBoundsType createUnitBoundsType() {
		UnitBoundsTypeImpl unitBoundsType = new UnitBoundsTypeImpl();
		return unitBoundsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitConditionType createUnitConditionType() {
		UnitConditionTypeImpl unitConditionType = new UnitConditionTypeImpl();
		return unitConditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitRefType createUnitRefType() {
		UnitRefTypeImpl unitRefType = new UnitRefTypeImpl();
		return unitRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitSliceType createUnitSliceType() {
		UnitSliceTypeImpl unitSliceType = new UnitSliceTypeImpl();
		return unitSliceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitType createUnitType() {
		UnitTypeImpl unitType = new UnitTypeImpl();
		return unitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionType createVersionType() {
		VersionTypeImpl versionType = new VersionTypeImpl();
		return versionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualElementAttributes createVisualElementAttributes() {
		VisualElementAttributesImpl visualElementAttributes = new VisualElementAttributesImpl();
		return visualElementAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuantificationType createQuantificationTypeFromString(EDataType eDataType, String initialValue) {
		QuantificationType result = QuantificationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQuantificationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedKinds createSupportedKindsFromString(EDataType eDataType, String initialValue) {
		SupportedKinds result = SupportedKinds.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSupportedKindsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarianceType createVarianceTypeFromString(EDataType eDataType, String initialValue) {
		VarianceType result = VarianceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVarianceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuantificationType createQuantificationTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createQuantificationTypeFromString(ComponentPackage.Literals.QUANTIFICATION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQuantificationTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertQuantificationTypeToString(ComponentPackage.Literals.QUANTIFICATION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedKinds createSupportedKindsObjectFromString(EDataType eDataType, String initialValue) {
		return createSupportedKindsFromString(ComponentPackage.Literals.SUPPORTED_KINDS, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSupportedKindsObjectToString(EDataType eDataType, Object instanceValue) {
		return convertSupportedKindsToString(ComponentPackage.Literals.SUPPORTED_KINDS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarianceType createVarianceTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createVarianceTypeFromString(ComponentPackage.Literals.VARIANCE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVarianceTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertVarianceTypeToString(ComponentPackage.Literals.VARIANCE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPackage getComponentPackage() {
		return (ComponentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComponentPackage getPackage() {
		return ComponentPackage.eINSTANCE;
	}

} //ComponentFactoryImpl
