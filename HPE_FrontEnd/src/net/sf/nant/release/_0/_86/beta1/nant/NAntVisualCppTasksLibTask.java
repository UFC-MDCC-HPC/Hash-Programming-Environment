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
 * A representation of the model object '<em><b>NAnt Visual Cpp Tasks Lib Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getSources <em>Sources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getSymbols <em>Symbols</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getIgnorelibraries <em>Ignorelibraries</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getLibdirs <em>Libdirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getModuledefinition <em>Moduledefinition</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getOptions <em>Options</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask()
 * @model extendedMetaData="name='NAnt.VisualCpp.Tasks.LibTask' kind='elementOnly'"
 * @generated
 */
public interface NAntVisualCppTasksLibTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Sources()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='sources' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getSources();

	/**
	 * Returns the value of the '<em><b>Symbols</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.SymbolsType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbols</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbols</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Symbols()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='symbols' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<SymbolsType1> getSymbols();

	/**
	 * Returns the value of the '<em><b>Ignorelibraries</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.IgnorelibrariesType1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignorelibraries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignorelibraries</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Ignorelibraries()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ignorelibraries' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<IgnorelibrariesType1> getIgnorelibraries();

	/**
	 * Returns the value of the '<em><b>Libdirs</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libdirs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libdirs</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Libdirs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='libdirs' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getLibdirs();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Arg()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='arg' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesArgument> getArg();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getFailonerror <em>Failonerror</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Moduledefinition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moduledefinition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moduledefinition</em>' attribute.
	 * @see #setModuledefinition(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Moduledefinition()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='moduledefinition'"
	 * @generated
	 */
	Object getModuledefinition();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getModuledefinition <em>Moduledefinition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moduledefinition</em>' attribute.
	 * @see #getModuledefinition()
	 * @generated
	 */
	void setModuledefinition(Object value);

	/**
	 * Returns the value of the '<em><b>Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' attribute.
	 * @see #setOptions(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Options()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='options'"
	 * @generated
	 */
	Object getOptions();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getOptions <em>Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Options</em>' attribute.
	 * @see #getOptions()
	 * @generated
	 */
	void setOptions(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Output()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='output'"
	 * @generated
	 */
	Object getOutput();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='timeout'"
	 * @generated
	 */
	Object getTimeout();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksLibTask#getVerbose <em>Verbose</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksLibTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':14' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntVisualCppTasksLibTask
