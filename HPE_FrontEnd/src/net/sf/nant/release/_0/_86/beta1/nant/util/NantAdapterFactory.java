/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.util;

import net.sf.nant.release._0._86.beta1.nant.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage
 * @generated
 */
public class NantAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NantPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NantAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = NantPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NantSwitch<Adapter> modelSwitch =
		new NantSwitch<Adapter>() {
			@Override
			public Adapter caseAttributesType(AttributesType object) {
				return createAttributesTypeAdapter();
			}
			@Override
			public Adapter caseDefinesType(DefinesType object) {
				return createDefinesTypeAdapter();
			}
			@Override
			public Adapter caseDefinesType1(DefinesType1 object) {
				return createDefinesType1Adapter();
			}
			@Override
			public Adapter caseDefinesType2(DefinesType2 object) {
				return createDefinesType2Adapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseExtensionobjectsType(ExtensionobjectsType object) {
				return createExtensionobjectsTypeAdapter();
			}
			@Override
			public Adapter caseIgnorelibrariesType(IgnorelibrariesType object) {
				return createIgnorelibrariesTypeAdapter();
			}
			@Override
			public Adapter caseIgnorelibrariesType1(IgnorelibrariesType1 object) {
				return createIgnorelibrariesType1Adapter();
			}
			@Override
			public Adapter caseNamespacesType(NamespacesType object) {
				return createNamespacesTypeAdapter();
			}
			@Override
			public Adapter caseNamespacesType1(NamespacesType1 object) {
				return createNamespacesType1Adapter();
			}
			@Override
			public Adapter caseNAntCompressionTasksGUnzip(NAntCompressionTasksGUnzip object) {
				return createNAntCompressionTasksGUnzipAdapter();
			}
			@Override
			public Adapter caseNAntCompressionTasksTarTask(NAntCompressionTasksTarTask object) {
				return createNAntCompressionTasksTarTaskAdapter();
			}
			@Override
			public Adapter caseNAntCompressionTasksUnZipTask(NAntCompressionTasksUnZipTask object) {
				return createNAntCompressionTasksUnZipTaskAdapter();
			}
			@Override
			public Adapter caseNAntCompressionTasksZipTask(NAntCompressionTasksZipTask object) {
				return createNAntCompressionTasksZipTaskAdapter();
			}
			@Override
			public Adapter caseNAntCompressionTypesTarFileSet(NAntCompressionTypesTarFileSet object) {
				return createNAntCompressionTypesTarFileSetAdapter();
			}
			@Override
			public Adapter caseNAntCompressionTypesZipFileSet(NAntCompressionTypesZipFileSet object) {
				return createNAntCompressionTypesZipFileSetAdapter();
			}
			@Override
			public Adapter caseNAntCoreFiltersFilter(NAntCoreFiltersFilter object) {
				return createNAntCoreFiltersFilterAdapter();
			}
			@Override
			public Adapter caseNAntCoreFiltersFilterChain(NAntCoreFiltersFilterChain object) {
				return createNAntCoreFiltersFilterChainAdapter();
			}
			@Override
			public Adapter caseNAntCoreTaskContainer(NAntCoreTaskContainer object) {
				return createNAntCoreTaskContainerAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksAttribTask(NAntCoreTasksAttribTask object) {
				return createNAntCoreTasksAttribTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksAvailableTask(NAntCoreTasksAvailableTask object) {
				return createNAntCoreTasksAvailableTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksCallTask(NAntCoreTasksCallTask object) {
				return createNAntCoreTasksCallTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksCopyTask(NAntCoreTasksCopyTask object) {
				return createNAntCoreTasksCopyTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksDeleteTask(NAntCoreTasksDeleteTask object) {
				return createNAntCoreTasksDeleteTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksDescriptionTask(NAntCoreTasksDescriptionTask object) {
				return createNAntCoreTasksDescriptionTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksEchoTask(NAntCoreTasksEchoTask object) {
				return createNAntCoreTasksEchoTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksExecTask(NAntCoreTasksExecTask object) {
				return createNAntCoreTasksExecTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksFailTask(NAntCoreTasksFailTask object) {
				return createNAntCoreTasksFailTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksGetTask(NAntCoreTasksGetTask object) {
				return createNAntCoreTasksGetTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksIfNotTask(NAntCoreTasksIfNotTask object) {
				return createNAntCoreTasksIfNotTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksIfTask(NAntCoreTasksIfTask object) {
				return createNAntCoreTasksIfTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksIncludeTask(NAntCoreTasksIncludeTask object) {
				return createNAntCoreTasksIncludeTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksInElement(NAntCoreTasksInElement object) {
				return createNAntCoreTasksInElementAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksLoadFileTask(NAntCoreTasksLoadFileTask object) {
				return createNAntCoreTasksLoadFileTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksLoadTasksTask(NAntCoreTasksLoadTasksTask object) {
				return createNAntCoreTasksLoadTasksTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksLoopTask(NAntCoreTasksLoopTask object) {
				return createNAntCoreTasksLoopTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksMailTask(NAntCoreTasksMailTask object) {
				return createNAntCoreTasksMailTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksMkDirTask(NAntCoreTasksMkDirTask object) {
				return createNAntCoreTasksMkDirTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksMoveTask(NAntCoreTasksMoveTask object) {
				return createNAntCoreTasksMoveTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksNAntSchemaTask(NAntCoreTasksNAntSchemaTask object) {
				return createNAntCoreTasksNAntSchemaTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksNAntTask(NAntCoreTasksNAntTask object) {
				return createNAntCoreTasksNAntTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksPropertyTask(NAntCoreTasksPropertyTask object) {
				return createNAntCoreTasksPropertyTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksRegexTask(NAntCoreTasksRegexTask object) {
				return createNAntCoreTasksRegexTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksSetEnvTask(NAntCoreTasksSetEnvTask object) {
				return createNAntCoreTasksSetEnvTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksSleepTask(NAntCoreTasksSleepTask object) {
				return createNAntCoreTasksSleepTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksStyleTask(NAntCoreTasksStyleTask object) {
				return createNAntCoreTasksStyleTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksSysInfoTask(NAntCoreTasksSysInfoTask object) {
				return createNAntCoreTasksSysInfoTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksTouchTask(NAntCoreTasksTouchTask object) {
				return createNAntCoreTasksTouchTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksTStampTask(NAntCoreTasksTStampTask object) {
				return createNAntCoreTasksTStampTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksUpToDateTask(NAntCoreTasksUpToDateTask object) {
				return createNAntCoreTasksUpToDateTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksXmlPeekTask(NAntCoreTasksXmlPeekTask object) {
				return createNAntCoreTasksXmlPeekTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTasksXmlPokeTask(NAntCoreTasksXmlPokeTask object) {
				return createNAntCoreTasksXmlPokeTaskAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesArgument(NAntCoreTypesArgument object) {
				return createNAntCoreTypesArgumentAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesCredential(NAntCoreTypesCredential object) {
				return createNAntCoreTypesCredentialAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesDirSet(NAntCoreTypesDirSet object) {
				return createNAntCoreTypesDirSetAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesEnvironmentSet(NAntCoreTypesEnvironmentSet object) {
				return createNAntCoreTypesEnvironmentSetAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesEnvironmentVariable(NAntCoreTypesEnvironmentVariable object) {
				return createNAntCoreTypesEnvironmentVariableAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesFileSet(NAntCoreTypesFileSet object) {
				return createNAntCoreTypesFileSetAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesFileSetExclude(NAntCoreTypesFileSetExclude object) {
				return createNAntCoreTypesFileSetExcludeAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesFileSetExcludesFile(NAntCoreTypesFileSetExcludesFile object) {
				return createNAntCoreTypesFileSetExcludesFileAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesFileSetInclude(NAntCoreTypesFileSetInclude object) {
				return createNAntCoreTypesFileSetIncludeAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesFileSetIncludesFile(NAntCoreTypesFileSetIncludesFile object) {
				return createNAntCoreTypesFileSetIncludesFileAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesFormatter(NAntCoreTypesFormatter object) {
				return createNAntCoreTypesFormatterAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesOption(NAntCoreTypesOption object) {
				return createNAntCoreTypesOptionAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesPathElement(NAntCoreTypesPathElement object) {
				return createNAntCoreTypesPathElementAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesPathSet(NAntCoreTypesPathSet object) {
				return createNAntCoreTypesPathSetAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesPattern(NAntCoreTypesPattern object) {
				return createNAntCoreTypesPatternAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesPatternSet(NAntCoreTypesPatternSet object) {
				return createNAntCoreTypesPatternSetAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesProxy(NAntCoreTypesProxy object) {
				return createNAntCoreTypesProxyAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesRawXml(NAntCoreTypesRawXml object) {
				return createNAntCoreTypesRawXmlAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesXmlNamespace(NAntCoreTypesXmlNamespace object) {
				return createNAntCoreTypesXmlNamespaceAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesXsltExtensionObject(NAntCoreTypesXsltExtensionObject object) {
				return createNAntCoreTypesXsltExtensionObjectAdapter();
			}
			@Override
			public Adapter caseNAntCoreTypesXsltParameter(NAntCoreTypesXsltParameter object) {
				return createNAntCoreTypesXsltParameterAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksAssemblyInfoTask(NAntDotNetTasksAssemblyInfoTask object) {
				return createNAntDotNetTasksAssemblyInfoTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksAssemblyLinkerTask(NAntDotNetTasksAssemblyLinkerTask object) {
				return createNAntDotNetTasksAssemblyLinkerTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksCscTask(NAntDotNetTasksCscTask object) {
				return createNAntDotNetTasksCscTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksDelaySignTask(NAntDotNetTasksDelaySignTask object) {
				return createNAntDotNetTasksDelaySignTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksIlasmTask(NAntDotNetTasksIlasmTask object) {
				return createNAntDotNetTasksIlasmTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksJscTask(NAntDotNetTasksJscTask object) {
				return createNAntDotNetTasksJscTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksLicenseTask(NAntDotNetTasksLicenseTask object) {
				return createNAntDotNetTasksLicenseTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksNDocTask(NAntDotNetTasksNDocTask object) {
				return createNAntDotNetTasksNDocTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksRegsvcsTask(NAntDotNetTasksRegsvcsTask object) {
				return createNAntDotNetTasksRegsvcsTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksResGenTask(NAntDotNetTasksResGenTask object) {
				return createNAntDotNetTasksResGenTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksScriptTask(NAntDotNetTasksScriptTask object) {
				return createNAntDotNetTasksScriptTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksVbcTask(NAntDotNetTasksVbcTask object) {
				return createNAntDotNetTasksVbcTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTasksVjcTask(NAntDotNetTasksVjcTask object) {
				return createNAntDotNetTasksVjcTaskAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesAssemblyAttribute(NAntDotNetTypesAssemblyAttribute object) {
				return createNAntDotNetTypesAssemblyAttributeAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesAssemblyFileSet(NAntDotNetTypesAssemblyFileSet object) {
				return createNAntDotNetTypesAssemblyFileSetAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesCompilerWarning(NAntDotNetTypesCompilerWarning object) {
				return createNAntDotNetTypesCompilerWarningAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesLibDirectorySet(NAntDotNetTypesLibDirectorySet object) {
				return createNAntDotNetTypesLibDirectorySetAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesModule(NAntDotNetTypesModule object) {
				return createNAntDotNetTypesModuleAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesModuleSet(NAntDotNetTypesModuleSet object) {
				return createNAntDotNetTypesModuleSetAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesNamespaceImport(NAntDotNetTypesNamespaceImport object) {
				return createNAntDotNetTypesNamespaceImportAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesNamespaceImportCollection(NAntDotNetTypesNamespaceImportCollection object) {
				return createNAntDotNetTypesNamespaceImportCollectionAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesPackage(NAntDotNetTypesPackage object) {
				return createNAntDotNetTypesPackageAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesResourceFileSet(NAntDotNetTypesResourceFileSet object) {
				return createNAntDotNetTypesResourceFileSetAdapter();
			}
			@Override
			public Adapter caseNAntDotNetTypesWarningAsError(NAntDotNetTypesWarningAsError object) {
				return createNAntDotNetTypesWarningAsErrorAdapter();
			}
			@Override
			public Adapter caseNAntMSNetTasksIldasmTask(NAntMSNetTasksIldasmTask object) {
				return createNAntMSNetTasksIldasmTaskAdapter();
			}
			@Override
			public Adapter caseNAntMSNetTasksServiceControllerTask(NAntMSNetTasksServiceControllerTask object) {
				return createNAntMSNetTasksServiceControllerTaskAdapter();
			}
			@Override
			public Adapter caseNAntNUnit1TasksNUnitTask(NAntNUnit1TasksNUnitTask object) {
				return createNAntNUnit1TasksNUnitTaskAdapter();
			}
			@Override
			public Adapter caseNAntNUnit1TypesNUnitTest(NAntNUnit1TypesNUnitTest object) {
				return createNAntNUnit1TypesNUnitTestAdapter();
			}
			@Override
			public Adapter caseNAntNUnit2TasksNUnit2Task(NAntNUnit2TasksNUnit2Task object) {
				return createNAntNUnit2TasksNUnit2TaskAdapter();
			}
			@Override
			public Adapter caseNAntNUnit2TypesCategories(NAntNUnit2TypesCategories object) {
				return createNAntNUnit2TypesCategoriesAdapter();
			}
			@Override
			public Adapter caseNAntNUnit2TypesCategory(NAntNUnit2TypesCategory object) {
				return createNAntNUnit2TypesCategoryAdapter();
			}
			@Override
			public Adapter caseNAntNUnit2TypesNUnit2Test(NAntNUnit2TypesNUnit2Test object) {
				return createNAntNUnit2TypesNUnit2TestAdapter();
			}
			@Override
			public Adapter caseNAntNUnitTypesFormatterElement(NAntNUnitTypesFormatterElement object) {
				return createNAntNUnitTypesFormatterElementAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksChangeLogTask(NAntSourceControlTasksChangeLogTask object) {
				return createNAntSourceControlTasksChangeLogTaskAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksCheckoutTask(NAntSourceControlTasksCheckoutTask object) {
				return createNAntSourceControlTasksCheckoutTaskAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksCvsPass(NAntSourceControlTasksCvsPass object) {
				return createNAntSourceControlTasksCvsPassAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksCvsTask(NAntSourceControlTasksCvsTask object) {
				return createNAntSourceControlTasksCvsTaskAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksExportTask(NAntSourceControlTasksExportTask object) {
				return createNAntSourceControlTasksExportTaskAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksRTagTask(NAntSourceControlTasksRTagTask object) {
				return createNAntSourceControlTasksRTagTaskAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksTagTask(NAntSourceControlTasksTagTask object) {
				return createNAntSourceControlTasksTagTaskAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTasksUpdateTask(NAntSourceControlTasksUpdateTask object) {
				return createNAntSourceControlTasksUpdateTaskAdapter();
			}
			@Override
			public Adapter caseNAntSourceControlTypesCvsFileSet(NAntSourceControlTypesCvsFileSet object) {
				return createNAntSourceControlTypesCvsFileSetAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTasksClTask(NAntVisualCppTasksClTask object) {
				return createNAntVisualCppTasksClTaskAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTasksLibTask(NAntVisualCppTasksLibTask object) {
				return createNAntVisualCppTasksLibTaskAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTasksLinkTask(NAntVisualCppTasksLinkTask object) {
				return createNAntVisualCppTasksLinkTaskAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTasksMcTask(NAntVisualCppTasksMcTask object) {
				return createNAntVisualCppTasksMcTaskAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTasksMidlTask(NAntVisualCppTasksMidlTask object) {
				return createNAntVisualCppTasksMidlTaskAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTasksRcTask(NAntVisualCppTasksRcTask object) {
				return createNAntVisualCppTasksRcTaskAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTypesLibrary(NAntVisualCppTypesLibrary object) {
				return createNAntVisualCppTypesLibraryAdapter();
			}
			@Override
			public Adapter caseNAntVisualCppTypesSymbol(NAntVisualCppTypesSymbol object) {
				return createNAntVisualCppTypesSymbolAdapter();
			}
			@Override
			public Adapter caseNAntVSNetTasksSolutionTask(NAntVSNetTasksSolutionTask object) {
				return createNAntVSNetTasksSolutionTaskAdapter();
			}
			@Override
			public Adapter caseNAntVSNetTypesWebMap(NAntVSNetTypesWebMap object) {
				return createNAntVSNetTypesWebMapAdapter();
			}
			@Override
			public Adapter caseNAntWin32TasksAxImpTask(NAntWin32TasksAxImpTask object) {
				return createNAntWin32TasksAxImpTaskAdapter();
			}
			@Override
			public Adapter caseNAntWin32TasksReadRegistryTask(NAntWin32TasksReadRegistryTask object) {
				return createNAntWin32TasksReadRegistryTaskAdapter();
			}
			@Override
			public Adapter caseNAntWin32TasksRegAsmTask(NAntWin32TasksRegAsmTask object) {
				return createNAntWin32TasksRegAsmTaskAdapter();
			}
			@Override
			public Adapter caseNAntWin32TasksTlbExpTask(NAntWin32TasksTlbExpTask object) {
				return createNAntWin32TasksTlbExpTaskAdapter();
			}
			@Override
			public Adapter caseNAntWin32TasksTlbImpTask(NAntWin32TasksTlbImpTask object) {
				return createNAntWin32TasksTlbImpTaskAdapter();
			}
			@Override
			public Adapter caseNowarnType(NowarnType object) {
				return createNowarnTypeAdapter();
			}
			@Override
			public Adapter caseNowarnType1(NowarnType1 object) {
				return createNowarnType1Adapter();
			}
			@Override
			public Adapter caseNowarnType2(NowarnType2 object) {
				return createNowarnType2Adapter();
			}
			@Override
			public Adapter caseOptionsType(OptionsType object) {
				return createOptionsTypeAdapter();
			}
			@Override
			public Adapter caseParametersType(ParametersType object) {
				return createParametersTypeAdapter();
			}
			@Override
			public Adapter casePkgReferencesType(PkgReferencesType object) {
				return createPkgReferencesTypeAdapter();
			}
			@Override
			public Adapter casePkgReferencesType1(PkgReferencesType1 object) {
				return createPkgReferencesType1Adapter();
			}
			@Override
			public Adapter casePkgReferencesType2(PkgReferencesType2 object) {
				return createPkgReferencesType2Adapter();
			}
			@Override
			public Adapter caseProjectType(ProjectType object) {
				return createProjectTypeAdapter();
			}
			@Override
			public Adapter casePropertiesType(PropertiesType object) {
				return createPropertiesTypeAdapter();
			}
			@Override
			public Adapter caseSymbolsType(SymbolsType object) {
				return createSymbolsTypeAdapter();
			}
			@Override
			public Adapter caseSymbolsType1(SymbolsType1 object) {
				return createSymbolsType1Adapter();
			}
			@Override
			public Adapter caseTarget(Target object) {
				return createTargetAdapter();
			}
			@Override
			public Adapter caseTestsNAntCoreElementTest1Task(TestsNAntCoreElementTest1Task object) {
				return createTestsNAntCoreElementTest1TaskAdapter();
			}
			@Override
			public Adapter caseTestsNAntCoreTestTask(TestsNAntCoreTestTask object) {
				return createTestsNAntCoreTestTaskAdapter();
			}
			@Override
			public Adapter caseTestsNAntCoreUtilXmlLoggerTestTestTask(TestsNAntCoreUtilXmlLoggerTestTestTask object) {
				return createTestsNAntCoreUtilXmlLoggerTestTestTaskAdapter();
			}
			@Override
			public Adapter caseUndefinesType(UndefinesType object) {
				return createUndefinesTypeAdapter();
			}
			@Override
			public Adapter caseUndefinesType1(UndefinesType1 object) {
				return createUndefinesType1Adapter();
			}
			@Override
			public Adapter caseWebmapType(WebmapType object) {
				return createWebmapTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.AttributesType <em>Attributes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.AttributesType
	 * @generated
	 */
	public Adapter createAttributesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.DefinesType <em>Defines Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.DefinesType
	 * @generated
	 */
	public Adapter createDefinesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.DefinesType1 <em>Defines Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.DefinesType1
	 * @generated
	 */
	public Adapter createDefinesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.DefinesType2 <em>Defines Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.DefinesType2
	 * @generated
	 */
	public Adapter createDefinesType2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.ExtensionobjectsType <em>Extensionobjects Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.ExtensionobjectsType
	 * @generated
	 */
	public Adapter createExtensionobjectsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.IgnorelibrariesType <em>Ignorelibraries Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.IgnorelibrariesType
	 * @generated
	 */
	public Adapter createIgnorelibrariesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.IgnorelibrariesType1 <em>Ignorelibraries Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.IgnorelibrariesType1
	 * @generated
	 */
	public Adapter createIgnorelibrariesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NamespacesType <em>Namespaces Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NamespacesType
	 * @generated
	 */
	public Adapter createNamespacesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NamespacesType1 <em>Namespaces Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NamespacesType1
	 * @generated
	 */
	public Adapter createNamespacesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksGUnzip <em>NAnt Compression Tasks GUnzip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksGUnzip
	 * @generated
	 */
	public Adapter createNAntCompressionTasksGUnzipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksTarTask <em>NAnt Compression Tasks Tar Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksTarTask
	 * @generated
	 */
	public Adapter createNAntCompressionTasksTarTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksUnZipTask <em>NAnt Compression Tasks Un Zip Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksUnZipTask
	 * @generated
	 */
	public Adapter createNAntCompressionTasksUnZipTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask <em>NAnt Compression Tasks Zip Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask
	 * @generated
	 */
	public Adapter createNAntCompressionTasksZipTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesTarFileSet <em>NAnt Compression Types Tar File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesTarFileSet
	 * @generated
	 */
	public Adapter createNAntCompressionTypesTarFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesZipFileSet <em>NAnt Compression Types Zip File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesZipFileSet
	 * @generated
	 */
	public Adapter createNAntCompressionTypesZipFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreFiltersFilter <em>NAnt Core Filters Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreFiltersFilter
	 * @generated
	 */
	public Adapter createNAntCoreFiltersFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreFiltersFilterChain <em>NAnt Core Filters Filter Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreFiltersFilterChain
	 * @generated
	 */
	public Adapter createNAntCoreFiltersFilterChainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTaskContainer <em>NAnt Core Task Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTaskContainer
	 * @generated
	 */
	public Adapter createNAntCoreTaskContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAttribTask <em>NAnt Core Tasks Attrib Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAttribTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksAttribTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAvailableTask <em>NAnt Core Tasks Available Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAvailableTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksAvailableTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCallTask <em>NAnt Core Tasks Call Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCallTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksCallTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCopyTask <em>NAnt Core Tasks Copy Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCopyTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksCopyTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDeleteTask <em>NAnt Core Tasks Delete Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDeleteTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksDeleteTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDescriptionTask <em>NAnt Core Tasks Description Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDescriptionTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksDescriptionTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksEchoTask <em>NAnt Core Tasks Echo Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksEchoTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksEchoTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksExecTask <em>NAnt Core Tasks Exec Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksExecTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksExecTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksFailTask <em>NAnt Core Tasks Fail Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksFailTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksFailTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksGetTask <em>NAnt Core Tasks Get Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksGetTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksGetTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfNotTask <em>NAnt Core Tasks If Not Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfNotTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksIfNotTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfTask <em>NAnt Core Tasks If Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksIfTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIncludeTask <em>NAnt Core Tasks Include Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIncludeTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksIncludeTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksInElement <em>NAnt Core Tasks In Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksInElement
	 * @generated
	 */
	public Adapter createNAntCoreTasksInElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadFileTask <em>NAnt Core Tasks Load File Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadFileTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksLoadFileTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadTasksTask <em>NAnt Core Tasks Load Tasks Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadTasksTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksLoadTasksTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoopTask <em>NAnt Core Tasks Loop Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoopTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksLoopTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMailTask <em>NAnt Core Tasks Mail Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMailTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksMailTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMkDirTask <em>NAnt Core Tasks Mk Dir Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMkDirTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksMkDirTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMoveTask <em>NAnt Core Tasks Move Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMoveTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksMoveTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntSchemaTask <em>NAnt Core Tasks NAnt Schema Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntSchemaTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksNAntSchemaTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntTask <em>NAnt Core Tasks NAnt Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksNAntTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksPropertyTask <em>NAnt Core Tasks Property Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksPropertyTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksPropertyTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksRegexTask <em>NAnt Core Tasks Regex Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksRegexTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksRegexTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSetEnvTask <em>NAnt Core Tasks Set Env Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSetEnvTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksSetEnvTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSleepTask <em>NAnt Core Tasks Sleep Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSleepTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksSleepTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask <em>NAnt Core Tasks Style Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksStyleTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSysInfoTask <em>NAnt Core Tasks Sys Info Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSysInfoTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksSysInfoTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTouchTask <em>NAnt Core Tasks Touch Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTouchTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksTouchTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTStampTask <em>NAnt Core Tasks TStamp Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTStampTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksTStampTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksUpToDateTask <em>NAnt Core Tasks Up To Date Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksUpToDateTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksUpToDateTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPeekTask <em>NAnt Core Tasks Xml Peek Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPeekTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksXmlPeekTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPokeTask <em>NAnt Core Tasks Xml Poke Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPokeTask
	 * @generated
	 */
	public Adapter createNAntCoreTasksXmlPokeTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument <em>NAnt Core Types Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument
	 * @generated
	 */
	public Adapter createNAntCoreTypesArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesCredential <em>NAnt Core Types Credential</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesCredential
	 * @generated
	 */
	public Adapter createNAntCoreTypesCredentialAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesDirSet <em>NAnt Core Types Dir Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesDirSet
	 * @generated
	 */
	public Adapter createNAntCoreTypesDirSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesEnvironmentSet <em>NAnt Core Types Environment Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesEnvironmentSet
	 * @generated
	 */
	public Adapter createNAntCoreTypesEnvironmentSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesEnvironmentVariable <em>NAnt Core Types Environment Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesEnvironmentVariable
	 * @generated
	 */
	public Adapter createNAntCoreTypesEnvironmentVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet <em>NAnt Core Types File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet
	 * @generated
	 */
	public Adapter createNAntCoreTypesFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExclude <em>NAnt Core Types File Set Exclude</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExclude
	 * @generated
	 */
	public Adapter createNAntCoreTypesFileSetExcludeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExcludesFile <em>NAnt Core Types File Set Excludes File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExcludesFile
	 * @generated
	 */
	public Adapter createNAntCoreTypesFileSetExcludesFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetInclude <em>NAnt Core Types File Set Include</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetInclude
	 * @generated
	 */
	public Adapter createNAntCoreTypesFileSetIncludeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetIncludesFile <em>NAnt Core Types File Set Includes File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetIncludesFile
	 * @generated
	 */
	public Adapter createNAntCoreTypesFileSetIncludesFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFormatter <em>NAnt Core Types Formatter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFormatter
	 * @generated
	 */
	public Adapter createNAntCoreTypesFormatterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesOption <em>NAnt Core Types Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesOption
	 * @generated
	 */
	public Adapter createNAntCoreTypesOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathElement <em>NAnt Core Types Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathElement
	 * @generated
	 */
	public Adapter createNAntCoreTypesPathElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathSet <em>NAnt Core Types Path Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathSet
	 * @generated
	 */
	public Adapter createNAntCoreTypesPathSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPattern <em>NAnt Core Types Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPattern
	 * @generated
	 */
	public Adapter createNAntCoreTypesPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPatternSet <em>NAnt Core Types Pattern Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPatternSet
	 * @generated
	 */
	public Adapter createNAntCoreTypesPatternSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesProxy <em>NAnt Core Types Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesProxy
	 * @generated
	 */
	public Adapter createNAntCoreTypesProxyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesRawXml <em>NAnt Core Types Raw Xml</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesRawXml
	 * @generated
	 */
	public Adapter createNAntCoreTypesRawXmlAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesXmlNamespace <em>NAnt Core Types Xml Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesXmlNamespace
	 * @generated
	 */
	public Adapter createNAntCoreTypesXmlNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesXsltExtensionObject <em>NAnt Core Types Xslt Extension Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesXsltExtensionObject
	 * @generated
	 */
	public Adapter createNAntCoreTypesXsltExtensionObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesXsltParameter <em>NAnt Core Types Xslt Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesXsltParameter
	 * @generated
	 */
	public Adapter createNAntCoreTypesXsltParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyInfoTask <em>NAnt Dot Net Tasks Assembly Info Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyInfoTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksAssemblyInfoTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyLinkerTask <em>NAnt Dot Net Tasks Assembly Linker Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyLinkerTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksAssemblyLinkerTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksCscTask <em>NAnt Dot Net Tasks Csc Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksCscTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksCscTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksDelaySignTask <em>NAnt Dot Net Tasks Delay Sign Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksDelaySignTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksDelaySignTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask <em>NAnt Dot Net Tasks Ilasm Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksIlasmTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksJscTask <em>NAnt Dot Net Tasks Jsc Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksJscTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksJscTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask <em>NAnt Dot Net Tasks License Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksLicenseTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksNDocTask <em>NAnt Dot Net Tasks NDoc Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksNDocTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksNDocTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksRegsvcsTask <em>NAnt Dot Net Tasks Regsvcs Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksRegsvcsTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksRegsvcsTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksResGenTask <em>NAnt Dot Net Tasks Res Gen Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksResGenTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksResGenTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksScriptTask <em>NAnt Dot Net Tasks Script Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksScriptTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksScriptTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVbcTask <em>NAnt Dot Net Tasks Vbc Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVbcTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksVbcTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVjcTask <em>NAnt Dot Net Tasks Vjc Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVjcTask
	 * @generated
	 */
	public Adapter createNAntDotNetTasksVjcTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyAttribute <em>NAnt Dot Net Types Assembly Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyAttribute
	 * @generated
	 */
	public Adapter createNAntDotNetTypesAssemblyAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet <em>NAnt Dot Net Types Assembly File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet
	 * @generated
	 */
	public Adapter createNAntDotNetTypesAssemblyFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesCompilerWarning <em>NAnt Dot Net Types Compiler Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesCompilerWarning
	 * @generated
	 */
	public Adapter createNAntDotNetTypesCompilerWarningAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesLibDirectorySet <em>NAnt Dot Net Types Lib Directory Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesLibDirectorySet
	 * @generated
	 */
	public Adapter createNAntDotNetTypesLibDirectorySetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModule <em>NAnt Dot Net Types Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModule
	 * @generated
	 */
	public Adapter createNAntDotNetTypesModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet <em>NAnt Dot Net Types Module Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet
	 * @generated
	 */
	public Adapter createNAntDotNetTypesModuleSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImport <em>NAnt Dot Net Types Namespace Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImport
	 * @generated
	 */
	public Adapter createNAntDotNetTypesNamespaceImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImportCollection <em>NAnt Dot Net Types Namespace Import Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImportCollection
	 * @generated
	 */
	public Adapter createNAntDotNetTypesNamespaceImportCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesPackage <em>NAnt Dot Net Types Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesPackage
	 * @generated
	 */
	public Adapter createNAntDotNetTypesPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet <em>NAnt Dot Net Types Resource File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet
	 * @generated
	 */
	public Adapter createNAntDotNetTypesResourceFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesWarningAsError <em>NAnt Dot Net Types Warning As Error</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesWarningAsError
	 * @generated
	 */
	public Adapter createNAntDotNetTypesWarningAsErrorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksIldasmTask <em>NAnt MS Net Tasks Ildasm Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksIldasmTask
	 * @generated
	 */
	public Adapter createNAntMSNetTasksIldasmTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksServiceControllerTask <em>NAnt MS Net Tasks Service Controller Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksServiceControllerTask
	 * @generated
	 */
	public Adapter createNAntMSNetTasksServiceControllerTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TasksNUnitTask <em>NAnt NUnit1 Tasks NUnit Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TasksNUnitTask
	 * @generated
	 */
	public Adapter createNAntNUnit1TasksNUnitTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TypesNUnitTest <em>NAnt NUnit1 Types NUnit Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TypesNUnitTest
	 * @generated
	 */
	public Adapter createNAntNUnit1TypesNUnitTestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TasksNUnit2Task <em>NAnt NUnit2 Tasks NUnit2 Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TasksNUnit2Task
	 * @generated
	 */
	public Adapter createNAntNUnit2TasksNUnit2TaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategories <em>NAnt NUnit2 Types Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategories
	 * @generated
	 */
	public Adapter createNAntNUnit2TypesCategoriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategory <em>NAnt NUnit2 Types Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategory
	 * @generated
	 */
	public Adapter createNAntNUnit2TypesCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test <em>NAnt NUnit2 Types NUnit2 Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test
	 * @generated
	 */
	public Adapter createNAntNUnit2TypesNUnit2TestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnitTypesFormatterElement <em>NAnt NUnit Types Formatter Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntNUnitTypesFormatterElement
	 * @generated
	 */
	public Adapter createNAntNUnitTypesFormatterElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask <em>NAnt Source Control Tasks Change Log Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksChangeLogTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCheckoutTask <em>NAnt Source Control Tasks Checkout Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCheckoutTask
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksCheckoutTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsPass <em>NAnt Source Control Tasks Cvs Pass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsPass
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksCvsPassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsTask <em>NAnt Source Control Tasks Cvs Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsTask
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksCvsTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksExportTask <em>NAnt Source Control Tasks Export Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksExportTask
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksExportTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksRTagTask <em>NAnt Source Control Tasks RTag Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksRTagTask
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksRTagTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksTagTask <em>NAnt Source Control Tasks Tag Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksTagTask
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksTagTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksUpdateTask <em>NAnt Source Control Tasks Update Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksUpdateTask
	 * @generated
	 */
	public Adapter createNAntSourceControlTasksUpdateTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTypesCvsFileSet <em>NAnt Source Control Types Cvs File Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTypesCvsFileSet
	 * @generated
	 */
	public Adapter createNAntSourceControlTypesCvsFileSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksClTask <em>NAnt Visual Cpp Tasks Cl Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksClTask
	 * @generated
	 */
	public Adapter createNAntVisualCppTasksClTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask <em>NAnt Visual Cpp Tasks Lib Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask
	 * @generated
	 */
	public Adapter createNAntVisualCppTasksLibTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLinkTask <em>NAnt Visual Cpp Tasks Link Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLinkTask
	 * @generated
	 */
	public Adapter createNAntVisualCppTasksLinkTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask <em>NAnt Visual Cpp Tasks Mc Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask
	 * @generated
	 */
	public Adapter createNAntVisualCppTasksMcTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask <em>NAnt Visual Cpp Tasks Midl Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask
	 * @generated
	 */
	public Adapter createNAntVisualCppTasksMidlTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksRcTask <em>NAnt Visual Cpp Tasks Rc Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksRcTask
	 * @generated
	 */
	public Adapter createNAntVisualCppTasksRcTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTypesLibrary <em>NAnt Visual Cpp Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTypesLibrary
	 * @generated
	 */
	public Adapter createNAntVisualCppTypesLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTypesSymbol <em>NAnt Visual Cpp Types Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTypesSymbol
	 * @generated
	 */
	public Adapter createNAntVisualCppTypesSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask <em>NAnt VS Net Tasks Solution Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask
	 * @generated
	 */
	public Adapter createNAntVSNetTasksSolutionTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTypesWebMap <em>NAnt VS Net Types Web Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntVSNetTypesWebMap
	 * @generated
	 */
	public Adapter createNAntVSNetTypesWebMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksAxImpTask <em>NAnt Win32 Tasks Ax Imp Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksAxImpTask
	 * @generated
	 */
	public Adapter createNAntWin32TasksAxImpTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksReadRegistryTask <em>NAnt Win32 Tasks Read Registry Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksReadRegistryTask
	 * @generated
	 */
	public Adapter createNAntWin32TasksReadRegistryTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksRegAsmTask <em>NAnt Win32 Tasks Reg Asm Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksRegAsmTask
	 * @generated
	 */
	public Adapter createNAntWin32TasksRegAsmTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbExpTask <em>NAnt Win32 Tasks Tlb Exp Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbExpTask
	 * @generated
	 */
	public Adapter createNAntWin32TasksTlbExpTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask <em>NAnt Win32 Tasks Tlb Imp Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask
	 * @generated
	 */
	public Adapter createNAntWin32TasksTlbImpTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NowarnType <em>Nowarn Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NowarnType
	 * @generated
	 */
	public Adapter createNowarnTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NowarnType1 <em>Nowarn Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NowarnType1
	 * @generated
	 */
	public Adapter createNowarnType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.NowarnType2 <em>Nowarn Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.NowarnType2
	 * @generated
	 */
	public Adapter createNowarnType2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.OptionsType <em>Options Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.OptionsType
	 * @generated
	 */
	public Adapter createOptionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.ParametersType <em>Parameters Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.ParametersType
	 * @generated
	 */
	public Adapter createParametersTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.PkgReferencesType <em>Pkg References Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.PkgReferencesType
	 * @generated
	 */
	public Adapter createPkgReferencesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.PkgReferencesType1 <em>Pkg References Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.PkgReferencesType1
	 * @generated
	 */
	public Adapter createPkgReferencesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.PkgReferencesType2 <em>Pkg References Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.PkgReferencesType2
	 * @generated
	 */
	public Adapter createPkgReferencesType2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.ProjectType <em>Project Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.ProjectType
	 * @generated
	 */
	public Adapter createProjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.PropertiesType
	 * @generated
	 */
	public Adapter createPropertiesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.SymbolsType <em>Symbols Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.SymbolsType
	 * @generated
	 */
	public Adapter createSymbolsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.SymbolsType1 <em>Symbols Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.SymbolsType1
	 * @generated
	 */
	public Adapter createSymbolsType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.Target
	 * @generated
	 */
	public Adapter createTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreElementTest1Task <em>Tests NAnt Core Element Test1 Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreElementTest1Task
	 * @generated
	 */
	public Adapter createTestsNAntCoreElementTest1TaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreTestTask <em>Tests NAnt Core Test Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreTestTask
	 * @generated
	 */
	public Adapter createTestsNAntCoreTestTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreUtilXmlLoggerTestTestTask <em>Tests NAnt Core Util Xml Logger Test Test Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreUtilXmlLoggerTestTestTask
	 * @generated
	 */
	public Adapter createTestsNAntCoreUtilXmlLoggerTestTestTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.UndefinesType <em>Undefines Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.UndefinesType
	 * @generated
	 */
	public Adapter createUndefinesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.UndefinesType1 <em>Undefines Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.UndefinesType1
	 * @generated
	 */
	public Adapter createUndefinesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.nant.release._0._86.beta1.nant.WebmapType <em>Webmap Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.nant.release._0._86.beta1.nant.WebmapType
	 * @generated
	 */
	public Adapter createWebmapTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //NantAdapterFactory
