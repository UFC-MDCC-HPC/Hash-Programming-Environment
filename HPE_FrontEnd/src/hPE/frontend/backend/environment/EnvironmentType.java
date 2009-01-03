/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.backend.environment.EnvironmentType#getDeployed <em>Deployed</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.backend.environment.EnvironmentPackage#getEnvironmentType()
 * @model extendedMetaData="name='EnvironmentType' kind='elementOnly'"
 * @generated
 */
public interface EnvironmentType extends EObject {
	/**
	 * Returns the value of the '<em><b>Deployed</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.backend.environment.DeployedComponentInfoType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployed</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployed</em>' containment reference list.
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getEnvironmentType_Deployed()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='deployed' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DeployedComponentInfoType> getDeployed();

} // EnvironmentType
