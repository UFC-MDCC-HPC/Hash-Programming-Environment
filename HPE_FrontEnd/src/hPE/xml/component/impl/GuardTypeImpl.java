/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.ConditionType;
import hPE.xml.component.GuardType;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.GuardTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link hPE.xml.component.impl.GuardTypeImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link hPE.xml.component.impl.GuardTypeImpl#getAnd <em>And</em>}</li>
 *   <li>{@link hPE.xml.component.impl.GuardTypeImpl#getOr <em>Or</em>}</li>
 *   <li>{@link hPE.xml.component.impl.GuardTypeImpl#isNot <em>Not</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardTypeImpl extends EObjectImpl implements GuardType {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;
	/**
	 * The default value of the '{@link #isNot() <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NOT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNot() <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNot()
	 * @generated
	 * @ordered
	 */
	protected boolean not = NOT_EDEFAULT;
	/**
	 * This is true if the Not attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean notESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.GUARD_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, ComponentPackage.GUARD_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionType> getCondition() {
		return getGroup().list(ComponentPackage.Literals.GUARD_TYPE__CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GuardType> getAnd() {
		return getGroup().list(ComponentPackage.Literals.GUARD_TYPE__AND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GuardType> getOr() {
		return getGroup().list(ComponentPackage.Literals.GUARD_TYPE__OR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNot() {
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNot(boolean newNot) {
		boolean oldNot = not;
		not = newNot;
		boolean oldNotESet = notESet;
		notESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.GUARD_TYPE__NOT, oldNot, not, !oldNotESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNot() {
		boolean oldNot = not;
		boolean oldNotESet = notESet;
		not = NOT_EDEFAULT;
		notESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.GUARD_TYPE__NOT, oldNot, NOT_EDEFAULT, oldNotESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNot() {
		return notESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.GUARD_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case ComponentPackage.GUARD_TYPE__CONDITION:
				return ((InternalEList<?>)getCondition()).basicRemove(otherEnd, msgs);
			case ComponentPackage.GUARD_TYPE__AND:
				return ((InternalEList<?>)getAnd()).basicRemove(otherEnd, msgs);
			case ComponentPackage.GUARD_TYPE__OR:
				return ((InternalEList<?>)getOr()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.GUARD_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case ComponentPackage.GUARD_TYPE__CONDITION:
				return getCondition();
			case ComponentPackage.GUARD_TYPE__AND:
				return getAnd();
			case ComponentPackage.GUARD_TYPE__OR:
				return getOr();
			case ComponentPackage.GUARD_TYPE__NOT:
				return isNot();
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
			case ComponentPackage.GUARD_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case ComponentPackage.GUARD_TYPE__CONDITION:
				getCondition().clear();
				getCondition().addAll((Collection<? extends ConditionType>)newValue);
				return;
			case ComponentPackage.GUARD_TYPE__AND:
				getAnd().clear();
				getAnd().addAll((Collection<? extends GuardType>)newValue);
				return;
			case ComponentPackage.GUARD_TYPE__OR:
				getOr().clear();
				getOr().addAll((Collection<? extends GuardType>)newValue);
				return;
			case ComponentPackage.GUARD_TYPE__NOT:
				setNot((Boolean)newValue);
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
			case ComponentPackage.GUARD_TYPE__GROUP:
				getGroup().clear();
				return;
			case ComponentPackage.GUARD_TYPE__CONDITION:
				getCondition().clear();
				return;
			case ComponentPackage.GUARD_TYPE__AND:
				getAnd().clear();
				return;
			case ComponentPackage.GUARD_TYPE__OR:
				getOr().clear();
				return;
			case ComponentPackage.GUARD_TYPE__NOT:
				unsetNot();
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
			case ComponentPackage.GUARD_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case ComponentPackage.GUARD_TYPE__CONDITION:
				return !getCondition().isEmpty();
			case ComponentPackage.GUARD_TYPE__AND:
				return !getAnd().isEmpty();
			case ComponentPackage.GUARD_TYPE__OR:
				return !getOr().isEmpty();
			case ComponentPackage.GUARD_TYPE__NOT:
				return isSetNot();
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
		result.append(" (group: ");
		result.append(group);
		result.append(", not: ");
		if (notESet) result.append(not); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //GuardTypeImpl
