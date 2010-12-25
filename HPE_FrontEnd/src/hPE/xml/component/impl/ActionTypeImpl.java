/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ActionType;
import hPE.xml.component.ComponentPackage;
import hPE.xml.component.VisualElementAttributes;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.ActionTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ActionTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ActionTypeImpl#getRepeat <em>Repeat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionTypeImpl extends EObjectImpl implements ActionType {
	/**
	 * The cached value of the '{@link #getVisualDescription() <em>Visual Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualDescription()
	 * @generated
	 * @ordered
	 */
	protected VisualElementAttributes visualDescription;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepeat() <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeat()
	 * @generated
	 * @ordered
	 */
	protected static final long REPEAT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRepeat() <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeat()
	 * @generated
	 * @ordered
	 */
	protected long repeat = REPEAT_EDEFAULT;

	/**
	 * This is true if the Repeat attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean repeatESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.ACTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualElementAttributes getVisualDescription() {
		return visualDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisualDescription(VisualElementAttributes newVisualDescription, NotificationChain msgs) {
		VisualElementAttributes oldVisualDescription = visualDescription;
		visualDescription = newVisualDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualDescription(VisualElementAttributes newVisualDescription) {
		if (newVisualDescription != visualDescription) {
			NotificationChain msgs = null;
			if (visualDescription != null)
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ACTION_TYPE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRepeat() {
		return repeat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeat(long newRepeat) {
		long oldRepeat = repeat;
		repeat = newRepeat;
		boolean oldRepeatESet = repeatESet;
		repeatESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ACTION_TYPE__REPEAT, oldRepeat, repeat, !oldRepeatESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepeat() {
		long oldRepeat = repeat;
		boolean oldRepeatESet = repeatESet;
		repeat = REPEAT_EDEFAULT;
		repeatESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.ACTION_TYPE__REPEAT, oldRepeat, REPEAT_EDEFAULT, oldRepeatESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepeat() {
		return repeatESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION:
				return basicSetVisualDescription(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.ACTION_TYPE__LABEL:
				return getLabel();
			case ComponentPackage.ACTION_TYPE__REPEAT:
				return getRepeat();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.ACTION_TYPE__LABEL:
				setLabel((String)newValue);
				return;
			case ComponentPackage.ACTION_TYPE__REPEAT:
				setRepeat((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.ACTION_TYPE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case ComponentPackage.ACTION_TYPE__REPEAT:
				unsetRepeat();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentPackage.ACTION_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.ACTION_TYPE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case ComponentPackage.ACTION_TYPE__REPEAT:
				return isSetRepeat();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(", repeat: ");
		if (repeatESet) result.append(repeat); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ActionTypeImpl
