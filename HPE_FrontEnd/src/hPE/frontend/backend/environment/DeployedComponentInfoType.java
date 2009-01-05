/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.frontend.backend.environment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployed Component Info Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getPackage <em>Package</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getEnumerator <em>Enumerator</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCid <em>Cid</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCidBase <em>Cid Base</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getKind <em>Kind</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getLocationURI <em>Location URI</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType()
 * @model extendedMetaData="name='DeployedComponentInfoType' kind='elementOnly'"
 * @generated
 */
public interface DeployedComponentInfoType extends EObject {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute list.
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_Package()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='package' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getPackage();

	/**
	 * Returns the value of the '<em><b>Enumerator</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerator</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerator</em>' attribute list.
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_Enumerator()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='enumerator' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getEnumerator();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link hPE.frontend.backend.environment.DeployedParameterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameter' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DeployedParameterType> getParameter();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #isSetAbstract()
	 * @see #unsetAbstract()
	 * @see #setAbstract(boolean)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_Abstract()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='abstract'"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isSetAbstract()
	 * @see #unsetAbstract()
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAbstract()
	 * @see #isAbstract()
	 * @see #setAbstract(boolean)
	 * @generated
	 */
	void unsetAbstract();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#isAbstract <em>Abstract</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Abstract</em>' attribute is set.
	 * @see #unsetAbstract()
	 * @see #isAbstract()
	 * @see #setAbstract(boolean)
	 * @generated
	 */
	boolean isSetAbstract();

	/**
	 * Returns the value of the '<em><b>Cid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cid</em>' attribute.
	 * @see #isSetCid()
	 * @see #unsetCid()
	 * @see #setCid(int)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_Cid()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='cid'"
	 * @generated
	 */
	int getCid();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCid <em>Cid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cid</em>' attribute.
	 * @see #isSetCid()
	 * @see #unsetCid()
	 * @see #getCid()
	 * @generated
	 */
	void setCid(int value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCid <em>Cid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCid()
	 * @see #getCid()
	 * @see #setCid(int)
	 * @generated
	 */
	void unsetCid();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCid <em>Cid</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cid</em>' attribute is set.
	 * @see #unsetCid()
	 * @see #getCid()
	 * @see #setCid(int)
	 * @generated
	 */
	boolean isSetCid();

	/**
	 * Returns the value of the '<em><b>Cid Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cid Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cid Base</em>' attribute.
	 * @see #isSetCidBase()
	 * @see #unsetCidBase()
	 * @see #setCidBase(int)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_CidBase()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='cidBase'"
	 * @generated
	 */
	int getCidBase();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCidBase <em>Cid Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cid Base</em>' attribute.
	 * @see #isSetCidBase()
	 * @see #unsetCidBase()
	 * @see #getCidBase()
	 * @generated
	 */
	void setCidBase(int value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCidBase <em>Cid Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCidBase()
	 * @see #getCidBase()
	 * @see #setCidBase(int)
	 * @generated
	 */
	void unsetCidBase();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getCidBase <em>Cid Base</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cid Base</em>' attribute is set.
	 * @see #unsetCidBase()
	 * @see #getCidBase()
	 * @see #setCidBase(int)
	 * @generated
	 */
	boolean isSetCidBase();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_Kind()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='kind'"
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location URI</em>' attribute.
	 * @see #setLocationURI(String)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_LocationURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='locationURI'"
	 * @generated
	 */
	String getLocationURI();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getLocationURI <em>Location URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location URI</em>' attribute.
	 * @see #getLocationURI()
	 * @generated
	 */
	void setLocationURI(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedComponentInfoType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedComponentInfoType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DeployedComponentInfoType
