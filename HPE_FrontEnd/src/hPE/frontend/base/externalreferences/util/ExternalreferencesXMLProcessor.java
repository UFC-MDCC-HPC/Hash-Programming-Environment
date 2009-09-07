/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.base.externalreferences.util;

import hPE.frontend.base.externalreferences.ExternalreferencesPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalreferencesXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalreferencesXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ExternalreferencesPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the ExternalreferencesResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ExternalreferencesResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ExternalreferencesResourceFactoryImpl());
		}
		return registrations;
	}

} //ExternalreferencesXMLProcessor
