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
 * A representation of the model object '<em><b>Fusion Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.FusionType#getCRefs <em>CRefs</em>}</li>
 *   <li>{@link hPE.xml.component.FusionType#getPRef <em>PRef</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getFusionType()
 * @model extendedMetaData="name='FusionType' kind='elementOnly'"
 * @generated
 */
public interface FusionType extends EObject {
	/**
	 * Returns the value of the '<em><b>CRefs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CRefs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CRefs</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getFusionType_CRefs()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='cRefs'"
	 * @generated
	 */
	EList<String> getCRefs();

	/**
	 * Returns the value of the '<em><b>PRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PRef</em>' attribute.
	 * @see #setPRef(String)
	 * @see hPE.xml.component.ComponentPackage#getFusionType_PRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='pRef'"
	 * @generated
	 */
	String getPRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FusionType#getPRef <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PRef</em>' attribute.
	 * @see #getPRef()
	 * @generated
	 */
	void setPRef(String value);

} // FusionType
