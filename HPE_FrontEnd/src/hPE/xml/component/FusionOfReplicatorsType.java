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
 * A representation of the model object '<em><b>Fusion Of Replicators Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.FusionOfReplicatorsType#getERef <em>ERef</em>}</li>
 *   <li>{@link hPE.xml.component.FusionOfReplicatorsType#getOriginRef <em>Origin Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getFusionOfReplicatorsType()
 * @model extendedMetaData="name='FusionOfReplicatorsType' kind='elementOnly'"
 * @generated
 */
public interface FusionOfReplicatorsType extends EObject {
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
	 * @see hPE.xml.component.ComponentPackage#getFusionOfReplicatorsType_ERef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='eRef'"
	 * @generated
	 */
	String getERef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FusionOfReplicatorsType#getERef <em>ERef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ERef</em>' attribute.
	 * @see #getERef()
	 * @generated
	 */
	void setERef(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getFusionOfReplicatorsType_OriginRef()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='originRef'"
	 * @generated
	 */
	EList<String> getOriginRef();

} // FusionOfReplicatorsType
