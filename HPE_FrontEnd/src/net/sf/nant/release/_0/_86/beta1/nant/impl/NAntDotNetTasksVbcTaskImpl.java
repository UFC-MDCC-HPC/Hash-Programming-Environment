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
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVbcTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImportCollection;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesWarningAsError;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.NowarnType1;
import net.sf.nant.release._0._86.beta1.nant.PkgReferencesType;

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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks Vbc Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getWarnaserror <em>Warnaserror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getNowarn <em>Nowarn</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getLib <em>Lib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getReferences <em>References</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getPkgReferences <em>Pkg References</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getBaseaddress <em>Baseaddress</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getDebug <em>Debug</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getDefine <em>Define</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getDelaysign <em>Delaysign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getImports1 <em>Imports1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getKeycontainer <em>Keycontainer</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getKeyfile <em>Keyfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getMain <em>Main</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getNostdlib <em>Nostdlib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getNowarn1 <em>Nowarn1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getOptioncompare <em>Optioncompare</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getOptionexplicit <em>Optionexplicit</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getOptionoptimize <em>Optionoptimize</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getOptionstrict <em>Optionstrict</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getRebuild <em>Rebuild</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getRemoveintchecks <em>Removeintchecks</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getRootnamespace <em>Rootnamespace</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getWarnaserror1 <em>Warnaserror1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getWin32icon <em>Win32icon</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksVbcTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksVbcTaskImpl extends EObjectImpl implements NAntDotNetTasksVbcTask {
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
	 * The default value of the '{@link #getBaseaddress() <em>Baseaddress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseaddress()
	 * @generated
	 * @ordered
	 */
	protected static final Object BASEADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseaddress() <em>Baseaddress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseaddress()
	 * @generated
	 * @ordered
	 */
	protected Object baseaddress = BASEADDRESS_EDEFAULT;

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
	 * The default value of the '{@link #getDoc() <em>Doc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoc()
	 * @generated
	 * @ordered
	 */
	protected static final Object DOC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDoc() <em>Doc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoc()
	 * @generated
	 * @ordered
	 */
	protected Object doc = DOC_EDEFAULT;

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
	 * The default value of the '{@link #getImports1() <em>Imports1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports1()
	 * @generated
	 * @ordered
	 */
	protected static final Object IMPORTS1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImports1() <em>Imports1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports1()
	 * @generated
	 * @ordered
	 */
	protected Object imports1 = IMPORTS1_EDEFAULT;

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
	 * The default value of the '{@link #getNostdlib() <em>Nostdlib</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNostdlib()
	 * @generated
	 * @ordered
	 */
	protected static final Object NOSTDLIB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNostdlib() <em>Nostdlib</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNostdlib()
	 * @generated
	 * @ordered
	 */
	protected Object nostdlib = NOSTDLIB_EDEFAULT;

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
	 * The default value of the '{@link #getOptioncompare() <em>Optioncompare</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptioncompare()
	 * @generated
	 * @ordered
	 */
	protected static final Object OPTIONCOMPARE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptioncompare() <em>Optioncompare</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptioncompare()
	 * @generated
	 * @ordered
	 */
	protected Object optioncompare = OPTIONCOMPARE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptionexplicit() <em>Optionexplicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionexplicit()
	 * @generated
	 * @ordered
	 */
	protected static final Object OPTIONEXPLICIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptionexplicit() <em>Optionexplicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionexplicit()
	 * @generated
	 * @ordered
	 */
	protected Object optionexplicit = OPTIONEXPLICIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptionoptimize() <em>Optionoptimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionoptimize()
	 * @generated
	 * @ordered
	 */
	protected static final Object OPTIONOPTIMIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptionoptimize() <em>Optionoptimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionoptimize()
	 * @generated
	 * @ordered
	 */
	protected Object optionoptimize = OPTIONOPTIMIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptionstrict() <em>Optionstrict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionstrict()
	 * @generated
	 * @ordered
	 */
	protected static final Object OPTIONSTRICT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptionstrict() <em>Optionstrict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionstrict()
	 * @generated
	 * @ordered
	 */
	protected Object optionstrict = OPTIONSTRICT_EDEFAULT;

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
	 * The default value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final Object PLATFORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected Object platform = PLATFORM_EDEFAULT;

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
	 * The default value of the '{@link #getRemoveintchecks() <em>Removeintchecks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoveintchecks()
	 * @generated
	 * @ordered
	 */
	protected static final Object REMOVEINTCHECKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRemoveintchecks() <em>Removeintchecks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoveintchecks()
	 * @generated
	 * @ordered
	 */
	protected Object removeintchecks = REMOVEINTCHECKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootnamespace() <em>Rootnamespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootnamespace()
	 * @generated
	 * @ordered
	 */
	protected static final Object ROOTNAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootnamespace() <em>Rootnamespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootnamespace()
	 * @generated
	 * @ordered
	 */
	protected Object rootnamespace = ROOTNAMESPACE_EDEFAULT;

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
	 * The default value of the '{@link #getWarnaserror1() <em>Warnaserror1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarnaserror1()
	 * @generated
	 * @ordered
	 */
	protected static final Object WARNASERROR1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWarnaserror1() <em>Warnaserror1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarnaserror1()
	 * @generated
	 * @ordered
	 */
	protected Object warnaserror1 = WARNASERROR1_EDEFAULT;

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
	protected NAntDotNetTasksVbcTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesNamespaceImportCollection> getImports() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Imports());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesWarningAsError> getWarnaserror() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Warnaserror());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NowarnType1> getNowarn() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Nowarn());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getLib() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Lib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getReferences() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_References());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PkgReferencesType> getPkgReferences() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_PkgReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesResourceFileSet> getResources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Resources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getModules() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Modules());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getSources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Sources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksVbcTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBaseaddress() {
		return baseaddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseaddress(Object newBaseaddress) {
		Object oldBaseaddress = baseaddress;
		baseaddress = newBaseaddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__BASEADDRESS, oldBaseaddress, baseaddress));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEBUG, oldDebug, debug));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEFINE, oldDefine, define));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DELAYSIGN, oldDelaysign, delaysign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDoc() {
		return doc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoc(Object newDoc) {
		Object oldDoc = doc;
		doc = newDoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DOC, oldDoc, doc));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImports1() {
		return imports1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImports1(Object newImports1) {
		Object oldImports1 = imports1;
		imports1 = newImports1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS1, oldImports1, imports1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYCONTAINER, oldKeycontainer, keycontainer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYFILE, oldKeyfile, keyfile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MAIN, oldMain, main));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNostdlib() {
		return nostdlib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNostdlib(Object newNostdlib) {
		Object oldNostdlib = nostdlib;
		nostdlib = newNostdlib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOSTDLIB, oldNostdlib, nostdlib));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN1, oldNowarn1, nowarn1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOptioncompare() {
		return optioncompare;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptioncompare(Object newOptioncompare) {
		Object oldOptioncompare = optioncompare;
		optioncompare = newOptioncompare;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONCOMPARE, oldOptioncompare, optioncompare));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOptionexplicit() {
		return optionexplicit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionexplicit(Object newOptionexplicit) {
		Object oldOptionexplicit = optionexplicit;
		optionexplicit = newOptionexplicit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONEXPLICIT, oldOptionexplicit, optionexplicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOptionoptimize() {
		return optionoptimize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionoptimize(Object newOptionoptimize) {
		Object oldOptionoptimize = optionoptimize;
		optionoptimize = newOptionoptimize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONOPTIMIZE, oldOptionoptimize, optionoptimize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOptionstrict() {
		return optionstrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionstrict(Object newOptionstrict) {
		Object oldOptionstrict = optionstrict;
		optionstrict = newOptionstrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONSTRICT, oldOptionstrict, optionstrict));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPlatform() {
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatform(Object newPlatform) {
		Object oldPlatform = platform;
		platform = newPlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PLATFORM, oldPlatform, platform));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REBUILD, oldRebuild, rebuild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRemoveintchecks() {
		return removeintchecks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveintchecks(Object newRemoveintchecks) {
		Object oldRemoveintchecks = removeintchecks;
		removeintchecks = newRemoveintchecks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REMOVEINTCHECKS, oldRemoveintchecks, removeintchecks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRootnamespace() {
		return rootnamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootnamespace(Object newRootnamespace) {
		Object oldRootnamespace = rootnamespace;
		rootnamespace = newRootnamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ROOTNAMESPACE, oldRootnamespace, rootnamespace));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWarnaserror1() {
		return warnaserror1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarnaserror1(Object newWarnaserror1) {
		Object oldWarnaserror1 = warnaserror1;
		warnaserror1 = newWarnaserror1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR1, oldWarnaserror1, warnaserror1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WIN32ICON, oldWin32icon, win32icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR:
				return ((InternalEList<?>)getWarnaserror()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN:
				return ((InternalEList<?>)getNowarn()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__LIB:
				return ((InternalEList<?>)getLib()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PKG_REFERENCES:
				return ((InternalEList<?>)getPkgReferences()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS:
				return getImports();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR:
				return getWarnaserror();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN:
				return getNowarn();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__LIB:
				return getLib();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REFERENCES:
				return getReferences();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PKG_REFERENCES:
				return getPkgReferences();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__RESOURCES:
				return getResources();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MODULES:
				return getModules();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__SOURCES:
				return getSources();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ARG:
				return getArg();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__BASEADDRESS:
				return getBaseaddress();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEBUG:
				return getDebug();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEFINE:
				return getDefine();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DELAYSIGN:
				return getDelaysign();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DOC:
				return getDoc();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS1:
				return getImports1();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYCONTAINER:
				return getKeycontainer();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYFILE:
				return getKeyfile();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MAIN:
				return getMain();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOSTDLIB:
				return getNostdlib();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN1:
				return getNowarn1();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONCOMPARE:
				return getOptioncompare();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONEXPLICIT:
				return getOptionexplicit();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONOPTIMIZE:
				return getOptionoptimize();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONSTRICT:
				return getOptionstrict();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PLATFORM:
				return getPlatform();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REBUILD:
				return getRebuild();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REMOVEINTCHECKS:
				return getRemoveintchecks();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ROOTNAMESPACE:
				return getRootnamespace();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TARGET:
				return getTarget();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR1:
				return getWarnaserror1();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WIN32ICON:
				return getWin32icon();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends NAntDotNetTypesNamespaceImportCollection>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR:
				getWarnaserror().clear();
				getWarnaserror().addAll((Collection<? extends NAntDotNetTypesWarningAsError>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN:
				getNowarn().clear();
				getNowarn().addAll((Collection<? extends NowarnType1>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__LIB:
				getLib().clear();
				getLib().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PKG_REFERENCES:
				getPkgReferences().clear();
				getPkgReferences().addAll((Collection<? extends PkgReferencesType>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends NAntDotNetTypesResourceFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__BASEADDRESS:
				setBaseaddress(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEBUG:
				setDebug(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEFINE:
				setDefine(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DELAYSIGN:
				setDelaysign(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DOC:
				setDoc(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS1:
				setImports1(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYCONTAINER:
				setKeycontainer(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYFILE:
				setKeyfile(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MAIN:
				setMain(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOSTDLIB:
				setNostdlib(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN1:
				setNowarn1(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONCOMPARE:
				setOptioncompare(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONEXPLICIT:
				setOptionexplicit(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONOPTIMIZE:
				setOptionoptimize(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONSTRICT:
				setOptionstrict(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PLATFORM:
				setPlatform(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REBUILD:
				setRebuild(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REMOVEINTCHECKS:
				setRemoveintchecks(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ROOTNAMESPACE:
				setRootnamespace(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TARGET:
				setTarget(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR1:
				setWarnaserror1(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WIN32ICON:
				setWin32icon(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS:
				getImports().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR:
				getWarnaserror().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN:
				getNowarn().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__LIB:
				getLib().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REFERENCES:
				getReferences().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PKG_REFERENCES:
				getPkgReferences().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__RESOURCES:
				getResources().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MODULES:
				getModules().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__SOURCES:
				getSources().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__BASEADDRESS:
				setBaseaddress(BASEADDRESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEBUG:
				setDebug(DEBUG_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEFINE:
				setDefine(DEFINE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DELAYSIGN:
				setDelaysign(DELAYSIGN_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DOC:
				setDoc(DOC_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS1:
				setImports1(IMPORTS1_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYCONTAINER:
				setKeycontainer(KEYCONTAINER_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYFILE:
				setKeyfile(KEYFILE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MAIN:
				setMain(MAIN_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOSTDLIB:
				setNostdlib(NOSTDLIB_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN1:
				setNowarn1(NOWARN1_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONCOMPARE:
				setOptioncompare(OPTIONCOMPARE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONEXPLICIT:
				setOptionexplicit(OPTIONEXPLICIT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONOPTIMIZE:
				setOptionoptimize(OPTIONOPTIMIZE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONSTRICT:
				setOptionstrict(OPTIONSTRICT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REBUILD:
				setRebuild(REBUILD_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REMOVEINTCHECKS:
				setRemoveintchecks(REMOVEINTCHECKS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ROOTNAMESPACE:
				setRootnamespace(ROOTNAMESPACE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR1:
				setWarnaserror1(WARNASERROR1_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WIN32ICON:
				setWin32icon(WIN32ICON_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS:
				return !getImports().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR:
				return !getWarnaserror().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN:
				return !getNowarn().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__LIB:
				return !getLib().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REFERENCES:
				return !getReferences().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PKG_REFERENCES:
				return !getPkgReferences().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__RESOURCES:
				return !getResources().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MODULES:
				return !getModules().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__SOURCES:
				return !getSources().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__BASEADDRESS:
				return BASEADDRESS_EDEFAULT == null ? baseaddress != null : !BASEADDRESS_EDEFAULT.equals(baseaddress);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEBUG:
				return DEBUG_EDEFAULT == null ? debug != null : !DEBUG_EDEFAULT.equals(debug);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DEFINE:
				return DEFINE_EDEFAULT == null ? define != null : !DEFINE_EDEFAULT.equals(define);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DELAYSIGN:
				return DELAYSIGN_EDEFAULT == null ? delaysign != null : !DELAYSIGN_EDEFAULT.equals(delaysign);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__DOC:
				return DOC_EDEFAULT == null ? doc != null : !DOC_EDEFAULT.equals(doc);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__IMPORTS1:
				return IMPORTS1_EDEFAULT == null ? imports1 != null : !IMPORTS1_EDEFAULT.equals(imports1);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYCONTAINER:
				return KEYCONTAINER_EDEFAULT == null ? keycontainer != null : !KEYCONTAINER_EDEFAULT.equals(keycontainer);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__KEYFILE:
				return KEYFILE_EDEFAULT == null ? keyfile != null : !KEYFILE_EDEFAULT.equals(keyfile);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__MAIN:
				return MAIN_EDEFAULT == null ? main != null : !MAIN_EDEFAULT.equals(main);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOSTDLIB:
				return NOSTDLIB_EDEFAULT == null ? nostdlib != null : !NOSTDLIB_EDEFAULT.equals(nostdlib);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__NOWARN1:
				return NOWARN1_EDEFAULT == null ? nowarn1 != null : !NOWARN1_EDEFAULT.equals(nowarn1);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONCOMPARE:
				return OPTIONCOMPARE_EDEFAULT == null ? optioncompare != null : !OPTIONCOMPARE_EDEFAULT.equals(optioncompare);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONEXPLICIT:
				return OPTIONEXPLICIT_EDEFAULT == null ? optionexplicit != null : !OPTIONEXPLICIT_EDEFAULT.equals(optionexplicit);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONOPTIMIZE:
				return OPTIONOPTIMIZE_EDEFAULT == null ? optionoptimize != null : !OPTIONOPTIMIZE_EDEFAULT.equals(optionoptimize);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OPTIONSTRICT:
				return OPTIONSTRICT_EDEFAULT == null ? optionstrict != null : !OPTIONSTRICT_EDEFAULT.equals(optionstrict);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REBUILD:
				return REBUILD_EDEFAULT == null ? rebuild != null : !REBUILD_EDEFAULT.equals(rebuild);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__REMOVEINTCHECKS:
				return REMOVEINTCHECKS_EDEFAULT == null ? removeintchecks != null : !REMOVEINTCHECKS_EDEFAULT.equals(removeintchecks);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ROOTNAMESPACE:
				return ROOTNAMESPACE_EDEFAULT == null ? rootnamespace != null : !ROOTNAMESPACE_EDEFAULT.equals(rootnamespace);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WARNASERROR1:
				return WARNASERROR1_EDEFAULT == null ? warnaserror1 != null : !WARNASERROR1_EDEFAULT.equals(warnaserror1);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__WIN32ICON:
				return WIN32ICON_EDEFAULT == null ? win32icon != null : !WIN32ICON_EDEFAULT.equals(win32icon);
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK__ANY_ATTRIBUTE:
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
		result.append(", baseaddress: ");
		result.append(baseaddress);
		result.append(", debug: ");
		result.append(debug);
		result.append(", define: ");
		result.append(define);
		result.append(", delaysign: ");
		result.append(delaysign);
		result.append(", doc: ");
		result.append(doc);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", imports1: ");
		result.append(imports1);
		result.append(", keycontainer: ");
		result.append(keycontainer);
		result.append(", keyfile: ");
		result.append(keyfile);
		result.append(", main: ");
		result.append(main);
		result.append(", nostdlib: ");
		result.append(nostdlib);
		result.append(", nowarn1: ");
		result.append(nowarn1);
		result.append(", optioncompare: ");
		result.append(optioncompare);
		result.append(", optionexplicit: ");
		result.append(optionexplicit);
		result.append(", optionoptimize: ");
		result.append(optionoptimize);
		result.append(", optionstrict: ");
		result.append(optionstrict);
		result.append(", output: ");
		result.append(output);
		result.append(", platform: ");
		result.append(platform);
		result.append(", rebuild: ");
		result.append(rebuild);
		result.append(", removeintchecks: ");
		result.append(removeintchecks);
		result.append(", rootnamespace: ");
		result.append(rootnamespace);
		result.append(", target: ");
		result.append(target);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", warnaserror1: ");
		result.append(warnaserror1);
		result.append(", win32icon: ");
		result.append(win32icon);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntDotNetTasksVbcTaskImpl
