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
 * A representation of the model object '<em><b>NAnt NUnit2 Types NUnit2 Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getAssemblies <em>Assemblies</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getCategories <em>Categories</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getAppconfig <em>Appconfig</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getAssemblyname <em>Assemblyname</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getHaltonfailure <em>Haltonfailure</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getTestname <em>Testname</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getTransformfile <em>Transformfile</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test()
 * @model extendedMetaData="name='NAnt.NUnit2.Types.NUnit2Test' kind='elementOnly'"
 * @generated
 */
public interface NAntNUnit2TypesNUnit2Test extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Group()
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Assemblies()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='assemblies' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntDotNetTypesAssemblyFileSet> getAssemblies();

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesCategories}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Categories()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='categories' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntNUnit2TypesCategories> getCategories();

	/**
	 * Returns the value of the '<em><b>Appconfig</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Appconfig</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Appconfig</em>' attribute.
	 * @see #setAppconfig(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Appconfig()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='appconfig'"
	 * @generated
	 */
	Object getAppconfig();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getAppconfig <em>Appconfig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Appconfig</em>' attribute.
	 * @see #getAppconfig()
	 * @generated
	 */
	void setAppconfig(Object value);

	/**
	 * Returns the value of the '<em><b>Assemblyname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assemblyname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assemblyname</em>' attribute.
	 * @see #setAssemblyname(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Assemblyname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='assemblyname'"
	 * @generated
	 */
	Object getAssemblyname();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getAssemblyname <em>Assemblyname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assemblyname</em>' attribute.
	 * @see #getAssemblyname()
	 * @generated
	 */
	void setAssemblyname(Object value);

	/**
	 * Returns the value of the '<em><b>Haltonfailure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Haltonfailure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Haltonfailure</em>' attribute.
	 * @see #setHaltonfailure(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Haltonfailure()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='haltonfailure'"
	 * @generated
	 */
	Object getHaltonfailure();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getHaltonfailure <em>Haltonfailure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Haltonfailure</em>' attribute.
	 * @see #getHaltonfailure()
	 * @generated
	 */
	void setHaltonfailure(Object value);

	/**
	 * Returns the value of the '<em><b>Testname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testname</em>' attribute.
	 * @see #setTestname(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Testname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='testname'"
	 * @generated
	 */
	Object getTestname();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getTestname <em>Testname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testname</em>' attribute.
	 * @see #getTestname()
	 * @generated
	 */
	void setTestname(Object value);

	/**
	 * Returns the value of the '<em><b>Transformfile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformfile</em>' attribute.
	 * @see #setTransformfile(Object)
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_Transformfile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='transformfile'"
	 * @generated
	 */
	Object getTransformfile();

	/**
	 * Sets the value of the '{@link net.sf.nant.release._0._86.beta1.nant.NAntNUnit2TypesNUnit2Test#getTransformfile <em>Transformfile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformfile</em>' attribute.
	 * @see #getTransformfile()
	 * @generated
	 */
	void setTransformfile(Object value);

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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getNAntNUnit2TypesNUnit2Test_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':8' processing='skip'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // NAntNUnit2TypesNUnit2Test
