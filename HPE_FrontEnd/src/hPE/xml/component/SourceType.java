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
 * A representation of the model object '<em><b>Source Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.SourceType#getFile <em>File</em>}</li>
 *   <li>{@link hPE.xml.component.SourceType#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link hPE.xml.component.SourceType#getVersionId <em>Version Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getSourceType()
 * @model extendedMetaData="name='SourceType' kind='elementOnly'"
 * @generated
 */
public interface SourceType extends EObject {
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.xml.component.SourceFileType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference list.
	 * @see hPE.xml.component.ComponentPackage#getSourceType_File()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='file'"
	 * @generated
	 */
	EList<SourceFileType> getFile();

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' attribute.
	 * @see #setSourceType(String)
	 * @see hPE.xml.component.ComponentPackage#getSourceType_SourceType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sourceType'"
	 * @generated
	 */
	String getSourceType();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SourceType#getSourceType <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' attribute.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(String value);

	/**
	 * Returns the value of the '<em><b>Version Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Id</em>' attribute.
	 * @see #setVersionId(String)
	 * @see hPE.xml.component.ComponentPackage#getSourceType_VersionId()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
	 *        extendedMetaData="kind='attribute' name='versionId'"
	 * @generated
	 */
	String getVersionId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SourceType#getVersionId <em>Version Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Id</em>' attribute.
	 * @see #getVersionId()
	 * @generated
	 */
	void setVersionId(String value);

} // SourceType
