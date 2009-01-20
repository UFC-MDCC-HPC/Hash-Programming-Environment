/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import net.sf.nant.release._0._86.beta1.nant.NAntNUnitTypesFormatterElement;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NAnt NUnit Types Formatter Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnitTypesFormatterElementImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnitTypesFormatterElementImpl#getOutputdir <em>Outputdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnitTypesFormatterElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnitTypesFormatterElementImpl#getUsefile <em>Usefile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnitTypesFormatterElementImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntNUnitTypesFormatterElementImpl extends EObjectImpl implements NAntNUnitTypesFormatterElement {
	/**
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected static final Object EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected Object extension = EXTENSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputdir() <em>Outputdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputdir()
	 * @generated
	 * @ordered
	 */
	protected static final Object OUTPUTDIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputdir() <em>Outputdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputdir()
	 * @generated
	 * @ordered
	 */
	protected Object outputdir = OUTPUTDIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final Object TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Object type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsefile() <em>Usefile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsefile()
	 * @generated
	 * @ordered
	 */
	protected static final Object USEFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsefile() <em>Usefile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsefile()
	 * @generated
	 * @ordered
	 */
	protected Object usefile = USEFILE_EDEFAULT;

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
	protected NAntNUnitTypesFormatterElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntNUnitTypesFormatterElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(Object newExtension) {
		Object oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOutputdir() {
		return outputdir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputdir(Object newOutputdir) {
		Object oldOutputdir = outputdir;
		outputdir = newOutputdir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__OUTPUTDIR, oldOutputdir, outputdir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Object newType) {
		Object oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUsefile() {
		return usefile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsefile(Object newUsefile) {
		Object oldUsefile = usefile;
		usefile = newUsefile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__USEFILE, oldUsefile, usefile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__EXTENSION:
				return getExtension();
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__OUTPUTDIR:
				return getOutputdir();
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__TYPE:
				return getType();
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__USEFILE:
				return getUsefile();
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__ANY_ATTRIBUTE:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__EXTENSION:
				setExtension(newValue);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__OUTPUTDIR:
				setOutputdir(newValue);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__TYPE:
				setType(newValue);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__USEFILE:
				setUsefile(newValue);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__OUTPUTDIR:
				setOutputdir(OUTPUTDIR_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__USEFILE:
				setUsefile(USEFILE_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__OUTPUTDIR:
				return OUTPUTDIR_EDEFAULT == null ? outputdir != null : !OUTPUTDIR_EDEFAULT.equals(outputdir);
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__USEFILE:
				return USEFILE_EDEFAULT == null ? usefile != null : !USEFILE_EDEFAULT.equals(usefile);
			case NantPackage.NANT_NUNIT_TYPES_FORMATTER_ELEMENT__ANY_ATTRIBUTE:
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
		result.append(" (extension: ");
		result.append(extension);
		result.append(", outputdir: ");
		result.append(outputdir);
		result.append(", type: ");
		result.append(type);
		result.append(", usefile: ");
		result.append(usefile);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntNUnitTypesFormatterElementImpl
