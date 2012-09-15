/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hpeparameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.HpeparameterType#getComponentConstraint <em>Component Constraint</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HpeparameterType#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeparameterType()
 * @model extendedMetaData="name='hpeparameterType' kind='elementOnly'"
 * @generated
 */
public interface HpeparameterType extends EObject {
	/**
	 * Returns the value of the '<em><b>Component Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Constraint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Constraint</em>' attribute.
	 * @see #setComponentConstraint(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeparameterType_ComponentConstraint()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='componentConstraint'"
	 * @generated
	 */
	String getComponentConstraint();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HpeparameterType#getComponentConstraint <em>Component Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Constraint</em>' attribute.
	 * @see #getComponentConstraint()
	 * @generated
	 */
	void setComponentConstraint(String value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.connector.xml.component.Hpeparameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeparameterType_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameter'"
	 * @generated
	 */
	EList<Hpeparameter> getParameter();

} // HpeparameterType
