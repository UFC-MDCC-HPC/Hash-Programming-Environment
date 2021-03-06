/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.InnerComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType;
import br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes;

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
 * An implementation of the model object '<em><b>In Use Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getPort <em>Port</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getUnitBounds <em>Unit Bounds</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getHashComponentUID <em>Hash Component UID</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getLocalRef <em>Local Ref</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getParameterId <em>Parameter Id</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.ComponentInUseTypeImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInUseTypeImpl extends EObjectImpl implements ComponentInUseType {
	/**
	 * The cached value of the '{@link #getVisualDescription() <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualDescription()
	 * @generated
	 * @ordered
	 */
	protected VisualElementAttributes visualDescription;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterRenaming> parameter;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected EList<InnerComponentType> port;

	/**
	 * The cached value of the '{@link #getUnitBounds() <em>Unit Bounds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitBounds()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitBoundsType> unitBounds;

	/**
	 * The default value of the '{@link #getHashComponentUID() <em>Hash Component UID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHashComponentUID()
	 * @generated
	 * @ordered
	 */
	protected static final String HASH_COMPONENT_UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHashComponentUID() <em>Hash Component UID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHashComponentUID()
	 * @generated
	 * @ordered
	 */
	protected String hashComponentUID = HASH_COMPONENT_UID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalRef() <em>Local Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalRef()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalRef() <em>Local Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalRef()
	 * @generated
	 * @ordered
	 */
	protected String localRef = LOCAL_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

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
	 * The default value of the '{@link #getParameterId() <em>Parameter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterId() <em>Parameter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterId()
	 * @generated
	 * @ordered
	 */
	protected String parameterId = PARAMETER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentInUseTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.COMPONENT_IN_USE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualElementAttributes getVisualDescription() {
		return visualDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisualDescription(VisualElementAttributes newVisualDescription, NotificationChain msgs) {
		VisualElementAttributes oldVisualDescription = visualDescription;
		visualDescription = newVisualDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualDescription(VisualElementAttributes newVisualDescription) {
		if (newVisualDescription != visualDescription) {
			NotificationChain msgs = null;
			if (visualDescription != null)
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterRenaming> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<ParameterRenaming>(ParameterRenaming.class, this, ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InnerComponentType> getPort() {
		if (port == null) {
			port = new EObjectContainmentEList<InnerComponentType>(InnerComponentType.class, this, ComponentPackage.COMPONENT_IN_USE_TYPE__PORT);
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitBoundsType> getUnitBounds() {
		if (unitBounds == null) {
			unitBounds = new EObjectContainmentEList<UnitBoundsType>(UnitBoundsType.class, this, ComponentPackage.COMPONENT_IN_USE_TYPE__UNIT_BOUNDS);
		}
		return unitBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHashComponentUID() {
		return hashComponentUID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHashComponentUID(String newHashComponentUID) {
		String oldHashComponentUID = hashComponentUID;
		hashComponentUID = newHashComponentUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID, oldHashComponentUID, hashComponentUID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalRef() {
		return localRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalRef(String newLocalRef) {
		String oldLocalRef = localRef;
		localRef = newLocalRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__LOCAL_REF, oldLocalRef, localRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__LOCATION, oldLocation, location));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterId() {
		return parameterId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterId(String newParameterId) {
		String oldParameterId = parameterId;
		parameterId = newParameterId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER_ID, oldParameterId, parameterId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_IN_USE_TYPE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION:
				return basicSetVisualDescription(null, msgs);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PORT:
				return ((InternalEList<?>)getPort()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__UNIT_BOUNDS:
				return ((InternalEList<?>)getUnitBounds()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER:
				return getParameter();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PORT:
				return getPort();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__UNIT_BOUNDS:
				return getUnitBounds();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID:
				return getHashComponentUID();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCAL_REF:
				return getLocalRef();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCATION:
				return getLocation();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__NAME:
				return getName();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PACKAGE:
				return getPackage();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER_ID:
				return getParameterId();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VERSION:
				return getVersion();
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
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends ParameterRenaming>)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PORT:
				getPort().clear();
				getPort().addAll((Collection<? extends InnerComponentType>)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__UNIT_BOUNDS:
				getUnitBounds().clear();
				getUnitBounds().addAll((Collection<? extends UnitBoundsType>)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID:
				setHashComponentUID((String)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCAL_REF:
				setLocalRef((String)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCATION:
				setLocation((String)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__NAME:
				setName((String)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PACKAGE:
				setPackage((String)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER_ID:
				setParameterId((String)newValue);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VERSION:
				setVersion((String)newValue);
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
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER:
				getParameter().clear();
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PORT:
				getPort().clear();
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__UNIT_BOUNDS:
				getUnitBounds().clear();
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID:
				setHashComponentUID(HASH_COMPONENT_UID_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCAL_REF:
				setLocalRef(LOCAL_REF_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER_ID:
				setParameterId(PARAMETER_ID_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PORT:
				return port != null && !port.isEmpty();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__UNIT_BOUNDS:
				return unitBounds != null && !unitBounds.isEmpty();
			case ComponentPackage.COMPONENT_IN_USE_TYPE__HASH_COMPONENT_UID:
				return HASH_COMPONENT_UID_EDEFAULT == null ? hashComponentUID != null : !HASH_COMPONENT_UID_EDEFAULT.equals(hashComponentUID);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCAL_REF:
				return LOCAL_REF_EDEFAULT == null ? localRef != null : !LOCAL_REF_EDEFAULT.equals(localRef);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__PARAMETER_ID:
				return PARAMETER_ID_EDEFAULT == null ? parameterId != null : !PARAMETER_ID_EDEFAULT.equals(parameterId);
			case ComponentPackage.COMPONENT_IN_USE_TYPE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
		result.append(" (hashComponentUID: ");
		result.append(hashComponentUID);
		result.append(", localRef: ");
		result.append(localRef);
		result.append(", location: ");
		result.append(location);
		result.append(", name: ");
		result.append(name);
		result.append(", package: ");
		result.append(package_);
		result.append(", parameterId: ");
		result.append(parameterId);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //ComponentInUseTypeImpl
