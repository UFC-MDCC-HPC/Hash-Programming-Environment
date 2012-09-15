/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.impl;

import hPE.frontend.connector.xml.component.ComponentPackage;
import hPE.frontend.connector.xml.component.HashComponentType;
import hPE.frontend.connector.xml.component.HpeinnerComponent;
import hPE.frontend.connector.xml.component.Hpekind;
import hPE.frontend.connector.xml.component.Hpeparameter;
import hPE.frontend.connector.xml.component.Hpetype;
import hPE.frontend.connector.xml.component.Unittype;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hash Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getUsing <em>Using</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getInnerComponent <em>Inner Component</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getSuperComponent <em>Super Component</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HashComponentTypeImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HashComponentTypeImpl extends EObjectImpl implements HashComponentType {
	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsing() <em>Using</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsing()
	 * @generated
	 * @ordered
	 */
	protected EList<String> using;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final Hpekind KIND_EDEFAULT = Hpekind.DATA;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected Hpekind kind = KIND_EDEFAULT;

	/**
	 * This is true if the Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kindESet;

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
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Hpeparameter> parameter;

	/**
	 * The cached value of the '{@link #getInnerComponent() <em>Inner Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerComponent()
	 * @generated
	 * @ordered
	 */
	protected EList<HpeinnerComponent> innerComponent;

	/**
	 * The cached value of the '{@link #getSuperComponent() <em>Super Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperComponent()
	 * @generated
	 * @ordered
	 */
	protected Hpetype superComponent;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected EList<Unittype> unit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HashComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.HASH_COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.HASH_COMPONENT_TYPE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUsing() {
		if (using == null) {
			using = new EDataTypeEList<String>(String.class, this, ComponentPackage.HASH_COMPONENT_TYPE__USING);
		}
		return using;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpekind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(Hpekind newKind) {
		Hpekind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		boolean oldKindESet = kindESet;
		kindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.HASH_COMPONENT_TYPE__KIND, oldKind, kind, !oldKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKind() {
		Hpekind oldKind = kind;
		boolean oldKindESet = kindESet;
		kind = KIND_EDEFAULT;
		kindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.HASH_COMPONENT_TYPE__KIND, oldKind, KIND_EDEFAULT, oldKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKind() {
		return kindESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.HASH_COMPONENT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hpeparameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Hpeparameter>(Hpeparameter.class, this, ComponentPackage.HASH_COMPONENT_TYPE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HpeinnerComponent> getInnerComponent() {
		if (innerComponent == null) {
			innerComponent = new EObjectContainmentEList<HpeinnerComponent>(HpeinnerComponent.class, this, ComponentPackage.HASH_COMPONENT_TYPE__INNER_COMPONENT);
		}
		return innerComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hpetype getSuperComponent() {
		return superComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperComponent(Hpetype newSuperComponent, NotificationChain msgs) {
		Hpetype oldSuperComponent = superComponent;
		superComponent = newSuperComponent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT, oldSuperComponent, newSuperComponent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperComponent(Hpetype newSuperComponent) {
		if (newSuperComponent != superComponent) {
			NotificationChain msgs = null;
			if (superComponent != null)
				msgs = ((InternalEObject)superComponent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT, null, msgs);
			if (newSuperComponent != null)
				msgs = ((InternalEObject)newSuperComponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT, null, msgs);
			msgs = basicSetSuperComponent(newSuperComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT, newSuperComponent, newSuperComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Unittype> getUnit() {
		if (unit == null) {
			unit = new EObjectContainmentEList<Unittype>(Unittype.class, this, ComponentPackage.HASH_COMPONENT_TYPE__UNIT);
		}
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.HASH_COMPONENT_TYPE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case ComponentPackage.HASH_COMPONENT_TYPE__INNER_COMPONENT:
				return ((InternalEList<?>)getInnerComponent()).basicRemove(otherEnd, msgs);
			case ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT:
				return basicSetSuperComponent(null, msgs);
			case ComponentPackage.HASH_COMPONENT_TYPE__UNIT:
				return ((InternalEList<?>)getUnit()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.HASH_COMPONENT_TYPE__PACKAGE:
				return getPackage();
			case ComponentPackage.HASH_COMPONENT_TYPE__USING:
				return getUsing();
			case ComponentPackage.HASH_COMPONENT_TYPE__KIND:
				return getKind();
			case ComponentPackage.HASH_COMPONENT_TYPE__NAME:
				return getName();
			case ComponentPackage.HASH_COMPONENT_TYPE__PARAMETER:
				return getParameter();
			case ComponentPackage.HASH_COMPONENT_TYPE__INNER_COMPONENT:
				return getInnerComponent();
			case ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT:
				return getSuperComponent();
			case ComponentPackage.HASH_COMPONENT_TYPE__UNIT:
				return getUnit();
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
			case ComponentPackage.HASH_COMPONENT_TYPE__PACKAGE:
				setPackage((String)newValue);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__USING:
				getUsing().clear();
				getUsing().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__KIND:
				setKind((Hpekind)newValue);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__NAME:
				setName((String)newValue);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Hpeparameter>)newValue);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__INNER_COMPONENT:
				getInnerComponent().clear();
				getInnerComponent().addAll((Collection<? extends HpeinnerComponent>)newValue);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT:
				setSuperComponent((Hpetype)newValue);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__UNIT:
				getUnit().clear();
				getUnit().addAll((Collection<? extends Unittype>)newValue);
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
			case ComponentPackage.HASH_COMPONENT_TYPE__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__USING:
				getUsing().clear();
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__KIND:
				unsetKind();
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__PARAMETER:
				getParameter().clear();
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__INNER_COMPONENT:
				getInnerComponent().clear();
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT:
				setSuperComponent((Hpetype)null);
				return;
			case ComponentPackage.HASH_COMPONENT_TYPE__UNIT:
				getUnit().clear();
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
			case ComponentPackage.HASH_COMPONENT_TYPE__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case ComponentPackage.HASH_COMPONENT_TYPE__USING:
				return using != null && !using.isEmpty();
			case ComponentPackage.HASH_COMPONENT_TYPE__KIND:
				return isSetKind();
			case ComponentPackage.HASH_COMPONENT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentPackage.HASH_COMPONENT_TYPE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case ComponentPackage.HASH_COMPONENT_TYPE__INNER_COMPONENT:
				return innerComponent != null && !innerComponent.isEmpty();
			case ComponentPackage.HASH_COMPONENT_TYPE__SUPER_COMPONENT:
				return superComponent != null;
			case ComponentPackage.HASH_COMPONENT_TYPE__UNIT:
				return unit != null && !unit.isEmpty();
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
		result.append(" (package: ");
		result.append(package_);
		result.append(", using: ");
		result.append(using);
		result.append(", kind: ");
		if (kindESet) result.append(kind); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //HashComponentTypeImpl
