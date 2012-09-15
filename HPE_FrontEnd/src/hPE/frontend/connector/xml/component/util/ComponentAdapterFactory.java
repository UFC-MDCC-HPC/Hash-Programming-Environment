/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.util;

import hPE.frontend.connector.xml.component.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hPE.frontend.connector.xml.component.ComponentPackage
 * @generated
 */
public class ComponentAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComponentPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ComponentPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentSwitch<Adapter> modelSwitch =
		new ComponentSwitch<Adapter>() {
			@Override
			public Adapter caseConditionType(ConditionType object) {
				return createConditionTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseGuardType(GuardType object) {
				return createGuardTypeAdapter();
			}
			@Override
			public Adapter caseHashComponentType(HashComponentType object) {
				return createHashComponentTypeAdapter();
			}
			@Override
			public Adapter caseHpeaction(Hpeaction object) {
				return createHpeactionAdapter();
			}
			@Override
			public Adapter caseHpecondition(Hpecondition object) {
				return createHpeconditionAdapter();
			}
			@Override
			public Adapter caseHpeinnerComponent(HpeinnerComponent object) {
				return createHpeinnerComponentAdapter();
			}
			@Override
			public Adapter caseHpeparameter(Hpeparameter object) {
				return createHpeparameterAdapter();
			}
			@Override
			public Adapter caseHpeparameterType(HpeparameterType object) {
				return createHpeparameterTypeAdapter();
			}
			@Override
			public Adapter caseHpesliceType(HpesliceType object) {
				return createHpesliceTypeAdapter();
			}
			@Override
			public Adapter caseHpetype(Hpetype object) {
				return createHpetypeAdapter();
			}
			@Override
			public Adapter caseProtocolChoiceType(ProtocolChoiceType object) {
				return createProtocolChoiceTypeAdapter();
			}
			@Override
			public Adapter caseProtocolCombinatorType(ProtocolCombinatorType object) {
				return createProtocolCombinatorTypeAdapter();
			}
			@Override
			public Adapter caseProtocolPerformType(ProtocolPerformType object) {
				return createProtocolPerformTypeAdapter();
			}
			@Override
			public Adapter caseProtocolType(ProtocolType object) {
				return createProtocolTypeAdapter();
			}
			@Override
			public Adapter caseUnittype(Unittype object) {
				return createUnittypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.ConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.ConditionType
	 * @generated
	 */
	public Adapter createConditionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.GuardType <em>Guard Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.GuardType
	 * @generated
	 */
	public Adapter createGuardTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.HashComponentType <em>Hash Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.HashComponentType
	 * @generated
	 */
	public Adapter createHashComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.Hpeaction <em>Hpeaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.Hpeaction
	 * @generated
	 */
	public Adapter createHpeactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.Hpecondition <em>Hpecondition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.Hpecondition
	 * @generated
	 */
	public Adapter createHpeconditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.HpeinnerComponent <em>Hpeinner Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.HpeinnerComponent
	 * @generated
	 */
	public Adapter createHpeinnerComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.Hpeparameter <em>Hpeparameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.Hpeparameter
	 * @generated
	 */
	public Adapter createHpeparameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.HpeparameterType <em>Hpeparameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.HpeparameterType
	 * @generated
	 */
	public Adapter createHpeparameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.HpesliceType <em>Hpeslice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.HpesliceType
	 * @generated
	 */
	public Adapter createHpesliceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.Hpetype <em>Hpetype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.Hpetype
	 * @generated
	 */
	public Adapter createHpetypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.ProtocolChoiceType <em>Protocol Choice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.ProtocolChoiceType
	 * @generated
	 */
	public Adapter createProtocolChoiceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.ProtocolCombinatorType <em>Protocol Combinator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.ProtocolCombinatorType
	 * @generated
	 */
	public Adapter createProtocolCombinatorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.ProtocolPerformType <em>Protocol Perform Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.ProtocolPerformType
	 * @generated
	 */
	public Adapter createProtocolPerformTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.ProtocolType <em>Protocol Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.ProtocolType
	 * @generated
	 */
	public Adapter createProtocolTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hPE.frontend.connector.xml.component.Unittype <em>Unittype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hPE.frontend.connector.xml.component.Unittype
	 * @generated
	 */
	public Adapter createUnittypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ComponentAdapterFactory
