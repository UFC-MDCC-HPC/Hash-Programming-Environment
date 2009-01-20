/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsPass;
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
 * An implementation of the model object '<em><b>NAnt Source Control Tasks Cvs Pass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getCvsroot <em>Cvsroot</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getPassfile <em>Passfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksCvsPassImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntSourceControlTasksCvsPassImpl extends EObjectImpl implements NAntSourceControlTasksCvsPass {
	/**
	 * The default value of the '{@link #getCvsroot() <em>Cvsroot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsroot()
	 * @generated
	 * @ordered
	 */
	protected static final Object CVSROOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCvsroot() <em>Cvsroot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsroot()
	 * @generated
	 * @ordered
	 */
	protected Object cvsroot = CVSROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailonerror() <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailonerror()
	 * @generated
	 * @ordered
	 */
	protected static final Object FAILONERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailonerror() <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailonerror()
	 * @generated
	 * @ordered
	 */
	protected Object failonerror = FAILONERROR_EDEFAULT;

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
	 * The default value of the '{@link #getPassfile() <em>Passfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object PASSFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassfile() <em>Passfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassfile()
	 * @generated
	 * @ordered
	 */
	protected Object passfile = PASSFILE_EDEFAULT;

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
	 * The default value of the '{@link #getVerbose() <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbose()
	 * @generated
	 * @ordered
	 */
	protected static final Object VERBOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerbose() <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbose()
	 * @generated
	 * @ordered
	 */
	protected Object verbose = VERBOSE_EDEFAULT;

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
	protected NAntSourceControlTasksCvsPassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntSourceControlTasksCvsPass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCvsroot() {
		return cvsroot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCvsroot(Object newCvsroot) {
		Object oldCvsroot = cvsroot;
		cvsroot = newCvsroot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__CVSROOT, oldCvsroot, cvsroot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFailonerror() {
		return failonerror;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailonerror(Object newFailonerror) {
		Object oldFailonerror = failonerror;
		failonerror = newFailonerror;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPassfile() {
		return passfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassfile(Object newPassfile) {
		Object oldPassfile = passfile;
		passfile = newPassfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSFILE, oldPassfile, passfile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSWORD, oldPassword, password));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getVerbose() {
		return verbose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerbose(Object newVerbose) {
		Object oldVerbose = verbose;
		verbose = newVerbose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__CVSROOT:
				return getCvsroot();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__IF:
				return getIf();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSFILE:
				return getPassfile();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSWORD:
				return getPassword();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__UNLESS:
				return getUnless();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__CVSROOT:
				setCvsroot(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSFILE:
				setPassfile(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSWORD:
				setPassword(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__CVSROOT:
				setCvsroot(CVSROOT_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSFILE:
				setPassfile(PASSFILE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__CVSROOT:
				return CVSROOT_EDEFAULT == null ? cvsroot != null : !CVSROOT_EDEFAULT.equals(cvsroot);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSFILE:
				return PASSFILE_EDEFAULT == null ? passfile != null : !PASSFILE_EDEFAULT.equals(passfile);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS__ANY_ATTRIBUTE:
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
		result.append(" (cvsroot: ");
		result.append(cvsroot);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", passfile: ");
		result.append(passfile);
		result.append(", password: ");
		result.append(password);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntSourceControlTasksCvsPassImpl
