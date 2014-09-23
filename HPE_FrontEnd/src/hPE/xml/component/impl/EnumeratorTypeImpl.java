/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hPE.xml.component.impl;

import hPE.xml.component.ComponentPackage;
import hPE.xml.component.EnumerableType;
import hPE.xml.component.EnumeratorFromRecursionType;
import hPE.xml.component.EnumeratorType;
import hPE.xml.component.VisualElementAttributes;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerator Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#getOriginRef <em>Origin Ref</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#getFromRecursion <em>From Recursion</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#isFromSplit <em>From Split</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link hPE.xml.component.impl.EnumeratorTypeImpl#getVarId <em>Var Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumeratorTypeImpl extends MinimalEObjectImpl.Container implements EnumeratorType {
	/**
	 * The cached value of the '{@link #getOriginRef() <em>Origin Ref</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginRef()
	 * @generated
	 * @ordered
	 */
	protected EList<String> originRef;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerableType> links;

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
	 * The cached value of the '{@link #getFromRecursion() <em>From Recursion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromRecursion()
	 * @generated
	 * @ordered
	 */
	protected EnumeratorFromRecursionType fromRecursion;

	/**
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int CARDINALITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected int cardinality = CARDINALITY_EDEFAULT;

	/**
	 * This is true if the Cardinality attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cardinalityESet;

	/**
	 * The default value of the '{@link #isFromSplit() <em>From Split</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFromSplit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FROM_SPLIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFromSplit() <em>From Split</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFromSplit()
	 * @generated
	 * @ordered
	 */
	protected boolean fromSplit = FROM_SPLIT_EDEFAULT;

	/**
	 * This is true if the From Split attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fromSplitESet;

	/**
	 * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected String ref = REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarId() <em>Var Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarId()
	 * @generated
	 * @ordered
	 */
	protected static final String VAR_ID_EDEFAULT = "*";

	/**
	 * The cached value of the '{@link #getVarId() <em>Var Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarId()
	 * @generated
	 * @ordered
	 */
	protected String varId = VAR_ID_EDEFAULT;

	/**
	 * This is true if the Var Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean varIdESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumeratorTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.ENUMERATOR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOriginRef() {
		if (originRef == null) {
			originRef = new EDataTypeEList<String>(String.class, this, ComponentPackage.ENUMERATOR_TYPE__ORIGIN_REF);
		}
		return originRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumerableType> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<EnumerableType>(EnumerableType.class, this, ComponentPackage.ENUMERATOR_TYPE__LINKS);
		}
		return links;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
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
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumeratorFromRecursionType getFromRecursion() {
		return fromRecursion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromRecursion(EnumeratorFromRecursionType newFromRecursion, NotificationChain msgs) {
		EnumeratorFromRecursionType oldFromRecursion = fromRecursion;
		fromRecursion = newFromRecursion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION, oldFromRecursion, newFromRecursion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromRecursion(EnumeratorFromRecursionType newFromRecursion) {
		if (newFromRecursion != fromRecursion) {
			NotificationChain msgs = null;
			if (fromRecursion != null)
				msgs = ((InternalEObject)fromRecursion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION, null, msgs);
			if (newFromRecursion != null)
				msgs = ((InternalEObject)newFromRecursion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION, null, msgs);
			msgs = basicSetFromRecursion(newFromRecursion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION, newFromRecursion, newFromRecursion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCardinality() {
		return cardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardinality(int newCardinality) {
		int oldCardinality = cardinality;
		cardinality = newCardinality;
		boolean oldCardinalityESet = cardinalityESet;
		cardinalityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__CARDINALITY, oldCardinality, cardinality, !oldCardinalityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCardinality() {
		int oldCardinality = cardinality;
		boolean oldCardinalityESet = cardinalityESet;
		cardinality = CARDINALITY_EDEFAULT;
		cardinalityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.ENUMERATOR_TYPE__CARDINALITY, oldCardinality, CARDINALITY_EDEFAULT, oldCardinalityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCardinality() {
		return cardinalityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFromSplit() {
		return fromSplit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromSplit(boolean newFromSplit) {
		boolean oldFromSplit = fromSplit;
		fromSplit = newFromSplit;
		boolean oldFromSplitESet = fromSplitESet;
		fromSplitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__FROM_SPLIT, oldFromSplit, fromSplit, !oldFromSplitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFromSplit() {
		boolean oldFromSplit = fromSplit;
		boolean oldFromSplitESet = fromSplitESet;
		fromSplit = FROM_SPLIT_EDEFAULT;
		fromSplitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.ENUMERATOR_TYPE__FROM_SPLIT, oldFromSplit, FROM_SPLIT_EDEFAULT, oldFromSplitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFromSplit() {
		return fromSplitESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(String newRef) {
		String oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVarId() {
		return varId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarId(String newVarId) {
		String oldVarId = varId;
		varId = newVarId;
		boolean oldVarIdESet = varIdESet;
		varIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.ENUMERATOR_TYPE__VAR_ID, oldVarId, varId, !oldVarIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVarId() {
		String oldVarId = varId;
		boolean oldVarIdESet = varIdESet;
		varId = VAR_ID_EDEFAULT;
		varIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.ENUMERATOR_TYPE__VAR_ID, oldVarId, VAR_ID_EDEFAULT, oldVarIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVarId() {
		return varIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.ENUMERATOR_TYPE__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION:
				return basicSetVisualDescription(null, msgs);
			case ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION:
				return basicSetFromRecursion(null, msgs);
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
			case ComponentPackage.ENUMERATOR_TYPE__ORIGIN_REF:
				return getOriginRef();
			case ComponentPackage.ENUMERATOR_TYPE__LINKS:
				return getLinks();
			case ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION:
				return getFromRecursion();
			case ComponentPackage.ENUMERATOR_TYPE__CARDINALITY:
				return getCardinality();
			case ComponentPackage.ENUMERATOR_TYPE__FROM_SPLIT:
				return isFromSplit();
			case ComponentPackage.ENUMERATOR_TYPE__REF:
				return getRef();
			case ComponentPackage.ENUMERATOR_TYPE__VAR_ID:
				return getVarId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.ENUMERATOR_TYPE__ORIGIN_REF:
				getOriginRef().clear();
				getOriginRef().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends EnumerableType>)newValue);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION:
				setFromRecursion((EnumeratorFromRecursionType)newValue);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__CARDINALITY:
				setCardinality((Integer)newValue);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__FROM_SPLIT:
				setFromSplit((Boolean)newValue);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__REF:
				setRef((String)newValue);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__VAR_ID:
				setVarId((String)newValue);
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
			case ComponentPackage.ENUMERATOR_TYPE__ORIGIN_REF:
				getOriginRef().clear();
				return;
			case ComponentPackage.ENUMERATOR_TYPE__LINKS:
				getLinks().clear();
				return;
			case ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION:
				setFromRecursion((EnumeratorFromRecursionType)null);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__CARDINALITY:
				unsetCardinality();
				return;
			case ComponentPackage.ENUMERATOR_TYPE__FROM_SPLIT:
				unsetFromSplit();
				return;
			case ComponentPackage.ENUMERATOR_TYPE__REF:
				setRef(REF_EDEFAULT);
				return;
			case ComponentPackage.ENUMERATOR_TYPE__VAR_ID:
				unsetVarId();
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
			case ComponentPackage.ENUMERATOR_TYPE__ORIGIN_REF:
				return originRef != null && !originRef.isEmpty();
			case ComponentPackage.ENUMERATOR_TYPE__LINKS:
				return links != null && !links.isEmpty();
			case ComponentPackage.ENUMERATOR_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.ENUMERATOR_TYPE__FROM_RECURSION:
				return fromRecursion != null;
			case ComponentPackage.ENUMERATOR_TYPE__CARDINALITY:
				return isSetCardinality();
			case ComponentPackage.ENUMERATOR_TYPE__FROM_SPLIT:
				return isSetFromSplit();
			case ComponentPackage.ENUMERATOR_TYPE__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case ComponentPackage.ENUMERATOR_TYPE__VAR_ID:
				return isSetVarId();
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
		result.append(" (originRef: ");
		result.append(originRef);
		result.append(", cardinality: ");
		if (cardinalityESet) result.append(cardinality); else result.append("<unset>");
		result.append(", fromSplit: ");
		if (fromSplitESet) result.append(fromSplit); else result.append("<unset>");
		result.append(", ref: ");
		result.append(ref);
		result.append(", varId: ");
		if (varIdESet) result.append(varId); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EnumeratorTypeImpl
