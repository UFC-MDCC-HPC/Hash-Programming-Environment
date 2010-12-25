/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.InterfaceRefType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Ref Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.InterfaceRefTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InterfaceRefTypeImpl#getIRef <em>IRef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceRefTypeImpl extends EObjectImpl implements InterfaceRefType {
	/**
	 * The default value of the '{@link #getCRef() <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRef()
	 * @generated
	 * @ordered
	 */
	protected static final String CREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCRef() <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRef()
	 * @generated
	 * @ordered
	 */
	protected String cRef = CREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getIRef() <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRef()
	 * @generated
	 * @ordered
	 */
	protected static final String IREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIRef() <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRef()
	 * @generated
	 * @ordered
	 */
	protected String iRef = IREF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceRefTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.INTERFACE_REF_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCRef() {
		return cRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCRef(String newCRef) {
		String oldCRef = cRef;
		cRef = newCRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_REF_TYPE__CREF, oldCRef, cRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIRef() {
		return iRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIRef(String newIRef) {
		String oldIRef = iRef;
		iRef = newIRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_REF_TYPE__IREF, oldIRef, iRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.INTERFACE_REF_TYPE__CREF:
				return getCRef();
			case ComponentPackage.INTERFACE_REF_TYPE__IREF:
				return getIRef();
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
			case ComponentPackage.INTERFACE_REF_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.INTERFACE_REF_TYPE__IREF:
				setIRef((String)newValue);
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
			case ComponentPackage.INTERFACE_REF_TYPE__CREF:
				setCRef(CREF_EDEFAULT);
				return;
			case ComponentPackage.INTERFACE_REF_TYPE__IREF:
				setIRef(IREF_EDEFAULT);
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
			case ComponentPackage.INTERFACE_REF_TYPE__CREF:
				return CREF_EDEFAULT == null ? cRef != null : !CREF_EDEFAULT.equals(cRef);
			case ComponentPackage.INTERFACE_REF_TYPE__IREF:
				return IREF_EDEFAULT == null ? iRef != null : !IREF_EDEFAULT.equals(iRef);
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
		result.append(" (cRef: ");
		result.append(cRef);
		result.append(", iRef: ");
		result.append(iRef);
		result.append(')');
		return result.toString();
	}

} //InterfaceRefTypeImpl
