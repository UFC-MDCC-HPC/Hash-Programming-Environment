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
 * A representation of the model object '<em><b>NAnt Dot Net Tasks License Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getInput <em>Input</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getLicensetarget <em>Licensetarget</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask()
 * @model extendedMetaData="name='NAnt.DotNet.Tasks.LicenseTask' kind='elementOnly'"
 * @generated
 */
public interface NAntDotNetTasksLicenseTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Assemblies</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assemblies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assemblies</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Assemblies()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='assemblies' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesAssemblyFileSet> getAssemblies();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getFailonerror <em>Failonerror</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Input()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='input'"
	 * @generated
	 */
	Object getInput();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Object value);

	/**
	 * Returns the value of the '<em><b>Licensetarget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Licensetarget</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Licensetarget</em>' attribute.
	 * @see #setLicensetarget(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Licensetarget()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='licensetarget'"
	 * @generated
	 */
	Object getLicensetarget();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getLicensetarget <em>Licensetarget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Licensetarget</em>' attribute.
	 * @see #getLicensetarget()
	 * @generated
	 */
	void setLicensetarget(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Output()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='output'"
	 * @generated
	 */
	Object getOutput();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Object value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute.
	 * @see #setTarget(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	Object getTarget();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='timeout'"
	 * @generated
	 */
	Object getTimeout();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getTimeout <em>Timeout</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksLicenseTask#getVerbose <em>Verbose</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksLicenseTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':11' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntDotNetTasksLicenseTask
