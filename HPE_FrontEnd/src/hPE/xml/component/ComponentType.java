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
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ComponentType#getHeader <em>Header</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentType#getComponentInfo <em>Component Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getComponentType()
 * @model extendedMetaData="name='ComponentType' kind='elementOnly'"
 * @generated
 */
public interface ComponentType extends EObject {
	/**
	 * Returns the value of the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' containment reference.
	 * @see #setHeader(ComponentHeaderType)
	 * @see hPE.xml.component.ComponentPackage#getComponentType_Header()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='header'"
	 * @generated
	 */
	ComponentHeaderType getHeader();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentType#getHeader <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' containment reference.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(ComponentHeaderType value);

	/**
	 * Returns the value of the '<em><b>Component Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Info</em>' containment reference.
	 * @see #setComponentInfo(ComponentBodyType)
	 * @see hPE.xml.component.ComponentPackage#getComponentType_ComponentInfo()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='componentInfo'"
	 * @generated
	 */
	ComponentBodyType getComponentInfo();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentType#getComponentInfo <em>Component Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Info</em>' containment reference.
	 * @see #getComponentInfo()
	 * @generated
	 */
	void setComponentInfo(ComponentBodyType value);

} // ComponentType
