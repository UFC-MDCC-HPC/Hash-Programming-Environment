/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesXsltExtensionObject;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NAnt Core Types Xslt Extension Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesXsltExtensionObjectImpl#getAssembly <em>Assembly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesXsltExtensionObjectImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesXsltExtensionObjectImpl#getNamespaceuri <em>Namespaceuri</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesXsltExtensionObjectImpl#getTypename <em>Typename</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesXsltExtensionObjectImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesXsltExtensionObjectImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTypesXsltExtensionObjectImpl extends EObjectImpl implements NAntCoreTypesXsltExtensionObject {
	/**
	 * The default value of the '{@link #getAssembly() <em>Assembly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssembly()
	 * @generated
	 * @ordered
	 */
	protected static final Object ASSEMBLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssembly() <em>Assembly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssembly()
	 * @generated
	 * @ordered
	 */
	protected Object assembly = ASSEMBLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIf() <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf()
	 * @generated
	 * @ordered
	 */
	protected static final Object IF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIf() <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf()
	 * @generated
	 * @ordered
	 */
	protected Object if_ = IF_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespaceuri() <em>Namespaceuri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaceuri()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAMESPACEURI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespaceuri() <em>Namespaceuri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaceuri()
	 * @generated
	 * @ordered
	 */
	protected Object namespaceuri = NAMESPACEURI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypename() <em>Typename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypename()
	 * @generated
	 * @ordered
	 */
	protected static final Object TYPENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypename() <em>Typename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypename()
	 * @generated
	 * @ordered
	 */
	protected Object typename = TYPENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnless() <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnless()
	 * @generated
	 * @ordered
	 */
	protected static final Object UNLESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnless() <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnless()
	 * @generated
	 * @ordered
	 */
	protected Object unless = UNLESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NAntCoreTypesXsltExtensionObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTypesXsltExtensionObject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAssembly() {
		return assembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssembly(Object newAssembly) {
		Object oldAssembly = assembly;
		assembly = newAssembly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ASSEMBLY, oldAssembly, assembly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIf() {
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIf(Object newIf) {
		Object oldIf = if_;
		if_ = newIf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNamespaceuri() {
		return namespaceuri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespaceuri(Object newNamespaceuri) {
		Object oldNamespaceuri = namespaceuri;
		namespaceuri = newNamespaceuri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__NAMESPACEURI, oldNamespaceuri, namespaceuri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTypename() {
		return typename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypename(Object newTypename) {
		Object oldTypename = typename;
		typename = newTypename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__TYPENAME, oldTypename, typename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUnless() {
		return unless;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnless(Object newUnless) {
		Object oldUnless = unless;
		unless = newUnless;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ASSEMBLY:
				return getAssembly();
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__IF:
				return getIf();
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__NAMESPACEURI:
				return getNamespaceuri();
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__TYPENAME:
				return getTypename();
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ASSEMBLY:
				setAssembly(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__NAMESPACEURI:
				setNamespaceuri(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__TYPENAME:
				setTypename(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ASSEMBLY:
				setAssembly(ASSEMBLY_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__NAMESPACEURI:
				setNamespaceuri(NAMESPACEURI_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__TYPENAME:
				setTypename(TYPENAME_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ASSEMBLY:
				return ASSEMBLY_EDEFAULT == null ? assembly != null : !ASSEMBLY_EDEFAULT.equals(assembly);
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__NAMESPACEURI:
				return NAMESPACEURI_EDEFAULT == null ? namespaceuri != null : !NAMESPACEURI_EDEFAULT.equals(namespaceuri);
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__TYPENAME:
				return TYPENAME_EDEFAULT == null ? typename != null : !TYPENAME_EDEFAULT.equals(typename);
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(" (assembly: ");
		result.append(assembly);
		result.append(", if: ");
		result.append(if_);
		result.append(", namespaceuri: ");
		result.append(namespaceuri);
		result.append(", typename: ");
		result.append(typename);
		result.append(", unless: ");
		result.append(unless);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTypesXsltExtensionObjectImpl
