/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Activate Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionActivateTypeImpl#getSliceRef <em>Slice Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionActivateTypeImpl extends ActionTypeImpl implements ActionActivateType {
	/**
	 * The default value of the '{@link #getSliceRef() <em>Slice Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceRef()
	 * @generated
	 * @ordered
	 */
	protected static final String SLICE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSliceRef() <em>Slice Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceRef()
	 * @generated
	 * @ordered
	 */
	protected String sliceRef = SLICE_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionActivateTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.ACTION_ACTIVATE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSliceRef() {
		return sliceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSliceRef(String newSliceRef) {
		String oldSliceRef = sliceRef;
		sliceRef = newSliceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ACTION_ACTIVATE_TYPE__SLICE_REF, oldSliceRef, sliceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.ACTION_ACTIVATE_TYPE__SLICE_REF:
				return getSliceRef();
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
			case ComponentPackage.ACTION_ACTIVATE_TYPE__SLICE_REF:
				setSliceRef((String)newValue);
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
			case ComponentPackage.ACTION_ACTIVATE_TYPE__SLICE_REF:
				setSliceRef(SLICE_REF_EDEFAULT);
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
			case ComponentPackage.ACTION_ACTIVATE_TYPE__SLICE_REF:
				return SLICE_REF_EDEFAULT == null ? sliceRef != null : !SLICE_REF_EDEFAULT.equals(sliceRef);
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
		result.append(" (sliceRef: ");
		result.append(sliceRef);
		result.append(')');
		return result.toString();
	}

} //ActionActivateTypeImpl
