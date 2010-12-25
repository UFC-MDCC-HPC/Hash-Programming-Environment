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
 * A representation of the model object '<em><b>Extends Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ExtendsType#getCRef <em>CRef</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getExtendsType()
 * @model extendedMetaData="name='ExtendsType' kind='elementOnly'"
 * @generated
 */
public interface ExtendsType extends EObject {
	/**
	 * Returns the value of the '<em><b>CRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CRef</em>' attribute.
	 * @see #setCRef(String)
	 * @see hPE.xml.component.ComponentPackage#getExtendsType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ExtendsType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

} // ExtendsType
