/**
 */
package hPE.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Configuration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.FacetConfigurationType#getFacet <em>Facet</em>}</li>
 *   <li>{@link hPE.xml.component.FacetConfigurationType#isMultiple <em>Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getFacetConfigurationType()
 * @model extendedMetaData="name='FacetConfigurationType' kind='empty'"
 * @generated
 */
public interface FacetConfigurationType extends EObject {
	/**
	 * Returns the value of the '<em><b>Facet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet</em>' attribute.
	 * @see #isSetFacet()
	 * @see #unsetFacet()
	 * @see #setFacet(int)
	 * @see hPE.xml.component.ComponentPackage#getFacetConfigurationType_Facet()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='facet'"
	 * @generated
	 */
	int getFacet();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FacetConfigurationType#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet</em>' attribute.
	 * @see #isSetFacet()
	 * @see #unsetFacet()
	 * @see #getFacet()
	 * @generated
	 */
	void setFacet(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.FacetConfigurationType#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacet()
	 * @see #getFacet()
	 * @see #setFacet(int)
	 * @generated
	 */
	void unsetFacet();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.FacetConfigurationType#getFacet <em>Facet</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Facet</em>' attribute is set.
	 * @see #unsetFacet()
	 * @see #getFacet()
	 * @see #setFacet(int)
	 * @generated
	 */
	boolean isSetFacet();

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
	 * @see hPE.xml.component.ComponentPackage#getFacetConfigurationType_Multiple()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='multiple'"
	 * @generated
	 */
	boolean isMultiple();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FacetConfigurationType#isMultiple <em>Multiple</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.xml.component.FacetConfigurationType#isMultiple <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMultiple()
	 * @see #isMultiple()
	 * @see #setMultiple(boolean)
	 * @generated
	 */
	void unsetMultiple();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.FacetConfigurationType#isMultiple <em>Multiple</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Multiple</em>' attribute is set.
	 * @see #unsetMultiple()
	 * @see #isMultiple()
	 * @see #setMultiple(boolean)
	 * @generated
	 */
	boolean isSetMultiple();

} // FacetConfigurationType
