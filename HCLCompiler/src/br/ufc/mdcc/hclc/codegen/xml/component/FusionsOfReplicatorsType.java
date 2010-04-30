/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fusions Of Replicators Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.FusionsOfReplicatorsType#getFusionOfReplicators <em>Fusion Of Replicators</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getFusionsOfReplicatorsType()
 * @model extendedMetaData="name='FusionsOfReplicatorsType' kind='elementOnly'"
 * @generated
 */
public interface FusionsOfReplicatorsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Fusion Of Replicators</b></em>' containment reference list.
	 * The list contents are of type {@link br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fusion Of Replicators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fusion Of Replicators</em>' containment reference list.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getFusionsOfReplicatorsType_FusionOfReplicators()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='fusionOfReplicators'"
	 * @generated
	 */
	EList<FusionOfReplicatorsType> getFusionOfReplicators();

} // FusionsOfReplicatorsType
