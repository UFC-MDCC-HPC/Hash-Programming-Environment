/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.core.locations.locations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.core.locations.locations.CoreType#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.core.locations.locations.LocationsPackage#getCoreType()
 * @model extendedMetaData="name='CoreType' kind='elementOnly'"
 * @generated
 */
public interface CoreType extends EObject {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.core.locations.locations.LocationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference list.
	 * @see hPE.frontend.core.locations.locations.LocationsPackage#getCoreType_Location()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='location' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<LocationType> getLocation();

} // CoreType
