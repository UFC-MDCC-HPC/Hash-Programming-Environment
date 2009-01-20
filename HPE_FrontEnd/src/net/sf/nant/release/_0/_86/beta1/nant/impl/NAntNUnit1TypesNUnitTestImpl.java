/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TypesNUnitTest;
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
 * An implementation of the model object '<em><b>NAnt NUnit1 Types NUnit Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getAppconfig <em>Appconfig</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getAssembly <em>Assembly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getFork <em>Fork</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getHaltonerror <em>Haltonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getHaltonfailure <em>Haltonfailure</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getOutfile <em>Outfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getTodir <em>Todir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit1TypesNUnitTestImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntNUnit1TypesNUnitTestImpl extends EObjectImpl implements NAntNUnit1TypesNUnitTest {
	/**
	 * The default value of the '{@link #getAppconfig() <em>Appconfig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppconfig()
	 * @generated
	 * @ordered
	 */
	protected static final Object APPCONFIG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAppconfig() <em>Appconfig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppconfig()
	 * @generated
	 * @ordered
	 */
	protected Object appconfig = APPCONFIG_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssembly() <em>Assembly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssembly()
	 * @generated
	 * @ordered
	 */
	protected static final Object ASSEMBLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssembly() <em>Assembly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssembly()
	 * @generated
	 * @ordered
	 */
	protected Object assembly = ASSEMBLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final Object CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected Object class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFork() <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFork()
	 * @generated
	 * @ordered
	 */
	protected static final Object FORK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFork() <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFork()
	 * @generated
	 * @ordered
	 */
	protected Object fork = FORK_EDEFAULT;

	/**
	 * The default value of the '{@link #getHaltonerror() <em>Haltonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHaltonerror()
	 * @generated
	 * @ordered
	 */
	protected static final Object HALTONERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHaltonerror() <em>Haltonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHaltonerror()
	 * @generated
	 * @ordered
	 */
	protected Object haltonerror = HALTONERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getHaltonfailure() <em>Haltonfailure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHaltonfailure()
	 * @generated
	 * @ordered
	 */
	protected static final Object HALTONFAILURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHaltonfailure() <em>Haltonfailure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHaltonfailure()
	 * @generated
	 * @ordered
	 */
	protected Object haltonfailure = HALTONFAILURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutfile() <em>Outfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object OUTFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutfile() <em>Outfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutfile()
	 * @generated
	 * @ordered
	 */
	protected Object outfile = OUTFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTodir() <em>Todir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTodir()
	 * @generated
	 * @ordered
	 */
	protected static final Object TODIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTodir() <em>Todir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTodir()
	 * @generated
	 * @ordered
	 */
	protected Object todir = TODIR_EDEFAULT;

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
	protected NAntNUnit1TypesNUnitTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntNUnit1TypesNUnitTest();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAppconfig() {
		return appconfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppconfig(Object newAppconfig) {
		Object oldAppconfig = appconfig;
		appconfig = newAppconfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__APPCONFIG, oldAppconfig, appconfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAssembly() {
		return assembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssembly(Object newAssembly) {
		Object oldAssembly = assembly;
		assembly = newAssembly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ASSEMBLY, oldAssembly, assembly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(Object newClass) {
		Object oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFork() {
		return fork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFork(Object newFork) {
		Object oldFork = fork;
		fork = newFork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__FORK, oldFork, fork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHaltonerror() {
		return haltonerror;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHaltonerror(Object newHaltonerror) {
		Object oldHaltonerror = haltonerror;
		haltonerror = newHaltonerror;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONERROR, oldHaltonerror, haltonerror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHaltonfailure() {
		return haltonfailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHaltonfailure(Object newHaltonfailure) {
		Object oldHaltonfailure = haltonfailure;
		haltonfailure = newHaltonfailure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONFAILURE, oldHaltonfailure, haltonfailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOutfile() {
		return outfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutfile(Object newOutfile) {
		Object oldOutfile = outfile;
		outfile = newOutfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__OUTFILE, oldOutfile, outfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTodir() {
		return todir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTodir(Object newTodir) {
		Object oldTodir = todir;
		todir = newTodir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__TODIR, oldTodir, todir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__APPCONFIG:
				return getAppconfig();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ASSEMBLY:
				return getAssembly();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__CLASS:
				return getClass_();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__FORK:
				return getFork();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONERROR:
				return getHaltonerror();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONFAILURE:
				return getHaltonfailure();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__OUTFILE:
				return getOutfile();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__TODIR:
				return getTodir();
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__APPCONFIG:
				setAppconfig(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ASSEMBLY:
				setAssembly(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__CLASS:
				setClass(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__FORK:
				setFork(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONERROR:
				setHaltonerror(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONFAILURE:
				setHaltonfailure(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__OUTFILE:
				setOutfile(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__TODIR:
				setTodir(newValue);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__APPCONFIG:
				setAppconfig(APPCONFIG_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ASSEMBLY:
				setAssembly(ASSEMBLY_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__FORK:
				setFork(FORK_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONERROR:
				setHaltonerror(HALTONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONFAILURE:
				setHaltonfailure(HALTONFAILURE_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__OUTFILE:
				setOutfile(OUTFILE_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__TODIR:
				setTodir(TODIR_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__APPCONFIG:
				return APPCONFIG_EDEFAULT == null ? appconfig != null : !APPCONFIG_EDEFAULT.equals(appconfig);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ASSEMBLY:
				return ASSEMBLY_EDEFAULT == null ? assembly != null : !ASSEMBLY_EDEFAULT.equals(assembly);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__FORK:
				return FORK_EDEFAULT == null ? fork != null : !FORK_EDEFAULT.equals(fork);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONERROR:
				return HALTONERROR_EDEFAULT == null ? haltonerror != null : !HALTONERROR_EDEFAULT.equals(haltonerror);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__HALTONFAILURE:
				return HALTONFAILURE_EDEFAULT == null ? haltonfailure != null : !HALTONFAILURE_EDEFAULT.equals(haltonfailure);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__OUTFILE:
				return OUTFILE_EDEFAULT == null ? outfile != null : !OUTFILE_EDEFAULT.equals(outfile);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__TODIR:
				return TODIR_EDEFAULT == null ? todir != null : !TODIR_EDEFAULT.equals(todir);
			case NantPackage.NANT_NUNIT1_TYPES_NUNIT_TEST__ANY_ATTRIBUTE:
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
		result.append(" (appconfig: ");
		result.append(appconfig);
		result.append(", assembly: ");
		result.append(assembly);
		result.append(", class: ");
		result.append(class_);
		result.append(", fork: ");
		result.append(fork);
		result.append(", haltonerror: ");
		result.append(haltonerror);
		result.append(", haltonfailure: ");
		result.append(haltonfailure);
		result.append(", outfile: ");
		result.append(outfile);
		result.append(", todir: ");
		result.append(todir);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntNUnit1TypesNUnitTestImpl
