/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreFiltersFilterChain;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMoveTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
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
 * An implementation of the model object '<em><b>NAnt Core Tasks Move Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getFilterchain <em>Filterchain</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getFile <em>File</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getFlatten <em>Flatten</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getIncludeemptydirs <em>Includeemptydirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getInputencoding <em>Inputencoding</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getOutputencoding <em>Outputencoding</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getOverwrite <em>Overwrite</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getTodir <em>Todir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getTofile <em>Tofile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCoreTasksMoveTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCoreTasksMoveTaskImpl extends EObjectImpl implements NAntCoreTasksMoveTask {
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
	 * The default value of the '{@link #getFlatten() <em>Flatten</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlatten()
	 * @generated
	 * @ordered
	 */
	protected static final Object FLATTEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFlatten() <em>Flatten</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlatten()
	 * @generated
	 * @ordered
	 */
	protected Object flatten = FLATTEN_EDEFAULT;

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
	 * The default value of the '{@link #getIncludeemptydirs() <em>Includeemptydirs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludeemptydirs()
	 * @generated
	 * @ordered
	 */
	protected static final Object INCLUDEEMPTYDIRS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIncludeemptydirs() <em>Includeemptydirs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludeemptydirs()
	 * @generated
	 * @ordered
	 */
	protected Object includeemptydirs = INCLUDEEMPTYDIRS_EDEFAULT;

	/**
	 * The default value of the '{@link #getInputencoding() <em>Inputencoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputencoding()
	 * @generated
	 * @ordered
	 */
	protected static final Object INPUTENCODING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputencoding() <em>Inputencoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputencoding()
	 * @generated
	 * @ordered
	 */
	protected Object inputencoding = INPUTENCODING_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputencoding() <em>Outputencoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputencoding()
	 * @generated
	 * @ordered
	 */
	protected static final Object OUTPUTENCODING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputencoding() <em>Outputencoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputencoding()
	 * @generated
	 * @ordered
	 */
	protected Object outputencoding = OUTPUTENCODING_EDEFAULT;

	/**
	 * The default value of the '{@link #getOverwrite() <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverwrite()
	 * @generated
	 * @ordered
	 */
	protected static final Object OVERWRITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverwrite() <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverwrite()
	 * @generated
	 * @ordered
	 */
	protected Object overwrite = OVERWRITE_EDEFAULT;

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
	 * The default value of the '{@link #getTofile() <em>Tofile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTofile()
	 * @generated
	 * @ordered
	 */
	protected static final Object TOFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTofile() <em>Tofile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTofile()
	 * @generated
	 * @ordered
	 */
	protected Object tofile = TOFILE_EDEFAULT;

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
	protected NAntCoreTasksMoveTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCoreTasksMoveTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASKS_MOVE_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getFileset() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTasksMoveTask_Fileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreFiltersFilterChain> getFilterchain() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCoreTasksMoveTask_Filterchain());
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFlatten() {
		return flatten;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlatten(Object newFlatten) {
		Object oldFlatten = flatten;
		flatten = newFlatten;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__FLATTEN, oldFlatten, flatten));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIncludeemptydirs() {
		return includeemptydirs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeemptydirs(Object newIncludeemptydirs) {
		Object oldIncludeemptydirs = includeemptydirs;
		includeemptydirs = newIncludeemptydirs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__INCLUDEEMPTYDIRS, oldIncludeemptydirs, includeemptydirs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getInputencoding() {
		return inputencoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputencoding(Object newInputencoding) {
		Object oldInputencoding = inputencoding;
		inputencoding = newInputencoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__INPUTENCODING, oldInputencoding, inputencoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOutputencoding() {
		return outputencoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputencoding(Object newOutputencoding) {
		Object oldOutputencoding = outputencoding;
		outputencoding = newOutputencoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__OUTPUTENCODING, oldOutputencoding, outputencoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOverwrite() {
		return overwrite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverwrite(Object newOverwrite) {
		Object oldOverwrite = overwrite;
		overwrite = newOverwrite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__OVERWRITE, oldOverwrite, overwrite));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__TODIR, oldTodir, todir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTofile() {
		return tofile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTofile(Object newTofile) {
		Object oldTofile = tofile;
		tofile = newTofile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__TOFILE, oldTofile, tofile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_CORE_TASKS_MOVE_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_CORE_TASKS_MOVE_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILESET:
				return ((InternalEList<?>)getFileset()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILTERCHAIN:
				return ((InternalEList<?>)getFilterchain()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILESET:
				return getFileset();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILTERCHAIN:
				return getFilterchain();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILE:
				return getFile();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FLATTEN:
				return getFlatten();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__IF:
				return getIf();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INCLUDEEMPTYDIRS:
				return getIncludeemptydirs();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INPUTENCODING:
				return getInputencoding();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OUTPUTENCODING:
				return getOutputencoding();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OVERWRITE:
				return getOverwrite();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TODIR:
				return getTodir();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TOFILE:
				return getTofile();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILESET:
				getFileset().clear();
				getFileset().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILTERCHAIN:
				getFilterchain().clear();
				getFilterchain().addAll((Collection<? extends NAntCoreFiltersFilterChain>)newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILE:
				setFile(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FLATTEN:
				setFlatten(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INCLUDEEMPTYDIRS:
				setIncludeemptydirs(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INPUTENCODING:
				setInputencoding(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OUTPUTENCODING:
				setOutputencoding(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OVERWRITE:
				setOverwrite(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TODIR:
				setTodir(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TOFILE:
				setTofile(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILESET:
				getFileset().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILTERCHAIN:
				getFilterchain().clear();
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FLATTEN:
				setFlatten(FLATTEN_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INCLUDEEMPTYDIRS:
				setIncludeemptydirs(INCLUDEEMPTYDIRS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INPUTENCODING:
				setInputencoding(INPUTENCODING_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OUTPUTENCODING:
				setOutputencoding(OUTPUTENCODING_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OVERWRITE:
				setOverwrite(OVERWRITE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TODIR:
				setTodir(TODIR_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TOFILE:
				setTofile(TOFILE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILESET:
				return !getFileset().isEmpty();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILTERCHAIN:
				return !getFilterchain().isEmpty();
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__FLATTEN:
				return FLATTEN_EDEFAULT == null ? flatten != null : !FLATTEN_EDEFAULT.equals(flatten);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INCLUDEEMPTYDIRS:
				return INCLUDEEMPTYDIRS_EDEFAULT == null ? includeemptydirs != null : !INCLUDEEMPTYDIRS_EDEFAULT.equals(includeemptydirs);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__INPUTENCODING:
				return INPUTENCODING_EDEFAULT == null ? inputencoding != null : !INPUTENCODING_EDEFAULT.equals(inputencoding);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OUTPUTENCODING:
				return OUTPUTENCODING_EDEFAULT == null ? outputencoding != null : !OUTPUTENCODING_EDEFAULT.equals(outputencoding);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__OVERWRITE:
				return OVERWRITE_EDEFAULT == null ? overwrite != null : !OVERWRITE_EDEFAULT.equals(overwrite);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TODIR:
				return TODIR_EDEFAULT == null ? todir != null : !TODIR_EDEFAULT.equals(todir);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__TOFILE:
				return TOFILE_EDEFAULT == null ? tofile != null : !TOFILE_EDEFAULT.equals(tofile);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_CORE_TASKS_MOVE_TASK__ANY_ATTRIBUTE:
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
		result.append(", flatten: ");
		result.append(flatten);
		result.append(", if: ");
		result.append(if_);
		result.append(", includeemptydirs: ");
		result.append(includeemptydirs);
		result.append(", inputencoding: ");
		result.append(inputencoding);
		result.append(", outputencoding: ");
		result.append(outputencoding);
		result.append(", overwrite: ");
		result.append(overwrite);
		result.append(", todir: ");
		result.append(todir);
		result.append(", tofile: ");
		result.append(tofile);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCoreTasksMoveTaskImpl
