/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Composition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ProtocolCompositionType#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getProtocolCompositionType()
 * @model extendedMetaData="name='ProtocolCompositionType' kind='elementOnly'"
 * @generated
 */
public interface ProtocolCompositionType extends ProtocolType {
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
	 * @see hPE.xml.component.ComponentPackage#getProtocolCompositionType_Action()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='action'"
	 * @generated
	 */
	EList<ProtocolChoiceType> getAction();

} // ProtocolCompositionType
