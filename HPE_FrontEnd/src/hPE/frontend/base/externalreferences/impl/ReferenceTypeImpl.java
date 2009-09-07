/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.base.externalreferences.impl;

import hPE.frontend.base.externalreferences.ExternalreferencesPackage;
import hPE.frontend.base.externalreferences.ReferenceType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl#getDestailedName <em>Destailed Name</em>}</li>
 *   <li>{@link hPE.frontend.base.externalreferences.impl.ReferenceTypeImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceTypeImpl extends EObjectImpl implements ReferenceType {
	/**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected EList<String> alias;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDestailedName() <em>Destailed Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestailedName()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTAILED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestailedName() <em>Destailed Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestailedName()
	 * @generated
	 * @ordered
	 */
	protected String destailedName = DESTAILED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExternalreferencesPackage.Literals.REFERENCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAlias() {
		if (alias == null) {
			alias = new EDataTypeEList<String>(String.class, this, ExternalreferencesPackage.REFERENCE_TYPE__ALIAS);
		}
		return alias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalreferencesPackage.REFERENCE_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestailedName() {
		return destailedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestailedName(String newDestailedName) {
		String oldDestailedName = destailedName;
		destailedName = newDestailedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalreferencesPackage.REFERENCE_TYPE__DESTAILED_NAME, oldDestailedName, destailedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExternalreferencesPackage.REFERENCE_TYPE__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExternalreferencesPackage.REFERENCE_TYPE__ALIAS:
				return getAlias();
			case ExternalreferencesPackage.REFERENCE_TYPE__DESCRIPTION:
				return getDescription();
			case ExternalreferencesPackage.REFERENCE_TYPE__DESTAILED_NAME:
				return getDestailedName();
			case ExternalreferencesPackage.REFERENCE_TYPE__PATH:
				return getPath();
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
			case ExternalreferencesPackage.REFERENCE_TYPE__ALIAS:
				getAlias().clear();
				getAlias().addAll((Collection<? extends String>)newValue);
				return;
			case ExternalreferencesPackage.REFERENCE_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ExternalreferencesPackage.REFERENCE_TYPE__DESTAILED_NAME:
				setDestailedName((String)newValue);
				return;
			case ExternalreferencesPackage.REFERENCE_TYPE__PATH:
				setPath((String)newValue);
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
			case ExternalreferencesPackage.REFERENCE_TYPE__ALIAS:
				getAlias().clear();
				return;
			case ExternalreferencesPackage.REFERENCE_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ExternalreferencesPackage.REFERENCE_TYPE__DESTAILED_NAME:
				setDestailedName(DESTAILED_NAME_EDEFAULT);
				return;
			case ExternalreferencesPackage.REFERENCE_TYPE__PATH:
				setPath(PATH_EDEFAULT);
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
			case ExternalreferencesPackage.REFERENCE_TYPE__ALIAS:
				return alias != null && !alias.isEmpty();
			case ExternalreferencesPackage.REFERENCE_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ExternalreferencesPackage.REFERENCE_TYPE__DESTAILED_NAME:
				return DESTAILED_NAME_EDEFAULT == null ? destailedName != null : !DESTAILED_NAME_EDEFAULT.equals(destailedName);
			case ExternalreferencesPackage.REFERENCE_TYPE__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
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
		result.append(" (alias: ");
		result.append(alias);
		result.append(", description: ");
		result.append(description);
		result.append(", destailedName: ");
		result.append(destailedName);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //ReferenceTypeImpl
