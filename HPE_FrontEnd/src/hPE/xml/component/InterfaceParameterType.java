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
 * A representation of the model object '<em><b>Interface Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.InterfaceParameterType#getIname <em>Iname</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceParameterType#getOrder <em>Order</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceParameterType#getParid <em>Parid</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceParameterType#getUname <em>Uname</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceParameterType#getVarid <em>Varid</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getInterfaceParameterType()
 * @model extendedMetaData="name='InterfaceParameterType' kind='empty'"
 * @generated
 */
public interface InterfaceParameterType extends EObject {
	/**
	 * Returns the value of the '<em><b>Iname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iname</em>' attribute.
	 * @see #setIname(String)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceParameterType_Iname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='iname'"
	 * @generated
	 */
	String getIname();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceParameterType#getIname <em>Iname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iname</em>' attribute.
	 * @see #getIname()
	 * @generated
	 */
	void setIname(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getInterfaceParameterType_Order()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='order'"
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceParameterType#getOrder <em>Order</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.xml.component.InterfaceParameterType#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrder()
	 * @see #getOrder()
	 * @see #setOrder(int)
	 * @generated
	 */
	void unsetOrder();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.InterfaceParameterType#getOrder <em>Order</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Parid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parid</em>' attribute.
	 * @see #setParid(String)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceParameterType_Parid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='parid'"
	 * @generated
	 */
	String getParid();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceParameterType#getParid <em>Parid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parid</em>' attribute.
	 * @see #getParid()
	 * @generated
	 */
	void setParid(String value);

	/**
	 * Returns the value of the '<em><b>Uname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uname</em>' attribute.
	 * @see #setUname(String)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceParameterType_Uname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uname'"
	 * @generated
	 */
	String getUname();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceParameterType#getUname <em>Uname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uname</em>' attribute.
	 * @see #getUname()
	 * @generated
	 */
	void setUname(String value);

	/**
	 * Returns the value of the '<em><b>Varid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varid</em>' attribute.
	 * @see #setVarid(String)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceParameterType_Varid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='varid'"
	 * @generated
	 */
	String getVarid();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceParameterType#getVarid <em>Varid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varid</em>' attribute.
	 * @see #getVarid()
	 * @generated
	 */
	void setVarid(String value);

} // InterfaceParameterType
