/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksUpdateTask;
import net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTypesCvsFileSet;
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
 * An implementation of the model object '<em><b>NAnt Source Control Tasks Update Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getBuilddirs <em>Builddirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getCommandline <em>Commandline</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getCompressionlevel <em>Compressionlevel</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getCvsfullpath <em>Cvsfullpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getCvsroot <em>Cvsroot</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getCvsrsh <em>Cvsrsh</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getDate <em>Date</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getModule <em>Module</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getOverwritelocal <em>Overwritelocal</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getPassfile <em>Passfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getPruneempty <em>Pruneempty</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getQuiet <em>Quiet</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getReadonly <em>Readonly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getReadwrite <em>Readwrite</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getReallyquiet <em>Reallyquiet</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getRecursive <em>Recursive</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getStickyTag <em>Sticky Tag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getUsesharpcvslib <em>Usesharpcvslib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntSourceControlTasksUpdateTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntSourceControlTasksUpdateTaskImpl extends EObjectImpl implements NAntSourceControlTasksUpdateTask {
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
	 * The default value of the '{@link #getBuilddirs() <em>Builddirs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuilddirs()
	 * @generated
	 * @ordered
	 */
	protected static final Object BUILDDIRS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuilddirs() <em>Builddirs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuilddirs()
	 * @generated
	 * @ordered
	 */
	protected Object builddirs = BUILDDIRS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandline() <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandline()
	 * @generated
	 * @ordered
	 */
	protected static final Object COMMANDLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandline() <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandline()
	 * @generated
	 * @ordered
	 */
	protected Object commandline = COMMANDLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompressionlevel() <em>Compressionlevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompressionlevel()
	 * @generated
	 * @ordered
	 */
	protected static final Object COMPRESSIONLEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompressionlevel() <em>Compressionlevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompressionlevel()
	 * @generated
	 * @ordered
	 */
	protected Object compressionlevel = COMPRESSIONLEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCvsfullpath() <em>Cvsfullpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsfullpath()
	 * @generated
	 * @ordered
	 */
	protected static final Object CVSFULLPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCvsfullpath() <em>Cvsfullpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsfullpath()
	 * @generated
	 * @ordered
	 */
	protected Object cvsfullpath = CVSFULLPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCvsroot() <em>Cvsroot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsroot()
	 * @generated
	 * @ordered
	 */
	protected static final Object CVSROOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCvsroot() <em>Cvsroot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsroot()
	 * @generated
	 * @ordered
	 */
	protected Object cvsroot = CVSROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCvsrsh() <em>Cvsrsh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsrsh()
	 * @generated
	 * @ordered
	 */
	protected static final Object CVSRSH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCvsrsh() <em>Cvsrsh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvsrsh()
	 * @generated
	 * @ordered
	 */
	protected Object cvsrsh = CVSRSH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Object date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDestination() <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected static final Object DESTINATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected Object destination = DESTINATION_EDEFAULT;

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
	 * The default value of the '{@link #getModule() <em>Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModule()
	 * @generated
	 * @ordered
	 */
	protected static final Object MODULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModule() <em>Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModule()
	 * @generated
	 * @ordered
	 */
	protected Object module = MODULE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOverwritelocal() <em>Overwritelocal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverwritelocal()
	 * @generated
	 * @ordered
	 */
	protected static final Object OVERWRITELOCAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverwritelocal() <em>Overwritelocal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverwritelocal()
	 * @generated
	 * @ordered
	 */
	protected Object overwritelocal = OVERWRITELOCAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassfile() <em>Passfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object PASSFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassfile() <em>Passfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassfile()
	 * @generated
	 * @ordered
	 */
	protected Object passfile = PASSFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final Object PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected Object password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPruneempty() <em>Pruneempty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPruneempty()
	 * @generated
	 * @ordered
	 */
	protected static final Object PRUNEEMPTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPruneempty() <em>Pruneempty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPruneempty()
	 * @generated
	 * @ordered
	 */
	protected Object pruneempty = PRUNEEMPTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuiet() <em>Quiet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuiet()
	 * @generated
	 * @ordered
	 */
	protected static final Object QUIET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuiet() <em>Quiet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuiet()
	 * @generated
	 * @ordered
	 */
	protected Object quiet = QUIET_EDEFAULT;

	/**
	 * The default value of the '{@link #getReadonly() <em>Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadonly()
	 * @generated
	 * @ordered
	 */
	protected static final Object READONLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadonly() <em>Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadonly()
	 * @generated
	 * @ordered
	 */
	protected Object readonly = READONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getReadwrite() <em>Readwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadwrite()
	 * @generated
	 * @ordered
	 */
	protected static final Object READWRITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadwrite() <em>Readwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadwrite()
	 * @generated
	 * @ordered
	 */
	protected Object readwrite = READWRITE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReallyquiet() <em>Reallyquiet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReallyquiet()
	 * @generated
	 * @ordered
	 */
	protected static final Object REALLYQUIET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReallyquiet() <em>Reallyquiet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReallyquiet()
	 * @generated
	 * @ordered
	 */
	protected Object reallyquiet = REALLYQUIET_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecursive() <em>Recursive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecursive()
	 * @generated
	 * @ordered
	 */
	protected static final Object RECURSIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecursive() <em>Recursive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecursive()
	 * @generated
	 * @ordered
	 */
	protected Object recursive = RECURSIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected static final Object REVISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected Object revision = REVISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStickyTag() <em>Sticky Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStickyTag()
	 * @generated
	 * @ordered
	 */
	protected static final Object STICKY_TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStickyTag() <em>Sticky Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStickyTag()
	 * @generated
	 * @ordered
	 */
	protected Object stickyTag = STICKY_TAG_EDEFAULT;

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
	 * The default value of the '{@link #getUsesharpcvslib() <em>Usesharpcvslib</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsesharpcvslib()
	 * @generated
	 * @ordered
	 */
	protected static final Object USESHARPCVSLIB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsesharpcvslib() <em>Usesharpcvslib</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsesharpcvslib()
	 * @generated
	 * @ordered
	 */
	protected Object usesharpcvslib = USESHARPCVSLIB_EDEFAULT;

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
	protected NAntSourceControlTasksUpdateTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntSourceControlTasksUpdateTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntSourceControlTypesCvsFileSet> getFileset() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntSourceControlTasksUpdateTask_Fileset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntSourceControlTasksUpdateTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBuilddirs() {
		return builddirs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuilddirs(Object newBuilddirs) {
		Object oldBuilddirs = builddirs;
		builddirs = newBuilddirs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__BUILDDIRS, oldBuilddirs, builddirs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCommandline() {
		return commandline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandline(Object newCommandline) {
		Object oldCommandline = commandline;
		commandline = newCommandline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMMANDLINE, oldCommandline, commandline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCompressionlevel() {
		return compressionlevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionlevel(Object newCompressionlevel) {
		Object oldCompressionlevel = compressionlevel;
		compressionlevel = newCompressionlevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMPRESSIONLEVEL, oldCompressionlevel, compressionlevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCvsfullpath() {
		return cvsfullpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCvsfullpath(Object newCvsfullpath) {
		Object oldCvsfullpath = cvsfullpath;
		cvsfullpath = newCvsfullpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSFULLPATH, oldCvsfullpath, cvsfullpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCvsroot() {
		return cvsroot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCvsroot(Object newCvsroot) {
		Object oldCvsroot = cvsroot;
		cvsroot = newCvsroot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSROOT, oldCvsroot, cvsroot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCvsrsh() {
		return cvsrsh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCvsrsh(Object newCvsrsh) {
		Object oldCvsrsh = cvsrsh;
		cvsrsh = newCvsrsh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSRSH, oldCvsrsh, cvsrsh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Object newDate) {
		Object oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(Object newDestination) {
		Object oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DESTINATION, oldDestination, destination));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FAILONERROR, oldFailonerror, failonerror));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getModule() {
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(Object newModule) {
		Object oldModule = module;
		module = newModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__MODULE, oldModule, module));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOverwritelocal() {
		return overwritelocal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverwritelocal(Object newOverwritelocal) {
		Object oldOverwritelocal = overwritelocal;
		overwritelocal = newOverwritelocal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__OVERWRITELOCAL, oldOverwritelocal, overwritelocal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPassfile() {
		return passfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassfile(Object newPassfile) {
		Object oldPassfile = passfile;
		passfile = newPassfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSFILE, oldPassfile, passfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(Object newPassword) {
		Object oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPruneempty() {
		return pruneempty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPruneempty(Object newPruneempty) {
		Object oldPruneempty = pruneempty;
		pruneempty = newPruneempty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PRUNEEMPTY, oldPruneempty, pruneempty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getQuiet() {
		return quiet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuiet(Object newQuiet) {
		Object oldQuiet = quiet;
		quiet = newQuiet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__QUIET, oldQuiet, quiet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getReadonly() {
		return readonly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadonly(Object newReadonly) {
		Object oldReadonly = readonly;
		readonly = newReadonly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READONLY, oldReadonly, readonly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getReadwrite() {
		return readwrite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadwrite(Object newReadwrite) {
		Object oldReadwrite = readwrite;
		readwrite = newReadwrite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READWRITE, oldReadwrite, readwrite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getReallyquiet() {
		return reallyquiet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReallyquiet(Object newReallyquiet) {
		Object oldReallyquiet = reallyquiet;
		reallyquiet = newReallyquiet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REALLYQUIET, oldReallyquiet, reallyquiet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRecursive() {
		return recursive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecursive(Object newRecursive) {
		Object oldRecursive = recursive;
		recursive = newRecursive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__RECURSIVE, oldRecursive, recursive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRevision() {
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Object newRevision) {
		Object oldRevision = revision;
		revision = newRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REVISION, oldRevision, revision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getStickyTag() {
		return stickyTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStickyTag(Object newStickyTag) {
		Object oldStickyTag = stickyTag;
		stickyTag = newStickyTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__STICKY_TAG, oldStickyTag, stickyTag));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__TIMEOUT, oldTimeout, timeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__UNLESS, oldUnless, unless));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUsesharpcvslib() {
		return usesharpcvslib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsesharpcvslib(Object newUsesharpcvslib) {
		Object oldUsesharpcvslib = usesharpcvslib;
		usesharpcvslib = newUsesharpcvslib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__USESHARPCVSLIB, oldUsesharpcvslib, usesharpcvslib));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FILESET:
				return ((InternalEList<?>)getFileset()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FILESET:
				return getFileset();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ARG:
				return getArg();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__BUILDDIRS:
				return getBuilddirs();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMMANDLINE:
				return getCommandline();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMPRESSIONLEVEL:
				return getCompressionlevel();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSFULLPATH:
				return getCvsfullpath();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSROOT:
				return getCvsroot();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSRSH:
				return getCvsrsh();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DATE:
				return getDate();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DESTINATION:
				return getDestination();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__IF:
				return getIf();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__MODULE:
				return getModule();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__OVERWRITELOCAL:
				return getOverwritelocal();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSFILE:
				return getPassfile();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSWORD:
				return getPassword();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PRUNEEMPTY:
				return getPruneempty();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__QUIET:
				return getQuiet();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READONLY:
				return getReadonly();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READWRITE:
				return getReadwrite();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REALLYQUIET:
				return getReallyquiet();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__RECURSIVE:
				return getRecursive();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REVISION:
				return getRevision();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__STICKY_TAG:
				return getStickyTag();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__USESHARPCVSLIB:
				return getUsesharpcvslib();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FILESET:
				getFileset().clear();
				getFileset().addAll((Collection<? extends NAntSourceControlTypesCvsFileSet>)newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__BUILDDIRS:
				setBuilddirs(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMMANDLINE:
				setCommandline(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMPRESSIONLEVEL:
				setCompressionlevel(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSFULLPATH:
				setCvsfullpath(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSROOT:
				setCvsroot(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSRSH:
				setCvsrsh(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DATE:
				setDate(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DESTINATION:
				setDestination(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__MODULE:
				setModule(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__OVERWRITELOCAL:
				setOverwritelocal(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSFILE:
				setPassfile(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSWORD:
				setPassword(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PRUNEEMPTY:
				setPruneempty(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__QUIET:
				setQuiet(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READONLY:
				setReadonly(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READWRITE:
				setReadwrite(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REALLYQUIET:
				setReallyquiet(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__RECURSIVE:
				setRecursive(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REVISION:
				setRevision(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__STICKY_TAG:
				setStickyTag(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__USESHARPCVSLIB:
				setUsesharpcvslib(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FILESET:
				getFileset().clear();
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__BUILDDIRS:
				setBuilddirs(BUILDDIRS_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMMANDLINE:
				setCommandline(COMMANDLINE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMPRESSIONLEVEL:
				setCompressionlevel(COMPRESSIONLEVEL_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSFULLPATH:
				setCvsfullpath(CVSFULLPATH_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSROOT:
				setCvsroot(CVSROOT_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSRSH:
				setCvsrsh(CVSRSH_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DESTINATION:
				setDestination(DESTINATION_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__MODULE:
				setModule(MODULE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__OVERWRITELOCAL:
				setOverwritelocal(OVERWRITELOCAL_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSFILE:
				setPassfile(PASSFILE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PRUNEEMPTY:
				setPruneempty(PRUNEEMPTY_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__QUIET:
				setQuiet(QUIET_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READONLY:
				setReadonly(READONLY_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READWRITE:
				setReadwrite(READWRITE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REALLYQUIET:
				setReallyquiet(REALLYQUIET_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__RECURSIVE:
				setRecursive(RECURSIVE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REVISION:
				setRevision(REVISION_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__STICKY_TAG:
				setStickyTag(STICKY_TAG_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__USESHARPCVSLIB:
				setUsesharpcvslib(USESHARPCVSLIB_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FILESET:
				return !getFileset().isEmpty();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__BUILDDIRS:
				return BUILDDIRS_EDEFAULT == null ? builddirs != null : !BUILDDIRS_EDEFAULT.equals(builddirs);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMMANDLINE:
				return COMMANDLINE_EDEFAULT == null ? commandline != null : !COMMANDLINE_EDEFAULT.equals(commandline);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__COMPRESSIONLEVEL:
				return COMPRESSIONLEVEL_EDEFAULT == null ? compressionlevel != null : !COMPRESSIONLEVEL_EDEFAULT.equals(compressionlevel);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSFULLPATH:
				return CVSFULLPATH_EDEFAULT == null ? cvsfullpath != null : !CVSFULLPATH_EDEFAULT.equals(cvsfullpath);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSROOT:
				return CVSROOT_EDEFAULT == null ? cvsroot != null : !CVSROOT_EDEFAULT.equals(cvsroot);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__CVSRSH:
				return CVSRSH_EDEFAULT == null ? cvsrsh != null : !CVSRSH_EDEFAULT.equals(cvsrsh);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__DESTINATION:
				return DESTINATION_EDEFAULT == null ? destination != null : !DESTINATION_EDEFAULT.equals(destination);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__MODULE:
				return MODULE_EDEFAULT == null ? module != null : !MODULE_EDEFAULT.equals(module);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__OVERWRITELOCAL:
				return OVERWRITELOCAL_EDEFAULT == null ? overwritelocal != null : !OVERWRITELOCAL_EDEFAULT.equals(overwritelocal);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSFILE:
				return PASSFILE_EDEFAULT == null ? passfile != null : !PASSFILE_EDEFAULT.equals(passfile);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__PRUNEEMPTY:
				return PRUNEEMPTY_EDEFAULT == null ? pruneempty != null : !PRUNEEMPTY_EDEFAULT.equals(pruneempty);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__QUIET:
				return QUIET_EDEFAULT == null ? quiet != null : !QUIET_EDEFAULT.equals(quiet);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READONLY:
				return READONLY_EDEFAULT == null ? readonly != null : !READONLY_EDEFAULT.equals(readonly);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__READWRITE:
				return READWRITE_EDEFAULT == null ? readwrite != null : !READWRITE_EDEFAULT.equals(readwrite);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REALLYQUIET:
				return REALLYQUIET_EDEFAULT == null ? reallyquiet != null : !REALLYQUIET_EDEFAULT.equals(reallyquiet);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__RECURSIVE:
				return RECURSIVE_EDEFAULT == null ? recursive != null : !RECURSIVE_EDEFAULT.equals(recursive);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__REVISION:
				return REVISION_EDEFAULT == null ? revision != null : !REVISION_EDEFAULT.equals(revision);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__STICKY_TAG:
				return STICKY_TAG_EDEFAULT == null ? stickyTag != null : !STICKY_TAG_EDEFAULT.equals(stickyTag);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__USESHARPCVSLIB:
				return USESHARPCVSLIB_EDEFAULT == null ? usesharpcvslib != null : !USESHARPCVSLIB_EDEFAULT.equals(usesharpcvslib);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_SOURCE_CONTROL_TASKS_UPDATE_TASK__ANY_ATTRIBUTE:
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
		result.append(", builddirs: ");
		result.append(builddirs);
		result.append(", commandline: ");
		result.append(commandline);
		result.append(", compressionlevel: ");
		result.append(compressionlevel);
		result.append(", cvsfullpath: ");
		result.append(cvsfullpath);
		result.append(", cvsroot: ");
		result.append(cvsroot);
		result.append(", cvsrsh: ");
		result.append(cvsrsh);
		result.append(", date: ");
		result.append(date);
		result.append(", destination: ");
		result.append(destination);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", if: ");
		result.append(if_);
		result.append(", module: ");
		result.append(module);
		result.append(", overwritelocal: ");
		result.append(overwritelocal);
		result.append(", passfile: ");
		result.append(passfile);
		result.append(", password: ");
		result.append(password);
		result.append(", pruneempty: ");
		result.append(pruneempty);
		result.append(", quiet: ");
		result.append(quiet);
		result.append(", readonly: ");
		result.append(readonly);
		result.append(", readwrite: ");
		result.append(readwrite);
		result.append(", reallyquiet: ");
		result.append(reallyquiet);
		result.append(", recursive: ");
		result.append(recursive);
		result.append(", revision: ");
		result.append(revision);
		result.append(", stickyTag: ");
		result.append(stickyTag);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", unless: ");
		result.append(unless);
		result.append(", usesharpcvslib: ");
		result.append(usesharpcvslib);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntSourceControlTasksUpdateTaskImpl
