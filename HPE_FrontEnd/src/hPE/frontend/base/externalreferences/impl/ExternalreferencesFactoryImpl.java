/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.base.externalreferences.impl;

import hPE.frontend.base.externalreferences.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalreferencesFactoryImpl extends EFactoryImpl implements ExternalreferencesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExternalreferencesFactory init() {
		try {
			ExternalreferencesFactory theExternalreferencesFactory = (ExternalreferencesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.example.org/externalreferences"); 
			if (theExternalreferencesFactory != null) {
				return theExternalreferencesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExternalreferencesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalreferencesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExternalreferencesPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case ExternalreferencesPackage.REFERENCE_LIST_TYPE: return createReferenceListType();
			case ExternalreferencesPackage.REFERENCE_TYPE: return createReferenceType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceListType createReferenceListType() {
		ReferenceListTypeImpl referenceListType = new ReferenceListTypeImpl();
		return referenceListType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceType createReferenceType() {
		ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
		return referenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalreferencesPackage getExternalreferencesPackage() {
		return (ExternalreferencesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExternalreferencesPackage getPackage() {
		return ExternalreferencesPackage.eINSTANCE;
	}

} //ExternalreferencesFactoryImpl
