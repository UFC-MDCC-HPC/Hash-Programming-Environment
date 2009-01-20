/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask;
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
 * An implementation of the model object '<em><b>NAnt Visual Cpp Tasks Mc Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getHeaderpath <em>Headerpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getMcfile <em>Mcfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getRcpath <em>Rcpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMcTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntVisualCppTasksMcTaskImpl extends EObjectImpl implements NAntVisualCppTasksMcTask {
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
	 * The default value of the '{@link #getHeaderpath() <em>Headerpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderpath()
	 * @generated
	 * @ordered
	 */
	protected static final Object HEADERPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeaderpath() <em>Headerpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderpath()
	 * @generated
	 * @ordered
	 */
	protected Object headerpath = HEADERPATH_EDEFAULT;

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
	 * The default value of the '{@link #getMcfile() <em>Mcfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMcfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object MCFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMcfile() <em>Mcfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMcfile()
	 * @generated
	 * @ordered
	 */
	protected Object mcfile = MCFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptions() <em>Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected static final Object OPTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected Object options = OPTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRcpath() <em>Rcpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRcpath()
	 * @generated
	 * @ordered
	 */
	protected static final Object RCPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRcpath() <em>Rcpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRcpath()
	 * @generated
	 * @ordered
	 */
	protected Object rcpath = RCPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final Object TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected Object timeout = TIMEOUT_EDEFAULT;

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
	protected NAntVisualCppTasksMcTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntVisualCppTasksMcTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksMcTask_Arg());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__FAILONERROR, oldFailonerror, failonerror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHeaderpath() {
		return headerpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderpath(Object newHeaderpath) {
		Object oldHeaderpath = headerpath;
		headerpath = newHeaderpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__HEADERPATH, oldHeaderpath, headerpath));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMcfile() {
		return mcfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMcfile(Object newMcfile) {
		Object oldMcfile = mcfile;
		mcfile = newMcfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__MCFILE, oldMcfile, mcfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOptions() {
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptions(Object newOptions) {
		Object oldOptions = options;
		options = newOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__OPTIONS, oldOptions, options));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRcpath() {
		return rcpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRcpath(Object newRcpath) {
		Object oldRcpath = rcpath;
		rcpath = newRcpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__RCPATH, oldRcpath, rcpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(Object newTimeout) {
		Object oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ARG:
				return getArg();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__HEADERPATH:
				return getHeaderpath();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__IF:
				return getIf();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__MCFILE:
				return getMcfile();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__OPTIONS:
				return getOptions();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__RCPATH:
				return getRcpath();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__HEADERPATH:
				setHeaderpath(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__MCFILE:
				setMcfile(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__OPTIONS:
				setOptions(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__RCPATH:
				setRcpath(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__HEADERPATH:
				setHeaderpath(HEADERPATH_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__MCFILE:
				setMcfile(MCFILE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__OPTIONS:
				setOptions(OPTIONS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__RCPATH:
				setRcpath(RCPATH_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__HEADERPATH:
				return HEADERPATH_EDEFAULT == null ? headerpath != null : !HEADERPATH_EDEFAULT.equals(headerpath);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__MCFILE:
				return MCFILE_EDEFAULT == null ? mcfile != null : !MCFILE_EDEFAULT.equals(mcfile);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__OPTIONS:
				return OPTIONS_EDEFAULT == null ? options != null : !OPTIONS_EDEFAULT.equals(options);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__RCPATH:
				return RCPATH_EDEFAULT == null ? rcpath != null : !RCPATH_EDEFAULT.equals(rcpath);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK__ANY_ATTRIBUTE:
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
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", headerpath: ");
		result.append(headerpath);
		result.append(", if: ");
		result.append(if_);
		result.append(", mcfile: ");
		result.append(mcfile);
		result.append(", options: ");
		result.append(options);
		result.append(", rcpath: ");
		result.append(rcpath);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntVisualCppTasksMcTaskImpl
