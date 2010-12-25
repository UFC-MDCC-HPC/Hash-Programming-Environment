/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.PortSliceType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Slice Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.PortSliceTypeImpl#getPRef <em>PRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.PortSliceTypeImpl#getSRef <em>SRef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortSliceTypeImpl extends EObjectImpl implements PortSliceType {
	/**
	 * The default value of the '{@link #getPRef() <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPRef()
	 * @generated
	 * @ordered
	 */
	protected static final String PREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPRef() <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPRef()
	 * @generated
	 * @ordered
	 */
	protected String pRef = PREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getSRef() <em>SRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRef()
	 * @generated
	 * @ordered
	 */
	protected static final String SREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSRef() <em>SRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRef()
	 * @generated
	 * @ordered
	 */
	protected String sRef = SREF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortSliceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.PORT_SLICE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPRef() {
		return pRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPRef(String newPRef) {
		String oldPRef = pRef;
		pRef = newPRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PORT_SLICE_TYPE__PREF, oldPRef, pRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSRef() {
		return sRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSRef(String newSRef) {
		String oldSRef = sRef;
		sRef = newSRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PORT_SLICE_TYPE__SREF, oldSRef, sRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.PORT_SLICE_TYPE__PREF:
				return getPRef();
			case ComponentPackage.PORT_SLICE_TYPE__SREF:
				return getSRef();
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
			case ComponentPackage.PORT_SLICE_TYPE__PREF:
				setPRef((String)newValue);
				return;
			case ComponentPackage.PORT_SLICE_TYPE__SREF:
				setSRef((String)newValue);
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
			case ComponentPackage.PORT_SLICE_TYPE__PREF:
				setPRef(PREF_EDEFAULT);
				return;
			case ComponentPackage.PORT_SLICE_TYPE__SREF:
				setSRef(SREF_EDEFAULT);
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
			case ComponentPackage.PORT_SLICE_TYPE__PREF:
				return PREF_EDEFAULT == null ? pRef != null : !PREF_EDEFAULT.equals(pRef);
			case ComponentPackage.PORT_SLICE_TYPE__SREF:
				return SREF_EDEFAULT == null ? sRef != null : !SREF_EDEFAULT.equals(sRef);
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
		result.append(" (pRef: ");
		result.append(pRef);
		result.append(", sRef: ");
		result.append(sRef);
		result.append(')');
		return result.toString();
	}

} //PortSliceTypeImpl
