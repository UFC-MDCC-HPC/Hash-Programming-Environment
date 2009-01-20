/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksRegAsmTask;
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
 * An implementation of the model object '<em><b>NAnt Win32 Tasks Reg Asm Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getReferences <em>References</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getAssembly <em>Assembly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getCodebase <em>Codebase</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getRegfile <em>Regfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getRegistered <em>Registered</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getTypelib <em>Typelib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getUnregister <em>Unregister</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksRegAsmTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntWin32TasksRegAsmTaskImpl extends EObjectImpl implements NAntWin32TasksRegAsmTask {
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
	 * The default value of the '{@link #getCodebase() <em>Codebase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodebase()
	 * @generated
	 * @ordered
	 */
	protected static final Object CODEBASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodebase() <em>Codebase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodebase()
	 * @generated
	 * @ordered
	 */
	protected Object codebase = CODEBASE_EDEFAULT;

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
	 * The default value of the '{@link #getRegfile() <em>Regfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object REGFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegfile() <em>Regfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegfile()
	 * @generated
	 * @ordered
	 */
	protected Object regfile = REGFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegistered() <em>Registered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistered()
	 * @generated
	 * @ordered
	 */
	protected static final Object REGISTERED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegistered() <em>Registered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistered()
	 * @generated
	 * @ordered
	 */
	protected Object registered = REGISTERED_EDEFAULT;

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
	 * The default value of the '{@link #getTypelib() <em>Typelib</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypelib()
	 * @generated
	 * @ordered
	 */
	protected static final Object TYPELIB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypelib() <em>Typelib</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypelib()
	 * @generated
	 * @ordered
	 */
	protected Object typelib = TYPELIB_EDEFAULT;

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
	 * The default value of the '{@link #getUnregister() <em>Unregister</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnregister()
	 * @generated
	 * @ordered
	 */
	protected static final Object UNREGISTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnregister() <em>Unregister</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnregister()
	 * @generated
	 * @ordered
	 */
	protected Object unregister = UNREGISTER_EDEFAULT;

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
	protected NAntWin32TasksRegAsmTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntWin32TasksRegAsmTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getAssemblies() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntWin32TasksRegAsmTask_Assemblies());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getReferences() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntWin32TasksRegAsmTask_References());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntWin32TasksRegAsmTask_Arg());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLY, oldAssembly, assembly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCodebase() {
		return codebase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodebase(Object newCodebase) {
		Object oldCodebase = codebase;
		codebase = newCodebase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__CODEBASE, oldCodebase, codebase));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRegfile() {
		return regfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegfile(Object newRegfile) {
		Object oldRegfile = regfile;
		regfile = newRegfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGFILE, oldRegfile, regfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRegistered() {
		return registered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistered(Object newRegistered) {
		Object oldRegistered = registered;
		registered = newRegistered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGISTERED, oldRegistered, registered));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTypelib() {
		return typelib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypelib(Object newTypelib) {
		Object oldTypelib = typelib;
		typelib = newTypelib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TYPELIB, oldTypelib, typelib));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUnregister() {
		return unregister;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnregister(Object newUnregister) {
		Object oldUnregister = unregister;
		unregister = newUnregister;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNREGISTER, oldUnregister, unregister));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLIES:
				return ((InternalEList<?>)getAssemblies()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLIES:
				return getAssemblies();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REFERENCES:
				return getReferences();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ARG:
				return getArg();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLY:
				return getAssembly();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__CODEBASE:
				return getCodebase();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__IF:
				return getIf();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGFILE:
				return getRegfile();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGISTERED:
				return getRegistered();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TYPELIB:
				return getTypelib();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNREGISTER:
				return getUnregister();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLIES:
				getAssemblies().clear();
				getAssemblies().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLY:
				setAssembly(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__CODEBASE:
				setCodebase(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGFILE:
				setRegfile(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGISTERED:
				setRegistered(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TYPELIB:
				setTypelib(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNREGISTER:
				setUnregister(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLIES:
				getAssemblies().clear();
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REFERENCES:
				getReferences().clear();
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLY:
				setAssembly(ASSEMBLY_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__CODEBASE:
				setCodebase(CODEBASE_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGFILE:
				setRegfile(REGFILE_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGISTERED:
				setRegistered(REGISTERED_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TYPELIB:
				setTypelib(TYPELIB_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNREGISTER:
				setUnregister(UNREGISTER_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLIES:
				return !getAssemblies().isEmpty();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REFERENCES:
				return !getReferences().isEmpty();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ASSEMBLY:
				return ASSEMBLY_EDEFAULT == null ? assembly != null : !ASSEMBLY_EDEFAULT.equals(assembly);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__CODEBASE:
				return CODEBASE_EDEFAULT == null ? codebase != null : !CODEBASE_EDEFAULT.equals(codebase);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGFILE:
				return REGFILE_EDEFAULT == null ? regfile != null : !REGFILE_EDEFAULT.equals(regfile);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__REGISTERED:
				return REGISTERED_EDEFAULT == null ? registered != null : !REGISTERED_EDEFAULT.equals(registered);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__TYPELIB:
				return TYPELIB_EDEFAULT == null ? typelib != null : !TYPELIB_EDEFAULT.equals(typelib);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__UNREGISTER:
				return UNREGISTER_EDEFAULT == null ? unregister != null : !UNREGISTER_EDEFAULT.equals(unregister);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK__ANY_ATTRIBUTE:
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
		result.append(", assembly: ");
		result.append(assembly);
		result.append(", codebase: ");
		result.append(codebase);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", regfile: ");
		result.append(regfile);
		result.append(", registered: ");
		result.append(registered);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", typelib: ");
		result.append(typelib);
		result.append(", unless: ");
		result.append(unless);
		result.append(", unregister: ");
		result.append(unregister);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntWin32TasksRegAsmTaskImpl
