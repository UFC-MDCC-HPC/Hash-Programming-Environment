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
 * A representation of the model object '<em><b>Port Slice Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.PortSliceType#getPRef <em>PRef</em>}</li>
 *   <li>{@link hPE.xml.component.PortSliceType#getSRef <em>SRef</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getPortSliceType()
 * @model extendedMetaData="name='PortSliceType' kind='empty'"
 * @generated
 */
public interface PortSliceType extends EObject {
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
	 * @see hPE.xml.component.ComponentPackage#getPortSliceType_PRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='pRef'"
	 * @generated
	 */
	String getPRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.PortSliceType#getPRef <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PRef</em>' attribute.
	 * @see #getPRef()
	 * @generated
	 */
	void setPRef(String value);

	/**
	 * Returns the value of the '<em><b>SRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRef</em>' attribute.
	 * @see #setSRef(String)
	 * @see hPE.xml.component.ComponentPackage#getPortSliceType_SRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sRef'"
	 * @generated
	 */
	String getSRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.PortSliceType#getSRef <em>SRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SRef</em>' attribute.
	 * @see #getSRef()
	 * @generated
	 */
	void setSRef(String value);

} // PortSliceType
