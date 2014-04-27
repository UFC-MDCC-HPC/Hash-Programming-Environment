package hPE.frontend.base.model;

import hPE.HPEProperties;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IComputationConfiguration;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.ui.preferences.PreferenceConstants;
import hPE.util.CommandLine;
import hPE.util.NullObject;
import hPE.util.ObjectInputStream_;
import hPE.util.ObjectOutputStream_;
import hPE.util.Pair;
import hPE.xml.factory.HComponentFactoryImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.graphics.Color;

public abstract class HComponent extends HVisualElement implements HNamed,
		Cloneable, IComponent, Serializable, IHasColor,
		IComputationConfiguration {

	public final static String UPDATE_CONFIGURATION = "UPDATE_CONFIGURATION";

	static final long serialVersionUID = 1;

	private List<Integer[]> versions = null;

	private int currentVersion = -1;

	public boolean containsVersion(Integer[] version) {

		List<Integer[]> versions = this.getVersions();

		for (Integer[] v : versions) {
			if (v[0] == version[0] && v[1] == version[1] && v[2] == version[2]
					&& v[3] == version[3])
				return true;
		}

		return false;
	}

	public void setVersions(List<Integer[]> versions) {
		this.versions = versions;
	}

	public List<Integer[]> getVersions() {
		if (versions == null) {
			versions = new ArrayList<Integer[]>();
			versions.add(new Integer[] { 1, 0, 0, 0 });
			currentVersion = 0;
		}

		return versions;
	}

	public void newVersion(Integer[] version) {
		if (versions == null) {
			versions = new ArrayList<Integer[]>();
			versions.add(version);
			currentVersion = 0;
		} else {
			versions.add(version);
			currentVersion = versions.indexOf(version);
		}
	}

	public Integer[] getCurrentVersion() {
		if (versions == null) {
			versions = new ArrayList<Integer[]>();
			versions.add(new Integer[] { 1, 0, 0, 0 });
			currentVersion = 0;
		}
		return getVersions().get(currentVersion);
	}

	private String myPackage = null;

	public void setPackagePath(IPath myPackage) {
		this.myPackage = myPackage.toPortableString();
	}

	public IPath getPackagePath() {
		return new Path(this.myPackage);
	}

	public boolean versionSupplied(String version) {

		for (HInterface i : this.getInterfaces()) {
			if (i.getConfiguration() == this) {
				HBESourceVersion<HBEAbstractFile> srcVersion = i
						.getSourceVersion(version);
				if (srcVersion == null || srcVersion.getFiles().isEmpty())
					return false;
			}
		}

		return true;
	}

	// TODO: EXISTENTIAL TYPE
	// private boolean existentialType = false;

	// public boolean isExistentialType() {
	// return existentialType && isParameter();
	// }

	private Map<HComponent, String> lOriginalInnerCRef = new HashMap<HComponent, String>();

	private String innerCRef = "";

	public void saveName() {
		if (this.lOriginalInnerCRef == null)
			lOriginalInnerCRef = new HashMap<HComponent, String>();
		HComponent c = this.getTopParentConfigurations().get(0); // saveName is
																	// always
																	// called
																	// before
																	// fusion
																	// ...
		this.lOriginalInnerCRef.put(c, this.innerCRef);
	}

	public void setSavedName(Map<HComponent, String> names) {
		if (this.lOriginalInnerCRef == null)
			lOriginalInnerCRef = new HashMap<HComponent, String>();
		this.lOriginalInnerCRef.putAll(names);
		// for (Entry<HComponent,String> n : names.entrySet())
		// if (!this.lOriginalInnerCRef.containsKey(n.getKey()))
		// this.lOriginalInnerCRef.put(n.getKey(),n.getValue());
	}

	public Map<HComponent, String> getSavedName() {
		if (this.lOriginalInnerCRef == null)
			lOriginalInnerCRef = new HashMap<HComponent, String>();
		return this.lOriginalInnerCRef;
	}

	public String getName2() {
		if (innerCRef == null)
			innerCRef = "";
		return innerCRef;
	}

	public void setName(String innerCRef) {
		HComponent parentC = (HComponent) this.getTopConfiguration();
		if (parentC == null || parentC.checkLegalRef(innerCRef)) {
			this.innerCRef = innerCRef;
			listeners.firePropertyChange(UPDATE_NAME, null, name); //$NON-NLS-2$//$NON-NLS-1$
		}
	}

	public boolean isNewNameValid(String name) {
		return name != null;
	}

	/**
	 * @uml.property name="interfaces"
	 * @uml.associationEnd readOnly="true" multiplicity="(0 -1)"
	 *                     inverse="configuration:hPE.base.model.HInterface"
	 */
	private Collection<HInterface> interfaces = new ArrayList<HInterface>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#getInterfaces()
	 */
	public Collection<HInterface> getInterfaces() {
		return interfaces;
	}

	/**
	 * @uml.property name="units"
	 * @uml.associationEnd readOnly="true" multiplicity="(0 -1)"
	 *                     inverse="configuration:hPE.base.model.HUnit"
	 */
	private List<IHUnit> units = new ArrayList<IHUnit>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#getUnits()
	 */
	public List<IHUnit> getUnits() {
		return units;		
	}

	/*
	 * return the list of units and clones of units. The cloned unit is not
	 * returned with its clones.
	 */
	public List<IHUnit> getAllUnits() 
	{
		List<IHUnit> ls = new ArrayList<IHUnit>();
		for (IHUnit u : this.getUnits()) 
		{
			ls.add((IHUnit) u);
		}
		return ls;
	}

	public final static String PROPERTY_INHERITS = "PROPERTY_INHERITS";

	public void setExtends(HComponent inheritedFrom) {

		List<IHUnit> us = ((List<IHUnit>) ((ArrayList<IHUnit>) inheritedFrom.getAllUnits()).clone());

		for (IHUnit the_source : us) {
			HComponent c = (HComponent) the_source.getConfiguration();

			if (!the_source.getHidden()) {
				IBindingTarget the_target = c.newStubFor((HUnit) the_source,
						true, false, (HComponent) c.getConfiguration());
				new HBinding(c, the_target, the_source); // TODO: setBinding ...
															// antes estava
															// HBinding(c,the_source,the_target)
				HInterface i = (HInterface) the_source.getInterface();
				i.setExtends();
				for (HPort p : i.getPorts()) {
					p.setInherited(true);
				}
				// i.setName(null);
				// i.setEditable(false);
				// if (!this.isAbstractConfiguration())
				// i.setEditableSource(true);
				for (HUnitSlice uss : the_source.getSlices()) {
					uss.setHiddenSlice(true);
				}

			}
		}

		inheritedFrom.setSuperType(true);
		inheritedFrom.setExposed(false);

		listeners.firePropertyChange(PROPERTY_INHERITS, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	public final static String PROPERTY_CONCRETE_CONFIGURATION = "CONCRETE_CONFIGURATION";

	private HComponent itImplements = null;

	public void setImplements(HComponent itImplements) {

		this.itImplements = itImplements;

		List<IHUnit> us = ((List<IHUnit>) ((ArrayList<IHUnit>) itImplements.getAllUnits()).clone());

		for (IHUnit the_source : us) {
			HComponent c = (HComponent) the_source.getConfiguration();
			if (!the_source.getHidden()) {
				IBindingTarget the_target = c.newStubFor((HUnit) the_source,
						false, true, (HComponent) c.getTopConfiguration());
				new HBinding(c, the_target, the_source); // TODO: setBindig ...
				HInterface i = (HInterface) the_target.getInterface();
				i.setImplements(); // mark versions to be overriden ...
				try {
					((HUnit) the_source).updatePorts();
				} catch (HPEAbortException e) {
					e.printStackTrace();
				}
			}
		}

		listeners.firePropertyChange(PROPERTY_CONCRETE_CONFIGURATION, null,name); //$NON-NLS-2$//$NON-NLS-1$		

	}

	private static int IS_UNDEFINED = -1;
	private static int IS_ABSTRACT = 0;
	private static int IS_CONCRETE = 1;

	private int isAbstract = IS_UNDEFINED;

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract ? IS_ABSTRACT : IS_CONCRETE;
		listeners.firePropertyChange(PROPERTY_CONCRETE_CONFIGURATION, null,
				name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	public boolean isAbstract() {
		return isAbstract == IS_ABSTRACT;
	}

	public boolean isAbstractConfiguration() {
		this.isAbstract = this.isAbstract == IS_UNDEFINED ? (forceIsAbstractConfiguration() ? IS_ABSTRACT
				: IS_CONCRETE)
				: isAbstract;
		return this.isAbstract == IS_ABSTRACT;
	}

	private boolean forceIsAbstractConfiguration() {

		if (this.getSuperType() == null) {
			return this.itImplements == null;
		} else {
			HComponent c = this.getSuperType();
			return c.isAbstractConfiguration();
		}

	}

	public HComponent getWhoItImplements() {

		if (this.getSuperType() == null) {
			return this.itImplements;
		} else {
			HComponent c = this.getSuperType();
			return c.getWhoItImplements();
		}
	}

	public IHUnit fetchUnit(String uName) {

		for (IHUnit u : this.getUnits())
			if (u.getName2().equals(uName))
				return u;

		return null;
	}

	public IHUnit fetchUnitByBaseName(String uName) {

		for (IHUnit u : this.getUnits())
			if (u.getBaseName().equals(uName))
				return u;

		return null;
	}
	
	public IHUnit fetchUnit(String uName, int iReplica) {

		for (IHUnit u : this.getUnits())
			if (u.getName2().equals(uName))
			{
				for (IHPrimUnit uu : u.getClones()) 
				{
					if (uu.getSliceReplicaIndex() == iReplica) 
						return (IHUnit) uu;
				}
			}

		return null;
	}

	public IBindingTarget createBinding(IHUnit the_source, IHUnit the_unit, Point where) throws HPEAbortException {

		if (the_unit.getInterface() != null
				&& !the_unit.isInterfaceEditable()) {
			throw new HPEAbortException("Non Editable Interface !");
		}

		IBindingTarget the_target = the_source.newSlice(the_unit, where);

		HInterface i = (HInterface) the_source.getInterface();
		i.setEditable(false);
		i.resetDefaultPortNames();

		new HBinding(this, the_target, the_source);
        if (the_source.isMultiple())
        	the_unit.setMultiple(true);
        else if (the_unit.isMultiple())
        {
            // The inner component thant owns the slice the_source must be multiple ... 
        }

		// Ao criar uma fatia, � necess�rio atualizar as portas da interfce
		// para gerar as portas associadas a fatia sempre que o componente interno
		// for p�blico.
		try {
			updatePorts();
		} catch (HPEAbortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return the_target;

	}

	/**
	 * @uml.property name="name" readOnly="true"
	 */
	private String name = "";

	public String getComponentName() {
		return name;
	}

	public void setComponentName(String name) {
		this.name = name;
		listeners.firePropertyChange(UPDATE_NAME, null, name); //$NON-NLS-2$//$NON-NLS-1$	

	}

	private static int lastInstanceId = 0;
	private static Map<Integer, HComponent> all_instances = new HashMap<Integer, HComponent>();

	private int myInstanceId = -1;

	synchronized private static void addInstance(HComponent c) {
		c.myInstanceId = lastInstanceId++;
		all_instances.put(c.getMyInstanceId(), c);
	}

	/**
	 * @param existentialType
	 *            TODO
	 */
	public HComponent(String name, IPackageLocation location, URI uri) {
		super();
		addInstance(this);
		this.name = name;
		this.location = location;
		this.setLocalURI(uri);

		listeners = new PropertyChangeSupport(this);
	}

	public HComponent(String name, IPackageLocation location, URI uriLocal,
			URI uriRemote) {
		super();
		addInstance(this);
		this.name = name;
		this.location = location;
		this.setLocalURI(uriLocal);
		this.setRemoteURI(uriRemote);

		listeners = new PropertyChangeSupport(this);
	}

	private String uriLocal = null;

	private String uriRemote = null;

	private void setLocalURI(URI uri) {
		this.uriLocal = uri.toString();
	}

	public void setRemoteURI(URI uri) {
		if (uri != null) {
			this.uriRemote = uri.toString();
		} else {
			this.uriRemote = null;
		}
	}

	// public final static String PROPERTY_EXISTENTIAL = "PROPERTY_EXISTENTIAL";

	// public void setExistentialType(boolean existentialType) {
	// this.existentialType = existentialType;
	//		listeners.firePropertyChange(PROPERTY_EXISTENTIAL, null, name); //$NON-NLS-2$//$NON-NLS-1$	
	// }

	/**
	 * @uml.property name="components"
	 * @uml.associationEnd readOnly="true" multiplicity="(0 -1)"
	 *                     inverse="configuration:hPE.model.HComponent"
	 */
	private List<HComponent> components = new ArrayList<HComponent>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#getComponents()
	 */
	public List<HComponent> getComponents() {
		return components;
	}

	public Collection<HComponent> getExposedComponents() 
	{
		Collection<HComponent> cs = new ArrayList<HComponent>();

		for (HComponent c : this.getComponents()) 
		{
			HComponent cx = (HComponent) (c.getSupplier() == null ? c : c.getSupplier());
			if (!c.isHiddenInnerComponent()) {
				
				if (!c.isSuperType() && (c.isPublic() || (!c.isPublic() && c.IsExposedFalsifiedContextTop()))) 
				{
					if (!cs.contains(c))
					{
						cs.add(c);
					}
				}

				if (cx == c) {
					for (HComponent c_ : c.getExposedComponents()) {
						if (!cs.contains(c_))
							cs.add(c_);
					}
				} else {
					for (HComponent cx_ : c.getExposedComponents()) {
						//HComponent cx__ = (HComponent) (cx_.getSupplier() == null ? cx_ : cx_.getSupplier());
						String n1 = cx_.getSavedName().get(cx);
						
						
						HComponent cx_prime = cx.getInnerComponent(n1);
						cx_prime = cx_prime == null ? cx_ : cx_prime /*(cx_prime.getSupplier() == null ? cx_prime : cx_prime.getSupplier())*/;

						if (cx_prime != null && !cs.contains(cx_prime) && (cx_.isPublic() || (!cx_.isPublic() && cx_.IsExposedFalsifiedContextTop())))
							cs.add(cx_prime);
					}
				}
			}
		
		}

		List<HComponent> cs_ = new ArrayList<HComponent>();
		if (cs != null) 
		{
			for (HComponent c : cs) 
			{
				List<HComponent> fusion_components = this.getFusionComponents(c.getRef());
				if (fusion_components == null || !fusion_components.contains(c) || fusion_components.get(0) == c ) 
				{
					cs_.add(c);
				}
			}
		}
		
		return cs_;
	}

	public HComponent getInnerComponent(String ref) 
	{
		for (HComponent c : this.getInnerComponents()) 
		{
			try 
			{
				// if (c.getRef().equals(ref)) return c;
				if (!c.getSavedName().isEmpty()) {
					if (/*c.getSavedName().containsKey(this) && */ c.getSavedName().get(this).equals(ref))
						return c;
				} else {
					if (c.getRef().equals(ref))
						return c;
				}
			}
			catch (NullPointerException e)
			{
				System.out.print(true);
			}
		}
		return null;
	}

	public List<HComponent> getInnerComponents() {
		return getInnerComponents(this);
	}

	public List<HComponent> getInnerComponents(HComponent context) {

		List<HComponent> cs = new ArrayList<HComponent>();

		for (HComponent c : this.getComponents()) {
			if (!c.isSuperType()
					&& this.getWhoItImplements() != c
					&& (c.isPublic() || (!c.isPublic()
							&& (c.IsExposedFalsifiedContext(context)) || context
							.getComponents().contains(c)))) {
				if (!cs.contains(c))
					cs.add(c);
				for (HComponent c_ : c.getInnerComponents(context)) {
					if (cs.contains(c_))
						cs.remove(c_);
					cs.add(c_);
				}
			} else { /* if (c.isSuperType() || this.getWhoItImplements() == c){ */
				for (HComponent c_ : c.getInnerComponents(c)) {
					if (cs.contains(c_))
						cs.remove(c_);
					cs.add(c_);
				}
			}
		}

		return cs;
	}

	/**
	 */
	public void addComponent(HComponent component) {
		if (!components.contains(component)) {
			components.add(component);
		}
	}

	public void addComponent(HComponent component, int i) {
		if (!components.contains(component)) {
			components.add(i, component);
		}
	}

	public void newUnit(IHUnit unit) {
		units.add(unit);
		listeners.firePropertyChange(NEW_UNIT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	public abstract HUnit createUnit(); /*
										 * { return new HUnit(null,this); }
										 */

	public void newInterface(HInterface the_interface) {

		List<HComponent> l = new ArrayList<HComponent>();

		l.add(this);
		// HComponent c = this;
		do {
			HComponent c = (HComponent) l.get(0); // c.getConfiguration();
			l.remove(0);
			if (!c.interfaces.contains(the_interface))
				c.interfaces.add(the_interface);
			l.addAll(c.getDirectParentConfigurations());
		} while (!l.isEmpty());

		listeners.firePropertyChange(NEW_INTERFACE, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}


	/**
	 * @uml.property name="bindings"
	 * @uml.associationEnd readOnly="true" multiplicity="(0 -1)"
	 *                     inverse="configuration:hPE.base.model.HBinding"
	 */
	private Collection<HBinding> bindings = new ArrayList<HBinding>();

	/**
	 * Getter of the property <tt>bindings</tt>
	 * 
	 * @return Returns the bindings.
	 * @uml.property name="bindings"
	 */
	public Collection<HBinding> getBindings() {
		return bindings;
	}

	/**
	 */
	public void newBinding(HBinding binding) {
		bindings.add(binding);
	}

	public void liftStubs() {
		for (IHUnit u : ((List<IHUnit>) ((ArrayList<IHUnit>) this.getAllUnits()).clone())) {
			for (HBinding b : u.getBindings()) {
				if (b.getPort() instanceof HUnitStub)
					u.unsetBinding();
			}
		}
	}

	/**
	 */

	private PropertyChangeSupport listeners;

	public final static String NEW_UNIT = "create_unit";
	public final static String NEW_REPLICATOR = "create_replicator";
	public final static String NEW_INTERFACE = "NEW_INTERFACE";
	public final static String NEW_COMPONENT = "NEW_COMPONENT";
	public final static String UPDATE_NAME = "UPDATE_NAME";
	public final static String UPDATE_COLOR = "UPDATE_COLOR";
	public final static String CHANGE_MULTIPLE = "change_multiple";

	/**
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	/**
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}

	public void unlinkUnit(IHUnit unit) {
		units.remove(unit);
		listeners.firePropertyChange(NEW_UNIT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}


	public void removeInterface(HHasExternalReferences i) {

		List<HComponent> l = new ArrayList<HComponent>();

		l.add(this);

		do {
			HComponent c = l.get(0);
			l.remove(0);
			c.interfaces.remove(i);
			l.addAll(c.getDirectParentConfigurations());
		} while (!l.isEmpty());

		listeners.firePropertyChange(NEW_INTERFACE, null, name); //$NON-NLS-2$//$NON-NLS-1$		

	}

	public void refresh() {
		listeners.firePropertyChange(UPDATE_CONNECTIONS, null, name);
	}

	public void updateUnits() {
		listeners.firePropertyChange(NEW_UNIT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	protected IComponent findComponentByName(String name) {

		for (IComponent c : this.components) {
			if (c.getComponentName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	/*
	 * public void updateInterfaceName(HPrimInterface i) {
	 * 
	 * HConfiguration c = this; String indexName = i.getIndexName(); while
	 * (c!=null) { if (c.iHMap.containsKey(indexName)) {
	 * c.iHMap.remove(indexName); c.iHMap.put(i.toString(),i); } else {
	 * System.out
	 * .println("ERROR: Interface NOT found ! HConfiguration (updateInterfaceName)"
	 * ); } c = (HConfiguration) c.getConfiguration(); }
	 * i.setIndexName(i.toString());
	 * 
	 * }
	 */

	public void updateVariableName(String formFieldId, String varName) {

		Map<String, List<HComponent>> m = this.getParameters();
		if (m.containsKey(formFieldId)) {
			for (HComponent cUpdate : m.get(formFieldId))
				cUpdate.setVariableName(varName);

		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"Parameter ID "
									+ formFieldId
									+ " (variable name = "
									+ varName
									+ " not found when loading component. Please, check the configuration !",
							"Invalid Operation", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void loadComponent(HComponent c, Point where) {

		c.hideAllInterfaces();
		if (c.getRef() == null || c.getRef().equals("")) {
			c.setName(this.generateFreshRef());
		}

		c.setConfiguration(this);
		this.addComponent(c);

		int i = this.getUnits().size();

		Rectangle bounds = new Rectangle(where, new Dimension(100, 60));
		bounds.translate(0, (i - 1) * 50);
		c.setBounds(bounds);

		c.adjustBoundsForReusingComponent();

		c.liftInterfaces();

		for (IHUnit u : c.getUnits()) {
			for (HUnitSlice s : u.getSlices()) {
				s.setHiddenSlice(true);
			}
		}

		List<String> varsToRename = new ArrayList<String>();
		List<String> varsAdded = new ArrayList<String>();

		varsToRename.removeAll(varsAdded);


		c.liftStubs();

		for (HComponent _c : c.getExposedComponents()) {
			_c.saveName();
		}

		if (c.isRecursiveComponent()) {
			c.configureRecursion();
		}

		// for (HComponent cc : c.getAllInnerConfigurations()) {
		// cc.setVariableName(cc.getVariableName(c));
		// }

		HComponent topC = (HComponent) this.getTopConfiguration();

		// SET THE CONTEXT OF VARIABLES OF INNER COMPONENTS
		Map<String, List<HComponent>> pars = c.getParameters();
		for (Entry<String, List<HComponent>> e : pars.entrySet()) {
			for (HComponent cc : e.getValue()) {
				if (cc.getVariableName(topC).equals("?"))
					cc.setVariableName(cc.getVariableName(c));
			}
		}

		listeners.firePropertyChange(NEW_COMPONENT, null, name);
		listeners.firePropertyChange(UPDATE_NAME, null, name);
	}

	public void injectComponent(HComponent c, int i) {

		c.setConfiguration(this);
		this.addComponent(c, i);

		c.liftInterfaces();

	}


	private void liftInterfaces() {
		HComponent c = (HComponent) this.getTopConfiguration(); // TODO
																// (getConfiguration):
																// from
																// getConfiguration
																// to
																// getTopConfiguration,
																// supposing
																// that
																// liftInterfaces
																// is always
																// called in
																// relation to
																// the top
																// configuration

		for (HInterface i : this.getInterfaces()) {
			c.newInterface(i);
			i.setEditable(false);
		}
	}

	public void hideAllInterfaces() {
		/*
		 * Iterator us = this.getUnits().iterator(); while (us.hasNext()) {
		 * HUnit u = (HUnit) us.next(); u.hideInterface(); }
		 */
		Iterator is = this.getInterfaces().iterator();
		while (is.hasNext()) {
			HInterface i = (HInterface) is.next();
			i.forceHide();
		}
	}

	public void setConfiguration(HComponent configuration) {
		if (configurations == null)
			configurations = new ArrayList<HComponent>();
		this.configurations.add(configuration);
	}

	public void removeComponent(HComponent c1) {
		List<HComponent> Cs = new ArrayList<HComponent>(
				((HComponent) this.getTopConfiguration())
						.getAllInnerConfigurations());

		List<HComponent> Cs_ = c1.getAllInnerConfigurations();
		// Nessa linha foi corrigido um erro em 19Mar2010. Ao inv�s de "c1",
		// tinha "this".
		// Sintoma: N�o reconhecia o par�metro de contexto ...

		Cs.removeAll(Cs_);
		this.removeComponent(c1, Cs, c1);
		listeners.firePropertyChange(UPDATE_NAME, null, name); //$NON-NLS-2$//$NON-NLS-1$
	}

	public void removeComponent(HComponent the_component, List<HComponent> C,
			HComponent c1) {

		components.remove(the_component);
		the_component.unsetConfiguration(this);

		if (the_component.canRemoveMe(C, c1)) {

			the_component.isRemoved = true;

			List<HComponent> lc = new ArrayList<HComponent>();
			lc.addAll(the_component.getComponents());

			for (HComponent c : lc) {
				the_component.removeComponent(c, C, c1);
			}


			// Clean interfaces.
			for (HInterface i : ((List<HInterface>) ((ArrayList<HInterface>) the_component
					.getInterfaces()).clone())) {
				i.removeLinksInConfiguration(the_component);
				this.removeInterface(i);
			}

		}

		listeners.firePropertyChange(NEW_COMPONENT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	public void removeComponent2(HComponent the_component) {


		// Clean interfaces.
		for (HInterface i : ((List<HInterface>) ((ArrayList<HInterface>) the_component
				.getInterfaces()).clone())) {
			i.removeLinksInConfiguration(the_component);
			this.removeInterface(i);
		}

		components.remove(the_component);
		the_component.unsetConfiguration(this);
		the_component.isRemoved = true;

		((HComponent) this.getTopConfiguration()).fireEvent(NEW_COMPONENT);

	}

	private void fireEvent(String event) {

		listeners.firePropertyChange(event, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	private boolean isRemoved = false;

	public boolean isRemoved() {
		return isRemoved;
	}

	public void unsetConfiguration(HComponent c) {
		this.configurations.remove(c);
	}

	public final static String SUPPLY_PARAMETER = "SUPPLY_PARAMETER";

	public void invalidateInterfaceNames() {

		for (HInterface i : this.getInterfaces()) {
			i.setName(i.getPrimName());
		}

		listeners.firePropertyChange(SUPPLY_PARAMETER, null, name); //$NON-NLS-2$//$NON-NLS-1$		

	}

	public List<HComponent> getAllInnerConfigurations() {

		List<HComponent> ls = new ArrayList<HComponent>();
		ls.add(this);
		for (HComponent c : this.getComponents()) {
			for (HComponent c_ : c.getAllInnerConfigurations())
				if (!ls.contains(c_))
					ls.add(c_);
		}
		return ls;
	}

	protected Map<HComponent, HComponent> getAllInnerComponents() {

		Map<HComponent, HComponent> ls = new HashMap<HComponent, HComponent>();
		ls.put(this, null);
		for (HComponent c : this.getComponents()) {
			for (Entry<HComponent, HComponent> c_ : c.getAllInnerComponents()
					.entrySet())
				if (!ls.containsKey(c_.getKey()))
					ls.put(c_.getKey(),
							c_.getValue() == null ? this : c_.getValue());
		}
		return ls;
	}


	public final static String PROPERTY_BOUNDS = "component_bounds";
	public final static String PROPERTY_COLOR = "component_color";

	public void setBounds(Rectangle bounds) 
	{
		super.setBounds(bounds);
		
		HComponent cTop = (HComponent) this.getTopConfiguration();
		List<HComponent> component_fusions = cTop.getFusionComponents(this.getRef());
		if (component_fusions != null)
			for (HComponent cf : component_fusions) 
			{
			   if (cf != this && !cf.getBounds().equals(bounds))
				   cf.setBounds(bounds);
			}
		
		listeners.firePropertyChange(PROPERTY_BOUNDS, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	/**
	 * @uml.property name="color"
	 */
	private MyColor color = new MyColor(ColorConstants.white);

	/**
	 * Getter of the property <tt>color</tt>
	 * 
	 * @return Returns the color.
	 * @uml.property name="color"
	 */
	public Color getColor() {
		return color.getColor();
	}

	/**
	 * Setter of the property <tt>color</tt>
	 * 
	 * @param color
	 *            The color to set.
	 * @uml.property name="color"
	 */
	public void setColor(Color color) {
		this.color.setColor(color);
		listeners.firePropertyChange(UPDATE_COLOR, null, getColor());
	}

	IPackageLocation location = null;

	// COMPONENT !!!!!

	/**
	 * @uml.property name="entries"
	 * @uml.associationEnd readOnly="true" multiplicity="(0 -1)" ordering="true"
	 *                     inverse="which_component:hPE.model.HComponentEntry"
	 */
	// private List entries = new ArrayList();
	/**
	 * @uml.property name="entries"
	 * @uml.associationEnd readOnly="true" multiplicity="(0 -1)" ordering="true"
	 *                     inverse="which_component:hPE.model.HComponentEntry"
	 */
	public Collection<IHUnit> getEntries() {
		return this.getUnits();
	}

	public Collection<IHPrimUnit> getObservableEntries() 
	{
		List<IHPrimUnit> ls = new ArrayList<IHPrimUnit>();
		for (IHUnit u : this.getAllUnits()) 
		{
			if (!u.getHidden()) 
			{   
				ls.addAll(u.getClones());
			} 
			else if (u.getBinding() != null) 
			{
				HBinding b = u.getBinding();
				if (b.getPort() instanceof HUnitStub)
					ls.add(u);
			}			
			
		}
		
		//for (HComponent c : this.getInnerComponents())
		//{
		//	if (!c.isParameter()) 
		//	{
		//		for (IHUnit u : c.getUnits())
		//		{
		//			if (u.getBinding() == null)
		//			{
		//				ls.add(u);
		//			}
		//		}
		//	}
		//}
		
		return ls;
	}

	/**
	 * @uml.property name="configuration"
	 * @uml.associationEnd readOnly="true" multiplicity="(1 1)"
	 *                     inverse="components:hPE.base.model.HComponent"
	 */
	private HComponent configuration = null;

	private List<HComponent> configurations = new ArrayList<HComponent>();

	/**
	 * Getter of the property <tt>configuration</tt>
	 * 
	 * @return Returns the configuration.
	 * @uml.property name="configuration"
	 */
	public IConfiguration getConfiguration() {
		if (configurations == null)
			configurations = new ArrayList<HComponent>();
		if (configuration != null) {
			configurations.add(configuration);
			configuration = null;
		}
		if (!configurations.isEmpty())
			return configurations.get(0);
		else
			return null;
	}

	public IConfiguration getTopConfiguration() {
		if (configurations == null)
			configurations = new ArrayList<HComponent>();
		if (configuration != null) {
			configurations.add(configuration);
			configuration = null;
		}
		HComponent c = this;
		while (!c.isTopConfiguration())
			c = (HComponent) c.getDirectParentConfigurations().get(0);
		return c;
	}

	/**
	 */
	// public void addEntry(HComponentEntry entry) {
	// entries.add(entry);
	// }



	public final static String REPLICATED = "replicated";

	/**
	 */
	public List getMyReplicas() {
		// TODO: model (getMyReplicas)
		return null;
	}

	public List<String> getModuleNames(String version) {
		List<String> l = new ArrayList<String>();
		for (IHUnit u : this.getUnits()) {
			HInterface i = (HInterface) u.getInterface();
			for (HBESourceVersion<HBEAbstractFile> m : i.getSourceVersions()) {
				if (m.getVersionID().equals(
						version == null ? "1.0.0.0" : version)) {
					for (HBEAbstractFile f : m.getFiles()) {
						l.add(f.getBinaryPath().toString());
					}
				}
			}
		}
		return l;
	}



	public boolean canRemoveMe(List<HComponent> C, HComponent c1) {

		/*
		 * if (this == c1) return true;
		 * 
		 * HComponent topC = (HComponent) this.getTopConfiguration();
		 * 
		 * Stack<HComponent> sss = new Stack<HComponent>();
		 * 
		 * sss.push(this);
		 * 
		 * while (!sss.isEmpty()) { HComponent d = sss.pop(); for (HComponent c
		 * : d.getDirectParentConfigurations()) { if (c==topC) return false;
		 * else if (c!=c1) { sss.push(c); } } }
		 */

		for (HComponent c : this.getDirectParentConfigurations()) {
			if (C.contains(c))
				return false;
		}

		return true;
	}

	public IConfiguration fetchSelfConfiguration() {
		// TODO: model (fetchSelfConfiguration)
		return this;
	}

	public void adjustBoundsForReusingComponent() {

		int i = 0;

		for (IHUnit unit__ : this.getAllUnits()) {
            for (IHPrimUnit unit_ : unit__.getClones()) 
            {
            	IHUnit unit = (IHUnit) unit_;
            	
				Rectangle r = new Rectangle();
	
				r.setSize(HUnit.diameter, HUnit.diameter);
				r.translate(5 + i * (HUnit.diameter + 3), 0);
	
				unit.saveBounds();
				unit.setBounds(r);
	
				i++;
            }
		}

	}

	// private ILComponentView libraryEntry;

	public String getRemoteLocation() {
		return uriRemote;
	}

	public String getRelativeLocation() {
		String r = /* Path.SEPARATOR + */this.getPackagePath().toString()
				+ "." + this.getComponentName() + Path.SEPARATOR
				+ this.getComponentName() + ".hpe";
		return r;
	}

	public String getLocalLocation() {
		return uriLocal.replaceAll("%20", " ");
	}

	public String toString() {
		return this.getLocalLocation();
	}

	public final static String PROPERTY_IS_PARAMETER = "PROPERTY_IS_PARAMETER";

	private boolean isParameter = false;
	private Map<HComponent, String> parameterIdentifier = new HashMap<HComponent, String>();

	public void setParameter(String parId) {

		HComponent c = (HComponent) this.getTopConfiguration();
		String s = c.getLocalLocation();

		this.isParameter = true;
		if (!this.parameterIdentifier.containsKey(s))
			this.parameterIdentifier.put(c, parId);

		if (!this.isConnected()) {
			this.setHiddenInnerComponent(true);
		}

		this.forceUpdateName();

		// TRY TO UPDATE ALL CONFIGURATION
		((HComponent) this.getTopConfiguration()).listeners.firePropertyChange(
				UPDATE_CONFIGURATION, null, name);

	}

	private Map<Integer, String> variableName = null;

	public String getVariableName() {
		HComponent topC = (HComponent) this.getTopConfiguration();
		HComponent base = topC.getWhoItImplements();
		if (base == null) {
			return this.getVariableName(topC);
		} else {
			return this.getVariableName(base);
		}

	}

	public String getVariableName(HComponent ctx) {

		if (this.variableName == null)
			this.variableName = new HashMap<Integer, String>();

		Integer code = ctx.getMyInstanceId();

		if (this.variableName.containsKey(code))
			return this.variableName.get(code);
		else {
			HComponent ctxTop = (HComponent) this.getTopConfiguration();
			if (ctxTop.getWhoItImplements() == ctx) {
				if (this.variableName.containsKey(ctxTop.getMyInstanceId())) {
					return this.getVariableName(ctxTop);
				}
			}
		}

		HComponent ctxSuper = ctx.getSuperType();
		return this.getWhoISupply() == null && ctxSuper != null ? this.getVariableName(ctxSuper) : "?";
	}

	public void setVariableName(String varName) {
		HComponent ctx = (HComponent) this.getTopConfiguration();
		this.setVariableName(ctx, varName);
	}

	public void setVariableName(HComponent ctx, String varName) 
	{
		if (this.variableName == null)
			this.variableName = new HashMap<Integer, String>();

		Integer idx_top = 3472;
		if (idx_top == ctx.getMyInstanceId() && varName.equals("I"))
		{
		   System.out.println("assert");
		}
		
		String currVar = this.variableName.get(ctx.getMyInstanceId());
		if (currVar == null || (currVar != null && !currVar.equals(varName))) {
			this.variableName.put(ctx.getMyInstanceId(), varName);
			try {
				listeners.firePropertyChange(PROPERTY_IS_PARAMETER, null, this.getBounds());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// informDeepParameters((HComponent) this.getConfiguration(), currVar,
		// varName);

	}

	public void changeVariableName(String oldVarName, String newVarName) {
		changeVariableName((HComponent) this.getTopConfiguration(), oldVarName,	newVarName);
	}

	public void changeVariableName(HComponent ctx, String parId, String newVarName) 
	{
		Map<String, List<HComponent>> parameters = this.getParameters();
		for (Entry<String, List<HComponent>> par : parameters.entrySet()) {
			HComponent c = par.getValue().get(0);
			String parId_ = par.getKey() ; //c.getVariableName(ctx);
			if (c.getSupplier() == null && parId_.equals(parId)) {
				c.setVariableName(ctx, newVarName);
			} else {
				// HComponent owner_of_c = (HComponent) c.getConfiguration();
				c.changeVariableName(ctx, parId, newVarName);
			}
		}

	}

	public void clearVariableName(String varName) {
		if (this.variableName == null)
			this.variableName = new HashMap<Integer, String>();

		HComponent ctx = (HComponent) this.getTopConfiguration();
		int iid = ctx.getMyInstanceId();
		if (this.variableName.containsKey(iid)) {
			String varName_ = this.variableName.get(iid);
			if (varName.equals(varName_)) {
				this.variableName.remove(ctx.getMyInstanceId());
				try {
					listeners.firePropertyChange(PROPERTY_IS_PARAMETER, null,
							this.getBounds());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void setVariableName(Map<Integer, String> varName) {
		if (this.variableName == null)
			this.variableName = new HashMap<Integer, String>();

		this.variableName.putAll(varName);
	}

	/*
	 * private String variableName = "?";
	 * 
	 * public String getVariableName() { if (this.variableName == null)
	 * this.variableName = "?";
	 * 
	 * return this.variableName; }
	 * 
	 * public void setVariableName(String varName) {
	 * 
	 * String currVar = this.variableName; if (!currVar.equals(varName)) {
	 * this.variableName = varName;
	 * listeners.firePropertyChange(PROPERTY_IS_PARAMETER
	 * ,null,this.getBounds()); }
	 * 
	 * 
	 * }
	 */
	public void setNullVariableName() {
		this.variableName = null;
		listeners.firePropertyChange(PROPERTY_IS_PARAMETER, null,
				this.getBounds());

	}

	/*
	 * public void changeVarName(String varName) {
	 * 
	 * isParameter = true; this.parameterIdentifier = varName;
	 * 
	 * }
	 */

	public void setNonAbstract(String parId) {

		isParameter = false;
		removeParameterIdentifierByName(parId);
		this.setNullVariableName();
		listeners.firePropertyChange(PROPERTY_IS_PARAMETER, null,
				this.getBounds());

	}

	public void removeParameterIdentifierByName(String varName) {

		List<HComponent> trash = new ArrayList<HComponent>();

		for (Entry<HComponent, String> p : this.parameterIdentifier.entrySet())
			if (p.getValue().equals(varName))
				trash.add(p.getKey());

		for (HComponent key : trash)
			this.parameterIdentifier.remove(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#isAbstract()
	 */
	public boolean isParameter() {
		return isParameter;
	}

	public String getParameterIdentifier() {
		return this
				.getParameterIdentifier((IComponent) this.getConfiguration());
	}

	public String getParameterIdentifier(IComponent c) {

		if (this.parameterIdentifier.containsKey(c/*.getLocalLocation()*/))
			return this.parameterIdentifier.get(c/*.getLocalLocation()*/);
		else {
			HComponent superType = getSuperType();
			return superType != null ? superType.getParameterIdentifier(c)	: "type ?";
		}

	}

	public String getParameterModifierName(boolean complete,
			boolean showBounds, boolean showParId) {

		List<String> vs = new ArrayList<String>();
		HComponent topC = (HComponent) this.getTopConfiguration();
		int parameterized = 0;
		String nameWithParameters = "";

		Set<Entry<String, List<HComponent>>> parameters = this.getParameters(topC).entrySet();

		for (Entry<String, List<HComponent>> entry : parameters) {

			String parId = entry.getKey();
			HComponent config = entry.getValue().get(0);
			//if (config.getSupplier() == null && config.getWhoISupply().isEmpty())
			{
				String varName = config.getVariableName();
	
				if (parId.equals("type ?"))
					parId = config.getParameterIdentifier((IComponent) config.getTopConfiguration());
				
				if (varName.equals("?"))
					varName = config.getVariableName(this);
				if (/* !complete || config.getSupplied() == null */true) {
					if (parameterized == 0)
						nameWithParameters = nameWithParameters.concat("<");
					parameterized++;
					if (!vs.contains(parId)) {
						if (parameterized > 1)
							nameWithParameters = nameWithParameters.concat(", ");
	
						// if (config.getSupplied() == null) {
						boolean showBounds_ = showBounds;
						showBounds_ = showBounds_ && ((!topC.getVars().contains(varName)) || this.isTopConfiguration());
						boolean showVar = (config.isParameter() && config.getSupplier() == null) || topC.getVars().contains(varName);
						nameWithParameters = nameWithParameters
								+ (showParId ? parId + " = " : "")
								+ (showVar ? varName : "")
								+ (showVar && showBounds_ ? ": " : "")
								+ (showBounds_ ? config.getNameWithParameters(
										complete, showBounds, showParId) : "");
						// } else {
						// nameWithParameters = nameWithParameters
						// + (showParId ? parId + " = " : "")
						// + config.getNameWithParameters(complete, showBounds,
						// showParId);
						// }
					}
					vs.add(parId);
				}
			}
		}

		if (parameterized > 0) {
			nameWithParameters = nameWithParameters.concat(">");
		}

		return nameWithParameters;
	}

	public String getNameWithParameters(boolean complete, boolean showBounds,  boolean showParId) {

		return this.getComponentName() + this.getParameterModifierName(complete, showBounds, showParId);

	}

	public Map<String, List<HComponent>> getParameters() {
		return getParameters(this);
	}

	protected Map<String, List<HComponent>> getParametersSetup() {

		Map<String, List<HComponent>> parameters = new HashMap<String, List<HComponent>>();

		for (HComponent c : this.getComponents()) {
			if (c.isParameter()) {
				String parId = c.getParameterIdentifier(this);
				if (parameters.containsKey(parId)) {
					parameters.get(parId).add(c);
				} else {
					List<HComponent> cs = new ArrayList<HComponent>();
					cs.add(c);
					parameters.put(parId, cs);
				}
			}

		}
		
		HComponent cSuper = this.getSuperType();
		if (cSuper != null) 
		{
		  Map<String, List<HComponent>> parameters_super = cSuper.getParametersSetup();
		  for (Entry<String,List<HComponent>> par_super : parameters_super.entrySet())
			  if (!parameters.containsKey(par_super.getKey())) 
				  parameters.put(par_super.getKey(), par_super.getValue());
		}

		return parameters;
	}

	protected Map<String, List<HComponent>> getFreeParameters(HComponent ctx, int key_kind)
	{
		Map<String, List<HComponent>> parameters = new HashMap<String, List<HComponent>>();
		
		for (HComponent c : this.getComponents())
		{
			if (c.isParameter() && c.getSupplier() == null && c.getWhoISupply().isEmpty())
			{
			   List<HComponent> cList = new ArrayList<HComponent>();
			   cList.add(c);
			   parameters.put(key_kind == this.BY_PARID ? c.getParameterIdentifier() : c.getVariableName(ctx), cList);
			}
			
			Map<String, List<HComponent>> c_parameter_list = c.getParameters(ctx);
			for (Entry<String, List<HComponent>> c_parameter : c_parameter_list.entrySet())
			{
			    String par_id = c_parameter.getKey();
			    HComponent c_par = c_parameter.getValue().get(0);
			   
				if (c_par.getSupplier() == null && c_par.getWhoISupply().isEmpty()) {
				    String var_id = c_par.getVariableName(ctx);
					parameters.put(key_kind == this.BY_PARID ? par_id : var_id, c_parameter.getValue());
				}
			   
			}
		}
		
		/*HComponent cSuper = this.getSuperType();
		if (cSuper != null) 
		{
		  Map<String, List<HComponent>> parameters_super = cSuper.getFreeParameters(ctx);
		  parameters.putAll(parameters_super);
		}*/
		
		return parameters;
		
	}
	
	protected Map<String, List<HComponent>> getClosedParameters(HComponent ctx, int key_kind)
	{
		Map<String, List<HComponent>> parameters = new HashMap<String, List<HComponent>>();
		
		for (HComponent c : this.getComponents())
		{
			if (c.isParameter() && !(c.getSupplier() == null && c.getWhoISupply().isEmpty()))
			{
			   List<HComponent> cList = new ArrayList<HComponent>();
			   cList.add(c);
			   parameters.put(key_kind == this.BY_PARID ? c.getParameterIdentifier(ctx) : c.getVariableName(ctx), cList);
			}
			
			Map<String, List<HComponent>> c_parameter_list = c.getParameters(ctx);
			for (Entry<String, List<HComponent>> c_parameter : c_parameter_list.entrySet())
			{
			    String par_id = c_parameter.getKey();
			    HComponent c_par = c_parameter.getValue().get(0);
			   
				if (!(c_par.getSupplier() == null && c_par.getWhoISupply().isEmpty())) {
				    String var_id = c_par.getVariableName(ctx);
				    if (!var_id.equals(UNDEFINED_NAME))
				    	parameters.put(key_kind == this.BY_PARID ? par_id : var_id, c_parameter.getValue());
				}
			   
			}
		}
		
		HComponent cSuper = this.getSuperType();
		if (cSuper != null) 
		{
		  Map<String, List<HComponent>> parameters_super = cSuper.getClosedParameters(ctx, key_kind);
		  for (Entry<String, List<HComponent>> par_super : parameters_super.entrySet())
		  {
			  if (!parameters.containsKey(par_super.getKey()))
				  parameters.put(par_super.getKey(), par_super.getValue());  
		  }
		}
		
		return parameters;
	}

	protected Map<String, List<HComponent>> getParameters(HComponent cThis) {

		Map<String, List<HComponent>> parameters = new HashMap<String, List<HComponent>>();
		Map<String, String> vars = new HashMap<String, String>();

		Map<String, HComponent> ccc = null;
		if (this != cThis) {
			ccc = cThis.getParametersByDefinedVarNames();
		}

		Map<String, List<HComponent>> parameter_setup_list = this.getParametersSetup();
		for (Entry<String, List<HComponent>> parameter_setup : parameter_setup_list.entrySet()) {
			String parId = parameter_setup.getKey();
			List<HComponent> cList = parameter_setup.getValue();
			for (HComponent c : cList) {
				String varName = c.getVariableName(cThis);
				HComponent c_ = c;
				if (ccc != null && (ccc.containsKey(varName)))
				{
					c_ = ccc.get(varName);		
				}
				else if (c.getSupplier() != null) 
				{
				    c_ = c.getSupplier();
				}
				
				addParameter(parId, c_, parameters);
				if (c != c_)
					addParameter(parId, c, parameters);
				if (!varName.equals(UNDEFINED_NAME))
					vars.put(varName, parId);
			}
		}

		/*
		 * for (HComponent c: this.getComponents()) { if (c.isParameter()) {
		 * HComponent c_; String varName = c.getVariableName(cThis); c_ =
		 * (HComponent) (ccc != null && (ccc.containsKey(varName)) ?
		 * ccc.get(varName) : c); String parId = c.getParameterIdentifier(this);
		 * addParameter(parId, c_, parameters); if (c != c_) addParameter(parId,
		 * c, parameters); vars.put(varName, parId); }
		 * 
		 * }
		 */

		for (HComponent c : this.getComponents()) {
			Map<String, List<HComponent>> parameters_c = c.getParameters(this);
			for (Entry<String, List<HComponent>> pars : parameters_c.entrySet()) {
				List<HComponent> ccs = pars.getValue();
				for (HComponent cc : ccs) {
					if (cc.getSupplier() == null) {
						String varName_ = cc.getVariableName(cThis);
						if (vars.containsKey(varName_)) {
							addParameter(vars.get(varName_), cc, parameters);
						}

					}
				}
			}
		}

		return parameters;
	}

	private void addParameter(String parId, HComponent c, Map<String, List<HComponent>> parameters) {
		if (parameters.containsKey(parId)) {
			parameters.get(parId).add(c);
		} else {
			List<HComponent> l = new ArrayList<HComponent>();
			l.add(c);
			parameters.put(parId, l);
		}
	}

	/*
	 * public Map<String,List<HComponent>> getParameters2() { List<String> vs =
	 * new ArrayList<String>(); Map<String,List<HComponent>> m = new
	 * HashMap<String,List<HComponent>>();
	 * 
	 * Map<String, List<HComponent>> pars = this.getParameters(); for
	 * (Entry<String,List<HComponent>> p : pars.entrySet()) {
	 * 
	 * String parId = p.getKey(); List<HComponent> c = p.getValue();
	 * 
	 * String v = parId; //.concat(" as ").concat(c.get(0).getVariableName());
	 * // c.getVariableName(); if (vs.contains(v)) { ((List<HComponent>)
	 * m.get(v)).addAll(c); } else { List<HComponent> vl = new
	 * ArrayList<HComponent>(); vl.addAll(c); m.put(v,vl); vs.add(v); }
	 * 
	 * } return m;
	 * 
	 * }
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#getParameter(java.lang.String)
	 */
	public List<HComponent> getParameterByName(String x) {
		Map<String, List<HComponent>> cs = this.getParameters();
		return cs.get(x);
	}

	public Map<String, HComponent> getParametersByDefinedVarNames() 
	{
		HComponent cThis = this; // .getWhoItImplements() == null ? this :
									// this.getWhoItImplements();

		Map<String, HComponent> parameters = new HashMap<String, HComponent>();

		for (Entry<String, List<HComponent>> par : cThis.getParametersSetup().entrySet()) 
		{
			List<HComponent> cList = par.getValue();
			for (HComponent c : cList) {
				String varName = c.getVariableName();
				if (!varName.equals(HComponent.UNDEFINED_NAME)) 
				{ // only variables with defined names.
					parameters.put(varName, c);
				}
			}
		}

		for (Entry<String, HComponent> supply : cThis.supplyMemory.entrySet()) 
		{
			String varName = supply.getKey();
			HComponent c = supply.getValue();
			c = c.getSupplier() != null ? c.getSupplier() : c;
			parameters.put(varName, c);
		}

		return parameters;
	}

	public List<String> getVars() 
	{

		List<String> vars = new ArrayList<String>();

		for (Entry<String, List<HComponent>> param : this.getParameters().entrySet()) {
			for (HComponent c : param.getValue()) {
				String var = c.getVariableName(this);
				if (c.isFreeVariable() && !vars.contains(var))
					vars.add(var);
			}
		}

		return vars;
	}

	private boolean isFreeVariable() {
		
		return this.getSupplier() == null && this.getWhoISupply().isEmpty();
	}

	private HComponent supplier = null;

	private void setSupplier(HComponent c) {
		this.supplier = c;
		//c.setRef(this.getRef());
		// this.isParameter = true;
		// this.parameterIdentifier.putAll(c.parameterIdentifier); // DUVIDA...
		// antes apenas
		// atribu�a
		// ...
		// this.setVariableName(c.getVariableName());
		// this.setVariableName(c.variableName);
	}


	public boolean representsOpenParameter() 
	{
	    return this.getSupplier() == null && this.getWhoISupply().isEmpty();
	}
	
	// TODO: TOP LEVEL PARAMETERS ...
	public HComponent getSupplier() {
		// return this.getSupplierComponent(this.getVariableName());
		HComponent supplier = null;
		HComponent supplier_next = this.supplier;
		while (supplier_next != null) {
			supplier = supplier_next;
			supplier_next = supplier.supplier;
			if (supplier == supplier_next)
				break;
		}
		return supplier;
	}

	/*
	 * private List suppliedParameters = new ArrayList();
	 * 
	 * public boolean isSupplied(HConfiguration component) { if
	 * (this.suppliedParameters == null) this.suppliedParameters = new
	 * ArrayList(); return this.suppliedParameters.contains(component); }
	 */

	public boolean isConnected() {
		for (IHUnit u : this.getAllUnits()) {
			if (u.getBinding() != null)
				return true;
		}
		return false;
	}

	public boolean isTopConfiguration() {
		if (configurations == null)
			configurations = new ArrayList<HComponent>();
		if (configuration != null) {
			configurations.add(configuration);
			configuration = null;
		}
		// return this.configuration == null;
		// TODO (getConfiguration):
		return this.getDirectParentConfigurations().isEmpty();

	}

	public boolean isDirectSonOfTheTopConfiguration() {
		if (configurations == null)
			configurations = new ArrayList<HComponent>();
		if (configuration != null) {
			configurations.add(configuration);
			configuration = null;
		}
		HComponent topC = (HComponent) this.getTopConfiguration();

		if (this instanceof HComputationComponent
				&& this.getDirectParentConfigurations().contains(topC)
				&& !topC.getComponents().contains(this)) {
			//System.out.print(true);
		}

		return this.getDirectParentConfigurations().contains(topC)
				&& topC.getComponents().contains(this);
		// If the component is direct son of the top configuration, then it has
		// only one parent configuration, the top configuration itself.
	}

	public List<HComponent> getDirectParentConfigurations() {
		List<HComponent> trash = new ArrayList<HComponent>();
		for (HComponent c : this.configurations) {
			if (c.isRemoved()) {
				trash.add(c);
			}
		}
		this.configurations.removeAll(trash);
		return this.configurations;
	}

	public List<HComponent> getTopParentConfigurations() {
		List<HComponent> l = new ArrayList<HComponent>();
		HComponent topC = (HComponent) this.getTopConfiguration();
		for (HComponent c : this.getAllParentConfigurations()) {
			if (c.getDirectParentConfigurations().contains(topC)) {
				l.add(c);
			}
		}
		if (this.getDirectParentConfigurations().contains(topC)) {
			l.add(this);
		}
		return l;
	}

	private static Pair<IHPrimUnit, IHPrimUnit> alignUnits(IHPrimUnit u1,
			IHPrimUnit u2) {

//		List<HLinkToReplicator> lrs = new ArrayList<HLinkToReplicator>();
//		HReplicator topR = null;

		// Por enquanto, sup�e-se que somente um replicador pode estar
		// dividido ....
/*		for (HReplicator r : u1.getReplicators()) {
			if (r.getParentSplit() != null) {
				lrs = r.getSplitPath();
				topR = r.getTopReplicator();
				if (!u2.isReplicatedBy(topR)) {
					topR = null;
				}
				break;
			}
		}
*/

/*		for (HLinkToReplicator l : lrs) {
			if (topR == null) {
				HReplicator rr = ((HReplicatorSplit) l.getReplicated())
						.getOwnerReplicator();
				if (u2.isReplicatedBy(rr)) {
					topR = rr;
				}
			} else {
				HReplicatorSplit s = (HReplicatorSplit) l.getReplicated();
				if (!u2.isCloned())
					u2.splitBy(s);
				for (IHPrimUnit u_ : u2.getMyClones()) {
					for (HReplicator r_ : u_.getReplicators()) {
						if (r_.getVarId().equals(l.getReplicator().getVarId())) {
							u2 = u_;
							break;
						}
					}
				}

			}
		}
*/		

		// u1.align((HPrimUnit)u2);

		// JOptionPane.showMessageDialog(null,
		// "The unit u1 is not replicated by the topR of u2" ,"HUnit.alignUnit",
		// JOptionPane.ERROR_MESSAGE);

		return new Pair<IHPrimUnit, IHPrimUnit>(u1, u2);
	}

	public void forceUpdateName() {
		listeners.firePropertyChange(UPDATE_NAME, null, name); //$NON-NLS-2$//$NON-NLS-1$	
		listeners.firePropertyChange(NEW_COMPONENT, null, name); //$NON-NLS-2$//$NON-NLS-1$	
	}

	public void adviceChangeParameterName() {
		// TRY TO UPDATE ALL CONFIGURATION
		((HComponent) this.getTopConfiguration()).listeners.firePropertyChange(
				UPDATE_CONFIGURATION, null, name);

	}

	public IComponent getSubTypeImageOf(HComponent c) {

		if (this.getComponentName().equals(c.getComponentName())) { // They are
																	// the same
																	// components.
																	// Check
																	// parameteres.

			if (this.getParameters().size() == 0)
				return this; // MATCH !!!!!!!!

			if (this.getParameters().size() == c.getParameters().size()) {
				// C[V1,V2,...,Vn] <: C[X1,X2,...,Xn] iif V1 <: X1 & V2 <: X2 &
				// ... & Vn <: Xn
				Iterator<Entry<String, List<HComponent>>> ps = c
						.getParameters().entrySet().iterator();
				boolean checkParameters = true;
				int pos = 0;
				while (ps.hasNext() && checkParameters) {
					Entry<String, List<HComponent>> valCEntry = ps.next();
					String parId = valCEntry.getKey();
					List<HComponent> valC = valCEntry.getValue();
					List<HComponent> v = this.getParameterByName(parId);
					if (v != null) {
						// Check parameter subtyping
						checkParameters = v.get(0).isSubTypeOf(valC.get(0))
								&& checkParameters;
					} else {
						System.out
								.println("CONSISTENCY ERROR !!! (isSubTypeOf): Variable Name NOT found !");
						return null;
					}
					pos++;
				}
				if (checkParameters)
					return this; // MATCH !!!!!
			} else {
				System.out
						.println("CONSISTENCY ERROR !!! (isSubTypeOf): Parameters does not Match");
				return null;
			}
		}

		// Check if they are of the same component kind (There is no subtype
		// relation between component types of distinct kinds).
		if (c.getClass() == this.getClass()) {
			// C = C1 # C2 # ... # Cn: D <: C if D <: C1 | D <: C2 | ... | D <:
			// Cn
			for (HComponent sc : this.getComponents()) {
				if (sc.allUnitsAreStubs()) {
					IComponent c1 = sc.getSubTypeImageOf(c);
					if (c1 != null)
						return c1;
				}
			}
		} else {
			return null;
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#getSuperType()
	 */
	public HComponent getSuperType() {

		for (HComponent sc : this.getComponents()) {
			if (sc.isSuperType()
					&& (sc.allUnitsAreStubs() || sc.getUnits().size() == 0)) {
				return sc;
			}
		}
		return null;
	}

	private boolean superType = false;

	public final static String PROPERTY_IS_SUPERTYPE = "PROPERTY_IS_SUPERTYPE";

	protected void setSuperType(boolean superType) {
		this.superType = superType;
		listeners.firePropertyChange(PROPERTY_IS_SUPERTYPE, null,
				this.getBounds());
	}

	public boolean isSuperType() {
		return superType;
	}

	public HComponent getSubType() {

		List<HComponent> cs = this.getDirectParentConfigurations();
		if (cs.size() == 1) { // TODO (getConfiguration) : if an inner component
								// is a subtype component
			HComponent c = cs.get(0);
			if (c != null && c.getSuperType() == this) {
				return c;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public IComponent getLeastSubType() {

		HComponent subC = this;
		while (subC.getSubType() != null)
			subC = subC.getSubType();
		return subC;

	}

	public boolean allUnitsAreStubs() {

		boolean yes = true;

		for (IHUnit u : this.getUnits())
			if (!(u instanceof HUnitStub))
				yes = false;

		return yes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#isSubTypeOf(hPE.base.model.HComponent)
	 */
	public boolean isSubTypeOf(HComponent c) {

		return getSubTypeImageOf2(c) != null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#isEquivalentTo(hPE.base.model.HComponent)
	 */
	public boolean isEquivalentTo(HComponent c) {
		return this.isSubTypeOf(c) && c.isSubTypeOf(this);
	}

	public boolean accepts(IComponent c) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hPE.base.model.IComponent#kindString()
	 */
	public String kindString() {
		return "?";
	}

	public List<Pair<HComponent, HComponent>> getSubTypeImageOf2(HComponent c) {

		List<Pair<HComponent, HComponent>> lr = new ArrayList<Pair<HComponent, HComponent>>();

		if (this.getComponentName().equals(c.getComponentName())) { // They are
																	// the same
																	// components.
																	// Check
																	// parameteres.

			Map<String, List<HComponent>> lll1 = this.getParameters();
			Map<String, List<HComponent>> lll2 = c.getParameters();

			if (lll1.size() == 0) {
				lr.add(new Pair(c, this.getLeastSubType())); // MATCH !!!!!!!!
				return lr;
			}

			// Collection i = this.getParameters();
			// Collection j = c.getParameters();

			if (lll1.size() == lll2.size()) {
				// C[V1,V2,...,Vn] <: C[X1,X2,...,Xn] iif V1 <: X1 & V2 <: X2 &
				// ... & Vn <: Xn
				Iterator<Entry<String, List<HComponent>>> ps = lll2.entrySet()
						.iterator();
				boolean checkParameters = true;
				int pos = 0;
				while (ps.hasNext() && checkParameters) {
					Entry<String, List<HComponent>> valCEntry = ps.next();
					String parId = valCEntry.getKey(); // (String)
														// valC.getParameterIdentifier(this);
					List<HComponent> valC = valCEntry.getValue();
					List<HComponent> v = this.getParameterByName(parId);
					HComponent v0 = v.get(0);
					HComponent valC0 = valC.get(0);
					if (v != null) {
						// Check parameter subtyping

						checkParameters = v0.isSubTypeOf(valC0)
								&& checkParameters;
						if (checkParameters) {
							lr.addAll(v0.getSubTypeImageOf2(valC0));
						}
					} else {
						System.out
								.println("CONSISTENCY ERROR !!! (isSubTypeOf): Variable Name NOT found !");
						return null;
					}
					pos++;
				}
				if (checkParameters) {
					lr.add(new Pair(c, this.getLeastSubType())); // MATCH
																	// !!!!!!!!
					return lr; // MATCH !!!!!
				}
			} else {
				System.out
						.println("CONSISTENCY ERROR !!! (isSubTypeOf): Parameters does not Match");
				return null;
			}
		}

		// Check if they are of the same component kind (There is no subtype
		// relation between component types of distinct kinds).
		if (c.getClass() == this.getClass()) {
			// C = C1 # C2 # ... # Cn: D <: C if D <: C1 | D <: C2 | ... | D <:
			// Cn
			for (HComponent sc : this.getComponents()) {
				if (sc.allUnitsAreStubs()) {
					List<Pair<HComponent, HComponent>> c1 = sc
							.getSubTypeImageOf2(c);
					if (c1 != null && c1.size() > 0) {
						lr.addAll(c1);
						return lr;
					}
				}
			}

		} else {
			return null;
		}

		return null;

	}

	public Map<String, Set<HComponent>> getVariablesSubTyping(HComponent ctx,
			HComponent c) {

		Map<String, Set<HComponent>> ls = new HashMap<String, Set<HComponent>>();

		for (Pair<HComponent, HComponent> p : this.getSubTypeImageOf2(c)) {
			HComponent c1 = p.fst();
			HComponent c2 = p.snd();
			if (c1.isParameter() && c.getSupplier() == null) {
				String varName = c1.getVariableName(ctx);
				if (ls.containsKey(varName)) {
					ls.get(varName).add(c2);
				} else {
					Set<HComponent> l = new HashSet<HComponent>();
					l.add(c2);
					ls.put(varName, l);
				}

			}
		}

		return ls;

	}

	public Map<HComponent, HComponent> getComponentsToSupply(String varName,
			HComponent model) {

		Map<HComponent, HComponent> componentsToSupply = new HashMap<HComponent, HComponent>();

		Map<HComponent, HComponent> allCs = this.getAllInnerComponents();

		for (Entry<HComponent, HComponent> entry : allCs.entrySet()) {
			HComponent c = entry.getKey();
			HComponent cParent = entry.getValue();
			String varName_of_c = c.getVariableName(this);
			if ((c.isParameter() && c.getSupplier() == null)
					&& varName_of_c.equals(varName)) {
				if (model.isSubTypeOf(c)) {
					if (!componentsToSupply.containsKey(c))
						componentsToSupply.put(c, cParent);
				} else {
					// JOptionPane.showMessageDialog(
					// null,
					// "Supplied component does not match to the parameter.",
					// "Error in Supply Component Action ",
					// JOptionPane.ERROR_MESSAGE);
					// return null;
				}
			}
		}

		return componentsToSupply;

	}

	public IHUnit getUnitByName(String uname) {
		for (IHUnit u : this.getUnits()) {
			if (u.getName2().equals(uname))
				return u;

		}
		return null;
	}

	public IHUnit getUnitByName(String uname, int index) {
		for (IHUnit u : this.getUnits()) {
			if (u.getName2().equals(uname))
				//if (index > 0)
				//	return (IHUnit) u.getClone(index);
				//else
					return u;

		}
		return null;
	}

	private Iterator<Entry<String, HComponent>> reverse(
			Iterator<Entry<String, HComponent>> is) {
		Stack<Entry<String, HComponent>> l = new Stack<Entry<String, HComponent>>();
		while (is.hasNext())
			l.push(is.next());
		return l.iterator();
	}

	static int BY_VARID = 0;
	static int BY_PARID = 1;
	
	// TODO: TOP LEVEL PARAMETERS ...
	public void unify(HComponent model, HComponent supplied, Map<String, Pair<HComponent,Boolean>> toSupply) 
								throws UnifySignaturesException 
	{
	//	model.setExposed(supplied.isPublic());
	//	model.setBounds(supplied.getBounds());
	//	model.setName(supplied.getRef());
		
		Map<String, List<HComponent>> model_parameters = model.getParameters(this);
		
		Map<String, List<HComponent>> free_parameters_supplied_1 = supplied.getParameters(supplied);
        for (Entry<String, List<HComponent>> par : free_parameters_supplied_1.entrySet())
        {
        	String parId = par.getKey();
        	if (model_parameters.containsKey(parId)) 
        	{
            	HComponent par_supplier = model_parameters.get(parId).get(0);
            	HComponent par_supplied = par.getValue().get(0);
            	
            	if (par_supplied.representsOpenParameter() && !par_supplier.representsOpenParameter())
            	{
	            	String supplyingVarId = par_supplied.getVariableName(this);
	            	Pair<HComponent,Boolean> pair_supplier = new Pair<HComponent,Boolean>(par_supplier,true);
	            	toSupply.put(supplyingVarId, pair_supplier);	            	
            	}
            	else if (!par_supplied.representsOpenParameter() && !par_supplier.representsOpenParameter())
            	{
            	   String cNameSupplier = par_supplier.getQualifiedName();
            	   String cNameSupplied = par_supplied.getQualifiedName();
            	   if (!cNameSupplier.equals(cNameSupplied)) 
                       throw new UnifySignaturesException();
            	} 
            	else if (par_supplied.representsOpenParameter() && par_supplier.representsOpenParameter())
            	{
            		String varIdSupplier = par_supplier.getVariableName(this);
            		String varIdSupplied = par_supplied.getVariableName(this);
             	   if (!varIdSupplier.equals(varIdSupplied)) 
                       throw new UnifySignaturesException();
            	} 
            	else 
            	{
            		
            	}
            	unify(par_supplier, par_supplied, toSupply);
        	}
        	else 
                throw new UnifySignaturesException();
        }
        
	}
	
	public String getQualifiedName() {
		return this.getPackagePath().toPortableString() + "." + this.getComponentName();
	}

	public void supplyParameter(String varName, HComponent model) 
	{
	    /*boolean fail = false;
		
		if (!model.isParameter()) 
		{	
			Map<String, Pair<HComponent,Boolean>> toSupply = new HashMap<String,Pair<HComponent,Boolean>>();
			Pair<HComponent,Boolean> pair_model = new Pair<HComponent,Boolean>(model,false);
			toSupply.put(varName, pair_model);
			
			Map<String, List<HComponent>> free_parameter_list = this.getFreeParameters(this, this.BY_VARID);
			List<HComponent> supplied_list = free_parameter_list.get(varName);
			if (supplied_list == null)
			{
				JOptionPane.showMessageDialog(null, 
            			  "There is no context variable named " + varName, "Supplying context variable " + varName,
            			  JOptionPane.ERROR_MESSAGE);	
      			
      			fail = true;
      			return;
			}
			
			Map<String, List<HComponent>> model_actual_parameters = model.getClosedParameters(this, this.BY_PARID);
			Map<String, List<HComponent>> model_free_parameters = model.getFreeParameters(this, this.BY_PARID);
			
			for (HComponent supplied : supplied_list)
			{
				Map<String, List<HComponent>> free_parameters_supplied_0 = supplied.getFreeParameters(this, this.BY_VARID);
				Map<HComponent, String> vars_mapping = new HashMap<HComponent, String>();
				for (Entry<String, List<HComponent>> par : free_parameters_supplied_0.entrySet())
				{
					for (HComponent c : par.getValue())
					{
						vars_mapping.put(c, par.getKey());
					}					
				}
				
				// Tentativa de parear os parâmetros
				Map<String, List<HComponent>> free_parameters_supplied_1 = supplied.getFreeParameters(supplied, this.BY_PARID);
                for (Entry<String, List<HComponent>> par : free_parameters_supplied_1.entrySet())
                {
                	String parId = par.getKey();
                	if (model_actual_parameters.containsKey(parId)) 
                	{
	                	HComponent supplier = model_actual_parameters.get(parId).get(0);
	                	String supplyingVarId = vars_mapping.get(par.getValue().get(0));
	                	Pair<HComponent,Boolean> pair_supplier = new Pair<HComponent,Boolean>(supplier,true);
	                	toSupply.put(supplyingVarId, pair_supplier);
                	}
                	else 
                	{	
                		if (!model_free_parameters.containsKey(parId))
                		{
                			JOptionPane.showMessageDialog(null, 
                      			  "Invalid Operation when binding context parameter " + parId + " !", 
                      			  "Supplying context variable " + varName,
                      			  JOptionPane.ERROR_MESSAGE);		
                			
                			fail = true;
                		}
                		//if (model_free_parameters.containsKey(varId)) 
                		//{
    	                //	HComponent supplier = model_free_parameters.get(varId).get(0);
    	                //	String supplyingVarId = vars_mapping.get(par.getValue().get(0));
    	                //	supplier.setVariableName(this, supplyingVarId);
                		//}
                	}
                }
			}
			
			if (!fail) 
			{
			  supplyParameter(toSupply);

			 ((HComponent) model.getTopConfiguration()).listeners.firePropertyChange(UPDATE_CONFIGURATION, null, name);
			}
		} else {
			System.err.print(varName + " is already a parameter. Maybe obsolete configuration. Cancelling supplyParameter.");
		}
		*/
		
		try {
			Map<String, Pair<HComponent,Boolean>> toSupply = new HashMap<String,Pair<HComponent,Boolean>>();
			Pair<HComponent,Boolean> pair_model = new Pair<HComponent,Boolean>(model,false);
			toSupply.put(varName, pair_model);
			
			Map<String, List<HComponent>> free_parameter_list = this.getFreeParameters(this, this.BY_VARID);
			List<HComponent> supplied_list = free_parameter_list.get(varName);
			if (supplied_list != null)
			for (HComponent supplied : supplied_list)
					unify(model,supplied,toSupply);
			
			supplyParameter(toSupply);
		
		} catch (UnifySignaturesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void supplyParameter(Map<String, Pair<HComponent,Boolean>> toSupply) 
	{
		for (Entry<String, Pair<HComponent,Boolean>> supply_item : toSupply.entrySet())
		{
			String varName = supply_item.getKey(); 
			HComponent model = supply_item.getValue().fst();
			boolean transitive = supply_item.getValue().snd();
			
			if (!model.isConnected()) {
				model.setHiddenInnerComponent(true);
			}
			this.rememberSupply(varName, model, transitive);
	
			this.setSupplied(model, varName);
		}
	}

	private void setSupplied(HComponent model, String varName) {

		model.setVariableName(this, varName);
		
		for (HComponent c : this.getComponents()) 
		{
			Map<String, List<HComponent>> c_parameters = c.getParametersSetup();
			for (Entry<String, List<HComponent>> c_par : c_parameters.entrySet()) 
			{
				List<HComponent> cList_ = c_par.getValue();
				for (HComponent c_ : cList_) 
				{
					if (c_.getSupplier() == null) 
					{
						String varName_ = c_.getVariableName();
						if (varName_.equals(varName)) 
						{
							//HComponent model = model_.getMyCopy();
							c_.setSupplier(model);
							model.addSuppliedByMe(c_);
							c.setSupplied(model, varName_);
							String parId = c_.getParameterIdentifier();
							String s = c.getLocalLocation();
							if (!model.parameterIdentifier.containsKey(c))
								model.parameterIdentifier.put(c, parId);
							
							//model.setVariableName(c, varName_);
						}
					}
				}
			}
		}
	}
	
	private List<HComponent> supplied_by_me = new ArrayList<HComponent>();

	private void addSuppliedByMe(HComponent c_) 
	{
		supplied_by_me.add(c_);		
	}
	
	public List<HComponent> getWhoISupply()
	{
	    return supplied_by_me;
	}

	public void undoSupplyParameter(String varName, HComponent model) {

		model.clearVariableName(varName);
		model.setHiddenInnerComponent(false);
		this.forgetSupply(varName);

		// TRY TO UPDATE ALL CONFIGURATION
		((HComponent) model.getTopConfiguration()).listeners
				.firePropertyChange(UPDATE_CONFIGURATION, null, name);
	}

	private void forgetSupply(String varName) {
		if (this.supplyMemory.containsKey(varName))
			this.supplyMemory.remove(varName);
	}

	/*
	 * public void supplyParameter2(String varName, HComponent model) {
	 * 
	 * boolean abort = false;
	 * 
	 * Collection<HComponent> allInnerModel = model.getAllInnerConfigurations();
	 * 
	 * Map<HComponent, HComponent> componentsToSupply =
	 * this.getComponentsToSupply(varName, model);
	 * 
	 * if (componentsToSupply == null || componentsToSupply.size() == 0) {
	 * JOptionPane.showMessageDialog(null, "No variables " + varName +
	 * " to supply (ref=" + model.getRef() + ") .", "Supply Error",
	 * JOptionPane.WARNING_MESSAGE); return; }
	 * 
	 * Map<String, Set<HComponent>> rs = new HashMap<String, Set<HComponent>>();
	 * 
	 * for (Entry<HComponent, HComponent> entries :
	 * componentsToSupply.entrySet()) { HComponent ct = entries.getKey();
	 * Map<String, Set<HComponent>> vs = model.getVariablesSubTyping(this, ct);
	 * 
	 * for (Entry<String, Set<HComponent>> e : vs.entrySet()) { String key =
	 * e.getKey(); if (rs.containsKey(key)) { rs.get(key).addAll(e.getValue());
	 * } else { rs.put(key, e.getValue()); } } }
	 * 
	 * Map<String, HComponent> rsNext = new HashMap<String, HComponent>();
	 * 
	 * for (Entry<String, Set<HComponent>> ee : rs.entrySet()) { String key =
	 * ee.getKey(); HComponent c =
	 * peekThatOneThatIsSubTypeOfTheOthers(ee.getValue()); if (c != null) {
	 * rsNext.put(key, c); } else { JOptionPane.showMessageDialog(null,
	 * "Impossible to match variables in supplyParameter. Look at: "
	 * .concat(rs.toString()), "Error in SupplyParameter",
	 * JOptionPane.ERROR_MESSAGE); abort = true; } }
	 * 
	 * if (!abort) {
	 * 
	 * Iterator<Entry<String, HComponent>> fs_ = rsNext.entrySet() .iterator();
	 * Stack<Entry<String, HComponent>> fs = new Stack<Entry<String,
	 * HComponent>>(); while (fs_.hasNext()) fs.push(fs_.next());
	 * 
	 * while (!fs.empty()) {
	 * 
	 * Entry<String, HComponent> f = fs.pop();
	 * 
	 * String key = f.getKey(); HComponent value = f.getValue();
	 * componentsToSupply = this.getComponentsToSupply(key, value); for
	 * (HComponent c : allInnerModel) { componentsToSupply.remove(c); }
	 * 
	 * if (componentsToSupply != null && componentsToSupply.size() > 0) {
	 * 
	 * int n = componentsToSupply.size(); List<HComponent> modelCopies = new
	 * ArrayList<HComponent>();
	 * 
	 * for (int i = 0; i < n; i++) { HComponent modelCopy = getMyCopy(value);
	 * modelCopies.add(modelCopy); modelCopy.unlinkFromConfiguration(); }
	 * 
	 * Iterator<HComponent> mcs = modelCopies.iterator();
	 * Iterator<Entry<HComponent, HComponent>> entries = componentsToSupply
	 * .entrySet().iterator(); String newVarName = key + "@" +
	 * System.currentTimeMillis(); while (mcs.hasNext()) { Entry<HComponent,
	 * HComponent> entry = entries.next(); HComponent c = (HComponent)
	 * entry.getKey(); HComponent modelCopy = (HComponent) mcs.next(); for
	 * (HComponent pc : c.getDirectParentConfigurations()) {
	 * pc.loadComponent(modelCopy, new Point(0, 0)); }
	 * HComponent.supersede(entry.getKey(), modelCopy, newVarName, value); if
	 * (model == value) { this.addAdjustSupply(value, modelCopy); } }
	 * this.invalidateInterfaceNames(); } } this.rememberSupply(varName, model);
	 * this.removeComponent(model); } }
	 */
	private void unlinkFromConfiguration() {
		this.configurations.clear();
	}

	public IBindingTarget newStubFor(HUnit unit, boolean forSubTyping,
			boolean forImplements, HComponent topConfiguration) {

		if (!this.getDirectParentConfigurations().contains(topConfiguration)) {
			JOptionPane.showMessageDialog(null, "(TODO) Cannot create a stub",
					"newStubFor", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		Rectangle bounds = unit.getBounds().getCopy();
		HUnitStub uStub = unit.createStub(topConfiguration);
		uStub.setBounds(bounds);
		int iu = this.getUnits().indexOf(unit); /*
												 * REMARK: new StubFor is now
												 * called only in subtyping or
												 * implements. There are no
												 * cloned unit
												 */
		unit.setConfiguration(topConfiguration);
		uStub.setConfiguration(this);
		this.getUnits().remove(uStub);
		this.getUnits().add(iu, uStub); // PLACE uStub in the same position of
										// unit

		HInterface i = (HInterface) unit.getInterface();
		i.setEditable(true);
		String iSubName = i.toString();
		if (forSubTyping) {
			i.setInherited(topConfiguration);
		} else if (forImplements) {
			i.setImplemented(topConfiguration);
		} else {
			i.setConfiguration(topConfiguration);
		}

		unit.hideSlices();
		unit.loadSavedBounds();
		return uStub;
	}

	public IBindingTarget newStubFor(HUnitStub unit, boolean forSubTyping,
			boolean forImplements, HComponent topConfiguration) {

		if (!getDirectParentConfigurations().contains(topConfiguration)) {
			JOptionPane.showMessageDialog(null, "(TODO) Cannot create a stub",
					"newStubFor", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		Rectangle bounds = unit.getBounds().getCopy();
		HUnitStub uStub = ((HUnit) unit.getActualUnit())
				.createStub(topConfiguration);
		uStub.setBounds(bounds);
		uStub.setConfiguration(topConfiguration);

		return uStub;
	}

	public HComponent getMyCopy() {

		HComponent that = null;// this.createComponent();

		for (HComponent c : this.components)
			that.components.add(c.getMyCopy());
		for (HComponent c : this.configurations)
			that.configurations.add(c);
		that.exposedFalsifiedContext = this.exposedFalsifiedContext;
		that.innerCRef = this.innerCRef;
		for (HInterface i : this.interfaces)
			that.interfaces.add(i); // TODO
		that.isExposed = this.isExposed;
		that.isParameter = this.isParameter;
		that.isRecursive = this.isRecursive;
		that.itImplements = this.itImplements.getMyCopy();
		that.location = this.location;
		for (Entry<HComponent, String> e : this.lOriginalInnerCRef.entrySet())
			that.lOriginalInnerCRef.put(e.getKey(), e.getValue());
		that.parameterIdentifier.putAll(this.parameterIdentifier);
		that.ref = this.ref;
		that.superType = this.superType;
		that.supplier = this.supplier;
		for (Entry<String, HComponent> sc : this.supplyMemory.entrySet())
			that.supplyMemory.put(sc.getKey(), sc.getValue());
		// that.units;
		that.uriLocal = this.uriLocal;
		that.uriRemote = this.uriRemote;
		that.setVariableName(this.variableName);

		return null;
	}

	// public abstract HComponent createComponent();

	public static HComponent getMyCopy(HComponent model) {

		HComponent modelCopy = null;

		List<HComponent> l1c = model.configurations;
		// List<HComponent> l2c = new ArrayList<HComponent>();
		// l2c.addAll(l1c);
		// model.configurations = null;

		// Collection<HReplicator> l1r = model.replicators;
		// Collection<HReplicator> l2r = new ArrayList<HReplicator>();
		// l2r.addAll(l1r);

		// model.replicators = null;

		try {
			NullObject nullObj = new NullObject();
			HComponent topC = (HComponent) model.getTopConfiguration();

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ObjectOutputStream_ oos = new ObjectOutputStream_(os, topC, nullObj);

			oos.writeObject(model);
			oos.flush();
			ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
			ObjectInputStream_ ois = new ObjectInputStream_(is, topC, nullObj);
			modelCopy = (HComponent) ois.readObject();

			oos.close();
			os.close();
			ois.close();
			is.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException ioe) {
			ioe.printStackTrace();
		}

		// for (HComponent c : l1c) model.setConfiguration(c);
		// modelCopy.configurations = l2c;

		// model.replicators = l1r;
		// modelCopy.replicators = l2r;

		return modelCopy;

	}

	public HComponent peekThatOneThatIsSubTypeOfTheOthers(Set<HComponent> cs) {

		// Among the components passed as parameters, peek the one that is
		// subtype of the others.
		// If such component does not exist, return null;

		// ASSUME SINGLE INHERITANCE

		HComponent c = null;

		for (HComponent i : cs) {
			if (c == null || i.isSubTypeOf(c)) {
				c = i;
			} else if (!c.isSubTypeOf(i)) {
				return null;
			}
		}

		return c;
	}

	private boolean isRecursive = false;
	public final static String PROPERTY_RECURSIVE = "PROPERTY_RECURSIVE";

	public void setRecursive(boolean isRecursive) {
		this.isRecursive = isRecursive;
		listeners.firePropertyChange(PROPERTY_RECURSIVE, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	public boolean isRecursive() {
		return this.isRecursive;
	}

	public boolean isRecursiveComponent() {
		return getRecursiveDimension() > 0;
	}

	protected int getRecursiveDimension() {

		if (this.getSuperType() != null) {
			Iterator<HComponent> cs = this.innerOccurrencesOfSubTypesOf(
					this.getSuperType()).iterator();

			int res = 0;
			while (cs.hasNext()) {
				HComponent c = cs.next();
				if (c.isRecursive())
					res++;
			}

			return res;
		} else {
			return 0;
		}

	}

	public final static String PROPERTY_HIDDEN_UNIT = "PROPERTY_HIDDEN_UNIT";

	public List<HComponent> getComponentsToReplicateInRecursion() { // TODO: ...

		List<HComponent> ls = new ArrayList<HComponent>();
		List<HComponent> cs = new ArrayList<HComponent>();
		cs.addAll(this.getComponents());
		cs.addAll(this.getExposedComponents());
		for (HComponent c : cs) {
			if (!c.isRecursive() && c != this.getSuperType()) {
				if (!ls.contains(c))
					ls.add(c);
			}
			if (c == this.getSuperType()) {
				for (HComponent _c : c.getComponentsToReplicateInRecursion())
					if (!ls.contains(_c))
						ls.add(_c);
			}
		}

		return ls;
	}

	public Pair<Map<HUnit, List<HUnit>>, Map<HUnit, Boolean>> calculateUnitCorrespondenceRecursion() {

		Map<HUnit, Boolean> uRs = new HashMap<HUnit, Boolean>();
		Map<HUnit, List<HUnit>> uCs = new HashMap<HUnit, List<HUnit>>();

		HComponent cSuper = this.getSuperType();
		List<HComponent> is = this.innerOccurrencesOfSubTypesOf(cSuper);
		List<IHUnit> ust = cSuper.getUnits();

		for (IHUnit u_ : ust) {
			HUnit u = (HUnit) u_.getActualUnit();
			uCs.put(u, new ArrayList<HUnit>());
		}

		for (HComponent c_ : is) {
			if (c_.isRecursive()) {
				HComponent c = (HComponent) c_.getSubTypeImageOf(cSuper);
				Iterator<IHUnit> cus = c.getUnits().iterator();
				int i = 0;
				while (cus.hasNext()) {
					IHUnit cu_ = cus.next();
					HUnit cu = (HUnit) cu_.getActualUnit();
					HUnit base_cu = (HUnit) ust.get(i).getActualUnit();
					uCs.get(base_cu).add(cu);
					uRs.put(cu, !cu.getBindings().isEmpty()); // TODO:
																// getBinding
																// para
																// getBindings
					i++;
				}
			}
		}

		return new Pair<Map<HUnit, List<HUnit>>, Map<HUnit, Boolean>>(uCs, uRs);
	}

	public List<Pair<HUnit, Integer>> getUnitsToReplicateInRecursion() {

		Pair<Map<HUnit, List<HUnit>>, Map<HUnit, Boolean>> pair = calculateUnitCorrespondenceRecursion();

		Map<HUnit, List<HUnit>> uCs = pair.fst();
		Map<HUnit, Boolean> uRs = pair.snd();

		List<Pair<HUnit, Integer>> replications = new ArrayList<Pair<HUnit, Integer>>();

		for (IHUnit _u : this.getUnits()) {
			HUnit u = (HUnit) _u;
			if (uCs.containsKey(u)) {
				Iterator<HUnit> vs = uCs.get(u).iterator();
				for (int j = 1; vs.hasNext(); j++) {
					HUnit v = vs.next();
					if (!uRs.get(v)) {
						// u is REPLICATED BY SUCH DIMENSION ...
						replications.add(new Pair<HUnit, Integer>(u, j));
					}
					/*
					 * IT IS REPLICATED BY LINK TO REPLICATOR IS INVISIBLE ...
					 */
					else {
						replications.add(new Pair<HUnit, Integer>(u, -j));
					}
					/*
					 * ...............................
					 */
				}
			} else {
				// FULL REPLICATED (in all dimensions)
				if (!u.hasStubs())
					replications
							.add(new Pair<HUnit, Integer>(u, new Integer(0)));
				else {
					u.setHidden(true);
					listeners.firePropertyChange(PROPERTY_HIDDEN_UNIT, null,
							name); //$NON-NLS-2$//$NON-NLS-1$		
				}
			}
		}

		return replications;

	}

	/*
	 * SUPONDO QUE TODA RECURSAO E' LINEAR, so' ha' necessidadade de um unico
	 * replicador para a recursao. Neste caso, e' retornado por
	 * getReplicatorRec. Supondo recursao nao linear, replicatorRec nao faz
	 * sentido dessa forma.
	 */


	/* ********************* */

	private int abs(int n) {
		if (n >= 0)
			return n;
		else
			return -n;
	}

	private void configureRecursion() {


	}

	/*
	 * public void recurse(HComponent cBasis) throws NoInnerOcurrencesException
	 * {
	 * 
	 * HComponent cSuper = this.getSuperType();
	 * 
	 * List<HComponent> cs = this.innerOccurrencesOfSubTypesOf(cSuper);
	 * HashMap<IHUnit,Vertex> vTable = new HashMap<IHUnit,Vertex>();
	 * HashMap<Vertex,IHUnit> vTableInv = new HashMap<Vertex,IHUnit>();
	 * List<Arc2> rUnits = new ArrayList<Arc2>();
	 * 
	 * Map<IHUnit,List<Pair<IHUnit,Boolean>>> recMap = new
	 * HashMap<IHUnit,List<Pair<IHUnit,Boolean>>>();
	 * 
	 * if (!cs.isEmpty()) {
	 * 
	 * DiGraph g = this.buildGraph(cBasis, cs, vTable, vTableInv, rUnits);
	 * 
	 * // for each Iterator<Arc2> as = rUnits.iterator(); while (as.hasNext()) {
	 * Arc2 a = as.next(); Vertex s = (Vertex) a.getTail(); Vertex t = (Vertex)
	 * a.getHead(); IHUnit us = vTableInv.get(s); IHUnit ut = vTableInv.get(t);
	 * 
	 * KShortestPaths k_shortest = new KShortestPaths(g,1);
	 * KShortestPaths.NAME_OF_VALUE = "poids"; k_shortest.run(t,s);
	 * k_shortest.printComputedPaths();
	 * 
	 * if (!recMap.containsKey(us)) { recMap.put(us,new
	 * ArrayList<Pair<IHUnit,Boolean>>()); }
	 * 
	 * List<Pair<IHUnit,Boolean>> entry = recMap.get(us); entry.add(new
	 * Pair<IHUnit,Boolean>(ut,k_shortest.numberOfComputedPaths() > 0)); }
	 * 
	 * this.getUnits();
	 * 
	 * 
	 * 
	 * 
	 * } else { throw new NoInnerOcurrencesException(); }
	 * 
	 * }
	 * 
	 * 
	 * private DiGraph buildGraph(HComponent cBasis, List<HComponent> is,
	 * HashMap<IHUnit,Vertex> vTable, HashMap<Vertex,IHUnit> vTableInv,
	 * List<Arc2> rUnits) {
	 * 
	 * HComponent cSuper = this.getSuperType();
	 * 
	 * List<Pair<IHUnit,IHUnit>> arcsToDo = new
	 * ArrayList<Pair<IHUnit,IHUnit>>();
	 * 
	 * VertexSet V = new VertexSet(); ArcSet A = new ArcSet(); DiGraph g = new
	 * DiGraph(V,A);
	 * 
	 * // CREATE VERTEXES Iterator<HComponent> cs =
	 * this.getComponents().iterator(); while (cs.hasNext()) { HComponent c =
	 * cs.next(); Iterator<IHUnit> us = c.getUnits().iterator(); while
	 * (us.hasNext()) { IHUnit u = us.next();
	 * 
	 * if (u instanceof HUnitStub) { u = u.getRealUnit(); } else if
	 * (u.getUnitSlice() != null){ arcsToDo.add(new
	 * Pair<IHUnit,IHUnit>(u,u.getUnitSlice().getUnit())); }
	 * 
	 * Vertex vu = new Vertex();
	 * vu.setDoubleValue(DijkstraAdvanced.DIJKSTRADISTANCE,1.0); V.add(vu);
	 * vTable.put(u,vu); vTableInv.put(vu,u); } }
	 * 
	 * // Look for proper units of cStep that are not stubs from inner
	 * components. Iterator<IHUnit> pus = this.getUnits().iterator(); while
	 * (pus.hasNext()) { IHUnit pu = pus.next(); if (!vTable.containsKey(pu)) {
	 * Vertex vu = new Vertex(); V.add(vu); vTable.put(pu,vu); } }
	 * 
	 * // CREATE Arc1 ARCS Iterator<Pair<IHUnit,IHUnit>> as =
	 * arcsToDo.iterator(); while (as.hasNext()) { Pair<IHUnit,IHUnit> a =
	 * as.next(); IHUnit tail = a.fst(); IHUnit head = a.snd(); Vertex tv =
	 * vTable.get(tail); Vertex th = vTable.get(head); Arc1 arc = new
	 * Arc1(tv,th); // arc.setValue(KShortestPath.WEIGHT, "1");
	 * arc.setDoubleValue(KShortestPaths.NAME_OF_VALUE,1.0); A.add(arc); }
	 * 
	 * List<IHUnit> ust = cSuper.getUnits();
	 * 
	 * Iterator<HComponent> iis = is.iterator(); while (iis.hasNext()) {
	 * HComponent c = iis.next(); Iterator<IHUnit> cus =
	 * c.getUnits().iterator(); int i = 0; while (cus.hasNext()) { IHUnit cu =
	 * cus.next(); cu = cu.getRealUnit(); IHUnit base_cu = (IHUnit) ust.get(i);
	 * base_cu = base_cu.getRealUnit(); Vertex tv = vTable.get(base_cu); Vertex
	 * th = vTable.get(cu); Arc2 arc = new Arc2(tv,th);
	 * arc.setDoubleValue(KShortestPaths.NAME_OF_VALUE,1.0); A.add(arc);
	 * rUnits.add(arc); i++; } }
	 * 
	 * 
	 * return g;
	 * 
	 * }
	 */

	private List<HComponent> innerOccurrencesOfSubTypesOf(HComponent c1) {

		List<HComponent> l = new ArrayList<HComponent>();

		Iterator<HComponent> cs = this.getComponents().iterator();
		while (cs.hasNext()) {
			HComponent c2 = cs.next();
			if (c2.isSubTypeOf(c1) && this.getSuperType() != c2)
				l.add(c2);
		}

		return l;
	}

	public class NoInnerOcurrencesException extends Exception {

		static final long serialVersionUID = 1;

	}

	/*
	 * // An Arc1 arc from a unit A to a unit B says that A is a slice of B.
	 * public class Arc1 extends Arc { public Arc1(AbstractVertex tail,
	 * AbstractVertex head) { super(tail,head); } }
	 * 
	 * // An Arc2 arc from a unit A to a unit B says that A is a subtyping unit
	 * and B is a corresponding unit int // the recursive component. public
	 * class Arc2 extends Arc { public Arc2(AbstractVertex tail, AbstractVertex
	 * head) { super(tail,head); } }
	 */



	// FOR XML GENERATION
	private List<HComponent> getComponentsSortedByRef() {
		List<HComponent> ps = new ArrayList<HComponent>(this.getComponents());
		return HComponent.sortComponentsByRef(ps);
	}

	private static List<HComponent> sortComponentsByRef(List<HComponent> ps) {
		if (ps.size() > 1) {
			HComponent pivot = ps.get(0);
			ps.remove(0);
			List<HComponent> ps_l = new ArrayList<HComponent>();
			List<HComponent> ps_r = new ArrayList<HComponent>();
			for (HComponent p : ps) {
				String ref = p.getRef();
				if (ref.compareTo(pivot.getRef()) < 0) {
					ps_l.add(p);
				} else {
					ps_r.add(p);
				}
			}
			List<HComponent> ps_l_ = sortComponentsByRef(ps_l);
			List<HComponent> ps_r_ = sortComponentsByRef(ps_r);
			ps_l_.add(pivot);
			ps_l_.addAll(ps_r_);
			return ps_l_;
		} else
			return ps;

	}

	private String ref = null;

	public String getRef() {
		return this.getName2();
		// if (ref == null)
		// ref = this.getComponentName() + "#" + System.currentTimeMillis() +
		// "%" + this.hashCode();
		// return ref;

	}


	public HHasExternalReferences fetchInterface(String iName) {

		for (HInterface i : this.getInterfaces()) {
			if (i.getPrimName().equals(iName))
				return i;
		}

		return null;
	}

	public void setRef(String ref2) {
		this.ref = ref2;

	}

	public boolean allSupplied() {
		boolean b = true;
		for (Entry<String, List<HComponent>> e : this.getParameters().entrySet()) 
		{
			for (HComponent c : e.getValue()) 
			{
				b = b && (c.getSupplier() != null || c.getWhoISupply() != null);
			}
		}
		return b;
	}

	private boolean isExposed = false;
	private HComponent exposedFalsifiedContext = null;

	public void updatePorts() throws HPEAbortException {

		// Update ports
		for (IHUnit _u : this.getAllUnits()) {
			if (!(_u instanceof HUnitStub)) {
				HUnit u = (HUnit) _u;
				for (HPrimUnit utop : u.getTopUnits(null)) {
					HComponent c = (HComponent) utop.getConfiguration();
					if (c.isTopConfiguration() && utop.getInterface() != null) {
						((HUnit) utop).updatePorts();
						HInterface i = (HInterface) utop.getInterface();
						if (!i.getHidden()) {
							utop.hideInterface();
							utop.showInterface();
						}
					}
				}
			}
		}

	}

	public void setExposed(boolean isExposed) 
	{
		if (this.isExposed != isExposed) 
		{
			boolean exposedBefore = this.isExposed;
			this.isExposed = isExposed;
			if (exposedBefore && !isExposed
					&& !this.isDirectSonOfTheTopConfiguration())
				this.exposedFalsifiedContext = (HComponent) this
						.getTopConfiguration();
			else
				this.exposedFalsifiedContext = null;

			try {
				updatePorts();
			} catch (HPEAbortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HComponent cTop = (HComponent) this.getTopConfiguration();			
			List<HComponent> component_fusions = cTop.getFusionComponents(this.getRef());
			if (component_fusions != null)
				for (HComponent cf : component_fusions)
				{
					cf.setExposed(isExposed);
				}

			listeners.firePropertyChange(this.PROPERTY_COLOR, null, name); //$NON-NLS-2$//$NON-NLS-1$

			((HComponent) this.getTopConfiguration()).updateConnections();

			for (HComponent c : this.getInnerTopConfigurations()) {
				c.updateConnections();
			}
		}

	}

	public final static String UPDATE_CONNECTIONS = "update connections";

	protected void updateConnections() {
		listeners.firePropertyChange(this.UPDATE_CONNECTIONS, null, name); //$NON-NLS-2$//$NON-NLS-1$
	}

	public boolean isPublic() {
		HComponent me = this.isSuperType() ? (HComponent) this.getConfiguration() : this;

		return me.isExposed;
	}

	public boolean IsExposedFalsifiedContextTop() {
		HComponent me = this.isSuperType() ? (HComponent) this.getConfiguration() : this;
		return !me.isDirectSonOfTheTopConfiguration()
				&& me.exposedFalsifiedContext == me.getTopConfiguration();
	}

	public boolean IsExposedFalsifiedContext(HComponent c) {
		HComponent me = this.isSuperType() ? (HComponent) this.getConfiguration() : this;
		return me.exposedFalsifiedContext == c;
	}

	static public void supersede3(HComponent c1, HComponent c2, boolean forSupply) 
	{
		HComponent cTop = (HComponent) c1.getTopConfiguration();
		String cRef = c1.getRef();
		List<HComponent> cList = new ArrayList<HComponent>();
		cList.add(c1);
		cList.add(c2);
		cTop.addFusion(cRef,cList);
		
		for (HComponent c : c2.getTopParentConfigurations()) {
			c.updateConnections();
			c.forceUpdateName();
		}
	}

	static public void supersede2(HComponent c1, HComponent c2, boolean forSupply) {

		HComponent c1_prime = (HComponent) (c1.getSupplier() == null ? c1 : c1.getSupplier());
		HComponent c2_prime = (HComponent) (c2.getSupplier() == null ? c2 : c2.getSupplier());
		
		// c2 <: c1;
		// c2 will replace its c1-image.
		if (c1 != c2) {

			for (HComponent c : c1.getDirectParentConfigurations()) {
				int i = c.getComponents().indexOf(c1);
				c.injectComponent(c2, i);
			}

			if (c2.isParameter()) {
				// c2.setVariableName(c1.getVariableName());
				c2.variableName.putAll(c1.variableName);
				if (c1.isParameter())
					c2.parameterIdentifier.putAll(c1.parameterIdentifier);
			}

			c2.setName(c1.getName2());
			if (c1.getSavedName() != null)
				c2.setSavedName(c1.getSavedName());
			c2.exposedFalsifiedContext = c1.exposedFalsifiedContext;

			HComponent im_c1inc2 = (HComponent) c2_prime.getSubTypeImageOf(c1_prime);
			Iterator us2 = ((ArrayList) ((ArrayList) im_c1inc2.getEntries()).clone()).iterator();
			Iterator us1 = ((ArrayList) ((ArrayList) c1.getEntries()).clone()).iterator();
			while (us1.hasNext() && us2.hasNext()) {
				IHPrimUnit u2 = (IHPrimUnit) us2.next();
				IHPrimUnit u1 = (IHPrimUnit) us1.next();

				Pair<IHPrimUnit, IHPrimUnit> pair = alignUnits(u1, u2);
				u1 = pair.fst();
				u2 = pair.snd();

				List<Pair<IHPrimUnit, IHPrimUnit>> pairs = matchUnits(u1, u2);

				for (Pair<IHPrimUnit, IHPrimUnit> e : pairs) {
					u1 = e.fst();
					u2 = e.snd();
					if (forSupply) {
						//u2.unsetAllReplicators();
					}
					HUnit.supersede(u1, u2);
				}
			}

			for (Pair<HComponent, HComponent> p : c2_prime.getSubTypeImageOf2(c1_prime)) {
				HComponent c1_ = p.fst();
				HComponent c2_ = p.snd();
				if (c1 != c1_ && c2 != c2_) {
					c2_.parameterIdentifier.putAll(c1_.parameterIdentifier);
				}

			}

			c2.setBounds(c1.getBounds().getCopy());

			List<HComponent> l = new ArrayList<HComponent>();
			for (HComponent c : c1.getDirectParentConfigurations())
				l.add(c);
			for (HComponent c1_ : l) {
				c1_.removeComponent2(c1);
			}

			Iterator<HComponent> c2s = im_c1inc2.getComponentsSortedByRef().iterator();
			Iterator<HComponent> c1s = c1.getComponentsSortedByRef().iterator();
			while (c2s.hasNext() && c1s.hasNext()) {
				HComponent c1_ = c1s.next();
				HComponent c2_ = c2s.next();
				HComponent.supersede2(c1_, c2_, forSupply);
			}

			// Update ports
			// c2.setExposed(c1.getExposed());
			// c2.updatePorts();

			// for (HComponent c2_ : c2.getAllParentConfigurations()) {
			// c2_.forceUpdateName();
			// }

			for (HComponent c : c2.getTopParentConfigurations()) {
				c.updateConnections();
				c.forceUpdateName();
			}

		}
	}

	private static List<Pair<IHPrimUnit, IHPrimUnit>> matchUnits(IHPrimUnit u1,
			IHPrimUnit u2) {

		List<Pair<IHPrimUnit, IHPrimUnit>> l = new ArrayList<Pair<IHPrimUnit, IHPrimUnit>>();

		l.add(new Pair<IHPrimUnit, IHPrimUnit>(u1, u2));

		return l;
	}

	private static IHPrimUnit alignClones(IHPrimUnit u1, IHPrimUnit u2) {

		IHPrimUnit u1_ = u1;

		return u1_;

	}


	static public boolean checkConsistencyOfUnitsInSuperseding(HComponent c1, HComponent c2) {

		//HComponent c1 = c1_.getSupplier() == null ? c1_ : c1_.getSupplier(); 
		//HComponent c2 = c2_.getSupplier() == null ? c2_ : c2_.getSupplier();
		
		IComponent im_c1inc2 = c2; //c2_.getSubTypeImageOf(c1_);
		HComponent topC = (HComponent) c1.getTopConfiguration();
		Iterator<IHUnit> us2 = ((ArrayList<IHUnit>) ((ArrayList<IHUnit>) im_c1inc2.getEntries()).clone()).iterator();
		Iterator us1 = ((ArrayList) ((ArrayList) c1.getEntries()).clone()).iterator();
		while (us1.hasNext() && us2.hasNext()) {
			IHUnit u2 = us2.next();
			IHUnit u1 = (IHUnit) us1.next();

			// ALinhar unidades...
			//Pair<IHPrimUnit, IHPrimUnit> pair = alignUnits(u1, u2);
			//u1 = (IHUnit) pair.fst();
			//u2 = (IHUnit) pair.snd();

			IHUnit topU2 = (IHUnit) u2.getTopUnit(null);
			IHUnit topU1 = (IHUnit) u1.getTopUnit(null);
			HComponent topC1 = (HComponent) topU1.getConfiguration();
			HComponent topC2 = (HComponent) topU2.getConfiguration();

			if (!((topU1 == topU2 && topC1 == topC2 && topC2 == topC) || (topU1 != topU2 && topC1 != topC2)))
				return false;

		}

		return true;
	}

	public List<HComponent> getInnerTopConfigurations() {
		List<HComponent> l = new ArrayList<HComponent>(); // this.getAllParentConfigurations();

		HComponent topC = (HComponent) this.getTopConfiguration();
		for (HComponent c : this.getDirectParentConfigurations()) {
			if (c.getDirectParentConfigurations().contains(topC)) {
				l.add(c);
				l.addAll(c.getExposedComponents());
			}

		}

		return l;

	}

	public List<HComponent> getAllParentConfigurations() {

		if (configurations == null)
			configurations = new ArrayList<HComponent>();
		List<HComponent> l = new ArrayList<HComponent>();

		HComponent c = this;
		if (!c.isTopConfiguration()) {
			for (HComponent c_ : configurations) {
				if (!l.contains(c_))
					l.add(c_);
				for (HComponent c__ : c_.getAllParentConfigurations())
					if (!l.contains(c__))
						l.add(c__);
			}
		}

		return l;
	}

	public HComponent getExposedComponentByName(String name) {

		Collection<HComponent> exposedComponents = this.getExposedComponents();

		for (HComponent c : exposedComponents) {
			if (c.getName2().equals(name))
				return c;
		}

		return null;

	}

	/*
	 * private Map<HComponent, List<HComponent>> adjustSuppliers = null;
	 * 
	 * private void addAdjustSupply(HComponent model, HComponent modelCopy) { if
	 * (adjustSuppliers == null) { adjustSuppliers = new HashMap<HComponent,
	 * List<HComponent>>(); } if (adjustSuppliers.containsKey(model)) {
	 * adjustSuppliers.get(model).add(modelCopy); } else { List<HComponent> ls =
	 * new ArrayList<HComponent>(); ls.add(modelCopy);
	 * adjustSuppliers.put(model, ls); } }
	 * 
	 * public void performAdjustSupply() { if (adjustSuppliers != null) {
	 * Collection<HComponent> exposedOnes = this.getExposedComponents(); for
	 * (Entry<HComponent, List<HComponent>> adj : adjustSuppliers .entrySet()) {
	 * HComponent model = adj.getKey(); for (HComponent modelCopy :
	 * adj.getValue()) { if (exposedOnes.contains(modelCopy) &&
	 * modelCopy.isHiddenInnerComponent()) {
	 * model.setName(modelCopy.getName2()); } } } } }
	 */

	private Map<String, HComponent> supplyMemory = new HashMap<String, HComponent>();
	private Map<String, Boolean> supplyTransitive = new HashMap<String, Boolean>();

	public boolean checkIfVariableWasSupplied(String varName) {
		return supplyMemory.containsKey(varName);
	}

	public void rememberSupply(String varName, HComponent c, boolean transitive) {
		if (supplyMemory == null)
			supplyMemory = new HashMap<String, HComponent>();
		supplyMemory.put(varName, c);
		supplyTransitive.put(varName, transitive);
	}

	public Map<String, HComponent> getSupplierComponents() {

		/*
		 * Todos os components que foram usados na configuracao para suprir
		 * parametros de componentes internos.
		 */
		if (supplyMemory == null)
			supplyMemory = new HashMap<String, HComponent>();
		return supplyMemory;

	}
	
	public boolean isTransitiveSupplier(String varName)
	{
	    return supplyTransitive.get(varName);
	}

	public HComponent getSupplierComponent(String varName) {

		Map<String, HComponent> supplyMemoryTop = ((HComponent) this.getTopConfiguration()).getSupplierComponents();

		return supplyMemoryTop.get(varName);

	}

	public static boolean checkConsistencyOfCardinalityInSuperseding(
			HComponent c1, HComponent c2) {


		return true;
	}




	public static List<HComponent> commonParent(HComponent c1, HComponent c2) {

		List<HComponent> lc1 = c1.getDirectParentConfigurations();
		List<HComponent> lc2 = c2.getDirectParentConfigurations();

		List<HComponent> lc1_diff_lc2 = new ArrayList<HComponent>();
		lc1_diff_lc2.addAll(lc1);
		lc1_diff_lc2.removeAll(lc2);

		List<HComponent> lc2_diff_lc1 = new ArrayList<HComponent>();
		lc2_diff_lc1.addAll(lc2);
		lc2_diff_lc1.removeAll(lc1);

		List<HComponent> lc2_union_lc1 = new ArrayList<HComponent>();
		lc2_union_lc1.addAll(lc1);
		lc2_union_lc1.addAll(lc2);

		List<HComponent> lc2_intersection_lc1 = new ArrayList<HComponent>();
		for (HComponent c : lc2_union_lc1)
			if (!lc2_intersection_lc1.contains(c))
				lc2_intersection_lc1.add(c);

		lc2_intersection_lc1.removeAll(lc1_diff_lc2);
		lc2_intersection_lc1.removeAll(lc2_diff_lc1);

		return lc2_intersection_lc1;
	}

	private String hash_component_UID;

	public void setHashComponentUID(String hash_component_UID) {
		this.hash_component_UID = hash_component_UID;
	}

	public String getHashComponentUID() {
		if (this.hash_component_UID == null
				|| this.hash_component_UID.equals("")) {
			this.hash_component_UID = this.getComponentName().toLowerCase();
		}

		return this.hash_component_UID;
	}

	public boolean isTransitiveInnerComponentOf(HComponent c2) {

		if (configurations == null)
			configurations = new ArrayList<HComponent>();

		HComponent c = this;
		if (!c.isTopConfiguration()) {
			for (HComponent c_ : configurations) {
				if (c_ == c2 || c_.isTransitiveInnerComponentOf(c2))
					return true;
			}
		}

		return false;
	}

	private String generateFreshRef() {

		// Integer max = this.getAllInnerComponents().size();
		// return "c" + (max+1);

		return UNDEFINED_NAME;
	}

	public static String UNDEFINED_NAME = "?";

	private boolean checkLegalRef(String ref) {

		/*
		 * for (HComponent c : this.getExposedComponents()) { String name =
		 * c.getRef(); if (name.equals(ref)) return false; }
		 * 
		 * for (HComponent c : this.getComponents()) { String name = c.getRef();
		 * if (name.equals(ref)) return false; }
		 */

		return true;
	}

	public static String breakLines(String name) {
		return breakLines(name, null).fst();
	}

	private static Pair<String, Integer> breakLines(String name, String ident) {

		if (ident == null)
			ident = "";
		String name_ = "";
		String head = "";

		Integer overhead = 0;
		int i = 0;
		boolean eos = false;
		boolean endhead = false;
		while (!eos) {
			if (i >= name.length())
				break;
			char c = name.charAt(i);
			if (name.charAt(i) == '<') {
				String subname = name.substring(i + 1);
				Pair<String, Integer> pair = breakLines(subname, ident + head);
				String a = pair.fst();
				name_ += ('<' + a + '>');
				i += a.length() - pair.snd() + 1;
				overhead += pair.snd();
				endhead = true;
			} else if (name.charAt(i) == '>') {
				eos = true;
			} else if (name.charAt(i) == ',' /* && level == 1 */) {
				// String a = breakLines(name.substring(lastindex, i+1), isFirst
				// ? "" : ident + head);
				name_ += c + " \n" + ident;
				overhead += (" \n" + ident).length();
				endhead = false;
				head = "";

			} else {
				name_ += c;
				if (!endhead)
					head += " ";
			}
			i++;
		}

		return new Pair<String, Integer>(name_, overhead);
	}

	public boolean hasFreeVariables() {

		HComponent topC = (HComponent) this.getTopConfiguration();

		Map<String, List<HComponent>> params = this.getParameters(topC);

		for (Entry<String, List<HComponent>> entry : params.entrySet()) {
			List<HComponent> cs = entry.getValue();
			// for (HComponent c : cs) {
			HComponent c = cs.get(0);
			String parIdAtTopC = c.getParameterIdentifier(topC);
			String varName = c.getVariableName();
			if (parIdAtTopC.equals("type ?") && !c.isInnerOfFreeParameter()
					&& (c.isParameter() && c.getSupplier() == null))
				return true;
			// }

		}

		return false;
	}

	private boolean isInnerOfFreeParameter() {

		List<HComponent> cs = this.getAllParentConfigurations();
		HComponent topC = (HComponent) this.getTopConfiguration();
		for (HComponent c : cs) {
			if (c.isParameter()) {
				String parIdAtTopC = c.getParameterIdentifier(topC);
				if (!parIdAtTopC.equals("type ?"))
					return true;
			}
		}

		return false;
	}

	public boolean versionCompiled(String versionStr) {

		for (HInterface i : this.getInterfaces()) {
			if (i.getConfiguration() == this) {
				HBESourceVersion version = i.getSourceVersion(versionStr);
				for (Object obj : version.getFiles()) {
					HBEAbstractFile file = (HBEAbstractFile) obj;
					IPath binPath = file.getBinaryPath();

					return HComponentFactoryImpl.existsInWorkspace(binPath);

					// if
					// (!ResourcesPlugin.getWorkspace().getRoot().exists(binPath))
					// return false;
				}
			}
		}

		return true;
	}

	public void createComponentKey() throws IOException {

		IPath pathKeyFile = (new Path(this.getLocalLocation()))
				.removeFileExtension().addFileExtension("snk");
		IPath pathPubFile = (new Path(this.getLocalLocation()))
				.removeFileExtension().addFileExtension("pub");
		// boolean okSNK =
		// ResourcesPlugin.getWorkspace().getRoot().exists(pathKeyFile);
		// boolean okPUB =
		// ResourcesPlugin.getWorkspace().getRoot().exists(pathPubFile);
		boolean okSNK = HComponentFactoryImpl.existsInWorkspace(pathKeyFile
				.setDevice(null));
		boolean okPUB = HComponentFactoryImpl.existsInWorkspace(pathPubFile
				.setDevice(null));

		boolean success = true;

		if (!okSNK || !okPUB) {
			String sn_path = HPEProperties.getInstance().getValue(
					PreferenceConstants.SN_PATH);

			// IFolder file =
			// ResourcesPlugin.getWorkspace().getRoot().getFolder(new
			// Path(this.getLocalLocation()));

			// this.getRelativeLocation();

			// tratar melhor no futuro
			if (!new File(sn_path).exists()) {
				throw new IOException(
						"THE PREFERENCE VARIABLE MONO_BIN_PATH IS MANDATORY. CONFIGURE ON THE PREFERENCE PAGE!");
			}

			IPath loc = HComponentFactoryImpl.buildWPath(new Path(this.getRelativeLocation())); // file.getLocation();

			if (loc != null) {
				IPath systemPath = loc.removeLastSegments(1);
				// java.io.File systemFile = new
				// java.io.File(systemPath.toString());
				java.io.File systemFile = systemPath.toFile();

				if (success && !okSNK) {
					int r = CommandLine.runCommand(new String[] { sn_path,
							"-k", this.getComponentName() + ".snk" },
							systemFile);
					success = r == CommandLine.SUCESSFULL_COMMAND;

				}

				if (success && !okPUB) {
					int r = CommandLine.runCommand(
							new String[] { sn_path, "-p",
									this.getComponentName() + ".snk",
									this.getComponentName() + ".pub" },
							systemFile);
					success = r == CommandLine.SUCESSFULL_COMMAND;
				}
			}
		}

		if (success) {
			// IFile fileW =
			// ResourcesPlugin.getWorkspace().getRoot().getFile(pathPubFile);
			java.io.File fileW = HComponentFactoryImpl
					.getFileInWorkspace(pathPubFile.setDevice(null));
			if (fileW.getAbsolutePath() != null) {
				InputStream is = new FileInputStream(fileW);
				byte[] pk = new byte[is.available()];
				is.read(pk);
				is.close();
				String pkStr = null;
				try {
					pkStr = getHexString(pk);
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.setHashComponentUID(pkStr);
			}
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"Error creating key files. It will not be possible to build the component.",
							"Key Files Error", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public static String getHexString(byte[] b) throws Exception {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

	public static URI getStandardLocationPath(String pk, String componentName,
			String version) {
		return URI.createURI(pk + "." + componentName
				+ java.io.File.separatorChar + componentName + ".hpe");
	}

	private boolean show_unitary_replicators = false;

	public boolean showUnitaryReplicators() {
		return show_unitary_replicators;
	}

	public void setShowUnitaryReplicators(boolean show) {
		show_unitary_replicators = show;
	}

	public int getMyInstanceId() {
		return myInstanceId;
	}

	public void hideInnerComponent(HComponent c) {
		if (this.getInnerComponents().contains(c)) {
			c.setHiddenInnerComponent(true);
		}
		listeners.firePropertyChange(NEW_COMPONENT, null, name); //$NON-NLS-2$//$NON-NLS-1$	
	}

	protected void setHiddenInnerComponent(boolean hidden	) {
		this.hiddenInnerComponent = hidden;
	}

	public boolean isHiddenInnerComponent() {
		return hiddenInnerComponent;
	}

	private boolean hiddenInnerComponent = false;

	public void removeMe() {
		this.getTopConfiguration().removeComponent(this);

	}

	private boolean derivedFromPermutation = false;

	public boolean isDerivedFromPermutation() {
		return derivedFromPermutation;
	}

	public void setDerivedFromPermutation(boolean derivedFromPermutation) {
		this.derivedFromPermutation = derivedFromPermutation;
		this.setHiddenInnerComponent(true);
	}

	public boolean isInnerComponentOf(HComponent c1) {

		List<HComponent> csParent = this.getDirectParentConfigurations();
		if (csParent.contains(c1)) {
			return true;
		} else {
			for (HComponent thisParent : csParent) {
				if (thisParent.isInnerComponentOf(c1)) {
					return true;
				}
			}
		}

		return false;
	}

	public HComponent getParentConfiguration() {
		HComponent current_c = this;
		HComponent parent_c = (HComponent) this.getConfiguration();
		HComponent top_c = (HComponent) this.getTopConfiguration();

		while (parent_c != top_c) {
			current_c = parent_c;
			parent_c = (HComponent) parent_c.getConfiguration();
		}

		return current_c;
	}

	public HInterface getInterfaceByName(String primName) {
		for (HInterface i : this.getInterfaces()) {
			if (i.getPrimBaseName() != null
					&& i.getPrimBaseNameAll().contains(primName))
				return i;
		}
		return null;
	}

	public HComponent getInnerComponentByName(String ref2) {

		List<HComponent> innerComponents = this.getComponents();

		for (HComponent cs : innerComponents) {
			if (!cs.isHiddenInnerComponent() && cs.getRef().equals(ref2)) {
				return cs;
			}
		}

		return this.getExposedComponentByName(ref2);
	}

    private boolean is_multiple = false;
    
	public boolean isMultiple() {		
		return is_multiple;
	}

	public void setMultiple(boolean is_multiple) {
		this.is_multiple = is_multiple;
		listeners.firePropertyChange(CHANGE_MULTIPLE,null,this.getBounds());	
	}
	
	private Map<String,List<HComponent>> fusions = new HashMap<String,List<HComponent>>();
	
	public void addFusion(String cRef, List<HComponent> cs)
	{
		if (fusions.containsKey(cRef)) 
		{
		   for (HComponent c : cs)
		   {
			   List<HComponent> cList = fusions.get(cRef);
			   if (!cList.contains(c))
				   cList.add(c);
		   }
		} 
		else
		{
			fusions.put(cRef, cs);
		}
	}
	
	public List<HComponent> getFusionComponents(String cRef)
	{
		return fusions.get(cRef);
	}
	
	public Map<String,List<HComponent>> getFusions()
	{
		return fusions;
	}
	
	private Map<String,Integer> parameter_order = new HashMap<String,Integer>();
	
	public void setParameterOrder(String par_id, Integer order)
	{
		if (parameter_order.containsKey(par_id))
			parameter_order.remove(par_id);		
		parameter_order.put(par_id, order);
	}
	
	public int getParameterOrder(String par_id)
	{
		HComponent c = this.isAbstract() ? this : this.getWhoItImplements();
		
		if (c.parameter_order.containsKey(par_id))
			return c.parameter_order.get(par_id);
		else
			return -1;
	}
	
	
	

}
