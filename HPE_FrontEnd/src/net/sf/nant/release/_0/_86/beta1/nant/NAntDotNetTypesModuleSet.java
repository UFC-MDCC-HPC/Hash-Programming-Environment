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
 * A representation of the model object '<em><b>NAnt Dot Net Types Module Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getModule <em>Module</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getDir <em>Dir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getId <em>Id</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getRefid <em>Refid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesModuleSet()
 * @model extendedMetaData="name='NAnt.DotNet.Types.ModuleSet' kind='elementOnly'"
 * @generated
 */
public interface NAntDotNetTypesModuleSet extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesModuleSet_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Module</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesModuleSet_Module()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='module' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesModule> getModule();

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesModuleSet_Dir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='dir'"
	 * @generated
	 */
	Object getDir();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getDir <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' attribute.
	 * @see #getDir()
	 * @generated
	 */
	void setDir(Object value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesModuleSet_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	Object getId();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Object value);

	/**
	 * Returns the value of the '<em><b>Refid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refid</em>' attribute.
	 * @see #setRefid(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesModuleSet_Refid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='refid'"
	 * @generated
	 */
	Object getRefid();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesModuleSet#getRefid <em>Refid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refid</em>' attribute.
	 * @see #getRefid()
	 * @generated
	 */
	void setRefid(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesModuleSet_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':5' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntDotNetTypesModuleSet
