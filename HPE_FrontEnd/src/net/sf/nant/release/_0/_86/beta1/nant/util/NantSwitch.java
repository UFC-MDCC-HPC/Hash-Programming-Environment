/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.util;

import java.util.List;

import net.sf.nant.release._0._86.beta1.nant.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage
 * @generated
 */
public class NantSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NantPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NantSwitch() {
		if (modelPackage == null) {
			modelPackage = NantPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case NantPackage.ATTRIBUTES_TYPE: {
				AttributesType attributesType = (AttributesType)theEObject;
				T result = caseAttributesType(attributesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.DEFINES_TYPE: {
				DefinesType definesType = (DefinesType)theEObject;
				T result = caseDefinesType(definesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.DEFINES_TYPE1: {
				DefinesType1 definesType1 = (DefinesType1)theEObject;
				T result = caseDefinesType1(definesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.DEFINES_TYPE2: {
				DefinesType2 definesType2 = (DefinesType2)theEObject;
				T result = caseDefinesType2(definesType2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.EXTENSIONOBJECTS_TYPE: {
				ExtensionobjectsType extensionobjectsType = (ExtensionobjectsType)theEObject;
				T result = caseExtensionobjectsType(extensionobjectsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.IGNORELIBRARIES_TYPE: {
				IgnorelibrariesType ignorelibrariesType = (IgnorelibrariesType)theEObject;
				T result = caseIgnorelibrariesType(ignorelibrariesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.IGNORELIBRARIES_TYPE1: {
				IgnorelibrariesType1 ignorelibrariesType1 = (IgnorelibrariesType1)theEObject;
				T result = caseIgnorelibrariesType1(ignorelibrariesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NAMESPACES_TYPE: {
				NamespacesType namespacesType = (NamespacesType)theEObject;
				T result = caseNamespacesType(namespacesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NAMESPACES_TYPE1: {
				NamespacesType1 namespacesType1 = (NamespacesType1)theEObject;
				T result = caseNamespacesType1(namespacesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_COMPRESSION_TASKS_GUNZIP: {
				NAntCompressionTasksGUnzip nAntCompressionTasksGUnzip = (NAntCompressionTasksGUnzip)theEObject;
				T result = caseNAntCompressionTasksGUnzip(nAntCompressionTasksGUnzip);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_COMPRESSION_TASKS_TAR_TASK: {
				NAntCompressionTasksTarTask nAntCompressionTasksTarTask = (NAntCompressionTasksTarTask)theEObject;
				T result = caseNAntCompressionTasksTarTask(nAntCompressionTasksTarTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_COMPRESSION_TASKS_UN_ZIP_TASK: {
				NAntCompressionTasksUnZipTask nAntCompressionTasksUnZipTask = (NAntCompressionTasksUnZipTask)theEObject;
				T result = caseNAntCompressionTasksUnZipTask(nAntCompressionTasksUnZipTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK: {
				NAntCompressionTasksZipTask nAntCompressionTasksZipTask = (NAntCompressionTasksZipTask)theEObject;
				T result = caseNAntCompressionTasksZipTask(nAntCompressionTasksZipTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_COMPRESSION_TYPES_TAR_FILE_SET: {
				NAntCompressionTypesTarFileSet nAntCompressionTypesTarFileSet = (NAntCompressionTypesTarFileSet)theEObject;
				T result = caseNAntCompressionTypesTarFileSet(nAntCompressionTypesTarFileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_COMPRESSION_TYPES_ZIP_FILE_SET: {
				NAntCompressionTypesZipFileSet nAntCompressionTypesZipFileSet = (NAntCompressionTypesZipFileSet)theEObject;
				T result = caseNAntCompressionTypesZipFileSet(nAntCompressionTypesZipFileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_FILTERS_FILTER: {
				NAntCoreFiltersFilter nAntCoreFiltersFilter = (NAntCoreFiltersFilter)theEObject;
				T result = caseNAntCoreFiltersFilter(nAntCoreFiltersFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_FILTERS_FILTER_CHAIN: {
				NAntCoreFiltersFilterChain nAntCoreFiltersFilterChain = (NAntCoreFiltersFilterChain)theEObject;
				T result = caseNAntCoreFiltersFilterChain(nAntCoreFiltersFilterChain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASK_CONTAINER: {
				NAntCoreTaskContainer nAntCoreTaskContainer = (NAntCoreTaskContainer)theEObject;
				T result = caseNAntCoreTaskContainer(nAntCoreTaskContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_ATTRIB_TASK: {
				NAntCoreTasksAttribTask nAntCoreTasksAttribTask = (NAntCoreTasksAttribTask)theEObject;
				T result = caseNAntCoreTasksAttribTask(nAntCoreTasksAttribTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_AVAILABLE_TASK: {
				NAntCoreTasksAvailableTask nAntCoreTasksAvailableTask = (NAntCoreTasksAvailableTask)theEObject;
				T result = caseNAntCoreTasksAvailableTask(nAntCoreTasksAvailableTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_CALL_TASK: {
				NAntCoreTasksCallTask nAntCoreTasksCallTask = (NAntCoreTasksCallTask)theEObject;
				T result = caseNAntCoreTasksCallTask(nAntCoreTasksCallTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_COPY_TASK: {
				NAntCoreTasksCopyTask nAntCoreTasksCopyTask = (NAntCoreTasksCopyTask)theEObject;
				T result = caseNAntCoreTasksCopyTask(nAntCoreTasksCopyTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_DELETE_TASK: {
				NAntCoreTasksDeleteTask nAntCoreTasksDeleteTask = (NAntCoreTasksDeleteTask)theEObject;
				T result = caseNAntCoreTasksDeleteTask(nAntCoreTasksDeleteTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_DESCRIPTION_TASK: {
				NAntCoreTasksDescriptionTask nAntCoreTasksDescriptionTask = (NAntCoreTasksDescriptionTask)theEObject;
				T result = caseNAntCoreTasksDescriptionTask(nAntCoreTasksDescriptionTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_ECHO_TASK: {
				NAntCoreTasksEchoTask nAntCoreTasksEchoTask = (NAntCoreTasksEchoTask)theEObject;
				T result = caseNAntCoreTasksEchoTask(nAntCoreTasksEchoTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_EXEC_TASK: {
				NAntCoreTasksExecTask nAntCoreTasksExecTask = (NAntCoreTasksExecTask)theEObject;
				T result = caseNAntCoreTasksExecTask(nAntCoreTasksExecTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_FAIL_TASK: {
				NAntCoreTasksFailTask nAntCoreTasksFailTask = (NAntCoreTasksFailTask)theEObject;
				T result = caseNAntCoreTasksFailTask(nAntCoreTasksFailTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_GET_TASK: {
				NAntCoreTasksGetTask nAntCoreTasksGetTask = (NAntCoreTasksGetTask)theEObject;
				T result = caseNAntCoreTasksGetTask(nAntCoreTasksGetTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_IF_NOT_TASK: {
				NAntCoreTasksIfNotTask nAntCoreTasksIfNotTask = (NAntCoreTasksIfNotTask)theEObject;
				T result = caseNAntCoreTasksIfNotTask(nAntCoreTasksIfNotTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_IF_TASK: {
				NAntCoreTasksIfTask nAntCoreTasksIfTask = (NAntCoreTasksIfTask)theEObject;
				T result = caseNAntCoreTasksIfTask(nAntCoreTasksIfTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_INCLUDE_TASK: {
				NAntCoreTasksIncludeTask nAntCoreTasksIncludeTask = (NAntCoreTasksIncludeTask)theEObject;
				T result = caseNAntCoreTasksIncludeTask(nAntCoreTasksIncludeTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_IN_ELEMENT: {
				NAntCoreTasksInElement nAntCoreTasksInElement = (NAntCoreTasksInElement)theEObject;
				T result = caseNAntCoreTasksInElement(nAntCoreTasksInElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_LOAD_FILE_TASK: {
				NAntCoreTasksLoadFileTask nAntCoreTasksLoadFileTask = (NAntCoreTasksLoadFileTask)theEObject;
				T result = caseNAntCoreTasksLoadFileTask(nAntCoreTasksLoadFileTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_LOAD_TASKS_TASK: {
				NAntCoreTasksLoadTasksTask nAntCoreTasksLoadTasksTask = (NAntCoreTasksLoadTasksTask)theEObject;
				T result = caseNAntCoreTasksLoadTasksTask(nAntCoreTasksLoadTasksTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_LOOP_TASK: {
				NAntCoreTasksLoopTask nAntCoreTasksLoopTask = (NAntCoreTasksLoopTask)theEObject;
				T result = caseNAntCoreTasksLoopTask(nAntCoreTasksLoopTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_MAIL_TASK: {
				NAntCoreTasksMailTask nAntCoreTasksMailTask = (NAntCoreTasksMailTask)theEObject;
				T result = caseNAntCoreTasksMailTask(nAntCoreTasksMailTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_MK_DIR_TASK: {
				NAntCoreTasksMkDirTask nAntCoreTasksMkDirTask = (NAntCoreTasksMkDirTask)theEObject;
				T result = caseNAntCoreTasksMkDirTask(nAntCoreTasksMkDirTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK: {
				NAntCoreTasksMoveTask nAntCoreTasksMoveTask = (NAntCoreTasksMoveTask)theEObject;
				T result = caseNAntCoreTasksMoveTask(nAntCoreTasksMoveTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_NANT_SCHEMA_TASK: {
				NAntCoreTasksNAntSchemaTask nAntCoreTasksNAntSchemaTask = (NAntCoreTasksNAntSchemaTask)theEObject;
				T result = caseNAntCoreTasksNAntSchemaTask(nAntCoreTasksNAntSchemaTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_NANT_TASK: {
				NAntCoreTasksNAntTask nAntCoreTasksNAntTask = (NAntCoreTasksNAntTask)theEObject;
				T result = caseNAntCoreTasksNAntTask(nAntCoreTasksNAntTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_PROPERTY_TASK: {
				NAntCoreTasksPropertyTask nAntCoreTasksPropertyTask = (NAntCoreTasksPropertyTask)theEObject;
				T result = caseNAntCoreTasksPropertyTask(nAntCoreTasksPropertyTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_REGEX_TASK: {
				NAntCoreTasksRegexTask nAntCoreTasksRegexTask = (NAntCoreTasksRegexTask)theEObject;
				T result = caseNAntCoreTasksRegexTask(nAntCoreTasksRegexTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_SET_ENV_TASK: {
				NAntCoreTasksSetEnvTask nAntCoreTasksSetEnvTask = (NAntCoreTasksSetEnvTask)theEObject;
				T result = caseNAntCoreTasksSetEnvTask(nAntCoreTasksSetEnvTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_SLEEP_TASK: {
				NAntCoreTasksSleepTask nAntCoreTasksSleepTask = (NAntCoreTasksSleepTask)theEObject;
				T result = caseNAntCoreTasksSleepTask(nAntCoreTasksSleepTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_STYLE_TASK: {
				NAntCoreTasksStyleTask nAntCoreTasksStyleTask = (NAntCoreTasksStyleTask)theEObject;
				T result = caseNAntCoreTasksStyleTask(nAntCoreTasksStyleTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_SYS_INFO_TASK: {
				NAntCoreTasksSysInfoTask nAntCoreTasksSysInfoTask = (NAntCoreTasksSysInfoTask)theEObject;
				T result = caseNAntCoreTasksSysInfoTask(nAntCoreTasksSysInfoTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_TOUCH_TASK: {
				NAntCoreTasksTouchTask nAntCoreTasksTouchTask = (NAntCoreTasksTouchTask)theEObject;
				T result = caseNAntCoreTasksTouchTask(nAntCoreTasksTouchTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_TSTAMP_TASK: {
				NAntCoreTasksTStampTask nAntCoreTasksTStampTask = (NAntCoreTasksTStampTask)theEObject;
				T result = caseNAntCoreTasksTStampTask(nAntCoreTasksTStampTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_UP_TO_DATE_TASK: {
				NAntCoreTasksUpToDateTask nAntCoreTasksUpToDateTask = (NAntCoreTasksUpToDateTask)theEObject;
				T result = caseNAntCoreTasksUpToDateTask(nAntCoreTasksUpToDateTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK: {
				NAntCoreTasksXmlPeekTask nAntCoreTasksXmlPeekTask = (NAntCoreTasksXmlPeekTask)theEObject;
				T result = caseNAntCoreTasksXmlPeekTask(nAntCoreTasksXmlPeekTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TASKS_XML_POKE_TASK: {
				NAntCoreTasksXmlPokeTask nAntCoreTasksXmlPokeTask = (NAntCoreTasksXmlPokeTask)theEObject;
				T result = caseNAntCoreTasksXmlPokeTask(nAntCoreTasksXmlPokeTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_ARGUMENT: {
				NAntCoreTypesArgument nAntCoreTypesArgument = (NAntCoreTypesArgument)theEObject;
				T result = caseNAntCoreTypesArgument(nAntCoreTypesArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_CREDENTIAL: {
				NAntCoreTypesCredential nAntCoreTypesCredential = (NAntCoreTypesCredential)theEObject;
				T result = caseNAntCoreTypesCredential(nAntCoreTypesCredential);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_DIR_SET: {
				NAntCoreTypesDirSet nAntCoreTypesDirSet = (NAntCoreTypesDirSet)theEObject;
				T result = caseNAntCoreTypesDirSet(nAntCoreTypesDirSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_SET: {
				NAntCoreTypesEnvironmentSet nAntCoreTypesEnvironmentSet = (NAntCoreTypesEnvironmentSet)theEObject;
				T result = caseNAntCoreTypesEnvironmentSet(nAntCoreTypesEnvironmentSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE: {
				NAntCoreTypesEnvironmentVariable nAntCoreTypesEnvironmentVariable = (NAntCoreTypesEnvironmentVariable)theEObject;
				T result = caseNAntCoreTypesEnvironmentVariable(nAntCoreTypesEnvironmentVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_FILE_SET: {
				NAntCoreTypesFileSet nAntCoreTypesFileSet = (NAntCoreTypesFileSet)theEObject;
				T result = caseNAntCoreTypesFileSet(nAntCoreTypesFileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_FILE_SET_EXCLUDE: {
				NAntCoreTypesFileSetExclude nAntCoreTypesFileSetExclude = (NAntCoreTypesFileSetExclude)theEObject;
				T result = caseNAntCoreTypesFileSetExclude(nAntCoreTypesFileSetExclude);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_FILE_SET_EXCLUDES_FILE: {
				NAntCoreTypesFileSetExcludesFile nAntCoreTypesFileSetExcludesFile = (NAntCoreTypesFileSetExcludesFile)theEObject;
				T result = caseNAntCoreTypesFileSetExcludesFile(nAntCoreTypesFileSetExcludesFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_FILE_SET_INCLUDE: {
				NAntCoreTypesFileSetInclude nAntCoreTypesFileSetInclude = (NAntCoreTypesFileSetInclude)theEObject;
				T result = caseNAntCoreTypesFileSetInclude(nAntCoreTypesFileSetInclude);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_FILE_SET_INCLUDES_FILE: {
				NAntCoreTypesFileSetIncludesFile nAntCoreTypesFileSetIncludesFile = (NAntCoreTypesFileSetIncludesFile)theEObject;
				T result = caseNAntCoreTypesFileSetIncludesFile(nAntCoreTypesFileSetIncludesFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_FORMATTER: {
				NAntCoreTypesFormatter nAntCoreTypesFormatter = (NAntCoreTypesFormatter)theEObject;
				T result = caseNAntCoreTypesFormatter(nAntCoreTypesFormatter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_OPTION: {
				NAntCoreTypesOption nAntCoreTypesOption = (NAntCoreTypesOption)theEObject;
				T result = caseNAntCoreTypesOption(nAntCoreTypesOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_PATH_ELEMENT: {
				NAntCoreTypesPathElement nAntCoreTypesPathElement = (NAntCoreTypesPathElement)theEObject;
				T result = caseNAntCoreTypesPathElement(nAntCoreTypesPathElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_PATH_SET: {
				NAntCoreTypesPathSet nAntCoreTypesPathSet = (NAntCoreTypesPathSet)theEObject;
				T result = caseNAntCoreTypesPathSet(nAntCoreTypesPathSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_PATTERN: {
				NAntCoreTypesPattern nAntCoreTypesPattern = (NAntCoreTypesPattern)theEObject;
				T result = caseNAntCoreTypesPattern(nAntCoreTypesPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_PATTERN_SET: {
				NAntCoreTypesPatternSet nAntCoreTypesPatternSet = (NAntCoreTypesPatternSet)theEObject;
				T result = caseNAntCoreTypesPatternSet(nAntCoreTypesPatternSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_PROXY: {
				NAntCoreTypesProxy nAntCoreTypesProxy = (NAntCoreTypesProxy)theEObject;
				T result = caseNAntCoreTypesProxy(nAntCoreTypesProxy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_RAW_XML: {
				NAntCoreTypesRawXml nAntCoreTypesRawXml = (NAntCoreTypesRawXml)theEObject;
				T result = caseNAntCoreTypesRawXml(nAntCoreTypesRawXml);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_XML_NAMESPACE: {
				NAntCoreTypesXmlNamespace nAntCoreTypesXmlNamespace = (NAntCoreTypesXmlNamespace)theEObject;
				T result = caseNAntCoreTypesXmlNamespace(nAntCoreTypesXmlNamespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_XSLT_EXTENSION_OBJECT: {
				NAntCoreTypesXsltExtensionObject nAntCoreTypesXsltExtensionObject = (NAntCoreTypesXsltExtensionObject)theEObject;
				T result = caseNAntCoreTypesXsltExtensionObject(nAntCoreTypesXsltExtensionObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_CORE_TYPES_XSLT_PARAMETER: {
				NAntCoreTypesXsltParameter nAntCoreTypesXsltParameter = (NAntCoreTypesXsltParameter)theEObject;
				T result = caseNAntCoreTypesXsltParameter(nAntCoreTypesXsltParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK: {
				NAntDotNetTasksAssemblyInfoTask nAntDotNetTasksAssemblyInfoTask = (NAntDotNetTasksAssemblyInfoTask)theEObject;
				T result = caseNAntDotNetTasksAssemblyInfoTask(nAntDotNetTasksAssemblyInfoTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK: {
				NAntDotNetTasksAssemblyLinkerTask nAntDotNetTasksAssemblyLinkerTask = (NAntDotNetTasksAssemblyLinkerTask)theEObject;
				T result = caseNAntDotNetTasksAssemblyLinkerTask(nAntDotNetTasksAssemblyLinkerTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_CSC_TASK: {
				NAntDotNetTasksCscTask nAntDotNetTasksCscTask = (NAntDotNetTasksCscTask)theEObject;
				T result = caseNAntDotNetTasksCscTask(nAntDotNetTasksCscTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_DELAY_SIGN_TASK: {
				NAntDotNetTasksDelaySignTask nAntDotNetTasksDelaySignTask = (NAntDotNetTasksDelaySignTask)theEObject;
				T result = caseNAntDotNetTasksDelaySignTask(nAntDotNetTasksDelaySignTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_ILASM_TASK: {
				NAntDotNetTasksIlasmTask nAntDotNetTasksIlasmTask = (NAntDotNetTasksIlasmTask)theEObject;
				T result = caseNAntDotNetTasksIlasmTask(nAntDotNetTasksIlasmTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_JSC_TASK: {
				NAntDotNetTasksJscTask nAntDotNetTasksJscTask = (NAntDotNetTasksJscTask)theEObject;
				T result = caseNAntDotNetTasksJscTask(nAntDotNetTasksJscTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_LICENSE_TASK: {
				NAntDotNetTasksLicenseTask nAntDotNetTasksLicenseTask = (NAntDotNetTasksLicenseTask)theEObject;
				T result = caseNAntDotNetTasksLicenseTask(nAntDotNetTasksLicenseTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK: {
				NAntDotNetTasksNDocTask nAntDotNetTasksNDocTask = (NAntDotNetTasksNDocTask)theEObject;
				T result = caseNAntDotNetTasksNDocTask(nAntDotNetTasksNDocTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_REGSVCS_TASK: {
				NAntDotNetTasksRegsvcsTask nAntDotNetTasksRegsvcsTask = (NAntDotNetTasksRegsvcsTask)theEObject;
				T result = caseNAntDotNetTasksRegsvcsTask(nAntDotNetTasksRegsvcsTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_RES_GEN_TASK: {
				NAntDotNetTasksResGenTask nAntDotNetTasksResGenTask = (NAntDotNetTasksResGenTask)theEObject;
				T result = caseNAntDotNetTasksResGenTask(nAntDotNetTasksResGenTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_SCRIPT_TASK: {
				NAntDotNetTasksScriptTask nAntDotNetTasksScriptTask = (NAntDotNetTasksScriptTask)theEObject;
				T result = caseNAntDotNetTasksScriptTask(nAntDotNetTasksScriptTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_VBC_TASK: {
				NAntDotNetTasksVbcTask nAntDotNetTasksVbcTask = (NAntDotNetTasksVbcTask)theEObject;
				T result = caseNAntDotNetTasksVbcTask(nAntDotNetTasksVbcTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TASKS_VJC_TASK: {
				NAntDotNetTasksVjcTask nAntDotNetTasksVjcTask = (NAntDotNetTasksVjcTask)theEObject;
				T result = caseNAntDotNetTasksVjcTask(nAntDotNetTasksVjcTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_ASSEMBLY_ATTRIBUTE: {
				NAntDotNetTypesAssemblyAttribute nAntDotNetTypesAssemblyAttribute = (NAntDotNetTypesAssemblyAttribute)theEObject;
				T result = caseNAntDotNetTypesAssemblyAttribute(nAntDotNetTypesAssemblyAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_ASSEMBLY_FILE_SET: {
				NAntDotNetTypesAssemblyFileSet nAntDotNetTypesAssemblyFileSet = (NAntDotNetTypesAssemblyFileSet)theEObject;
				T result = caseNAntDotNetTypesAssemblyFileSet(nAntDotNetTypesAssemblyFileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_COMPILER_WARNING: {
				NAntDotNetTypesCompilerWarning nAntDotNetTypesCompilerWarning = (NAntDotNetTypesCompilerWarning)theEObject;
				T result = caseNAntDotNetTypesCompilerWarning(nAntDotNetTypesCompilerWarning);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_LIB_DIRECTORY_SET: {
				NAntDotNetTypesLibDirectorySet nAntDotNetTypesLibDirectorySet = (NAntDotNetTypesLibDirectorySet)theEObject;
				T result = caseNAntDotNetTypesLibDirectorySet(nAntDotNetTypesLibDirectorySet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_MODULE: {
				NAntDotNetTypesModule nAntDotNetTypesModule = (NAntDotNetTypesModule)theEObject;
				T result = caseNAntDotNetTypesModule(nAntDotNetTypesModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_MODULE_SET: {
				NAntDotNetTypesModuleSet nAntDotNetTypesModuleSet = (NAntDotNetTypesModuleSet)theEObject;
				T result = caseNAntDotNetTypesModuleSet(nAntDotNetTypesModuleSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_NAMESPACE_IMPORT: {
				NAntDotNetTypesNamespaceImport nAntDotNetTypesNamespaceImport = (NAntDotNetTypesNamespaceImport)theEObject;
				T result = caseNAntDotNetTypesNamespaceImport(nAntDotNetTypesNamespaceImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_NAMESPACE_IMPORT_COLLECTION: {
				NAntDotNetTypesNamespaceImportCollection nAntDotNetTypesNamespaceImportCollection = (NAntDotNetTypesNamespaceImportCollection)theEObject;
				T result = caseNAntDotNetTypesNamespaceImportCollection(nAntDotNetTypesNamespaceImportCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_PACKAGE: {
				NAntDotNetTypesPackage nAntDotNetTypesPackage = (NAntDotNetTypesPackage)theEObject;
				T result = caseNAntDotNetTypesPackage(nAntDotNetTypesPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_RESOURCE_FILE_SET: {
				NAntDotNetTypesResourceFileSet nAntDotNetTypesResourceFileSet = (NAntDotNetTypesResourceFileSet)theEObject;
				T result = caseNAntDotNetTypesResourceFileSet(nAntDotNetTypesResourceFileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_DOT_NET_TYPES_WARNING_AS_ERROR: {
				NAntDotNetTypesWarningAsError nAntDotNetTypesWarningAsError = (NAntDotNetTypesWarningAsError)theEObject;
				T result = caseNAntDotNetTypesWarningAsError(nAntDotNetTypesWarningAsError);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK: {
				NAntMSNetTasksIldasmTask nAntMSNetTasksIldasmTask = (NAntMSNetTasksIldasmTask)theEObject;
				T result = caseNAntMSNetTasksIldasmTask(nAntMSNetTasksIldasmTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_MS_NET_TASKS_SERVICE_CONTROLLER_TASK: {
				NAntMSNetTasksServiceControllerTask nAntMSNetTasksServiceControllerTask = (NAntMSNetTasksServiceControllerTask)theEObject;
				T result = caseNAntMSNetTasksServiceControllerTask(nAntMSNetTasksServiceControllerTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_NUNIT1_TASKS_NUNIT_TASK: {
				NAntNUnit1TasksNUnitTask nAntNUnit1TasksNUnitTask = (NAntNUnit1TasksNUnitTask)theEObject;
				T result = caseNAntNUnit1TasksNUnitTask(nAntNUnit1TasksNUnitTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST: {
				NAntNUnit1TypesNUnitTest nAntNUnit1TypesNUnitTest = (NAntNUnit1TypesNUnitTest)theEObject;
				T result = caseNAntNUnit1TypesNUnitTest(nAntNUnit1TypesNUnitTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_NUNIT2_TASKS_NUNIT2_TASK: {
				NAntNUnit2TasksNUnit2Task nAntNUnit2TasksNUnit2Task = (NAntNUnit2TasksNUnit2Task)theEObject;
				T result = caseNAntNUnit2TasksNUnit2Task(nAntNUnit2TasksNUnit2Task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_NUNIT2_TYPES_CATEGORIES: {
				NAntNUnit2TypesCategories nAntNUnit2TypesCategories = (NAntNUnit2TypesCategories)theEObject;
				T result = caseNAntNUnit2TypesCategories(nAntNUnit2TypesCategories);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_NUNIT2_TYPES_CATEGORY: {
				NAntNUnit2TypesCategory nAntNUnit2TypesCategory = (NAntNUnit2TypesCategory)theEObject;
				T result = caseNAntNUnit2TypesCategory(nAntNUnit2TypesCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST: {
				NAntNUnit2TypesNUnit2Test nAntNUnit2TypesNUnit2Test = (NAntNUnit2TypesNUnit2Test)theEObject;
				T result = caseNAntNUnit2TypesNUnit2Test(nAntNUnit2TypesNUnit2Test);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT: {
				NAntNUnitTypesFormatterElement nAntNUnitTypesFormatterElement = (NAntNUnitTypesFormatterElement)theEObject;
				T result = caseNAntNUnitTypesFormatterElement(nAntNUnitTypesFormatterElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CHANGE_LOG_TASK: {
				NAntSourceControlTasksChangeLogTask nAntSourceControlTasksChangeLogTask = (NAntSourceControlTasksChangeLogTask)theEObject;
				T result = caseNAntSourceControlTasksChangeLogTask(nAntSourceControlTasksChangeLogTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CHECKOUT_TASK: {
				NAntSourceControlTasksCheckoutTask nAntSourceControlTasksCheckoutTask = (NAntSourceControlTasksCheckoutTask)theEObject;
				T result = caseNAntSourceControlTasksCheckoutTask(nAntSourceControlTasksCheckoutTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_PASS: {
				NAntSourceControlTasksCvsPass nAntSourceControlTasksCvsPass = (NAntSourceControlTasksCvsPass)theEObject;
				T result = caseNAntSourceControlTasksCvsPass(nAntSourceControlTasksCvsPass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_CVS_TASK: {
				NAntSourceControlTasksCvsTask nAntSourceControlTasksCvsTask = (NAntSourceControlTasksCvsTask)theEObject;
				T result = caseNAntSourceControlTasksCvsTask(nAntSourceControlTasksCvsTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_EXPORT_TASK: {
				NAntSourceControlTasksExportTask nAntSourceControlTasksExportTask = (NAntSourceControlTasksExportTask)theEObject;
				T result = caseNAntSourceControlTasksExportTask(nAntSourceControlTasksExportTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_RTAG_TASK: {
				NAntSourceControlTasksRTagTask nAntSourceControlTasksRTagTask = (NAntSourceControlTasksRTagTask)theEObject;
				T result = caseNAntSourceControlTasksRTagTask(nAntSourceControlTasksRTagTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_TAG_TASK: {
				NAntSourceControlTasksTagTask nAntSourceControlTasksTagTask = (NAntSourceControlTasksTagTask)theEObject;
				T result = caseNAntSourceControlTasksTagTask(nAntSourceControlTasksTagTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK: {
				NAntSourceControlTasksUpdateTask nAntSourceControlTasksUpdateTask = (NAntSourceControlTasksUpdateTask)theEObject;
				T result = caseNAntSourceControlTasksUpdateTask(nAntSourceControlTasksUpdateTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_SOURCE_CONTROL_TYPES_CVS_FILE_SET: {
				NAntSourceControlTypesCvsFileSet nAntSourceControlTypesCvsFileSet = (NAntSourceControlTypesCvsFileSet)theEObject;
				T result = caseNAntSourceControlTypesCvsFileSet(nAntSourceControlTypesCvsFileSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TASKS_CL_TASK: {
				NAntVisualCppTasksClTask nAntVisualCppTasksClTask = (NAntVisualCppTasksClTask)theEObject;
				T result = caseNAntVisualCppTasksClTask(nAntVisualCppTasksClTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TASKS_LIB_TASK: {
				NAntVisualCppTasksLibTask nAntVisualCppTasksLibTask = (NAntVisualCppTasksLibTask)theEObject;
				T result = caseNAntVisualCppTasksLibTask(nAntVisualCppTasksLibTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TASKS_LINK_TASK: {
				NAntVisualCppTasksLinkTask nAntVisualCppTasksLinkTask = (NAntVisualCppTasksLinkTask)theEObject;
				T result = caseNAntVisualCppTasksLinkTask(nAntVisualCppTasksLinkTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TASKS_MC_TASK: {
				NAntVisualCppTasksMcTask nAntVisualCppTasksMcTask = (NAntVisualCppTasksMcTask)theEObject;
				T result = caseNAntVisualCppTasksMcTask(nAntVisualCppTasksMcTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TASKS_MIDL_TASK: {
				NAntVisualCppTasksMidlTask nAntVisualCppTasksMidlTask = (NAntVisualCppTasksMidlTask)theEObject;
				T result = caseNAntVisualCppTasksMidlTask(nAntVisualCppTasksMidlTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TASKS_RC_TASK: {
				NAntVisualCppTasksRcTask nAntVisualCppTasksRcTask = (NAntVisualCppTasksRcTask)theEObject;
				T result = caseNAntVisualCppTasksRcTask(nAntVisualCppTasksRcTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TYPES_LIBRARY: {
				NAntVisualCppTypesLibrary nAntVisualCppTypesLibrary = (NAntVisualCppTypesLibrary)theEObject;
				T result = caseNAntVisualCppTypesLibrary(nAntVisualCppTypesLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VISUAL_CPP_TYPES_SYMBOL: {
				NAntVisualCppTypesSymbol nAntVisualCppTypesSymbol = (NAntVisualCppTypesSymbol)theEObject;
				T result = caseNAntVisualCppTypesSymbol(nAntVisualCppTypesSymbol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK: {
				NAntVSNetTasksSolutionTask nAntVSNetTasksSolutionTask = (NAntVSNetTasksSolutionTask)theEObject;
				T result = caseNAntVSNetTasksSolutionTask(nAntVSNetTasksSolutionTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_VS_NET_TYPES_WEB_MAP: {
				NAntVSNetTypesWebMap nAntVSNetTypesWebMap = (NAntVSNetTypesWebMap)theEObject;
				T result = caseNAntVSNetTypesWebMap(nAntVSNetTypesWebMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_WIN32_TASKS_AX_IMP_TASK: {
				NAntWin32TasksAxImpTask nAntWin32TasksAxImpTask = (NAntWin32TasksAxImpTask)theEObject;
				T result = caseNAntWin32TasksAxImpTask(nAntWin32TasksAxImpTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_WIN32_TASKS_READ_REGISTRY_TASK: {
				NAntWin32TasksReadRegistryTask nAntWin32TasksReadRegistryTask = (NAntWin32TasksReadRegistryTask)theEObject;
				T result = caseNAntWin32TasksReadRegistryTask(nAntWin32TasksReadRegistryTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_WIN32_TASKS_REG_ASM_TASK: {
				NAntWin32TasksRegAsmTask nAntWin32TasksRegAsmTask = (NAntWin32TasksRegAsmTask)theEObject;
				T result = caseNAntWin32TasksRegAsmTask(nAntWin32TasksRegAsmTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_WIN32_TASKS_TLB_EXP_TASK: {
				NAntWin32TasksTlbExpTask nAntWin32TasksTlbExpTask = (NAntWin32TasksTlbExpTask)theEObject;
				T result = caseNAntWin32TasksTlbExpTask(nAntWin32TasksTlbExpTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NANT_WIN32_TASKS_TLB_IMP_TASK: {
				NAntWin32TasksTlbImpTask nAntWin32TasksTlbImpTask = (NAntWin32TasksTlbImpTask)theEObject;
				T result = caseNAntWin32TasksTlbImpTask(nAntWin32TasksTlbImpTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NOWARN_TYPE: {
				NowarnType nowarnType = (NowarnType)theEObject;
				T result = caseNowarnType(nowarnType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NOWARN_TYPE1: {
				NowarnType1 nowarnType1 = (NowarnType1)theEObject;
				T result = caseNowarnType1(nowarnType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.NOWARN_TYPE2: {
				NowarnType2 nowarnType2 = (NowarnType2)theEObject;
				T result = caseNowarnType2(nowarnType2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.OPTIONS_TYPE: {
				OptionsType optionsType = (OptionsType)theEObject;
				T result = caseOptionsType(optionsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.PARAMETERS_TYPE: {
				ParametersType parametersType = (ParametersType)theEObject;
				T result = caseParametersType(parametersType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.PKG_REFERENCES_TYPE: {
				PkgReferencesType pkgReferencesType = (PkgReferencesType)theEObject;
				T result = casePkgReferencesType(pkgReferencesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.PKG_REFERENCES_TYPE1: {
				PkgReferencesType1 pkgReferencesType1 = (PkgReferencesType1)theEObject;
				T result = casePkgReferencesType1(pkgReferencesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.PKG_REFERENCES_TYPE2: {
				PkgReferencesType2 pkgReferencesType2 = (PkgReferencesType2)theEObject;
				T result = casePkgReferencesType2(pkgReferencesType2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.PROJECT_TYPE: {
				ProjectType projectType = (ProjectType)theEObject;
				T result = caseProjectType(projectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.PROPERTIES_TYPE: {
				PropertiesType propertiesType = (PropertiesType)theEObject;
				T result = casePropertiesType(propertiesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.SYMBOLS_TYPE: {
				SymbolsType symbolsType = (SymbolsType)theEObject;
				T result = caseSymbolsType(symbolsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.SYMBOLS_TYPE1: {
				SymbolsType1 symbolsType1 = (SymbolsType1)theEObject;
				T result = caseSymbolsType1(symbolsType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.TARGET: {
				Target target = (Target)theEObject;
				T result = caseTarget(target);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.TESTS_NANT_CORE_ELEMENT_TEST1_TASK: {
				TestsNAntCoreElementTest1Task testsNAntCoreElementTest1Task = (TestsNAntCoreElementTest1Task)theEObject;
				T result = caseTestsNAntCoreElementTest1Task(testsNAntCoreElementTest1Task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.TESTS_NANT_CORE_TEST_TASK: {
				TestsNAntCoreTestTask testsNAntCoreTestTask = (TestsNAntCoreTestTask)theEObject;
				T result = caseTestsNAntCoreTestTask(testsNAntCoreTestTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.TESTS_NANT_CORE_UTIL_XML_LOGGER_TEST_TEST_TASK: {
				TestsNAntCoreUtilXmlLoggerTestTestTask testsNAntCoreUtilXmlLoggerTestTestTask = (TestsNAntCoreUtilXmlLoggerTestTestTask)theEObject;
				T result = caseTestsNAntCoreUtilXmlLoggerTestTestTask(testsNAntCoreUtilXmlLoggerTestTestTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.UNDEFINES_TYPE: {
				UndefinesType undefinesType = (UndefinesType)theEObject;
				T result = caseUndefinesType(undefinesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.UNDEFINES_TYPE1: {
				UndefinesType1 undefinesType1 = (UndefinesType1)theEObject;
				T result = caseUndefinesType1(undefinesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NantPackage.WEBMAP_TYPE: {
				WebmapType webmapType = (WebmapType)theEObject;
				T result = caseWebmapType(webmapType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attributes Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attributes Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributesType(AttributesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defines Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defines Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinesType(DefinesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defines Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defines Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinesType1(DefinesType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defines Type2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defines Type2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinesType2(DefinesType2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensionobjects Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensionobjects Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionobjectsType(ExtensionobjectsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ignorelibraries Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ignorelibraries Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIgnorelibrariesType(IgnorelibrariesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ignorelibraries Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ignorelibraries Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIgnorelibrariesType1(IgnorelibrariesType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespaces Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespaces Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespacesType(NamespacesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespaces Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespaces Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespacesType1(NamespacesType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Compression Tasks GUnzip</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Compression Tasks GUnzip</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCompressionTasksGUnzip(NAntCompressionTasksGUnzip object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Compression Tasks Tar Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Compression Tasks Tar Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCompressionTasksTarTask(NAntCompressionTasksTarTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Compression Tasks Un Zip Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Compression Tasks Un Zip Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCompressionTasksUnZipTask(NAntCompressionTasksUnZipTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Compression Tasks Zip Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Compression Tasks Zip Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCompressionTasksZipTask(NAntCompressionTasksZipTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Compression Types Tar File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Compression Types Tar File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCompressionTypesTarFileSet(NAntCompressionTypesTarFileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Compression Types Zip File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Compression Types Zip File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCompressionTypesZipFileSet(NAntCompressionTypesZipFileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Filters Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Filters Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreFiltersFilter(NAntCoreFiltersFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Filters Filter Chain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Filters Filter Chain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreFiltersFilterChain(NAntCoreFiltersFilterChain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Task Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Task Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTaskContainer(NAntCoreTaskContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Attrib Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Attrib Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksAttribTask(NAntCoreTasksAttribTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Available Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Available Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksAvailableTask(NAntCoreTasksAvailableTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Call Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Call Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksCallTask(NAntCoreTasksCallTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Copy Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Copy Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksCopyTask(NAntCoreTasksCopyTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Delete Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Delete Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksDeleteTask(NAntCoreTasksDeleteTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Description Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Description Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksDescriptionTask(NAntCoreTasksDescriptionTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Echo Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Echo Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksEchoTask(NAntCoreTasksEchoTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Exec Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Exec Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksExecTask(NAntCoreTasksExecTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Fail Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Fail Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksFailTask(NAntCoreTasksFailTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Get Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Get Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksGetTask(NAntCoreTasksGetTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks If Not Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks If Not Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksIfNotTask(NAntCoreTasksIfNotTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks If Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks If Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksIfTask(NAntCoreTasksIfTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Include Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Include Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksIncludeTask(NAntCoreTasksIncludeTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks In Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks In Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksInElement(NAntCoreTasksInElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Load File Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Load File Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksLoadFileTask(NAntCoreTasksLoadFileTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Load Tasks Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Load Tasks Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksLoadTasksTask(NAntCoreTasksLoadTasksTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Loop Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Loop Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksLoopTask(NAntCoreTasksLoopTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Mail Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Mail Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksMailTask(NAntCoreTasksMailTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Mk Dir Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Mk Dir Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksMkDirTask(NAntCoreTasksMkDirTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Move Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Move Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksMoveTask(NAntCoreTasksMoveTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks NAnt Schema Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks NAnt Schema Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksNAntSchemaTask(NAntCoreTasksNAntSchemaTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks NAnt Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks NAnt Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksNAntTask(NAntCoreTasksNAntTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Property Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Property Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksPropertyTask(NAntCoreTasksPropertyTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Regex Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Regex Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksRegexTask(NAntCoreTasksRegexTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Set Env Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Set Env Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksSetEnvTask(NAntCoreTasksSetEnvTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Sleep Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Sleep Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksSleepTask(NAntCoreTasksSleepTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Style Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Style Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksStyleTask(NAntCoreTasksStyleTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Sys Info Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Sys Info Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksSysInfoTask(NAntCoreTasksSysInfoTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Touch Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Touch Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksTouchTask(NAntCoreTasksTouchTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks TStamp Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks TStamp Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksTStampTask(NAntCoreTasksTStampTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Up To Date Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Up To Date Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksUpToDateTask(NAntCoreTasksUpToDateTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Xml Peek Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Xml Peek Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksXmlPeekTask(NAntCoreTasksXmlPeekTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Tasks Xml Poke Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Tasks Xml Poke Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTasksXmlPokeTask(NAntCoreTasksXmlPokeTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesArgument(NAntCoreTypesArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Credential</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Credential</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesCredential(NAntCoreTypesCredential object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Dir Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Dir Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesDirSet(NAntCoreTypesDirSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Environment Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Environment Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesEnvironmentSet(NAntCoreTypesEnvironmentSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Environment Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Environment Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesEnvironmentVariable(NAntCoreTypesEnvironmentVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesFileSet(NAntCoreTypesFileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Exclude</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Exclude</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesFileSetExclude(NAntCoreTypesFileSetExclude object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Excludes File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Excludes File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesFileSetExcludesFile(NAntCoreTypesFileSetExcludesFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Include</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Include</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesFileSetInclude(NAntCoreTypesFileSetInclude object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Includes File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types File Set Includes File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesFileSetIncludesFile(NAntCoreTypesFileSetIncludesFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Formatter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Formatter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesFormatter(NAntCoreTypesFormatter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesOption(NAntCoreTypesOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Path Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesPathElement(NAntCoreTypesPathElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Path Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Path Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesPathSet(NAntCoreTypesPathSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesPattern(NAntCoreTypesPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Pattern Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Pattern Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesPatternSet(NAntCoreTypesPatternSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Proxy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesProxy(NAntCoreTypesProxy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Raw Xml</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Raw Xml</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesRawXml(NAntCoreTypesRawXml object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Xml Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Xml Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesXmlNamespace(NAntCoreTypesXmlNamespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Xslt Extension Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Xslt Extension Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesXsltExtensionObject(NAntCoreTypesXsltExtensionObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Core Types Xslt Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Core Types Xslt Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntCoreTypesXsltParameter(NAntCoreTypesXsltParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Assembly Info Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Assembly Info Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksAssemblyInfoTask(NAntDotNetTasksAssemblyInfoTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Assembly Linker Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Assembly Linker Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksAssemblyLinkerTask(NAntDotNetTasksAssemblyLinkerTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Csc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Csc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksCscTask(NAntDotNetTasksCscTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Delay Sign Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Delay Sign Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksDelaySignTask(NAntDotNetTasksDelaySignTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Ilasm Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Ilasm Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksIlasmTask(NAntDotNetTasksIlasmTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Jsc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Jsc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksJscTask(NAntDotNetTasksJscTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks License Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks License Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksLicenseTask(NAntDotNetTasksLicenseTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks NDoc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks NDoc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksNDocTask(NAntDotNetTasksNDocTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Regsvcs Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Regsvcs Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksRegsvcsTask(NAntDotNetTasksRegsvcsTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Res Gen Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Res Gen Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksResGenTask(NAntDotNetTasksResGenTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Script Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Script Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksScriptTask(NAntDotNetTasksScriptTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Vbc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Vbc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksVbcTask(NAntDotNetTasksVbcTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Vjc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Tasks Vjc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTasksVjcTask(NAntDotNetTasksVjcTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Assembly Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Assembly Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesAssemblyAttribute(NAntDotNetTypesAssemblyAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Assembly File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Assembly File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesAssemblyFileSet(NAntDotNetTypesAssemblyFileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Compiler Warning</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Compiler Warning</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesCompilerWarning(NAntDotNetTypesCompilerWarning object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Lib Directory Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Lib Directory Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesLibDirectorySet(NAntDotNetTypesLibDirectorySet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesModule(NAntDotNetTypesModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Module Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Module Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesModuleSet(NAntDotNetTypesModuleSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Namespace Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Namespace Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesNamespaceImport(NAntDotNetTypesNamespaceImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Namespace Import Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Namespace Import Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesNamespaceImportCollection(NAntDotNetTypesNamespaceImportCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesPackage(NAntDotNetTypesPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Resource File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Resource File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesResourceFileSet(NAntDotNetTypesResourceFileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Warning As Error</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Dot Net Types Warning As Error</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntDotNetTypesWarningAsError(NAntDotNetTypesWarningAsError object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt MS Net Tasks Ildasm Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt MS Net Tasks Ildasm Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntMSNetTasksIldasmTask(NAntMSNetTasksIldasmTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt MS Net Tasks Service Controller Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt MS Net Tasks Service Controller Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntMSNetTasksServiceControllerTask(NAntMSNetTasksServiceControllerTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt NUnit1 Tasks NUnit Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt NUnit1 Tasks NUnit Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntNUnit1TasksNUnitTask(NAntNUnit1TasksNUnitTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt NUnit1 Types NUnit Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt NUnit1 Types NUnit Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntNUnit1TypesNUnitTest(NAntNUnit1TypesNUnitTest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt NUnit2 Tasks NUnit2 Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt NUnit2 Tasks NUnit2 Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntNUnit2TasksNUnit2Task(NAntNUnit2TasksNUnit2Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt NUnit2 Types Categories</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt NUnit2 Types Categories</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntNUnit2TypesCategories(NAntNUnit2TypesCategories object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt NUnit2 Types Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt NUnit2 Types Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntNUnit2TypesCategory(NAntNUnit2TypesCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt NUnit2 Types NUnit2 Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt NUnit2 Types NUnit2 Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntNUnit2TypesNUnit2Test(NAntNUnit2TypesNUnit2Test object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt NUnit Types Formatter Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt NUnit Types Formatter Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntNUnitTypesFormatterElement(NAntNUnitTypesFormatterElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Change Log Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Change Log Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksChangeLogTask(NAntSourceControlTasksChangeLogTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Checkout Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Checkout Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksCheckoutTask(NAntSourceControlTasksCheckoutTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Cvs Pass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Cvs Pass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksCvsPass(NAntSourceControlTasksCvsPass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Cvs Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Cvs Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksCvsTask(NAntSourceControlTasksCvsTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Export Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Export Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksExportTask(NAntSourceControlTasksExportTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks RTag Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks RTag Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksRTagTask(NAntSourceControlTasksRTagTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Tag Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Tag Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksTagTask(NAntSourceControlTasksTagTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Update Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Tasks Update Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTasksUpdateTask(NAntSourceControlTasksUpdateTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Source Control Types Cvs File Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Source Control Types Cvs File Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntSourceControlTypesCvsFileSet(NAntSourceControlTypesCvsFileSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Cl Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Cl Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTasksClTask(NAntVisualCppTasksClTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Lib Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Lib Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTasksLibTask(NAntVisualCppTasksLibTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Link Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Link Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTasksLinkTask(NAntVisualCppTasksLinkTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Mc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Mc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTasksMcTask(NAntVisualCppTasksMcTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Midl Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Midl Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTasksMidlTask(NAntVisualCppTasksMidlTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Rc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Tasks Rc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTasksRcTask(NAntVisualCppTasksRcTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Types Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTypesLibrary(NAntVisualCppTypesLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Types Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Visual Cpp Types Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVisualCppTypesSymbol(NAntVisualCppTypesSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt VS Net Tasks Solution Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt VS Net Tasks Solution Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVSNetTasksSolutionTask(NAntVSNetTasksSolutionTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt VS Net Types Web Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt VS Net Types Web Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntVSNetTypesWebMap(NAntVSNetTypesWebMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Ax Imp Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Ax Imp Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntWin32TasksAxImpTask(NAntWin32TasksAxImpTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Read Registry Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Read Registry Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntWin32TasksReadRegistryTask(NAntWin32TasksReadRegistryTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Reg Asm Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Reg Asm Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntWin32TasksRegAsmTask(NAntWin32TasksRegAsmTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Tlb Exp Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Tlb Exp Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntWin32TasksTlbExpTask(NAntWin32TasksTlbExpTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Tlb Imp Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAnt Win32 Tasks Tlb Imp Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAntWin32TasksTlbImpTask(NAntWin32TasksTlbImpTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nowarn Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nowarn Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNowarnType(NowarnType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nowarn Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nowarn Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNowarnType1(NowarnType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nowarn Type2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nowarn Type2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNowarnType2(NowarnType2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Options Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Options Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptionsType(OptionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameters Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameters Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParametersType(ParametersType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pkg References Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pkg References Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePkgReferencesType(PkgReferencesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pkg References Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pkg References Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePkgReferencesType1(PkgReferencesType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pkg References Type2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pkg References Type2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePkgReferencesType2(PkgReferencesType2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectType(ProjectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesType(PropertiesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbols Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbols Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolsType(SymbolsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbols Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbols Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolsType1(SymbolsType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTarget(Target object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tests NAnt Core Element Test1 Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tests NAnt Core Element Test1 Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestsNAntCoreElementTest1Task(TestsNAntCoreElementTest1Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tests NAnt Core Test Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tests NAnt Core Test Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestsNAntCoreTestTask(TestsNAntCoreTestTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tests NAnt Core Util Xml Logger Test Test Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tests NAnt Core Util Xml Logger Test Test Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestsNAntCoreUtilXmlLoggerTestTestTask(TestsNAntCoreUtilXmlLoggerTestTestTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Undefines Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Undefines Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUndefinesType(UndefinesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Undefines Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Undefines Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUndefinesType1(UndefinesType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Webmap Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Webmap Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWebmapType(WebmapType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //NantSwitch
