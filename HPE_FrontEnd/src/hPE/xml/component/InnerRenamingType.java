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
 * A representation of the model object '<em><b>Inner Renaming Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.InnerRenamingType#getCNewName <em>CNew Name</em>}</li>
 *   <li>{@link hPE.xml.component.InnerRenamingType#getCOldName <em>COld Name</em>}</li>
 *   <li>{@link hPE.xml.component.InnerRenamingType#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.InnerRenamingType#getIndexReplica <em>Index Replica</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getInnerRenamingType()
 * @model extendedMetaData="name='InnerRenamingType' kind='empty'"
 * @generated
 */
public interface InnerRenamingType extends EObject {
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
	 * @see hPE.xml.component.ComponentPackage#getInnerRenamingType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InnerRenamingType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getInnerRenamingType_IndexReplica()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='index_replica'"
	 * @generated
	 */
	int getIndexReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InnerRenamingType#getIndexReplica <em>Index Replica</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.xml.component.InnerRenamingType#getIndexReplica <em>Index Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndexReplica()
	 * @see #getIndexReplica()
	 * @see #setIndexReplica(int)
	 * @generated
	 */
	void unsetIndexReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.InnerRenamingType#getIndexReplica <em>Index Replica</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>COld Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>COld Name</em>' attribute.
	 * @see #setCOldName(String)
	 * @see hPE.xml.component.ComponentPackage#getInnerRenamingType_COldName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cOldName'"
	 * @generated
	 */
	String getCOldName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InnerRenamingType#getCOldName <em>COld Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>COld Name</em>' attribute.
	 * @see #getCOldName()
	 * @generated
	 */
	void setCOldName(String value);

	/**
	 * Returns the value of the '<em><b>CNew Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CNew Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CNew Name</em>' attribute.
	 * @see #setCNewName(String)
	 * @see hPE.xml.component.ComponentPackage#getInnerRenamingType_CNewName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cNewName'"
	 * @generated
	 */
	String getCNewName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.InnerRenamingType#getCNewName <em>CNew Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CNew Name</em>' attribute.
	 * @see #getCNewName()
	 * @generated
	 */
	void setCNewName(String value);

} // InnerRenamingType
