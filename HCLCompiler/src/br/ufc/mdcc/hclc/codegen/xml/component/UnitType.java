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
 * A representation of the model object '<em><b>Unit Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getSuper <em>Super</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getSlices <em>Slices</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getIRef <em>IRef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isPrivate <em>Private</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getURef <em>URef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isVisibleInterface <em>Visible Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType()
 * @model extendedMetaData="name='UnitType' kind='elementOnly'"
 * @generated
 */
public interface UnitType extends EObject {
	/**
	 * Returns the value of the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' containment reference.
	 * @see #setSuper(UnitRefType)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType_Super()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='super'"
	 * @generated
	 */
	UnitRefType getSuper();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getSuper <em>Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super</em>' containment reference.
	 * @see #getSuper()
	 * @generated
	 */
	void setSuper(UnitRefType value);

	/**
	 * Returns the value of the '<em><b>Slices</b></em>' containment reference list.
	 * The list contents are of type {@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slices</em>' containment reference list.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType_Slices()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='slices'"
	 * @generated
	 */
	EList<UnitSliceType> getSlices();

	/**
	 * Returns the value of the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual Description</em>' containment reference.
	 * @see #setVisualDescription(VisualElementAttributes)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>IRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IRef</em>' attribute.
	 * @see #setIRef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType_IRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='iRef'"
	 * @generated
	 */
	String getIRef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getIRef <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IRef</em>' attribute.
	 * @see #getIRef()
	 * @generated
	 */
	void setIRef(String value);

	/**
	 * Returns the value of the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Private</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Private</em>' attribute.
	 * @see #isSetPrivate()
	 * @see #unsetPrivate()
	 * @see #setPrivate(boolean)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType_Private()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='private'"
	 * @generated
	 */
	boolean isPrivate();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Private</em>' attribute.
	 * @see #isSetPrivate()
	 * @see #unsetPrivate()
	 * @see #isPrivate()
	 * @generated
	 */
	void setPrivate(boolean value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrivate()
	 * @see #isPrivate()
	 * @see #setPrivate(boolean)
	 * @generated
	 */
	void unsetPrivate();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isPrivate <em>Private</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Private</em>' attribute is set.
	 * @see #unsetPrivate()
	 * @see #isPrivate()
	 * @see #setPrivate(boolean)
	 * @generated
	 */
	boolean isSetPrivate();

	/**
	 * Returns the value of the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URef</em>' attribute.
	 * @see #setURef(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType_URef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='uRef'"
	 * @generated
	 */
	String getURef();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#getURef <em>URef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URef</em>' attribute.
	 * @see #getURef()
	 * @generated
	 */
	void setURef(String value);

	/**
	 * Returns the value of the '<em><b>Visible Interface</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Interface</em>' attribute.
	 * @see #isSetVisibleInterface()
	 * @see #unsetVisibleInterface()
	 * @see #setVisibleInterface(boolean)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitType_VisibleInterface()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='visibleInterface'"
	 * @generated
	 */
	boolean isVisibleInterface();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isVisibleInterface <em>Visible Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Interface</em>' attribute.
	 * @see #isSetVisibleInterface()
	 * @see #unsetVisibleInterface()
	 * @see #isVisibleInterface()
	 * @generated
	 */
	void setVisibleInterface(boolean value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isVisibleInterface <em>Visible Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleInterface()
	 * @see #isVisibleInterface()
	 * @see #setVisibleInterface(boolean)
	 * @generated
	 */
	void unsetVisibleInterface();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitType#isVisibleInterface <em>Visible Interface</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Interface</em>' attribute is set.
	 * @see #unsetVisibleInterface()
	 * @see #isVisibleInterface()
	 * @see #setVisibleInterface(boolean)
	 * @generated
	 */
	boolean isSetVisibleInterface();

} // UnitType
