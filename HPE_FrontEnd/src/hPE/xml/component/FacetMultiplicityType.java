/**
 */
package hPE.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Multiplicity Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.FacetMultiplicityType#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link hPE.xml.component.FacetMultiplicityType#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.FacetMultiplicityType#getFacet <em>Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getFacetMultiplicityType()
 * @model extendedMetaData="name='FacetMultiplicityType' kind='empty'"
 * @generated
 */
public interface FacetMultiplicityType extends EObject {
	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #isSetCardinality()
	 * @see #unsetCardinality()
	 * @see #setCardinality(int)
	 * @see hPE.xml.component.ComponentPackage#getFacetMultiplicityType_Cardinality()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='cardinality'"
	 * @generated
	 */
	int getCardinality();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FacetMultiplicityType#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #isSetCardinality()
	 * @see #unsetCardinality()
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.FacetMultiplicityType#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCardinality()
	 * @see #getCardinality()
	 * @see #setCardinality(int)
	 * @generated
	 */
	void unsetCardinality();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.FacetMultiplicityType#getCardinality <em>Cardinality</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cardinality</em>' attribute is set.
	 * @see #unsetCardinality()
	 * @see #getCardinality()
	 * @see #setCardinality(int)
	 * @generated
	 */
	boolean isSetCardinality();

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
	 * @see hPE.xml.component.ComponentPackage#getFacetMultiplicityType_CRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cRef'"
	 * @generated
	 */
	String getCRef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FacetMultiplicityType#getCRef <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CRef</em>' attribute.
	 * @see #getCRef()
	 * @generated
	 */
	void setCRef(String value);

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
	 * @see hPE.xml.component.ComponentPackage#getFacetMultiplicityType_Facet()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='facet'"
	 * @generated
	 */
	int getFacet();

	/**
	 * Sets the value of the '{@link hPE.xml.component.FacetMultiplicityType#getFacet <em>Facet</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.xml.component.FacetMultiplicityType#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacet()
	 * @see #getFacet()
	 * @see #setFacet(int)
	 * @generated
	 */
	void unsetFacet();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.FacetMultiplicityType#getFacet <em>Facet</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Facet</em>' attribute is set.
	 * @see #unsetFacet()
	 * @see #getFacet()
	 * @see #setFacet(int)
	 * @generated
	 */
	boolean isSetFacet();

} // FacetMultiplicityType
