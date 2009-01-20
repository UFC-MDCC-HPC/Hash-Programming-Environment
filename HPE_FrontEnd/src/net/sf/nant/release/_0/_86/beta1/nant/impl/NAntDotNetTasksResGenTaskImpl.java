/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksResGenTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet;
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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks Res Gen Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getInput <em>Input</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getTodir <em>Todir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getUsesourcepath <em>Usesourcepath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksResGenTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksResGenTaskImpl extends EObjectImpl implements NAntDotNetTasksResGenTask {
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
	 * The default value of the '{@link #getTodir() <em>Todir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTodir()
	 * @generated
	 * @ordered
	 */
	protected static final Object TODIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTodir() <em>Todir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTodir()
	 * @generated
	 * @ordered
	 */
	protected Object todir = TODIR_EDEFAULT;

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
	 * The default value of the '{@link #getUsesourcepath() <em>Usesourcepath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsesourcepath()
	 * @generated
	 * @ordered
	 */
	protected static final Object USESOURCEPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsesourcepath() <em>Usesourcepath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsesourcepath()
	 * @generated
	 * @ordered
	 */
	protected Object usesourcepath = USESOURCEPATH_EDEFAULT;

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
	protected NAntDotNetTasksResGenTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksResGenTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesResourceFileSet> getResources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksResGenTask_Resources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getAssemblies() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksResGenTask_Assemblies());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksResGenTask_Arg());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__IF, oldIf, if_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__INPUT, oldInput, input));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__OUTPUT, oldOutput, output));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTodir() {
		return todir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTodir(Object newTodir) {
		Object oldTodir = todir;
		todir = newTodir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TODIR, oldTodir, todir));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUsesourcepath() {
		return usesourcepath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsesourcepath(Object newUsesourcepath) {
		Object oldUsesourcepath = usesourcepath;
		usesourcepath = newUsesourcepath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__USESOURCEPATH, oldUsesourcepath, usesourcepath));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ASSEMBLIES:
				return ((InternalEList<?>)getAssemblies()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__RESOURCES:
				return getResources();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ASSEMBLIES:
				return getAssemblies();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ARG:
				return getArg();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__INPUT:
				return getInput();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TARGET:
				return getTarget();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TODIR:
				return getTodir();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__USESOURCEPATH:
				return getUsesourcepath();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends NAntDotNetTypesResourceFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ASSEMBLIES:
				getAssemblies().clear();
				getAssemblies().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__INPUT:
				setInput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TARGET:
				setTarget(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TODIR:
				setTodir(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__USESOURCEPATH:
				setUsesourcepath(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__RESOURCES:
				getResources().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ASSEMBLIES:
				getAssemblies().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__INPUT:
				setInput(INPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TODIR:
				setTodir(TODIR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__USESOURCEPATH:
				setUsesourcepath(USESOURCEPATH_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__RESOURCES:
				return !getResources().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ASSEMBLIES:
				return !getAssemblies().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__INPUT:
				return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__TODIR:
				return TODIR_EDEFAULT == null ? todir != null : !TODIR_EDEFAULT.equals(todir);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__USESOURCEPATH:
				return USESOURCEPATH_EDEFAULT == null ? usesourcepath != null : !USESOURCEPATH_EDEFAULT.equals(usesourcepath);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK__ANY_ATTRIBUTE:
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
		result.append(", output: ");
		result.append(output);
		result.append(", target: ");
		result.append(target);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", todir: ");
		result.append(todir);
		result.append(", unless: ");
		result.append(unless);
		result.append(", usesourcepath: ");
		result.append(usesourcepath);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntDotNetTasksResGenTaskImpl
