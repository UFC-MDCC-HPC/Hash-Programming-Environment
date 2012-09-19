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
 * A representation of the model object '<em><b>Condition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ConditionType#getCondId <em>Cond Id</em>}</li>
 *   <li>{@link hPE.xml.component.ConditionType#getSliceId <em>Slice Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getConditionType()
 * @model extendedMetaData="name='ConditionType' kind='empty'"
 * @generated
 */
public interface ConditionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Cond Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Id</em>' attribute.
	 * @see #setCondId(String)
	 * @see hPE.xml.component.ComponentPackage#getConditionType_CondId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='cond_id'"
	 * @generated
	 */
	String getCondId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ConditionType#getCondId <em>Cond Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond Id</em>' attribute.
	 * @see #getCondId()
	 * @generated
	 */
	void setCondId(String value);

	/**
	 * Returns the value of the '<em><b>Slice Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice Id</em>' attribute.
	 * @see #setSliceId(String)
	 * @see hPE.xml.component.ComponentPackage#getConditionType_SliceId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='slice_id'"
	 * @generated
	 */
	String getSliceId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ConditionType#getSliceId <em>Slice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Id</em>' attribute.
	 * @see #getSliceId()
	 * @generated
	 */
	void setSliceId(String value);

} // ConditionType
