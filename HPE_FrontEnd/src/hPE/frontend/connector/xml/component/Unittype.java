/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unittype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.Unittype#getSlice <em>Slice</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.Unittype#getAction <em>Action</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.Unittype#getCondition <em>Condition</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.Unittype#getIndex <em>Index</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.Unittype#getName <em>Name</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.Unittype#isParallel <em>Parallel</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.connector.xml.component.ComponentPackage#getUnittype()
 * @model extendedMetaData="name='unittype' kind='elementOnly'"
 * @generated
 */
public interface Unittype extends EObject {
	/**
	 * Returns the value of the '<em><b>Slice</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.connector.xml.component.HpesliceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice</em>' containment reference list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getUnittype_Slice()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='slice'"
	 * @generated
	 */
	EList<HpesliceType> getSlice();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.connector.xml.component.Hpeaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getUnittype_Action()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='action'"
	 * @generated
	 */
	EList<Hpeaction> getAction();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.connector.xml.component.Hpecondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getUnittype_Condition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='condition'"
	 * @generated
	 */
	EList<Hpecondition> getCondition();

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #setIndex(int)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getUnittype_Index()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='index'"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.Unittype#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.connector.xml.component.Unittype#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
	void unsetIndex();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.connector.xml.component.Unittype#getIndex <em>Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Index</em>' attribute is set.
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
	boolean isSetIndex();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getUnittype_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.Unittype#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parallel</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel</em>' attribute.
	 * @see #isSetParallel()
	 * @see #unsetParallel()
	 * @see #setParallel(boolean)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getUnittype_Parallel()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='parallel'"
	 * @generated
	 */
	boolean isParallel();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.Unittype#isParallel <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parallel</em>' attribute.
	 * @see #isSetParallel()
	 * @see #unsetParallel()
	 * @see #isParallel()
	 * @generated
	 */
	void setParallel(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.connector.xml.component.Unittype#isParallel <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParallel()
	 * @see #isParallel()
	 * @see #setParallel(boolean)
	 * @generated
	 */
	void unsetParallel();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.connector.xml.component.Unittype#isParallel <em>Parallel</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parallel</em>' attribute is set.
	 * @see #unsetParallel()
	 * @see #isParallel()
	 * @see #setParallel(boolean)
	 * @generated
	 */
	boolean isSetParallel();

} // Unittype
