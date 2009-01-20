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
import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesTarFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesZipFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreFiltersFilterChain;
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
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesCredential;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesDirSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPatternSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesProxy;
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
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImportCollection;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesWarningAsError;
import net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksIldasmTask;
import net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksServiceControllerTask;
import net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TasksNUnitTask;
import net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TasksNUnit2Task;
import net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategories;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCheckoutTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsPass;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksExportTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksRTagTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksTagTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksUpdateTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTypesCvsFileSet;
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
import net.sf.nant.release._0._86.beta1.nant.ProjectType;
import net.sf.nant.release._0._86.beta1.nant.Target;
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
 * An implementation of the model object '<em><b>Project Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getAsminfo <em>Asminfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getAl <em>Al</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCsc <em>Csc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getDelaySign <em>Delay Sign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getIlasm <em>Ilasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getJsc <em>Jsc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getLicense <em>License</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getNdoc <em>Ndoc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getRegsvcs <em>Regsvcs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getResgen <em>Resgen</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getScript <em>Script</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getVbc <em>Vbc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getVjc <em>Vjc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getGunzip <em>Gunzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTar <em>Tar</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getUnzip <em>Unzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getZip <em>Zip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getNunit <em>Nunit</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getNunit2 <em>Nunit2</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsChangelog <em>Cvs Changelog</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsCheckout <em>Cvs Checkout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsPass <em>Cvs Pass</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvs <em>Cvs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsExport <em>Cvs Export</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsRtag <em>Cvs Rtag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsTag <em>Cvs Tag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsUpdate <em>Cvs Update</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getAximp <em>Aximp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getReadregistry <em>Readregistry</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getRegasm <em>Regasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTlbexp <em>Tlbexp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTlbimp <em>Tlbimp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCl <em>Cl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getLib <em>Lib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getLink <em>Link</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getMc <em>Mc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getMidl <em>Midl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getRc <em>Rc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getSolution <em>Solution</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTesttask <em>Testtask</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getElementTest1 <em>Element Test1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTest <em>Test</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getAttrib <em>Attrib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getAvailable <em>Available</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCall <em>Call</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCopy <em>Copy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getDelete <em>Delete</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getEcho <em>Echo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getExec <em>Exec</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getFail <em>Fail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getGet <em>Get</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getIfnot <em>Ifnot</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getLoadfile <em>Loadfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getLoadtasks <em>Loadtasks</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getForeach <em>Foreach</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getMail <em>Mail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getMkdir <em>Mkdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getMove <em>Move</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getNantschema <em>Nantschema</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getNant <em>Nant</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getSetenv <em>Setenv</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getSleep <em>Sleep</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getSysinfo <em>Sysinfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTstamp <em>Tstamp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTouch <em>Touch</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getUptodate <em>Uptodate</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getXmlpeek <em>Xmlpeek</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getXmlpoke <em>Xmlpoke</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getIldasm <em>Ildasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getServicecontroller <em>Servicecontroller</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getAssemblyfileset <em>Assemblyfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getModuleset <em>Moduleset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getNamespaceimports <em>Namespaceimports</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getResourcefileset <em>Resourcefileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getWarnaserror <em>Warnaserror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTarfileset <em>Tarfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getZipfileset <em>Zipfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCvsfileset <em>Cvsfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getFilterchain <em>Filterchain</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getCredential <em>Credential</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getDirset <em>Dirset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getPath <em>Path</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getPatternset <em>Patternset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getProxy <em>Proxy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getBasedir <em>Basedir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.ProjectTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectTypeImpl extends EObjectImpl implements ProjectType {
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
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected Object default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Object name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getProjectType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.PROJECT_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksAssemblyInfoTask> getAsminfo() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Asminfo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksAssemblyLinkerTask> getAl() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Al());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksCscTask> getCsc() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Csc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksDelaySignTask> getDelaySign() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_DelaySign());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksIlasmTask> getIlasm() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Ilasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksJscTask> getJsc() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Jsc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksLicenseTask> getLicense() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_License());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksNDocTask> getNdoc() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Ndoc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksRegsvcsTask> getRegsvcs() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Regsvcs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksResGenTask> getResgen() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Resgen());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksScriptTask> getScript() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Script());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksVbcTask> getVbc() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Vbc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksVjcTask> getVjc() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Vjc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksGUnzip> getGunzip() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Gunzip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksTarTask> getTar() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Tar());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksUnZipTask> getUnzip() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Unzip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksZipTask> getZip() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Zip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit1TasksNUnitTask> getNunit() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Nunit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit2TasksNUnit2Task> getNunit2() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Nunit2());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksChangeLogTask> getCvsChangelog() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_CvsChangelog());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCheckoutTask> getCvsCheckout() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_CvsCheckout());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCvsPass> getCvsPass() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_CvsPass());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCvsTask> getCvs() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Cvs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksExportTask> getCvsExport() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_CvsExport());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksRTagTask> getCvsRtag() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_CvsRtag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksTagTask> getCvsTag() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_CvsTag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksUpdateTask> getCvsUpdate() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_CvsUpdate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksAxImpTask> getAximp() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Aximp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksReadRegistryTask> getReadregistry() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Readregistry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksRegAsmTask> getRegasm() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Regasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksTlbExpTask> getTlbexp() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Tlbexp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksTlbImpTask> getTlbimp() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Tlbimp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksClTask> getCl() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Cl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksLibTask> getLib() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Lib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksLinkTask> getLink() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Link());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksMcTask> getMc() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Mc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksMidlTask> getMidl() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Midl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksRcTask> getRc() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Rc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVSNetTasksSolutionTask> getSolution() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Solution());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreUtilXmlLoggerTestTestTask> getTesttask() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Testtask());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreElementTest1Task> getElementTest1() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_ElementTest1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreTestTask> getTest() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Test());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksAttribTask> getAttrib() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Attrib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksAvailableTask> getAvailable() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Available());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksCallTask> getCall() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Call());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksCopyTask> getCopy() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Copy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksDeleteTask> getDelete() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Delete());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksDescriptionTask> getDescription() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksEchoTask> getEcho() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Echo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksExecTask> getExec() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Exec());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksFailTask> getFail() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Fail());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksGetTask> getGet() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Get());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIfTask> getIf() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_If());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIfNotTask> getIfnot() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Ifnot());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIncludeTask> getInclude() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Include());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoadFileTask> getLoadfile() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Loadfile());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoadTasksTask> getLoadtasks() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Loadtasks());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoopTask> getForeach() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Foreach());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMailTask> getMail() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Mail());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMkDirTask> getMkdir() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Mkdir());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMoveTask> getMove() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Move());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksNAntSchemaTask> getNantschema() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Nantschema());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksNAntTask> getNant() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Nant());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksPropertyTask> getProperty() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Property());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksRegexTask> getRegex() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Regex());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSetEnvTask> getSetenv() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Setenv());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSleepTask> getSleep() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Sleep());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksStyleTask> getStyle() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Style());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSysInfoTask> getSysinfo() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Sysinfo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksTStampTask> getTstamp() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Tstamp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksTouchTask> getTouch() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Touch());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksUpToDateTask> getUptodate() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Uptodate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksXmlPeekTask> getXmlpeek() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Xmlpeek());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksXmlPokeTask> getXmlpoke() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Xmlpoke());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntMSNetTasksIldasmTask> getIldasm() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Ildasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntMSNetTasksServiceControllerTask> getServicecontroller() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Servicecontroller());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getAssemblyfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Assemblyfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesModuleSet> getModuleset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Moduleset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesNamespaceImportCollection> getNamespaceimports() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Namespaceimports());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesResourceFileSet> getResourcefileset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Resourcefileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesWarningAsError> getWarnaserror() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Warnaserror());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTypesTarFileSet> getTarfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Tarfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTypesZipFileSet> getZipfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Zipfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit2TypesCategories> getCategories() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Categories());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTypesCvsFileSet> getCvsfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Cvsfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreFiltersFilterChain> getFilterchain() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Filterchain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesCredential> getCredential() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Credential());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getFileset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Fileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesDirSet> getDirset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Dirset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesPathSet> getPath() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Path());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesPatternSet> getPatternset() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Patternset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesProxy> getProxy() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Proxy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Target> getTarget() {
		return getGroup().list(NantPackage.eINSTANCE.getProjectType_Target());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(NantPackage.eINSTANCE.getProjectType_Any());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.PROJECT_TYPE__BASEDIR, oldBasedir, basedir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(Object newDefault) {
		Object oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.PROJECT_TYPE__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Object newName) {
		Object oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.PROJECT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NantPackage.PROJECT_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ASMINFO:
				return ((InternalEList<?>)getAsminfo()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__AL:
				return ((InternalEList<?>)getAl()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CSC:
				return ((InternalEList<?>)getCsc()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__DELAY_SIGN:
				return ((InternalEList<?>)getDelaySign()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ILASM:
				return ((InternalEList<?>)getIlasm()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__JSC:
				return ((InternalEList<?>)getJsc()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__LICENSE:
				return ((InternalEList<?>)getLicense()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__NDOC:
				return ((InternalEList<?>)getNdoc()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__REGSVCS:
				return ((InternalEList<?>)getRegsvcs()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__RESGEN:
				return ((InternalEList<?>)getResgen()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__SCRIPT:
				return ((InternalEList<?>)getScript()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__VBC:
				return ((InternalEList<?>)getVbc()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__VJC:
				return ((InternalEList<?>)getVjc()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__GUNZIP:
				return ((InternalEList<?>)getGunzip()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TAR:
				return ((InternalEList<?>)getTar()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__UNZIP:
				return ((InternalEList<?>)getUnzip()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ZIP:
				return ((InternalEList<?>)getZip()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__NUNIT:
				return ((InternalEList<?>)getNunit()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__NUNIT2:
				return ((InternalEList<?>)getNunit2()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS_CHANGELOG:
				return ((InternalEList<?>)getCvsChangelog()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS_CHECKOUT:
				return ((InternalEList<?>)getCvsCheckout()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS_PASS:
				return ((InternalEList<?>)getCvsPass()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS:
				return ((InternalEList<?>)getCvs()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS_EXPORT:
				return ((InternalEList<?>)getCvsExport()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS_RTAG:
				return ((InternalEList<?>)getCvsRtag()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS_TAG:
				return ((InternalEList<?>)getCvsTag()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVS_UPDATE:
				return ((InternalEList<?>)getCvsUpdate()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__AXIMP:
				return ((InternalEList<?>)getAximp()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__READREGISTRY:
				return ((InternalEList<?>)getReadregistry()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__REGASM:
				return ((InternalEList<?>)getRegasm()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TLBEXP:
				return ((InternalEList<?>)getTlbexp()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TLBIMP:
				return ((InternalEList<?>)getTlbimp()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CL:
				return ((InternalEList<?>)getCl()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__LIB:
				return ((InternalEList<?>)getLib()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__MC:
				return ((InternalEList<?>)getMc()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__MIDL:
				return ((InternalEList<?>)getMidl()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__RC:
				return ((InternalEList<?>)getRc()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__SOLUTION:
				return ((InternalEList<?>)getSolution()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TESTTASK:
				return ((InternalEList<?>)getTesttask()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ELEMENT_TEST1:
				return ((InternalEList<?>)getElementTest1()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TEST:
				return ((InternalEList<?>)getTest()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ATTRIB:
				return ((InternalEList<?>)getAttrib()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__AVAILABLE:
				return ((InternalEList<?>)getAvailable()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CALL:
				return ((InternalEList<?>)getCall()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__COPY:
				return ((InternalEList<?>)getCopy()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__DELETE:
				return ((InternalEList<?>)getDelete()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ECHO:
				return ((InternalEList<?>)getEcho()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__EXEC:
				return ((InternalEList<?>)getExec()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__FAIL:
				return ((InternalEList<?>)getFail()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__GET:
				return ((InternalEList<?>)getGet()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__IF:
				return ((InternalEList<?>)getIf()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__IFNOT:
				return ((InternalEList<?>)getIfnot()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__INCLUDE:
				return ((InternalEList<?>)getInclude()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__LOADFILE:
				return ((InternalEList<?>)getLoadfile()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__LOADTASKS:
				return ((InternalEList<?>)getLoadtasks()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__FOREACH:
				return ((InternalEList<?>)getForeach()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__MAIL:
				return ((InternalEList<?>)getMail()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__MKDIR:
				return ((InternalEList<?>)getMkdir()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__MOVE:
				return ((InternalEList<?>)getMove()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__NANTSCHEMA:
				return ((InternalEList<?>)getNantschema()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__NANT:
				return ((InternalEList<?>)getNant()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__REGEX:
				return ((InternalEList<?>)getRegex()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__SETENV:
				return ((InternalEList<?>)getSetenv()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__SLEEP:
				return ((InternalEList<?>)getSleep()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__STYLE:
				return ((InternalEList<?>)getStyle()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__SYSINFO:
				return ((InternalEList<?>)getSysinfo()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TSTAMP:
				return ((InternalEList<?>)getTstamp()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TOUCH:
				return ((InternalEList<?>)getTouch()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__UPTODATE:
				return ((InternalEList<?>)getUptodate()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__XMLPEEK:
				return ((InternalEList<?>)getXmlpeek()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__XMLPOKE:
				return ((InternalEList<?>)getXmlpoke()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ILDASM:
				return ((InternalEList<?>)getIldasm()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__SERVICECONTROLLER:
				return ((InternalEList<?>)getServicecontroller()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ASSEMBLYFILESET:
				return ((InternalEList<?>)getAssemblyfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__MODULESET:
				return ((InternalEList<?>)getModuleset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__NAMESPACEIMPORTS:
				return ((InternalEList<?>)getNamespaceimports()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__RESOURCEFILESET:
				return ((InternalEList<?>)getResourcefileset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__WARNASERROR:
				return ((InternalEList<?>)getWarnaserror()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TARFILESET:
				return ((InternalEList<?>)getTarfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ZIPFILESET:
				return ((InternalEList<?>)getZipfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CVSFILESET:
				return ((InternalEList<?>)getCvsfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__FILTERCHAIN:
				return ((InternalEList<?>)getFilterchain()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__CREDENTIAL:
				return ((InternalEList<?>)getCredential()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__FILESET:
				return ((InternalEList<?>)getFileset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__DIRSET:
				return ((InternalEList<?>)getDirset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__PATH:
				return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__PATTERNSET:
				return ((InternalEList<?>)getPatternset()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__PROXY:
				return ((InternalEList<?>)getProxy()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__TARGET:
				return ((InternalEList<?>)getTarget()).basicRemove(otherEnd, msgs);
			case NantPackage.PROJECT_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
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
			case NantPackage.PROJECT_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.PROJECT_TYPE__ASMINFO:
				return getAsminfo();
			case NantPackage.PROJECT_TYPE__AL:
				return getAl();
			case NantPackage.PROJECT_TYPE__CSC:
				return getCsc();
			case NantPackage.PROJECT_TYPE__DELAY_SIGN:
				return getDelaySign();
			case NantPackage.PROJECT_TYPE__ILASM:
				return getIlasm();
			case NantPackage.PROJECT_TYPE__JSC:
				return getJsc();
			case NantPackage.PROJECT_TYPE__LICENSE:
				return getLicense();
			case NantPackage.PROJECT_TYPE__NDOC:
				return getNdoc();
			case NantPackage.PROJECT_TYPE__REGSVCS:
				return getRegsvcs();
			case NantPackage.PROJECT_TYPE__RESGEN:
				return getResgen();
			case NantPackage.PROJECT_TYPE__SCRIPT:
				return getScript();
			case NantPackage.PROJECT_TYPE__VBC:
				return getVbc();
			case NantPackage.PROJECT_TYPE__VJC:
				return getVjc();
			case NantPackage.PROJECT_TYPE__GUNZIP:
				return getGunzip();
			case NantPackage.PROJECT_TYPE__TAR:
				return getTar();
			case NantPackage.PROJECT_TYPE__UNZIP:
				return getUnzip();
			case NantPackage.PROJECT_TYPE__ZIP:
				return getZip();
			case NantPackage.PROJECT_TYPE__NUNIT:
				return getNunit();
			case NantPackage.PROJECT_TYPE__NUNIT2:
				return getNunit2();
			case NantPackage.PROJECT_TYPE__CVS_CHANGELOG:
				return getCvsChangelog();
			case NantPackage.PROJECT_TYPE__CVS_CHECKOUT:
				return getCvsCheckout();
			case NantPackage.PROJECT_TYPE__CVS_PASS:
				return getCvsPass();
			case NantPackage.PROJECT_TYPE__CVS:
				return getCvs();
			case NantPackage.PROJECT_TYPE__CVS_EXPORT:
				return getCvsExport();
			case NantPackage.PROJECT_TYPE__CVS_RTAG:
				return getCvsRtag();
			case NantPackage.PROJECT_TYPE__CVS_TAG:
				return getCvsTag();
			case NantPackage.PROJECT_TYPE__CVS_UPDATE:
				return getCvsUpdate();
			case NantPackage.PROJECT_TYPE__AXIMP:
				return getAximp();
			case NantPackage.PROJECT_TYPE__READREGISTRY:
				return getReadregistry();
			case NantPackage.PROJECT_TYPE__REGASM:
				return getRegasm();
			case NantPackage.PROJECT_TYPE__TLBEXP:
				return getTlbexp();
			case NantPackage.PROJECT_TYPE__TLBIMP:
				return getTlbimp();
			case NantPackage.PROJECT_TYPE__CL:
				return getCl();
			case NantPackage.PROJECT_TYPE__LIB:
				return getLib();
			case NantPackage.PROJECT_TYPE__LINK:
				return getLink();
			case NantPackage.PROJECT_TYPE__MC:
				return getMc();
			case NantPackage.PROJECT_TYPE__MIDL:
				return getMidl();
			case NantPackage.PROJECT_TYPE__RC:
				return getRc();
			case NantPackage.PROJECT_TYPE__SOLUTION:
				return getSolution();
			case NantPackage.PROJECT_TYPE__TESTTASK:
				return getTesttask();
			case NantPackage.PROJECT_TYPE__ELEMENT_TEST1:
				return getElementTest1();
			case NantPackage.PROJECT_TYPE__TEST:
				return getTest();
			case NantPackage.PROJECT_TYPE__ATTRIB:
				return getAttrib();
			case NantPackage.PROJECT_TYPE__AVAILABLE:
				return getAvailable();
			case NantPackage.PROJECT_TYPE__CALL:
				return getCall();
			case NantPackage.PROJECT_TYPE__COPY:
				return getCopy();
			case NantPackage.PROJECT_TYPE__DELETE:
				return getDelete();
			case NantPackage.PROJECT_TYPE__DESCRIPTION:
				return getDescription();
			case NantPackage.PROJECT_TYPE__ECHO:
				return getEcho();
			case NantPackage.PROJECT_TYPE__EXEC:
				return getExec();
			case NantPackage.PROJECT_TYPE__FAIL:
				return getFail();
			case NantPackage.PROJECT_TYPE__GET:
				return getGet();
			case NantPackage.PROJECT_TYPE__IF:
				return getIf();
			case NantPackage.PROJECT_TYPE__IFNOT:
				return getIfnot();
			case NantPackage.PROJECT_TYPE__INCLUDE:
				return getInclude();
			case NantPackage.PROJECT_TYPE__LOADFILE:
				return getLoadfile();
			case NantPackage.PROJECT_TYPE__LOADTASKS:
				return getLoadtasks();
			case NantPackage.PROJECT_TYPE__FOREACH:
				return getForeach();
			case NantPackage.PROJECT_TYPE__MAIL:
				return getMail();
			case NantPackage.PROJECT_TYPE__MKDIR:
				return getMkdir();
			case NantPackage.PROJECT_TYPE__MOVE:
				return getMove();
			case NantPackage.PROJECT_TYPE__NANTSCHEMA:
				return getNantschema();
			case NantPackage.PROJECT_TYPE__NANT:
				return getNant();
			case NantPackage.PROJECT_TYPE__PROPERTY:
				return getProperty();
			case NantPackage.PROJECT_TYPE__REGEX:
				return getRegex();
			case NantPackage.PROJECT_TYPE__SETENV:
				return getSetenv();
			case NantPackage.PROJECT_TYPE__SLEEP:
				return getSleep();
			case NantPackage.PROJECT_TYPE__STYLE:
				return getStyle();
			case NantPackage.PROJECT_TYPE__SYSINFO:
				return getSysinfo();
			case NantPackage.PROJECT_TYPE__TSTAMP:
				return getTstamp();
			case NantPackage.PROJECT_TYPE__TOUCH:
				return getTouch();
			case NantPackage.PROJECT_TYPE__UPTODATE:
				return getUptodate();
			case NantPackage.PROJECT_TYPE__XMLPEEK:
				return getXmlpeek();
			case NantPackage.PROJECT_TYPE__XMLPOKE:
				return getXmlpoke();
			case NantPackage.PROJECT_TYPE__ILDASM:
				return getIldasm();
			case NantPackage.PROJECT_TYPE__SERVICECONTROLLER:
				return getServicecontroller();
			case NantPackage.PROJECT_TYPE__ASSEMBLYFILESET:
				return getAssemblyfileset();
			case NantPackage.PROJECT_TYPE__MODULESET:
				return getModuleset();
			case NantPackage.PROJECT_TYPE__NAMESPACEIMPORTS:
				return getNamespaceimports();
			case NantPackage.PROJECT_TYPE__RESOURCEFILESET:
				return getResourcefileset();
			case NantPackage.PROJECT_TYPE__WARNASERROR:
				return getWarnaserror();
			case NantPackage.PROJECT_TYPE__TARFILESET:
				return getTarfileset();
			case NantPackage.PROJECT_TYPE__ZIPFILESET:
				return getZipfileset();
			case NantPackage.PROJECT_TYPE__CATEGORIES:
				return getCategories();
			case NantPackage.PROJECT_TYPE__CVSFILESET:
				return getCvsfileset();
			case NantPackage.PROJECT_TYPE__FILTERCHAIN:
				return getFilterchain();
			case NantPackage.PROJECT_TYPE__CREDENTIAL:
				return getCredential();
			case NantPackage.PROJECT_TYPE__FILESET:
				return getFileset();
			case NantPackage.PROJECT_TYPE__DIRSET:
				return getDirset();
			case NantPackage.PROJECT_TYPE__PATH:
				return getPath();
			case NantPackage.PROJECT_TYPE__PATTERNSET:
				return getPatternset();
			case NantPackage.PROJECT_TYPE__PROXY:
				return getProxy();
			case NantPackage.PROJECT_TYPE__TARGET:
				return getTarget();
			case NantPackage.PROJECT_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case NantPackage.PROJECT_TYPE__BASEDIR:
				return getBasedir();
			case NantPackage.PROJECT_TYPE__DEFAULT:
				return getDefault();
			case NantPackage.PROJECT_TYPE__NAME:
				return getName();
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
			case NantPackage.PROJECT_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.PROJECT_TYPE__ASMINFO:
				getAsminfo().clear();
				getAsminfo().addAll((Collection<? extends NAntDotNetTasksAssemblyInfoTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__AL:
				getAl().clear();
				getAl().addAll((Collection<? extends NAntDotNetTasksAssemblyLinkerTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CSC:
				getCsc().clear();
				getCsc().addAll((Collection<? extends NAntDotNetTasksCscTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__DELAY_SIGN:
				getDelaySign().clear();
				getDelaySign().addAll((Collection<? extends NAntDotNetTasksDelaySignTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ILASM:
				getIlasm().clear();
				getIlasm().addAll((Collection<? extends NAntDotNetTasksIlasmTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__JSC:
				getJsc().clear();
				getJsc().addAll((Collection<? extends NAntDotNetTasksJscTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__LICENSE:
				getLicense().clear();
				getLicense().addAll((Collection<? extends NAntDotNetTasksLicenseTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__NDOC:
				getNdoc().clear();
				getNdoc().addAll((Collection<? extends NAntDotNetTasksNDocTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__REGSVCS:
				getRegsvcs().clear();
				getRegsvcs().addAll((Collection<? extends NAntDotNetTasksRegsvcsTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__RESGEN:
				getResgen().clear();
				getResgen().addAll((Collection<? extends NAntDotNetTasksResGenTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__SCRIPT:
				getScript().clear();
				getScript().addAll((Collection<? extends NAntDotNetTasksScriptTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__VBC:
				getVbc().clear();
				getVbc().addAll((Collection<? extends NAntDotNetTasksVbcTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__VJC:
				getVjc().clear();
				getVjc().addAll((Collection<? extends NAntDotNetTasksVjcTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__GUNZIP:
				getGunzip().clear();
				getGunzip().addAll((Collection<? extends NAntCompressionTasksGUnzip>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TAR:
				getTar().clear();
				getTar().addAll((Collection<? extends NAntCompressionTasksTarTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__UNZIP:
				getUnzip().clear();
				getUnzip().addAll((Collection<? extends NAntCompressionTasksUnZipTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ZIP:
				getZip().clear();
				getZip().addAll((Collection<? extends NAntCompressionTasksZipTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__NUNIT:
				getNunit().clear();
				getNunit().addAll((Collection<? extends NAntNUnit1TasksNUnitTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__NUNIT2:
				getNunit2().clear();
				getNunit2().addAll((Collection<? extends NAntNUnit2TasksNUnit2Task>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS_CHANGELOG:
				getCvsChangelog().clear();
				getCvsChangelog().addAll((Collection<? extends NAntSourceControlTasksChangeLogTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS_CHECKOUT:
				getCvsCheckout().clear();
				getCvsCheckout().addAll((Collection<? extends NAntSourceControlTasksCheckoutTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS_PASS:
				getCvsPass().clear();
				getCvsPass().addAll((Collection<? extends NAntSourceControlTasksCvsPass>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS:
				getCvs().clear();
				getCvs().addAll((Collection<? extends NAntSourceControlTasksCvsTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS_EXPORT:
				getCvsExport().clear();
				getCvsExport().addAll((Collection<? extends NAntSourceControlTasksExportTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS_RTAG:
				getCvsRtag().clear();
				getCvsRtag().addAll((Collection<? extends NAntSourceControlTasksRTagTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS_TAG:
				getCvsTag().clear();
				getCvsTag().addAll((Collection<? extends NAntSourceControlTasksTagTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVS_UPDATE:
				getCvsUpdate().clear();
				getCvsUpdate().addAll((Collection<? extends NAntSourceControlTasksUpdateTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__AXIMP:
				getAximp().clear();
				getAximp().addAll((Collection<? extends NAntWin32TasksAxImpTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__READREGISTRY:
				getReadregistry().clear();
				getReadregistry().addAll((Collection<? extends NAntWin32TasksReadRegistryTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__REGASM:
				getRegasm().clear();
				getRegasm().addAll((Collection<? extends NAntWin32TasksRegAsmTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TLBEXP:
				getTlbexp().clear();
				getTlbexp().addAll((Collection<? extends NAntWin32TasksTlbExpTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TLBIMP:
				getTlbimp().clear();
				getTlbimp().addAll((Collection<? extends NAntWin32TasksTlbImpTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CL:
				getCl().clear();
				getCl().addAll((Collection<? extends NAntVisualCppTasksClTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__LIB:
				getLib().clear();
				getLib().addAll((Collection<? extends NAntVisualCppTasksLibTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends NAntVisualCppTasksLinkTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__MC:
				getMc().clear();
				getMc().addAll((Collection<? extends NAntVisualCppTasksMcTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__MIDL:
				getMidl().clear();
				getMidl().addAll((Collection<? extends NAntVisualCppTasksMidlTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__RC:
				getRc().clear();
				getRc().addAll((Collection<? extends NAntVisualCppTasksRcTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__SOLUTION:
				getSolution().clear();
				getSolution().addAll((Collection<? extends NAntVSNetTasksSolutionTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TESTTASK:
				getTesttask().clear();
				getTesttask().addAll((Collection<? extends TestsNAntCoreUtilXmlLoggerTestTestTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ELEMENT_TEST1:
				getElementTest1().clear();
				getElementTest1().addAll((Collection<? extends TestsNAntCoreElementTest1Task>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TEST:
				getTest().clear();
				getTest().addAll((Collection<? extends TestsNAntCoreTestTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ATTRIB:
				getAttrib().clear();
				getAttrib().addAll((Collection<? extends NAntCoreTasksAttribTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__AVAILABLE:
				getAvailable().clear();
				getAvailable().addAll((Collection<? extends NAntCoreTasksAvailableTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CALL:
				getCall().clear();
				getCall().addAll((Collection<? extends NAntCoreTasksCallTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__COPY:
				getCopy().clear();
				getCopy().addAll((Collection<? extends NAntCoreTasksCopyTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__DELETE:
				getDelete().clear();
				getDelete().addAll((Collection<? extends NAntCoreTasksDeleteTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends NAntCoreTasksDescriptionTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ECHO:
				getEcho().clear();
				getEcho().addAll((Collection<? extends NAntCoreTasksEchoTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__EXEC:
				getExec().clear();
				getExec().addAll((Collection<? extends NAntCoreTasksExecTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__FAIL:
				getFail().clear();
				getFail().addAll((Collection<? extends NAntCoreTasksFailTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__GET:
				getGet().clear();
				getGet().addAll((Collection<? extends NAntCoreTasksGetTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__IF:
				getIf().clear();
				getIf().addAll((Collection<? extends NAntCoreTasksIfTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__IFNOT:
				getIfnot().clear();
				getIfnot().addAll((Collection<? extends NAntCoreTasksIfNotTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__INCLUDE:
				getInclude().clear();
				getInclude().addAll((Collection<? extends NAntCoreTasksIncludeTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__LOADFILE:
				getLoadfile().clear();
				getLoadfile().addAll((Collection<? extends NAntCoreTasksLoadFileTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__LOADTASKS:
				getLoadtasks().clear();
				getLoadtasks().addAll((Collection<? extends NAntCoreTasksLoadTasksTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__FOREACH:
				getForeach().clear();
				getForeach().addAll((Collection<? extends NAntCoreTasksLoopTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__MAIL:
				getMail().clear();
				getMail().addAll((Collection<? extends NAntCoreTasksMailTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__MKDIR:
				getMkdir().clear();
				getMkdir().addAll((Collection<? extends NAntCoreTasksMkDirTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__MOVE:
				getMove().clear();
				getMove().addAll((Collection<? extends NAntCoreTasksMoveTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__NANTSCHEMA:
				getNantschema().clear();
				getNantschema().addAll((Collection<? extends NAntCoreTasksNAntSchemaTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__NANT:
				getNant().clear();
				getNant().addAll((Collection<? extends NAntCoreTasksNAntTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends NAntCoreTasksPropertyTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__REGEX:
				getRegex().clear();
				getRegex().addAll((Collection<? extends NAntCoreTasksRegexTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__SETENV:
				getSetenv().clear();
				getSetenv().addAll((Collection<? extends NAntCoreTasksSetEnvTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__SLEEP:
				getSleep().clear();
				getSleep().addAll((Collection<? extends NAntCoreTasksSleepTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__STYLE:
				getStyle().clear();
				getStyle().addAll((Collection<? extends NAntCoreTasksStyleTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__SYSINFO:
				getSysinfo().clear();
				getSysinfo().addAll((Collection<? extends NAntCoreTasksSysInfoTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TSTAMP:
				getTstamp().clear();
				getTstamp().addAll((Collection<? extends NAntCoreTasksTStampTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TOUCH:
				getTouch().clear();
				getTouch().addAll((Collection<? extends NAntCoreTasksTouchTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__UPTODATE:
				getUptodate().clear();
				getUptodate().addAll((Collection<? extends NAntCoreTasksUpToDateTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__XMLPEEK:
				getXmlpeek().clear();
				getXmlpeek().addAll((Collection<? extends NAntCoreTasksXmlPeekTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__XMLPOKE:
				getXmlpoke().clear();
				getXmlpoke().addAll((Collection<? extends NAntCoreTasksXmlPokeTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ILDASM:
				getIldasm().clear();
				getIldasm().addAll((Collection<? extends NAntMSNetTasksIldasmTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__SERVICECONTROLLER:
				getServicecontroller().clear();
				getServicecontroller().addAll((Collection<? extends NAntMSNetTasksServiceControllerTask>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ASSEMBLYFILESET:
				getAssemblyfileset().clear();
				getAssemblyfileset().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__MODULESET:
				getModuleset().clear();
				getModuleset().addAll((Collection<? extends NAntDotNetTypesModuleSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__NAMESPACEIMPORTS:
				getNamespaceimports().clear();
				getNamespaceimports().addAll((Collection<? extends NAntDotNetTypesNamespaceImportCollection>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__RESOURCEFILESET:
				getResourcefileset().clear();
				getResourcefileset().addAll((Collection<? extends NAntDotNetTypesResourceFileSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__WARNASERROR:
				getWarnaserror().clear();
				getWarnaserror().addAll((Collection<? extends NAntDotNetTypesWarningAsError>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TARFILESET:
				getTarfileset().clear();
				getTarfileset().addAll((Collection<? extends NAntCompressionTypesTarFileSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ZIPFILESET:
				getZipfileset().clear();
				getZipfileset().addAll((Collection<? extends NAntCompressionTypesZipFileSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends NAntNUnit2TypesCategories>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CVSFILESET:
				getCvsfileset().clear();
				getCvsfileset().addAll((Collection<? extends NAntSourceControlTypesCvsFileSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__FILTERCHAIN:
				getFilterchain().clear();
				getFilterchain().addAll((Collection<? extends NAntCoreFiltersFilterChain>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__CREDENTIAL:
				getCredential().clear();
				getCredential().addAll((Collection<? extends NAntCoreTypesCredential>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__FILESET:
				getFileset().clear();
				getFileset().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__DIRSET:
				getDirset().clear();
				getDirset().addAll((Collection<? extends NAntCoreTypesDirSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends NAntCoreTypesPathSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__PATTERNSET:
				getPatternset().clear();
				getPatternset().addAll((Collection<? extends NAntCoreTypesPatternSet>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__PROXY:
				getProxy().clear();
				getProxy().addAll((Collection<? extends NAntCoreTypesProxy>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__TARGET:
				getTarget().clear();
				getTarget().addAll((Collection<? extends Target>)newValue);
				return;
			case NantPackage.PROJECT_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case NantPackage.PROJECT_TYPE__BASEDIR:
				setBasedir(newValue);
				return;
			case NantPackage.PROJECT_TYPE__DEFAULT:
				setDefault(newValue);
				return;
			case NantPackage.PROJECT_TYPE__NAME:
				setName(newValue);
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
			case NantPackage.PROJECT_TYPE__GROUP:
				getGroup().clear();
				return;
			case NantPackage.PROJECT_TYPE__ASMINFO:
				getAsminfo().clear();
				return;
			case NantPackage.PROJECT_TYPE__AL:
				getAl().clear();
				return;
			case NantPackage.PROJECT_TYPE__CSC:
				getCsc().clear();
				return;
			case NantPackage.PROJECT_TYPE__DELAY_SIGN:
				getDelaySign().clear();
				return;
			case NantPackage.PROJECT_TYPE__ILASM:
				getIlasm().clear();
				return;
			case NantPackage.PROJECT_TYPE__JSC:
				getJsc().clear();
				return;
			case NantPackage.PROJECT_TYPE__LICENSE:
				getLicense().clear();
				return;
			case NantPackage.PROJECT_TYPE__NDOC:
				getNdoc().clear();
				return;
			case NantPackage.PROJECT_TYPE__REGSVCS:
				getRegsvcs().clear();
				return;
			case NantPackage.PROJECT_TYPE__RESGEN:
				getResgen().clear();
				return;
			case NantPackage.PROJECT_TYPE__SCRIPT:
				getScript().clear();
				return;
			case NantPackage.PROJECT_TYPE__VBC:
				getVbc().clear();
				return;
			case NantPackage.PROJECT_TYPE__VJC:
				getVjc().clear();
				return;
			case NantPackage.PROJECT_TYPE__GUNZIP:
				getGunzip().clear();
				return;
			case NantPackage.PROJECT_TYPE__TAR:
				getTar().clear();
				return;
			case NantPackage.PROJECT_TYPE__UNZIP:
				getUnzip().clear();
				return;
			case NantPackage.PROJECT_TYPE__ZIP:
				getZip().clear();
				return;
			case NantPackage.PROJECT_TYPE__NUNIT:
				getNunit().clear();
				return;
			case NantPackage.PROJECT_TYPE__NUNIT2:
				getNunit2().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS_CHANGELOG:
				getCvsChangelog().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS_CHECKOUT:
				getCvsCheckout().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS_PASS:
				getCvsPass().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS:
				getCvs().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS_EXPORT:
				getCvsExport().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS_RTAG:
				getCvsRtag().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS_TAG:
				getCvsTag().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVS_UPDATE:
				getCvsUpdate().clear();
				return;
			case NantPackage.PROJECT_TYPE__AXIMP:
				getAximp().clear();
				return;
			case NantPackage.PROJECT_TYPE__READREGISTRY:
				getReadregistry().clear();
				return;
			case NantPackage.PROJECT_TYPE__REGASM:
				getRegasm().clear();
				return;
			case NantPackage.PROJECT_TYPE__TLBEXP:
				getTlbexp().clear();
				return;
			case NantPackage.PROJECT_TYPE__TLBIMP:
				getTlbimp().clear();
				return;
			case NantPackage.PROJECT_TYPE__CL:
				getCl().clear();
				return;
			case NantPackage.PROJECT_TYPE__LIB:
				getLib().clear();
				return;
			case NantPackage.PROJECT_TYPE__LINK:
				getLink().clear();
				return;
			case NantPackage.PROJECT_TYPE__MC:
				getMc().clear();
				return;
			case NantPackage.PROJECT_TYPE__MIDL:
				getMidl().clear();
				return;
			case NantPackage.PROJECT_TYPE__RC:
				getRc().clear();
				return;
			case NantPackage.PROJECT_TYPE__SOLUTION:
				getSolution().clear();
				return;
			case NantPackage.PROJECT_TYPE__TESTTASK:
				getTesttask().clear();
				return;
			case NantPackage.PROJECT_TYPE__ELEMENT_TEST1:
				getElementTest1().clear();
				return;
			case NantPackage.PROJECT_TYPE__TEST:
				getTest().clear();
				return;
			case NantPackage.PROJECT_TYPE__ATTRIB:
				getAttrib().clear();
				return;
			case NantPackage.PROJECT_TYPE__AVAILABLE:
				getAvailable().clear();
				return;
			case NantPackage.PROJECT_TYPE__CALL:
				getCall().clear();
				return;
			case NantPackage.PROJECT_TYPE__COPY:
				getCopy().clear();
				return;
			case NantPackage.PROJECT_TYPE__DELETE:
				getDelete().clear();
				return;
			case NantPackage.PROJECT_TYPE__DESCRIPTION:
				getDescription().clear();
				return;
			case NantPackage.PROJECT_TYPE__ECHO:
				getEcho().clear();
				return;
			case NantPackage.PROJECT_TYPE__EXEC:
				getExec().clear();
				return;
			case NantPackage.PROJECT_TYPE__FAIL:
				getFail().clear();
				return;
			case NantPackage.PROJECT_TYPE__GET:
				getGet().clear();
				return;
			case NantPackage.PROJECT_TYPE__IF:
				getIf().clear();
				return;
			case NantPackage.PROJECT_TYPE__IFNOT:
				getIfnot().clear();
				return;
			case NantPackage.PROJECT_TYPE__INCLUDE:
				getInclude().clear();
				return;
			case NantPackage.PROJECT_TYPE__LOADFILE:
				getLoadfile().clear();
				return;
			case NantPackage.PROJECT_TYPE__LOADTASKS:
				getLoadtasks().clear();
				return;
			case NantPackage.PROJECT_TYPE__FOREACH:
				getForeach().clear();
				return;
			case NantPackage.PROJECT_TYPE__MAIL:
				getMail().clear();
				return;
			case NantPackage.PROJECT_TYPE__MKDIR:
				getMkdir().clear();
				return;
			case NantPackage.PROJECT_TYPE__MOVE:
				getMove().clear();
				return;
			case NantPackage.PROJECT_TYPE__NANTSCHEMA:
				getNantschema().clear();
				return;
			case NantPackage.PROJECT_TYPE__NANT:
				getNant().clear();
				return;
			case NantPackage.PROJECT_TYPE__PROPERTY:
				getProperty().clear();
				return;
			case NantPackage.PROJECT_TYPE__REGEX:
				getRegex().clear();
				return;
			case NantPackage.PROJECT_TYPE__SETENV:
				getSetenv().clear();
				return;
			case NantPackage.PROJECT_TYPE__SLEEP:
				getSleep().clear();
				return;
			case NantPackage.PROJECT_TYPE__STYLE:
				getStyle().clear();
				return;
			case NantPackage.PROJECT_TYPE__SYSINFO:
				getSysinfo().clear();
				return;
			case NantPackage.PROJECT_TYPE__TSTAMP:
				getTstamp().clear();
				return;
			case NantPackage.PROJECT_TYPE__TOUCH:
				getTouch().clear();
				return;
			case NantPackage.PROJECT_TYPE__UPTODATE:
				getUptodate().clear();
				return;
			case NantPackage.PROJECT_TYPE__XMLPEEK:
				getXmlpeek().clear();
				return;
			case NantPackage.PROJECT_TYPE__XMLPOKE:
				getXmlpoke().clear();
				return;
			case NantPackage.PROJECT_TYPE__ILDASM:
				getIldasm().clear();
				return;
			case NantPackage.PROJECT_TYPE__SERVICECONTROLLER:
				getServicecontroller().clear();
				return;
			case NantPackage.PROJECT_TYPE__ASSEMBLYFILESET:
				getAssemblyfileset().clear();
				return;
			case NantPackage.PROJECT_TYPE__MODULESET:
				getModuleset().clear();
				return;
			case NantPackage.PROJECT_TYPE__NAMESPACEIMPORTS:
				getNamespaceimports().clear();
				return;
			case NantPackage.PROJECT_TYPE__RESOURCEFILESET:
				getResourcefileset().clear();
				return;
			case NantPackage.PROJECT_TYPE__WARNASERROR:
				getWarnaserror().clear();
				return;
			case NantPackage.PROJECT_TYPE__TARFILESET:
				getTarfileset().clear();
				return;
			case NantPackage.PROJECT_TYPE__ZIPFILESET:
				getZipfileset().clear();
				return;
			case NantPackage.PROJECT_TYPE__CATEGORIES:
				getCategories().clear();
				return;
			case NantPackage.PROJECT_TYPE__CVSFILESET:
				getCvsfileset().clear();
				return;
			case NantPackage.PROJECT_TYPE__FILTERCHAIN:
				getFilterchain().clear();
				return;
			case NantPackage.PROJECT_TYPE__CREDENTIAL:
				getCredential().clear();
				return;
			case NantPackage.PROJECT_TYPE__FILESET:
				getFileset().clear();
				return;
			case NantPackage.PROJECT_TYPE__DIRSET:
				getDirset().clear();
				return;
			case NantPackage.PROJECT_TYPE__PATH:
				getPath().clear();
				return;
			case NantPackage.PROJECT_TYPE__PATTERNSET:
				getPatternset().clear();
				return;
			case NantPackage.PROJECT_TYPE__PROXY:
				getProxy().clear();
				return;
			case NantPackage.PROJECT_TYPE__TARGET:
				getTarget().clear();
				return;
			case NantPackage.PROJECT_TYPE__ANY:
				getAny().clear();
				return;
			case NantPackage.PROJECT_TYPE__BASEDIR:
				setBasedir(BASEDIR_EDEFAULT);
				return;
			case NantPackage.PROJECT_TYPE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case NantPackage.PROJECT_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case NantPackage.PROJECT_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.PROJECT_TYPE__ASMINFO:
				return !getAsminfo().isEmpty();
			case NantPackage.PROJECT_TYPE__AL:
				return !getAl().isEmpty();
			case NantPackage.PROJECT_TYPE__CSC:
				return !getCsc().isEmpty();
			case NantPackage.PROJECT_TYPE__DELAY_SIGN:
				return !getDelaySign().isEmpty();
			case NantPackage.PROJECT_TYPE__ILASM:
				return !getIlasm().isEmpty();
			case NantPackage.PROJECT_TYPE__JSC:
				return !getJsc().isEmpty();
			case NantPackage.PROJECT_TYPE__LICENSE:
				return !getLicense().isEmpty();
			case NantPackage.PROJECT_TYPE__NDOC:
				return !getNdoc().isEmpty();
			case NantPackage.PROJECT_TYPE__REGSVCS:
				return !getRegsvcs().isEmpty();
			case NantPackage.PROJECT_TYPE__RESGEN:
				return !getResgen().isEmpty();
			case NantPackage.PROJECT_TYPE__SCRIPT:
				return !getScript().isEmpty();
			case NantPackage.PROJECT_TYPE__VBC:
				return !getVbc().isEmpty();
			case NantPackage.PROJECT_TYPE__VJC:
				return !getVjc().isEmpty();
			case NantPackage.PROJECT_TYPE__GUNZIP:
				return !getGunzip().isEmpty();
			case NantPackage.PROJECT_TYPE__TAR:
				return !getTar().isEmpty();
			case NantPackage.PROJECT_TYPE__UNZIP:
				return !getUnzip().isEmpty();
			case NantPackage.PROJECT_TYPE__ZIP:
				return !getZip().isEmpty();
			case NantPackage.PROJECT_TYPE__NUNIT:
				return !getNunit().isEmpty();
			case NantPackage.PROJECT_TYPE__NUNIT2:
				return !getNunit2().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS_CHANGELOG:
				return !getCvsChangelog().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS_CHECKOUT:
				return !getCvsCheckout().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS_PASS:
				return !getCvsPass().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS:
				return !getCvs().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS_EXPORT:
				return !getCvsExport().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS_RTAG:
				return !getCvsRtag().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS_TAG:
				return !getCvsTag().isEmpty();
			case NantPackage.PROJECT_TYPE__CVS_UPDATE:
				return !getCvsUpdate().isEmpty();
			case NantPackage.PROJECT_TYPE__AXIMP:
				return !getAximp().isEmpty();
			case NantPackage.PROJECT_TYPE__READREGISTRY:
				return !getReadregistry().isEmpty();
			case NantPackage.PROJECT_TYPE__REGASM:
				return !getRegasm().isEmpty();
			case NantPackage.PROJECT_TYPE__TLBEXP:
				return !getTlbexp().isEmpty();
			case NantPackage.PROJECT_TYPE__TLBIMP:
				return !getTlbimp().isEmpty();
			case NantPackage.PROJECT_TYPE__CL:
				return !getCl().isEmpty();
			case NantPackage.PROJECT_TYPE__LIB:
				return !getLib().isEmpty();
			case NantPackage.PROJECT_TYPE__LINK:
				return !getLink().isEmpty();
			case NantPackage.PROJECT_TYPE__MC:
				return !getMc().isEmpty();
			case NantPackage.PROJECT_TYPE__MIDL:
				return !getMidl().isEmpty();
			case NantPackage.PROJECT_TYPE__RC:
				return !getRc().isEmpty();
			case NantPackage.PROJECT_TYPE__SOLUTION:
				return !getSolution().isEmpty();
			case NantPackage.PROJECT_TYPE__TESTTASK:
				return !getTesttask().isEmpty();
			case NantPackage.PROJECT_TYPE__ELEMENT_TEST1:
				return !getElementTest1().isEmpty();
			case NantPackage.PROJECT_TYPE__TEST:
				return !getTest().isEmpty();
			case NantPackage.PROJECT_TYPE__ATTRIB:
				return !getAttrib().isEmpty();
			case NantPackage.PROJECT_TYPE__AVAILABLE:
				return !getAvailable().isEmpty();
			case NantPackage.PROJECT_TYPE__CALL:
				return !getCall().isEmpty();
			case NantPackage.PROJECT_TYPE__COPY:
				return !getCopy().isEmpty();
			case NantPackage.PROJECT_TYPE__DELETE:
				return !getDelete().isEmpty();
			case NantPackage.PROJECT_TYPE__DESCRIPTION:
				return !getDescription().isEmpty();
			case NantPackage.PROJECT_TYPE__ECHO:
				return !getEcho().isEmpty();
			case NantPackage.PROJECT_TYPE__EXEC:
				return !getExec().isEmpty();
			case NantPackage.PROJECT_TYPE__FAIL:
				return !getFail().isEmpty();
			case NantPackage.PROJECT_TYPE__GET:
				return !getGet().isEmpty();
			case NantPackage.PROJECT_TYPE__IF:
				return !getIf().isEmpty();
			case NantPackage.PROJECT_TYPE__IFNOT:
				return !getIfnot().isEmpty();
			case NantPackage.PROJECT_TYPE__INCLUDE:
				return !getInclude().isEmpty();
			case NantPackage.PROJECT_TYPE__LOADFILE:
				return !getLoadfile().isEmpty();
			case NantPackage.PROJECT_TYPE__LOADTASKS:
				return !getLoadtasks().isEmpty();
			case NantPackage.PROJECT_TYPE__FOREACH:
				return !getForeach().isEmpty();
			case NantPackage.PROJECT_TYPE__MAIL:
				return !getMail().isEmpty();
			case NantPackage.PROJECT_TYPE__MKDIR:
				return !getMkdir().isEmpty();
			case NantPackage.PROJECT_TYPE__MOVE:
				return !getMove().isEmpty();
			case NantPackage.PROJECT_TYPE__NANTSCHEMA:
				return !getNantschema().isEmpty();
			case NantPackage.PROJECT_TYPE__NANT:
				return !getNant().isEmpty();
			case NantPackage.PROJECT_TYPE__PROPERTY:
				return !getProperty().isEmpty();
			case NantPackage.PROJECT_TYPE__REGEX:
				return !getRegex().isEmpty();
			case NantPackage.PROJECT_TYPE__SETENV:
				return !getSetenv().isEmpty();
			case NantPackage.PROJECT_TYPE__SLEEP:
				return !getSleep().isEmpty();
			case NantPackage.PROJECT_TYPE__STYLE:
				return !getStyle().isEmpty();
			case NantPackage.PROJECT_TYPE__SYSINFO:
				return !getSysinfo().isEmpty();
			case NantPackage.PROJECT_TYPE__TSTAMP:
				return !getTstamp().isEmpty();
			case NantPackage.PROJECT_TYPE__TOUCH:
				return !getTouch().isEmpty();
			case NantPackage.PROJECT_TYPE__UPTODATE:
				return !getUptodate().isEmpty();
			case NantPackage.PROJECT_TYPE__XMLPEEK:
				return !getXmlpeek().isEmpty();
			case NantPackage.PROJECT_TYPE__XMLPOKE:
				return !getXmlpoke().isEmpty();
			case NantPackage.PROJECT_TYPE__ILDASM:
				return !getIldasm().isEmpty();
			case NantPackage.PROJECT_TYPE__SERVICECONTROLLER:
				return !getServicecontroller().isEmpty();
			case NantPackage.PROJECT_TYPE__ASSEMBLYFILESET:
				return !getAssemblyfileset().isEmpty();
			case NantPackage.PROJECT_TYPE__MODULESET:
				return !getModuleset().isEmpty();
			case NantPackage.PROJECT_TYPE__NAMESPACEIMPORTS:
				return !getNamespaceimports().isEmpty();
			case NantPackage.PROJECT_TYPE__RESOURCEFILESET:
				return !getResourcefileset().isEmpty();
			case NantPackage.PROJECT_TYPE__WARNASERROR:
				return !getWarnaserror().isEmpty();
			case NantPackage.PROJECT_TYPE__TARFILESET:
				return !getTarfileset().isEmpty();
			case NantPackage.PROJECT_TYPE__ZIPFILESET:
				return !getZipfileset().isEmpty();
			case NantPackage.PROJECT_TYPE__CATEGORIES:
				return !getCategories().isEmpty();
			case NantPackage.PROJECT_TYPE__CVSFILESET:
				return !getCvsfileset().isEmpty();
			case NantPackage.PROJECT_TYPE__FILTERCHAIN:
				return !getFilterchain().isEmpty();
			case NantPackage.PROJECT_TYPE__CREDENTIAL:
				return !getCredential().isEmpty();
			case NantPackage.PROJECT_TYPE__FILESET:
				return !getFileset().isEmpty();
			case NantPackage.PROJECT_TYPE__DIRSET:
				return !getDirset().isEmpty();
			case NantPackage.PROJECT_TYPE__PATH:
				return !getPath().isEmpty();
			case NantPackage.PROJECT_TYPE__PATTERNSET:
				return !getPatternset().isEmpty();
			case NantPackage.PROJECT_TYPE__PROXY:
				return !getProxy().isEmpty();
			case NantPackage.PROJECT_TYPE__TARGET:
				return !getTarget().isEmpty();
			case NantPackage.PROJECT_TYPE__ANY:
				return !getAny().isEmpty();
			case NantPackage.PROJECT_TYPE__BASEDIR:
				return BASEDIR_EDEFAULT == null ? basedir != null : !BASEDIR_EDEFAULT.equals(basedir);
			case NantPackage.PROJECT_TYPE__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case NantPackage.PROJECT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", basedir: ");
		result.append(basedir);
		result.append(", default: ");
		result.append(default_);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ProjectTypeImpl
