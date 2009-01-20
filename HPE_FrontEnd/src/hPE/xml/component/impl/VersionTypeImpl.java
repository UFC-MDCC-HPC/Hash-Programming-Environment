/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.VersionType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.VersionTypeImpl#getField1 <em>Field1</em>}</li>
 *   <li>{@link hPE.xml.component.impl.VersionTypeImpl#getField2 <em>Field2</em>}</li>
 *   <li>{@link hPE.xml.component.impl.VersionTypeImpl#getField3 <em>Field3</em>}</li>
 *   <li>{@link hPE.xml.component.impl.VersionTypeImpl#getField4 <em>Field4</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VersionTypeImpl extends EObjectImpl implements VersionType {
	/**
	 * The default value of the '{@link #getField1() <em>Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField1()
	 * @generated
	 * @ordered
	 */
	protected static final int FIELD1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getField1() <em>Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField1()
	 * @generated
	 * @ordered
	 */
	protected int field1 = FIELD1_EDEFAULT;

	/**
	 * This is true if the Field1 attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean field1ESet;

	/**
	 * The default value of the '{@link #getField2() <em>Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField2()
	 * @generated
	 * @ordered
	 */
	protected static final int FIELD2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getField2() <em>Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField2()
	 * @generated
	 * @ordered
	 */
	protected int field2 = FIELD2_EDEFAULT;

	/**
	 * This is true if the Field2 attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean field2ESet;

	/**
	 * The default value of the '{@link #getField3() <em>Field3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField3()
	 * @generated
	 * @ordered
	 */
	protected static final int FIELD3_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getField3() <em>Field3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField3()
	 * @generated
	 * @ordered
	 */
	protected int field3 = FIELD3_EDEFAULT;

	/**
	 * This is true if the Field3 attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean field3ESet;

	/**
	 * The default value of the '{@link #getField4() <em>Field4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField4()
	 * @generated
	 * @ordered
	 */
	protected static final int FIELD4_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getField4() <em>Field4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField4()
	 * @generated
	 * @ordered
	 */
	protected int field4 = FIELD4_EDEFAULT;

	/**
	 * This is true if the Field4 attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean field4ESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.VERSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getField1() {
		return field1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField1(int newField1) {
		int oldField1 = field1;
		field1 = newField1;
		boolean oldField1ESet = field1ESet;
		field1ESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.VERSION_TYPE__FIELD1, oldField1, field1, !oldField1ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetField1() {
		int oldField1 = field1;
		boolean oldField1ESet = field1ESet;
		field1 = FIELD1_EDEFAULT;
		field1ESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.VERSION_TYPE__FIELD1, oldField1, FIELD1_EDEFAULT, oldField1ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetField1() {
		return field1ESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getField2() {
		return field2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField2(int newField2) {
		int oldField2 = field2;
		field2 = newField2;
		boolean oldField2ESet = field2ESet;
		field2ESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.VERSION_TYPE__FIELD2, oldField2, field2, !oldField2ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetField2() {
		int oldField2 = field2;
		boolean oldField2ESet = field2ESet;
		field2 = FIELD2_EDEFAULT;
		field2ESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.VERSION_TYPE__FIELD2, oldField2, FIELD2_EDEFAULT, oldField2ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetField2() {
		return field2ESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getField3() {
		return field3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField3(int newField3) {
		int oldField3 = field3;
		field3 = newField3;
		boolean oldField3ESet = field3ESet;
		field3ESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.VERSION_TYPE__FIELD3, oldField3, field3, !oldField3ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetField3() {
		int oldField3 = field3;
		boolean oldField3ESet = field3ESet;
		field3 = FIELD3_EDEFAULT;
		field3ESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.VERSION_TYPE__FIELD3, oldField3, FIELD3_EDEFAULT, oldField3ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetField3() {
		return field3ESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getField4() {
		return field4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField4(int newField4) {
		int oldField4 = field4;
		field4 = newField4;
		boolean oldField4ESet = field4ESet;
		field4ESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.VERSION_TYPE__FIELD4, oldField4, field4, !oldField4ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetField4() {
		int oldField4 = field4;
		boolean oldField4ESet = field4ESet;
		field4 = FIELD4_EDEFAULT;
		field4ESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.VERSION_TYPE__FIELD4, oldField4, FIELD4_EDEFAULT, oldField4ESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetField4() {
		return field4ESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.VERSION_TYPE__FIELD1:
				return new Integer(getField1());
			case ComponentPackage.VERSION_TYPE__FIELD2:
				return new Integer(getField2());
			case ComponentPackage.VERSION_TYPE__FIELD3:
				return new Integer(getField3());
			case ComponentPackage.VERSION_TYPE__FIELD4:
				return new Integer(getField4());
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
			case ComponentPackage.VERSION_TYPE__FIELD1:
				setField1(((Integer)newValue).intValue());
				return;
			case ComponentPackage.VERSION_TYPE__FIELD2:
				setField2(((Integer)newValue).intValue());
				return;
			case ComponentPackage.VERSION_TYPE__FIELD3:
				setField3(((Integer)newValue).intValue());
				return;
			case ComponentPackage.VERSION_TYPE__FIELD4:
				setField4(((Integer)newValue).intValue());
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
			case ComponentPackage.VERSION_TYPE__FIELD1:
				unsetField1();
				return;
			case ComponentPackage.VERSION_TYPE__FIELD2:
				unsetField2();
				return;
			case ComponentPackage.VERSION_TYPE__FIELD3:
				unsetField3();
				return;
			case ComponentPackage.VERSION_TYPE__FIELD4:
				unsetField4();
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
			case ComponentPackage.VERSION_TYPE__FIELD1:
				return isSetField1();
			case ComponentPackage.VERSION_TYPE__FIELD2:
				return isSetField2();
			case ComponentPackage.VERSION_TYPE__FIELD3:
				return isSetField3();
			case ComponentPackage.VERSION_TYPE__FIELD4:
				return isSetField4();
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
		result.append(" (field1: ");
		if (field1ESet) result.append(field1); else result.append("<unset>");
		result.append(", field2: ");
		if (field2ESet) result.append(field2); else result.append("<unset>");
		result.append(", field3: ");
		if (field3ESet) result.append(field3); else result.append("<unset>");
		result.append(", field4: ");
		if (field4ESet) result.append(field4); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //VersionTypeImpl
