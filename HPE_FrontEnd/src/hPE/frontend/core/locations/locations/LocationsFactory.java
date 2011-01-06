/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.core.locations.locations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hPE.frontend.core.locations.locations.LocationsPackage
 * @generated
 */
public interface LocationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LocationsFactory eINSTANCE = hPE.frontend.core.locations.locations.impl.LocationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Core Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Core Type</em>'.
	 * @generated
	 */
	CoreType createCoreType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Location Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location Type</em>'.
	 * @generated
	 */
	LocationType createLocationType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LocationsPackage getLocationsPackage();

} //LocationsFactory
