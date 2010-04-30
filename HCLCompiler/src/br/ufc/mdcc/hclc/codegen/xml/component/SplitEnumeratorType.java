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
 * A representation of the model object '<em><b>Split Enumerator Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitEnumeratorType#getERef <em>ERef</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getSplitEnumeratorType()
 * @model extendedMetaData="name='SplitEnumeratorType' kind='empty'"
 * @generated
 */
public interface SplitEnumeratorType extends EObject {
	/**
	 * Returns the value of the '<em><b>ERef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ERef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ERef</em>' attribute.
	 * @see #setERef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getSplitEnumeratorType_ERef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='eRef'"
	 * @generated
	 */
	String getERef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitEnumeratorType#getERef <em>ERef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ERef</em>' attribute.
	 * @see #getERef()
	 * @generated
	 */
	void setERef(String value);

} // SplitEnumeratorType
