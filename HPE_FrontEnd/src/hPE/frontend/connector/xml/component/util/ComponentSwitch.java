/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.util;

import hPE.frontend.connector.xml.component.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hPE.frontend.connector.xml.component.ComponentPackage
 * @generated
 */
public class ComponentSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComponentPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSwitch() {
		if (modelPackage == null) {
			modelPackage = ComponentPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ComponentPackage.CONDITION_TYPE: {
				ConditionType conditionType = (ConditionType)theEObject;
				T result = caseConditionType(conditionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.GUARD_TYPE: {
				GuardType guardType = (GuardType)theEObject;
				T result = caseGuardType(guardType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HASH_COMPONENT_TYPE: {
				HashComponentType hashComponentType = (HashComponentType)theEObject;
				T result = caseHashComponentType(hashComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HPEACTION: {
				Hpeaction hpeaction = (Hpeaction)theEObject;
				T result = caseHpeaction(hpeaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HPECONDITION: {
				Hpecondition hpecondition = (Hpecondition)theEObject;
				T result = caseHpecondition(hpecondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HPEINNER_COMPONENT: {
				HpeinnerComponent hpeinnerComponent = (HpeinnerComponent)theEObject;
				T result = caseHpeinnerComponent(hpeinnerComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HPEPARAMETER: {
				Hpeparameter hpeparameter = (Hpeparameter)theEObject;
				T result = caseHpeparameter(hpeparameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HPEPARAMETER_TYPE: {
				HpeparameterType hpeparameterType = (HpeparameterType)theEObject;
				T result = caseHpeparameterType(hpeparameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HPESLICE_TYPE: {
				HpesliceType hpesliceType = (HpesliceType)theEObject;
				T result = caseHpesliceType(hpesliceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.HPETYPE: {
				Hpetype hpetype = (Hpetype)theEObject;
				T result = caseHpetype(hpetype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_CHOICE_TYPE: {
				ProtocolChoiceType protocolChoiceType = (ProtocolChoiceType)theEObject;
				T result = caseProtocolChoiceType(protocolChoiceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_COMBINATOR_TYPE: {
				ProtocolCombinatorType protocolCombinatorType = (ProtocolCombinatorType)theEObject;
				T result = caseProtocolCombinatorType(protocolCombinatorType);
				if (result == null) result = caseProtocolType(protocolCombinatorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_PERFORM_TYPE: {
				ProtocolPerformType protocolPerformType = (ProtocolPerformType)theEObject;
				T result = caseProtocolPerformType(protocolPerformType);
				if (result == null) result = caseProtocolType(protocolPerformType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.PROTOCOL_TYPE: {
				ProtocolType protocolType = (ProtocolType)theEObject;
				T result = caseProtocolType(protocolType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentPackage.UNITTYPE: {
				Unittype unittype = (Unittype)theEObject;
				T result = caseUnittype(unittype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionType(ConditionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardType(GuardType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hash Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hash Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHashComponentType(HashComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hpeaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hpeaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHpeaction(Hpeaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hpecondition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hpecondition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHpecondition(Hpecondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hpeinner Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hpeinner Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHpeinnerComponent(HpeinnerComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hpeparameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hpeparameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHpeparameter(Hpeparameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hpeparameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hpeparameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHpeparameterType(HpeparameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hpeslice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hpeslice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHpesliceType(HpesliceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hpetype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hpetype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHpetype(Hpetype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Choice Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Choice Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolChoiceType(ProtocolChoiceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Combinator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Combinator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolCombinatorType(ProtocolCombinatorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Perform Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Perform Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolPerformType(ProtocolPerformType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolType(ProtocolType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unittype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unittype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnittype(Unittype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ComponentSwitch
