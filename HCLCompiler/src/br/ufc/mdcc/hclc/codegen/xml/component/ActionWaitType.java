/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Wait Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType#getSemaphore <em>Semaphore</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getActionWaitType()
 * @model extendedMetaData="name='ActionWaitType' kind='elementOnly'"
 * @generated
 */
public interface ActionWaitType extends ActionType {
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
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getActionWaitType_Semaphore()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='semaphore'"
	 * @generated
	 */
	String getSemaphore();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType#getSemaphore <em>Semaphore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semaphore</em>' attribute.
	 * @see #getSemaphore()
	 * @generated
	 */
	void setSemaphore(String value);

} // ActionWaitType
