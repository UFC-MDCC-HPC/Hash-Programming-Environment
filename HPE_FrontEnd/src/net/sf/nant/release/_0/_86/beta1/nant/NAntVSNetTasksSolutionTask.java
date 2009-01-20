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
 * A representation of the model object '<em><b>NAnt VS Net Tasks Solution Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getProjects <em>Projects</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getReferenceprojects <em>Referenceprojects</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getWebmap <em>Webmap</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getExcludeprojects <em>Excludeprojects</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getAssemblyfolders <em>Assemblyfolders</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getEnablewebdav <em>Enablewebdav</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getIncludevsfolders <em>Includevsfolders</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getOutputdir <em>Outputdir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getSolutionfile <em>Solutionfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask()
 * @model extendedMetaData="name='NAnt.VSNet.Tasks.SolutionTask' kind='elementOnly'"
 * @generated
 */
public interface NAntVSNetTasksSolutionTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Projects()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='projects' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getProjects();

	/**
	 * Returns the value of the '<em><b>Referenceprojects</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenceprojects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenceprojects</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Referenceprojects()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='referenceprojects' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getReferenceprojects();

	/**
	 * Returns the value of the '<em><b>Webmap</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.WebmapType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Webmap</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Webmap</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Webmap()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='webmap' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<WebmapType> getWebmap();

	/**
	 * Returns the value of the '<em><b>Excludeprojects</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excludeprojects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excludeprojects</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Excludeprojects()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='excludeprojects' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getExcludeprojects();

	/**
	 * Returns the value of the '<em><b>Assemblyfolders</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assemblyfolders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assemblyfolders</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Assemblyfolders()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='assemblyfolders' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getAssemblyfolders();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' attribute.
	 * @see #setConfiguration(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Configuration()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='configuration'"
	 * @generated
	 */
	Object getConfiguration();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getConfiguration <em>Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' attribute.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(Object value);

	/**
	 * Returns the value of the '<em><b>Enablewebdav</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enablewebdav</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enablewebdav</em>' attribute.
	 * @see #setEnablewebdav(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Enablewebdav()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='enablewebdav'"
	 * @generated
	 */
	Object getEnablewebdav();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getEnablewebdav <em>Enablewebdav</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enablewebdav</em>' attribute.
	 * @see #getEnablewebdav()
	 * @generated
	 */
	void setEnablewebdav(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getFailonerror <em>Failonerror</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Includevsfolders</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includevsfolders</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includevsfolders</em>' attribute.
	 * @see #setIncludevsfolders(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Includevsfolders()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='includevsfolders'"
	 * @generated
	 */
	Object getIncludevsfolders();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getIncludevsfolders <em>Includevsfolders</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Includevsfolders</em>' attribute.
	 * @see #getIncludevsfolders()
	 * @generated
	 */
	void setIncludevsfolders(Object value);

	/**
	 * Returns the value of the '<em><b>Outputdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputdir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputdir</em>' attribute.
	 * @see #setOutputdir(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Outputdir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='outputdir'"
	 * @generated
	 */
	Object getOutputdir();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getOutputdir <em>Outputdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outputdir</em>' attribute.
	 * @see #getOutputdir()
	 * @generated
	 */
	void setOutputdir(Object value);

	/**
	 * Returns the value of the '<em><b>Solutionfile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutionfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutionfile</em>' attribute.
	 * @see #setSolutionfile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Solutionfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='solutionfile'"
	 * @generated
	 */
	Object getSolutionfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getSolutionfile <em>Solutionfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solutionfile</em>' attribute.
	 * @see #getSolutionfile()
	 * @generated
	 */
	void setSolutionfile(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntVSNetTasksSolutionTask#getVerbose <em>Verbose</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntVSNetTasksSolutionTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':15' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntVSNetTasksSolutionTask
