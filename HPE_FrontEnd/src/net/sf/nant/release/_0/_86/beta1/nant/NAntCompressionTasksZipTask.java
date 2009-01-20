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
 * A representation of the model object '<em><b>NAnt Compression Tasks Zip Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getFileset <em>Fileset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getComment <em>Comment</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getDuplicate <em>Duplicate</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getFailonerror <em>Failonerror</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getIncludeemptydirs <em>Includeemptydirs</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getStampdatetime <em>Stampdatetime</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getVerbose <em>Verbose</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getZipfile <em>Zipfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getZiplevel <em>Ziplevel</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask()
 * @model extendedMetaData="name='NAnt.Compression.Tasks.ZipTask' kind='elementOnly'"
 * @generated
 */
public interface NAntCompressionTasksZipTask extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Fileset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTypesZipFileSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fileset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fileset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Fileset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='fileset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCompressionTypesZipFileSet> getFileset();

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Comment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='comment'"
	 * @generated
	 */
	Object getComment();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(Object value);

	/**
	 * Returns the value of the '<em><b>Duplicate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duplicate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicate</em>' attribute.
	 * @see #setDuplicate(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Duplicate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='duplicate'"
	 * @generated
	 */
	Object getDuplicate();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getDuplicate <em>Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duplicate</em>' attribute.
	 * @see #getDuplicate()
	 * @generated
	 */
	void setDuplicate(Object value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Encoding()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='encoding'"
	 * @generated
	 */
	Object getEncoding();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Failonerror()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonerror'"
	 * @generated
	 */
	Object getFailonerror();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getFailonerror <em>Failonerror</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Includeemptydirs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includeemptydirs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includeemptydirs</em>' attribute.
	 * @see #setIncludeemptydirs(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Includeemptydirs()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='includeemptydirs'"
	 * @generated
	 */
	Object getIncludeemptydirs();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getIncludeemptydirs <em>Includeemptydirs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Includeemptydirs</em>' attribute.
	 * @see #getIncludeemptydirs()
	 * @generated
	 */
	void setIncludeemptydirs(Object value);

	/**
	 * Returns the value of the '<em><b>Stampdatetime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stampdatetime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stampdatetime</em>' attribute.
	 * @see #setStampdatetime(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Stampdatetime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='stampdatetime'"
	 * @generated
	 */
	Object getStampdatetime();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getStampdatetime <em>Stampdatetime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stampdatetime</em>' attribute.
	 * @see #getStampdatetime()
	 * @generated
	 */
	void setStampdatetime(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getUnless <em>Unless</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Verbose()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='verbose'"
	 * @generated
	 */
	Object getVerbose();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getVerbose <em>Verbose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbose</em>' attribute.
	 * @see #getVerbose()
	 * @generated
	 */
	void setVerbose(Object value);

	/**
	 * Returns the value of the '<em><b>Zipfile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zipfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zipfile</em>' attribute.
	 * @see #setZipfile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Zipfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='zipfile'"
	 * @generated
	 */
	Object getZipfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getZipfile <em>Zipfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zipfile</em>' attribute.
	 * @see #getZipfile()
	 * @generated
	 */
	void setZipfile(Object value);

	/**
	 * Returns the value of the '<em><b>Ziplevel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ziplevel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ziplevel</em>' attribute.
	 * @see #setZiplevel(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_Ziplevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='ziplevel'"
	 * @generated
	 */
	Object getZiplevel();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCompressionTasksZipTask#getZiplevel <em>Ziplevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ziplevel</em>' attribute.
	 * @see #getZiplevel()
	 * @generated
	 */
	void setZiplevel(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCompressionTasksZipTask_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':13' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntCompressionTasksZipTask
