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
 * A representation of the model object '<em><b>Unit Ref Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.UnitRefType#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.UnitRefType#getReplica <em>Replica</em>}</li>
 *   <li>{@link hPE.xml.component.UnitRefType#getSliceReplica <em>Slice Replica</em>}</li>
 *   <li>{@link hPE.xml.component.UnitRefType#getURef <em>URef</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getUnitRefType()
 * @model extendedMetaData="name='UnitRefType' kind='empty'"
 * @generated
 */
public interface UnitRefType extends EObject {
	/**
	 * Returns the value of the '<em><b>CRef</b></em>' attribute.
	 * The default value is <code>"this"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CRef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CRef</em>' attribute.
	 * @see #isSetCRef()
	 * @see #unsetCRef()
	 * @see #setCRef(String)
	 * @see hPE.xml.component.ComponentPackage#getUnitRefType_CRef()
	 * @model default="this" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitRefType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #isSetCRef()
	 * @see #unsetCRef()
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitRefType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCRef()
	 * @see #getCRef()
	 * @see #setCRef(String)
	 * @generated
	 */
	void unsetCRef();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitRefType#getCRef <em>CRef</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>CRef</em>' attribute is set.
	 * @see #unsetCRef()
	 * @see #getCRef()
	 * @see #setCRef(String)
	 * @generated
	 */
	boolean isSetCRef();

	/**
	 * Returns the value of the '<em><b>Replica</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replica</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replica</em>' attribute.
	 * @see #isSetReplica()
	 * @see #unsetReplica()
	 * @see #setReplica(int)
	 * @see hPE.xml.component.ComponentPackage#getUnitRefType_Replica()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='replica'"
	 * @generated
	 */
	int getReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitRefType#getReplica <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replica</em>' attribute.
	 * @see #isSetReplica()
	 * @see #unsetReplica()
	 * @see #getReplica()
	 * @generated
	 */
	void setReplica(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitRefType#getReplica <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReplica()
	 * @see #getReplica()
	 * @see #setReplica(int)
	 * @generated
	 */
	void unsetReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitRefType#getReplica <em>Replica</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Replica</em>' attribute is set.
	 * @see #unsetReplica()
	 * @see #getReplica()
	 * @see #setReplica(int)
	 * @generated
	 */
	boolean isSetReplica();

	/**
	 * Returns the value of the '<em><b>Slice Replica</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice Replica</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice Replica</em>' attribute.
	 * @see #isSetSliceReplica()
	 * @see #unsetSliceReplica()
	 * @see #setSliceReplica(int)
	 * @see hPE.xml.component.ComponentPackage#getUnitRefType_SliceReplica()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='slice_replica'"
	 * @generated
	 */
	int getSliceReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitRefType#getSliceReplica <em>Slice Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Replica</em>' attribute.
	 * @see #isSetSliceReplica()
	 * @see #unsetSliceReplica()
	 * @see #getSliceReplica()
	 * @generated
	 */
	void setSliceReplica(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitRefType#getSliceReplica <em>Slice Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSliceReplica()
	 * @see #getSliceReplica()
	 * @see #setSliceReplica(int)
	 * @generated
	 */
	void unsetSliceReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitRefType#getSliceReplica <em>Slice Replica</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Slice Replica</em>' attribute is set.
	 * @see #unsetSliceReplica()
	 * @see #getSliceReplica()
	 * @see #setSliceReplica(int)
	 * @generated
	 */
	boolean isSetSliceReplica();

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
	 * @see hPE.xml.component.ComponentPackage#getUnitRefType_URef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='uRef'"
	 * @generated
	 */
	String getURef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitRefType#getURef <em>URef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URef</em>' attribute.
	 * @see #getURef()
	 * @generated
	 */
	void setURef(String value);

} // UnitRefType
