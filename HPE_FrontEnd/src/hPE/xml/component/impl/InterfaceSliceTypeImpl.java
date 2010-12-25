/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.InterfaceRefType;
import hPE.xml.component.InterfaceSliceType;
import hPE.xml.component.VisualElementAttributes;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Slice Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.InterfaceSliceTypeImpl#getOriginRef <em>Origin Ref</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InterfaceSliceTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InterfaceSliceTypeImpl#getIsRef <em>Is Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceSliceTypeImpl extends EObjectImpl implements InterfaceSliceType {
	/**
	 * The cached value of the '{@link #getOriginRef() <em>Origin Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginRef()
	 * @generated
	 * @ordered
	 */
	protected InterfaceRefType originRef;

	/**
	 * The cached value of the '{@link #getVisualDescription() <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualDescription()
	 * @generated
	 * @ordered
	 */
	protected VisualElementAttributes visualDescription;

	/**
	 * The default value of the '{@link #getIsRef() <em>Is Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsRef()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsRef() <em>Is Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsRef()
	 * @generated
	 * @ordered
	 */
	protected String isRef = IS_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceSliceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.INTERFACE_SLICE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceRefType getOriginRef() {
		return originRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOriginRef(InterfaceRefType newOriginRef, NotificationChain msgs) {
		InterfaceRefType oldOriginRef = originRef;
		originRef = newOriginRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF, oldOriginRef, newOriginRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginRef(InterfaceRefType newOriginRef) {
		if (newOriginRef != originRef) {
			NotificationChain msgs = null;
			if (originRef != null)
				msgs = ((InternalEObject)originRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF, null, msgs);
			if (newOriginRef != null)
				msgs = ((InternalEObject)newOriginRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF, null, msgs);
			msgs = basicSetOriginRef(newOriginRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF, newOriginRef, newOriginRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualElementAttributes getVisualDescription() {
		return visualDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisualDescription(VisualElementAttributes newVisualDescription, NotificationChain msgs) {
		VisualElementAttributes oldVisualDescription = visualDescription;
		visualDescription = newVisualDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualDescription(VisualElementAttributes newVisualDescription) {
		if (newVisualDescription != visualDescription) {
			NotificationChain msgs = null;
			if (visualDescription != null)
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsRef() {
		return isRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRef(String newIsRef) {
		String oldIsRef = isRef;
		isRef = newIsRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_SLICE_TYPE__IS_REF, oldIsRef, isRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF:
				return basicSetOriginRef(null, msgs);
			case ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION:
				return basicSetVisualDescription(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF:
				return getOriginRef();
			case ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.INTERFACE_SLICE_TYPE__IS_REF:
				return getIsRef();
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
			case ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF:
				setOriginRef((InterfaceRefType)newValue);
				return;
			case ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.INTERFACE_SLICE_TYPE__IS_REF:
				setIsRef((String)newValue);
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
			case ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF:
				setOriginRef((InterfaceRefType)null);
				return;
			case ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.INTERFACE_SLICE_TYPE__IS_REF:
				setIsRef(IS_REF_EDEFAULT);
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
			case ComponentPackage.INTERFACE_SLICE_TYPE__ORIGIN_REF:
				return originRef != null;
			case ComponentPackage.INTERFACE_SLICE_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.INTERFACE_SLICE_TYPE__IS_REF:
				return IS_REF_EDEFAULT == null ? isRef != null : !IS_REF_EDEFAULT.equals(isRef);
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
		result.append(" (isRef: ");
		result.append(isRef);
		result.append(')');
		return result.toString();
	}

} //InterfaceSliceTypeImpl
