/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Activate Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType#getSliceRef <em>Slice Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getActionActivateType()
 * @model extendedMetaData="name='ActionActivateType' kind='elementOnly'"
 * @generated
 */
public interface ActionActivateType extends ActionType {
	/**
	 * Returns the value of the '<em><b>Slice Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice Ref</em>' attribute.
	 * @see #setSliceRef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getActionActivateType_SliceRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='sliceRef'"
	 * @generated
	 */
	String getSliceRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType#getSliceRef <em>Slice Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Ref</em>' attribute.
	 * @see #getSliceRef()
	 * @generated
	 */
	void setSliceRef(String value);

} // ActionActivateType
