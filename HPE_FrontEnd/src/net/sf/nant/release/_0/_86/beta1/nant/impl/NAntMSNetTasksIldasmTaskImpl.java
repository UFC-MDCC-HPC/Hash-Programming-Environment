/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksIldasmTask;
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
 * An implementation of the model object '<em><b>NAnt MS Net Tasks Ildasm Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getAll <em>All</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getBytes <em>Bytes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getInput <em>Input</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getItem <em>Item</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getLinenumbers <em>Linenumbers</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getNoil <em>Noil</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getPubliconly <em>Publiconly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getQuoteallnames <em>Quoteallnames</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getRawexceptionhandling <em>Rawexceptionhandling</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getRebuild <em>Rebuild</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getSource <em>Source</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getTodir <em>Todir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getUnicode <em>Unicode</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getUtf8 <em>Utf8</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntMSNetTasksIldasmTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntMSNetTasksIldasmTaskImpl extends EObjectImpl implements NAntMSNetTasksIldasmTask {
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
	 * The default value of the '{@link #getAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAll()
	 * @generated
	 * @ordered
	 */
	protected static final Object ALL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAll()
	 * @generated
	 * @ordered
	 */
	protected Object all = ALL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBytes() <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytes()
	 * @generated
	 * @ordered
	 */
	protected static final Object BYTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBytes() <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytes()
	 * @generated
	 * @ordered
	 */
	protected Object bytes = BYTES_EDEFAULT;

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
	 * The default value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected static final Object HEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Object header = HEADER_EDEFAULT;

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
	 * The default value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected static final Object INPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Object input = INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getItem() <em>Item</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected static final Object ITEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected Object item = ITEM_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinenumbers() <em>Linenumbers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinenumbers()
	 * @generated
	 * @ordered
	 */
	protected static final Object LINENUMBERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinenumbers() <em>Linenumbers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinenumbers()
	 * @generated
	 * @ordered
	 */
	protected Object linenumbers = LINENUMBERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNoil() <em>Noil</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoil()
	 * @generated
	 * @ordered
	 */
	protected static final Object NOIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNoil() <em>Noil</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoil()
	 * @generated
	 * @ordered
	 */
	protected Object noil = NOIL_EDEFAULT;

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
	 * The default value of the '{@link #getPubliconly() <em>Publiconly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPubliconly()
	 * @generated
	 * @ordered
	 */
	protected static final Object PUBLICONLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPubliconly() <em>Publiconly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPubliconly()
	 * @generated
	 * @ordered
	 */
	protected Object publiconly = PUBLICONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuoteallnames() <em>Quoteallnames</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuoteallnames()
	 * @generated
	 * @ordered
	 */
	protected static final Object QUOTEALLNAMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuoteallnames() <em>Quoteallnames</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuoteallnames()
	 * @generated
	 * @ordered
	 */
	protected Object quoteallnames = QUOTEALLNAMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getRawexceptionhandling() <em>Rawexceptionhandling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawexceptionhandling()
	 * @generated
	 * @ordered
	 */
	protected static final Object RAWEXCEPTIONHANDLING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRawexceptionhandling() <em>Rawexceptionhandling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawexceptionhandling()
	 * @generated
	 * @ordered
	 */
	protected Object rawexceptionhandling = RAWEXCEPTIONHANDLING_EDEFAULT;

	/**
	 * The default value of the '{@link #getRebuild() <em>Rebuild</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRebuild()
	 * @generated
	 * @ordered
	 */
	protected static final Object REBUILD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRebuild() <em>Rebuild</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRebuild()
	 * @generated
	 * @ordered
	 */
	protected Object rebuild = REBUILD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final Object SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Object source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final Object TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected Object timeout = TIMEOUT_EDEFAULT;

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
	 * The default value of the '{@link #getTokens() <em>Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected static final Object TOKENS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected Object tokens = TOKENS_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnicode() <em>Unicode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnicode()
	 * @generated
	 * @ordered
	 */
	protected static final Object UNICODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnicode() <em>Unicode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnicode()
	 * @generated
	 * @ordered
	 */
	protected Object unicode = UNICODE_EDEFAULT;

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
	 * The default value of the '{@link #getUtf8() <em>Utf8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtf8()
	 * @generated
	 * @ordered
	 */
	protected static final Object UTF8_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUtf8() <em>Utf8</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtf8()
	 * @generated
	 * @ordered
	 */
	protected Object utf8 = UTF8_EDEFAULT;

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
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Object VISIBILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Object visibility = VISIBILITY_EDEFAULT;

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
	protected NAntMSNetTasksIldasmTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntMSNetTasksIldasmTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getAssemblies() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntMSNetTasksIldasmTask_Assemblies());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAll() {
		return all;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAll(Object newAll) {
		Object oldAll = all;
		all = newAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ALL, oldAll, all));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBytes() {
		return bytes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBytes(Object newBytes) {
		Object oldBytes = bytes;
		bytes = newBytes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__BYTES, oldBytes, bytes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__FAILONERROR, oldFailonerror, failonerror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(Object newHeader) {
		Object oldHeader = header;
		header = newHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__HEADER, oldHeader, header));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(Object newInput) {
		Object oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getItem() {
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItem(Object newItem) {
		Object oldItem = item;
		item = newItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ITEM, oldItem, item));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLinenumbers() {
		return linenumbers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinenumbers(Object newLinenumbers) {
		Object oldLinenumbers = linenumbers;
		linenumbers = newLinenumbers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__LINENUMBERS, oldLinenumbers, linenumbers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNoil() {
		return noil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoil(Object newNoil) {
		Object oldNoil = noil;
		noil = newNoil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__NOIL, oldNoil, noil));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPubliconly() {
		return publiconly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPubliconly(Object newPubliconly) {
		Object oldPubliconly = publiconly;
		publiconly = newPubliconly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__PUBLICONLY, oldPubliconly, publiconly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getQuoteallnames() {
		return quoteallnames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuoteallnames(Object newQuoteallnames) {
		Object oldQuoteallnames = quoteallnames;
		quoteallnames = newQuoteallnames;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__QUOTEALLNAMES, oldQuoteallnames, quoteallnames));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRawexceptionhandling() {
		return rawexceptionhandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawexceptionhandling(Object newRawexceptionhandling) {
		Object oldRawexceptionhandling = rawexceptionhandling;
		rawexceptionhandling = newRawexceptionhandling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__RAWEXCEPTIONHANDLING, oldRawexceptionhandling, rawexceptionhandling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRebuild() {
		return rebuild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRebuild(Object newRebuild) {
		Object oldRebuild = rebuild;
		rebuild = newRebuild;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__REBUILD, oldRebuild, rebuild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Object newSource) {
		Object oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(Object newTimeout) {
		Object oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TODIR, oldTodir, todir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTokens() {
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTokens(Object newTokens) {
		Object oldTokens = tokens;
		tokens = newTokens;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TOKENS, oldTokens, tokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUnicode() {
		return unicode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnicode(Object newUnicode) {
		Object oldUnicode = unicode;
		unicode = newUnicode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNICODE, oldUnicode, unicode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUtf8() {
		return utf8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtf8(Object newUtf8) {
		Object oldUtf8 = utf8;
		utf8 = newUtf8;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UTF8, oldUtf8, utf8));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Object newVisibility) {
		Object oldVisibility = visibility;
		visibility = newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ASSEMBLIES:
				return ((InternalEList<?>)getAssemblies()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ASSEMBLIES:
				return getAssemblies();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ALL:
				return getAll();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__BYTES:
				return getBytes();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__HEADER:
				return getHeader();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__IF:
				return getIf();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__INPUT:
				return getInput();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ITEM:
				return getItem();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__LINENUMBERS:
				return getLinenumbers();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__NOIL:
				return getNoil();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__PUBLICONLY:
				return getPubliconly();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__QUOTEALLNAMES:
				return getQuoteallnames();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__RAWEXCEPTIONHANDLING:
				return getRawexceptionhandling();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__REBUILD:
				return getRebuild();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__SOURCE:
				return getSource();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TODIR:
				return getTodir();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TOKENS:
				return getTokens();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNICODE:
				return getUnicode();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UTF8:
				return getUtf8();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VISIBILITY:
				return getVisibility();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ASSEMBLIES:
				getAssemblies().clear();
				getAssemblies().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ALL:
				setAll(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__BYTES:
				setBytes(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__HEADER:
				setHeader(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__INPUT:
				setInput(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ITEM:
				setItem(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__LINENUMBERS:
				setLinenumbers(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__NOIL:
				setNoil(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__PUBLICONLY:
				setPubliconly(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__QUOTEALLNAMES:
				setQuoteallnames(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__RAWEXCEPTIONHANDLING:
				setRawexceptionhandling(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__REBUILD:
				setRebuild(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__SOURCE:
				setSource(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TODIR:
				setTodir(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TOKENS:
				setTokens(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNICODE:
				setUnicode(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UTF8:
				setUtf8(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VISIBILITY:
				setVisibility(newValue);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ASSEMBLIES:
				getAssemblies().clear();
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ALL:
				setAll(ALL_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__BYTES:
				setBytes(BYTES_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__HEADER:
				setHeader(HEADER_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__INPUT:
				setInput(INPUT_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ITEM:
				setItem(ITEM_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__LINENUMBERS:
				setLinenumbers(LINENUMBERS_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__NOIL:
				setNoil(NOIL_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__PUBLICONLY:
				setPubliconly(PUBLICONLY_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__QUOTEALLNAMES:
				setQuoteallnames(QUOTEALLNAMES_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__RAWEXCEPTIONHANDLING:
				setRawexceptionhandling(RAWEXCEPTIONHANDLING_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__REBUILD:
				setRebuild(REBUILD_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TODIR:
				setTodir(TODIR_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TOKENS:
				setTokens(TOKENS_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNICODE:
				setUnicode(UNICODE_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UTF8:
				setUtf8(UTF8_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ASSEMBLIES:
				return !getAssemblies().isEmpty();
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ALL:
				return ALL_EDEFAULT == null ? all != null : !ALL_EDEFAULT.equals(all);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__BYTES:
				return BYTES_EDEFAULT == null ? bytes != null : !BYTES_EDEFAULT.equals(bytes);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__HEADER:
				return HEADER_EDEFAULT == null ? header != null : !HEADER_EDEFAULT.equals(header);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__INPUT:
				return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ITEM:
				return ITEM_EDEFAULT == null ? item != null : !ITEM_EDEFAULT.equals(item);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__LINENUMBERS:
				return LINENUMBERS_EDEFAULT == null ? linenumbers != null : !LINENUMBERS_EDEFAULT.equals(linenumbers);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__NOIL:
				return NOIL_EDEFAULT == null ? noil != null : !NOIL_EDEFAULT.equals(noil);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__PUBLICONLY:
				return PUBLICONLY_EDEFAULT == null ? publiconly != null : !PUBLICONLY_EDEFAULT.equals(publiconly);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__QUOTEALLNAMES:
				return QUOTEALLNAMES_EDEFAULT == null ? quoteallnames != null : !QUOTEALLNAMES_EDEFAULT.equals(quoteallnames);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__RAWEXCEPTIONHANDLING:
				return RAWEXCEPTIONHANDLING_EDEFAULT == null ? rawexceptionhandling != null : !RAWEXCEPTIONHANDLING_EDEFAULT.equals(rawexceptionhandling);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__REBUILD:
				return REBUILD_EDEFAULT == null ? rebuild != null : !REBUILD_EDEFAULT.equals(rebuild);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TODIR:
				return TODIR_EDEFAULT == null ? todir != null : !TODIR_EDEFAULT.equals(todir);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__TOKENS:
				return TOKENS_EDEFAULT == null ? tokens != null : !TOKENS_EDEFAULT.equals(tokens);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNICODE:
				return UNICODE_EDEFAULT == null ? unicode != null : !UNICODE_EDEFAULT.equals(unicode);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__UTF8:
				return UTF8_EDEFAULT == null ? utf8 != null : !UTF8_EDEFAULT.equals(utf8);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__VISIBILITY:
				return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
			case NantPackage.NANT_MS_NET_TASKS_ILDASM_TASK__ANY_ATTRIBUTE:
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
		result.append(", all: ");
		result.append(all);
		result.append(", bytes: ");
		result.append(bytes);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", header: ");
		result.append(header);
		result.append(", if: ");
		result.append(if_);
		result.append(", input: ");
		result.append(input);
		result.append(", item: ");
		result.append(item);
		result.append(", linenumbers: ");
		result.append(linenumbers);
		result.append(", noil: ");
		result.append(noil);
		result.append(", output: ");
		result.append(output);
		result.append(", publiconly: ");
		result.append(publiconly);
		result.append(", quoteallnames: ");
		result.append(quoteallnames);
		result.append(", rawexceptionhandling: ");
		result.append(rawexceptionhandling);
		result.append(", rebuild: ");
		result.append(rebuild);
		result.append(", source: ");
		result.append(source);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", todir: ");
		result.append(todir);
		result.append(", tokens: ");
		result.append(tokens);
		result.append(", unicode: ");
		result.append(unicode);
		result.append(", unless: ");
		result.append(unless);
		result.append(", utf8: ");
		result.append(utf8);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntMSNetTasksIldasmTaskImpl
