/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fusion Of Replicators Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionOfReplicatorsTypeImpl#getERef <em>ERef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.FusionOfReplicatorsTypeImpl#getOriginRef <em>Origin Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FusionOfReplicatorsTypeImpl extends EObjectImpl implements FusionOfReplicatorsType {
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
	 * The cached value of the '{@link #getOriginRef() <em>Origin Ref</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginRef()
	 * @generated
	 * @ordered
	 */
	protected EList<String> originRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FusionOfReplicatorsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.FUSION_OF_REPLICATORS_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.FUSION_OF_REPLICATORS_TYPE__EREF, oldERef, eRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOriginRef() {
		if (originRef == null) {
			originRef = new EDataTypeEList<String>(String.class, this, ComponentPackage.FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF);
		}
		return originRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__EREF:
				return getERef();
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF:
				return getOriginRef();
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
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__EREF:
				setERef((String)newValue);
				return;
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF:
				getOriginRef().clear();
				getOriginRef().addAll((Collection<? extends String>)newValue);
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
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__EREF:
				setERef(EREF_EDEFAULT);
				return;
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF:
				getOriginRef().clear();
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
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__EREF:
				return EREF_EDEFAULT == null ? eRef != null : !EREF_EDEFAULT.equals(eRef);
			case ComponentPackage.FUSION_OF_REPLICATORS_TYPE__ORIGIN_REF:
				return originRef != null && !originRef.isEmpty();
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
		result.append(" (eRef: ");
		result.append(eRef);
		result.append(", originRef: ");
		result.append(originRef);
		result.append(')');
		return result.toString();
	}

} //FusionOfReplicatorsTypeImpl
