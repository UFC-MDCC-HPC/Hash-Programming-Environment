/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksGUnzip;
import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksTarTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksUnZipTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTaskContainer;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAttribTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAvailableTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCallTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCopyTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDeleteTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDescriptionTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksEchoTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksExecTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksFailTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksGetTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfNotTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIncludeTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadFileTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadTasksTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoopTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMailTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMkDirTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMoveTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntSchemaTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksPropertyTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksRegexTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSetEnvTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSleepTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSysInfoTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTStampTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTouchTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksUpToDateTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPeekTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPokeTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyInfoTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyLinkerTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksCscTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksDelaySignTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksJscTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksNDocTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksRegsvcsTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksResGenTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksScriptTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVbcTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVjcTask;
import net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksIldasmTask;
import net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksServiceControllerTask;
import net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TasksNUnitTask;
import net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TasksNUnit2Task;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCheckoutTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsPass;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksExportTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksRTagTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksTagTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksUpdateTask;
import net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksClTask;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLinkTask;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask;
import net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksRcTask;
import net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksAxImpTask;
import net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksReadRegistryTask;
import net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksRegAsmTask;
import net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbExpTask;
import net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreElementTest1Task;
import net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreTestTask;
import net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreUtilXmlLoggerTestTestTask;

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
 * An implementation of the model object '<em><b>NAnt Core Task Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getAsminfo <em>Asminfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getAl <em>Al</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCsc <em>Csc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getDelaySign <em>Delay Sign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getIlasm <em>Ilasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getJsc <em>Jsc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getLicense <em>License</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getNdoc <em>Ndoc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getRegsvcs <em>Regsvcs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getResgen <em>Resgen</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getScript <em>Script</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getVbc <em>Vbc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getVjc <em>Vjc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getGunzip <em>Gunzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getTar <em>Tar</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getUnzip <em>Unzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getZip <em>Zip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getNunit <em>Nunit</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getNunit2 <em>Nunit2</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvsChangelog <em>Cvs Changelog</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvsCheckout <em>Cvs Checkout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvsPass <em>Cvs Pass</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvs <em>Cvs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvsExport <em>Cvs Export</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvsRtag <em>Cvs Rtag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvsTag <em>Cvs Tag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCvsUpdate <em>Cvs Update</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getAximp <em>Aximp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getReadregistry <em>Readregistry</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getRegasm <em>Regasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getTlbexp <em>Tlbexp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getTlbimp <em>Tlbimp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCl <em>Cl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getLib <em>Lib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getLink <em>Link</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getMc <em>Mc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getMidl <em>Midl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getRc <em>Rc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getSolution <em>Solution</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getTesttask <em>Testtask</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getElementTest1 <em>Element Test1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getTest <em>Test</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getAttrib <em>Attrib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getAvailable <em>Available</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCall <em>Call</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getCopy <em>Copy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getDelete <em>Delete</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getEcho <em>Echo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getExec <em>Exec</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getFail <em>Fail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getGet <em>Get</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getIfnot <em>Ifnot</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getLoadfile <em>Loadfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getLoadtasks <em>Loadtasks</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getForeach <em>Foreach</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getMail <em>Mail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getMkdir <em>Mkdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getMove <em>Move</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getNantschema <em>Nantschema</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getNant <em>Nant</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getSetenv <em>Setenv</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getSleep <em>Sleep</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getSysinfo <em>Sysinfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getTstamp <em>Tstamp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getTouch <em>Touch</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getUptodate <em>Uptodate</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getXmlpeek <em>Xmlpeek</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getXmlpoke <em>Xmlpoke</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getIldasm <em>Ildasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getServicecontroller <em>Servicecontroller</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getIf1 <em>If1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTaskContainerImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTaskContainerImpl extends EObjectImpl implements NAntCoreTaskContainer {
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
	 * The default value of the '{@link #getIf1() <em>If1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf1()
	 * @generated
	 * @ordered
	 */
	protected static final Object IF1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIf1() <em>If1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf1()
	 * @generated
	 * @ordered
	 */
	protected Object if1 = IF1_EDEFAULT;

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
	protected NAntCoreTaskContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTaskContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASK_CONTAINER__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksAssemblyInfoTask> getAsminfo() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Asminfo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksAssemblyLinkerTask> getAl() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Al());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksCscTask> getCsc() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Csc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksDelaySignTask> getDelaySign() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_DelaySign());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksIlasmTask> getIlasm() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Ilasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksJscTask> getJsc() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Jsc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksLicenseTask> getLicense() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_License());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksNDocTask> getNdoc() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Ndoc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksRegsvcsTask> getRegsvcs() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Regsvcs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksResGenTask> getResgen() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Resgen());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksScriptTask> getScript() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Script());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksVbcTask> getVbc() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Vbc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksVjcTask> getVjc() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Vjc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksGUnzip> getGunzip() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Gunzip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksTarTask> getTar() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Tar());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksUnZipTask> getUnzip() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Unzip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksZipTask> getZip() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Zip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit1TasksNUnitTask> getNunit() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Nunit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit2TasksNUnit2Task> getNunit2() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Nunit2());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksChangeLogTask> getCvsChangelog() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_CvsChangelog());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCheckoutTask> getCvsCheckout() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_CvsCheckout());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCvsPass> getCvsPass() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_CvsPass());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCvsTask> getCvs() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Cvs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksExportTask> getCvsExport() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_CvsExport());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksRTagTask> getCvsRtag() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_CvsRtag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksTagTask> getCvsTag() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_CvsTag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksUpdateTask> getCvsUpdate() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_CvsUpdate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksAxImpTask> getAximp() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Aximp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksReadRegistryTask> getReadregistry() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Readregistry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksRegAsmTask> getRegasm() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Regasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksTlbExpTask> getTlbexp() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Tlbexp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksTlbImpTask> getTlbimp() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Tlbimp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksClTask> getCl() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Cl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksLibTask> getLib() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Lib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksLinkTask> getLink() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Link());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksMcTask> getMc() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Mc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksMidlTask> getMidl() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Midl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksRcTask> getRc() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Rc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVSNetTasksSolutionTask> getSolution() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Solution());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreUtilXmlLoggerTestTestTask> getTesttask() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Testtask());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreElementTest1Task> getElementTest1() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_ElementTest1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreTestTask> getTest() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Test());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksAttribTask> getAttrib() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Attrib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksAvailableTask> getAvailable() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Available());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksCallTask> getCall() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Call());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksCopyTask> getCopy() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Copy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksDeleteTask> getDelete() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Delete());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksDescriptionTask> getDescription() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksEchoTask> getEcho() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Echo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksExecTask> getExec() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Exec());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksFailTask> getFail() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Fail());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksGetTask> getGet() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Get());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIfTask> getIf() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_If());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIfNotTask> getIfnot() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Ifnot());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIncludeTask> getInclude() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Include());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoadFileTask> getLoadfile() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Loadfile());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoadTasksTask> getLoadtasks() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Loadtasks());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoopTask> getForeach() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Foreach());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMailTask> getMail() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Mail());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMkDirTask> getMkdir() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Mkdir());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMoveTask> getMove() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Move());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksNAntSchemaTask> getNantschema() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Nantschema());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksNAntTask> getNant() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Nant());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksPropertyTask> getProperty() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Property());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksRegexTask> getRegex() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Regex());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSetEnvTask> getSetenv() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Setenv());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSleepTask> getSleep() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Sleep());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksStyleTask> getStyle() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Style());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSysInfoTask> getSysinfo() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Sysinfo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksTStampTask> getTstamp() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Tstamp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksTouchTask> getTouch() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Touch());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksUpToDateTask> getUptodate() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Uptodate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksXmlPeekTask> getXmlpeek() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Xmlpeek());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksXmlPokeTask> getXmlpoke() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Xmlpoke());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntMSNetTasksIldasmTask> getIldasm() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Ildasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntMSNetTasksServiceControllerTask> getServicecontroller() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Servicecontroller());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(NantPackage.eINSTANCE.getNAntCoreTaskContainer_Any());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASK_CONTAINER__FAILONERROR, oldFailonerror, failonerror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIf1() {
		return if1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIf1(Object newIf1) {
		Object oldIf1 = if1;
		if1 = newIf1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASK_CONTAINER__IF1, oldIf1, if1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASK_CONTAINER__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASK_CONTAINER__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASK_CONTAINER__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_CORE_TASK_CONTAINER__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ASMINFO:
				return ((InternalEList<?>)getAsminfo()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__AL:
				return ((InternalEList<?>)getAl()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CSC:
				return ((InternalEList<?>)getCsc()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELAY_SIGN:
				return ((InternalEList<?>)getDelaySign()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILASM:
				return ((InternalEList<?>)getIlasm()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__JSC:
				return ((InternalEList<?>)getJsc()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__LICENSE:
				return ((InternalEList<?>)getLicense()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__NDOC:
				return ((InternalEList<?>)getNdoc()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGSVCS:
				return ((InternalEList<?>)getRegsvcs()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__RESGEN:
				return ((InternalEList<?>)getResgen()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__SCRIPT:
				return ((InternalEList<?>)getScript()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__VBC:
				return ((InternalEList<?>)getVbc()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__VJC:
				return ((InternalEList<?>)getVjc()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__GUNZIP:
				return ((InternalEList<?>)getGunzip()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__TAR:
				return ((InternalEList<?>)getTar()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNZIP:
				return ((InternalEList<?>)getUnzip()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ZIP:
				return ((InternalEList<?>)getZip()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT:
				return ((InternalEList<?>)getNunit()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT2:
				return ((InternalEList<?>)getNunit2()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHANGELOG:
				return ((InternalEList<?>)getCvsChangelog()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHECKOUT:
				return ((InternalEList<?>)getCvsCheckout()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_PASS:
				return ((InternalEList<?>)getCvsPass()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS:
				return ((InternalEList<?>)getCvs()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_EXPORT:
				return ((InternalEList<?>)getCvsExport()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_RTAG:
				return ((InternalEList<?>)getCvsRtag()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_TAG:
				return ((InternalEList<?>)getCvsTag()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_UPDATE:
				return ((InternalEList<?>)getCvsUpdate()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__AXIMP:
				return ((InternalEList<?>)getAximp()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__READREGISTRY:
				return ((InternalEList<?>)getReadregistry()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGASM:
				return ((InternalEList<?>)getRegasm()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBEXP:
				return ((InternalEList<?>)getTlbexp()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBIMP:
				return ((InternalEList<?>)getTlbimp()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CL:
				return ((InternalEList<?>)getCl()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__LIB:
				return ((InternalEList<?>)getLib()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__MC:
				return ((InternalEList<?>)getMc()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__MIDL:
				return ((InternalEList<?>)getMidl()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__RC:
				return ((InternalEList<?>)getRc()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__SOLUTION:
				return ((InternalEList<?>)getSolution()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__TESTTASK:
				return ((InternalEList<?>)getTesttask()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ELEMENT_TEST1:
				return ((InternalEList<?>)getElementTest1()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__TEST:
				return ((InternalEList<?>)getTest()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ATTRIB:
				return ((InternalEList<?>)getAttrib()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__AVAILABLE:
				return ((InternalEList<?>)getAvailable()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__CALL:
				return ((InternalEList<?>)getCall()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__COPY:
				return ((InternalEList<?>)getCopy()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELETE:
				return ((InternalEList<?>)getDelete()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ECHO:
				return ((InternalEList<?>)getEcho()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__EXEC:
				return ((InternalEList<?>)getExec()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAIL:
				return ((InternalEList<?>)getFail()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__GET:
				return ((InternalEList<?>)getGet()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF:
				return ((InternalEList<?>)getIf()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__IFNOT:
				return ((InternalEList<?>)getIfnot()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__INCLUDE:
				return ((InternalEList<?>)getInclude()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADFILE:
				return ((InternalEList<?>)getLoadfile()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADTASKS:
				return ((InternalEList<?>)getLoadtasks()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__FOREACH:
				return ((InternalEList<?>)getForeach()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__MAIL:
				return ((InternalEList<?>)getMail()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__MKDIR:
				return ((InternalEList<?>)getMkdir()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__MOVE:
				return ((InternalEList<?>)getMove()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANTSCHEMA:
				return ((InternalEList<?>)getNantschema()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANT:
				return ((InternalEList<?>)getNant()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGEX:
				return ((InternalEList<?>)getRegex()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__SETENV:
				return ((InternalEList<?>)getSetenv()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__SLEEP:
				return ((InternalEList<?>)getSleep()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__STYLE:
				return ((InternalEList<?>)getStyle()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__SYSINFO:
				return ((InternalEList<?>)getSysinfo()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__TSTAMP:
				return ((InternalEList<?>)getTstamp()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__TOUCH:
				return ((InternalEList<?>)getTouch()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__UPTODATE:
				return ((InternalEList<?>)getUptodate()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPEEK:
				return ((InternalEList<?>)getXmlpeek()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPOKE:
				return ((InternalEList<?>)getXmlpoke()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILDASM:
				return ((InternalEList<?>)getIldasm()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__SERVICECONTROLLER:
				return ((InternalEList<?>)getServicecontroller()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASK_CONTAINER__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ASMINFO:
				return getAsminfo();
			case NantPackage.NANT_CORE_TASK_CONTAINER__AL:
				return getAl();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CSC:
				return getCsc();
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELAY_SIGN:
				return getDelaySign();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILASM:
				return getIlasm();
			case NantPackage.NANT_CORE_TASK_CONTAINER__JSC:
				return getJsc();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LICENSE:
				return getLicense();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NDOC:
				return getNdoc();
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGSVCS:
				return getRegsvcs();
			case NantPackage.NANT_CORE_TASK_CONTAINER__RESGEN:
				return getResgen();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SCRIPT:
				return getScript();
			case NantPackage.NANT_CORE_TASK_CONTAINER__VBC:
				return getVbc();
			case NantPackage.NANT_CORE_TASK_CONTAINER__VJC:
				return getVjc();
			case NantPackage.NANT_CORE_TASK_CONTAINER__GUNZIP:
				return getGunzip();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TAR:
				return getTar();
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNZIP:
				return getUnzip();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ZIP:
				return getZip();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT:
				return getNunit();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT2:
				return getNunit2();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHANGELOG:
				return getCvsChangelog();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHECKOUT:
				return getCvsCheckout();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_PASS:
				return getCvsPass();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS:
				return getCvs();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_EXPORT:
				return getCvsExport();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_RTAG:
				return getCvsRtag();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_TAG:
				return getCvsTag();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_UPDATE:
				return getCvsUpdate();
			case NantPackage.NANT_CORE_TASK_CONTAINER__AXIMP:
				return getAximp();
			case NantPackage.NANT_CORE_TASK_CONTAINER__READREGISTRY:
				return getReadregistry();
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGASM:
				return getRegasm();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBEXP:
				return getTlbexp();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBIMP:
				return getTlbimp();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CL:
				return getCl();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LIB:
				return getLib();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LINK:
				return getLink();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MC:
				return getMc();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MIDL:
				return getMidl();
			case NantPackage.NANT_CORE_TASK_CONTAINER__RC:
				return getRc();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SOLUTION:
				return getSolution();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TESTTASK:
				return getTesttask();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ELEMENT_TEST1:
				return getElementTest1();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TEST:
				return getTest();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ATTRIB:
				return getAttrib();
			case NantPackage.NANT_CORE_TASK_CONTAINER__AVAILABLE:
				return getAvailable();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CALL:
				return getCall();
			case NantPackage.NANT_CORE_TASK_CONTAINER__COPY:
				return getCopy();
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELETE:
				return getDelete();
			case NantPackage.NANT_CORE_TASK_CONTAINER__DESCRIPTION:
				return getDescription();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ECHO:
				return getEcho();
			case NantPackage.NANT_CORE_TASK_CONTAINER__EXEC:
				return getExec();
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAIL:
				return getFail();
			case NantPackage.NANT_CORE_TASK_CONTAINER__GET:
				return getGet();
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF:
				return getIf();
			case NantPackage.NANT_CORE_TASK_CONTAINER__IFNOT:
				return getIfnot();
			case NantPackage.NANT_CORE_TASK_CONTAINER__INCLUDE:
				return getInclude();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADFILE:
				return getLoadfile();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADTASKS:
				return getLoadtasks();
			case NantPackage.NANT_CORE_TASK_CONTAINER__FOREACH:
				return getForeach();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MAIL:
				return getMail();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MKDIR:
				return getMkdir();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MOVE:
				return getMove();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANTSCHEMA:
				return getNantschema();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANT:
				return getNant();
			case NantPackage.NANT_CORE_TASK_CONTAINER__PROPERTY:
				return getProperty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGEX:
				return getRegex();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SETENV:
				return getSetenv();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SLEEP:
				return getSleep();
			case NantPackage.NANT_CORE_TASK_CONTAINER__STYLE:
				return getStyle();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SYSINFO:
				return getSysinfo();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TSTAMP:
				return getTstamp();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TOUCH:
				return getTouch();
			case NantPackage.NANT_CORE_TASK_CONTAINER__UPTODATE:
				return getUptodate();
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPEEK:
				return getXmlpeek();
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPOKE:
				return getXmlpoke();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILDASM:
				return getIldasm();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SERVICECONTROLLER:
				return getServicecontroller();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF1:
				return getIf1();
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TASK_CONTAINER__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASK_CONTAINER__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ASMINFO:
				getAsminfo().clear();
				getAsminfo().addAll((Collection<? extends NAntDotNetTasksAssemblyInfoTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__AL:
				getAl().clear();
				getAl().addAll((Collection<? extends NAntDotNetTasksAssemblyLinkerTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CSC:
				getCsc().clear();
				getCsc().addAll((Collection<? extends NAntDotNetTasksCscTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELAY_SIGN:
				getDelaySign().clear();
				getDelaySign().addAll((Collection<? extends NAntDotNetTasksDelaySignTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILASM:
				getIlasm().clear();
				getIlasm().addAll((Collection<? extends NAntDotNetTasksIlasmTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__JSC:
				getJsc().clear();
				getJsc().addAll((Collection<? extends NAntDotNetTasksJscTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LICENSE:
				getLicense().clear();
				getLicense().addAll((Collection<? extends NAntDotNetTasksLicenseTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NDOC:
				getNdoc().clear();
				getNdoc().addAll((Collection<? extends NAntDotNetTasksNDocTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGSVCS:
				getRegsvcs().clear();
				getRegsvcs().addAll((Collection<? extends NAntDotNetTasksRegsvcsTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__RESGEN:
				getResgen().clear();
				getResgen().addAll((Collection<? extends NAntDotNetTasksResGenTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SCRIPT:
				getScript().clear();
				getScript().addAll((Collection<? extends NAntDotNetTasksScriptTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__VBC:
				getVbc().clear();
				getVbc().addAll((Collection<? extends NAntDotNetTasksVbcTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__VJC:
				getVjc().clear();
				getVjc().addAll((Collection<? extends NAntDotNetTasksVjcTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__GUNZIP:
				getGunzip().clear();
				getGunzip().addAll((Collection<? extends NAntCompressionTasksGUnzip>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TAR:
				getTar().clear();
				getTar().addAll((Collection<? extends NAntCompressionTasksTarTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNZIP:
				getUnzip().clear();
				getUnzip().addAll((Collection<? extends NAntCompressionTasksUnZipTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ZIP:
				getZip().clear();
				getZip().addAll((Collection<? extends NAntCompressionTasksZipTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT:
				getNunit().clear();
				getNunit().addAll((Collection<? extends NAntNUnit1TasksNUnitTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT2:
				getNunit2().clear();
				getNunit2().addAll((Collection<? extends NAntNUnit2TasksNUnit2Task>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHANGELOG:
				getCvsChangelog().clear();
				getCvsChangelog().addAll((Collection<? extends NAntSourceControlTasksChangeLogTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHECKOUT:
				getCvsCheckout().clear();
				getCvsCheckout().addAll((Collection<? extends NAntSourceControlTasksCheckoutTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_PASS:
				getCvsPass().clear();
				getCvsPass().addAll((Collection<? extends NAntSourceControlTasksCvsPass>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS:
				getCvs().clear();
				getCvs().addAll((Collection<? extends NAntSourceControlTasksCvsTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_EXPORT:
				getCvsExport().clear();
				getCvsExport().addAll((Collection<? extends NAntSourceControlTasksExportTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_RTAG:
				getCvsRtag().clear();
				getCvsRtag().addAll((Collection<? extends NAntSourceControlTasksRTagTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_TAG:
				getCvsTag().clear();
				getCvsTag().addAll((Collection<? extends NAntSourceControlTasksTagTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_UPDATE:
				getCvsUpdate().clear();
				getCvsUpdate().addAll((Collection<? extends NAntSourceControlTasksUpdateTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__AXIMP:
				getAximp().clear();
				getAximp().addAll((Collection<? extends NAntWin32TasksAxImpTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__READREGISTRY:
				getReadregistry().clear();
				getReadregistry().addAll((Collection<? extends NAntWin32TasksReadRegistryTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGASM:
				getRegasm().clear();
				getRegasm().addAll((Collection<? extends NAntWin32TasksRegAsmTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBEXP:
				getTlbexp().clear();
				getTlbexp().addAll((Collection<? extends NAntWin32TasksTlbExpTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBIMP:
				getTlbimp().clear();
				getTlbimp().addAll((Collection<? extends NAntWin32TasksTlbImpTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CL:
				getCl().clear();
				getCl().addAll((Collection<? extends NAntVisualCppTasksClTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LIB:
				getLib().clear();
				getLib().addAll((Collection<? extends NAntVisualCppTasksLibTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends NAntVisualCppTasksLinkTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MC:
				getMc().clear();
				getMc().addAll((Collection<? extends NAntVisualCppTasksMcTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MIDL:
				getMidl().clear();
				getMidl().addAll((Collection<? extends NAntVisualCppTasksMidlTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__RC:
				getRc().clear();
				getRc().addAll((Collection<? extends NAntVisualCppTasksRcTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SOLUTION:
				getSolution().clear();
				getSolution().addAll((Collection<? extends NAntVSNetTasksSolutionTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TESTTASK:
				getTesttask().clear();
				getTesttask().addAll((Collection<? extends TestsNAntCoreUtilXmlLoggerTestTestTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ELEMENT_TEST1:
				getElementTest1().clear();
				getElementTest1().addAll((Collection<? extends TestsNAntCoreElementTest1Task>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TEST:
				getTest().clear();
				getTest().addAll((Collection<? extends TestsNAntCoreTestTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ATTRIB:
				getAttrib().clear();
				getAttrib().addAll((Collection<? extends NAntCoreTasksAttribTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__AVAILABLE:
				getAvailable().clear();
				getAvailable().addAll((Collection<? extends NAntCoreTasksAvailableTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CALL:
				getCall().clear();
				getCall().addAll((Collection<? extends NAntCoreTasksCallTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__COPY:
				getCopy().clear();
				getCopy().addAll((Collection<? extends NAntCoreTasksCopyTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELETE:
				getDelete().clear();
				getDelete().addAll((Collection<? extends NAntCoreTasksDeleteTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends NAntCoreTasksDescriptionTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ECHO:
				getEcho().clear();
				getEcho().addAll((Collection<? extends NAntCoreTasksEchoTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__EXEC:
				getExec().clear();
				getExec().addAll((Collection<? extends NAntCoreTasksExecTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAIL:
				getFail().clear();
				getFail().addAll((Collection<? extends NAntCoreTasksFailTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__GET:
				getGet().clear();
				getGet().addAll((Collection<? extends NAntCoreTasksGetTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF:
				getIf().clear();
				getIf().addAll((Collection<? extends NAntCoreTasksIfTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__IFNOT:
				getIfnot().clear();
				getIfnot().addAll((Collection<? extends NAntCoreTasksIfNotTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__INCLUDE:
				getInclude().clear();
				getInclude().addAll((Collection<? extends NAntCoreTasksIncludeTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADFILE:
				getLoadfile().clear();
				getLoadfile().addAll((Collection<? extends NAntCoreTasksLoadFileTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADTASKS:
				getLoadtasks().clear();
				getLoadtasks().addAll((Collection<? extends NAntCoreTasksLoadTasksTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__FOREACH:
				getForeach().clear();
				getForeach().addAll((Collection<? extends NAntCoreTasksLoopTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MAIL:
				getMail().clear();
				getMail().addAll((Collection<? extends NAntCoreTasksMailTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MKDIR:
				getMkdir().clear();
				getMkdir().addAll((Collection<? extends NAntCoreTasksMkDirTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MOVE:
				getMove().clear();
				getMove().addAll((Collection<? extends NAntCoreTasksMoveTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANTSCHEMA:
				getNantschema().clear();
				getNantschema().addAll((Collection<? extends NAntCoreTasksNAntSchemaTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANT:
				getNant().clear();
				getNant().addAll((Collection<? extends NAntCoreTasksNAntTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends NAntCoreTasksPropertyTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGEX:
				getRegex().clear();
				getRegex().addAll((Collection<? extends NAntCoreTasksRegexTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SETENV:
				getSetenv().clear();
				getSetenv().addAll((Collection<? extends NAntCoreTasksSetEnvTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SLEEP:
				getSleep().clear();
				getSleep().addAll((Collection<? extends NAntCoreTasksSleepTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__STYLE:
				getStyle().clear();
				getStyle().addAll((Collection<? extends NAntCoreTasksStyleTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SYSINFO:
				getSysinfo().clear();
				getSysinfo().addAll((Collection<? extends NAntCoreTasksSysInfoTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TSTAMP:
				getTstamp().clear();
				getTstamp().addAll((Collection<? extends NAntCoreTasksTStampTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TOUCH:
				getTouch().clear();
				getTouch().addAll((Collection<? extends NAntCoreTasksTouchTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__UPTODATE:
				getUptodate().clear();
				getUptodate().addAll((Collection<? extends NAntCoreTasksUpToDateTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPEEK:
				getXmlpeek().clear();
				getXmlpeek().addAll((Collection<? extends NAntCoreTasksXmlPeekTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPOKE:
				getXmlpoke().clear();
				getXmlpoke().addAll((Collection<? extends NAntCoreTasksXmlPokeTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILDASM:
				getIldasm().clear();
				getIldasm().addAll((Collection<? extends NAntMSNetTasksIldasmTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SERVICECONTROLLER:
				getServicecontroller().clear();
				getServicecontroller().addAll((Collection<? extends NAntMSNetTasksServiceControllerTask>)newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF1:
				setIf1(newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASK_CONTAINER__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ASMINFO:
				getAsminfo().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__AL:
				getAl().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CSC:
				getCsc().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELAY_SIGN:
				getDelaySign().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILASM:
				getIlasm().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__JSC:
				getJsc().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LICENSE:
				getLicense().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NDOC:
				getNdoc().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGSVCS:
				getRegsvcs().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__RESGEN:
				getResgen().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SCRIPT:
				getScript().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__VBC:
				getVbc().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__VJC:
				getVjc().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__GUNZIP:
				getGunzip().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TAR:
				getTar().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNZIP:
				getUnzip().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ZIP:
				getZip().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT:
				getNunit().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT2:
				getNunit2().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHANGELOG:
				getCvsChangelog().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHECKOUT:
				getCvsCheckout().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_PASS:
				getCvsPass().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS:
				getCvs().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_EXPORT:
				getCvsExport().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_RTAG:
				getCvsRtag().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_TAG:
				getCvsTag().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_UPDATE:
				getCvsUpdate().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__AXIMP:
				getAximp().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__READREGISTRY:
				getReadregistry().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGASM:
				getRegasm().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBEXP:
				getTlbexp().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBIMP:
				getTlbimp().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CL:
				getCl().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LIB:
				getLib().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LINK:
				getLink().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MC:
				getMc().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MIDL:
				getMidl().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__RC:
				getRc().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SOLUTION:
				getSolution().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TESTTASK:
				getTesttask().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ELEMENT_TEST1:
				getElementTest1().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TEST:
				getTest().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ATTRIB:
				getAttrib().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__AVAILABLE:
				getAvailable().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__CALL:
				getCall().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__COPY:
				getCopy().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELETE:
				getDelete().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__DESCRIPTION:
				getDescription().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ECHO:
				getEcho().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__EXEC:
				getExec().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAIL:
				getFail().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__GET:
				getGet().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF:
				getIf().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__IFNOT:
				getIfnot().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__INCLUDE:
				getInclude().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADFILE:
				getLoadfile().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADTASKS:
				getLoadtasks().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__FOREACH:
				getForeach().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MAIL:
				getMail().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MKDIR:
				getMkdir().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__MOVE:
				getMove().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANTSCHEMA:
				getNantschema().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANT:
				getNant().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__PROPERTY:
				getProperty().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGEX:
				getRegex().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SETENV:
				getSetenv().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SLEEP:
				getSleep().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__STYLE:
				getStyle().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SYSINFO:
				getSysinfo().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TSTAMP:
				getTstamp().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__TOUCH:
				getTouch().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__UPTODATE:
				getUptodate().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPEEK:
				getXmlpeek().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPOKE:
				getXmlpoke().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILDASM:
				getIldasm().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__SERVICECONTROLLER:
				getServicecontroller().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY:
				getAny().clear();
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF1:
				setIf1(IF1_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASK_CONTAINER__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ASMINFO:
				return !getAsminfo().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__AL:
				return !getAl().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CSC:
				return !getCsc().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELAY_SIGN:
				return !getDelaySign().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILASM:
				return !getIlasm().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__JSC:
				return !getJsc().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LICENSE:
				return !getLicense().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NDOC:
				return !getNdoc().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGSVCS:
				return !getRegsvcs().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__RESGEN:
				return !getResgen().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SCRIPT:
				return !getScript().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__VBC:
				return !getVbc().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__VJC:
				return !getVjc().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__GUNZIP:
				return !getGunzip().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TAR:
				return !getTar().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNZIP:
				return !getUnzip().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ZIP:
				return !getZip().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT:
				return !getNunit().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NUNIT2:
				return !getNunit2().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHANGELOG:
				return !getCvsChangelog().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_CHECKOUT:
				return !getCvsCheckout().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_PASS:
				return !getCvsPass().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS:
				return !getCvs().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_EXPORT:
				return !getCvsExport().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_RTAG:
				return !getCvsRtag().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_TAG:
				return !getCvsTag().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CVS_UPDATE:
				return !getCvsUpdate().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__AXIMP:
				return !getAximp().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__READREGISTRY:
				return !getReadregistry().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGASM:
				return !getRegasm().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBEXP:
				return !getTlbexp().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TLBIMP:
				return !getTlbimp().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CL:
				return !getCl().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LIB:
				return !getLib().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LINK:
				return !getLink().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MC:
				return !getMc().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MIDL:
				return !getMidl().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__RC:
				return !getRc().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SOLUTION:
				return !getSolution().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TESTTASK:
				return !getTesttask().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ELEMENT_TEST1:
				return !getElementTest1().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TEST:
				return !getTest().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ATTRIB:
				return !getAttrib().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__AVAILABLE:
				return !getAvailable().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__CALL:
				return !getCall().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__COPY:
				return !getCopy().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__DELETE:
				return !getDelete().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__DESCRIPTION:
				return !getDescription().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ECHO:
				return !getEcho().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__EXEC:
				return !getExec().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAIL:
				return !getFail().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__GET:
				return !getGet().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF:
				return !getIf().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__IFNOT:
				return !getIfnot().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__INCLUDE:
				return !getInclude().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADFILE:
				return !getLoadfile().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__LOADTASKS:
				return !getLoadtasks().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__FOREACH:
				return !getForeach().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MAIL:
				return !getMail().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MKDIR:
				return !getMkdir().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__MOVE:
				return !getMove().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANTSCHEMA:
				return !getNantschema().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__NANT:
				return !getNant().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__PROPERTY:
				return !getProperty().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__REGEX:
				return !getRegex().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SETENV:
				return !getSetenv().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SLEEP:
				return !getSleep().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__STYLE:
				return !getStyle().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SYSINFO:
				return !getSysinfo().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TSTAMP:
				return !getTstamp().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__TOUCH:
				return !getTouch().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__UPTODATE:
				return !getUptodate().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPEEK:
				return !getXmlpeek().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__XMLPOKE:
				return !getXmlpoke().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ILDASM:
				return !getIldasm().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__SERVICECONTROLLER:
				return !getServicecontroller().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY:
				return !getAny().isEmpty();
			case NantPackage.NANT_CORE_TASK_CONTAINER__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_CORE_TASK_CONTAINER__IF1:
				return IF1_EDEFAULT == null ? if1 != null : !IF1_EDEFAULT.equals(if1);
			case NantPackage.NANT_CORE_TASK_CONTAINER__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TASK_CONTAINER__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_CORE_TASK_CONTAINER__ANY_ATTRIBUTE:
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
		result.append(", if1: ");
		result.append(if1);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTaskContainerImpl
