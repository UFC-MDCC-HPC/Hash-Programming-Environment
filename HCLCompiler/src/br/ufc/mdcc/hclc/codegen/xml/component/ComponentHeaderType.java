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
 * A representation of the model object '<em><b>Header Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getVersions <em>Versions</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getVisualAttributes <em>Visual Attributes</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getHashComponentUID <em>Hash Component UID</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getKind <em>Kind</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getLocationURI <em>Location URI</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getName <em>Name</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getPackagePath <em>Package Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType()
 * @model extendedMetaData="name='ComponentHeaderType' kind='elementOnly'"
 * @generated
 */
public interface ComponentHeaderType extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Type</em>' containment reference.
	 * @see #setBaseType(BaseTypeType)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_BaseType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='baseType'"
	 * @generated
	 */
	BaseTypeType getBaseType();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getBaseType <em>Base Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Type</em>' containment reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(BaseTypeType value);

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link br.ufc.mdcc.hclc.codegen.xml.component.VersionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Versions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_Versions()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='versions'"
	 * @generated
	 */
	EList<VersionType> getVersions();

	/**
	 * Returns the value of the '<em><b>Visual Attributes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual Attributes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual Attributes</em>' containment reference.
	 * @see #setVisualAttributes(VisualElementAttributes)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_VisualAttributes()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualAttributes'"
	 * @generated
	 */
	VisualElementAttributes getVisualAttributes();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getVisualAttributes <em>Visual Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Attributes</em>' containment reference.
	 * @see #getVisualAttributes()
	 * @generated
	 */
	void setVisualAttributes(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>Hash Component UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hash Component UID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hash Component UID</em>' attribute.
	 * @see #setHashComponentUID(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_HashComponentUID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hash_component_UID'"
	 * @generated
	 */
	String getHashComponentUID();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getHashComponentUID <em>Hash Component UID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hash Component UID</em>' attribute.
	 * @see #getHashComponentUID()
	 * @generated
	 */
	void setHashComponentUID(String value);

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #isSetIsAbstract()
	 * @see #unsetIsAbstract()
	 * @see #setIsAbstract(boolean)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_IsAbstract()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isAbstract'"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isSetIsAbstract()
	 * @see #unsetIsAbstract()
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsAbstract()
	 * @see #isIsAbstract()
	 * @see #setIsAbstract(boolean)
	 * @generated
	 */
	void unsetIsAbstract();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#isIsAbstract <em>Is Abstract</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Abstract</em>' attribute is set.
	 * @see #unsetIsAbstract()
	 * @see #isIsAbstract()
	 * @see #setIsAbstract(boolean)
	 * @generated
	 */
	boolean isSetIsAbstract();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #setKind(SupportedKinds)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_Kind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='kind'"
	 * @generated
	 */
	SupportedKinds getKind();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #getKind()
	 * @generated
	 */
	void setKind(SupportedKinds value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKind()
	 * @see #getKind()
	 * @see #setKind(SupportedKinds)
	 * @generated
	 */
	void unsetKind();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getKind <em>Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kind</em>' attribute is set.
	 * @see #unsetKind()
	 * @see #getKind()
	 * @see #setKind(SupportedKinds)
	 * @generated
	 */
	boolean isSetKind();

	/**
	 * Returns the value of the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location URI</em>' attribute.
	 * @see #setLocationURI(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_LocationURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='locationURI'"
	 * @generated
	 */
	String getLocationURI();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getLocationURI <em>Location URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location URI</em>' attribute.
	 * @see #getLocationURI()
	 * @generated
	 */
	void setLocationURI(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Package Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Path</em>' attribute.
	 * @see #setPackagePath(String)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getComponentHeaderType_PackagePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='packagePath'"
	 * @generated
	 */
	String getPackagePath();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType#getPackagePath <em>Package Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Path</em>' attribute.
	 * @see #getPackagePath()
	 * @generated
	 */
	void setPackagePath(String value);

} // ComponentHeaderType
