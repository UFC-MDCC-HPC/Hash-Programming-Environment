/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Type Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ExtensionTypeType#isImplements <em>Implements</em>}</li>
 *   <li>{@link hPE.xml.component.ExtensionTypeType#isExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getExtensionTypeType()
 * @model extendedMetaData="name='ExtensionTypeType' kind='elementOnly'"
 * @generated
 */
public interface ExtensionTypeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Implements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' attribute.
	 * @see #isSetImplements()
	 * @see #unsetImplements()
	 * @see #setImplements(boolean)
	 * @see hPE.xml.component.ComponentPackage#getExtensionTypeType_Implements()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='implements'"
	 * @generated
	 */
	boolean isImplements();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ExtensionTypeType#isImplements <em>Implements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements</em>' attribute.
	 * @see #isSetImplements()
	 * @see #unsetImplements()
	 * @see #isImplements()
	 * @generated
	 */
	void setImplements(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.ExtensionTypeType#isImplements <em>Implements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetImplements()
	 * @see #isImplements()
	 * @see #setImplements(boolean)
	 * @generated
	 */
	void unsetImplements();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.ExtensionTypeType#isImplements <em>Implements</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Implements</em>' attribute is set.
	 * @see #unsetImplements()
	 * @see #isImplements()
	 * @see #setImplements(boolean)
	 * @generated
	 */
	boolean isSetImplements();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' attribute.
	 * @see #isSetExtends()
	 * @see #unsetExtends()
	 * @see #setExtends(boolean)
	 * @see hPE.xml.component.ComponentPackage#getExtensionTypeType_Extends()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='extends'"
	 * @generated
	 */
	boolean isExtends();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ExtensionTypeType#isExtends <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' attribute.
	 * @see #isSetExtends()
	 * @see #unsetExtends()
	 * @see #isExtends()
	 * @generated
	 */
	void setExtends(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.ExtensionTypeType#isExtends <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExtends()
	 * @see #isExtends()
	 * @see #setExtends(boolean)
	 * @generated
	 */
	void unsetExtends();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.ExtensionTypeType#isExtends <em>Extends</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Extends</em>' attribute is set.
	 * @see #unsetExtends()
	 * @see #isExtends()
	 * @see #setExtends(boolean)
	 * @generated
	 */
	boolean isSetExtends();

} // ExtensionTypeType
