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
 * A representation of the model object '<em><b>Symbols Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.SymbolsType#getGroup <em>Group</em>}</li>
 *   <li>{@link net.sf.nant.release._0._86.beta1.nant.SymbolsType#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getSymbolsType()
 * @model extendedMetaData="name='symbols_._type' kind='elementOnly'"
 * @generated
 */
public interface SymbolsType extends EObject {
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
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getSymbolsType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.nant.release._0._86.beta1.nant.NAntVisualCppTypesSymbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' containment reference list.
	 * @see net.sf.nant.release._0._86.beta1.nant.NantPackage#getSymbolsType_Symbol()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='symbol' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<NAntVisualCppTypesSymbol> getSymbol();

} // SymbolsType
