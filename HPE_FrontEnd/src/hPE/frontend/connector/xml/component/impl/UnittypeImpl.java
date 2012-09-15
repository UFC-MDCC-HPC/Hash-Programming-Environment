/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.impl;

import hPE.frontend.connector.xml.component.ComponentPackage;
import hPE.frontend.connector.xml.component.GuardType;
import hPE.frontend.connector.xml.component.Hpeaction;
import hPE.frontend.connector.xml.component.Hpecondition;
import hPE.frontend.connector.xml.component.HpesliceType;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.connector.xml.component.Unittype;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unittype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl#getSlice <em>Slice</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl#getAction <em>Action</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.UnittypeImpl#isParallel <em>Parallel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnittypeImpl extends EObjectImpl implements Unittype {
	/**
	 * The cached value of the '{@link #getSlice() <em>Slice</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlice()
	 * @generated
	 * @ordered
	 */
	protected EList<HpesliceType> slice;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Hpeaction> action;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<Hpecondition> condition;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * This is true if the Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indexESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParallel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARALLEL_EDEFAULT = true;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnittypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.UNITTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HpesliceType> getSlice() {
		if (slice == null) {
			slice = new EObjectContainmentEList<HpesliceType>(HpesliceType.class, this, ComponentPackage.UNITTYPE__SLICE);
		}
		return slice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hpeaction> getAction() {
		if (action == null) {
			action = new EObjectContainmentEList<Hpeaction>(Hpeaction.class, this, ComponentPackage.UNITTYPE__ACTION);
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hpecondition> getCondition() {
		if (condition == null) {
			condition = new EObjectContainmentEList<Hpecondition>(Hpecondition.class, this, ComponentPackage.UNITTYPE__CONDITION);
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		boolean oldIndexESet = indexESet;
		indexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNITTYPE__INDEX, oldIndex, index, !oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndex() {
		int oldIndex = index;
		boolean oldIndexESet = indexESet;
		index = INDEX_EDEFAULT;
		indexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNITTYPE__INDEX, oldIndex, INDEX_EDEFAULT, oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndex() {
		return indexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNITTYPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNITTYPE__PARALLEL, oldParallel, parallel, !oldParallelESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNITTYPE__PARALLEL, oldParallel, PARALLEL_EDEFAULT, oldParallelESet));
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.UNITTYPE__SLICE:
				return ((InternalEList<?>)getSlice()).basicRemove(otherEnd, msgs);
			case ComponentPackage.UNITTYPE__ACTION:
				return ((InternalEList<?>)getAction()).basicRemove(otherEnd, msgs);
			case ComponentPackage.UNITTYPE__CONDITION:
				return ((InternalEList<?>)getCondition()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.UNITTYPE__SLICE:
				return getSlice();
			case ComponentPackage.UNITTYPE__ACTION:
				return getAction();
			case ComponentPackage.UNITTYPE__CONDITION:
				return getCondition();
			case ComponentPackage.UNITTYPE__INDEX:
				return getIndex();
			case ComponentPackage.UNITTYPE__NAME:
				return getName();
			case ComponentPackage.UNITTYPE__PARALLEL:
				return isParallel();
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
			case ComponentPackage.UNITTYPE__SLICE:
				getSlice().clear();
				getSlice().addAll((Collection<? extends HpesliceType>)newValue);
				return;
			case ComponentPackage.UNITTYPE__ACTION:
				getAction().clear();
				getAction().addAll((Collection<? extends Hpeaction>)newValue);
				return;
			case ComponentPackage.UNITTYPE__CONDITION:
				getCondition().clear();
				getCondition().addAll((Collection<? extends Hpecondition>)newValue);
				return;
			case ComponentPackage.UNITTYPE__INDEX:
				setIndex((Integer)newValue);
				return;
			case ComponentPackage.UNITTYPE__NAME:
				setName((String)newValue);
				return;
			case ComponentPackage.UNITTYPE__PARALLEL:
				setParallel((Boolean)newValue);
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
			case ComponentPackage.UNITTYPE__SLICE:
				getSlice().clear();
				return;
			case ComponentPackage.UNITTYPE__ACTION:
				getAction().clear();
				return;
			case ComponentPackage.UNITTYPE__CONDITION:
				getCondition().clear();
				return;
			case ComponentPackage.UNITTYPE__INDEX:
				unsetIndex();
				return;
			case ComponentPackage.UNITTYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentPackage.UNITTYPE__PARALLEL:
				unsetParallel();
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
			case ComponentPackage.UNITTYPE__SLICE:
				return slice != null && !slice.isEmpty();
			case ComponentPackage.UNITTYPE__ACTION:
				return action != null && !action.isEmpty();
			case ComponentPackage.UNITTYPE__CONDITION:
				return condition != null && !condition.isEmpty();
			case ComponentPackage.UNITTYPE__INDEX:
				return isSetIndex();
			case ComponentPackage.UNITTYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentPackage.UNITTYPE__PARALLEL:
				return isSetParallel();
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
		result.append(" (index: ");
		if (indexESet) result.append(index); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", parallel: ");
		if (parallelESet) result.append(parallel); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //UnittypeImpl
