/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Supported Kinds</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see hPE.xml.component.ComponentPackage#getSupportedKinds()
 * @model extendedMetaData="name='SupportedKinds'"
 * @generated
 */
public enum SupportedKinds implements Enumerator {


	/**
	 * The '<em><b>Data</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_VALUE
	 * @generated
	 * @ordered
	 */
	DATA(0, "Data", "Data"),
	
	/**
	 * The '<em><b>Computation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTATION_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTATION(1, "Computation", "Computation"),

	/**
	 * The '<em><b>Synchronizer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONIZER_VALUE
	 * @generated
	 * @ordered
	 */
	SYNCHRONIZER(2, "Synchronizer", "Synchronizer"), /**
	 * The '<em><b>Architecture</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHITECTURE_VALUE
	 * @generated
	 * @ordered
	 */
	ARCHITECTURE(3, "Architecture", "Architecture"),

	/**
	 * The '<em><b>Environment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENVIRONMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ENVIRONMENT(4, "Environment", "Environment"),

	/**
	 * The '<em><b>Qualifier</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUALIFIER_VALUE
	 * @generated
	 * @ordered
	 */
	QUALIFIER(5, "Qualifier", "Qualifier"),

	/**
	 * The '<em><b>Application</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPLICATION_VALUE
	 * @generated
	 * @ordered
	 */
	APPLICATION(6, "Application", "Application"), /**
	 * The '<em><b>Enumerator</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENUMERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	ENUMERATOR(7, "Enumerator", "Enumerator"),

	/**
	 * The '<em><b>Facet</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACET_VALUE
	 * @generated
	 * @ordered
	 */
	FACET(8, "Facet", "Facet"),

	/**
	 * The '<em><b>Domain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOMAIN_VALUE
	 * @generated
	 * @ordered
	 */
	DOMAIN(9, "Domain", "Domain"),

	/**
	 * The '<em><b>Domain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOMAIN_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE(9, "Service", "Service");

	/**
	 * The '<em><b>Data</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA
	 * @model name="Data"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_VALUE = 0;

	/**
	 * The '<em><b>Computation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Computation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPUTATION
	 * @model name="Computation"
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTATION_VALUE = 1;

	/**
	 * The '<em><b>Synchronizer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Synchronizer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONIZER
	 * @model name="Synchronizer"
	 * @generated
	 * @ordered
	 */
	public static final int SYNCHRONIZER_VALUE = 2;

	/**
	 * The '<em><b>Architecture</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Architecture</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARCHITECTURE
	 * @model name="Architecture"
	 * @generated
	 * @ordered
	 */
	public static final int ARCHITECTURE_VALUE = 3;

	/**
	 * The '<em><b>Environment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Environment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENVIRONMENT
	 * @model name="Environment"
	 * @generated
	 * @ordered
	 */
	public static final int ENVIRONMENT_VALUE = 4;

	/**
	 * The '<em><b>Qualifier</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Qualifier</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUALIFIER
	 * @model name="Qualifier"
	 * @generated
	 * @ordered
	 */
	public static final int QUALIFIER_VALUE = 5;

	/**
	 * The '<em><b>Application</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Application</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APPLICATION
	 * @model name="Application"
	 * @generated
	 * @ordered
	 */
	public static final int APPLICATION_VALUE = 6;

	/**
	 * The '<em><b>Enumerator</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Enumerator</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENUMERATOR
	 * @model name="Enumerator"
	 * @generated
	 * @ordered
	 */
	public static final int ENUMERATOR_VALUE = 7;


	/**
	 * The '<em><b>Facet</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Facet</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACET
	 * @model name="Facet"
	 * @generated
	 * @ordered
	 */	
	public static final int FACET_VALUE = 8;

	/**
	 * The '<em><b>Domain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Domain</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOMAIN
	 * @model name="Domain"
	 * @generated
	 * @ordered
	 */
	public static final int DOMAIN_VALUE = 9;
	
	
	/**
	 * The '<em><b>Service</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Service</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVICE
	 * @model name="Service"
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Supported Kinds</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SupportedKinds[] VALUES_ARRAY =
		new SupportedKinds[] {
			DATA,
			COMPUTATION,
			SYNCHRONIZER,
			ARCHITECTURE,
			ENVIRONMENT,
			QUALIFIER,
			APPLICATION,
			ENUMERATOR,
			FACET,
			DOMAIN,
			SERVICE,
		};

	/**
	 * A public read-only list of all the '<em><b>Supported Kinds</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SupportedKinds> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Supported Kinds</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SupportedKinds get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SupportedKinds result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Supported Kinds</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SupportedKinds getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SupportedKinds result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Supported Kinds</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SupportedKinds get(int value) {
		switch (value) {
			case DATA_VALUE: return DATA;
			case COMPUTATION_VALUE: return COMPUTATION;
			case SYNCHRONIZER_VALUE: return SYNCHRONIZER;
			case ARCHITECTURE_VALUE: return ARCHITECTURE;
			case ENVIRONMENT_VALUE: return ENVIRONMENT;
			case QUALIFIER_VALUE: return QUALIFIER;
			case APPLICATION_VALUE: return APPLICATION;
			case ENUMERATOR_VALUE: return ENUMERATOR;
			case DOMAIN_VALUE: return DOMAIN;
			case FACET_VALUE: return FACET;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SupportedKinds(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SupportedKinds
