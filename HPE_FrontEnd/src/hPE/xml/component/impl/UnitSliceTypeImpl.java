/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.UnitSliceType;
import hPE.xml.component.VisualElementAttributes;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Slice Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.UnitSliceTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitSliceTypeImpl#getPort <em>Port</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitSliceTypeImpl#getSliceName <em>Slice Name</em>}</li>
 *   <li>{@link hPE.xml.component.impl.UnitSliceTypeImpl#isTransitive <em>Transitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitSliceTypeImpl extends UnitRefTypeImpl implements UnitSliceType {
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
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected EList<String> port;

	/**
	 * The default value of the '{@link #getSliceName() <em>Slice Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SLICE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSliceName() <em>Slice Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceName()
	 * @generated
	 * @ordered
	 */
	protected String sliceName = SLICE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransitive() <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSITIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransitive() <em>Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransitive()
	 * @generated
	 * @ordered
	 */
	protected boolean transitive = TRANSITIVE_EDEFAULT;

	/**
	 * This is true if the Transitive attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean transitiveESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitSliceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.UNIT_SLICE_TYPE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
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
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPort() {
		if (port == null) {
			port = new EDataTypeEList<String>(String.class, this, ComponentPackage.UNIT_SLICE_TYPE__PORT);
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSliceName() {
		return sliceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSliceName(String newSliceName) {
		String oldSliceName = sliceName;
		sliceName = newSliceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_SLICE_TYPE__SLICE_NAME, oldSliceName, sliceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransitive() {
		return transitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitive(boolean newTransitive) {
		boolean oldTransitive = transitive;
		transitive = newTransitive;
		boolean oldTransitiveESet = transitiveESet;
		transitiveESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.UNIT_SLICE_TYPE__TRANSITIVE, oldTransitive, transitive, !oldTransitiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransitive() {
		boolean oldTransitive = transitive;
		boolean oldTransitiveESet = transitiveESet;
		transitive = TRANSITIVE_EDEFAULT;
		transitiveESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.UNIT_SLICE_TYPE__TRANSITIVE, oldTransitive, TRANSITIVE_EDEFAULT, oldTransitiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransitive() {
		return transitiveESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION:
				return basicSetVisualDescription(null, msgs);
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
			case ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.UNIT_SLICE_TYPE__PORT:
				return getPort();
			case ComponentPackage.UNIT_SLICE_TYPE__SLICE_NAME:
				return getSliceName();
			case ComponentPackage.UNIT_SLICE_TYPE__TRANSITIVE:
				return isTransitive();
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
			case ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.UNIT_SLICE_TYPE__PORT:
				getPort().clear();
				getPort().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.UNIT_SLICE_TYPE__SLICE_NAME:
				setSliceName((String)newValue);
				return;
			case ComponentPackage.UNIT_SLICE_TYPE__TRANSITIVE:
				setTransitive((Boolean)newValue);
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
			case ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.UNIT_SLICE_TYPE__PORT:
				getPort().clear();
				return;
			case ComponentPackage.UNIT_SLICE_TYPE__SLICE_NAME:
				setSliceName(SLICE_NAME_EDEFAULT);
				return;
			case ComponentPackage.UNIT_SLICE_TYPE__TRANSITIVE:
				unsetTransitive();
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
			case ComponentPackage.UNIT_SLICE_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.UNIT_SLICE_TYPE__PORT:
				return port != null && !port.isEmpty();
			case ComponentPackage.UNIT_SLICE_TYPE__SLICE_NAME:
				return SLICE_NAME_EDEFAULT == null ? sliceName != null : !SLICE_NAME_EDEFAULT.equals(sliceName);
			case ComponentPackage.UNIT_SLICE_TYPE__TRANSITIVE:
				return isSetTransitive();
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
		result.append(" (port: ");
		result.append(port);
		result.append(", sliceName: ");
		result.append(sliceName);
		result.append(", transitive: ");
		if (transitiveESet) result.append(transitive); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //UnitSliceTypeImpl
