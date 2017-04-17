/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.InnerRenamingType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inner Renaming Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.InnerRenamingTypeImpl#getCNewName <em>CNew Name</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InnerRenamingTypeImpl#getCOldName <em>COld Name</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InnerRenamingTypeImpl#getCRef <em>CRef</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InnerRenamingTypeImpl#getIndexReplica <em>Index Replica</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InnerRenamingTypeImpl extends MinimalEObjectImpl.Container implements InnerRenamingType {
	/**
	 * The default value of the '{@link #getCNewName() <em>CNew Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCNewName()
	 * @generated
	 * @ordered
	 */
	protected static final String CNEW_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCNewName() <em>CNew Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCNewName()
	 * @generated
	 * @ordered
	 */
	protected String cNewName = CNEW_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCOldName() <em>COld Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCOldName()
	 * @generated
	 * @ordered
	 */
	protected static final String COLD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCOldName() <em>COld Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCOldName()
	 * @generated
	 * @ordered
	 */
	protected String cOldName = COLD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCRef() <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRef()
	 * @generated
	 * @ordered
	 */
	protected static final String CREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCRef() <em>CRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCRef()
	 * @generated
	 * @ordered
	 */
	protected String cRef = CREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexReplica() <em>Index Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexReplica()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_REPLICA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndexReplica() <em>Index Replica</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexReplica()
	 * @generated
	 * @ordered
	 */
	protected int indexReplica = INDEX_REPLICA_EDEFAULT;

	/**
	 * This is true if the Index Replica attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indexReplicaESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InnerRenamingTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.INNER_RENAMING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCRef() {
		return cRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCRef(String newCRef) {
		String oldCRef = cRef;
		cRef = newCRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INNER_RENAMING_TYPE__CREF, oldCRef, cRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndexReplica() {
		return indexReplica;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexReplica(int newIndexReplica) {
		int oldIndexReplica = indexReplica;
		indexReplica = newIndexReplica;
		boolean oldIndexReplicaESet = indexReplicaESet;
		indexReplicaESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INNER_RENAMING_TYPE__INDEX_REPLICA, oldIndexReplica, indexReplica, !oldIndexReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndexReplica() {
		int oldIndexReplica = indexReplica;
		boolean oldIndexReplicaESet = indexReplicaESet;
		indexReplica = INDEX_REPLICA_EDEFAULT;
		indexReplicaESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.INNER_RENAMING_TYPE__INDEX_REPLICA, oldIndexReplica, INDEX_REPLICA_EDEFAULT, oldIndexReplicaESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndexReplica() {
		return indexReplicaESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCOldName() {
		return cOldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCOldName(String newCOldName) {
		String oldCOldName = cOldName;
		cOldName = newCOldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INNER_RENAMING_TYPE__COLD_NAME, oldCOldName, cOldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCNewName() {
		return cNewName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCNewName(String newCNewName) {
		String oldCNewName = cNewName;
		cNewName = newCNewName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INNER_RENAMING_TYPE__CNEW_NAME, oldCNewName, cNewName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.INNER_RENAMING_TYPE__CNEW_NAME:
				return getCNewName();
			case ComponentPackage.INNER_RENAMING_TYPE__COLD_NAME:
				return getCOldName();
			case ComponentPackage.INNER_RENAMING_TYPE__CREF:
				return getCRef();
			case ComponentPackage.INNER_RENAMING_TYPE__INDEX_REPLICA:
				return getIndexReplica();
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
			case ComponentPackage.INNER_RENAMING_TYPE__CNEW_NAME:
				setCNewName((String)newValue);
				return;
			case ComponentPackage.INNER_RENAMING_TYPE__COLD_NAME:
				setCOldName((String)newValue);
				return;
			case ComponentPackage.INNER_RENAMING_TYPE__CREF:
				setCRef((String)newValue);
				return;
			case ComponentPackage.INNER_RENAMING_TYPE__INDEX_REPLICA:
				setIndexReplica((Integer)newValue);
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
			case ComponentPackage.INNER_RENAMING_TYPE__CNEW_NAME:
				setCNewName(CNEW_NAME_EDEFAULT);
				return;
			case ComponentPackage.INNER_RENAMING_TYPE__COLD_NAME:
				setCOldName(COLD_NAME_EDEFAULT);
				return;
			case ComponentPackage.INNER_RENAMING_TYPE__CREF:
				setCRef(CREF_EDEFAULT);
				return;
			case ComponentPackage.INNER_RENAMING_TYPE__INDEX_REPLICA:
				unsetIndexReplica();
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
			case ComponentPackage.INNER_RENAMING_TYPE__CNEW_NAME:
				return CNEW_NAME_EDEFAULT == null ? cNewName != null : !CNEW_NAME_EDEFAULT.equals(cNewName);
			case ComponentPackage.INNER_RENAMING_TYPE__COLD_NAME:
				return COLD_NAME_EDEFAULT == null ? cOldName != null : !COLD_NAME_EDEFAULT.equals(cOldName);
			case ComponentPackage.INNER_RENAMING_TYPE__CREF:
				return CREF_EDEFAULT == null ? cRef != null : !CREF_EDEFAULT.equals(cRef);
			case ComponentPackage.INNER_RENAMING_TYPE__INDEX_REPLICA:
				return isSetIndexReplica();
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
		result.append(" (cNewName: ");
		result.append(cNewName);
		result.append(", cOldName: ");
		result.append(cOldName);
		result.append(", cRef: ");
		result.append(cRef);
		result.append(", indexReplica: ");
		if (indexReplicaESet) result.append(indexReplica); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //InnerRenamingTypeImpl
