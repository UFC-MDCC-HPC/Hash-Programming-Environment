/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hash Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getPackage <em>Package</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getUsing <em>Using</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getKind <em>Kind</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getName <em>Name</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getInnerComponent <em>Inner Component</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getSuperComponent <em>Super Component</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.HashComponentType#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType()
 * @model extendedMetaData="name='hashComponentType' kind='elementOnly'"
 * @generated
 */
public interface HashComponentType extends EObject {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_Package()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='package'"
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HashComponentType#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

	/**
	 * Returns the value of the '<em><b>Using</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using</em>' attribute list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_Using()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='using'"
	 * @generated
	 */
	EList<String> getUsing();

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
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_Kind()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='element' name='kind'"
	 * @generated
	 */
	Hpekind getKind();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HashComponentType#getKind <em>Kind</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.frontend.connector.xml.component.HashComponentType#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKind()
	 * @see #getKind()
	 * @see #setKind(Hpekind)
	 * @generated
	 */
	void unsetKind();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.connector.xml.component.HashComponentType#getKind <em>Kind</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HashComponentType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.connector.xml.component.Hpeparameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameter'"
	 * @generated
	 */
	EList<Hpeparameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Inner Component</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.connector.xml.component.HpeinnerComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Component</em>' containment reference list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_InnerComponent()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='innerComponent'"
	 * @generated
	 */
	EList<HpeinnerComponent> getInnerComponent();

	/**
	 * Returns the value of the '<em><b>Super Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Component</em>' containment reference.
	 * @see #setSuperComponent(Hpetype)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_SuperComponent()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='superComponent'"
	 * @generated
	 */
	Hpetype getSuperComponent();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.HashComponentType#getSuperComponent <em>Super Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Component</em>' containment reference.
	 * @see #getSuperComponent()
	 * @generated
	 */
	void setSuperComponent(Hpetype value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.connector.xml.component.Unittype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' containment reference list.
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getHashComponentType_Unit()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='unit'"
	 * @generated
	 */
	EList<Unittype> getUnit();

} // HashComponentType
