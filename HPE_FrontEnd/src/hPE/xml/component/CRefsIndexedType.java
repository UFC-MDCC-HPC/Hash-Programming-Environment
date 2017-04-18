/**
 */
package hPE.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CRefs Indexed Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.CRefsIndexedType#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.CRefsIndexedType#getIndexReplica <em>Index Replica</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getCRefsIndexedType()
 * @model extendedMetaData="name='cRefsIndexed_._type' kind='empty'"
 * @generated
 */
public interface CRefsIndexedType extends EObject {
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
	 * @see hPE.xml.component.ComponentPackage#getCRefsIndexedType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.CRefsIndexedType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

	/**
	 * Returns the value of the '<em><b>Index Replica</b></em>' attribute.
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
	 * @see hPE.xml.component.ComponentPackage#getCRefsIndexedType_IndexReplica()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='index_replica'"
	 * @generated
	 */
	int getIndexReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.CRefsIndexedType#getIndexReplica <em>Index Replica</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.xml.component.CRefsIndexedType#getIndexReplica <em>Index Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndexReplica()
	 * @see #getIndexReplica()
	 * @see #setIndexReplica(int)
	 * @generated
	 */
	void unsetIndexReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.CRefsIndexedType#getIndexReplica <em>Index Replica</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Index Replica</em>' attribute is set.
	 * @see #unsetIndexReplica()
	 * @see #getIndexReplica()
	 * @see #setIndexReplica(int)
	 * @generated
	 */
	boolean isSetIndexReplica();

} // CRefsIndexedType
