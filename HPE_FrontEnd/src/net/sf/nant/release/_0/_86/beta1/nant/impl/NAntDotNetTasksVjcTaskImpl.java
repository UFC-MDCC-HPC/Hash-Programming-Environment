/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVjcTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.NowarnType;

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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks Vjc Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getNowarn <em>Nowarn</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getLib <em>Lib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getReferences <em>References</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getDebug <em>Debug</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getDefine <em>Define</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getDelaysign <em>Delaysign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getJcpa <em>Jcpa</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getKeycontainer <em>Keycontainer</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getKeyfile <em>Keyfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getLibpath <em>Libpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getMain <em>Main</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getNowarn1 <em>Nowarn1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getRebuild <em>Rebuild</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getSecurescoping <em>Securescoping</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getWarnaserror <em>Warnaserror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getWarninglevel <em>Warninglevel</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getWin32icon <em>Win32icon</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getX <em>X</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVjcTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksVjcTaskImpl extends EObjectImpl implements NAntDotNetTasksVjcTask {
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
	 * The default value of the '{@link #getCodepage() <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodepage()
	 * @generated
	 * @ordered
	 */
	protected static final Object CODEPAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodepage() <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodepage()
	 * @generated
	 * @ordered
	 */
	protected Object codepage = CODEPAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebug()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEBUG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebug()
	 * @generated
	 * @ordered
	 */
	protected Object debug = DEBUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefine() <em>Define</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefine()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEFINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefine() <em>Define</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefine()
	 * @generated
	 * @ordered
	 */
	protected Object define = DEFINE_EDEFAULT;

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
	 * The default value of the '{@link #getJcpa() <em>Jcpa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJcpa()
	 * @generated
	 * @ordered
	 */
	protected static final Object JCPA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJcpa() <em>Jcpa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJcpa()
	 * @generated
	 * @ordered
	 */
	protected Object jcpa = JCPA_EDEFAULT;

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
	 * The default value of the '{@link #getLibpath() <em>Libpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibpath()
	 * @generated
	 * @ordered
	 */
	protected static final Object LIBPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibpath() <em>Libpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibpath()
	 * @generated
	 * @ordered
	 */
	protected Object libpath = LIBPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMain() <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected static final Object MAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMain() <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected Object main = MAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getNowarn1() <em>Nowarn1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNowarn1()
	 * @generated
	 * @ordered
	 */
	protected static final Object NOWARN1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNowarn1() <em>Nowarn1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNowarn1()
	 * @generated
	 * @ordered
	 */
	protected Object nowarn1 = NOWARN1_EDEFAULT;

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
	 * The default value of the '{@link #getRebuild() <em>Rebuild</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRebuild()
	 * @generated
	 * @ordered
	 */
	protected static final Object REBUILD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRebuild() <em>Rebuild</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRebuild()
	 * @generated
	 * @ordered
	 */
	protected Object rebuild = REBUILD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecurescoping() <em>Securescoping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurescoping()
	 * @generated
	 * @ordered
	 */
	protected static final Object SECURESCOPING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecurescoping() <em>Securescoping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurescoping()
	 * @generated
	 * @ordered
	 */
	protected Object securescoping = SECURESCOPING_EDEFAULT;

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
	 * The default value of the '{@link #getWarnaserror() <em>Warnaserror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarnaserror()
	 * @generated
	 * @ordered
	 */
	protected static final Object WARNASERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWarnaserror() <em>Warnaserror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarnaserror()
	 * @generated
	 * @ordered
	 */
	protected Object warnaserror = WARNASERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getWarninglevel() <em>Warninglevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarninglevel()
	 * @generated
	 * @ordered
	 */
	protected static final Object WARNINGLEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWarninglevel() <em>Warninglevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarninglevel()
	 * @generated
	 * @ordered
	 */
	protected Object warninglevel = WARNINGLEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getWin32icon() <em>Win32icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin32icon()
	 * @generated
	 * @ordered
	 */
	protected static final Object WIN32ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWin32icon() <em>Win32icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin32icon()
	 * @generated
	 * @ordered
	 */
	protected Object win32icon = WIN32ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final Object X_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected Object x = X_EDEFAULT;

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
	protected NAntDotNetTasksVjcTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksVjcTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NowarnType> getNowarn() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVjcTask_Nowarn());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getLib() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVjcTask_Lib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getReferences() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVjcTask_References());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesResourceFileSet> getResources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVjcTask_Resources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getSources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVjcTask_Sources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVjcTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCodepage() {
		return codepage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodepage(Object newCodepage) {
		Object oldCodepage = codepage;
		codepage = newCodepage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__CODEPAGE, oldCodepage, codepage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDebug() {
		return debug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebug(Object newDebug) {
		Object oldDebug = debug;
		debug = newDebug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEBUG, oldDebug, debug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDefine() {
		return define;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefine(Object newDefine) {
		Object oldDefine = define;
		define = newDefine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEFINE, oldDefine, define));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DELAYSIGN, oldDelaysign, delaysign));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getJcpa() {
		return jcpa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJcpa(Object newJcpa) {
		Object oldJcpa = jcpa;
		jcpa = newJcpa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__JCPA, oldJcpa, jcpa));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYCONTAINER, oldKeycontainer, keycontainer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYFILE, oldKeyfile, keyfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLibpath() {
		return libpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibpath(Object newLibpath) {
		Object oldLibpath = libpath;
		libpath = newLibpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIBPATH, oldLibpath, libpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMain() {
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMain(Object newMain) {
		Object oldMain = main;
		main = newMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__MAIN, oldMain, main));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNowarn1() {
		return nowarn1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNowarn1(Object newNowarn1) {
		Object oldNowarn1 = nowarn1;
		nowarn1 = newNowarn1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN1, oldNowarn1, nowarn1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRebuild() {
		return rebuild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRebuild(Object newRebuild) {
		Object oldRebuild = rebuild;
		rebuild = newRebuild;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REBUILD, oldRebuild, rebuild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSecurescoping() {
		return securescoping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurescoping(Object newSecurescoping) {
		Object oldSecurescoping = securescoping;
		securescoping = newSecurescoping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SECURESCOPING, oldSecurescoping, securescoping));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWarnaserror() {
		return warnaserror;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarnaserror(Object newWarnaserror) {
		Object oldWarnaserror = warnaserror;
		warnaserror = newWarnaserror;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNASERROR, oldWarnaserror, warnaserror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWarninglevel() {
		return warninglevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarninglevel(Object newWarninglevel) {
		Object oldWarninglevel = warninglevel;
		warninglevel = newWarninglevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNINGLEVEL, oldWarninglevel, warninglevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWin32icon() {
		return win32icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWin32icon(Object newWin32icon) {
		Object oldWin32icon = win32icon;
		win32icon = newWin32icon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WIN32ICON, oldWin32icon, win32icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(Object newX) {
		Object oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN:
				return ((InternalEList<?>)getNowarn()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIB:
				return ((InternalEList<?>)getLib()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN:
				return getNowarn();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIB:
				return getLib();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REFERENCES:
				return getReferences();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__RESOURCES:
				return getResources();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SOURCES:
				return getSources();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ARG:
				return getArg();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__CODEPAGE:
				return getCodepage();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEBUG:
				return getDebug();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEFINE:
				return getDefine();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DELAYSIGN:
				return getDelaysign();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__JCPA:
				return getJcpa();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYCONTAINER:
				return getKeycontainer();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYFILE:
				return getKeyfile();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIBPATH:
				return getLibpath();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__MAIN:
				return getMain();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN1:
				return getNowarn1();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REBUILD:
				return getRebuild();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SECURESCOPING:
				return getSecurescoping();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TARGET:
				return getTarget();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNASERROR:
				return getWarnaserror();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNINGLEVEL:
				return getWarninglevel();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WIN32ICON:
				return getWin32icon();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__X:
				return getX();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN:
				getNowarn().clear();
				getNowarn().addAll((Collection<? extends NowarnType>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIB:
				getLib().clear();
				getLib().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends NAntDotNetTypesResourceFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__CODEPAGE:
				setCodepage(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEBUG:
				setDebug(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEFINE:
				setDefine(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DELAYSIGN:
				setDelaysign(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__JCPA:
				setJcpa(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYCONTAINER:
				setKeycontainer(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYFILE:
				setKeyfile(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIBPATH:
				setLibpath(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__MAIN:
				setMain(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN1:
				setNowarn1(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REBUILD:
				setRebuild(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SECURESCOPING:
				setSecurescoping(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TARGET:
				setTarget(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNASERROR:
				setWarnaserror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNINGLEVEL:
				setWarninglevel(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WIN32ICON:
				setWin32icon(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__X:
				setX(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN:
				getNowarn().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIB:
				getLib().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REFERENCES:
				getReferences().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__RESOURCES:
				getResources().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SOURCES:
				getSources().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__CODEPAGE:
				setCodepage(CODEPAGE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEBUG:
				setDebug(DEBUG_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEFINE:
				setDefine(DEFINE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DELAYSIGN:
				setDelaysign(DELAYSIGN_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__JCPA:
				setJcpa(JCPA_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYCONTAINER:
				setKeycontainer(KEYCONTAINER_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYFILE:
				setKeyfile(KEYFILE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIBPATH:
				setLibpath(LIBPATH_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__MAIN:
				setMain(MAIN_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN1:
				setNowarn1(NOWARN1_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REBUILD:
				setRebuild(REBUILD_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SECURESCOPING:
				setSecurescoping(SECURESCOPING_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNASERROR:
				setWarnaserror(WARNASERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNINGLEVEL:
				setWarninglevel(WARNINGLEVEL_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WIN32ICON:
				setWin32icon(WIN32ICON_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__X:
				setX(X_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN:
				return !getNowarn().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIB:
				return !getLib().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REFERENCES:
				return !getReferences().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__RESOURCES:
				return !getResources().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SOURCES:
				return !getSources().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__CODEPAGE:
				return CODEPAGE_EDEFAULT == null ? codepage != null : !CODEPAGE_EDEFAULT.equals(codepage);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEBUG:
				return DEBUG_EDEFAULT == null ? debug != null : !DEBUG_EDEFAULT.equals(debug);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DEFINE:
				return DEFINE_EDEFAULT == null ? define != null : !DEFINE_EDEFAULT.equals(define);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__DELAYSIGN:
				return DELAYSIGN_EDEFAULT == null ? delaysign != null : !DELAYSIGN_EDEFAULT.equals(delaysign);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__JCPA:
				return JCPA_EDEFAULT == null ? jcpa != null : !JCPA_EDEFAULT.equals(jcpa);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYCONTAINER:
				return KEYCONTAINER_EDEFAULT == null ? keycontainer != null : !KEYCONTAINER_EDEFAULT.equals(keycontainer);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__KEYFILE:
				return KEYFILE_EDEFAULT == null ? keyfile != null : !KEYFILE_EDEFAULT.equals(keyfile);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__LIBPATH:
				return LIBPATH_EDEFAULT == null ? libpath != null : !LIBPATH_EDEFAULT.equals(libpath);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__MAIN:
				return MAIN_EDEFAULT == null ? main != null : !MAIN_EDEFAULT.equals(main);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__NOWARN1:
				return NOWARN1_EDEFAULT == null ? nowarn1 != null : !NOWARN1_EDEFAULT.equals(nowarn1);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__REBUILD:
				return REBUILD_EDEFAULT == null ? rebuild != null : !REBUILD_EDEFAULT.equals(rebuild);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__SECURESCOPING:
				return SECURESCOPING_EDEFAULT == null ? securescoping != null : !SECURESCOPING_EDEFAULT.equals(securescoping);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNASERROR:
				return WARNASERROR_EDEFAULT == null ? warnaserror != null : !WARNASERROR_EDEFAULT.equals(warnaserror);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WARNINGLEVEL:
				return WARNINGLEVEL_EDEFAULT == null ? warninglevel != null : !WARNINGLEVEL_EDEFAULT.equals(warninglevel);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__WIN32ICON:
				return WIN32ICON_EDEFAULT == null ? win32icon != null : !WIN32ICON_EDEFAULT.equals(win32icon);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__X:
				return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK__ANY_ATTRIBUTE:
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
		result.append(", codepage: ");
		result.append(codepage);
		result.append(", debug: ");
		result.append(debug);
		result.append(", define: ");
		result.append(define);
		result.append(", delaysign: ");
		result.append(delaysign);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", jcpa: ");
		result.append(jcpa);
		result.append(", keycontainer: ");
		result.append(keycontainer);
		result.append(", keyfile: ");
		result.append(keyfile);
		result.append(", libpath: ");
		result.append(libpath);
		result.append(", main: ");
		result.append(main);
		result.append(", nowarn1: ");
		result.append(nowarn1);
		result.append(", output: ");
		result.append(output);
		result.append(", rebuild: ");
		result.append(rebuild);
		result.append(", securescoping: ");
		result.append(securescoping);
		result.append(", target: ");
		result.append(target);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", warnaserror: ");
		result.append(warnaserror);
		result.append(", warninglevel: ");
		result.append(warninglevel);
		result.append(", win32icon: ");
		result.append(win32icon);
		result.append(", x: ");
		result.append(x);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntDotNetTasksVjcTaskImpl
