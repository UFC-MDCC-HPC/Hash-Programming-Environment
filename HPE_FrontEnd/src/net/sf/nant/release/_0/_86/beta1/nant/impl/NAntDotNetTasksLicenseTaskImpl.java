/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks License Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getInput <em>Input</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getLicensetarget <em>Licensetarget</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksLicenseTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksLicenseTaskImpl extends EObjectImpl implements NAntDotNetTasksLicenseTask {
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
	 * The default value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected static final Object INPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Object input = INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicensetarget() <em>Licensetarget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicensetarget()
	 * @generated
	 * @ordered
	 */
	protected static final Object LICENSETARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicensetarget() <em>Licensetarget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicensetarget()
	 * @generated
	 * @ordered
	 */
	protected Object licensetarget = LICENSETARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected static final Object OUTPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Object output = OUTPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final Object TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Object target = TARGET_EDEFAULT;

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
	protected NAntDotNetTasksLicenseTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksLicenseTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getAssemblies() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksLicenseTask_Assemblies());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(Object newInput) {
		Object oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLicensetarget() {
		return licensetarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicensetarget(Object newLicensetarget) {
		Object oldLicensetarget = licensetarget;
		licensetarget = newLicensetarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__LICENSETARGET, oldLicensetarget, licensetarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Object newOutput) {
		Object oldOutput = output;
		output = newOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Object newTarget) {
		Object oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ASSEMBLIES:
				return ((InternalEList<?>)getAssemblies()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ASSEMBLIES:
				return getAssemblies();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__INPUT:
				return getInput();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__LICENSETARGET:
				return getLicensetarget();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TARGET:
				return getTarget();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ASSEMBLIES:
				getAssemblies().clear();
				getAssemblies().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__INPUT:
				setInput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__LICENSETARGET:
				setLicensetarget(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TARGET:
				setTarget(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ASSEMBLIES:
				getAssemblies().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__INPUT:
				setInput(INPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__LICENSETARGET:
				setLicensetarget(LICENSETARGET_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ASSEMBLIES:
				return !getAssemblies().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__INPUT:
				return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__LICENSETARGET:
				return LICENSETARGET_EDEFAULT == null ? licensetarget != null : !LICENSETARGET_EDEFAULT.equals(licensetarget);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK__ANY_ATTRIBUTE:
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
		result.append(", if: ");
		result.append(if_);
		result.append(", input: ");
		result.append(input);
		result.append(", licensetarget: ");
		result.append(licensetarget);
		result.append(", output: ");
		result.append(output);
		result.append(", target: ");
		result.append(target);
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

} //NAntDotNetTasksLicenseTaskImpl
