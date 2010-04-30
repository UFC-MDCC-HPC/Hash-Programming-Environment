/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Supply Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterSupplyTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ParameterSupplyTypeImpl#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterSupplyTypeImpl extends EObjectImpl implements ParameterSupplyType {
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
	 * The default value of the '{@link #getVarName() <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarName()
	 * @generated
	 * @ordered
	 */
	protected static final String VAR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVarName() <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarName()
	 * @generated
	 * @ordered
	 */
	protected String varName = VAR_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterSupplyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.PARAMETER_SUPPLY_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PARAMETER_SUPPLY_TYPE__CREF, oldCRef, cRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVarName() {
		return varName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarName(String newVarName) {
		String oldVarName = varName;
		varName = newVarName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PARAMETER_SUPPLY_TYPE__VAR_NAME, oldVarName, varName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__CREF:
				return getCRef();
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__VAR_NAME:
				return getVarName();
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
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__VAR_NAME:
				setVarName((String)newValue);
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
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__CREF:
				setCRef(CREF_EDEFAULT);
				return;
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__VAR_NAME:
				setVarName(VAR_NAME_EDEFAULT);
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
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__CREF:
				return CREF_EDEFAULT == null ? cRef != null : !CREF_EDEFAULT.equals(cRef);
			case ComponentPackage.PARAMETER_SUPPLY_TYPE__VAR_NAME:
				return VAR_NAME_EDEFAULT == null ? varName != null : !VAR_NAME_EDEFAULT.equals(varName);
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
		result.append(", varName: ");
		result.append(varName);
		result.append(')');
		return result.toString();
	}

} //ParameterSupplyTypeImpl
