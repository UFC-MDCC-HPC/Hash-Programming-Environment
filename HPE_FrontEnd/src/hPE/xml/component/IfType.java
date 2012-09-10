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
 * A representation of the model object '<em><b>If Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.IfType#getGuard <em>Guard</em>}</li>
 *   <li>{@link hPE.xml.component.IfType#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link hPE.xml.component.IfType#getElse <em>Else</em>}</li>
 *   <li>{@link hPE.xml.component.IfType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getIfType()
 * @model extendedMetaData="name='if_._type' kind='elementOnly'"
 * @generated
 */
public interface IfType extends EObject {
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(Hpeguard)
	 * @see hPE.xml.component.ComponentPackage#getIfType_Guard()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='guard'"
	 * @generated
	 */
	Hpeguard getGuard();

	/**
	 * Sets the value of the '{@link hPE.xml.component.IfType#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Hpeguard value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' containment reference.
	 * @see #setProtocol(Hpeprotocol)
	 * @see hPE.xml.component.ComponentPackage#getIfType_Protocol()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='protocol'"
	 * @generated
	 */
	Hpeprotocol getProtocol();

	/**
	 * Sets the value of the '{@link hPE.xml.component.IfType#getProtocol <em>Protocol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' containment reference.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(Hpeprotocol value);

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(Hpeprotocol)
	 * @see hPE.xml.component.ComponentPackage#getIfType_Else()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='else'"
	 * @generated
	 */
	Hpeprotocol getElse();

	/**
	 * Sets the value of the '{@link hPE.xml.component.IfType#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(Hpeprotocol value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see hPE.xml.component.ComponentPackage#getIfType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.IfType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // IfType
