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
 * A representation of the model object '<em><b>Unit Bounds Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getFacet <em>Facet</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getFacetInstance <em>Facet Instance</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getFacetInstanceEnclosing <em>Facet Instance Enclosing</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#isParallel <em>Parallel</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getReplica <em>Replica</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getSliceReplica <em>Slice Replica</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getUnitReplica <em>Unit Replica</em>}</li>
 *   <li>{@link hPE.xml.component.UnitBoundsType#getURef <em>URef</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType()
 * @model extendedMetaData="name='UnitBoundsType' kind='elementOnly'"
 * @generated
 */
public interface UnitBoundsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Visual Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual Description</em>' containment reference.
	 * @see #setVisualDescription(VisualElementAttributes)
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_VisualDescription()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='visualDescription'"
	 * @generated
	 */
	VisualElementAttributes getVisualDescription();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getVisualDescription <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual Description</em>' containment reference.
	 * @see #getVisualDescription()
	 * @generated
	 */
	void setVisualDescription(VisualElementAttributes value);

	/**
	 * Returns the value of the '<em><b>Facet</b></em>' attribute.
	 * The default value is <code>"0"</code>.
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
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_Facet()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='facet'"
	 * @generated
	 */
	int getFacet();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getFacet <em>Facet</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.xml.component.UnitBoundsType#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacet()
	 * @see #getFacet()
	 * @see #setFacet(int)
	 * @generated
	 */
	void unsetFacet();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitBoundsType#getFacet <em>Facet</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Facet Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Instance</em>' attribute.
	 * @see #isSetFacetInstance()
	 * @see #unsetFacetInstance()
	 * @see #setFacetInstance(int)
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_FacetInstance()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='facet_instance'"
	 * @generated
	 */
	int getFacetInstance();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getFacetInstance <em>Facet Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Instance</em>' attribute.
	 * @see #isSetFacetInstance()
	 * @see #unsetFacetInstance()
	 * @see #getFacetInstance()
	 * @generated
	 */
	void setFacetInstance(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitBoundsType#getFacetInstance <em>Facet Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacetInstance()
	 * @see #getFacetInstance()
	 * @see #setFacetInstance(int)
	 * @generated
	 */
	void unsetFacetInstance();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitBoundsType#getFacetInstance <em>Facet Instance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Facet Instance</em>' attribute is set.
	 * @see #unsetFacetInstance()
	 * @see #getFacetInstance()
	 * @see #setFacetInstance(int)
	 * @generated
	 */
	boolean isSetFacetInstance();

	/**
	 * Returns the value of the '<em><b>Facet Instance Enclosing</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Instance Enclosing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Instance Enclosing</em>' attribute.
	 * @see #isSetFacetInstanceEnclosing()
	 * @see #unsetFacetInstanceEnclosing()
	 * @see #setFacetInstanceEnclosing(int)
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_FacetInstanceEnclosing()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='facet_instance_enclosing'"
	 * @generated
	 */
	int getFacetInstanceEnclosing();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getFacetInstanceEnclosing <em>Facet Instance Enclosing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Instance Enclosing</em>' attribute.
	 * @see #isSetFacetInstanceEnclosing()
	 * @see #unsetFacetInstanceEnclosing()
	 * @see #getFacetInstanceEnclosing()
	 * @generated
	 */
	void setFacetInstanceEnclosing(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitBoundsType#getFacetInstanceEnclosing <em>Facet Instance Enclosing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacetInstanceEnclosing()
	 * @see #getFacetInstanceEnclosing()
	 * @see #setFacetInstanceEnclosing(int)
	 * @generated
	 */
	void unsetFacetInstanceEnclosing();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitBoundsType#getFacetInstanceEnclosing <em>Facet Instance Enclosing</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Facet Instance Enclosing</em>' attribute is set.
	 * @see #unsetFacetInstanceEnclosing()
	 * @see #getFacetInstanceEnclosing()
	 * @see #setFacetInstanceEnclosing(int)
	 * @generated
	 */
	boolean isSetFacetInstanceEnclosing();

	/**
	 * Returns the value of the '<em><b>Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel</em>' attribute.
	 * @see #isSetParallel()
	 * @see #unsetParallel()
	 * @see #setParallel(boolean)
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_Parallel()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='parallel'"
	 * @generated
	 */
	boolean isParallel();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#isParallel <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parallel</em>' attribute.
	 * @see #isSetParallel()
	 * @see #unsetParallel()
	 * @see #isParallel()
	 * @generated
	 */
	void setParallel(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitBoundsType#isParallel <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParallel()
	 * @see #isParallel()
	 * @see #setParallel(boolean)
	 * @generated
	 */
	void unsetParallel();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitBoundsType#isParallel <em>Parallel</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parallel</em>' attribute is set.
	 * @see #unsetParallel()
	 * @see #isParallel()
	 * @see #setParallel(boolean)
	 * @generated
	 */
	boolean isSetParallel();

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
	 * @see #setReplica(long)
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_Replica()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt"
	 *        extendedMetaData="kind='attribute' name='replica'"
	 * @generated
	 */
	long getReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getReplica <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replica</em>' attribute.
	 * @see #isSetReplica()
	 * @see #unsetReplica()
	 * @see #getReplica()
	 * @generated
	 */
	void setReplica(long value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitBoundsType#getReplica <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReplica()
	 * @see #getReplica()
	 * @see #setReplica(long)
	 * @generated
	 */
	void unsetReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitBoundsType#getReplica <em>Replica</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Replica</em>' attribute is set.
	 * @see #unsetReplica()
	 * @see #getReplica()
	 * @see #setReplica(long)
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
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_SliceReplica()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='slice_replica'"
	 * @generated
	 */
	int getSliceReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getSliceReplica <em>Slice Replica</em>}' attribute.
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
	 * Unsets the value of the '{@link hPE.xml.component.UnitBoundsType#getSliceReplica <em>Slice Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSliceReplica()
	 * @see #getSliceReplica()
	 * @see #setSliceReplica(int)
	 * @generated
	 */
	void unsetSliceReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitBoundsType#getSliceReplica <em>Slice Replica</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Unit Replica</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Replica</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Replica</em>' attribute.
	 * @see #isSetUnitReplica()
	 * @see #unsetUnitReplica()
	 * @see #setUnitReplica(int)
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_UnitReplica()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='unit_replica'"
	 * @generated
	 */
	int getUnitReplica();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getUnitReplica <em>Unit Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Replica</em>' attribute.
	 * @see #isSetUnitReplica()
	 * @see #unsetUnitReplica()
	 * @see #getUnitReplica()
	 * @generated
	 */
	void setUnitReplica(int value);

	/**
	 * Unsets the value of the '{@link hPE.xml.component.UnitBoundsType#getUnitReplica <em>Unit Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnitReplica()
	 * @see #getUnitReplica()
	 * @see #setUnitReplica(int)
	 * @generated
	 */
	void unsetUnitReplica();

	/**
	 * Returns whether the value of the '{@link hPE.xml.component.UnitBoundsType#getUnitReplica <em>Unit Replica</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unit Replica</em>' attribute is set.
	 * @see #unsetUnitReplica()
	 * @see #getUnitReplica()
	 * @see #setUnitReplica(int)
	 * @generated
	 */
	boolean isSetUnitReplica();

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
	 * @see hPE.xml.component.ComponentPackage#getUnitBoundsType_URef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uRef'"
	 * @generated
	 */
	String getURef();

	/**
	 * Sets the value of the '{@link hPE.xml.component.UnitBoundsType#getURef <em>URef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URef</em>' attribute.
	 * @see #getURef()
	 * @generated
	 */
	void setURef(String value);

} // UnitBoundsType
