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
 * A representation of the model object '<em><b>Deployed Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hPE.frontend.backend.environment.DeployedParameterType#getActual <em>Actual</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedParameterType#getBound <em>Bound</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedParameterType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link hPE.frontend.backend.environment.DeployedParameterType#getParameterId <em>Parameter Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedParameterType()
 * @model extendedMetaData="name='DeployedParameterType' kind='elementOnly'"
 * @generated
 */
public interface DeployedParameterType extends EObject {
	/**
	 * Returns the value of the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual</em>' attribute.
	 * @see #isSetActual()
	 * @see #unsetActual()
	 * @see #setActual(int)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedParameterType_Actual()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='element' name='actual' namespace='##targetNamespace'"
	 * @generated
	 */
	int getActual();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedParameterType#getActual <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' attribute.
	 * @see #isSetActual()
	 * @see #unsetActual()
	 * @see #getActual()
	 * @generated
	 */
	void setActual(int value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.backend.environment.DeployedParameterType#getActual <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActual()
	 * @see #getActual()
	 * @see #setActual(int)
	 * @generated
	 */
	void unsetActual();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.backend.environment.DeployedParameterType#getActual <em>Actual</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual</em>' attribute is set.
	 * @see #unsetActual()
	 * @see #getActual()
	 * @see #setActual(int)
	 * @generated
	 */
	boolean isSetActual();

	/**
	 * Returns the value of the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' attribute.
	 * @see #isSetBound()
	 * @see #unsetBound()
	 * @see #setBound(int)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedParameterType_Bound()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='element' name='bound' namespace='##targetNamespace'"
	 * @generated
	 */
	int getBound();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedParameterType#getBound <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound</em>' attribute.
	 * @see #isSetBound()
	 * @see #unsetBound()
	 * @see #getBound()
	 * @generated
	 */
	void setBound(int value);

	/**
	 * Unsets the value of the '{@link hPE.frontend.backend.environment.DeployedParameterType#getBound <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBound()
	 * @see #getBound()
	 * @see #setBound(int)
	 * @generated
	 */
	void unsetBound();

	/**
	 * Returns whether the value of the '{@link hPE.frontend.backend.environment.DeployedParameterType#getBound <em>Bound</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bound</em>' attribute is set.
	 * @see #unsetBound()
	 * @see #getBound()
	 * @see #setBound(int)
	 * @generated
	 */
	boolean isSetBound();

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
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedParameterType_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameter' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DeployedParameterType> getParameter();

	/**
	 * Returns the value of the '<em><b>Parameter Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Id</em>' attribute.
	 * @see #setParameterId(String)
	 * @see hPE.frontend.backend.environment.EnvironmentPackage#getDeployedParameterType_ParameterId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='parameter_id'"
	 * @generated
	 */
	String getParameterId();

	/**
	 * Sets the value of the '{@link hPE.frontend.backend.environment.DeployedParameterType#getParameterId <em>Parameter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Id</em>' attribute.
	 * @see #getParameterId()
	 * @generated
	 */
	void setParameterId(String value);

} // DeployedParameterType
