/**
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.FacetConfigurationType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Configuration Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.FacetConfigurationTypeImpl#getFacet <em>Facet</em>}</li>
 *   <li>{@link hPE.xml.component.impl.FacetConfigurationTypeImpl#isMultiple <em>Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacetConfigurationTypeImpl extends MinimalEObjectImpl.Container implements FacetConfigurationType {
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
	 * The default value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiple()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIPLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiple()
	 * @generated
	 * @ordered
	 */
	protected boolean multiple = MULTIPLE_EDEFAULT;

	/**
	 * This is true if the Multiple attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean multipleESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetConfigurationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.FACET_CONFIGURATION_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.FACET_CONFIGURATION_TYPE__FACET, oldFacet, facet, !oldFacetESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.FACET_CONFIGURATION_TYPE__FACET, oldFacet, FACET_EDEFAULT, oldFacetESet));
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
	public boolean isMultiple() {
		return multiple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiple(boolean newMultiple) {
		boolean oldMultiple = multiple;
		multiple = newMultiple;
		boolean oldMultipleESet = multipleESet;
		multipleESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.FACET_CONFIGURATION_TYPE__MULTIPLE, oldMultiple, multiple, !oldMultipleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMultiple() {
		boolean oldMultiple = multiple;
		boolean oldMultipleESet = multipleESet;
		multiple = MULTIPLE_EDEFAULT;
		multipleESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.FACET_CONFIGURATION_TYPE__MULTIPLE, oldMultiple, MULTIPLE_EDEFAULT, oldMultipleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMultiple() {
		return multipleESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.FACET_CONFIGURATION_TYPE__FACET:
				return getFacet();
			case ComponentPackage.FACET_CONFIGURATION_TYPE__MULTIPLE:
				return isMultiple();
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
			case ComponentPackage.FACET_CONFIGURATION_TYPE__FACET:
				setFacet((Integer)newValue);
				return;
			case ComponentPackage.FACET_CONFIGURATION_TYPE__MULTIPLE:
				setMultiple((Boolean)newValue);
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
			case ComponentPackage.FACET_CONFIGURATION_TYPE__FACET:
				unsetFacet();
				return;
			case ComponentPackage.FACET_CONFIGURATION_TYPE__MULTIPLE:
				unsetMultiple();
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
			case ComponentPackage.FACET_CONFIGURATION_TYPE__FACET:
				return isSetFacet();
			case ComponentPackage.FACET_CONFIGURATION_TYPE__MULTIPLE:
				return isSetMultiple();
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
		result.append(" (facet: ");
		if (facetESet) result.append(facet); else result.append("<unset>");
		result.append(", multiple: ");
		if (multipleESet) result.append(multiple); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //FacetConfigurationTypeImpl
