/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.InterfaceType#getSlice <em>Slice</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceType#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceType#getSources <em>Sources</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceType#getPort <em>Port</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceType#getIRef <em>IRef</em>}</li>
 *   <li>{@link hPE.xml.component.InterfaceType#getNArgs <em>NArgs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getInterfaceType()
 * @model extendedMetaData="name='InterfaceType' kind='elementOnly'"
 * @generated
 */
public interface InterfaceType extends EObject {
	/**
	 * Returns the value of the '<em><b>Slice</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.InterfaceSliceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getInterfaceType_Slice()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='slice'"
	 * @generated
	 */
	EList<InterfaceSliceType> getSlice();

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' containment reference.
	 * @see #setProtocol(ActionType)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceType_Protocol()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='protocol'"
	 * @generated
	 */
	ActionType getProtocol();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceType#getProtocol <em>Protocol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' containment reference.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(ActionType value);

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.SourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getInterfaceType_Sources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='sources'"
	 * @generated
	 */
	EList<SourceType> getSources();

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
	 * @see hPE.xml.component.ComponentPackage#getInterfaceType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.InterfacePortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getInterfaceType_Port()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='port'"
	 * @generated
	 */
	EList<InterfacePortType> getPort();

	/**
	 * Returns the value of the '<em><b>IRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IRef</em>' attribute.
	 * @see #setIRef(String)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceType_IRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='iRef'"
	 * @generated
	 */
	String getIRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceType#getIRef <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IRef</em>' attribute.
	 * @see #getIRef()
	 * @generated
	 */
	void setIRef(String value);

	/**
	 * Returns the value of the '<em><b>NArgs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NArgs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NArgs</em>' attribute.
	 * @see #isSetNArgs()
	 * @see #unsetNArgs()
	 * @see #setNArgs(int)
	 * @see hPE.xml.component.ComponentPackage#getInterfaceType_NArgs()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='nArgs'"
	 * @generated
	 */
	int getNArgs();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InterfaceType#getNArgs <em>NArgs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NArgs</em>' attribute.
	 * @see #isSetNArgs()
	 * @see #unsetNArgs()
	 * @see #getNArgs()
	 * @generated
	 */
	void setNArgs(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.InterfaceType#getNArgs <em>NArgs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNArgs()
	 * @see #getNArgs()
	 * @see #setNArgs(int)
	 * @generated
	 */
	void unsetNArgs();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.InterfaceType#getNArgs <em>NArgs</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>NArgs</em>' attribute is set.
	 * @see #unsetNArgs()
	 * @see #getNArgs()
	 * @see #setNArgs(int)
	 * @generated
	 */
	boolean isSetNArgs();

} // InterfaceType
