/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.base.externalreferences;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.base.externalreferences.ReferenceType#getAlias <em>Alias</em>}</li>
 *   <li>{@link hPE.frontend.base.externalreferences.ReferenceType#getDescription <em>Description</em>}</li>
 *   <li>{@link hPE.frontend.base.externalreferences.ReferenceType#getDestailedName <em>Destailed Name</em>}</li>
 *   <li>{@link hPE.frontend.base.externalreferences.ReferenceType#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.base.externalreferences.ExternalreferencesPackage#getReferenceType()
 * @model extendedMetaData="name='ReferenceType' kind='elementOnly'"
 * @generated
 */
public interface ReferenceType extends EObject {
	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute list.
	 * @see hPE.frontend.base.externalreferences.ExternalreferencesPackage#getReferenceType_Alias()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='alias' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getAlias();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see hPE.frontend.base.externalreferences.ExternalreferencesPackage#getReferenceType_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link hPE.frontend.base.externalreferences.ReferenceType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Destailed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destailed Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destailed Name</em>' attribute.
	 * @see #setDestailedName(String)
	 * @see hPE.frontend.base.externalreferences.ExternalreferencesPackage#getReferenceType_DestailedName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='destailedName'"
	 * @generated
	 */
	String getDestailedName();

	/**
	 * Sets the value of the '{@link hPE.frontend.base.externalreferences.ReferenceType#getDestailedName <em>Destailed Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destailed Name</em>' attribute.
	 * @see #getDestailedName()
	 * @generated
	 */
	void setDestailedName(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see hPE.frontend.base.externalreferences.ExternalreferencesPackage#getReferenceType_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='path'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link hPE.frontend.base.externalreferences.ReferenceType#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // ReferenceType
