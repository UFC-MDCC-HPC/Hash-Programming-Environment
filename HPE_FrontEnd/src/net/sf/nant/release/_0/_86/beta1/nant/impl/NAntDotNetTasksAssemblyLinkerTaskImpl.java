/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant.impl;

import java.util.Collection;

import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyLinkerTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet;
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
 * An implementation of the model object '<em><b>NAnt Dot Net Tasks Assembly Linker Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getAlgid <em>Algid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getCulture <em>Culture</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getDelaysign <em>Delaysign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getEvidence <em>Evidence</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getFileversion <em>Fileversion</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getFlags <em>Flags</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getKeycontainer <em>Keycontainer</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getKeyfile <em>Keyfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getMain <em>Main</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getProductversion <em>Productversion</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getTrademark <em>Trademark</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getWin32icon <em>Win32icon</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getWin32res <em>Win32res</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.impl.NAntDotNetTasksAssemblyLinkerTaskImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NAntDotNetTasksAssemblyLinkerTaskImpl extends EObjectImpl implements NAntDotNetTasksAssemblyLinkerTask {
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
	 * The default value of the '{@link #getAlgid() <em>Algid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgid()
	 * @generated
	 * @ordered
	 */
	protected static final Object ALGID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgid() <em>Algid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgid()
	 * @generated
	 * @ordered
	 */
	protected Object algid = ALGID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompany() <em>Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected static final Object COMPANY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompany() <em>Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected Object company = COMPANY_EDEFAULT;

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
	 * The default value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected static final Object COPYRIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected Object copyright = COPYRIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCulture() <em>Culture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCulture()
	 * @generated
	 * @ordered
	 */
	protected static final Object CULTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCulture() <em>Culture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCulture()
	 * @generated
	 * @ordered
	 */
	protected Object culture = CULTURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDelaysign() <em>Delaysign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelaysign()
	 * @generated
	 * @ordered
	 */
	protected static final Object DELAYSIGN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDelaysign() <em>Delaysign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelaysign()
	 * @generated
	 * @ordered
	 */
	protected Object delaysign = DELAYSIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final Object DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected Object description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvidence() <em>Evidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvidence()
	 * @generated
	 * @ordered
	 */
	protected static final Object EVIDENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvidence() <em>Evidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvidence()
	 * @generated
	 * @ordered
	 */
	protected Object evidence = EVIDENCE_EDEFAULT;

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
	 * The default value of the '{@link #getFileversion() <em>Fileversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileversion()
	 * @generated
	 * @ordered
	 */
	protected static final Object FILEVERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileversion() <em>Fileversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileversion()
	 * @generated
	 * @ordered
	 */
	protected Object fileversion = FILEVERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFlags() <em>Flags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlags()
	 * @generated
	 * @ordered
	 */
	protected static final Object FLAGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFlags() <em>Flags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlags()
	 * @generated
	 * @ordered
	 */
	protected Object flags = FLAGS_EDEFAULT;

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
	 * The default value of the '{@link #getKeycontainer() <em>Keycontainer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeycontainer()
	 * @generated
	 * @ordered
	 */
	protected static final Object KEYCONTAINER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeycontainer() <em>Keycontainer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeycontainer()
	 * @generated
	 * @ordered
	 */
	protected Object keycontainer = KEYCONTAINER_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyfile() <em>Keyfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyfile()
	 * @generated
	 * @ordered
	 */
	protected static final Object KEYFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyfile() <em>Keyfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyfile()
	 * @generated
	 * @ordered
	 */
	protected Object keyfile = KEYFILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMain() <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected static final Object MAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMain() <em>Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected Object main = MAIN_EDEFAULT;

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
	 * The default value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected static final Object PRODUCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected Object product = PRODUCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductversion() <em>Productversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductversion()
	 * @generated
	 * @ordered
	 */
	protected static final Object PRODUCTVERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductversion() <em>Productversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductversion()
	 * @generated
	 * @ordered
	 */
	protected Object productversion = PRODUCTVERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final Object TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Object target = TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final Object TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected Object template = TEMPLATE_EDEFAULT;

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
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final Object TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected Object title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrademark() <em>Trademark</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrademark()
	 * @generated
	 * @ordered
	 */
	protected static final Object TRADEMARK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrademark() <em>Trademark</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrademark()
	 * @generated
	 * @ordered
	 */
	protected Object trademark = TRADEMARK_EDEFAULT;

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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final Object VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Object version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWin32icon() <em>Win32icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin32icon()
	 * @generated
	 * @ordered
	 */
	protected static final Object WIN32ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWin32icon() <em>Win32icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin32icon()
	 * @generated
	 * @ordered
	 */
	protected Object win32icon = WIN32ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getWin32res() <em>Win32res</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin32res()
	 * @generated
	 * @ordered
	 */
	protected static final Object WIN32RES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWin32res() <em>Win32res</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWin32res()
	 * @generated
	 * @ordered
	 */
	protected Object win32res = WIN32RES_EDEFAULT;

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
	protected NAntDotNetTasksAssemblyLinkerTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyLinkerTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntDotNetTypesModuleSet> getModules() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyLinkerTask_Modules());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesFileSet> getSources() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyLinkerTask_Sources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NAntCoreTypesArgument> getArg() {
		return getGroup().list(NantPackage.eINSTANCE.getNAntDotNetTasksAssemblyLinkerTask_Arg());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAlgid() {
		return algid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgid(Object newAlgid) {
		Object oldAlgid = algid;
		algid = newAlgid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ALGID, oldAlgid, algid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCompany() {
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompany(Object newCompany) {
		Object oldCompany = company;
		company = newCompany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COMPANY, oldCompany, company));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CONFIGURATION, oldConfiguration, configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopyright(Object newCopyright) {
		Object oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COPYRIGHT, oldCopyright, copyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getCulture() {
		return culture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCulture(Object newCulture) {
		Object oldCulture = culture;
		culture = newCulture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CULTURE, oldCulture, culture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDelaysign() {
		return delaysign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelaysign(Object newDelaysign) {
		Object oldDelaysign = delaysign;
		delaysign = newDelaysign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DELAYSIGN, oldDelaysign, delaysign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(Object newDescription) {
		Object oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEvidence() {
		return evidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvidence(Object newEvidence) {
		Object oldEvidence = evidence;
		evidence = newEvidence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__EVIDENCE, oldEvidence, evidence));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FAILONERROR, oldFailonerror, failonerror));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFileversion() {
		return fileversion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileversion(Object newFileversion) {
		Object oldFileversion = fileversion;
		fileversion = newFileversion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FILEVERSION, oldFileversion, fileversion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFlags() {
		return flags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlags(Object newFlags) {
		Object oldFlags = flags;
		flags = newFlags;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FLAGS, oldFlags, flags));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__IF, oldIf, if_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getKeycontainer() {
		return keycontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeycontainer(Object newKeycontainer) {
		Object oldKeycontainer = keycontainer;
		keycontainer = newKeycontainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYCONTAINER, oldKeycontainer, keycontainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getKeyfile() {
		return keyfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyfile(Object newKeyfile) {
		Object oldKeyfile = keyfile;
		keyfile = newKeyfile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYFILE, oldKeyfile, keyfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMain() {
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMain(Object newMain) {
		Object oldMain = main;
		main = newMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MAIN, oldMain, main));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__OUTPUT, oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(Object newProduct) {
		Object oldProduct = product;
		product = newProduct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCT, oldProduct, product));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getProductversion() {
		return productversion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductversion(Object newProductversion) {
		Object oldProductversion = productversion;
		productversion = newProductversion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCTVERSION, oldProductversion, productversion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Object newTarget) {
		Object oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(Object newTemplate) {
		Object oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TEMPLATE, oldTemplate, template));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(Object newTitle) {
		Object oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTrademark() {
		return trademark;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrademark(Object newTrademark) {
		Object oldTrademark = trademark;
		trademark = newTrademark;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TRADEMARK, oldTrademark, trademark));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__UNLESS, oldUnless, unless));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERBOSE, oldVerbose, verbose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Object newVersion) {
		Object oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWin32icon() {
		return win32icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWin32icon(Object newWin32icon) {
		Object oldWin32icon = win32icon;
		win32icon = newWin32icon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32ICON, oldWin32icon, win32icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWin32res() {
		return win32res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWin32res(Object newWin32res) {
		Object oldWin32res = win32res;
		win32res = newWin32res;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32RES, oldWin32res, win32res));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ANY_ATTRIBUTE);
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ARG:
				return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MODULES:
				return getModules();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__SOURCES:
				return getSources();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ARG:
				return getArg();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ALGID:
				return getAlgid();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COMPANY:
				return getCompany();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CONFIGURATION:
				return getConfiguration();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COPYRIGHT:
				return getCopyright();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CULTURE:
				return getCulture();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DELAYSIGN:
				return getDelaysign();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DESCRIPTION:
				return getDescription();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__EVIDENCE:
				return getEvidence();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FAILONERROR:
				return getFailonerror();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FILEVERSION:
				return getFileversion();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FLAGS:
				return getFlags();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__IF:
				return getIf();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYCONTAINER:
				return getKeycontainer();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYFILE:
				return getKeyfile();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MAIN:
				return getMain();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__OUTPUT:
				return getOutput();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCT:
				return getProduct();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCTVERSION:
				return getProductversion();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TARGET:
				return getTarget();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TEMPLATE:
				return getTemplate();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TIMEOUT:
				return getTimeout();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TITLE:
				return getTitle();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TRADEMARK:
				return getTrademark();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__UNLESS:
				return getUnless();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERBOSE:
				return getVerbose();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERSION:
				return getVersion();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32ICON:
				return getWin32icon();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32RES:
				return getWin32res();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends NAntDotNetTypesModuleSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends NAntCoreTypesFileSet>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ARG:
				getArg().clear();
				getArg().addAll((Collection<? extends NAntCoreTypesArgument>)newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ALGID:
				setAlgid(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COMPANY:
				setCompany(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CONFIGURATION:
				setConfiguration(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COPYRIGHT:
				setCopyright(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CULTURE:
				setCulture(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DELAYSIGN:
				setDelaysign(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DESCRIPTION:
				setDescription(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__EVIDENCE:
				setEvidence(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FAILONERROR:
				setFailonerror(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FILEVERSION:
				setFileversion(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FLAGS:
				setFlags(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__IF:
				setIf(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYCONTAINER:
				setKeycontainer(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYFILE:
				setKeyfile(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MAIN:
				setMain(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__OUTPUT:
				setOutput(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCT:
				setProduct(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCTVERSION:
				setProductversion(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TARGET:
				setTarget(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TEMPLATE:
				setTemplate(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TIMEOUT:
				setTimeout(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TITLE:
				setTitle(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TRADEMARK:
				setTrademark(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__UNLESS:
				setUnless(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERBOSE:
				setVerbose(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERSION:
				setVersion(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32ICON:
				setWin32icon(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32RES:
				setWin32res(newValue);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__GROUP:
				getGroup().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MODULES:
				getModules().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__SOURCES:
				getSources().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ARG:
				getArg().clear();
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ALGID:
				setAlgid(ALGID_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COMPANY:
				setCompany(COMPANY_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CONFIGURATION:
				setConfiguration(CONFIGURATION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COPYRIGHT:
				setCopyright(COPYRIGHT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CULTURE:
				setCulture(CULTURE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DELAYSIGN:
				setDelaysign(DELAYSIGN_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__EVIDENCE:
				setEvidence(EVIDENCE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FAILONERROR:
				setFailonerror(FAILONERROR_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FILEVERSION:
				setFileversion(FILEVERSION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FLAGS:
				setFlags(FLAGS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__IF:
				setIf(IF_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYCONTAINER:
				setKeycontainer(KEYCONTAINER_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYFILE:
				setKeyfile(KEYFILE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MAIN:
				setMain(MAIN_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCTVERSION:
				setProductversion(PRODUCTVERSION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TEMPLATE:
				setTemplate(TEMPLATE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TRADEMARK:
				setTrademark(TRADEMARK_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__UNLESS:
				setUnless(UNLESS_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERBOSE:
				setVerbose(VERBOSE_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32ICON:
				setWin32icon(WIN32ICON_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32RES:
				setWin32res(WIN32RES_EDEFAULT);
				return;
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ANY_ATTRIBUTE:
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
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__GROUP:
				return group != null && !group.isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MODULES:
				return !getModules().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__SOURCES:
				return !getSources().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ARG:
				return !getArg().isEmpty();
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ALGID:
				return ALGID_EDEFAULT == null ? algid != null : !ALGID_EDEFAULT.equals(algid);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COMPANY:
				return COMPANY_EDEFAULT == null ? company != null : !COMPANY_EDEFAULT.equals(company);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CONFIGURATION:
				return CONFIGURATION_EDEFAULT == null ? configuration != null : !CONFIGURATION_EDEFAULT.equals(configuration);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__COPYRIGHT:
				return COPYRIGHT_EDEFAULT == null ? copyright != null : !COPYRIGHT_EDEFAULT.equals(copyright);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__CULTURE:
				return CULTURE_EDEFAULT == null ? culture != null : !CULTURE_EDEFAULT.equals(culture);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DELAYSIGN:
				return DELAYSIGN_EDEFAULT == null ? delaysign != null : !DELAYSIGN_EDEFAULT.equals(delaysign);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__EVIDENCE:
				return EVIDENCE_EDEFAULT == null ? evidence != null : !EVIDENCE_EDEFAULT.equals(evidence);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FAILONERROR:
				return FAILONERROR_EDEFAULT == null ? failonerror != null : !FAILONERROR_EDEFAULT.equals(failonerror);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FILEVERSION:
				return FILEVERSION_EDEFAULT == null ? fileversion != null : !FILEVERSION_EDEFAULT.equals(fileversion);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__FLAGS:
				return FLAGS_EDEFAULT == null ? flags != null : !FLAGS_EDEFAULT.equals(flags);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__IF:
				return IF_EDEFAULT == null ? if_ != null : !IF_EDEFAULT.equals(if_);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYCONTAINER:
				return KEYCONTAINER_EDEFAULT == null ? keycontainer != null : !KEYCONTAINER_EDEFAULT.equals(keycontainer);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__KEYFILE:
				return KEYFILE_EDEFAULT == null ? keyfile != null : !KEYFILE_EDEFAULT.equals(keyfile);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__MAIN:
				return MAIN_EDEFAULT == null ? main != null : !MAIN_EDEFAULT.equals(main);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__PRODUCTVERSION:
				return PRODUCTVERSION_EDEFAULT == null ? productversion != null : !PRODUCTVERSION_EDEFAULT.equals(productversion);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TEMPLATE:
				return TEMPLATE_EDEFAULT == null ? template != null : !TEMPLATE_EDEFAULT.equals(template);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__TRADEMARK:
				return TRADEMARK_EDEFAULT == null ? trademark != null : !TRADEMARK_EDEFAULT.equals(trademark);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__UNLESS:
				return UNLESS_EDEFAULT == null ? unless != null : !UNLESS_EDEFAULT.equals(unless);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERBOSE:
				return VERBOSE_EDEFAULT == null ? verbose != null : !VERBOSE_EDEFAULT.equals(verbose);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32ICON:
				return WIN32ICON_EDEFAULT == null ? win32icon != null : !WIN32ICON_EDEFAULT.equals(win32icon);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__WIN32RES:
				return WIN32RES_EDEFAULT == null ? win32res != null : !WIN32RES_EDEFAULT.equals(win32res);
			case NantPackage.NANT_DOT_NET_TASKS_ASSEMBLY_LINKER_TASK__ANY_ATTRIBUTE:
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
		result.append(", algid: ");
		result.append(algid);
		result.append(", company: ");
		result.append(company);
		result.append(", configuration: ");
		result.append(configuration);
		result.append(", copyright: ");
		result.append(copyright);
		result.append(", culture: ");
		result.append(culture);
		result.append(", delaysign: ");
		result.append(delaysign);
		result.append(", description: ");
		result.append(description);
		result.append(", evidence: ");
		result.append(evidence);
		result.append(", failonerror: ");
		result.append(failonerror);
		result.append(", fileversion: ");
		result.append(fileversion);
		result.append(", flags: ");
		result.append(flags);
		result.append(", if: ");
		result.append(if_);
		result.append(", keycontainer: ");
		result.append(keycontainer);
		result.append(", keyfile: ");
		result.append(keyfile);
		result.append(", main: ");
		result.append(main);
		result.append(", output: ");
		result.append(output);
		result.append(", product: ");
		result.append(product);
		result.append(", productversion: ");
		result.append(productversion);
		result.append(", target: ");
		result.append(target);
		result.append(", template: ");
		result.append(template);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", title: ");
		result.append(title);
		result.append(", trademark: ");
		result.append(trademark);
		result.append(", unless: ");
		result.append(unless);
		result.append(", verbose: ");
		result.append(verbose);
		result.append(", version: ");
		result.append(version);
		result.append(", win32icon: ");
		result.append(win32icon);
		result.append(", win32res: ");
		result.append(win32res);
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //NAntDotNetTasksAssemblyLinkerTaskImpl
