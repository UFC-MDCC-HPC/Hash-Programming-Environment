/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.DefinesType1;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.OptionsType;
import net.sf.nant.release._0._86.beta1.nant.UndefinesType;

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
 * An implementation of the model object '<em><b>NAnt Visual Cpp Tasks Midl Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getDefines <em>Defines</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getUndefines <em>Undefines</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getIncludedirs <em>Includedirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getAcf <em>Acf</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getAlign <em>Align</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getAppConfig <em>App Config</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getChar <em>Char</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getClient <em>Client</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getCstub <em>Cstub</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getDlldata <em>Dlldata</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getIid <em>Iid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getOi <em>Oi</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getProxy <em>Proxy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getTlb <em>Tlb</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVisualCppTasksMidlTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntVisualCppTasksMidlTaskImpl extends EObjectImpl implements NAntVisualCppTasksMidlTask {
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
	 * The default value of the '{@link #getAcf() <em>Acf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcf()
	 * @generated
	 * @ordered
	 */
	protected static final Object ACF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAcf() <em>Acf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcf()
	 * @generated
	 * @ordered
	 */
	protected Object acf = ACF_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlign() <em>Align</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlign()
	 * @generated
	 * @ordered
	 */
	protected static final Object ALIGN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlign() <em>Align</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlign()
	 * @generated
	 * @ordered
	 */
	protected Object align = ALIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAppConfig() <em>App Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppConfig()
	 * @generated
	 * @ordered
	 */
	protected static final Object APP_CONFIG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAppConfig() <em>App Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppConfig()
	 * @generated
	 * @ordered
	 */
	protected Object appConfig = APP_CONFIG_EDEFAULT;

	/**
	 * The default value of the '{@link #getChar() <em>Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChar()
	 * @generated
	 * @ordered
	 */
	protected static final Object CHAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChar() <em>Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChar()
	 * @generated
	 * @ordered
	 */
	protected Object char_ = CHAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getClient() <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClient()
	 * @generated
	 * @ordered
	 */
	protected static final Object CLIENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClient() <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClient()
	 * @generated
	 * @ordered
	 */
	protected Object client = CLIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCstub() <em>Cstub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCstub()
	 * @generated
	 * @ordered
	 */
	protected static final Object CSTUB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCstub() <em>Cstub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCstub()
	 * @generated
	 * @ordered
	 */
	protected Object cstub = CSTUB_EDEFAULT;

	/**
	 * The default value of the '{@link #getDlldata() <em>Dlldata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDlldata()
	 * @generated
	 * @ordered
	 */
	protected static final Object DLLDATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDlldata() <em>Dlldata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDlldata()
	 * @generated
	 * @ordered
	 */
	protected Object dlldata = DLLDATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnv() <em>Env</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnv()
	 * @generated
	 * @ordered
	 */
	protected static final Object ENV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnv() <em>Env</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnv()
	 * @generated
	 * @ordered
	 */
	protected Object env = ENV_EDEFAULT;

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
	 * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected static final Object FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected Object filename = FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected static final Object HEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Object header = HEADER_EDEFAULT;

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
	 * The default value of the '{@link #getIid() <em>Iid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIid()
	 * @generated
	 * @ordered
	 */
	protected static final Object IID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIid() <em>Iid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIid()
	 * @generated
	 * @ordered
	 */
	protected Object iid = IID_EDEFAULT;

	/**
	 * The default value of the '{@link #getOi() <em>Oi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOi()
	 * @generated
	 * @ordered
	 */
	protected static final Object OI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOi() <em>Oi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOi()
	 * @generated
	 * @ordered
	 */
	protected Object oi = OI_EDEFAULT;

	/**
	 * The default value of the '{@link #getProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxy()
	 * @generated
	 * @ordered
	 */
	protected static final Object PROXY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxy()
	 * @generated
	 * @ordered
	 */
	protected Object proxy = PROXY_EDEFAULT;

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
	protected NAntVisualCppTasksMidlTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntVisualCppTasksMidlTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OptionsType> getOptions() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksMidlTask_Options());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefinesType1> getDefines() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksMidlTask_Defines());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UndefinesType> getUndefines() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksMidlTask_Undefines());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getIncludedirs() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksMidlTask_Includedirs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVisualCppTasksMidlTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAcf() {
		return acf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcf(Object newAcf) {
		Object oldAcf = acf;
		acf = newAcf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ACF, oldAcf, acf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAlign() {
		return align;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlign(Object newAlign) {
		Object oldAlign = align;
		align = newAlign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ALIGN, oldAlign, align));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAppConfig() {
		return appConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppConfig(Object newAppConfig) {
		Object oldAppConfig = appConfig;
		appConfig = newAppConfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__APP_CONFIG, oldAppConfig, appConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getChar() {
		return char_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChar(Object newChar) {
		Object oldChar = char_;
		char_ = newChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CHAR, oldChar, char_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getClient() {
		return client;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClient(Object newClient) {
		Object oldClient = client;
		client = newClient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CLIENT, oldClient, client));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCstub() {
		return cstub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCstub(Object newCstub) {
		Object oldCstub = cstub;
		cstub = newCstub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CSTUB, oldCstub, cstub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDlldata() {
		return dlldata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDlldata(Object newDlldata) {
		Object oldDlldata = dlldata;
		dlldata = newDlldata;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DLLDATA, oldDlldata, dlldata));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEnv() {
		return env;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnv(Object newEnv) {
		Object oldEnv = env;
		env = newEnv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ENV, oldEnv, env));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FAILONERROR, oldFailonerror, failonerror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFilename() {
		return filename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilename(Object newFilename) {
		Object oldFilename = filename;
		filename = newFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(Object newHeader) {
		Object oldHeader = header;
		header = newHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__HEADER, oldHeader, header));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIid() {
		return iid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIid(Object newIid) {
		Object oldIid = iid;
		iid = newIid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IID, oldIid, iid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOi() {
		return oi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOi(Object newOi) {
		Object oldOi = oi;
		oi = newOi;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OI, oldOi, oi));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getProxy() {
		return proxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxy(Object newProxy) {
		Object oldProxy = proxy;
		proxy = newProxy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__PROXY, oldProxy, proxy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TLB, oldTlb, tlb));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OPTIONS:
				return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DEFINES:
				return ((InternalEList<?>)getDefines()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNDEFINES:
				return ((InternalEList<?>)getUndefines()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__INCLUDEDIRS:
				return ((InternalEList<?>)getIncludedirs()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OPTIONS:
				return getOptions();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DEFINES:
				return getDefines();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNDEFINES:
				return getUndefines();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__INCLUDEDIRS:
				return getIncludedirs();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ARG:
				return getArg();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ACF:
				return getAcf();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ALIGN:
				return getAlign();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__APP_CONFIG:
				return getAppConfig();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CHAR:
				return getChar();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CLIENT:
				return getClient();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CSTUB:
				return getCstub();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DLLDATA:
				return getDlldata();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ENV:
				return getEnv();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FILENAME:
				return getFilename();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__HEADER:
				return getHeader();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IF:
				return getIf();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IID:
				return getIid();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OI:
				return getOi();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__PROXY:
				return getProxy();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TLB:
				return getTlb();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends OptionsType>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DEFINES:
				getDefines().clear();
				getDefines().addAll((Collection<? extends DefinesType1>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNDEFINES:
				getUndefines().clear();
				getUndefines().addAll((Collection<? extends UndefinesType>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__INCLUDEDIRS:
				getIncludedirs().clear();
				getIncludedirs().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ACF:
				setAcf(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ALIGN:
				setAlign(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__APP_CONFIG:
				setAppConfig(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CHAR:
				setChar(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CLIENT:
				setClient(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CSTUB:
				setCstub(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DLLDATA:
				setDlldata(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ENV:
				setEnv(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FILENAME:
				setFilename(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__HEADER:
				setHeader(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IID:
				setIid(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OI:
				setOi(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__PROXY:
				setProxy(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TLB:
				setTlb(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OPTIONS:
				getOptions().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DEFINES:
				getDefines().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNDEFINES:
				getUndefines().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__INCLUDEDIRS:
				getIncludedirs().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ACF:
				setAcf(ACF_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ALIGN:
				setAlign(ALIGN_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__APP_CONFIG:
				setAppConfig(APP_CONFIG_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CHAR:
				setChar(CHAR_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CLIENT:
				setClient(CLIENT_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CSTUB:
				setCstub(CSTUB_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DLLDATA:
				setDlldata(DLLDATA_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ENV:
				setEnv(ENV_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FILENAME:
				setFilename(FILENAME_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__HEADER:
				setHeader(HEADER_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IID:
				setIid(IID_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OI:
				setOi(OI_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__PROXY:
				setProxy(PROXY_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TLB:
				setTlb(TLB_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OPTIONS:
				return !getOptions().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DEFINES:
				return !getDefines().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNDEFINES:
				return !getUndefines().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__INCLUDEDIRS:
				return !getIncludedirs().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ACF:
				return ACF_EDEFAULT == null ? acf != null : !ACF_EDEFAULT.equals(acf);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ALIGN:
				return ALIGN_EDEFAULT == null ? align != null : !ALIGN_EDEFAULT.equals(align);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__APP_CONFIG:
				return APP_CONFIG_EDEFAULT == null ? appConfig != null : !APP_CONFIG_EDEFAULT.equals(appConfig);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CHAR:
				return CHAR_EDEFAULT == null ? char_ != null : !CHAR_EDEFAULT.equals(char_);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CLIENT:
				return CLIENT_EDEFAULT == null ? client != null : !CLIENT_EDEFAULT.equals(client);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__CSTUB:
				return CSTUB_EDEFAULT == null ? cstub != null : !CSTUB_EDEFAULT.equals(cstub);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__DLLDATA:
				return DLLDATA_EDEFAULT == null ? dlldata != null : !DLLDATA_EDEFAULT.equals(dlldata);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ENV:
				return ENV_EDEFAULT == null ? env != null : !ENV_EDEFAULT.equals(env);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__FILENAME:
				return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__HEADER:
				return HEADER_EDEFAULT == null ? header != null : !HEADER_EDEFAULT.equals(header);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__IID:
				return IID_EDEFAULT == null ? iid != null : !IID_EDEFAULT.equals(iid);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__OI:
				return OI_EDEFAULT == null ? oi != null : !OI_EDEFAULT.equals(oi);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__PROXY:
				return PROXY_EDEFAULT == null ? proxy != null : !PROXY_EDEFAULT.equals(proxy);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__TLB:
				return TLB_EDEFAULT == null ? tlb != null : !TLB_EDEFAULT.equals(tlb);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK__ANY_ATTRIBUTE:
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
		result.append(", acf: ");
		result.append(acf);
		result.append(", align: ");
		result.append(align);
		result.append(", appConfig: ");
		result.append(appConfig);
		result.append(", char: ");
		result.append(char_);
		result.append(", client: ");
		result.append(client);
		result.append(", cstub: ");
		result.append(cstub);
		result.append(", dlldata: ");
		result.append(dlldata);
		result.append(", env: ");
		result.append(env);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", filename: ");
		result.append(filename);
		result.append(", header: ");
		result.append(header);
		result.append(", if: ");
		result.append(if_);
		result.append(", iid: ");
		result.append(iid);
		result.append(", oi: ");
		result.append(oi);
		result.append(", proxy: ");
		result.append(proxy);
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

} //NAntVisualCppTasksMidlTaskImpl
