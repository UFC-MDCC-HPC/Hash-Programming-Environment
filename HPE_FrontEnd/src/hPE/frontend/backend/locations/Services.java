/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.locations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Services</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.backend.locations.Services#getBackend <em>Backend</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.backend.locations.LocationsPackage#getServices()
 * @model extendedMetaData="name='Services' kind='elementOnly'"
 * @generated
 */
public interface Services extends EObject {
	/**
	 * Returns the value of the '<em><b>Backend</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.backend.locations.Location}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backend</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backend</em>' containment reference list.
	 * @see hPE.frontend.backend.locations.LocationsPackage#getServices_Backend()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='backend' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Location> getBackend();

} // Services
