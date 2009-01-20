/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategories;
import net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test;
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
 * An implementation of the model object '<em><b>NAnt NUnit2 Types NUnit2 Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getAppconfig <em>Appconfig</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getAssemblyname <em>Assemblyname</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getHaltonfailure <em>Haltonfailure</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getTestname <em>Testname</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getTransformfile <em>Transformfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntNUnit2TypesNUnit2TestImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntNUnit2TypesNUnit2TestImpl extends EObjectImpl implements NAntNUnit2TypesNUnit2Test {
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
	 * The default value of the '{@link #getAssemblyname() <em>Assemblyname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyname()
	 * @generated
	 * @ordered
	 */
	protected static final Object ASSEMBLYNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssemblyname() <em>Assemblyname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyname()
	 * @generated
	 * @ordered
	 */
	protected Object assemblyname = ASSEMBLYNAME_EDEFAULT;

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
	 * The default value of the '{@link #getTestname() <em>Testname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestname()
	 * @generated
	 * @ordered
	 */
	protected static final Object TESTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestname() <em>Testname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestname()
	 * @generated
	 * @ordered
	 */
	protected Object testname = TESTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransformfile() <em>Transformfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object TRANSFORMFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransformfile() <em>Transformfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformfile()
	 * @generated
	 * @ordered
	 */
	protected Object transformfile = TRANSFORMFILE_EDEFAULT;

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
	protected NAntNUnit2TypesNUnit2TestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntNUnit2TypesNUnit2Test();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getAssemblies() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntNUnit2TypesNUnit2Test_Assemblies());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntNUnit2TypesCategories> getCategories() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntNUnit2TypesNUnit2Test_Categories());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__APPCONFIG, oldAppconfig, appconfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAssemblyname() {
		return assemblyname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyname(Object newAssemblyname) {
		Object oldAssemblyname = assemblyname;
		assemblyname = newAssemblyname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLYNAME, oldAssemblyname, assemblyname));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__HALTONFAILURE, oldHaltonfailure, haltonfailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTestname() {
		return testname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestname(Object newTestname) {
		Object oldTestname = testname;
		testname = newTestname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TESTNAME, oldTestname, testname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTransformfile() {
		return transformfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformfile(Object newTransformfile) {
		Object oldTransformfile = transformfile;
		transformfile = newTransformfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TRANSFORMFILE, oldTransformfile, transformfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLIES:
				return ((InternalEList<?>)getAssemblies()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLIES:
				return getAssemblies();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__CATEGORIES:
				return getCategories();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__APPCONFIG:
				return getAppconfig();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLYNAME:
				return getAssemblyname();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__HALTONFAILURE:
				return getHaltonfailure();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TESTNAME:
				return getTestname();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TRANSFORMFILE:
				return getTransformfile();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLIES:
				getAssemblies().clear();
				getAssemblies().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends NAntNUnit2TypesCategories>)newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__APPCONFIG:
				setAppconfig(newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLYNAME:
				setAssemblyname(newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__HALTONFAILURE:
				setHaltonfailure(newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TESTNAME:
				setTestname(newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TRANSFORMFILE:
				setTransformfile(newValue);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLIES:
				getAssemblies().clear();
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__CATEGORIES:
				getCategories().clear();
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__APPCONFIG:
				setAppconfig(APPCONFIG_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLYNAME:
				setAssemblyname(ASSEMBLYNAME_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__HALTONFAILURE:
				setHaltonfailure(HALTONFAILURE_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TESTNAME:
				setTestname(TESTNAME_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TRANSFORMFILE:
				setTransformfile(TRANSFORMFILE_EDEFAULT);
				return;
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLIES:
				return !getAssemblies().isEmpty();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__CATEGORIES:
				return !getCategories().isEmpty();
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__APPCONFIG:
				return APPCONFIG_EDEFAULT == null ? appconfig != null : !APPCONFIG_EDEFAULT.equals(appconfig);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ASSEMBLYNAME:
				return ASSEMBLYNAME_EDEFAULT == null ? assemblyname != null : !ASSEMBLYNAME_EDEFAULT.equals(assemblyname);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__HALTONFAILURE:
				return HALTONFAILURE_EDEFAULT == null ? haltonfailure != null : !HALTONFAILURE_EDEFAULT.equals(haltonfailure);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TESTNAME:
				return TESTNAME_EDEFAULT == null ? testname != null : !TESTNAME_EDEFAULT.equals(testname);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__TRANSFORMFILE:
				return TRANSFORMFILE_EDEFAULT == null ? transformfile != null : !TRANSFORMFILE_EDEFAULT.equals(transformfile);
			case NantPackage.NANT_NUNIT2_TYPES_NUNIT2_TEST__ANY_ATTRIBUTE:
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
		result.append(", appconfig: ");
		result.append(appconfig);
		result.append(", assemblyname: ");
		result.append(assemblyname);
		result.append(", haltonfailure: ");
		result.append(haltonfailure);
		result.append(", testname: ");
		result.append(testname);
		result.append(", transformfile: ");
		result.append(transformfile);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntNUnit2TypesNUnit2TestImpl
