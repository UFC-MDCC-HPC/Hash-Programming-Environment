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
 * A representation of the model object '<em><b>NAnt Source Control Tasks Change Log Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getArg <em>Arg</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCommandline <em>Commandline</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCompressionlevel <em>Compressionlevel</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCvsfullpath <em>Cvsfullpath</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCvsroot <em>Cvsroot</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCvsrsh <em>Cvsrsh</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getDestination <em>Destination</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getEnd <em>End</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getModule <em>Module</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getPassfile <em>Passfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getPassword <em>Password</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getQuiet <em>Quiet</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getReadonly <em>Readonly</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getReadwrite <em>Readwrite</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getReallyquiet <em>Reallyquiet</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getStart <em>Start</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getXmlfile <em>Xmlfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask()
 * @model extendedMetaData="name='NAnt.SourceControl.Tasks.ChangeLogTask' kind='elementOnly'"
 * @generated
 */
public interface NAntSourceControlTasksChangeLogTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Fileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTypesCvsFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Fileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='fileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntSourceControlTypesCvsFileSet> getFileset();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Arg()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='arg' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesArgument> getArg();

	/**
	 * Returns the value of the '<em><b>Commandline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commandline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commandline</em>' attribute.
	 * @see #setCommandline(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Commandline()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='commandline'"
	 * @generated
	 */
	Object getCommandline();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCommandline <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commandline</em>' attribute.
	 * @see #getCommandline()
	 * @generated
	 */
	void setCommandline(Object value);

	/**
	 * Returns the value of the '<em><b>Compressionlevel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compressionlevel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compressionlevel</em>' attribute.
	 * @see #setCompressionlevel(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Compressionlevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='compressionlevel'"
	 * @generated
	 */
	Object getCompressionlevel();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCompressionlevel <em>Compressionlevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compressionlevel</em>' attribute.
	 * @see #getCompressionlevel()
	 * @generated
	 */
	void setCompressionlevel(Object value);

	/**
	 * Returns the value of the '<em><b>Cvsfullpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvsfullpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvsfullpath</em>' attribute.
	 * @see #setCvsfullpath(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Cvsfullpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='cvsfullpath'"
	 * @generated
	 */
	Object getCvsfullpath();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCvsfullpath <em>Cvsfullpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cvsfullpath</em>' attribute.
	 * @see #getCvsfullpath()
	 * @generated
	 */
	void setCvsfullpath(Object value);

	/**
	 * Returns the value of the '<em><b>Cvsroot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvsroot</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvsroot</em>' attribute.
	 * @see #setCvsroot(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Cvsroot()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='cvsroot'"
	 * @generated
	 */
	Object getCvsroot();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCvsroot <em>Cvsroot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cvsroot</em>' attribute.
	 * @see #getCvsroot()
	 * @generated
	 */
	void setCvsroot(Object value);

	/**
	 * Returns the value of the '<em><b>Cvsrsh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cvsrsh</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cvsrsh</em>' attribute.
	 * @see #setCvsrsh(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Cvsrsh()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='cvsrsh'"
	 * @generated
	 */
	Object getCvsrsh();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getCvsrsh <em>Cvsrsh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cvsrsh</em>' attribute.
	 * @see #getCvsrsh()
	 * @generated
	 */
	void setCvsrsh(Object value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' attribute.
	 * @see #setDestination(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Destination()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='destination'"
	 * @generated
	 */
	Object getDestination();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Object value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_End()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='end'"
	 * @generated
	 */
	Object getEnd();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getFailonerror <em>Failonerror</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' attribute.
	 * @see #setModule(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Module()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='module'"
	 * @generated
	 */
	Object getModule();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getModule <em>Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' attribute.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Object value);

	/**
	 * Returns the value of the '<em><b>Passfile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passfile</em>' attribute.
	 * @see #setPassfile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Passfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='passfile'"
	 * @generated
	 */
	Object getPassfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getPassfile <em>Passfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passfile</em>' attribute.
	 * @see #getPassfile()
	 * @generated
	 */
	void setPassfile(Object value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Password()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='password'"
	 * @generated
	 */
	Object getPassword();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(Object value);

	/**
	 * Returns the value of the '<em><b>Quiet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quiet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quiet</em>' attribute.
	 * @see #setQuiet(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Quiet()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='quiet'"
	 * @generated
	 */
	Object getQuiet();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getQuiet <em>Quiet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quiet</em>' attribute.
	 * @see #getQuiet()
	 * @generated
	 */
	void setQuiet(Object value);

	/**
	 * Returns the value of the '<em><b>Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Readonly</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Readonly</em>' attribute.
	 * @see #setReadonly(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Readonly()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='readonly'"
	 * @generated
	 */
	Object getReadonly();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getReadonly <em>Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Readonly</em>' attribute.
	 * @see #getReadonly()
	 * @generated
	 */
	void setReadonly(Object value);

	/**
	 * Returns the value of the '<em><b>Readwrite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Readwrite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Readwrite</em>' attribute.
	 * @see #setReadwrite(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Readwrite()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='readwrite'"
	 * @generated
	 */
	Object getReadwrite();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getReadwrite <em>Readwrite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Readwrite</em>' attribute.
	 * @see #getReadwrite()
	 * @generated
	 */
	void setReadwrite(Object value);

	/**
	 * Returns the value of the '<em><b>Reallyquiet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reallyquiet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reallyquiet</em>' attribute.
	 * @see #setReallyquiet(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Reallyquiet()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='reallyquiet'"
	 * @generated
	 */
	Object getReallyquiet();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getReallyquiet <em>Reallyquiet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reallyquiet</em>' attribute.
	 * @see #getReallyquiet()
	 * @generated
	 */
	void setReallyquiet(Object value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Start()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='start'"
	 * @generated
	 */
	Object getStart();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='timeout'"
	 * @generated
	 */
	Object getTimeout();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getTimeout <em>Timeout</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getVerbose <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbose</em>' attribute.
	 * @see #getVerbose()
	 * @generated
	 */
	void setVerbose(Object value);

	/**
	 * Returns the value of the '<em><b>Xmlfile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmlfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmlfile</em>' attribute.
	 * @see #setXmlfile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_Xmlfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='xmlfile'"
	 * @generated
	 */
	Object getXmlfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntSourceControlTasksChangeLogTask#getXmlfile <em>Xmlfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmlfile</em>' attribute.
	 * @see #getXmlfile()
	 * @generated
	 */
	void setXmlfile(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntSourceControlTasksChangeLogTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':24' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntSourceControlTasksChangeLogTask
