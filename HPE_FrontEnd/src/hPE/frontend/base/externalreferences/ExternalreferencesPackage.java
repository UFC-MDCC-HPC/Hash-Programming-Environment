/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.base.externalreferences;

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
 * @see hPE.frontend.base.externalreferences.ExternalreferencesFactory
 * @model kind="package"
 * @generated
 */
public interface ExternalreferencesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "externalreferences";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/externalreferences";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "externalreferences";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExternalreferencesPackage eINSTANCE = hPE.frontend.base.externalreferences.impl.ExternalreferencesPackageImpl.init();

	/**
	 * The meta object id for the '{@link hPE.frontend.base.externalreferences.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.base.externalreferences.impl.DocumentRootImpl
	 * @see hPE.frontend.base.externalreferences.impl.ExternalreferencesPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

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
	 * The feature id for the '<em><b>External</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EXTERNAL = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hPE.frontend.base.externalreferences.impl.ReferenceListTypeImpl <em>Reference List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.base.externalreferences.impl.ReferenceListTypeImpl
	 * @see hPE.frontend.base.externalreferences.impl.ExternalreferencesPackageImpl#getReferenceListType()
	 * @generated
	 */
	int REFERENCE_LIST_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LIST_TYPE__REFERENCE = 0;

	/**
	 * The number of structural features of the '<em>Reference List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_LIST_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl
	 * @see hPE.frontend.base.externalreferences.impl.ExternalreferencesPackageImpl#getReferenceType()
	 * @generated
	 */
	int REFERENCE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__ALIAS = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Destailed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DESTAILED_NAME = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__PATH = 3;

	/**
	 * The number of structural features of the '<em>Reference Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link hPE.frontend.base.externalreferences.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see hPE.frontend.base.externalreferences.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.base.externalreferences.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see hPE.frontend.base.externalreferences.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link hPE.frontend.base.externalreferences.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see hPE.frontend.base.externalreferences.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link hPE.frontend.base.externalreferences.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see hPE.frontend.base.externalreferences.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.base.externalreferences.DocumentRoot#getExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>External</em>'.
	 * @see hPE.frontend.base.externalreferences.DocumentRoot#getExternal()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_External();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.base.externalreferences.ReferenceListType <em>Reference List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference List Type</em>'.
	 * @see hPE.frontend.base.externalreferences.ReferenceListType
	 * @generated
	 */
	EClass getReferenceListType();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.base.externalreferences.ReferenceListType#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference</em>'.
	 * @see hPE.frontend.base.externalreferences.ReferenceListType#getReference()
	 * @see #getReferenceListType()
	 * @generated
	 */
	EReference getReferenceListType_Reference();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.base.externalreferences.ReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Type</em>'.
	 * @see hPE.frontend.base.externalreferences.ReferenceType
	 * @generated
	 */
	EClass getReferenceType();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.base.externalreferences.ReferenceType#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Alias</em>'.
	 * @see hPE.frontend.base.externalreferences.ReferenceType#getAlias()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_Alias();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.base.externalreferences.ReferenceType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see hPE.frontend.base.externalreferences.ReferenceType#getDescription()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_Description();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.base.externalreferences.ReferenceType#getDestailedName <em>Destailed Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destailed Name</em>'.
	 * @see hPE.frontend.base.externalreferences.ReferenceType#getDestailedName()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_DestailedName();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.base.externalreferences.ReferenceType#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see hPE.frontend.base.externalreferences.ReferenceType#getPath()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_Path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExternalreferencesFactory getExternalreferencesFactory();

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
		 * The meta object literal for the '{@link hPE.frontend.base.externalreferences.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.base.externalreferences.impl.DocumentRootImpl
		 * @see hPE.frontend.base.externalreferences.impl.ExternalreferencesPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>External</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EXTERNAL = eINSTANCE.getDocumentRoot_External();

		/**
		 * The meta object literal for the '{@link hPE.frontend.base.externalreferences.impl.ReferenceListTypeImpl <em>Reference List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.base.externalreferences.impl.ReferenceListTypeImpl
		 * @see hPE.frontend.base.externalreferences.impl.ExternalreferencesPackageImpl#getReferenceListType()
		 * @generated
		 */
		EClass REFERENCE_LIST_TYPE = eINSTANCE.getReferenceListType();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_LIST_TYPE__REFERENCE = eINSTANCE.getReferenceListType_Reference();

		/**
		 * The meta object literal for the '{@link hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl
		 * @see hPE.frontend.base.externalreferences.impl.ExternalreferencesPackageImpl#getReferenceType()
		 * @generated
		 */
		EClass REFERENCE_TYPE = eINSTANCE.getReferenceType();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_TYPE__ALIAS = eINSTANCE.getReferenceType_Alias();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_TYPE__DESCRIPTION = eINSTANCE.getReferenceType_Description();

		/**
		 * The meta object literal for the '<em><b>Destailed Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_TYPE__DESTAILED_NAME = eINSTANCE.getReferenceType_DestailedName();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_TYPE__PATH = eINSTANCE.getReferenceType_Path();

	}

} //ExternalreferencesPackage
