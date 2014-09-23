/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.InterfaceParameterType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.InterfaceParameterTypeImpl#getIname <em>Iname</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InterfaceParameterTypeImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InterfaceParameterTypeImpl#getParid <em>Parid</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InterfaceParameterTypeImpl#getUname <em>Uname</em>}</li>
 *   <li>{@link hPE.xml.component.impl.InterfaceParameterTypeImpl#getVarid <em>Varid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceParameterTypeImpl extends MinimalEObjectImpl.Container implements InterfaceParameterType {
	/**
	 * The default value of the '{@link #getIname() <em>Iname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIname()
	 * @generated
	 * @ordered
	 */
	protected static final String INAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIname() <em>Iname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIname()
	 * @generated
	 * @ordered
	 */
	protected String iname = INAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * This is true if the Order attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean orderESet;

	/**
	 * The default value of the '{@link #getParid() <em>Parid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParid()
	 * @generated
	 * @ordered
	 */
	protected static final String PARID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParid() <em>Parid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParid()
	 * @generated
	 * @ordered
	 */
	protected String parid = PARID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUname() <em>Uname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUname()
	 * @generated
	 * @ordered
	 */
	protected static final String UNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUname() <em>Uname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUname()
	 * @generated
	 * @ordered
	 */
	protected String uname = UNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarid() <em>Varid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarid()
	 * @generated
	 * @ordered
	 */
	protected static final String VARID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVarid() <em>Varid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarid()
	 * @generated
	 * @ordered
	 */
	protected String varid = VARID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceParameterTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.INTERFACE_PARAMETER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIname() {
		return iname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIname(String newIname) {
		String oldIname = iname;
		iname = newIname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_PARAMETER_TYPE__INAME, oldIname, iname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		boolean oldOrderESet = orderESet;
		orderESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_PARAMETER_TYPE__ORDER, oldOrder, order, !oldOrderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOrder() {
		int oldOrder = order;
		boolean oldOrderESet = orderESet;
		order = ORDER_EDEFAULT;
		orderESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.INTERFACE_PARAMETER_TYPE__ORDER, oldOrder, ORDER_EDEFAULT, oldOrderESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOrder() {
		return orderESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParid() {
		return parid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParid(String newParid) {
		String oldParid = parid;
		parid = newParid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_PARAMETER_TYPE__PARID, oldParid, parid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUname(String newUname) {
		String oldUname = uname;
		uname = newUname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_PARAMETER_TYPE__UNAME, oldUname, uname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVarid() {
		return varid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarid(String newVarid) {
		String oldVarid = varid;
		varid = newVarid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_PARAMETER_TYPE__VARID, oldVarid, varid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__INAME:
				return getIname();
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__ORDER:
				return getOrder();
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__PARID:
				return getParid();
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__UNAME:
				return getUname();
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__VARID:
				return getVarid();
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
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__INAME:
				setIname((String)newValue);
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__ORDER:
				setOrder((Integer)newValue);
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__PARID:
				setParid((String)newValue);
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__UNAME:
				setUname((String)newValue);
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__VARID:
				setVarid((String)newValue);
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
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__INAME:
				setIname(INAME_EDEFAULT);
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__ORDER:
				unsetOrder();
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__PARID:
				setParid(PARID_EDEFAULT);
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__UNAME:
				setUname(UNAME_EDEFAULT);
				return;
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__VARID:
				setVarid(VARID_EDEFAULT);
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
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__INAME:
				return INAME_EDEFAULT == null ? iname != null : !INAME_EDEFAULT.equals(iname);
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__ORDER:
				return isSetOrder();
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__PARID:
				return PARID_EDEFAULT == null ? parid != null : !PARID_EDEFAULT.equals(parid);
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__UNAME:
				return UNAME_EDEFAULT == null ? uname != null : !UNAME_EDEFAULT.equals(uname);
			case ComponentPackage.INTERFACE_PARAMETER_TYPE__VARID:
				return VARID_EDEFAULT == null ? varid != null : !VARID_EDEFAULT.equals(varid);
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
		result.append(" (iname: ");
		result.append(iname);
		result.append(", order: ");
		if (orderESet) result.append(order); else result.append("<unset>");
		result.append(", parid: ");
		result.append(parid);
		result.append(", uname: ");
		result.append(uname);
		result.append(", varid: ");
		result.append(varid);
		result.append(')');
		return result.toString();
	}

} //InterfaceParameterTypeImpl
