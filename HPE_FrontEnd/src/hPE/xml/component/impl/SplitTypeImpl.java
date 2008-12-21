/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.SplitLinkType;
import hPE.xml.component.SplitType;

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
 * An implementation of the model object '<em><b>Split Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.SplitTypeImpl#getSplitLink <em>Split Link</em>}</li>
 *   <li>{@link hPE.xml.component.impl.SplitTypeImpl#getSplitEnumerator <em>Split Enumerator</em>}</li>
 *   <li>{@link hPE.xml.component.impl.SplitTypeImpl#getOriginRef <em>Origin Ref</em>}</li>
 *   <li>{@link hPE.xml.component.impl.SplitTypeImpl#getERef <em>ERef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.SplitTypeImpl#getN <em>N</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SplitTypeImpl extends EObjectImpl implements SplitType {
	/**
	 * The cached value of the '{@link #getSplitLink() <em>Split Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitLink()
	 * @generated
	 * @ordered
	 */
	protected EList<SplitLinkType> splitLink;

	/**
	 * The cached value of the '{@link #getSplitEnumerator() <em>Split Enumerator</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitEnumerator()
	 * @generated
	 * @ordered
	 */
	protected EList<String> splitEnumerator;

	/**
	 * The cached value of the '{@link #getOriginRef() <em>Origin Ref</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginRef()
	 * @generated
	 * @ordered
	 */
	protected EList<String> originRef;

	/**
	 * The default value of the '{@link #getERef() <em>ERef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getERef()
	 * @generated
	 * @ordered
	 */
	protected static final String EREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getERef() <em>ERef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getERef()
	 * @generated
	 * @ordered
	 */
	protected String eRef = EREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected static final int N_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected int n = N_EDEFAULT;

	/**
	 * This is true if the N attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SplitTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.SPLIT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SplitLinkType> getSplitLink() {
		if (splitLink == null) {
			splitLink = new EObjectContainmentEList<SplitLinkType>(SplitLinkType.class, this, ComponentPackage.SPLIT_TYPE__SPLIT_LINK);
		}
		return splitLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSplitEnumerator() {
		if (splitEnumerator == null) {
			splitEnumerator = new EDataTypeEList<String>(String.class, this, ComponentPackage.SPLIT_TYPE__SPLIT_ENUMERATOR);
		}
		return splitEnumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOriginRef() {
		if (originRef == null) {
			originRef = new EDataTypeEList<String>(String.class, this, ComponentPackage.SPLIT_TYPE__ORIGIN_REF);
		}
		return originRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getERef() {
		return eRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setERef(String newERef) {
		String oldERef = eRef;
		eRef = newERef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SPLIT_TYPE__EREF, oldERef, eRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getN() {
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN(int newN) {
		int oldN = n;
		n = newN;
		boolean oldNESet = nESet;
		nESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SPLIT_TYPE__N, oldN, n, !oldNESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetN() {
		int oldN = n;
		boolean oldNESet = nESet;
		n = N_EDEFAULT;
		nESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.SPLIT_TYPE__N, oldN, N_EDEFAULT, oldNESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetN() {
		return nESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.SPLIT_TYPE__SPLIT_LINK:
				return ((InternalEList<?>)getSplitLink()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.SPLIT_TYPE__SPLIT_LINK:
				return getSplitLink();
			case ComponentPackage.SPLIT_TYPE__SPLIT_ENUMERATOR:
				return getSplitEnumerator();
			case ComponentPackage.SPLIT_TYPE__ORIGIN_REF:
				return getOriginRef();
			case ComponentPackage.SPLIT_TYPE__EREF:
				return getERef();
			case ComponentPackage.SPLIT_TYPE__N:
				return new Integer(getN());
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
			case ComponentPackage.SPLIT_TYPE__SPLIT_LINK:
				getSplitLink().clear();
				getSplitLink().addAll((Collection<? extends SplitLinkType>)newValue);
				return;
			case ComponentPackage.SPLIT_TYPE__SPLIT_ENUMERATOR:
				getSplitEnumerator().clear();
				getSplitEnumerator().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.SPLIT_TYPE__ORIGIN_REF:
				getOriginRef().clear();
				getOriginRef().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.SPLIT_TYPE__EREF:
				setERef((String)newValue);
				return;
			case ComponentPackage.SPLIT_TYPE__N:
				setN(((Integer)newValue).intValue());
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
			case ComponentPackage.SPLIT_TYPE__SPLIT_LINK:
				getSplitLink().clear();
				return;
			case ComponentPackage.SPLIT_TYPE__SPLIT_ENUMERATOR:
				getSplitEnumerator().clear();
				return;
			case ComponentPackage.SPLIT_TYPE__ORIGIN_REF:
				getOriginRef().clear();
				return;
			case ComponentPackage.SPLIT_TYPE__EREF:
				setERef(EREF_EDEFAULT);
				return;
			case ComponentPackage.SPLIT_TYPE__N:
				unsetN();
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
			case ComponentPackage.SPLIT_TYPE__SPLIT_LINK:
				return splitLink != null && !splitLink.isEmpty();
			case ComponentPackage.SPLIT_TYPE__SPLIT_ENUMERATOR:
				return splitEnumerator != null && !splitEnumerator.isEmpty();
			case ComponentPackage.SPLIT_TYPE__ORIGIN_REF:
				return originRef != null && !originRef.isEmpty();
			case ComponentPackage.SPLIT_TYPE__EREF:
				return EREF_EDEFAULT == null ? eRef != null : !EREF_EDEFAULT.equals(eRef);
			case ComponentPackage.SPLIT_TYPE__N:
				return isSetN();
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
		result.append(" (splitEnumerator: ");
		result.append(splitEnumerator);
		result.append(", originRef: ");
		result.append(originRef);
		result.append(", eRef: ");
		result.append(eRef);
		result.append(", n: ");
		if (nESet) result.append(n); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //SplitTypeImpl
