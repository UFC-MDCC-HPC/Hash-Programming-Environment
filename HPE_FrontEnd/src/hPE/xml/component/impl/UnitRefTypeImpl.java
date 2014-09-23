/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.UnitRefType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Ref Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.UnitRefTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitRefTypeImpl#getInnerReplica <em>Inner Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitRefTypeImpl#getReplica <em>Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitRefTypeImpl#getSliceReplica <em>Slice Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitRefTypeImpl#getURef <em>URef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitRefTypeImpl extends MinimalEObjectImpl.Container implements UnitRefType {
	/**
	 * The default value of the '{@link #getCRef() <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRef()
	 * @generated
	 * @ordered
	 */
	protected static final String CREF_EDEFAULT = "this";

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
	 * This is true if the CRef attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cRefESet;

	/**
	 * The default value of the '{@link #getInnerReplica() <em>Inner Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerReplica()
	 * @generated
	 * @ordered
	 */
	protected static final int INNER_REPLICA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInnerReplica() <em>Inner Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerReplica()
	 * @generated
	 * @ordered
	 */
	protected int innerReplica = INNER_REPLICA_EDEFAULT;

	/**
	 * This is true if the Inner Replica attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean innerReplicaESet;

	/**
	 * The default value of the '{@link #getReplica() <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplica()
	 * @generated
	 * @ordered
	 */
	protected static final int REPLICA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReplica() <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplica()
	 * @generated
	 * @ordered
	 */
	protected int replica = REPLICA_EDEFAULT;

	/**
	 * This is true if the Replica attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean replicaESet;

	/**
	 * The default value of the '{@link #getSliceReplica() <em>Slice Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceReplica()
	 * @generated
	 * @ordered
	 */
	protected static final int SLICE_REPLICA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSliceReplica() <em>Slice Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceReplica()
	 * @generated
	 * @ordered
	 */
	protected int sliceReplica = SLICE_REPLICA_EDEFAULT;

	/**
	 * This is true if the Slice Replica attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sliceReplicaESet;

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
	protected UnitRefTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.UNIT_REF_TYPE;
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
		boolean oldCRefESet = cRefESet;
		cRefESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_REF_TYPE__CREF, oldCRef, cRef, !oldCRefESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCRef() {
		String oldCRef = cRef;
		boolean oldCRefESet = cRefESet;
		cRef = CREF_EDEFAULT;
		cRefESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_REF_TYPE__CREF, oldCRef, CREF_EDEFAULT, oldCRefESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCRef() {
		return cRefESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInnerReplica() {
		return innerReplica;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerReplica(int newInnerReplica) {
		int oldInnerReplica = innerReplica;
		innerReplica = newInnerReplica;
		boolean oldInnerReplicaESet = innerReplicaESet;
		innerReplicaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_REF_TYPE__INNER_REPLICA, oldInnerReplica, innerReplica, !oldInnerReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInnerReplica() {
		int oldInnerReplica = innerReplica;
		boolean oldInnerReplicaESet = innerReplicaESet;
		innerReplica = INNER_REPLICA_EDEFAULT;
		innerReplicaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_REF_TYPE__INNER_REPLICA, oldInnerReplica, INNER_REPLICA_EDEFAULT, oldInnerReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInnerReplica() {
		return innerReplicaESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getReplica() {
		return replica;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplica(int newReplica) {
		int oldReplica = replica;
		replica = newReplica;
		boolean oldReplicaESet = replicaESet;
		replicaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_REF_TYPE__REPLICA, oldReplica, replica, !oldReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReplica() {
		int oldReplica = replica;
		boolean oldReplicaESet = replicaESet;
		replica = REPLICA_EDEFAULT;
		replicaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_REF_TYPE__REPLICA, oldReplica, REPLICA_EDEFAULT, oldReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReplica() {
		return replicaESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSliceReplica() {
		return sliceReplica;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSliceReplica(int newSliceReplica) {
		int oldSliceReplica = sliceReplica;
		sliceReplica = newSliceReplica;
		boolean oldSliceReplicaESet = sliceReplicaESet;
		sliceReplicaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_REF_TYPE__SLICE_REPLICA, oldSliceReplica, sliceReplica, !oldSliceReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSliceReplica() {
		int oldSliceReplica = sliceReplica;
		boolean oldSliceReplicaESet = sliceReplicaESet;
		sliceReplica = SLICE_REPLICA_EDEFAULT;
		sliceReplicaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_REF_TYPE__SLICE_REPLICA, oldSliceReplica, SLICE_REPLICA_EDEFAULT, oldSliceReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSliceReplica() {
		return sliceReplicaESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_REF_TYPE__UREF, oldURef, uRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.UNIT_REF_TYPE__CREF:
				return getCRef();
			case ComponentPackage.UNIT_REF_TYPE__INNER_REPLICA:
				return getInnerReplica();
			case ComponentPackage.UNIT_REF_TYPE__REPLICA:
				return getReplica();
			case ComponentPackage.UNIT_REF_TYPE__SLICE_REPLICA:
				return getSliceReplica();
			case ComponentPackage.UNIT_REF_TYPE__UREF:
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
			case ComponentPackage.UNIT_REF_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.UNIT_REF_TYPE__INNER_REPLICA:
				setInnerReplica((Integer)newValue);
				return;
			case ComponentPackage.UNIT_REF_TYPE__REPLICA:
				setReplica((Integer)newValue);
				return;
			case ComponentPackage.UNIT_REF_TYPE__SLICE_REPLICA:
				setSliceReplica((Integer)newValue);
				return;
			case ComponentPackage.UNIT_REF_TYPE__UREF:
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
			case ComponentPackage.UNIT_REF_TYPE__CREF:
				unsetCRef();
				return;
			case ComponentPackage.UNIT_REF_TYPE__INNER_REPLICA:
				unsetInnerReplica();
				return;
			case ComponentPackage.UNIT_REF_TYPE__REPLICA:
				unsetReplica();
				return;
			case ComponentPackage.UNIT_REF_TYPE__SLICE_REPLICA:
				unsetSliceReplica();
				return;
			case ComponentPackage.UNIT_REF_TYPE__UREF:
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
			case ComponentPackage.UNIT_REF_TYPE__CREF:
				return isSetCRef();
			case ComponentPackage.UNIT_REF_TYPE__INNER_REPLICA:
				return isSetInnerReplica();
			case ComponentPackage.UNIT_REF_TYPE__REPLICA:
				return isSetReplica();
			case ComponentPackage.UNIT_REF_TYPE__SLICE_REPLICA:
				return isSetSliceReplica();
			case ComponentPackage.UNIT_REF_TYPE__UREF:
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
		if (cRefESet) result.append(cRef); else result.append("<unset>");
		result.append(", innerReplica: ");
		if (innerReplicaESet) result.append(innerReplica); else result.append("<unset>");
		result.append(", replica: ");
		if (replicaESet) result.append(replica); else result.append("<unset>");
		result.append(", sliceReplica: ");
		if (sliceReplicaESet) result.append(sliceReplica); else result.append("<unset>");
		result.append(", uRef: ");
		result.append(uRef);
		result.append(')');
		return result.toString();
	}

} //UnitRefTypeImpl
