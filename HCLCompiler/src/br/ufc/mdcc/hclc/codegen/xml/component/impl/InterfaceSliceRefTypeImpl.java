/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Slice Ref Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceRefTypeImpl#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceRefTypeImpl#getInterfaceRef <em>Interface Ref</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceRefTypeImpl#getSliceRef <em>Slice Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceSliceRefTypeImpl extends EObjectImpl implements InterfaceSliceRefType {
	/**
	 * The default value of the '{@link #getComponentRef() <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentRef()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_REF_EDEFAULT = "this";

	/**
	 * The cached value of the '{@link #getComponentRef() <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentRef()
	 * @generated
	 * @ordered
	 */
	protected String componentRef = COMPONENT_REF_EDEFAULT;

	/**
	 * This is true if the Component Ref attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean componentRefESet;

	/**
	 * The default value of the '{@link #getInterfaceRef() <em>Interface Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceRef()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterfaceRef() <em>Interface Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceRef()
	 * @generated
	 * @ordered
	 */
	protected String interfaceRef = INTERFACE_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getSliceRef() <em>Slice Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceRef()
	 * @generated
	 * @ordered
	 */
	protected static final String SLICE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSliceRef() <em>Slice Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceRef()
	 * @generated
	 * @ordered
	 */
	protected String sliceRef = SLICE_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceSliceRefTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.INTERFACE_SLICE_REF_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentRef() {
		return componentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentRef(String newComponentRef) {
		String oldComponentRef = componentRef;
		componentRef = newComponentRef;
		boolean oldComponentRefESet = componentRefESet;
		componentRefESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_REF_TYPE__COMPONENT_REF, oldComponentRef, componentRef, !oldComponentRefESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetComponentRef() {
		String oldComponentRef = componentRef;
		boolean oldComponentRefESet = componentRefESet;
		componentRef = COMPONENT_REF_EDEFAULT;
		componentRefESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.INTERFACE_SLICE_REF_TYPE__COMPONENT_REF, oldComponentRef, COMPONENT_REF_EDEFAULT, oldComponentRefESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetComponentRef() {
		return componentRefESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterfaceRef() {
		return interfaceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceRef(String newInterfaceRef) {
		String oldInterfaceRef = interfaceRef;
		interfaceRef = newInterfaceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_REF_TYPE__INTERFACE_REF, oldInterfaceRef, interfaceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSliceRef() {
		return sliceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSliceRef(String newSliceRef) {
		String oldSliceRef = sliceRef;
		sliceRef = newSliceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_REF_TYPE__SLICE_REF, oldSliceRef, sliceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__COMPONENT_REF:
				return getComponentRef();
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__INTERFACE_REF:
				return getInterfaceRef();
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__SLICE_REF:
				return getSliceRef();
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
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__COMPONENT_REF:
				setComponentRef((String)newValue);
				return;
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__INTERFACE_REF:
				setInterfaceRef((String)newValue);
				return;
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__SLICE_REF:
				setSliceRef((String)newValue);
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
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__COMPONENT_REF:
				unsetComponentRef();
				return;
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__INTERFACE_REF:
				setInterfaceRef(INTERFACE_REF_EDEFAULT);
				return;
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__SLICE_REF:
				setSliceRef(SLICE_REF_EDEFAULT);
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
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__COMPONENT_REF:
				return isSetComponentRef();
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__INTERFACE_REF:
				return INTERFACE_REF_EDEFAULT == null ? interfaceRef != null : !INTERFACE_REF_EDEFAULT.equals(interfaceRef);
			case ComponentPackage.INTERFACE_SLICE_REF_TYPE__SLICE_REF:
				return SLICE_REF_EDEFAULT == null ? sliceRef != null : !SLICE_REF_EDEFAULT.equals(sliceRef);
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
		result.append(" (componentRef: ");
		if (componentRefESet) result.append(componentRef); else result.append("<unset>");
		result.append(", interfaceRef: ");
		result.append(interfaceRef);
		result.append(", sliceRef: ");
		result.append(sliceRef);
		result.append(')');
		return result.toString();
	}

} //InterfaceSliceRefTypeImpl
