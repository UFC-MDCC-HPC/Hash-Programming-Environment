/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesZipFileSet;
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
 * An implementation of the model object '<em><b>NAnt Compression Tasks Zip Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getDuplicate <em>Duplicate</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getIncludeemptydirs <em>Includeemptydirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getStampdatetime <em>Stampdatetime</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getZipfile <em>Zipfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getZiplevel <em>Ziplevel</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntCompressionTasksZipTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntCompressionTasksZipTaskImpl extends EObjectImpl implements NAntCompressionTasksZipTask {
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
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final Object COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected Object comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuplicate() <em>Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicate()
	 * @generated
	 * @ordered
	 */
	protected static final Object DUPLICATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDuplicate() <em>Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicate()
	 * @generated
	 * @ordered
	 */
	protected Object duplicate = DUPLICATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final Object ENCODING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected Object encoding = ENCODING_EDEFAULT;

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
	 * The default value of the '{@link #getStampdatetime() <em>Stampdatetime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStampdatetime()
	 * @generated
	 * @ordered
	 */
	protected static final Object STAMPDATETIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStampdatetime() <em>Stampdatetime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStampdatetime()
	 * @generated
	 * @ordered
	 */
	protected Object stampdatetime = STAMPDATETIME_EDEFAULT;

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
	 * The default value of the '{@link #getZipfile() <em>Zipfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object ZIPFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZipfile() <em>Zipfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipfile()
	 * @generated
	 * @ordered
	 */
	protected Object zipfile = ZIPFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getZiplevel() <em>Ziplevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZiplevel()
	 * @generated
	 * @ordered
	 */
	protected static final Object ZIPLEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZiplevel() <em>Ziplevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZiplevel()
	 * @generated
	 * @ordered
	 */
	protected Object ziplevel = ZIPLEVEL_EDEFAULT;

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
	protected NAntCompressionTasksZipTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntCompressionTasksZipTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCompressionTypesZipFileSet> getFileset() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntCompressionTasksZipTask_Fileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(Object newComment) {
		Object oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDuplicate() {
		return duplicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuplicate(Object newDuplicate) {
		Object oldDuplicate = duplicate;
		duplicate = newDuplicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__DUPLICATE, oldDuplicate, duplicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEncoding() {
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(Object newEncoding) {
		Object oldEncoding = encoding;
		encoding = newEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ENCODING, oldEncoding, encoding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__IF, oldIf, if_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__INCLUDEEMPTYDIRS, oldIncludeemptydirs, includeemptydirs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getStampdatetime() {
		return stampdatetime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStampdatetime(Object newStampdatetime) {
		Object oldStampdatetime = stampdatetime;
		stampdatetime = newStampdatetime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__STAMPDATETIME, oldStampdatetime, stampdatetime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getZipfile() {
		return zipfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZipfile(Object newZipfile) {
		Object oldZipfile = zipfile;
		zipfile = newZipfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPFILE, oldZipfile, zipfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getZiplevel() {
		return ziplevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZiplevel(Object newZiplevel) {
		Object oldZiplevel = ziplevel;
		ziplevel = newZiplevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPLEVEL, oldZiplevel, ziplevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FILESET:
				return ((InternalEList<?>)getFileset()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FILESET:
				return getFileset();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__COMMENT:
				return getComment();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__DUPLICATE:
				return getDuplicate();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ENCODING:
				return getEncoding();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__IF:
				return getIf();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__INCLUDEEMPTYDIRS:
				return getIncludeemptydirs();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__STAMPDATETIME:
				return getStampdatetime();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPFILE:
				return getZipfile();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPLEVEL:
				return getZiplevel();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FILESET:
				getFileset().clear();
				getFileset().addAll((Collection<? extends NAntCompressionTypesZipFileSet>)newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__COMMENT:
				setComment(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__DUPLICATE:
				setDuplicate(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ENCODING:
				setEncoding(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__INCLUDEEMPTYDIRS:
				setIncludeemptydirs(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__STAMPDATETIME:
				setStampdatetime(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPFILE:
				setZipfile(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPLEVEL:
				setZiplevel(newValue);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FILESET:
				getFileset().clear();
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__DUPLICATE:
				setDuplicate(DUPLICATE_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ENCODING:
				setEncoding(ENCODING_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__INCLUDEEMPTYDIRS:
				setIncludeemptydirs(INCLUDEEMPTYDIRS_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__STAMPDATETIME:
				setStampdatetime(STAMPDATETIME_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPFILE:
				setZipfile(ZIPFILE_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPLEVEL:
				setZiplevel(ZIPLEVEL_EDEFAULT);
				return;
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FILESET:
				return !getFileset().isEmpty();
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__DUPLICATE:
				return DUPLICATE_EDEFAULT == null ? duplicate != null : !DUPLICATE_EDEFAULT.equals(duplicate);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ENCODING:
				return ENCODING_EDEFAULT == null ? encoding != null : !ENCODING_EDEFAULT.equals(encoding);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__INCLUDEEMPTYDIRS:
				return INCLUDEEMPTYDIRS_EDEFAULT == null ? includeemptydirs != null : !INCLUDEEMPTYDIRS_EDEFAULT.equals(includeemptydirs);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__STAMPDATETIME:
				return STAMPDATETIME_EDEFAULT == null ? stampdatetime != null : !STAMPDATETIME_EDEFAULT.equals(stampdatetime);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPFILE:
				return ZIPFILE_EDEFAULT == null ? zipfile != null : !ZIPFILE_EDEFAULT.equals(zipfile);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ZIPLEVEL:
				return ZIPLEVEL_EDEFAULT == null ? ziplevel != null : !ZIPLEVEL_EDEFAULT.equals(ziplevel);
			case NantPackage.NANT_COMPRESSION_TASKS_ZIP_TASK__ANY_ATTRIBUTE:
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
		result.append(", comment: ");
		result.append(comment);
		result.append(", duplicate: ");
		result.append(duplicate);
		result.append(", encoding: ");
		result.append(encoding);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", includeemptydirs: ");
		result.append(includeemptydirs);
		result.append(", stampdatetime: ");
		result.append(stampdatetime);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", zipfile: ");
		result.append(zipfile);
		result.append(", ziplevel: ");
		result.append(ziplevel);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntCompressionTasksZipTaskImpl
