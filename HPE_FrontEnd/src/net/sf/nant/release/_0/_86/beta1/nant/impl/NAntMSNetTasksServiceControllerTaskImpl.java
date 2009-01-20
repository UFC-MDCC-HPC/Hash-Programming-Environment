/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksServiceControllerTask;
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
 * An implementation of the model object '<em><b>NAnt MS Net Tasks Service Controller Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getAction <em>Action</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getService <em>Service</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksServiceControllerTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntMSNetTasksServiceControllerTaskImpl extends EObjectImpl implements NAntMSNetTasksServiceControllerTask {
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
	 * The default value of the '{@link #getMachine() <em>Machine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected static final Object MACHINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected Object machine = MACHINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected static final Object SERVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected Object service = SERVICE_EDEFAULT;

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
	protected NAntMSNetTasksServiceControllerTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntMSNetTasksServiceControllerTask();
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ACTION, oldAction, action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMachine() {
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachine(Object newMachine) {
		Object oldMachine = machine;
		machine = newMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__MACHINE, oldMachine, machine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Object newService) {
		Object oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__SERVICE, oldService, service));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ACTION:
				return getAction();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__IF:
				return getIf();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__MACHINE:
				return getMachine();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__SERVICE:
				return getService();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ACTION:
				setAction(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__MACHINE:
				setMachine(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__SERVICE:
				setService(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__MACHINE:
				setMachine(MACHINE_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__SERVICE:
				setService(SERVICE_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__MACHINE:
				return MACHINE_EDEFAULT == null ? machine != null : !MACHINE_EDEFAULT.equals(machine);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__SERVICE:
				return SERVICE_EDEFAULT == null ? service != null : !SERVICE_EDEFAULT.equals(service);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK__ANY_ATTRIBUTE:
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
		result.append(" (action: ");
		result.append(action);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", machine: ");
		result.append(machine);
		result.append(", service: ");
		result.append(service);
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

} //NAntMSNetTasksServiceControllerTaskImpl
