/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.BaseTypeType;
import hPE.xml.component.ComponentInUseType;
import hPE.xml.component.ComponentPackage;
import hPE.xml.component.ExtensionTypeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.BaseTypeTypeImpl#getExtensionType <em>Extension Type</em>}</li>
 *   <li>{@link hPE.xml.component.impl.BaseTypeTypeImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseTypeTypeImpl extends EObjectImpl implements BaseTypeType {
	/**
	 * The cached value of the '{@link #getExtensionType() <em>Extension Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionType()
	 * @generated
	 * @ordered
	 */
	protected ExtensionTypeType extensionType;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected ComponentInUseType component;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseTypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.BASE_TYPE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionTypeType getExtensionType() {
		return extensionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionType(ExtensionTypeType newExtensionType, NotificationChain msgs) {
		ExtensionTypeType oldExtensionType = extensionType;
		extensionType = newExtensionType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE, oldExtensionType, newExtensionType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionType(ExtensionTypeType newExtensionType) {
		if (newExtensionType != extensionType) {
			NotificationChain msgs = null;
			if (extensionType != null)
				msgs = ((InternalEObject)extensionType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE, null, msgs);
			if (newExtensionType != null)
				msgs = ((InternalEObject)newExtensionType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE, null, msgs);
			msgs = basicSetExtensionType(newExtensionType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE, newExtensionType, newExtensionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInUseType getComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponent(ComponentInUseType newComponent, NotificationChain msgs) {
		ComponentInUseType oldComponent = component;
		component = newComponent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.BASE_TYPE_TYPE__COMPONENT, oldComponent, newComponent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(ComponentInUseType newComponent) {
		if (newComponent != component) {
			NotificationChain msgs = null;
			if (component != null)
				msgs = ((InternalEObject)component).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.BASE_TYPE_TYPE__COMPONENT, null, msgs);
			if (newComponent != null)
				msgs = ((InternalEObject)newComponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.BASE_TYPE_TYPE__COMPONENT, null, msgs);
			msgs = basicSetComponent(newComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.BASE_TYPE_TYPE__COMPONENT, newComponent, newComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE:
				return basicSetExtensionType(null, msgs);
			case ComponentPackage.BASE_TYPE_TYPE__COMPONENT:
				return basicSetComponent(null, msgs);
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
			case ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE:
				return getExtensionType();
			case ComponentPackage.BASE_TYPE_TYPE__COMPONENT:
				return getComponent();
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
			case ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE:
				setExtensionType((ExtensionTypeType)newValue);
				return;
			case ComponentPackage.BASE_TYPE_TYPE__COMPONENT:
				setComponent((ComponentInUseType)newValue);
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
			case ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE:
				setExtensionType((ExtensionTypeType)null);
				return;
			case ComponentPackage.BASE_TYPE_TYPE__COMPONENT:
				setComponent((ComponentInUseType)null);
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
			case ComponentPackage.BASE_TYPE_TYPE__EXTENSION_TYPE:
				return extensionType != null;
			case ComponentPackage.BASE_TYPE_TYPE__COMPONENT:
				return component != null;
		}
		return super.eIsSet(featureID);
	}

} //BaseTypeTypeImpl
