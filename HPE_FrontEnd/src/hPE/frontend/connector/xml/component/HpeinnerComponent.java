/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hpeinner Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getKind <em>Kind</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getType <em>Type</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getAccess <em>Access</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HpeinnerComponent#isExportActions <em>Export Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeinnerComponent()
 * @model extendedMetaData="name='hpeinnerComponent' kind='elementOnly'"
 * @generated
 */
public interface HpeinnerComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link hPE.frontend.connector.xml.component.Hpekind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see hPE.frontend.connector.xml.component.Hpekind
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #setKind(Hpekind)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeinnerComponent_Kind()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='element' name='kind'"
	 * @generated
	 */
	Hpekind getKind();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see hPE.frontend.connector.xml.component.Hpekind
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #getKind()
	 * @generated
	 */
	void setKind(Hpekind value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKind()
	 * @see #getKind()
	 * @see #setKind(Hpekind)
	 * @generated
	 */
	void unsetKind();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getKind <em>Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kind</em>' attribute is set.
	 * @see #unsetKind()
	 * @see #getKind()
	 * @see #setKind(Hpekind)
	 * @generated
	 */
	boolean isSetKind();

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeinnerComponent_Identifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='identifier'"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Hpetype)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeinnerComponent_Type()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='type'"
	 * @generated
	 */
	Hpetype getType();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Hpetype value);

	/**
	 * Returns the value of the '<em><b>Access</b></em>' attribute.
	 * The literals are from the enumeration {@link hPE.frontend.connector.xml.component.AccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' attribute.
	 * @see hPE.frontend.connector.xml.component.AccessType
	 * @see #isSetAccess()
	 * @see #unsetAccess()
	 * @see #setAccess(AccessType)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeinnerComponent_Access()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='element' name='access'"
	 * @generated
	 */
	AccessType getAccess();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getAccess <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' attribute.
	 * @see hPE.frontend.connector.xml.component.AccessType
	 * @see #isSetAccess()
	 * @see #unsetAccess()
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(AccessType value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getAccess <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAccess()
	 * @see #getAccess()
	 * @see #setAccess(AccessType)
	 * @generated
	 */
	void unsetAccess();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#getAccess <em>Access</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Access</em>' attribute is set.
	 * @see #unsetAccess()
	 * @see #getAccess()
	 * @see #setAccess(AccessType)
	 * @generated
	 */
	boolean isSetAccess();

	/**
	 * Returns the value of the '<em><b>Export Actions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Actions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Actions</em>' attribute.
	 * @see #isSetExportActions()
	 * @see #unsetExportActions()
	 * @see #setExportActions(boolean)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHpeinnerComponent_ExportActions()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='element' name='exportActions'"
	 * @generated
	 */
	boolean isExportActions();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#isExportActions <em>Export Actions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Actions</em>' attribute.
	 * @see #isSetExportActions()
	 * @see #unsetExportActions()
	 * @see #isExportActions()
	 * @generated
	 */
	void setExportActions(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#isExportActions <em>Export Actions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExportActions()
	 * @see #isExportActions()
	 * @see #setExportActions(boolean)
	 * @generated
	 */
	void unsetExportActions();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.connector.xml.component.HpeinnerComponent#isExportActions <em>Export Actions</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Export Actions</em>' attribute is set.
	 * @see #unsetExportActions()
	 * @see #isExportActions()
	 * @see #setExportActions(boolean)
	 * @generated
	 */
	boolean isSetExportActions();

} // HpeinnerComponent
