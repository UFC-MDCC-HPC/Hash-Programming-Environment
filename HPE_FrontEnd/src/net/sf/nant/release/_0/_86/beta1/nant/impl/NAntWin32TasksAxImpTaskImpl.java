/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksAxImpTask;
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
 * An implementation of the model object '<em><b>NAnt Win32 Tasks Ax Imp Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getDelaysign <em>Delaysign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getGeneratesource <em>Generatesource</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getKeycontainer <em>Keycontainer</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getKeyfile <em>Keyfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getOcx <em>Ocx</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getPublickey <em>Publickey</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getRcw <em>Rcw</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntWin32TasksAxImpTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntWin32TasksAxImpTaskImpl extends EObjectImpl implements NAntWin32TasksAxImpTask {
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
	 * The default value of the '{@link #getDelaysign() <em>Delaysign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelaysign()
	 * @generated
	 * @ordered
	 */
	protected static final Object DELAYSIGN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDelaysign() <em>Delaysign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelaysign()
	 * @generated
	 * @ordered
	 */
	protected Object delaysign = DELAYSIGN_EDEFAULT;

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
	 * The default value of the '{@link #getGeneratesource() <em>Generatesource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratesource()
	 * @generated
	 * @ordered
	 */
	protected static final Object GENERATESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeneratesource() <em>Generatesource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratesource()
	 * @generated
	 * @ordered
	 */
	protected Object generatesource = GENERATESOURCE_EDEFAULT;

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
	 * The default value of the '{@link #getKeycontainer() <em>Keycontainer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeycontainer()
	 * @generated
	 * @ordered
	 */
	protected static final Object KEYCONTAINER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeycontainer() <em>Keycontainer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeycontainer()
	 * @generated
	 * @ordered
	 */
	protected Object keycontainer = KEYCONTAINER_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyfile() <em>Keyfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object KEYFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyfile() <em>Keyfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyfile()
	 * @generated
	 * @ordered
	 */
	protected Object keyfile = KEYFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOcx() <em>Ocx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcx()
	 * @generated
	 * @ordered
	 */
	protected static final Object OCX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOcx() <em>Ocx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcx()
	 * @generated
	 * @ordered
	 */
	protected Object ocx = OCX_EDEFAULT;

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
	 * The default value of the '{@link #getPublickey() <em>Publickey</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublickey()
	 * @generated
	 * @ordered
	 */
	protected static final Object PUBLICKEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublickey() <em>Publickey</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublickey()
	 * @generated
	 * @ordered
	 */
	protected Object publickey = PUBLICKEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRcw() <em>Rcw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRcw()
	 * @generated
	 * @ordered
	 */
	protected static final Object RCW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRcw() <em>Rcw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRcw()
	 * @generated
	 * @ordered
	 */
	protected Object rcw = RCW_EDEFAULT;

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
	protected NAntWin32TasksAxImpTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntWin32TasksAxImpTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntWin32TasksAxImpTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDelaysign() {
		return delaysign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelaysign(Object newDelaysign) {
		Object oldDelaysign = delaysign;
		delaysign = newDelaysign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__DELAYSIGN, oldDelaysign, delaysign));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__FAILONERROR, oldFailonerror, failonerror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getGeneratesource() {
		return generatesource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratesource(Object newGeneratesource) {
		Object oldGeneratesource = generatesource;
		generatesource = newGeneratesource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GENERATESOURCE, oldGeneratesource, generatesource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getKeycontainer() {
		return keycontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeycontainer(Object newKeycontainer) {
		Object oldKeycontainer = keycontainer;
		keycontainer = newKeycontainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYCONTAINER, oldKeycontainer, keycontainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getKeyfile() {
		return keyfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyfile(Object newKeyfile) {
		Object oldKeyfile = keyfile;
		keyfile = newKeyfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYFILE, oldKeyfile, keyfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOcx() {
		return ocx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOcx(Object newOcx) {
		Object oldOcx = ocx;
		ocx = newOcx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OCX, oldOcx, ocx));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPublickey() {
		return publickey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublickey(Object newPublickey) {
		Object oldPublickey = publickey;
		publickey = newPublickey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__PUBLICKEY, oldPublickey, publickey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRcw() {
		return rcw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRcw(Object newRcw) {
		Object oldRcw = rcw;
		rcw = newRcw;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__RCW, oldRcw, rcw));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ARG:
				return getArg();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__DELAYSIGN:
				return getDelaysign();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GENERATESOURCE:
				return getGeneratesource();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__IF:
				return getIf();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYCONTAINER:
				return getKeycontainer();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYFILE:
				return getKeyfile();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OCX:
				return getOcx();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__PUBLICKEY:
				return getPublickey();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__RCW:
				return getRcw();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__DELAYSIGN:
				setDelaysign(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GENERATESOURCE:
				setGeneratesource(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYCONTAINER:
				setKeycontainer(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYFILE:
				setKeyfile(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OCX:
				setOcx(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__PUBLICKEY:
				setPublickey(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__RCW:
				setRcw(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__DELAYSIGN:
				setDelaysign(DELAYSIGN_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GENERATESOURCE:
				setGeneratesource(GENERATESOURCE_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYCONTAINER:
				setKeycontainer(KEYCONTAINER_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYFILE:
				setKeyfile(KEYFILE_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OCX:
				setOcx(OCX_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__PUBLICKEY:
				setPublickey(PUBLICKEY_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__RCW:
				setRcw(RCW_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__DELAYSIGN:
				return DELAYSIGN_EDEFAULT == null ? delaysign != null : !DELAYSIGN_EDEFAULT.equals(delaysign);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__GENERATESOURCE:
				return GENERATESOURCE_EDEFAULT == null ? generatesource != null : !GENERATESOURCE_EDEFAULT.equals(generatesource);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYCONTAINER:
				return KEYCONTAINER_EDEFAULT == null ? keycontainer != null : !KEYCONTAINER_EDEFAULT.equals(keycontainer);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__KEYFILE:
				return KEYFILE_EDEFAULT == null ? keyfile != null : !KEYFILE_EDEFAULT.equals(keyfile);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OCX:
				return OCX_EDEFAULT == null ? ocx != null : !OCX_EDEFAULT.equals(ocx);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__PUBLICKEY:
				return PUBLICKEY_EDEFAULT == null ? publickey != null : !PUBLICKEY_EDEFAULT.equals(publickey);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__RCW:
				return RCW_EDEFAULT == null ? rcw != null : !RCW_EDEFAULT.equals(rcw);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK__ANY_ATTRIBUTE:
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
		result.append(", delaysign: ");
		result.append(delaysign);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", generatesource: ");
		result.append(generatesource);
		result.append(", if: ");
		result.append(if_);
		result.append(", keycontainer: ");
		result.append(keycontainer);
		result.append(", keyfile: ");
		result.append(keyfile);
		result.append(", ocx: ");
		result.append(ocx);
		result.append(", output: ");
		result.append(output);
		result.append(", publickey: ");
		result.append(publickey);
		result.append(", rcw: ");
		result.append(rcw);
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

} //NAntWin32TasksAxImpTaskImpl
