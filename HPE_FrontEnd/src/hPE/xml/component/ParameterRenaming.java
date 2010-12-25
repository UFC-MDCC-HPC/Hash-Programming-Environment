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
 * A representation of the model object '<em><b>Parameter Renaming</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ParameterRenaming#getFormFieldId <em>Form Field Id</em>}</li>
 *   <li>{@link hPE.xml.component.ParameterRenaming#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getParameterRenaming()
 * @model extendedMetaData="name='ParameterRenaming' kind='empty'"
 * @generated
 */
public interface ParameterRenaming extends EObject {
	/**
	 * Returns the value of the '<em><b>Form Field Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Field Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Field Id</em>' attribute.
	 * @see #setFormFieldId(String)
	 * @see hPE.xml.component.ComponentPackage#getParameterRenaming_FormFieldId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='formFieldId'"
	 * @generated
	 */
	String getFormFieldId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterRenaming#getFormFieldId <em>Form Field Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Form Field Id</em>' attribute.
	 * @see #getFormFieldId()
	 * @generated
	 */
	void setFormFieldId(String value);

	/**
	 * Returns the value of the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Name</em>' attribute.
	 * @see #setVarName(String)
	 * @see hPE.xml.component.ComponentPackage#getParameterRenaming_VarName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='varName'"
	 * @generated
	 */
	String getVarName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterRenaming#getVarName <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' attribute.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(String value);

} // ParameterRenaming
