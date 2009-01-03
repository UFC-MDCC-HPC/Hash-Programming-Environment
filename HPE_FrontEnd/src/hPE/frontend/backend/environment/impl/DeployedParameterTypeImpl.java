/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment.impl;

import hPE.frontend.backend.environment.DeployedParameterType;
import hPE.frontend.backend.environment.EnvironmentPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployed Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl#getActual <em>Actual</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl#getBound <em>Bound</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl#getParameterId <em>Parameter Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeployedParameterTypeImpl extends EObjectImpl implements DeployedParameterType {
	/**
	 * The default value of the '{@link #getActual() <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActual()
	 * @generated
	 * @ordered
	 */
	protected static final int ACTUAL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getActual() <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActual()
	 * @generated
	 * @ordered
	 */
	protected int actual = ACTUAL_EDEFAULT;

	/**
	 * This is true if the Actual attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean actualESet;

	/**
	 * The default value of the '{@link #getBound() <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected static final int BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBound() <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected int bound = BOUND_EDEFAULT;

	/**
	 * This is true if the Bound attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean boundESet;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<DeployedParameterType> parameter;

	/**
	 * The default value of the '{@link #getParameterId() <em>Parameter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterId() <em>Parameter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterId()
	 * @generated
	 * @ordered
	 */
	protected String parameterId = PARAMETER_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployedParameterTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.DEPLOYED_PARAMETER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getActual() {
		return actual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActual(int newActual) {
		int oldActual = actual;
		actual = newActual;
		boolean oldActualESet = actualESet;
		actualESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__ACTUAL, oldActual, actual, !oldActualESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActual() {
		int oldActual = actual;
		boolean oldActualESet = actualESet;
		actual = ACTUAL_EDEFAULT;
		actualESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__ACTUAL, oldActual, ACTUAL_EDEFAULT, oldActualESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActual() {
		return actualESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBound() {
		return bound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBound(int newBound) {
		int oldBound = bound;
		bound = newBound;
		boolean oldBoundESet = boundESet;
		boundESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__BOUND, oldBound, bound, !oldBoundESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBound() {
		int oldBound = bound;
		boolean oldBoundESet = boundESet;
		bound = BOUND_EDEFAULT;
		boundESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__BOUND, oldBound, BOUND_EDEFAULT, oldBoundESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBound() {
		return boundESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeployedParameterType> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<DeployedParameterType>(DeployedParameterType.class, this, EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterId() {
		return parameterId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterId(String newParameterId) {
		String oldParameterId = parameterId;
		parameterId = newParameterId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER_ID, oldParameterId, parameterId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__ACTUAL:
				return new Integer(getActual());
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__BOUND:
				return new Integer(getBound());
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER:
				return getParameter();
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER_ID:
				return getParameterId();
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
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__ACTUAL:
				setActual(((Integer)newValue).intValue());
				return;
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__BOUND:
				setBound(((Integer)newValue).intValue());
				return;
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends DeployedParameterType>)newValue);
				return;
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER_ID:
				setParameterId((String)newValue);
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
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__ACTUAL:
				unsetActual();
				return;
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__BOUND:
				unsetBound();
				return;
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER:
				getParameter().clear();
				return;
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER_ID:
				setParameterId(PARAMETER_ID_EDEFAULT);
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
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__ACTUAL:
				return isSetActual();
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__BOUND:
				return isSetBound();
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case EnvironmentPackage.DEPLOYED_PARAMETER_TYPE__PARAMETER_ID:
				return PARAMETER_ID_EDEFAULT == null ? parameterId != null : !PARAMETER_ID_EDEFAULT.equals(parameterId);
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
		result.append(" (actual: ");
		if (actualESet) result.append(actual); else result.append("<unset>");
		result.append(", bound: ");
		if (boundESet) result.append(bound); else result.append("<unset>");
		result.append(", parameterId: ");
		result.append(parameterId);
		result.append(')');
		return result.toString();
	}

} //DeployedParameterTypeImpl
