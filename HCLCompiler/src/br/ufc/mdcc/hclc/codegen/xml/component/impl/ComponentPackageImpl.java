/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorAltType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorParType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorSeqType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionSignalType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionSkipType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType;
import br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType;
import br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentFactory;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot;
import br.ufc.mdcc.hclc.codegen.xml.component.EntryType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorFromRecursionType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorRefType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType;
import br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType;
import br.ufc.mdcc.hclc.codegen.xml.component.ExtendsType;
import br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType;
import br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType;
import br.ufc.mdcc.hclc.codegen.xml.component.FusionType;
import br.ufc.mdcc.hclc.codegen.xml.component.FusionsOfReplicatorsType;
import br.ufc.mdcc.hclc.codegen.xml.component.ImplementsType;
import br.ufc.mdcc.hclc.codegen.xml.component.InnerComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterType;
import br.ufc.mdcc.hclc.codegen.xml.component.PortSliceType;
import br.ufc.mdcc.hclc.codegen.xml.component.PortType;
import br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType;
import br.ufc.mdcc.hclc.codegen.xml.component.QuantificationVarType;
import br.ufc.mdcc.hclc.codegen.xml.component.RecursiveEntryType;
import br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType;
import br.ufc.mdcc.hclc.codegen.xml.component.SourceType;
import br.ufc.mdcc.hclc.codegen.xml.component.SplitEnumeratorType;
import br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType;
import br.ufc.mdcc.hclc.codegen.xml.component.SplitType;
import br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitType;
import br.ufc.mdcc.hclc.codegen.xml.component.VersionType;
import br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes;

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
	private EClass actionActivateTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionCombinatorAltTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionCombinatorParTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionCombinatorSeqTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionCombinatorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionSignalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionSkipTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionWaitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseTypeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorComplexTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentBodyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentHeaderTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentInUseTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeEClass = null;

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
	private EClass entryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerableComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerableEntryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerableTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerableUnitSliceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerableUnitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratorFromRecursionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratorRefTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exposePortTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionTypeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fusionOfReplicatorsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fusionsOfReplicatorsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fusionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass innerComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass innerRenamingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceParameterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfacePortTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceRefTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceSliceRefTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceSliceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterRenamingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterSupplyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portSliceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quantificationVarTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recursiveEntryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceFileTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass splitEnumeratorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass splitLinkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass splitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitBoundsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitRefTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitSliceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visualElementAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum quantificationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum supportedKindsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType quantificationTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType supportedKindsObjectEDataType = null;

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
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#eNS_URI
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
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
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
		ComponentPackageImpl theComponentPackage = (ComponentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ComponentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ComponentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theComponentPackage.createPackageContents();

		// Initialize created meta-data
		theComponentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComponentPackage.freeze();

		return theComponentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionActivateType() {
		return actionActivateTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionActivateType_SliceRef() {
		return (EAttribute)actionActivateTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionCombinatorAltType() {
		return actionCombinatorAltTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionCombinatorParType() {
		return actionCombinatorParTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionCombinatorSeqType() {
		return actionCombinatorSeqTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionCombinatorType() {
		return actionCombinatorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionCombinatorType_Group() {
		return (EAttribute)actionCombinatorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionCombinatorType_Action() {
		return (EReference)actionCombinatorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionSignalType() {
		return actionSignalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionSignalType_Semaphore() {
		return (EAttribute)actionSignalTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionSkipType() {
		return actionSkipTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionType() {
		return actionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionType_VisualDescription() {
		return (EReference)actionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionType_Label() {
		return (EAttribute)actionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionType_Repeat() {
		return (EAttribute)actionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionWaitType() {
		return actionWaitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionWaitType_Semaphore() {
		return (EAttribute)actionWaitTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseTypeType() {
		return baseTypeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseTypeType_ExtensionType() {
		return (EReference)baseTypeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseTypeType_Component() {
		return (EReference)baseTypeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorComplexType() {
		return colorComplexTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorComplexType_B() {
		return (EAttribute)colorComplexTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorComplexType_G() {
		return (EAttribute)colorComplexTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorComplexType_R() {
		return (EAttribute)colorComplexTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentBodyType() {
		return componentBodyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentBodyType_Group() {
		return (EAttribute)componentBodyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_InnerComponent() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_Parameter() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_SupplyParameter() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_InnerRenaming() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_Fusion() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_Split() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_RecursiveEntry() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_Interface() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_Unit() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_Enumerator() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentBodyType_FusionsOfReplicators() {
		return (EReference)componentBodyTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentHeaderType() {
		return componentHeaderTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentHeaderType_BaseType() {
		return (EReference)componentHeaderTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentHeaderType_Versions() {
		return (EReference)componentHeaderTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentHeaderType_VisualAttributes() {
		return (EReference)componentHeaderTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentHeaderType_HashComponentUID() {
		return (EAttribute)componentHeaderTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentHeaderType_IsAbstract() {
		return (EAttribute)componentHeaderTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentHeaderType_Kind() {
		return (EAttribute)componentHeaderTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentHeaderType_LocationURI() {
		return (EAttribute)componentHeaderTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentHeaderType_Name() {
		return (EAttribute)componentHeaderTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentHeaderType_PackagePath() {
		return (EAttribute)componentHeaderTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentInUseType() {
		return componentInUseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInUseType_VisualDescription() {
		return (EReference)componentInUseTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInUseType_Parameter() {
		return (EReference)componentInUseTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInUseType_Port() {
		return (EReference)componentInUseTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentInUseType_UnitBounds() {
		return (EReference)componentInUseTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInUseType_HashComponentUID() {
		return (EAttribute)componentInUseTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInUseType_LocalRef() {
		return (EAttribute)componentInUseTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInUseType_Location() {
		return (EAttribute)componentInUseTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInUseType_Name() {
		return (EAttribute)componentInUseTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInUseType_Package() {
		return (EAttribute)componentInUseTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInUseType_ParameterId() {
		return (EAttribute)componentInUseTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentInUseType_Version() {
		return (EAttribute)componentInUseTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentType() {
		return componentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Header() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_ComponentInfo() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(1);
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
	public EReference getDocumentRoot_Component() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_NewAttribute() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryType() {
		return entryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntryType_VisualDescription() {
		return (EReference)entryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerableComponentType() {
		return enumerableComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerableEntryType() {
		return enumerableEntryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableEntryType_CRef() {
		return (EAttribute)enumerableEntryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableEntryType_Index() {
		return (EAttribute)enumerableEntryTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableEntryType_URef() {
		return (EAttribute)enumerableEntryTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerableType() {
		return enumerableTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableType_Ref() {
		return (EAttribute)enumerableTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerableUnitSliceType() {
		return enumerableUnitSliceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableUnitSliceType_CRef() {
		return (EAttribute)enumerableUnitSliceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableUnitSliceType_SplitReplica() {
		return (EAttribute)enumerableUnitSliceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableUnitSliceType_SRef() {
		return (EAttribute)enumerableUnitSliceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerableUnitSliceType_URef() {
		return (EAttribute)enumerableUnitSliceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerableUnitType() {
		return enumerableUnitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeratorFromRecursionType() {
		return enumeratorFromRecursionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratorFromRecursionType_CRef() {
		return (EAttribute)enumeratorFromRecursionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeratorRefType() {
		return enumeratorRefTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratorRefType_CRef() {
		return (EAttribute)enumeratorRefTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeratorType() {
		return enumeratorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratorType_OriginRef() {
		return (EAttribute)enumeratorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeratorType_Links() {
		return (EReference)enumeratorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeratorType_VisualDescription() {
		return (EReference)enumeratorTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeratorType_FromRecursion() {
		return (EReference)enumeratorTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratorType_Cardinality() {
		return (EAttribute)enumeratorTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratorType_FromSplit() {
		return (EAttribute)enumeratorTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratorType_Ref() {
		return (EAttribute)enumeratorTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratorType_VarId() {
		return (EAttribute)enumeratorTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExposePortType() {
		return exposePortTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExposePortType_CRef() {
		return (EAttribute)exposePortTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExposePortType_Exposed() {
		return (EAttribute)exposePortTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExposePortType_PRef() {
		return (EAttribute)exposePortTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsType() {
		return extendsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsType_CRef() {
		return (EAttribute)extendsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionTypeType() {
		return extensionTypeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionTypeType_Implements() {
		return (EAttribute)extensionTypeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionTypeType_Extends() {
		return (EAttribute)extensionTypeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFusionOfReplicatorsType() {
		return fusionOfReplicatorsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFusionOfReplicatorsType_ERef() {
		return (EAttribute)fusionOfReplicatorsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFusionOfReplicatorsType_OriginRef() {
		return (EAttribute)fusionOfReplicatorsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFusionsOfReplicatorsType() {
		return fusionsOfReplicatorsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFusionsOfReplicatorsType_FusionOfReplicators() {
		return (EReference)fusionsOfReplicatorsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFusionType() {
		return fusionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFusionType_CRefs() {
		return (EAttribute)fusionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFusionType_PRef() {
		return (EAttribute)fusionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementsType() {
		return implementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImplementsType_CRef() {
		return (EAttribute)implementsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInnerComponentType() {
		return innerComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInnerComponentType_Exposed() {
		return (EAttribute)innerComponentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInnerRenamingType() {
		return innerRenamingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInnerRenamingType_CNewName() {
		return (EAttribute)innerRenamingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInnerRenamingType_COldName() {
		return (EAttribute)innerRenamingTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInnerRenamingType_CRef() {
		return (EAttribute)innerRenamingTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceParameterType() {
		return interfaceParameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameterType_Iname() {
		return (EAttribute)interfaceParameterTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameterType_Order() {
		return (EAttribute)interfaceParameterTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameterType_Parid() {
		return (EAttribute)interfaceParameterTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameterType_Uname() {
		return (EAttribute)interfaceParameterTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameterType_Varid() {
		return (EAttribute)interfaceParameterTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfacePortType() {
		return interfacePortTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfacePortType_VisualDescription() {
		return (EReference)interfacePortTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfacePortType_Slice() {
		return (EReference)interfacePortTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfacePortType_Name() {
		return (EAttribute)interfacePortTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceRefType() {
		return interfaceRefTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceRefType_CRef() {
		return (EAttribute)interfaceRefTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceRefType_IRef() {
		return (EAttribute)interfaceRefTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceSliceRefType() {
		return interfaceSliceRefTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceSliceRefType_ComponentRef() {
		return (EAttribute)interfaceSliceRefTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceSliceRefType_InterfaceRef() {
		return (EAttribute)interfaceSliceRefTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceSliceRefType_SliceRef() {
		return (EAttribute)interfaceSliceRefTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceSliceType() {
		return interfaceSliceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceSliceType_OriginRef() {
		return (EReference)interfaceSliceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceSliceType_VisualDescription() {
		return (EReference)interfaceSliceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceSliceType_IsRef() {
		return (EAttribute)interfaceSliceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceType() {
		return interfaceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceType_Slice() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceType_Protocol() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceType_Sources() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceType_VisualDescription() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceType_Port() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceType_ExternalReferences() {
		return (EAttribute)interfaceTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceType_Parameter() {
		return (EReference)interfaceTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceType_IRef() {
		return (EAttribute)interfaceTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceType_NArgs() {
		return (EAttribute)interfaceTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterRenaming() {
		return parameterRenamingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterRenaming_FormFieldId() {
		return (EAttribute)parameterRenamingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterRenaming_VarName() {
		return (EAttribute)parameterRenamingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterSupplyType() {
		return parameterSupplyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterSupplyType_CRef() {
		return (EAttribute)parameterSupplyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterSupplyType_VarName() {
		return (EAttribute)parameterSupplyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterType() {
		return parameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterType_ComponentRef() {
		return (EAttribute)parameterTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterType_FormFieldId() {
		return (EAttribute)parameterTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterType_VarName() {
		return (EAttribute)parameterTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortSliceType() {
		return portSliceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortSliceType_PRef() {
		return (EAttribute)portSliceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortSliceType_SRef() {
		return (EAttribute)portSliceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortType() {
		return portTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortType_VisualDescription() {
		return (EReference)portTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortType_Exposed() {
		return (EAttribute)portTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortType_PRef() {
		return (EAttribute)portTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuantificationVarType() {
		return quantificationVarTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuantificationVarType_QType() {
		return (EAttribute)quantificationVarTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuantificationVarType_VarName() {
		return (EAttribute)quantificationVarTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecursiveEntryType() {
		return recursiveEntryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecursiveEntryType_CRef() {
		return (EAttribute)recursiveEntryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceFileType() {
		return sourceFileTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_Dependency() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_ExternalDependency() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_Contents() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_FileType() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_Name() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_SrcType() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_Uri() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileType_VersionId() {
		return (EAttribute)sourceFileTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceType() {
		return sourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceType_File() {
		return (EReference)sourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceType_SourceType() {
		return (EAttribute)sourceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceType_VersionId() {
		return (EAttribute)sourceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSplitEnumeratorType() {
		return splitEnumeratorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitEnumeratorType_ERef() {
		return (EAttribute)splitEnumeratorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSplitLinkType() {
		return splitLinkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitLinkType_CRef() {
		return (EAttribute)splitLinkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitLinkType_URef() {
		return (EAttribute)splitLinkTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSplitType() {
		return splitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSplitType_SplitLink() {
		return (EReference)splitTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitType_SplitEnumerator() {
		return (EAttribute)splitTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitType_OriginRef() {
		return (EAttribute)splitTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitType_CRefPermutation() {
		return (EAttribute)splitTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitType_ERef() {
		return (EAttribute)splitTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplitType_N() {
		return (EAttribute)splitTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitBoundsType() {
		return unitBoundsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitBoundsType_VisualDescription() {
		return (EReference)unitBoundsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitBoundsType_Replica() {
		return (EAttribute)unitBoundsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitBoundsType_URef() {
		return (EAttribute)unitBoundsTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitRefType() {
		return unitRefTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitRefType_CRef() {
		return (EAttribute)unitRefTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitRefType_Replica() {
		return (EAttribute)unitRefTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitRefType_URef() {
		return (EAttribute)unitRefTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitSliceType() {
		return unitSliceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitSliceType_VisualDescription() {
		return (EReference)unitSliceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitSliceType_Port() {
		return (EAttribute)unitSliceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitSliceType_SliceName() {
		return (EAttribute)unitSliceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitSliceType_Transitive() {
		return (EAttribute)unitSliceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitType() {
		return unitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitType_Super() {
		return (EReference)unitTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitType_Slices() {
		return (EReference)unitTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitType_VisualDescription() {
		return (EReference)unitTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitType_IRef() {
		return (EAttribute)unitTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitType_Private() {
		return (EAttribute)unitTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitType_URef() {
		return (EAttribute)unitTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitType_VisibleInterface() {
		return (EAttribute)unitTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionType() {
		return versionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionType_Field1() {
		return (EAttribute)versionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionType_Field2() {
		return (EAttribute)versionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionType_Field3() {
		return (EAttribute)versionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionType_Field4() {
		return (EAttribute)versionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisualElementAttributes() {
		return visualElementAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualElementAttributes_Color() {
		return (EReference)visualElementAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualElementAttributes_H() {
		return (EAttribute)visualElementAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualElementAttributes_W() {
		return (EAttribute)visualElementAttributesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualElementAttributes_X() {
		return (EAttribute)visualElementAttributesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualElementAttributes_Y() {
		return (EAttribute)visualElementAttributesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQuantificationType() {
		return quantificationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSupportedKinds() {
		return supportedKindsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getQuantificationTypeObject() {
		return quantificationTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSupportedKindsObject() {
		return supportedKindsObjectEDataType;
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
		actionActivateTypeEClass = createEClass(ACTION_ACTIVATE_TYPE);
		createEAttribute(actionActivateTypeEClass, ACTION_ACTIVATE_TYPE__SLICE_REF);

		actionCombinatorAltTypeEClass = createEClass(ACTION_COMBINATOR_ALT_TYPE);

		actionCombinatorParTypeEClass = createEClass(ACTION_COMBINATOR_PAR_TYPE);

		actionCombinatorSeqTypeEClass = createEClass(ACTION_COMBINATOR_SEQ_TYPE);

		actionCombinatorTypeEClass = createEClass(ACTION_COMBINATOR_TYPE);
		createEAttribute(actionCombinatorTypeEClass, ACTION_COMBINATOR_TYPE__GROUP);
		createEReference(actionCombinatorTypeEClass, ACTION_COMBINATOR_TYPE__ACTION);

		actionSignalTypeEClass = createEClass(ACTION_SIGNAL_TYPE);
		createEAttribute(actionSignalTypeEClass, ACTION_SIGNAL_TYPE__SEMAPHORE);

		actionSkipTypeEClass = createEClass(ACTION_SKIP_TYPE);

		actionTypeEClass = createEClass(ACTION_TYPE);
		createEReference(actionTypeEClass, ACTION_TYPE__VISUAL_DESCRIPTION);
		createEAttribute(actionTypeEClass, ACTION_TYPE__LABEL);
		createEAttribute(actionTypeEClass, ACTION_TYPE__REPEAT);

		actionWaitTypeEClass = createEClass(ACTION_WAIT_TYPE);
		createEAttribute(actionWaitTypeEClass, ACTION_WAIT_TYPE__SEMAPHORE);

		baseTypeTypeEClass = createEClass(BASE_TYPE_TYPE);
		createEReference(baseTypeTypeEClass, BASE_TYPE_TYPE__EXTENSION_TYPE);
		createEReference(baseTypeTypeEClass, BASE_TYPE_TYPE__COMPONENT);

		colorComplexTypeEClass = createEClass(COLOR_COMPLEX_TYPE);
		createEAttribute(colorComplexTypeEClass, COLOR_COMPLEX_TYPE__B);
		createEAttribute(colorComplexTypeEClass, COLOR_COMPLEX_TYPE__G);
		createEAttribute(colorComplexTypeEClass, COLOR_COMPLEX_TYPE__R);

		componentBodyTypeEClass = createEClass(COMPONENT_BODY_TYPE);
		createEAttribute(componentBodyTypeEClass, COMPONENT_BODY_TYPE__GROUP);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__INNER_COMPONENT);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__PARAMETER);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__SUPPLY_PARAMETER);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__INNER_RENAMING);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__FUSION);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__SPLIT);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__RECURSIVE_ENTRY);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__INTERFACE);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__UNIT);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__ENUMERATOR);
		createEReference(componentBodyTypeEClass, COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS);

		componentHeaderTypeEClass = createEClass(COMPONENT_HEADER_TYPE);
		createEReference(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__BASE_TYPE);
		createEReference(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__VERSIONS);
		createEReference(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES);
		createEAttribute(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID);
		createEAttribute(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__IS_ABSTRACT);
		createEAttribute(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__KIND);
		createEAttribute(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__LOCATION_URI);
		createEAttribute(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__NAME);
		createEAttribute(componentHeaderTypeEClass, COMPONENT_HEADER_TYPE__PACKAGE_PATH);

		componentInUseTypeEClass = createEClass(COMPONENT_IN_USE_TYPE);
		createEReference(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION);
		createEReference(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__PARAMETER);
		createEReference(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__PORT);
		createEReference(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__UNIT_BOUNDS);
		createEAttribute(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID);
		createEAttribute(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__LOCAL_REF);
		createEAttribute(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__LOCATION);
		createEAttribute(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__NAME);
		createEAttribute(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__PACKAGE);
		createEAttribute(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__PARAMETER_ID);
		createEAttribute(componentInUseTypeEClass, COMPONENT_IN_USE_TYPE__VERSION);

		componentTypeEClass = createEClass(COMPONENT_TYPE);
		createEReference(componentTypeEClass, COMPONENT_TYPE__HEADER);
		createEReference(componentTypeEClass, COMPONENT_TYPE__COMPONENT_INFO);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__NEW_ATTRIBUTE);

		entryTypeEClass = createEClass(ENTRY_TYPE);
		createEReference(entryTypeEClass, ENTRY_TYPE__VISUAL_DESCRIPTION);

		enumerableComponentTypeEClass = createEClass(ENUMERABLE_COMPONENT_TYPE);

		enumerableEntryTypeEClass = createEClass(ENUMERABLE_ENTRY_TYPE);
		createEAttribute(enumerableEntryTypeEClass, ENUMERABLE_ENTRY_TYPE__CREF);
		createEAttribute(enumerableEntryTypeEClass, ENUMERABLE_ENTRY_TYPE__INDEX);
		createEAttribute(enumerableEntryTypeEClass, ENUMERABLE_ENTRY_TYPE__UREF);

		enumerableTypeEClass = createEClass(ENUMERABLE_TYPE);
		createEAttribute(enumerableTypeEClass, ENUMERABLE_TYPE__REF);

		enumerableUnitSliceTypeEClass = createEClass(ENUMERABLE_UNIT_SLICE_TYPE);
		createEAttribute(enumerableUnitSliceTypeEClass, ENUMERABLE_UNIT_SLICE_TYPE__CREF);
		createEAttribute(enumerableUnitSliceTypeEClass, ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA);
		createEAttribute(enumerableUnitSliceTypeEClass, ENUMERABLE_UNIT_SLICE_TYPE__SREF);
		createEAttribute(enumerableUnitSliceTypeEClass, ENUMERABLE_UNIT_SLICE_TYPE__UREF);

		enumerableUnitTypeEClass = createEClass(ENUMERABLE_UNIT_TYPE);

		enumeratorFromRecursionTypeEClass = createEClass(ENUMERATOR_FROM_RECURSION_TYPE);
		createEAttribute(enumeratorFromRecursionTypeEClass, ENUMERATOR_FROM_RECURSION_TYPE__CREF);

		enumeratorRefTypeEClass = createEClass(ENUMERATOR_REF_TYPE);
		createEAttribute(enumeratorRefTypeEClass, ENUMERATOR_REF_TYPE__CREF);

		enumeratorTypeEClass = createEClass(ENUMERATOR_TYPE);
		createEAttribute(enumeratorTypeEClass, ENUMERATOR_TYPE__ORIGIN_REF);
		createEReference(enumeratorTypeEClass, ENUMERATOR_TYPE__LINKS);
		createEReference(enumeratorTypeEClass, ENUMERATOR_TYPE__VISUAL_DESCRIPTION);
		createEReference(enumeratorTypeEClass, ENUMERATOR_TYPE__FROM_RECURSION);
		createEAttribute(enumeratorTypeEClass, ENUMERATOR_TYPE__CARDINALITY);
		createEAttribute(enumeratorTypeEClass, ENUMERATOR_TYPE__FROM_SPLIT);
		createEAttribute(enumeratorTypeEClass, ENUMERATOR_TYPE__REF);
		createEAttribute(enumeratorTypeEClass, ENUMERATOR_TYPE__VAR_ID);

		exposePortTypeEClass = createEClass(EXPOSE_PORT_TYPE);
		createEAttribute(exposePortTypeEClass, EXPOSE_PORT_TYPE__CREF);
		createEAttribute(exposePortTypeEClass, EXPOSE_PORT_TYPE__EXPOSED);
		createEAttribute(exposePortTypeEClass, EXPOSE_PORT_TYPE__PREF);

		extendsTypeEClass = createEClass(EXTENDS_TYPE);
		createEAttribute(extendsTypeEClass, EXTENDS_TYPE__CREF);

		extensionTypeTypeEClass = createEClass(EXTENSION_TYPE_TYPE);
		createEAttribute(extensionTypeTypeEClass, EXTENSION_TYPE_TYPE__IMPLEMENTS);
		createEAttribute(extensionTypeTypeEClass, EXTENSION_TYPE_TYPE__EXTENDS);

		fusionOfReplicatorsTypeEClass = createEClass(FUSION_OF_REPLICATORS_TYPE);
		createEAttribute(fusionOfReplicatorsTypeEClass, FUSION_OF_REPLICATORS_TYPE__EREF);
		createEAttribute(fusionOfReplicatorsTypeEClass, FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF);

		fusionsOfReplicatorsTypeEClass = createEClass(FUSIONS_OF_REPLICATORS_TYPE);
		createEReference(fusionsOfReplicatorsTypeEClass, FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS);

		fusionTypeEClass = createEClass(FUSION_TYPE);
		createEAttribute(fusionTypeEClass, FUSION_TYPE__CREFS);
		createEAttribute(fusionTypeEClass, FUSION_TYPE__PREF);

		implementsTypeEClass = createEClass(IMPLEMENTS_TYPE);
		createEAttribute(implementsTypeEClass, IMPLEMENTS_TYPE__CREF);

		innerComponentTypeEClass = createEClass(INNER_COMPONENT_TYPE);
		createEAttribute(innerComponentTypeEClass, INNER_COMPONENT_TYPE__EXPOSED);

		innerRenamingTypeEClass = createEClass(INNER_RENAMING_TYPE);
		createEAttribute(innerRenamingTypeEClass, INNER_RENAMING_TYPE__CNEW_NAME);
		createEAttribute(innerRenamingTypeEClass, INNER_RENAMING_TYPE__COLD_NAME);
		createEAttribute(innerRenamingTypeEClass, INNER_RENAMING_TYPE__CREF);

		interfaceParameterTypeEClass = createEClass(INTERFACE_PARAMETER_TYPE);
		createEAttribute(interfaceParameterTypeEClass, INTERFACE_PARAMETER_TYPE__INAME);
		createEAttribute(interfaceParameterTypeEClass, INTERFACE_PARAMETER_TYPE__ORDER);
		createEAttribute(interfaceParameterTypeEClass, INTERFACE_PARAMETER_TYPE__PARID);
		createEAttribute(interfaceParameterTypeEClass, INTERFACE_PARAMETER_TYPE__UNAME);
		createEAttribute(interfaceParameterTypeEClass, INTERFACE_PARAMETER_TYPE__VARID);

		interfacePortTypeEClass = createEClass(INTERFACE_PORT_TYPE);
		createEReference(interfacePortTypeEClass, INTERFACE_PORT_TYPE__VISUAL_DESCRIPTION);
		createEReference(interfacePortTypeEClass, INTERFACE_PORT_TYPE__SLICE);
		createEAttribute(interfacePortTypeEClass, INTERFACE_PORT_TYPE__NAME);

		interfaceRefTypeEClass = createEClass(INTERFACE_REF_TYPE);
		createEAttribute(interfaceRefTypeEClass, INTERFACE_REF_TYPE__CREF);
		createEAttribute(interfaceRefTypeEClass, INTERFACE_REF_TYPE__IREF);

		interfaceSliceRefTypeEClass = createEClass(INTERFACE_SLICE_REF_TYPE);
		createEAttribute(interfaceSliceRefTypeEClass, INTERFACE_SLICE_REF_TYPE__COMPONENT_REF);
		createEAttribute(interfaceSliceRefTypeEClass, INTERFACE_SLICE_REF_TYPE__INTERFACE_REF);
		createEAttribute(interfaceSliceRefTypeEClass, INTERFACE_SLICE_REF_TYPE__SLICE_REF);

		interfaceSliceTypeEClass = createEClass(INTERFACE_SLICE_TYPE);
		createEReference(interfaceSliceTypeEClass, INTERFACE_SLICE_TYPE__ORIGIN_REF);
		createEReference(interfaceSliceTypeEClass, INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION);
		createEAttribute(interfaceSliceTypeEClass, INTERFACE_SLICE_TYPE__IS_REF);

		interfaceTypeEClass = createEClass(INTERFACE_TYPE);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__SLICE);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__PROTOCOL);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__SOURCES);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__VISUAL_DESCRIPTION);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__PORT);
		createEAttribute(interfaceTypeEClass, INTERFACE_TYPE__EXTERNAL_REFERENCES);
		createEReference(interfaceTypeEClass, INTERFACE_TYPE__PARAMETER);
		createEAttribute(interfaceTypeEClass, INTERFACE_TYPE__IREF);
		createEAttribute(interfaceTypeEClass, INTERFACE_TYPE__NARGS);

		parameterRenamingEClass = createEClass(PARAMETER_RENAMING);
		createEAttribute(parameterRenamingEClass, PARAMETER_RENAMING__FORM_FIELD_ID);
		createEAttribute(parameterRenamingEClass, PARAMETER_RENAMING__VAR_NAME);

		parameterSupplyTypeEClass = createEClass(PARAMETER_SUPPLY_TYPE);
		createEAttribute(parameterSupplyTypeEClass, PARAMETER_SUPPLY_TYPE__CREF);
		createEAttribute(parameterSupplyTypeEClass, PARAMETER_SUPPLY_TYPE__VAR_NAME);

		parameterTypeEClass = createEClass(PARAMETER_TYPE);
		createEAttribute(parameterTypeEClass, PARAMETER_TYPE__COMPONENT_REF);
		createEAttribute(parameterTypeEClass, PARAMETER_TYPE__FORM_FIELD_ID);
		createEAttribute(parameterTypeEClass, PARAMETER_TYPE__VAR_NAME);

		portSliceTypeEClass = createEClass(PORT_SLICE_TYPE);
		createEAttribute(portSliceTypeEClass, PORT_SLICE_TYPE__PREF);
		createEAttribute(portSliceTypeEClass, PORT_SLICE_TYPE__SREF);

		portTypeEClass = createEClass(PORT_TYPE);
		createEReference(portTypeEClass, PORT_TYPE__VISUAL_DESCRIPTION);
		createEAttribute(portTypeEClass, PORT_TYPE__EXPOSED);
		createEAttribute(portTypeEClass, PORT_TYPE__PREF);

		quantificationVarTypeEClass = createEClass(QUANTIFICATION_VAR_TYPE);
		createEAttribute(quantificationVarTypeEClass, QUANTIFICATION_VAR_TYPE__QTYPE);
		createEAttribute(quantificationVarTypeEClass, QUANTIFICATION_VAR_TYPE__VAR_NAME);

		recursiveEntryTypeEClass = createEClass(RECURSIVE_ENTRY_TYPE);
		createEAttribute(recursiveEntryTypeEClass, RECURSIVE_ENTRY_TYPE__CREF);

		sourceFileTypeEClass = createEClass(SOURCE_FILE_TYPE);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__DEPENDENCY);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__CONTENTS);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__FILE_TYPE);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__NAME);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__SRC_TYPE);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__URI);
		createEAttribute(sourceFileTypeEClass, SOURCE_FILE_TYPE__VERSION_ID);

		sourceTypeEClass = createEClass(SOURCE_TYPE);
		createEReference(sourceTypeEClass, SOURCE_TYPE__FILE);
		createEAttribute(sourceTypeEClass, SOURCE_TYPE__SOURCE_TYPE);
		createEAttribute(sourceTypeEClass, SOURCE_TYPE__VERSION_ID);

		splitEnumeratorTypeEClass = createEClass(SPLIT_ENUMERATOR_TYPE);
		createEAttribute(splitEnumeratorTypeEClass, SPLIT_ENUMERATOR_TYPE__EREF);

		splitLinkTypeEClass = createEClass(SPLIT_LINK_TYPE);
		createEAttribute(splitLinkTypeEClass, SPLIT_LINK_TYPE__CREF);
		createEAttribute(splitLinkTypeEClass, SPLIT_LINK_TYPE__UREF);

		splitTypeEClass = createEClass(SPLIT_TYPE);
		createEReference(splitTypeEClass, SPLIT_TYPE__SPLIT_LINK);
		createEAttribute(splitTypeEClass, SPLIT_TYPE__SPLIT_ENUMERATOR);
		createEAttribute(splitTypeEClass, SPLIT_TYPE__ORIGIN_REF);
		createEAttribute(splitTypeEClass, SPLIT_TYPE__CREF_PERMUTATION);
		createEAttribute(splitTypeEClass, SPLIT_TYPE__EREF);
		createEAttribute(splitTypeEClass, SPLIT_TYPE__N);

		unitBoundsTypeEClass = createEClass(UNIT_BOUNDS_TYPE);
		createEReference(unitBoundsTypeEClass, UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION);
		createEAttribute(unitBoundsTypeEClass, UNIT_BOUNDS_TYPE__REPLICA);
		createEAttribute(unitBoundsTypeEClass, UNIT_BOUNDS_TYPE__UREF);

		unitRefTypeEClass = createEClass(UNIT_REF_TYPE);
		createEAttribute(unitRefTypeEClass, UNIT_REF_TYPE__CREF);
		createEAttribute(unitRefTypeEClass, UNIT_REF_TYPE__REPLICA);
		createEAttribute(unitRefTypeEClass, UNIT_REF_TYPE__UREF);

		unitSliceTypeEClass = createEClass(UNIT_SLICE_TYPE);
		createEReference(unitSliceTypeEClass, UNIT_SLICE_TYPE__VISUAL_DESCRIPTION);
		createEAttribute(unitSliceTypeEClass, UNIT_SLICE_TYPE__PORT);
		createEAttribute(unitSliceTypeEClass, UNIT_SLICE_TYPE__SLICE_NAME);
		createEAttribute(unitSliceTypeEClass, UNIT_SLICE_TYPE__TRANSITIVE);

		unitTypeEClass = createEClass(UNIT_TYPE);
		createEReference(unitTypeEClass, UNIT_TYPE__SUPER);
		createEReference(unitTypeEClass, UNIT_TYPE__SLICES);
		createEReference(unitTypeEClass, UNIT_TYPE__VISUAL_DESCRIPTION);
		createEAttribute(unitTypeEClass, UNIT_TYPE__IREF);
		createEAttribute(unitTypeEClass, UNIT_TYPE__PRIVATE);
		createEAttribute(unitTypeEClass, UNIT_TYPE__UREF);
		createEAttribute(unitTypeEClass, UNIT_TYPE__VISIBLE_INTERFACE);

		versionTypeEClass = createEClass(VERSION_TYPE);
		createEAttribute(versionTypeEClass, VERSION_TYPE__FIELD1);
		createEAttribute(versionTypeEClass, VERSION_TYPE__FIELD2);
		createEAttribute(versionTypeEClass, VERSION_TYPE__FIELD3);
		createEAttribute(versionTypeEClass, VERSION_TYPE__FIELD4);

		visualElementAttributesEClass = createEClass(VISUAL_ELEMENT_ATTRIBUTES);
		createEReference(visualElementAttributesEClass, VISUAL_ELEMENT_ATTRIBUTES__COLOR);
		createEAttribute(visualElementAttributesEClass, VISUAL_ELEMENT_ATTRIBUTES__H);
		createEAttribute(visualElementAttributesEClass, VISUAL_ELEMENT_ATTRIBUTES__W);
		createEAttribute(visualElementAttributesEClass, VISUAL_ELEMENT_ATTRIBUTES__X);
		createEAttribute(visualElementAttributesEClass, VISUAL_ELEMENT_ATTRIBUTES__Y);

		// Create enums
		quantificationTypeEEnum = createEEnum(QUANTIFICATION_TYPE);
		supportedKindsEEnum = createEEnum(SUPPORTED_KINDS);

		// Create data types
		quantificationTypeObjectEDataType = createEDataType(QUANTIFICATION_TYPE_OBJECT);
		supportedKindsObjectEDataType = createEDataType(SUPPORTED_KINDS_OBJECT);
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
		actionActivateTypeEClass.getESuperTypes().add(this.getActionType());
		actionCombinatorAltTypeEClass.getESuperTypes().add(this.getActionCombinatorType());
		actionCombinatorParTypeEClass.getESuperTypes().add(this.getActionCombinatorType());
		actionCombinatorSeqTypeEClass.getESuperTypes().add(this.getActionCombinatorType());
		actionCombinatorTypeEClass.getESuperTypes().add(this.getActionType());
		actionSignalTypeEClass.getESuperTypes().add(this.getActionType());
		actionSkipTypeEClass.getESuperTypes().add(this.getActionType());
		actionWaitTypeEClass.getESuperTypes().add(this.getActionType());
		enumerableComponentTypeEClass.getESuperTypes().add(this.getEnumerableType());
		enumerableEntryTypeEClass.getESuperTypes().add(this.getEnumerableType());
		enumerableUnitSliceTypeEClass.getESuperTypes().add(this.getEnumerableType());
		enumerableUnitTypeEClass.getESuperTypes().add(this.getEnumerableType());
		innerComponentTypeEClass.getESuperTypes().add(this.getComponentInUseType());
		unitSliceTypeEClass.getESuperTypes().add(this.getUnitRefType());

		// Initialize classes and features; add operations and parameters
		initEClass(actionActivateTypeEClass, ActionActivateType.class, "ActionActivateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionActivateType_SliceRef(), theXMLTypePackage.getString(), "sliceRef", null, 1, 1, ActionActivateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionCombinatorAltTypeEClass, ActionCombinatorAltType.class, "ActionCombinatorAltType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionCombinatorParTypeEClass, ActionCombinatorParType.class, "ActionCombinatorParType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionCombinatorSeqTypeEClass, ActionCombinatorSeqType.class, "ActionCombinatorSeqType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionCombinatorTypeEClass, ActionCombinatorType.class, "ActionCombinatorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionCombinatorType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ActionCombinatorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionCombinatorType_Action(), this.getActionType(), null, "action", null, 1, -1, ActionCombinatorType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(actionSignalTypeEClass, ActionSignalType.class, "ActionSignalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionSignalType_Semaphore(), theXMLTypePackage.getString(), "semaphore", null, 1, 1, ActionSignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionSkipTypeEClass, ActionSkipType.class, "ActionSkipType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionTypeEClass, ActionType.class, "ActionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionType_Label(), theXMLTypePackage.getString(), "label", null, 0, 1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionType_Repeat(), theXMLTypePackage.getUnsignedInt(), "repeat", null, 0, 1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionWaitTypeEClass, ActionWaitType.class, "ActionWaitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionWaitType_Semaphore(), theXMLTypePackage.getString(), "semaphore", null, 1, 1, ActionWaitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(baseTypeTypeEClass, BaseTypeType.class, "BaseTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBaseTypeType_ExtensionType(), this.getExtensionTypeType(), null, "extensionType", null, 1, 1, BaseTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseTypeType_Component(), this.getComponentInUseType(), null, "component", null, 1, 1, BaseTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorComplexTypeEClass, ColorComplexType.class, "ColorComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorComplexType_B(), theXMLTypePackage.getUnsignedByte(), "b", null, 1, 1, ColorComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorComplexType_G(), theXMLTypePackage.getUnsignedByte(), "g", null, 1, 1, ColorComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorComplexType_R(), theXMLTypePackage.getUnsignedByte(), "r", null, 1, 1, ColorComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentBodyTypeEClass, ComponentBodyType.class, "ComponentBodyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentBodyType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ComponentBodyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_InnerComponent(), this.getInnerComponentType(), null, "innerComponent", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_Parameter(), this.getParameterType(), null, "parameter", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_SupplyParameter(), this.getParameterSupplyType(), null, "supplyParameter", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_InnerRenaming(), this.getInnerRenamingType(), null, "innerRenaming", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_Fusion(), this.getFusionType(), null, "fusion", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_Split(), this.getSplitType(), null, "split", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_RecursiveEntry(), this.getRecursiveEntryType(), null, "recursiveEntry", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_Interface(), this.getInterfaceType(), null, "interface", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_Unit(), this.getUnitType(), null, "unit", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_Enumerator(), this.getEnumeratorType(), null, "enumerator", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentBodyType_FusionsOfReplicators(), this.getFusionsOfReplicatorsType(), null, "fusionsOfReplicators", null, 0, -1, ComponentBodyType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(componentHeaderTypeEClass, ComponentHeaderType.class, "ComponentHeaderType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentHeaderType_BaseType(), this.getBaseTypeType(), null, "baseType", null, 0, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentHeaderType_Versions(), this.getVersionType(), null, "versions", null, 1, -1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentHeaderType_VisualAttributes(), this.getVisualElementAttributes(), null, "visualAttributes", null, 1, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentHeaderType_HashComponentUID(), theXMLTypePackage.getString(), "hashComponentUID", null, 0, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentHeaderType_IsAbstract(), theXMLTypePackage.getBoolean(), "isAbstract", null, 0, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentHeaderType_Kind(), this.getSupportedKinds(), "kind", null, 0, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentHeaderType_LocationURI(), theXMLTypePackage.getAnyURI(), "locationURI", null, 0, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentHeaderType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentHeaderType_PackagePath(), theXMLTypePackage.getAnyURI(), "packagePath", null, 0, 1, ComponentHeaderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentInUseTypeEClass, ComponentInUseType.class, "ComponentInUseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentInUseType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentInUseType_Parameter(), this.getParameterRenaming(), null, "parameter", null, 0, -1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentInUseType_Port(), this.getInnerComponentType(), null, "port", null, 0, -1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentInUseType_UnitBounds(), this.getUnitBoundsType(), null, "unitBounds", null, 0, -1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentInUseType_HashComponentUID(), theXMLTypePackage.getString(), "hashComponentUID", null, 0, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentInUseType_LocalRef(), theXMLTypePackage.getString(), "localRef", null, 0, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentInUseType_Location(), theXMLTypePackage.getAnyURI(), "location", null, 1, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentInUseType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentInUseType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentInUseType_ParameterId(), theXMLTypePackage.getString(), "parameterId", null, 0, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentInUseType_Version(), theXMLTypePackage.getID(), "version", null, 0, 1, ComponentInUseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentTypeEClass, ComponentType.class, "ComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentType_Header(), this.getComponentHeaderType(), null, "header", null, 1, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_ComponentInfo(), this.getComponentBodyType(), null, "componentInfo", null, 1, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Component(), this.getComponentType(), null, "component", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_NewAttribute(), theXMLTypePackage.getString(), "newAttribute", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryTypeEClass, EntryType.class, "EntryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntryType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, EntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerableComponentTypeEClass, EnumerableComponentType.class, "EnumerableComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumerableEntryTypeEClass, EnumerableEntryType.class, "EnumerableEntryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerableEntryType_CRef(), theXMLTypePackage.getString(), "cRef", null, 0, 1, EnumerableEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerableEntryType_Index(), theXMLTypePackage.getInt(), "index", null, 0, 1, EnumerableEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerableEntryType_URef(), theXMLTypePackage.getString(), "uRef", null, 0, 1, EnumerableEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerableTypeEClass, EnumerableType.class, "EnumerableType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerableType_Ref(), theXMLTypePackage.getString(), "ref", null, 1, 1, EnumerableType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerableUnitSliceTypeEClass, EnumerableUnitSliceType.class, "EnumerableUnitSliceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerableUnitSliceType_CRef(), theXMLTypePackage.getString(), "cRef", null, 0, 1, EnumerableUnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerableUnitSliceType_SplitReplica(), theXMLTypePackage.getInt(), "splitReplica", null, 0, 1, EnumerableUnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerableUnitSliceType_SRef(), theXMLTypePackage.getString(), "sRef", null, 0, 1, EnumerableUnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerableUnitSliceType_URef(), theXMLTypePackage.getString(), "uRef", null, 1, 1, EnumerableUnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerableUnitTypeEClass, EnumerableUnitType.class, "EnumerableUnitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumeratorFromRecursionTypeEClass, EnumeratorFromRecursionType.class, "EnumeratorFromRecursionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumeratorFromRecursionType_CRef(), theXMLTypePackage.getString(), "cRef", null, 0, 1, EnumeratorFromRecursionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumeratorRefTypeEClass, EnumeratorRefType.class, "EnumeratorRefType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumeratorRefType_CRef(), theXMLTypePackage.getString(), "cRef", null, 1, 1, EnumeratorRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumeratorTypeEClass, EnumeratorType.class, "EnumeratorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumeratorType_OriginRef(), theXMLTypePackage.getString(), "originRef", null, 0, -1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumeratorType_Links(), this.getEnumerableType(), null, "links", null, 1, -1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumeratorType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumeratorType_FromRecursion(), this.getEnumeratorFromRecursionType(), null, "fromRecursion", null, 0, 1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumeratorType_Cardinality(), theXMLTypePackage.getInt(), "cardinality", null, 0, 1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumeratorType_FromSplit(), theXMLTypePackage.getBoolean(), "fromSplit", null, 1, 1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumeratorType_Ref(), theXMLTypePackage.getString(), "ref", null, 1, 1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumeratorType_VarId(), theXMLTypePackage.getString(), "varId", "*", 0, 1, EnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exposePortTypeEClass, ExposePortType.class, "ExposePortType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExposePortType_CRef(), theXMLTypePackage.getString(), "cRef", null, 0, 1, ExposePortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExposePortType_Exposed(), theXMLTypePackage.getString(), "exposed", null, 0, 1, ExposePortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExposePortType_PRef(), theXMLTypePackage.getString(), "pRef", null, 0, 1, ExposePortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsTypeEClass, ExtendsType.class, "ExtendsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsType_CRef(), theXMLTypePackage.getString(), "cRef", null, 1, 1, ExtendsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensionTypeTypeEClass, ExtensionTypeType.class, "ExtensionTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtensionTypeType_Implements(), theXMLTypePackage.getBoolean(), "implements", null, 0, 1, ExtensionTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtensionTypeType_Extends(), theXMLTypePackage.getBoolean(), "extends", null, 0, 1, ExtensionTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fusionOfReplicatorsTypeEClass, FusionOfReplicatorsType.class, "FusionOfReplicatorsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFusionOfReplicatorsType_ERef(), theXMLTypePackage.getString(), "eRef", null, 1, 1, FusionOfReplicatorsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFusionOfReplicatorsType_OriginRef(), theXMLTypePackage.getString(), "originRef", null, 0, -1, FusionOfReplicatorsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fusionsOfReplicatorsTypeEClass, FusionsOfReplicatorsType.class, "FusionsOfReplicatorsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFusionsOfReplicatorsType_FusionOfReplicators(), this.getFusionOfReplicatorsType(), null, "fusionOfReplicators", null, 1, -1, FusionsOfReplicatorsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fusionTypeEClass, FusionType.class, "FusionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFusionType_CRefs(), theXMLTypePackage.getString(), "cRefs", null, 1, -1, FusionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFusionType_PRef(), theXMLTypePackage.getString(), "pRef", null, 1, 1, FusionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementsTypeEClass, ImplementsType.class, "ImplementsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImplementsType_CRef(), theXMLTypePackage.getString(), "cRef", null, 1, 1, ImplementsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(innerComponentTypeEClass, InnerComponentType.class, "InnerComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInnerComponentType_Exposed(), theXMLTypePackage.getBoolean(), "exposed", null, 0, 1, InnerComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(innerRenamingTypeEClass, InnerRenamingType.class, "InnerRenamingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInnerRenamingType_CNewName(), theXMLTypePackage.getString(), "cNewName", null, 0, 1, InnerRenamingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInnerRenamingType_COldName(), theXMLTypePackage.getString(), "cOldName", null, 0, 1, InnerRenamingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInnerRenamingType_CRef(), theXMLTypePackage.getString(), "cRef", null, 0, 1, InnerRenamingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceParameterTypeEClass, InterfaceParameterType.class, "InterfaceParameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterfaceParameterType_Iname(), theXMLTypePackage.getString(), "iname", null, 0, 1, InterfaceParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceParameterType_Order(), theXMLTypePackage.getInt(), "order", null, 0, 1, InterfaceParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceParameterType_Parid(), theXMLTypePackage.getString(), "parid", null, 0, 1, InterfaceParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceParameterType_Uname(), theXMLTypePackage.getString(), "uname", null, 0, 1, InterfaceParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceParameterType_Varid(), theXMLTypePackage.getString(), "varid", null, 0, 1, InterfaceParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfacePortTypeEClass, InterfacePortType.class, "InterfacePortType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfacePortType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, InterfacePortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfacePortType_Slice(), this.getPortSliceType(), null, "slice", null, 1, -1, InterfacePortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfacePortType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, InterfacePortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceRefTypeEClass, InterfaceRefType.class, "InterfaceRefType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterfaceRefType_CRef(), theXMLTypePackage.getString(), "cRef", null, 1, 1, InterfaceRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceRefType_IRef(), theXMLTypePackage.getString(), "iRef", null, 1, 1, InterfaceRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceSliceRefTypeEClass, InterfaceSliceRefType.class, "InterfaceSliceRefType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterfaceSliceRefType_ComponentRef(), theXMLTypePackage.getString(), "componentRef", "this", 0, 1, InterfaceSliceRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceSliceRefType_InterfaceRef(), theXMLTypePackage.getString(), "interfaceRef", null, 1, 1, InterfaceSliceRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceSliceRefType_SliceRef(), theXMLTypePackage.getString(), "sliceRef", null, 0, 1, InterfaceSliceRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceSliceTypeEClass, InterfaceSliceType.class, "InterfaceSliceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceSliceType_OriginRef(), this.getInterfaceRefType(), null, "originRef", null, 1, 1, InterfaceSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceSliceType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, InterfaceSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceSliceType_IsRef(), theXMLTypePackage.getString(), "isRef", null, 1, 1, InterfaceSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceTypeEClass, InterfaceType.class, "InterfaceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceType_Slice(), this.getInterfaceSliceType(), null, "slice", null, 0, -1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceType_Protocol(), this.getActionType(), null, "protocol", null, 0, 1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceType_Sources(), this.getSourceType(), null, "sources", null, 0, -1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceType_Port(), this.getInterfacePortType(), null, "port", null, 0, -1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceType_ExternalReferences(), theXMLTypePackage.getString(), "externalReferences", null, 0, -1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceType_Parameter(), this.getInterfaceParameterType(), null, "parameter", null, 0, -1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceType_IRef(), theXMLTypePackage.getString(), "iRef", null, 1, 1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceType_NArgs(), theXMLTypePackage.getInt(), "nArgs", null, 0, 1, InterfaceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterRenamingEClass, ParameterRenaming.class, "ParameterRenaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterRenaming_FormFieldId(), theXMLTypePackage.getString(), "formFieldId", null, 1, 1, ParameterRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterRenaming_VarName(), theXMLTypePackage.getString(), "varName", null, 1, 1, ParameterRenaming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterSupplyTypeEClass, ParameterSupplyType.class, "ParameterSupplyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterSupplyType_CRef(), theXMLTypePackage.getString(), "cRef", null, 1, 1, ParameterSupplyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterSupplyType_VarName(), theXMLTypePackage.getString(), "varName", null, 1, 1, ParameterSupplyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterTypeEClass, ParameterType.class, "ParameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterType_ComponentRef(), theXMLTypePackage.getString(), "componentRef", null, 1, 1, ParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterType_FormFieldId(), theXMLTypePackage.getString(), "formFieldId", null, 1, 1, ParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterType_VarName(), theXMLTypePackage.getString(), "varName", null, 0, 1, ParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portSliceTypeEClass, PortSliceType.class, "PortSliceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPortSliceType_PRef(), theXMLTypePackage.getString(), "pRef", null, 0, 1, PortSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortSliceType_SRef(), theXMLTypePackage.getString(), "sRef", null, 0, 1, PortSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portTypeEClass, PortType.class, "PortType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, PortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortType_Exposed(), theXMLTypePackage.getBoolean(), "exposed", null, 0, 1, PortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortType_PRef(), theXMLTypePackage.getString(), "pRef", null, 0, 1, PortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quantificationVarTypeEClass, QuantificationVarType.class, "QuantificationVarType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuantificationVarType_QType(), this.getQuantificationType(), "qType", "Universal", 0, 1, QuantificationVarType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuantificationVarType_VarName(), theXMLTypePackage.getString(), "varName", null, 1, 1, QuantificationVarType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recursiveEntryTypeEClass, RecursiveEntryType.class, "RecursiveEntryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecursiveEntryType_CRef(), theXMLTypePackage.getString(), "cRef", null, 0, 1, RecursiveEntryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceFileTypeEClass, SourceFileType.class, "SourceFileType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceFileType_Dependency(), theXMLTypePackage.getString(), "dependency", null, 0, -1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileType_ExternalDependency(), theXMLTypePackage.getString(), "externalDependency", null, 0, -1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileType_Contents(), theXMLTypePackage.getString(), "contents", null, 0, 1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileType_FileType(), theXMLTypePackage.getString(), "fileType", null, 0, 1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileType_SrcType(), theXMLTypePackage.getString(), "srcType", null, 0, 1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileType_Uri(), theXMLTypePackage.getString(), "uri", null, 0, 1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileType_VersionId(), theXMLTypePackage.getString(), "versionId", null, 0, 1, SourceFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceTypeEClass, SourceType.class, "SourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceType_File(), this.getSourceFileType(), null, "file", null, 1, -1, SourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceType_SourceType(), theXMLTypePackage.getString(), "sourceType", null, 0, 1, SourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceType_VersionId(), theXMLTypePackage.getID(), "versionId", null, 0, 1, SourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(splitEnumeratorTypeEClass, SplitEnumeratorType.class, "SplitEnumeratorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSplitEnumeratorType_ERef(), theXMLTypePackage.getString(), "eRef", null, 1, 1, SplitEnumeratorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(splitLinkTypeEClass, SplitLinkType.class, "SplitLinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSplitLinkType_CRef(), theXMLTypePackage.getString(), "cRef", null, 1, 1, SplitLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplitLinkType_URef(), theXMLTypePackage.getString(), "uRef", null, 1, 1, SplitLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(splitTypeEClass, SplitType.class, "SplitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSplitType_SplitLink(), this.getSplitLinkType(), null, "splitLink", null, 1, -1, SplitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplitType_SplitEnumerator(), theXMLTypePackage.getString(), "splitEnumerator", null, 1, -1, SplitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplitType_OriginRef(), theXMLTypePackage.getString(), "originRef", null, 0, -1, SplitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplitType_CRefPermutation(), theXMLTypePackage.getString(), "cRefPermutation", null, 0, 1, SplitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplitType_ERef(), theXMLTypePackage.getString(), "eRef", null, 1, 1, SplitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplitType_N(), theXMLTypePackage.getInt(), "n", null, 0, 1, SplitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitBoundsTypeEClass, UnitBoundsType.class, "UnitBoundsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitBoundsType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, UnitBoundsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitBoundsType_Replica(), theXMLTypePackage.getUnsignedInt(), "replica", null, 0, 1, UnitBoundsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitBoundsType_URef(), theXMLTypePackage.getString(), "uRef", null, 0, 1, UnitBoundsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitRefTypeEClass, UnitRefType.class, "UnitRefType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitRefType_CRef(), theXMLTypePackage.getString(), "cRef", "this", 0, 1, UnitRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitRefType_Replica(), theXMLTypePackage.getInt(), "replica", "0", 0, 1, UnitRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitRefType_URef(), theXMLTypePackage.getString(), "uRef", null, 1, 1, UnitRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitSliceTypeEClass, UnitSliceType.class, "UnitSliceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitSliceType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, UnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitSliceType_Port(), theXMLTypePackage.getString(), "port", null, 0, -1, UnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitSliceType_SliceName(), theXMLTypePackage.getString(), "sliceName", null, 0, 1, UnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitSliceType_Transitive(), theXMLTypePackage.getBoolean(), "transitive", null, 0, 1, UnitSliceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitTypeEClass, UnitType.class, "UnitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitType_Super(), this.getUnitRefType(), null, "super", null, 0, 1, UnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitType_Slices(), this.getUnitSliceType(), null, "slices", null, 0, -1, UnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitType_VisualDescription(), this.getVisualElementAttributes(), null, "visualDescription", null, 1, 1, UnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitType_IRef(), theXMLTypePackage.getString(), "iRef", null, 1, 1, UnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitType_Private(), theXMLTypePackage.getBoolean(), "private", null, 0, 1, UnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitType_URef(), theXMLTypePackage.getString(), "uRef", null, 1, 1, UnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitType_VisibleInterface(), theXMLTypePackage.getBoolean(), "visibleInterface", "true", 0, 1, UnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionTypeEClass, VersionType.class, "VersionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionType_Field1(), theXMLTypePackage.getInt(), "field1", null, 0, 1, VersionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionType_Field2(), theXMLTypePackage.getInt(), "field2", null, 0, 1, VersionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionType_Field3(), theXMLTypePackage.getInt(), "field3", null, 0, 1, VersionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionType_Field4(), theXMLTypePackage.getInt(), "field4", null, 0, 1, VersionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visualElementAttributesEClass, VisualElementAttributes.class, "VisualElementAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisualElementAttributes_Color(), this.getColorComplexType(), null, "color", null, 0, 1, VisualElementAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualElementAttributes_H(), theXMLTypePackage.getUnsignedInt(), "h", null, 1, 1, VisualElementAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualElementAttributes_W(), theXMLTypePackage.getUnsignedInt(), "w", null, 1, 1, VisualElementAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualElementAttributes_X(), theXMLTypePackage.getUnsignedInt(), "x", null, 1, 1, VisualElementAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualElementAttributes_Y(), theXMLTypePackage.getUnsignedInt(), "y", null, 1, 1, VisualElementAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(quantificationTypeEEnum, QuantificationType.class, "QuantificationType");
		addEEnumLiteral(quantificationTypeEEnum, QuantificationType.UNIVERSAL);
		addEEnumLiteral(quantificationTypeEEnum, QuantificationType.EXISTENTIAL);

		initEEnum(supportedKindsEEnum, SupportedKinds.class, "SupportedKinds");
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.DATA);
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.COMPUTATION);
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.SYNCHRONIZER);
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.ARCHITECTURE);
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.ENVIRONMENT);
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.QUALIFIER);
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.APPLICATION);
		addEEnumLiteral(supportedKindsEEnum, SupportedKinds.ENUMERATOR);

		// Initialize data types
		initEDataType(quantificationTypeObjectEDataType, QuantificationType.class, "QuantificationTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(supportedKindsObjectEDataType, SupportedKinds.class, "SupportedKindsObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
		  (actionActivateTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionActivateType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActionActivateType_SliceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sliceRef"
		   });		
		addAnnotation
		  (actionCombinatorAltTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionCombinatorAltType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (actionCombinatorParTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionCombinatorParType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (actionCombinatorSeqTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionCombinatorSeqType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (actionCombinatorTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionCombinatorType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActionCombinatorType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:3"
		   });		
		addAnnotation
		  (getActionCombinatorType_Action(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "action",
			 "group", "#group:3"
		   });		
		addAnnotation
		  (actionSignalTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionSignalType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActionSignalType_Semaphore(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "semaphore"
		   });		
		addAnnotation
		  (actionSkipTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionSkipType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (actionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActionType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getActionType_Label(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "label"
		   });		
		addAnnotation
		  (getActionType_Repeat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "repeat"
		   });		
		addAnnotation
		  (actionWaitTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ActionWaitType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActionWaitType_Semaphore(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "semaphore"
		   });		
		addAnnotation
		  (baseTypeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "BaseTypeType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBaseTypeType_ExtensionType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extensionType"
		   });		
		addAnnotation
		  (getBaseTypeType_Component(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "component"
		   });		
		addAnnotation
		  (colorComplexTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ColorComplexType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getColorComplexType_B(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "b"
		   });		
		addAnnotation
		  (getColorComplexType_G(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "g"
		   });		
		addAnnotation
		  (getColorComplexType_R(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "r"
		   });			
		addAnnotation
		  (componentBodyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ComponentBodyType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComponentBodyType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_InnerComponent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "innerComponent",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_SupplyParameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "supplyParameter",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_InnerRenaming(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "innerRenaming",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_Fusion(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fusion",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_Split(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "split",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_RecursiveEntry(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "recursiveEntry",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "interface",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_Unit(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "unit",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_Enumerator(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "enumerator",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentBodyType_FusionsOfReplicators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fusionsOfReplicators",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (componentHeaderTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ComponentHeaderType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComponentHeaderType_BaseType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "baseType"
		   });		
		addAnnotation
		  (getComponentHeaderType_Versions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "versions"
		   });		
		addAnnotation
		  (getComponentHeaderType_VisualAttributes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualAttributes"
		   });		
		addAnnotation
		  (getComponentHeaderType_HashComponentUID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "hash_component_UID"
		   });		
		addAnnotation
		  (getComponentHeaderType_IsAbstract(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isAbstract"
		   });		
		addAnnotation
		  (getComponentHeaderType_Kind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "kind"
		   });		
		addAnnotation
		  (getComponentHeaderType_LocationURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "locationURI"
		   });		
		addAnnotation
		  (getComponentHeaderType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getComponentHeaderType_PackagePath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "packagePath"
		   });		
		addAnnotation
		  (componentInUseTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ComponentInUseType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComponentInUseType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getComponentInUseType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter"
		   });		
		addAnnotation
		  (getComponentInUseType_Port(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "port"
		   });		
		addAnnotation
		  (getComponentInUseType_UnitBounds(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "unitBounds"
		   });		
		addAnnotation
		  (getComponentInUseType_HashComponentUID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "hash_component_UID"
		   });		
		addAnnotation
		  (getComponentInUseType_LocalRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "localRef"
		   });		
		addAnnotation
		  (getComponentInUseType_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });		
		addAnnotation
		  (getComponentInUseType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getComponentInUseType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package"
		   });		
		addAnnotation
		  (getComponentInUseType_ParameterId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parameter_id"
		   });		
		addAnnotation
		  (getComponentInUseType_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "version"
		   });		
		addAnnotation
		  (componentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ComponentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComponentType_Header(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "header"
		   });		
		addAnnotation
		  (getComponentType_ComponentInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "componentInfo"
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
		  (getDocumentRoot_Component(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "component",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_NewAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "NewAttribute",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (entryTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EntryType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEntryType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (enumerableComponentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumerableComponentType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (enumerableEntryTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumerableEntryType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEnumerableEntryType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (getEnumerableEntryType_Index(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "index"
		   });		
		addAnnotation
		  (getEnumerableEntryType_URef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uRef"
		   });		
		addAnnotation
		  (enumerableTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumerableType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEnumerableType_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });		
		addAnnotation
		  (enumerableUnitSliceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumerableUnitSliceType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEnumerableUnitSliceType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (getEnumerableUnitSliceType_SplitReplica(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "splitReplica"
		   });		
		addAnnotation
		  (getEnumerableUnitSliceType_SRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sRef"
		   });		
		addAnnotation
		  (getEnumerableUnitSliceType_URef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uRef"
		   });		
		addAnnotation
		  (enumerableUnitTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumerableUnitType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (enumeratorFromRecursionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumeratorFromRecursionType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEnumeratorFromRecursionType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (enumeratorRefTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumeratorRefType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEnumeratorRefType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (enumeratorTypeEClass, 
		   source, 
		   new String[] {
			 "name", "EnumeratorType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEnumeratorType_OriginRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "originRef"
		   });		
		addAnnotation
		  (getEnumeratorType_Links(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "links"
		   });		
		addAnnotation
		  (getEnumeratorType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getEnumeratorType_FromRecursion(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fromRecursion"
		   });		
		addAnnotation
		  (getEnumeratorType_Cardinality(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cardinality"
		   });		
		addAnnotation
		  (getEnumeratorType_FromSplit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fromSplit"
		   });		
		addAnnotation
		  (getEnumeratorType_Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ref"
		   });		
		addAnnotation
		  (getEnumeratorType_VarId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "varId"
		   });		
		addAnnotation
		  (exposePortTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ExposePortType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getExposePortType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (getExposePortType_Exposed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "exposed"
		   });		
		addAnnotation
		  (getExposePortType_PRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pRef"
		   });		
		addAnnotation
		  (extendsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ExtendsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExtendsType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "cRef"
		   });		
		addAnnotation
		  (extensionTypeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ExtensionTypeType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExtensionTypeType_Implements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "implements"
		   });		
		addAnnotation
		  (getExtensionTypeType_Extends(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extends"
		   });		
		addAnnotation
		  (fusionOfReplicatorsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "FusionOfReplicatorsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFusionOfReplicatorsType_ERef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eRef"
		   });		
		addAnnotation
		  (getFusionOfReplicatorsType_OriginRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "originRef"
		   });		
		addAnnotation
		  (fusionsOfReplicatorsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "FusionsOfReplicatorsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFusionsOfReplicatorsType_FusionOfReplicators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fusionOfReplicators"
		   });		
		addAnnotation
		  (fusionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "FusionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFusionType_CRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "cRefs"
		   });		
		addAnnotation
		  (getFusionType_PRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pRef"
		   });		
		addAnnotation
		  (implementsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ImplementsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getImplementsType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "cRef"
		   });		
		addAnnotation
		  (innerComponentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InnerComponentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInnerComponentType_Exposed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "exposed"
		   });		
		addAnnotation
		  (innerRenamingTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InnerRenamingType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getInnerRenamingType_CNewName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cNewName"
		   });		
		addAnnotation
		  (getInnerRenamingType_COldName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cOldName"
		   });		
		addAnnotation
		  (getInnerRenamingType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (interfaceParameterTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceParameterType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getInterfaceParameterType_Iname(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "iname"
		   });		
		addAnnotation
		  (getInterfaceParameterType_Order(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "order"
		   });		
		addAnnotation
		  (getInterfaceParameterType_Parid(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parid"
		   });		
		addAnnotation
		  (getInterfaceParameterType_Uname(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uname"
		   });		
		addAnnotation
		  (getInterfaceParameterType_Varid(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "varid"
		   });		
		addAnnotation
		  (interfacePortTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfacePortType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInterfacePortType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getInterfacePortType_Slice(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "slice"
		   });		
		addAnnotation
		  (getInterfacePortType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (interfaceRefTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceRefType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getInterfaceRefType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (getInterfaceRefType_IRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "iRef"
		   });		
		addAnnotation
		  (interfaceSliceRefTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceSliceRefType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getInterfaceSliceRefType_ComponentRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "componentRef"
		   });		
		addAnnotation
		  (getInterfaceSliceRefType_InterfaceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "interfaceRef"
		   });		
		addAnnotation
		  (getInterfaceSliceRefType_SliceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sliceRef"
		   });		
		addAnnotation
		  (interfaceSliceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceSliceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInterfaceSliceType_OriginRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "originRef"
		   });		
		addAnnotation
		  (getInterfaceSliceType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getInterfaceSliceType_IsRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isRef"
		   });		
		addAnnotation
		  (interfaceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInterfaceType_Slice(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "slice"
		   });		
		addAnnotation
		  (getInterfaceType_Protocol(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "protocol"
		   });		
		addAnnotation
		  (getInterfaceType_Sources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sources"
		   });		
		addAnnotation
		  (getInterfaceType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getInterfaceType_Port(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "port"
		   });		
		addAnnotation
		  (getInterfaceType_ExternalReferences(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "externalReferences"
		   });		
		addAnnotation
		  (getInterfaceType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter"
		   });		
		addAnnotation
		  (getInterfaceType_IRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "iRef"
		   });		
		addAnnotation
		  (getInterfaceType_NArgs(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nArgs"
		   });		
		addAnnotation
		  (parameterRenamingEClass, 
		   source, 
		   new String[] {
			 "name", "ParameterRenaming",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getParameterRenaming_FormFieldId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "formFieldId"
		   });		
		addAnnotation
		  (getParameterRenaming_VarName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "varName"
		   });		
		addAnnotation
		  (parameterSupplyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ParameterSupplyType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getParameterSupplyType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (getParameterSupplyType_VarName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "varName"
		   });		
		addAnnotation
		  (parameterTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ParameterType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getParameterType_ComponentRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "componentRef"
		   });		
		addAnnotation
		  (getParameterType_FormFieldId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "formFieldId"
		   });		
		addAnnotation
		  (getParameterType_VarName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "varName"
		   });		
		addAnnotation
		  (portSliceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PortSliceType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getPortSliceType_PRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pRef"
		   });		
		addAnnotation
		  (getPortSliceType_SRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sRef"
		   });		
		addAnnotation
		  (portTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PortType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPortType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getPortType_Exposed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "exposed"
		   });		
		addAnnotation
		  (getPortType_PRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pRef"
		   });		
		addAnnotation
		  (quantificationTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "QuantificationType"
		   });		
		addAnnotation
		  (quantificationTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "QuantificationType:Object",
			 "baseType", "QuantificationType"
		   });		
		addAnnotation
		  (quantificationVarTypeEClass, 
		   source, 
		   new String[] {
			 "name", "QuantificationVarType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getQuantificationVarType_QType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "qType"
		   });		
		addAnnotation
		  (getQuantificationVarType_VarName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "varName"
		   });		
		addAnnotation
		  (recursiveEntryTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RecursiveEntryType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getRecursiveEntryType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (sourceFileTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SourceFileType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSourceFileType_Dependency(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dependency"
		   });		
		addAnnotation
		  (getSourceFileType_ExternalDependency(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "externalDependency"
		   });		
		addAnnotation
		  (getSourceFileType_Contents(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "contents"
		   });		
		addAnnotation
		  (getSourceFileType_FileType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fileType"
		   });		
		addAnnotation
		  (getSourceFileType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getSourceFileType_SrcType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "srcType"
		   });		
		addAnnotation
		  (getSourceFileType_Uri(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uri"
		   });		
		addAnnotation
		  (getSourceFileType_VersionId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "versionId"
		   });		
		addAnnotation
		  (sourceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SourceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSourceType_File(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "file"
		   });		
		addAnnotation
		  (getSourceType_SourceType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sourceType"
		   });		
		addAnnotation
		  (getSourceType_VersionId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "versionId"
		   });		
		addAnnotation
		  (splitEnumeratorTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SplitEnumeratorType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getSplitEnumeratorType_ERef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "eRef"
		   });		
		addAnnotation
		  (splitLinkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SplitLinkType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getSplitLinkType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (getSplitLinkType_URef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uRef"
		   });		
		addAnnotation
		  (splitTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SplitType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSplitType_SplitLink(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "splitLink"
		   });		
		addAnnotation
		  (getSplitType_SplitEnumerator(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "splitEnumerator"
		   });		
		addAnnotation
		  (getSplitType_OriginRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "originRef"
		   });		
		addAnnotation
		  (getSplitType_CRefPermutation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRefPermutation"
		   });		
		addAnnotation
		  (getSplitType_ERef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "eRef"
		   });		
		addAnnotation
		  (getSplitType_N(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "n"
		   });		
		addAnnotation
		  (supportedKindsEEnum, 
		   source, 
		   new String[] {
			 "name", "SupportedKinds"
		   });		
		addAnnotation
		  (supportedKindsObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "SupportedKinds:Object",
			 "baseType", "SupportedKinds"
		   });		
		addAnnotation
		  (unitBoundsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "UnitBoundsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getUnitBoundsType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getUnitBoundsType_Replica(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "replica"
		   });		
		addAnnotation
		  (getUnitBoundsType_URef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uRef"
		   });		
		addAnnotation
		  (unitRefTypeEClass, 
		   source, 
		   new String[] {
			 "name", "UnitRefType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getUnitRefType_CRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cRef"
		   });		
		addAnnotation
		  (getUnitRefType_Replica(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "replica"
		   });		
		addAnnotation
		  (getUnitRefType_URef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uRef"
		   });		
		addAnnotation
		  (unitSliceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "UnitSliceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getUnitSliceType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getUnitSliceType_Port(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "port"
		   });		
		addAnnotation
		  (getUnitSliceType_SliceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sliceName"
		   });		
		addAnnotation
		  (getUnitSliceType_Transitive(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "transitive"
		   });		
		addAnnotation
		  (unitTypeEClass, 
		   source, 
		   new String[] {
			 "name", "UnitType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getUnitType_Super(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "super"
		   });		
		addAnnotation
		  (getUnitType_Slices(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "slices"
		   });		
		addAnnotation
		  (getUnitType_VisualDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visualDescription"
		   });		
		addAnnotation
		  (getUnitType_IRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "iRef"
		   });		
		addAnnotation
		  (getUnitType_Private(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "private"
		   });		
		addAnnotation
		  (getUnitType_URef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "uRef"
		   });		
		addAnnotation
		  (getUnitType_VisibleInterface(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "visibleInterface"
		   });		
		addAnnotation
		  (versionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "VersionType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getVersionType_Field1(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field1"
		   });		
		addAnnotation
		  (getVersionType_Field2(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field2"
		   });		
		addAnnotation
		  (getVersionType_Field3(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field3"
		   });		
		addAnnotation
		  (getVersionType_Field4(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field4"
		   });		
		addAnnotation
		  (visualElementAttributesEClass, 
		   source, 
		   new String[] {
			 "name", "VisualElementAttributes",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getVisualElementAttributes_Color(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "color"
		   });		
		addAnnotation
		  (getVisualElementAttributes_H(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "h"
		   });		
		addAnnotation
		  (getVisualElementAttributes_W(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "w"
		   });		
		addAnnotation
		  (getVisualElementAttributes_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x"
		   });		
		addAnnotation
		  (getVisualElementAttributes_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y"
		   });
	}

} //ComponentPackageImpl
