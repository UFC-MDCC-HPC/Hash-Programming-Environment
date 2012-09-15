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
 * A representation of the model object '<em><b>Perform Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.PerformType#getActionId <em>Action Id</em>}</li>
 *   <li>{@link hPE.xml.component.PerformType#getSliceId <em>Slice Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getPerformType()
 * @model extendedMetaData="name='perform_._type' kind='empty'"
 * @generated
 */
public interface PerformType extends EObject {
	/**
	 * Returns the value of the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Id</em>' attribute.
	 * @see #setActionId(String)
	 * @see hPE.xml.component.ComponentPackage#getPerformType_ActionId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='action_id'"
	 * @generated
	 */
	String getActionId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.PerformType#getActionId <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Id</em>' attribute.
	 * @see #getActionId()
	 * @generated
	 */
	void setActionId(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getPerformType_SliceId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='slice_id'"
	 * @generated
	 */
	String getSliceId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.PerformType#getSliceId <em>Slice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Id</em>' attribute.
	 * @see #getSliceId()
	 * @generated
	 */
	void setSliceId(String value);

} // PerformType
