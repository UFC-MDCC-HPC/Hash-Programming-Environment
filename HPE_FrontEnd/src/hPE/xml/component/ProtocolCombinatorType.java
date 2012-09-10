/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Combinator Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ProtocolCombinatorType#getAction <em>Action</em>}</li>
 *   <li>{@link hPE.xml.component.ProtocolCombinatorType#getGuard <em>Guard</em>}</li>
 *   <li>{@link hPE.xml.component.ProtocolCombinatorType#getId <em>Id</em>}</li>
 *   <li>{@link hPE.xml.component.ProtocolCombinatorType#isRepeat <em>Repeat</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getProtocolCombinatorType()
 * @model extendedMetaData="name='ProtocolCombinatorType' kind='elementOnly'"
 * @generated
 */
public interface ProtocolCombinatorType extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ProtocolChoiceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getProtocolCombinatorType_Action()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='action'"
	 * @generated
	 */
	EList<ProtocolChoiceType> getAction();

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(GuardType)
	 * @see hPE.xml.component.ComponentPackage#getProtocolCombinatorType_Guard()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='guard'"
	 * @generated
	 */
	GuardType getGuard();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolCombinatorType#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(GuardType value);

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
	 * @see hPE.xml.component.ComponentPackage#getProtocolCombinatorType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolCombinatorType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat</em>' attribute.
	 * @see #isSetRepeat()
	 * @see #unsetRepeat()
	 * @see #setRepeat(boolean)
	 * @see hPE.xml.component.ComponentPackage#getProtocolCombinatorType_Repeat()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='repeat'"
	 * @generated
	 */
	boolean isRepeat();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolCombinatorType#isRepeat <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat</em>' attribute.
	 * @see #isSetRepeat()
	 * @see #unsetRepeat()
	 * @see #isRepeat()
	 * @generated
	 */
	void setRepeat(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.ProtocolCombinatorType#isRepeat <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepeat()
	 * @see #isRepeat()
	 * @see #setRepeat(boolean)
	 * @generated
	 */
	void unsetRepeat();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.ProtocolCombinatorType#isRepeat <em>Repeat</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Repeat</em>' attribute is set.
	 * @see #unsetRepeat()
	 * @see #isRepeat()
	 * @see #setRepeat(boolean)
	 * @generated
	 */
	boolean isSetRepeat();

} // ProtocolCombinatorType
