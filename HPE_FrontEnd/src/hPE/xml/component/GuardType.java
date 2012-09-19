/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.GuardType#getGroup <em>Group</em>}</li>
 *   <li>{@link hPE.xml.component.GuardType#getCondition <em>Condition</em>}</li>
 *   <li>{@link hPE.xml.component.GuardType#getAnd <em>And</em>}</li>
 *   <li>{@link hPE.xml.component.GuardType#getOr <em>Or</em>}</li>
 *   <li>{@link hPE.xml.component.GuardType#isNot <em>Not</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getGuardType()
 * @model extendedMetaData="name='GuardType' kind='elementOnly'"
 * @generated
 */
public interface GuardType extends EObject {

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getGuardType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ConditionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getGuardType_Condition()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='condition' group='#group:0'"
	 * @generated
	 */
	EList<ConditionType> getCondition();

	/**
	 * Returns the value of the '<em><b>And</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.GuardType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>And</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>And</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getGuardType_And()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='and' group='#group:0'"
	 * @generated
	 */
	EList<GuardType> getAnd();

	/**
	 * Returns the value of the '<em><b>Or</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.GuardType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Or</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Or</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getGuardType_Or()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='or' group='#group:0'"
	 * @generated
	 */
	EList<GuardType> getOr();

	/**
	 * Returns the value of the '<em><b>Not</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not</em>' attribute.
	 * @see #isSetNot()
	 * @see #unsetNot()
	 * @see #setNot(boolean)
	 * @see hPE.xml.component.ComponentPackage#getGuardType_Not()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='not'"
	 * @generated
	 */
	boolean isNot();

	/**
	 * Sets the value of the '{@link hPE.xml.component.GuardType#isNot <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not</em>' attribute.
	 * @see #isSetNot()
	 * @see #unsetNot()
	 * @see #isNot()
	 * @generated
	 */
	void setNot(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.GuardType#isNot <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNot()
	 * @see #isNot()
	 * @see #setNot(boolean)
	 * @generated
	 */
	void unsetNot();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.GuardType#isNot <em>Not</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Not</em>' attribute is set.
	 * @see #unsetNot()
	 * @see #isNot()
	 * @see #setNot(boolean)
	 * @generated
	 */
	boolean isSetNot();
} // GuardType
