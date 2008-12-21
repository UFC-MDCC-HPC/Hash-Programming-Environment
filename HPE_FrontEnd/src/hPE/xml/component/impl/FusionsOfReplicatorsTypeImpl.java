/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.FusionOfReplicatorsType;
import hPE.xml.component.FusionsOfReplicatorsType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fusions Of Replicators Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.FusionsOfReplicatorsTypeImpl#getFusionOfReplicators <em>Fusion Of Replicators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FusionsOfReplicatorsTypeImpl extends EObjectImpl implements FusionsOfReplicatorsType {
	/**
	 * The cached value of the '{@link #getFusionOfReplicators() <em>Fusion Of Replicators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFusionOfReplicators()
	 * @generated
	 * @ordered
	 */
	protected EList<FusionOfReplicatorsType> fusionOfReplicators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FusionsOfReplicatorsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.FUSIONS_OF_REPLICATORS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FusionOfReplicatorsType> getFusionOfReplicators() {
		if (fusionOfReplicators == null) {
			fusionOfReplicators = new EObjectContainmentEList<FusionOfReplicatorsType>(FusionOfReplicatorsType.class, this, ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS);
		}
		return fusionOfReplicators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS:
				return ((InternalEList<?>)getFusionOfReplicators()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS:
				return getFusionOfReplicators();
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
			case ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS:
				getFusionOfReplicators().clear();
				getFusionOfReplicators().addAll((Collection<? extends FusionOfReplicatorsType>)newValue);
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
			case ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS:
				getFusionOfReplicators().clear();
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
			case ComponentPackage.FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS:
				return fusionOfReplicators != null && !fusionOfReplicators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FusionsOfReplicatorsTypeImpl
