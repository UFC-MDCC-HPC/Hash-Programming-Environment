/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksTarTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesTarFileSet;
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
 * An implementation of the model object '<em><b>NAnt Compression Tasks Tar Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getCompression <em>Compression</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getDestfile <em>Destfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getIncludeemptydirs <em>Includeemptydirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksTarTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCompressionTasksTarTaskImpl extends EObjectImpl implements NAntCompressionTasksTarTask {
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
	 * The default value of the '{@link #getCompression() <em>Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompression()
	 * @generated
	 * @ordered
	 */
	protected static final Object COMPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompression() <em>Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompression()
	 * @generated
	 * @ordered
	 */
	protected Object compression = COMPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDestfile() <em>Destfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object DESTFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestfile() <em>Destfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestfile()
	 * @generated
	 * @ordered
	 */
	protected Object destfile = DESTFILE_EDEFAULT;

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
	 * The default value of the '{@link #getIncludeemptydirs() <em>Includeemptydirs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludeemptydirs()
	 * @generated
	 * @ordered
	 */
	protected static final Object INCLUDEEMPTYDIRS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIncludeemptydirs() <em>Includeemptydirs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludeemptydirs()
	 * @generated
	 * @ordered
	 */
	protected Object includeemptydirs = INCLUDEEMPTYDIRS_EDEFAULT;

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
	protected NAntCompressionTasksTarTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCompressionTasksTarTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTypesTarFileSet> getFileset() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCompressionTasksTarTask_Fileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCompression() {
		return compression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompression(Object newCompression) {
		Object oldCompression = compression;
		compression = newCompression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__COMPRESSION, oldCompression, compression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDestfile() {
		return destfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestfile(Object newDestfile) {
		Object oldDestfile = destfile;
		destfile = newDestfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__DESTFILE, oldDestfile, destfile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIncludeemptydirs() {
		return includeemptydirs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeemptydirs(Object newIncludeemptydirs) {
		Object oldIncludeemptydirs = includeemptydirs;
		includeemptydirs = newIncludeemptydirs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__INCLUDEEMPTYDIRS, oldIncludeemptydirs, includeemptydirs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FILESET:
				return ((InternalEList<?>)getFileset()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FILESET:
				return getFileset();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__COMPRESSION:
				return getCompression();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__DESTFILE:
				return getDestfile();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__IF:
				return getIf();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__INCLUDEEMPTYDIRS:
				return getIncludeemptydirs();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FILESET:
				getFileset().clear();
				getFileset().addAll((Collection<? extends NAntCompressionTypesTarFileSet>)newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__COMPRESSION:
				setCompression(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__DESTFILE:
				setDestfile(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__INCLUDEEMPTYDIRS:
				setIncludeemptydirs(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FILESET:
				getFileset().clear();
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__COMPRESSION:
				setCompression(COMPRESSION_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__DESTFILE:
				setDestfile(DESTFILE_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__INCLUDEEMPTYDIRS:
				setIncludeemptydirs(INCLUDEEMPTYDIRS_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FILESET:
				return !getFileset().isEmpty();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__COMPRESSION:
				return COMPRESSION_EDEFAULT == null ? compression != null : !COMPRESSION_EDEFAULT.equals(compression);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__DESTFILE:
				return DESTFILE_EDEFAULT == null ? destfile != null : !DESTFILE_EDEFAULT.equals(destfile);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__INCLUDEEMPTYDIRS:
				return INCLUDEEMPTYDIRS_EDEFAULT == null ? includeemptydirs != null : !INCLUDEEMPTYDIRS_EDEFAULT.equals(includeemptydirs);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK__ANY_ATTRIBUTE:
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
		result.append(", compression: ");
		result.append(compression);
		result.append(", destfile: ");
		result.append(destfile);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", includeemptydirs: ");
		result.append(includeemptydirs);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCompressionTasksTarTaskImpl
