/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesDirSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExclude;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExcludesFile;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetInclude;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetIncludesFile;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPatternSet;
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
 * An implementation of the model object '<em><b>NAnt Core Types Dir Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getPatternset <em>Patternset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getExclude <em>Exclude</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getIncludesList <em>Includes List</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getIncludesfile <em>Includesfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getExcludesfile <em>Excludesfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getBasedir <em>Basedir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getCasesensitive <em>Casesensitive</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getDefaultexcludes <em>Defaultexcludes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getFailonempty <em>Failonempty</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getId <em>Id</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getRefid <em>Refid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTypesDirSetImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTypesDirSetImpl extends EObjectImpl implements NAntCoreTypesDirSet {
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
	 * The default value of the '{@link #getBasedir() <em>Basedir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasedir()
	 * @generated
	 * @ordered
	 */
	protected static final Object BASEDIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasedir() <em>Basedir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasedir()
	 * @generated
	 * @ordered
	 */
	protected Object basedir = BASEDIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCasesensitive() <em>Casesensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCasesensitive()
	 * @generated
	 * @ordered
	 */
	protected static final Object CASESENSITIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCasesensitive() <em>Casesensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCasesensitive()
	 * @generated
	 * @ordered
	 */
	protected Object casesensitive = CASESENSITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultexcludes() <em>Defaultexcludes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultexcludes()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEFAULTEXCLUDES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultexcludes() <em>Defaultexcludes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultexcludes()
	 * @generated
	 * @ordered
	 */
	protected Object defaultexcludes = DEFAULTEXCLUDES_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailonempty() <em>Failonempty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailonempty()
	 * @generated
	 * @ordered
	 */
	protected static final Object FAILONEMPTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailonempty() <em>Failonempty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailonempty()
	 * @generated
	 * @ordered
	 */
	protected Object failonempty = FAILONEMPTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Object ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Object id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getRefid() <em>Refid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefid()
	 * @generated
	 * @ordered
	 */
	protected static final Object REFID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefid() <em>Refid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefid()
	 * @generated
	 * @ordered
	 */
	protected Object refid = REFID_EDEFAULT;

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
	protected NAntCoreTypesDirSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTypesDirSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_DIR_SET__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesPatternSet> getPatternset() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_Patternset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSetInclude> getIncludes() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_Includes());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSetInclude> getInclude() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_Include());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSetExclude> getExcludes() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_Excludes());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSetExclude> getExclude() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_Exclude());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSetIncludesFile> getIncludesList() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_IncludesList());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSetIncludesFile> getIncludesfile() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_Includesfile());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSetExcludesFile> getExcludesfile() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTypesDirSet_Excludesfile());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBasedir() {
		return basedir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasedir(Object newBasedir) {
		Object oldBasedir = basedir;
		basedir = newBasedir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_DIR_SET__BASEDIR, oldBasedir, basedir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCasesensitive() {
		return casesensitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasesensitive(Object newCasesensitive) {
		Object oldCasesensitive = casesensitive;
		casesensitive = newCasesensitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_DIR_SET__CASESENSITIVE, oldCasesensitive, casesensitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDefaultexcludes() {
		return defaultexcludes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultexcludes(Object newDefaultexcludes) {
		Object oldDefaultexcludes = defaultexcludes;
		defaultexcludes = newDefaultexcludes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_DIR_SET__DEFAULTEXCLUDES, oldDefaultexcludes, defaultexcludes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFailonempty() {
		return failonempty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailonempty(Object newFailonempty) {
		Object oldFailonempty = failonempty;
		failonempty = newFailonempty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_DIR_SET__FAILONEMPTY, oldFailonempty, failonempty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Object newId) {
		Object oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_DIR_SET__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRefid() {
		return refid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefid(Object newRefid) {
		Object oldRefid = refid;
		refid = newRefid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TYPES_DIR_SET__REFID, oldRefid, refid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TYPES_DIR_SET__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_CORE_TYPES_DIR_SET__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__PATTERNSET:
				return ((InternalEList<?>)getPatternset()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES:
				return ((InternalEList<?>)getIncludes()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDE:
				return ((InternalEList<?>)getInclude()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDES:
				return ((InternalEList<?>)getExcludes()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDE:
				return ((InternalEList<?>)getExclude()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES_LIST:
				return ((InternalEList<?>)getIncludesList()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDESFILE:
				return ((InternalEList<?>)getIncludesfile()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDESFILE:
				return ((InternalEList<?>)getExcludesfile()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_DIR_SET__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__PATTERNSET:
				return getPatternset();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES:
				return getIncludes();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDE:
				return getInclude();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDES:
				return getExcludes();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDE:
				return getExclude();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES_LIST:
				return getIncludesList();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDESFILE:
				return getIncludesfile();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDESFILE:
				return getExcludesfile();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__BASEDIR:
				return getBasedir();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__CASESENSITIVE:
				return getCasesensitive();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__DEFAULTEXCLUDES:
				return getDefaultexcludes();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__FAILONEMPTY:
				return getFailonempty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ID:
				return getId();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__REFID:
				return getRefid();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_DIR_SET__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__PATTERNSET:
				getPatternset().clear();
				getPatternset().addAll((Collection<? extends NAntCoreTypesPatternSet>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES:
				getIncludes().clear();
				getIncludes().addAll((Collection<? extends NAntCoreTypesFileSetInclude>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDE:
				getInclude().clear();
				getInclude().addAll((Collection<? extends NAntCoreTypesFileSetInclude>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDES:
				getExcludes().clear();
				getExcludes().addAll((Collection<? extends NAntCoreTypesFileSetExclude>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDE:
				getExclude().clear();
				getExclude().addAll((Collection<? extends NAntCoreTypesFileSetExclude>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES_LIST:
				getIncludesList().clear();
				getIncludesList().addAll((Collection<? extends NAntCoreTypesFileSetIncludesFile>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDESFILE:
				getIncludesfile().clear();
				getIncludesfile().addAll((Collection<? extends NAntCoreTypesFileSetIncludesFile>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDESFILE:
				getExcludesfile().clear();
				getExcludesfile().addAll((Collection<? extends NAntCoreTypesFileSetExcludesFile>)newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__BASEDIR:
				setBasedir(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__CASESENSITIVE:
				setCasesensitive(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__DEFAULTEXCLUDES:
				setDefaultexcludes(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__FAILONEMPTY:
				setFailonempty(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ID:
				setId(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__REFID:
				setRefid(newValue);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_DIR_SET__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__PATTERNSET:
				getPatternset().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES:
				getIncludes().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDE:
				getInclude().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDES:
				getExcludes().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDE:
				getExclude().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES_LIST:
				getIncludesList().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDESFILE:
				getIncludesfile().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDESFILE:
				getExcludesfile().clear();
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__BASEDIR:
				setBasedir(BASEDIR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__CASESENSITIVE:
				setCasesensitive(CASESENSITIVE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__DEFAULTEXCLUDES:
				setDefaultexcludes(DEFAULTEXCLUDES_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__FAILONEMPTY:
				setFailonempty(FAILONEMPTY_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ID:
				setId(ID_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__REFID:
				setRefid(REFID_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TYPES_DIR_SET__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__PATTERNSET:
				return !getPatternset().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES:
				return !getIncludes().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDE:
				return !getInclude().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDES:
				return !getExcludes().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDE:
				return !getExclude().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDES_LIST:
				return !getIncludesList().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__INCLUDESFILE:
				return !getIncludesfile().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__EXCLUDESFILE:
				return !getExcludesfile().isEmpty();
			case NantPackage.NANT_CORE_TYPES_DIR_SET__BASEDIR:
				return BASEDIR_EDEFAULT == null ? basedir != null : !BASEDIR_EDEFAULT.equals(basedir);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__CASESENSITIVE:
				return CASESENSITIVE_EDEFAULT == null ? casesensitive != null : !CASESENSITIVE_EDEFAULT.equals(casesensitive);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__DEFAULTEXCLUDES:
				return DEFAULTEXCLUDES_EDEFAULT == null ? defaultexcludes != null : !DEFAULTEXCLUDES_EDEFAULT.equals(defaultexcludes);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__FAILONEMPTY:
				return FAILONEMPTY_EDEFAULT == null ? failonempty != null : !FAILONEMPTY_EDEFAULT.equals(failonempty);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__REFID:
				return REFID_EDEFAULT == null ? refid != null : !REFID_EDEFAULT.equals(refid);
			case NantPackage.NANT_CORE_TYPES_DIR_SET__ANY_ATTRIBUTE:
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
		result.append(", basedir: ");
		result.append(basedir);
		result.append(", casesensitive: ");
		result.append(casesensitive);
		result.append(", defaultexcludes: ");
		result.append(defaultexcludes);
		result.append(", failonempty: ");
		result.append(failonempty);
		result.append(", id: ");
		result.append(id);
		result.append(", refid: ");
		result.append(refid);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTypesDirSetImpl
