/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Signal Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ActionSignalType#getSemaphore <em>Semaphore</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getActionSignalType()
 * @model extendedMetaData="name='ActionSignalType' kind='elementOnly'"
 * @generated
 */
public interface ActionSignalType extends ActionType {
	/**
	 * Returns the value of the '<em><b>Semaphore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semaphore</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semaphore</em>' attribute.
	 * @see #setSemaphore(String)
	 * @see hPE.xml.component.ComponentPackage#getActionSignalType_Semaphore()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='semaphore'"
	 * @generated
	 */
	String getSemaphore();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ActionSignalType#getSemaphore <em>Semaphore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semaphore</em>' attribute.
	 * @see #getSemaphore()
	 * @generated
	 */
	void setSemaphore(String value);

} // ActionSignalType
