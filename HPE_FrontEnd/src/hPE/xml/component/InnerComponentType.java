/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inner Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.InnerComponentType#isExposed <em>Exposed</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getInnerComponentType()
 * @model extendedMetaData="name='InnerComponentType' kind='elementOnly'"
 * @generated
 */
public interface InnerComponentType extends ComponentInUseType {
	/**
	 * Returns the value of the '<em><b>Exposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exposed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exposed</em>' attribute.
	 * @see #isSetExposed()
	 * @see #unsetExposed()
	 * @see #setExposed(boolean)
	 * @see hPE.xml.component.ComponentPackage#getInnerComponentType_Exposed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='exposed'"
	 * @generated
	 */
	boolean isExposed();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InnerComponentType#isExposed <em>Exposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exposed</em>' attribute.
	 * @see #isSetExposed()
	 * @see #unsetExposed()
	 * @see #isExposed()
	 * @generated
	 */
	void setExposed(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.InnerComponentType#isExposed <em>Exposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExposed()
	 * @see #isExposed()
	 * @see #setExposed(boolean)
	 * @generated
	 */
	void unsetExposed();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.InnerComponentType#isExposed <em>Exposed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exposed</em>' attribute is set.
	 * @see #unsetExposed()
	 * @see #isExposed()
	 * @see #setExposed(boolean)
	 * @generated
	 */
	boolean isSetExposed();

} // InnerComponentType
