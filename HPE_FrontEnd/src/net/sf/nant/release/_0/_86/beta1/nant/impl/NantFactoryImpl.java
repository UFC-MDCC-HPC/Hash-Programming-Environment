/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import net.sf.nant.release._0._86.beta1.nant.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NantFactoryImpl extends EFactoryImpl implements NantFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NantFactory init() {
		try {
			NantFactory theNantFactory = (NantFactory)EPackage.Registry.INSTANCE.getEFactory("http://nant.sf.net/release/0.86-beta1/nant.xsd"); 
			if (theNantFactory != null) {
				return theNantFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NantFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NantFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NantPackage.ATTRIBUTES_TYPE: return createAttributesType();
			case NantPackage.DEFINES_TYPE: return createDefinesType();
			case NantPackage.DEFINES_TYPE1: return createDefinesType1();
			case NantPackage.DEFINES_TYPE2: return createDefinesType2();
			case NantPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case NantPackage.EXTENSIONOBJECTS_TYPE: return createExtensionobjectsType();
			case NantPackage.IGNORELIBRARIES_TYPE: return createIgnorelibrariesType();
			case NantPackage.IGNORELIBRARIES_TYPE1: return createIgnorelibrariesType1();
			case NantPackage.NAMESPACES_TYPE: return createNamespacesType();
			case NantPackage.NAMESPACES_TYPE1: return createNamespacesType1();
			case NantPackage.NANT_COMPRESSION_TASKS_GUNZIP: return createNAntCompressionTasksGUnzip();
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK: return createNAntCompressionTasksTarTask();
			case NantPackage.NANT_COMPRESSION_TASKS_UN_ZIP_TASK: return createNAntCompressionTasksUnZipTask();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK: return createNAntCompressionTasksZipTask();
			case NantPackage.NANT_COMPRESSION_TYPES_TAR_FILE_SET: return createNAntCompressionTypesTarFileSet();
			case NantPackage.NANT_COMPRESSION_TYPES_ZIP_FILE_SET: return createNAntCompressionTypesZipFileSet();
			case NantPackage.NANT_CORE_FILTERS_FILTER: return createNAntCoreFiltersFilter();
			case NantPackage.NANT_CORE_FILTERS_FILTER_CHAIN: return createNAntCoreFiltersFilterChain();
			case NantPackage.NANT_CORE_TASK_CONTAINER: return createNAntCoreTaskContainer();
			case NantPackage.NANT_CORE_TASKS_ATTRIB_TASK: return createNAntCoreTasksAttribTask();
			case NantPackage.NANT_CORE_TASKS_AVAILABLE_TASK: return createNAntCoreTasksAvailableTask();
			case NantPackage.NANT_CORE_TASKS_CALL_TASK: return createNAntCoreTasksCallTask();
			case NantPackage.NANT_CORE_TASKS_COPY_TASK: return createNAntCoreTasksCopyTask();
			case NantPackage.NANT_CORE_TASKS_DELETE_TASK: return createNAntCoreTasksDeleteTask();
			case NantPackage.NANT_CORE_TASKS_DESCRIPTION_TASK: return createNAntCoreTasksDescriptionTask();
			case NantPackage.NANT_CORE_TASKS_ECHO_TASK: return createNAntCoreTasksEchoTask();
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK: return createNAntCoreTasksExecTask();
			case NantPackage.NANT_CORE_TASKS_FAIL_TASK: return createNAntCoreTasksFailTask();
			case NantPackage.NANT_CORE_TASKS_GET_TASK: return createNAntCoreTasksGetTask();
			case NantPackage.NANT_CORE_TASKS_IF_NOT_TASK: return createNAntCoreTasksIfNotTask();
			case NantPackage.NANT_CORE_TASKS_IF_TASK: return createNAntCoreTasksIfTask();
			case NantPackage.NANT_CORE_TASKS_INCLUDE_TASK: return createNAntCoreTasksIncludeTask();
			case NantPackage.NANT_CORE_TASKS_IN_ELEMENT: return createNAntCoreTasksInElement();
			case NantPackage.NANT_CORE_TASKS_LOAD_FILE_TASK: return createNAntCoreTasksLoadFileTask();
			case NantPackage.NANT_CORE_TASKS_LOAD_TASKS_TASK: return createNAntCoreTasksLoadTasksTask();
			case NantPackage.NANT_CORE_TASKS_LOOP_TASK: return createNAntCoreTasksLoopTask();
			case NantPackage.NANT_CORE_TASKS_MAIL_TASK: return createNAntCoreTasksMailTask();
			case NantPackage.NANT_CORE_TASKS_MK_DIR_TASK: return createNAntCoreTasksMkDirTask();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK: return createNAntCoreTasksMoveTask();
			case NantPackage.NANT_CORE_TASKS_NANT_SCHEMA_TASK: return createNAntCoreTasksNAntSchemaTask();
			case NantPackage.NANT_CORE_TASKS_NANT_TASK: return createNAntCoreTasksNAntTask();
			case NantPackage.NANT_CORE_TASKS_PROPERTY_TASK: return createNAntCoreTasksPropertyTask();
			case NantPackage.NANT_CORE_TASKS_REGEX_TASK: return createNAntCoreTasksRegexTask();
			case NantPackage.NANT_CORE_TASKS_SET_ENV_TASK: return createNAntCoreTasksSetEnvTask();
			case NantPackage.NANT_CORE_TASKS_SLEEP_TASK: return createNAntCoreTasksSleepTask();
			case NantPackage.NANT_CORE_TASKS_STYLE_TASK: return createNAntCoreTasksStyleTask();
			case NantPackage.NANT_CORE_TASKS_SYS_INFO_TASK: return createNAntCoreTasksSysInfoTask();
			case NantPackage.NANT_CORE_TASKS_TOUCH_TASK: return createNAntCoreTasksTouchTask();
			case NantPackage.NANT_CORE_TASKS_TSTAMP_TASK: return createNAntCoreTasksTStampTask();
			case NantPackage.NANT_CORE_TASKS_UP_TO_DATE_TASK: return createNAntCoreTasksUpToDateTask();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK: return createNAntCoreTasksXmlPeekTask();
			case NantPackage.NANT_CORE_TASKS_XML_POKE_TASK: return createNAntCoreTasksXmlPokeTask();
			case NantPackage.NANT_CORE_TYPES_ARGUMENT: return createNAntCoreTypesArgument();
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL: return createNAntCoreTypesCredential();
			case NantPackage.NANT_CORE_TYPES_DIR_SET: return createNAntCoreTypesDirSet();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_SET: return createNAntCoreTypesEnvironmentSet();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE: return createNAntCoreTypesEnvironmentVariable();
			case NantPackage.NANT_CORE_TYPES_FILE_SET: return createNAntCoreTypesFileSet();
			case NantPackage.NANT_CORE_TYPES_FILE_SET_EXCLUDE: return createNAntCoreTypesFileSetExclude();
			case NantPackage.NANT_CORE_TYPES_FILE_SET_EXCLUDES_FILE: return createNAntCoreTypesFileSetExcludesFile();
			case NantPackage.NANT_CORE_TYPES_FILE_SET_INCLUDE: return createNAntCoreTypesFileSetInclude();
			case NantPackage.NANT_CORE_TYPES_FILE_SET_INCLUDES_FILE: return createNAntCoreTypesFileSetIncludesFile();
			case NantPackage.NANT_CORE_TYPES_FORMATTER: return createNAntCoreTypesFormatter();
			case NantPackage.NANT_CORE_TYPES_OPTION: return createNAntCoreTypesOption();
			case NantPackage.NANT_CORE_TYPES_PATH_ELEMENT: return createNAntCoreTypesPathElement();
			case NantPackage.NANT_CORE_TYPES_PATH_SET: return createNAntCoreTypesPathSet();
			case NantPackage.NANT_CORE_TYPES_PATTERN: return createNAntCoreTypesPattern();
			case NantPackage.NANT_CORE_TYPES_PATTERN_SET: return createNAntCoreTypesPatternSet();
			case NantPackage.NANT_CORE_TYPES_PROXY: return createNAntCoreTypesProxy();
			case NantPackage.NANT_CORE_TYPES_RAW_XML: return createNAntCoreTypesRawXml();
			case NantPackage.NANT_CORE_TYPES_XML_NAMESPACE: return createNAntCoreTypesXmlNamespace();
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT: return createNAntCoreTypesXsltExtensionObject();
			case NantPackage.NANT_CORE_TYPES_XSLT_PARAMETER: return createNAntCoreTypesXsltParameter();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK: return createNAntDotNetTasksAssemblyInfoTask();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK: return createNAntDotNetTasksAssemblyLinkerTask();
			case NantPackage.NANT_DOT_NET_TASKS_CSC_TASK: return createNAntDotNetTasksCscTask();
			case NantPackage.NANT_DOT_NET_TASKS_DELAY_SIGN_TASK: return createNAntDotNetTasksDelaySignTask();
			case NantPackage.NANT_DOT_NET_TASKS_ILASM_TASK: return createNAntDotNetTasksIlasmTask();
			case NantPackage.NANT_DOT_NET_TASKS_JSC_TASK: return createNAntDotNetTasksJscTask();
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK: return createNAntDotNetTasksLicenseTask();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK: return createNAntDotNetTasksNDocTask();
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK: return createNAntDotNetTasksRegsvcsTask();
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK: return createNAntDotNetTasksResGenTask();
			case NantPackage.NANT_DOT_NET_TASKS_SCRIPT_TASK: return createNAntDotNetTasksScriptTask();
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK: return createNAntDotNetTasksVbcTask();
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK: return createNAntDotNetTasksVjcTask();
			case NantPackage.NANT_DOT_NET_TYPES_ASSEMBLY_ATTRIBUTE: return createNAntDotNetTypesAssemblyAttribute();
			case NantPackage.NANT_DOT_NET_TYPES_ASSEMBLY_FILE_SET: return createNAntDotNetTypesAssemblyFileSet();
			case NantPackage.NANT_DOT_NET_TYPES_COMPILER_WARNING: return createNAntDotNetTypesCompilerWarning();
			case NantPackage.NANT_DOT_NET_TYPES_LIB_DIRECTORY_SET: return createNAntDotNetTypesLibDirectorySet();
			case NantPackage.NANT_DOT_NET_TYPES_MODULE: return createNAntDotNetTypesModule();
			case NantPackage.NANT_DOT_NET_TYPES_MODULE_SET: return createNAntDotNetTypesModuleSet();
			case NantPackage.NANT_DOT_NET_TYPES_NAMESPACE_IMPORT: return createNAntDotNetTypesNamespaceImport();
			case NantPackage.NANT_DOT_NET_TYPES_NAMESPACE_IMPORT_COLLECTION: return createNAntDotNetTypesNamespaceImportCollection();
			case NantPackage.NANT_DOT_NET_TYPES_PACKAGE: return createNAntDotNetTypesPackage();
			case NantPackage.NANT_DOT_NET_TYPES_RESOURCE_FILE_SET: return createNAntDotNetTypesResourceFileSet();
			case NantPackage.NANT_DOT_NET_TYPES_WARNING_AS_ERROR: return createNAntDotNetTypesWarningAsError();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK: return createNAntMSNetTasksIldasmTask();
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK: return createNAntMSNetTasksServiceControllerTask();
			case NantPackage.NANT_NUNIT1_TASKS_NUNIT_TASK: return createNAntNUnit1TasksNUnitTask();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST: return createNAntNUnit1TypesNUnitTest();
			case NantPackage.NANT_NUNIT2_TASKS_NUNIT2_TASK: return createNAntNUnit2TasksNUnit2Task();
			case NantPackage.NANT_NUNIT2_TYPES_CATEGORIES: return createNAntNUnit2TypesCategories();
			case NantPackage.NANT_NUNIT2_TYPES_CATEGORY: return createNAntNUnit2TypesCategory();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST: return createNAntNUnit2TypesNUnit2Test();
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT: return createNAntNUnitTypesFormatterElement();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CHANGE_LOG_TASK: return createNAntSourceControlTasksChangeLogTask();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CHECKOUT_TASK: return createNAntSourceControlTasksCheckoutTask();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS: return createNAntSourceControlTasksCvsPass();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_TASK: return createNAntSourceControlTasksCvsTask();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_EXPORT_TASK: return createNAntSourceControlTasksExportTask();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_RTAG_TASK: return createNAntSourceControlTasksRTagTask();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_TAG_TASK: return createNAntSourceControlTasksTagTask();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK: return createNAntSourceControlTasksUpdateTask();
			case NantPackage.NANT_SOURCE_CONTROL_TYPES_CVS_FILE_SET: return createNAntSourceControlTypesCvsFileSet();
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK: return createNAntVisualCppTasksClTask();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LIB_TASK: return createNAntVisualCppTasksLibTask();
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK: return createNAntVisualCppTasksLinkTask();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK: return createNAntVisualCppTasksMcTask();
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK: return createNAntVisualCppTasksMidlTask();
			case NantPackage.NANT_VISUAL_CPP_TASKS_RC_TASK: return createNAntVisualCppTasksRcTask();
			case NantPackage.NANT_VISUAL_CPP_TYPES_LIBRARY: return createNAntVisualCppTypesLibrary();
			case NantPackage.NANT_VISUAL_CPP_TYPES_SYMBOL: return createNAntVisualCppTypesSymbol();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK: return createNAntVSNetTasksSolutionTask();
			case NantPackage.NANT_VS_NET_TYPES_WEB_MAP: return createNAntVSNetTypesWebMap();
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK: return createNAntWin32TasksAxImpTask();
			case NantPackage.NANT_WIN32_TASKS_READ_REGISTRY_TASK: return createNAntWin32TasksReadRegistryTask();
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK: return createNAntWin32TasksRegAsmTask();
			case NantPackage.NANT_WIN32_TASKS_TLB_EXP_TASK: return createNAntWin32TasksTlbExpTask();
			case NantPackage.NANT_WIN32_TASKS_TLB_IMP_TASK: return createNAntWin32TasksTlbImpTask();
			case NantPackage.NOWARN_TYPE: return createNowarnType();
			case NantPackage.NOWARN_TYPE1: return createNowarnType1();
			case NantPackage.NOWARN_TYPE2: return createNowarnType2();
			case NantPackage.OPTIONS_TYPE: return createOptionsType();
			case NantPackage.PARAMETERS_TYPE: return createParametersType();
			case NantPackage.PKG_REFERENCES_TYPE: return createPkgReferencesType();
			case NantPackage.PKG_REFERENCES_TYPE1: return createPkgReferencesType1();
			case NantPackage.PKG_REFERENCES_TYPE2: return createPkgReferencesType2();
			case NantPackage.PROJECT_TYPE: return createProjectType();
			case NantPackage.PROPERTIES_TYPE: return createPropertiesType();
			case NantPackage.SYMBOLS_TYPE: return createSymbolsType();
			case NantPackage.SYMBOLS_TYPE1: return createSymbolsType1();
			case NantPackage.TARGET: return createTarget();
			case NantPackage.TESTS_NANT_CORE_ELEMENT_TEST1_TASK: return createTestsNAntCoreElementTest1Task();
			case NantPackage.TESTS_NANT_CORE_TEST_TASK: return createTestsNAntCoreTestTask();
			case NantPackage.TESTS_NANT_CORE_UTIL_XML_LOGGER_TEST_TEST_TASK: return createTestsNAntCoreUtilXmlLoggerTestTestTask();
			case NantPackage.UNDEFINES_TYPE: return createUndefinesType();
			case NantPackage.UNDEFINES_TYPE1: return createUndefinesType1();
			case NantPackage.WEBMAP_TYPE: return createWebmapType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributesType createAttributesType() {
		AttributesTypeImpl attributesType = new AttributesTypeImpl();
		return attributesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinesType createDefinesType() {
		DefinesTypeImpl definesType = new DefinesTypeImpl();
		return definesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinesType1 createDefinesType1() {
		DefinesType1Impl definesType1 = new DefinesType1Impl();
		return definesType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinesType2 createDefinesType2() {
		DefinesType2Impl definesType2 = new DefinesType2Impl();
		return definesType2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionobjectsType createExtensionobjectsType() {
		ExtensionobjectsTypeImpl extensionobjectsType = new ExtensionobjectsTypeImpl();
		return extensionobjectsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IgnorelibrariesType createIgnorelibrariesType() {
		IgnorelibrariesTypeImpl ignorelibrariesType = new IgnorelibrariesTypeImpl();
		return ignorelibrariesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IgnorelibrariesType1 createIgnorelibrariesType1() {
		IgnorelibrariesType1Impl ignorelibrariesType1 = new IgnorelibrariesType1Impl();
		return ignorelibrariesType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacesType createNamespacesType() {
		NamespacesTypeImpl namespacesType = new NamespacesTypeImpl();
		return namespacesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacesType1 createNamespacesType1() {
		NamespacesType1Impl namespacesType1 = new NamespacesType1Impl();
		return namespacesType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCompressionTasksGUnzip createNAntCompressionTasksGUnzip() {
		NAntCompressionTasksGUnzipImpl nAntCompressionTasksGUnzip = new NAntCompressionTasksGUnzipImpl();
		return nAntCompressionTasksGUnzip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCompressionTasksTarTask createNAntCompressionTasksTarTask() {
		NAntCompressionTasksTarTaskImpl nAntCompressionTasksTarTask = new NAntCompressionTasksTarTaskImpl();
		return nAntCompressionTasksTarTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCompressionTasksUnZipTask createNAntCompressionTasksUnZipTask() {
		NAntCompressionTasksUnZipTaskImpl nAntCompressionTasksUnZipTask = new NAntCompressionTasksUnZipTaskImpl();
		return nAntCompressionTasksUnZipTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCompressionTasksZipTask createNAntCompressionTasksZipTask() {
		NAntCompressionTasksZipTaskImpl nAntCompressionTasksZipTask = new NAntCompressionTasksZipTaskImpl();
		return nAntCompressionTasksZipTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCompressionTypesTarFileSet createNAntCompressionTypesTarFileSet() {
		NAntCompressionTypesTarFileSetImpl nAntCompressionTypesTarFileSet = new NAntCompressionTypesTarFileSetImpl();
		return nAntCompressionTypesTarFileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCompressionTypesZipFileSet createNAntCompressionTypesZipFileSet() {
		NAntCompressionTypesZipFileSetImpl nAntCompressionTypesZipFileSet = new NAntCompressionTypesZipFileSetImpl();
		return nAntCompressionTypesZipFileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreFiltersFilter createNAntCoreFiltersFilter() {
		NAntCoreFiltersFilterImpl nAntCoreFiltersFilter = new NAntCoreFiltersFilterImpl();
		return nAntCoreFiltersFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreFiltersFilterChain createNAntCoreFiltersFilterChain() {
		NAntCoreFiltersFilterChainImpl nAntCoreFiltersFilterChain = new NAntCoreFiltersFilterChainImpl();
		return nAntCoreFiltersFilterChain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTaskContainer createNAntCoreTaskContainer() {
		NAntCoreTaskContainerImpl nAntCoreTaskContainer = new NAntCoreTaskContainerImpl();
		return nAntCoreTaskContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksAttribTask createNAntCoreTasksAttribTask() {
		NAntCoreTasksAttribTaskImpl nAntCoreTasksAttribTask = new NAntCoreTasksAttribTaskImpl();
		return nAntCoreTasksAttribTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksAvailableTask createNAntCoreTasksAvailableTask() {
		NAntCoreTasksAvailableTaskImpl nAntCoreTasksAvailableTask = new NAntCoreTasksAvailableTaskImpl();
		return nAntCoreTasksAvailableTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksCallTask createNAntCoreTasksCallTask() {
		NAntCoreTasksCallTaskImpl nAntCoreTasksCallTask = new NAntCoreTasksCallTaskImpl();
		return nAntCoreTasksCallTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksCopyTask createNAntCoreTasksCopyTask() {
		NAntCoreTasksCopyTaskImpl nAntCoreTasksCopyTask = new NAntCoreTasksCopyTaskImpl();
		return nAntCoreTasksCopyTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksDeleteTask createNAntCoreTasksDeleteTask() {
		NAntCoreTasksDeleteTaskImpl nAntCoreTasksDeleteTask = new NAntCoreTasksDeleteTaskImpl();
		return nAntCoreTasksDeleteTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksDescriptionTask createNAntCoreTasksDescriptionTask() {
		NAntCoreTasksDescriptionTaskImpl nAntCoreTasksDescriptionTask = new NAntCoreTasksDescriptionTaskImpl();
		return nAntCoreTasksDescriptionTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksEchoTask createNAntCoreTasksEchoTask() {
		NAntCoreTasksEchoTaskImpl nAntCoreTasksEchoTask = new NAntCoreTasksEchoTaskImpl();
		return nAntCoreTasksEchoTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksExecTask createNAntCoreTasksExecTask() {
		NAntCoreTasksExecTaskImpl nAntCoreTasksExecTask = new NAntCoreTasksExecTaskImpl();
		return nAntCoreTasksExecTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksFailTask createNAntCoreTasksFailTask() {
		NAntCoreTasksFailTaskImpl nAntCoreTasksFailTask = new NAntCoreTasksFailTaskImpl();
		return nAntCoreTasksFailTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksGetTask createNAntCoreTasksGetTask() {
		NAntCoreTasksGetTaskImpl nAntCoreTasksGetTask = new NAntCoreTasksGetTaskImpl();
		return nAntCoreTasksGetTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksIfNotTask createNAntCoreTasksIfNotTask() {
		NAntCoreTasksIfNotTaskImpl nAntCoreTasksIfNotTask = new NAntCoreTasksIfNotTaskImpl();
		return nAntCoreTasksIfNotTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksIfTask createNAntCoreTasksIfTask() {
		NAntCoreTasksIfTaskImpl nAntCoreTasksIfTask = new NAntCoreTasksIfTaskImpl();
		return nAntCoreTasksIfTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksIncludeTask createNAntCoreTasksIncludeTask() {
		NAntCoreTasksIncludeTaskImpl nAntCoreTasksIncludeTask = new NAntCoreTasksIncludeTaskImpl();
		return nAntCoreTasksIncludeTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksInElement createNAntCoreTasksInElement() {
		NAntCoreTasksInElementImpl nAntCoreTasksInElement = new NAntCoreTasksInElementImpl();
		return nAntCoreTasksInElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksLoadFileTask createNAntCoreTasksLoadFileTask() {
		NAntCoreTasksLoadFileTaskImpl nAntCoreTasksLoadFileTask = new NAntCoreTasksLoadFileTaskImpl();
		return nAntCoreTasksLoadFileTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksLoadTasksTask createNAntCoreTasksLoadTasksTask() {
		NAntCoreTasksLoadTasksTaskImpl nAntCoreTasksLoadTasksTask = new NAntCoreTasksLoadTasksTaskImpl();
		return nAntCoreTasksLoadTasksTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksLoopTask createNAntCoreTasksLoopTask() {
		NAntCoreTasksLoopTaskImpl nAntCoreTasksLoopTask = new NAntCoreTasksLoopTaskImpl();
		return nAntCoreTasksLoopTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksMailTask createNAntCoreTasksMailTask() {
		NAntCoreTasksMailTaskImpl nAntCoreTasksMailTask = new NAntCoreTasksMailTaskImpl();
		return nAntCoreTasksMailTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksMkDirTask createNAntCoreTasksMkDirTask() {
		NAntCoreTasksMkDirTaskImpl nAntCoreTasksMkDirTask = new NAntCoreTasksMkDirTaskImpl();
		return nAntCoreTasksMkDirTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksMoveTask createNAntCoreTasksMoveTask() {
		NAntCoreTasksMoveTaskImpl nAntCoreTasksMoveTask = new NAntCoreTasksMoveTaskImpl();
		return nAntCoreTasksMoveTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksNAntSchemaTask createNAntCoreTasksNAntSchemaTask() {
		NAntCoreTasksNAntSchemaTaskImpl nAntCoreTasksNAntSchemaTask = new NAntCoreTasksNAntSchemaTaskImpl();
		return nAntCoreTasksNAntSchemaTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksNAntTask createNAntCoreTasksNAntTask() {
		NAntCoreTasksNAntTaskImpl nAntCoreTasksNAntTask = new NAntCoreTasksNAntTaskImpl();
		return nAntCoreTasksNAntTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksPropertyTask createNAntCoreTasksPropertyTask() {
		NAntCoreTasksPropertyTaskImpl nAntCoreTasksPropertyTask = new NAntCoreTasksPropertyTaskImpl();
		return nAntCoreTasksPropertyTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksRegexTask createNAntCoreTasksRegexTask() {
		NAntCoreTasksRegexTaskImpl nAntCoreTasksRegexTask = new NAntCoreTasksRegexTaskImpl();
		return nAntCoreTasksRegexTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksSetEnvTask createNAntCoreTasksSetEnvTask() {
		NAntCoreTasksSetEnvTaskImpl nAntCoreTasksSetEnvTask = new NAntCoreTasksSetEnvTaskImpl();
		return nAntCoreTasksSetEnvTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksSleepTask createNAntCoreTasksSleepTask() {
		NAntCoreTasksSleepTaskImpl nAntCoreTasksSleepTask = new NAntCoreTasksSleepTaskImpl();
		return nAntCoreTasksSleepTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksStyleTask createNAntCoreTasksStyleTask() {
		NAntCoreTasksStyleTaskImpl nAntCoreTasksStyleTask = new NAntCoreTasksStyleTaskImpl();
		return nAntCoreTasksStyleTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksSysInfoTask createNAntCoreTasksSysInfoTask() {
		NAntCoreTasksSysInfoTaskImpl nAntCoreTasksSysInfoTask = new NAntCoreTasksSysInfoTaskImpl();
		return nAntCoreTasksSysInfoTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksTouchTask createNAntCoreTasksTouchTask() {
		NAntCoreTasksTouchTaskImpl nAntCoreTasksTouchTask = new NAntCoreTasksTouchTaskImpl();
		return nAntCoreTasksTouchTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksTStampTask createNAntCoreTasksTStampTask() {
		NAntCoreTasksTStampTaskImpl nAntCoreTasksTStampTask = new NAntCoreTasksTStampTaskImpl();
		return nAntCoreTasksTStampTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksUpToDateTask createNAntCoreTasksUpToDateTask() {
		NAntCoreTasksUpToDateTaskImpl nAntCoreTasksUpToDateTask = new NAntCoreTasksUpToDateTaskImpl();
		return nAntCoreTasksUpToDateTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksXmlPeekTask createNAntCoreTasksXmlPeekTask() {
		NAntCoreTasksXmlPeekTaskImpl nAntCoreTasksXmlPeekTask = new NAntCoreTasksXmlPeekTaskImpl();
		return nAntCoreTasksXmlPeekTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTasksXmlPokeTask createNAntCoreTasksXmlPokeTask() {
		NAntCoreTasksXmlPokeTaskImpl nAntCoreTasksXmlPokeTask = new NAntCoreTasksXmlPokeTaskImpl();
		return nAntCoreTasksXmlPokeTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesArgument createNAntCoreTypesArgument() {
		NAntCoreTypesArgumentImpl nAntCoreTypesArgument = new NAntCoreTypesArgumentImpl();
		return nAntCoreTypesArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesCredential createNAntCoreTypesCredential() {
		NAntCoreTypesCredentialImpl nAntCoreTypesCredential = new NAntCoreTypesCredentialImpl();
		return nAntCoreTypesCredential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesDirSet createNAntCoreTypesDirSet() {
		NAntCoreTypesDirSetImpl nAntCoreTypesDirSet = new NAntCoreTypesDirSetImpl();
		return nAntCoreTypesDirSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesEnvironmentSet createNAntCoreTypesEnvironmentSet() {
		NAntCoreTypesEnvironmentSetImpl nAntCoreTypesEnvironmentSet = new NAntCoreTypesEnvironmentSetImpl();
		return nAntCoreTypesEnvironmentSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesEnvironmentVariable createNAntCoreTypesEnvironmentVariable() {
		NAntCoreTypesEnvironmentVariableImpl nAntCoreTypesEnvironmentVariable = new NAntCoreTypesEnvironmentVariableImpl();
		return nAntCoreTypesEnvironmentVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesFileSet createNAntCoreTypesFileSet() {
		NAntCoreTypesFileSetImpl nAntCoreTypesFileSet = new NAntCoreTypesFileSetImpl();
		return nAntCoreTypesFileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesFileSetExclude createNAntCoreTypesFileSetExclude() {
		NAntCoreTypesFileSetExcludeImpl nAntCoreTypesFileSetExclude = new NAntCoreTypesFileSetExcludeImpl();
		return nAntCoreTypesFileSetExclude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesFileSetExcludesFile createNAntCoreTypesFileSetExcludesFile() {
		NAntCoreTypesFileSetExcludesFileImpl nAntCoreTypesFileSetExcludesFile = new NAntCoreTypesFileSetExcludesFileImpl();
		return nAntCoreTypesFileSetExcludesFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesFileSetInclude createNAntCoreTypesFileSetInclude() {
		NAntCoreTypesFileSetIncludeImpl nAntCoreTypesFileSetInclude = new NAntCoreTypesFileSetIncludeImpl();
		return nAntCoreTypesFileSetInclude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesFileSetIncludesFile createNAntCoreTypesFileSetIncludesFile() {
		NAntCoreTypesFileSetIncludesFileImpl nAntCoreTypesFileSetIncludesFile = new NAntCoreTypesFileSetIncludesFileImpl();
		return nAntCoreTypesFileSetIncludesFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesFormatter createNAntCoreTypesFormatter() {
		NAntCoreTypesFormatterImpl nAntCoreTypesFormatter = new NAntCoreTypesFormatterImpl();
		return nAntCoreTypesFormatter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesOption createNAntCoreTypesOption() {
		NAntCoreTypesOptionImpl nAntCoreTypesOption = new NAntCoreTypesOptionImpl();
		return nAntCoreTypesOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesPathElement createNAntCoreTypesPathElement() {
		NAntCoreTypesPathElementImpl nAntCoreTypesPathElement = new NAntCoreTypesPathElementImpl();
		return nAntCoreTypesPathElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesPathSet createNAntCoreTypesPathSet() {
		NAntCoreTypesPathSetImpl nAntCoreTypesPathSet = new NAntCoreTypesPathSetImpl();
		return nAntCoreTypesPathSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesPattern createNAntCoreTypesPattern() {
		NAntCoreTypesPatternImpl nAntCoreTypesPattern = new NAntCoreTypesPatternImpl();
		return nAntCoreTypesPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesPatternSet createNAntCoreTypesPatternSet() {
		NAntCoreTypesPatternSetImpl nAntCoreTypesPatternSet = new NAntCoreTypesPatternSetImpl();
		return nAntCoreTypesPatternSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesProxy createNAntCoreTypesProxy() {
		NAntCoreTypesProxyImpl nAntCoreTypesProxy = new NAntCoreTypesProxyImpl();
		return nAntCoreTypesProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesRawXml createNAntCoreTypesRawXml() {
		NAntCoreTypesRawXmlImpl nAntCoreTypesRawXml = new NAntCoreTypesRawXmlImpl();
		return nAntCoreTypesRawXml;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesXmlNamespace createNAntCoreTypesXmlNamespace() {
		NAntCoreTypesXmlNamespaceImpl nAntCoreTypesXmlNamespace = new NAntCoreTypesXmlNamespaceImpl();
		return nAntCoreTypesXmlNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesXsltExtensionObject createNAntCoreTypesXsltExtensionObject() {
		NAntCoreTypesXsltExtensionObjectImpl nAntCoreTypesXsltExtensionObject = new NAntCoreTypesXsltExtensionObjectImpl();
		return nAntCoreTypesXsltExtensionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntCoreTypesXsltParameter createNAntCoreTypesXsltParameter() {
		NAntCoreTypesXsltParameterImpl nAntCoreTypesXsltParameter = new NAntCoreTypesXsltParameterImpl();
		return nAntCoreTypesXsltParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksAssemblyInfoTask createNAntDotNetTasksAssemblyInfoTask() {
		NAntDotNetTasksAssemblyInfoTaskImpl nAntDotNetTasksAssemblyInfoTask = new NAntDotNetTasksAssemblyInfoTaskImpl();
		return nAntDotNetTasksAssemblyInfoTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksAssemblyLinkerTask createNAntDotNetTasksAssemblyLinkerTask() {
		NAntDotNetTasksAssemblyLinkerTaskImpl nAntDotNetTasksAssemblyLinkerTask = new NAntDotNetTasksAssemblyLinkerTaskImpl();
		return nAntDotNetTasksAssemblyLinkerTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksCscTask createNAntDotNetTasksCscTask() {
		NAntDotNetTasksCscTaskImpl nAntDotNetTasksCscTask = new NAntDotNetTasksCscTaskImpl();
		return nAntDotNetTasksCscTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksDelaySignTask createNAntDotNetTasksDelaySignTask() {
		NAntDotNetTasksDelaySignTaskImpl nAntDotNetTasksDelaySignTask = new NAntDotNetTasksDelaySignTaskImpl();
		return nAntDotNetTasksDelaySignTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksIlasmTask createNAntDotNetTasksIlasmTask() {
		NAntDotNetTasksIlasmTaskImpl nAntDotNetTasksIlasmTask = new NAntDotNetTasksIlasmTaskImpl();
		return nAntDotNetTasksIlasmTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksJscTask createNAntDotNetTasksJscTask() {
		NAntDotNetTasksJscTaskImpl nAntDotNetTasksJscTask = new NAntDotNetTasksJscTaskImpl();
		return nAntDotNetTasksJscTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksLicenseTask createNAntDotNetTasksLicenseTask() {
		NAntDotNetTasksLicenseTaskImpl nAntDotNetTasksLicenseTask = new NAntDotNetTasksLicenseTaskImpl();
		return nAntDotNetTasksLicenseTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksNDocTask createNAntDotNetTasksNDocTask() {
		NAntDotNetTasksNDocTaskImpl nAntDotNetTasksNDocTask = new NAntDotNetTasksNDocTaskImpl();
		return nAntDotNetTasksNDocTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksRegsvcsTask createNAntDotNetTasksRegsvcsTask() {
		NAntDotNetTasksRegsvcsTaskImpl nAntDotNetTasksRegsvcsTask = new NAntDotNetTasksRegsvcsTaskImpl();
		return nAntDotNetTasksRegsvcsTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksResGenTask createNAntDotNetTasksResGenTask() {
		NAntDotNetTasksResGenTaskImpl nAntDotNetTasksResGenTask = new NAntDotNetTasksResGenTaskImpl();
		return nAntDotNetTasksResGenTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksScriptTask createNAntDotNetTasksScriptTask() {
		NAntDotNetTasksScriptTaskImpl nAntDotNetTasksScriptTask = new NAntDotNetTasksScriptTaskImpl();
		return nAntDotNetTasksScriptTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksVbcTask createNAntDotNetTasksVbcTask() {
		NAntDotNetTasksVbcTaskImpl nAntDotNetTasksVbcTask = new NAntDotNetTasksVbcTaskImpl();
		return nAntDotNetTasksVbcTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTasksVjcTask createNAntDotNetTasksVjcTask() {
		NAntDotNetTasksVjcTaskImpl nAntDotNetTasksVjcTask = new NAntDotNetTasksVjcTaskImpl();
		return nAntDotNetTasksVjcTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesAssemblyAttribute createNAntDotNetTypesAssemblyAttribute() {
		NAntDotNetTypesAssemblyAttributeImpl nAntDotNetTypesAssemblyAttribute = new NAntDotNetTypesAssemblyAttributeImpl();
		return nAntDotNetTypesAssemblyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesAssemblyFileSet createNAntDotNetTypesAssemblyFileSet() {
		NAntDotNetTypesAssemblyFileSetImpl nAntDotNetTypesAssemblyFileSet = new NAntDotNetTypesAssemblyFileSetImpl();
		return nAntDotNetTypesAssemblyFileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesCompilerWarning createNAntDotNetTypesCompilerWarning() {
		NAntDotNetTypesCompilerWarningImpl nAntDotNetTypesCompilerWarning = new NAntDotNetTypesCompilerWarningImpl();
		return nAntDotNetTypesCompilerWarning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesLibDirectorySet createNAntDotNetTypesLibDirectorySet() {
		NAntDotNetTypesLibDirectorySetImpl nAntDotNetTypesLibDirectorySet = new NAntDotNetTypesLibDirectorySetImpl();
		return nAntDotNetTypesLibDirectorySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesModule createNAntDotNetTypesModule() {
		NAntDotNetTypesModuleImpl nAntDotNetTypesModule = new NAntDotNetTypesModuleImpl();
		return nAntDotNetTypesModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesModuleSet createNAntDotNetTypesModuleSet() {
		NAntDotNetTypesModuleSetImpl nAntDotNetTypesModuleSet = new NAntDotNetTypesModuleSetImpl();
		return nAntDotNetTypesModuleSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesNamespaceImport createNAntDotNetTypesNamespaceImport() {
		NAntDotNetTypesNamespaceImportImpl nAntDotNetTypesNamespaceImport = new NAntDotNetTypesNamespaceImportImpl();
		return nAntDotNetTypesNamespaceImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesNamespaceImportCollection createNAntDotNetTypesNamespaceImportCollection() {
		NAntDotNetTypesNamespaceImportCollectionImpl nAntDotNetTypesNamespaceImportCollection = new NAntDotNetTypesNamespaceImportCollectionImpl();
		return nAntDotNetTypesNamespaceImportCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesPackage createNAntDotNetTypesPackage() {
		NAntDotNetTypesPackageImpl nAntDotNetTypesPackage = new NAntDotNetTypesPackageImpl();
		return nAntDotNetTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesResourceFileSet createNAntDotNetTypesResourceFileSet() {
		NAntDotNetTypesResourceFileSetImpl nAntDotNetTypesResourceFileSet = new NAntDotNetTypesResourceFileSetImpl();
		return nAntDotNetTypesResourceFileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntDotNetTypesWarningAsError createNAntDotNetTypesWarningAsError() {
		NAntDotNetTypesWarningAsErrorImpl nAntDotNetTypesWarningAsError = new NAntDotNetTypesWarningAsErrorImpl();
		return nAntDotNetTypesWarningAsError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntMSNetTasksIldasmTask createNAntMSNetTasksIldasmTask() {
		NAntMSNetTasksIldasmTaskImpl nAntMSNetTasksIldasmTask = new NAntMSNetTasksIldasmTaskImpl();
		return nAntMSNetTasksIldasmTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntMSNetTasksServiceControllerTask createNAntMSNetTasksServiceControllerTask() {
		NAntMSNetTasksServiceControllerTaskImpl nAntMSNetTasksServiceControllerTask = new NAntMSNetTasksServiceControllerTaskImpl();
		return nAntMSNetTasksServiceControllerTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntNUnit1TasksNUnitTask createNAntNUnit1TasksNUnitTask() {
		NAntNUnit1TasksNUnitTaskImpl nAntNUnit1TasksNUnitTask = new NAntNUnit1TasksNUnitTaskImpl();
		return nAntNUnit1TasksNUnitTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntNUnit1TypesNUnitTest createNAntNUnit1TypesNUnitTest() {
		NAntNUnit1TypesNUnitTestImpl nAntNUnit1TypesNUnitTest = new NAntNUnit1TypesNUnitTestImpl();
		return nAntNUnit1TypesNUnitTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntNUnit2TasksNUnit2Task createNAntNUnit2TasksNUnit2Task() {
		NAntNUnit2TasksNUnit2TaskImpl nAntNUnit2TasksNUnit2Task = new NAntNUnit2TasksNUnit2TaskImpl();
		return nAntNUnit2TasksNUnit2Task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntNUnit2TypesCategories createNAntNUnit2TypesCategories() {
		NAntNUnit2TypesCategoriesImpl nAntNUnit2TypesCategories = new NAntNUnit2TypesCategoriesImpl();
		return nAntNUnit2TypesCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntNUnit2TypesCategory createNAntNUnit2TypesCategory() {
		NAntNUnit2TypesCategoryImpl nAntNUnit2TypesCategory = new NAntNUnit2TypesCategoryImpl();
		return nAntNUnit2TypesCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntNUnit2TypesNUnit2Test createNAntNUnit2TypesNUnit2Test() {
		NAntNUnit2TypesNUnit2TestImpl nAntNUnit2TypesNUnit2Test = new NAntNUnit2TypesNUnit2TestImpl();
		return nAntNUnit2TypesNUnit2Test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntNUnitTypesFormatterElement createNAntNUnitTypesFormatterElement() {
		NAntNUnitTypesFormatterElementImpl nAntNUnitTypesFormatterElement = new NAntNUnitTypesFormatterElementImpl();
		return nAntNUnitTypesFormatterElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksChangeLogTask createNAntSourceControlTasksChangeLogTask() {
		NAntSourceControlTasksChangeLogTaskImpl nAntSourceControlTasksChangeLogTask = new NAntSourceControlTasksChangeLogTaskImpl();
		return nAntSourceControlTasksChangeLogTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksCheckoutTask createNAntSourceControlTasksCheckoutTask() {
		NAntSourceControlTasksCheckoutTaskImpl nAntSourceControlTasksCheckoutTask = new NAntSourceControlTasksCheckoutTaskImpl();
		return nAntSourceControlTasksCheckoutTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksCvsPass createNAntSourceControlTasksCvsPass() {
		NAntSourceControlTasksCvsPassImpl nAntSourceControlTasksCvsPass = new NAntSourceControlTasksCvsPassImpl();
		return nAntSourceControlTasksCvsPass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksCvsTask createNAntSourceControlTasksCvsTask() {
		NAntSourceControlTasksCvsTaskImpl nAntSourceControlTasksCvsTask = new NAntSourceControlTasksCvsTaskImpl();
		return nAntSourceControlTasksCvsTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksExportTask createNAntSourceControlTasksExportTask() {
		NAntSourceControlTasksExportTaskImpl nAntSourceControlTasksExportTask = new NAntSourceControlTasksExportTaskImpl();
		return nAntSourceControlTasksExportTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksRTagTask createNAntSourceControlTasksRTagTask() {
		NAntSourceControlTasksRTagTaskImpl nAntSourceControlTasksRTagTask = new NAntSourceControlTasksRTagTaskImpl();
		return nAntSourceControlTasksRTagTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksTagTask createNAntSourceControlTasksTagTask() {
		NAntSourceControlTasksTagTaskImpl nAntSourceControlTasksTagTask = new NAntSourceControlTasksTagTaskImpl();
		return nAntSourceControlTasksTagTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTasksUpdateTask createNAntSourceControlTasksUpdateTask() {
		NAntSourceControlTasksUpdateTaskImpl nAntSourceControlTasksUpdateTask = new NAntSourceControlTasksUpdateTaskImpl();
		return nAntSourceControlTasksUpdateTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntSourceControlTypesCvsFileSet createNAntSourceControlTypesCvsFileSet() {
		NAntSourceControlTypesCvsFileSetImpl nAntSourceControlTypesCvsFileSet = new NAntSourceControlTypesCvsFileSetImpl();
		return nAntSourceControlTypesCvsFileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTasksClTask createNAntVisualCppTasksClTask() {
		NAntVisualCppTasksClTaskImpl nAntVisualCppTasksClTask = new NAntVisualCppTasksClTaskImpl();
		return nAntVisualCppTasksClTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTasksLibTask createNAntVisualCppTasksLibTask() {
		NAntVisualCppTasksLibTaskImpl nAntVisualCppTasksLibTask = new NAntVisualCppTasksLibTaskImpl();
		return nAntVisualCppTasksLibTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTasksLinkTask createNAntVisualCppTasksLinkTask() {
		NAntVisualCppTasksLinkTaskImpl nAntVisualCppTasksLinkTask = new NAntVisualCppTasksLinkTaskImpl();
		return nAntVisualCppTasksLinkTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTasksMcTask createNAntVisualCppTasksMcTask() {
		NAntVisualCppTasksMcTaskImpl nAntVisualCppTasksMcTask = new NAntVisualCppTasksMcTaskImpl();
		return nAntVisualCppTasksMcTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTasksMidlTask createNAntVisualCppTasksMidlTask() {
		NAntVisualCppTasksMidlTaskImpl nAntVisualCppTasksMidlTask = new NAntVisualCppTasksMidlTaskImpl();
		return nAntVisualCppTasksMidlTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTasksRcTask createNAntVisualCppTasksRcTask() {
		NAntVisualCppTasksRcTaskImpl nAntVisualCppTasksRcTask = new NAntVisualCppTasksRcTaskImpl();
		return nAntVisualCppTasksRcTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTypesLibrary createNAntVisualCppTypesLibrary() {
		NAntVisualCppTypesLibraryImpl nAntVisualCppTypesLibrary = new NAntVisualCppTypesLibraryImpl();
		return nAntVisualCppTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVisualCppTypesSymbol createNAntVisualCppTypesSymbol() {
		NAntVisualCppTypesSymbolImpl nAntVisualCppTypesSymbol = new NAntVisualCppTypesSymbolImpl();
		return nAntVisualCppTypesSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVSNetTasksSolutionTask createNAntVSNetTasksSolutionTask() {
		NAntVSNetTasksSolutionTaskImpl nAntVSNetTasksSolutionTask = new NAntVSNetTasksSolutionTaskImpl();
		return nAntVSNetTasksSolutionTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntVSNetTypesWebMap createNAntVSNetTypesWebMap() {
		NAntVSNetTypesWebMapImpl nAntVSNetTypesWebMap = new NAntVSNetTypesWebMapImpl();
		return nAntVSNetTypesWebMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntWin32TasksAxImpTask createNAntWin32TasksAxImpTask() {
		NAntWin32TasksAxImpTaskImpl nAntWin32TasksAxImpTask = new NAntWin32TasksAxImpTaskImpl();
		return nAntWin32TasksAxImpTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntWin32TasksReadRegistryTask createNAntWin32TasksReadRegistryTask() {
		NAntWin32TasksReadRegistryTaskImpl nAntWin32TasksReadRegistryTask = new NAntWin32TasksReadRegistryTaskImpl();
		return nAntWin32TasksReadRegistryTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntWin32TasksRegAsmTask createNAntWin32TasksRegAsmTask() {
		NAntWin32TasksRegAsmTaskImpl nAntWin32TasksRegAsmTask = new NAntWin32TasksRegAsmTaskImpl();
		return nAntWin32TasksRegAsmTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntWin32TasksTlbExpTask createNAntWin32TasksTlbExpTask() {
		NAntWin32TasksTlbExpTaskImpl nAntWin32TasksTlbExpTask = new NAntWin32TasksTlbExpTaskImpl();
		return nAntWin32TasksTlbExpTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAntWin32TasksTlbImpTask createNAntWin32TasksTlbImpTask() {
		NAntWin32TasksTlbImpTaskImpl nAntWin32TasksTlbImpTask = new NAntWin32TasksTlbImpTaskImpl();
		return nAntWin32TasksTlbImpTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NowarnType createNowarnType() {
		NowarnTypeImpl nowarnType = new NowarnTypeImpl();
		return nowarnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NowarnType1 createNowarnType1() {
		NowarnType1Impl nowarnType1 = new NowarnType1Impl();
		return nowarnType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NowarnType2 createNowarnType2() {
		NowarnType2Impl nowarnType2 = new NowarnType2Impl();
		return nowarnType2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionsType createOptionsType() {
		OptionsTypeImpl optionsType = new OptionsTypeImpl();
		return optionsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersType createParametersType() {
		ParametersTypeImpl parametersType = new ParametersTypeImpl();
		return parametersType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PkgReferencesType createPkgReferencesType() {
		PkgReferencesTypeImpl pkgReferencesType = new PkgReferencesTypeImpl();
		return pkgReferencesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PkgReferencesType1 createPkgReferencesType1() {
		PkgReferencesType1Impl pkgReferencesType1 = new PkgReferencesType1Impl();
		return pkgReferencesType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PkgReferencesType2 createPkgReferencesType2() {
		PkgReferencesType2Impl pkgReferencesType2 = new PkgReferencesType2Impl();
		return pkgReferencesType2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectType createProjectType() {
		ProjectTypeImpl projectType = new ProjectTypeImpl();
		return projectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesType createPropertiesType() {
		PropertiesTypeImpl propertiesType = new PropertiesTypeImpl();
		return propertiesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolsType createSymbolsType() {
		SymbolsTypeImpl symbolsType = new SymbolsTypeImpl();
		return symbolsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolsType1 createSymbolsType1() {
		SymbolsType1Impl symbolsType1 = new SymbolsType1Impl();
		return symbolsType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestsNAntCoreElementTest1Task createTestsNAntCoreElementTest1Task() {
		TestsNAntCoreElementTest1TaskImpl testsNAntCoreElementTest1Task = new TestsNAntCoreElementTest1TaskImpl();
		return testsNAntCoreElementTest1Task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestsNAntCoreTestTask createTestsNAntCoreTestTask() {
		TestsNAntCoreTestTaskImpl testsNAntCoreTestTask = new TestsNAntCoreTestTaskImpl();
		return testsNAntCoreTestTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestsNAntCoreUtilXmlLoggerTestTestTask createTestsNAntCoreUtilXmlLoggerTestTestTask() {
		TestsNAntCoreUtilXmlLoggerTestTestTaskImpl testsNAntCoreUtilXmlLoggerTestTestTask = new TestsNAntCoreUtilXmlLoggerTestTestTaskImpl();
		return testsNAntCoreUtilXmlLoggerTestTestTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UndefinesType createUndefinesType() {
		UndefinesTypeImpl undefinesType = new UndefinesTypeImpl();
		return undefinesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UndefinesType1 createUndefinesType1() {
		UndefinesType1Impl undefinesType1 = new UndefinesType1Impl();
		return undefinesType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebmapType createWebmapType() {
		WebmapTypeImpl webmapType = new WebmapTypeImpl();
		return webmapType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NantPackage getNantPackage() {
		return (NantPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NantPackage getPackage() {
		return NantPackage.eINSTANCE;
	}

} //NantFactoryImpl
