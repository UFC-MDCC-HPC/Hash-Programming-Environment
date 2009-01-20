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
 * A representation of the model object '<em><b>NAnt Visual Cpp Tasks Mc Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getHeaderpath <em>Headerpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getMcfile <em>Mcfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getOptions <em>Options</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getRcpath <em>Rcpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask()
 * @model extendedMetaData="name='NAnt.VisualCpp.Tasks.McTask' kind='elementOnly'"
 * @generated
 */
public interface NAntVisualCppTasksMcTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Arg()
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getFailonerror <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failonerror</em>' attribute.
	 * @see #getFailonerror()
	 * @generated
	 */
	void setFailonerror(Object value);

	/**
	 * Returns the value of the '<em><b>Headerpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Headerpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headerpath</em>' attribute.
	 * @see #setHeaderpath(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Headerpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='headerpath'"
	 * @generated
	 */
	Object getHeaderpath();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getHeaderpath <em>Headerpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Headerpath</em>' attribute.
	 * @see #getHeaderpath()
	 * @generated
	 */
	void setHeaderpath(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Mcfile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mcfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mcfile</em>' attribute.
	 * @see #setMcfile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Mcfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='mcfile'"
	 * @generated
	 */
	Object getMcfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getMcfile <em>Mcfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mcfile</em>' attribute.
	 * @see #getMcfile()
	 * @generated
	 */
	void setMcfile(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Options()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='options'"
	 * @generated
	 */
	Object getOptions();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getOptions <em>Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Options</em>' attribute.
	 * @see #getOptions()
	 * @generated
	 */
	void setOptions(Object value);

	/**
	 * Returns the value of the '<em><b>Rcpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rcpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rcpath</em>' attribute.
	 * @see #setRcpath(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Rcpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='rcpath'"
	 * @generated
	 */
	Object getRcpath();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getRcpath <em>Rcpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rcpath</em>' attribute.
	 * @see #getRcpath()
	 * @generated
	 */
	void setRcpath(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='timeout'"
	 * @generated
	 */
	Object getTimeout();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getTimeout <em>Timeout</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTasksMcTask#getVerbose <em>Verbose</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVisualCppTasksMcTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':11' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntVisualCppTasksMcTask
