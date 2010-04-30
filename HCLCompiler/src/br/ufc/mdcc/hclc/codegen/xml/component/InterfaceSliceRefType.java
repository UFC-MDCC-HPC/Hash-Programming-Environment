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
 * A representation of the model object '<em><b>Interface Slice Ref Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getInterfaceRef <em>Interface Ref</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getSliceRef <em>Slice Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInterfaceSliceRefType()
 * @model extendedMetaData="name='InterfaceSliceRefType' kind='empty'"
 * @generated
 */
public interface InterfaceSliceRefType extends EObject {
	/**
	 * Returns the value of the '<em><b>Component Ref</b></em>' attribute.
	 * The default value is <code>"this"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Ref</em>' attribute.
	 * @see #isSetComponentRef()
	 * @see #unsetComponentRef()
	 * @see #setComponentRef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInterfaceSliceRefType_ComponentRef()
	 * @model default="this" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='componentRef'"
	 * @generated
	 */
	String getComponentRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getComponentRef <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ref</em>' attribute.
	 * @see #isSetComponentRef()
	 * @see #unsetComponentRef()
	 * @see #getComponentRef()
	 * @generated
	 */
	void setComponentRef(String value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getComponentRef <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetComponentRef()
	 * @see #getComponentRef()
	 * @see #setComponentRef(String)
	 * @generated
	 */
	void unsetComponentRef();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getComponentRef <em>Component Ref</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Component Ref</em>' attribute is set.
	 * @see #unsetComponentRef()
	 * @see #getComponentRef()
	 * @see #setComponentRef(String)
	 * @generated
	 */
	boolean isSetComponentRef();

	/**
	 * Returns the value of the '<em><b>Interface Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Ref</em>' attribute.
	 * @see #setInterfaceRef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInterfaceSliceRefType_InterfaceRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='interfaceRef'"
	 * @generated
	 */
	String getInterfaceRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getInterfaceRef <em>Interface Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Ref</em>' attribute.
	 * @see #getInterfaceRef()
	 * @generated
	 */
	void setInterfaceRef(String value);

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
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getInterfaceSliceRefType_SliceRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sliceRef'"
	 * @generated
	 */
	String getSliceRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getSliceRef <em>Slice Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Ref</em>' attribute.
	 * @see #getSliceRef()
	 * @generated
	 */
	void setSliceRef(String value);

} // InterfaceSliceRefType
