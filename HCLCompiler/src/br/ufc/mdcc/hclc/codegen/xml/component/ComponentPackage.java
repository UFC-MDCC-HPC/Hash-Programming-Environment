/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "component";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/HashComponent";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "component";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentPackage eINSTANCE = br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl.init();

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionTypeImpl <em>Action Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionType()
	 * @generated
	 */
	int ACTION_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__VISUAL_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__LABEL = 1;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__REPEAT = 2;

	/**
	 * The number of structural features of the '<em>Action Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionActivateTypeImpl <em>Action Activate Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionActivateTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionActivateType()
	 * @generated
	 */
	int ACTION_ACTIVATE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ACTIVATE_TYPE__VISUAL_DESCRIPTION = ACTION_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ACTIVATE_TYPE__LABEL = ACTION_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ACTIVATE_TYPE__REPEAT = ACTION_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Slice Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ACTIVATE_TYPE__SLICE_REF = ACTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Activate Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_ACTIVATE_TYPE_FEATURE_COUNT = ACTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorTypeImpl <em>Action Combinator Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorType()
	 * @generated
	 */
	int ACTION_COMBINATOR_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_TYPE__VISUAL_DESCRIPTION = ACTION_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_TYPE__LABEL = ACTION_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_TYPE__REPEAT = ACTION_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_TYPE__GROUP = ACTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_TYPE__ACTION = ACTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action Combinator Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_TYPE_FEATURE_COUNT = ACTION_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorAltTypeImpl <em>Action Combinator Alt Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorAltTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorAltType()
	 * @generated
	 */
	int ACTION_COMBINATOR_ALT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_ALT_TYPE__VISUAL_DESCRIPTION = ACTION_COMBINATOR_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_ALT_TYPE__LABEL = ACTION_COMBINATOR_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_ALT_TYPE__REPEAT = ACTION_COMBINATOR_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_ALT_TYPE__GROUP = ACTION_COMBINATOR_TYPE__GROUP;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_ALT_TYPE__ACTION = ACTION_COMBINATOR_TYPE__ACTION;

	/**
	 * The number of structural features of the '<em>Action Combinator Alt Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_ALT_TYPE_FEATURE_COUNT = ACTION_COMBINATOR_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorParTypeImpl <em>Action Combinator Par Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorParTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorParType()
	 * @generated
	 */
	int ACTION_COMBINATOR_PAR_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_PAR_TYPE__VISUAL_DESCRIPTION = ACTION_COMBINATOR_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_PAR_TYPE__LABEL = ACTION_COMBINATOR_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_PAR_TYPE__REPEAT = ACTION_COMBINATOR_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_PAR_TYPE__GROUP = ACTION_COMBINATOR_TYPE__GROUP;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_PAR_TYPE__ACTION = ACTION_COMBINATOR_TYPE__ACTION;

	/**
	 * The number of structural features of the '<em>Action Combinator Par Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_PAR_TYPE_FEATURE_COUNT = ACTION_COMBINATOR_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorSeqTypeImpl <em>Action Combinator Seq Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorSeqTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorSeqType()
	 * @generated
	 */
	int ACTION_COMBINATOR_SEQ_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_SEQ_TYPE__VISUAL_DESCRIPTION = ACTION_COMBINATOR_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_SEQ_TYPE__LABEL = ACTION_COMBINATOR_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_SEQ_TYPE__REPEAT = ACTION_COMBINATOR_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_SEQ_TYPE__GROUP = ACTION_COMBINATOR_TYPE__GROUP;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_SEQ_TYPE__ACTION = ACTION_COMBINATOR_TYPE__ACTION;

	/**
	 * The number of structural features of the '<em>Action Combinator Seq Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_COMBINATOR_SEQ_TYPE_FEATURE_COUNT = ACTION_COMBINATOR_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSignalTypeImpl <em>Action Signal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSignalTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionSignalType()
	 * @generated
	 */
	int ACTION_SIGNAL_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SIGNAL_TYPE__VISUAL_DESCRIPTION = ACTION_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SIGNAL_TYPE__LABEL = ACTION_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SIGNAL_TYPE__REPEAT = ACTION_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Semaphore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SIGNAL_TYPE__SEMAPHORE = ACTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Signal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SIGNAL_TYPE_FEATURE_COUNT = ACTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSkipTypeImpl <em>Action Skip Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSkipTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionSkipType()
	 * @generated
	 */
	int ACTION_SKIP_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SKIP_TYPE__VISUAL_DESCRIPTION = ACTION_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SKIP_TYPE__LABEL = ACTION_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SKIP_TYPE__REPEAT = ACTION_TYPE__REPEAT;

	/**
	 * The number of structural features of the '<em>Action Skip Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_SKIP_TYPE_FEATURE_COUNT = ACTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionWaitTypeImpl <em>Action Wait Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionWaitTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionWaitType()
	 * @generated
	 */
	int ACTION_WAIT_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_WAIT_TYPE__VISUAL_DESCRIPTION = ACTION_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_WAIT_TYPE__LABEL = ACTION_TYPE__LABEL;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_WAIT_TYPE__REPEAT = ACTION_TYPE__REPEAT;

	/**
	 * The feature id for the '<em><b>Semaphore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_WAIT_TYPE__SEMAPHORE = ACTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Wait Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_WAIT_TYPE_FEATURE_COUNT = ACTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.BaseTypeTypeImpl <em>Base Type Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.BaseTypeTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getBaseTypeType()
	 * @generated
	 */
	int BASE_TYPE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Extension Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_TYPE__EXTENSION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_TYPE__COMPONENT = 1;

	/**
	 * The number of structural features of the '<em>Base Type Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_TYPE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ColorComplexTypeImpl <em>Color Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ColorComplexTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getColorComplexType()
	 * @generated
	 */
	int COLOR_COMPLEX_TYPE = 10;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_COMPLEX_TYPE__B = 0;

	/**
	 * The feature id for the '<em><b>G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_COMPLEX_TYPE__G = 1;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_COMPLEX_TYPE__R = 2;

	/**
	 * The number of structural features of the '<em>Color Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_COMPLEX_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentBodyTypeImpl <em>Body Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentBodyTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentBodyType()
	 * @generated
	 */
	int COMPONENT_BODY_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Inner Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__INNER_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Supply Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__SUPPLY_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Inner Renaming</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__INNER_RENAMING = 4;

	/**
	 * The feature id for the '<em><b>Fusion</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__FUSION = 5;

	/**
	 * The feature id for the '<em><b>Split</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__SPLIT = 6;

	/**
	 * The feature id for the '<em><b>Recursive Entry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__RECURSIVE_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__INTERFACE = 8;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__UNIT = 9;

	/**
	 * The feature id for the '<em><b>Enumerator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__ENUMERATOR = 10;

	/**
	 * The feature id for the '<em><b>Fusions Of Replicators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS = 11;

	/**
	 * The number of structural features of the '<em>Body Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BODY_TYPE_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentHeaderTypeImpl <em>Header Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentHeaderTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentHeaderType()
	 * @generated
	 */
	int COMPONENT_HEADER_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__BASE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__VERSIONS = 1;

	/**
	 * The feature id for the '<em><b>Visual Attributes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES = 2;

	/**
	 * The feature id for the '<em><b>Hash Component UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID = 3;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__IS_ABSTRACT = 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__KIND = 5;

	/**
	 * The feature id for the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__LOCATION_URI = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__NAME = 7;

	/**
	 * The feature id for the '<em><b>Package Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE__PACKAGE_PATH = 8;

	/**
	 * The number of structural features of the '<em>Header Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_HEADER_TYPE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl <em>In Use Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentInUseType()
	 * @generated
	 */
	int COMPONENT_IN_USE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__PORT = 2;

	/**
	 * The feature id for the '<em><b>Unit Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__UNIT_BOUNDS = 3;

	/**
	 * The feature id for the '<em><b>Hash Component UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID = 4;

	/**
	 * The feature id for the '<em><b>Local Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__LOCAL_REF = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__LOCATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__NAME = 7;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__PACKAGE = 8;

	/**
	 * The feature id for the '<em><b>Parameter Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__PARAMETER_ID = 9;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE__VERSION = 10;

	/**
	 * The number of structural features of the '<em>In Use Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_IN_USE_TYPE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__HEADER = 0;

	/**
	 * The feature id for the '<em><b>Component Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__COMPONENT_INFO = 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.DocumentRootImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 15;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>New Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NEW_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EntryTypeImpl <em>Entry Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EntryTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEntryType()
	 * @generated
	 */
	int ENTRY_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_TYPE__VISUAL_DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Entry Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableTypeImpl <em>Enumerable Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableType()
	 * @generated
	 */
	int ENUMERABLE_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_TYPE__REF = 0;

	/**
	 * The number of structural features of the '<em>Enumerable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableComponentTypeImpl <em>Enumerable Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableComponentTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableComponentType()
	 * @generated
	 */
	int ENUMERABLE_COMPONENT_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_COMPONENT_TYPE__REF = ENUMERABLE_TYPE__REF;

	/**
	 * The number of structural features of the '<em>Enumerable Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_COMPONENT_TYPE_FEATURE_COUNT = ENUMERABLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableEntryTypeImpl <em>Enumerable Entry Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableEntryTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableEntryType()
	 * @generated
	 */
	int ENUMERABLE_ENTRY_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_ENTRY_TYPE__REF = ENUMERABLE_TYPE__REF;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_ENTRY_TYPE__CREF = ENUMERABLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_ENTRY_TYPE__INDEX = ENUMERABLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_ENTRY_TYPE__UREF = ENUMERABLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enumerable Entry Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_ENTRY_TYPE_FEATURE_COUNT = ENUMERABLE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitSliceTypeImpl <em>Enumerable Unit Slice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitSliceTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableUnitSliceType()
	 * @generated
	 */
	int ENUMERABLE_UNIT_SLICE_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_SLICE_TYPE__REF = ENUMERABLE_TYPE__REF;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_SLICE_TYPE__CREF = ENUMERABLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Split Replica</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA = ENUMERABLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_SLICE_TYPE__SREF = ENUMERABLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_SLICE_TYPE__UREF = ENUMERABLE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Enumerable Unit Slice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_SLICE_TYPE_FEATURE_COUNT = ENUMERABLE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitTypeImpl <em>Enumerable Unit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableUnitType()
	 * @generated
	 */
	int ENUMERABLE_UNIT_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_TYPE__REF = ENUMERABLE_TYPE__REF;

	/**
	 * The number of structural features of the '<em>Enumerable Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERABLE_UNIT_TYPE_FEATURE_COUNT = ENUMERABLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorFromRecursionTypeImpl <em>Enumerator From Recursion Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorFromRecursionTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumeratorFromRecursionType()
	 * @generated
	 */
	int ENUMERATOR_FROM_RECURSION_TYPE = 22;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_FROM_RECURSION_TYPE__CREF = 0;

	/**
	 * The number of structural features of the '<em>Enumerator From Recursion Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_FROM_RECURSION_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorRefTypeImpl <em>Enumerator Ref Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorRefTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumeratorRefType()
	 * @generated
	 */
	int ENUMERATOR_REF_TYPE = 23;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_REF_TYPE__CREF = 0;

	/**
	 * The number of structural features of the '<em>Enumerator Ref Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_REF_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorTypeImpl <em>Enumerator Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumeratorType()
	 * @generated
	 */
	int ENUMERATOR_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Origin Ref</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__ORIGIN_REF = 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__LINKS = 1;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__VISUAL_DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>From Recursion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__FROM_RECURSION = 3;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__CARDINALITY = 4;

	/**
	 * The feature id for the '<em><b>From Split</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__FROM_SPLIT = 5;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__REF = 6;

	/**
	 * The feature id for the '<em><b>Var Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__VAR_ID = 7;

	/**
	 * The number of structural features of the '<em>Enumerator Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExposePortTypeImpl <em>Expose Port Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ExposePortTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getExposePortType()
	 * @generated
	 */
	int EXPOSE_PORT_TYPE = 25;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPOSE_PORT_TYPE__CREF = 0;

	/**
	 * The feature id for the '<em><b>Exposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPOSE_PORT_TYPE__EXPOSED = 1;

	/**
	 * The feature id for the '<em><b>PRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPOSE_PORT_TYPE__PREF = 2;

	/**
	 * The number of structural features of the '<em>Expose Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPOSE_PORT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtendsTypeImpl <em>Extends Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtendsTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getExtendsType()
	 * @generated
	 */
	int EXTENDS_TYPE = 26;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_TYPE__CREF = 0;

	/**
	 * The number of structural features of the '<em>Extends Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtensionTypeTypeImpl <em>Extension Type Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtensionTypeTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getExtensionTypeType()
	 * @generated
	 */
	int EXTENSION_TYPE_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_TYPE__IMPLEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_TYPE__EXTENDS = 1;

	/**
	 * The number of structural features of the '<em>Extension Type Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionOfReplicatorsTypeImpl <em>Fusion Of Replicators Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionOfReplicatorsTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getFusionOfReplicatorsType()
	 * @generated
	 */
	int FUSION_OF_REPLICATORS_TYPE = 28;

	/**
	 * The feature id for the '<em><b>ERef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_OF_REPLICATORS_TYPE__EREF = 0;

	/**
	 * The feature id for the '<em><b>Origin Ref</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF = 1;

	/**
	 * The number of structural features of the '<em>Fusion Of Replicators Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_OF_REPLICATORS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionsOfReplicatorsTypeImpl <em>Fusions Of Replicators Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionsOfReplicatorsTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getFusionsOfReplicatorsType()
	 * @generated
	 */
	int FUSIONS_OF_REPLICATORS_TYPE = 29;

	/**
	 * The feature id for the '<em><b>Fusion Of Replicators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS = 0;

	/**
	 * The number of structural features of the '<em>Fusions Of Replicators Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSIONS_OF_REPLICATORS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionTypeImpl <em>Fusion Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getFusionType()
	 * @generated
	 */
	int FUSION_TYPE = 30;

	/**
	 * The feature id for the '<em><b>CRefs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_TYPE__CREFS = 0;

	/**
	 * The feature id for the '<em><b>PRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_TYPE__PREF = 1;

	/**
	 * The number of structural features of the '<em>Fusion Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ImplementsTypeImpl <em>Implements Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ImplementsTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getImplementsType()
	 * @generated
	 */
	int IMPLEMENTS_TYPE = 31;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTS_TYPE__CREF = 0;

	/**
	 * The number of structural features of the '<em>Implements Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerComponentTypeImpl <em>Inner Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerComponentTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInnerComponentType()
	 * @generated
	 */
	int INNER_COMPONENT_TYPE = 32;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__VISUAL_DESCRIPTION = COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__PARAMETER = COMPONENT_IN_USE_TYPE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__PORT = COMPONENT_IN_USE_TYPE__PORT;

	/**
	 * The feature id for the '<em><b>Unit Bounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__UNIT_BOUNDS = COMPONENT_IN_USE_TYPE__UNIT_BOUNDS;

	/**
	 * The feature id for the '<em><b>Hash Component UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__HASH_COMPONENT_UID = COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID;

	/**
	 * The feature id for the '<em><b>Local Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__LOCAL_REF = COMPONENT_IN_USE_TYPE__LOCAL_REF;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__LOCATION = COMPONENT_IN_USE_TYPE__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__NAME = COMPONENT_IN_USE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__PACKAGE = COMPONENT_IN_USE_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Parameter Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__PARAMETER_ID = COMPONENT_IN_USE_TYPE__PARAMETER_ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__VERSION = COMPONENT_IN_USE_TYPE__VERSION;

	/**
	 * The feature id for the '<em><b>Exposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE__EXPOSED = COMPONENT_IN_USE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inner Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_COMPONENT_TYPE_FEATURE_COUNT = COMPONENT_IN_USE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerRenamingTypeImpl <em>Inner Renaming Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerRenamingTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInnerRenamingType()
	 * @generated
	 */
	int INNER_RENAMING_TYPE = 33;

	/**
	 * The feature id for the '<em><b>CNew Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_RENAMING_TYPE__CNEW_NAME = 0;

	/**
	 * The feature id for the '<em><b>COld Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_RENAMING_TYPE__COLD_NAME = 1;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_RENAMING_TYPE__CREF = 2;

	/**
	 * The number of structural features of the '<em>Inner Renaming Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNER_RENAMING_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceParameterTypeImpl <em>Interface Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceParameterTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceParameterType()
	 * @generated
	 */
	int INTERFACE_PARAMETER_TYPE = 34;

	/**
	 * The feature id for the '<em><b>Iname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER_TYPE__INAME = 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER_TYPE__ORDER = 1;

	/**
	 * The feature id for the '<em><b>Parid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER_TYPE__PARID = 2;

	/**
	 * The feature id for the '<em><b>Uname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER_TYPE__UNAME = 3;

	/**
	 * The feature id for the '<em><b>Varid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER_TYPE__VARID = 4;

	/**
	 * The number of structural features of the '<em>Interface Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfacePortTypeImpl <em>Interface Port Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfacePortTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfacePortType()
	 * @generated
	 */
	int INTERFACE_PORT_TYPE = 35;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT_TYPE__VISUAL_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Slice</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT_TYPE__SLICE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT_TYPE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Interface Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PORT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceRefTypeImpl <em>Interface Ref Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceRefTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceRefType()
	 * @generated
	 */
	int INTERFACE_REF_TYPE = 36;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REF_TYPE__CREF = 0;

	/**
	 * The feature id for the '<em><b>IRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REF_TYPE__IREF = 1;

	/**
	 * The number of structural features of the '<em>Interface Ref Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REF_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceRefTypeImpl <em>Interface Slice Ref Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceRefTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceSliceRefType()
	 * @generated
	 */
	int INTERFACE_SLICE_REF_TYPE = 37;

	/**
	 * The feature id for the '<em><b>Component Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_REF_TYPE__COMPONENT_REF = 0;

	/**
	 * The feature id for the '<em><b>Interface Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_REF_TYPE__INTERFACE_REF = 1;

	/**
	 * The feature id for the '<em><b>Slice Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_REF_TYPE__SLICE_REF = 2;

	/**
	 * The number of structural features of the '<em>Interface Slice Ref Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_REF_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceTypeImpl <em>Interface Slice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceSliceType()
	 * @generated
	 */
	int INTERFACE_SLICE_TYPE = 38;

	/**
	 * The feature id for the '<em><b>Origin Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_TYPE__ORIGIN_REF = 0;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Is Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_TYPE__IS_REF = 2;

	/**
	 * The number of structural features of the '<em>Interface Slice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_SLICE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl <em>Interface Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceType()
	 * @generated
	 */
	int INTERFACE_TYPE = 39;

	/**
	 * The feature id for the '<em><b>Slice</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__SLICE = 0;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__PROTOCOL = 1;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__SOURCES = 2;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__VISUAL_DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__PORT = 4;

	/**
	 * The feature id for the '<em><b>External References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__EXTERNAL_REFERENCES = 5;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>IRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__IREF = 7;

	/**
	 * The feature id for the '<em><b>NArgs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE__NARGS = 8;

	/**
	 * The number of structural features of the '<em>Interface Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_TYPE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterRenamingImpl <em>Parameter Renaming</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterRenamingImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getParameterRenaming()
	 * @generated
	 */
	int PARAMETER_RENAMING = 40;

	/**
	 * The feature id for the '<em><b>Form Field Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RENAMING__FORM_FIELD_ID = 0;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RENAMING__VAR_NAME = 1;

	/**
	 * The number of structural features of the '<em>Parameter Renaming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_RENAMING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterSupplyTypeImpl <em>Parameter Supply Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterSupplyTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getParameterSupplyType()
	 * @generated
	 */
	int PARAMETER_SUPPLY_TYPE = 41;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SUPPLY_TYPE__CREF = 0;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SUPPLY_TYPE__VAR_NAME = 1;

	/**
	 * The number of structural features of the '<em>Parameter Supply Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_SUPPLY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterTypeImpl <em>Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getParameterType()
	 * @generated
	 */
	int PARAMETER_TYPE = 42;

	/**
	 * The feature id for the '<em><b>Component Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__COMPONENT_REF = 0;

	/**
	 * The feature id for the '<em><b>Form Field Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__FORM_FIELD_ID = 1;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__VAR_NAME = 2;

	/**
	 * The number of structural features of the '<em>Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.PortSliceTypeImpl <em>Port Slice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.PortSliceTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getPortSliceType()
	 * @generated
	 */
	int PORT_SLICE_TYPE = 43;

	/**
	 * The feature id for the '<em><b>PRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SLICE_TYPE__PREF = 0;

	/**
	 * The feature id for the '<em><b>SRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SLICE_TYPE__SREF = 1;

	/**
	 * The number of structural features of the '<em>Port Slice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SLICE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.PortTypeImpl <em>Port Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.PortTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 44;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__VISUAL_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Exposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__EXPOSED = 1;

	/**
	 * The feature id for the '<em><b>PRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE__PREF = 2;

	/**
	 * The number of structural features of the '<em>Port Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.QuantificationVarTypeImpl <em>Quantification Var Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.QuantificationVarTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getQuantificationVarType()
	 * @generated
	 */
	int QUANTIFICATION_VAR_TYPE = 45;

	/**
	 * The feature id for the '<em><b>QType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_VAR_TYPE__QTYPE = 0;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_VAR_TYPE__VAR_NAME = 1;

	/**
	 * The number of structural features of the '<em>Quantification Var Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFICATION_VAR_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.RecursiveEntryTypeImpl <em>Recursive Entry Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.RecursiveEntryTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getRecursiveEntryType()
	 * @generated
	 */
	int RECURSIVE_ENTRY_TYPE = 46;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSIVE_ENTRY_TYPE__CREF = 0;

	/**
	 * The number of structural features of the '<em>Recursive Entry Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSIVE_ENTRY_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl <em>Source File Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSourceFileType()
	 * @generated
	 */
	int SOURCE_FILE_TYPE = 47;

	/**
	 * The feature id for the '<em><b>Dependency</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__DEPENDENCY = 0;

	/**
	 * The feature id for the '<em><b>External Dependency</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY = 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__CONTENTS = 2;

	/**
	 * The feature id for the '<em><b>File Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__FILE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Src Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__SRC_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__URI = 6;

	/**
	 * The feature id for the '<em><b>Version Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE__VERSION_ID = 7;

	/**
	 * The number of structural features of the '<em>Source File Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_TYPE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceTypeImpl <em>Source Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSourceType()
	 * @generated
	 */
	int SOURCE_TYPE = 48;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE__FILE = 0;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE__SOURCE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Version Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE__VERSION_ID = 2;

	/**
	 * The number of structural features of the '<em>Source Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitEnumeratorTypeImpl <em>Split Enumerator Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitEnumeratorTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSplitEnumeratorType()
	 * @generated
	 */
	int SPLIT_ENUMERATOR_TYPE = 49;

	/**
	 * The feature id for the '<em><b>ERef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_ENUMERATOR_TYPE__EREF = 0;

	/**
	 * The number of structural features of the '<em>Split Enumerator Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_ENUMERATOR_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitLinkTypeImpl <em>Split Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitLinkTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSplitLinkType()
	 * @generated
	 */
	int SPLIT_LINK_TYPE = 50;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_LINK_TYPE__CREF = 0;

	/**
	 * The feature id for the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_LINK_TYPE__UREF = 1;

	/**
	 * The number of structural features of the '<em>Split Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_LINK_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitTypeImpl <em>Split Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSplitType()
	 * @generated
	 */
	int SPLIT_TYPE = 51;

	/**
	 * The feature id for the '<em><b>Split Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_TYPE__SPLIT_LINK = 0;

	/**
	 * The feature id for the '<em><b>Split Enumerator</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_TYPE__SPLIT_ENUMERATOR = 1;

	/**
	 * The feature id for the '<em><b>Origin Ref</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_TYPE__ORIGIN_REF = 2;

	/**
	 * The feature id for the '<em><b>CRef Permutation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_TYPE__CREF_PERMUTATION = 3;

	/**
	 * The feature id for the '<em><b>ERef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_TYPE__EREF = 4;

	/**
	 * The feature id for the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_TYPE__N = 5;

	/**
	 * The number of structural features of the '<em>Split Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitBoundsTypeImpl <em>Unit Bounds Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitBoundsTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitBoundsType()
	 * @generated
	 */
	int UNIT_BOUNDS_TYPE = 52;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Replica</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_BOUNDS_TYPE__REPLICA = 1;

	/**
	 * The feature id for the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_BOUNDS_TYPE__UREF = 2;

	/**
	 * The number of structural features of the '<em>Unit Bounds Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_BOUNDS_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitRefTypeImpl <em>Unit Ref Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitRefTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitRefType()
	 * @generated
	 */
	int UNIT_REF_TYPE = 53;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REF_TYPE__CREF = 0;

	/**
	 * The feature id for the '<em><b>Replica</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REF_TYPE__REPLICA = 1;

	/**
	 * The feature id for the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REF_TYPE__UREF = 2;

	/**
	 * The number of structural features of the '<em>Unit Ref Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REF_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitSliceTypeImpl <em>Unit Slice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitSliceTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitSliceType()
	 * @generated
	 */
	int UNIT_SLICE_TYPE = 54;

	/**
	 * The feature id for the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE__CREF = UNIT_REF_TYPE__CREF;

	/**
	 * The feature id for the '<em><b>Replica</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE__REPLICA = UNIT_REF_TYPE__REPLICA;

	/**
	 * The feature id for the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE__UREF = UNIT_REF_TYPE__UREF;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE__VISUAL_DESCRIPTION = UNIT_REF_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE__PORT = UNIT_REF_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Slice Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE__SLICE_NAME = UNIT_REF_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE__TRANSITIVE = UNIT_REF_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Unit Slice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_SLICE_TYPE_FEATURE_COUNT = UNIT_REF_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitTypeImpl <em>Unit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitType()
	 * @generated
	 */
	int UNIT_TYPE = 55;

	/**
	 * The feature id for the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__SUPER = 0;

	/**
	 * The feature id for the '<em><b>Slices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__SLICES = 1;

	/**
	 * The feature id for the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__VISUAL_DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>IRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__IREF = 3;

	/**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__PRIVATE = 4;

	/**
	 * The feature id for the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__UREF = 5;

	/**
	 * The feature id for the '<em><b>Visible Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE__VISIBLE_INTERFACE = 6;

	/**
	 * The number of structural features of the '<em>Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.VersionTypeImpl <em>Version Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.VersionTypeImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getVersionType()
	 * @generated
	 */
	int VERSION_TYPE = 56;

	/**
	 * The feature id for the '<em><b>Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_TYPE__FIELD1 = 0;

	/**
	 * The feature id for the '<em><b>Field2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_TYPE__FIELD2 = 1;

	/**
	 * The feature id for the '<em><b>Field3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_TYPE__FIELD3 = 2;

	/**
	 * The feature id for the '<em><b>Field4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_TYPE__FIELD4 = 3;

	/**
	 * The number of structural features of the '<em>Version Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.VisualElementAttributesImpl <em>Visual Element Attributes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.VisualElementAttributesImpl
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getVisualElementAttributes()
	 * @generated
	 */
	int VISUAL_ELEMENT_ATTRIBUTES = 57;

	/**
	 * The feature id for the '<em><b>Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_ELEMENT_ATTRIBUTES__COLOR = 0;

	/**
	 * The feature id for the '<em><b>H</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_ELEMENT_ATTRIBUTES__H = 1;

	/**
	 * The feature id for the '<em><b>W</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_ELEMENT_ATTRIBUTES__W = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_ELEMENT_ATTRIBUTES__X = 3;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_ELEMENT_ATTRIBUTES__Y = 4;

	/**
	 * The number of structural features of the '<em>Visual Element Attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_ELEMENT_ATTRIBUTES_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType <em>Quantification Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getQuantificationType()
	 * @generated
	 */
	int QUANTIFICATION_TYPE = 58;

	/**
	 * The meta object id for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds <em>Supported Kinds</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSupportedKinds()
	 * @generated
	 */
	int SUPPORTED_KINDS = 59;

	/**
	 * The meta object id for the '<em>Quantification Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getQuantificationTypeObject()
	 * @generated
	 */
	int QUANTIFICATION_TYPE_OBJECT = 60;

	/**
	 * The meta object id for the '<em>Supported Kinds Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSupportedKindsObject()
	 * @generated
	 */
	int SUPPORTED_KINDS_OBJECT = 61;


	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType <em>Action Activate Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Activate Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType
	 * @generated
	 */
	EClass getActionActivateType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType#getSliceRef <em>Slice Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType#getSliceRef()
	 * @see #getActionActivateType()
	 * @generated
	 */
	EAttribute getActionActivateType_SliceRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorAltType <em>Action Combinator Alt Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Combinator Alt Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorAltType
	 * @generated
	 */
	EClass getActionCombinatorAltType();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorParType <em>Action Combinator Par Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Combinator Par Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorParType
	 * @generated
	 */
	EClass getActionCombinatorParType();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorSeqType <em>Action Combinator Seq Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Combinator Seq Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorSeqType
	 * @generated
	 */
	EClass getActionCombinatorSeqType();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType <em>Action Combinator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Combinator Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType
	 * @generated
	 */
	EClass getActionCombinatorType();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType#getGroup()
	 * @see #getActionCombinatorType()
	 * @generated
	 */
	EAttribute getActionCombinatorType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType#getAction()
	 * @see #getActionCombinatorType()
	 * @generated
	 */
	EReference getActionCombinatorType_Action();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionSignalType <em>Action Signal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Signal Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionSignalType
	 * @generated
	 */
	EClass getActionSignalType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionSignalType#getSemaphore <em>Semaphore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Semaphore</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionSignalType#getSemaphore()
	 * @see #getActionSignalType()
	 * @generated
	 */
	EAttribute getActionSignalType_Semaphore();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionSkipType <em>Action Skip Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Skip Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionSkipType
	 * @generated
	 */
	EClass getActionSkipType();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionType
	 * @generated
	 */
	EClass getActionType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionType#getVisualDescription()
	 * @see #getActionType()
	 * @generated
	 */
	EReference getActionType_VisualDescription();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionType#getLabel()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Label();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionType#getRepeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionType#getRepeat()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Repeat();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType <em>Action Wait Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Wait Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType
	 * @generated
	 */
	EClass getActionWaitType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType#getSemaphore <em>Semaphore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Semaphore</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType#getSemaphore()
	 * @see #getActionWaitType()
	 * @generated
	 */
	EAttribute getActionWaitType_Semaphore();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType <em>Base Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Type Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType
	 * @generated
	 */
	EClass getBaseTypeType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getExtensionType()
	 * @see #getBaseTypeType()
	 * @generated
	 */
	EReference getBaseTypeType_ExtensionType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType#getComponent()
	 * @see #getBaseTypeType()
	 * @generated
	 */
	EReference getBaseTypeType_Component();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType <em>Color Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Complex Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType
	 * @generated
	 */
	EClass getColorComplexType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType#getB()
	 * @see #getColorComplexType()
	 * @generated
	 */
	EAttribute getColorComplexType_B();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType#getG <em>G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>G</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType#getG()
	 * @see #getColorComplexType()
	 * @generated
	 */
	EAttribute getColorComplexType_G();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType#getR()
	 * @see #getColorComplexType()
	 * @generated
	 */
	EAttribute getColorComplexType_R();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType <em>Body Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Body Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType
	 * @generated
	 */
	EClass getComponentBodyType();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getGroup()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EAttribute getComponentBodyType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getInnerComponent <em>Inner Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner Component</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getInnerComponent()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_InnerComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getParameter()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getSupplyParameter <em>Supply Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supply Parameter</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getSupplyParameter()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_SupplyParameter();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getInnerRenaming <em>Inner Renaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner Renaming</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getInnerRenaming()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_InnerRenaming();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getFusion <em>Fusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fusion</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getFusion()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_Fusion();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getSplit <em>Split</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Split</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getSplit()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_Split();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getRecursiveEntry <em>Recursive Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Recursive Entry</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getRecursiveEntry()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_RecursiveEntry();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interface</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getInterface()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_Interface();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getUnit()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_Unit();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getEnumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enumerator</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getEnumerator()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_Enumerator();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getFusionsOfReplicators <em>Fusions Of Replicators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fusions Of Replicators</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType#getFusionsOfReplicators()
	 * @see #getComponentBodyType()
	 * @generated
	 */
	EReference getComponentBodyType_FusionsOfReplicators();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType <em>Header Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType
	 * @generated
	 */
	EClass getComponentHeaderType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getBaseType()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EReference getComponentHeaderType_BaseType();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getVersions()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EReference getComponentHeaderType_Versions();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getVisualAttributes <em>Visual Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Attributes</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getVisualAttributes()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EReference getComponentHeaderType_VisualAttributes();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getHashComponentUID <em>Hash Component UID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hash Component UID</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getHashComponentUID()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EAttribute getComponentHeaderType_HashComponentUID();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#isIsAbstract()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EAttribute getComponentHeaderType_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getKind()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EAttribute getComponentHeaderType_Kind();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getLocationURI <em>Location URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location URI</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getLocationURI()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EAttribute getComponentHeaderType_LocationURI();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getName()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EAttribute getComponentHeaderType_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getPackagePath <em>Package Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Path</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getPackagePath()
	 * @see #getComponentHeaderType()
	 * @generated
	 */
	EAttribute getComponentHeaderType_PackagePath();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType <em>In Use Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Use Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType
	 * @generated
	 */
	EClass getComponentInUseType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getVisualDescription()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EReference getComponentInUseType_VisualDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getParameter()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EReference getComponentInUseType_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getPort()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EReference getComponentInUseType_Port();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getUnitBounds <em>Unit Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit Bounds</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getUnitBounds()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EReference getComponentInUseType_UnitBounds();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getHashComponentUID <em>Hash Component UID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hash Component UID</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getHashComponentUID()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EAttribute getComponentInUseType_HashComponentUID();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getLocalRef <em>Local Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getLocalRef()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EAttribute getComponentInUseType_LocalRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getLocation()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EAttribute getComponentInUseType_Location();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getName()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EAttribute getComponentInUseType_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getPackage()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EAttribute getComponentInUseType_Package();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getParameterId <em>Parameter Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Id</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getParameterId()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EAttribute getComponentInUseType_ParameterId();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType#getVersion()
	 * @see #getComponentInUseType()
	 * @generated
	 */
	EAttribute getComponentInUseType_Version();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentType#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Header</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentType#getHeader()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Header();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentType#getComponentInfo <em>Component Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Info</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentType#getComponentInfo()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_ComponentInfo();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getNewAttribute <em>New Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Attribute</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot#getNewAttribute()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_NewAttribute();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EntryType <em>Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EntryType
	 * @generated
	 */
	EClass getEntryType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.EntryType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EntryType#getVisualDescription()
	 * @see #getEntryType()
	 * @generated
	 */
	EReference getEntryType_VisualDescription();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableComponentType <em>Enumerable Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerable Component Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableComponentType
	 * @generated
	 */
	EClass getEnumerableComponentType();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType <em>Enumerable Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerable Entry Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType
	 * @generated
	 */
	EClass getEnumerableEntryType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType#getCRef()
	 * @see #getEnumerableEntryType()
	 * @generated
	 */
	EAttribute getEnumerableEntryType_CRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType#getIndex()
	 * @see #getEnumerableEntryType()
	 * @generated
	 */
	EAttribute getEnumerableEntryType_Index();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType#getURef <em>URef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType#getURef()
	 * @see #getEnumerableEntryType()
	 * @generated
	 */
	EAttribute getEnumerableEntryType_URef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableType <em>Enumerable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerable Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableType
	 * @generated
	 */
	EClass getEnumerableType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableType#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableType#getRef()
	 * @see #getEnumerableType()
	 * @generated
	 */
	EAttribute getEnumerableType_Ref();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType <em>Enumerable Unit Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerable Unit Slice Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType
	 * @generated
	 */
	EClass getEnumerableUnitSliceType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getCRef()
	 * @see #getEnumerableUnitSliceType()
	 * @generated
	 */
	EAttribute getEnumerableUnitSliceType_CRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getSplitReplica <em>Split Replica</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Split Replica</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getSplitReplica()
	 * @see #getEnumerableUnitSliceType()
	 * @generated
	 */
	EAttribute getEnumerableUnitSliceType_SplitReplica();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getSRef <em>SRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getSRef()
	 * @see #getEnumerableUnitSliceType()
	 * @generated
	 */
	EAttribute getEnumerableUnitSliceType_SRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getURef <em>URef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType#getURef()
	 * @see #getEnumerableUnitSliceType()
	 * @generated
	 */
	EAttribute getEnumerableUnitSliceType_URef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitType <em>Enumerable Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerable Unit Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitType
	 * @generated
	 */
	EClass getEnumerableUnitType();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorFromRecursionType <em>Enumerator From Recursion Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerator From Recursion Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorFromRecursionType
	 * @generated
	 */
	EClass getEnumeratorFromRecursionType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorFromRecursionType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorFromRecursionType#getCRef()
	 * @see #getEnumeratorFromRecursionType()
	 * @generated
	 */
	EAttribute getEnumeratorFromRecursionType_CRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorRefType <em>Enumerator Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerator Ref Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorRefType
	 * @generated
	 */
	EClass getEnumeratorRefType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorRefType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorRefType#getCRef()
	 * @see #getEnumeratorRefType()
	 * @generated
	 */
	EAttribute getEnumeratorRefType_CRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType <em>Enumerator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerator Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType
	 * @generated
	 */
	EClass getEnumeratorType();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getOriginRef <em>Origin Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Origin Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getOriginRef()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EAttribute getEnumeratorType_OriginRef();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getLinks()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EReference getEnumeratorType_Links();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getVisualDescription()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EReference getEnumeratorType_VisualDescription();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getFromRecursion <em>From Recursion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From Recursion</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getFromRecursion()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EReference getEnumeratorType_FromRecursion();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getCardinality()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EAttribute getEnumeratorType_Cardinality();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#isFromSplit <em>From Split</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Split</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#isFromSplit()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EAttribute getEnumeratorType_FromSplit();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getRef()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EAttribute getEnumeratorType_Ref();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getVarId <em>Var Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Id</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType#getVarId()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EAttribute getEnumeratorType_VarId();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType <em>Expose Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expose Port Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType
	 * @generated
	 */
	EClass getExposePortType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getCRef()
	 * @see #getExposePortType()
	 * @generated
	 */
	EAttribute getExposePortType_CRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getExposed <em>Exposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exposed</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getExposed()
	 * @see #getExposePortType()
	 * @generated
	 */
	EAttribute getExposePortType_Exposed();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getPRef <em>PRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExposePortType#getPRef()
	 * @see #getExposePortType()
	 * @generated
	 */
	EAttribute getExposePortType_PRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExtendsType <em>Extends Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExtendsType
	 * @generated
	 */
	EClass getExtendsType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExtendsType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExtendsType#getCRef()
	 * @see #getExtendsType()
	 * @generated
	 */
	EAttribute getExtendsType_CRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType <em>Extension Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType
	 * @generated
	 */
	EClass getExtensionTypeType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType#isImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implements</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType#isImplements()
	 * @see #getExtensionTypeType()
	 * @generated
	 */
	EAttribute getExtensionTypeType_Implements();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType#isExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType#isExtends()
	 * @see #getExtensionTypeType()
	 * @generated
	 */
	EAttribute getExtensionTypeType_Extends();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType <em>Fusion Of Replicators Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fusion Of Replicators Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType
	 * @generated
	 */
	EClass getFusionOfReplicatorsType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType#getERef <em>ERef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ERef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType#getERef()
	 * @see #getFusionOfReplicatorsType()
	 * @generated
	 */
	EAttribute getFusionOfReplicatorsType_ERef();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType#getOriginRef <em>Origin Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Origin Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType#getOriginRef()
	 * @see #getFusionOfReplicatorsType()
	 * @generated
	 */
	EAttribute getFusionOfReplicatorsType_OriginRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionsOfReplicatorsType <em>Fusions Of Replicators Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fusions Of Replicators Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionsOfReplicatorsType
	 * @generated
	 */
	EClass getFusionsOfReplicatorsType();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionsOfReplicatorsType#getFusionOfReplicators <em>Fusion Of Replicators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fusion Of Replicators</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionsOfReplicatorsType#getFusionOfReplicators()
	 * @see #getFusionsOfReplicatorsType()
	 * @generated
	 */
	EReference getFusionsOfReplicatorsType_FusionOfReplicators();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionType <em>Fusion Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fusion Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionType
	 * @generated
	 */
	EClass getFusionType();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionType#getCRefs <em>CRefs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>CRefs</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionType#getCRefs()
	 * @see #getFusionType()
	 * @generated
	 */
	EAttribute getFusionType_CRefs();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionType#getPRef <em>PRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.FusionType#getPRef()
	 * @see #getFusionType()
	 * @generated
	 */
	EAttribute getFusionType_PRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ImplementsType <em>Implements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implements Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ImplementsType
	 * @generated
	 */
	EClass getImplementsType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ImplementsType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ImplementsType#getCRef()
	 * @see #getImplementsType()
	 * @generated
	 */
	EAttribute getImplementsType_CRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerComponentType <em>Inner Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inner Component Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InnerComponentType
	 * @generated
	 */
	EClass getInnerComponentType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerComponentType#isExposed <em>Exposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exposed</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InnerComponentType#isExposed()
	 * @see #getInnerComponentType()
	 * @generated
	 */
	EAttribute getInnerComponentType_Exposed();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType <em>Inner Renaming Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inner Renaming Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType
	 * @generated
	 */
	EClass getInnerRenamingType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCNewName <em>CNew Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CNew Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCNewName()
	 * @see #getInnerRenamingType()
	 * @generated
	 */
	EAttribute getInnerRenamingType_CNewName();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCOldName <em>COld Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>COld Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCOldName()
	 * @see #getInnerRenamingType()
	 * @generated
	 */
	EAttribute getInnerRenamingType_COldName();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType#getCRef()
	 * @see #getInnerRenamingType()
	 * @generated
	 */
	EAttribute getInnerRenamingType_CRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType <em>Interface Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Parameter Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType
	 * @generated
	 */
	EClass getInterfaceParameterType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getIname <em>Iname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iname</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getIname()
	 * @see #getInterfaceParameterType()
	 * @generated
	 */
	EAttribute getInterfaceParameterType_Iname();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getOrder()
	 * @see #getInterfaceParameterType()
	 * @generated
	 */
	EAttribute getInterfaceParameterType_Order();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getParid <em>Parid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parid</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getParid()
	 * @see #getInterfaceParameterType()
	 * @generated
	 */
	EAttribute getInterfaceParameterType_Parid();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getUname <em>Uname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uname</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getUname()
	 * @see #getInterfaceParameterType()
	 * @generated
	 */
	EAttribute getInterfaceParameterType_Uname();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getVarid <em>Varid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Varid</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType#getVarid()
	 * @see #getInterfaceParameterType()
	 * @generated
	 */
	EAttribute getInterfaceParameterType_Varid();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType <em>Interface Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Port Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType
	 * @generated
	 */
	EClass getInterfacePortType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType#getVisualDescription()
	 * @see #getInterfacePortType()
	 * @generated
	 */
	EReference getInterfacePortType_VisualDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType#getSlice <em>Slice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slice</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType#getSlice()
	 * @see #getInterfacePortType()
	 * @generated
	 */
	EReference getInterfacePortType_Slice();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType#getName()
	 * @see #getInterfacePortType()
	 * @generated
	 */
	EAttribute getInterfacePortType_Name();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType <em>Interface Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Ref Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType
	 * @generated
	 */
	EClass getInterfaceRefType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getCRef()
	 * @see #getInterfaceRefType()
	 * @generated
	 */
	EAttribute getInterfaceRefType_CRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getIRef <em>IRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceRefType#getIRef()
	 * @see #getInterfaceRefType()
	 * @generated
	 */
	EAttribute getInterfaceRefType_IRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType <em>Interface Slice Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Slice Ref Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType
	 * @generated
	 */
	EClass getInterfaceSliceRefType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getComponentRef <em>Component Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getComponentRef()
	 * @see #getInterfaceSliceRefType()
	 * @generated
	 */
	EAttribute getInterfaceSliceRefType_ComponentRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getInterfaceRef <em>Interface Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getInterfaceRef()
	 * @see #getInterfaceSliceRefType()
	 * @generated
	 */
	EAttribute getInterfaceSliceRefType_InterfaceRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getSliceRef <em>Slice Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceRefType#getSliceRef()
	 * @see #getInterfaceSliceRefType()
	 * @generated
	 */
	EAttribute getInterfaceSliceRefType_SliceRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType <em>Interface Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Slice Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType
	 * @generated
	 */
	EClass getInterfaceSliceType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType#getOriginRef <em>Origin Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType#getOriginRef()
	 * @see #getInterfaceSliceType()
	 * @generated
	 */
	EReference getInterfaceSliceType_OriginRef();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType#getVisualDescription()
	 * @see #getInterfaceSliceType()
	 * @generated
	 */
	EReference getInterfaceSliceType_VisualDescription();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType#getIsRef <em>Is Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType#getIsRef()
	 * @see #getInterfaceSliceType()
	 * @generated
	 */
	EAttribute getInterfaceSliceType_IsRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType <em>Interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType
	 * @generated
	 */
	EClass getInterfaceType();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getSlice <em>Slice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slice</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getSlice()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EReference getInterfaceType_Slice();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Protocol</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getProtocol()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EReference getInterfaceType_Protocol();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sources</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getSources()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EReference getInterfaceType_Sources();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getVisualDescription()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EReference getInterfaceType_VisualDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getPort()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EReference getInterfaceType_Port();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getExternalReferences <em>External References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>External References</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getExternalReferences()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EAttribute getInterfaceType_ExternalReferences();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getParameter()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EReference getInterfaceType_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getIRef <em>IRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getIRef()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EAttribute getInterfaceType_IRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getNArgs <em>NArgs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>NArgs</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType#getNArgs()
	 * @see #getInterfaceType()
	 * @generated
	 */
	EAttribute getInterfaceType_NArgs();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming <em>Parameter Renaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Renaming</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming
	 * @generated
	 */
	EClass getParameterRenaming();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming#getFormFieldId <em>Form Field Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Form Field Id</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming#getFormFieldId()
	 * @see #getParameterRenaming()
	 * @generated
	 */
	EAttribute getParameterRenaming_FormFieldId();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming#getVarName()
	 * @see #getParameterRenaming()
	 * @generated
	 */
	EAttribute getParameterRenaming_VarName();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType <em>Parameter Supply Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Supply Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType
	 * @generated
	 */
	EClass getParameterSupplyType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType#getCRef()
	 * @see #getParameterSupplyType()
	 * @generated
	 */
	EAttribute getParameterSupplyType_CRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType#getVarName()
	 * @see #getParameterSupplyType()
	 * @generated
	 */
	EAttribute getParameterSupplyType_VarName();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterType
	 * @generated
	 */
	EClass getParameterType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterType#getComponentRef <em>Component Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterType#getComponentRef()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_ComponentRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterType#getFormFieldId <em>Form Field Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Form Field Id</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterType#getFormFieldId()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_FormFieldId();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.ParameterType#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ParameterType#getVarName()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_VarName();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortSliceType <em>Port Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Slice Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.PortSliceType
	 * @generated
	 */
	EClass getPortSliceType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortSliceType#getPRef <em>PRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.PortSliceType#getPRef()
	 * @see #getPortSliceType()
	 * @generated
	 */
	EAttribute getPortSliceType_PRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortSliceType#getSRef <em>SRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.PortSliceType#getSRef()
	 * @see #getPortSliceType()
	 * @generated
	 */
	EAttribute getPortSliceType_SRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.PortType
	 * @generated
	 */
	EClass getPortType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.PortType#getVisualDescription()
	 * @see #getPortType()
	 * @generated
	 */
	EReference getPortType_VisualDescription();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#isExposed <em>Exposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exposed</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.PortType#isExposed()
	 * @see #getPortType()
	 * @generated
	 */
	EAttribute getPortType_Exposed();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.PortType#getPRef <em>PRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.PortType#getPRef()
	 * @see #getPortType()
	 * @generated
	 */
	EAttribute getPortType_PRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.QuantificationVarType <em>Quantification Var Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantification Var Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationVarType
	 * @generated
	 */
	EClass getQuantificationVarType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.QuantificationVarType#getQType <em>QType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>QType</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationVarType#getQType()
	 * @see #getQuantificationVarType()
	 * @generated
	 */
	EAttribute getQuantificationVarType_QType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.QuantificationVarType#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationVarType#getVarName()
	 * @see #getQuantificationVarType()
	 * @generated
	 */
	EAttribute getQuantificationVarType_VarName();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.RecursiveEntryType <em>Recursive Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recursive Entry Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.RecursiveEntryType
	 * @generated
	 */
	EClass getRecursiveEntryType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.RecursiveEntryType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.RecursiveEntryType#getCRef()
	 * @see #getRecursiveEntryType()
	 * @generated
	 */
	EAttribute getRecursiveEntryType_CRef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType <em>Source File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source File Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType
	 * @generated
	 */
	EClass getSourceFileType();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dependency</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getDependency()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_Dependency();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getExternalDependency <em>External Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>External Dependency</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getExternalDependency()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_ExternalDependency();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contents</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getContents()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_Contents();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getFileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getFileType()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_FileType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getName()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getSrcType <em>Src Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getSrcType()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_SrcType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getUri()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_Uri();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getVersionId <em>Version Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Id</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType#getVersionId()
	 * @see #getSourceFileType()
	 * @generated
	 */
	EAttribute getSourceFileType_VersionId();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceType
	 * @generated
	 */
	EClass getSourceType();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceType#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>File</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceType#getFile()
	 * @see #getSourceType()
	 * @generated
	 */
	EReference getSourceType_File();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceType#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceType#getSourceType()
	 * @see #getSourceType()
	 * @generated
	 */
	EAttribute getSourceType_SourceType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SourceType#getVersionId <em>Version Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Id</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SourceType#getVersionId()
	 * @see #getSourceType()
	 * @generated
	 */
	EAttribute getSourceType_VersionId();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitEnumeratorType <em>Split Enumerator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Split Enumerator Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitEnumeratorType
	 * @generated
	 */
	EClass getSplitEnumeratorType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitEnumeratorType#getERef <em>ERef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ERef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitEnumeratorType#getERef()
	 * @see #getSplitEnumeratorType()
	 * @generated
	 */
	EAttribute getSplitEnumeratorType_ERef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType <em>Split Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Split Link Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType
	 * @generated
	 */
	EClass getSplitLinkType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType#getCRef()
	 * @see #getSplitLinkType()
	 * @generated
	 */
	EAttribute getSplitLinkType_CRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType#getURef <em>URef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType#getURef()
	 * @see #getSplitLinkType()
	 * @generated
	 */
	EAttribute getSplitLinkType_URef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitType <em>Split Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Split Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitType
	 * @generated
	 */
	EClass getSplitType();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getSplitLink <em>Split Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Split Link</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getSplitLink()
	 * @see #getSplitType()
	 * @generated
	 */
	EReference getSplitType_SplitLink();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getSplitEnumerator <em>Split Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Split Enumerator</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getSplitEnumerator()
	 * @see #getSplitType()
	 * @generated
	 */
	EAttribute getSplitType_SplitEnumerator();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getOriginRef <em>Origin Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Origin Ref</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getOriginRef()
	 * @see #getSplitType()
	 * @generated
	 */
	EAttribute getSplitType_OriginRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getCRefPermutation <em>CRef Permutation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef Permutation</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getCRefPermutation()
	 * @see #getSplitType()
	 * @generated
	 */
	EAttribute getSplitType_CRefPermutation();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getERef <em>ERef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ERef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getERef()
	 * @see #getSplitType()
	 * @generated
	 */
	EAttribute getSplitType_ERef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getN <em>N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>N</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SplitType#getN()
	 * @see #getSplitType()
	 * @generated
	 */
	EAttribute getSplitType_N();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType <em>Unit Bounds Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Bounds Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType
	 * @generated
	 */
	EClass getUnitBoundsType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType#getVisualDescription()
	 * @see #getUnitBoundsType()
	 * @generated
	 */
	EReference getUnitBoundsType_VisualDescription();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType#getReplica <em>Replica</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replica</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType#getReplica()
	 * @see #getUnitBoundsType()
	 * @generated
	 */
	EAttribute getUnitBoundsType_Replica();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType#getURef <em>URef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType#getURef()
	 * @see #getUnitBoundsType()
	 * @generated
	 */
	EAttribute getUnitBoundsType_URef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType <em>Unit Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Ref Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType
	 * @generated
	 */
	EClass getUnitRefType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType#getCRef <em>CRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType#getCRef()
	 * @see #getUnitRefType()
	 * @generated
	 */
	EAttribute getUnitRefType_CRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType#getReplica <em>Replica</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replica</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType#getReplica()
	 * @see #getUnitRefType()
	 * @generated
	 */
	EAttribute getUnitRefType_Replica();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType#getURef <em>URef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType#getURef()
	 * @see #getUnitRefType()
	 * @generated
	 */
	EAttribute getUnitRefType_URef();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType <em>Unit Slice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Slice Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType
	 * @generated
	 */
	EClass getUnitSliceType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getVisualDescription()
	 * @see #getUnitSliceType()
	 * @generated
	 */
	EReference getUnitSliceType_VisualDescription();

	/**
	 * Returns the meta object for the attribute list '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Port</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getPort()
	 * @see #getUnitSliceType()
	 * @generated
	 */
	EAttribute getUnitSliceType_Port();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getSliceName <em>Slice Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice Name</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getSliceName()
	 * @see #getUnitSliceType()
	 * @generated
	 */
	EAttribute getUnitSliceType_SliceName();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#isTransitive <em>Transitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transitive</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#isTransitive()
	 * @see #getUnitSliceType()
	 * @generated
	 */
	EAttribute getUnitSliceType_Transitive();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType
	 * @generated
	 */
	EClass getUnitType();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getSuper()
	 * @see #getUnitType()
	 * @generated
	 */
	EReference getUnitType_Super();

	/**
	 * Returns the meta object for the containment reference list '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getSlices <em>Slices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slices</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getSlices()
	 * @see #getUnitType()
	 * @generated
	 */
	EReference getUnitType_Slices();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getVisualDescription <em>Visual Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visual Description</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getVisualDescription()
	 * @see #getUnitType()
	 * @generated
	 */
	EReference getUnitType_VisualDescription();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getIRef <em>IRef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IRef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getIRef()
	 * @see #getUnitType()
	 * @generated
	 */
	EAttribute getUnitType_IRef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isPrivate <em>Private</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Private</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isPrivate()
	 * @see #getUnitType()
	 * @generated
	 */
	EAttribute getUnitType_Private();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getURef <em>URef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URef</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getURef()
	 * @see #getUnitType()
	 * @generated
	 */
	EAttribute getUnitType_URef();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isVisibleInterface <em>Visible Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible Interface</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isVisibleInterface()
	 * @see #getUnitType()
	 * @generated
	 */
	EAttribute getUnitType_VisibleInterface();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.VersionType <em>Version Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VersionType
	 * @generated
	 */
	EClass getVersionType();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField1 <em>Field1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field1</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField1()
	 * @see #getVersionType()
	 * @generated
	 */
	EAttribute getVersionType_Field1();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField2 <em>Field2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field2</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField2()
	 * @see #getVersionType()
	 * @generated
	 */
	EAttribute getVersionType_Field2();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField3 <em>Field3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field3</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField3()
	 * @see #getVersionType()
	 * @generated
	 */
	EAttribute getVersionType_Field3();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField4 <em>Field4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field4</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VersionType#getField4()
	 * @see #getVersionType()
	 * @generated
	 */
	EAttribute getVersionType_Field4();

	/**
	 * Returns the meta object for class '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes <em>Visual Element Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visual Element Attributes</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes
	 * @generated
	 */
	EClass getVisualElementAttributes();

	/**
	 * Returns the meta object for the containment reference '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getColor()
	 * @see #getVisualElementAttributes()
	 * @generated
	 */
	EReference getVisualElementAttributes_Color();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getH <em>H</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>H</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getH()
	 * @see #getVisualElementAttributes()
	 * @generated
	 */
	EAttribute getVisualElementAttributes_H();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getW <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>W</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getW()
	 * @see #getVisualElementAttributes()
	 * @generated
	 */
	EAttribute getVisualElementAttributes_W();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getX()
	 * @see #getVisualElementAttributes()
	 * @generated
	 */
	EAttribute getVisualElementAttributes_X();

	/**
	 * Returns the meta object for the attribute '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getY()
	 * @see #getVisualElementAttributes()
	 * @generated
	 */
	EAttribute getVisualElementAttributes_Y();

	/**
	 * Returns the meta object for enum '{@link br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType <em>Quantification Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Quantification Type</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType
	 * @generated
	 */
	EEnum getQuantificationType();

	/**
	 * Returns the meta object for enum '{@link br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds <em>Supported Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Supported Kinds</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
	 * @generated
	 */
	EEnum getSupportedKinds();

	/**
	 * Returns the meta object for data type '{@link br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType <em>Quantification Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Quantification Type Object</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType
	 * @model instanceClass="br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType"
	 *        extendedMetaData="name='QuantificationType:Object' baseType='QuantificationType'"
	 * @generated
	 */
	EDataType getQuantificationTypeObject();

	/**
	 * Returns the meta object for data type '{@link br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds <em>Supported Kinds Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Supported Kinds Object</em>'.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
	 * @model instanceClass="br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds"
	 *        extendedMetaData="name='SupportedKinds:Object' baseType='SupportedKinds'"
	 * @generated
	 */
	EDataType getSupportedKindsObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentFactory getComponentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionActivateTypeImpl <em>Action Activate Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionActivateTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionActivateType()
		 * @generated
		 */
		EClass ACTION_ACTIVATE_TYPE = eINSTANCE.getActionActivateType();

		/**
		 * The meta object literal for the '<em><b>Slice Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_ACTIVATE_TYPE__SLICE_REF = eINSTANCE.getActionActivateType_SliceRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorAltTypeImpl <em>Action Combinator Alt Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorAltTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorAltType()
		 * @generated
		 */
		EClass ACTION_COMBINATOR_ALT_TYPE = eINSTANCE.getActionCombinatorAltType();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorParTypeImpl <em>Action Combinator Par Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorParTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorParType()
		 * @generated
		 */
		EClass ACTION_COMBINATOR_PAR_TYPE = eINSTANCE.getActionCombinatorParType();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorSeqTypeImpl <em>Action Combinator Seq Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorSeqTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorSeqType()
		 * @generated
		 */
		EClass ACTION_COMBINATOR_SEQ_TYPE = eINSTANCE.getActionCombinatorSeqType();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorTypeImpl <em>Action Combinator Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionCombinatorTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionCombinatorType()
		 * @generated
		 */
		EClass ACTION_COMBINATOR_TYPE = eINSTANCE.getActionCombinatorType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_COMBINATOR_TYPE__GROUP = eINSTANCE.getActionCombinatorType_Group();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_COMBINATOR_TYPE__ACTION = eINSTANCE.getActionCombinatorType_Action();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSignalTypeImpl <em>Action Signal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSignalTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionSignalType()
		 * @generated
		 */
		EClass ACTION_SIGNAL_TYPE = eINSTANCE.getActionSignalType();

		/**
		 * The meta object literal for the '<em><b>Semaphore</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_SIGNAL_TYPE__SEMAPHORE = eINSTANCE.getActionSignalType_Semaphore();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSkipTypeImpl <em>Action Skip Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSkipTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionSkipType()
		 * @generated
		 */
		EClass ACTION_SKIP_TYPE = eINSTANCE.getActionSkipType();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionTypeImpl <em>Action Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionType()
		 * @generated
		 */
		EClass ACTION_TYPE = eINSTANCE.getActionType();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getActionType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__LABEL = eINSTANCE.getActionType_Label();

		/**
		 * The meta object literal for the '<em><b>Repeat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__REPEAT = eINSTANCE.getActionType_Repeat();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionWaitTypeImpl <em>Action Wait Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionWaitTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getActionWaitType()
		 * @generated
		 */
		EClass ACTION_WAIT_TYPE = eINSTANCE.getActionWaitType();

		/**
		 * The meta object literal for the '<em><b>Semaphore</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_WAIT_TYPE__SEMAPHORE = eINSTANCE.getActionWaitType_Semaphore();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.BaseTypeTypeImpl <em>Base Type Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.BaseTypeTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getBaseTypeType()
		 * @generated
		 */
		EClass BASE_TYPE_TYPE = eINSTANCE.getBaseTypeType();

		/**
		 * The meta object literal for the '<em><b>Extension Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_TYPE_TYPE__EXTENSION_TYPE = eINSTANCE.getBaseTypeType_ExtensionType();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_TYPE_TYPE__COMPONENT = eINSTANCE.getBaseTypeType_Component();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ColorComplexTypeImpl <em>Color Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ColorComplexTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getColorComplexType()
		 * @generated
		 */
		EClass COLOR_COMPLEX_TYPE = eINSTANCE.getColorComplexType();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_COMPLEX_TYPE__B = eINSTANCE.getColorComplexType_B();

		/**
		 * The meta object literal for the '<em><b>G</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_COMPLEX_TYPE__G = eINSTANCE.getColorComplexType_G();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_COMPLEX_TYPE__R = eINSTANCE.getColorComplexType_R();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentBodyTypeImpl <em>Body Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentBodyTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentBodyType()
		 * @generated
		 */
		EClass COMPONENT_BODY_TYPE = eINSTANCE.getComponentBodyType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_BODY_TYPE__GROUP = eINSTANCE.getComponentBodyType_Group();

		/**
		 * The meta object literal for the '<em><b>Inner Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__INNER_COMPONENT = eINSTANCE.getComponentBodyType_InnerComponent();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__PARAMETER = eINSTANCE.getComponentBodyType_Parameter();

		/**
		 * The meta object literal for the '<em><b>Supply Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__SUPPLY_PARAMETER = eINSTANCE.getComponentBodyType_SupplyParameter();

		/**
		 * The meta object literal for the '<em><b>Inner Renaming</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__INNER_RENAMING = eINSTANCE.getComponentBodyType_InnerRenaming();

		/**
		 * The meta object literal for the '<em><b>Fusion</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__FUSION = eINSTANCE.getComponentBodyType_Fusion();

		/**
		 * The meta object literal for the '<em><b>Split</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__SPLIT = eINSTANCE.getComponentBodyType_Split();

		/**
		 * The meta object literal for the '<em><b>Recursive Entry</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__RECURSIVE_ENTRY = eINSTANCE.getComponentBodyType_RecursiveEntry();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__INTERFACE = eINSTANCE.getComponentBodyType_Interface();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__UNIT = eINSTANCE.getComponentBodyType_Unit();

		/**
		 * The meta object literal for the '<em><b>Enumerator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__ENUMERATOR = eINSTANCE.getComponentBodyType_Enumerator();

		/**
		 * The meta object literal for the '<em><b>Fusions Of Replicators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_BODY_TYPE__FUSIONS_OF_REPLICATORS = eINSTANCE.getComponentBodyType_FusionsOfReplicators();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentHeaderTypeImpl <em>Header Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentHeaderTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentHeaderType()
		 * @generated
		 */
		EClass COMPONENT_HEADER_TYPE = eINSTANCE.getComponentHeaderType();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_HEADER_TYPE__BASE_TYPE = eINSTANCE.getComponentHeaderType_BaseType();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_HEADER_TYPE__VERSIONS = eINSTANCE.getComponentHeaderType_Versions();

		/**
		 * The meta object literal for the '<em><b>Visual Attributes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES = eINSTANCE.getComponentHeaderType_VisualAttributes();

		/**
		 * The meta object literal for the '<em><b>Hash Component UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID = eINSTANCE.getComponentHeaderType_HashComponentUID();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_HEADER_TYPE__IS_ABSTRACT = eINSTANCE.getComponentHeaderType_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_HEADER_TYPE__KIND = eINSTANCE.getComponentHeaderType_Kind();

		/**
		 * The meta object literal for the '<em><b>Location URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_HEADER_TYPE__LOCATION_URI = eINSTANCE.getComponentHeaderType_LocationURI();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_HEADER_TYPE__NAME = eINSTANCE.getComponentHeaderType_Name();

		/**
		 * The meta object literal for the '<em><b>Package Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_HEADER_TYPE__PACKAGE_PATH = eINSTANCE.getComponentHeaderType_PackagePath();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl <em>In Use Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentInUseType()
		 * @generated
		 */
		EClass COMPONENT_IN_USE_TYPE = eINSTANCE.getComponentInUseType();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getComponentInUseType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_IN_USE_TYPE__PARAMETER = eINSTANCE.getComponentInUseType_Parameter();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_IN_USE_TYPE__PORT = eINSTANCE.getComponentInUseType_Port();

		/**
		 * The meta object literal for the '<em><b>Unit Bounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_IN_USE_TYPE__UNIT_BOUNDS = eINSTANCE.getComponentInUseType_UnitBounds();

		/**
		 * The meta object literal for the '<em><b>Hash Component UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID = eINSTANCE.getComponentInUseType_HashComponentUID();

		/**
		 * The meta object literal for the '<em><b>Local Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IN_USE_TYPE__LOCAL_REF = eINSTANCE.getComponentInUseType_LocalRef();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IN_USE_TYPE__LOCATION = eINSTANCE.getComponentInUseType_Location();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IN_USE_TYPE__NAME = eINSTANCE.getComponentInUseType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IN_USE_TYPE__PACKAGE = eINSTANCE.getComponentInUseType_Package();

		/**
		 * The meta object literal for the '<em><b>Parameter Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IN_USE_TYPE__PARAMETER_ID = eINSTANCE.getComponentInUseType_ParameterId();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_IN_USE_TYPE__VERSION = eINSTANCE.getComponentInUseType_Version();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__HEADER = eINSTANCE.getComponentType_Header();

		/**
		 * The meta object literal for the '<em><b>Component Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__COMPONENT_INFO = eINSTANCE.getComponentType_ComponentInfo();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.DocumentRootImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__COMPONENT = eINSTANCE.getDocumentRoot_Component();

		/**
		 * The meta object literal for the '<em><b>New Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__NEW_ATTRIBUTE = eINSTANCE.getDocumentRoot_NewAttribute();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EntryTypeImpl <em>Entry Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EntryTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEntryType()
		 * @generated
		 */
		EClass ENTRY_TYPE = eINSTANCE.getEntryType();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getEntryType_VisualDescription();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableComponentTypeImpl <em>Enumerable Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableComponentTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableComponentType()
		 * @generated
		 */
		EClass ENUMERABLE_COMPONENT_TYPE = eINSTANCE.getEnumerableComponentType();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableEntryTypeImpl <em>Enumerable Entry Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableEntryTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableEntryType()
		 * @generated
		 */
		EClass ENUMERABLE_ENTRY_TYPE = eINSTANCE.getEnumerableEntryType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_ENTRY_TYPE__CREF = eINSTANCE.getEnumerableEntryType_CRef();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_ENTRY_TYPE__INDEX = eINSTANCE.getEnumerableEntryType_Index();

		/**
		 * The meta object literal for the '<em><b>URef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_ENTRY_TYPE__UREF = eINSTANCE.getEnumerableEntryType_URef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableTypeImpl <em>Enumerable Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableType()
		 * @generated
		 */
		EClass ENUMERABLE_TYPE = eINSTANCE.getEnumerableType();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_TYPE__REF = eINSTANCE.getEnumerableType_Ref();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitSliceTypeImpl <em>Enumerable Unit Slice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitSliceTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableUnitSliceType()
		 * @generated
		 */
		EClass ENUMERABLE_UNIT_SLICE_TYPE = eINSTANCE.getEnumerableUnitSliceType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_UNIT_SLICE_TYPE__CREF = eINSTANCE.getEnumerableUnitSliceType_CRef();

		/**
		 * The meta object literal for the '<em><b>Split Replica</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA = eINSTANCE.getEnumerableUnitSliceType_SplitReplica();

		/**
		 * The meta object literal for the '<em><b>SRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_UNIT_SLICE_TYPE__SREF = eINSTANCE.getEnumerableUnitSliceType_SRef();

		/**
		 * The meta object literal for the '<em><b>URef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERABLE_UNIT_SLICE_TYPE__UREF = eINSTANCE.getEnumerableUnitSliceType_URef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitTypeImpl <em>Enumerable Unit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumerableUnitTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumerableUnitType()
		 * @generated
		 */
		EClass ENUMERABLE_UNIT_TYPE = eINSTANCE.getEnumerableUnitType();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorFromRecursionTypeImpl <em>Enumerator From Recursion Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorFromRecursionTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumeratorFromRecursionType()
		 * @generated
		 */
		EClass ENUMERATOR_FROM_RECURSION_TYPE = eINSTANCE.getEnumeratorFromRecursionType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_FROM_RECURSION_TYPE__CREF = eINSTANCE.getEnumeratorFromRecursionType_CRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorRefTypeImpl <em>Enumerator Ref Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorRefTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumeratorRefType()
		 * @generated
		 */
		EClass ENUMERATOR_REF_TYPE = eINSTANCE.getEnumeratorRefType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_REF_TYPE__CREF = eINSTANCE.getEnumeratorRefType_CRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorTypeImpl <em>Enumerator Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.EnumeratorTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getEnumeratorType()
		 * @generated
		 */
		EClass ENUMERATOR_TYPE = eINSTANCE.getEnumeratorType();

		/**
		 * The meta object literal for the '<em><b>Origin Ref</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_TYPE__ORIGIN_REF = eINSTANCE.getEnumeratorType_OriginRef();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATOR_TYPE__LINKS = eINSTANCE.getEnumeratorType_Links();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATOR_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getEnumeratorType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>From Recursion</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATOR_TYPE__FROM_RECURSION = eINSTANCE.getEnumeratorType_FromRecursion();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_TYPE__CARDINALITY = eINSTANCE.getEnumeratorType_Cardinality();

		/**
		 * The meta object literal for the '<em><b>From Split</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_TYPE__FROM_SPLIT = eINSTANCE.getEnumeratorType_FromSplit();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_TYPE__REF = eINSTANCE.getEnumeratorType_Ref();

		/**
		 * The meta object literal for the '<em><b>Var Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_TYPE__VAR_ID = eINSTANCE.getEnumeratorType_VarId();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExposePortTypeImpl <em>Expose Port Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ExposePortTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getExposePortType()
		 * @generated
		 */
		EClass EXPOSE_PORT_TYPE = eINSTANCE.getExposePortType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPOSE_PORT_TYPE__CREF = eINSTANCE.getExposePortType_CRef();

		/**
		 * The meta object literal for the '<em><b>Exposed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPOSE_PORT_TYPE__EXPOSED = eINSTANCE.getExposePortType_Exposed();

		/**
		 * The meta object literal for the '<em><b>PRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPOSE_PORT_TYPE__PREF = eINSTANCE.getExposePortType_PRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtendsTypeImpl <em>Extends Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtendsTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getExtendsType()
		 * @generated
		 */
		EClass EXTENDS_TYPE = eINSTANCE.getExtendsType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_TYPE__CREF = eINSTANCE.getExtendsType_CRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtensionTypeTypeImpl <em>Extension Type Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ExtensionTypeTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getExtensionTypeType()
		 * @generated
		 */
		EClass EXTENSION_TYPE_TYPE = eINSTANCE.getExtensionTypeType();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TYPE_TYPE__IMPLEMENTS = eINSTANCE.getExtensionTypeType_Implements();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TYPE_TYPE__EXTENDS = eINSTANCE.getExtensionTypeType_Extends();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionOfReplicatorsTypeImpl <em>Fusion Of Replicators Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionOfReplicatorsTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getFusionOfReplicatorsType()
		 * @generated
		 */
		EClass FUSION_OF_REPLICATORS_TYPE = eINSTANCE.getFusionOfReplicatorsType();

		/**
		 * The meta object literal for the '<em><b>ERef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUSION_OF_REPLICATORS_TYPE__EREF = eINSTANCE.getFusionOfReplicatorsType_ERef();

		/**
		 * The meta object literal for the '<em><b>Origin Ref</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF = eINSTANCE.getFusionOfReplicatorsType_OriginRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionsOfReplicatorsTypeImpl <em>Fusions Of Replicators Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionsOfReplicatorsTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getFusionsOfReplicatorsType()
		 * @generated
		 */
		EClass FUSIONS_OF_REPLICATORS_TYPE = eINSTANCE.getFusionsOfReplicatorsType();

		/**
		 * The meta object literal for the '<em><b>Fusion Of Replicators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUSIONS_OF_REPLICATORS_TYPE__FUSION_OF_REPLICATORS = eINSTANCE.getFusionsOfReplicatorsType_FusionOfReplicators();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionTypeImpl <em>Fusion Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getFusionType()
		 * @generated
		 */
		EClass FUSION_TYPE = eINSTANCE.getFusionType();

		/**
		 * The meta object literal for the '<em><b>CRefs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUSION_TYPE__CREFS = eINSTANCE.getFusionType_CRefs();

		/**
		 * The meta object literal for the '<em><b>PRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUSION_TYPE__PREF = eINSTANCE.getFusionType_PRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ImplementsTypeImpl <em>Implements Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ImplementsTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getImplementsType()
		 * @generated
		 */
		EClass IMPLEMENTS_TYPE = eINSTANCE.getImplementsType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTS_TYPE__CREF = eINSTANCE.getImplementsType_CRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerComponentTypeImpl <em>Inner Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerComponentTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInnerComponentType()
		 * @generated
		 */
		EClass INNER_COMPONENT_TYPE = eINSTANCE.getInnerComponentType();

		/**
		 * The meta object literal for the '<em><b>Exposed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNER_COMPONENT_TYPE__EXPOSED = eINSTANCE.getInnerComponentType_Exposed();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerRenamingTypeImpl <em>Inner Renaming Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InnerRenamingTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInnerRenamingType()
		 * @generated
		 */
		EClass INNER_RENAMING_TYPE = eINSTANCE.getInnerRenamingType();

		/**
		 * The meta object literal for the '<em><b>CNew Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNER_RENAMING_TYPE__CNEW_NAME = eINSTANCE.getInnerRenamingType_CNewName();

		/**
		 * The meta object literal for the '<em><b>COld Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNER_RENAMING_TYPE__COLD_NAME = eINSTANCE.getInnerRenamingType_COldName();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNER_RENAMING_TYPE__CREF = eINSTANCE.getInnerRenamingType_CRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceParameterTypeImpl <em>Interface Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceParameterTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceParameterType()
		 * @generated
		 */
		EClass INTERFACE_PARAMETER_TYPE = eINSTANCE.getInterfaceParameterType();

		/**
		 * The meta object literal for the '<em><b>Iname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER_TYPE__INAME = eINSTANCE.getInterfaceParameterType_Iname();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER_TYPE__ORDER = eINSTANCE.getInterfaceParameterType_Order();

		/**
		 * The meta object literal for the '<em><b>Parid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER_TYPE__PARID = eINSTANCE.getInterfaceParameterType_Parid();

		/**
		 * The meta object literal for the '<em><b>Uname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER_TYPE__UNAME = eINSTANCE.getInterfaceParameterType_Uname();

		/**
		 * The meta object literal for the '<em><b>Varid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER_TYPE__VARID = eINSTANCE.getInterfaceParameterType_Varid();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfacePortTypeImpl <em>Interface Port Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfacePortTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfacePortType()
		 * @generated
		 */
		EClass INTERFACE_PORT_TYPE = eINSTANCE.getInterfacePortType();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_PORT_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getInterfacePortType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Slice</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_PORT_TYPE__SLICE = eINSTANCE.getInterfacePortType_Slice();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PORT_TYPE__NAME = eINSTANCE.getInterfacePortType_Name();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceRefTypeImpl <em>Interface Ref Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceRefTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceRefType()
		 * @generated
		 */
		EClass INTERFACE_REF_TYPE = eINSTANCE.getInterfaceRefType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_REF_TYPE__CREF = eINSTANCE.getInterfaceRefType_CRef();

		/**
		 * The meta object literal for the '<em><b>IRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_REF_TYPE__IREF = eINSTANCE.getInterfaceRefType_IRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceRefTypeImpl <em>Interface Slice Ref Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceRefTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceSliceRefType()
		 * @generated
		 */
		EClass INTERFACE_SLICE_REF_TYPE = eINSTANCE.getInterfaceSliceRefType();

		/**
		 * The meta object literal for the '<em><b>Component Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_SLICE_REF_TYPE__COMPONENT_REF = eINSTANCE.getInterfaceSliceRefType_ComponentRef();

		/**
		 * The meta object literal for the '<em><b>Interface Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_SLICE_REF_TYPE__INTERFACE_REF = eINSTANCE.getInterfaceSliceRefType_InterfaceRef();

		/**
		 * The meta object literal for the '<em><b>Slice Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_SLICE_REF_TYPE__SLICE_REF = eINSTANCE.getInterfaceSliceRefType_SliceRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceTypeImpl <em>Interface Slice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceSliceTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceSliceType()
		 * @generated
		 */
		EClass INTERFACE_SLICE_TYPE = eINSTANCE.getInterfaceSliceType();

		/**
		 * The meta object literal for the '<em><b>Origin Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_SLICE_TYPE__ORIGIN_REF = eINSTANCE.getInterfaceSliceType_OriginRef();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getInterfaceSliceType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Is Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_SLICE_TYPE__IS_REF = eINSTANCE.getInterfaceSliceType_IsRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl <em>Interface Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getInterfaceType()
		 * @generated
		 */
		EClass INTERFACE_TYPE = eINSTANCE.getInterfaceType();

		/**
		 * The meta object literal for the '<em><b>Slice</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__SLICE = eINSTANCE.getInterfaceType_Slice();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__PROTOCOL = eINSTANCE.getInterfaceType_Protocol();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__SOURCES = eINSTANCE.getInterfaceType_Sources();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getInterfaceType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__PORT = eINSTANCE.getInterfaceType_Port();

		/**
		 * The meta object literal for the '<em><b>External References</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_TYPE__EXTERNAL_REFERENCES = eINSTANCE.getInterfaceType_ExternalReferences();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_TYPE__PARAMETER = eINSTANCE.getInterfaceType_Parameter();

		/**
		 * The meta object literal for the '<em><b>IRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_TYPE__IREF = eINSTANCE.getInterfaceType_IRef();

		/**
		 * The meta object literal for the '<em><b>NArgs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_TYPE__NARGS = eINSTANCE.getInterfaceType_NArgs();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterRenamingImpl <em>Parameter Renaming</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterRenamingImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getParameterRenaming()
		 * @generated
		 */
		EClass PARAMETER_RENAMING = eINSTANCE.getParameterRenaming();

		/**
		 * The meta object literal for the '<em><b>Form Field Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_RENAMING__FORM_FIELD_ID = eINSTANCE.getParameterRenaming_FormFieldId();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_RENAMING__VAR_NAME = eINSTANCE.getParameterRenaming_VarName();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterSupplyTypeImpl <em>Parameter Supply Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterSupplyTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getParameterSupplyType()
		 * @generated
		 */
		EClass PARAMETER_SUPPLY_TYPE = eINSTANCE.getParameterSupplyType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_SUPPLY_TYPE__CREF = eINSTANCE.getParameterSupplyType_CRef();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_SUPPLY_TYPE__VAR_NAME = eINSTANCE.getParameterSupplyType_VarName();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterTypeImpl <em>Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getParameterType()
		 * @generated
		 */
		EClass PARAMETER_TYPE = eINSTANCE.getParameterType();

		/**
		 * The meta object literal for the '<em><b>Component Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__COMPONENT_REF = eINSTANCE.getParameterType_ComponentRef();

		/**
		 * The meta object literal for the '<em><b>Form Field Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__FORM_FIELD_ID = eINSTANCE.getParameterType_FormFieldId();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__VAR_NAME = eINSTANCE.getParameterType_VarName();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.PortSliceTypeImpl <em>Port Slice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.PortSliceTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getPortSliceType()
		 * @generated
		 */
		EClass PORT_SLICE_TYPE = eINSTANCE.getPortSliceType();

		/**
		 * The meta object literal for the '<em><b>PRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SLICE_TYPE__PREF = eINSTANCE.getPortSliceType_PRef();

		/**
		 * The meta object literal for the '<em><b>SRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SLICE_TYPE__SREF = eINSTANCE.getPortSliceType_SRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.PortTypeImpl <em>Port Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.PortTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getPortType()
		 * @generated
		 */
		EClass PORT_TYPE = eINSTANCE.getPortType();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getPortType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Exposed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_TYPE__EXPOSED = eINSTANCE.getPortType_Exposed();

		/**
		 * The meta object literal for the '<em><b>PRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_TYPE__PREF = eINSTANCE.getPortType_PRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.QuantificationVarTypeImpl <em>Quantification Var Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.QuantificationVarTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getQuantificationVarType()
		 * @generated
		 */
		EClass QUANTIFICATION_VAR_TYPE = eINSTANCE.getQuantificationVarType();

		/**
		 * The meta object literal for the '<em><b>QType</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTIFICATION_VAR_TYPE__QTYPE = eINSTANCE.getQuantificationVarType_QType();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTIFICATION_VAR_TYPE__VAR_NAME = eINSTANCE.getQuantificationVarType_VarName();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.RecursiveEntryTypeImpl <em>Recursive Entry Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.RecursiveEntryTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getRecursiveEntryType()
		 * @generated
		 */
		EClass RECURSIVE_ENTRY_TYPE = eINSTANCE.getRecursiveEntryType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSIVE_ENTRY_TYPE__CREF = eINSTANCE.getRecursiveEntryType_CRef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl <em>Source File Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSourceFileType()
		 * @generated
		 */
		EClass SOURCE_FILE_TYPE = eINSTANCE.getSourceFileType();

		/**
		 * The meta object literal for the '<em><b>Dependency</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__DEPENDENCY = eINSTANCE.getSourceFileType_Dependency();

		/**
		 * The meta object literal for the '<em><b>External Dependency</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY = eINSTANCE.getSourceFileType_ExternalDependency();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__CONTENTS = eINSTANCE.getSourceFileType_Contents();

		/**
		 * The meta object literal for the '<em><b>File Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__FILE_TYPE = eINSTANCE.getSourceFileType_FileType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__NAME = eINSTANCE.getSourceFileType_Name();

		/**
		 * The meta object literal for the '<em><b>Src Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__SRC_TYPE = eINSTANCE.getSourceFileType_SrcType();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__URI = eINSTANCE.getSourceFileType_Uri();

		/**
		 * The meta object literal for the '<em><b>Version Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_TYPE__VERSION_ID = eINSTANCE.getSourceFileType_VersionId();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceTypeImpl <em>Source Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSourceType()
		 * @generated
		 */
		EClass SOURCE_TYPE = eINSTANCE.getSourceType();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_TYPE__FILE = eINSTANCE.getSourceType_File();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_TYPE__SOURCE_TYPE = eINSTANCE.getSourceType_SourceType();

		/**
		 * The meta object literal for the '<em><b>Version Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_TYPE__VERSION_ID = eINSTANCE.getSourceType_VersionId();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitEnumeratorTypeImpl <em>Split Enumerator Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitEnumeratorTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSplitEnumeratorType()
		 * @generated
		 */
		EClass SPLIT_ENUMERATOR_TYPE = eINSTANCE.getSplitEnumeratorType();

		/**
		 * The meta object literal for the '<em><b>ERef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_ENUMERATOR_TYPE__EREF = eINSTANCE.getSplitEnumeratorType_ERef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitLinkTypeImpl <em>Split Link Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitLinkTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSplitLinkType()
		 * @generated
		 */
		EClass SPLIT_LINK_TYPE = eINSTANCE.getSplitLinkType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_LINK_TYPE__CREF = eINSTANCE.getSplitLinkType_CRef();

		/**
		 * The meta object literal for the '<em><b>URef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_LINK_TYPE__UREF = eINSTANCE.getSplitLinkType_URef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitTypeImpl <em>Split Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.SplitTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSplitType()
		 * @generated
		 */
		EClass SPLIT_TYPE = eINSTANCE.getSplitType();

		/**
		 * The meta object literal for the '<em><b>Split Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPLIT_TYPE__SPLIT_LINK = eINSTANCE.getSplitType_SplitLink();

		/**
		 * The meta object literal for the '<em><b>Split Enumerator</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_TYPE__SPLIT_ENUMERATOR = eINSTANCE.getSplitType_SplitEnumerator();

		/**
		 * The meta object literal for the '<em><b>Origin Ref</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_TYPE__ORIGIN_REF = eINSTANCE.getSplitType_OriginRef();

		/**
		 * The meta object literal for the '<em><b>CRef Permutation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_TYPE__CREF_PERMUTATION = eINSTANCE.getSplitType_CRefPermutation();

		/**
		 * The meta object literal for the '<em><b>ERef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_TYPE__EREF = eINSTANCE.getSplitType_ERef();

		/**
		 * The meta object literal for the '<em><b>N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT_TYPE__N = eINSTANCE.getSplitType_N();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitBoundsTypeImpl <em>Unit Bounds Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitBoundsTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitBoundsType()
		 * @generated
		 */
		EClass UNIT_BOUNDS_TYPE = eINSTANCE.getUnitBoundsType();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getUnitBoundsType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Replica</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_BOUNDS_TYPE__REPLICA = eINSTANCE.getUnitBoundsType_Replica();

		/**
		 * The meta object literal for the '<em><b>URef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_BOUNDS_TYPE__UREF = eINSTANCE.getUnitBoundsType_URef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitRefTypeImpl <em>Unit Ref Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitRefTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitRefType()
		 * @generated
		 */
		EClass UNIT_REF_TYPE = eINSTANCE.getUnitRefType();

		/**
		 * The meta object literal for the '<em><b>CRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_REF_TYPE__CREF = eINSTANCE.getUnitRefType_CRef();

		/**
		 * The meta object literal for the '<em><b>Replica</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_REF_TYPE__REPLICA = eINSTANCE.getUnitRefType_Replica();

		/**
		 * The meta object literal for the '<em><b>URef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_REF_TYPE__UREF = eINSTANCE.getUnitRefType_URef();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitSliceTypeImpl <em>Unit Slice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitSliceTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitSliceType()
		 * @generated
		 */
		EClass UNIT_SLICE_TYPE = eINSTANCE.getUnitSliceType();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_SLICE_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getUnitSliceType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_SLICE_TYPE__PORT = eINSTANCE.getUnitSliceType_Port();

		/**
		 * The meta object literal for the '<em><b>Slice Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_SLICE_TYPE__SLICE_NAME = eINSTANCE.getUnitSliceType_SliceName();

		/**
		 * The meta object literal for the '<em><b>Transitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_SLICE_TYPE__TRANSITIVE = eINSTANCE.getUnitSliceType_Transitive();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitTypeImpl <em>Unit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.UnitTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getUnitType()
		 * @generated
		 */
		EClass UNIT_TYPE = eINSTANCE.getUnitType();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_TYPE__SUPER = eINSTANCE.getUnitType_Super();

		/**
		 * The meta object literal for the '<em><b>Slices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_TYPE__SLICES = eINSTANCE.getUnitType_Slices();

		/**
		 * The meta object literal for the '<em><b>Visual Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_TYPE__VISUAL_DESCRIPTION = eINSTANCE.getUnitType_VisualDescription();

		/**
		 * The meta object literal for the '<em><b>IRef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TYPE__IREF = eINSTANCE.getUnitType_IRef();

		/**
		 * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TYPE__PRIVATE = eINSTANCE.getUnitType_Private();

		/**
		 * The meta object literal for the '<em><b>URef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TYPE__UREF = eINSTANCE.getUnitType_URef();

		/**
		 * The meta object literal for the '<em><b>Visible Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_TYPE__VISIBLE_INTERFACE = eINSTANCE.getUnitType_VisibleInterface();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.VersionTypeImpl <em>Version Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.VersionTypeImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getVersionType()
		 * @generated
		 */
		EClass VERSION_TYPE = eINSTANCE.getVersionType();

		/**
		 * The meta object literal for the '<em><b>Field1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_TYPE__FIELD1 = eINSTANCE.getVersionType_Field1();

		/**
		 * The meta object literal for the '<em><b>Field2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_TYPE__FIELD2 = eINSTANCE.getVersionType_Field2();

		/**
		 * The meta object literal for the '<em><b>Field3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_TYPE__FIELD3 = eINSTANCE.getVersionType_Field3();

		/**
		 * The meta object literal for the '<em><b>Field4</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_TYPE__FIELD4 = eINSTANCE.getVersionType_Field4();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.VisualElementAttributesImpl <em>Visual Element Attributes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.VisualElementAttributesImpl
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getVisualElementAttributes()
		 * @generated
		 */
		EClass VISUAL_ELEMENT_ATTRIBUTES = eINSTANCE.getVisualElementAttributes();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUAL_ELEMENT_ATTRIBUTES__COLOR = eINSTANCE.getVisualElementAttributes_Color();

		/**
		 * The meta object literal for the '<em><b>H</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISUAL_ELEMENT_ATTRIBUTES__H = eINSTANCE.getVisualElementAttributes_H();

		/**
		 * The meta object literal for the '<em><b>W</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISUAL_ELEMENT_ATTRIBUTES__W = eINSTANCE.getVisualElementAttributes_W();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISUAL_ELEMENT_ATTRIBUTES__X = eINSTANCE.getVisualElementAttributes_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISUAL_ELEMENT_ATTRIBUTES__Y = eINSTANCE.getVisualElementAttributes_Y();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType <em>Quantification Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getQuantificationType()
		 * @generated
		 */
		EEnum QUANTIFICATION_TYPE = eINSTANCE.getQuantificationType();

		/**
		 * The meta object literal for the '{@link br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds <em>Supported Kinds</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSupportedKinds()
		 * @generated
		 */
		EEnum SUPPORTED_KINDS = eINSTANCE.getSupportedKinds();

		/**
		 * The meta object literal for the '<em>Quantification Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.QuantificationType
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getQuantificationTypeObject()
		 * @generated
		 */
		EDataType QUANTIFICATION_TYPE_OBJECT = eINSTANCE.getQuantificationTypeObject();

		/**
		 * The meta object literal for the '<em>Supported Kinds Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
		 * @see br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentPackageImpl#getSupportedKindsObject()
		 * @generated
		 */
		EDataType SUPPORTED_KINDS_OBJECT = eINSTANCE.getSupportedKindsObject();

	}

} //ComponentPackage
