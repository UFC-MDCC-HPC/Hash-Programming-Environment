/**
 */
package hPE.xml.component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variance Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see hPE.xml.component.ComponentPackage#getVarianceType()
 * @model extendedMetaData="name='VarianceType'"
 * @generated
 */
public enum VarianceType implements Enumerator {
	/**
	 * The '<em><b>Covariant</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COVARIANT_VALUE
	 * @generated
	 * @ordered
	 */
	COVARIANT(0, "covariant", "covariant"),

	/**
	 * The '<em><b>Contravariant</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRAVARIANT_VALUE
	 * @generated
	 * @ordered
	 */
	CONTRAVARIANT(1, "contravariant", "contravariant"),

	/**
	 * The '<em><b>Invariant</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVARIANT_VALUE
	 * @generated
	 * @ordered
	 */
	INVARIANT(2, "invariant", "invariant");

	/**
	 * The '<em><b>Covariant</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Covariant</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COVARIANT
	 * @model name="covariant"
	 * @generated
	 * @ordered
	 */
	public static final int COVARIANT_VALUE = 0;

	/**
	 * The '<em><b>Contravariant</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Contravariant</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTRAVARIANT
	 * @model name="contravariant"
	 * @generated
	 * @ordered
	 */
	public static final int CONTRAVARIANT_VALUE = 1;

	/**
	 * The '<em><b>Invariant</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Invariant</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVARIANT
	 * @model name="invariant"
	 * @generated
	 * @ordered
	 */
	public static final int INVARIANT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Variance Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VarianceType[] VALUES_ARRAY =
		new VarianceType[] {
			COVARIANT,
			CONTRAVARIANT,
			INVARIANT,
		};

	/**
	 * A public read-only list of all the '<em><b>Variance Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VarianceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variance Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VarianceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VarianceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variance Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VarianceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VarianceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variance Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VarianceType get(int value) {
		switch (value) {
			case COVARIANT_VALUE: return COVARIANT;
			case CONTRAVARIANT_VALUE: return CONTRAVARIANT;
			case INVARIANT_VALUE: return INVARIANT;
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
	private VarianceType(int value, String name, String literal) {
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
	
} //VarianceType
