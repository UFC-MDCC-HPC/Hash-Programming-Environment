/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.IgnorelibrariesType;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLinkTask;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.SymbolsType;

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
 * An implementation of the model object '<em><b>NAnt Visual Cpp Tasks Link Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getDelayloaded <em>Delayloaded</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getLibdirs <em>Libdirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getEmbeddedresources <em>Embeddedresources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getSymbols <em>Symbols</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getIgnorelibraries <em>Ignorelibraries</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getPdbfile <em>Pdbfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksLinkTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntVisualCppTasksLinkTaskImpl extends EObjectImpl implements NAntVisualCppTasksLinkTask {
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
	protected NAntVisualCppTasksLinkTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getDelayloaded() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Delayloaded());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getSources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Sources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getLibdirs() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Libdirs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getModules() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Modules());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getEmbeddedresources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Embeddedresources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SymbolsType> getSymbols() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Symbols());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IgnorelibrariesType> getIgnorelibraries() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Ignorelibraries());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksLinkTask_Arg());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IF, oldIf, if_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OPTIONS, oldOptions, options));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OUTPUT, oldOutput, output));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__PDBFILE, oldPdbfile, pdbfile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__DELAYLOADED:
				return ((InternalEList<?>)getDelayloaded()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__LIBDIRS:
				return ((InternalEList<?>)getLibdirs()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__EMBEDDEDRESOURCES:
				return ((InternalEList<?>)getEmbeddedresources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SYMBOLS:
				return ((InternalEList<?>)getSymbols()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IGNORELIBRARIES:
				return ((InternalEList<?>)getIgnorelibraries()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__DELAYLOADED:
				return getDelayloaded();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SOURCES:
				return getSources();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__LIBDIRS:
				return getLibdirs();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__MODULES:
				return getModules();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__EMBEDDEDRESOURCES:
				return getEmbeddedresources();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SYMBOLS:
				return getSymbols();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IGNORELIBRARIES:
				return getIgnorelibraries();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ARG:
				return getArg();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IF:
				return getIf();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OPTIONS:
				return getOptions();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__PDBFILE:
				return getPdbfile();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__DELAYLOADED:
				getDelayloaded().clear();
				getDelayloaded().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__LIBDIRS:
				getLibdirs().clear();
				getLibdirs().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__EMBEDDEDRESOURCES:
				getEmbeddedresources().clear();
				getEmbeddedresources().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SYMBOLS:
				getSymbols().clear();
				getSymbols().addAll((Collection<? extends SymbolsType>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IGNORELIBRARIES:
				getIgnorelibraries().clear();
				getIgnorelibraries().addAll((Collection<? extends IgnorelibrariesType>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OPTIONS:
				setOptions(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__PDBFILE:
				setPdbfile(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__DELAYLOADED:
				getDelayloaded().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SOURCES:
				getSources().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__LIBDIRS:
				getLibdirs().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__MODULES:
				getModules().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__EMBEDDEDRESOURCES:
				getEmbeddedresources().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SYMBOLS:
				getSymbols().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IGNORELIBRARIES:
				getIgnorelibraries().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OPTIONS:
				setOptions(OPTIONS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__PDBFILE:
				setPdbfile(PDBFILE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__DELAYLOADED:
				return !getDelayloaded().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SOURCES:
				return !getSources().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__LIBDIRS:
				return !getLibdirs().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__MODULES:
				return !getModules().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__EMBEDDEDRESOURCES:
				return !getEmbeddedresources().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__SYMBOLS:
				return !getSymbols().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IGNORELIBRARIES:
				return !getIgnorelibraries().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OPTIONS:
				return OPTIONS_EDEFAULT == null ? options != null : !OPTIONS_EDEFAULT.equals(options);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__PDBFILE:
				return PDBFILE_EDEFAULT == null ? pdbfile != null : !PDBFILE_EDEFAULT.equals(pdbfile);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK__ANY_ATTRIBUTE:
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
		result.append(", options: ");
		result.append(options);
		result.append(", output: ");
		result.append(output);
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

} //NAntVisualCppTasksLinkTaskImpl
