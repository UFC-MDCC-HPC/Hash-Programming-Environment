/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment.impl;

import hPE.frontend.backend.environment.DeployedComponentInfoType;
import hPE.frontend.backend.environment.DeployedParameterType;
import hPE.frontend.backend.environment.DocumentRoot;
import hPE.frontend.backend.environment.EnvironmentFactory;
import hPE.frontend.backend.environment.EnvironmentPackage;
import hPE.frontend.backend.environment.EnvironmentType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentPackageImpl extends EPackageImpl implements EnvironmentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deployedComponentInfoTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deployedParameterTypeEClass = null;

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
	private EClass environmentTypeEClass = null;

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
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnvironmentPackageImpl() {
		super(eNS_URI, EnvironmentFactory.eINSTANCE);
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
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnvironmentPackage init() {
		if (isInited) return (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Obtain or create and register package
		EnvironmentPackageImpl theEnvironmentPackage = (EnvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EnvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EnvironmentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEnvironmentPackage.createPackageContents();

		// Initialize created meta-data
		theEnvironmentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnvironmentPackage.freeze();

		return theEnvironmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployedComponentInfoType() {
		return deployedComponentInfoTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_Package() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_Enumerator() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployedComponentInfoType_Parameter() {
		return (EReference)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_Abstract() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_Cid() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_CidBase() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_Kind() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_LocationURI() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedComponentInfoType_Name() {
		return (EAttribute)deployedComponentInfoTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployedParameterType() {
		return deployedParameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedParameterType_Actual() {
		return (EAttribute)deployedParameterTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedParameterType_Bound() {
		return (EAttribute)deployedParameterTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployedParameterType_Parameter() {
		return (EReference)deployedParameterTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployedParameterType_ParameterId() {
		return (EAttribute)deployedParameterTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Environment() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnvironmentType() {
		return environmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironmentType_Deployed() {
		return (EReference)environmentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentFactory getEnvironmentFactory() {
		return (EnvironmentFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		deployedComponentInfoTypeEClass = createEClass(DEPLOYED_COMPONENT_INFO_TYPE);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR);
		createEReference(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__CID);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__CID_BASE);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__KIND);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI);
		createEAttribute(deployedComponentInfoTypeEClass, DEPLOYED_COMPONENT_INFO_TYPE__NAME);

		deployedParameterTypeEClass = createEClass(DEPLOYED_PARAMETER_TYPE);
		createEAttribute(deployedParameterTypeEClass, DEPLOYED_PARAMETER_TYPE__ACTUAL);
		createEAttribute(deployedParameterTypeEClass, DEPLOYED_PARAMETER_TYPE__BOUND);
		createEReference(deployedParameterTypeEClass, DEPLOYED_PARAMETER_TYPE__PARAMETER);
		createEAttribute(deployedParameterTypeEClass, DEPLOYED_PARAMETER_TYPE__PARAMETER_ID);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ENVIRONMENT);

		environmentTypeEClass = createEClass(ENVIRONMENT_TYPE);
		createEReference(environmentTypeEClass, ENVIRONMENT_TYPE__DEPLOYED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(deployedComponentInfoTypeEClass, DeployedComponentInfoType.class, "DeployedComponentInfoType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeployedComponentInfoType_Package(), theXMLTypePackage.getString(), "package", null, 0, -1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedComponentInfoType_Enumerator(), theXMLTypePackage.getString(), "enumerator", null, 0, -1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeployedComponentInfoType_Parameter(), this.getDeployedParameterType(), null, "parameter", null, 0, -1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedComponentInfoType_Abstract(), theXMLTypePackage.getBoolean(), "abstract", null, 0, 1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedComponentInfoType_Cid(), theXMLTypePackage.getInt(), "cid", null, 0, 1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedComponentInfoType_CidBase(), theXMLTypePackage.getInt(), "cidBase", null, 0, 1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedComponentInfoType_Kind(), theXMLTypePackage.getString(), "kind", null, 0, 1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedComponentInfoType_LocationURI(), theXMLTypePackage.getAnyURI(), "locationURI", null, 0, 1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedComponentInfoType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, DeployedComponentInfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deployedParameterTypeEClass, DeployedParameterType.class, "DeployedParameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeployedParameterType_Actual(), theXMLTypePackage.getInt(), "actual", null, 0, 1, DeployedParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedParameterType_Bound(), theXMLTypePackage.getInt(), "bound", null, 1, 1, DeployedParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeployedParameterType_Parameter(), this.getDeployedParameterType(), null, "parameter", null, 0, -1, DeployedParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeployedParameterType_ParameterId(), theXMLTypePackage.getString(), "parameterId", null, 0, 1, DeployedParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Environment(), this.getEnvironmentType(), null, "environment", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(environmentTypeEClass, EnvironmentType.class, "EnvironmentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnvironmentType_Deployed(), this.getDeployedComponentInfoType(), null, "deployed", null, 0, -1, EnvironmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (deployedComponentInfoTypeEClass, 
		   source, 
		   new String[] {
			 "name", "DeployedComponentInfoType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_Package(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_Enumerator(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "enumerator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "abstract"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_Cid(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cid"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_CidBase(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cidBase"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_Kind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "kind"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_LocationURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "locationURI"
		   });		
		addAnnotation
		  (getDeployedComponentInfoType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (deployedParameterTypeEClass, 
		   source, 
		   new String[] {
			 "name", "DeployedParameterType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDeployedParameterType_Actual(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "actual",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeployedParameterType_Bound(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "bound",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeployedParameterType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeployedParameterType_ParameterId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parameter_id"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Environment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "environment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (environmentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnvironmentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEnvironmentType_Deployed(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "deployed",
			 "namespace", "##targetNamespace"
		   });
	}

} //EnvironmentPackageImpl
