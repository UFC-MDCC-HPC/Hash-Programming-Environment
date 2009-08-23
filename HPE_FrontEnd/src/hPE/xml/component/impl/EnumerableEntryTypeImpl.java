/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.EnumerableEntryType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerable Entry Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.EnumerableEntryTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumerableEntryTypeImpl#getPermutation <em>Permutation</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumerableEntryTypeImpl#getURef <em>URef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerableEntryTypeImpl extends EnumerableTypeImpl implements EnumerableEntryType {
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
	 * The default value of the '{@link #getPermutation() <em>Permutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermutation()
	 * @generated
	 * @ordered
	 */
	protected static final String PERMUTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPermutation() <em>Permutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermutation()
	 * @generated
	 * @ordered
	 */
	protected String permutation = PERMUTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getURef() <em>URef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURef()
	 * @generated
	 * @ordered
	 */
	protected static final String UREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURef() <em>URef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURef()
	 * @generated
	 * @ordered
	 */
	protected String uRef = UREF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerableEntryTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.ENUMERABLE_ENTRY_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERABLE_ENTRY_TYPE__CREF, oldCRef, cRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPermutation() {
		return permutation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPermutation(String newPermutation) {
		String oldPermutation = permutation;
		permutation = newPermutation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERABLE_ENTRY_TYPE__PERMUTATION, oldPermutation, permutation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getURef() {
		return uRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURef(String newURef) {
		String oldURef = uRef;
		uRef = newURef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERABLE_ENTRY_TYPE__UREF, oldURef, uRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__CREF:
				return getCRef();
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__PERMUTATION:
				return getPermutation();
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__UREF:
				return getURef();
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
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__PERMUTATION:
				setPermutation((String)newValue);
				return;
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__UREF:
				setURef((String)newValue);
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
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__CREF:
				setCRef(CREF_EDEFAULT);
				return;
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__PERMUTATION:
				setPermutation(PERMUTATION_EDEFAULT);
				return;
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__UREF:
				setURef(UREF_EDEFAULT);
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
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__CREF:
				return CREF_EDEFAULT == null ? cRef != null : !CREF_EDEFAULT.equals(cRef);
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__PERMUTATION:
				return PERMUTATION_EDEFAULT == null ? permutation != null : !PERMUTATION_EDEFAULT.equals(permutation);
			case ComponentPackage.ENUMERABLE_ENTRY_TYPE__UREF:
				return UREF_EDEFAULT == null ? uRef != null : !UREF_EDEFAULT.equals(uRef);
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
		result.append(" (cRef: ");
		result.append(cRef);
		result.append(", permutation: ");
		result.append(permutation);
		result.append(", uRef: ");
		result.append(uRef);
		result.append(')');
		return result.toString();
	}

} //EnumerableEntryTypeImpl
