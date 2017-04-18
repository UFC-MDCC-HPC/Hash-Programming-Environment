/**
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.FacetMultiplicityType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Multiplicity Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.FacetMultiplicityTypeImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link hPE.xml.component.impl.FacetMultiplicityTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.FacetMultiplicityTypeImpl#getFacet <em>Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacetMultiplicityTypeImpl extends MinimalEObjectImpl.Container implements FacetMultiplicityType {
	/**
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int CARDINALITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected int cardinality = CARDINALITY_EDEFAULT;

	/**
	 * This is true if the Cardinality attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cardinalityESet;

	/**
	 * The default value of the '{@link #getCRef() <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRef()
	 * @generated
	 * @ordered
	 */
	protected static final String CREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCRef() <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRef()
	 * @generated
	 * @ordered
	 */
	protected String cRef = CREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacet() <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacet()
	 * @generated
	 * @ordered
	 */
	protected static final int FACET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFacet() <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacet()
	 * @generated
	 * @ordered
	 */
	protected int facet = FACET_EDEFAULT;

	/**
	 * This is true if the Facet attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean facetESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetMultiplicityTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.FACET_MULTIPLICITY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCardinality() {
		return cardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardinality(int newCardinality) {
		int oldCardinality = cardinality;
		cardinality = newCardinality;
		boolean oldCardinalityESet = cardinalityESet;
		cardinalityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.FACET_MULTIPLICITY_TYPE__CARDINALITY, oldCardinality, cardinality, !oldCardinalityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCardinality() {
		int oldCardinality = cardinality;
		boolean oldCardinalityESet = cardinalityESet;
		cardinality = CARDINALITY_EDEFAULT;
		cardinalityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.FACET_MULTIPLICITY_TYPE__CARDINALITY, oldCardinality, CARDINALITY_EDEFAULT, oldCardinalityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCardinality() {
		return cardinalityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCRef() {
		return cRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCRef(String newCRef) {
		String oldCRef = cRef;
		cRef = newCRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.FACET_MULTIPLICITY_TYPE__CREF, oldCRef, cRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFacet() {
		return facet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacet(int newFacet) {
		int oldFacet = facet;
		facet = newFacet;
		boolean oldFacetESet = facetESet;
		facetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.FACET_MULTIPLICITY_TYPE__FACET, oldFacet, facet, !oldFacetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFacet() {
		int oldFacet = facet;
		boolean oldFacetESet = facetESet;
		facet = FACET_EDEFAULT;
		facetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.FACET_MULTIPLICITY_TYPE__FACET, oldFacet, FACET_EDEFAULT, oldFacetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFacet() {
		return facetESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CARDINALITY:
				return getCardinality();
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CREF:
				return getCRef();
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__FACET:
				return getFacet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CARDINALITY:
				setCardinality((Integer)newValue);
				return;
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__FACET:
				setFacet((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CARDINALITY:
				unsetCardinality();
				return;
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CREF:
				setCRef(CREF_EDEFAULT);
				return;
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__FACET:
				unsetFacet();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CARDINALITY:
				return isSetCardinality();
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__CREF:
				return CREF_EDEFAULT == null ? cRef != null : !CREF_EDEFAULT.equals(cRef);
			case ComponentPackage.FACET_MULTIPLICITY_TYPE__FACET:
				return isSetFacet();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cardinality: ");
		if (cardinalityESet) result.append(cardinality); else result.append("<unset>");
		result.append(", cRef: ");
		result.append(cRef);
		result.append(", facet: ");
		if (facetESet) result.append(facet); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //FacetMultiplicityTypeImpl
