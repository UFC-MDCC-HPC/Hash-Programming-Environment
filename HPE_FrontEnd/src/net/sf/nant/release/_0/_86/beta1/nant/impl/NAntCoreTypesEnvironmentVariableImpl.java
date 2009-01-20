/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesEnvironmentVariable;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathSet;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NAnt Core Types Environment Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getPath <em>Path</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getDir <em>Dir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getFile <em>File</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getPath1 <em>Path1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesEnvironmentVariableImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTypesEnvironmentVariableImpl extends EObjectImpl implements NAntCoreTypesEnvironmentVariable {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getDir() <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDir()
	 * @generated
	 * @ordered
	 */
	protected static final Object DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDir() <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDir()
	 * @generated
	 * @ordered
	 */
	protected Object dir = DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected static final Object FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected Object file = FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIf() <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf()
	 * @generated
	 * @ordered
	 */
	protected static final Object IF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIf() <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIf()
	 * @generated
	 * @ordered
	 */
	protected Object if_ = IF_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Object name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath1() <em>Path1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath1()
	 * @generated
	 * @ordered
	 */
	protected static final Object PATH1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath1() <em>Path1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath1()
	 * @generated
	 * @ordered
	 */
	protected Object path1 = PATH1_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnless() <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnless()
	 * @generated
	 * @ordered
	 */
	protected static final Object UNLESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnless() <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnless()
	 * @generated
	 * @ordered
	 */
	protected Object unless = UNLESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NAntCoreTypesEnvironmentVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTypesEnvironmentVariable();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesPathSet> getPath() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesEnvironmentVariable_Path());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDir() {
		return dir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDir(Object newDir) {
		Object oldDir = dir;
		dir = newDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__DIR, oldDir, dir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(Object newFile) {
		Object oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIf() {
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIf(Object newIf) {
		Object oldIf = if_;
		if_ = newIf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Object newName) {
		Object oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPath1() {
		return path1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath1(Object newPath1) {
		Object oldPath1 = path1;
		path1 = newPath1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH1, oldPath1, path1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUnless() {
		return unless;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnless(Object newUnless) {
		Object oldUnless = unless;
		unless = newUnless;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH:
				return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH:
				return getPath();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__DIR:
				return getDir();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__FILE:
				return getFile();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__IF:
				return getIf();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__NAME:
				return getName();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH1:
				return getPath1();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__VALUE:
				return getValue();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends NAntCoreTypesPathSet>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__DIR:
				setDir(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__FILE:
				setFile(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__NAME:
				setName(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH1:
				setPath1(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__VALUE:
				setValue(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH:
				getPath().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__DIR:
				setDir(DIR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH1:
				setPath1(PATH1_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH:
				return !getPath().isEmpty();
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__DIR:
				return DIR_EDEFAULT == null ? dir != null : !DIR_EDEFAULT.equals(dir);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__PATH1:
				return PATH1_EDEFAULT == null ? path1 != null : !PATH1_EDEFAULT.equals(path1);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case NantPackage.NANT_CORE_TYPES_ENVIRONMENT_VARIABLE__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(" (group: ");
		result.append(group);
		result.append(", dir: ");
		result.append(dir);
		result.append(", file: ");
		result.append(file);
		result.append(", if: ");
		result.append(if_);
		result.append(", name: ");
		result.append(name);
		result.append(", path1: ");
		result.append(path1);
		result.append(", unless: ");
		result.append(unless);
		result.append(", value: ");
		result.append(value);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTypesEnvironmentVariableImpl
