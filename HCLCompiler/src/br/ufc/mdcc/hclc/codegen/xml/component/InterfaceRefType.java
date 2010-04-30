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
 * A representation of the model object '<em><b>Interface Ref Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getCRef <em>CRef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getIRef <em>IRef</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInterfaceRefType()
 * @model extendedMetaData="name='InterfaceRefType' kind='empty'"
 * @generated
 */
public interface InterfaceRefType extends EObject {
	/**
	 * Returns the value of the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CRef</em>' attribute.
	 * @see #setCRef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInterfaceRefType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

	/**
	 * Returns the value of the '<em><b>IRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IRef</em>' attribute.
	 * @see #setIRef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInterfaceRefType_IRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='iRef'"
	 * @generated
	 */
	String getIRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getIRef <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IRef</em>' attribute.
	 * @see #getIRef()
	 * @generated
	 */
	void setIRef(String value);

} // InterfaceRefType
