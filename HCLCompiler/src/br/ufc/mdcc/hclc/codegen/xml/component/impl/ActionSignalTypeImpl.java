/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ActionSignalType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Signal Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ActionSignalTypeImpl#getSemaphore <em>Semaphore</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionSignalTypeImpl extends ActionTypeImpl implements ActionSignalType {
	/**
	 * The default value of the '{@link #getSemaphore() <em>Semaphore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemaphore()
	 * @generated
	 * @ordered
	 */
	protected static final String SEMAPHORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSemaphore() <em>Semaphore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemaphore()
	 * @generated
	 * @ordered
	 */
	protected String semaphore = SEMAPHORE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionSignalTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.ACTION_SIGNAL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemaphore() {
		return semaphore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemaphore(String newSemaphore) {
		String oldSemaphore = semaphore;
		semaphore = newSemaphore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ACTION_SIGNAL_TYPE__SEMAPHORE, oldSemaphore, semaphore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.ACTION_SIGNAL_TYPE__SEMAPHORE:
				return getSemaphore();
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
			case ComponentPackage.ACTION_SIGNAL_TYPE__SEMAPHORE:
				setSemaphore((String)newValue);
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
			case ComponentPackage.ACTION_SIGNAL_TYPE__SEMAPHORE:
				setSemaphore(SEMAPHORE_EDEFAULT);
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
			case ComponentPackage.ACTION_SIGNAL_TYPE__SEMAPHORE:
				return SEMAPHORE_EDEFAULT == null ? semaphore != null : !SEMAPHORE_EDEFAULT.equals(semaphore);
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
		result.append(" (semaphore: ");
		result.append(semaphore);
		result.append(')');
		return result.toString();
	}

} //ActionSignalTypeImpl
