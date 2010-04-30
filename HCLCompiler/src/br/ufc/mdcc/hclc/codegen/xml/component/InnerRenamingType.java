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
 * A representation of the model object '<em><b>Inner Renaming Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCNewName <em>CNew Name</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCOldName <em>COld Name</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCRef <em>CRef</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInnerRenamingType()
 * @model extendedMetaData="name='InnerRenamingType' kind='empty'"
 * @generated
 */
public interface InnerRenamingType extends EObject {
	/**
	 * Returns the value of the '<em><b>CNew Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CNew Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CNew Name</em>' attribute.
	 * @see #setCNewName(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInnerRenamingType_CNewName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cNewName'"
	 * @generated
	 */
	String getCNewName();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCNewName <em>CNew Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CNew Name</em>' attribute.
	 * @see #getCNewName()
	 * @generated
	 */
	void setCNewName(String value);

	/**
	 * Returns the value of the '<em><b>COld Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>COld Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>COld Name</em>' attribute.
	 * @see #setCOldName(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInnerRenamingType_COldName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cOldName'"
	 * @generated
	 */
	String getCOldName();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCOldName <em>COld Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>COld Name</em>' attribute.
	 * @see #getCOldName()
	 * @generated
	 */
	void setCOldName(String value);

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
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInnerRenamingType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

} // InnerRenamingType
