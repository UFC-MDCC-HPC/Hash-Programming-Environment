/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#isExposed <em>Exposed</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#getPRef <em>PRef</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getPortType()
 * @model extendedMetaData="name='PortType' kind='elementOnly'"
 * @generated
 */
public interface PortType extends EObject {
	/**
	 * Returns the value of the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual Description</em>' containment reference.
	 * @see #setVisualDescription(VisualElementAttributes)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getPortType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>Exposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exposed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exposed</em>' attribute.
	 * @see #isSetExposed()
	 * @see #unsetExposed()
	 * @see #setExposed(boolean)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getPortType_Exposed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='exposed'"
	 * @generated
	 */
	boolean isExposed();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#isExposed <em>Exposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exposed</em>' attribute.
	 * @see #isSetExposed()
	 * @see #unsetExposed()
	 * @see #isExposed()
	 * @generated
	 */
	void setExposed(boolean value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#isExposed <em>Exposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExposed()
	 * @see #isExposed()
	 * @see #setExposed(boolean)
	 * @generated
	 */
	void unsetExposed();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#isExposed <em>Exposed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exposed</em>' attribute is set.
	 * @see #unsetExposed()
	 * @see #isExposed()
	 * @see #setExposed(boolean)
	 * @generated
	 */
	boolean isSetExposed();

	/**
	 * Returns the value of the '<em><b>PRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PRef</em>' attribute.
	 * @see #setPRef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getPortType_PRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='pRef'"
	 * @generated
	 */
	String getPRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#getPRef <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PRef</em>' attribute.
	 * @see #getPRef()
	 * @generated
	 */
	void setPRef(String value);

} // PortType
