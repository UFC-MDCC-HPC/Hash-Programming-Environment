/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesCredential;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesProxy;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NAnt Core Types Proxy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getCredentials <em>Credentials</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getBypassonlocal <em>Bypassonlocal</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getHost <em>Host</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getPort <em>Port</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getRefid <em>Refid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesProxyImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTypesProxyImpl extends EObjectImpl implements NAntCoreTypesProxy {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getBypassonlocal() <em>Bypassonlocal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBypassonlocal()
	 * @generated
	 * @ordered
	 */
	protected static final Object BYPASSONLOCAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBypassonlocal() <em>Bypassonlocal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBypassonlocal()
	 * @generated
	 * @ordered
	 */
	protected Object bypassonlocal = BYPASSONLOCAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final Object HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected Object host = HOST_EDEFAULT;

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
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final Object PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected Object port = PORT_EDEFAULT;

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
	protected NAntCoreTypesProxyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTypesProxy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_PROXY__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesCredential> getCredentials() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesProxy_Credentials());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBypassonlocal() {
		return bypassonlocal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBypassonlocal(Object newBypassonlocal) {
		Object oldBypassonlocal = bypassonlocal;
		bypassonlocal = newBypassonlocal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_PROXY__BYPASSONLOCAL, oldBypassonlocal, bypassonlocal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(Object newHost) {
		Object oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_PROXY__HOST, oldHost, host));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_PROXY__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_PROXY__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(Object newPort) {
		Object oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_PROXY__PORT, oldPort, port));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_PROXY__REFID, oldRefid, refid));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_PROXY__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_PROXY__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_CORE_TYPES_PROXY__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_PROXY__CREDENTIALS:
				return ((InternalEList<?>)getCredentials()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_PROXY__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_PROXY__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_CORE_TYPES_PROXY__CREDENTIALS:
				return getCredentials();
			case NantPackage.NANT_CORE_TYPES_PROXY__BYPASSONLOCAL:
				return getBypassonlocal();
			case NantPackage.NANT_CORE_TYPES_PROXY__HOST:
				return getHost();
			case NantPackage.NANT_CORE_TYPES_PROXY__ID:
				return getId();
			case NantPackage.NANT_CORE_TYPES_PROXY__IF:
				return getIf();
			case NantPackage.NANT_CORE_TYPES_PROXY__PORT:
				return getPort();
			case NantPackage.NANT_CORE_TYPES_PROXY__REFID:
				return getRefid();
			case NantPackage.NANT_CORE_TYPES_PROXY__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TYPES_PROXY__ANY_ATTRIBUTE:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NantPackage.NANT_CORE_TYPES_PROXY__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__CREDENTIALS:
				getCredentials().clear();
				getCredentials().addAll((Collection<? extends NAntCoreTypesCredential>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__BYPASSONLOCAL:
				setBypassonlocal(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__HOST:
				setHost(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__ID:
				setId(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__PORT:
				setPort(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__REFID:
				setRefid(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_PROXY__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__CREDENTIALS:
				getCredentials().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__BYPASSONLOCAL:
				setBypassonlocal(BYPASSONLOCAL_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__ID:
				setId(ID_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__REFID:
				setRefid(REFID_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_PROXY__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_PROXY__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_CORE_TYPES_PROXY__CREDENTIALS:
				return !getCredentials().isEmpty();
			case NantPackage.NANT_CORE_TYPES_PROXY__BYPASSONLOCAL:
				return BYPASSONLOCAL_EDEFAULT == null ? bypassonlocal != null : !BYPASSONLOCAL_EDEFAULT.equals(bypassonlocal);
			case NantPackage.NANT_CORE_TYPES_PROXY__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case NantPackage.NANT_CORE_TYPES_PROXY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NantPackage.NANT_CORE_TYPES_PROXY__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_CORE_TYPES_PROXY__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case NantPackage.NANT_CORE_TYPES_PROXY__REFID:
				return REFID_EDEFAULT == null ? refid != null : !REFID_EDEFAULT.equals(refid);
			case NantPackage.NANT_CORE_TYPES_PROXY__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TYPES_PROXY__ANY_ATTRIBUTE:
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
		result.append(" (group: ");
		result.append(group);
		result.append(", bypassonlocal: ");
		result.append(bypassonlocal);
		result.append(", host: ");
		result.append(host);
		result.append(", id: ");
		result.append(id);
		result.append(", if: ");
		result.append(if_);
		result.append(", port: ");
		result.append(port);
		result.append(", refid: ");
		result.append(refid);
		result.append(", unless: ");
		result.append(unless);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTypesProxyImpl
