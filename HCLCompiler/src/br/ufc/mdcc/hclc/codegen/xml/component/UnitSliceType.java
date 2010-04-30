/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Slice Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getPort <em>Port</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getSliceName <em>Slice Name</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#isTransitive <em>Transitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitSliceType()
 * @model extendedMetaData="name='UnitSliceType' kind='elementOnly'"
 * @generated
 */
public interface UnitSliceType extends UnitRefType {
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
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitSliceType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute list.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitSliceType_Port()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='port'"
	 * @generated
	 */
	EList<String> getPort();

	/**
	 * Returns the value of the '<em><b>Slice Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice Name</em>' attribute.
	 * @see #setSliceName(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitSliceType_SliceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sliceName'"
	 * @generated
	 */
	String getSliceName();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#getSliceName <em>Slice Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Name</em>' attribute.
	 * @see #getSliceName()
	 * @generated
	 */
	void setSliceName(String value);

	/**
	 * Returns the value of the '<em><b>Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitive</em>' attribute.
	 * @see #isSetTransitive()
	 * @see #unsetTransitive()
	 * @see #setTransitive(boolean)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getUnitSliceType_Transitive()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='transitive'"
	 * @generated
	 */
	boolean isTransitive();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#isTransitive <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transitive</em>' attribute.
	 * @see #isSetTransitive()
	 * @see #unsetTransitive()
	 * @see #isTransitive()
	 * @generated
	 */
	void setTransitive(boolean value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#isTransitive <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransitive()
	 * @see #isTransitive()
	 * @see #setTransitive(boolean)
	 * @generated
	 */
	void unsetTransitive();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType#isTransitive <em>Transitive</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transitive</em>' attribute is set.
	 * @see #unsetTransitive()
	 * @see #isTransitive()
	 * @see #setTransitive(boolean)
	 * @generated
	 */
	boolean isSetTransitive();

} // UnitSliceType
