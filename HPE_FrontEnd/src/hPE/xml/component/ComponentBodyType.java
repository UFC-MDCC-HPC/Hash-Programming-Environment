/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Body Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		The elements are in the "workflow order" ...
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getGroup <em>Group</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getInnerComponent <em>Inner Component</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getSupplyParameter <em>Supply Parameter</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getInnerRenaming <em>Inner Renaming</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getFusion <em>Fusion</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getSplit <em>Split</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getRecursiveEntry <em>Recursive Entry</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getInterface <em>Interface</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getUnit <em>Unit</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getEnumerator <em>Enumerator</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getFusionsOfReplicators <em>Fusions Of Replicators</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentBodyType#getExternalLibrary <em>External Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getComponentBodyType()
 * @model extendedMetaData="name='ComponentBodyType' kind='elementOnly'"
 * @generated
 */
public interface ComponentBodyType extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Inner Component</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.InnerComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Component</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_InnerComponent()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='innerComponent' group='#group:0'"
	 * @generated
	 */
	EList<InnerComponentType> getInnerComponent();

	/**
	 * Returns the value of the '<em><b>Supply Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ParameterSupplyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supply Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supply Parameter</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_SupplyParameter()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='supplyParameter' group='#group:0'"
	 * @generated
	 */
	EList<ParameterSupplyType> getSupplyParameter();

	/**
	 * Returns the value of the '<em><b>Inner Renaming</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.InnerRenamingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Renaming</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Renaming</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_InnerRenaming()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='innerRenaming' group='#group:0'"
	 * @generated
	 */
	EList<InnerRenamingType> getInnerRenaming();

	/**
	 * Returns the value of the '<em><b>Fusion</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.FusionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fusion</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fusion</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_Fusion()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='fusion' group='#group:0'"
	 * @generated
	 */
	EList<FusionType> getFusion();

	/**
	 * Returns the value of the '<em><b>Recursive Entry</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.RecursiveEntryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recursive Entry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recursive Entry</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_RecursiveEntry()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='recursiveEntry' group='#group:0'"
	 * @generated
	 */
	EList<RecursiveEntryType> getRecursiveEntry();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ParameterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_Parameter()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='parameter' group='#group:0'"
	 * @generated
	 */
	EList<ParameterType> getParameter();

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.InterfaceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_Interface()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface' group='#group:0'"
	 * @generated
	 */
	EList<InterfaceType> getInterface();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.UnitType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_Unit()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit' group='#group:0'"
	 * @generated
	 */
	EList<UnitType> getUnit();

	/**
	 * Returns the value of the '<em><b>Enumerator</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.EnumeratorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerator</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_Enumerator()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='enumerator' group='#group:0'"
	 * @generated
	 */
	EList<EnumeratorType> getEnumerator();

	/**
	 * Returns the value of the '<em><b>Fusions Of Replicators</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.FusionsOfReplicatorsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fusions Of Replicators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fusions Of Replicators</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_FusionsOfReplicators()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='fusionsOfReplicators' group='#group:0'"
	 * @generated
	 */
	EList<FusionsOfReplicatorsType> getFusionsOfReplicators();

	/**
	 * Returns the value of the '<em><b>External Library</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ExternalLibraryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Library</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Library</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_ExternalLibrary()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='externalLibrary' group='#group:0'"
	 * @generated
	 */
	EList<ExternalLibraryType> getExternalLibrary();

	/**
	 * Returns the value of the '<em><b>Split</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.SplitType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentBodyType_Split()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='split' group='#group:0'"
	 * @generated
	 */
	EList<SplitType> getSplit();

} // ComponentBodyType
