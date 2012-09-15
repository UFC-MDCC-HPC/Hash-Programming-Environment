/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Perform Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.ProtocolPerformType#getSliceId <em>Slice Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.connector.xml.component.ComponentPackage#getProtocolPerformType()
 * @model extendedMetaData="name='ProtocolPerformType' kind='elementOnly'"
 * @generated
 */
public interface ProtocolPerformType extends ProtocolType {
	/**
	 * Returns the value of the '<em><b>Slice Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slice Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slice Id</em>' attribute.
	 * @see #setSliceId(String)
	 * @see hPE.frontend.connector.xml.component.ComponentPackage#getProtocolPerformType_SliceId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='slice_id'"
	 * @generated
	 */
	String getSliceId();

	/**
	 * Sets the value of the '{@link hPE.frontend.connector.xml.component.ProtocolPerformType#getSliceId <em>Slice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slice Id</em>' attribute.
	 * @see #getSliceId()
	 * @generated
	 */
	void setSliceId(String value);

} // ProtocolPerformType
