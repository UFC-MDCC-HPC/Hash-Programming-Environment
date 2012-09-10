/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Choice Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ProtocolChoiceType#getPar <em>Par</em>}</li>
 *   <li>{@link hPE.xml.component.ProtocolChoiceType#getSeq <em>Seq</em>}</li>
 *   <li>{@link hPE.xml.component.ProtocolChoiceType#getAlt <em>Alt</em>}</li>
 *   <li>{@link hPE.xml.component.ProtocolChoiceType#getPerform <em>Perform</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getProtocolChoiceType()
 * @model extendedMetaData="name='ProtocolChoiceType' kind='elementOnly'"
 * @generated
 */
public interface ProtocolChoiceType extends ProtocolType {
	/**
	 * Returns the value of the '<em><b>Par</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Par</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Par</em>' containment reference.
	 * @see #setPar(ProtocolCombinatorType)
	 * @see hPE.xml.component.ComponentPackage#getProtocolChoiceType_Par()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='par'"
	 * @generated
	 */
	ProtocolCombinatorType getPar();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolChoiceType#getPar <em>Par</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Par</em>' containment reference.
	 * @see #getPar()
	 * @generated
	 */
	void setPar(ProtocolCombinatorType value);

	/**
	 * Returns the value of the '<em><b>Seq</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seq</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seq</em>' containment reference.
	 * @see #setSeq(ProtocolCombinatorType)
	 * @see hPE.xml.component.ComponentPackage#getProtocolChoiceType_Seq()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='seq'"
	 * @generated
	 */
	ProtocolCombinatorType getSeq();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolChoiceType#getSeq <em>Seq</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seq</em>' containment reference.
	 * @see #getSeq()
	 * @generated
	 */
	void setSeq(ProtocolCombinatorType value);

	/**
	 * Returns the value of the '<em><b>Alt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alt</em>' containment reference.
	 * @see #setAlt(ProtocolCombinatorType)
	 * @see hPE.xml.component.ComponentPackage#getProtocolChoiceType_Alt()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='alt'"
	 * @generated
	 */
	ProtocolCombinatorType getAlt();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolChoiceType#getAlt <em>Alt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alt</em>' containment reference.
	 * @see #getAlt()
	 * @generated
	 */
	void setAlt(ProtocolCombinatorType value);

	/**
	 * Returns the value of the '<em><b>Perform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Perform</em>' containment reference.
	 * @see #setPerform(PerformType)
	 * @see hPE.xml.component.ComponentPackage#getProtocolChoiceType_Perform()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='perform'"
	 * @generated
	 */
	PerformType getPerform();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ProtocolChoiceType#getPerform <em>Perform</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Perform</em>' containment reference.
	 * @see #getPerform()
	 * @generated
	 */
	void setPerform(PerformType value);

} // ProtocolChoiceType
