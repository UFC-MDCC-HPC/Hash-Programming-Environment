/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hPE.frontend.backend.environment.EnvironmentFactory
 * @model kind="package"
 * @generated
 */
public interface EnvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "environment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/BackEndEnvironment";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "environment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentPackage eINSTANCE = hPE.frontend.backend.environment.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl <em>Deployed Component Info Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl
	 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getDeployedComponentInfoType()
	 * @generated
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Enumerator</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR = 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT = 3;

	/**
	 * The feature id for the '<em><b>Cid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__CID = 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__KIND = 5;

	/**
	 * The feature id for the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE__NAME = 7;

	/**
	 * The number of structural features of the '<em>Deployed Component Info Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_COMPONENT_INFO_TYPE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl <em>Deployed Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl
	 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getDeployedParameterType()
	 * @generated
	 */
	int DEPLOYED_PARAMETER_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_PARAMETER_TYPE__ACTUAL = 0;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_PARAMETER_TYPE__BOUND = 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_PARAMETER_TYPE__PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Parameter Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_PARAMETER_TYPE__PARAMETER_ID = 3;

	/**
	 * The number of structural features of the '<em>Deployed Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYED_PARAMETER_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hPE.frontend.backend.environment.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.backend.environment.impl.DocumentRootImpl
	 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ENVIRONMENT = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hPE.frontend.backend.environment.impl.EnvironmentTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.backend.environment.impl.EnvironmentTypeImpl
	 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getEnvironmentType()
	 * @generated
	 */
	int ENVIRONMENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Deployed</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_TYPE__DEPLOYED = 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_TYPE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link hPE.frontend.backend.environment.DeployedComponentInfoType <em>Deployed Component Info Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployed Component Info Type</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType
	 * @generated
	 */
	EClass getDeployedComponentInfoType();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Package</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#getPackage()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EAttribute getDeployedComponentInfoType_Package();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getEnumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enumerator</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#getEnumerator()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EAttribute getDeployedComponentInfoType_Enumerator();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#getParameter()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EReference getDeployedComponentInfoType_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#isAbstract()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EAttribute getDeployedComponentInfoType_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCid <em>Cid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cid</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#getCid()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EAttribute getDeployedComponentInfoType_Cid();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#getKind()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EAttribute getDeployedComponentInfoType_Kind();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getLocationURI <em>Location URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location URI</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#getLocationURI()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EAttribute getDeployedComponentInfoType_LocationURI();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hPE.frontend.backend.environment.DeployedComponentInfoType#getName()
	 * @see #getDeployedComponentInfoType()
	 * @generated
	 */
	EAttribute getDeployedComponentInfoType_Name();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.backend.environment.DeployedParameterType <em>Deployed Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployed Parameter Type</em>'.
	 * @see hPE.frontend.backend.environment.DeployedParameterType
	 * @generated
	 */
	EClass getDeployedParameterType();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedParameterType#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual</em>'.
	 * @see hPE.frontend.backend.environment.DeployedParameterType#getActual()
	 * @see #getDeployedParameterType()
	 * @generated
	 */
	EAttribute getDeployedParameterType_Actual();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedParameterType#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound</em>'.
	 * @see hPE.frontend.backend.environment.DeployedParameterType#getBound()
	 * @see #getDeployedParameterType()
	 * @generated
	 */
	EAttribute getDeployedParameterType_Bound();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.backend.environment.DeployedParameterType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hPE.frontend.backend.environment.DeployedParameterType#getParameter()
	 * @see #getDeployedParameterType()
	 * @generated
	 */
	EReference getDeployedParameterType_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.backend.environment.DeployedParameterType#getParameterId <em>Parameter Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Id</em>'.
	 * @see hPE.frontend.backend.environment.DeployedParameterType#getParameterId()
	 * @see #getDeployedParameterType()
	 * @generated
	 */
	EAttribute getDeployedParameterType_ParameterId();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.backend.environment.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see hPE.frontend.backend.environment.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.backend.environment.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see hPE.frontend.backend.environment.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link hPE.frontend.backend.environment.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see hPE.frontend.backend.environment.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link hPE.frontend.backend.environment.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see hPE.frontend.backend.environment.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.backend.environment.DocumentRoot#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Environment</em>'.
	 * @see hPE.frontend.backend.environment.DocumentRoot#getEnvironment()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Environment();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.backend.environment.EnvironmentType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see hPE.frontend.backend.environment.EnvironmentType
	 * @generated
	 */
	EClass getEnvironmentType();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.backend.environment.EnvironmentType#getDeployed <em>Deployed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deployed</em>'.
	 * @see hPE.frontend.backend.environment.EnvironmentType#getDeployed()
	 * @see #getEnvironmentType()
	 * @generated
	 */
	EReference getEnvironmentType_Deployed();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnvironmentFactory getEnvironmentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl <em>Deployed Component Info Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl
		 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getDeployedComponentInfoType()
		 * @generated
		 */
		EClass DEPLOYED_COMPONENT_INFO_TYPE = eINSTANCE.getDeployedComponentInfoType();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE = eINSTANCE.getDeployedComponentInfoType_Package();

		/**
		 * The meta object literal for the '<em><b>Enumerator</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR = eINSTANCE.getDeployedComponentInfoType_Enumerator();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER = eINSTANCE.getDeployedComponentInfoType_Parameter();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT = eINSTANCE.getDeployedComponentInfoType_Abstract();

		/**
		 * The meta object literal for the '<em><b>Cid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_COMPONENT_INFO_TYPE__CID = eINSTANCE.getDeployedComponentInfoType_Cid();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_COMPONENT_INFO_TYPE__KIND = eINSTANCE.getDeployedComponentInfoType_Kind();

		/**
		 * The meta object literal for the '<em><b>Location URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI = eINSTANCE.getDeployedComponentInfoType_LocationURI();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_COMPONENT_INFO_TYPE__NAME = eINSTANCE.getDeployedComponentInfoType_Name();

		/**
		 * The meta object literal for the '{@link hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl <em>Deployed Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.backend.environment.impl.DeployedParameterTypeImpl
		 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getDeployedParameterType()
		 * @generated
		 */
		EClass DEPLOYED_PARAMETER_TYPE = eINSTANCE.getDeployedParameterType();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_PARAMETER_TYPE__ACTUAL = eINSTANCE.getDeployedParameterType_Actual();

		/**
		 * The meta object literal for the '<em><b>Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_PARAMETER_TYPE__BOUND = eINSTANCE.getDeployedParameterType_Bound();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYED_PARAMETER_TYPE__PARAMETER = eINSTANCE.getDeployedParameterType_Parameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYED_PARAMETER_TYPE__PARAMETER_ID = eINSTANCE.getDeployedParameterType_ParameterId();

		/**
		 * The meta object literal for the '{@link hPE.frontend.backend.environment.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.backend.environment.impl.DocumentRootImpl
		 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ENVIRONMENT = eINSTANCE.getDocumentRoot_Environment();

		/**
		 * The meta object literal for the '{@link hPE.frontend.backend.environment.impl.EnvironmentTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.backend.environment.impl.EnvironmentTypeImpl
		 * @see hPE.frontend.backend.environment.impl.EnvironmentPackageImpl#getEnvironmentType()
		 * @generated
		 */
		EClass ENVIRONMENT_TYPE = eINSTANCE.getEnvironmentType();

		/**
		 * The meta object literal for the '<em><b>Deployed</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT_TYPE__DEPLOYED = eINSTANCE.getEnvironmentType_Deployed();

	}

} //EnvironmentPackage
