/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.nant.release._0._86.beta1.nant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getAsminfo <em>Asminfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getAl <em>Al</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCsc <em>Csc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getDelaySign <em>Delay Sign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getIlasm <em>Ilasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getJsc <em>Jsc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getLicense <em>License</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getNdoc <em>Ndoc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getRegsvcs <em>Regsvcs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getResgen <em>Resgen</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getScript <em>Script</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getVbc <em>Vbc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getVjc <em>Vjc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getGunzip <em>Gunzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTar <em>Tar</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getUnzip <em>Unzip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getZip <em>Zip</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getNunit <em>Nunit</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getNunit2 <em>Nunit2</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsChangelog <em>Cvs Changelog</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsCheckout <em>Cvs Checkout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsPass <em>Cvs Pass</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvs <em>Cvs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsExport <em>Cvs Export</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsRtag <em>Cvs Rtag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsTag <em>Cvs Tag</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsUpdate <em>Cvs Update</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getAximp <em>Aximp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getReadregistry <em>Readregistry</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getRegasm <em>Regasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTlbexp <em>Tlbexp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTlbimp <em>Tlbimp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCl <em>Cl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getLib <em>Lib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getLink <em>Link</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getMc <em>Mc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getMidl <em>Midl</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getRc <em>Rc</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getSolution <em>Solution</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTesttask <em>Testtask</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getElementTest1 <em>Element Test1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTest <em>Test</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getAttrib <em>Attrib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getAvailable <em>Available</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCall <em>Call</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCopy <em>Copy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getDelete <em>Delete</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getDescription <em>Description</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getEcho <em>Echo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getExec <em>Exec</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getFail <em>Fail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getGet <em>Get</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getIfnot <em>Ifnot</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getInclude <em>Include</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getLoadfile <em>Loadfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getLoadtasks <em>Loadtasks</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getForeach <em>Foreach</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getMail <em>Mail</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getMkdir <em>Mkdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getMove <em>Move</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getNantschema <em>Nantschema</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getNant <em>Nant</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getProperty <em>Property</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getRegex <em>Regex</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getSetenv <em>Setenv</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getSleep <em>Sleep</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getStyle <em>Style</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getSysinfo <em>Sysinfo</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTstamp <em>Tstamp</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTouch <em>Touch</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getUptodate <em>Uptodate</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getXmlpeek <em>Xmlpeek</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getXmlpoke <em>Xmlpoke</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getIldasm <em>Ildasm</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getServicecontroller <em>Servicecontroller</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getAssemblyfileset <em>Assemblyfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getModuleset <em>Moduleset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getNamespaceimports <em>Namespaceimports</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getResourcefileset <em>Resourcefileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getWarnaserror <em>Warnaserror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getTarfileset <em>Tarfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getZipfileset <em>Zipfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCategories <em>Categories</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCvsfileset <em>Cvsfileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getFilterchain <em>Filterchain</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getCredential <em>Credential</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getDirset <em>Dirset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getPath <em>Path</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getPatternset <em>Patternset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getProxy <em>Proxy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getAny <em>Any</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getDepends <em>Depends</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getIf1 <em>If1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.Target#getUnless <em>Unless</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget()
 * @model extendedMetaData="name='Target' kind='elementOnly'"
 * @generated
 */
public interface Target extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Asminfo</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyInfoTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asminfo</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asminfo</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Asminfo()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='asminfo' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksAssemblyInfoTask> getAsminfo();

	/**
	 * Returns the value of the '<em><b>Al</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksAssemblyLinkerTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Al</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Al</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Al()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='al' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksAssemblyLinkerTask> getAl();

	/**
	 * Returns the value of the '<em><b>Csc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksCscTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Csc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Csc</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Csc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='csc' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksCscTask> getCsc();

	/**
	 * Returns the value of the '<em><b>Delay Sign</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksDelaySignTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay Sign</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay Sign</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_DelaySign()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='delay-sign' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksDelaySignTask> getDelaySign();

	/**
	 * Returns the value of the '<em><b>Ilasm</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ilasm</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ilasm</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Ilasm()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ilasm' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksIlasmTask> getIlasm();

	/**
	 * Returns the value of the '<em><b>Jsc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksJscTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jsc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jsc</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Jsc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='jsc' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksJscTask> getJsc();

	/**
	 * Returns the value of the '<em><b>License</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_License()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='license' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksLicenseTask> getLicense();

	/**
	 * Returns the value of the '<em><b>Ndoc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksNDocTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ndoc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ndoc</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Ndoc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ndoc' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksNDocTask> getNdoc();

	/**
	 * Returns the value of the '<em><b>Regsvcs</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksRegsvcsTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regsvcs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regsvcs</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Regsvcs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='regsvcs' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksRegsvcsTask> getRegsvcs();

	/**
	 * Returns the value of the '<em><b>Resgen</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksResGenTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resgen</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resgen</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Resgen()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resgen' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksResGenTask> getResgen();

	/**
	 * Returns the value of the '<em><b>Script</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksScriptTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Script()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='script' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksScriptTask> getScript();

	/**
	 * Returns the value of the '<em><b>Vbc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVbcTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vbc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vbc</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Vbc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='vbc' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksVbcTask> getVbc();

	/**
	 * Returns the value of the '<em><b>Vjc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksVjcTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vjc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vjc</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Vjc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='vjc' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTasksVjcTask> getVjc();

	/**
	 * Returns the value of the '<em><b>Gunzip</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksGUnzip}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gunzip</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gunzip</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Gunzip()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='gunzip' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCompressionTasksGUnzip> getGunzip();

	/**
	 * Returns the value of the '<em><b>Tar</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksTarTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tar</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tar</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Tar()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tar' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCompressionTasksTarTask> getTar();

	/**
	 * Returns the value of the '<em><b>Unzip</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksUnZipTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unzip</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unzip</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Unzip()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unzip' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCompressionTasksUnZipTask> getUnzip();

	/**
	 * Returns the value of the '<em><b>Zip</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zip</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zip</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Zip()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='zip' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCompressionTasksZipTask> getZip();

	/**
	 * Returns the value of the '<em><b>Nunit</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit1TasksNUnitTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nunit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nunit</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Nunit()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='nunit' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntNUnit1TasksNUnitTask> getNunit();

	/**
	 * Returns the value of the '<em><b>Nunit2</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TasksNUnit2Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nunit2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nunit2</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Nunit2()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='nunit2' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntNUnit2TasksNUnit2Task> getNunit2();

	/**
	 * Returns the value of the '<em><b>Cvs Changelog</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs Changelog</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs Changelog</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_CvsChangelog()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs-changelog' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksChangeLogTask> getCvsChangelog();

	/**
	 * Returns the value of the '<em><b>Cvs Checkout</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCheckoutTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs Checkout</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs Checkout</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_CvsCheckout()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs-checkout' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksCheckoutTask> getCvsCheckout();

	/**
	 * Returns the value of the '<em><b>Cvs Pass</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsPass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs Pass</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs Pass</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_CvsPass()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs-pass' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksCvsPass> getCvsPass();

	/**
	 * Returns the value of the '<em><b>Cvs</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksCvsTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Cvs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksCvsTask> getCvs();

	/**
	 * Returns the value of the '<em><b>Cvs Export</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksExportTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs Export</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs Export</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_CvsExport()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs-export' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksExportTask> getCvsExport();

	/**
	 * Returns the value of the '<em><b>Cvs Rtag</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksRTagTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs Rtag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs Rtag</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_CvsRtag()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs-rtag' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksRTagTask> getCvsRtag();

	/**
	 * Returns the value of the '<em><b>Cvs Tag</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksTagTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs Tag</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_CvsTag()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs-tag' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksTagTask> getCvsTag();

	/**
	 * Returns the value of the '<em><b>Cvs Update</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksUpdateTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvs Update</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvs Update</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_CvsUpdate()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvs-update' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTasksUpdateTask> getCvsUpdate();

	/**
	 * Returns the value of the '<em><b>Aximp</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksAxImpTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aximp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aximp</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Aximp()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='aximp' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntWin32TasksAxImpTask> getAximp();

	/**
	 * Returns the value of the '<em><b>Readregistry</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksReadRegistryTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Readregistry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Readregistry</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Readregistry()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='readregistry' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntWin32TasksReadRegistryTask> getReadregistry();

	/**
	 * Returns the value of the '<em><b>Regasm</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksRegAsmTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regasm</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regasm</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Regasm()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='regasm' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntWin32TasksRegAsmTask> getRegasm();

	/**
	 * Returns the value of the '<em><b>Tlbexp</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbExpTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tlbexp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tlbexp</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Tlbexp()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tlbexp' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntWin32TasksTlbExpTask> getTlbexp();

	/**
	 * Returns the value of the '<em><b>Tlbimp</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tlbimp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tlbimp</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Tlbimp()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tlbimp' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntWin32TasksTlbImpTask> getTlbimp();

	/**
	 * Returns the value of the '<em><b>Cl</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksClTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cl</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cl</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Cl()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cl' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVisualCppTasksClTask> getCl();

	/**
	 * Returns the value of the '<em><b>Lib</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lib</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lib</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Lib()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='lib' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVisualCppTasksLibTask> getLib();

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLinkTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Link()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVisualCppTasksLinkTask> getLink();

	/**
	 * Returns the value of the '<em><b>Mc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mc</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Mc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='mc' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVisualCppTasksMcTask> getMc();

	/**
	 * Returns the value of the '<em><b>Midl</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Midl</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Midl</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Midl()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='midl' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVisualCppTasksMidlTask> getMidl();

	/**
	 * Returns the value of the '<em><b>Rc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksRcTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rc</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Rc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='rc' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVisualCppTasksRcTask> getRc();

	/**
	 * Returns the value of the '<em><b>Solution</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Solution()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='solution' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVSNetTasksSolutionTask> getSolution();

	/**
	 * Returns the value of the '<em><b>Testtask</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreUtilXmlLoggerTestTestTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testtask</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testtask</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Testtask()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='testtask' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<TestsNAntCoreUtilXmlLoggerTestTestTask> getTesttask();

	/**
	 * Returns the value of the '<em><b>Element Test1</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreElementTest1Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Test1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Test1</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_ElementTest1()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='elementTest1' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<TestsNAntCoreElementTest1Task> getElementTest1();

	/**
	 * Returns the value of the '<em><b>Test</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.TestsNAntCoreTestTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Test()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='test' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<TestsNAntCoreTestTask> getTest();

	/**
	 * Returns the value of the '<em><b>Attrib</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAttribTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attrib</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attrib</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Attrib()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='attrib' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksAttribTask> getAttrib();

	/**
	 * Returns the value of the '<em><b>Available</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksAvailableTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Available()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='available' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksAvailableTask> getAvailable();

	/**
	 * Returns the value of the '<em><b>Call</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCallTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Call()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='call' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksCallTask> getCall();

	/**
	 * Returns the value of the '<em><b>Copy</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksCopyTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Copy()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='copy' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksCopyTask> getCopy();

	/**
	 * Returns the value of the '<em><b>Delete</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDeleteTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Delete()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='delete' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksDeleteTask> getDelete();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksDescriptionTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Description()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='description' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksDescriptionTask> getDescription();

	/**
	 * Returns the value of the '<em><b>Echo</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksEchoTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Echo</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Echo</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Echo()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='echo' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksEchoTask> getEcho();

	/**
	 * Returns the value of the '<em><b>Exec</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksExecTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exec</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exec</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Exec()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='exec' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksExecTask> getExec();

	/**
	 * Returns the value of the '<em><b>Fail</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksFailTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fail</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fail</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Fail()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='fail' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksFailTask> getFail();

	/**
	 * Returns the value of the '<em><b>Get</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksGetTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Get</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Get()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='get' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksGetTask> getGet();

	/**
	 * Returns the value of the '<em><b>If</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_If()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='if' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksIfTask> getIf();

	/**
	 * Returns the value of the '<em><b>Ifnot</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfNotTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifnot</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifnot</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Ifnot()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ifnot' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksIfNotTask> getIfnot();

	/**
	 * Returns the value of the '<em><b>Include</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIncludeTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Include()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='include' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksIncludeTask> getInclude();

	/**
	 * Returns the value of the '<em><b>Loadfile</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadFileTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loadfile</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loadfile</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Loadfile()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='loadfile' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksLoadFileTask> getLoadfile();

	/**
	 * Returns the value of the '<em><b>Loadtasks</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoadTasksTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loadtasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loadtasks</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Loadtasks()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='loadtasks' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksLoadTasksTask> getLoadtasks();

	/**
	 * Returns the value of the '<em><b>Foreach</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksLoopTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreach</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreach</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Foreach()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='foreach' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksLoopTask> getForeach();

	/**
	 * Returns the value of the '<em><b>Mail</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMailTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mail</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mail</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Mail()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='mail' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksMailTask> getMail();

	/**
	 * Returns the value of the '<em><b>Mkdir</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMkDirTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mkdir</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mkdir</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Mkdir()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='mkdir' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksMkDirTask> getMkdir();

	/**
	 * Returns the value of the '<em><b>Move</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMoveTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Move</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Move</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Move()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='move' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksMoveTask> getMove();

	/**
	 * Returns the value of the '<em><b>Nantschema</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntSchemaTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nantschema</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nantschema</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Nantschema()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='nantschema' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksNAntSchemaTask> getNantschema();

	/**
	 * Returns the value of the '<em><b>Nant</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksNAntTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nant</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nant</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Nant()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='nant' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksNAntTask> getNant();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksPropertyTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Property()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksPropertyTask> getProperty();

	/**
	 * Returns the value of the '<em><b>Regex</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksRegexTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Regex()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='regex' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksRegexTask> getRegex();

	/**
	 * Returns the value of the '<em><b>Setenv</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSetEnvTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setenv</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setenv</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Setenv()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='setenv' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksSetEnvTask> getSetenv();

	/**
	 * Returns the value of the '<em><b>Sleep</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSleepTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sleep</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sleep</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Sleep()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='sleep' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksSleepTask> getSleep();

	/**
	 * Returns the value of the '<em><b>Style</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Style()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='style' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksStyleTask> getStyle();

	/**
	 * Returns the value of the '<em><b>Sysinfo</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksSysInfoTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sysinfo</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sysinfo</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Sysinfo()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='sysinfo' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksSysInfoTask> getSysinfo();

	/**
	 * Returns the value of the '<em><b>Tstamp</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTStampTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tstamp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tstamp</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Tstamp()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tstamp' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksTStampTask> getTstamp();

	/**
	 * Returns the value of the '<em><b>Touch</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksTouchTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Touch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Touch</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Touch()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='touch' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksTouchTask> getTouch();

	/**
	 * Returns the value of the '<em><b>Uptodate</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksUpToDateTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uptodate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uptodate</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Uptodate()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='uptodate' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksUpToDateTask> getUptodate();

	/**
	 * Returns the value of the '<em><b>Xmlpeek</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPeekTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmlpeek</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmlpeek</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Xmlpeek()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='xmlpeek' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksXmlPeekTask> getXmlpeek();

	/**
	 * Returns the value of the '<em><b>Xmlpoke</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksXmlPokeTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmlpoke</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmlpoke</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Xmlpoke()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='xmlpoke' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTasksXmlPokeTask> getXmlpoke();

	/**
	 * Returns the value of the '<em><b>Ildasm</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksIldasmTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ildasm</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ildasm</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Ildasm()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ildasm' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntMSNetTasksIldasmTask> getIldasm();

	/**
	 * Returns the value of the '<em><b>Servicecontroller</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntMSNetTasksServiceControllerTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servicecontroller</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servicecontroller</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Servicecontroller()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='servicecontroller' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntMSNetTasksServiceControllerTask> getServicecontroller();

	/**
	 * Returns the value of the '<em><b>Assemblyfileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assemblyfileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assemblyfileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Assemblyfileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='assemblyfileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesAssemblyFileSet> getAssemblyfileset();

	/**
	 * Returns the value of the '<em><b>Moduleset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moduleset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moduleset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Moduleset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='moduleset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesModuleSet> getModuleset();

	/**
	 * Returns the value of the '<em><b>Namespaceimports</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesNamespaceImportCollection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespaceimports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespaceimports</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Namespaceimports()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='namespaceimports' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesNamespaceImportCollection> getNamespaceimports();

	/**
	 * Returns the value of the '<em><b>Resourcefileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resourcefileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resourcefileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Resourcefileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='resourcefileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesResourceFileSet> getResourcefileset();

	/**
	 * Returns the value of the '<em><b>Warnaserror</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesWarningAsError}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warnaserror</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warnaserror</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Warnaserror()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='warnaserror' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesWarningAsError> getWarnaserror();

	/**
	 * Returns the value of the '<em><b>Tarfileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesTarFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tarfileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tarfileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Tarfileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='tarfileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCompressionTypesTarFileSet> getTarfileset();

	/**
	 * Returns the value of the '<em><b>Zipfileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesZipFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zipfileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zipfileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Zipfileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='zipfileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCompressionTypesZipFileSet> getZipfileset();

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategories}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Categories()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='categories' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntNUnit2TypesCategories> getCategories();

	/**
	 * Returns the value of the '<em><b>Cvsfileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTypesCvsFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvsfileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvsfileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Cvsfileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='cvsfileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTypesCvsFileSet> getCvsfileset();

	/**
	 * Returns the value of the '<em><b>Filterchain</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreFiltersFilterChain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filterchain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filterchain</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Filterchain()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='filterchain' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreFiltersFilterChain> getFilterchain();

	/**
	 * Returns the value of the '<em><b>Credential</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesCredential}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Credential</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Credential</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Credential()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='credential' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesCredential> getCredential();

	/**
	 * Returns the value of the '<em><b>Fileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Fileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='fileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getFileset();

	/**
	 * Returns the value of the '<em><b>Dirset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesDirSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dirset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dirset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Dirset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='dirset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesDirSet> getDirset();

	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Path()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='path' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesPathSet> getPath();

	/**
	 * Returns the value of the '<em><b>Patternset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPatternSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Patternset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patternset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Patternset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='patternset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesPatternSet> getPatternset();

	/**
	 * Returns the value of the '<em><b>Proxy</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesProxy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Proxy()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='proxy' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesProxy> getProxy();

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':93' processing='strict' group='#group:0'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Depends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends</em>' attribute.
	 * @see #setDepends(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Depends()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='depends'"
	 * @generated
	 */
	Object getDepends();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.Target#getDepends <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depends</em>' attribute.
	 * @see #getDepends()
	 * @generated
	 */
	void setDepends(Object value);

	/**
	 * Returns the value of the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description1</em>' attribute.
	 * @see #setDescription1(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Description1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	Object getDescription1();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.Target#getDescription1 <em>Description1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description1</em>' attribute.
	 * @see #getDescription1()
	 * @generated
	 */
	void setDescription1(Object value);

	/**
	 * Returns the value of the '<em><b>If1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If1</em>' attribute.
	 * @see #setIf1(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_If1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf1();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.Target#getIf1 <em>If1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If1</em>' attribute.
	 * @see #getIf1()
	 * @generated
	 */
	void setIf1(Object value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	Object getName();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.Target#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Object value);

	/**
	 * Returns the value of the '<em><b>Unless</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unless</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unless</em>' attribute.
	 * @see #setUnless(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getTarget_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.Target#getUnless <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unless</em>' attribute.
	 * @see #getUnless()
	 * @generated
	 */
	void setUnless(Object value);

} // Target
