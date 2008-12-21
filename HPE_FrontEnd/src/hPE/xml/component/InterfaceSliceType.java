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
 * A representation of the model object '<em><b>Interface Slice Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.InterfaceSliceType#getOriginRef <em>Origin Ref</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceSliceType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceSliceType#getIsRef <em>Is Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getInterfaceSliceType()
 * @model extendedMetaData="name='InterfaceSliceType' kind='elementOnly'"
 * @generated
 */
public interface InterfaceSliceType extends EObject {
	/**
	 * Returns the value of the '<em><b>Origin Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Ref</em>' containment reference.
	 * @see #setOriginRef(InterfaceRefType)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceSliceType_OriginRef()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='originRef'"
	 * @generated
	 */
	InterfaceRefType getOriginRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceSliceType#getOriginRef <em>Origin Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Ref</em>' containment reference.
	 * @see #getOriginRef()
	 * @generated
	 */
	void setOriginRef(InterfaceRefType value);

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
	 * @see hPE.xml.component.ComponentPackage#getInterfaceSliceType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceSliceType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>Is Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ref</em>' attribute.
	 * @see #setIsRef(String)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceSliceType_IsRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='isRef'"
	 * @generated
	 */
	String getIsRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceSliceType#getIsRef <em>Is Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ref</em>' attribute.
	 * @see #getIsRef()
	 * @generated
	 */
	void setIsRef(String value);

} // InterfaceSliceType
