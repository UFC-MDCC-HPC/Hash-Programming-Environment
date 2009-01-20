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
 * A representation of the model object '<em><b>NAnt Core Types Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getPath <em>Path</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getDir <em>Dir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getFile <em>File</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getIf <em>If</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getLine <em>Line</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getPath1 <em>Path1</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getUnless <em>Unless</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getValue <em>Value</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument()
 * @model extendedMetaData="name='NAnt.Core.Types.Argument' kind='elementOnly'"
 * @generated
 */
public interface NAntCoreTypesArgument extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPathSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_Path()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='path' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesPathSet> getPath();

	/**
	 * Returns the value of the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dir</em>' attribute.
	 * @see #setDir(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_Dir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='dir'"
	 * @generated
	 */
	Object getDir();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getDir <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' attribute.
	 * @see #getDir()
	 * @generated
	 */
	void setDir(Object value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_File()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='file'"
	 * @generated
	 */
	Object getFile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_If()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='if'"
	 * @generated
	 */
	Object getIf();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(Object value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_Line()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='line'"
	 * @generated
	 */
	Object getLine();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(Object value);

	/**
	 * Returns the value of the '<em><b>Path1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path1</em>' attribute.
	 * @see #setPath1(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_Path1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='path'"
	 * @generated
	 */
	Object getPath1();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getPath1 <em>Path1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path1</em>' attribute.
	 * @see #getPath1()
	 * @generated
	 */
	void setPath1(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_Unless()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='unless'"
	 * @generated
	 */
	Object getUnless();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getUnless <em>Unless</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unless</em>' attribute.
	 * @see #getUnless()
	 * @generated
	 */
	void setUnless(Object value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='value'"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesArgument#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntCoreTypesArgument_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':9' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntCoreTypesArgument
