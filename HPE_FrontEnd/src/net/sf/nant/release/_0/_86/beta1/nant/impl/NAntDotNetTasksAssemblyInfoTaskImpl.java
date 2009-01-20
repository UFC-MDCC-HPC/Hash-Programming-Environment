/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.AttributesType;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyInfoTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImportCollection;
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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks Assembly Info Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getReferences <em>References</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyInfoTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksAssemblyInfoTaskImpl extends EObjectImpl implements NAntDotNetTasksAssemblyInfoTask {
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
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final Object LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected Object language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected static final Object OUTPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Object output = OUTPUT_EDEFAULT;

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
	protected NAntDotNetTasksAssemblyInfoTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyInfoTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributesType> getAttributes() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyInfoTask_Attributes());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesNamespaceImportCollection> getImports() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyInfoTask_Imports());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesAssemblyFileSet> getReferences() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyInfoTask_References());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(Object newLanguage) {
		Object oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Object newOutput) {
		Object oldOutput = output;
		output = newOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__OUTPUT, oldOutput, output));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ATTRIBUTES:
				return getAttributes();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IMPORTS:
				return getImports();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__REFERENCES:
				return getReferences();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__LANGUAGE:
				return getLanguage();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends AttributesType>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends NAntDotNetTypesNamespaceImportCollection>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends NAntDotNetTypesAssemblyFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__LANGUAGE:
				setLanguage(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ATTRIBUTES:
				getAttributes().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IMPORTS:
				getImports().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__REFERENCES:
				getReferences().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ATTRIBUTES:
				return !getAttributes().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IMPORTS:
				return !getImports().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__REFERENCES:
				return !getReferences().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_INFO_TASK__ANY_ATTRIBUTE:
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
		result.append(", language: ");
		result.append(language);
		result.append(", output: ");
		result.append(output);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntDotNetTasksAssemblyInfoTaskImpl
