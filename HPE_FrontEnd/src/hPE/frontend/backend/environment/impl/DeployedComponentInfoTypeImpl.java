/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment.impl;

import hPE.frontend.backend.environment.DeployedComponentInfoType;
import hPE.frontend.backend.environment.DeployedParameterType;
import hPE.frontend.backend.environment.EnvironmentPackage;

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
 * An implementation of the model object '<em><b>Deployed Component Info Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getEnumerator <em>Enumerator</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getCid <em>Cid</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getCidBase <em>Cid Base</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getLocationURI <em>Location URI</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.impl.DeployedComponentInfoTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeployedComponentInfoTypeImpl extends EObjectImpl implements DeployedComponentInfoType {
	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<String> package_;

	/**
	 * The cached value of the '{@link #getEnumerator() <em>Enumerator</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerator()
	 * @generated
	 * @ordered
	 */
	protected EList<String> enumerator;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<DeployedParameterType> parameter;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * This is true if the Abstract attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean abstractESet;

	/**
	 * The default value of the '{@link #getCid() <em>Cid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCid()
	 * @generated
	 * @ordered
	 */
	protected static final int CID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCid() <em>Cid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCid()
	 * @generated
	 * @ordered
	 */
	protected int cid = CID_EDEFAULT;

	/**
	 * This is true if the Cid attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cidESet;

	/**
	 * The default value of the '{@link #getCidBase() <em>Cid Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCidBase()
	 * @generated
	 * @ordered
	 */
	protected static final int CID_BASE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCidBase() <em>Cid Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCidBase()
	 * @generated
	 * @ordered
	 */
	protected int cidBase = CID_BASE_EDEFAULT;

	/**
	 * This is true if the Cid Base attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cidBaseESet;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocationURI() <em>Location URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationURI()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocationURI() <em>Location URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationURI()
	 * @generated
	 * @ordered
	 */
	protected String locationURI = LOCATION_URI_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployedComponentInfoTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.DEPLOYED_COMPONENT_INFO_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPackage() {
		if (package_ == null) {
			package_ = new EDataTypeEList<String>(String.class, this, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE);
		}
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEnumerator() {
		if (enumerator == null) {
			enumerator = new EDataTypeEList<String>(String.class, this, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR);
		}
		return enumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeployedParameterType> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<DeployedParameterType>(DeployedParameterType.class, this, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		boolean oldAbstractESet = abstractESet;
		abstractESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT, oldAbstract, abstract_, !oldAbstractESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAbstract() {
		boolean oldAbstract = abstract_;
		boolean oldAbstractESet = abstractESet;
		abstract_ = ABSTRACT_EDEFAULT;
		abstractESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT, oldAbstract, ABSTRACT_EDEFAULT, oldAbstractESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAbstract() {
		return abstractESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCid(int newCid) {
		int oldCid = cid;
		cid = newCid;
		boolean oldCidESet = cidESet;
		cidESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID, oldCid, cid, !oldCidESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCid() {
		int oldCid = cid;
		boolean oldCidESet = cidESet;
		cid = CID_EDEFAULT;
		cidESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID, oldCid, CID_EDEFAULT, oldCidESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCid() {
		return cidESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCidBase() {
		return cidBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCidBase(int newCidBase) {
		int oldCidBase = cidBase;
		cidBase = newCidBase;
		boolean oldCidBaseESet = cidBaseESet;
		cidBaseESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID_BASE, oldCidBase, cidBase, !oldCidBaseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCidBase() {
		int oldCidBase = cidBase;
		boolean oldCidBaseESet = cidBaseESet;
		cidBase = CID_BASE_EDEFAULT;
		cidBaseESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID_BASE, oldCidBase, CID_BASE_EDEFAULT, oldCidBaseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCidBase() {
		return cidBaseESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocationURI() {
		return locationURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationURI(String newLocationURI) {
		String oldLocationURI = locationURI;
		locationURI = newLocationURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI, oldLocationURI, locationURI));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER:
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
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE:
				return getPackage();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR:
				return getEnumerator();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER:
				return getParameter();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT:
				return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID:
				return new Integer(getCid());
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID_BASE:
				return new Integer(getCidBase());
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__KIND:
				return getKind();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI:
				return getLocationURI();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__NAME:
				return getName();
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
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE:
				getPackage().clear();
				getPackage().addAll((Collection<? extends String>)newValue);
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR:
				getEnumerator().clear();
				getEnumerator().addAll((Collection<? extends String>)newValue);
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends DeployedParameterType>)newValue);
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT:
				setAbstract(((Boolean)newValue).booleanValue());
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID:
				setCid(((Integer)newValue).intValue());
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID_BASE:
				setCidBase(((Integer)newValue).intValue());
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__KIND:
				setKind((String)newValue);
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI:
				setLocationURI((String)newValue);
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__NAME:
				setName((String)newValue);
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
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE:
				getPackage().clear();
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR:
				getEnumerator().clear();
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER:
				getParameter().clear();
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT:
				unsetAbstract();
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID:
				unsetCid();
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID_BASE:
				unsetCidBase();
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI:
				setLocationURI(LOCATION_URI_EDEFAULT);
				return;
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PACKAGE:
				return package_ != null && !package_.isEmpty();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ENUMERATOR:
				return enumerator != null && !enumerator.isEmpty();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__ABSTRACT:
				return isSetAbstract();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID:
				return isSetCid();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__CID_BASE:
				return isSetCidBase();
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__LOCATION_URI:
				return LOCATION_URI_EDEFAULT == null ? locationURI != null : !LOCATION_URI_EDEFAULT.equals(locationURI);
			case EnvironmentPackage.DEPLOYED_COMPONENT_INFO_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", enumerator: ");
		result.append(enumerator);
		result.append(", abstract: ");
		if (abstractESet) result.append(abstract_); else result.append("<unset>");
		result.append(", cid: ");
		if (cidESet) result.append(cid); else result.append("<unset>");
		result.append(", cidBase: ");
		if (cidBaseESet) result.append(cidBase); else result.append("<unset>");
		result.append(", kind: ");
		result.append(kind);
		result.append(", locationURI: ");
		result.append(locationURI);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DeployedComponentInfoTypeImpl
