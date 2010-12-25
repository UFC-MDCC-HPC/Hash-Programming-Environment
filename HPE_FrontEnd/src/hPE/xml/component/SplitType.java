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
 * A representation of the model object '<em><b>Split Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.SplitType#getSplitLink <em>Split Link</em>}</li>
 *   <li>{@link hPE.xml.component.SplitType#getSplitEnumerator <em>Split Enumerator</em>}</li>
 *   <li>{@link hPE.xml.component.SplitType#getOriginRef <em>Origin Ref</em>}</li>
 *   <li>{@link hPE.xml.component.SplitType#getCRefPermutation <em>CRef Permutation</em>}</li>
 *   <li>{@link hPE.xml.component.SplitType#getERef <em>ERef</em>}</li>
 *   <li>{@link hPE.xml.component.SplitType#getN <em>N</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getSplitType()
 * @model extendedMetaData="name='SplitType' kind='elementOnly'"
 * @generated
 */
public interface SplitType extends EObject {
	/**
	 * Returns the value of the '<em><b>Split Link</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.SplitLinkType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Link</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getSplitType_SplitLink()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='splitLink'"
	 * @generated
	 */
	EList<SplitLinkType> getSplitLink();

	/**
	 * Returns the value of the '<em><b>Split Enumerator</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Enumerator</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Enumerator</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getSplitType_SplitEnumerator()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='splitEnumerator'"
	 * @generated
	 */
	EList<String> getSplitEnumerator();

	/**
	 * Returns the value of the '<em><b>Origin Ref</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Ref</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Ref</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getSplitType_OriginRef()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='originRef'"
	 * @generated
	 */
	EList<String> getOriginRef();

	/**
	 * Returns the value of the '<em><b>CRef Permutation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CRef Permutation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CRef Permutation</em>' attribute.
	 * @see #setCRefPermutation(String)
	 * @see hPE.xml.component.ComponentPackage#getSplitType_CRefPermutation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRefPermutation'"
	 * @generated
	 */
	String getCRefPermutation();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SplitType#getCRefPermutation <em>CRef Permutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef Permutation</em>' attribute.
	 * @see #getCRefPermutation()
	 * @generated
	 */
	void setCRefPermutation(String value);

	/**
	 * Returns the value of the '<em><b>ERef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ERef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ERef</em>' attribute.
	 * @see #setERef(String)
	 * @see hPE.xml.component.ComponentPackage#getSplitType_ERef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='eRef'"
	 * @generated
	 */
	String getERef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SplitType#getERef <em>ERef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ERef</em>' attribute.
	 * @see #getERef()
	 * @generated
	 */
	void setERef(String value);

	/**
	 * Returns the value of the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>N</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>N</em>' attribute.
	 * @see #isSetN()
	 * @see #unsetN()
	 * @see #setN(int)
	 * @see hPE.xml.component.ComponentPackage#getSplitType_N()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='n'"
	 * @generated
	 */
	int getN();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SplitType#getN <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N</em>' attribute.
	 * @see #isSetN()
	 * @see #unsetN()
	 * @see #getN()
	 * @generated
	 */
	void setN(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.SplitType#getN <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetN()
	 * @see #getN()
	 * @see #setN(int)
	 * @generated
	 */
	void unsetN();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.SplitType#getN <em>N</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>N</em>' attribute is set.
	 * @see #unsetN()
	 * @see #getN()
	 * @see #setN(int)
	 * @generated
	 */
	boolean isSetN();

} // SplitType
