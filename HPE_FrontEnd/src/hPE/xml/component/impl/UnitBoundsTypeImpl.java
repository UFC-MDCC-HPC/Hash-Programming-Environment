/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.UnitBoundsType;
import hPE.xml.component.VisualElementAttributes;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Bounds Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.UnitBoundsTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitBoundsTypeImpl#isParallel <em>Parallel</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitBoundsTypeImpl#getReplica <em>Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitBoundsTypeImpl#getSliceReplica <em>Slice Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitBoundsTypeImpl#getUnitReplica <em>Unit Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitBoundsTypeImpl#getURef <em>URef</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitBoundsTypeImpl extends MinimalEObjectImpl.Container implements UnitBoundsType {
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
	 * The default value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParallel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARALLEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParallel()
	 * @generated
	 * @ordered
	 */
	protected boolean parallel = PARALLEL_EDEFAULT;

	/**
	 * This is true if the Parallel attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean parallelESet;

	/**
	 * The default value of the '{@link #getReplica() <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplica()
	 * @generated
	 * @ordered
	 */
	protected static final long REPLICA_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getReplica() <em>Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplica()
	 * @generated
	 * @ordered
	 */
	protected long replica = REPLICA_EDEFAULT;

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
	 * The default value of the '{@link #getUnitReplica() <em>Unit Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitReplica()
	 * @generated
	 * @ordered
	 */
	protected static final int UNIT_REPLICA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUnitReplica() <em>Unit Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitReplica()
	 * @generated
	 * @ordered
	 */
	protected int unitReplica = UNIT_REPLICA_EDEFAULT;

	/**
	 * This is true if the Unit Replica attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unitReplicaESet;

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
	protected UnitBoundsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.UNIT_BOUNDS_TYPE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
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
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParallel() {
		return parallel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParallel(boolean newParallel) {
		boolean oldParallel = parallel;
		parallel = newParallel;
		boolean oldParallelESet = parallelESet;
		parallelESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_BOUNDS_TYPE__PARALLEL, oldParallel, parallel, !oldParallelESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetParallel() {
		boolean oldParallel = parallel;
		boolean oldParallelESet = parallelESet;
		parallel = PARALLEL_EDEFAULT;
		parallelESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_BOUNDS_TYPE__PARALLEL, oldParallel, PARALLEL_EDEFAULT, oldParallelESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParallel() {
		return parallelESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getReplica() {
		return replica;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplica(long newReplica) {
		long oldReplica = replica;
		replica = newReplica;
		boolean oldReplicaESet = replicaESet;
		replicaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_BOUNDS_TYPE__REPLICA, oldReplica, replica, !oldReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReplica() {
		long oldReplica = replica;
		boolean oldReplicaESet = replicaESet;
		replica = REPLICA_EDEFAULT;
		replicaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_BOUNDS_TYPE__REPLICA, oldReplica, REPLICA_EDEFAULT, oldReplicaESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_BOUNDS_TYPE__SLICE_REPLICA, oldSliceReplica, sliceReplica, !oldSliceReplicaESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_BOUNDS_TYPE__SLICE_REPLICA, oldSliceReplica, SLICE_REPLICA_EDEFAULT, oldSliceReplicaESet));
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
	public int getUnitReplica() {
		return unitReplica;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitReplica(int newUnitReplica) {
		int oldUnitReplica = unitReplica;
		unitReplica = newUnitReplica;
		boolean oldUnitReplicaESet = unitReplicaESet;
		unitReplicaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_BOUNDS_TYPE__UNIT_REPLICA, oldUnitReplica, unitReplica, !oldUnitReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnitReplica() {
		int oldUnitReplica = unitReplica;
		boolean oldUnitReplicaESet = unitReplicaESet;
		unitReplica = UNIT_REPLICA_EDEFAULT;
		unitReplicaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_BOUNDS_TYPE__UNIT_REPLICA, oldUnitReplica, UNIT_REPLICA_EDEFAULT, oldUnitReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnitReplica() {
		return unitReplicaESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_BOUNDS_TYPE__UREF, oldURef, uRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION:
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
			case ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.UNIT_BOUNDS_TYPE__PARALLEL:
				return isParallel();
			case ComponentPackage.UNIT_BOUNDS_TYPE__REPLICA:
				return getReplica();
			case ComponentPackage.UNIT_BOUNDS_TYPE__SLICE_REPLICA:
				return getSliceReplica();
			case ComponentPackage.UNIT_BOUNDS_TYPE__UNIT_REPLICA:
				return getUnitReplica();
			case ComponentPackage.UNIT_BOUNDS_TYPE__UREF:
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
			case ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__PARALLEL:
				setParallel((Boolean)newValue);
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__REPLICA:
				setReplica((Long)newValue);
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__SLICE_REPLICA:
				setSliceReplica((Integer)newValue);
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__UNIT_REPLICA:
				setUnitReplica((Integer)newValue);
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__UREF:
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
			case ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__PARALLEL:
				unsetParallel();
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__REPLICA:
				unsetReplica();
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__SLICE_REPLICA:
				unsetSliceReplica();
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__UNIT_REPLICA:
				unsetUnitReplica();
				return;
			case ComponentPackage.UNIT_BOUNDS_TYPE__UREF:
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
			case ComponentPackage.UNIT_BOUNDS_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.UNIT_BOUNDS_TYPE__PARALLEL:
				return isSetParallel();
			case ComponentPackage.UNIT_BOUNDS_TYPE__REPLICA:
				return isSetReplica();
			case ComponentPackage.UNIT_BOUNDS_TYPE__SLICE_REPLICA:
				return isSetSliceReplica();
			case ComponentPackage.UNIT_BOUNDS_TYPE__UNIT_REPLICA:
				return isSetUnitReplica();
			case ComponentPackage.UNIT_BOUNDS_TYPE__UREF:
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
		result.append(" (parallel: ");
		if (parallelESet) result.append(parallel); else result.append("<unset>");
		result.append(", replica: ");
		if (replicaESet) result.append(replica); else result.append("<unset>");
		result.append(", sliceReplica: ");
		if (sliceReplicaESet) result.append(sliceReplica); else result.append("<unset>");
		result.append(", unitReplica: ");
		if (unitReplicaESet) result.append(unitReplica); else result.append("<unset>");
		result.append(", uRef: ");
		result.append(uRef);
		result.append(')');
		return result.toString();
	}

} //UnitBoundsTypeImpl
