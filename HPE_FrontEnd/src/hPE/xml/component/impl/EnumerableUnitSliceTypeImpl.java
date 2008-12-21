/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.EnumerableUnitSliceType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerable Unit Slice Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.EnumerableUnitSliceTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumerableUnitSliceTypeImpl#getSplitReplica <em>Split Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumerableUnitSliceTypeImpl#getSRef <em>SRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumerableUnitSliceTypeImpl#getURef <em>URef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerableUnitSliceTypeImpl extends EnumerableTypeImpl implements EnumerableUnitSliceType {
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
	 * The default value of the '{@link #getSplitReplica() <em>Split Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitReplica()
	 * @generated
	 * @ordered
	 */
	protected static final int SPLIT_REPLICA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSplitReplica() <em>Split Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitReplica()
	 * @generated
	 * @ordered
	 */
	protected int splitReplica = SPLIT_REPLICA_EDEFAULT;

	/**
	 * This is true if the Split Replica attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean splitReplicaESet;

	/**
	 * The default value of the '{@link #getSRef() <em>SRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRef()
	 * @generated
	 * @ordered
	 */
	protected static final String SREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSRef() <em>SRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRef()
	 * @generated
	 * @ordered
	 */
	protected String sRef = SREF_EDEFAULT;

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
	protected EnumerableUnitSliceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.ENUMERABLE_UNIT_SLICE_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__CREF, oldCRef, cRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSplitReplica() {
		return splitReplica;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSplitReplica(int newSplitReplica) {
		int oldSplitReplica = splitReplica;
		splitReplica = newSplitReplica;
		boolean oldSplitReplicaESet = splitReplicaESet;
		splitReplicaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA, oldSplitReplica, splitReplica, !oldSplitReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSplitReplica() {
		int oldSplitReplica = splitReplica;
		boolean oldSplitReplicaESet = splitReplicaESet;
		splitReplica = SPLIT_REPLICA_EDEFAULT;
		splitReplicaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA, oldSplitReplica, SPLIT_REPLICA_EDEFAULT, oldSplitReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSplitReplica() {
		return splitReplicaESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSRef() {
		return sRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSRef(String newSRef) {
		String oldSRef = sRef;
		sRef = newSRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SREF, oldSRef, sRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__UREF, oldURef, uRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__CREF:
				return getCRef();
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA:
				return new Integer(getSplitReplica());
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SREF:
				return getSRef();
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__UREF:
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
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA:
				setSplitReplica(((Integer)newValue).intValue());
				return;
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SREF:
				setSRef((String)newValue);
				return;
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__UREF:
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
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__CREF:
				setCRef(CREF_EDEFAULT);
				return;
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA:
				unsetSplitReplica();
				return;
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SREF:
				setSRef(SREF_EDEFAULT);
				return;
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__UREF:
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
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__CREF:
				return CREF_EDEFAULT == null ? cRef != null : !CREF_EDEFAULT.equals(cRef);
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SPLIT_REPLICA:
				return isSetSplitReplica();
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__SREF:
				return SREF_EDEFAULT == null ? sRef != null : !SREF_EDEFAULT.equals(sRef);
			case ComponentPackage.ENUMERABLE_UNIT_SLICE_TYPE__UREF:
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
		result.append(", splitReplica: ");
		if (splitReplicaESet) result.append(splitReplica); else result.append("<unset>");
		result.append(", sRef: ");
		result.append(sRef);
		result.append(", uRef: ");
		result.append(uRef);
		result.append(')');
		return result.toString();
	}

} //EnumerableUnitSliceTypeImpl
