/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visual Element Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getColor <em>Color</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getH <em>H</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getW <em>W</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getX <em>X</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getVisualElementAttributes()
 * @model extendedMetaData="name='VisualElementAttributes' kind='elementOnly'"
 * @generated
 */
public interface VisualElementAttributes extends EObject {
	/**
	 * Returns the value of the '<em><b>Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' containment reference.
	 * @see #setColor(ColorComplexType)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getVisualElementAttributes_Color()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='color'"
	 * @generated
	 */
	ColorComplexType getColor();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getColor <em>Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' containment reference.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(ColorComplexType value);

	/**
	 * Returns the value of the '<em><b>H</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>H</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>H</em>' attribute.
	 * @see #isSetH()
	 * @see #unsetH()
	 * @see #setH(long)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getVisualElementAttributes_H()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt" required="true"
	 *        extendedMetaData="kind='attribute' name='h'"
	 * @generated
	 */
	long getH();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getH <em>H</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>H</em>' attribute.
	 * @see #isSetH()
	 * @see #unsetH()
	 * @see #getH()
	 * @generated
	 */
	void setH(long value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getH <em>H</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetH()
	 * @see #getH()
	 * @see #setH(long)
	 * @generated
	 */
	void unsetH();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getH <em>H</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>H</em>' attribute is set.
	 * @see #unsetH()
	 * @see #getH()
	 * @see #setH(long)
	 * @generated
	 */
	boolean isSetH();

	/**
	 * Returns the value of the '<em><b>W</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W</em>' attribute.
	 * @see #isSetW()
	 * @see #unsetW()
	 * @see #setW(long)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getVisualElementAttributes_W()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt" required="true"
	 *        extendedMetaData="kind='attribute' name='w'"
	 * @generated
	 */
	long getW();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getW <em>W</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W</em>' attribute.
	 * @see #isSetW()
	 * @see #unsetW()
	 * @see #getW()
	 * @generated
	 */
	void setW(long value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getW <em>W</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetW()
	 * @see #getW()
	 * @see #setW(long)
	 * @generated
	 */
	void unsetW();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getW <em>W</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>W</em>' attribute is set.
	 * @see #unsetW()
	 * @see #getW()
	 * @see #setW(long)
	 * @generated
	 */
	boolean isSetW();

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #isSetX()
	 * @see #unsetX()
	 * @see #setX(long)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getVisualElementAttributes_X()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt" required="true"
	 *        extendedMetaData="kind='attribute' name='x'"
	 * @generated
	 */
	long getX();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #isSetX()
	 * @see #unsetX()
	 * @see #getX()
	 * @generated
	 */
	void setX(long value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetX()
	 * @see #getX()
	 * @see #setX(long)
	 * @generated
	 */
	void unsetX();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getX <em>X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>X</em>' attribute is set.
	 * @see #unsetX()
	 * @see #getX()
	 * @see #setX(long)
	 * @generated
	 */
	boolean isSetX();

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #isSetY()
	 * @see #unsetY()
	 * @see #setY(long)
	 * @see br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage#getVisualElementAttributes_Y()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.UnsignedInt" required="true"
	 *        extendedMetaData="kind='attribute' name='y'"
	 * @generated
	 */
	long getY();

	/**
	 * Sets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #isSetY()
	 * @see #unsetY()
	 * @see #getY()
	 * @generated
	 */
	void setY(long value);

	/**
	 * Unsets the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetY()
	 * @see #getY()
	 * @see #setY(long)
	 * @generated
	 */
	void unsetY();

	/**
	 * Returns whether the value of the '{@link br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes#getY <em>Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Y</em>' attribute is set.
	 * @see #unsetY()
	 * @see #getY()
	 * @see #setY(long)
	 * @generated
	 */
	boolean isSetY();

} // VisualElementAttributes
