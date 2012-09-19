/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Condition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.GuardConditionType#getCondition1 <em>Condition1</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getGuardConditionType()
 * @model extendedMetaData="name='GuardConditionType' kind='elementOnly'"
 * @generated
 */
public interface GuardConditionType extends GuardType {
	/**
	 * Returns the value of the '<em><b>Condition1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition1</em>' attribute.
	 * @see #setCondition1(String)
	 * @see hPE.xml.component.ComponentPackage#getGuardConditionType_Condition1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='condition'"
	 * @generated
	 */
	String getCondition1();

	/**
	 * Sets the value of the '{@link hPE.xml.component.GuardConditionType#getCondition1 <em>Condition1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition1</em>' attribute.
	 * @see #getCondition1()
	 * @generated
	 */
	void setCondition1(String value);

} // GuardConditionType
