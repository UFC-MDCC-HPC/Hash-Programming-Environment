/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hPE.xml.component.ComponentPackage
 * @generated
 */
public interface ComponentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentFactory eINSTANCE = hPE.xml.component.impl.ComponentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Action Activate Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Activate Type</em>'.
	 * @generated
	 */
	ActionActivateType createActionActivateType();

	/**
	 * Returns a new object of class '<em>Action Combinator Alt Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Combinator Alt Type</em>'.
	 * @generated
	 */
	ActionCombinatorAltType createActionCombinatorAltType();

	/**
	 * Returns a new object of class '<em>Action Combinator Par Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Combinator Par Type</em>'.
	 * @generated
	 */
	ActionCombinatorParType createActionCombinatorParType();

	/**
	 * Returns a new object of class '<em>Action Combinator Seq Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Combinator Seq Type</em>'.
	 * @generated
	 */
	ActionCombinatorSeqType createActionCombinatorSeqType();

	/**
	 * Returns a new object of class '<em>Action Combinator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Combinator Type</em>'.
	 * @generated
	 */
	ActionCombinatorType createActionCombinatorType();

	/**
	 * Returns a new object of class '<em>Action Signal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Signal Type</em>'.
	 * @generated
	 */
	ActionSignalType createActionSignalType();

	/**
	 * Returns a new object of class '<em>Action Skip Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Skip Type</em>'.
	 * @generated
	 */
	ActionSkipType createActionSkipType();

	/**
	 * Returns a new object of class '<em>Action Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Type</em>'.
	 * @generated
	 */
	ActionType createActionType();

	/**
	 * Returns a new object of class '<em>Action Wait Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Wait Type</em>'.
	 * @generated
	 */
	ActionWaitType createActionWaitType();

	/**
	 * Returns a new object of class '<em>Base Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Type Type</em>'.
	 * @generated
	 */
	BaseTypeType createBaseTypeType();

	/**
	 * Returns a new object of class '<em>Color Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Complex Type</em>'.
	 * @generated
	 */
	ColorComplexType createColorComplexType();

	/**
	 * Returns a new object of class '<em>Body Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Body Type</em>'.
	 * @generated
	 */
	ComponentBodyType createComponentBodyType();

	/**
	 * Returns a new object of class '<em>Header Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Header Type</em>'.
	 * @generated
	 */
	ComponentHeaderType createComponentHeaderType();

	/**
	 * Returns a new object of class '<em>In Use Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Use Type</em>'.
	 * @generated
	 */
	ComponentInUseType createComponentInUseType();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	ComponentType createComponentType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Type</em>'.
	 * @generated
	 */
	EntryType createEntryType();

	/**
	 * Returns a new object of class '<em>Enumerable Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerable Component Type</em>'.
	 * @generated
	 */
	EnumerableComponentType createEnumerableComponentType();

	/**
	 * Returns a new object of class '<em>Enumerable Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerable Entry Type</em>'.
	 * @generated
	 */
	EnumerableEntryType createEnumerableEntryType();

	/**
	 * Returns a new object of class '<em>Enumerable Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerable Type</em>'.
	 * @generated
	 */
	EnumerableType createEnumerableType();

	/**
	 * Returns a new object of class '<em>Enumerable Unit Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerable Unit Slice Type</em>'.
	 * @generated
	 */
	EnumerableUnitSliceType createEnumerableUnitSliceType();

	/**
	 * Returns a new object of class '<em>Enumerable Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerable Unit Type</em>'.
	 * @generated
	 */
	EnumerableUnitType createEnumerableUnitType();

	/**
	 * Returns a new object of class '<em>Enumerator From Recursion Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerator From Recursion Type</em>'.
	 * @generated
	 */
	EnumeratorFromRecursionType createEnumeratorFromRecursionType();

	/**
	 * Returns a new object of class '<em>Enumerator Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerator Ref Type</em>'.
	 * @generated
	 */
	EnumeratorRefType createEnumeratorRefType();

	/**
	 * Returns a new object of class '<em>Enumerator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerator Type</em>'.
	 * @generated
	 */
	EnumeratorType createEnumeratorType();

	/**
	 * Returns a new object of class '<em>Expose Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expose Port Type</em>'.
	 * @generated
	 */
	ExposePortType createExposePortType();

	/**
	 * Returns a new object of class '<em>Extends Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Type</em>'.
	 * @generated
	 */
	ExtendsType createExtendsType();

	/**
	 * Returns a new object of class '<em>Extension Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Type Type</em>'.
	 * @generated
	 */
	ExtensionTypeType createExtensionTypeType();

	/**
	 * Returns a new object of class '<em>Fusion Of Replicators Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fusion Of Replicators Type</em>'.
	 * @generated
	 */
	FusionOfReplicatorsType createFusionOfReplicatorsType();

	/**
	 * Returns a new object of class '<em>Fusions Of Replicators Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fusions Of Replicators Type</em>'.
	 * @generated
	 */
	FusionsOfReplicatorsType createFusionsOfReplicatorsType();

	/**
	 * Returns a new object of class '<em>Fusion Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fusion Type</em>'.
	 * @generated
	 */
	FusionType createFusionType();

	/**
	 * Returns a new object of class '<em>Implements Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implements Type</em>'.
	 * @generated
	 */
	ImplementsType createImplementsType();

	/**
	 * Returns a new object of class '<em>Inner Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inner Component Type</em>'.
	 * @generated
	 */
	InnerComponentType createInnerComponentType();

	/**
	 * Returns a new object of class '<em>Inner Renaming Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inner Renaming Type</em>'.
	 * @generated
	 */
	InnerRenamingType createInnerRenamingType();

	/**
	 * Returns a new object of class '<em>Interface Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Parameter Type</em>'.
	 * @generated
	 */
	InterfaceParameterType createInterfaceParameterType();

	/**
	 * Returns a new object of class '<em>Interface Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Port Type</em>'.
	 * @generated
	 */
	InterfacePortType createInterfacePortType();

	/**
	 * Returns a new object of class '<em>Interface Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Ref Type</em>'.
	 * @generated
	 */
	InterfaceRefType createInterfaceRefType();

	/**
	 * Returns a new object of class '<em>Interface Slice Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Slice Ref Type</em>'.
	 * @generated
	 */
	InterfaceSliceRefType createInterfaceSliceRefType();

	/**
	 * Returns a new object of class '<em>Interface Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Slice Type</em>'.
	 * @generated
	 */
	InterfaceSliceType createInterfaceSliceType();

	/**
	 * Returns a new object of class '<em>Interface Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Type</em>'.
	 * @generated
	 */
	InterfaceType createInterfaceType();

	/**
	 * Returns a new object of class '<em>Parameter Renaming</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Renaming</em>'.
	 * @generated
	 */
	ParameterRenaming createParameterRenaming();

	/**
	 * Returns a new object of class '<em>Parameter Supply Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Supply Type</em>'.
	 * @generated
	 */
	ParameterSupplyType createParameterSupplyType();

	/**
	 * Returns a new object of class '<em>Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Type</em>'.
	 * @generated
	 */
	ParameterType createParameterType();

	/**
	 * Returns a new object of class '<em>Port Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Slice Type</em>'.
	 * @generated
	 */
	PortSliceType createPortSliceType();

	/**
	 * Returns a new object of class '<em>Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Type</em>'.
	 * @generated
	 */
	PortType createPortType();

	/**
	 * Returns a new object of class '<em>Quantification Var Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quantification Var Type</em>'.
	 * @generated
	 */
	QuantificationVarType createQuantificationVarType();

	/**
	 * Returns a new object of class '<em>Recursive Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recursive Entry Type</em>'.
	 * @generated
	 */
	RecursiveEntryType createRecursiveEntryType();

	/**
	 * Returns a new object of class '<em>Source File Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source File Type</em>'.
	 * @generated
	 */
	SourceFileType createSourceFileType();

	/**
	 * Returns a new object of class '<em>Source Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Type</em>'.
	 * @generated
	 */
	SourceType createSourceType();

	/**
	 * Returns a new object of class '<em>Split Enumerator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Split Enumerator Type</em>'.
	 * @generated
	 */
	SplitEnumeratorType createSplitEnumeratorType();

	/**
	 * Returns a new object of class '<em>Split Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Split Link Type</em>'.
	 * @generated
	 */
	SplitLinkType createSplitLinkType();

	/**
	 * Returns a new object of class '<em>Split Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Split Type</em>'.
	 * @generated
	 */
	SplitType createSplitType();

	/**
	 * Returns a new object of class '<em>Unit Bounds Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Bounds Type</em>'.
	 * @generated
	 */
	UnitBoundsType createUnitBoundsType();

	/**
	 * Returns a new object of class '<em>Unit Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Ref Type</em>'.
	 * @generated
	 */
	UnitRefType createUnitRefType();

	/**
	 * Returns a new object of class '<em>Unit Slice Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Slice Type</em>'.
	 * @generated
	 */
	UnitSliceType createUnitSliceType();

	/**
	 * Returns a new object of class '<em>Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Type</em>'.
	 * @generated
	 */
	UnitType createUnitType();

	/**
	 * Returns a new object of class '<em>Version Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version Type</em>'.
	 * @generated
	 */
	VersionType createVersionType();

	/**
	 * Returns a new object of class '<em>Visual Element Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visual Element Attributes</em>'.
	 * @generated
	 */
	VisualElementAttributes createVisualElementAttributes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComponentPackage getComponentPackage();

} //ComponentFactory
