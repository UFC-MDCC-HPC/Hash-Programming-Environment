/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.ufc.mdcc.hclc.codegen.xml.component.impl;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.SourceFileType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source File Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getExternalDependency <em>External Dependency</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getFileType <em>File Type</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getSrcType <em>Src Type</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link br.ufc.mdcc.hclc.codegen.xml.component.impl.SourceFileTypeImpl#getVersionId <em>Version Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceFileTypeImpl extends EObjectImpl implements SourceFileType {
	/**
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<String> dependency;

	/**
	 * The cached value of the '{@link #getExternalDependency() <em>External Dependency</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<String> externalDependency;

	/**
	 * The default value of the '{@link #getContents() <em>Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected String contents = CONTENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileType() <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileType() <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected String fileType = FILE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrcType() <em>Src Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcType()
	 * @generated
	 * @ordered
	 */
	protected static final String SRC_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSrcType() <em>Src Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcType()
	 * @generated
	 * @ordered
	 */
	protected String srcType = SRC_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionId() <em>Version Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionId()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionId() <em>Version Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionId()
	 * @generated
	 * @ordered
	 */
	protected String versionId = VERSION_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceFileTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.SOURCE_FILE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDependency() {
		if (dependency == null) {
			dependency = new EDataTypeEList<String>(String.class, this, ComponentPackage.SOURCE_FILE_TYPE__DEPENDENCY);
		}
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExternalDependency() {
		if (externalDependency == null) {
			externalDependency = new EDataTypeEList<String>(String.class, this, ComponentPackage.SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY);
		}
		return externalDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContents(String newContents) {
		String oldContents = contents;
		contents = newContents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SOURCE_FILE_TYPE__CONTENTS, oldContents, contents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileType(String newFileType) {
		String oldFileType = fileType;
		fileType = newFileType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SOURCE_FILE_TYPE__FILE_TYPE, oldFileType, fileType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SOURCE_FILE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSrcType() {
		return srcType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcType(String newSrcType) {
		String oldSrcType = srcType;
		srcType = newSrcType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SOURCE_FILE_TYPE__SRC_TYPE, oldSrcType, srcType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SOURCE_FILE_TYPE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersionId() {
		return versionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionId(String newVersionId) {
		String oldVersionId = versionId;
		versionId = newVersionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.SOURCE_FILE_TYPE__VERSION_ID, oldVersionId, versionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.SOURCE_FILE_TYPE__DEPENDENCY:
				return getDependency();
			case ComponentPackage.SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY:
				return getExternalDependency();
			case ComponentPackage.SOURCE_FILE_TYPE__CONTENTS:
				return getContents();
			case ComponentPackage.SOURCE_FILE_TYPE__FILE_TYPE:
				return getFileType();
			case ComponentPackage.SOURCE_FILE_TYPE__NAME:
				return getName();
			case ComponentPackage.SOURCE_FILE_TYPE__SRC_TYPE:
				return getSrcType();
			case ComponentPackage.SOURCE_FILE_TYPE__URI:
				return getUri();
			case ComponentPackage.SOURCE_FILE_TYPE__VERSION_ID:
				return getVersionId();
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
			case ComponentPackage.SOURCE_FILE_TYPE__DEPENDENCY:
				getDependency().clear();
				getDependency().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY:
				getExternalDependency().clear();
				getExternalDependency().addAll((Collection<? extends String>)newValue);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__CONTENTS:
				setContents((String)newValue);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__FILE_TYPE:
				setFileType((String)newValue);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__NAME:
				setName((String)newValue);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__SRC_TYPE:
				setSrcType((String)newValue);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__URI:
				setUri((String)newValue);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__VERSION_ID:
				setVersionId((String)newValue);
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
			case ComponentPackage.SOURCE_FILE_TYPE__DEPENDENCY:
				getDependency().clear();
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY:
				getExternalDependency().clear();
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__CONTENTS:
				setContents(CONTENTS_EDEFAULT);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__FILE_TYPE:
				setFileType(FILE_TYPE_EDEFAULT);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__SRC_TYPE:
				setSrcType(SRC_TYPE_EDEFAULT);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__URI:
				setUri(URI_EDEFAULT);
				return;
			case ComponentPackage.SOURCE_FILE_TYPE__VERSION_ID:
				setVersionId(VERSION_ID_EDEFAULT);
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
			case ComponentPackage.SOURCE_FILE_TYPE__DEPENDENCY:
				return dependency != null && !dependency.isEmpty();
			case ComponentPackage.SOURCE_FILE_TYPE__EXTERNAL_DEPENDENCY:
				return externalDependency != null && !externalDependency.isEmpty();
			case ComponentPackage.SOURCE_FILE_TYPE__CONTENTS:
				return CONTENTS_EDEFAULT == null ? contents != null : !CONTENTS_EDEFAULT.equals(contents);
			case ComponentPackage.SOURCE_FILE_TYPE__FILE_TYPE:
				return FILE_TYPE_EDEFAULT == null ? fileType != null : !FILE_TYPE_EDEFAULT.equals(fileType);
			case ComponentPackage.SOURCE_FILE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentPackage.SOURCE_FILE_TYPE__SRC_TYPE:
				return SRC_TYPE_EDEFAULT == null ? srcType != null : !SRC_TYPE_EDEFAULT.equals(srcType);
			case ComponentPackage.SOURCE_FILE_TYPE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case ComponentPackage.SOURCE_FILE_TYPE__VERSION_ID:
				return VERSION_ID_EDEFAULT == null ? versionId != null : !VERSION_ID_EDEFAULT.equals(versionId);
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
		result.append(" (dependency: ");
		result.append(dependency);
		result.append(", externalDependency: ");
		result.append(externalDependency);
		result.append(", contents: ");
		result.append(contents);
		result.append(", fileType: ");
		result.append(fileType);
		result.append(", name: ");
		result.append(name);
		result.append(", srcType: ");
		result.append(srcType);
		result.append(", uri: ");
		result.append(uri);
		result.append(", versionId: ");
		result.append(versionId);
		result.append(')');
		return result.toString();
	}

} //SourceFileTypeImpl
