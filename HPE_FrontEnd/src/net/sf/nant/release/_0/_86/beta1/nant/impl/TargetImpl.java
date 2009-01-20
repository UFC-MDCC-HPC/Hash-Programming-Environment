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
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getAsminfo <em>Asminfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getAl <em>Al</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCsc <em>Csc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getDelaySign <em>Delay Sign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getIlasm <em>Ilasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getJsc <em>Jsc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getLicense <em>License</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getNdoc <em>Ndoc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getRegsvcs <em>Regsvcs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getResgen <em>Resgen</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getScript <em>Script</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getVbc <em>Vbc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getVjc <em>Vjc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getGunzip <em>Gunzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTar <em>Tar</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getUnzip <em>Unzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getZip <em>Zip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getNunit <em>Nunit</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getNunit2 <em>Nunit2</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsChangelog <em>Cvs Changelog</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsCheckout <em>Cvs Checkout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsPass <em>Cvs Pass</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvs <em>Cvs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsExport <em>Cvs Export</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsRtag <em>Cvs Rtag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsTag <em>Cvs Tag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsUpdate <em>Cvs Update</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getAximp <em>Aximp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getReadregistry <em>Readregistry</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getRegasm <em>Regasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTlbexp <em>Tlbexp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTlbimp <em>Tlbimp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCl <em>Cl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getLib <em>Lib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getLink <em>Link</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getMc <em>Mc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getMidl <em>Midl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getRc <em>Rc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getSolution <em>Solution</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTesttask <em>Testtask</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getElementTest1 <em>Element Test1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTest <em>Test</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getAttrib <em>Attrib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getAvailable <em>Available</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCall <em>Call</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCopy <em>Copy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getDelete <em>Delete</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getEcho <em>Echo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getExec <em>Exec</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getFail <em>Fail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getGet <em>Get</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getIfnot <em>Ifnot</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getLoadfile <em>Loadfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getLoadtasks <em>Loadtasks</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getForeach <em>Foreach</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getMail <em>Mail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getMkdir <em>Mkdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getMove <em>Move</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getNantschema <em>Nantschema</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getNant <em>Nant</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getSetenv <em>Setenv</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getSleep <em>Sleep</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getSysinfo <em>Sysinfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTstamp <em>Tstamp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTouch <em>Touch</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getUptodate <em>Uptodate</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getXmlpeek <em>Xmlpeek</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getXmlpoke <em>Xmlpoke</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getIldasm <em>Ildasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getServicecontroller <em>Servicecontroller</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getAssemblyfileset <em>Assemblyfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getModuleset <em>Moduleset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getNamespaceimports <em>Namespaceimports</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getResourcefileset <em>Resourcefileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getWarnaserror <em>Warnaserror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getTarfileset <em>Tarfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getZipfileset <em>Zipfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCvsfileset <em>Cvsfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getFilterchain <em>Filterchain</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getCredential <em>Credential</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getDirset <em>Dirset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getPath <em>Path</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getPatternset <em>Patternset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getProxy <em>Proxy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getAny <em>Any</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getIf1 <em>If1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.TargetImpl#getUnless <em>Unless</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetImpl extends EObjectImpl implements Target {
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
	 * The default value of the '{@link #getDepends() <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEPENDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepends() <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected Object depends = DEPENDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected static final Object DESCRIPTION1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription1() <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected Object description1 = DESCRIPTION1_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.TARGET__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksAssemblyInfoTask> getAsminfo() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Asminfo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksAssemblyLinkerTask> getAl() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Al());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksCscTask> getCsc() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Csc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksDelaySignTask> getDelaySign() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_DelaySign());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksIlasmTask> getIlasm() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Ilasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksJscTask> getJsc() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Jsc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksLicenseTask> getLicense() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_License());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksNDocTask> getNdoc() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Ndoc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksRegsvcsTask> getRegsvcs() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Regsvcs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksResGenTask> getResgen() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Resgen());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksScriptTask> getScript() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Script());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksVbcTask> getVbc() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Vbc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTasksVjcTask> getVjc() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Vjc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksGUnzip> getGunzip() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Gunzip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksTarTask> getTar() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Tar());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksUnZipTask> getUnzip() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Unzip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTasksZipTask> getZip() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Zip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit1TasksNUnitTask> getNunit() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Nunit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit2TasksNUnit2Task> getNunit2() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Nunit2());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksChangeLogTask> getCvsChangelog() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_CvsChangelog());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCheckoutTask> getCvsCheckout() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_CvsCheckout());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCvsPass> getCvsPass() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_CvsPass());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksCvsTask> getCvs() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Cvs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksExportTask> getCvsExport() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_CvsExport());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksRTagTask> getCvsRtag() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_CvsRtag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksTagTask> getCvsTag() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_CvsTag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTasksUpdateTask> getCvsUpdate() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_CvsUpdate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksAxImpTask> getAximp() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Aximp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksReadRegistryTask> getReadregistry() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Readregistry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksRegAsmTask> getRegasm() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Regasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksTlbExpTask> getTlbexp() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Tlbexp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntWin32TasksTlbImpTask> getTlbimp() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Tlbimp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksClTask> getCl() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Cl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksLibTask> getLib() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Lib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksLinkTask> getLink() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Link());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksMcTask> getMc() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Mc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksMidlTask> getMidl() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Midl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVisualCppTasksRcTask> getRc() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Rc());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntVSNetTasksSolutionTask> getSolution() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Solution());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreUtilXmlLoggerTestTestTask> getTesttask() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Testtask());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreElementTest1Task> getElementTest1() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_ElementTest1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsNAntCoreTestTask> getTest() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Test());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksAttribTask> getAttrib() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Attrib());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksAvailableTask> getAvailable() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Available());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksCallTask> getCall() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Call());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksCopyTask> getCopy() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Copy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksDeleteTask> getDelete() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Delete());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksDescriptionTask> getDescription() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksEchoTask> getEcho() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Echo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksExecTask> getExec() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Exec());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksFailTask> getFail() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Fail());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksGetTask> getGet() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Get());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIfTask> getIf() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_If());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIfNotTask> getIfnot() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Ifnot());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksIncludeTask> getInclude() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Include());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoadFileTask> getLoadfile() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Loadfile());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoadTasksTask> getLoadtasks() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Loadtasks());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksLoopTask> getForeach() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Foreach());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMailTask> getMail() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Mail());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMkDirTask> getMkdir() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Mkdir());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksMoveTask> getMove() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Move());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksNAntSchemaTask> getNantschema() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Nantschema());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksNAntTask> getNant() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Nant());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksPropertyTask> getProperty() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Property());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksRegexTask> getRegex() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Regex());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSetEnvTask> getSetenv() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Setenv());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSleepTask> getSleep() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Sleep());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksStyleTask> getStyle() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Style());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksSysInfoTask> getSysinfo() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Sysinfo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksTStampTask> getTstamp() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Tstamp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksTouchTask> getTouch() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Touch());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksUpToDateTask> getUptodate() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Uptodate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksXmlPeekTask> getXmlpeek() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Xmlpeek());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTasksXmlPokeTask> getXmlpoke() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Xmlpoke());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntMSNetTasksIldasmTask> getIldasm() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Ildasm());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntMSNetTasksServiceControllerTask> getServicecontroller() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Servicecontroller());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getAssemblyfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Assemblyfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesModuleSet> getModuleset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Moduleset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesNamespaceImportCollection> getNamespaceimports() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Namespaceimports());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesResourceFileSet> getResourcefileset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Resourcefileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesWarningAsError> getWarnaserror() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Warnaserror());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTypesTarFileSet> getTarfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Tarfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTypesZipFileSet> getZipfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Zipfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit2TypesCategories> getCategories() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Categories());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTypesCvsFileSet> getCvsfileset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Cvsfileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreFiltersFilterChain> getFilterchain() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Filterchain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesCredential> getCredential() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Credential());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getFileset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Fileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesDirSet> getDirset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Dirset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesPathSet> getPath() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Path());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesPatternSet> getPatternset() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Patternset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesProxy> getProxy() {
		return getGroup().list(NantPackage.eINSTANCE.getTarget_Proxy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(NantPackage.eINSTANCE.getTarget_Any());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDepends() {
		return depends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepends(Object newDepends) {
		Object oldDepends = depends;
		depends = newDepends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.TARGET__DEPENDS, oldDepends, depends));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDescription1() {
		return description1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription1(Object newDescription1) {
		Object oldDescription1 = description1;
		description1 = newDescription1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.TARGET__DESCRIPTION1, oldDescription1, description1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.TARGET__IF1, oldIf1, if1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.TARGET__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.TARGET__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NantPackage.TARGET__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ASMINFO:
				return ((InternalEList<?>)getAsminfo()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__AL:
				return ((InternalEList<?>)getAl()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CSC:
				return ((InternalEList<?>)getCsc()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__DELAY_SIGN:
				return ((InternalEList<?>)getDelaySign()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ILASM:
				return ((InternalEList<?>)getIlasm()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__JSC:
				return ((InternalEList<?>)getJsc()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__LICENSE:
				return ((InternalEList<?>)getLicense()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__NDOC:
				return ((InternalEList<?>)getNdoc()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__REGSVCS:
				return ((InternalEList<?>)getRegsvcs()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__RESGEN:
				return ((InternalEList<?>)getResgen()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__SCRIPT:
				return ((InternalEList<?>)getScript()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__VBC:
				return ((InternalEList<?>)getVbc()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__VJC:
				return ((InternalEList<?>)getVjc()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__GUNZIP:
				return ((InternalEList<?>)getGunzip()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TAR:
				return ((InternalEList<?>)getTar()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__UNZIP:
				return ((InternalEList<?>)getUnzip()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ZIP:
				return ((InternalEList<?>)getZip()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__NUNIT:
				return ((InternalEList<?>)getNunit()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__NUNIT2:
				return ((InternalEList<?>)getNunit2()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS_CHANGELOG:
				return ((InternalEList<?>)getCvsChangelog()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS_CHECKOUT:
				return ((InternalEList<?>)getCvsCheckout()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS_PASS:
				return ((InternalEList<?>)getCvsPass()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS:
				return ((InternalEList<?>)getCvs()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS_EXPORT:
				return ((InternalEList<?>)getCvsExport()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS_RTAG:
				return ((InternalEList<?>)getCvsRtag()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS_TAG:
				return ((InternalEList<?>)getCvsTag()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVS_UPDATE:
				return ((InternalEList<?>)getCvsUpdate()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__AXIMP:
				return ((InternalEList<?>)getAximp()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__READREGISTRY:
				return ((InternalEList<?>)getReadregistry()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__REGASM:
				return ((InternalEList<?>)getRegasm()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TLBEXP:
				return ((InternalEList<?>)getTlbexp()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TLBIMP:
				return ((InternalEList<?>)getTlbimp()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CL:
				return ((InternalEList<?>)getCl()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__LIB:
				return ((InternalEList<?>)getLib()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__MC:
				return ((InternalEList<?>)getMc()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__MIDL:
				return ((InternalEList<?>)getMidl()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__RC:
				return ((InternalEList<?>)getRc()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__SOLUTION:
				return ((InternalEList<?>)getSolution()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TESTTASK:
				return ((InternalEList<?>)getTesttask()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ELEMENT_TEST1:
				return ((InternalEList<?>)getElementTest1()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TEST:
				return ((InternalEList<?>)getTest()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ATTRIB:
				return ((InternalEList<?>)getAttrib()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__AVAILABLE:
				return ((InternalEList<?>)getAvailable()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CALL:
				return ((InternalEList<?>)getCall()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__COPY:
				return ((InternalEList<?>)getCopy()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__DELETE:
				return ((InternalEList<?>)getDelete()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ECHO:
				return ((InternalEList<?>)getEcho()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__EXEC:
				return ((InternalEList<?>)getExec()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__FAIL:
				return ((InternalEList<?>)getFail()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__GET:
				return ((InternalEList<?>)getGet()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__IF:
				return ((InternalEList<?>)getIf()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__IFNOT:
				return ((InternalEList<?>)getIfnot()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__INCLUDE:
				return ((InternalEList<?>)getInclude()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__LOADFILE:
				return ((InternalEList<?>)getLoadfile()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__LOADTASKS:
				return ((InternalEList<?>)getLoadtasks()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__FOREACH:
				return ((InternalEList<?>)getForeach()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__MAIL:
				return ((InternalEList<?>)getMail()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__MKDIR:
				return ((InternalEList<?>)getMkdir()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__MOVE:
				return ((InternalEList<?>)getMove()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__NANTSCHEMA:
				return ((InternalEList<?>)getNantschema()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__NANT:
				return ((InternalEList<?>)getNant()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__REGEX:
				return ((InternalEList<?>)getRegex()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__SETENV:
				return ((InternalEList<?>)getSetenv()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__SLEEP:
				return ((InternalEList<?>)getSleep()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__STYLE:
				return ((InternalEList<?>)getStyle()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__SYSINFO:
				return ((InternalEList<?>)getSysinfo()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TSTAMP:
				return ((InternalEList<?>)getTstamp()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TOUCH:
				return ((InternalEList<?>)getTouch()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__UPTODATE:
				return ((InternalEList<?>)getUptodate()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__XMLPEEK:
				return ((InternalEList<?>)getXmlpeek()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__XMLPOKE:
				return ((InternalEList<?>)getXmlpoke()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ILDASM:
				return ((InternalEList<?>)getIldasm()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__SERVICECONTROLLER:
				return ((InternalEList<?>)getServicecontroller()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ASSEMBLYFILESET:
				return ((InternalEList<?>)getAssemblyfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__MODULESET:
				return ((InternalEList<?>)getModuleset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__NAMESPACEIMPORTS:
				return ((InternalEList<?>)getNamespaceimports()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__RESOURCEFILESET:
				return ((InternalEList<?>)getResourcefileset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__WARNASERROR:
				return ((InternalEList<?>)getWarnaserror()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__TARFILESET:
				return ((InternalEList<?>)getTarfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ZIPFILESET:
				return ((InternalEList<?>)getZipfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CVSFILESET:
				return ((InternalEList<?>)getCvsfileset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__FILTERCHAIN:
				return ((InternalEList<?>)getFilterchain()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__CREDENTIAL:
				return ((InternalEList<?>)getCredential()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__FILESET:
				return ((InternalEList<?>)getFileset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__DIRSET:
				return ((InternalEList<?>)getDirset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__PATH:
				return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__PATTERNSET:
				return ((InternalEList<?>)getPatternset()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__PROXY:
				return ((InternalEList<?>)getProxy()).basicRemove(otherEnd, msgs);
			case NantPackage.TARGET__ANY:
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
			case NantPackage.TARGET__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.TARGET__ASMINFO:
				return getAsminfo();
			case NantPackage.TARGET__AL:
				return getAl();
			case NantPackage.TARGET__CSC:
				return getCsc();
			case NantPackage.TARGET__DELAY_SIGN:
				return getDelaySign();
			case NantPackage.TARGET__ILASM:
				return getIlasm();
			case NantPackage.TARGET__JSC:
				return getJsc();
			case NantPackage.TARGET__LICENSE:
				return getLicense();
			case NantPackage.TARGET__NDOC:
				return getNdoc();
			case NantPackage.TARGET__REGSVCS:
				return getRegsvcs();
			case NantPackage.TARGET__RESGEN:
				return getResgen();
			case NantPackage.TARGET__SCRIPT:
				return getScript();
			case NantPackage.TARGET__VBC:
				return getVbc();
			case NantPackage.TARGET__VJC:
				return getVjc();
			case NantPackage.TARGET__GUNZIP:
				return getGunzip();
			case NantPackage.TARGET__TAR:
				return getTar();
			case NantPackage.TARGET__UNZIP:
				return getUnzip();
			case NantPackage.TARGET__ZIP:
				return getZip();
			case NantPackage.TARGET__NUNIT:
				return getNunit();
			case NantPackage.TARGET__NUNIT2:
				return getNunit2();
			case NantPackage.TARGET__CVS_CHANGELOG:
				return getCvsChangelog();
			case NantPackage.TARGET__CVS_CHECKOUT:
				return getCvsCheckout();
			case NantPackage.TARGET__CVS_PASS:
				return getCvsPass();
			case NantPackage.TARGET__CVS:
				return getCvs();
			case NantPackage.TARGET__CVS_EXPORT:
				return getCvsExport();
			case NantPackage.TARGET__CVS_RTAG:
				return getCvsRtag();
			case NantPackage.TARGET__CVS_TAG:
				return getCvsTag();
			case NantPackage.TARGET__CVS_UPDATE:
				return getCvsUpdate();
			case NantPackage.TARGET__AXIMP:
				return getAximp();
			case NantPackage.TARGET__READREGISTRY:
				return getReadregistry();
			case NantPackage.TARGET__REGASM:
				return getRegasm();
			case NantPackage.TARGET__TLBEXP:
				return getTlbexp();
			case NantPackage.TARGET__TLBIMP:
				return getTlbimp();
			case NantPackage.TARGET__CL:
				return getCl();
			case NantPackage.TARGET__LIB:
				return getLib();
			case NantPackage.TARGET__LINK:
				return getLink();
			case NantPackage.TARGET__MC:
				return getMc();
			case NantPackage.TARGET__MIDL:
				return getMidl();
			case NantPackage.TARGET__RC:
				return getRc();
			case NantPackage.TARGET__SOLUTION:
				return getSolution();
			case NantPackage.TARGET__TESTTASK:
				return getTesttask();
			case NantPackage.TARGET__ELEMENT_TEST1:
				return getElementTest1();
			case NantPackage.TARGET__TEST:
				return getTest();
			case NantPackage.TARGET__ATTRIB:
				return getAttrib();
			case NantPackage.TARGET__AVAILABLE:
				return getAvailable();
			case NantPackage.TARGET__CALL:
				return getCall();
			case NantPackage.TARGET__COPY:
				return getCopy();
			case NantPackage.TARGET__DELETE:
				return getDelete();
			case NantPackage.TARGET__DESCRIPTION:
				return getDescription();
			case NantPackage.TARGET__ECHO:
				return getEcho();
			case NantPackage.TARGET__EXEC:
				return getExec();
			case NantPackage.TARGET__FAIL:
				return getFail();
			case NantPackage.TARGET__GET:
				return getGet();
			case NantPackage.TARGET__IF:
				return getIf();
			case NantPackage.TARGET__IFNOT:
				return getIfnot();
			case NantPackage.TARGET__INCLUDE:
				return getInclude();
			case NantPackage.TARGET__LOADFILE:
				return getLoadfile();
			case NantPackage.TARGET__LOADTASKS:
				return getLoadtasks();
			case NantPackage.TARGET__FOREACH:
				return getForeach();
			case NantPackage.TARGET__MAIL:
				return getMail();
			case NantPackage.TARGET__MKDIR:
				return getMkdir();
			case NantPackage.TARGET__MOVE:
				return getMove();
			case NantPackage.TARGET__NANTSCHEMA:
				return getNantschema();
			case NantPackage.TARGET__NANT:
				return getNant();
			case NantPackage.TARGET__PROPERTY:
				return getProperty();
			case NantPackage.TARGET__REGEX:
				return getRegex();
			case NantPackage.TARGET__SETENV:
				return getSetenv();
			case NantPackage.TARGET__SLEEP:
				return getSleep();
			case NantPackage.TARGET__STYLE:
				return getStyle();
			case NantPackage.TARGET__SYSINFO:
				return getSysinfo();
			case NantPackage.TARGET__TSTAMP:
				return getTstamp();
			case NantPackage.TARGET__TOUCH:
				return getTouch();
			case NantPackage.TARGET__UPTODATE:
				return getUptodate();
			case NantPackage.TARGET__XMLPEEK:
				return getXmlpeek();
			case NantPackage.TARGET__XMLPOKE:
				return getXmlpoke();
			case NantPackage.TARGET__ILDASM:
				return getIldasm();
			case NantPackage.TARGET__SERVICECONTROLLER:
				return getServicecontroller();
			case NantPackage.TARGET__ASSEMBLYFILESET:
				return getAssemblyfileset();
			case NantPackage.TARGET__MODULESET:
				return getModuleset();
			case NantPackage.TARGET__NAMESPACEIMPORTS:
				return getNamespaceimports();
			case NantPackage.TARGET__RESOURCEFILESET:
				return getResourcefileset();
			case NantPackage.TARGET__WARNASERROR:
				return getWarnaserror();
			case NantPackage.TARGET__TARFILESET:
				return getTarfileset();
			case NantPackage.TARGET__ZIPFILESET:
				return getZipfileset();
			case NantPackage.TARGET__CATEGORIES:
				return getCategories();
			case NantPackage.TARGET__CVSFILESET:
				return getCvsfileset();
			case NantPackage.TARGET__FILTERCHAIN:
				return getFilterchain();
			case NantPackage.TARGET__CREDENTIAL:
				return getCredential();
			case NantPackage.TARGET__FILESET:
				return getFileset();
			case NantPackage.TARGET__DIRSET:
				return getDirset();
			case NantPackage.TARGET__PATH:
				return getPath();
			case NantPackage.TARGET__PATTERNSET:
				return getPatternset();
			case NantPackage.TARGET__PROXY:
				return getProxy();
			case NantPackage.TARGET__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case NantPackage.TARGET__DEPENDS:
				return getDepends();
			case NantPackage.TARGET__DESCRIPTION1:
				return getDescription1();
			case NantPackage.TARGET__IF1:
				return getIf1();
			case NantPackage.TARGET__NAME:
				return getName();
			case NantPackage.TARGET__UNLESS:
				return getUnless();
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
			case NantPackage.TARGET__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.TARGET__ASMINFO:
				getAsminfo().clear();
				getAsminfo().addAll((Collection<? extends NAntDotNetTasksAssemblyInfoTask>)newValue);
				return;
			case NantPackage.TARGET__AL:
				getAl().clear();
				getAl().addAll((Collection<? extends NAntDotNetTasksAssemblyLinkerTask>)newValue);
				return;
			case NantPackage.TARGET__CSC:
				getCsc().clear();
				getCsc().addAll((Collection<? extends NAntDotNetTasksCscTask>)newValue);
				return;
			case NantPackage.TARGET__DELAY_SIGN:
				getDelaySign().clear();
				getDelaySign().addAll((Collection<? extends NAntDotNetTasksDelaySignTask>)newValue);
				return;
			case NantPackage.TARGET__ILASM:
				getIlasm().clear();
				getIlasm().addAll((Collection<? extends NAntDotNetTasksIlasmTask>)newValue);
				return;
			case NantPackage.TARGET__JSC:
				getJsc().clear();
				getJsc().addAll((Collection<? extends NAntDotNetTasksJscTask>)newValue);
				return;
			case NantPackage.TARGET__LICENSE:
				getLicense().clear();
				getLicense().addAll((Collection<? extends NAntDotNetTasksLicenseTask>)newValue);
				return;
			case NantPackage.TARGET__NDOC:
				getNdoc().clear();
				getNdoc().addAll((Collection<? extends NAntDotNetTasksNDocTask>)newValue);
				return;
			case NantPackage.TARGET__REGSVCS:
				getRegsvcs().clear();
				getRegsvcs().addAll((Collection<? extends NAntDotNetTasksRegsvcsTask>)newValue);
				return;
			case NantPackage.TARGET__RESGEN:
				getResgen().clear();
				getResgen().addAll((Collection<? extends NAntDotNetTasksResGenTask>)newValue);
				return;
			case NantPackage.TARGET__SCRIPT:
				getScript().clear();
				getScript().addAll((Collection<? extends NAntDotNetTasksScriptTask>)newValue);
				return;
			case NantPackage.TARGET__VBC:
				getVbc().clear();
				getVbc().addAll((Collection<? extends NAntDotNetTasksVbcTask>)newValue);
				return;
			case NantPackage.TARGET__VJC:
				getVjc().clear();
				getVjc().addAll((Collection<? extends NAntDotNetTasksVjcTask>)newValue);
				return;
			case NantPackage.TARGET__GUNZIP:
				getGunzip().clear();
				getGunzip().addAll((Collection<? extends NAntCompressionTasksGUnzip>)newValue);
				return;
			case NantPackage.TARGET__TAR:
				getTar().clear();
				getTar().addAll((Collection<? extends NAntCompressionTasksTarTask>)newValue);
				return;
			case NantPackage.TARGET__UNZIP:
				getUnzip().clear();
				getUnzip().addAll((Collection<? extends NAntCompressionTasksUnZipTask>)newValue);
				return;
			case NantPackage.TARGET__ZIP:
				getZip().clear();
				getZip().addAll((Collection<? extends NAntCompressionTasksZipTask>)newValue);
				return;
			case NantPackage.TARGET__NUNIT:
				getNunit().clear();
				getNunit().addAll((Collection<? extends NAntNUnit1TasksNUnitTask>)newValue);
				return;
			case NantPackage.TARGET__NUNIT2:
				getNunit2().clear();
				getNunit2().addAll((Collection<? extends NAntNUnit2TasksNUnit2Task>)newValue);
				return;
			case NantPackage.TARGET__CVS_CHANGELOG:
				getCvsChangelog().clear();
				getCvsChangelog().addAll((Collection<? extends NAntSourceControlTasksChangeLogTask>)newValue);
				return;
			case NantPackage.TARGET__CVS_CHECKOUT:
				getCvsCheckout().clear();
				getCvsCheckout().addAll((Collection<? extends NAntSourceControlTasksCheckoutTask>)newValue);
				return;
			case NantPackage.TARGET__CVS_PASS:
				getCvsPass().clear();
				getCvsPass().addAll((Collection<? extends NAntSourceControlTasksCvsPass>)newValue);
				return;
			case NantPackage.TARGET__CVS:
				getCvs().clear();
				getCvs().addAll((Collection<? extends NAntSourceControlTasksCvsTask>)newValue);
				return;
			case NantPackage.TARGET__CVS_EXPORT:
				getCvsExport().clear();
				getCvsExport().addAll((Collection<? extends NAntSourceControlTasksExportTask>)newValue);
				return;
			case NantPackage.TARGET__CVS_RTAG:
				getCvsRtag().clear();
				getCvsRtag().addAll((Collection<? extends NAntSourceControlTasksRTagTask>)newValue);
				return;
			case NantPackage.TARGET__CVS_TAG:
				getCvsTag().clear();
				getCvsTag().addAll((Collection<? extends NAntSourceControlTasksTagTask>)newValue);
				return;
			case NantPackage.TARGET__CVS_UPDATE:
				getCvsUpdate().clear();
				getCvsUpdate().addAll((Collection<? extends NAntSourceControlTasksUpdateTask>)newValue);
				return;
			case NantPackage.TARGET__AXIMP:
				getAximp().clear();
				getAximp().addAll((Collection<? extends NAntWin32TasksAxImpTask>)newValue);
				return;
			case NantPackage.TARGET__READREGISTRY:
				getReadregistry().clear();
				getReadregistry().addAll((Collection<? extends NAntWin32TasksReadRegistryTask>)newValue);
				return;
			case NantPackage.TARGET__REGASM:
				getRegasm().clear();
				getRegasm().addAll((Collection<? extends NAntWin32TasksRegAsmTask>)newValue);
				return;
			case NantPackage.TARGET__TLBEXP:
				getTlbexp().clear();
				getTlbexp().addAll((Collection<? extends NAntWin32TasksTlbExpTask>)newValue);
				return;
			case NantPackage.TARGET__TLBIMP:
				getTlbimp().clear();
				getTlbimp().addAll((Collection<? extends NAntWin32TasksTlbImpTask>)newValue);
				return;
			case NantPackage.TARGET__CL:
				getCl().clear();
				getCl().addAll((Collection<? extends NAntVisualCppTasksClTask>)newValue);
				return;
			case NantPackage.TARGET__LIB:
				getLib().clear();
				getLib().addAll((Collection<? extends NAntVisualCppTasksLibTask>)newValue);
				return;
			case NantPackage.TARGET__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends NAntVisualCppTasksLinkTask>)newValue);
				return;
			case NantPackage.TARGET__MC:
				getMc().clear();
				getMc().addAll((Collection<? extends NAntVisualCppTasksMcTask>)newValue);
				return;
			case NantPackage.TARGET__MIDL:
				getMidl().clear();
				getMidl().addAll((Collection<? extends NAntVisualCppTasksMidlTask>)newValue);
				return;
			case NantPackage.TARGET__RC:
				getRc().clear();
				getRc().addAll((Collection<? extends NAntVisualCppTasksRcTask>)newValue);
				return;
			case NantPackage.TARGET__SOLUTION:
				getSolution().clear();
				getSolution().addAll((Collection<? extends NAntVSNetTasksSolutionTask>)newValue);
				return;
			case NantPackage.TARGET__TESTTASK:
				getTesttask().clear();
				getTesttask().addAll((Collection<? extends TestsNAntCoreUtilXmlLoggerTestTestTask>)newValue);
				return;
			case NantPackage.TARGET__ELEMENT_TEST1:
				getElementTest1().clear();
				getElementTest1().addAll((Collection<? extends TestsNAntCoreElementTest1Task>)newValue);
				return;
			case NantPackage.TARGET__TEST:
				getTest().clear();
				getTest().addAll((Collection<? extends TestsNAntCoreTestTask>)newValue);
				return;
			case NantPackage.TARGET__ATTRIB:
				getAttrib().clear();
				getAttrib().addAll((Collection<? extends NAntCoreTasksAttribTask>)newValue);
				return;
			case NantPackage.TARGET__AVAILABLE:
				getAvailable().clear();
				getAvailable().addAll((Collection<? extends NAntCoreTasksAvailableTask>)newValue);
				return;
			case NantPackage.TARGET__CALL:
				getCall().clear();
				getCall().addAll((Collection<? extends NAntCoreTasksCallTask>)newValue);
				return;
			case NantPackage.TARGET__COPY:
				getCopy().clear();
				getCopy().addAll((Collection<? extends NAntCoreTasksCopyTask>)newValue);
				return;
			case NantPackage.TARGET__DELETE:
				getDelete().clear();
				getDelete().addAll((Collection<? extends NAntCoreTasksDeleteTask>)newValue);
				return;
			case NantPackage.TARGET__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends NAntCoreTasksDescriptionTask>)newValue);
				return;
			case NantPackage.TARGET__ECHO:
				getEcho().clear();
				getEcho().addAll((Collection<? extends NAntCoreTasksEchoTask>)newValue);
				return;
			case NantPackage.TARGET__EXEC:
				getExec().clear();
				getExec().addAll((Collection<? extends NAntCoreTasksExecTask>)newValue);
				return;
			case NantPackage.TARGET__FAIL:
				getFail().clear();
				getFail().addAll((Collection<? extends NAntCoreTasksFailTask>)newValue);
				return;
			case NantPackage.TARGET__GET:
				getGet().clear();
				getGet().addAll((Collection<? extends NAntCoreTasksGetTask>)newValue);
				return;
			case NantPackage.TARGET__IF:
				getIf().clear();
				getIf().addAll((Collection<? extends NAntCoreTasksIfTask>)newValue);
				return;
			case NantPackage.TARGET__IFNOT:
				getIfnot().clear();
				getIfnot().addAll((Collection<? extends NAntCoreTasksIfNotTask>)newValue);
				return;
			case NantPackage.TARGET__INCLUDE:
				getInclude().clear();
				getInclude().addAll((Collection<? extends NAntCoreTasksIncludeTask>)newValue);
				return;
			case NantPackage.TARGET__LOADFILE:
				getLoadfile().clear();
				getLoadfile().addAll((Collection<? extends NAntCoreTasksLoadFileTask>)newValue);
				return;
			case NantPackage.TARGET__LOADTASKS:
				getLoadtasks().clear();
				getLoadtasks().addAll((Collection<? extends NAntCoreTasksLoadTasksTask>)newValue);
				return;
			case NantPackage.TARGET__FOREACH:
				getForeach().clear();
				getForeach().addAll((Collection<? extends NAntCoreTasksLoopTask>)newValue);
				return;
			case NantPackage.TARGET__MAIL:
				getMail().clear();
				getMail().addAll((Collection<? extends NAntCoreTasksMailTask>)newValue);
				return;
			case NantPackage.TARGET__MKDIR:
				getMkdir().clear();
				getMkdir().addAll((Collection<? extends NAntCoreTasksMkDirTask>)newValue);
				return;
			case NantPackage.TARGET__MOVE:
				getMove().clear();
				getMove().addAll((Collection<? extends NAntCoreTasksMoveTask>)newValue);
				return;
			case NantPackage.TARGET__NANTSCHEMA:
				getNantschema().clear();
				getNantschema().addAll((Collection<? extends NAntCoreTasksNAntSchemaTask>)newValue);
				return;
			case NantPackage.TARGET__NANT:
				getNant().clear();
				getNant().addAll((Collection<? extends NAntCoreTasksNAntTask>)newValue);
				return;
			case NantPackage.TARGET__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends NAntCoreTasksPropertyTask>)newValue);
				return;
			case NantPackage.TARGET__REGEX:
				getRegex().clear();
				getRegex().addAll((Collection<? extends NAntCoreTasksRegexTask>)newValue);
				return;
			case NantPackage.TARGET__SETENV:
				getSetenv().clear();
				getSetenv().addAll((Collection<? extends NAntCoreTasksSetEnvTask>)newValue);
				return;
			case NantPackage.TARGET__SLEEP:
				getSleep().clear();
				getSleep().addAll((Collection<? extends NAntCoreTasksSleepTask>)newValue);
				return;
			case NantPackage.TARGET__STYLE:
				getStyle().clear();
				getStyle().addAll((Collection<? extends NAntCoreTasksStyleTask>)newValue);
				return;
			case NantPackage.TARGET__SYSINFO:
				getSysinfo().clear();
				getSysinfo().addAll((Collection<? extends NAntCoreTasksSysInfoTask>)newValue);
				return;
			case NantPackage.TARGET__TSTAMP:
				getTstamp().clear();
				getTstamp().addAll((Collection<? extends NAntCoreTasksTStampTask>)newValue);
				return;
			case NantPackage.TARGET__TOUCH:
				getTouch().clear();
				getTouch().addAll((Collection<? extends NAntCoreTasksTouchTask>)newValue);
				return;
			case NantPackage.TARGET__UPTODATE:
				getUptodate().clear();
				getUptodate().addAll((Collection<? extends NAntCoreTasksUpToDateTask>)newValue);
				return;
			case NantPackage.TARGET__XMLPEEK:
				getXmlpeek().clear();
				getXmlpeek().addAll((Collection<? extends NAntCoreTasksXmlPeekTask>)newValue);
				return;
			case NantPackage.TARGET__XMLPOKE:
				getXmlpoke().clear();
				getXmlpoke().addAll((Collection<? extends NAntCoreTasksXmlPokeTask>)newValue);
				return;
			case NantPackage.TARGET__ILDASM:
				getIldasm().clear();
				getIldasm().addAll((Collection<? extends NAntMSNetTasksIldasmTask>)newValue);
				return;
			case NantPackage.TARGET__SERVICECONTROLLER:
				getServicecontroller().clear();
				getServicecontroller().addAll((Collection<? extends NAntMSNetTasksServiceControllerTask>)newValue);
				return;
			case NantPackage.TARGET__ASSEMBLYFILESET:
				getAssemblyfileset().clear();
				getAssemblyfileset().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.TARGET__MODULESET:
				getModuleset().clear();
				getModuleset().addAll((Collection<? extends NAntDotNetTypesModuleSet>)newValue);
				return;
			case NantPackage.TARGET__NAMESPACEIMPORTS:
				getNamespaceimports().clear();
				getNamespaceimports().addAll((Collection<? extends NAntDotNetTypesNamespaceImportCollection>)newValue);
				return;
			case NantPackage.TARGET__RESOURCEFILESET:
				getResourcefileset().clear();
				getResourcefileset().addAll((Collection<? extends NAntDotNetTypesResourceFileSet>)newValue);
				return;
			case NantPackage.TARGET__WARNASERROR:
				getWarnaserror().clear();
				getWarnaserror().addAll((Collection<? extends NAntDotNetTypesWarningAsError>)newValue);
				return;
			case NantPackage.TARGET__TARFILESET:
				getTarfileset().clear();
				getTarfileset().addAll((Collection<? extends NAntCompressionTypesTarFileSet>)newValue);
				return;
			case NantPackage.TARGET__ZIPFILESET:
				getZipfileset().clear();
				getZipfileset().addAll((Collection<? extends NAntCompressionTypesZipFileSet>)newValue);
				return;
			case NantPackage.TARGET__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends NAntNUnit2TypesCategories>)newValue);
				return;
			case NantPackage.TARGET__CVSFILESET:
				getCvsfileset().clear();
				getCvsfileset().addAll((Collection<? extends NAntSourceControlTypesCvsFileSet>)newValue);
				return;
			case NantPackage.TARGET__FILTERCHAIN:
				getFilterchain().clear();
				getFilterchain().addAll((Collection<? extends NAntCoreFiltersFilterChain>)newValue);
				return;
			case NantPackage.TARGET__CREDENTIAL:
				getCredential().clear();
				getCredential().addAll((Collection<? extends NAntCoreTypesCredential>)newValue);
				return;
			case NantPackage.TARGET__FILESET:
				getFileset().clear();
				getFileset().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.TARGET__DIRSET:
				getDirset().clear();
				getDirset().addAll((Collection<? extends NAntCoreTypesDirSet>)newValue);
				return;
			case NantPackage.TARGET__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends NAntCoreTypesPathSet>)newValue);
				return;
			case NantPackage.TARGET__PATTERNSET:
				getPatternset().clear();
				getPatternset().addAll((Collection<? extends NAntCoreTypesPatternSet>)newValue);
				return;
			case NantPackage.TARGET__PROXY:
				getProxy().clear();
				getProxy().addAll((Collection<? extends NAntCoreTypesProxy>)newValue);
				return;
			case NantPackage.TARGET__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case NantPackage.TARGET__DEPENDS:
				setDepends(newValue);
				return;
			case NantPackage.TARGET__DESCRIPTION1:
				setDescription1(newValue);
				return;
			case NantPackage.TARGET__IF1:
				setIf1(newValue);
				return;
			case NantPackage.TARGET__NAME:
				setName(newValue);
				return;
			case NantPackage.TARGET__UNLESS:
				setUnless(newValue);
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
			case NantPackage.TARGET__GROUP:
				getGroup().clear();
				return;
			case NantPackage.TARGET__ASMINFO:
				getAsminfo().clear();
				return;
			case NantPackage.TARGET__AL:
				getAl().clear();
				return;
			case NantPackage.TARGET__CSC:
				getCsc().clear();
				return;
			case NantPackage.TARGET__DELAY_SIGN:
				getDelaySign().clear();
				return;
			case NantPackage.TARGET__ILASM:
				getIlasm().clear();
				return;
			case NantPackage.TARGET__JSC:
				getJsc().clear();
				return;
			case NantPackage.TARGET__LICENSE:
				getLicense().clear();
				return;
			case NantPackage.TARGET__NDOC:
				getNdoc().clear();
				return;
			case NantPackage.TARGET__REGSVCS:
				getRegsvcs().clear();
				return;
			case NantPackage.TARGET__RESGEN:
				getResgen().clear();
				return;
			case NantPackage.TARGET__SCRIPT:
				getScript().clear();
				return;
			case NantPackage.TARGET__VBC:
				getVbc().clear();
				return;
			case NantPackage.TARGET__VJC:
				getVjc().clear();
				return;
			case NantPackage.TARGET__GUNZIP:
				getGunzip().clear();
				return;
			case NantPackage.TARGET__TAR:
				getTar().clear();
				return;
			case NantPackage.TARGET__UNZIP:
				getUnzip().clear();
				return;
			case NantPackage.TARGET__ZIP:
				getZip().clear();
				return;
			case NantPackage.TARGET__NUNIT:
				getNunit().clear();
				return;
			case NantPackage.TARGET__NUNIT2:
				getNunit2().clear();
				return;
			case NantPackage.TARGET__CVS_CHANGELOG:
				getCvsChangelog().clear();
				return;
			case NantPackage.TARGET__CVS_CHECKOUT:
				getCvsCheckout().clear();
				return;
			case NantPackage.TARGET__CVS_PASS:
				getCvsPass().clear();
				return;
			case NantPackage.TARGET__CVS:
				getCvs().clear();
				return;
			case NantPackage.TARGET__CVS_EXPORT:
				getCvsExport().clear();
				return;
			case NantPackage.TARGET__CVS_RTAG:
				getCvsRtag().clear();
				return;
			case NantPackage.TARGET__CVS_TAG:
				getCvsTag().clear();
				return;
			case NantPackage.TARGET__CVS_UPDATE:
				getCvsUpdate().clear();
				return;
			case NantPackage.TARGET__AXIMP:
				getAximp().clear();
				return;
			case NantPackage.TARGET__READREGISTRY:
				getReadregistry().clear();
				return;
			case NantPackage.TARGET__REGASM:
				getRegasm().clear();
				return;
			case NantPackage.TARGET__TLBEXP:
				getTlbexp().clear();
				return;
			case NantPackage.TARGET__TLBIMP:
				getTlbimp().clear();
				return;
			case NantPackage.TARGET__CL:
				getCl().clear();
				return;
			case NantPackage.TARGET__LIB:
				getLib().clear();
				return;
			case NantPackage.TARGET__LINK:
				getLink().clear();
				return;
			case NantPackage.TARGET__MC:
				getMc().clear();
				return;
			case NantPackage.TARGET__MIDL:
				getMidl().clear();
				return;
			case NantPackage.TARGET__RC:
				getRc().clear();
				return;
			case NantPackage.TARGET__SOLUTION:
				getSolution().clear();
				return;
			case NantPackage.TARGET__TESTTASK:
				getTesttask().clear();
				return;
			case NantPackage.TARGET__ELEMENT_TEST1:
				getElementTest1().clear();
				return;
			case NantPackage.TARGET__TEST:
				getTest().clear();
				return;
			case NantPackage.TARGET__ATTRIB:
				getAttrib().clear();
				return;
			case NantPackage.TARGET__AVAILABLE:
				getAvailable().clear();
				return;
			case NantPackage.TARGET__CALL:
				getCall().clear();
				return;
			case NantPackage.TARGET__COPY:
				getCopy().clear();
				return;
			case NantPackage.TARGET__DELETE:
				getDelete().clear();
				return;
			case NantPackage.TARGET__DESCRIPTION:
				getDescription().clear();
				return;
			case NantPackage.TARGET__ECHO:
				getEcho().clear();
				return;
			case NantPackage.TARGET__EXEC:
				getExec().clear();
				return;
			case NantPackage.TARGET__FAIL:
				getFail().clear();
				return;
			case NantPackage.TARGET__GET:
				getGet().clear();
				return;
			case NantPackage.TARGET__IF:
				getIf().clear();
				return;
			case NantPackage.TARGET__IFNOT:
				getIfnot().clear();
				return;
			case NantPackage.TARGET__INCLUDE:
				getInclude().clear();
				return;
			case NantPackage.TARGET__LOADFILE:
				getLoadfile().clear();
				return;
			case NantPackage.TARGET__LOADTASKS:
				getLoadtasks().clear();
				return;
			case NantPackage.TARGET__FOREACH:
				getForeach().clear();
				return;
			case NantPackage.TARGET__MAIL:
				getMail().clear();
				return;
			case NantPackage.TARGET__MKDIR:
				getMkdir().clear();
				return;
			case NantPackage.TARGET__MOVE:
				getMove().clear();
				return;
			case NantPackage.TARGET__NANTSCHEMA:
				getNantschema().clear();
				return;
			case NantPackage.TARGET__NANT:
				getNant().clear();
				return;
			case NantPackage.TARGET__PROPERTY:
				getProperty().clear();
				return;
			case NantPackage.TARGET__REGEX:
				getRegex().clear();
				return;
			case NantPackage.TARGET__SETENV:
				getSetenv().clear();
				return;
			case NantPackage.TARGET__SLEEP:
				getSleep().clear();
				return;
			case NantPackage.TARGET__STYLE:
				getStyle().clear();
				return;
			case NantPackage.TARGET__SYSINFO:
				getSysinfo().clear();
				return;
			case NantPackage.TARGET__TSTAMP:
				getTstamp().clear();
				return;
			case NantPackage.TARGET__TOUCH:
				getTouch().clear();
				return;
			case NantPackage.TARGET__UPTODATE:
				getUptodate().clear();
				return;
			case NantPackage.TARGET__XMLPEEK:
				getXmlpeek().clear();
				return;
			case NantPackage.TARGET__XMLPOKE:
				getXmlpoke().clear();
				return;
			case NantPackage.TARGET__ILDASM:
				getIldasm().clear();
				return;
			case NantPackage.TARGET__SERVICECONTROLLER:
				getServicecontroller().clear();
				return;
			case NantPackage.TARGET__ASSEMBLYFILESET:
				getAssemblyfileset().clear();
				return;
			case NantPackage.TARGET__MODULESET:
				getModuleset().clear();
				return;
			case NantPackage.TARGET__NAMESPACEIMPORTS:
				getNamespaceimports().clear();
				return;
			case NantPackage.TARGET__RESOURCEFILESET:
				getResourcefileset().clear();
				return;
			case NantPackage.TARGET__WARNASERROR:
				getWarnaserror().clear();
				return;
			case NantPackage.TARGET__TARFILESET:
				getTarfileset().clear();
				return;
			case NantPackage.TARGET__ZIPFILESET:
				getZipfileset().clear();
				return;
			case NantPackage.TARGET__CATEGORIES:
				getCategories().clear();
				return;
			case NantPackage.TARGET__CVSFILESET:
				getCvsfileset().clear();
				return;
			case NantPackage.TARGET__FILTERCHAIN:
				getFilterchain().clear();
				return;
			case NantPackage.TARGET__CREDENTIAL:
				getCredential().clear();
				return;
			case NantPackage.TARGET__FILESET:
				getFileset().clear();
				return;
			case NantPackage.TARGET__DIRSET:
				getDirset().clear();
				return;
			case NantPackage.TARGET__PATH:
				getPath().clear();
				return;
			case NantPackage.TARGET__PATTERNSET:
				getPatternset().clear();
				return;
			case NantPackage.TARGET__PROXY:
				getProxy().clear();
				return;
			case NantPackage.TARGET__ANY:
				getAny().clear();
				return;
			case NantPackage.TARGET__DEPENDS:
				setDepends(DEPENDS_EDEFAULT);
				return;
			case NantPackage.TARGET__DESCRIPTION1:
				setDescription1(DESCRIPTION1_EDEFAULT);
				return;
			case NantPackage.TARGET__IF1:
				setIf1(IF1_EDEFAULT);
				return;
			case NantPackage.TARGET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NantPackage.TARGET__UNLESS:
				setUnless(UNLESS_EDEFAULT);
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
			case NantPackage.TARGET__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.TARGET__ASMINFO:
				return !getAsminfo().isEmpty();
			case NantPackage.TARGET__AL:
				return !getAl().isEmpty();
			case NantPackage.TARGET__CSC:
				return !getCsc().isEmpty();
			case NantPackage.TARGET__DELAY_SIGN:
				return !getDelaySign().isEmpty();
			case NantPackage.TARGET__ILASM:
				return !getIlasm().isEmpty();
			case NantPackage.TARGET__JSC:
				return !getJsc().isEmpty();
			case NantPackage.TARGET__LICENSE:
				return !getLicense().isEmpty();
			case NantPackage.TARGET__NDOC:
				return !getNdoc().isEmpty();
			case NantPackage.TARGET__REGSVCS:
				return !getRegsvcs().isEmpty();
			case NantPackage.TARGET__RESGEN:
				return !getResgen().isEmpty();
			case NantPackage.TARGET__SCRIPT:
				return !getScript().isEmpty();
			case NantPackage.TARGET__VBC:
				return !getVbc().isEmpty();
			case NantPackage.TARGET__VJC:
				return !getVjc().isEmpty();
			case NantPackage.TARGET__GUNZIP:
				return !getGunzip().isEmpty();
			case NantPackage.TARGET__TAR:
				return !getTar().isEmpty();
			case NantPackage.TARGET__UNZIP:
				return !getUnzip().isEmpty();
			case NantPackage.TARGET__ZIP:
				return !getZip().isEmpty();
			case NantPackage.TARGET__NUNIT:
				return !getNunit().isEmpty();
			case NantPackage.TARGET__NUNIT2:
				return !getNunit2().isEmpty();
			case NantPackage.TARGET__CVS_CHANGELOG:
				return !getCvsChangelog().isEmpty();
			case NantPackage.TARGET__CVS_CHECKOUT:
				return !getCvsCheckout().isEmpty();
			case NantPackage.TARGET__CVS_PASS:
				return !getCvsPass().isEmpty();
			case NantPackage.TARGET__CVS:
				return !getCvs().isEmpty();
			case NantPackage.TARGET__CVS_EXPORT:
				return !getCvsExport().isEmpty();
			case NantPackage.TARGET__CVS_RTAG:
				return !getCvsRtag().isEmpty();
			case NantPackage.TARGET__CVS_TAG:
				return !getCvsTag().isEmpty();
			case NantPackage.TARGET__CVS_UPDATE:
				return !getCvsUpdate().isEmpty();
			case NantPackage.TARGET__AXIMP:
				return !getAximp().isEmpty();
			case NantPackage.TARGET__READREGISTRY:
				return !getReadregistry().isEmpty();
			case NantPackage.TARGET__REGASM:
				return !getRegasm().isEmpty();
			case NantPackage.TARGET__TLBEXP:
				return !getTlbexp().isEmpty();
			case NantPackage.TARGET__TLBIMP:
				return !getTlbimp().isEmpty();
			case NantPackage.TARGET__CL:
				return !getCl().isEmpty();
			case NantPackage.TARGET__LIB:
				return !getLib().isEmpty();
			case NantPackage.TARGET__LINK:
				return !getLink().isEmpty();
			case NantPackage.TARGET__MC:
				return !getMc().isEmpty();
			case NantPackage.TARGET__MIDL:
				return !getMidl().isEmpty();
			case NantPackage.TARGET__RC:
				return !getRc().isEmpty();
			case NantPackage.TARGET__SOLUTION:
				return !getSolution().isEmpty();
			case NantPackage.TARGET__TESTTASK:
				return !getTesttask().isEmpty();
			case NantPackage.TARGET__ELEMENT_TEST1:
				return !getElementTest1().isEmpty();
			case NantPackage.TARGET__TEST:
				return !getTest().isEmpty();
			case NantPackage.TARGET__ATTRIB:
				return !getAttrib().isEmpty();
			case NantPackage.TARGET__AVAILABLE:
				return !getAvailable().isEmpty();
			case NantPackage.TARGET__CALL:
				return !getCall().isEmpty();
			case NantPackage.TARGET__COPY:
				return !getCopy().isEmpty();
			case NantPackage.TARGET__DELETE:
				return !getDelete().isEmpty();
			case NantPackage.TARGET__DESCRIPTION:
				return !getDescription().isEmpty();
			case NantPackage.TARGET__ECHO:
				return !getEcho().isEmpty();
			case NantPackage.TARGET__EXEC:
				return !getExec().isEmpty();
			case NantPackage.TARGET__FAIL:
				return !getFail().isEmpty();
			case NantPackage.TARGET__GET:
				return !getGet().isEmpty();
			case NantPackage.TARGET__IF:
				return !getIf().isEmpty();
			case NantPackage.TARGET__IFNOT:
				return !getIfnot().isEmpty();
			case NantPackage.TARGET__INCLUDE:
				return !getInclude().isEmpty();
			case NantPackage.TARGET__LOADFILE:
				return !getLoadfile().isEmpty();
			case NantPackage.TARGET__LOADTASKS:
				return !getLoadtasks().isEmpty();
			case NantPackage.TARGET__FOREACH:
				return !getForeach().isEmpty();
			case NantPackage.TARGET__MAIL:
				return !getMail().isEmpty();
			case NantPackage.TARGET__MKDIR:
				return !getMkdir().isEmpty();
			case NantPackage.TARGET__MOVE:
				return !getMove().isEmpty();
			case NantPackage.TARGET__NANTSCHEMA:
				return !getNantschema().isEmpty();
			case NantPackage.TARGET__NANT:
				return !getNant().isEmpty();
			case NantPackage.TARGET__PROPERTY:
				return !getProperty().isEmpty();
			case NantPackage.TARGET__REGEX:
				return !getRegex().isEmpty();
			case NantPackage.TARGET__SETENV:
				return !getSetenv().isEmpty();
			case NantPackage.TARGET__SLEEP:
				return !getSleep().isEmpty();
			case NantPackage.TARGET__STYLE:
				return !getStyle().isEmpty();
			case NantPackage.TARGET__SYSINFO:
				return !getSysinfo().isEmpty();
			case NantPackage.TARGET__TSTAMP:
				return !getTstamp().isEmpty();
			case NantPackage.TARGET__TOUCH:
				return !getTouch().isEmpty();
			case NantPackage.TARGET__UPTODATE:
				return !getUptodate().isEmpty();
			case NantPackage.TARGET__XMLPEEK:
				return !getXmlpeek().isEmpty();
			case NantPackage.TARGET__XMLPOKE:
				return !getXmlpoke().isEmpty();
			case NantPackage.TARGET__ILDASM:
				return !getIldasm().isEmpty();
			case NantPackage.TARGET__SERVICECONTROLLER:
				return !getServicecontroller().isEmpty();
			case NantPackage.TARGET__ASSEMBLYFILESET:
				return !getAssemblyfileset().isEmpty();
			case NantPackage.TARGET__MODULESET:
				return !getModuleset().isEmpty();
			case NantPackage.TARGET__NAMESPACEIMPORTS:
				return !getNamespaceimports().isEmpty();
			case NantPackage.TARGET__RESOURCEFILESET:
				return !getResourcefileset().isEmpty();
			case NantPackage.TARGET__WARNASERROR:
				return !getWarnaserror().isEmpty();
			case NantPackage.TARGET__TARFILESET:
				return !getTarfileset().isEmpty();
			case NantPackage.TARGET__ZIPFILESET:
				return !getZipfileset().isEmpty();
			case NantPackage.TARGET__CATEGORIES:
				return !getCategories().isEmpty();
			case NantPackage.TARGET__CVSFILESET:
				return !getCvsfileset().isEmpty();
			case NantPackage.TARGET__FILTERCHAIN:
				return !getFilterchain().isEmpty();
			case NantPackage.TARGET__CREDENTIAL:
				return !getCredential().isEmpty();
			case NantPackage.TARGET__FILESET:
				return !getFileset().isEmpty();
			case NantPackage.TARGET__DIRSET:
				return !getDirset().isEmpty();
			case NantPackage.TARGET__PATH:
				return !getPath().isEmpty();
			case NantPackage.TARGET__PATTERNSET:
				return !getPatternset().isEmpty();
			case NantPackage.TARGET__PROXY:
				return !getProxy().isEmpty();
			case NantPackage.TARGET__ANY:
				return !getAny().isEmpty();
			case NantPackage.TARGET__DEPENDS:
				return DEPENDS_EDEFAULT == null ? depends != null : !DEPENDS_EDEFAULT.equals(depends);
			case NantPackage.TARGET__DESCRIPTION1:
				return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT.equals(description1);
			case NantPackage.TARGET__IF1:
				return IF1_EDEFAULT == null ? if1 != null : !IF1_EDEFAULT.equals(if1);
			case NantPackage.TARGET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NantPackage.TARGET__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
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
		result.append(", depends: ");
		result.append(depends);
		result.append(", description1: ");
		result.append(description1);
		result.append(", if1: ");
		result.append(if1);
		result.append(", name: ");
		result.append(name);
		result.append(", unless: ");
		result.append(unless);
		result.append(')');
		return result.toString();
	}

} //TargetImpl
