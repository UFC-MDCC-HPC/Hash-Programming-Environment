/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.FusionType;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fusion Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.FusionTypeImpl#getPRef <em>PRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.FusionTypeImpl#getCRefs <em>CRefs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FusionTypeImpl extends MinimalEObjectImpl.Container implements FusionType {
	/**
	 * The default value of the '{@link #getPRef() <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPRef()
	 * @generated
	 * @ordered
	 */
	protected static final String PREF_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPRef() <em>PRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPRef()
	 * @generated
	 * @ordered
	 */
	protected String pRef = PREF_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCRefs() <em>CRefs</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<String> cRefs;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FusionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.FUSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCRefs() {
		if (cRefs == null) {
			cRefs = new EDataTypeEList<String>(String.class, this, ComponentPackage.FUSION_TYPE__CREFS);
		}
		return cRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPRef() {
		return pRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPRef(String newPRef) {
		String oldPRef = pRef;
		pRef = newPRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.FUSION_TYPE__PREF, oldPRef, pRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.FUSION_TYPE__PREF:
				return getPRef();
			case ComponentPackage.FUSION_TYPE__CREFS:
				return getCRefs();
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
			case ComponentPackage.FUSION_TYPE__PREF:
				setPRef((String)newValue);
				return;
			case ComponentPackage.FUSION_TYPE__CREFS:
				getCRefs().clear();
				getCRefs().addAll((Collection<? extends String>)newValue);
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
			case ComponentPackage.FUSION_TYPE__PREF:
				setPRef(PREF_EDEFAULT);
				return;
			case ComponentPackage.FUSION_TYPE__CREFS:
				getCRefs().clear();
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
			case ComponentPackage.FUSION_TYPE__PREF:
				return PREF_EDEFAULT == null ? pRef != null : !PREF_EDEFAULT.equals(pRef);
			case ComponentPackage.FUSION_TYPE__CREFS:
				return cRefs != null && !cRefs.isEmpty();
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
		result.append(" (pRef: ");
		result.append(pRef);
		result.append(", cRefs: ");
		result.append(cRefs);
		result.append(')');
		return result.toString();
	}

} //FusionTypeImpl
