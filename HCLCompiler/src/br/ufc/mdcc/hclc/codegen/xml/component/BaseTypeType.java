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
 * A representation of the model object '<em><b>Base Type Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getExtensionType <em>Extension Type</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getBaseTypeType()
 * @model extendedMetaData="name='BaseTypeType' kind='elementOnly'"
 * @generated
 */
public interface BaseTypeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Extension Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Type</em>' containment reference.
	 * @see #setExtensionType(ExtensionTypeType)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getBaseTypeType_ExtensionType()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='extensionType'"
	 * @generated
	 */
	ExtensionTypeType getExtensionType();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getExtensionType <em>Extension Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Type</em>' containment reference.
	 * @see #getExtensionType()
	 * @generated
	 */
	void setExtensionType(ExtensionTypeType value);

	/**
	 * Returns the value of the '<em><b>Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' containment reference.
	 * @see #setComponent(ComponentInUseType)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getBaseTypeType_Component()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='component'"
	 * @generated
	 */
	ComponentInUseType getComponent();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getComponent <em>Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' containment reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(ComponentInUseType value);

} // BaseTypeType
