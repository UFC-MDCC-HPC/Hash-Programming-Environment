/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hpeparameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.Hpeparameter#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.Hpeparameter#getVariable <em>Variable</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.Hpeparameter#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeparameter()
 * @model extendedMetaData="name='hpeparameter' kind='elementOnly'"
 * @generated
 */
public interface Hpeparameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeparameter_Identifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='identifier'"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.Hpeparameter#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeparameter_Variable()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='variable'"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.Hpeparameter#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference.
	 * @see #setConstraint(HpeparameterType)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeparameter_Constraint()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='constraint'"
	 * @generated
	 */
	HpeparameterType getConstraint();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.Hpeparameter#getConstraint <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' containment reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(HpeparameterType value);

} // Hpeparameter
