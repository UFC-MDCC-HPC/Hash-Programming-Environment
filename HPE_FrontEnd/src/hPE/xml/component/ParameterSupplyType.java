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
 * A representation of the model object '<em><b>Parameter Supply Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ParameterSupplyType#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.ParameterSupplyType#isDirect <em>Direct</em>}</li>
 *   <li>{@link hPE.xml.component.ParameterSupplyType#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getParameterSupplyType()
 * @model extendedMetaData="name='ParameterSupplyType' kind='empty'"
 * @generated
 */
public interface ParameterSupplyType extends EObject {
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
	 * @see hPE.xml.component.ComponentPackage#getParameterSupplyType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterSupplyType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

	/**
	 * Returns the value of the '<em><b>Direct</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct</em>' attribute.
	 * @see #isSetDirect()
	 * @see #unsetDirect()
	 * @see #setDirect(boolean)
	 * @see hPE.xml.component.ComponentPackage#getParameterSupplyType_Direct()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='direct'"
	 * @generated
	 */
	boolean isDirect();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterSupplyType#isDirect <em>Direct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direct</em>' attribute.
	 * @see #isSetDirect()
	 * @see #unsetDirect()
	 * @see #isDirect()
	 * @generated
	 */
	void setDirect(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.ParameterSupplyType#isDirect <em>Direct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirect()
	 * @see #isDirect()
	 * @see #setDirect(boolean)
	 * @generated
	 */
	void unsetDirect();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.ParameterSupplyType#isDirect <em>Direct</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Direct</em>' attribute is set.
	 * @see #unsetDirect()
	 * @see #isDirect()
	 * @see #setDirect(boolean)
	 * @generated
	 */
	boolean isSetDirect();

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
	 * @see hPE.xml.component.ComponentPackage#getParameterSupplyType_VarName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='varName'"
	 * @generated
	 */
	String getVarName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ParameterSupplyType#getVarName <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' attribute.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(String value);

} // ParameterSupplyType
