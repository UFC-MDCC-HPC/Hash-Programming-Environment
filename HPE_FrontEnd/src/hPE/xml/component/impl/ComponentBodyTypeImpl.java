/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentBodyType;
import hPE.xml.component.ComponentPackage;
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
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Body Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getInnerComponent <em>Inner Component</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getSupplyParameter <em>Supply Parameter</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getInnerRenaming <em>Inner Renaming</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getFusion <em>Fusion</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getSplit <em>Split</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getRecursiveEntry <em>Recursive Entry</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getEnumerator <em>Enumerator</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getFusionsOfReplicators <em>Fusions Of Replicators</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentBodyTypeImpl#getExternalLibrary <em>External Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentBodyTypeImpl extends MinimalEObjectImpl.Container implements ComponentBodyType {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentBodyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.COMPONENT_BODY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, ComponentPackage.COMPONENT_BODY_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InnerComponentType> getInnerComponent() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__INNER_COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterSupplyType> getSupplyParameter() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__SUPPLY_PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InnerRenamingType> getInnerRenaming() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__INNER_RENAMING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FusionType> getFusion() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__FUSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RecursiveEntryType> getRecursiveEntry() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__RECURSIVE_ENTRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterType> getParameter() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceType> getInterface() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__INTERFACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitType> getUnit() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumeratorType> getEnumerator() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__ENUMERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FusionsOfReplicatorsType> getFusionsOfReplicators() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalLibraryType> getExternalLibrary() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__EXTERNAL_LIBRARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SplitType> getSplit() {
		return getGroup().list(ComponentPackage.Literals.COMPONENT_BODY_TYPE__SPLIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.COMPONENT_BODY_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_COMPONENT:
				return ((InternalEList<?>)getInnerComponent()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__SUPPLY_PARAMETER:
				return ((InternalEList<?>)getSupplyParameter()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_RENAMING:
				return ((InternalEList<?>)getInnerRenaming()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSION:
				return ((InternalEList<?>)getFusion()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__SPLIT:
				return ((InternalEList<?>)getSplit()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__RECURSIVE_ENTRY:
				return ((InternalEList<?>)getRecursiveEntry()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__INTERFACE:
				return ((InternalEList<?>)getInterface()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__UNIT:
				return ((InternalEList<?>)getUnit()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__ENUMERATOR:
				return ((InternalEList<?>)getEnumerator()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS:
				return ((InternalEList<?>)getFusionsOfReplicators()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_BODY_TYPE__EXTERNAL_LIBRARY:
				return ((InternalEList<?>)getExternalLibrary()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.COMPONENT_BODY_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_COMPONENT:
				return getInnerComponent();
			case ComponentPackage.COMPONENT_BODY_TYPE__PARAMETER:
				return getParameter();
			case ComponentPackage.COMPONENT_BODY_TYPE__SUPPLY_PARAMETER:
				return getSupplyParameter();
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_RENAMING:
				return getInnerRenaming();
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSION:
				return getFusion();
			case ComponentPackage.COMPONENT_BODY_TYPE__SPLIT:
				return getSplit();
			case ComponentPackage.COMPONENT_BODY_TYPE__RECURSIVE_ENTRY:
				return getRecursiveEntry();
			case ComponentPackage.COMPONENT_BODY_TYPE__INTERFACE:
				return getInterface();
			case ComponentPackage.COMPONENT_BODY_TYPE__UNIT:
				return getUnit();
			case ComponentPackage.COMPONENT_BODY_TYPE__ENUMERATOR:
				return getEnumerator();
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS:
				return getFusionsOfReplicators();
			case ComponentPackage.COMPONENT_BODY_TYPE__EXTERNAL_LIBRARY:
				return getExternalLibrary();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.COMPONENT_BODY_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_COMPONENT:
				getInnerComponent().clear();
				getInnerComponent().addAll((Collection<? extends InnerComponentType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends ParameterType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__SUPPLY_PARAMETER:
				getSupplyParameter().clear();
				getSupplyParameter().addAll((Collection<? extends ParameterSupplyType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_RENAMING:
				getInnerRenaming().clear();
				getInnerRenaming().addAll((Collection<? extends InnerRenamingType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSION:
				getFusion().clear();
				getFusion().addAll((Collection<? extends FusionType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__SPLIT:
				getSplit().clear();
				getSplit().addAll((Collection<? extends SplitType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__RECURSIVE_ENTRY:
				getRecursiveEntry().clear();
				getRecursiveEntry().addAll((Collection<? extends RecursiveEntryType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__INTERFACE:
				getInterface().clear();
				getInterface().addAll((Collection<? extends InterfaceType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__UNIT:
				getUnit().clear();
				getUnit().addAll((Collection<? extends UnitType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__ENUMERATOR:
				getEnumerator().clear();
				getEnumerator().addAll((Collection<? extends EnumeratorType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS:
				getFusionsOfReplicators().clear();
				getFusionsOfReplicators().addAll((Collection<? extends FusionsOfReplicatorsType>)newValue);
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__EXTERNAL_LIBRARY:
				getExternalLibrary().clear();
				getExternalLibrary().addAll((Collection<? extends ExternalLibraryType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentPackage.COMPONENT_BODY_TYPE__GROUP:
				getGroup().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_COMPONENT:
				getInnerComponent().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__PARAMETER:
				getParameter().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__SUPPLY_PARAMETER:
				getSupplyParameter().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_RENAMING:
				getInnerRenaming().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSION:
				getFusion().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__SPLIT:
				getSplit().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__RECURSIVE_ENTRY:
				getRecursiveEntry().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__INTERFACE:
				getInterface().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__UNIT:
				getUnit().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__ENUMERATOR:
				getEnumerator().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS:
				getFusionsOfReplicators().clear();
				return;
			case ComponentPackage.COMPONENT_BODY_TYPE__EXTERNAL_LIBRARY:
				getExternalLibrary().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentPackage.COMPONENT_BODY_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_COMPONENT:
				return !getInnerComponent().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__PARAMETER:
				return !getParameter().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__SUPPLY_PARAMETER:
				return !getSupplyParameter().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__INNER_RENAMING:
				return !getInnerRenaming().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSION:
				return !getFusion().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__SPLIT:
				return !getSplit().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__RECURSIVE_ENTRY:
				return !getRecursiveEntry().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__INTERFACE:
				return !getInterface().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__UNIT:
				return !getUnit().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__ENUMERATOR:
				return !getEnumerator().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS:
				return !getFusionsOfReplicators().isEmpty();
			case ComponentPackage.COMPONENT_BODY_TYPE__EXTERNAL_LIBRARY:
				return !getExternalLibrary().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (group: ");
		result.append(group);
		result.append(')');
		return result.toString();
	}

} //ComponentBodyTypeImpl
