/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentInUseType;
import hPE.xml.component.ComponentPackage;
import hPE.xml.component.ParameterRenaming;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Renaming</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.ParameterRenamingImpl#getFormFieldId <em>Form Field Id</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ParameterRenamingImpl#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterRenamingImpl extends EObjectImpl implements ParameterRenaming {
	/**
	 * The default value of the '{@link #getFormFieldId() <em>Form Field Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormFieldId()
	 * @generated
	 * @ordered
	 */
	protected static final String FORM_FIELD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormFieldId() <em>Form Field Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormFieldId()
	 * @generated
	 * @ordered
	 */
	protected String formFieldId = FORM_FIELD_ID_EDEFAULT;

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
	protected ParameterRenamingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.PARAMETER_RENAMING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormFieldId() {
		return formFieldId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormFieldId(String newFormFieldId) {
		String oldFormFieldId = formFieldId;
		formFieldId = newFormFieldId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PARAMETER_RENAMING__FORM_FIELD_ID, oldFormFieldId, formFieldId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PARAMETER_RENAMING__VAR_NAME, oldVarName, varName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.PARAMETER_RENAMING__FORM_FIELD_ID:
				return getFormFieldId();
			case ComponentPackage.PARAMETER_RENAMING__VAR_NAME:
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
			case ComponentPackage.PARAMETER_RENAMING__FORM_FIELD_ID:
				setFormFieldId((String)newValue);
				return;
			case ComponentPackage.PARAMETER_RENAMING__VAR_NAME:
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
			case ComponentPackage.PARAMETER_RENAMING__FORM_FIELD_ID:
				setFormFieldId(FORM_FIELD_ID_EDEFAULT);
				return;
			case ComponentPackage.PARAMETER_RENAMING__VAR_NAME:
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
			case ComponentPackage.PARAMETER_RENAMING__FORM_FIELD_ID:
				return FORM_FIELD_ID_EDEFAULT == null ? formFieldId != null : !FORM_FIELD_ID_EDEFAULT.equals(formFieldId);
			case ComponentPackage.PARAMETER_RENAMING__VAR_NAME:
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
		result.append(" (formFieldId: ");
		result.append(formFieldId);
		result.append(", varName: ");
		result.append(varName);
		result.append(')');
		return result.toString();
	}

} //ParameterRenamingImpl
