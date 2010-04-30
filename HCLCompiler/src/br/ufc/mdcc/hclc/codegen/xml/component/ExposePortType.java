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
 * A representation of the model object '<em><b>Expose Port Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getCRef <em>CRef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getExposed <em>Exposed</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getPRef <em>PRef</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getExposePortType()
 * @model extendedMetaData="name='ExposePortType' kind='empty'"
 * @generated
 */
public interface ExposePortType extends EObject {
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
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getExposePortType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

	/**
	 * Returns the value of the '<em><b>Exposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exposed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exposed</em>' attribute.
	 * @see #setExposed(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getExposePortType_Exposed()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='exposed'"
	 * @generated
	 */
	String getExposed();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getExposed <em>Exposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exposed</em>' attribute.
	 * @see #getExposed()
	 * @generated
	 */
	void setExposed(String value);

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
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getExposePortType_PRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='pRef'"
	 * @generated
	 */
	String getPRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getPRef <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PRef</em>' attribute.
	 * @see #getPRef()
	 * @generated
	 */
	void setPRef(String value);

} // ExposePortType
