/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksRegsvcsTask;
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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks Regsvcs Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getAction <em>Action</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getApplication <em>Application</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getAssembly <em>Assembly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getComponentsonly <em>Componentsonly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getExistingapp <em>Existingapp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getExistingtlb <em>Existingtlb</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getNoreconfig <em>Noreconfig</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getPartition <em>Partition</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getTlb <em>Tlb</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksRegsvcsTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksRegsvcsTaskImpl extends EObjectImpl implements NAntDotNetTasksRegsvcsTask {
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
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final Object ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Object action = ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getApplication() <em>Application</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplication()
	 * @generated
	 * @ordered
	 */
	protected static final Object APPLICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplication() <em>Application</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplication()
	 * @generated
	 * @ordered
	 */
	protected Object application = APPLICATION_EDEFAULT;

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
	 * The default value of the '{@link #getComponentsonly() <em>Componentsonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentsonly()
	 * @generated
	 * @ordered
	 */
	protected static final Object COMPONENTSONLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentsonly() <em>Componentsonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentsonly()
	 * @generated
	 * @ordered
	 */
	protected Object componentsonly = COMPONENTSONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getExistingapp() <em>Existingapp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistingapp()
	 * @generated
	 * @ordered
	 */
	protected static final Object EXISTINGAPP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExistingapp() <em>Existingapp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistingapp()
	 * @generated
	 * @ordered
	 */
	protected Object existingapp = EXISTINGAPP_EDEFAULT;

	/**
	 * The default value of the '{@link #getExistingtlb() <em>Existingtlb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistingtlb()
	 * @generated
	 * @ordered
	 */
	protected static final Object EXISTINGTLB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExistingtlb() <em>Existingtlb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistingtlb()
	 * @generated
	 * @ordered
	 */
	protected Object existingtlb = EXISTINGTLB_EDEFAULT;

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
	 * The default value of the '{@link #getNoreconfig() <em>Noreconfig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoreconfig()
	 * @generated
	 * @ordered
	 */
	protected static final Object NORECONFIG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNoreconfig() <em>Noreconfig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoreconfig()
	 * @generated
	 * @ordered
	 */
	protected Object noreconfig = NORECONFIG_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartition() <em>Partition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartition()
	 * @generated
	 * @ordered
	 */
	protected static final Object PARTITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartition() <em>Partition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartition()
	 * @generated
	 * @ordered
	 */
	protected Object partition = PARTITION_EDEFAULT;

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
	 * The default value of the '{@link #getTlb() <em>Tlb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTlb()
	 * @generated
	 * @ordered
	 */
	protected static final Object TLB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTlb() <em>Tlb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTlb()
	 * @generated
	 * @ordered
	 */
	protected Object tlb = TLB_EDEFAULT;

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
	protected NAntDotNetTasksRegsvcsTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksRegsvcsTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksRegsvcsTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Object newAction) {
		Object oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getApplication() {
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplication(Object newApplication) {
		Object oldApplication = application;
		application = newApplication;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__APPLICATION, oldApplication, application));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ASSEMBLY, oldAssembly, assembly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getComponentsonly() {
		return componentsonly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentsonly(Object newComponentsonly) {
		Object oldComponentsonly = componentsonly;
		componentsonly = newComponentsonly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__COMPONENTSONLY, oldComponentsonly, componentsonly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getExistingapp() {
		return existingapp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExistingapp(Object newExistingapp) {
		Object oldExistingapp = existingapp;
		existingapp = newExistingapp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGAPP, oldExistingapp, existingapp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getExistingtlb() {
		return existingtlb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExistingtlb(Object newExistingtlb) {
		Object oldExistingtlb = existingtlb;
		existingtlb = newExistingtlb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGTLB, oldExistingtlb, existingtlb));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNoreconfig() {
		return noreconfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoreconfig(Object newNoreconfig) {
		Object oldNoreconfig = noreconfig;
		noreconfig = newNoreconfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__NORECONFIG, oldNoreconfig, noreconfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPartition() {
		return partition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartition(Object newPartition) {
		Object oldPartition = partition;
		partition = newPartition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__PARTITION, oldPartition, partition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTlb() {
		return tlb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTlb(Object newTlb) {
		Object oldTlb = tlb;
		tlb = newTlb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TLB, oldTlb, tlb));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ARG:
				return getArg();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ACTION:
				return getAction();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__APPLICATION:
				return getApplication();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ASSEMBLY:
				return getAssembly();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__COMPONENTSONLY:
				return getComponentsonly();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGAPP:
				return getExistingapp();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGTLB:
				return getExistingtlb();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__NORECONFIG:
				return getNoreconfig();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__PARTITION:
				return getPartition();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TLB:
				return getTlb();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ACTION:
				setAction(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__APPLICATION:
				setApplication(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ASSEMBLY:
				setAssembly(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__COMPONENTSONLY:
				setComponentsonly(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGAPP:
				setExistingapp(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGTLB:
				setExistingtlb(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__NORECONFIG:
				setNoreconfig(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__PARTITION:
				setPartition(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TLB:
				setTlb(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__APPLICATION:
				setApplication(APPLICATION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ASSEMBLY:
				setAssembly(ASSEMBLY_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__COMPONENTSONLY:
				setComponentsonly(COMPONENTSONLY_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGAPP:
				setExistingapp(EXISTINGAPP_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGTLB:
				setExistingtlb(EXISTINGTLB_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__NORECONFIG:
				setNoreconfig(NORECONFIG_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__PARTITION:
				setPartition(PARTITION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TLB:
				setTlb(TLB_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__APPLICATION:
				return APPLICATION_EDEFAULT == null ? application != null : !APPLICATION_EDEFAULT.equals(application);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ASSEMBLY:
				return ASSEMBLY_EDEFAULT == null ? assembly != null : !ASSEMBLY_EDEFAULT.equals(assembly);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__COMPONENTSONLY:
				return COMPONENTSONLY_EDEFAULT == null ? componentsonly != null : !COMPONENTSONLY_EDEFAULT.equals(componentsonly);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGAPP:
				return EXISTINGAPP_EDEFAULT == null ? existingapp != null : !EXISTINGAPP_EDEFAULT.equals(existingapp);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__EXISTINGTLB:
				return EXISTINGTLB_EDEFAULT == null ? existingtlb != null : !EXISTINGTLB_EDEFAULT.equals(existingtlb);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__NORECONFIG:
				return NORECONFIG_EDEFAULT == null ? noreconfig != null : !NORECONFIG_EDEFAULT.equals(noreconfig);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__PARTITION:
				return PARTITION_EDEFAULT == null ? partition != null : !PARTITION_EDEFAULT.equals(partition);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__TLB:
				return TLB_EDEFAULT == null ? tlb != null : !TLB_EDEFAULT.equals(tlb);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK__ANY_ATTRIBUTE:
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
		result.append(", action: ");
		result.append(action);
		result.append(", application: ");
		result.append(application);
		result.append(", assembly: ");
		result.append(assembly);
		result.append(", componentsonly: ");
		result.append(componentsonly);
		result.append(", existingapp: ");
		result.append(existingapp);
		result.append(", existingtlb: ");
		result.append(existingtlb);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", noreconfig: ");
		result.append(noreconfig);
		result.append(", partition: ");
		result.append(partition);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", tlb: ");
		result.append(tlb);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntDotNetTasksRegsvcsTaskImpl
