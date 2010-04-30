/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expose Port Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExposePortTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExposePortTypeImpl#getExposed <em>Exposed</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExposePortTypeImpl#getPRef <em>PRef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExposePortTypeImpl extends EObjectImpl implements ExposePortType {
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
	 * The default value of the '{@link #getExposed() <em>Exposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposed()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPOSED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExposed() <em>Exposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposed()
	 * @generated
	 * @ordered
	 */
	protected String exposed = EXPOSED_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExposePortTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.EXPOSE_PORT_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.EXPOSE_PORT_TYPE__CREF, oldCRef, cRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExposed() {
		return exposed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExposed(String newExposed) {
		String oldExposed = exposed;
		exposed = newExposed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.EXPOSE_PORT_TYPE__EXPOSED, oldExposed, exposed));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.EXPOSE_PORT_TYPE__PREF, oldPRef, pRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.EXPOSE_PORT_TYPE__CREF:
				return getCRef();
			case ComponentPackage.EXPOSE_PORT_TYPE__EXPOSED:
				return getExposed();
			case ComponentPackage.EXPOSE_PORT_TYPE__PREF:
				return getPRef();
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
			case ComponentPackage.EXPOSE_PORT_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.EXPOSE_PORT_TYPE__EXPOSED:
				setExposed((String)newValue);
				return;
			case ComponentPackage.EXPOSE_PORT_TYPE__PREF:
				setPRef((String)newValue);
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
			case ComponentPackage.EXPOSE_PORT_TYPE__CREF:
				setCRef(CREF_EDEFAULT);
				return;
			case ComponentPackage.EXPOSE_PORT_TYPE__EXPOSED:
				setExposed(EXPOSED_EDEFAULT);
				return;
			case ComponentPackage.EXPOSE_PORT_TYPE__PREF:
				setPRef(PREF_EDEFAULT);
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
			case ComponentPackage.EXPOSE_PORT_TYPE__CREF:
				return CREF_EDEFAULT == null ? cRef != null : !CREF_EDEFAULT.equals(cRef);
			case ComponentPackage.EXPOSE_PORT_TYPE__EXPOSED:
				return EXPOSED_EDEFAULT == null ? exposed != null : !EXPOSED_EDEFAULT.equals(exposed);
			case ComponentPackage.EXPOSE_PORT_TYPE__PREF:
				return PREF_EDEFAULT == null ? pRef != null : !PREF_EDEFAULT.equals(pRef);
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
		result.append(", exposed: ");
		result.append(exposed);
		result.append(", pRef: ");
		result.append(pRef);
		result.append(')');
		return result.toString();
	}

} //ExposePortTypeImpl
