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
 * A representation of the model object '<em><b>Source File Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.SourceFileType#getDependency <em>Dependency</em>}</li>
 *   <li>{@link hPE.xml.component.SourceFileType#getExternalDependency <em>External Dependency</em>}</li>
 *   <li>{@link hPE.xml.component.SourceFileType#getContents <em>Contents</em>}</li>
 *   <li>{@link hPE.xml.component.SourceFileType#getFileType <em>File Type</em>}</li>
 *   <li>{@link hPE.xml.component.SourceFileType#getName <em>Name</em>}</li>
 *   <li>{@link hPE.xml.component.SourceFileType#getUri <em>Uri</em>}</li>
 *   <li>{@link hPE.xml.component.SourceFileType#getVersionId <em>Version Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getSourceFileType()
 * @model extendedMetaData="name='SourceFileType' kind='elementOnly'"
 * @generated
 */
public interface SourceFileType extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getSourceFileType_Dependency()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='dependency'"
	 * @generated
	 */
	EList<String> getDependency();

	/**
	 * Returns the value of the '<em><b>External Dependency</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Dependency</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Dependency</em>' attribute list.
	 * @see hPE.xml.component.ComponentPackage#getSourceFileType_ExternalDependency()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='externalDependency'"
	 * @generated
	 */
	EList<String> getExternalDependency();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' attribute.
	 * @see #setContents(String)
	 * @see hPE.xml.component.ComponentPackage#getSourceFileType_Contents()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='contents'"
	 * @generated
	 */
	String getContents();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SourceFileType#getContents <em>Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contents</em>' attribute.
	 * @see #getContents()
	 * @generated
	 */
	void setContents(String value);

	/**
	 * Returns the value of the '<em><b>File Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Type</em>' attribute.
	 * @see #setFileType(String)
	 * @see hPE.xml.component.ComponentPackage#getSourceFileType_FileType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fileType'"
	 * @generated
	 */
	String getFileType();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SourceFileType#getFileType <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Type</em>' attribute.
	 * @see #getFileType()
	 * @generated
	 */
	void setFileType(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getSourceFileType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SourceFileType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see hPE.xml.component.ComponentPackage#getSourceFileType_Uri()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uri'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SourceFileType#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getSourceFileType_VersionId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='versionId'"
	 * @generated
	 */
	String getVersionId();

	/**
	 * Sets the value of the '{@link hPE.xml.component.SourceFileType#getVersionId <em>Version Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Id</em>' attribute.
	 * @see #getVersionId()
	 * @generated
	 */
	void setVersionId(String value);

} // SourceFileType
