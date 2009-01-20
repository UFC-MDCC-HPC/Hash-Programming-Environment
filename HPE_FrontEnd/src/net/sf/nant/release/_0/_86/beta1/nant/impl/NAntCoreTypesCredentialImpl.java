/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesCredential;
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
 * An implementation of the model object '<em><b>NAnt Core Types Credential</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getRefid <em>Refid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesCredentialImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTypesCredentialImpl extends EObjectImpl implements NAntCoreTypesCredential {
	/**
	 * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected static final Object DOMAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Object domain = DOMAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Object ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Object id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final Object PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected Object password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRefid() <em>Refid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefid()
	 * @generated
	 * @ordered
	 */
	protected static final Object REFID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefid() <em>Refid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefid()
	 * @generated
	 * @ordered
	 */
	protected Object refid = REFID_EDEFAULT;

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
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final Object USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected Object username = USERNAME_EDEFAULT;

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
	protected NAntCoreTypesCredentialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTypesCredential();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Object newDomain) {
		Object oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_CREDENTIAL__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Object newId) {
		Object oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_CREDENTIAL__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_CREDENTIAL__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(Object newPassword) {
		Object oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_CREDENTIAL__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRefid() {
		return refid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefid(Object newRefid) {
		Object oldRefid = refid;
		refid = newRefid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_CREDENTIAL__REFID, oldRefid, refid));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_CREDENTIAL__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(Object newUsername) {
		Object oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_CREDENTIAL__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_CREDENTIAL__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__DOMAIN:
				return getDomain();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ID:
				return getId();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__IF:
				return getIf();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__PASSWORD:
				return getPassword();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__REFID:
				return getRefid();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__USERNAME:
				return getUsername();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__DOMAIN:
				setDomain(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ID:
				setId(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__PASSWORD:
				setPassword(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__REFID:
				setRefid(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__USERNAME:
				setUsername(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__DOMAIN:
				setDomain(DOMAIN_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ID:
				setId(ID_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__REFID:
				setRefid(REFID_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__DOMAIN:
				return DOMAIN_EDEFAULT == null ? domain != null : !DOMAIN_EDEFAULT.equals(domain);
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__REFID:
				return REFID_EDEFAULT == null ? refid != null : !REFID_EDEFAULT.equals(refid);
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL__ANY_ATTRIBUTE:
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
		result.append(" (domain: ");
		result.append(domain);
		result.append(", id: ");
		result.append(id);
		result.append(", if: ");
		result.append(if_);
		result.append(", password: ");
		result.append(password);
		result.append(", refid: ");
		result.append(refid);
		result.append(", unless: ");
		result.append(unless);
		result.append(", username: ");
		result.append(username);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTypesCredentialImpl
