/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment.util;

import hPE.frontend.backend.environment.EnvironmentPackage;

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
public class EnvironmentXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		EnvironmentPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the EnvironmentResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new EnvironmentResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new EnvironmentResourceFactoryImpl());
		}
		return registrations;
	}

} //EnvironmentXMLProcessor
