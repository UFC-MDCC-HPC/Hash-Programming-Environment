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
 * A representation of the model object '<em><b>NAnt Visual Cpp Tasks Midl Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getOptions <em>Options</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getDefines <em>Defines</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getUndefines <em>Undefines</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getIncludedirs <em>Includedirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getAcf <em>Acf</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getAlign <em>Align</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getAppConfig <em>App Config</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getChar <em>Char</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getClient <em>Client</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getCstub <em>Cstub</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getDlldata <em>Dlldata</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getEnv <em>Env</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getFilename <em>Filename</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getHeader <em>Header</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getIid <em>Iid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getOi <em>Oi</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getProxy <em>Proxy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getTlb <em>Tlb</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask()
 * @model extendedMetaData="name='NAnt.VisualCpp.Tasks.MidlTask' kind='elementOnly'"
 * @generated
 */
public interface NAntVisualCppTasksMidlTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.OptionsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Options()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='options' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<OptionsType> getOptions();

	/**
	 * Returns the value of the '<em><b>Defines</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.DefinesType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Defines()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='defines' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<DefinesType1> getDefines();

	/**
	 * Returns the value of the '<em><b>Undefines</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.UndefinesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Undefines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Undefines</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Undefines()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='undefines' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UndefinesType> getUndefines();

	/**
	 * Returns the value of the '<em><b>Includedirs</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includedirs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includedirs</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Includedirs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='includedirs' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getIncludedirs();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Arg()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='arg' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesArgument> getArg();

	/**
	 * Returns the value of the '<em><b>Acf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acf</em>' attribute.
	 * @see #setAcf(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Acf()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='acf'"
	 * @generated
	 */
	Object getAcf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getAcf <em>Acf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acf</em>' attribute.
	 * @see #getAcf()
	 * @generated
	 */
	void setAcf(Object value);

	/**
	 * Returns the value of the '<em><b>Align</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Align</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Align</em>' attribute.
	 * @see #setAlign(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Align()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='align'"
	 * @generated
	 */
	Object getAlign();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getAlign <em>Align</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Align</em>' attribute.
	 * @see #getAlign()
	 * @generated
	 */
	void setAlign(Object value);

	/**
	 * Returns the value of the '<em><b>App Config</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>App Config</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>App Config</em>' attribute.
	 * @see #setAppConfig(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_AppConfig()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='app_config'"
	 * @generated
	 */
	Object getAppConfig();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getAppConfig <em>App Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>App Config</em>' attribute.
	 * @see #getAppConfig()
	 * @generated
	 */
	void setAppConfig(Object value);

	/**
	 * Returns the value of the '<em><b>Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Char</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Char</em>' attribute.
	 * @see #setChar(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Char()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='char'"
	 * @generated
	 */
	Object getChar();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getChar <em>Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Char</em>' attribute.
	 * @see #getChar()
	 * @generated
	 */
	void setChar(Object value);

	/**
	 * Returns the value of the '<em><b>Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client</em>' attribute.
	 * @see #setClient(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Client()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='client'"
	 * @generated
	 */
	Object getClient();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getClient <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client</em>' attribute.
	 * @see #getClient()
	 * @generated
	 */
	void setClient(Object value);

	/**
	 * Returns the value of the '<em><b>Cstub</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cstub</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cstub</em>' attribute.
	 * @see #setCstub(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Cstub()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='cstub'"
	 * @generated
	 */
	Object getCstub();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getCstub <em>Cstub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cstub</em>' attribute.
	 * @see #getCstub()
	 * @generated
	 */
	void setCstub(Object value);

	/**
	 * Returns the value of the '<em><b>Dlldata</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dlldata</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dlldata</em>' attribute.
	 * @see #setDlldata(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Dlldata()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='dlldata'"
	 * @generated
	 */
	Object getDlldata();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getDlldata <em>Dlldata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dlldata</em>' attribute.
	 * @see #getDlldata()
	 * @generated
	 */
	void setDlldata(Object value);

	/**
	 * Returns the value of the '<em><b>Env</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env</em>' attribute.
	 * @see #setEnv(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Env()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='env'"
	 * @generated
	 */
	Object getEnv();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getEnv <em>Env</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Env</em>' attribute.
	 * @see #getEnv()
	 * @generated
	 */
	void setEnv(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getFailonerror <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failonerror</em>' attribute.
	 * @see #getFailonerror()
	 * @generated
	 */
	void setFailonerror(Object value);

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Filename()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='filename'"
	 * @generated
	 */
	Object getFilename();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(Object value);

	/**
	 * Returns the value of the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' attribute.
	 * @see #setHeader(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Header()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='header'"
	 * @generated
	 */
	Object getHeader();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getHeader <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' attribute.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Iid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iid</em>' attribute.
	 * @see #setIid(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Iid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='iid'"
	 * @generated
	 */
	Object getIid();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getIid <em>Iid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iid</em>' attribute.
	 * @see #getIid()
	 * @generated
	 */
	void setIid(Object value);

	/**
	 * Returns the value of the '<em><b>Oi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oi</em>' attribute.
	 * @see #setOi(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Oi()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='Oi'"
	 * @generated
	 */
	Object getOi();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getOi <em>Oi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oi</em>' attribute.
	 * @see #getOi()
	 * @generated
	 */
	void setOi(Object value);

	/**
	 * Returns the value of the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy</em>' attribute.
	 * @see #setProxy(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Proxy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='proxy'"
	 * @generated
	 */
	Object getProxy();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getProxy <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy</em>' attribute.
	 * @see #getProxy()
	 * @generated
	 */
	void setProxy(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='timeout'"
	 * @generated
	 */
	Object getTimeout();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(Object value);

	/**
	 * Returns the value of the '<em><b>Tlb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tlb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tlb</em>' attribute.
	 * @see #setTlb(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Tlb()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='tlb'"
	 * @generated
	 */
	Object getTlb();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getTlb <em>Tlb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tlb</em>' attribute.
	 * @see #getTlb()
	 * @generated
	 */
	void setTlb(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getUnless <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unless</em>' attribute.
	 * @see #getUnless()
	 * @generated
	 */
	void setUnless(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMidlTask#getVerbose <em>Verbose</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMidlTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':25' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntVisualCppTasksMidlTask
