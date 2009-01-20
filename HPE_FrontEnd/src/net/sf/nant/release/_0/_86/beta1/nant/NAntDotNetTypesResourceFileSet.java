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
 * A representation of the model object '<em><b>NAnt Dot Net Types Resource File Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getPatternset <em>Patternset</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getIncludes <em>Includes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getInclude <em>Include</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getExclude <em>Exclude</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getIncludesList <em>Includes List</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getIncludesfile <em>Includesfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getExcludesfile <em>Excludesfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getBasedir <em>Basedir</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getCasesensitive <em>Casesensitive</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getDefaultexcludes <em>Defaultexcludes</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getDynamicprefix <em>Dynamicprefix</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getFailonempty <em>Failonempty</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getId <em>Id</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getRefid <em>Refid</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet()
 * @model extendedMetaData="name='NAnt.DotNet.Types.ResourceFileSet' kind='elementOnly'"
 * @generated
 */
public interface NAntDotNetTypesResourceFileSet extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Patternset</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesPatternSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Patternset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patternset</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Patternset()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='patternset' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesPatternSet> getPatternset();

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetInclude}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Includes()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='includes' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSetInclude> getIncludes();

	/**
	 * Returns the value of the '<em><b>Include</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetInclude}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Include()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='include' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSetInclude> getInclude();

	/**
	 * Returns the value of the '<em><b>Excludes</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExclude}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excludes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excludes</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Excludes()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='excludes' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSetExclude> getExcludes();

	/**
	 * Returns the value of the '<em><b>Exclude</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExclude}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclude</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclude</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Exclude()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='exclude' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSetExclude> getExclude();

	/**
	 * Returns the value of the '<em><b>Includes List</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetIncludesFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes List</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_IncludesList()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='includesList' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSetIncludesFile> getIncludesList();

	/**
	 * Returns the value of the '<em><b>Includesfile</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetIncludesFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includesfile</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includesfile</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Includesfile()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='includesfile' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSetIncludesFile> getIncludesfile();

	/**
	 * Returns the value of the '<em><b>Excludesfile</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetExcludesFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excludesfile</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excludesfile</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Excludesfile()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='excludesfile' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntCoreTypesFileSetExcludesFile> getExcludesfile();

	/**
	 * Returns the value of the '<em><b>Basedir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basedir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basedir</em>' attribute.
	 * @see #setBasedir(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Basedir()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='basedir'"
	 * @generated
	 */
	Object getBasedir();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getBasedir <em>Basedir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basedir</em>' attribute.
	 * @see #getBasedir()
	 * @generated
	 */
	void setBasedir(Object value);

	/**
	 * Returns the value of the '<em><b>Casesensitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Casesensitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Casesensitive</em>' attribute.
	 * @see #setCasesensitive(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Casesensitive()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='casesensitive'"
	 * @generated
	 */
	Object getCasesensitive();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getCasesensitive <em>Casesensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Casesensitive</em>' attribute.
	 * @see #getCasesensitive()
	 * @generated
	 */
	void setCasesensitive(Object value);

	/**
	 * Returns the value of the '<em><b>Defaultexcludes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defaultexcludes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defaultexcludes</em>' attribute.
	 * @see #setDefaultexcludes(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Defaultexcludes()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='defaultexcludes'"
	 * @generated
	 */
	Object getDefaultexcludes();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getDefaultexcludes <em>Defaultexcludes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defaultexcludes</em>' attribute.
	 * @see #getDefaultexcludes()
	 * @generated
	 */
	void setDefaultexcludes(Object value);

	/**
	 * Returns the value of the '<em><b>Dynamicprefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamicprefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamicprefix</em>' attribute.
	 * @see #setDynamicprefix(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Dynamicprefix()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='dynamicprefix'"
	 * @generated
	 */
	Object getDynamicprefix();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getDynamicprefix <em>Dynamicprefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamicprefix</em>' attribute.
	 * @see #getDynamicprefix()
	 * @generated
	 */
	void setDynamicprefix(Object value);

	/**
	 * Returns the value of the '<em><b>Failonempty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failonempty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failonempty</em>' attribute.
	 * @see #setFailonempty(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Failonempty()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='failonempty'"
	 * @generated
	 */
	Object getFailonempty();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getFailonempty <em>Failonempty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failonempty</em>' attribute.
	 * @see #getFailonempty()
	 * @generated
	 */
	void setFailonempty(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	Object getId();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Object value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Prefix()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='prefix'"
	 * @generated
	 */
	Object getPrefix();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_Refid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='refid'"
	 * @generated
	 */
	Object getRefid();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesResourceFileSet#getRefid <em>Refid</em>}' attribute.
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntDotNetTypesResourceFileSet_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':17' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntDotNetTypesResourceFileSet
