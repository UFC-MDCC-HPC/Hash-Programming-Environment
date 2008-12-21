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
 * A representation of the model object '<em><b>Enumerator Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.EnumeratorType#getOriginRef <em>Origin Ref</em>}</li>
 *   <li>{@link hPE.xml.component.EnumeratorType#getLinks <em>Links</em>}</li>
 *   <li>{@link hPE.xml.component.EnumeratorType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.EnumeratorType#getFromRecursion <em>From Recursion</em>}</li>
 *   <li>{@link hPE.xml.component.EnumeratorType#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link hPE.xml.component.EnumeratorType#isFromSplit <em>From Split</em>}</li>
 *   <li>{@link hPE.xml.component.EnumeratorType#getRef <em>Ref</em>}</li>
 *   <li>{@link hPE.xml.component.EnumeratorType#getVarId <em>Var Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getEnumeratorType()
 * @model extendedMetaData="name='EnumeratorType' kind='elementOnly'"
 * @generated
 */
public interface EnumeratorType extends EObject {
	/**
	 * Returns the value of the '<em><b>Origin Ref</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Ref</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_OriginRef()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='originRef'"
	 * @generated
	 */
	EList<String> getOriginRef();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.EnumerableType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_Links()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='links'"
	 * @generated
	 */
	EList<EnumerableType> getLinks();

	/**
	 * Returns the value of the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual Description</em>' containment reference.
	 * @see #setVisualDescription(VisualElementAttributes)
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumeratorType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>From Recursion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Recursion</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Recursion</em>' containment reference.
	 * @see #setFromRecursion(EnumeratorFromRecursionType)
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_FromRecursion()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='fromRecursion'"
	 * @generated
	 */
	EnumeratorFromRecursionType getFromRecursion();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumeratorType#getFromRecursion <em>From Recursion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Recursion</em>' containment reference.
	 * @see #getFromRecursion()
	 * @generated
	 */
	void setFromRecursion(EnumeratorFromRecursionType value);

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #isSetCardinality()
	 * @see #unsetCardinality()
	 * @see #setCardinality(int)
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_Cardinality()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='cardinality'"
	 * @generated
	 */
	int getCardinality();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumeratorType#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #isSetCardinality()
	 * @see #unsetCardinality()
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.EnumeratorType#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCardinality()
	 * @see #getCardinality()
	 * @see #setCardinality(int)
	 * @generated
	 */
	void unsetCardinality();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.EnumeratorType#getCardinality <em>Cardinality</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cardinality</em>' attribute is set.
	 * @see #unsetCardinality()
	 * @see #getCardinality()
	 * @see #setCardinality(int)
	 * @generated
	 */
	boolean isSetCardinality();

	/**
	 * Returns the value of the '<em><b>From Split</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Split</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Split</em>' attribute.
	 * @see #isSetFromSplit()
	 * @see #unsetFromSplit()
	 * @see #setFromSplit(boolean)
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_FromSplit()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='fromSplit'"
	 * @generated
	 */
	boolean isFromSplit();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumeratorType#isFromSplit <em>From Split</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Split</em>' attribute.
	 * @see #isSetFromSplit()
	 * @see #unsetFromSplit()
	 * @see #isFromSplit()
	 * @generated
	 */
	void setFromSplit(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.EnumeratorType#isFromSplit <em>From Split</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFromSplit()
	 * @see #isFromSplit()
	 * @see #setFromSplit(boolean)
	 * @generated
	 */
	void unsetFromSplit();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.EnumeratorType#isFromSplit <em>From Split</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>From Split</em>' attribute is set.
	 * @see #unsetFromSplit()
	 * @see #isFromSplit()
	 * @see #setFromSplit(boolean)
	 * @generated
	 */
	boolean isSetFromSplit();

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_Ref()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='ref'"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumeratorType#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the value of the '<em><b>Var Id</b></em>' attribute.
	 * The default value is <code>"*"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Id</em>' attribute.
	 * @see #isSetVarId()
	 * @see #unsetVarId()
	 * @see #setVarId(String)
	 * @see hPE.xml.component.ComponentPackage#getEnumeratorType_VarId()
	 * @model default="*" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='varId'"
	 * @generated
	 */
	String getVarId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumeratorType#getVarId <em>Var Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Id</em>' attribute.
	 * @see #isSetVarId()
	 * @see #unsetVarId()
	 * @see #getVarId()
	 * @generated
	 */
	void setVarId(String value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.EnumeratorType#getVarId <em>Var Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVarId()
	 * @see #getVarId()
	 * @see #setVarId(String)
	 * @generated
	 */
	void unsetVarId();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.EnumeratorType#getVarId <em>Var Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Var Id</em>' attribute is set.
	 * @see #unsetVarId()
	 * @see #getVarId()
	 * @see #setVarId(String)
	 * @generated
	 */
	boolean isSetVarId();

} // EnumeratorType
