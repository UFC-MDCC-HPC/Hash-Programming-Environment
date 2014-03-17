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
 * A representation of the model object '<em><b>Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ParameterType#getComponentRef <em>Component Ref</em>}</li>
 *   <li>{@link hPE.xml.component.ParameterType#getFormFieldId <em>Form Field Id</em>}</li>
 *   <li>{@link hPE.xml.component.ParameterType#getOrder <em>Order</em>}</li>
 *   <li>{@link hPE.xml.component.ParameterType#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getParameterType()
 * @model extendedMetaData="name='ParameterType' kind='empty'"
 * @generated
 */
public interface ParameterType extends EObject {
	/**
	 * Returns the value of the '<em><b>Component Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Ref</em>' attribute.
	 * @see #setComponentRef(String)
	 * @see hPE.xml.component.ComponentPackage#getParameterType_ComponentRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='componentRef'"
	 * @generated
	 */
	String getComponentRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterType#getComponentRef <em>Component Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Ref</em>' attribute.
	 * @see #getComponentRef()
	 * @generated
	 */
	void setComponentRef(String value);

	/**
	 * Returns the value of the '<em><b>Form Field Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Field Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Field Id</em>' attribute.
	 * @see #setFormFieldId(String)
	 * @see hPE.xml.component.ComponentPackage#getParameterType_FormFieldId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='formFieldId'"
	 * @generated
	 */
	String getFormFieldId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterType#getFormFieldId <em>Form Field Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Form Field Id</em>' attribute.
	 * @see #getFormFieldId()
	 * @generated
	 */
	void setFormFieldId(String value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #isSetOrder()
	 * @see #unsetOrder()
	 * @see #setOrder(int)
	 * @see hPE.xml.component.ComponentPackage#getParameterType_Order()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='order'"
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterType#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #isSetOrder()
	 * @see #unsetOrder()
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.ParameterType#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrder()
	 * @see #getOrder()
	 * @see #setOrder(int)
	 * @generated
	 */
	void unsetOrder();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.ParameterType#getOrder <em>Order</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Order</em>' attribute is set.
	 * @see #unsetOrder()
	 * @see #getOrder()
	 * @see #setOrder(int)
	 * @generated
	 */
	boolean isSetOrder();

	/**
	 * Returns the value of the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Name</em>' attribute.
	 * @see #setVarName(String)
	 * @see hPE.xml.component.ComponentPackage#getParameterType_VarName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='varName'"
	 * @generated
	 */
	String getVarName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterType#getVarName <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' attribute.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(String value);

} // ParameterType
