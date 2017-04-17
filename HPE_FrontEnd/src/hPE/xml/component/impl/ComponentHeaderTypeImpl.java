/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.BaseTypeType;
import hPE.xml.component.ComponentHeaderType;
import hPE.xml.component.ComponentPackage;
import hPE.xml.component.FacetConfigurationType;
import hPE.xml.component.SupportedKinds;
import hPE.xml.component.VersionType;
import hPE.xml.component.VisualElementAttributes;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Header Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getVersions <em>Versions</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getVisualAttributes <em>Visual Attributes</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getFacetConfiguration <em>Facet Configuration</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getHashComponentUID <em>Hash Component UID</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getLocationURI <em>Location URI</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ComponentHeaderTypeImpl#getPackagePath <em>Package Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentHeaderTypeImpl extends MinimalEObjectImpl.Container implements ComponentHeaderType {
	/**
	 * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseType()
	 * @generated
	 * @ordered
	 */
	protected BaseTypeType baseType;

	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<VersionType> versions;

	/**
	 * The cached value of the '{@link #getVisualAttributes() <em>Visual Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualAttributes()
	 * @generated
	 * @ordered
	 */
	protected VisualElementAttributes visualAttributes;

	/**
	 * The cached value of the '{@link #getFacetConfiguration() <em>Facet Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<FacetConfigurationType> facetConfiguration;

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
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * This is true if the Is Abstract attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstractESet;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final SupportedKinds KIND_EDEFAULT = SupportedKinds.DATA;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected SupportedKinds kind = KIND_EDEFAULT;

	/**
	 * This is true if the Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kindESet;

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
	 * The default value of the '{@link #getPackagePath() <em>Package Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePath()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackagePath() <em>Package Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePath()
	 * @generated
	 * @ordered
	 */
	protected String packagePath = PACKAGE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentHeaderTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.COMPONENT_HEADER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseTypeType getBaseType() {
		return baseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseType(BaseTypeType newBaseType, NotificationChain msgs) {
		BaseTypeType oldBaseType = baseType;
		baseType = newBaseType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE, oldBaseType, newBaseType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseType(BaseTypeType newBaseType) {
		if (newBaseType != baseType) {
			NotificationChain msgs = null;
			if (baseType != null)
				msgs = ((InternalEObject)baseType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE, null, msgs);
			if (newBaseType != null)
				msgs = ((InternalEObject)newBaseType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE, null, msgs);
			msgs = basicSetBaseType(newBaseType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE, newBaseType, newBaseType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VersionType> getVersions() {
		if (versions == null) {
			versions = new EObjectContainmentEList<VersionType>(VersionType.class, this, ComponentPackage.COMPONENT_HEADER_TYPE__VERSIONS);
		}
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualElementAttributes getVisualAttributes() {
		return visualAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisualAttributes(VisualElementAttributes newVisualAttributes, NotificationChain msgs) {
		VisualElementAttributes oldVisualAttributes = visualAttributes;
		visualAttributes = newVisualAttributes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES, oldVisualAttributes, newVisualAttributes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualAttributes(VisualElementAttributes newVisualAttributes) {
		if (newVisualAttributes != visualAttributes) {
			NotificationChain msgs = null;
			if (visualAttributes != null)
				msgs = ((InternalEObject)visualAttributes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES, null, msgs);
			if (newVisualAttributes != null)
				msgs = ((InternalEObject)newVisualAttributes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES, null, msgs);
			msgs = basicSetVisualAttributes(newVisualAttributes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES, newVisualAttributes, newVisualAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FacetConfigurationType> getFacetConfiguration() {
		if (facetConfiguration == null) {
			facetConfiguration = new EObjectContainmentEList<FacetConfigurationType>(FacetConfigurationType.class, this, ComponentPackage.COMPONENT_HEADER_TYPE__FACET_CONFIGURATION);
		}
		return facetConfiguration;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID, oldHashComponentUID, hashComponentUID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		boolean oldIsAbstractESet = isAbstractESet;
		isAbstractESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__IS_ABSTRACT, oldIsAbstract, isAbstract, !oldIsAbstractESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsAbstract() {
		boolean oldIsAbstract = isAbstract;
		boolean oldIsAbstractESet = isAbstractESet;
		isAbstract = IS_ABSTRACT_EDEFAULT;
		isAbstractESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.COMPONENT_HEADER_TYPE__IS_ABSTRACT, oldIsAbstract, IS_ABSTRACT_EDEFAULT, oldIsAbstractESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsAbstract() {
		return isAbstractESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedKinds getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(SupportedKinds newKind) {
		SupportedKinds oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		boolean oldKindESet = kindESet;
		kindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__KIND, oldKind, kind, !oldKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKind() {
		SupportedKinds oldKind = kind;
		boolean oldKindESet = kindESet;
		kind = KIND_EDEFAULT;
		kindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.COMPONENT_HEADER_TYPE__KIND, oldKind, KIND_EDEFAULT, oldKindESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__LOCATION_URI, oldLocationURI, locationURI));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackagePath() {
		return packagePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackagePath(String newPackagePath) {
		String oldPackagePath = packagePath;
		packagePath = newPackagePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.COMPONENT_HEADER_TYPE__PACKAGE_PATH, oldPackagePath, packagePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE:
				return basicSetBaseType(null, msgs);
			case ComponentPackage.COMPONENT_HEADER_TYPE__VERSIONS:
				return ((InternalEList<?>)getVersions()).basicRemove(otherEnd, msgs);
			case ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES:
				return basicSetVisualAttributes(null, msgs);
			case ComponentPackage.COMPONENT_HEADER_TYPE__FACET_CONFIGURATION:
				return ((InternalEList<?>)getFacetConfiguration()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE:
				return getBaseType();
			case ComponentPackage.COMPONENT_HEADER_TYPE__VERSIONS:
				return getVersions();
			case ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES:
				return getVisualAttributes();
			case ComponentPackage.COMPONENT_HEADER_TYPE__FACET_CONFIGURATION:
				return getFacetConfiguration();
			case ComponentPackage.COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID:
				return getHashComponentUID();
			case ComponentPackage.COMPONENT_HEADER_TYPE__IS_ABSTRACT:
				return isIsAbstract();
			case ComponentPackage.COMPONENT_HEADER_TYPE__KIND:
				return getKind();
			case ComponentPackage.COMPONENT_HEADER_TYPE__LOCATION_URI:
				return getLocationURI();
			case ComponentPackage.COMPONENT_HEADER_TYPE__NAME:
				return getName();
			case ComponentPackage.COMPONENT_HEADER_TYPE__PACKAGE_PATH:
				return getPackagePath();
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
			case ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE:
				setBaseType((BaseTypeType)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__VERSIONS:
				getVersions().clear();
				getVersions().addAll((Collection<? extends VersionType>)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES:
				setVisualAttributes((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__FACET_CONFIGURATION:
				getFacetConfiguration().clear();
				getFacetConfiguration().addAll((Collection<? extends FacetConfigurationType>)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID:
				setHashComponentUID((String)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__KIND:
				setKind((SupportedKinds)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__LOCATION_URI:
				setLocationURI((String)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__NAME:
				setName((String)newValue);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__PACKAGE_PATH:
				setPackagePath((String)newValue);
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
			case ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE:
				setBaseType((BaseTypeType)null);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__VERSIONS:
				getVersions().clear();
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES:
				setVisualAttributes((VisualElementAttributes)null);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__FACET_CONFIGURATION:
				getFacetConfiguration().clear();
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID:
				setHashComponentUID(HASH_COMPONENT_UID_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__IS_ABSTRACT:
				unsetIsAbstract();
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__KIND:
				unsetKind();
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__LOCATION_URI:
				setLocationURI(LOCATION_URI_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentPackage.COMPONENT_HEADER_TYPE__PACKAGE_PATH:
				setPackagePath(PACKAGE_PATH_EDEFAULT);
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
			case ComponentPackage.COMPONENT_HEADER_TYPE__BASE_TYPE:
				return baseType != null;
			case ComponentPackage.COMPONENT_HEADER_TYPE__VERSIONS:
				return versions != null && !versions.isEmpty();
			case ComponentPackage.COMPONENT_HEADER_TYPE__VISUAL_ATTRIBUTES:
				return visualAttributes != null;
			case ComponentPackage.COMPONENT_HEADER_TYPE__FACET_CONFIGURATION:
				return facetConfiguration != null && !facetConfiguration.isEmpty();
			case ComponentPackage.COMPONENT_HEADER_TYPE__HASH_COMPONENT_UID:
				return HASH_COMPONENT_UID_EDEFAULT == null ? hashComponentUID != null : !HASH_COMPONENT_UID_EDEFAULT.equals(hashComponentUID);
			case ComponentPackage.COMPONENT_HEADER_TYPE__IS_ABSTRACT:
				return isSetIsAbstract();
			case ComponentPackage.COMPONENT_HEADER_TYPE__KIND:
				return isSetKind();
			case ComponentPackage.COMPONENT_HEADER_TYPE__LOCATION_URI:
				return LOCATION_URI_EDEFAULT == null ? locationURI != null : !LOCATION_URI_EDEFAULT.equals(locationURI);
			case ComponentPackage.COMPONENT_HEADER_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentPackage.COMPONENT_HEADER_TYPE__PACKAGE_PATH:
				return PACKAGE_PATH_EDEFAULT == null ? packagePath != null : !PACKAGE_PATH_EDEFAULT.equals(packagePath);
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
		result.append(", isAbstract: ");
		if (isAbstractESet) result.append(isAbstract); else result.append("<unset>");
		result.append(", kind: ");
		if (kindESet) result.append(kind); else result.append("<unset>");
		result.append(", locationURI: ");
		result.append(locationURI);
		result.append(", name: ");
		result.append(name);
		result.append(", packagePath: ");
		result.append(packagePath);
		result.append(')');
		return result.toString();
	}

} //ComponentHeaderTypeImpl
