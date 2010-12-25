/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.ExtensionTypeType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.ExtensionTypeTypeImpl#isImplements <em>Implements</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ExtensionTypeTypeImpl#isExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionTypeTypeImpl extends EObjectImpl implements ExtensionTypeType {
	/**
	 * The default value of the '{@link #isImplements() <em>Implements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLEMENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImplements() <em>Implements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplements()
	 * @generated
	 * @ordered
	 */
	protected boolean implements_ = IMPLEMENTS_EDEFAULT;

	/**
	 * This is true if the Implements attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean implementsESet;

	/**
	 * The default value of the '{@link #isExtends() <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtends()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtends() <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtends()
	 * @generated
	 * @ordered
	 */
	protected boolean extends_ = EXTENDS_EDEFAULT;

	/**
	 * This is true if the Extends attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean extendsESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionTypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.EXTENSION_TYPE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplements() {
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplements(boolean newImplements) {
		boolean oldImplements = implements_;
		implements_ = newImplements;
		boolean oldImplementsESet = implementsESet;
		implementsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.EXTENSION_TYPE_TYPE__IMPLEMENTS, oldImplements, implements_, !oldImplementsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImplements() {
		boolean oldImplements = implements_;
		boolean oldImplementsESet = implementsESet;
		implements_ = IMPLEMENTS_EDEFAULT;
		implementsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.EXTENSION_TYPE_TYPE__IMPLEMENTS, oldImplements, IMPLEMENTS_EDEFAULT, oldImplementsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImplements() {
		return implementsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(boolean newExtends) {
		boolean oldExtends = extends_;
		extends_ = newExtends;
		boolean oldExtendsESet = extendsESet;
		extendsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.EXTENSION_TYPE_TYPE__EXTENDS, oldExtends, extends_, !oldExtendsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExtends() {
		boolean oldExtends = extends_;
		boolean oldExtendsESet = extendsESet;
		extends_ = EXTENDS_EDEFAULT;
		extendsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.EXTENSION_TYPE_TYPE__EXTENDS, oldExtends, EXTENDS_EDEFAULT, oldExtendsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExtends() {
		return extendsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.EXTENSION_TYPE_TYPE__IMPLEMENTS:
				return isImplements();
			case ComponentPackage.EXTENSION_TYPE_TYPE__EXTENDS:
				return isExtends();
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
			case ComponentPackage.EXTENSION_TYPE_TYPE__IMPLEMENTS:
				setImplements((Boolean)newValue);
				return;
			case ComponentPackage.EXTENSION_TYPE_TYPE__EXTENDS:
				setExtends((Boolean)newValue);
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
			case ComponentPackage.EXTENSION_TYPE_TYPE__IMPLEMENTS:
				unsetImplements();
				return;
			case ComponentPackage.EXTENSION_TYPE_TYPE__EXTENDS:
				unsetExtends();
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
			case ComponentPackage.EXTENSION_TYPE_TYPE__IMPLEMENTS:
				return isSetImplements();
			case ComponentPackage.EXTENSION_TYPE_TYPE__EXTENDS:
				return isSetExtends();
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
		result.append(" (implements: ");
		if (implementsESet) result.append(implements_); else result.append("<unset>");
		result.append(", extends: ");
		if (extendsESet) result.append(extends_); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ExtensionTypeTypeImpl
