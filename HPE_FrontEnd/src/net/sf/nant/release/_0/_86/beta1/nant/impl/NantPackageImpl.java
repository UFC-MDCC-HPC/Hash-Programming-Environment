/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.io.IOException;

import java.net.URL;

import net.sf.nant.release._0._86.beta1.nant.NantFactory;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NantPackageImpl extends EPackageImpl implements NantPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "nant.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definesType2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionobjectsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ignorelibrariesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ignorelibrariesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespacesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespacesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCompressionTasksGUnzipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCompressionTasksTarTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCompressionTasksUnZipTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCompressionTasksZipTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCompressionTypesTarFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCompressionTypesZipFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreFiltersFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreFiltersFilterChainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTaskContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksAttribTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksAvailableTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksCallTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksCopyTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksDeleteTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksDescriptionTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksEchoTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksExecTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksFailTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksGetTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksIfNotTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksIfTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksIncludeTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksInElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksLoadFileTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksLoadTasksTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksLoopTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksMailTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksMkDirTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksMoveTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksNAntSchemaTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksNAntTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksPropertyTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksRegexTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksSetEnvTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksSleepTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksStyleTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksSysInfoTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksTouchTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksTStampTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksUpToDateTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksXmlPeekTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTasksXmlPokeTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesCredentialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesDirSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesEnvironmentSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesEnvironmentVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesFileSetExcludeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesFileSetExcludesFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesFileSetIncludeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesFileSetIncludesFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesFormatterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesPathElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesPathSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesPatternSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesProxyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesRawXmlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesXmlNamespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesXsltExtensionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntCoreTypesXsltParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksAssemblyInfoTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksAssemblyLinkerTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksCscTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksDelaySignTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksIlasmTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksJscTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksLicenseTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksNDocTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksRegsvcsTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksResGenTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksScriptTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksVbcTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTasksVjcTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesAssemblyAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesAssemblyFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesCompilerWarningEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesLibDirectorySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesModuleSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesNamespaceImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesNamespaceImportCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesResourceFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntDotNetTypesWarningAsErrorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntMSNetTasksIldasmTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntMSNetTasksServiceControllerTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntNUnit1TasksNUnitTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntNUnit1TypesNUnitTestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntNUnit2TasksNUnit2TaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntNUnit2TypesCategoriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntNUnit2TypesCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntNUnit2TypesNUnit2TestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntNUnitTypesFormatterElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksChangeLogTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksCheckoutTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksCvsPassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksCvsTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksExportTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksRTagTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksTagTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTasksUpdateTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntSourceControlTypesCvsFileSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTasksClTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTasksLibTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTasksLinkTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTasksMcTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTasksMidlTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTasksRcTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTypesLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVisualCppTypesSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVSNetTasksSolutionTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntVSNetTypesWebMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntWin32TasksAxImpTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntWin32TasksReadRegistryTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntWin32TasksRegAsmTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntWin32TasksTlbExpTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAntWin32TasksTlbImpTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nowarnTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nowarnType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nowarnType2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametersTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pkgReferencesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pkgReferencesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pkgReferencesType2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolsType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testsNAntCoreElementTest1TaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testsNAntCoreTestTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testsNAntCoreUtilXmlLoggerTestTestTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass undefinesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass undefinesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webmapTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NantPackageImpl() {
		super(eNS_URI, NantFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static NantPackage init() {
		if (isInited) return (NantPackage)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI);

		// Obtain or create and register package
		NantPackageImpl theNantPackage = (NantPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof NantPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new NantPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Load packages
		theNantPackage.loadPackage();

		// Fix loaded packages
		theNantPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theNantPackage.freeze();

		return theNantPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributesType() {
		if (attributesTypeEClass == null) {
			attributesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(0);
		}
		return attributesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributesType_Group() {
        return (EAttribute)getAttributesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributesType_Attribute() {
        return (EReference)getAttributesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinesType() {
		if (definesTypeEClass == null) {
			definesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(1);
		}
		return definesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinesType_Group() {
        return (EAttribute)getDefinesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinesType_Define() {
        return (EReference)getDefinesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinesType1() {
		if (definesType1EClass == null) {
			definesType1EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(2);
		}
		return definesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinesType1_Group() {
        return (EAttribute)getDefinesType1().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinesType1_Define() {
        return (EReference)getDefinesType1().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinesType2() {
		if (definesType2EClass == null) {
			definesType2EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(3);
		}
		return definesType2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinesType2_Group() {
        return (EAttribute)getDefinesType2().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinesType2_Define() {
        return (EReference)getDefinesType2().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		if (documentRootEClass == null) {
			documentRootEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(4);
		}
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute)getDocumentRoot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Project() {
        return (EReference)getDocumentRoot().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionobjectsType() {
		if (extensionobjectsTypeEClass == null) {
			extensionobjectsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(5);
		}
		return extensionobjectsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionobjectsType_Group() {
        return (EAttribute)getExtensionobjectsType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionobjectsType_Extensionobject() {
        return (EReference)getExtensionobjectsType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIgnorelibrariesType() {
		if (ignorelibrariesTypeEClass == null) {
			ignorelibrariesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(6);
		}
		return ignorelibrariesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIgnorelibrariesType_Group() {
        return (EAttribute)getIgnorelibrariesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIgnorelibrariesType_Library() {
        return (EReference)getIgnorelibrariesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIgnorelibrariesType1() {
		if (ignorelibrariesType1EClass == null) {
			ignorelibrariesType1EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(7);
		}
		return ignorelibrariesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIgnorelibrariesType1_Group() {
        return (EAttribute)getIgnorelibrariesType1().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIgnorelibrariesType1_Library() {
        return (EReference)getIgnorelibrariesType1().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespacesType() {
		if (namespacesTypeEClass == null) {
			namespacesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(8);
		}
		return namespacesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacesType_Group() {
        return (EAttribute)getNamespacesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespacesType_Namespace() {
        return (EReference)getNamespacesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespacesType1() {
		if (namespacesType1EClass == null) {
			namespacesType1EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(9);
		}
		return namespacesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacesType1_Group() {
        return (EAttribute)getNamespacesType1().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespacesType1_Namespace() {
        return (EReference)getNamespacesType1().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCompressionTasksGUnzip() {
		if (nAntCompressionTasksGUnzipEClass == null) {
			nAntCompressionTasksGUnzipEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(10);
		}
		return nAntCompressionTasksGUnzipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksGUnzip_Dest() {
        return (EAttribute)getNAntCompressionTasksGUnzip().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksGUnzip_Failonerror() {
        return (EAttribute)getNAntCompressionTasksGUnzip().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksGUnzip_If() {
        return (EAttribute)getNAntCompressionTasksGUnzip().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksGUnzip_Src() {
        return (EAttribute)getNAntCompressionTasksGUnzip().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksGUnzip_Unless() {
        return (EAttribute)getNAntCompressionTasksGUnzip().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksGUnzip_Verbose() {
        return (EAttribute)getNAntCompressionTasksGUnzip().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksGUnzip_AnyAttribute() {
        return (EAttribute)getNAntCompressionTasksGUnzip().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCompressionTasksTarTask() {
		if (nAntCompressionTasksTarTaskEClass == null) {
			nAntCompressionTasksTarTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(11);
		}
		return nAntCompressionTasksTarTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_Group() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTasksTarTask_Fileset() {
        return (EReference)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_Compression() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_Destfile() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_Failonerror() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_If() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_Includeemptydirs() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_Unless() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_Verbose() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksTarTask_AnyAttribute() {
        return (EAttribute)getNAntCompressionTasksTarTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCompressionTasksUnZipTask() {
		if (nAntCompressionTasksUnZipTaskEClass == null) {
			nAntCompressionTasksUnZipTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(12);
		}
		return nAntCompressionTasksUnZipTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_Encoding() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_Failonerror() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_If() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_Todir() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_Unless() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_Verbose() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_Zipfile() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksUnZipTask_AnyAttribute() {
        return (EAttribute)getNAntCompressionTasksUnZipTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCompressionTasksZipTask() {
		if (nAntCompressionTasksZipTaskEClass == null) {
			nAntCompressionTasksZipTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(13);
		}
		return nAntCompressionTasksZipTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Group() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTasksZipTask_Fileset() {
        return (EReference)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Comment() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Duplicate() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Encoding() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Failonerror() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_If() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Includeemptydirs() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Stampdatetime() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Unless() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Verbose() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Zipfile() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_Ziplevel() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTasksZipTask_AnyAttribute() {
        return (EAttribute)getNAntCompressionTasksZipTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCompressionTypesTarFileSet() {
		if (nAntCompressionTypesTarFileSetEClass == null) {
			nAntCompressionTypesTarFileSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(14);
		}
		return nAntCompressionTypesTarFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Group() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_Patternset() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_Includes() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_Include() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_Excludes() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_Exclude() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_IncludesList() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_Includesfile() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesTarFileSet_Excludesfile() {
        return (EReference)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Basedir() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Casesensitive() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Defaultexcludes() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Dirmode() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Failonempty() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Filemode() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Gid() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Groupname() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Id() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Prefix() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Refid() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Uid() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_Username() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesTarFileSet_AnyAttribute() {
        return (EAttribute)getNAntCompressionTypesTarFileSet().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCompressionTypesZipFileSet() {
		if (nAntCompressionTypesZipFileSetEClass == null) {
			nAntCompressionTypesZipFileSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(15);
		}
		return nAntCompressionTypesZipFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Group() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_Patternset() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_Includes() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_Include() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_Excludes() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_Exclude() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_IncludesList() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_Includesfile() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCompressionTypesZipFileSet_Excludesfile() {
        return (EReference)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Basedir() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Casesensitive() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Defaultexcludes() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Failonempty() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Id() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Prefix() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_Refid() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCompressionTypesZipFileSet_AnyAttribute() {
        return (EAttribute)getNAntCompressionTypesZipFileSet().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreFiltersFilter() {
		if (nAntCoreFiltersFilterEClass == null) {
			nAntCoreFiltersFilterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(16);
		}
		return nAntCoreFiltersFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilter_If() {
        return (EAttribute)getNAntCoreFiltersFilter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilter_Unless() {
        return (EAttribute)getNAntCoreFiltersFilter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilter_AnyAttribute() {
        return (EAttribute)getNAntCoreFiltersFilter().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreFiltersFilterChain() {
		if (nAntCoreFiltersFilterChainEClass == null) {
			nAntCoreFiltersFilterChainEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(17);
		}
		return nAntCoreFiltersFilterChainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilterChain_Group() {
        return (EAttribute)getNAntCoreFiltersFilterChain().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreFiltersFilterChain_Filter() {
        return (EReference)getNAntCoreFiltersFilterChain().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilterChain_Encoding() {
        return (EAttribute)getNAntCoreFiltersFilterChain().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilterChain_Id() {
        return (EAttribute)getNAntCoreFiltersFilterChain().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilterChain_Refid() {
        return (EAttribute)getNAntCoreFiltersFilterChain().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreFiltersFilterChain_AnyAttribute() {
        return (EAttribute)getNAntCoreFiltersFilterChain().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTaskContainer() {
		if (nAntCoreTaskContainerEClass == null) {
			nAntCoreTaskContainerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(18);
		}
		return nAntCoreTaskContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTaskContainer_Group() {
        return (EAttribute)getNAntCoreTaskContainer().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Asminfo() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Al() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Csc() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_DelaySign() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Ilasm() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Jsc() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_License() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Ndoc() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Regsvcs() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Resgen() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Script() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Vbc() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Vjc() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Gunzip() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Tar() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Unzip() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Zip() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Nunit() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Nunit2() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_CvsChangelog() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_CvsCheckout() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_CvsPass() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Cvs() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_CvsExport() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_CvsRtag() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_CvsTag() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_CvsUpdate() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Aximp() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Readregistry() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Regasm() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Tlbexp() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Tlbimp() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Cl() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Lib() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Link() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Mc() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Midl() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Rc() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Solution() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Testtask() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_ElementTest1() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Test() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Attrib() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Available() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Call() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Copy() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Delete() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Description() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Echo() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Exec() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Fail() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Get() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_If() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Ifnot() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Include() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Loadfile() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Loadtasks() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Foreach() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Mail() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Mkdir() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Move() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Nantschema() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Nant() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Property() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Regex() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Setenv() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Sleep() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Style() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Sysinfo() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Tstamp() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Touch() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Uptodate() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Xmlpeek() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Xmlpoke() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Ildasm() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTaskContainer_Servicecontroller() {
        return (EReference)getNAntCoreTaskContainer().getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTaskContainer_Any() {
        return (EAttribute)getNAntCoreTaskContainer().getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTaskContainer_Failonerror() {
        return (EAttribute)getNAntCoreTaskContainer().getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTaskContainer_If1() {
        return (EAttribute)getNAntCoreTaskContainer().getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTaskContainer_Unless() {
        return (EAttribute)getNAntCoreTaskContainer().getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTaskContainer_Verbose() {
        return (EAttribute)getNAntCoreTaskContainer().getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTaskContainer_AnyAttribute() {
        return (EAttribute)getNAntCoreTaskContainer().getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksAttribTask() {
		if (nAntCoreTasksAttribTaskEClass == null) {
			nAntCoreTasksAttribTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(19);
		}
		return nAntCoreTasksAttribTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Group() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksAttribTask_Fileset() {
        return (EReference)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Archive() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_File() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Hidden() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_If() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Normal() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Readonly() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_System() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Unless() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_Verbose() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAttribTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksAttribTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksAvailableTask() {
		if (nAntCoreTasksAvailableTaskEClass == null) {
			nAntCoreTasksAvailableTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(20);
		}
		return nAntCoreTasksAvailableTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_If() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_Property() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_Resource() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_Type() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_Unless() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_Verbose() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksAvailableTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksAvailableTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksCallTask() {
		if (nAntCoreTasksCallTaskEClass == null) {
			nAntCoreTasksCallTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(21);
		}
		return nAntCoreTasksCallTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_Cascade() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_Force() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_If() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_Target() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_Unless() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_Verbose() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCallTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksCallTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksCopyTask() {
		if (nAntCoreTasksCopyTaskEClass == null) {
			nAntCoreTasksCopyTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(22);
		}
		return nAntCoreTasksCopyTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Group() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksCopyTask_Fileset() {
        return (EReference)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksCopyTask_Filterchain() {
        return (EReference)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_File() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Flatten() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_If() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Includeemptydirs() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Inputencoding() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Outputencoding() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Overwrite() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Todir() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Tofile() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Unless() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_Verbose() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksCopyTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksCopyTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksDeleteTask() {
		if (nAntCoreTasksDeleteTaskEClass == null) {
			nAntCoreTasksDeleteTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(23);
		}
		return nAntCoreTasksDeleteTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_Group() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksDeleteTask_Fileset() {
        return (EReference)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_Dir() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_File() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_If() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_Includeemptydirs() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_Unless() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_Verbose() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDeleteTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksDeleteTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksDescriptionTask() {
		if (nAntCoreTasksDescriptionTaskEClass == null) {
			nAntCoreTasksDescriptionTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(24);
		}
		return nAntCoreTasksDescriptionTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDescriptionTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksDescriptionTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDescriptionTask_If() {
        return (EAttribute)getNAntCoreTasksDescriptionTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDescriptionTask_Unless() {
        return (EAttribute)getNAntCoreTasksDescriptionTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDescriptionTask_Verbose() {
        return (EAttribute)getNAntCoreTasksDescriptionTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksDescriptionTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksDescriptionTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksEchoTask() {
		if (nAntCoreTasksEchoTaskEClass == null) {
			nAntCoreTasksEchoTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(25);
		}
		return nAntCoreTasksEchoTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_Append() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_File() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_If() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_Level() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_Message() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_Unless() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_Verbose() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksEchoTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksEchoTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksExecTask() {
		if (nAntCoreTasksExecTaskEClass == null) {
			nAntCoreTasksExecTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(26);
		}
		return nAntCoreTasksExecTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Group() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksExecTask_Environment() {
        return (EReference)getNAntCoreTasksExecTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksExecTask_Arg() {
        return (EReference)getNAntCoreTasksExecTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Append() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Basedir() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Commandline() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_If() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Managed() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Output() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Pidproperty() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Program() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Resultproperty() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Spawn() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Timeout() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Unless() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Useruntimeengine() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Verbose() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_Workingdir() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksExecTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksExecTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksFailTask() {
		if (nAntCoreTasksFailTaskEClass == null) {
			nAntCoreTasksFailTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(27);
		}
		return nAntCoreTasksFailTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksFailTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksFailTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksFailTask_If() {
        return (EAttribute)getNAntCoreTasksFailTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksFailTask_Message() {
        return (EAttribute)getNAntCoreTasksFailTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksFailTask_Unless() {
        return (EAttribute)getNAntCoreTasksFailTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksFailTask_Verbose() {
        return (EAttribute)getNAntCoreTasksFailTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksFailTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksFailTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksGetTask() {
		if (nAntCoreTasksGetTaskEClass == null) {
			nAntCoreTasksGetTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(28);
		}
		return nAntCoreTasksGetTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Group() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksGetTask_Proxy() {
        return (EReference)getNAntCoreTasksGetTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksGetTask_Credentials() {
        return (EReference)getNAntCoreTasksGetTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksGetTask_Certificates() {
        return (EReference)getNAntCoreTasksGetTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Dest() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Httpproxy() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_If() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Ignoreerrors() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Src() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Timeout() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Unless() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Usetimestamp() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_Verbose() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksGetTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksGetTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksIfNotTask() {
		if (nAntCoreTasksIfNotTaskEClass == null) {
			nAntCoreTasksIfNotTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(29);
		}
		return nAntCoreTasksIfNotTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Group() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Comparefiles() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Uptodatefiles() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Asminfo() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Al() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Csc() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_DelaySign() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Ilasm() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Jsc() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_License() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Ndoc() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Regsvcs() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Resgen() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Script() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Vbc() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Vjc() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Gunzip() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Tar() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Unzip() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Zip() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Nunit() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Nunit2() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_CvsChangelog() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_CvsCheckout() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_CvsPass() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Cvs() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_CvsExport() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_CvsRtag() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_CvsTag() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_CvsUpdate() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Aximp() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Readregistry() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Regasm() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Tlbexp() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Tlbimp() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Cl() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Lib() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Link() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Mc() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Midl() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Rc() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Solution() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Testtask() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_ElementTest1() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Test() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Attrib() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Available() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Call() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Copy() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Delete() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Description() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Echo() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Exec() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Fail() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Get() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_If() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Ifnot() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Include() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Loadfile() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Loadtasks() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Foreach() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Mail() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Mkdir() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Move() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Nantschema() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Nant() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Property() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Regex() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Setenv() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Sleep() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Style() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Sysinfo() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Tstamp() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Touch() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Uptodate() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Xmlpeek() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Xmlpoke() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Ildasm() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfNotTask_Servicecontroller() {
        return (EReference)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Any() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Comparefile() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_If1() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Propertyexists() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Propertytrue() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Targetexists() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Test1() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Unless() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Uptodatefile() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_Verbose() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfNotTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksIfNotTask().getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksIfTask() {
		if (nAntCoreTasksIfTaskEClass == null) {
			nAntCoreTasksIfTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(30);
		}
		return nAntCoreTasksIfTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Group() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Comparefiles() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Uptodatefiles() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Asminfo() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Al() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Csc() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_DelaySign() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Ilasm() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Jsc() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_License() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Ndoc() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Regsvcs() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Resgen() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Script() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Vbc() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Vjc() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Gunzip() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Tar() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Unzip() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Zip() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Nunit() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Nunit2() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_CvsChangelog() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_CvsCheckout() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_CvsPass() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Cvs() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_CvsExport() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_CvsRtag() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_CvsTag() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_CvsUpdate() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Aximp() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Readregistry() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Regasm() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Tlbexp() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Tlbimp() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Cl() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Lib() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Link() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Mc() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Midl() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Rc() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Solution() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Testtask() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_ElementTest1() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Test() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Attrib() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Available() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Call() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Copy() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Delete() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Description() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Echo() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Exec() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Fail() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Get() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_If() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Ifnot() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Include() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Loadfile() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Loadtasks() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Foreach() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Mail() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Mkdir() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Move() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Nantschema() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Nant() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Property() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Regex() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Setenv() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Sleep() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Style() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Sysinfo() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Tstamp() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Touch() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Uptodate() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Xmlpeek() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Xmlpoke() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Ildasm() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksIfTask_Servicecontroller() {
        return (EReference)getNAntCoreTasksIfTask().getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Any() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Comparefile() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_If1() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Propertyexists() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Propertytrue() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Targetexists() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Test1() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Unless() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Uptodatefile() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_Verbose() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIfTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksIfTask().getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksIncludeTask() {
		if (nAntCoreTasksIncludeTaskEClass == null) {
			nAntCoreTasksIncludeTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(31);
		}
		return nAntCoreTasksIncludeTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIncludeTask_Buildfile() {
        return (EAttribute)getNAntCoreTasksIncludeTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIncludeTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksIncludeTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIncludeTask_If() {
        return (EAttribute)getNAntCoreTasksIncludeTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIncludeTask_Unless() {
        return (EAttribute)getNAntCoreTasksIncludeTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIncludeTask_Verbose() {
        return (EAttribute)getNAntCoreTasksIncludeTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksIncludeTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksIncludeTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksInElement() {
		if (nAntCoreTasksInElementEClass == null) {
			nAntCoreTasksInElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(32);
		}
		return nAntCoreTasksInElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksInElement_Group() {
        return (EAttribute)getNAntCoreTasksInElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksInElement_Items() {
        return (EReference)getNAntCoreTasksInElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksInElement_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksInElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksLoadFileTask() {
		if (nAntCoreTasksLoadFileTaskEClass == null) {
			nAntCoreTasksLoadFileTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(33);
		}
		return nAntCoreTasksLoadFileTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_Group() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoadFileTask_Filterchain() {
        return (EReference)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_Encoding() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_File() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_If() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_Property() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_Unless() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_Verbose() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadFileTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksLoadFileTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksLoadTasksTask() {
		if (nAntCoreTasksLoadTasksTaskEClass == null) {
			nAntCoreTasksLoadTasksTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(34);
		}
		return nAntCoreTasksLoadTasksTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_Group() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoadTasksTask_Fileset() {
        return (EReference)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_Assembly() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_If() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_Path() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_Unless() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_Verbose() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoadTasksTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksLoadTasksTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksLoopTask() {
		if (nAntCoreTasksLoopTaskEClass == null) {
			nAntCoreTasksLoopTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(35);
		}
		return nAntCoreTasksLoopTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Group() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_In() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Do() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Asminfo() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Al() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Csc() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_DelaySign() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Ilasm() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Jsc() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_License() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Ndoc() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Regsvcs() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Resgen() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Script() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Vbc() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Vjc() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Gunzip() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Tar() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Unzip() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Zip() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Nunit() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Nunit2() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_CvsChangelog() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_CvsCheckout() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_CvsPass() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Cvs() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_CvsExport() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_CvsRtag() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_CvsTag() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_CvsUpdate() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Aximp() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Readregistry() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Regasm() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Tlbexp() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Tlbimp() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Cl() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Lib() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Link() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Mc() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Midl() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Rc() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Solution() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Testtask() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_ElementTest1() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Test() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Attrib() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Available() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Call() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Copy() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Delete() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Description() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Echo() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Exec() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Fail() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Get() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_If() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Ifnot() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Include() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Loadfile() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Loadtasks() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Foreach() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Mail() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Mkdir() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Move() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Nantschema() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Nant() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Property() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Regex() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Setenv() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Sleep() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Style() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Sysinfo() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Tstamp() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Touch() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Uptodate() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Xmlpeek() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Xmlpoke() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Ildasm() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksLoopTask_Servicecontroller() {
        return (EReference)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Any() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Delim() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_If1() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_In1() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Item() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Property1() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Trim() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Unless() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_Verbose() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksLoopTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksLoopTask().getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksMailTask() {
		if (nAntCoreTasksMailTaskEClass == null) {
			nAntCoreTasksMailTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(36);
		}
		return nAntCoreTasksMailTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Group() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksMailTask_Files() {
        return (EReference)getNAntCoreTasksMailTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksMailTask_Attachments() {
        return (EReference)getNAntCoreTasksMailTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Bcclist() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Cclist() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Format() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_From() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_If() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Mailhost() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Message() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Subject() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Tolist() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Unless() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_Verbose() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMailTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksMailTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksMkDirTask() {
		if (nAntCoreTasksMkDirTaskEClass == null) {
			nAntCoreTasksMkDirTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(37);
		}
		return nAntCoreTasksMkDirTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMkDirTask_Dir() {
        return (EAttribute)getNAntCoreTasksMkDirTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMkDirTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksMkDirTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMkDirTask_If() {
        return (EAttribute)getNAntCoreTasksMkDirTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMkDirTask_Unless() {
        return (EAttribute)getNAntCoreTasksMkDirTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMkDirTask_Verbose() {
        return (EAttribute)getNAntCoreTasksMkDirTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMkDirTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksMkDirTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksMoveTask() {
		if (nAntCoreTasksMoveTaskEClass == null) {
			nAntCoreTasksMoveTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(38);
		}
		return nAntCoreTasksMoveTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Group() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksMoveTask_Fileset() {
        return (EReference)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksMoveTask_Filterchain() {
        return (EReference)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_File() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Flatten() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_If() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Includeemptydirs() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Inputencoding() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Outputencoding() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Overwrite() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Todir() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Tofile() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Unless() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_Verbose() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksMoveTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksMoveTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksNAntSchemaTask() {
		if (nAntCoreTasksNAntSchemaTaskEClass == null) {
			nAntCoreTasksNAntSchemaTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(39);
		}
		return nAntCoreTasksNAntSchemaTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_Class() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_If() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_Output() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_TargetNs() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_Unless() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_Verbose() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntSchemaTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksNAntSchemaTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksNAntTask() {
		if (nAntCoreTasksNAntTaskEClass == null) {
			nAntCoreTasksNAntTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(40);
		}
		return nAntCoreTasksNAntTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Group() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksNAntTask_Buildfiles() {
        return (EReference)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksNAntTask_Properties() {
        return (EReference)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Buildfile() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_If() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Inheritall() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Inheritrefs() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Target() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Unless() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_Verbose() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksNAntTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksNAntTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksPropertyTask() {
		if (nAntCoreTasksPropertyTaskEClass == null) {
			nAntCoreTasksPropertyTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(41);
		}
		return nAntCoreTasksPropertyTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Dynamic() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_If() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Name() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Overwrite() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Readonly() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Unless() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Value() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_Verbose() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksPropertyTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksPropertyTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksRegexTask() {
		if (nAntCoreTasksRegexTaskEClass == null) {
			nAntCoreTasksRegexTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(42);
		}
		return nAntCoreTasksRegexTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_If() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_Input() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_Options() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_Pattern() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_Unless() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_Verbose() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksRegexTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksRegexTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksSetEnvTask() {
		if (nAntCoreTasksSetEnvTaskEClass == null) {
			nAntCoreTasksSetEnvTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(43);
		}
		return nAntCoreTasksSetEnvTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Group() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksSetEnvTask_Variable() {
        return (EReference)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Dir() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_File() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_If() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Name() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Path() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Unless() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Value() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_Verbose() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSetEnvTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksSetEnvTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksSleepTask() {
		if (nAntCoreTasksSleepTaskEClass == null) {
			nAntCoreTasksSleepTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(44);
		}
		return nAntCoreTasksSleepTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_Hours() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_If() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_Milliseconds() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_Minutes() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_Seconds() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_Unless() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_Verbose() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSleepTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksSleepTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksStyleTask() {
		if (nAntCoreTasksStyleTaskEClass == null) {
			nAntCoreTasksStyleTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(45);
		}
		return nAntCoreTasksStyleTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Group() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksStyleTask_Infiles() {
        return (EReference)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksStyleTask_Parameters() {
        return (EReference)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksStyleTask_Extensionobjects() {
        return (EReference)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksStyleTask_Proxy() {
        return (EReference)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Destdir() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Extension() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_If() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_In() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Out() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Style() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Unless() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_Verbose() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksStyleTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksStyleTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksSysInfoTask() {
		if (nAntCoreTasksSysInfoTaskEClass == null) {
			nAntCoreTasksSysInfoTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(46);
		}
		return nAntCoreTasksSysInfoTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSysInfoTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksSysInfoTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSysInfoTask_If() {
        return (EAttribute)getNAntCoreTasksSysInfoTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSysInfoTask_Prefix() {
        return (EAttribute)getNAntCoreTasksSysInfoTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSysInfoTask_Unless() {
        return (EAttribute)getNAntCoreTasksSysInfoTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSysInfoTask_Verbose() {
        return (EAttribute)getNAntCoreTasksSysInfoTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksSysInfoTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksSysInfoTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksTouchTask() {
		if (nAntCoreTasksTouchTaskEClass == null) {
			nAntCoreTasksTouchTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(47);
		}
		return nAntCoreTasksTouchTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_Group() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksTouchTask_Fileset() {
        return (EReference)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_Datetime() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_File() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_If() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_Millis() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_Unless() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_Verbose() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTouchTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksTouchTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksTStampTask() {
		if (nAntCoreTasksTStampTaskEClass == null) {
			nAntCoreTasksTStampTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(48);
		}
		return nAntCoreTasksTStampTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_Group() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksTStampTask_Formatter() {
        return (EReference)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_If() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_Pattern() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_Property() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_Unless() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_Verbose() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksTStampTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksTStampTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksUpToDateTask() {
		if (nAntCoreTasksUpToDateTaskEClass == null) {
			nAntCoreTasksUpToDateTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(49);
		}
		return nAntCoreTasksUpToDateTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksUpToDateTask_Group() {
        return (EAttribute)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksUpToDateTask_Sourcefiles() {
        return (EReference)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksUpToDateTask_Targetfiles() {
        return (EReference)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksUpToDateTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksUpToDateTask_If() {
        return (EAttribute)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksUpToDateTask_Property() {
        return (EAttribute)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksUpToDateTask_Unless() {
        return (EAttribute)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksUpToDateTask_Verbose() {
        return (EAttribute)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksUpToDateTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksUpToDateTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksXmlPeekTask() {
		if (nAntCoreTasksXmlPeekTaskEClass == null) {
			nAntCoreTasksXmlPeekTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(50);
		}
		return nAntCoreTasksXmlPeekTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_Group() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksXmlPeekTask_Namespaces() {
        return (EReference)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_File() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_If() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_Nodeindex() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_Property() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_Unless() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_Verbose() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_Xpath() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPeekTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksXmlPeekTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTasksXmlPokeTask() {
		if (nAntCoreTasksXmlPokeTaskEClass == null) {
			nAntCoreTasksXmlPokeTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(51);
		}
		return nAntCoreTasksXmlPokeTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_Group() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTasksXmlPokeTask_Namespaces() {
        return (EReference)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_Failonerror() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_File() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_If() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_Unless() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_Value() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_Verbose() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_Xpath() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTasksXmlPokeTask_AnyAttribute() {
        return (EAttribute)getNAntCoreTasksXmlPokeTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesArgument() {
		if (nAntCoreTypesArgumentEClass == null) {
			nAntCoreTypesArgumentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(52);
		}
		return nAntCoreTypesArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_Group() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesArgument_Path() {
        return (EReference)getNAntCoreTypesArgument().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_Dir() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_File() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_If() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_Line() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_Path1() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_Unless() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_Value() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesArgument_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesArgument().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesCredential() {
		if (nAntCoreTypesCredentialEClass == null) {
			nAntCoreTypesCredentialEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(53);
		}
		return nAntCoreTypesCredentialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_Domain() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_Id() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_If() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_Password() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_Refid() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_Unless() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_Username() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesCredential_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesCredential().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesDirSet() {
		if (nAntCoreTypesDirSetEClass == null) {
			nAntCoreTypesDirSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(54);
		}
		return nAntCoreTypesDirSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_Group() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_Patternset() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_Includes() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_Include() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_Excludes() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_Exclude() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_IncludesList() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_Includesfile() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesDirSet_Excludesfile() {
        return (EReference)getNAntCoreTypesDirSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_Basedir() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_Casesensitive() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_Defaultexcludes() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_Failonempty() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_Id() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_Refid() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesDirSet_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesDirSet().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesEnvironmentSet() {
		if (nAntCoreTypesEnvironmentSetEClass == null) {
			nAntCoreTypesEnvironmentSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(55);
		}
		return nAntCoreTypesEnvironmentSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentSet_Group() {
        return (EAttribute)getNAntCoreTypesEnvironmentSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesEnvironmentSet_Option() {
        return (EReference)getNAntCoreTypesEnvironmentSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesEnvironmentSet_Variable() {
        return (EReference)getNAntCoreTypesEnvironmentSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentSet_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesEnvironmentSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesEnvironmentVariable() {
		if (nAntCoreTypesEnvironmentVariableEClass == null) {
			nAntCoreTypesEnvironmentVariableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(56);
		}
		return nAntCoreTypesEnvironmentVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_Group() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesEnvironmentVariable_Path() {
        return (EReference)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_Dir() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_File() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_If() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_Name() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_Path1() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_Unless() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_Value() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesEnvironmentVariable_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesEnvironmentVariable().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesFileSet() {
		if (nAntCoreTypesFileSetEClass == null) {
			nAntCoreTypesFileSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(57);
		}
		return nAntCoreTypesFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_Group() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_Patternset() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_Includes() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_Include() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_Excludes() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_Exclude() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_IncludesList() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_Includesfile() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesFileSet_Excludesfile() {
        return (EReference)getNAntCoreTypesFileSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_Basedir() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_Casesensitive() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_Defaultexcludes() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_Failonempty() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_Id() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_Refid() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSet_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesFileSet().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesFileSetExclude() {
		if (nAntCoreTypesFileSetExcludeEClass == null) {
			nAntCoreTypesFileSetExcludeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(58);
		}
		return nAntCoreTypesFileSetExcludeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExclude_If() {
        return (EAttribute)getNAntCoreTypesFileSetExclude().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExclude_Name() {
        return (EAttribute)getNAntCoreTypesFileSetExclude().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExclude_Unless() {
        return (EAttribute)getNAntCoreTypesFileSetExclude().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExclude_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesFileSetExclude().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesFileSetExcludesFile() {
		if (nAntCoreTypesFileSetExcludesFileEClass == null) {
			nAntCoreTypesFileSetExcludesFileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(59);
		}
		return nAntCoreTypesFileSetExcludesFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExcludesFile_If() {
        return (EAttribute)getNAntCoreTypesFileSetExcludesFile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExcludesFile_Name() {
        return (EAttribute)getNAntCoreTypesFileSetExcludesFile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExcludesFile_Unless() {
        return (EAttribute)getNAntCoreTypesFileSetExcludesFile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetExcludesFile_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesFileSetExcludesFile().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesFileSetInclude() {
		if (nAntCoreTypesFileSetIncludeEClass == null) {
			nAntCoreTypesFileSetIncludeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(60);
		}
		return nAntCoreTypesFileSetIncludeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetInclude_Asis() {
        return (EAttribute)getNAntCoreTypesFileSetInclude().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetInclude_Frompath() {
        return (EAttribute)getNAntCoreTypesFileSetInclude().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetInclude_If() {
        return (EAttribute)getNAntCoreTypesFileSetInclude().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetInclude_Name() {
        return (EAttribute)getNAntCoreTypesFileSetInclude().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetInclude_Unless() {
        return (EAttribute)getNAntCoreTypesFileSetInclude().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetInclude_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesFileSetInclude().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesFileSetIncludesFile() {
		if (nAntCoreTypesFileSetIncludesFileEClass == null) {
			nAntCoreTypesFileSetIncludesFileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(61);
		}
		return nAntCoreTypesFileSetIncludesFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetIncludesFile_Asis() {
        return (EAttribute)getNAntCoreTypesFileSetIncludesFile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetIncludesFile_Frompath() {
        return (EAttribute)getNAntCoreTypesFileSetIncludesFile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetIncludesFile_If() {
        return (EAttribute)getNAntCoreTypesFileSetIncludesFile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetIncludesFile_Name() {
        return (EAttribute)getNAntCoreTypesFileSetIncludesFile().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetIncludesFile_Unless() {
        return (EAttribute)getNAntCoreTypesFileSetIncludesFile().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFileSetIncludesFile_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesFileSetIncludesFile().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesFormatter() {
		if (nAntCoreTypesFormatterEClass == null) {
			nAntCoreTypesFormatterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(62);
		}
		return nAntCoreTypesFormatterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFormatter_If() {
        return (EAttribute)getNAntCoreTypesFormatter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFormatter_Pattern() {
        return (EAttribute)getNAntCoreTypesFormatter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFormatter_Property() {
        return (EAttribute)getNAntCoreTypesFormatter().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFormatter_Unless() {
        return (EAttribute)getNAntCoreTypesFormatter().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesFormatter_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesFormatter().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesOption() {
		if (nAntCoreTypesOptionEClass == null) {
			nAntCoreTypesOptionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(63);
		}
		return nAntCoreTypesOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesOption_If() {
        return (EAttribute)getNAntCoreTypesOption().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesOption_Name() {
        return (EAttribute)getNAntCoreTypesOption().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesOption_Unless() {
        return (EAttribute)getNAntCoreTypesOption().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesOption_Value() {
        return (EAttribute)getNAntCoreTypesOption().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesOption_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesOption().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesPathElement() {
		if (nAntCoreTypesPathElementEClass == null) {
			nAntCoreTypesPathElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(64);
		}
		return nAntCoreTypesPathElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathElement_Dir() {
        return (EAttribute)getNAntCoreTypesPathElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathElement_File() {
        return (EAttribute)getNAntCoreTypesPathElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathElement_If() {
        return (EAttribute)getNAntCoreTypesPathElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathElement_Path() {
        return (EAttribute)getNAntCoreTypesPathElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathElement_Unless() {
        return (EAttribute)getNAntCoreTypesPathElement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathElement_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesPathElement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesPathSet() {
		if (nAntCoreTypesPathSetEClass == null) {
			nAntCoreTypesPathSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(65);
		}
		return nAntCoreTypesPathSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathSet_Group() {
        return (EAttribute)getNAntCoreTypesPathSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesPathSet_Path() {
        return (EReference)getNAntCoreTypesPathSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesPathSet_Pathelement() {
        return (EReference)getNAntCoreTypesPathSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathSet_Id() {
        return (EAttribute)getNAntCoreTypesPathSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathSet_Refid() {
        return (EAttribute)getNAntCoreTypesPathSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPathSet_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesPathSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesPattern() {
		if (nAntCoreTypesPatternEClass == null) {
			nAntCoreTypesPatternEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(66);
		}
		return nAntCoreTypesPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPattern_If() {
        return (EAttribute)getNAntCoreTypesPattern().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPattern_Name() {
        return (EAttribute)getNAntCoreTypesPattern().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPattern_Unless() {
        return (EAttribute)getNAntCoreTypesPattern().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPattern_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesPattern().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesPatternSet() {
		if (nAntCoreTypesPatternSetEClass == null) {
			nAntCoreTypesPatternSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(67);
		}
		return nAntCoreTypesPatternSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPatternSet_Group() {
        return (EAttribute)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesPatternSet_Patternset() {
        return (EReference)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesPatternSet_Include() {
        return (EReference)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesPatternSet_Includesfile() {
        return (EReference)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesPatternSet_Exclude() {
        return (EReference)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesPatternSet_Excludesfile() {
        return (EReference)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPatternSet_Id() {
        return (EAttribute)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPatternSet_Refid() {
        return (EAttribute)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesPatternSet_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesPatternSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesProxy() {
		if (nAntCoreTypesProxyEClass == null) {
			nAntCoreTypesProxyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(68);
		}
		return nAntCoreTypesProxyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_Group() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntCoreTypesProxy_Credentials() {
        return (EReference)getNAntCoreTypesProxy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_Bypassonlocal() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_Host() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_Id() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_If() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_Port() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_Refid() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_Unless() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesProxy_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesProxy().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesRawXml() {
		if (nAntCoreTypesRawXmlEClass == null) {
			nAntCoreTypesRawXmlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(69);
		}
		return nAntCoreTypesRawXmlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesRawXml_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesRawXml().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesXmlNamespace() {
		if (nAntCoreTypesXmlNamespaceEClass == null) {
			nAntCoreTypesXmlNamespaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(70);
		}
		return nAntCoreTypesXmlNamespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXmlNamespace_If() {
        return (EAttribute)getNAntCoreTypesXmlNamespace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXmlNamespace_Prefix() {
        return (EAttribute)getNAntCoreTypesXmlNamespace().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXmlNamespace_Unless() {
        return (EAttribute)getNAntCoreTypesXmlNamespace().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXmlNamespace_Uri() {
        return (EAttribute)getNAntCoreTypesXmlNamespace().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXmlNamespace_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesXmlNamespace().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesXsltExtensionObject() {
		if (nAntCoreTypesXsltExtensionObjectEClass == null) {
			nAntCoreTypesXsltExtensionObjectEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(71);
		}
		return nAntCoreTypesXsltExtensionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltExtensionObject_Assembly() {
        return (EAttribute)getNAntCoreTypesXsltExtensionObject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltExtensionObject_If() {
        return (EAttribute)getNAntCoreTypesXsltExtensionObject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltExtensionObject_Namespaceuri() {
        return (EAttribute)getNAntCoreTypesXsltExtensionObject().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltExtensionObject_Typename() {
        return (EAttribute)getNAntCoreTypesXsltExtensionObject().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltExtensionObject_Unless() {
        return (EAttribute)getNAntCoreTypesXsltExtensionObject().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltExtensionObject_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesXsltExtensionObject().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntCoreTypesXsltParameter() {
		if (nAntCoreTypesXsltParameterEClass == null) {
			nAntCoreTypesXsltParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(72);
		}
		return nAntCoreTypesXsltParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltParameter_If() {
        return (EAttribute)getNAntCoreTypesXsltParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltParameter_Name() {
        return (EAttribute)getNAntCoreTypesXsltParameter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltParameter_Namespaceuri() {
        return (EAttribute)getNAntCoreTypesXsltParameter().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltParameter_Unless() {
        return (EAttribute)getNAntCoreTypesXsltParameter().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltParameter_Value() {
        return (EAttribute)getNAntCoreTypesXsltParameter().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntCoreTypesXsltParameter_AnyAttribute() {
        return (EAttribute)getNAntCoreTypesXsltParameter().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksAssemblyInfoTask() {
		if (nAntDotNetTasksAssemblyInfoTaskEClass == null) {
			nAntDotNetTasksAssemblyInfoTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(73);
		}
		return nAntDotNetTasksAssemblyInfoTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_Group() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksAssemblyInfoTask_Attributes() {
        return (EReference)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksAssemblyInfoTask_Imports() {
        return (EReference)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksAssemblyInfoTask_References() {
        return (EReference)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_If() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_Language() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_Output() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_Unless() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyInfoTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksAssemblyInfoTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksAssemblyLinkerTask() {
		if (nAntDotNetTasksAssemblyLinkerTaskEClass == null) {
			nAntDotNetTasksAssemblyLinkerTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(74);
		}
		return nAntDotNetTasksAssemblyLinkerTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Group() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksAssemblyLinkerTask_Modules() {
        return (EReference)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksAssemblyLinkerTask_Sources() {
        return (EReference)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksAssemblyLinkerTask_Arg() {
        return (EReference)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Algid() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Company() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Configuration() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Copyright() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Culture() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Delaysign() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Description() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Evidence() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Fileversion() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Flags() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_If() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Keycontainer() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Keyfile() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Main() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Output() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Product() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Productversion() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Target() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Template() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Title() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Trademark() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Unless() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Version() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Win32icon() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_Win32res() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksAssemblyLinkerTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksAssemblyLinkerTask().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksCscTask() {
		if (nAntDotNetTasksCscTaskEClass == null) {
			nAntDotNetTasksCscTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(75);
		}
		return nAntDotNetTasksCscTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Group() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_Warnaserror() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_Nowarn() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_Lib() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_References() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_PkgReferences() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_Resources() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_Modules() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_Sources() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksCscTask_Arg() {
        return (EReference)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Baseaddress() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Checked() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Codepage() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Debug() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Define() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Delaysign() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Doc() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Filealign() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_If() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Keycontainer() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Keyfile() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Langversion() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Main() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Noconfig() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Nostdlib() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Nowarn1() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Optimize() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Output() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Platform() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Rebuild() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Target() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Unless() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Unsafe() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Warnaserror1() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Warninglevel() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_Win32icon() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksCscTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksCscTask().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksDelaySignTask() {
		if (nAntDotNetTasksDelaySignTaskEClass == null) {
			nAntDotNetTasksDelaySignTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(76);
		}
		return nAntDotNetTasksDelaySignTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_Group() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksDelaySignTask_Targets() {
        return (EReference)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksDelaySignTask_Arg() {
        return (EReference)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_If() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_Keycontainer() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_Keyfile() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_Unless() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksDelaySignTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksDelaySignTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksIlasmTask() {
		if (nAntDotNetTasksIlasmTaskEClass == null) {
			nAntDotNetTasksIlasmTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(77);
		}
		return nAntDotNetTasksIlasmTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Group() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksIlasmTask_Sources() {
        return (EReference)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksIlasmTask_Arg() {
        return (EReference)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Alignment() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Base() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Clock() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Debug() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Error() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Flags() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_If() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Keyfile() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Keysource() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Listing() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Output() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Rebuild() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Resourcefile() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Subsystem() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Target() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Unless() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksIlasmTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksIlasmTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksJscTask() {
		if (nAntDotNetTasksJscTaskEClass == null) {
			nAntDotNetTasksJscTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(78);
		}
		return nAntDotNetTasksJscTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Group() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksJscTask_Lib() {
        return (EReference)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksJscTask_References() {
        return (EReference)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksJscTask_PkgReferences() {
        return (EReference)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksJscTask_Resources() {
        return (EReference)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksJscTask_Sources() {
        return (EReference)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksJscTask_Arg() {
        return (EReference)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Autoref() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Codepage() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Debug() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Define() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_If() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Main() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Nostdlib() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Output() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Platform() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Rebuild() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Target() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Unless() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Versionsafe() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Warnaserror() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Warninglevel() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_Win32icon() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksJscTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksJscTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksLicenseTask() {
		if (nAntDotNetTasksLicenseTaskEClass == null) {
			nAntDotNetTasksLicenseTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(79);
		}
		return nAntDotNetTasksLicenseTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Group() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksLicenseTask_Assemblies() {
        return (EReference)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_If() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Input() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Licensetarget() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Output() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Target() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Unless() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksLicenseTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksLicenseTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksNDocTask() {
		if (nAntDotNetTasksNDocTaskEClass == null) {
			nAntDotNetTasksNDocTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(80);
		}
		return nAntDotNetTasksNDocTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksNDocTask_Group() {
        return (EAttribute)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksNDocTask_Assemblies() {
        return (EReference)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksNDocTask_Summaries() {
        return (EReference)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksNDocTask_Documenters() {
        return (EReference)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksNDocTask_Referencepaths() {
        return (EReference)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksNDocTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksNDocTask_If() {
        return (EAttribute)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksNDocTask_Unless() {
        return (EAttribute)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksNDocTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksNDocTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksNDocTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksRegsvcsTask() {
		if (nAntDotNetTasksRegsvcsTaskEClass == null) {
			nAntDotNetTasksRegsvcsTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(81);
		}
		return nAntDotNetTasksRegsvcsTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Group() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksRegsvcsTask_Arg() {
        return (EReference)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Action() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Application() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Assembly() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Componentsonly() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Existingapp() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Existingtlb() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_If() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Noreconfig() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Partition() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Tlb() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Unless() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksRegsvcsTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksRegsvcsTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksResGenTask() {
		if (nAntDotNetTasksResGenTaskEClass == null) {
			nAntDotNetTasksResGenTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(82);
		}
		return nAntDotNetTasksResGenTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Group() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksResGenTask_Resources() {
        return (EReference)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksResGenTask_Assemblies() {
        return (EReference)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksResGenTask_Arg() {
        return (EReference)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_If() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Input() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Output() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Target() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Todir() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Unless() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Usesourcepath() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksResGenTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksResGenTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksScriptTask() {
		if (nAntDotNetTasksScriptTaskEClass == null) {
			nAntDotNetTasksScriptTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(83);
		}
		return nAntDotNetTasksScriptTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_Group() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksScriptTask_References() {
        return (EReference)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksScriptTask_Imports() {
        return (EReference)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksScriptTask_Code() {
        return (EReference)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_If() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_Language() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_Mainclass() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_Prefix() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_Unless() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksScriptTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksScriptTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksVbcTask() {
		if (nAntDotNetTasksVbcTaskEClass == null) {
			nAntDotNetTasksVbcTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(84);
		}
		return nAntDotNetTasksVbcTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Group() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Imports() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Warnaserror() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Nowarn() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Lib() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_References() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_PkgReferences() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Resources() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Modules() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Sources() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVbcTask_Arg() {
        return (EReference)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Baseaddress() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Debug() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Define() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Delaysign() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Doc() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_If() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Imports1() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Keycontainer() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Keyfile() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Main() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Nostdlib() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Nowarn1() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Optioncompare() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Optionexplicit() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Optionoptimize() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Optionstrict() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Output() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Platform() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Rebuild() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Removeintchecks() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Rootnamespace() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Target() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Unless() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Warnaserror1() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_Win32icon() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVbcTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksVbcTask().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTasksVjcTask() {
		if (nAntDotNetTasksVjcTaskEClass == null) {
			nAntDotNetTasksVjcTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(85);
		}
		return nAntDotNetTasksVjcTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Group() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVjcTask_Nowarn() {
        return (EReference)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVjcTask_Lib() {
        return (EReference)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVjcTask_References() {
        return (EReference)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVjcTask_Resources() {
        return (EReference)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVjcTask_Sources() {
        return (EReference)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTasksVjcTask_Arg() {
        return (EReference)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Codepage() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Debug() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Define() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Delaysign() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Failonerror() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_If() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Jcpa() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Keycontainer() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Keyfile() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Libpath() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Main() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Nowarn1() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Output() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Rebuild() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Securescoping() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Target() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Timeout() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Unless() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Verbose() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Warnaserror() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Warninglevel() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_Win32icon() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_X() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTasksVjcTask_AnyAttribute() {
        return (EAttribute)getNAntDotNetTasksVjcTask().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesAssemblyAttribute() {
		if (nAntDotNetTypesAssemblyAttributeEClass == null) {
			nAntDotNetTypesAssemblyAttributeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(86);
		}
		return nAntDotNetTypesAssemblyAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyAttribute_Asis() {
        return (EAttribute)getNAntDotNetTypesAssemblyAttribute().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyAttribute_If() {
        return (EAttribute)getNAntDotNetTypesAssemblyAttribute().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyAttribute_Type() {
        return (EAttribute)getNAntDotNetTypesAssemblyAttribute().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyAttribute_Unless() {
        return (EAttribute)getNAntDotNetTypesAssemblyAttribute().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyAttribute_Value() {
        return (EAttribute)getNAntDotNetTypesAssemblyAttribute().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyAttribute_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesAssemblyAttribute().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesAssemblyFileSet() {
		if (nAntDotNetTypesAssemblyFileSetEClass == null) {
			nAntDotNetTypesAssemblyFileSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(87);
		}
		return nAntDotNetTypesAssemblyFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_Group() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Patternset() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Lib() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Includes() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Include() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Excludes() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Exclude() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_IncludesList() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Includesfile() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesAssemblyFileSet_Excludesfile() {
        return (EReference)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_Basedir() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_Casesensitive() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_Defaultexcludes() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_Failonempty() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_Id() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_Refid() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesAssemblyFileSet_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesAssemblyFileSet().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesCompilerWarning() {
		if (nAntDotNetTypesCompilerWarningEClass == null) {
			nAntDotNetTypesCompilerWarningEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(88);
		}
		return nAntDotNetTypesCompilerWarningEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesCompilerWarning_If() {
        return (EAttribute)getNAntDotNetTypesCompilerWarning().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesCompilerWarning_Number() {
        return (EAttribute)getNAntDotNetTypesCompilerWarning().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesCompilerWarning_Unless() {
        return (EAttribute)getNAntDotNetTypesCompilerWarning().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesCompilerWarning_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesCompilerWarning().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesLibDirectorySet() {
		if (nAntDotNetTypesLibDirectorySetEClass == null) {
			nAntDotNetTypesLibDirectorySetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(89);
		}
		return nAntDotNetTypesLibDirectorySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesLibDirectorySet_Group() {
        return (EAttribute)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_Patternset() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_Includes() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_Include() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_Excludes() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_Exclude() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_IncludesList() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_Includesfile() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesLibDirectorySet_Excludesfile() {
        return (EReference)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesLibDirectorySet_Casesensitive() {
        return (EAttribute)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesLibDirectorySet_Defaultexcludes() {
        return (EAttribute)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesLibDirectorySet_Failonempty() {
        return (EAttribute)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesLibDirectorySet_Id() {
        return (EAttribute)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesLibDirectorySet_Refid() {
        return (EAttribute)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesLibDirectorySet_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesLibDirectorySet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesModule() {
		if (nAntDotNetTypesModuleEClass == null) {
			nAntDotNetTypesModuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(90);
		}
		return nAntDotNetTypesModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModule_File() {
        return (EAttribute)getNAntDotNetTypesModule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModule_Target() {
        return (EAttribute)getNAntDotNetTypesModule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModule_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesModule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesModuleSet() {
		if (nAntDotNetTypesModuleSetEClass == null) {
			nAntDotNetTypesModuleSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(91);
		}
		return nAntDotNetTypesModuleSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModuleSet_Group() {
        return (EAttribute)getNAntDotNetTypesModuleSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesModuleSet_Module() {
        return (EReference)getNAntDotNetTypesModuleSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModuleSet_Dir() {
        return (EAttribute)getNAntDotNetTypesModuleSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModuleSet_Id() {
        return (EAttribute)getNAntDotNetTypesModuleSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModuleSet_Refid() {
        return (EAttribute)getNAntDotNetTypesModuleSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesModuleSet_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesModuleSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesNamespaceImport() {
		if (nAntDotNetTypesNamespaceImportEClass == null) {
			nAntDotNetTypesNamespaceImportEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(92);
		}
		return nAntDotNetTypesNamespaceImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImport_If() {
        return (EAttribute)getNAntDotNetTypesNamespaceImport().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImport_Name() {
        return (EAttribute)getNAntDotNetTypesNamespaceImport().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImport_Namespace() {
        return (EAttribute)getNAntDotNetTypesNamespaceImport().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImport_Unless() {
        return (EAttribute)getNAntDotNetTypesNamespaceImport().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImport_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesNamespaceImport().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesNamespaceImportCollection() {
		if (nAntDotNetTypesNamespaceImportCollectionEClass == null) {
			nAntDotNetTypesNamespaceImportCollectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(93);
		}
		return nAntDotNetTypesNamespaceImportCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImportCollection_Group() {
        return (EAttribute)getNAntDotNetTypesNamespaceImportCollection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesNamespaceImportCollection_Import() {
        return (EReference)getNAntDotNetTypesNamespaceImportCollection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImportCollection_Id() {
        return (EAttribute)getNAntDotNetTypesNamespaceImportCollection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImportCollection_Refid() {
        return (EAttribute)getNAntDotNetTypesNamespaceImportCollection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesNamespaceImportCollection_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesNamespaceImportCollection().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesPackage() {
		if (nAntDotNetTypesPackageEClass == null) {
			nAntDotNetTypesPackageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(94);
		}
		return nAntDotNetTypesPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesPackage_If() {
        return (EAttribute)getNAntDotNetTypesPackage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesPackage_Name() {
        return (EAttribute)getNAntDotNetTypesPackage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesPackage_Unless() {
        return (EAttribute)getNAntDotNetTypesPackage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesPackage_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesPackage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesResourceFileSet() {
		if (nAntDotNetTypesResourceFileSetEClass == null) {
			nAntDotNetTypesResourceFileSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(95);
		}
		return nAntDotNetTypesResourceFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Group() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_Patternset() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_Includes() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_Include() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_Excludes() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_Exclude() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_IncludesList() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_Includesfile() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesResourceFileSet_Excludesfile() {
        return (EReference)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Basedir() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Casesensitive() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Defaultexcludes() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Dynamicprefix() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Failonempty() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Id() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Prefix() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_Refid() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesResourceFileSet_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesResourceFileSet().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntDotNetTypesWarningAsError() {
		if (nAntDotNetTypesWarningAsErrorEClass == null) {
			nAntDotNetTypesWarningAsErrorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(96);
		}
		return nAntDotNetTypesWarningAsErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesWarningAsError_Group() {
        return (EAttribute)getNAntDotNetTypesWarningAsError().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesWarningAsError_Include() {
        return (EReference)getNAntDotNetTypesWarningAsError().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntDotNetTypesWarningAsError_Exclude() {
        return (EReference)getNAntDotNetTypesWarningAsError().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesWarningAsError_Id() {
        return (EAttribute)getNAntDotNetTypesWarningAsError().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesWarningAsError_Refid() {
        return (EAttribute)getNAntDotNetTypesWarningAsError().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntDotNetTypesWarningAsError_AnyAttribute() {
        return (EAttribute)getNAntDotNetTypesWarningAsError().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntMSNetTasksIldasmTask() {
		if (nAntMSNetTasksIldasmTaskEClass == null) {
			nAntMSNetTasksIldasmTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(97);
		}
		return nAntMSNetTasksIldasmTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Group() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntMSNetTasksIldasmTask_Assemblies() {
        return (EReference)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_All() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Bytes() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Failonerror() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Header() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_If() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Input() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Item() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Linenumbers() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Noil() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Output() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Publiconly() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Quoteallnames() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Rawexceptionhandling() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Rebuild() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Source() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Timeout() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Todir() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Tokens() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Unicode() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Unless() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Utf8() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Verbose() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_Visibility() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksIldasmTask_AnyAttribute() {
        return (EAttribute)getNAntMSNetTasksIldasmTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntMSNetTasksServiceControllerTask() {
		if (nAntMSNetTasksServiceControllerTaskEClass == null) {
			nAntMSNetTasksServiceControllerTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(98);
		}
		return nAntMSNetTasksServiceControllerTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_Action() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_Failonerror() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_If() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_Machine() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_Service() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_Timeout() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_Unless() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_Verbose() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntMSNetTasksServiceControllerTask_AnyAttribute() {
        return (EAttribute)getNAntMSNetTasksServiceControllerTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntNUnit1TasksNUnitTask() {
		if (nAntNUnit1TasksNUnitTaskEClass == null) {
			nAntNUnit1TasksNUnitTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(99);
		}
		return nAntNUnit1TasksNUnitTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_Group() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit1TasksNUnitTask_Test() {
        return (EReference)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit1TasksNUnitTask_Formatter() {
        return (EReference)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_Failonerror() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_Haltonerror() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_Haltonfailure() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_If() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_Timeout() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_Unless() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_Verbose() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TasksNUnitTask_AnyAttribute() {
        return (EAttribute)getNAntNUnit1TasksNUnitTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntNUnit1TypesNUnitTest() {
		if (nAntNUnit1TypesNUnitTestEClass == null) {
			nAntNUnit1TypesNUnitTestEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(100);
		}
		return nAntNUnit1TypesNUnitTestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Appconfig() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Assembly() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Class() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Fork() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Haltonerror() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Haltonfailure() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Outfile() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_Todir() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit1TypesNUnitTest_AnyAttribute() {
        return (EAttribute)getNAntNUnit1TypesNUnitTest().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntNUnit2TasksNUnit2Task() {
		if (nAntNUnit2TasksNUnit2TaskEClass == null) {
			nAntNUnit2TasksNUnit2TaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(101);
		}
		return nAntNUnit2TasksNUnit2TaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TasksNUnit2Task_Group() {
        return (EAttribute)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit2TasksNUnit2Task_Test() {
        return (EReference)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit2TasksNUnit2Task_Formatter() {
        return (EReference)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TasksNUnit2Task_Failonerror() {
        return (EAttribute)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TasksNUnit2Task_Haltonfailure() {
        return (EAttribute)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TasksNUnit2Task_If() {
        return (EAttribute)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TasksNUnit2Task_Unless() {
        return (EAttribute)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TasksNUnit2Task_Verbose() {
        return (EAttribute)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TasksNUnit2Task_AnyAttribute() {
        return (EAttribute)getNAntNUnit2TasksNUnit2Task().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntNUnit2TypesCategories() {
		if (nAntNUnit2TypesCategoriesEClass == null) {
			nAntNUnit2TypesCategoriesEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(102);
		}
		return nAntNUnit2TypesCategoriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategories_Group() {
        return (EAttribute)getNAntNUnit2TypesCategories().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit2TypesCategories_Include() {
        return (EReference)getNAntNUnit2TypesCategories().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit2TypesCategories_Exclude() {
        return (EReference)getNAntNUnit2TypesCategories().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategories_Id() {
        return (EAttribute)getNAntNUnit2TypesCategories().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategories_Refid() {
        return (EAttribute)getNAntNUnit2TypesCategories().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategories_AnyAttribute() {
        return (EAttribute)getNAntNUnit2TypesCategories().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntNUnit2TypesCategory() {
		if (nAntNUnit2TypesCategoryEClass == null) {
			nAntNUnit2TypesCategoryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(103);
		}
		return nAntNUnit2TypesCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategory_If() {
        return (EAttribute)getNAntNUnit2TypesCategory().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategory_Name() {
        return (EAttribute)getNAntNUnit2TypesCategory().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategory_Unless() {
        return (EAttribute)getNAntNUnit2TypesCategory().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesCategory_AnyAttribute() {
        return (EAttribute)getNAntNUnit2TypesCategory().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntNUnit2TypesNUnit2Test() {
		if (nAntNUnit2TypesNUnit2TestEClass == null) {
			nAntNUnit2TypesNUnit2TestEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(104);
		}
		return nAntNUnit2TypesNUnit2TestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesNUnit2Test_Group() {
        return (EAttribute)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit2TypesNUnit2Test_Assemblies() {
        return (EReference)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntNUnit2TypesNUnit2Test_Categories() {
        return (EReference)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesNUnit2Test_Appconfig() {
        return (EAttribute)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesNUnit2Test_Assemblyname() {
        return (EAttribute)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesNUnit2Test_Haltonfailure() {
        return (EAttribute)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesNUnit2Test_Testname() {
        return (EAttribute)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesNUnit2Test_Transformfile() {
        return (EAttribute)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnit2TypesNUnit2Test_AnyAttribute() {
        return (EAttribute)getNAntNUnit2TypesNUnit2Test().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntNUnitTypesFormatterElement() {
		if (nAntNUnitTypesFormatterElementEClass == null) {
			nAntNUnitTypesFormatterElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(105);
		}
		return nAntNUnitTypesFormatterElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnitTypesFormatterElement_Extension() {
        return (EAttribute)getNAntNUnitTypesFormatterElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnitTypesFormatterElement_Outputdir() {
        return (EAttribute)getNAntNUnitTypesFormatterElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnitTypesFormatterElement_Type() {
        return (EAttribute)getNAntNUnitTypesFormatterElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnitTypesFormatterElement_Usefile() {
        return (EAttribute)getNAntNUnitTypesFormatterElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntNUnitTypesFormatterElement_AnyAttribute() {
        return (EAttribute)getNAntNUnitTypesFormatterElement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksChangeLogTask() {
		if (nAntSourceControlTasksChangeLogTaskEClass == null) {
			nAntSourceControlTasksChangeLogTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(106);
		}
		return nAntSourceControlTasksChangeLogTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Group() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksChangeLogTask_Fileset() {
        return (EReference)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksChangeLogTask_Arg() {
        return (EReference)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Commandline() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Compressionlevel() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Cvsfullpath() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Cvsrsh() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Destination() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_End() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_If() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Module() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Passfile() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Password() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Quiet() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Readonly() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Readwrite() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Reallyquiet() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Start() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Timeout() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Unless() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Verbose() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_Xmlfile() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksChangeLogTask_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksChangeLogTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksCheckoutTask() {
		if (nAntSourceControlTasksCheckoutTaskEClass == null) {
			nAntSourceControlTasksCheckoutTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(107);
		}
		return nAntSourceControlTasksCheckoutTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Group() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksCheckoutTask_Fileset() {
        return (EReference)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksCheckoutTask_Arg() {
        return (EReference)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Commandline() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Compressionlevel() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Cvsfullpath() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Cvsrsh() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Date() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Destination() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_If() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Module() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Overridedir() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_OverrideDirectory() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Passfile() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Password() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Quiet() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Readonly() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Readwrite() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Reallyquiet() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Revision() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_StickyTag() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Timeout() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Unless() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Usesharpcvslib() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_Verbose() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCheckoutTask_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksCheckoutTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksCvsPass() {
		if (nAntSourceControlTasksCvsPassEClass == null) {
			nAntSourceControlTasksCvsPassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(108);
		}
		return nAntSourceControlTasksCvsPassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_If() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_Passfile() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_Password() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_Unless() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_Verbose() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsPass_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksCvsPass().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksCvsTask() {
		if (nAntSourceControlTasksCvsTaskEClass == null) {
			nAntSourceControlTasksCvsTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(109);
		}
		return nAntSourceControlTasksCvsTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Group() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksCvsTask_Fileset() {
        return (EReference)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksCvsTask_Arg() {
        return (EReference)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Command() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Commandline() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Compressionlevel() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Cvsfullpath() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Cvsrsh() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Destination() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_If() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Module() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Passfile() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Password() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Quiet() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Readonly() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Readwrite() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Reallyquiet() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Timeout() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Unless() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Usesharpcvslib() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_Verbose() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksCvsTask_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksCvsTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksExportTask() {
		if (nAntSourceControlTasksExportTaskEClass == null) {
			nAntSourceControlTasksExportTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(110);
		}
		return nAntSourceControlTasksExportTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Group() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksExportTask_Fileset() {
        return (EReference)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksExportTask_Arg() {
        return (EReference)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Commandline() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Compressionlevel() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Cvsfullpath() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Cvsrsh() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Date() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Destination() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_ForceHead() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_If() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Module() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_NoShortening() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Overridedir() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Passfile() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Password() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Quiet() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Readonly() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Readwrite() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Reallyquiet() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Recursive() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Revision() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Timeout() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Unless() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Usesharpcvslib() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_Verbose() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksExportTask_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksExportTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksRTagTask() {
		if (nAntSourceControlTasksRTagTaskEClass == null) {
			nAntSourceControlTasksRTagTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(111);
		}
		return nAntSourceControlTasksRTagTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Group() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksRTagTask_Fileset() {
        return (EReference)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksRTagTask_Arg() {
        return (EReference)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_ActOnDate() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_ActOnTag() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Commandline() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Compressionlevel() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Cvsfullpath() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Cvsrsh() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Destination() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_ForceHead() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_If() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Module() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_MoveIfExists() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Passfile() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Password() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Quiet() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Readonly() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Readwrite() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Reallyquiet() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Recursive() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Remove() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Tag() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Timeout() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Unless() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Usesharpcvslib() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_Verbose() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksRTagTask_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksRTagTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksTagTask() {
		if (nAntSourceControlTasksTagTaskEClass == null) {
			nAntSourceControlTasksTagTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(112);
		}
		return nAntSourceControlTasksTagTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Group() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksTagTask_Fileset() {
        return (EReference)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksTagTask_Arg() {
        return (EReference)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_ActOnDate() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_ActOnTag() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Commandline() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Compressionlevel() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Cvsfullpath() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Cvsrsh() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Destination() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_FailIfModified() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_ForceHead() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_If() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_MoveIfExists() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Passfile() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Password() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Quiet() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Readonly() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Readwrite() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Reallyquiet() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Recursive() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Remove() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Tag() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Timeout() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Unless() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Usesharpcvslib() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_Verbose() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksTagTask_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksTagTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTasksUpdateTask() {
		if (nAntSourceControlTasksUpdateTaskEClass == null) {
			nAntSourceControlTasksUpdateTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(113);
		}
		return nAntSourceControlTasksUpdateTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Group() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksUpdateTask_Fileset() {
        return (EReference)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTasksUpdateTask_Arg() {
        return (EReference)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Builddirs() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Commandline() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Compressionlevel() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Cvsfullpath() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Cvsroot() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Cvsrsh() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Date() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Destination() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Failonerror() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_If() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Module() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Overwritelocal() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Passfile() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Password() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Pruneempty() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Quiet() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Readonly() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Readwrite() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Reallyquiet() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Recursive() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Revision() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_StickyTag() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Timeout() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Unless() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Usesharpcvslib() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_Verbose() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTasksUpdateTask_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTasksUpdateTask().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntSourceControlTypesCvsFileSet() {
		if (nAntSourceControlTypesCvsFileSetEClass == null) {
			nAntSourceControlTypesCvsFileSetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(114);
		}
		return nAntSourceControlTypesCvsFileSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Group() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_Patternset() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_Includes() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_Include() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_Excludes() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_Exclude() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_IncludesList() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_Includesfile() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntSourceControlTypesCvsFileSet_Excludesfile() {
        return (EReference)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Basedir() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Casesensitive() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Defaultexcludes() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Failonempty() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Id() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Refid() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_Usecvsignore() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntSourceControlTypesCvsFileSet_AnyAttribute() {
        return (EAttribute)getNAntSourceControlTypesCvsFileSet().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTasksClTask() {
		if (nAntVisualCppTasksClTaskEClass == null) {
			nAntVisualCppTasksClTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(115);
		}
		return nAntVisualCppTasksClTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Group() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksClTask_Sources() {
        return (EReference)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksClTask_Includedirs() {
        return (EReference)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksClTask_Metadataincludedirs() {
        return (EReference)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksClTask_Forcedusingfiles() {
        return (EReference)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksClTask_Defines() {
        return (EReference)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksClTask_Undefines() {
        return (EReference)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksClTask_Arg() {
        return (EReference)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Characterset() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Failonerror() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_If() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Managedextensions() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Objectfile() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Options() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Outputdir() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Pchfile() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Pchmode() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Pchthroughfile() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Pdbfile() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Timeout() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Unless() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_Verbose() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksClTask_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTasksClTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTasksLibTask() {
		if (nAntVisualCppTasksLibTaskEClass == null) {
			nAntVisualCppTasksLibTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(116);
		}
		return nAntVisualCppTasksLibTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Group() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLibTask_Sources() {
        return (EReference)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLibTask_Symbols() {
        return (EReference)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLibTask_Ignorelibraries() {
        return (EReference)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLibTask_Libdirs() {
        return (EReference)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLibTask_Arg() {
        return (EReference)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Failonerror() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_If() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Moduledefinition() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Options() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Output() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Timeout() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Unless() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_Verbose() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLibTask_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTasksLibTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTasksLinkTask() {
		if (nAntVisualCppTasksLinkTaskEClass == null) {
			nAntVisualCppTasksLinkTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(117);
		}
		return nAntVisualCppTasksLinkTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Group() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Delayloaded() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Sources() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Libdirs() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Modules() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Embeddedresources() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Symbols() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Ignorelibraries() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksLinkTask_Arg() {
        return (EReference)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Failonerror() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_If() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Options() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Output() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Pdbfile() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Timeout() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Unless() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_Verbose() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksLinkTask_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTasksLinkTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTasksMcTask() {
		if (nAntVisualCppTasksMcTaskEClass == null) {
			nAntVisualCppTasksMcTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(118);
		}
		return nAntVisualCppTasksMcTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Group() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksMcTask_Arg() {
        return (EReference)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Failonerror() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Headerpath() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_If() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Mcfile() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Options() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Rcpath() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Timeout() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Unless() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_Verbose() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMcTask_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTasksMcTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTasksMidlTask() {
		if (nAntVisualCppTasksMidlTaskEClass == null) {
			nAntVisualCppTasksMidlTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(119);
		}
		return nAntVisualCppTasksMidlTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Group() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksMidlTask_Options() {
        return (EReference)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksMidlTask_Defines() {
        return (EReference)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksMidlTask_Undefines() {
        return (EReference)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksMidlTask_Includedirs() {
        return (EReference)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksMidlTask_Arg() {
        return (EReference)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Acf() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Align() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_AppConfig() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Char() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Client() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Cstub() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Dlldata() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Env() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Failonerror() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Filename() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Header() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_If() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Iid() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Oi() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Proxy() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Timeout() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Tlb() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Unless() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_Verbose() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksMidlTask_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTasksMidlTask().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTasksRcTask() {
		if (nAntVisualCppTasksRcTaskEClass == null) {
			nAntVisualCppTasksRcTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(120);
		}
		return nAntVisualCppTasksRcTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Group() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksRcTask_Includedirs() {
        return (EReference)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksRcTask_Defines() {
        return (EReference)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVisualCppTasksRcTask_Arg() {
        return (EReference)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Failonerror() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_If() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Langid() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Options() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Output() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Rcfile() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Timeout() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Unless() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_Verbose() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTasksRcTask_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTasksRcTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTypesLibrary() {
		if (nAntVisualCppTypesLibraryEClass == null) {
			nAntVisualCppTypesLibraryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(121);
		}
		return nAntVisualCppTypesLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesLibrary_If() {
        return (EAttribute)getNAntVisualCppTypesLibrary().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesLibrary_Name() {
        return (EAttribute)getNAntVisualCppTypesLibrary().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesLibrary_Unless() {
        return (EAttribute)getNAntVisualCppTypesLibrary().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesLibrary_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTypesLibrary().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVisualCppTypesSymbol() {
		if (nAntVisualCppTypesSymbolEClass == null) {
			nAntVisualCppTypesSymbolEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(122);
		}
		return nAntVisualCppTypesSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesSymbol_If() {
        return (EAttribute)getNAntVisualCppTypesSymbol().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesSymbol_Name() {
        return (EAttribute)getNAntVisualCppTypesSymbol().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesSymbol_Unless() {
        return (EAttribute)getNAntVisualCppTypesSymbol().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVisualCppTypesSymbol_AnyAttribute() {
        return (EAttribute)getNAntVisualCppTypesSymbol().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVSNetTasksSolutionTask() {
		if (nAntVSNetTasksSolutionTaskEClass == null) {
			nAntVSNetTasksSolutionTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(123);
		}
		return nAntVSNetTasksSolutionTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Group() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVSNetTasksSolutionTask_Projects() {
        return (EReference)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVSNetTasksSolutionTask_Referenceprojects() {
        return (EReference)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVSNetTasksSolutionTask_Webmap() {
        return (EReference)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVSNetTasksSolutionTask_Excludeprojects() {
        return (EReference)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntVSNetTasksSolutionTask_Assemblyfolders() {
        return (EReference)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Configuration() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Enablewebdav() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Failonerror() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_If() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Includevsfolders() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Outputdir() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Solutionfile() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Unless() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_Verbose() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTasksSolutionTask_AnyAttribute() {
        return (EAttribute)getNAntVSNetTasksSolutionTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntVSNetTypesWebMap() {
		if (nAntVSNetTypesWebMapEClass == null) {
			nAntVSNetTypesWebMapEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(124);
		}
		return nAntVSNetTypesWebMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTypesWebMap_Casesensitive() {
        return (EAttribute)getNAntVSNetTypesWebMap().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTypesWebMap_If() {
        return (EAttribute)getNAntVSNetTypesWebMap().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTypesWebMap_Path() {
        return (EAttribute)getNAntVSNetTypesWebMap().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTypesWebMap_Unless() {
        return (EAttribute)getNAntVSNetTypesWebMap().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTypesWebMap_Url() {
        return (EAttribute)getNAntVSNetTypesWebMap().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntVSNetTypesWebMap_AnyAttribute() {
        return (EAttribute)getNAntVSNetTypesWebMap().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntWin32TasksAxImpTask() {
		if (nAntWin32TasksAxImpTaskEClass == null) {
			nAntWin32TasksAxImpTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(125);
		}
		return nAntWin32TasksAxImpTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Group() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntWin32TasksAxImpTask_Arg() {
        return (EReference)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Delaysign() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Failonerror() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Generatesource() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_If() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Keycontainer() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Keyfile() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Ocx() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Output() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Publickey() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Rcw() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Timeout() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Unless() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_Verbose() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksAxImpTask_AnyAttribute() {
        return (EAttribute)getNAntWin32TasksAxImpTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntWin32TasksReadRegistryTask() {
		if (nAntWin32TasksReadRegistryTaskEClass == null) {
			nAntWin32TasksReadRegistryTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(126);
		}
		return nAntWin32TasksReadRegistryTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_Failonerror() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_Hive() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_If() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_Key() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_Prefix() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_Property() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_Unless() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_Verbose() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksReadRegistryTask_AnyAttribute() {
        return (EAttribute)getNAntWin32TasksReadRegistryTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntWin32TasksRegAsmTask() {
		if (nAntWin32TasksRegAsmTaskEClass == null) {
			nAntWin32TasksRegAsmTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(127);
		}
		return nAntWin32TasksRegAsmTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Group() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntWin32TasksRegAsmTask_Assemblies() {
        return (EReference)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntWin32TasksRegAsmTask_References() {
        return (EReference)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntWin32TasksRegAsmTask_Arg() {
        return (EReference)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Assembly() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Codebase() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Failonerror() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_If() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Regfile() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Registered() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Timeout() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Typelib() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Unless() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Unregister() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_Verbose() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksRegAsmTask_AnyAttribute() {
        return (EAttribute)getNAntWin32TasksRegAsmTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntWin32TasksTlbExpTask() {
		if (nAntWin32TasksTlbExpTaskEClass == null) {
			nAntWin32TasksTlbExpTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(128);
		}
		return nAntWin32TasksTlbExpTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Group() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntWin32TasksTlbExpTask_Arg() {
        return (EReference)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Assembly() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Failonerror() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_If() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Names() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Output() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Timeout() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Unless() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_Verbose() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbExpTask_AnyAttribute() {
        return (EAttribute)getNAntWin32TasksTlbExpTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAntWin32TasksTlbImpTask() {
		if (nAntWin32TasksTlbImpTaskEClass == null) {
			nAntWin32TasksTlbImpTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(129);
		}
		return nAntWin32TasksTlbImpTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Group() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntWin32TasksTlbImpTask_References() {
        return (EReference)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNAntWin32TasksTlbImpTask_Arg() {
        return (EReference)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Asmversion() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Delaysign() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Failonerror() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_If() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Keycontainer() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Keyfile() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Namespace() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Output() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Primary() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Publickey() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Strictref() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Sysarray() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Timeout() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Transform() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Typelib() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Unless() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Unsafe() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_Verbose() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNAntWin32TasksTlbImpTask_AnyAttribute() {
        return (EAttribute)getNAntWin32TasksTlbImpTask().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNowarnType() {
		if (nowarnTypeEClass == null) {
			nowarnTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(130);
		}
		return nowarnTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNowarnType_Group() {
        return (EAttribute)getNowarnType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNowarnType_Warning() {
        return (EReference)getNowarnType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNowarnType1() {
		if (nowarnType1EClass == null) {
			nowarnType1EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(131);
		}
		return nowarnType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNowarnType1_Group() {
        return (EAttribute)getNowarnType1().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNowarnType1_Warning() {
        return (EReference)getNowarnType1().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNowarnType2() {
		if (nowarnType2EClass == null) {
			nowarnType2EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(132);
		}
		return nowarnType2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNowarnType2_Group() {
        return (EAttribute)getNowarnType2().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNowarnType2_Warning() {
        return (EReference)getNowarnType2().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptionsType() {
		if (optionsTypeEClass == null) {
			optionsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(133);
		}
		return optionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionsType_Group() {
        return (EAttribute)getOptionsType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptionsType_Option() {
        return (EReference)getOptionsType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametersType() {
		if (parametersTypeEClass == null) {
			parametersTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(134);
		}
		return parametersTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParametersType_Group() {
        return (EAttribute)getParametersType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametersType_Parameter() {
        return (EReference)getParametersType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPkgReferencesType() {
		if (pkgReferencesTypeEClass == null) {
			pkgReferencesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(135);
		}
		return pkgReferencesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPkgReferencesType_Group() {
        return (EAttribute)getPkgReferencesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPkgReferencesType_Package() {
        return (EReference)getPkgReferencesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPkgReferencesType1() {
		if (pkgReferencesType1EClass == null) {
			pkgReferencesType1EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(136);
		}
		return pkgReferencesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPkgReferencesType1_Group() {
        return (EAttribute)getPkgReferencesType1().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPkgReferencesType1_Package() {
        return (EReference)getPkgReferencesType1().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPkgReferencesType2() {
		if (pkgReferencesType2EClass == null) {
			pkgReferencesType2EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(137);
		}
		return pkgReferencesType2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPkgReferencesType2_Group() {
        return (EAttribute)getPkgReferencesType2().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPkgReferencesType2_Package() {
        return (EReference)getPkgReferencesType2().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectType() {
		if (projectTypeEClass == null) {
			projectTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(138);
		}
		return projectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectType_Group() {
        return (EAttribute)getProjectType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Asminfo() {
        return (EReference)getProjectType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Al() {
        return (EReference)getProjectType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Csc() {
        return (EReference)getProjectType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_DelaySign() {
        return (EReference)getProjectType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Ilasm() {
        return (EReference)getProjectType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Jsc() {
        return (EReference)getProjectType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_License() {
        return (EReference)getProjectType().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Ndoc() {
        return (EReference)getProjectType().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Regsvcs() {
        return (EReference)getProjectType().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Resgen() {
        return (EReference)getProjectType().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Script() {
        return (EReference)getProjectType().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Vbc() {
        return (EReference)getProjectType().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Vjc() {
        return (EReference)getProjectType().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Gunzip() {
        return (EReference)getProjectType().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Tar() {
        return (EReference)getProjectType().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Unzip() {
        return (EReference)getProjectType().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Zip() {
        return (EReference)getProjectType().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Nunit() {
        return (EReference)getProjectType().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Nunit2() {
        return (EReference)getProjectType().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_CvsChangelog() {
        return (EReference)getProjectType().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_CvsCheckout() {
        return (EReference)getProjectType().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_CvsPass() {
        return (EReference)getProjectType().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Cvs() {
        return (EReference)getProjectType().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_CvsExport() {
        return (EReference)getProjectType().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_CvsRtag() {
        return (EReference)getProjectType().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_CvsTag() {
        return (EReference)getProjectType().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_CvsUpdate() {
        return (EReference)getProjectType().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Aximp() {
        return (EReference)getProjectType().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Readregistry() {
        return (EReference)getProjectType().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Regasm() {
        return (EReference)getProjectType().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Tlbexp() {
        return (EReference)getProjectType().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Tlbimp() {
        return (EReference)getProjectType().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Cl() {
        return (EReference)getProjectType().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Lib() {
        return (EReference)getProjectType().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Link() {
        return (EReference)getProjectType().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Mc() {
        return (EReference)getProjectType().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Midl() {
        return (EReference)getProjectType().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Rc() {
        return (EReference)getProjectType().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Solution() {
        return (EReference)getProjectType().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Testtask() {
        return (EReference)getProjectType().getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_ElementTest1() {
        return (EReference)getProjectType().getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Test() {
        return (EReference)getProjectType().getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Attrib() {
        return (EReference)getProjectType().getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Available() {
        return (EReference)getProjectType().getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Call() {
        return (EReference)getProjectType().getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Copy() {
        return (EReference)getProjectType().getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Delete() {
        return (EReference)getProjectType().getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Description() {
        return (EReference)getProjectType().getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Echo() {
        return (EReference)getProjectType().getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Exec() {
        return (EReference)getProjectType().getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Fail() {
        return (EReference)getProjectType().getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Get() {
        return (EReference)getProjectType().getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_If() {
        return (EReference)getProjectType().getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Ifnot() {
        return (EReference)getProjectType().getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Include() {
        return (EReference)getProjectType().getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Loadfile() {
        return (EReference)getProjectType().getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Loadtasks() {
        return (EReference)getProjectType().getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Foreach() {
        return (EReference)getProjectType().getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Mail() {
        return (EReference)getProjectType().getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Mkdir() {
        return (EReference)getProjectType().getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Move() {
        return (EReference)getProjectType().getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Nantschema() {
        return (EReference)getProjectType().getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Nant() {
        return (EReference)getProjectType().getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Property() {
        return (EReference)getProjectType().getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Regex() {
        return (EReference)getProjectType().getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Setenv() {
        return (EReference)getProjectType().getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Sleep() {
        return (EReference)getProjectType().getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Style() {
        return (EReference)getProjectType().getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Sysinfo() {
        return (EReference)getProjectType().getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Tstamp() {
        return (EReference)getProjectType().getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Touch() {
        return (EReference)getProjectType().getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Uptodate() {
        return (EReference)getProjectType().getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Xmlpeek() {
        return (EReference)getProjectType().getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Xmlpoke() {
        return (EReference)getProjectType().getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Ildasm() {
        return (EReference)getProjectType().getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Servicecontroller() {
        return (EReference)getProjectType().getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Assemblyfileset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Moduleset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Namespaceimports() {
        return (EReference)getProjectType().getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Resourcefileset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Warnaserror() {
        return (EReference)getProjectType().getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Tarfileset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Zipfileset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Categories() {
        return (EReference)getProjectType().getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Cvsfileset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Filterchain() {
        return (EReference)getProjectType().getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Credential() {
        return (EReference)getProjectType().getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Fileset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Dirset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Path() {
        return (EReference)getProjectType().getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Patternset() {
        return (EReference)getProjectType().getEStructuralFeatures().get(91);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Proxy() {
        return (EReference)getProjectType().getEStructuralFeatures().get(92);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectType_Target() {
        return (EReference)getProjectType().getEStructuralFeatures().get(93);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectType_Any() {
        return (EAttribute)getProjectType().getEStructuralFeatures().get(94);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectType_Basedir() {
        return (EAttribute)getProjectType().getEStructuralFeatures().get(95);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectType_Default() {
        return (EAttribute)getProjectType().getEStructuralFeatures().get(96);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectType_Name() {
        return (EAttribute)getProjectType().getEStructuralFeatures().get(97);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesType() {
		if (propertiesTypeEClass == null) {
			propertiesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(139);
		}
		return propertiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesType_Group() {
        return (EAttribute)getPropertiesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertiesType_Property() {
        return (EReference)getPropertiesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSymbolsType() {
		if (symbolsTypeEClass == null) {
			symbolsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(140);
		}
		return symbolsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSymbolsType_Group() {
        return (EAttribute)getSymbolsType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymbolsType_Symbol() {
        return (EReference)getSymbolsType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSymbolsType1() {
		if (symbolsType1EClass == null) {
			symbolsType1EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(141);
		}
		return symbolsType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSymbolsType1_Group() {
        return (EAttribute)getSymbolsType1().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymbolsType1_Symbol() {
        return (EReference)getSymbolsType1().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		if (targetEClass == null) {
			targetEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(142);
		}
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Group() {
        return (EAttribute)getTarget().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Asminfo() {
        return (EReference)getTarget().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Al() {
        return (EReference)getTarget().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Csc() {
        return (EReference)getTarget().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_DelaySign() {
        return (EReference)getTarget().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Ilasm() {
        return (EReference)getTarget().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Jsc() {
        return (EReference)getTarget().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_License() {
        return (EReference)getTarget().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Ndoc() {
        return (EReference)getTarget().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Regsvcs() {
        return (EReference)getTarget().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Resgen() {
        return (EReference)getTarget().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Script() {
        return (EReference)getTarget().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Vbc() {
        return (EReference)getTarget().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Vjc() {
        return (EReference)getTarget().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Gunzip() {
        return (EReference)getTarget().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Tar() {
        return (EReference)getTarget().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Unzip() {
        return (EReference)getTarget().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Zip() {
        return (EReference)getTarget().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Nunit() {
        return (EReference)getTarget().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Nunit2() {
        return (EReference)getTarget().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_CvsChangelog() {
        return (EReference)getTarget().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_CvsCheckout() {
        return (EReference)getTarget().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_CvsPass() {
        return (EReference)getTarget().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Cvs() {
        return (EReference)getTarget().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_CvsExport() {
        return (EReference)getTarget().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_CvsRtag() {
        return (EReference)getTarget().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_CvsTag() {
        return (EReference)getTarget().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_CvsUpdate() {
        return (EReference)getTarget().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Aximp() {
        return (EReference)getTarget().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Readregistry() {
        return (EReference)getTarget().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Regasm() {
        return (EReference)getTarget().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Tlbexp() {
        return (EReference)getTarget().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Tlbimp() {
        return (EReference)getTarget().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Cl() {
        return (EReference)getTarget().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Lib() {
        return (EReference)getTarget().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Link() {
        return (EReference)getTarget().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Mc() {
        return (EReference)getTarget().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Midl() {
        return (EReference)getTarget().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Rc() {
        return (EReference)getTarget().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Solution() {
        return (EReference)getTarget().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Testtask() {
        return (EReference)getTarget().getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_ElementTest1() {
        return (EReference)getTarget().getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Test() {
        return (EReference)getTarget().getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Attrib() {
        return (EReference)getTarget().getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Available() {
        return (EReference)getTarget().getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Call() {
        return (EReference)getTarget().getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Copy() {
        return (EReference)getTarget().getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Delete() {
        return (EReference)getTarget().getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Description() {
        return (EReference)getTarget().getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Echo() {
        return (EReference)getTarget().getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Exec() {
        return (EReference)getTarget().getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Fail() {
        return (EReference)getTarget().getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Get() {
        return (EReference)getTarget().getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_If() {
        return (EReference)getTarget().getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Ifnot() {
        return (EReference)getTarget().getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Include() {
        return (EReference)getTarget().getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Loadfile() {
        return (EReference)getTarget().getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Loadtasks() {
        return (EReference)getTarget().getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Foreach() {
        return (EReference)getTarget().getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Mail() {
        return (EReference)getTarget().getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Mkdir() {
        return (EReference)getTarget().getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Move() {
        return (EReference)getTarget().getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Nantschema() {
        return (EReference)getTarget().getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Nant() {
        return (EReference)getTarget().getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Property() {
        return (EReference)getTarget().getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Regex() {
        return (EReference)getTarget().getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Setenv() {
        return (EReference)getTarget().getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Sleep() {
        return (EReference)getTarget().getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Style() {
        return (EReference)getTarget().getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Sysinfo() {
        return (EReference)getTarget().getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Tstamp() {
        return (EReference)getTarget().getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Touch() {
        return (EReference)getTarget().getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Uptodate() {
        return (EReference)getTarget().getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Xmlpeek() {
        return (EReference)getTarget().getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Xmlpoke() {
        return (EReference)getTarget().getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Ildasm() {
        return (EReference)getTarget().getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Servicecontroller() {
        return (EReference)getTarget().getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Assemblyfileset() {
        return (EReference)getTarget().getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Moduleset() {
        return (EReference)getTarget().getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Namespaceimports() {
        return (EReference)getTarget().getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Resourcefileset() {
        return (EReference)getTarget().getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Warnaserror() {
        return (EReference)getTarget().getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Tarfileset() {
        return (EReference)getTarget().getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Zipfileset() {
        return (EReference)getTarget().getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Categories() {
        return (EReference)getTarget().getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Cvsfileset() {
        return (EReference)getTarget().getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Filterchain() {
        return (EReference)getTarget().getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Credential() {
        return (EReference)getTarget().getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Fileset() {
        return (EReference)getTarget().getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Dirset() {
        return (EReference)getTarget().getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Path() {
        return (EReference)getTarget().getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Patternset() {
        return (EReference)getTarget().getEStructuralFeatures().get(91);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Proxy() {
        return (EReference)getTarget().getEStructuralFeatures().get(92);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Any() {
        return (EAttribute)getTarget().getEStructuralFeatures().get(93);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Depends() {
        return (EAttribute)getTarget().getEStructuralFeatures().get(94);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Description1() {
        return (EAttribute)getTarget().getEStructuralFeatures().get(95);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_If1() {
        return (EAttribute)getTarget().getEStructuralFeatures().get(96);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Name() {
        return (EAttribute)getTarget().getEStructuralFeatures().get(97);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Unless() {
        return (EAttribute)getTarget().getEStructuralFeatures().get(98);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestsNAntCoreElementTest1Task() {
		if (testsNAntCoreElementTest1TaskEClass == null) {
			testsNAntCoreElementTest1TaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(143);
		}
		return testsNAntCoreElementTest1TaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_Group() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestsNAntCoreElementTest1Task_Fileset() {
        return (EReference)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_Failonerror() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_If() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_Type() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_Unless() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_Uri() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_Verbose() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreElementTest1Task_AnyAttribute() {
        return (EAttribute)getTestsNAntCoreElementTest1Task().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestsNAntCoreTestTask() {
		if (testsNAntCoreTestTaskEClass == null) {
			testsNAntCoreTestTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(144);
		}
		return testsNAntCoreTestTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_Fail() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_Failonerror() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_If() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_Required() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_Requirednotempty() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_Unless() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_Verbose() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreTestTask_AnyAttribute() {
        return (EAttribute)getTestsNAntCoreTestTask().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestsNAntCoreUtilXmlLoggerTestTestTask() {
		if (testsNAntCoreUtilXmlLoggerTestTestTaskEClass == null) {
			testsNAntCoreUtilXmlLoggerTestTestTaskEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(145);
		}
		return testsNAntCoreUtilXmlLoggerTestTestTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreUtilXmlLoggerTestTestTask_Failonerror() {
        return (EAttribute)getTestsNAntCoreUtilXmlLoggerTestTestTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreUtilXmlLoggerTestTestTask_If() {
        return (EAttribute)getTestsNAntCoreUtilXmlLoggerTestTestTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreUtilXmlLoggerTestTestTask_Unless() {
        return (EAttribute)getTestsNAntCoreUtilXmlLoggerTestTestTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreUtilXmlLoggerTestTestTask_Verbose() {
        return (EAttribute)getTestsNAntCoreUtilXmlLoggerTestTestTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsNAntCoreUtilXmlLoggerTestTestTask_AnyAttribute() {
        return (EAttribute)getTestsNAntCoreUtilXmlLoggerTestTestTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUndefinesType() {
		if (undefinesTypeEClass == null) {
			undefinesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(146);
		}
		return undefinesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUndefinesType_Group() {
        return (EAttribute)getUndefinesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUndefinesType_Undefine() {
        return (EReference)getUndefinesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUndefinesType1() {
		if (undefinesType1EClass == null) {
			undefinesType1EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(147);
		}
		return undefinesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUndefinesType1_Group() {
        return (EAttribute)getUndefinesType1().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUndefinesType1_Undefine() {
        return (EReference)getUndefinesType1().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebmapType() {
		if (webmapTypeEClass == null) {
			webmapTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(NantPackage.eNS_URI).getEClassifiers().get(148);
		}
		return webmapTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebmapType_Group() {
        return (EAttribute)getWebmapType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWebmapType_Map() {
        return (EReference)getWebmapType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NantFactory getNantFactory() {
		return (NantFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("net.sf.nant.release._0._86.beta1.nant." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //NantPackageImpl
