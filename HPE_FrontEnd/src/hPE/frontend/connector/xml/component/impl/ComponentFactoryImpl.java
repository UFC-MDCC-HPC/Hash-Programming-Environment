/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.impl;

import hPE.frontend.connector.xml.component.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentFactoryImpl extends EFactoryImpl implements ComponentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComponentFactory init() {
		try {
			ComponentFactory theComponentFactory = (ComponentFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.example.org/HashComponent"); 
			if (theComponentFactory != null) {
				return theComponentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComponentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComponentPackage.CONDITION_TYPE: return createConditionType();
			case ComponentPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case ComponentPackage.GUARD_TYPE: return createGuardType();
			case ComponentPackage.HASH_COMPONENT_TYPE: return createHashComponentType();
			case ComponentPackage.HPEACTION: return createHpeaction();
			case ComponentPackage.HPECONDITION: return createHpecondition();
			case ComponentPackage.HPEINNER_COMPONENT: return createHpeinnerComponent();
			case ComponentPackage.HPEPARAMETER: return createHpeparameter();
			case ComponentPackage.HPEPARAMETER_TYPE: return createHpeparameterType();
			case ComponentPackage.HPESLICE_TYPE: return createHpesliceType();
			case ComponentPackage.HPETYPE: return createHpetype();
			case ComponentPackage.PROTOCOL_CHOICE_TYPE: return createProtocolChoiceType();
			case ComponentPackage.PROTOCOL_COMBINATOR_TYPE: return createProtocolCombinatorType();
			case ComponentPackage.PROTOCOL_PERFORM_TYPE: return createProtocolPerformType();
			case ComponentPackage.UNITTYPE: return createUnittype();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ComponentPackage.ACCESS_TYPE:
				return createAccessTypeFromString(eDataType, initialValue);
			case ComponentPackage.HPEKIND:
				return createHpekindFromString(eDataType, initialValue);
			case ComponentPackage.ACCESS_TYPE_OBJECT:
				return createAccessTypeObjectFromString(eDataType, initialValue);
			case ComponentPackage.HPEKIND_OBJECT:
				return createHpekindObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ComponentPackage.ACCESS_TYPE:
				return convertAccessTypeToString(eDataType, instanceValue);
			case ComponentPackage.HPEKIND:
				return convertHpekindToString(eDataType, instanceValue);
			case ComponentPackage.ACCESS_TYPE_OBJECT:
				return convertAccessTypeObjectToString(eDataType, instanceValue);
			case ComponentPackage.HPEKIND_OBJECT:
				return convertHpekindObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionType createConditionType() {
		ConditionTypeImpl conditionType = new ConditionTypeImpl();
		return conditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardType createGuardType() {
		GuardTypeImpl guardType = new GuardTypeImpl();
		return guardType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HashComponentType createHashComponentType() {
		HashComponentTypeImpl hashComponentType = new HashComponentTypeImpl();
		return hashComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpeaction createHpeaction() {
		HpeactionImpl hpeaction = new HpeactionImpl();
		return hpeaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpecondition createHpecondition() {
		HpeconditionImpl hpecondition = new HpeconditionImpl();
		return hpecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HpeinnerComponent createHpeinnerComponent() {
		HpeinnerComponentImpl hpeinnerComponent = new HpeinnerComponentImpl();
		return hpeinnerComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpeparameter createHpeparameter() {
		HpeparameterImpl hpeparameter = new HpeparameterImpl();
		return hpeparameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HpeparameterType createHpeparameterType() {
		HpeparameterTypeImpl hpeparameterType = new HpeparameterTypeImpl();
		return hpeparameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HpesliceType createHpesliceType() {
		HpesliceTypeImpl hpesliceType = new HpesliceTypeImpl();
		return hpesliceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpetype createHpetype() {
		HpetypeImpl hpetype = new HpetypeImpl();
		return hpetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolChoiceType createProtocolChoiceType() {
		ProtocolChoiceTypeImpl protocolChoiceType = new ProtocolChoiceTypeImpl();
		return protocolChoiceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolCombinatorType createProtocolCombinatorType() {
		ProtocolCombinatorTypeImpl protocolCombinatorType = new ProtocolCombinatorTypeImpl();
		return protocolCombinatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolPerformType createProtocolPerformType() {
		ProtocolPerformTypeImpl protocolPerformType = new ProtocolPerformTypeImpl();
		return protocolPerformType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unittype createUnittype() {
		UnittypeImpl unittype = new UnittypeImpl();
		return unittype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessType createAccessTypeFromString(EDataType eDataType, String initialValue) {
		AccessType result = AccessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpekind createHpekindFromString(EDataType eDataType, String initialValue) {
		Hpekind result = Hpekind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHpekindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessType createAccessTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createAccessTypeFromString(ComponentPackage.Literals.ACCESS_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAccessTypeToString(ComponentPackage.Literals.ACCESS_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpekind createHpekindObjectFromString(EDataType eDataType, String initialValue) {
		return createHpekindFromString(ComponentPackage.Literals.HPEKIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHpekindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertHpekindToString(ComponentPackage.Literals.HPEKIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPackage getComponentPackage() {
		return (ComponentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComponentPackage getPackage() {
		return ComponentPackage.eINSTANCE;
	}

} //ComponentFactoryImpl
