/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesDirSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesRawXml;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksNDocTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks NDoc Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getSummaries <em>Summaries</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getDocumenters <em>Documenters</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getReferencepaths <em>Referencepaths</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksNDocTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksNDocTaskImpl extends EObjectImpl implements NAntDotNetTasksNDocTask {
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
	 * The default value of the '{@link #getFailonerror() <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailonerror()
	 * @generated
	 * @ordered
	 */
	protected static final Object FAILONERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailonerror() <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailonerror()
	 * @generated
	 * @ordered
	 */
	protected Object failonerror = FAILONERROR_EDEFAULT;

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
	 * The default value of the '{@link #getVerbose() <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbose()
	 * @generated
	 * @ordered
	 */
	protected static final Object VERBOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerbose() <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbose()
	 * @generated
	 * @ordered
	 */
	protected Object verbose = VERBOSE_EDEFAULT;

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
	protected NAntDotNetTasksNDocTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksNDocTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getAssemblies() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksNDocTask_Assemblies());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getSummaries() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksNDocTask_Summaries());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesRawXml> getDocumenters() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksNDocTask_Documenters());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesDirSet> getReferencepaths() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksNDocTask_Referencepaths());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFailonerror() {
		return failonerror;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailonerror(Object newFailonerror) {
		Object oldFailonerror = failonerror;
		failonerror = newFailonerror;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__IF, oldIf, if_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getVerbose() {
		return verbose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerbose(Object newVerbose) {
		Object oldVerbose = verbose;
		verbose = newVerbose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ASSEMBLIES:
				return ((InternalEList<?>)getAssemblies()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__SUMMARIES:
				return ((InternalEList<?>)getSummaries()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__DOCUMENTERS:
				return ((InternalEList<?>)getDocumenters()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__REFERENCEPATHS:
				return ((InternalEList<?>)getReferencepaths()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ASSEMBLIES:
				return getAssemblies();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__SUMMARIES:
				return getSummaries();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__DOCUMENTERS:
				return getDocumenters();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__REFERENCEPATHS:
				return getReferencepaths();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ASSEMBLIES:
				getAssemblies().clear();
				getAssemblies().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__SUMMARIES:
				getSummaries().clear();
				getSummaries().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__DOCUMENTERS:
				getDocumenters().clear();
				getDocumenters().addAll((Collection<? extends NAntCoreTypesRawXml>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__REFERENCEPATHS:
				getReferencepaths().clear();
				getReferencepaths().addAll((Collection<? extends NAntCoreTypesDirSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ASSEMBLIES:
				getAssemblies().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__SUMMARIES:
				getSummaries().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__DOCUMENTERS:
				getDocumenters().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__REFERENCEPATHS:
				getReferencepaths().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ASSEMBLIES:
				return !getAssemblies().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__SUMMARIES:
				return !getSummaries().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__DOCUMENTERS:
				return !getDocumenters().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__REFERENCEPATHS:
				return !getReferencepaths().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_NDOC_TASK__ANY_ATTRIBUTE:
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
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntDotNetTasksNDocTaskImpl
