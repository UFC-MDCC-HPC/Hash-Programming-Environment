/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.DefinesType2;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksClTask;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.UndefinesType1;

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
 * An implementation of the model object '<em><b>NAnt Visual Cpp Tasks Cl Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getIncludedirs <em>Includedirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getMetadataincludedirs <em>Metadataincludedirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getForcedusingfiles <em>Forcedusingfiles</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getDefines <em>Defines</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getUndefines <em>Undefines</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getCharacterset <em>Characterset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getManagedextensions <em>Managedextensions</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getObjectfile <em>Objectfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getOutputdir <em>Outputdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getPchfile <em>Pchfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getPchmode <em>Pchmode</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getPchthroughfile <em>Pchthroughfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getPdbfile <em>Pdbfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksClTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntVisualCppTasksClTaskImpl extends EObjectImpl implements NAntVisualCppTasksClTask {
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
	 * The default value of the '{@link #getCharacterset() <em>Characterset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterset()
	 * @generated
	 * @ordered
	 */
	protected static final Object CHARACTERSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCharacterset() <em>Characterset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterset()
	 * @generated
	 * @ordered
	 */
	protected Object characterset = CHARACTERSET_EDEFAULT;

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
	 * The default value of the '{@link #getManagedextensions() <em>Managedextensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedextensions()
	 * @generated
	 * @ordered
	 */
	protected static final Object MANAGEDEXTENSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManagedextensions() <em>Managedextensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedextensions()
	 * @generated
	 * @ordered
	 */
	protected Object managedextensions = MANAGEDEXTENSIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectfile() <em>Objectfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECTFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectfile() <em>Objectfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectfile()
	 * @generated
	 * @ordered
	 */
	protected Object objectfile = OBJECTFILE_EDEFAULT;

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
	 * The default value of the '{@link #getOutputdir() <em>Outputdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputdir()
	 * @generated
	 * @ordered
	 */
	protected static final Object OUTPUTDIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputdir() <em>Outputdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputdir()
	 * @generated
	 * @ordered
	 */
	protected Object outputdir = OUTPUTDIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPchfile() <em>Pchfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPchfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object PCHFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPchfile() <em>Pchfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPchfile()
	 * @generated
	 * @ordered
	 */
	protected Object pchfile = PCHFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPchmode() <em>Pchmode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPchmode()
	 * @generated
	 * @ordered
	 */
	protected static final Object PCHMODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPchmode() <em>Pchmode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPchmode()
	 * @generated
	 * @ordered
	 */
	protected Object pchmode = PCHMODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPchthroughfile() <em>Pchthroughfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPchthroughfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object PCHTHROUGHFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPchthroughfile() <em>Pchthroughfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPchthroughfile()
	 * @generated
	 * @ordered
	 */
	protected Object pchthroughfile = PCHTHROUGHFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPdbfile() <em>Pdbfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPdbfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object PDBFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPdbfile() <em>Pdbfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPdbfile()
	 * @generated
	 * @ordered
	 */
	protected Object pdbfile = PDBFILE_EDEFAULT;

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
	protected NAntVisualCppTasksClTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntVisualCppTasksClTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getSources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksClTask_Sources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getIncludedirs() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksClTask_Includedirs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getMetadataincludedirs() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksClTask_Metadataincludedirs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getForcedusingfiles() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksClTask_Forcedusingfiles());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefinesType2> getDefines() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksClTask_Defines());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UndefinesType1> getUndefines() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksClTask_Undefines());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksClTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCharacterset() {
		return characterset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterset(Object newCharacterset) {
		Object oldCharacterset = characterset;
		characterset = newCharacterset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__CHARACTERSET, oldCharacterset, characterset));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getManagedextensions() {
		return managedextensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedextensions(Object newManagedextensions) {
		Object oldManagedextensions = managedextensions;
		managedextensions = newManagedextensions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__MANAGEDEXTENSIONS, oldManagedextensions, managedextensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getObjectfile() {
		return objectfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectfile(Object newObjectfile) {
		Object oldObjectfile = objectfile;
		objectfile = newObjectfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OBJECTFILE, oldObjectfile, objectfile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OPTIONS, oldOptions, options));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOutputdir() {
		return outputdir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputdir(Object newOutputdir) {
		Object oldOutputdir = outputdir;
		outputdir = newOutputdir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OUTPUTDIR, oldOutputdir, outputdir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPchfile() {
		return pchfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPchfile(Object newPchfile) {
		Object oldPchfile = pchfile;
		pchfile = newPchfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHFILE, oldPchfile, pchfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPchmode() {
		return pchmode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPchmode(Object newPchmode) {
		Object oldPchmode = pchmode;
		pchmode = newPchmode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHMODE, oldPchmode, pchmode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPchthroughfile() {
		return pchthroughfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPchthroughfile(Object newPchthroughfile) {
		Object oldPchthroughfile = pchthroughfile;
		pchthroughfile = newPchthroughfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHTHROUGHFILE, oldPchthroughfile, pchthroughfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPdbfile() {
		return pdbfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPdbfile(Object newPdbfile) {
		Object oldPdbfile = pdbfile;
		pdbfile = newPdbfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PDBFILE, oldPdbfile, pdbfile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__INCLUDEDIRS:
				return ((InternalEList<?>)getIncludedirs()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__METADATAINCLUDEDIRS:
				return ((InternalEList<?>)getMetadataincludedirs()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FORCEDUSINGFILES:
				return ((InternalEList<?>)getForcedusingfiles()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__DEFINES:
				return ((InternalEList<?>)getDefines()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNDEFINES:
				return ((InternalEList<?>)getUndefines()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__SOURCES:
				return getSources();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__INCLUDEDIRS:
				return getIncludedirs();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__METADATAINCLUDEDIRS:
				return getMetadataincludedirs();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FORCEDUSINGFILES:
				return getForcedusingfiles();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__DEFINES:
				return getDefines();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNDEFINES:
				return getUndefines();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ARG:
				return getArg();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__CHARACTERSET:
				return getCharacterset();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__IF:
				return getIf();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__MANAGEDEXTENSIONS:
				return getManagedextensions();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OBJECTFILE:
				return getObjectfile();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OPTIONS:
				return getOptions();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OUTPUTDIR:
				return getOutputdir();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHFILE:
				return getPchfile();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHMODE:
				return getPchmode();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHTHROUGHFILE:
				return getPchthroughfile();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PDBFILE:
				return getPdbfile();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__INCLUDEDIRS:
				getIncludedirs().clear();
				getIncludedirs().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__METADATAINCLUDEDIRS:
				getMetadataincludedirs().clear();
				getMetadataincludedirs().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FORCEDUSINGFILES:
				getForcedusingfiles().clear();
				getForcedusingfiles().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__DEFINES:
				getDefines().clear();
				getDefines().addAll((Collection<? extends DefinesType2>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNDEFINES:
				getUndefines().clear();
				getUndefines().addAll((Collection<? extends UndefinesType1>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__CHARACTERSET:
				setCharacterset(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__MANAGEDEXTENSIONS:
				setManagedextensions(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OBJECTFILE:
				setObjectfile(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OPTIONS:
				setOptions(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OUTPUTDIR:
				setOutputdir(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHFILE:
				setPchfile(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHMODE:
				setPchmode(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHTHROUGHFILE:
				setPchthroughfile(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PDBFILE:
				setPdbfile(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__SOURCES:
				getSources().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__INCLUDEDIRS:
				getIncludedirs().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__METADATAINCLUDEDIRS:
				getMetadataincludedirs().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FORCEDUSINGFILES:
				getForcedusingfiles().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__DEFINES:
				getDefines().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNDEFINES:
				getUndefines().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__CHARACTERSET:
				setCharacterset(CHARACTERSET_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__MANAGEDEXTENSIONS:
				setManagedextensions(MANAGEDEXTENSIONS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OBJECTFILE:
				setObjectfile(OBJECTFILE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OPTIONS:
				setOptions(OPTIONS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OUTPUTDIR:
				setOutputdir(OUTPUTDIR_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHFILE:
				setPchfile(PCHFILE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHMODE:
				setPchmode(PCHMODE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHTHROUGHFILE:
				setPchthroughfile(PCHTHROUGHFILE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PDBFILE:
				setPdbfile(PDBFILE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__SOURCES:
				return !getSources().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__INCLUDEDIRS:
				return !getIncludedirs().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__METADATAINCLUDEDIRS:
				return !getMetadataincludedirs().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FORCEDUSINGFILES:
				return !getForcedusingfiles().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__DEFINES:
				return !getDefines().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNDEFINES:
				return !getUndefines().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__CHARACTERSET:
				return CHARACTERSET_EDEFAULT == null ? characterset != null : !CHARACTERSET_EDEFAULT.equals(characterset);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__MANAGEDEXTENSIONS:
				return MANAGEDEXTENSIONS_EDEFAULT == null ? managedextensions != null : !MANAGEDEXTENSIONS_EDEFAULT.equals(managedextensions);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OBJECTFILE:
				return OBJECTFILE_EDEFAULT == null ? objectfile != null : !OBJECTFILE_EDEFAULT.equals(objectfile);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OPTIONS:
				return OPTIONS_EDEFAULT == null ? options != null : !OPTIONS_EDEFAULT.equals(options);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__OUTPUTDIR:
				return OUTPUTDIR_EDEFAULT == null ? outputdir != null : !OUTPUTDIR_EDEFAULT.equals(outputdir);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHFILE:
				return PCHFILE_EDEFAULT == null ? pchfile != null : !PCHFILE_EDEFAULT.equals(pchfile);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHMODE:
				return PCHMODE_EDEFAULT == null ? pchmode != null : !PCHMODE_EDEFAULT.equals(pchmode);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PCHTHROUGHFILE:
				return PCHTHROUGHFILE_EDEFAULT == null ? pchthroughfile != null : !PCHTHROUGHFILE_EDEFAULT.equals(pchthroughfile);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__PDBFILE:
				return PDBFILE_EDEFAULT == null ? pdbfile != null : !PDBFILE_EDEFAULT.equals(pdbfile);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK__ANY_ATTRIBUTE:
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
		result.append(", characterset: ");
		result.append(characterset);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", managedextensions: ");
		result.append(managedextensions);
		result.append(", objectfile: ");
		result.append(objectfile);
		result.append(", options: ");
		result.append(options);
		result.append(", outputdir: ");
		result.append(outputdir);
		result.append(", pchfile: ");
		result.append(pchfile);
		result.append(", pchmode: ");
		result.append(pchmode);
		result.append(", pchthroughfile: ");
		result.append(pchthroughfile);
		result.append(", pdbfile: ");
		result.append(pdbfile);
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

} //NAntVisualCppTasksClTaskImpl
