/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.WebmapType;

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
 * An implementation of the model object '<em><b>NAnt VS Net Tasks Solution Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getReferenceprojects <em>Referenceprojects</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getWebmap <em>Webmap</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getExcludeprojects <em>Excludeprojects</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getAssemblyfolders <em>Assemblyfolders</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getEnablewebdav <em>Enablewebdav</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getIncludevsfolders <em>Includevsfolders</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getOutputdir <em>Outputdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getSolutionfile <em>Solutionfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntVSNetTasksSolutionTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntVSNetTasksSolutionTaskImpl extends EObjectImpl implements NAntVSNetTasksSolutionTask {
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
	 * The default value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONFIGURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Object configuration = CONFIGURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnablewebdav() <em>Enablewebdav</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnablewebdav()
	 * @generated
	 * @ordered
	 */
	protected static final Object ENABLEWEBDAV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnablewebdav() <em>Enablewebdav</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnablewebdav()
	 * @generated
	 * @ordered
	 */
	protected Object enablewebdav = ENABLEWEBDAV_EDEFAULT;

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
	 * The default value of the '{@link #getIncludevsfolders() <em>Includevsfolders</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludevsfolders()
	 * @generated
	 * @ordered
	 */
	protected static final Object INCLUDEVSFOLDERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIncludevsfolders() <em>Includevsfolders</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludevsfolders()
	 * @generated
	 * @ordered
	 */
	protected Object includevsfolders = INCLUDEVSFOLDERS_EDEFAULT;

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
	 * The default value of the '{@link #getSolutionfile() <em>Solutionfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object SOLUTIONFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSolutionfile() <em>Solutionfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionfile()
	 * @generated
	 * @ordered
	 */
	protected Object solutionfile = SOLUTIONFILE_EDEFAULT;

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
	protected NAntVSNetTasksSolutionTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntVSNetTasksSolutionTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getProjects() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVSNetTasksSolutionTask_Projects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getReferenceprojects() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVSNetTasksSolutionTask_Referenceprojects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WebmapType> getWebmap() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVSNetTasksSolutionTask_Webmap());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getExcludeprojects() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVSNetTasksSolutionTask_Excludeprojects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getAssemblyfolders() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntVSNetTasksSolutionTask_Assemblyfolders());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(Object newConfiguration) {
		Object oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__CONFIGURATION, oldConfiguration, configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEnablewebdav() {
		return enablewebdav;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnablewebdav(Object newEnablewebdav) {
		Object oldEnablewebdav = enablewebdav;
		enablewebdav = newEnablewebdav;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ENABLEWEBDAV, oldEnablewebdav, enablewebdav));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIncludevsfolders() {
		return includevsfolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludevsfolders(Object newIncludevsfolders) {
		Object oldIncludevsfolders = includevsfolders;
		includevsfolders = newIncludevsfolders;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__INCLUDEVSFOLDERS, oldIncludevsfolders, includevsfolders));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__OUTPUTDIR, oldOutputdir, outputdir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSolutionfile() {
		return solutionfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolutionfile(Object newSolutionfile) {
		Object oldSolutionfile = solutionfile;
		solutionfile = newSolutionfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__SOLUTIONFILE, oldSolutionfile, solutionfile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__REFERENCEPROJECTS:
				return ((InternalEList<?>)getReferenceprojects()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__WEBMAP:
				return ((InternalEList<?>)getWebmap()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__EXCLUDEPROJECTS:
				return ((InternalEList<?>)getExcludeprojects()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ASSEMBLYFOLDERS:
				return ((InternalEList<?>)getAssemblyfolders()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__PROJECTS:
				return getProjects();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__REFERENCEPROJECTS:
				return getReferenceprojects();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__WEBMAP:
				return getWebmap();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__EXCLUDEPROJECTS:
				return getExcludeprojects();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ASSEMBLYFOLDERS:
				return getAssemblyfolders();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__CONFIGURATION:
				return getConfiguration();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ENABLEWEBDAV:
				return getEnablewebdav();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__IF:
				return getIf();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__INCLUDEVSFOLDERS:
				return getIncludevsfolders();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__OUTPUTDIR:
				return getOutputdir();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__SOLUTIONFILE:
				return getSolutionfile();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__REFERENCEPROJECTS:
				getReferenceprojects().clear();
				getReferenceprojects().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__WEBMAP:
				getWebmap().clear();
				getWebmap().addAll((Collection<? extends WebmapType>)newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__EXCLUDEPROJECTS:
				getExcludeprojects().clear();
				getExcludeprojects().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ASSEMBLYFOLDERS:
				getAssemblyfolders().clear();
				getAssemblyfolders().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__CONFIGURATION:
				setConfiguration(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ENABLEWEBDAV:
				setEnablewebdav(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__INCLUDEVSFOLDERS:
				setIncludevsfolders(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__OUTPUTDIR:
				setOutputdir(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__SOLUTIONFILE:
				setSolutionfile(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__PROJECTS:
				getProjects().clear();
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__REFERENCEPROJECTS:
				getReferenceprojects().clear();
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__WEBMAP:
				getWebmap().clear();
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__EXCLUDEPROJECTS:
				getExcludeprojects().clear();
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ASSEMBLYFOLDERS:
				getAssemblyfolders().clear();
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__CONFIGURATION:
				setConfiguration(CONFIGURATION_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ENABLEWEBDAV:
				setEnablewebdav(ENABLEWEBDAV_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__INCLUDEVSFOLDERS:
				setIncludevsfolders(INCLUDEVSFOLDERS_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__OUTPUTDIR:
				setOutputdir(OUTPUTDIR_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__SOLUTIONFILE:
				setSolutionfile(SOLUTIONFILE_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__PROJECTS:
				return !getProjects().isEmpty();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__REFERENCEPROJECTS:
				return !getReferenceprojects().isEmpty();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__WEBMAP:
				return !getWebmap().isEmpty();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__EXCLUDEPROJECTS:
				return !getExcludeprojects().isEmpty();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ASSEMBLYFOLDERS:
				return !getAssemblyfolders().isEmpty();
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__CONFIGURATION:
				return CONFIGURATION_EDEFAULT == null ? configuration != null : !CONFIGURATION_EDEFAULT.equals(configuration);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ENABLEWEBDAV:
				return ENABLEWEBDAV_EDEFAULT == null ? enablewebdav != null : !ENABLEWEBDAV_EDEFAULT.equals(enablewebdav);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__INCLUDEVSFOLDERS:
				return INCLUDEVSFOLDERS_EDEFAULT == null ? includevsfolders != null : !INCLUDEVSFOLDERS_EDEFAULT.equals(includevsfolders);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__OUTPUTDIR:
				return OUTPUTDIR_EDEFAULT == null ? outputdir != null : !OUTPUTDIR_EDEFAULT.equals(outputdir);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__SOLUTIONFILE:
				return SOLUTIONFILE_EDEFAULT == null ? solutionfile != null : !SOLUTIONFILE_EDEFAULT.equals(solutionfile);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_VS_NET_TASKS_SOLUTION_TASK__ANY_ATTRIBUTE:
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
		result.append(", configuration: ");
		result.append(configuration);
		result.append(", enablewebdav: ");
		result.append(enablewebdav);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", includevsfolders: ");
		result.append(includevsfolders);
		result.append(", outputdir: ");
		result.append(outputdir);
		result.append(", solutionfile: ");
		result.append(solutionfile);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntVSNetTasksSolutionTaskImpl
