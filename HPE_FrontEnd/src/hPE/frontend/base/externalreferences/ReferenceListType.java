/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.base.externalreferences;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference List Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.base.externalreferences.ReferenceListType#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.base.externalreferences.ExternalreferencesPackage#getReferenceListType()
 * @model extendedMetaData="name='ReferenceListType' kind='elementOnly'"
 * @generated
 */
public interface ReferenceListType extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.base.externalreferences.ReferenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' containment reference list.
	 * @see hPE.frontend.base.externalreferences.ExternalreferencesPackage#getReferenceListType_Reference()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='reference' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ReferenceType> getReference();

} // ReferenceListType
