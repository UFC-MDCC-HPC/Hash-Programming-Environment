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
 * A representation of the model object '<em><b>NAnt Win32 Tasks Tlb Imp Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getReferences <em>References</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getAsmversion <em>Asmversion</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getDelaysign <em>Delaysign</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getKeycontainer <em>Keycontainer</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getKeyfile <em>Keyfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getPrimary <em>Primary</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getPublickey <em>Publickey</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getStrictref <em>Strictref</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getSysarray <em>Sysarray</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getTransform <em>Transform</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getTypelib <em>Typelib</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getUnsafe <em>Unsafe</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask()
 * @model extendedMetaData="name='NAnt.Win32.Tasks.TlbImpTask' kind='elementOnly'"
 * @generated
 */
public interface NAntWin32TasksTlbImpTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_References()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='references' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesAssemblyFileSet> getReferences();

	/**
	 * Returns the value of the '<em><b>Arg</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arg</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arg</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Arg()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='arg' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesArgument> getArg();

	/**
	 * Returns the value of the '<em><b>Asmversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asmversion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asmversion</em>' attribute.
	 * @see #setAsmversion(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Asmversion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='asmversion'"
	 * @generated
	 */
	Object getAsmversion();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getAsmversion <em>Asmversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asmversion</em>' attribute.
	 * @see #getAsmversion()
	 * @generated
	 */
	void setAsmversion(Object value);

	/**
	 * Returns the value of the '<em><b>Delaysign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delaysign</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delaysign</em>' attribute.
	 * @see #setDelaysign(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Delaysign()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='delaysign'"
	 * @generated
	 */
	Object getDelaysign();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getDelaysign <em>Delaysign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delaysign</em>' attribute.
	 * @see #getDelaysign()
	 * @generated
	 */
	void setDelaysign(Object value);

	/**
	 * Returns the value of the '<em><b>Failonerror</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failonerror</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failonerror</em>' attribute.
	 * @see #setFailonerror(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getFailonerror <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failonerror</em>' attribute.
	 * @see #getFailonerror()
	 * @generated
	 */
	void setFailonerror(Object value);

	/**
	 * Returns the value of the '<em><b>If</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If</em>' attribute.
	 * @see #setIf(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Keycontainer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keycontainer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keycontainer</em>' attribute.
	 * @see #setKeycontainer(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Keycontainer()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='keycontainer'"
	 * @generated
	 */
	Object getKeycontainer();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getKeycontainer <em>Keycontainer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keycontainer</em>' attribute.
	 * @see #getKeycontainer()
	 * @generated
	 */
	void setKeycontainer(Object value);

	/**
	 * Returns the value of the '<em><b>Keyfile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keyfile</em>' attribute.
	 * @see #setKeyfile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Keyfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='keyfile'"
	 * @generated
	 */
	Object getKeyfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getKeyfile <em>Keyfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keyfile</em>' attribute.
	 * @see #getKeyfile()
	 * @generated
	 */
	void setKeyfile(Object value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Namespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='namespace'"
	 * @generated
	 */
	Object getNamespace();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(Object value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Output()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='output'"
	 * @generated
	 */
	Object getOutput();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Object value);

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary</em>' attribute.
	 * @see #setPrimary(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Primary()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='primary'"
	 * @generated
	 */
	Object getPrimary();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getPrimary <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' attribute.
	 * @see #getPrimary()
	 * @generated
	 */
	void setPrimary(Object value);

	/**
	 * Returns the value of the '<em><b>Publickey</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publickey</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publickey</em>' attribute.
	 * @see #setPublickey(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Publickey()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='publickey'"
	 * @generated
	 */
	Object getPublickey();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getPublickey <em>Publickey</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publickey</em>' attribute.
	 * @see #getPublickey()
	 * @generated
	 */
	void setPublickey(Object value);

	/**
	 * Returns the value of the '<em><b>Strictref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strictref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strictref</em>' attribute.
	 * @see #setStrictref(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Strictref()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='strictref'"
	 * @generated
	 */
	Object getStrictref();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getStrictref <em>Strictref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strictref</em>' attribute.
	 * @see #getStrictref()
	 * @generated
	 */
	void setStrictref(Object value);

	/**
	 * Returns the value of the '<em><b>Sysarray</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sysarray</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sysarray</em>' attribute.
	 * @see #setSysarray(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Sysarray()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='sysarray'"
	 * @generated
	 */
	Object getSysarray();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getSysarray <em>Sysarray</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sysarray</em>' attribute.
	 * @see #getSysarray()
	 * @generated
	 */
	void setSysarray(Object value);

	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='timeout'"
	 * @generated
	 */
	Object getTimeout();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(Object value);

	/**
	 * Returns the value of the '<em><b>Transform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transform</em>' attribute.
	 * @see #setTransform(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Transform()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='transform'"
	 * @generated
	 */
	Object getTransform();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getTransform <em>Transform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transform</em>' attribute.
	 * @see #getTransform()
	 * @generated
	 */
	void setTransform(Object value);

	/**
	 * Returns the value of the '<em><b>Typelib</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typelib</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typelib</em>' attribute.
	 * @see #setTypelib(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Typelib()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='typelib'"
	 * @generated
	 */
	Object getTypelib();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getTypelib <em>Typelib</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typelib</em>' attribute.
	 * @see #getTypelib()
	 * @generated
	 */
	void setTypelib(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getUnless <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unless</em>' attribute.
	 * @see #getUnless()
	 * @generated
	 */
	void setUnless(Object value);

	/**
	 * Returns the value of the '<em><b>Unsafe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsafe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsafe</em>' attribute.
	 * @see #setUnsafe(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Unsafe()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unsafe'"
	 * @generated
	 */
	Object getUnsafe();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getUnsafe <em>Unsafe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsafe</em>' attribute.
	 * @see #getUnsafe()
	 * @generated
	 */
	void setUnsafe(Object value);

	/**
	 * Returns the value of the '<em><b>Verbose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verbose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verbose</em>' attribute.
	 * @see #setVerbose(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntWin32TasksTlbImpTask#getVerbose <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbose</em>' attribute.
	 * @see #getVerbose()
	 * @generated
	 */
	void setVerbose(Object value);

	/**
	 * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Attribute</em>' attribute list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntWin32TasksTlbImpTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':21' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntWin32TasksTlbImpTask
