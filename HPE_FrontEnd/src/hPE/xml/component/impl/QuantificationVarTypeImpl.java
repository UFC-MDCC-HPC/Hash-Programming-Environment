/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.QuantificationType;
import hPE.xml.component.QuantificationVarType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quantification Var Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.QuantificationVarTypeImpl#getQType <em>QType</em>}</li>
 *   <li>{@link hPE.xml.component.impl.QuantificationVarTypeImpl#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuantificationVarTypeImpl extends EObjectImpl implements QuantificationVarType {
	/**
	 * The default value of the '{@link #getQType() <em>QType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQType()
	 * @generated
	 * @ordered
	 */
	protected static final QuantificationType QTYPE_EDEFAULT = QuantificationType.UNIVERSAL;

	/**
	 * The cached value of the '{@link #getQType() <em>QType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQType()
	 * @generated
	 * @ordered
	 */
	protected QuantificationType qType = QTYPE_EDEFAULT;

	/**
	 * This is true if the QType attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean qTypeESet;

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
	protected QuantificationVarTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.QUANTIFICATION_VAR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuantificationType getQType() {
		return qType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQType(QuantificationType newQType) {
		QuantificationType oldQType = qType;
		qType = newQType == null ? QTYPE_EDEFAULT : newQType;
		boolean oldQTypeESet = qTypeESet;
		qTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.QUANTIFICATION_VAR_TYPE__QTYPE, oldQType, qType, !oldQTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetQType() {
		QuantificationType oldQType = qType;
		boolean oldQTypeESet = qTypeESet;
		qType = QTYPE_EDEFAULT;
		qTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.QUANTIFICATION_VAR_TYPE__QTYPE, oldQType, QTYPE_EDEFAULT, oldQTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQType() {
		return qTypeESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.QUANTIFICATION_VAR_TYPE__VAR_NAME, oldVarName, varName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__QTYPE:
				return getQType();
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__VAR_NAME:
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
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__QTYPE:
				setQType((QuantificationType)newValue);
				return;
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__VAR_NAME:
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
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__QTYPE:
				unsetQType();
				return;
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__VAR_NAME:
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
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__QTYPE:
				return isSetQType();
			case ComponentPackage.QUANTIFICATION_VAR_TYPE__VAR_NAME:
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
		result.append(" (qType: ");
		if (qTypeESet) result.append(qType); else result.append("<unset>");
		result.append(", varName: ");
		result.append(varName);
		result.append(')');
		return result.toString();
	}

} //QuantificationVarTypeImpl
