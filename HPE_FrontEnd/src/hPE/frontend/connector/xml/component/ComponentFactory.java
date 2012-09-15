/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hPE.frontend.connector.xml.component.ComponentPackage
 * @generated
 */
public interface ComponentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentFactory eINSTANCE = hPE.frontend.connector.xml.component.impl.ComponentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Condition Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Type</em>'.
	 * @generated
	 */
	ConditionType createConditionType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Guard Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard Type</em>'.
	 * @generated
	 */
	GuardType createGuardType();

	/**
	 * Returns a new object of class '<em>Hash Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hash Component Type</em>'.
	 * @generated
	 */
	HashComponentType createHashComponentType();

	/**
	 * Returns a new object of class '<em>Hpeaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hpeaction</em>'.
	 * @generated
	 */
	Hpeaction createHpeaction();

	/**
	 * Returns a new object of class '<em>Hpecondition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hpecondition</em>'.
	 * @generated
	 */
	Hpecondition createHpecondition();

	/**
	 * Returns a new object of class '<em>Hpeinner Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hpeinner Component</em>'.
	 * @generated
	 */
	HpeinnerComponent createHpeinnerComponent();

	/**
	 * Returns a new object of class '<em>Hpeparameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hpeparameter</em>'.
	 * @generated
	 */
	Hpeparameter createHpeparameter();

	/**
	 * Returns a new object of class '<em>Hpeparameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hpeparameter Type</em>'.
	 * @generated
	 */
	HpeparameterType createHpeparameterType();

	/**
	 * Returns a new object of class '<em>Hpeslice Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hpeslice Type</em>'.
	 * @generated
	 */
	HpesliceType createHpesliceType();

	/**
	 * Returns a new object of class '<em>Hpetype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hpetype</em>'.
	 * @generated
	 */
	Hpetype createHpetype();

	/**
	 * Returns a new object of class '<em>Protocol Choice Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protocol Choice Type</em>'.
	 * @generated
	 */
	ProtocolChoiceType createProtocolChoiceType();

	/**
	 * Returns a new object of class '<em>Protocol Combinator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protocol Combinator Type</em>'.
	 * @generated
	 */
	ProtocolCombinatorType createProtocolCombinatorType();

	/**
	 * Returns a new object of class '<em>Protocol Perform Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protocol Perform Type</em>'.
	 * @generated
	 */
	ProtocolPerformType createProtocolPerformType();

	/**
	 * Returns a new object of class '<em>Unittype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unittype</em>'.
	 * @generated
	 */
	Unittype createUnittype();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComponentPackage getComponentPackage();

} //ComponentFactory
