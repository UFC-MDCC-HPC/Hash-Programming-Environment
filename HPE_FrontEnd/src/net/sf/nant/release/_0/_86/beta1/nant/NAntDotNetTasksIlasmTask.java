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
 * A representation of the model object '<em><b>NAnt Dot Net Tasks Ilasm Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getSources <em>Sources</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getBase <em>Base</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getClock <em>Clock</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getDebug <em>Debug</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getError <em>Error</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getFlags <em>Flags</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getKeyfile <em>Keyfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getKeysource <em>Keysource</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getListing <em>Listing</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getOutput <em>Output</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getRebuild <em>Rebuild</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getResourcefile <em>Resourcefile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getSubsystem <em>Subsystem</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getTarget <em>Target</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask()
 * @model extendedMetaData="name='NAnt.DotNet.Tasks.IlasmTask' kind='elementOnly'"
 * @generated
 */
public interface NAntDotNetTasksIlasmTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Group()
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Sources()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='sources' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSet> getSources();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Arg()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='arg' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesArgument> getArg();

	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see #setAlignment(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Alignment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='alignment'"
	 * @generated
	 */
	Object getAlignment();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getAlignment <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(Object value);

	/**
	 * Returns the value of the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' attribute.
	 * @see #setBase(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Base()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='base'"
	 * @generated
	 */
	Object getBase();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getBase <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' attribute.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(Object value);

	/**
	 * Returns the value of the '<em><b>Clock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock</em>' attribute.
	 * @see #setClock(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Clock()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='clock'"
	 * @generated
	 */
	Object getClock();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getClock <em>Clock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock</em>' attribute.
	 * @see #getClock()
	 * @generated
	 */
	void setClock(Object value);

	/**
	 * Returns the value of the '<em><b>Debug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug</em>' attribute.
	 * @see #setDebug(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Debug()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='debug'"
	 * @generated
	 */
	Object getDebug();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getDebug <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug</em>' attribute.
	 * @see #getDebug()
	 * @generated
	 */
	void setDebug(Object value);

	/**
	 * Returns the value of the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' attribute.
	 * @see #setError(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Error()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='error'"
	 * @generated
	 */
	Object getError();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getError <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' attribute.
	 * @see #getError()
	 * @generated
	 */
	void setError(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getFailonerror <em>Failonerror</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failonerror</em>' attribute.
	 * @see #getFailonerror()
	 * @generated
	 */
	void setFailonerror(Object value);

	/**
	 * Returns the value of the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flags</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flags</em>' attribute.
	 * @see #setFlags(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Flags()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='flags'"
	 * @generated
	 */
	Object getFlags();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getFlags <em>Flags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flags</em>' attribute.
	 * @see #getFlags()
	 * @generated
	 */
	void setFlags(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Keyfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='keyfile'"
	 * @generated
	 */
	Object getKeyfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getKeyfile <em>Keyfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keyfile</em>' attribute.
	 * @see #getKeyfile()
	 * @generated
	 */
	void setKeyfile(Object value);

	/**
	 * Returns the value of the '<em><b>Keysource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keysource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keysource</em>' attribute.
	 * @see #setKeysource(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Keysource()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='keysource'"
	 * @generated
	 */
	Object getKeysource();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getKeysource <em>Keysource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keysource</em>' attribute.
	 * @see #getKeysource()
	 * @generated
	 */
	void setKeysource(Object value);

	/**
	 * Returns the value of the '<em><b>Listing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listing</em>' attribute.
	 * @see #setListing(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Listing()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='listing'"
	 * @generated
	 */
	Object getListing();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getListing <em>Listing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listing</em>' attribute.
	 * @see #getListing()
	 * @generated
	 */
	void setListing(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Output()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='output'"
	 * @generated
	 */
	Object getOutput();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Object value);

	/**
	 * Returns the value of the '<em><b>Rebuild</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rebuild</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rebuild</em>' attribute.
	 * @see #setRebuild(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Rebuild()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='rebuild'"
	 * @generated
	 */
	Object getRebuild();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getRebuild <em>Rebuild</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rebuild</em>' attribute.
	 * @see #getRebuild()
	 * @generated
	 */
	void setRebuild(Object value);

	/**
	 * Returns the value of the '<em><b>Resourcefile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resourcefile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resourcefile</em>' attribute.
	 * @see #setResourcefile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Resourcefile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='resourcefile'"
	 * @generated
	 */
	Object getResourcefile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getResourcefile <em>Resourcefile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resourcefile</em>' attribute.
	 * @see #getResourcefile()
	 * @generated
	 */
	void setResourcefile(Object value);

	/**
	 * Returns the value of the '<em><b>Subsystem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystem</em>' attribute.
	 * @see #setSubsystem(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Subsystem()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='subsystem'"
	 * @generated
	 */
	Object getSubsystem();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getSubsystem <em>Subsystem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subsystem</em>' attribute.
	 * @see #getSubsystem()
	 * @generated
	 */
	void setSubsystem(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	Object getTarget();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getTarget <em>Target</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='timeout'"
	 * @generated
	 */
	Object getTimeout();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getTimeout <em>Timeout</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksIlasmTask#getVerbose <em>Verbose</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTasksIlasmTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':22' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntDotNetTasksIlasmTask
