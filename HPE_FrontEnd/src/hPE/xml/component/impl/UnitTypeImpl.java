/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.UnitRefType;
import hPE.xml.component.UnitSliceType;
import hPE.xml.component.UnitType;
import hPE.xml.component.VisualElementAttributes;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#getSlices <em>Slices</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#getFacet <em>Facet</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#getIRef <em>IRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#isMultiple <em>Multiple</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#getReplica <em>Replica</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#getURef <em>URef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitTypeImpl#isVisibleInterface <em>Visible Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitTypeImpl extends MinimalEObjectImpl.Container implements UnitType {
	/**
	 * The cached value of the '{@link #getSuper() <em>Super</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitRefType> super_;

	/**
	 * The cached value of the '{@link #getSlices() <em>Slices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlices()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitSliceType> slices;

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
	 * The default value of the '{@link #getIRef() <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRef()
	 * @generated
	 * @ordered
	 */
	protected static final String IREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIRef() <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRef()
	 * @generated
	 * @ordered
	 */
	protected String iRef = IREF_EDEFAULT;

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
	 * The default value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIVATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
	protected boolean private_ = PRIVATE_EDEFAULT;

	/**
	 * This is true if the Private attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean privateESet;

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
	 * The default value of the '{@link #isVisibleInterface() <em>Visible Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisibleInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_INTERFACE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisibleInterface() <em>Visible Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisibleInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean visibleInterface = VISIBLE_INTERFACE_EDEFAULT;

	/**
	 * This is true if the Visible Interface attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean visibleInterfaceESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.UNIT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitRefType> getSuper() {
		if (super_ == null) {
			super_ = new EObjectContainmentEList<UnitRefType>(UnitRefType.class, this, ComponentPackage.UNIT_TYPE__SUPER);
		}
		return super_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitSliceType> getSlices() {
		if (slices == null) {
			slices = new EObjectContainmentEList<UnitSliceType>(UnitSliceType.class, this, ComponentPackage.UNIT_TYPE__SLICES);
		}
		return slices;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
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
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__FACET, oldFacet, facet, !oldFacetESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_TYPE__FACET, oldFacet, FACET_EDEFAULT, oldFacetESet));
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
	public String getIRef() {
		return iRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIRef(String newIRef) {
		String oldIRef = iRef;
		iRef = newIRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__IREF, oldIRef, iRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__MULTIPLE, oldMultiple, multiple, !oldMultipleESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_TYPE__MULTIPLE, oldMultiple, MULTIPLE_EDEFAULT, oldMultipleESet));
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
	public boolean isPrivate() {
		return private_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrivate(boolean newPrivate) {
		boolean oldPrivate = private_;
		private_ = newPrivate;
		boolean oldPrivateESet = privateESet;
		privateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__PRIVATE, oldPrivate, private_, !oldPrivateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPrivate() {
		boolean oldPrivate = private_;
		boolean oldPrivateESet = privateESet;
		private_ = PRIVATE_EDEFAULT;
		privateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_TYPE__PRIVATE, oldPrivate, PRIVATE_EDEFAULT, oldPrivateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPrivate() {
		return privateESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__REPLICA, oldReplica, replica, !oldReplicaESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_TYPE__REPLICA, oldReplica, REPLICA_EDEFAULT, oldReplicaESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__UREF, oldURef, uRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisibleInterface() {
		return visibleInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleInterface(boolean newVisibleInterface) {
		boolean oldVisibleInterface = visibleInterface;
		visibleInterface = newVisibleInterface;
		boolean oldVisibleInterfaceESet = visibleInterfaceESet;
		visibleInterfaceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_TYPE__VISIBLE_INTERFACE, oldVisibleInterface, visibleInterface, !oldVisibleInterfaceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleInterface() {
		boolean oldVisibleInterface = visibleInterface;
		boolean oldVisibleInterfaceESet = visibleInterfaceESet;
		visibleInterface = VISIBLE_INTERFACE_EDEFAULT;
		visibleInterfaceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_TYPE__VISIBLE_INTERFACE, oldVisibleInterface, VISIBLE_INTERFACE_EDEFAULT, oldVisibleInterfaceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleInterface() {
		return visibleInterfaceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.UNIT_TYPE__SUPER:
				return ((InternalEList<?>)getSuper()).basicRemove(otherEnd, msgs);
			case ComponentPackage.UNIT_TYPE__SLICES:
				return ((InternalEList<?>)getSlices()).basicRemove(otherEnd, msgs);
			case ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION:
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
			case ComponentPackage.UNIT_TYPE__SUPER:
				return getSuper();
			case ComponentPackage.UNIT_TYPE__SLICES:
				return getSlices();
			case ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.UNIT_TYPE__FACET:
				return getFacet();
			case ComponentPackage.UNIT_TYPE__IREF:
				return getIRef();
			case ComponentPackage.UNIT_TYPE__MULTIPLE:
				return isMultiple();
			case ComponentPackage.UNIT_TYPE__PRIVATE:
				return isPrivate();
			case ComponentPackage.UNIT_TYPE__REPLICA:
				return getReplica();
			case ComponentPackage.UNIT_TYPE__UREF:
				return getURef();
			case ComponentPackage.UNIT_TYPE__VISIBLE_INTERFACE:
				return isVisibleInterface();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.UNIT_TYPE__SUPER:
				getSuper().clear();
				getSuper().addAll((Collection<? extends UnitRefType>)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__SLICES:
				getSlices().clear();
				getSlices().addAll((Collection<? extends UnitSliceType>)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__FACET:
				setFacet((Integer)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__IREF:
				setIRef((String)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__MULTIPLE:
				setMultiple((Boolean)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__PRIVATE:
				setPrivate((Boolean)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__REPLICA:
				setReplica((Integer)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__UREF:
				setURef((String)newValue);
				return;
			case ComponentPackage.UNIT_TYPE__VISIBLE_INTERFACE:
				setVisibleInterface((Boolean)newValue);
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
			case ComponentPackage.UNIT_TYPE__SUPER:
				getSuper().clear();
				return;
			case ComponentPackage.UNIT_TYPE__SLICES:
				getSlices().clear();
				return;
			case ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.UNIT_TYPE__FACET:
				unsetFacet();
				return;
			case ComponentPackage.UNIT_TYPE__IREF:
				setIRef(IREF_EDEFAULT);
				return;
			case ComponentPackage.UNIT_TYPE__MULTIPLE:
				unsetMultiple();
				return;
			case ComponentPackage.UNIT_TYPE__PRIVATE:
				unsetPrivate();
				return;
			case ComponentPackage.UNIT_TYPE__REPLICA:
				unsetReplica();
				return;
			case ComponentPackage.UNIT_TYPE__UREF:
				setURef(UREF_EDEFAULT);
				return;
			case ComponentPackage.UNIT_TYPE__VISIBLE_INTERFACE:
				unsetVisibleInterface();
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
			case ComponentPackage.UNIT_TYPE__SUPER:
				return super_ != null && !super_.isEmpty();
			case ComponentPackage.UNIT_TYPE__SLICES:
				return slices != null && !slices.isEmpty();
			case ComponentPackage.UNIT_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.UNIT_TYPE__FACET:
				return isSetFacet();
			case ComponentPackage.UNIT_TYPE__IREF:
				return IREF_EDEFAULT == null ? iRef != null : !IREF_EDEFAULT.equals(iRef);
			case ComponentPackage.UNIT_TYPE__MULTIPLE:
				return isSetMultiple();
			case ComponentPackage.UNIT_TYPE__PRIVATE:
				return isSetPrivate();
			case ComponentPackage.UNIT_TYPE__REPLICA:
				return isSetReplica();
			case ComponentPackage.UNIT_TYPE__UREF:
				return UREF_EDEFAULT == null ? uRef != null : !UREF_EDEFAULT.equals(uRef);
			case ComponentPackage.UNIT_TYPE__VISIBLE_INTERFACE:
				return isSetVisibleInterface();
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
		result.append(", iRef: ");
		result.append(iRef);
		result.append(", multiple: ");
		if (multipleESet) result.append(multiple); else result.append("<unset>");
		result.append(", private: ");
		if (privateESet) result.append(private_); else result.append("<unset>");
		result.append(", replica: ");
		if (replicaESet) result.append(replica); else result.append("<unset>");
		result.append(", uRef: ");
		result.append(uRef);
		result.append(", visibleInterface: ");
		if (visibleInterfaceESet) result.append(visibleInterface); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //UnitTypeImpl
