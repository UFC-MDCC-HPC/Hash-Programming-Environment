/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Activation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ProtocolActivationType#getActionId <em>Action Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getProtocolActivationType()
 * @model extendedMetaData="name='ProtocolActivationType' kind='elementOnly'"
 * @generated
 */
public interface ProtocolActivationType extends ProtocolType {
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
	 * @see hPE.xml.component.ComponentPackage#getProtocolActivationType_ActionId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='action_id'"
	 * @generated
	 */
	String getActionId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolActivationType#getActionId <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Id</em>' attribute.
	 * @see #getActionId()
	 * @generated
	 */
	void setActionId(String value);

} // ProtocolActivationType
