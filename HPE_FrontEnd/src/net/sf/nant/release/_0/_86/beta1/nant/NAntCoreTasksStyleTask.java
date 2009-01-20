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
 * A representation of the model object '<em><b>NAnt Core Tasks Style Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getInfiles <em>Infiles</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getParameters <em>Parameters</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getExtensionobjects <em>Extensionobjects</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getProxy <em>Proxy</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getDestdir <em>Destdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getExtension <em>Extension</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getIn <em>In</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getOut <em>Out</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getStyle <em>Style</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask()
 * @model extendedMetaData="name='NAnt.Core.Tasks.StyleTask' kind='elementOnly'"
 * @generated
 */
public interface NAntCoreTasksStyleTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Infiles</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infiles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infiles</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Infiles()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='infiles' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getInfiles();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.ParametersType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Parameters()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='parameters' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<ParametersType> getParameters();

	/**
	 * Returns the value of the '<em><b>Extensionobjects</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.ExtensionobjectsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensionobjects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensionobjects</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Extensionobjects()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='extensionobjects' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<ExtensionobjectsType> getExtensionobjects();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Proxy()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='proxy' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesProxy> getProxy();

	/**
	 * Returns the value of the '<em><b>Destdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destdir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destdir</em>' attribute.
	 * @see #setDestdir(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Destdir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='destdir'"
	 * @generated
	 */
	Object getDestdir();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getDestdir <em>Destdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destdir</em>' attribute.
	 * @see #getDestdir()
	 * @generated
	 */
	void setDestdir(Object value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Extension()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='extension'"
	 * @generated
	 */
	Object getExtension();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getFailonerror <em>Failonerror</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' attribute.
	 * @see #setIn(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_In()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='in'"
	 * @generated
	 */
	Object getIn();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getIn <em>In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' attribute.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(Object value);

	/**
	 * Returns the value of the '<em><b>Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' attribute.
	 * @see #setOut(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Out()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='out'"
	 * @generated
	 */
	Object getOut();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getOut <em>Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out</em>' attribute.
	 * @see #getOut()
	 * @generated
	 */
	void setOut(Object value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see #setStyle(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Style()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='style'"
	 * @generated
	 */
	Object getStyle();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksStyleTask#getVerbose <em>Verbose</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTasksStyleTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':14' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntCoreTasksStyleTask
