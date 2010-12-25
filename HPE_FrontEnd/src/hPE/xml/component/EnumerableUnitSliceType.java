/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerable Unit Slice Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.EnumerableUnitSliceType#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.EnumerableUnitSliceType#getSplitReplica <em>Split Replica</em>}</li>
 *   <li>{@link hPE.xml.component.EnumerableUnitSliceType#getSRef <em>SRef</em>}</li>
 *   <li>{@link hPE.xml.component.EnumerableUnitSliceType#getURef <em>URef</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getEnumerableUnitSliceType()
 * @model extendedMetaData="name='EnumerableUnitSliceType' kind='empty'"
 * @generated
 */
public interface EnumerableUnitSliceType extends EnumerableType {
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
	 * @see hPE.xml.component.ComponentPackage#getEnumerableUnitSliceType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumerableUnitSliceType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

	/**
	 * Returns the value of the '<em><b>Split Replica</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Replica</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Replica</em>' attribute.
	 * @see #isSetSplitReplica()
	 * @see #unsetSplitReplica()
	 * @see #setSplitReplica(int)
	 * @see hPE.xml.component.ComponentPackage#getEnumerableUnitSliceType_SplitReplica()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='splitReplica'"
	 * @generated
	 */
	int getSplitReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumerableUnitSliceType#getSplitReplica <em>Split Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Split Replica</em>' attribute.
	 * @see #isSetSplitReplica()
	 * @see #unsetSplitReplica()
	 * @see #getSplitReplica()
	 * @generated
	 */
	void setSplitReplica(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.EnumerableUnitSliceType#getSplitReplica <em>Split Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSplitReplica()
	 * @see #getSplitReplica()
	 * @see #setSplitReplica(int)
	 * @generated
	 */
	void unsetSplitReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.EnumerableUnitSliceType#getSplitReplica <em>Split Replica</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Split Replica</em>' attribute is set.
	 * @see #unsetSplitReplica()
	 * @see #getSplitReplica()
	 * @see #setSplitReplica(int)
	 * @generated
	 */
	boolean isSetSplitReplica();

	/**
	 * Returns the value of the '<em><b>SRef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRef</em>' attribute.
	 * @see #setSRef(String)
	 * @see hPE.xml.component.ComponentPackage#getEnumerableUnitSliceType_SRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sRef'"
	 * @generated
	 */
	String getSRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumerableUnitSliceType#getSRef <em>SRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SRef</em>' attribute.
	 * @see #getSRef()
	 * @generated
	 */
	void setSRef(String value);

	/**
	 * Returns the value of the '<em><b>URef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URef</em>' attribute.
	 * @see #setURef(String)
	 * @see hPE.xml.component.ComponentPackage#getEnumerableUnitSliceType_URef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='uRef'"
	 * @generated
	 */
	String getURef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.EnumerableUnitSliceType#getURef <em>URef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URef</em>' attribute.
	 * @see #getURef()
	 * @generated
	 */
	void setURef(String value);

} // EnumerableUnitSliceType
