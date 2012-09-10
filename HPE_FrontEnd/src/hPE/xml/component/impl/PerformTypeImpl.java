/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.PerformType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Perform Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.PerformTypeImpl#getActionId <em>Action Id</em>}</li>
 *   <li>{@link hPE.xml.component.impl.PerformTypeImpl#getSliceId <em>Slice Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PerformTypeImpl extends EObjectImpl implements PerformType {
	/**
	 * The default value of the '{@link #getActionId() <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionId()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionId() <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionId()
	 * @generated
	 * @ordered
	 */
	protected String actionId = ACTION_ID_EDEFAULT;

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
	protected PerformTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.PERFORM_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionId() {
		return actionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionId(String newActionId) {
		String oldActionId = actionId;
		actionId = newActionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PERFORM_TYPE__ACTION_ID, oldActionId, actionId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PERFORM_TYPE__SLICE_ID, oldSliceId, sliceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.PERFORM_TYPE__ACTION_ID:
				return getActionId();
			case ComponentPackage.PERFORM_TYPE__SLICE_ID:
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
			case ComponentPackage.PERFORM_TYPE__ACTION_ID:
				setActionId((String)newValue);
				return;
			case ComponentPackage.PERFORM_TYPE__SLICE_ID:
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
			case ComponentPackage.PERFORM_TYPE__ACTION_ID:
				setActionId(ACTION_ID_EDEFAULT);
				return;
			case ComponentPackage.PERFORM_TYPE__SLICE_ID:
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
			case ComponentPackage.PERFORM_TYPE__ACTION_ID:
				return ACTION_ID_EDEFAULT == null ? actionId != null : !ACTION_ID_EDEFAULT.equals(actionId);
			case ComponentPackage.PERFORM_TYPE__SLICE_ID:
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
		result.append(" (actionId: ");
		result.append(actionId);
		result.append(", sliceId: ");
		result.append(sliceId);
		result.append(')');
		return result.toString();
	}

} //PerformTypeImpl
