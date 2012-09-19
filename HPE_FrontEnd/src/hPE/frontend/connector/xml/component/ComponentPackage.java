/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see hPE.frontend.connector.xml.component.ComponentFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "component";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/HashComponent";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "component";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentPackage eINSTANCE = hPE.frontend.connector.xml.component.impl.ComponentPackageImpl.init();

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.ConditionTypeImpl <em>Condition Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.ConditionTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getConditionType()
	 * @generated
	 */
	int CONDITION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Cond Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__COND_ID = 0;

	/**
	 * The feature id for the '<em><b>Slice Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE__SLICE_ID = 1;

	/**
	 * The number of structural features of the '<em>Condition Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.DocumentRootImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

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
	 * The feature id for the '<em><b>Hash Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HASH_COMPONENT = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.GuardTypeImpl <em>Guard Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.GuardTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getGuardType()
	 * @generated
	 */
	int GUARD_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TYPE__CONDITION = 1;

	/**
	 * The feature id for the '<em><b>And</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TYPE__AND = 2;

	/**
	 * The feature id for the '<em><b>Or</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TYPE__OR = 3;

	/**
	 * The feature id for the '<em><b>Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TYPE__NOT = 4;

	/**
	 * The number of structural features of the '<em>Guard Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl <em>Hash Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHashComponentType()
	 * @generated
	 */
	int HASH_COMPONENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Using</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__USING = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__KIND = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Inner Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__INNER_COMPONENT = 5;

	/**
	 * The feature id for the '<em><b>Super Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__SUPER_COMPONENT = 6;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE__UNIT = 7;

	/**
	 * The number of structural features of the '<em>Hash Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HASH_COMPONENT_TYPE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HpeactionImpl <em>Hpeaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HpeactionImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeaction()
	 * @generated
	 */
	int HPEACTION = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEACTION__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEACTION__PROTOCOL = 1;

	/**
	 * The number of structural features of the '<em>Hpeaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HpeconditionImpl <em>Hpecondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HpeconditionImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpecondition()
	 * @generated
	 */
	int HPECONDITION = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPECONDITION__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPECONDITION__GUARD = 1;

	/**
	 * The number of structural features of the '<em>Hpecondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPECONDITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HpeinnerComponentImpl <em>Hpeinner Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HpeinnerComponentImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeinnerComponent()
	 * @generated
	 */
	int HPEINNER_COMPONENT = 6;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEINNER_COMPONENT__KIND = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEINNER_COMPONENT__IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEINNER_COMPONENT__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEINNER_COMPONENT__ACCESS = 3;

	/**
	 * The feature id for the '<em><b>Export Actions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEINNER_COMPONENT__EXPORT_ACTIONS = 4;

	/**
	 * The number of structural features of the '<em>Hpeinner Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEINNER_COMPONENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HpeparameterImpl <em>Hpeparameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HpeparameterImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeparameter()
	 * @generated
	 */
	int HPEPARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEPARAMETER__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEPARAMETER__VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEPARAMETER__CONSTRAINT = 2;

	/**
	 * The number of structural features of the '<em>Hpeparameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEPARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HpeparameterTypeImpl <em>Hpeparameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HpeparameterTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeparameterType()
	 * @generated
	 */
	int HPEPARAMETER_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Component Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEPARAMETER_TYPE__PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Hpeparameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPEPARAMETER_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HpesliceTypeImpl <em>Hpeslice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HpesliceTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpesliceType()
	 * @generated
	 */
	int HPESLICE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPESLICE_TYPE__INDEX = 0;

	/**
	 * The feature id for the '<em><b>Inner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPESLICE_TYPE__INNER = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPESLICE_TYPE__UNIT = 2;

	/**
	 * The number of structural features of the '<em>Hpeslice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPESLICE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.HpetypeImpl <em>Hpetype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.HpetypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpetype()
	 * @generated
	 */
	int HPETYPE = 10;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPETYPE__COMPONENT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Public Inner Component</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPETYPE__PUBLIC_INNER_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPETYPE__PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPETYPE__PACKAGE = 3;

	/**
	 * The number of structural features of the '<em>Hpetype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HPETYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolChoiceTypeImpl <em>Protocol Choice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.ProtocolChoiceTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolChoiceType()
	 * @generated
	 */
	int PROTOCOL_CHOICE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Par</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_CHOICE_TYPE__PAR = 0;

	/**
	 * The feature id for the '<em><b>Seq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_CHOICE_TYPE__SEQ = 1;

	/**
	 * The feature id for the '<em><b>Alt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_CHOICE_TYPE__ALT = 2;

	/**
	 * The feature id for the '<em><b>Perform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_CHOICE_TYPE__PERFORM = 3;

	/**
	 * The number of structural features of the '<em>Protocol Choice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_CHOICE_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolTypeImpl <em>Protocol Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.ProtocolTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolType()
	 * @generated
	 */
	int PROTOCOL_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_TYPE__GUARD = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_TYPE__ID = 1;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_TYPE__REPEAT = 2;

	/**
	 * The number of structural features of the '<em>Protocol Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolCombinatorTypeImpl <em>Protocol Combinator Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.ProtocolCombinatorTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolCombinatorType()
	 * @generated
	 */
	int PROTOCOL_COMBINATOR_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_COMBINATOR_TYPE__GUARD = PROTOCOL_TYPE__GUARD;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_COMBINATOR_TYPE__ID = PROTOCOL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_COMBINATOR_TYPE__REPEAT = PROTOCOL_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_COMBINATOR_TYPE__ACTION = PROTOCOL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Protocol Combinator Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_COMBINATOR_TYPE_FEATURE_COUNT = PROTOCOL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolPerformTypeImpl <em>Protocol Perform Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.ProtocolPerformTypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolPerformType()
	 * @generated
	 */
	int PROTOCOL_PERFORM_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_PERFORM_TYPE__GUARD = PROTOCOL_TYPE__GUARD;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_PERFORM_TYPE__ID = PROTOCOL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_PERFORM_TYPE__REPEAT = PROTOCOL_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_PERFORM_TYPE__ACTION_ID = PROTOCOL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slice Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_PERFORM_TYPE__SLICE_ID = PROTOCOL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Protocol Perform Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_PERFORM_TYPE_FEATURE_COUNT = PROTOCOL_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl <em>Unittype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.impl.UnittypeImpl
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getUnittype()
	 * @generated
	 */
	int UNITTYPE = 15;

	/**
	 * The feature id for the '<em><b>Slice</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNITTYPE__SLICE = 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNITTYPE__ACTION = 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNITTYPE__CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNITTYPE__INDEX = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNITTYPE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNITTYPE__PARALLEL = 5;

	/**
	 * The number of structural features of the '<em>Unittype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNITTYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.AccessType <em>Access Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.AccessType
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getAccessType()
	 * @generated
	 */
	int ACCESS_TYPE = 16;

	/**
	 * The meta object id for the '{@link hPE.frontend.connector.xml.component.Hpekind <em>Hpekind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.Hpekind
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpekind()
	 * @generated
	 */
	int HPEKIND = 17;

	/**
	 * The meta object id for the '<em>Access Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.AccessType
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getAccessTypeObject()
	 * @generated
	 */
	int ACCESS_TYPE_OBJECT = 18;

	/**
	 * The meta object id for the '<em>Hpekind Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hPE.frontend.connector.xml.component.Hpekind
	 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpekindObject()
	 * @generated
	 */
	int HPEKIND_OBJECT = 19;


	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.ConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Type</em>'.
	 * @see hPE.frontend.connector.xml.component.ConditionType
	 * @generated
	 */
	EClass getConditionType();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.ConditionType#getCondId <em>Cond Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cond Id</em>'.
	 * @see hPE.frontend.connector.xml.component.ConditionType#getCondId()
	 * @see #getConditionType()
	 * @generated
	 */
	EAttribute getConditionType_CondId();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.ConditionType#getSliceId <em>Slice Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice Id</em>'.
	 * @see hPE.frontend.connector.xml.component.ConditionType#getSliceId()
	 * @see #getConditionType()
	 * @generated
	 */
	EAttribute getConditionType_SliceId();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see hPE.frontend.connector.xml.component.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.connector.xml.component.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see hPE.frontend.connector.xml.component.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link hPE.frontend.connector.xml.component.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see hPE.frontend.connector.xml.component.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link hPE.frontend.connector.xml.component.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see hPE.frontend.connector.xml.component.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.DocumentRoot#getHashComponent <em>Hash Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hash Component</em>'.
	 * @see hPE.frontend.connector.xml.component.DocumentRoot#getHashComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_HashComponent();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.GuardType <em>Guard Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Type</em>'.
	 * @see hPE.frontend.connector.xml.component.GuardType
	 * @generated
	 */
	EClass getGuardType();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.connector.xml.component.GuardType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see hPE.frontend.connector.xml.component.GuardType#getGroup()
	 * @see #getGuardType()
	 * @generated
	 */
	EAttribute getGuardType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.GuardType#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition</em>'.
	 * @see hPE.frontend.connector.xml.component.GuardType#getCondition()
	 * @see #getGuardType()
	 * @generated
	 */
	EReference getGuardType_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.GuardType#getAnd <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>And</em>'.
	 * @see hPE.frontend.connector.xml.component.GuardType#getAnd()
	 * @see #getGuardType()
	 * @generated
	 */
	EReference getGuardType_And();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.GuardType#getOr <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Or</em>'.
	 * @see hPE.frontend.connector.xml.component.GuardType#getOr()
	 * @see #getGuardType()
	 * @generated
	 */
	EReference getGuardType_Or();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.GuardType#isNot <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not</em>'.
	 * @see hPE.frontend.connector.xml.component.GuardType#isNot()
	 * @see #getGuardType()
	 * @generated
	 */
	EAttribute getGuardType_Not();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.HashComponentType <em>Hash Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hash Component Type</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType
	 * @generated
	 */
	EClass getHashComponentType();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HashComponentType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getPackage()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EAttribute getHashComponentType_Package();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.connector.xml.component.HashComponentType#getUsing <em>Using</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Using</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getUsing()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EAttribute getHashComponentType_Using();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HashComponentType#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getKind()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EAttribute getHashComponentType_Kind();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HashComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getName()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EAttribute getHashComponentType_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.HashComponentType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getParameter()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EReference getHashComponentType_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.HashComponentType#getInnerComponent <em>Inner Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner Component</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getInnerComponent()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EReference getHashComponentType_InnerComponent();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.HashComponentType#getSuperComponent <em>Super Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super Component</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getSuperComponent()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EReference getHashComponentType_SuperComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.HashComponentType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit</em>'.
	 * @see hPE.frontend.connector.xml.component.HashComponentType#getUnit()
	 * @see #getHashComponentType()
	 * @generated
	 */
	EReference getHashComponentType_Unit();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.Hpeaction <em>Hpeaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hpeaction</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpeaction
	 * @generated
	 */
	EClass getHpeaction();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Hpeaction#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpeaction#getIdentifier()
	 * @see #getHpeaction()
	 * @generated
	 */
	EAttribute getHpeaction_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.Hpeaction#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Protocol</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpeaction#getProtocol()
	 * @see #getHpeaction()
	 * @generated
	 */
	EReference getHpeaction_Protocol();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.Hpecondition <em>Hpecondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hpecondition</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpecondition
	 * @generated
	 */
	EClass getHpecondition();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Hpecondition#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpecondition#getIdentifier()
	 * @see #getHpecondition()
	 * @generated
	 */
	EAttribute getHpecondition_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.Hpecondition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpecondition#getGuard()
	 * @see #getHpecondition()
	 * @generated
	 */
	EReference getHpecondition_Guard();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.HpeinnerComponent <em>Hpeinner Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hpeinner Component</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeinnerComponent
	 * @generated
	 */
	EClass getHpeinnerComponent();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeinnerComponent#getKind()
	 * @see #getHpeinnerComponent()
	 * @generated
	 */
	EAttribute getHpeinnerComponent_Kind();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeinnerComponent#getIdentifier()
	 * @see #getHpeinnerComponent()
	 * @generated
	 */
	EAttribute getHpeinnerComponent_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeinnerComponent#getType()
	 * @see #getHpeinnerComponent()
	 * @generated
	 */
	EReference getHpeinnerComponent_Type();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeinnerComponent#getAccess()
	 * @see #getHpeinnerComponent()
	 * @generated
	 */
	EAttribute getHpeinnerComponent_Access();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#isExportActions <em>Export Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Actions</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeinnerComponent#isExportActions()
	 * @see #getHpeinnerComponent()
	 * @generated
	 */
	EAttribute getHpeinnerComponent_ExportActions();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.Hpeparameter <em>Hpeparameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hpeparameter</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpeparameter
	 * @generated
	 */
	EClass getHpeparameter();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Hpeparameter#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpeparameter#getIdentifier()
	 * @see #getHpeparameter()
	 * @generated
	 */
	EAttribute getHpeparameter_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Hpeparameter#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpeparameter#getVariable()
	 * @see #getHpeparameter()
	 * @generated
	 */
	EAttribute getHpeparameter_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.Hpeparameter#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpeparameter#getConstraint()
	 * @see #getHpeparameter()
	 * @generated
	 */
	EReference getHpeparameter_Constraint();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.HpeparameterType <em>Hpeparameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hpeparameter Type</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeparameterType
	 * @generated
	 */
	EClass getHpeparameterType();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpeparameterType#getComponentConstraint <em>Component Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Constraint</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeparameterType#getComponentConstraint()
	 * @see #getHpeparameterType()
	 * @generated
	 */
	EAttribute getHpeparameterType_ComponentConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.HpeparameterType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hPE.frontend.connector.xml.component.HpeparameterType#getParameter()
	 * @see #getHpeparameterType()
	 * @generated
	 */
	EReference getHpeparameterType_Parameter();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.HpesliceType <em>Hpeslice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hpeslice Type</em>'.
	 * @see hPE.frontend.connector.xml.component.HpesliceType
	 * @generated
	 */
	EClass getHpesliceType();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpesliceType#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see hPE.frontend.connector.xml.component.HpesliceType#getIndex()
	 * @see #getHpesliceType()
	 * @generated
	 */
	EAttribute getHpesliceType_Index();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpesliceType#getInner <em>Inner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inner</em>'.
	 * @see hPE.frontend.connector.xml.component.HpesliceType#getInner()
	 * @see #getHpesliceType()
	 * @generated
	 */
	EAttribute getHpesliceType_Inner();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.HpesliceType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see hPE.frontend.connector.xml.component.HpesliceType#getUnit()
	 * @see #getHpesliceType()
	 * @generated
	 */
	EAttribute getHpesliceType_Unit();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.Hpetype <em>Hpetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hpetype</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpetype
	 * @generated
	 */
	EClass getHpetype();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Hpetype#getComponentName <em>Component Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Name</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpetype#getComponentName()
	 * @see #getHpetype()
	 * @generated
	 */
	EAttribute getHpetype_ComponentName();

	/**
	 * Returns the meta object for the attribute list '{@link hPE.frontend.connector.xml.component.Hpetype#getPublicInnerComponent <em>Public Inner Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Public Inner Component</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpetype#getPublicInnerComponent()
	 * @see #getHpetype()
	 * @generated
	 */
	EAttribute getHpetype_PublicInnerComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.Hpetype#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpetype#getParameter()
	 * @see #getHpetype()
	 * @generated
	 */
	EReference getHpetype_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Hpetype#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpetype#getPackage()
	 * @see #getHpetype()
	 * @generated
	 */
	EAttribute getHpetype_Package();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.ProtocolChoiceType <em>Protocol Choice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol Choice Type</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolChoiceType
	 * @generated
	 */
	EClass getProtocolChoiceType();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.ProtocolChoiceType#getPar <em>Par</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Par</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolChoiceType#getPar()
	 * @see #getProtocolChoiceType()
	 * @generated
	 */
	EReference getProtocolChoiceType_Par();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.ProtocolChoiceType#getSeq <em>Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Seq</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolChoiceType#getSeq()
	 * @see #getProtocolChoiceType()
	 * @generated
	 */
	EReference getProtocolChoiceType_Seq();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.ProtocolChoiceType#getAlt <em>Alt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alt</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolChoiceType#getAlt()
	 * @see #getProtocolChoiceType()
	 * @generated
	 */
	EReference getProtocolChoiceType_Alt();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.ProtocolChoiceType#getPerform <em>Perform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Perform</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolChoiceType#getPerform()
	 * @see #getProtocolChoiceType()
	 * @generated
	 */
	EReference getProtocolChoiceType_Perform();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.ProtocolCombinatorType <em>Protocol Combinator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol Combinator Type</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolCombinatorType
	 * @generated
	 */
	EClass getProtocolCombinatorType();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.ProtocolCombinatorType#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolCombinatorType#getAction()
	 * @see #getProtocolCombinatorType()
	 * @generated
	 */
	EReference getProtocolCombinatorType_Action();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.ProtocolPerformType <em>Protocol Perform Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol Perform Type</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolPerformType
	 * @generated
	 */
	EClass getProtocolPerformType();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.ProtocolPerformType#getActionId <em>Action Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Id</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolPerformType#getActionId()
	 * @see #getProtocolPerformType()
	 * @generated
	 */
	EAttribute getProtocolPerformType_ActionId();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.ProtocolPerformType#getSliceId <em>Slice Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice Id</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolPerformType#getSliceId()
	 * @see #getProtocolPerformType()
	 * @generated
	 */
	EAttribute getProtocolPerformType_SliceId();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.ProtocolType <em>Protocol Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol Type</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolType
	 * @generated
	 */
	EClass getProtocolType();

	/**
	 * Returns the meta object for the containment reference '{@link hPE.frontend.connector.xml.component.ProtocolType#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolType#getGuard()
	 * @see #getProtocolType()
	 * @generated
	 */
	EReference getProtocolType_Guard();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.ProtocolType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolType#getId()
	 * @see #getProtocolType()
	 * @generated
	 */
	EAttribute getProtocolType_Id();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.ProtocolType#isRepeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat</em>'.
	 * @see hPE.frontend.connector.xml.component.ProtocolType#isRepeat()
	 * @see #getProtocolType()
	 * @generated
	 */
	EAttribute getProtocolType_Repeat();

	/**
	 * Returns the meta object for class '{@link hPE.frontend.connector.xml.component.Unittype <em>Unittype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unittype</em>'.
	 * @see hPE.frontend.connector.xml.component.Unittype
	 * @generated
	 */
	EClass getUnittype();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.Unittype#getSlice <em>Slice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slice</em>'.
	 * @see hPE.frontend.connector.xml.component.Unittype#getSlice()
	 * @see #getUnittype()
	 * @generated
	 */
	EReference getUnittype_Slice();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.Unittype#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see hPE.frontend.connector.xml.component.Unittype#getAction()
	 * @see #getUnittype()
	 * @generated
	 */
	EReference getUnittype_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link hPE.frontend.connector.xml.component.Unittype#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition</em>'.
	 * @see hPE.frontend.connector.xml.component.Unittype#getCondition()
	 * @see #getUnittype()
	 * @generated
	 */
	EReference getUnittype_Condition();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Unittype#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see hPE.frontend.connector.xml.component.Unittype#getIndex()
	 * @see #getUnittype()
	 * @generated
	 */
	EAttribute getUnittype_Index();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Unittype#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hPE.frontend.connector.xml.component.Unittype#getName()
	 * @see #getUnittype()
	 * @generated
	 */
	EAttribute getUnittype_Name();

	/**
	 * Returns the meta object for the attribute '{@link hPE.frontend.connector.xml.component.Unittype#isParallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parallel</em>'.
	 * @see hPE.frontend.connector.xml.component.Unittype#isParallel()
	 * @see #getUnittype()
	 * @generated
	 */
	EAttribute getUnittype_Parallel();

	/**
	 * Returns the meta object for enum '{@link hPE.frontend.connector.xml.component.AccessType <em>Access Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Type</em>'.
	 * @see hPE.frontend.connector.xml.component.AccessType
	 * @generated
	 */
	EEnum getAccessType();

	/**
	 * Returns the meta object for enum '{@link hPE.frontend.connector.xml.component.Hpekind <em>Hpekind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Hpekind</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpekind
	 * @generated
	 */
	EEnum getHpekind();

	/**
	 * Returns the meta object for data type '{@link hPE.frontend.connector.xml.component.AccessType <em>Access Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Access Type Object</em>'.
	 * @see hPE.frontend.connector.xml.component.AccessType
	 * @model instanceClass="hPE.frontend.connector.xml.component.AccessType"
	 *        extendedMetaData="name='accessType:Object' baseType='accessType'"
	 * @generated
	 */
	EDataType getAccessTypeObject();

	/**
	 * Returns the meta object for data type '{@link hPE.frontend.connector.xml.component.Hpekind <em>Hpekind Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Hpekind Object</em>'.
	 * @see hPE.frontend.connector.xml.component.Hpekind
	 * @model instanceClass="hPE.frontend.connector.xml.component.Hpekind"
	 *        extendedMetaData="name='hpekind:Object' baseType='hpekind'"
	 * @generated
	 */
	EDataType getHpekindObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentFactory getComponentFactory();

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
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.ConditionTypeImpl <em>Condition Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.ConditionTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getConditionType()
		 * @generated
		 */
		EClass CONDITION_TYPE = eINSTANCE.getConditionType();

		/**
		 * The meta object literal for the '<em><b>Cond Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_TYPE__COND_ID = eINSTANCE.getConditionType_CondId();

		/**
		 * The meta object literal for the '<em><b>Slice Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_TYPE__SLICE_ID = eINSTANCE.getConditionType_SliceId();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.DocumentRootImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Hash Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HASH_COMPONENT = eINSTANCE.getDocumentRoot_HashComponent();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.GuardTypeImpl <em>Guard Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.GuardTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getGuardType()
		 * @generated
		 */
		EClass GUARD_TYPE = eINSTANCE.getGuardType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD_TYPE__GROUP = eINSTANCE.getGuardType_Group();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_TYPE__CONDITION = eINSTANCE.getGuardType_Condition();

		/**
		 * The meta object literal for the '<em><b>And</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_TYPE__AND = eINSTANCE.getGuardType_And();

		/**
		 * The meta object literal for the '<em><b>Or</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_TYPE__OR = eINSTANCE.getGuardType_Or();

		/**
		 * The meta object literal for the '<em><b>Not</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD_TYPE__NOT = eINSTANCE.getGuardType_Not();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl <em>Hash Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHashComponentType()
		 * @generated
		 */
		EClass HASH_COMPONENT_TYPE = eINSTANCE.getHashComponentType();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HASH_COMPONENT_TYPE__PACKAGE = eINSTANCE.getHashComponentType_Package();

		/**
		 * The meta object literal for the '<em><b>Using</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HASH_COMPONENT_TYPE__USING = eINSTANCE.getHashComponentType_Using();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HASH_COMPONENT_TYPE__KIND = eINSTANCE.getHashComponentType_Kind();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HASH_COMPONENT_TYPE__NAME = eINSTANCE.getHashComponentType_Name();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HASH_COMPONENT_TYPE__PARAMETER = eINSTANCE.getHashComponentType_Parameter();

		/**
		 * The meta object literal for the '<em><b>Inner Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HASH_COMPONENT_TYPE__INNER_COMPONENT = eINSTANCE.getHashComponentType_InnerComponent();

		/**
		 * The meta object literal for the '<em><b>Super Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HASH_COMPONENT_TYPE__SUPER_COMPONENT = eINSTANCE.getHashComponentType_SuperComponent();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HASH_COMPONENT_TYPE__UNIT = eINSTANCE.getHashComponentType_Unit();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HpeactionImpl <em>Hpeaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HpeactionImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeaction()
		 * @generated
		 */
		EClass HPEACTION = eINSTANCE.getHpeaction();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEACTION__IDENTIFIER = eINSTANCE.getHpeaction_Identifier();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HPEACTION__PROTOCOL = eINSTANCE.getHpeaction_Protocol();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HpeconditionImpl <em>Hpecondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HpeconditionImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpecondition()
		 * @generated
		 */
		EClass HPECONDITION = eINSTANCE.getHpecondition();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPECONDITION__IDENTIFIER = eINSTANCE.getHpecondition_Identifier();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HPECONDITION__GUARD = eINSTANCE.getHpecondition_Guard();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HpeinnerComponentImpl <em>Hpeinner Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HpeinnerComponentImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeinnerComponent()
		 * @generated
		 */
		EClass HPEINNER_COMPONENT = eINSTANCE.getHpeinnerComponent();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEINNER_COMPONENT__KIND = eINSTANCE.getHpeinnerComponent_Kind();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEINNER_COMPONENT__IDENTIFIER = eINSTANCE.getHpeinnerComponent_Identifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HPEINNER_COMPONENT__TYPE = eINSTANCE.getHpeinnerComponent_Type();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEINNER_COMPONENT__ACCESS = eINSTANCE.getHpeinnerComponent_Access();

		/**
		 * The meta object literal for the '<em><b>Export Actions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEINNER_COMPONENT__EXPORT_ACTIONS = eINSTANCE.getHpeinnerComponent_ExportActions();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HpeparameterImpl <em>Hpeparameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HpeparameterImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeparameter()
		 * @generated
		 */
		EClass HPEPARAMETER = eINSTANCE.getHpeparameter();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEPARAMETER__IDENTIFIER = eINSTANCE.getHpeparameter_Identifier();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEPARAMETER__VARIABLE = eINSTANCE.getHpeparameter_Variable();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HPEPARAMETER__CONSTRAINT = eINSTANCE.getHpeparameter_Constraint();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HpeparameterTypeImpl <em>Hpeparameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HpeparameterTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpeparameterType()
		 * @generated
		 */
		EClass HPEPARAMETER_TYPE = eINSTANCE.getHpeparameterType();

		/**
		 * The meta object literal for the '<em><b>Component Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT = eINSTANCE.getHpeparameterType_ComponentConstraint();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HPEPARAMETER_TYPE__PARAMETER = eINSTANCE.getHpeparameterType_Parameter();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HpesliceTypeImpl <em>Hpeslice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HpesliceTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpesliceType()
		 * @generated
		 */
		EClass HPESLICE_TYPE = eINSTANCE.getHpesliceType();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPESLICE_TYPE__INDEX = eINSTANCE.getHpesliceType_Index();

		/**
		 * The meta object literal for the '<em><b>Inner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPESLICE_TYPE__INNER = eINSTANCE.getHpesliceType_Inner();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPESLICE_TYPE__UNIT = eINSTANCE.getHpesliceType_Unit();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.HpetypeImpl <em>Hpetype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.HpetypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpetype()
		 * @generated
		 */
		EClass HPETYPE = eINSTANCE.getHpetype();

		/**
		 * The meta object literal for the '<em><b>Component Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPETYPE__COMPONENT_NAME = eINSTANCE.getHpetype_ComponentName();

		/**
		 * The meta object literal for the '<em><b>Public Inner Component</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPETYPE__PUBLIC_INNER_COMPONENT = eINSTANCE.getHpetype_PublicInnerComponent();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HPETYPE__PARAMETER = eINSTANCE.getHpetype_Parameter();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HPETYPE__PACKAGE = eINSTANCE.getHpetype_Package();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolChoiceTypeImpl <em>Protocol Choice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.ProtocolChoiceTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolChoiceType()
		 * @generated
		 */
		EClass PROTOCOL_CHOICE_TYPE = eINSTANCE.getProtocolChoiceType();

		/**
		 * The meta object literal for the '<em><b>Par</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL_CHOICE_TYPE__PAR = eINSTANCE.getProtocolChoiceType_Par();

		/**
		 * The meta object literal for the '<em><b>Seq</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL_CHOICE_TYPE__SEQ = eINSTANCE.getProtocolChoiceType_Seq();

		/**
		 * The meta object literal for the '<em><b>Alt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL_CHOICE_TYPE__ALT = eINSTANCE.getProtocolChoiceType_Alt();

		/**
		 * The meta object literal for the '<em><b>Perform</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL_CHOICE_TYPE__PERFORM = eINSTANCE.getProtocolChoiceType_Perform();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolCombinatorTypeImpl <em>Protocol Combinator Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.ProtocolCombinatorTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolCombinatorType()
		 * @generated
		 */
		EClass PROTOCOL_COMBINATOR_TYPE = eINSTANCE.getProtocolCombinatorType();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL_COMBINATOR_TYPE__ACTION = eINSTANCE.getProtocolCombinatorType_Action();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolPerformTypeImpl <em>Protocol Perform Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.ProtocolPerformTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolPerformType()
		 * @generated
		 */
		EClass PROTOCOL_PERFORM_TYPE = eINSTANCE.getProtocolPerformType();

		/**
		 * The meta object literal for the '<em><b>Action Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL_PERFORM_TYPE__ACTION_ID = eINSTANCE.getProtocolPerformType_ActionId();

		/**
		 * The meta object literal for the '<em><b>Slice Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL_PERFORM_TYPE__SLICE_ID = eINSTANCE.getProtocolPerformType_SliceId();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.ProtocolTypeImpl <em>Protocol Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.ProtocolTypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getProtocolType()
		 * @generated
		 */
		EClass PROTOCOL_TYPE = eINSTANCE.getProtocolType();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL_TYPE__GUARD = eINSTANCE.getProtocolType_Guard();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL_TYPE__ID = eINSTANCE.getProtocolType_Id();

		/**
		 * The meta object literal for the '<em><b>Repeat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL_TYPE__REPEAT = eINSTANCE.getProtocolType_Repeat();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl <em>Unittype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.impl.UnittypeImpl
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getUnittype()
		 * @generated
		 */
		EClass UNITTYPE = eINSTANCE.getUnittype();

		/**
		 * The meta object literal for the '<em><b>Slice</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNITTYPE__SLICE = eINSTANCE.getUnittype_Slice();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNITTYPE__ACTION = eINSTANCE.getUnittype_Action();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNITTYPE__CONDITION = eINSTANCE.getUnittype_Condition();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNITTYPE__INDEX = eINSTANCE.getUnittype_Index();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNITTYPE__NAME = eINSTANCE.getUnittype_Name();

		/**
		 * The meta object literal for the '<em><b>Parallel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNITTYPE__PARALLEL = eINSTANCE.getUnittype_Parallel();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.AccessType <em>Access Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.AccessType
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getAccessType()
		 * @generated
		 */
		EEnum ACCESS_TYPE = eINSTANCE.getAccessType();

		/**
		 * The meta object literal for the '{@link hPE.frontend.connector.xml.component.Hpekind <em>Hpekind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.Hpekind
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpekind()
		 * @generated
		 */
		EEnum HPEKIND = eINSTANCE.getHpekind();

		/**
		 * The meta object literal for the '<em>Access Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.AccessType
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getAccessTypeObject()
		 * @generated
		 */
		EDataType ACCESS_TYPE_OBJECT = eINSTANCE.getAccessTypeObject();

		/**
		 * The meta object literal for the '<em>Hpekind Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hPE.frontend.connector.xml.component.Hpekind
		 * @see hPE.frontend.connector.xml.component.impl.ComponentPackageImpl#getHpekindObject()
		 * @generated
		 */
		EDataType HPEKIND_OBJECT = eINSTANCE.getHpekindObject();

	}

} //ComponentPackage
