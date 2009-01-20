/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksExecTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesEnvironmentSet;
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
 * An implementation of the model object '<em><b>NAnt Core Tasks Exec Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getAppend <em>Append</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getBasedir <em>Basedir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getCommandline <em>Commandline</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getManaged <em>Managed</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getPidproperty <em>Pidproperty</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getProgram <em>Program</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getResultproperty <em>Resultproperty</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getSpawn <em>Spawn</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getUseruntimeengine <em>Useruntimeengine</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getWorkingdir <em>Workingdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksExecTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTasksExecTaskImpl extends EObjectImpl implements NAntCoreTasksExecTask {
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
	 * The default value of the '{@link #getAppend() <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppend()
	 * @generated
	 * @ordered
	 */
	protected static final Object APPEND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAppend() <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppend()
	 * @generated
	 * @ordered
	 */
	protected Object append = APPEND_EDEFAULT;

	/**
	 * The default value of the '{@link #getBasedir() <em>Basedir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasedir()
	 * @generated
	 * @ordered
	 */
	protected static final Object BASEDIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasedir() <em>Basedir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasedir()
	 * @generated
	 * @ordered
	 */
	protected Object basedir = BASEDIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandline() <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandline()
	 * @generated
	 * @ordered
	 */
	protected static final Object COMMANDLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandline() <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandline()
	 * @generated
	 * @ordered
	 */
	protected Object commandline = COMMANDLINE_EDEFAULT;

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
	 * The default value of the '{@link #getManaged() <em>Managed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManaged()
	 * @generated
	 * @ordered
	 */
	protected static final Object MANAGED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManaged() <em>Managed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManaged()
	 * @generated
	 * @ordered
	 */
	protected Object managed = MANAGED_EDEFAULT;

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
	 * The default value of the '{@link #getPidproperty() <em>Pidproperty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPidproperty()
	 * @generated
	 * @ordered
	 */
	protected static final Object PIDPROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPidproperty() <em>Pidproperty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPidproperty()
	 * @generated
	 * @ordered
	 */
	protected Object pidproperty = PIDPROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProgram() <em>Program</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgram()
	 * @generated
	 * @ordered
	 */
	protected static final Object PROGRAM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProgram() <em>Program</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgram()
	 * @generated
	 * @ordered
	 */
	protected Object program = PROGRAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getResultproperty() <em>Resultproperty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultproperty()
	 * @generated
	 * @ordered
	 */
	protected static final Object RESULTPROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultproperty() <em>Resultproperty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultproperty()
	 * @generated
	 * @ordered
	 */
	protected Object resultproperty = RESULTPROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpawn() <em>Spawn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpawn()
	 * @generated
	 * @ordered
	 */
	protected static final Object SPAWN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpawn() <em>Spawn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpawn()
	 * @generated
	 * @ordered
	 */
	protected Object spawn = SPAWN_EDEFAULT;

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
	 * The default value of the '{@link #getUseruntimeengine() <em>Useruntimeengine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseruntimeengine()
	 * @generated
	 * @ordered
	 */
	protected static final Object USERUNTIMEENGINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUseruntimeengine() <em>Useruntimeengine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseruntimeengine()
	 * @generated
	 * @ordered
	 */
	protected Object useruntimeengine = USERUNTIMEENGINE_EDEFAULT;

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
	 * The default value of the '{@link #getWorkingdir() <em>Workingdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkingdir()
	 * @generated
	 * @ordered
	 */
	protected static final Object WORKINGDIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorkingdir() <em>Workingdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkingdir()
	 * @generated
	 * @ordered
	 */
	protected Object workingdir = WORKINGDIR_EDEFAULT;

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
	protected NAntCoreTasksExecTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTasksExecTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASKS_EXEC_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesEnvironmentSet> getEnvironment() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTasksExecTask_Environment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTasksExecTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAppend() {
		return append;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppend(Object newAppend) {
		Object oldAppend = append;
		append = newAppend;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__APPEND, oldAppend, append));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBasedir() {
		return basedir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasedir(Object newBasedir) {
		Object oldBasedir = basedir;
		basedir = newBasedir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__BASEDIR, oldBasedir, basedir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCommandline() {
		return commandline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandline(Object newCommandline) {
		Object oldCommandline = commandline;
		commandline = newCommandline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__COMMANDLINE, oldCommandline, commandline));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getManaged() {
		return managed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManaged(Object newManaged) {
		Object oldManaged = managed;
		managed = newManaged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__MANAGED, oldManaged, managed));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPidproperty() {
		return pidproperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPidproperty(Object newPidproperty) {
		Object oldPidproperty = pidproperty;
		pidproperty = newPidproperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__PIDPROPERTY, oldPidproperty, pidproperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getProgram() {
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgram(Object newProgram) {
		Object oldProgram = program;
		program = newProgram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__PROGRAM, oldProgram, program));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getResultproperty() {
		return resultproperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultproperty(Object newResultproperty) {
		Object oldResultproperty = resultproperty;
		resultproperty = newResultproperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__RESULTPROPERTY, oldResultproperty, resultproperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSpawn() {
		return spawn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpawn(Object newSpawn) {
		Object oldSpawn = spawn;
		spawn = newSpawn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__SPAWN, oldSpawn, spawn));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUseruntimeengine() {
		return useruntimeengine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseruntimeengine(Object newUseruntimeengine) {
		Object oldUseruntimeengine = useruntimeengine;
		useruntimeengine = newUseruntimeengine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__USERUNTIMEENGINE, oldUseruntimeengine, useruntimeengine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWorkingdir() {
		return workingdir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkingdir(Object newWorkingdir) {
		Object oldWorkingdir = workingdir;
		workingdir = newWorkingdir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_EXEC_TASK__WORKINGDIR, oldWorkingdir, workingdir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASKS_EXEC_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ENVIRONMENT:
				return ((InternalEList<?>)getEnvironment()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ENVIRONMENT:
				return getEnvironment();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ARG:
				return getArg();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__APPEND:
				return getAppend();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__BASEDIR:
				return getBasedir();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__COMMANDLINE:
				return getCommandline();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__IF:
				return getIf();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__MANAGED:
				return getManaged();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PIDPROPERTY:
				return getPidproperty();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PROGRAM:
				return getProgram();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__RESULTPROPERTY:
				return getResultproperty();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__SPAWN:
				return getSpawn();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__USERUNTIMEENGINE:
				return getUseruntimeengine();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__WORKINGDIR:
				return getWorkingdir();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ENVIRONMENT:
				getEnvironment().clear();
				getEnvironment().addAll((Collection<? extends NAntCoreTypesEnvironmentSet>)newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__APPEND:
				setAppend(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__BASEDIR:
				setBasedir(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__COMMANDLINE:
				setCommandline(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__MANAGED:
				setManaged(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PIDPROPERTY:
				setPidproperty(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PROGRAM:
				setProgram(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__RESULTPROPERTY:
				setResultproperty(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__SPAWN:
				setSpawn(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__USERUNTIMEENGINE:
				setUseruntimeengine(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__WORKINGDIR:
				setWorkingdir(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ENVIRONMENT:
				getEnvironment().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__APPEND:
				setAppend(APPEND_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__BASEDIR:
				setBasedir(BASEDIR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__COMMANDLINE:
				setCommandline(COMMANDLINE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__MANAGED:
				setManaged(MANAGED_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PIDPROPERTY:
				setPidproperty(PIDPROPERTY_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PROGRAM:
				setProgram(PROGRAM_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__RESULTPROPERTY:
				setResultproperty(RESULTPROPERTY_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__SPAWN:
				setSpawn(SPAWN_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__USERUNTIMEENGINE:
				setUseruntimeengine(USERUNTIMEENGINE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__WORKINGDIR:
				setWorkingdir(WORKINGDIR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ENVIRONMENT:
				return !getEnvironment().isEmpty();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__APPEND:
				return APPEND_EDEFAULT == null ? append != null : !APPEND_EDEFAULT.equals(append);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__BASEDIR:
				return BASEDIR_EDEFAULT == null ? basedir != null : !BASEDIR_EDEFAULT.equals(basedir);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__COMMANDLINE:
				return COMMANDLINE_EDEFAULT == null ? commandline != null : !COMMANDLINE_EDEFAULT.equals(commandline);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__MANAGED:
				return MANAGED_EDEFAULT == null ? managed != null : !MANAGED_EDEFAULT.equals(managed);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PIDPROPERTY:
				return PIDPROPERTY_EDEFAULT == null ? pidproperty != null : !PIDPROPERTY_EDEFAULT.equals(pidproperty);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__PROGRAM:
				return PROGRAM_EDEFAULT == null ? program != null : !PROGRAM_EDEFAULT.equals(program);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__RESULTPROPERTY:
				return RESULTPROPERTY_EDEFAULT == null ? resultproperty != null : !RESULTPROPERTY_EDEFAULT.equals(resultproperty);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__SPAWN:
				return SPAWN_EDEFAULT == null ? spawn != null : !SPAWN_EDEFAULT.equals(spawn);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__USERUNTIMEENGINE:
				return USERUNTIMEENGINE_EDEFAULT == null ? useruntimeengine != null : !USERUNTIMEENGINE_EDEFAULT.equals(useruntimeengine);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__WORKINGDIR:
				return WORKINGDIR_EDEFAULT == null ? workingdir != null : !WORKINGDIR_EDEFAULT.equals(workingdir);
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK__ANY_ATTRIBUTE:
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
		result.append(", append: ");
		result.append(append);
		result.append(", basedir: ");
		result.append(basedir);
		result.append(", commandline: ");
		result.append(commandline);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", managed: ");
		result.append(managed);
		result.append(", output: ");
		result.append(output);
		result.append(", pidproperty: ");
		result.append(pidproperty);
		result.append(", program: ");
		result.append(program);
		result.append(", resultproperty: ");
		result.append(resultproperty);
		result.append(", spawn: ");
		result.append(spawn);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", unless: ");
		result.append(unless);
		result.append(", useruntimeengine: ");
		result.append(useruntimeengine);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", workingdir: ");
		result.append(workingdir);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTasksExecTaskImpl
