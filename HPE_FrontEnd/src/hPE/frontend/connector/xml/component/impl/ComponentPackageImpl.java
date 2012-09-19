/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.impl;

import hPE.frontend.connector.xml.component.AccessType;
import hPE.frontend.connector.xml.component.ComponentFactory;
import hPE.frontend.connector.xml.component.ComponentPackage;
import hPE.frontend.connector.xml.component.ConditionType;
import hPE.frontend.connector.xml.component.DocumentRoot;
import hPE.frontend.connector.xml.component.GuardType;
import hPE.frontend.connector.xml.component.HashComponentType;
import hPE.frontend.connector.xml.component.Hpeaction;
import hPE.frontend.connector.xml.component.Hpecondition;
import hPE.frontend.connector.xml.component.HpeinnerComponent;
import hPE.frontend.connector.xml.component.Hpekind;
import hPE.frontend.connector.xml.component.Hpeparameter;
import hPE.frontend.connector.xml.component.HpeparameterType;
import hPE.frontend.connector.xml.component.HpesliceType;
import hPE.frontend.connector.xml.component.Hpetype;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.connector.xml.component.ProtocolCombinatorType;
import hPE.frontend.connector.xml.component.ProtocolPerformType;
import hPE.frontend.connector.xml.component.ProtocolType;
import hPE.frontend.connector.xml.component.Unittype;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentPackageImpl extends EPackageImpl implements ComponentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hashComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hpeactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hpeconditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hpeinnerComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hpeparameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hpeparameterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hpesliceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hpetypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protocolChoiceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protocolCombinatorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protocolPerformTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protocolTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unittypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum hpekindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType accessTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hpekindObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComponentPackageImpl() {
		super(eNS_URI, ComponentFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ComponentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComponentPackage init() {
		if (isInited) return (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage(ComponentPackage.eNS_URI);

		// Obtain or create and register package
		ComponentPackageImpl theComponentPackage = (ComponentPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ComponentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ComponentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theComponentPackage.createPackageContents();

		// Initialize created meta-data
		theComponentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComponentPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComponentPackage.eNS_URI, theComponentPackage);
		return theComponentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionType() {
		return conditionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionType_CondId() {
		return (EAttribute)conditionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionType_SliceId() {
		return (EAttribute)conditionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_HashComponent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuardType() {
		return guardTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuardType_Group() {
		return (EAttribute)guardTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuardType_Condition() {
		return (EReference)guardTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuardType_And() {
		return (EReference)guardTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuardType_Or() {
		return (EReference)guardTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuardType_Not() {
		return (EAttribute)guardTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHashComponentType() {
		return hashComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHashComponentType_Package() {
		return (EAttribute)hashComponentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHashComponentType_Using() {
		return (EAttribute)hashComponentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHashComponentType_Kind() {
		return (EAttribute)hashComponentTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHashComponentType_Name() {
		return (EAttribute)hashComponentTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHashComponentType_Parameter() {
		return (EReference)hashComponentTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHashComponentType_InnerComponent() {
		return (EReference)hashComponentTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHashComponentType_SuperComponent() {
		return (EReference)hashComponentTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHashComponentType_Unit() {
		return (EReference)hashComponentTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHpeaction() {
		return hpeactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeaction_Identifier() {
		return (EAttribute)hpeactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHpeaction_Protocol() {
		return (EReference)hpeactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHpecondition() {
		return hpeconditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpecondition_Identifier() {
		return (EAttribute)hpeconditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHpecondition_Guard() {
		return (EReference)hpeconditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHpeinnerComponent() {
		return hpeinnerComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeinnerComponent_Kind() {
		return (EAttribute)hpeinnerComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeinnerComponent_Identifier() {
		return (EAttribute)hpeinnerComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHpeinnerComponent_Type() {
		return (EReference)hpeinnerComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeinnerComponent_Access() {
		return (EAttribute)hpeinnerComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeinnerComponent_ExportActions() {
		return (EAttribute)hpeinnerComponentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHpeparameter() {
		return hpeparameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeparameter_Identifier() {
		return (EAttribute)hpeparameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeparameter_Variable() {
		return (EAttribute)hpeparameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHpeparameter_Constraint() {
		return (EReference)hpeparameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHpeparameterType() {
		return hpeparameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpeparameterType_ComponentConstraint() {
		return (EAttribute)hpeparameterTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHpeparameterType_Parameter() {
		return (EReference)hpeparameterTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHpesliceType() {
		return hpesliceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpesliceType_Index() {
		return (EAttribute)hpesliceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpesliceType_Inner() {
		return (EAttribute)hpesliceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpesliceType_Unit() {
		return (EAttribute)hpesliceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHpetype() {
		return hpetypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpetype_ComponentName() {
		return (EAttribute)hpetypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpetype_PublicInnerComponent() {
		return (EAttribute)hpetypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHpetype_Parameter() {
		return (EReference)hpetypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHpetype_Package() {
		return (EAttribute)hpetypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtocolChoiceType() {
		return protocolChoiceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtocolChoiceType_Par() {
		return (EReference)protocolChoiceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtocolChoiceType_Seq() {
		return (EReference)protocolChoiceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtocolChoiceType_Alt() {
		return (EReference)protocolChoiceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtocolChoiceType_Perform() {
		return (EReference)protocolChoiceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtocolCombinatorType() {
		return protocolCombinatorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtocolCombinatorType_Action() {
		return (EReference)protocolCombinatorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtocolPerformType() {
		return protocolPerformTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtocolPerformType_ActionId() {
		return (EAttribute)protocolPerformTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtocolPerformType_SliceId() {
		return (EAttribute)protocolPerformTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtocolType() {
		return protocolTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtocolType_Guard() {
		return (EReference)protocolTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtocolType_Id() {
		return (EAttribute)protocolTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtocolType_Repeat() {
		return (EAttribute)protocolTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnittype() {
		return unittypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnittype_Slice() {
		return (EReference)unittypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnittype_Action() {
		return (EReference)unittypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnittype_Condition() {
		return (EReference)unittypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnittype_Index() {
		return (EAttribute)unittypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnittype_Name() {
		return (EAttribute)unittypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnittype_Parallel() {
		return (EAttribute)unittypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessType() {
		return accessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHpekind() {
		return hpekindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAccessTypeObject() {
		return accessTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHpekindObject() {
		return hpekindObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentFactory getComponentFactory() {
		return (ComponentFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		conditionTypeEClass = createEClass(CONDITION_TYPE);
		createEAttribute(conditionTypeEClass, CONDITION_TYPE__COND_ID);
		createEAttribute(conditionTypeEClass, CONDITION_TYPE__SLICE_ID);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HASH_COMPONENT);

		guardTypeEClass = createEClass(GUARD_TYPE);
		createEAttribute(guardTypeEClass, GUARD_TYPE__GROUP);
		createEReference(guardTypeEClass, GUARD_TYPE__CONDITION);
		createEReference(guardTypeEClass, GUARD_TYPE__AND);
		createEReference(guardTypeEClass, GUARD_TYPE__OR);
		createEAttribute(guardTypeEClass, GUARD_TYPE__NOT);

		hashComponentTypeEClass = createEClass(HASH_COMPONENT_TYPE);
		createEAttribute(hashComponentTypeEClass, HASH_COMPONENT_TYPE__PACKAGE);
		createEAttribute(hashComponentTypeEClass, HASH_COMPONENT_TYPE__USING);
		createEAttribute(hashComponentTypeEClass, HASH_COMPONENT_TYPE__KIND);
		createEAttribute(hashComponentTypeEClass, HASH_COMPONENT_TYPE__NAME);
		createEReference(hashComponentTypeEClass, HASH_COMPONENT_TYPE__PARAMETER);
		createEReference(hashComponentTypeEClass, HASH_COMPONENT_TYPE__INNER_COMPONENT);
		createEReference(hashComponentTypeEClass, HASH_COMPONENT_TYPE__SUPER_COMPONENT);
		createEReference(hashComponentTypeEClass, HASH_COMPONENT_TYPE__UNIT);

		hpeactionEClass = createEClass(HPEACTION);
		createEAttribute(hpeactionEClass, HPEACTION__IDENTIFIER);
		createEReference(hpeactionEClass, HPEACTION__PROTOCOL);

		hpeconditionEClass = createEClass(HPECONDITION);
		createEAttribute(hpeconditionEClass, HPECONDITION__IDENTIFIER);
		createEReference(hpeconditionEClass, HPECONDITION__GUARD);

		hpeinnerComponentEClass = createEClass(HPEINNER_COMPONENT);
		createEAttribute(hpeinnerComponentEClass, HPEINNER_COMPONENT__KIND);
		createEAttribute(hpeinnerComponentEClass, HPEINNER_COMPONENT__IDENTIFIER);
		createEReference(hpeinnerComponentEClass, HPEINNER_COMPONENT__TYPE);
		createEAttribute(hpeinnerComponentEClass, HPEINNER_COMPONENT__ACCESS);
		createEAttribute(hpeinnerComponentEClass, HPEINNER_COMPONENT__EXPORT_ACTIONS);

		hpeparameterEClass = createEClass(HPEPARAMETER);
		createEAttribute(hpeparameterEClass, HPEPARAMETER__IDENTIFIER);
		createEAttribute(hpeparameterEClass, HPEPARAMETER__VARIABLE);
		createEReference(hpeparameterEClass, HPEPARAMETER__CONSTRAINT);

		hpeparameterTypeEClass = createEClass(HPEPARAMETER_TYPE);
		createEAttribute(hpeparameterTypeEClass, HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT);
		createEReference(hpeparameterTypeEClass, HPEPARAMETER_TYPE__PARAMETER);

		hpesliceTypeEClass = createEClass(HPESLICE_TYPE);
		createEAttribute(hpesliceTypeEClass, HPESLICE_TYPE__INDEX);
		createEAttribute(hpesliceTypeEClass, HPESLICE_TYPE__INNER);
		createEAttribute(hpesliceTypeEClass, HPESLICE_TYPE__UNIT);

		hpetypeEClass = createEClass(HPETYPE);
		createEAttribute(hpetypeEClass, HPETYPE__COMPONENT_NAME);
		createEAttribute(hpetypeEClass, HPETYPE__PUBLIC_INNER_COMPONENT);
		createEReference(hpetypeEClass, HPETYPE__PARAMETER);
		createEAttribute(hpetypeEClass, HPETYPE__PACKAGE);

		protocolChoiceTypeEClass = createEClass(PROTOCOL_CHOICE_TYPE);
		createEReference(protocolChoiceTypeEClass, PROTOCOL_CHOICE_TYPE__PAR);
		createEReference(protocolChoiceTypeEClass, PROTOCOL_CHOICE_TYPE__SEQ);
		createEReference(protocolChoiceTypeEClass, PROTOCOL_CHOICE_TYPE__ALT);
		createEReference(protocolChoiceTypeEClass, PROTOCOL_CHOICE_TYPE__PERFORM);

		protocolCombinatorTypeEClass = createEClass(PROTOCOL_COMBINATOR_TYPE);
		createEReference(protocolCombinatorTypeEClass, PROTOCOL_COMBINATOR_TYPE__ACTION);

		protocolPerformTypeEClass = createEClass(PROTOCOL_PERFORM_TYPE);
		createEAttribute(protocolPerformTypeEClass, PROTOCOL_PERFORM_TYPE__ACTION_ID);
		createEAttribute(protocolPerformTypeEClass, PROTOCOL_PERFORM_TYPE__SLICE_ID);

		protocolTypeEClass = createEClass(PROTOCOL_TYPE);
		createEReference(protocolTypeEClass, PROTOCOL_TYPE__GUARD);
		createEAttribute(protocolTypeEClass, PROTOCOL_TYPE__ID);
		createEAttribute(protocolTypeEClass, PROTOCOL_TYPE__REPEAT);

		unittypeEClass = createEClass(UNITTYPE);
		createEReference(unittypeEClass, UNITTYPE__SLICE);
		createEReference(unittypeEClass, UNITTYPE__ACTION);
		createEReference(unittypeEClass, UNITTYPE__CONDITION);
		createEAttribute(unittypeEClass, UNITTYPE__INDEX);
		createEAttribute(unittypeEClass, UNITTYPE__NAME);
		createEAttribute(unittypeEClass, UNITTYPE__PARALLEL);

		// Create enums
		accessTypeEEnum = createEEnum(ACCESS_TYPE);
		hpekindEEnum = createEEnum(HPEKIND);

		// Create data types
		accessTypeObjectEDataType = createEDataType(ACCESS_TYPE_OBJECT);
		hpekindObjectEDataType = createEDataType(HPEKIND_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		protocolCombinatorTypeEClass.getESuperTypes().add(this.getProtocolType());
		protocolPerformTypeEClass.getESuperTypes().add(this.getProtocolType());

		// Initialize classes and features; add operations and parameters
		initEClass(conditionTypeEClass, ConditionType.class, "ConditionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionType_CondId(), theXMLTypePackage.getString(), "condId", null, 1, 1, ConditionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionType_SliceId(), theXMLTypePackage.getString(), "sliceId", null, 0, 1, ConditionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_HashComponent(), this.getHashComponentType(), null, "hashComponent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(guardTypeEClass, GuardType.class, "GuardType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGuardType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, GuardType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGuardType_Condition(), this.getConditionType(), null, "condition", null, 0, -1, GuardType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getGuardType_And(), this.getGuardType(), null, "and", null, 0, -1, GuardType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getGuardType_Or(), this.getGuardType(), null, "or", null, 0, -1, GuardType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getGuardType_Not(), theXMLTypePackage.getBoolean(), "not", null, 0, 1, GuardType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hashComponentTypeEClass, HashComponentType.class, "HashComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHashComponentType_Package(), theXMLTypePackage.getString(), "package", null, 1, 1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHashComponentType_Using(), theXMLTypePackage.getString(), "using", null, 0, -1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHashComponentType_Kind(), this.getHpekind(), "kind", null, 1, 1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHashComponentType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHashComponentType_Parameter(), this.getHpeparameter(), null, "parameter", null, 0, -1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHashComponentType_InnerComponent(), this.getHpeinnerComponent(), null, "innerComponent", null, 0, -1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHashComponentType_SuperComponent(), this.getHpetype(), null, "superComponent", null, 0, 1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHashComponentType_Unit(), this.getUnittype(), null, "unit", null, 0, -1, HashComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hpeactionEClass, Hpeaction.class, "Hpeaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHpeaction_Identifier(), theXMLTypePackage.getString(), "identifier", null, 1, 1, Hpeaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHpeaction_Protocol(), this.getProtocolChoiceType(), null, "protocol", null, 0, 1, Hpeaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hpeconditionEClass, Hpecondition.class, "Hpecondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHpecondition_Identifier(), theXMLTypePackage.getString(), "identifier", null, 1, 1, Hpecondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHpecondition_Guard(), this.getGuardType(), null, "guard", null, 1, 1, Hpecondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hpeinnerComponentEClass, HpeinnerComponent.class, "HpeinnerComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHpeinnerComponent_Kind(), this.getHpekind(), "kind", null, 1, 1, HpeinnerComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpeinnerComponent_Identifier(), theXMLTypePackage.getString(), "identifier", null, 1, 1, HpeinnerComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHpeinnerComponent_Type(), this.getHpetype(), null, "type", null, 1, 1, HpeinnerComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpeinnerComponent_Access(), this.getAccessType(), "access", null, 1, 1, HpeinnerComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpeinnerComponent_ExportActions(), theXMLTypePackage.getBoolean(), "exportActions", null, 1, 1, HpeinnerComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hpeparameterEClass, Hpeparameter.class, "Hpeparameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHpeparameter_Identifier(), theXMLTypePackage.getString(), "identifier", null, 1, 1, Hpeparameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpeparameter_Variable(), theXMLTypePackage.getString(), "variable", null, 0, 1, Hpeparameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHpeparameter_Constraint(), this.getHpeparameterType(), null, "constraint", null, 1, 1, Hpeparameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hpeparameterTypeEClass, HpeparameterType.class, "HpeparameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHpeparameterType_ComponentConstraint(), theXMLTypePackage.getString(), "componentConstraint", null, 1, 1, HpeparameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHpeparameterType_Parameter(), this.getHpeparameter(), null, "parameter", null, 0, -1, HpeparameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hpesliceTypeEClass, HpesliceType.class, "HpesliceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHpesliceType_Index(), theXMLTypePackage.getInt(), "index", "0", 0, 1, HpesliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpesliceType_Inner(), theXMLTypePackage.getString(), "inner", null, 1, 1, HpesliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpesliceType_Unit(), theXMLTypePackage.getString(), "unit", null, 1, 1, HpesliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hpetypeEClass, Hpetype.class, "Hpetype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHpetype_ComponentName(), theXMLTypePackage.getString(), "componentName", null, 1, 1, Hpetype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpetype_PublicInnerComponent(), theXMLTypePackage.getString(), "publicInnerComponent", null, 0, -1, Hpetype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHpetype_Parameter(), this.getHpeparameter(), null, "parameter", null, 0, -1, Hpetype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHpetype_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, Hpetype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protocolChoiceTypeEClass, ProtocolChoiceType.class, "ProtocolChoiceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtocolChoiceType_Par(), this.getProtocolCombinatorType(), null, "par", null, 0, 1, ProtocolChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtocolChoiceType_Seq(), this.getProtocolCombinatorType(), null, "seq", null, 0, 1, ProtocolChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtocolChoiceType_Alt(), this.getProtocolCombinatorType(), null, "alt", null, 0, 1, ProtocolChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtocolChoiceType_Perform(), this.getProtocolPerformType(), null, "perform", null, 0, 1, ProtocolChoiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protocolCombinatorTypeEClass, ProtocolCombinatorType.class, "ProtocolCombinatorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtocolCombinatorType_Action(), this.getProtocolChoiceType(), null, "action", null, 1, -1, ProtocolCombinatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protocolPerformTypeEClass, ProtocolPerformType.class, "ProtocolPerformType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProtocolPerformType_ActionId(), theXMLTypePackage.getString(), "actionId", null, 0, 1, ProtocolPerformType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtocolPerformType_SliceId(), theXMLTypePackage.getString(), "sliceId", null, 0, 1, ProtocolPerformType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protocolTypeEClass, ProtocolType.class, "ProtocolType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtocolType_Guard(), this.getGuardType(), null, "guard", null, 0, 1, ProtocolType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtocolType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ProtocolType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtocolType_Repeat(), theXMLTypePackage.getBoolean(), "repeat", null, 0, 1, ProtocolType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unittypeEClass, Unittype.class, "Unittype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnittype_Slice(), this.getHpesliceType(), null, "slice", null, 1, -1, Unittype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnittype_Action(), this.getHpeaction(), null, "action", null, 0, -1, Unittype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnittype_Condition(), this.getHpecondition(), null, "condition", null, 0, -1, Unittype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnittype_Index(), theXMLTypePackage.getInt(), "index", null, 0, 1, Unittype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnittype_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Unittype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnittype_Parallel(), theXMLTypePackage.getBoolean(), "parallel", "true", 0, 1, Unittype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(accessTypeEEnum, AccessType.class, "AccessType");
		addEEnumLiteral(accessTypeEEnum, AccessType.PUBLIC);
		addEEnumLiteral(accessTypeEEnum, AccessType.PRIVATE);

		initEEnum(hpekindEEnum, Hpekind.class, "Hpekind");
		addEEnumLiteral(hpekindEEnum, Hpekind.DATA);
		addEEnumLiteral(hpekindEEnum, Hpekind.COMPUTATION);
		addEEnumLiteral(hpekindEEnum, Hpekind.SYNCHRONIZER);
		addEEnumLiteral(hpekindEEnum, Hpekind.PLATFORM);
		addEEnumLiteral(hpekindEEnum, Hpekind.ENVIRONMENT);
		addEEnumLiteral(hpekindEEnum, Hpekind.QUALIFIER);
		addEEnumLiteral(hpekindEEnum, Hpekind.APPLICATION);
		addEEnumLiteral(hpekindEEnum, Hpekind.ENUMERATOR);
		addEEnumLiteral(hpekindEEnum, Hpekind.FACET);
		addEEnumLiteral(hpekindEEnum, Hpekind.DOMAIN);
		addEEnumLiteral(hpekindEEnum, Hpekind.TOPOLOGY);
		addEEnumLiteral(hpekindEEnum, Hpekind.VALUE);

		// Initialize data types
		initEDataType(accessTypeObjectEDataType, AccessType.class, "AccessTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(hpekindObjectEDataType, Hpekind.class, "HpekindObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (accessTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "accessType"
		   });		
		addAnnotation
		  (accessTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "accessType:Object",
			 "baseType", "accessType"
		   });		
		addAnnotation
		  (conditionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ConditionType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getConditionType_CondId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cond_id"
		   });		
		addAnnotation
		  (getConditionType_SliceId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "slice_id"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_HashComponent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "hashComponent",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (guardTypeEClass, 
		   source, 
		   new String[] {
			 "name", "GuardType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGuardType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getGuardType_Condition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "condition",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getGuardType_And(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "and",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getGuardType_Or(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "or",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getGuardType_Not(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "not"
		   });		
		addAnnotation
		  (hashComponentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "hashComponentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHashComponentType_Package(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "package"
		   });		
		addAnnotation
		  (getHashComponentType_Using(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "using"
		   });		
		addAnnotation
		  (getHashComponentType_Kind(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "kind"
		   });		
		addAnnotation
		  (getHashComponentType_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name"
		   });		
		addAnnotation
		  (getHashComponentType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter"
		   });		
		addAnnotation
		  (getHashComponentType_InnerComponent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "innerComponent"
		   });		
		addAnnotation
		  (getHashComponentType_SuperComponent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "superComponent"
		   });		
		addAnnotation
		  (getHashComponentType_Unit(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "unit"
		   });		
		addAnnotation
		  (hpeactionEClass, 
		   source, 
		   new String[] {
			 "name", "hpeaction",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHpeaction_Identifier(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "identifier"
		   });		
		addAnnotation
		  (getHpeaction_Protocol(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "protocol"
		   });		
		addAnnotation
		  (hpeconditionEClass, 
		   source, 
		   new String[] {
			 "name", "hpecondition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHpecondition_Identifier(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "identifier"
		   });		
		addAnnotation
		  (getHpecondition_Guard(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "guard"
		   });		
		addAnnotation
		  (hpeinnerComponentEClass, 
		   source, 
		   new String[] {
			 "name", "hpeinnerComponent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHpeinnerComponent_Kind(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "kind"
		   });		
		addAnnotation
		  (getHpeinnerComponent_Identifier(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "identifier"
		   });		
		addAnnotation
		  (getHpeinnerComponent_Type(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "type"
		   });		
		addAnnotation
		  (getHpeinnerComponent_Access(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "access"
		   });		
		addAnnotation
		  (getHpeinnerComponent_ExportActions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "exportActions"
		   });		
		addAnnotation
		  (hpekindEEnum, 
		   source, 
		   new String[] {
			 "name", "hpekind"
		   });		
		addAnnotation
		  (hpekindObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "hpekind:Object",
			 "baseType", "hpekind"
		   });		
		addAnnotation
		  (hpeparameterEClass, 
		   source, 
		   new String[] {
			 "name", "hpeparameter",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHpeparameter_Identifier(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "identifier"
		   });		
		addAnnotation
		  (getHpeparameter_Variable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variable"
		   });		
		addAnnotation
		  (getHpeparameter_Constraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "constraint"
		   });		
		addAnnotation
		  (hpeparameterTypeEClass, 
		   source, 
		   new String[] {
			 "name", "hpeparameterType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHpeparameterType_ComponentConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "componentConstraint"
		   });		
		addAnnotation
		  (getHpeparameterType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter"
		   });		
		addAnnotation
		  (hpesliceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "hpesliceType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getHpesliceType_Index(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "index"
		   });		
		addAnnotation
		  (getHpesliceType_Inner(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "inner"
		   });		
		addAnnotation
		  (getHpesliceType_Unit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "unit"
		   });		
		addAnnotation
		  (hpetypeEClass, 
		   source, 
		   new String[] {
			 "name", "hpetype",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHpetype_ComponentName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "componentName"
		   });		
		addAnnotation
		  (getHpetype_PublicInnerComponent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "publicInnerComponent"
		   });		
		addAnnotation
		  (getHpetype_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter"
		   });			
		addAnnotation
		  (getHpetype_Package(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "package"
		   });		
		addAnnotation
		  (protocolChoiceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ProtocolChoiceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProtocolChoiceType_Par(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "par"
		   });		
		addAnnotation
		  (getProtocolChoiceType_Seq(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "seq"
		   });		
		addAnnotation
		  (getProtocolChoiceType_Alt(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "alt"
		   });		
		addAnnotation
		  (getProtocolChoiceType_Perform(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "perform"
		   });		
		addAnnotation
		  (protocolCombinatorTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ProtocolCombinatorType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProtocolCombinatorType_Action(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "action"
		   });		
		addAnnotation
		  (protocolPerformTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ProtocolPerformType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProtocolPerformType_ActionId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "action_id"
		   });		
		addAnnotation
		  (getProtocolPerformType_SliceId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "slice_id"
		   });		
		addAnnotation
		  (protocolTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ProtocolType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProtocolType_Guard(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "guard"
		   });		
		addAnnotation
		  (getProtocolType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getProtocolType_Repeat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "repeat"
		   });		
		addAnnotation
		  (unittypeEClass, 
		   source, 
		   new String[] {
			 "name", "unittype",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getUnittype_Slice(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "slice"
		   });		
		addAnnotation
		  (getUnittype_Action(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "action"
		   });		
		addAnnotation
		  (getUnittype_Condition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "condition"
		   });		
		addAnnotation
		  (getUnittype_Index(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "index"
		   });		
		addAnnotation
		  (getUnittype_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getUnittype_Parallel(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parallel"
		   });
	}

} //ComponentPackageImpl
