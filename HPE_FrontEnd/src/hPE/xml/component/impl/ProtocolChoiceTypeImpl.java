/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.PerformType;
import hPE.xml.component.ProtocolChoiceType;
import hPE.xml.component.ProtocolCombinatorVisualType;
import hPE.xml.component.ProtocolPerformVisualType;
import hPE.xml.component.ProtocolCombinatorType;
import hPE.xml.component.ProtocolPerformType;
import hPE.xml.component.ProtocolType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol Choice Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.ProtocolChoiceTypeImpl#getPar <em>Par</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ProtocolChoiceTypeImpl#getSeq <em>Seq</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ProtocolChoiceTypeImpl#getAlt <em>Alt</em>}</li>
 *   <li>{@link hPE.xml.component.impl.ProtocolChoiceTypeImpl#getPerform <em>Perform</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtocolChoiceTypeImpl extends EObjectImpl implements ProtocolChoiceType {
	/**
	 * The cached value of the '{@link #getPar() <em>Par</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPar()
	 * @generated
	 * @ordered
	 */
	protected ProtocolCombinatorVisualType par;

	/**
	 * The cached value of the '{@link #getSeq() <em>Seq</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeq()
	 * @generated
	 * @ordered
	 */
	protected ProtocolCombinatorVisualType seq;

	/**
	 * The cached value of the '{@link #getAlt() <em>Alt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlt()
	 * @generated
	 * @ordered
	 */
	protected ProtocolCombinatorVisualType alt;

	/**
	 * The cached value of the '{@link #getPerform() <em>Perform</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerform()
	 * @generated
	 * @ordered
	 */
	protected ProtocolPerformVisualType perform;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtocolChoiceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.PROTOCOL_CHOICE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolCombinatorVisualType getPar() {
		return par;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPar(ProtocolCombinatorVisualType newPar, NotificationChain msgs) {
		ProtocolCombinatorVisualType oldPar = par;
		par = newPar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR, oldPar, newPar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPar(ProtocolCombinatorVisualType newPar) {
		if (newPar != par) {
			NotificationChain msgs = null;
			if (par != null)
				msgs = ((InternalEObject)par).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR, null, msgs);
			if (newPar != null)
				msgs = ((InternalEObject)newPar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR, null, msgs);
			msgs = basicSetPar(newPar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR, newPar, newPar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolCombinatorVisualType getSeq() {
		return seq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSeq(ProtocolCombinatorVisualType newSeq, NotificationChain msgs) {
		ProtocolCombinatorVisualType oldSeq = seq;
		seq = newSeq;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ, oldSeq, newSeq);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeq(ProtocolCombinatorVisualType newSeq) {
		if (newSeq != seq) {
			NotificationChain msgs = null;
			if (seq != null)
				msgs = ((InternalEObject)seq).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ, null, msgs);
			if (newSeq != null)
				msgs = ((InternalEObject)newSeq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ, null, msgs);
			msgs = basicSetSeq(newSeq, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ, newSeq, newSeq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolCombinatorVisualType getAlt() {
		return alt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlt(ProtocolCombinatorVisualType newAlt, NotificationChain msgs) {
		ProtocolCombinatorVisualType oldAlt = alt;
		alt = newAlt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT, oldAlt, newAlt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlt(ProtocolCombinatorVisualType newAlt) {
		if (newAlt != alt) {
			NotificationChain msgs = null;
			if (alt != null)
				msgs = ((InternalEObject)alt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT, null, msgs);
			if (newAlt != null)
				msgs = ((InternalEObject)newAlt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT, null, msgs);
			msgs = basicSetAlt(newAlt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT, newAlt, newAlt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolPerformVisualType getPerform() {
		return perform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerform(ProtocolPerformVisualType newPerform, NotificationChain msgs) {
		ProtocolPerformVisualType oldPerform = perform;
		perform = newPerform;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM, oldPerform, newPerform);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerform(ProtocolPerformVisualType newPerform) {
		if (newPerform != perform) {
			NotificationChain msgs = null;
			if (perform != null)
				msgs = ((InternalEObject)perform).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM, null, msgs);
			if (newPerform != null)
				msgs = ((InternalEObject)newPerform).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM, null, msgs);
			msgs = basicSetPerform(newPerform, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM, newPerform, newPerform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR:
				return basicSetPar(null, msgs);
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ:
				return basicSetSeq(null, msgs);
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT:
				return basicSetAlt(null, msgs);
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM:
				return basicSetPerform(null, msgs);
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
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR:
				return getPar();
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ:
				return getSeq();
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT:
				return getAlt();
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM:
				return getPerform();
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
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR:
				setPar((ProtocolCombinatorVisualType)newValue);
				return;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ:
				setSeq((ProtocolCombinatorVisualType)newValue);
				return;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT:
				setAlt((ProtocolCombinatorVisualType)newValue);
				return;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM:
				setPerform((ProtocolPerformVisualType)newValue);
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
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR:
				setPar((ProtocolCombinatorVisualType)null);
				return;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ:
				setSeq((ProtocolCombinatorVisualType)null);
				return;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT:
				setAlt((ProtocolCombinatorVisualType)null);
				return;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM:
				setPerform((ProtocolPerformVisualType)null);
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
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PAR:
				return par != null;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__SEQ:
				return seq != null;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__ALT:
				return alt != null;
			case ComponentPackage.PROTOCOL_CHOICE_TYPE__PERFORM:
				return perform != null;
		}
		return super.eIsSet(featureID);
	}

} //ProtocolChoiceTypeImpl
