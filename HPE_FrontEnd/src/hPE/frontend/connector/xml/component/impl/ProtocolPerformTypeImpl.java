/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.impl;

import hPE.frontend.connector.xml.component.ComponentPackage;
import hPE.frontend.connector.xml.component.ProtocolPerformType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol Perform Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.ProtocolPerformTypeImpl#getSliceId <em>Slice Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtocolPerformTypeImpl extends ProtocolTypeImpl implements ProtocolPerformType {
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
	protected ProtocolPerformTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.PROTOCOL_PERFORM_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_PERFORM_TYPE__SLICE_ID, oldSliceId, sliceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.PROTOCOL_PERFORM_TYPE__SLICE_ID:
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
			case ComponentPackage.PROTOCOL_PERFORM_TYPE__SLICE_ID:
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
			case ComponentPackage.PROTOCOL_PERFORM_TYPE__SLICE_ID:
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
			case ComponentPackage.PROTOCOL_PERFORM_TYPE__SLICE_ID:
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
		result.append(" (sliceId: ");
		result.append(sliceId);
		result.append(')');
		return result.toString();
	}

} //ProtocolPerformTypeImpl
