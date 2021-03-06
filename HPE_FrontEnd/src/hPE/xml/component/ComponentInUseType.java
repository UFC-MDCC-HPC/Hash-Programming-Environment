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
 * A representation of the model object '<em><b>In Use Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getPort <em>Port</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getUnitBounds <em>Unit Bounds</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getRevokeMultipleFacet <em>Revoke Multiple Facet</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getHashComponentUID <em>Hash Component UID</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getIndexReplica <em>Index Replica</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getLocalRef <em>Local Ref</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getLocation <em>Location</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#isMultiple <em>Multiple</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getName <em>Name</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getPackage <em>Package</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getParameterId <em>Parameter Id</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getQuantifierValue <em>Quantifier Value</em>}</li>
 *   <li>{@link hPE.xml.component.ComponentInUseType#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getComponentInUseType()
 * @model extendedMetaData="name='ComponentInUseType' kind='elementOnly'"
 * @generated
 */
public interface ComponentInUseType extends EObject {
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
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.ParameterRenaming}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameter'"
	 * @generated
	 */
	EList<ParameterRenaming> getParameter();

	/**
	 * Returns the value of the '<em><b>Port</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.InnerComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_Port()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='port'"
	 * @generated
	 */
	EList<InnerComponentType> getPort();

	/**
	 * Returns the value of the '<em><b>Unit Bounds</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.UnitBoundsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Bounds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Bounds</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_UnitBounds()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='unitBounds'"
	 * @generated
	 */
	EList<UnitBoundsType> getUnitBounds();

	/**
	 * Returns the value of the '<em><b>Revoke Multiple Facet</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revoke Multiple Facet</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revoke Multiple Facet</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_RevokeMultipleFacet()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='element' name='revokeMultipleFacet'"
	 * @generated
	 */
	EList<Integer> getRevokeMultipleFacet();

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
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_HashComponentUID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hash_component_UID'"
	 * @generated
	 */
	String getHashComponentUID();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getHashComponentUID <em>Hash Component UID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hash Component UID</em>' attribute.
	 * @see #getHashComponentUID()
	 * @generated
	 */
	void setHashComponentUID(String value);

	/**
	 * Returns the value of the '<em><b>Index Replica</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Replica</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Replica</em>' attribute.
	 * @see #isSetIndexReplica()
	 * @see #unsetIndexReplica()
	 * @see #setIndexReplica(int)
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_IndexReplica()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='index_replica'"
	 * @generated
	 */
	int getIndexReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getIndexReplica <em>Index Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Replica</em>' attribute.
	 * @see #isSetIndexReplica()
	 * @see #unsetIndexReplica()
	 * @see #getIndexReplica()
	 * @generated
	 */
	void setIndexReplica(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.ComponentInUseType#getIndexReplica <em>Index Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndexReplica()
	 * @see #getIndexReplica()
	 * @see #setIndexReplica(int)
	 * @generated
	 */
	void unsetIndexReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.ComponentInUseType#getIndexReplica <em>Index Replica</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Index Replica</em>' attribute is set.
	 * @see #unsetIndexReplica()
	 * @see #getIndexReplica()
	 * @see #setIndexReplica(int)
	 * @generated
	 */
	boolean isSetIndexReplica();

	/**
	 * Returns the value of the '<em><b>Local Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Ref</em>' attribute.
	 * @see #setLocalRef(String)
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_LocalRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='localRef'"
	 * @generated
	 */
	String getLocalRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getLocalRef <em>Local Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Ref</em>' attribute.
	 * @see #getLocalRef()
	 * @generated
	 */
	void setLocalRef(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_Location()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='location'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple</em>' attribute.
	 * @see #isSetMultiple()
	 * @see #unsetMultiple()
	 * @see #setMultiple(boolean)
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_Multiple()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='multiple'"
	 * @generated
	 */
	boolean isMultiple();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#isMultiple <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiple</em>' attribute.
	 * @see #isSetMultiple()
	 * @see #unsetMultiple()
	 * @see #isMultiple()
	 * @generated
	 */
	void setMultiple(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.ComponentInUseType#isMultiple <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMultiple()
	 * @see #isMultiple()
	 * @see #setMultiple(boolean)
	 * @generated
	 */
	void unsetMultiple();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.ComponentInUseType#isMultiple <em>Multiple</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Multiple</em>' attribute is set.
	 * @see #unsetMultiple()
	 * @see #isMultiple()
	 * @see #setMultiple(boolean)
	 * @generated
	 */
	boolean isSetMultiple();

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
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_Package()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='package'"
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Id</em>' attribute.
	 * @see #setParameterId(String)
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_ParameterId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='parameter_id'"
	 * @generated
	 */
	String getParameterId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getParameterId <em>Parameter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Id</em>' attribute.
	 * @see #getParameterId()
	 * @generated
	 */
	void setParameterId(String value);

	/**
	 * Returns the value of the '<em><b>Quantifier Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only for quantifiers ...
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quantifier Value</em>' attribute.
	 * @see #setQuantifierValue(String)
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_QuantifierValue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='quantifier_value'"
	 * @generated
	 */
	String getQuantifierValue();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getQuantifierValue <em>Quantifier Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantifier Value</em>' attribute.
	 * @see #getQuantifierValue()
	 * @generated
	 */
	void setQuantifierValue(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see hPE.xml.component.ComponentPackage#getComponentInUseType_Version()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
	 *        extendedMetaData="kind='attribute' name='version'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link hPE.xml.component.ComponentInUseType#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // ComponentInUseType
