/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hPE.frontend.backend.environment.EnvironmentPackage
 * @generated
 */
public interface EnvironmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentFactory eINSTANCE = hPE.frontend.backend.environment.impl.EnvironmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Deployed Component Info Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployed Component Info Type</em>'.
	 * @generated
	 */
	DeployedComponentInfoType createDeployedComponentInfoType();

	/**
	 * Returns a new object of class '<em>Deployed Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployed Parameter Type</em>'.
	 * @generated
	 */
	DeployedParameterType createDeployedParameterType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	EnvironmentType createEnvironmentType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EnvironmentPackage getEnvironmentPackage();

} //EnvironmentFactory
