/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.util;

import hPE.xml.component.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hPE.xml.component.ComponentPackage
 * @generated
 */
public class ComponentAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComponentPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ComponentPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentSwitch<Adapter> modelSwitch =
		new ComponentSwitch<Adapter>() {
			@Override
			public Adapter caseActionType(ActionType object) {
				return createActionTypeAdapter();
			}
			@Override
			public Adapter caseBaseTypeType(BaseTypeType object) {
				return createBaseTypeTypeAdapter();
			}
			@Override
			public Adapter caseColorComplexType(ColorComplexType object) {
				return createColorComplexTypeAdapter();
			}
			@Override
			public Adapter caseComponentBodyType(ComponentBodyType object) {
				return createComponentBodyTypeAdapter();
			}
			@Override
			public Adapter caseComponentHeaderType(ComponentHeaderType object) {
				return createComponentHeaderTypeAdapter();
			}
			@Override
			public Adapter caseComponentInUseType(ComponentInUseType object) {
				return createComponentInUseTypeAdapter();
			}
			@Override
			public Adapter caseComponentType(ComponentType object) {
				return createComponentTypeAdapter();
			}
			@Override
			public Adapter caseConditionType(ConditionType object) {
				return createConditionTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseEntryType(EntryType object) {
				return createEntryTypeAdapter();
			}
			@Override
			public Adapter caseEnumerableComponentType(EnumerableComponentType object) {
				return createEnumerableComponentTypeAdapter();
			}
			@Override
			public Adapter caseEnumerableEntryType(EnumerableEntryType object) {
				return createEnumerableEntryTypeAdapter();
			}
			@Override
			public Adapter caseEnumerableType(EnumerableType object) {
				return createEnumerableTypeAdapter();
			}
			@Override
			public Adapter caseEnumerableUnitSliceType(EnumerableUnitSliceType object) {
				return createEnumerableUnitSliceTypeAdapter();
			}
			@Override
			public Adapter caseEnumerableUnitType(EnumerableUnitType object) {
				return createEnumerableUnitTypeAdapter();
			}
			@Override
			public Adapter caseEnumeratorFromRecursionType(EnumeratorFromRecursionType object) {
				return createEnumeratorFromRecursionTypeAdapter();
			}
			@Override
			public Adapter caseEnumeratorRefType(EnumeratorRefType object) {
				return createEnumeratorRefTypeAdapter();
			}
			@Override
			public Adapter caseEnumeratorType(EnumeratorType object) {
				return createEnumeratorTypeAdapter();
			}
			@Override
			public Adapter caseExposePortType(ExposePortType object) {
				return createExposePortTypeAdapter();
			}
			@Override
			public Adapter caseExtendsType(ExtendsType object) {
				return createExtendsTypeAdapter();
			}
			@Override
			public Adapter caseExtensionTypeType(ExtensionTypeType object) {
				return createExtensionTypeTypeAdapter();
			}
			@Override
			public Adapter caseFusionOfReplicatorsType(FusionOfReplicatorsType object) {
				return createFusionOfReplicatorsTypeAdapter();
			}
			@Override
			public Adapter caseFusionsOfReplicatorsType(FusionsOfReplicatorsType object) {
				return createFusionsOfReplicatorsTypeAdapter();
			}
			@Override
			public Adapter caseFusionType(FusionType object) {
				return createFusionTypeAdapter();
			}
			@Override
			public Adapter caseGuardAndType(GuardAndType object) {
				return createGuardAndTypeAdapter();
			}
			@Override
			public Adapter caseGuardConditionType(GuardConditionType object) {
				return createGuardConditionTypeAdapter();
			}
			@Override
			public Adapter caseGuardNotType(GuardNotType object) {
				return createGuardNotTypeAdapter();
			}
			@Override
			public Adapter caseGuardOrType(GuardOrType object) {
				return createGuardOrTypeAdapter();
			}
			@Override
			public Adapter caseGuardType(GuardType object) {
				return createGuardTypeAdapter();
			}
			@Override
			public Adapter caseImplementsType(ImplementsType object) {
				return createImplementsTypeAdapter();
			}
			@Override
			public Adapter caseInnerComponentType(InnerComponentType object) {
				return createInnerComponentTypeAdapter();
			}
			@Override
			public Adapter caseInnerRenamingType(InnerRenamingType object) {
				return createInnerRenamingTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceParameterType(InterfaceParameterType object) {
				return createInterfaceParameterTypeAdapter();
			}
			@Override
			public Adapter caseInterfacePortType(InterfacePortType object) {
				return createInterfacePortTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceRefType(InterfaceRefType object) {
				return createInterfaceRefTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceSliceRefType(InterfaceSliceRefType object) {
				return createInterfaceSliceRefTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceSliceType(InterfaceSliceType object) {
				return createInterfaceSliceTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceType(InterfaceType object) {
				return createInterfaceTypeAdapter();
			}
			@Override
			public Adapter caseParameterRenaming(ParameterRenaming object) {
				return createParameterRenamingAdapter();
			}
			@Override
			public Adapter caseParameterSupplyType(ParameterSupplyType object) {
				return createParameterSupplyTypeAdapter();
			}
			@Override
			public Adapter caseParameterType(ParameterType object) {
				return createParameterTypeAdapter();
			}
			@Override
			public Adapter casePortSliceType(PortSliceType object) {
				return createPortSliceTypeAdapter();
			}
			@Override
			public Adapter casePortType(PortType object) {
				return createPortTypeAdapter();
			}
			@Override
			public Adapter caseProtocolChoiceType(ProtocolChoiceType object) {
				return createProtocolChoiceTypeAdapter();
			}
			@Override
			public Adapter caseProtocolCombinatorType(ProtocolCombinatorType object) {
				return createProtocolCombinatorTypeAdapter();
			}
			@Override
			public Adapter caseProtocolPerformType(ProtocolPerformType object) {
				return createProtocolPerformTypeAdapter();
			}
			@Override
			public Adapter caseProtocolType(ProtocolType object) {
				return createProtocolTypeAdapter();
			}
			@Override
			public Adapter caseRecursiveEntryType(RecursiveEntryType object) {
				return createRecursiveEntryTypeAdapter();
			}
			@Override
			public Adapter caseSourceFileType(SourceFileType object) {
				return createSourceFileTypeAdapter();
			}
			@Override
			public Adapter caseSourceType(SourceType object) {
				return createSourceTypeAdapter();
			}
			@Override
			public Adapter caseSplitEnumeratorType(SplitEnumeratorType object) {
				return createSplitEnumeratorTypeAdapter();
			}
			@Override
			public Adapter caseSplitLinkType(SplitLinkType object) {
				return createSplitLinkTypeAdapter();
			}
			@Override
			public Adapter caseSplitType(SplitType object) {
				return createSplitTypeAdapter();
			}
			@Override
			public Adapter caseUnitBoundsType(UnitBoundsType object) {
				return createUnitBoundsTypeAdapter();
			}
			@Override
			public Adapter caseUnitRefType(UnitRefType object) {
				return createUnitRefTypeAdapter();
			}
			@Override
			public Adapter caseUnitSliceType(UnitSliceType object) {
				return createUnitSliceTypeAdapter();
			}
			@Override
			public Adapter caseUnitType(UnitType object) {
				return createUnitTypeAdapter();
			}
			@Override
			public Adapter caseVersionType(VersionType object) {
				return createVersionTypeAdapter();
			}
			@Override
			public Adapter caseVisualElementAttributes(VisualElementAttributes object) {
				return createVisualElementAttributesAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ActionType
	 * @generated
	 */
	public Adapter createActionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.BaseTypeType <em>Base Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.BaseTypeType
	 * @generated
	 */
	public Adapter createBaseTypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ColorComplexType <em>Color Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ColorComplexType
	 * @generated
	 */
	public Adapter createColorComplexTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ComponentBodyType <em>Body Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ComponentBodyType
	 * @generated
	 */
	public Adapter createComponentBodyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ComponentHeaderType <em>Header Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ComponentHeaderType
	 * @generated
	 */
	public Adapter createComponentHeaderTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ComponentInUseType <em>In Use Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ComponentInUseType
	 * @generated
	 */
	public Adapter createComponentInUseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ComponentType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ComponentType
	 * @generated
	 */
	public Adapter createComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ConditionType
	 * @generated
	 */
	public Adapter createConditionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EntryType <em>Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EntryType
	 * @generated
	 */
	public Adapter createEntryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumerableComponentType <em>Enumerable Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumerableComponentType
	 * @generated
	 */
	public Adapter createEnumerableComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumerableEntryType <em>Enumerable Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumerableEntryType
	 * @generated
	 */
	public Adapter createEnumerableEntryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumerableType <em>Enumerable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumerableType
	 * @generated
	 */
	public Adapter createEnumerableTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumerableUnitSliceType <em>Enumerable Unit Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumerableUnitSliceType
	 * @generated
	 */
	public Adapter createEnumerableUnitSliceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumerableUnitType <em>Enumerable Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumerableUnitType
	 * @generated
	 */
	public Adapter createEnumerableUnitTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumeratorFromRecursionType <em>Enumerator From Recursion Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumeratorFromRecursionType
	 * @generated
	 */
	public Adapter createEnumeratorFromRecursionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumeratorRefType <em>Enumerator Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumeratorRefType
	 * @generated
	 */
	public Adapter createEnumeratorRefTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.EnumeratorType <em>Enumerator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.EnumeratorType
	 * @generated
	 */
	public Adapter createEnumeratorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ExposePortType <em>Expose Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ExposePortType
	 * @generated
	 */
	public Adapter createExposePortTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ExtendsType <em>Extends Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ExtendsType
	 * @generated
	 */
	public Adapter createExtendsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ExtensionTypeType <em>Extension Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ExtensionTypeType
	 * @generated
	 */
	public Adapter createExtensionTypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.FusionOfReplicatorsType <em>Fusion Of Replicators Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.FusionOfReplicatorsType
	 * @generated
	 */
	public Adapter createFusionOfReplicatorsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.FusionsOfReplicatorsType <em>Fusions Of Replicators Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.FusionsOfReplicatorsType
	 * @generated
	 */
	public Adapter createFusionsOfReplicatorsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.FusionType <em>Fusion Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.FusionType
	 * @generated
	 */
	public Adapter createFusionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.GuardAndType <em>Guard And Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.GuardAndType
	 * @generated
	 */
	public Adapter createGuardAndTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.GuardConditionType <em>Guard Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.GuardConditionType
	 * @generated
	 */
	public Adapter createGuardConditionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.GuardNotType <em>Guard Not Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.GuardNotType
	 * @generated
	 */
	public Adapter createGuardNotTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.GuardOrType <em>Guard Or Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.GuardOrType
	 * @generated
	 */
	public Adapter createGuardOrTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.GuardType <em>Guard Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.GuardType
	 * @generated
	 */
	public Adapter createGuardTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ImplementsType <em>Implements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ImplementsType
	 * @generated
	 */
	public Adapter createImplementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InnerComponentType <em>Inner Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InnerComponentType
	 * @generated
	 */
	public Adapter createInnerComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InnerRenamingType <em>Inner Renaming Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InnerRenamingType
	 * @generated
	 */
	public Adapter createInnerRenamingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InterfaceParameterType <em>Interface Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InterfaceParameterType
	 * @generated
	 */
	public Adapter createInterfaceParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InterfacePortType <em>Interface Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InterfacePortType
	 * @generated
	 */
	public Adapter createInterfacePortTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InterfaceRefType <em>Interface Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InterfaceRefType
	 * @generated
	 */
	public Adapter createInterfaceRefTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InterfaceSliceRefType <em>Interface Slice Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InterfaceSliceRefType
	 * @generated
	 */
	public Adapter createInterfaceSliceRefTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InterfaceSliceType <em>Interface Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InterfaceSliceType
	 * @generated
	 */
	public Adapter createInterfaceSliceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.InterfaceType <em>Interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.InterfaceType
	 * @generated
	 */
	public Adapter createInterfaceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ParameterRenaming <em>Parameter Renaming</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ParameterRenaming
	 * @generated
	 */
	public Adapter createParameterRenamingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ParameterSupplyType <em>Parameter Supply Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ParameterSupplyType
	 * @generated
	 */
	public Adapter createParameterSupplyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ParameterType
	 * @generated
	 */
	public Adapter createParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.PortSliceType <em>Port Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.PortSliceType
	 * @generated
	 */
	public Adapter createPortSliceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.PortType
	 * @generated
	 */
	public Adapter createPortTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ProtocolChoiceType <em>Protocol Choice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ProtocolChoiceType
	 * @generated
	 */
	public Adapter createProtocolChoiceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ProtocolCombinatorType <em>Protocol Combinator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ProtocolCombinatorType
	 * @generated
	 */
	public Adapter createProtocolCombinatorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ProtocolPerformType <em>Protocol Perform Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ProtocolPerformType
	 * @generated
	 */
	public Adapter createProtocolPerformTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.ProtocolType <em>Protocol Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.ProtocolType
	 * @generated
	 */
	public Adapter createProtocolTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.RecursiveEntryType <em>Recursive Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.RecursiveEntryType
	 * @generated
	 */
	public Adapter createRecursiveEntryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.SourceFileType <em>Source File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.SourceFileType
	 * @generated
	 */
	public Adapter createSourceFileTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.SourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.SourceType
	 * @generated
	 */
	public Adapter createSourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.SplitEnumeratorType <em>Split Enumerator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.SplitEnumeratorType
	 * @generated
	 */
	public Adapter createSplitEnumeratorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.SplitLinkType <em>Split Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.SplitLinkType
	 * @generated
	 */
	public Adapter createSplitLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.SplitType <em>Split Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.SplitType
	 * @generated
	 */
	public Adapter createSplitTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.UnitBoundsType <em>Unit Bounds Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.UnitBoundsType
	 * @generated
	 */
	public Adapter createUnitBoundsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.UnitRefType <em>Unit Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.UnitRefType
	 * @generated
	 */
	public Adapter createUnitRefTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.UnitSliceType <em>Unit Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.UnitSliceType
	 * @generated
	 */
	public Adapter createUnitSliceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.UnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.UnitType
	 * @generated
	 */
	public Adapter createUnitTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.VersionType <em>Version Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.VersionType
	 * @generated
	 */
	public Adapter createVersionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.xml.component.VisualElementAttributes <em>Visual Element Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.xml.component.VisualElementAttributes
	 * @generated
	 */
	public Adapter createVisualElementAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ComponentAdapterFactory
