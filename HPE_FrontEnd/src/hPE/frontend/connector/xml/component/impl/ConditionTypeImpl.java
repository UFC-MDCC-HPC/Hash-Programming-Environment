/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.impl;

import hPE.frontend.connector.xml.component.ComponentPackage;
import hPE.frontend.connector.xml.component.ConditionType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.ConditionTypeImpl#getCondId <em>Cond Id</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.ConditionTypeImpl#getSliceId <em>Slice Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionTypeImpl extends EObjectImpl implements ConditionType {
	/**
	 * The default value of the '{@link #getCondId() <em>Cond Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondId()
	 * @generated
	 * @ordered
	 */
	protected static final String COND_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondId() <em>Cond Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondId()
	 * @generated
	 * @ordered
	 */
	protected String condId = COND_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSliceId() <em>Slice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceId()
	 * @generated
	 * @ordered
	 */
	protected static final String SLICE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSliceId() <em>Slice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceId()
	 * @generated
	 * @ordered
	 */
	protected String sliceId = SLICE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.CONDITION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondId() {
		return condId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondId(String newCondId) {
		String oldCondId = condId;
		condId = newCondId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.CONDITION_TYPE__COND_ID, oldCondId, condId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSliceId() {
		return sliceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSliceId(String newSliceId) {
		String oldSliceId = sliceId;
		sliceId = newSliceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.CONDITION_TYPE__SLICE_ID, oldSliceId, sliceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.CONDITION_TYPE__COND_ID:
				return getCondId();
			case ComponentPackage.CONDITION_TYPE__SLICE_ID:
				return getSliceId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.CONDITION_TYPE__COND_ID:
				setCondId((String)newValue);
				return;
			case ComponentPackage.CONDITION_TYPE__SLICE_ID:
				setSliceId((String)newValue);
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
			case ComponentPackage.CONDITION_TYPE__COND_ID:
				setCondId(COND_ID_EDEFAULT);
				return;
			case ComponentPackage.CONDITION_TYPE__SLICE_ID:
				setSliceId(SLICE_ID_EDEFAULT);
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
			case ComponentPackage.CONDITION_TYPE__COND_ID:
				return COND_ID_EDEFAULT == null ? condId != null : !COND_ID_EDEFAULT.equals(condId);
			case ComponentPackage.CONDITION_TYPE__SLICE_ID:
				return SLICE_ID_EDEFAULT == null ? sliceId != null : !SLICE_ID_EDEFAULT.equals(sliceId);
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
		result.append(" (condId: ");
		result.append(condId);
		result.append(", sliceId: ");
		result.append(sliceId);
		result.append(')');
		return result.toString();
	}

} //ConditionTypeImpl
