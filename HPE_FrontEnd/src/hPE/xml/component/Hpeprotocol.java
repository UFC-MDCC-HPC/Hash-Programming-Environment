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
 * A representation of the model object '<em><b>Hpeprotocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.Hpeprotocol#getGroup <em>Group</em>}</li>
 *   <li>{@link hPE.xml.component.Hpeprotocol#getAction <em>Action</em>}</li>
 *   <li>{@link hPE.xml.component.Hpeprotocol#getSeq <em>Seq</em>}</li>
 *   <li>{@link hPE.xml.component.Hpeprotocol#getPar <em>Par</em>}</li>
 *   <li>{@link hPE.xml.component.Hpeprotocol#getAlt <em>Alt</em>}</li>
 *   <li>{@link hPE.xml.component.Hpeprotocol#getIf <em>If</em>}</li>
 *   <li>{@link hPE.xml.component.Hpeprotocol#getLoop <em>Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getHpeprotocol()
 * @model abstract="true"
 *        extendedMetaData="name='hpeprotocol' kind='elementOnly'"
 * @generated
 */
public interface Hpeprotocol extends EObject {
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
	 * @see hPE.xml.component.ComponentPackage#getHpeprotocol_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ActionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getHpeprotocol_Action()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='action' group='#group:0'"
	 * @generated
	 */
	EList<ActionType> getAction();

	/**
	 * Returns the value of the '<em><b>Seq</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.SeqType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seq</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seq</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getHpeprotocol_Seq()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='seq' group='#group:0'"
	 * @generated
	 */
	EList<SeqType> getSeq();

	/**
	 * Returns the value of the '<em><b>Par</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ParType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Par</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Par</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getHpeprotocol_Par()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='par' group='#group:0'"
	 * @generated
	 */
	EList<ParType> getPar();

	/**
	 * Returns the value of the '<em><b>Alt</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.AltType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alt</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alt</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getHpeprotocol_Alt()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='alt' group='#group:0'"
	 * @generated
	 */
	EList<AltType> getAlt();

	/**
	 * Returns the value of the '<em><b>If</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.IfType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getHpeprotocol_If()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='if' group='#group:0'"
	 * @generated
	 */
	EList<IfType> getIf();

	/**
	 * Returns the value of the '<em><b>Loop</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.LoopType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getHpeprotocol_Loop()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='loop' group='#group:0'"
	 * @generated
	 */
	EList<LoopType> getLoop();

} // Hpeprotocol
