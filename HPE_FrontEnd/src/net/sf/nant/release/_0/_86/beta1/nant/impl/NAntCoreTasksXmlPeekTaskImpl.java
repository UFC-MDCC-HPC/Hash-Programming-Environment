/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPeekTask;
import net.sf.nant.release._0._86.beta1.nant.NamespacesType1;
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
 * An implementation of the model object '<em><b>NAnt Core Tasks Xml Peek Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getFile <em>File</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getNodeindex <em>Nodeindex</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getXpath <em>Xpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksXmlPeekTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTasksXmlPeekTaskImpl extends EObjectImpl implements NAntCoreTasksXmlPeekTask {
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
	 * The default value of the '{@link #getNodeindex() <em>Nodeindex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeindex()
	 * @generated
	 * @ordered
	 */
	protected static final Object NODEINDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeindex() <em>Nodeindex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeindex()
	 * @generated
	 * @ordered
	 */
	protected Object nodeindex = NODEINDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final Object PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Object property = PROPERTY_EDEFAULT;

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
	 * The default value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpath()
	 * @generated
	 * @ordered
	 */
	protected static final Object XPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpath()
	 * @generated
	 * @ordered
	 */
	protected Object xpath = XPATH_EDEFAULT;

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
	protected NAntCoreTasksXmlPeekTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTasksXmlPeekTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamespacesType1> getNamespaces() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTasksXmlPeekTask_Namespaces());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FILE, oldFile, file));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNodeindex() {
		return nodeindex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeindex(Object newNodeindex) {
		Object oldNodeindex = nodeindex;
		nodeindex = newNodeindex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NODEINDEX, oldNodeindex, nodeindex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Object newProperty) {
		Object oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__PROPERTY, oldProperty, property));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getXpath() {
		return xpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXpath(Object newXpath) {
		Object oldXpath = xpath;
		xpath = newXpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__XPATH, oldXpath, xpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NAMESPACES:
				return ((InternalEList<?>)getNamespaces()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NAMESPACES:
				return getNamespaces();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FILE:
				return getFile();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__IF:
				return getIf();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NODEINDEX:
				return getNodeindex();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__PROPERTY:
				return getProperty();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__XPATH:
				return getXpath();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NAMESPACES:
				getNamespaces().clear();
				getNamespaces().addAll((Collection<? extends NamespacesType1>)newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FILE:
				setFile(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NODEINDEX:
				setNodeindex(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__PROPERTY:
				setProperty(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__XPATH:
				setXpath(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NAMESPACES:
				getNamespaces().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NODEINDEX:
				setNodeindex(NODEINDEX_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__XPATH:
				setXpath(XPATH_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NAMESPACES:
				return !getNamespaces().isEmpty();
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__NODEINDEX:
				return NODEINDEX_EDEFAULT == null ? nodeindex != null : !NODEINDEX_EDEFAULT.equals(nodeindex);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__PROPERTY:
				return PROPERTY_EDEFAULT == null ? property != null : !PROPERTY_EDEFAULT.equals(property);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__XPATH:
				return XPATH_EDEFAULT == null ? xpath != null : !XPATH_EDEFAULT.equals(xpath);
			case NantPackage.NANT_CORE_TASKS_XML_PEEK_TASK__ANY_ATTRIBUTE:
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
		result.append(", file: ");
		result.append(file);
		result.append(", if: ");
		result.append(if_);
		result.append(", nodeindex: ");
		result.append(nodeindex);
		result.append(", property: ");
		result.append(property);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", xpath: ");
		result.append(xpath);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTasksXmlPeekTaskImpl
