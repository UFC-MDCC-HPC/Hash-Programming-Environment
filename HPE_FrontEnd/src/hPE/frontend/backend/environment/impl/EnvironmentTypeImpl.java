/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment.impl;

import hPE.frontend.backend.environment.DeployedComponentInfoType;
import hPE.frontend.backend.environment.EnvironmentPackage;
import hPE.frontend.backend.environment.EnvironmentType;

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
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.backend.environment.impl.EnvironmentTypeImpl#getDeployed <em>Deployed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentTypeImpl extends EObjectImpl implements EnvironmentType {
	/**
	 * The cached value of the '{@link #getDeployed() <em>Deployed</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeployed()
	 * @generated
	 * @ordered
	 */
	protected EList<DeployedComponentInfoType> deployed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.ENVIRONMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeployedComponentInfoType> getDeployed() {
		if (deployed == null) {
			deployed = new EObjectContainmentEList<DeployedComponentInfoType>(DeployedComponentInfoType.class, this, EnvironmentPackage.ENVIRONMENT_TYPE__DEPLOYED);
		}
		return deployed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EnvironmentPackage.ENVIRONMENT_TYPE__DEPLOYED:
				return ((InternalEList<?>)getDeployed()).basicRemove(otherEnd, msgs);
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
			case EnvironmentPackage.ENVIRONMENT_TYPE__DEPLOYED:
				return getDeployed();
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
			case EnvironmentPackage.ENVIRONMENT_TYPE__DEPLOYED:
				getDeployed().clear();
				getDeployed().addAll((Collection<? extends DeployedComponentInfoType>)newValue);
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
			case EnvironmentPackage.ENVIRONMENT_TYPE__DEPLOYED:
				getDeployed().clear();
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
			case EnvironmentPackage.ENVIRONMENT_TYPE__DEPLOYED:
				return deployed != null && !deployed.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnvironmentTypeImpl
