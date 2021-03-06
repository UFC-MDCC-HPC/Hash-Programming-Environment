/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ActionType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceParameterType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfacePortType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceSliceType;
import br.ufc.mdcc.hclc.codegen.xml.component.InterfaceType;
import br.ufc.mdcc.hclc.codegen.xml.component.SourceType;
import br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getSlice <em>Slice</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getVisualDescription <em>Visual Description</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getPort <em>Port</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getExternalReferences <em>External References</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getIRef <em>IRef</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.InterfaceTypeImpl#getNArgs <em>NArgs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceTypeImpl extends EObjectImpl implements InterfaceType {
	/**
	 * The cached value of the '{@link #getSlice() <em>Slice</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlice()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceSliceType> slice;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected ActionType protocol;

	/**
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceType> sources;

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
	 * The cached value of the '{@link #getPort() <em>Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfacePortType> port;

	/**
	 * The cached value of the '{@link #getExternalReferences() <em>External References</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<String> externalReferences;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceParameterType> parameter;

	/**
	 * The default value of the '{@link #getIRef() <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRef()
	 * @generated
	 * @ordered
	 */
	protected static final String IREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIRef() <em>IRef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIRef()
	 * @generated
	 * @ordered
	 */
	protected String iRef = IREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getNArgs() <em>NArgs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNArgs()
	 * @generated
	 * @ordered
	 */
	protected static final int NARGS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNArgs() <em>NArgs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNArgs()
	 * @generated
	 * @ordered
	 */
	protected int nArgs = NARGS_EDEFAULT;

	/**
	 * This is true if the NArgs attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nArgsESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.INTERFACE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceSliceType> getSlice() {
		if (slice == null) {
			slice = new EObjectContainmentEList<InterfaceSliceType>(InterfaceSliceType.class, this, ComponentPackage.INTERFACE_TYPE__SLICE);
		}
		return slice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType getProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProtocol(ActionType newProtocol, NotificationChain msgs) {
		ActionType oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_TYPE__PROTOCOL, oldProtocol, newProtocol);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(ActionType newProtocol) {
		if (newProtocol != protocol) {
			NotificationChain msgs = null;
			if (protocol != null)
				msgs = ((InternalEObject)protocol).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_TYPE__PROTOCOL, null, msgs);
			if (newProtocol != null)
				msgs = ((InternalEObject)newProtocol).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_TYPE__PROTOCOL, null, msgs);
			msgs = basicSetProtocol(newProtocol, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_TYPE__PROTOCOL, newProtocol, newProtocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceType> getSources() {
		if (sources == null) {
			sources = new EObjectContainmentEList<SourceType>(SourceType.class, this, ComponentPackage.INTERFACE_TYPE__SOURCES);
		}
		return sources;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION, oldVisualDescription, newVisualDescription);
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
				msgs = ((InternalEObject)visualDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			if (newVisualDescription != null)
				msgs = ((InternalEObject)newVisualDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION, null, msgs);
			msgs = basicSetVisualDescription(newVisualDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION, newVisualDescription, newVisualDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfacePortType> getPort() {
		if (port == null) {
			port = new EObjectContainmentEList<InterfacePortType>(InterfacePortType.class, this, ComponentPackage.INTERFACE_TYPE__PORT);
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExternalReferences() {
		if (externalReferences == null) {
			externalReferences = new EDataTypeEList<String>(String.class, this, ComponentPackage.INTERFACE_TYPE__EXTERNAL_REFERENCES);
		}
		return externalReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceParameterType> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<InterfaceParameterType>(InterfaceParameterType.class, this, ComponentPackage.INTERFACE_TYPE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIRef() {
		return iRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIRef(String newIRef) {
		String oldIRef = iRef;
		iRef = newIRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_TYPE__IREF, oldIRef, iRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNArgs() {
		return nArgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNArgs(int newNArgs) {
		int oldNArgs = nArgs;
		nArgs = newNArgs;
		boolean oldNArgsESet = nArgsESet;
		nArgsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.INTERFACE_TYPE__NARGS, oldNArgs, nArgs, !oldNArgsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNArgs() {
		int oldNArgs = nArgs;
		boolean oldNArgsESet = nArgsESet;
		nArgs = NARGS_EDEFAULT;
		nArgsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentPackage.INTERFACE_TYPE__NARGS, oldNArgs, NARGS_EDEFAULT, oldNArgsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNArgs() {
		return nArgsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentPackage.INTERFACE_TYPE__SLICE:
				return ((InternalEList<?>)getSlice()).basicRemove(otherEnd, msgs);
			case ComponentPackage.INTERFACE_TYPE__PROTOCOL:
				return basicSetProtocol(null, msgs);
			case ComponentPackage.INTERFACE_TYPE__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
			case ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION:
				return basicSetVisualDescription(null, msgs);
			case ComponentPackage.INTERFACE_TYPE__PORT:
				return ((InternalEList<?>)getPort()).basicRemove(otherEnd, msgs);
			case ComponentPackage.INTERFACE_TYPE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case ComponentPackage.INTERFACE_TYPE__SLICE:
				return getSlice();
			case ComponentPackage.INTERFACE_TYPE__PROTOCOL:
				return getProtocol();
			case ComponentPackage.INTERFACE_TYPE__SOURCES:
				return getSources();
			case ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION:
				return getVisualDescription();
			case ComponentPackage.INTERFACE_TYPE__PORT:
				return getPort();
			case ComponentPackage.INTERFACE_TYPE__EXTERNAL_REFERENCES:
				return getExternalReferences();
			case ComponentPackage.INTERFACE_TYPE__PARAMETER:
				return getParameter();
			case ComponentPackage.INTERFACE_TYPE__IREF:
				return getIRef();
			case ComponentPackage.INTERFACE_TYPE__NARGS:
				return new Integer(getNArgs());
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
			case ComponentPackage.INTERFACE_TYPE__SLICE:
				getSlice().clear();
				getSlice().addAll((Collection<? extends InterfaceSliceType>)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__PROTOCOL:
				setProtocol((ActionType)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends SourceType>)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__PORT:
				getPort().clear();
				getPort().addAll((Collection<? extends InterfacePortType>)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__EXTERNAL_REFERENCES:
				getExternalReferences().clear();
				getExternalReferences().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends InterfaceParameterType>)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__IREF:
				setIRef((String)newValue);
				return;
			case ComponentPackage.INTERFACE_TYPE__NARGS:
				setNArgs(((Integer)newValue).intValue());
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
			case ComponentPackage.INTERFACE_TYPE__SLICE:
				getSlice().clear();
				return;
			case ComponentPackage.INTERFACE_TYPE__PROTOCOL:
				setProtocol((ActionType)null);
				return;
			case ComponentPackage.INTERFACE_TYPE__SOURCES:
				getSources().clear();
				return;
			case ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION:
				setVisualDescription((VisualElementAttributes)null);
				return;
			case ComponentPackage.INTERFACE_TYPE__PORT:
				getPort().clear();
				return;
			case ComponentPackage.INTERFACE_TYPE__EXTERNAL_REFERENCES:
				getExternalReferences().clear();
				return;
			case ComponentPackage.INTERFACE_TYPE__PARAMETER:
				getParameter().clear();
				return;
			case ComponentPackage.INTERFACE_TYPE__IREF:
				setIRef(IREF_EDEFAULT);
				return;
			case ComponentPackage.INTERFACE_TYPE__NARGS:
				unsetNArgs();
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
			case ComponentPackage.INTERFACE_TYPE__SLICE:
				return slice != null && !slice.isEmpty();
			case ComponentPackage.INTERFACE_TYPE__PROTOCOL:
				return protocol != null;
			case ComponentPackage.INTERFACE_TYPE__SOURCES:
				return sources != null && !sources.isEmpty();
			case ComponentPackage.INTERFACE_TYPE__VISUAL_DESCRIPTION:
				return visualDescription != null;
			case ComponentPackage.INTERFACE_TYPE__PORT:
				return port != null && !port.isEmpty();
			case ComponentPackage.INTERFACE_TYPE__EXTERNAL_REFERENCES:
				return externalReferences != null && !externalReferences.isEmpty();
			case ComponentPackage.INTERFACE_TYPE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case ComponentPackage.INTERFACE_TYPE__IREF:
				return IREF_EDEFAULT == null ? iRef != null : !IREF_EDEFAULT.equals(iRef);
			case ComponentPackage.INTERFACE_TYPE__NARGS:
				return isSetNArgs();
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
		result.append(" (externalReferences: ");
		result.append(externalReferences);
		result.append(", iRef: ");
		result.append(iRef);
		result.append(", nArgs: ");
		if (nArgsESet) result.append(nArgs); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //InterfaceTypeImpl
