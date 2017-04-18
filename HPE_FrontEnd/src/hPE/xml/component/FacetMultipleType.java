/**
 */
package hPE.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Multiple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.FacetMultipleType#getFacet <em>Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getFacetMultipleType()
 * @model extendedMetaData="name='FacetMultipleType' kind='empty'"
 * @generated
 */
public interface FacetMultipleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Facet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet</em>' attribute.
	 * @see #setFacet(String)
	 * @see hPE.xml.component.ComponentPackage#getFacetMultipleType_Facet()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='facet'"
	 * @generated
	 */
	String getFacet();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FacetMultipleType#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet</em>' attribute.
	 * @see #getFacet()
	 * @generated
	 */
	void setFacet(String value);

} // FacetMultipleType
