/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantification Var Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.QuantificationVarType#getQType <em>QType</em>}</li>
 *   <li>{@link hPE.xml.component.QuantificationVarType#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getQuantificationVarType()
 * @model extendedMetaData="name='QuantificationVarType' kind='elementOnly'"
 * @generated
 */
public interface QuantificationVarType extends EObject {
	/**
	 * Returns the value of the '<em><b>QType</b></em>' attribute.
	 * The default value is <code>"Universal"</code>.
	 * The literals are from the enumeration {@link hPE.xml.component.QuantificationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>QType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>QType</em>' attribute.
	 * @see hPE.xml.component.QuantificationType
	 * @see #isSetQType()
	 * @see #unsetQType()
	 * @see #setQType(QuantificationType)
	 * @see hPE.xml.component.ComponentPackage#getQuantificationVarType_QType()
	 * @model default="Universal" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='qType'"
	 * @generated
	 */
	QuantificationType getQType();

	/**
	 * Sets the value of the '{@link hPE.xml.component.QuantificationVarType#getQType <em>QType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>QType</em>' attribute.
	 * @see hPE.xml.component.QuantificationType
	 * @see #isSetQType()
	 * @see #unsetQType()
	 * @see #getQType()
	 * @generated
	 */
	void setQType(QuantificationType value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.QuantificationVarType#getQType <em>QType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQType()
	 * @see #getQType()
	 * @see #setQType(QuantificationType)
	 * @generated
	 */
	void unsetQType();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.QuantificationVarType#getQType <em>QType</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>QType</em>' attribute is set.
	 * @see #unsetQType()
	 * @see #getQType()
	 * @see #setQType(QuantificationType)
	 * @generated
	 */
	boolean isSetQType();

	/**
	 * Returns the value of the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Name</em>' attribute.
	 * @see #setVarName(String)
	 * @see hPE.xml.component.ComponentPackage#getQuantificationVarType_VarName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='varName'"
	 * @generated
	 */
	String getVarName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.QuantificationVarType#getVarName <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' attribute.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(String value);

} // QuantificationVarType
