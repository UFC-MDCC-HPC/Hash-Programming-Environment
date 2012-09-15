/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.connector.xml.component.impl;

import hPE.frontend.connector.xml.component.ComponentPackage;
import hPE.frontend.connector.xml.component.Hpeparameter;
import hPE.frontend.connector.xml.component.HpeparameterType;

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
 * An implementation of the model object '<em><b>Hpeparameter Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HpeparameterTypeImpl#getComponentConstraint <em>Component Constraint</em>}</li>
 *   <li>{@link hPE.frontend.connector.xml.component.impl.HpeparameterTypeImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HpeparameterTypeImpl extends EObjectImpl implements HpeparameterType {
	/**
	 * The default value of the '{@link #getComponentConstraint() <em>Component Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_CONSTRAINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentConstraint() <em>Component Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentConstraint()
	 * @generated
	 * @ordered
	 */
	protected String componentConstraint = COMPONENT_CONSTRAINT_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HpeparameterTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.HPEPARAMETER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentConstraint() {
		return componentConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentConstraint(String newComponentConstraint) {
		String oldComponentConstraint = componentConstraint;
		componentConstraint = newComponentConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT, oldComponentConstraint, componentConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hpeparameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Hpeparameter>(Hpeparameter.class, this, ComponentPackage.HPEPARAMETER_TYPE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.HPEPARAMETER_TYPE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT:
				return getComponentConstraint();
			case ComponentPackage.HPEPARAMETER_TYPE__PARAMETER:
				return getParameter();
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
			case ComponentPackage.HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT:
				setComponentConstraint((String)newValue);
				return;
			case ComponentPackage.HPEPARAMETER_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Hpeparameter>)newValue);
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
			case ComponentPackage.HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT:
				setComponentConstraint(COMPONENT_CONSTRAINT_EDEFAULT);
				return;
			case ComponentPackage.HPEPARAMETER_TYPE__PARAMETER:
				getParameter().clear();
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
			case ComponentPackage.HPEPARAMETER_TYPE__COMPONENT_CONSTRAINT:
				return COMPONENT_CONSTRAINT_EDEFAULT == null ? componentConstraint != null : !COMPONENT_CONSTRAINT_EDEFAULT.equals(componentConstraint);
			case ComponentPackage.HPEPARAMETER_TYPE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
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
		result.append(" (componentConstraint: ");
		result.append(componentConstraint);
		result.append(')');
		return result.toString();
	}

} //HpeparameterTypeImpl
