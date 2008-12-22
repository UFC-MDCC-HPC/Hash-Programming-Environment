package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IComputationConfiguration;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.interfaces.IReplicator;
import hPE.frontend.base.model.HReplicator.ReplicatorOrigin;
import hPE.frontend.kinds.base.model.HHasPortsInterface;
import hPE.util.NullObject;
import hPE.util.ObjectInputStream_;
import hPE.util.ObjectOutputStream_;
import hPE.util.Pair;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.graphics.Color;



public abstract class HComponent extends HVisualElement implements HNamed, Cloneable, IComponent ,IReplicatedElement, Serializable, IHasColor, IComputationConfiguration {
	
	static final long serialVersionUID = 1;
	
	private String myPackage = null;
	
	public void setPackagePath(IPath myPackage) {
		this.myPackage = myPackage.toPortableString();
	}
	
	public IPath getPackagePath() {
		return new Path(this.myPackage); 
	}
	
	
	// TODO: EXISTENTIAL TYPE
	//private boolean existentialType = false;
	
	//public boolean isExistentialType() {
	//	return existentialType && isParameter();
	//}
	
	private Map<HComponent,String> lOriginalInnerCRef = new HashMap<HComponent,String>();
	
	private String innerCRef = "";
	
	public void saveName() {
		if (this.lOriginalInnerCRef == null) lOriginalInnerCRef = new HashMap<HComponent,String>();
		HComponent c = this.getTopParentConfigurations().get(0); // saveName is always called before fusion ...
		this.lOriginalInnerCRef.put(c,this.innerCRef);
	}
	
	public void setSavedName(Map<HComponent,String> names) {
		if (this.lOriginalInnerCRef == null) lOriginalInnerCRef = new HashMap<HComponent,String>();
		for (Entry<HComponent,String> n : names.entrySet()) 
			if (!this.lOriginalInnerCRef.containsKey(n.getKey())) 
				this.lOriginalInnerCRef.put(n.getKey(),n.getValue());
	}
	
	public Map<HComponent,String> getSavedName() {
		if (this.lOriginalInnerCRef == null) lOriginalInnerCRef = new HashMap<HComponent,String>();
		return this.lOriginalInnerCRef;
	}
	
	public String getName2() {
		if (innerCRef == null) innerCRef = "";
		return innerCRef;
	}
	
	public void setName (String innerCRef) {
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
	 * @uml.property   name="interfaces"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" inverse="configuration:hPE.base.model.HInterface"
	 */
	private Collection<HInterface> interfaces = new ArrayList<HInterface>();

	/* (non-Javadoc)
	 * @see hPE.base.model.IComponent#getInterfaces()
	 */
	public Collection<HInterface> getInterfaces() {
		return interfaces; 
	}

	/**
	 * @uml.property   name="units"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" inverse="configuration:hPE.base.model.HUnit"
	 */
	private List<IHUnit> units = new ArrayList<IHUnit>();

	/* (non-Javadoc)
	 * @see hPE.base.model.IComponent#getUnits()
	 */
	public List<IHUnit> getUnits() {
		return units;
	}

	/* return the list of units and clones of units. The cloned unit is not returned with its clones. */
	public List<IHUnit> getAllUnits() {
		List<IHUnit> ls = new ArrayList<IHUnit>();
		for (IHUnit u : this.getUnits()) {
			for (IHPrimUnit u_ : u.getClones()) {
			   ls.add((IHUnit) u_);
			}
		}
		return ls;
	}
	
	public final static String PROPERTY_INHERITS = "PROPERTY_INHERITS";
	
	public void setExtends(HComponent inheritedFrom) {
	    
		Iterator<IHUnit> us = ((List)((ArrayList)inheritedFrom.getAllUnits()).clone()).iterator();
		
		while (us.hasNext()) {
			IHUnit the_source = us.next();			
			HComponent c = (HComponent)the_source.getConfiguration();
			
			if (!the_source.getHidden()) {
			   IBindingTarget the_target = c.newStubFor((HUnit)the_source, true, false, (HComponent) c.getConfiguration());			
			   new HBinding(c,the_target,the_source); // TODO: setBinding ... antes estava HBinding(c,the_source,the_target)
			   HInterface i = (HInterface) the_source.getInterface();
			   for (HPort p : i.getPorts()) {
				   p.setInherited(true);
			   }
			   // i.setName(null);
			  // i.setEditable(false);
			  // if (!this.isAbstractConfiguration()) i.setEditableSource(true);
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
		
		Iterator<IHUnit> us = ((List)((ArrayList)itImplements.getAllUnits()).clone()).iterator();
		
		while (us.hasNext()) {
			IHUnit the_source = us.next();			
			HComponent c = (HComponent)the_source.getConfiguration();
			
			if (!the_source.getHidden()) {
			   IBindingTarget the_target = c.newStubFor((HUnit)the_source,false, true, (HComponent) c.getTopConfiguration());			
			   new HBinding(c,the_target,the_source); // TODO: setBindig ... 
			   HInterface i = (HInterface) the_target.getInterface();
			   i.setImplements(); // mark versions to be overriden ...
			   try {
				((HUnit)the_source).updatePorts();
			} catch (HPEAbortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
	/*		   if (i instanceof HHasPortsInterface) {
			    HHasPortsInterface iwp = (HHasPortsInterface) i; 
			    List<IHProvidesPort> ports = new ArrayList<IHProvidesPort>();
				iwp.getPorts(ports, null, "", ".", 1);
				for (IHProvidesPort p : ports) {
					p.resetDefaultName();
				}
			   } 
    */
			   
	//		   i.setEditableSource(true);
		//	   i.setEditable(false);
			}
		}

		listeners.firePropertyChange(PROPERTY_CONCRETE_CONFIGURATION, null, name); //$NON-NLS-2$//$NON-NLS-1$		
		
	}
	
	public boolean isAbstractConfiguration() {
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
			if (u.getName2().equals(uName) && !u.isClone()) 
				return u;
		
		return null;
	}
	
	public IHUnit fetchUnit(String uName, int iReplica) {
		
		for (IHUnit u : this.getUnits()) 
			if (u.getName2().equals(uName) && !u.isClone()) 
				return (IHUnit) u.getClone(iReplica) ;		
		
		return null;
	}
	
	public IBindingTarget createBinding(IHUnit the_source, IHUnit the_unit, Point where) throws HPEAbortException {
		
			if (!the_unit.isClone() && the_unit.getInterface() != null && !the_unit.isInterfaceEditable()) {
			  throw new HPEAbortException("Non Editable Interface !");	
			}
			
			IBindingTarget the_target = the_source.newSlice(the_unit,where);
			HInterface i = (HInterface) the_source.getInterface();
			i.setEditable(false);
			
			new HBinding(this,the_target,the_source);
			
			if (the_target instanceof HUnitSlice) {
				HUnitSlice s = (HUnitSlice) the_target;
				for (HLinkToReplicator l : s.getLinksToReplicators()) {
				   l.liftReplicator();
				}
			} 
			
			return the_target;
		
	}
	
	/**
	 * @uml.property   name="name" readOnly="true"
	 */
	private String name = "";

	public String getComponentName() {
		return name;
	}
	
	public void setComponentName(String name) {
		this.name = name;		
		listeners.firePropertyChange(UPDATE_NAME, null, name); //$NON-NLS-2$//$NON-NLS-1$	
		
	}

	
	/**
	 * @param existentialType TODO
	 */
	public HComponent(String name, IPackageLocation location, URI uri) {
		super();
		this.name = name;
		this.location = location;
 		this.setURI(uri);
		
		listeners = new PropertyChangeSupport(this);
		
	}
	
	private String uri = null;
	
	public URI getURI() {
		return URI.createURI(uri);
	}
	
	public void setURI(URI uri) {
		this.uri = uri.toString();
	}
	
//	public final static String PROPERTY_EXISTENTIAL = "PROPERTY_EXISTENTIAL";

//	public void setExistentialType(boolean existentialType) {
//		this.existentialType = existentialType;
//		listeners.firePropertyChange(PROPERTY_EXISTENTIAL, null, name); //$NON-NLS-2$//$NON-NLS-1$	
//	}
	
	/**
	 * @uml.property  name="components"
	 * @uml.associationEnd  readOnly="true" multiplicity="(0 -1)" inverse="configuration:hPE.model.HComponent"
	 */
	private List<HComponent> components = new ArrayList<HComponent>();

	/* (non-Javadoc)
	 * @see hPE.base.model.IComponent#getComponents()
	 */
	public List<HComponent> getComponents() {
		return components;
	}


	
	public Collection<HComponent> getExposedComponents() {
		
		Collection<HComponent> cs = new ArrayList<HComponent>();
		
		for (HComponent c : this.getComponents()) { 
			if (!c.isSuperType() && (c.getExposed() || (!c.getExposed() && c.IsExposedFalsifiedContextTop()))) {
			//	if (!c.isDirectSonOfTheTopConfiguration()) {
			//	    if (!cs.contains(c)) cs.add(c);
			//	} else {
				if (!cs.contains(c)) cs.add(c);
				for (HComponent c_ : c.getExposedComponents()) {
					if (!cs.contains(c_)) cs.add(c_);	
				}
			//	}
			} else {
				for (HComponent c_ : c.getExposedComponents()) {
					if (!cs.contains(c_)) cs.add(c_);	
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
		   components.add(i,component);
		}
	}

	
	public void newUnit(IHUnit unit) {
		units.add(unit);		
		listeners.firePropertyChange(NEW_UNIT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}
	
	public abstract HUnit createUnit(); /*{
		return new HUnit(null,this);
	}*/

	
	
	public void newInterface(HInterface the_interface) {
		
		List<HComponent> l = new ArrayList<HComponent>();
		
		l.add(this);
		// HComponent c = this;
		do {
			HComponent c = (HComponent) l.get(0); //c.getConfiguration();
			l.remove(0);
		    if (!c.interfaces.contains(the_interface)) c.interfaces.add(the_interface);
		    l.addAll(c.getDirectParentConfigurations());
		} while (!l.isEmpty());
		
		listeners.firePropertyChange(NEW_INTERFACE, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	/**
	 */
	public void newReplicator(HReplicator new_replicator) {
		if (!this.replicators.contains(new_replicator)) 
			this.replicators.add(new_replicator);
		listeners.firePropertyChange(NEW_REPLICATOR, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}

	
	
	
	/**
	 * @uml.property   name="bindings"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" inverse="configuration:hPE.base.model.HBinding"
	 */
	private Collection bindings = new ArrayList();

	/**
	 * Getter of the property <tt>bindings</tt>
	 * @return  Returns the bindings.
	 * @uml.property  name="bindings"
	 */
	public Collection getBindings() {
		return bindings;
	}

	/**
	 */
	public void newBinding(HBinding binding) {
		bindings.add(binding);
	}

	public void liftStubs() {
		for (IHUnit u : ((List<IHUnit>)((ArrayList<IHUnit>)this.getAllUnits()).clone())) {
			for (HBinding b : u.getBindings()) {
		   	    if (b.getPort() instanceof HUnitStub) u.unsetBinding();
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
	
	public void unlinkReplicator(HReplicator replicator) {
		
		replicators.remove(replicator);
		if (!this.isTopConfiguration()) {
			for (HComponent c : this.getDirectParentConfigurations()) {
			   c.unlinkReplicator(replicator);
			}
		}		
		
		listeners.firePropertyChange(NEW_REPLICATOR, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}
	
/*	public HInterface getInterface(String id) {
		
		if (iHMap.containsKey(id)) {
			HInterface i = (HInterface) iHMap.get(id);
			return i;
		} else {
			return null;
		}
		
	} */
	
	
/*	public void removeInterface(String id) {
		
		HConfiguration c = this;
		
		while (c!=null) {
			if (iHMap.containsKey(id)) {
				HInterface i = (HInterface) iHMap.get(id);
				if (i.getLinksToTheInterface().size() == 0) {
					iHMap.remove(id);
					interfaces.remove(i);			
				}
			} else {
				System.out.println("ERROR: Interface NOT found ! (removeInterface):".concat(id));
			}
			c =(HConfiguration) c.getConfiguration();
		}
		
	}
	*/
	 
	public void removeInterface(HInterface i) {
	
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
		
	}

	/**
	 * @uml.property   name="replicators"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="configuration:hPE.base.model.HReplicator"
	 */
	private List<HReplicator> replicators = new ArrayList<HReplicator>();

	/* (non-Javadoc)
	 * @see hPE.base.model.IComponent#gettReplicators()
	 */
	public List<HReplicator> gettReplicators() {
		return replicators;
	}


	/**
	 * Setter of the property <tt>replicators</tt>
	 * @param replicators  The replicators to set.
	 * @uml.property  name="replicators"
	 */
	public void setReplicators(List<HReplicator> replicators) {
		this.replicators = replicators;
	}

	protected IComponent findComponentByName(String name) {
		
		for (IComponent c : this.components) {
			if (c.getComponentName().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
/*	public void updateInterfaceName(HPrimInterface i) {
		
		HConfiguration c = this;
		String indexName = i.getIndexName(); 
		while (c!=null) {
			if (c.iHMap.containsKey(indexName)) {
			   c.iHMap.remove(indexName);
			   c.iHMap.put(i.toString(),i);
			} else {
				System.out.println("ERROR: Interface NOT found ! HConfiguration (updateInterfaceName)");
			}
			c = (HConfiguration) c.getConfiguration();
		}
		i.setIndexName(i.toString());
		
	}
	*/
	
		
	public void updateVariableName(String formFieldId, String varName) {
		
		 Map<String,List<HComponent>> m = this.getParameters2();
		 for (HComponent cUpdate : m.get(formFieldId)) 
			 cUpdate.setVariableName(varName);
		 

	}
	
	public void loadComponent(HComponent c, Point where) {

		c.hideAllInterfaces();
		if (c.getRef() == null || c.getRef().equals("")) {
		   c.setName(this.generateFreshRef());
		}
		
		c.setConfiguration(this);		
		this.addComponent(c);
			
		int i = this.getUnits().size();
		
		Rectangle bounds = new Rectangle(where,new Dimension(50,30));
		bounds.translate(0,(i-1)*50);
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
		
		for (HReplicator r : c.gettReplicators()) {
			if (!r.isJoined()) {
				if ((r.pointsToSomeUnitOf(c)) && r.getFactor() != 1) { 
					this.newReplicator(r);
					r.setConfiguration(this);
					varsAdded.add(r.getVarId());
					for (HLinkToReplicator l : r.getLinksToMe()) 
						l.setPermanent(true);
				} else {
					if (!varsAdded.contains(r.getVarId())) 
						varsToRename.add(r.getVarId());
					r.setHidden(true);
				}
			} else {
				if (!varsAdded.contains(r.getVarId())) 
					varsToRename.add(r.getVarId());
				r.setHidden(true);
			}
		}

		varsToRename.removeAll(varsAdded);
		
		for (String v : varsToRename) {
			c.renameEnumeratorVariable(v);
		}
		
		c.liftStubs();
		
		for (HComponent _c : c.getExposedComponents()) {
			_c.saveName();
		}
		
		if (c.isRecursiveComponent()) {
  		    c.configureRecursion();					
		}
		 
		listeners.firePropertyChange(NEW_COMPONENT, null, name);		
		listeners.firePropertyChange(UPDATE_NAME, null, name); 
	}
	
	public void injectComponent(HComponent c, int i) {

		c.setConfiguration(this);		
		this.addComponent(c,i);
			
		c.liftInterfaces();
		

	}

	private void renameEnumeratorVariable(HReplicator r) {
		
		String    varName = r.getVarId();
		String newVarName = "@".concat(new Long((int)System.currentTimeMillis()).toString());
		
	    for (HReplicator s : this.getEnumeratorsByVarName(varName)) {
			s.setVaridForced(newVarName);
		}
	}
	
	private void renameEnumeratorVariable(String vr) {
		
		String    varName = vr;
		String newVarName = "@".concat(new Long((int)System.currentTimeMillis()).toString());
		
	    for (HReplicator s : this.getEnumeratorsByVarName(varName)) {
			s.setVaridForced(newVarName);
		}
	}
	
	private List<HReplicator> getEnumeratorsByVarName(String varId) {
		
		Stack<HComponent> cs = new Stack<HComponent>();
		List<HReplicator> rs = new ArrayList<HReplicator>(); 
		
		cs.push(this);
		
		while (!cs.isEmpty()) {
			
			HComponent c = cs.pop();
			
			for (HReplicator w : c.gettReplicators()) {
			    if (w.getVarId().equals(varId)) {
			    	if (!rs.contains(w)) 
			    		rs.add(w);
			    }
			}
			
			for (HComponent x : c.getComponents()) cs.push(x);
		}
		
		return rs;
	}
	
	private void liftInterfaces() {
		HComponent c = (HComponent) this.getTopConfiguration(); // TODO (getConfiguration): from getConfiguration to getTopConfiguration, supposing that liftInterfaces is always called in relation to the top configuration

		for (HInterface i : this.getInterfaces()) {
			   c.newInterface(i);
	 		   i.setEditable(false); 
		}		
	}
	
	public void hideAllInterfaces() {
/*		Iterator us = this.getUnits().iterator();
		while (us.hasNext()) {
			HUnit u = (HUnit) us.next();
			u.hideInterface();
		} */
		Iterator is = this.getInterfaces().iterator();
		while (is.hasNext()) {
			HInterface i = (HInterface) is.next();
			i.forceHide();
		}
	}
	
	
	public void setConfiguration(HComponent configuration) {
		if (configurations == null) configurations = new ArrayList<HComponent>();
		this.configurations.add(configuration);		
	}
	
	
    public void removeComponent(HComponent c1) {
    	List<HComponent> Cs = new ArrayList<HComponent>(((HComponent)this.getTopConfiguration()).getAllInnerConfigurations());
    	List<HComponent> Cs_ = this.getAllInnerConfigurations();
    	Cs.removeAll(Cs_);
    	this.removeComponent(c1, Cs, c1);
		
	}

	public void removeComponent(HComponent the_component,List<HComponent> C, HComponent c1) {

		if (the_component.canRemoveMe(C,c1)) {

			the_component.isRemoved = true;
			
			List<HComponent> lc = new ArrayList<HComponent>();
			lc.addAll(the_component.getComponents());
			
			for (HComponent c : lc) {
				the_component.removeComponent(c,C,c1);
			}
			
			// Unlink all internal replicators
			for (HReplicator r : gettReplicators()) {
				for (HLinkToReplicator l : ((List<HLinkToReplicator>)((ArrayList)r.getLinksToMe()).clone())) {
					if (!(l.getReplicated() instanceof HReplicatorSplit)) {
						if (!l.isExternalLink(the_component)) {
						    r.removeLink(l);
						} else {
							//l.getReplicator().setConfiguration(this);
						}
					}
				}				
			}
				
			// Unlink replicators to the component
			the_component.unsetAllReplicators();
			
			// Unlink external replicators
			
			for (IHUnit entry : the_component.getEntries()) {			
				if (entry instanceof IHUnit) ((IHUnit) entry).hideInterface();
				if (!(entry instanceof HPrimUnitStub)) entry.unsetAllReplicators();
			} 
			
			// Clean interfaces.
			for (HInterface i : ((List<HInterface>)((ArrayList<HInterface>)the_component.getInterfaces()).clone())) {
				i.removeLinksInConfiguration(the_component);
				this.removeInterface(i);
			}
			
			this.clean_unused_replicators();
			
			
		}	
	
		components.remove(the_component);
		the_component.unsetConfiguration(this);
		
		listeners.firePropertyChange(NEW_COMPONENT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}
	
	public void removeComponent2(HComponent the_component) {

		// Unlink all internal replicators
		for (HReplicator r : gettReplicators()) {
			for (HLinkToReplicator l : ((List<HLinkToReplicator>)((ArrayList)r.getLinksToMe()).clone())) {
				if (!(l.getReplicated() instanceof HReplicatorSplit)) {
					if (!l.isExternalLink(the_component)) {
					    r.removeLink(l);
					} else {
						//l.getReplicator().setConfiguration(this);
					}
				}
			}				
		}
			
		// Unlink replicators to the component
		the_component.unsetAllReplicators();
		
		// Unlink external replicators
		
		for (IHUnit entry : the_component.getEntries()) {			
			if (entry instanceof IHUnit) ((IHUnit) entry).hideInterface();
			if (!(entry instanceof HPrimUnitStub)) entry.unsetAllReplicators();
		} 
		
		// Clean interfaces.
		for (HInterface i : ((List<HInterface>)((ArrayList<HInterface>)the_component.getInterfaces()).clone())) {
			i.removeLinksInConfiguration(the_component);
			this.removeInterface(i);
		}
		
		this.clean_unused_replicators();
			
		components.remove(the_component);
		the_component.unsetConfiguration(this);
		the_component.isRemoved = true;
		
		listeners.firePropertyChange(NEW_COMPONENT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
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
	
	private void clean_unused_replicators() {
		
		Iterator rs = ((ArrayList)((ArrayList) this.replicators).clone()).iterator();
		while (rs.hasNext()) {
			HReplicator r = (HReplicator) rs.next();
		    if (!r.hasLinks() && !r.isSplitReplicator()) 
		       r.remove();	
		    else
		       r.removeSplits();
		}
	}
	
	public final static String PROPERTY_BOUNDS = "component_bounds";
	public final static String PROPERTY_COLOR = "component_color";
	
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		listeners.firePropertyChange(PROPERTY_BOUNDS, null, name); //$NON-NLS-2$//$NON-NLS-1$		
	}
	
	/**
	 * @uml.property  name="color"
	 */
	private MyColor color = new MyColor(ColorConstants.white);

	/**
	 * Getter of the property <tt>color</tt>
	 * @return  Returns the color.
	 * @uml.property  name="color"
	 */
	public Color getColor() {
		return color.getColor();
	}

	/**
	 * Setter of the property <tt>color</tt>
	 * @param color  The color to set.
	 * @uml.property  name="color"
	 */
	public void setColor(Color color) {
		this.color.setColor(color);
		listeners.firePropertyChange(UPDATE_COLOR, null, getColor());
	}
	
	IPackageLocation location = null;
	
	

	// COMPONENT !!!!!
	
	/**
	 * @uml.property   name="entries"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" ordering="true" inverse="which_component:hPE.model.HComponentEntry"
	 */
//	private List entries = new ArrayList();

	/**
	 * @uml.property   name="entries"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" ordering="true" inverse="which_component:hPE.model.HComponentEntry"
	 */
	public Collection<IHUnit> getEntries() {
		return this.getUnits();
	}
	
	public Collection<IHPrimUnit> getObservableEntries() {
		List<IHPrimUnit> ls = new ArrayList<IHPrimUnit>();
		for (IHUnit u : this.getAllUnits()) {
			if (!u.getHidden()) {
				ls.add(u);
			} else if (u.getBinding() != null) {				
				HBinding b = u.getBinding();
				if (b.getPort() instanceof HUnitStub) 
					ls.add(u);
			}
		}
		return ls;
	}
	
	
	/**
	 * @uml.property   name="configuration"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="components:hPE.base.model.HComponent"
	 */
	private HComponent configuration = null;

	private List<HComponent> configurations = new ArrayList<HComponent>();
	
	/**
	 * Getter of the property <tt>configuration</tt>
	 * @return  Returns the configuration.
	 * @uml.property  name="configuration"
	 */
	public IConfiguration getConfiguration() {
    	if (configurations == null) configurations = new ArrayList<HComponent>();
		if (configuration != null) {
			configurations.add(configuration);
			configuration = null;
		}
		if (!configurations.isEmpty()) return configurations.get(0); else return null;
	}
	
	public IConfiguration getTopConfiguration() {
    	if (configurations == null) configurations = new ArrayList<HComponent>();
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
//	public void addEntry(HComponentEntry entry) {
//		entries.add(entry);
//	}


	/**
	 * @uml.property   name="linkToReplicator"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="hComponent:hPE.base.model.HLinkToReplicator"
	 */
	private Collection<HLinkToReplicator> linkToReplicator  = new ArrayList();

	/** 
	 * Getter of the property <tt>linkToReplicator</tt>
	 * @return  Returns the linkToReplicator.
	 * @uml.property  name="linkToReplicator"
	 */
	public List<HLinkToReplicator> getLinksToVisibleReplicators() {
		
		List<HLinkToReplicator> visibleLinks = new ArrayList<HLinkToReplicator>();
		Iterator<HLinkToReplicator> links = linkToReplicator.iterator(); 
		while (links.hasNext()) {
			HLinkToReplicator l = links.next();
			HReplicator r = l.getReplicator();
			if (!r.getHidden()) visibleLinks.add(l);
		}
		
		return visibleLinks;
	}

	public List<HLinkToReplicator> getLinksToReplicators() {
		
		List<HLinkToReplicator> theLinks = new ArrayList<HLinkToReplicator>();
		Iterator<HLinkToReplicator> links = linkToReplicator.iterator(); 
		while (links.hasNext()) {
			HLinkToReplicator l = links.next();
			HReplicator r = l.getReplicator();
			theLinks.add(l);
		}
		
		return theLinks;
	}

	/**
	 */
	public List<HReplicator> getReplicators() {
		List<HReplicator> replicators = new ArrayList<HReplicator>();
		if (this.getLinksToReplicators().size() > 0) {
			for (HLinkToReplicator lr : this.getLinksToReplicators()) {
		    	HReplicator r = lr.getReplicator();
		    	replicators.add(r);
		    }
		}			
		return replicators;
	}

	
	/**
	 */
	public void setReplicator(HReplicator the_replicator) throws HPEUnmatchingEnumeratorsException{
		if (!this.isReplicatedBy(the_replicator)) {
			
			//if (this.someUnitIsReplicatedByVarIdOf(the_replicator))
				//unlinkUnitsFromReplicator(the_replicator);
			
			HLinkToReplicator linkToReplicator = new HLinkToReplicator(this,the_replicator);
			this.linkToReplicator.add(linkToReplicator);
			
			// PROPAGATE TO UNIT SLICES ! ...
	/*		try {
				propagateReplicator(the_replicator);
			} catch (HPEUnmatchingEnumeratorsException e) {
				this.linkToReplicator.remove(linkToReplicator); // ROLL BACK !
				throw new HPEUnmatchingEnumeratorsException();
		    } */
			
			for (HReplicator r : the_replicator.getMyJoined()) {
				setReplicator(r);				
			}
			
			listeners.firePropertyChange(REPLICATED,null,getComponentName());
		} 

	}
	


/*	private void propagateReplicator(HReplicator r) throws HPEUnmatchingEnumeratorsException {
		
		Iterator<IHUnit> us = this.getUnits().iterator();
		while (us.hasNext()) {
			IHUnit hu = us.next();
			if (hu instanceof HUnit) {
				HUnit u = (HUnit) hu;
				if (u.getBinding() != null) {
					IBindingTarget b = u.getBinding().getPort();
					if (b instanceof HUnitSlice) {
						HUnitSlice s = (HUnitSlice) b;
						if (!s.isReplicatedBy(r) && !s.getUnit().isReplicatedBy(r)) 
							 s.setReplicator(r,true);
					}
				}
			}
		}
	}
*/
	public void setReplicator (HReplicator the_replicator, boolean permanent) throws HPEUnmatchingEnumeratorsException{
		setReplicator(the_replicator);
		this.findLink(the_replicator).setPermanent(permanent);
	}

	public void unSetReplicator(HReplicator which_replicator) {
		
		HLinkToReplicator link = findLink(which_replicator);
	    link.unlinkFromReplicator();
	    this.linkToReplicator.remove(link);
    	List<HReplicator> rs = which_replicator.getMyJoined();    	
    	if (!rs.isEmpty())
			for (HReplicator s : rs) 
			    if (this.isReplicatedBy(s)) 
			    	this.unSetReplicator(s);
	    listeners.firePropertyChange(REPLICATED,null,getComponentName());
	
    }
	
	public boolean isReplicatedBy(IReplicator which_replicator) {
		return (findLink((HReplicator)which_replicator) != null);
	}

	public final static String REPLICATED = "replicated";
	
	private HLinkToReplicator findLink(HReplicator which_replicator) {
		HLinkToReplicator link = null;
		Iterator ls = ((List) ((ArrayList) this.linkToReplicator).clone()).iterator();
		while (ls.hasNext()) {
			link = (HLinkToReplicator) ls.next();
			if (link.getReplicator() == which_replicator) return link;   		
		}
		return null;
	}
	
	public HReplicator getReplicatorByVarId(String v) {
		HLinkToReplicator link = null;
		Iterator ls = ((List) ((ArrayList) this.linkToReplicator).clone()).iterator();
		while (ls.hasNext()) {
			link = (HLinkToReplicator) ls.next();
			if (link.getReplicator().getName2().equals(v)) return link.getReplicator();   		
		}
		return null;
	}
		
	
	/**
	 */
    public boolean isReplicated() {
	    return this.getLinksToReplicators().size() > 0;
    }

	/**
	 */
	public List getMyReplicas() {
		// TODO: model (getMyReplicas)
		return null;
	}
   
	/**
	 */
	public boolean isReplicatorFactorDetermined(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
		if (link != null) 
			return link.isReplicatorFactorDetermined();
		else
			return false; // RAISES EXCEPTION !!!! ERROR !!!
	}

	/**
	 */
	public int getReplicationFactor(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
		if (link != null) 
		        return which_replicator.getFactor();
		else
			return -1; // RAISES EXCEPTION !!!! ERROR !!!
	}



	/** 
	 * Setter of the property <tt>linkToReplicator</tt>
	 * @param linkToReplicator  The linkToReplicator to set.
	 * @uml.property  name="linkToReplicator"
	 */
	public void setLinkToReplicator(Collection linkToReplicator) {
		this.linkToReplicator = linkToReplicator;
	}
	
	public void unsetAllReplicators() {
		Iterator rs = ((ArrayList)((ArrayList) this.getLinksToVisibleReplicators()).clone()).iterator();
		while (rs.hasNext()) {
			HLinkToReplicator r = (HLinkToReplicator) rs.next();
			this.unSetReplicator(r.getReplicator());
		}
	}
	
	public boolean canRemoveMe(List<HComponent> C, HComponent c1) {

/*		if (this == c1) return true;
		
		HComponent topC = (HComponent) this.getTopConfiguration();
		
		Stack<HComponent> sss = new Stack<HComponent>();
		
		sss.push(this);
		
		while (!sss.isEmpty()) {			
		    HComponent d = sss.pop();
			for (HComponent c : d.getDirectParentConfigurations()) {
		        if (c==topC) 
		        	return false;
		        else if (c!=c1) {
				   sss.push(c);
		        }
			}
		}
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

		for (IHUnit unit : this.getAllUnits()) { 
					
			Rectangle r = new Rectangle();
			
			r.setSize(HUnit.diameter,HUnit.diameter);
	 		r.translate(5+i*(HUnit.diameter+3),0);
				
	 		unit.saveBounds();
			unit.setBounds(r);
			
			i++;			
		}
		
		
	}

	// private ILComponentView libraryEntry;
	
	private String libraryEntry = "";
	
	public void setLocation(String libraryEntry) {
		this.libraryEntry = libraryEntry;
	}
	
	public String getSystemLocation() {
		return this.uri;
	}
	
	public String getLocation() {
		return uri;
	}
	
	public String toString() {
		return this.getSystemLocation();
	}
	
	public final static String PROPERTY_IS_PARAMETER = "PROPERTY_IS_PARAMETER";
	
	private boolean isParameter = false;
	private Map<String,String> parameterIdentifier = new HashMap<String,String>();
	private String variableName = "?";
	
    public void setParameter(String varName) {
    	
    	String s = this.getTopConfiguration().toString();
    	
    	this.isParameter = true;
    	if (!this.parameterIdentifier.containsKey(s))
    	   this.parameterIdentifier.put(s,varName);
    	
    	this.setComponentName(this.getComponentName());
    	
    }
    
    public String getVariableName() {
    	if (this.variableName == null) this.variableName = "?" ;
    	return this.variableName;
    }
    
    public void setVariableName(String varName) {
    	this.variableName = varName;
		listeners.firePropertyChange(PROPERTY_IS_PARAMETER,null,this.getBounds());

    }
    
    public void setNullVariableName() {
    	this.variableName = null;
		listeners.firePropertyChange(PROPERTY_IS_PARAMETER,null,this.getBounds());

    }
    
    
/*    
    public void changeVarName(String varName) {
    	
    	isParameter = true;
    	this.parameterIdentifier = varName;
		
    }
    */
    
    public void setNonAbstract(String varName) {
    	
    	isParameter = false;
    	removeParameterIdentifierByName(varName);
    	this.setNullVariableName();
		listeners.firePropertyChange(PROPERTY_IS_PARAMETER,null,this.getBounds());
		
    }    
    
    public void removeParameterIdentifierByName(String varName) {
    	
    	List<String> trash = new ArrayList<String>();
    	
    	
    	for (Entry<String,String> p : this.parameterIdentifier.entrySet()) 
    	    if (p.getValue().equals(varName)) 
    	    	trash.add(p.getKey());
    	
    	for (String key : trash)
    	   this.parameterIdentifier.remove(key);
    }
        
    /* (non-Javadoc)
	 * @see hPE.base.model.IComponent#isAbstract()
	 */
    public boolean isParameter() {
    	return isParameter;
    }
    
    public String getParameterIdentifier(IComponent c) {

    	if (this.parameterIdentifier.containsKey(c.toString()))
    	    return this.parameterIdentifier.get(c.toString());
    	else {
    		HComponent superType = getSuperType();
   			return superType != null ? superType.getParameterIdentifier(c) : "type ?";
    	}
    	    	
    		
/*    	for (Pair<String,String> p : this.parameterIdentifier) {
    		String cs = (String) p.fst();
    		if (cs.equals(c.toString())) {
    			return (String) p.snd();
    		} 
    	}
    	
    	HComponent superType = getSuperType();
    	if (superType != null) 	return superType.getParameterIdentifier(c);
    	else return "type ?"; */	
    }
    
    public String getParameterModifierName(boolean complete, boolean showBounds, boolean showParId) {
    	
    	List<String> vs = new ArrayList<String>();
    	HComponent topC = (HComponent)this.getTopConfiguration();
    	Iterator<Entry<String,List<HComponent>>> cs = this.getParameters().entrySet().iterator();
    	int parameterized = 0;
    	String nameWithParameters = "";
    	while (cs.hasNext()) {
    		    HComponent config = cs.next().getValue().get(0);
    		    String parId = config.getParameterIdentifier(this);
    		    if (parId.equals("type ?")) parId = config.getParameterIdentifier((IComponent)config.getTopConfiguration());
    		    // TODO (getConfiguration): de getConfiguration para getTopConfiguration...
	    		String varName = config.getVariableName();
 	    		if (/*!complete  || config.getSupplied() == null */true) {
		   	       if (parameterized == 0) nameWithParameters = nameWithParameters.concat("<");
			       parameterized ++;
		   	       if (!vs.contains(parId)) {
			    	   if (parameterized > 1) nameWithParameters = nameWithParameters.concat(", ");;
			    	   if (config.getSupplied()==null) {
			    		  boolean showBounds_ = showBounds;
			    		  showBounds_ = showBounds_ && ((!topC.getVars().contains(varName)) || this.isTopConfiguration());
			    	      nameWithParameters = nameWithParameters + (showParId ? parId + " = " : "") + varName + (showBounds_ ? ": " + config.getNameWithParameters(complete, showBounds, showParId): "");
			    	   } else {
			    	      nameWithParameters = nameWithParameters + (showParId ? parId + " = " : "") + config.getNameWithParameters(complete, showBounds, showParId);
			    	   }
		   	       }
		    	   vs.add(parId);
	    		} 
    	}
    	    	
    	if (parameterized > 0) {
    		nameWithParameters = nameWithParameters.concat(">");
    	}
    	
    	return nameWithParameters;    	
    }
    
    public String getNameWithParameters(boolean complete, boolean showBounds, boolean showParId) {

         return this.getComponentName() + this.getParameterModifierName(complete, showBounds, showParId);	
    
    }

    public Map<String,List<HComponent>> getParameters() {
    	return getParameters(this);
    }
    
    /* (non-Javadoc)
	 * @see hPE.base.model.IComponent#getParameters(hPE.base.model.IComponent)
	 */
    protected Map<String,List<HComponent>> getParameters(HComponent cThis) {
    	
    	Map <String,List<HComponent>> p = new HashMap<String,List<HComponent>>();
    	
    	for (HComponent c : this.getComponents()) {
    	    if (c.isParameter()) {
    	    	String parId = c.getParameterIdentifier(cThis);
    	    	addParameter(parId,c,p);
     	    }
    	    for (List<HComponent> qs : c.getParameters(cThis).values()) {
    	        for (HComponent innerParameter : qs) {
	    	    	String parId =  innerParameter.getParameterIdentifier(cThis);
	    	    	if (!parId.equals("type ?"))
	    	    		addParameter(parId,innerParameter,p);
	    	    	else {
	    	    		//System.err.println("***" + parId + " - " + innerParameter.getVariableName());
	    	    	}
	    	    }
    	    }
    	}    	
    	
    	return  p;
    	
    }
    
    private void addParameter(String parId, HComponent c, Map <String,List<HComponent>> p) {
    	if (p.containsKey(parId)) {
	    	   p.get(parId).add(c);	
	    	} else {
	    	   List<HComponent>	l = new ArrayList<HComponent>();
	    	   l.add(c);
	    	   p.put(parId,l);
	    	}
    }
    
    public Map<String,List<HComponent>> getParameters2() {
        List<String> vs = new ArrayList<String>();
        Map<String,List<HComponent>> m = new HashMap<String,List<HComponent>>();
        
        for (Entry<String,List<HComponent>> p : this.getParameters().entrySet()) {
                	
        	String parId = p.getKey();
        	List<HComponent> c = p.getValue();
        	
        	String v = parId; //.concat(" as ").concat(c.get(0).getVariableName()); // c.getVariableName();
        	if (vs.contains(v)) {
        		((List<HComponent>) m.get(v)).addAll(c);
        	} else {
        		List<HComponent> vl = new ArrayList<HComponent>();
        		vl.addAll(c);
        		m.put(v,vl);
        		vs.add(v);
        	}
        		
        }
        return m;
        
    }
    
    
    /* (non-Javadoc)
	 * @see hPE.base.model.IComponent#getParameter(java.lang.String)
	 */
    public List<HComponent> getParameterByName(String x) {
        Map<String,List<HComponent>> cs = this.getParameters();
        return cs.get(x);
    }

    public List<String> getVars() {
    	
    	List<String> vars = new ArrayList<String>();
    	
    	for (Entry<String,List<HComponent>> param : this.getParameters().entrySet()) {
    		for (HComponent c : param.getValue()) {
    			String var = c.getVariableName();
    		    if (!vars.contains(var)) vars.add(var);  
    		}
    	}
    	
    	return vars;
    }
    
    private IComponent supplied = null;
    
    private void setSupplier(HComponent c) {
    	this.supplied = c;    	
    	this.isParameter = true;
    	this.parameterIdentifier.putAll(c.parameterIdentifier); // DUVIDA... antes apenas atribu�a ...
    	this.variableName = c.getVariableName();
    }
    
    public IComponent getSupplied() {    
    	return supplied;
    }
    
    
    
/*    private List suppliedParameters = new ArrayList(); 
    
    public boolean isSupplied(HConfiguration component) {
    	if (this.suppliedParameters == null) this.suppliedParameters = new ArrayList();
    	return this.suppliedParameters.contains(component);
    } */
    
    public boolean isConnected() {
    	for (IHUnit u : this.getAllUnits()) {
    	    if (u.getBinding() != null) return true;	
    	}
    	return false;
    }
    
    public boolean isTopConfiguration () {
    	if (configurations == null) configurations = new ArrayList<HComponent>();
    	if (configuration != null) {    		
    		configurations.add(configuration);
    		configuration = null;
    	}
    	// return this.configuration == null;
    	// TODO (getConfiguration): 
    	return this.getDirectParentConfigurations().isEmpty();
    	
    }
    
    public boolean isDirectSonOfTheTopConfiguration () {
    	if (configurations == null) configurations = new ArrayList<HComponent>();
    	if (configuration != null) {
    		configurations.add(configuration);
    		configuration = null;
    	}
    	return this.getDirectParentConfigurations().contains(this.getTopConfiguration());
    	// If the component is direct son of the top configuration, then it has only one parent configuration, the top configuration itself. 
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
    
 
    
    static public void supersede(HComponent c1, HComponent c2, String newVarName) {

    		// c2 <: c1;
    	    // c2 will replace its c1-image.

    	c2.setName(c1.getName2());
    	if (c1.getSavedName()!=null) c2.setSavedName(c1.getSavedName());
    	c2.setExposed(c1.getExposed());
    	c2.exposedFalsifiedContext = c1.exposedFalsifiedContext;
    	
        if (!c2.isParameter()) { 
    	    	c2.setSupplier(c1);
    	    	c1.setVariableName(newVarName);
    	    	c2.setVariableName(newVarName); 
   	    } else {
    	    	c2.setVariableName(c1.getVariableName());
    	    	c2.parameterIdentifier.putAll(c1.parameterIdentifier);
   	    }
            
        HComponent im_c1inc2 = (HComponent)c2.getSubTypeImageOf(c1);
        Iterator us2 = ((ArrayList)((ArrayList)im_c1inc2.getEntries()).clone()).iterator();
        Iterator us1 = ((ArrayList)((ArrayList)c1.getEntries()).clone()).iterator(); 
        while (us1.hasNext() && us2.hasNext()) {
        	IHPrimUnit u2 = (IHPrimUnit) us2.next();
        	IHPrimUnit u1 = (IHPrimUnit) us1.next();
        	
            if (!(u2 instanceof HUnitStub && u1 instanceof HUnitStub)) {
            	
	    		u2 = u2.getRealUnit();
	        	
	        	Pair<IHPrimUnit,IHPrimUnit> pair = alignUnits(u1,u2);
	        	u1 = pair.fst(); u2 = pair.snd();
	    		List<Pair<IHPrimUnit,IHPrimUnit>> pairs = matchUnits(u1,u2);
	        	
	        	for (Pair<IHPrimUnit,IHPrimUnit> e : pairs) {
	        		u1 = e.fst();
	        		u2 = e.snd();
	        		u2.unsetAllReplicators();
	        		HUnit.supersede(u1,u2);
	        	}

            }
        }
        
                        
        for (Pair<HComponent,HComponent> p : c2.getSubTypeImageOf2(c1)) {
        	HComponent c1_ = p.fst();
        	HComponent c2_ = p.snd();
        	if (c1 != c1_ && c2 != c2_) {
    	    	c2_.parameterIdentifier.putAll(c1_.parameterIdentifier);
        	}
            
        }
        
        c2.unsetAllReplicators();
        // LINK C2 TO ALL REPLICATORS OF C1.
        for (HReplicator r : c1.getReplicators()) {
    		try {
    		   c2.setReplicator(r);
    		} catch (HPEUnmatchingEnumeratorsException e) {
			   System.err.println("Unexpected Exception !" + e.getMessage());
		    }
    	}
            
        c2.setBounds(c1.getBounds().getCopy());
        
        List<HComponent> l = new ArrayList<HComponent>(c1.getDirectParentConfigurations());
        for (HComponent c1_ : l) {
            c1_.removeComponent(c1);
        }
  
 	   // Update ports
 	   for (IHUnit _u : c2.getAllUnits()) {
	       	for (HPrimUnit utop : _u.getTopUnits(null)) {
	       		HComponent c = (HComponent) utop.getConfiguration();
		       	if (c.isTopConfiguration() && utop.getInterface() != null) { 
		       		try {
						((HUnit)utop).updatePorts();
					} catch (HPEAbortException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			       	HInterface i = (HInterface)utop.getInterface();
			       	if (!i.getHidden()) {
			       		utop.hideInterface();
			       		utop.showInterface();
			       	}
		       	}
	       	}
     }
        
        
/*        for (IHUnit _u : c2.getAllUnits()) {
        	
        	HUnit utop = (HUnit) _u.getTopUnit(null);
        	HInterface i = (HInterface)utop.getInterface();
        	if (i != null) {
	        	try {
					utop.updatePorts();
				} catch (HPEAbortException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	if (!i.getHidden()) {
	        		utop.hideInterface();
	        		utop.showInterface();
	        	}
        	}
        }
*/
        for (HComponent c2_ : c2.getAllParentConfigurations()) {
            c2_.forceUpdateName();    	
        }
    	
        for (HComponent c : c2.getInnerTopConfigurations()) {
        	c.updateConnections();
        }
        

    }
    

	private static Pair<IHPrimUnit, IHPrimUnit> alignUnits(IHPrimUnit u1, IHPrimUnit u2) {
    	
    	List<HLinkToReplicator> lrs = new ArrayList<HLinkToReplicator>();
    	HReplicator topR = null;
    	
    	// Por enquanto, sup�e-se que somente um replicador pode estar dividido ....
    	for (HReplicator r : u1.getReplicators()) {
    		if (r.getParentSplit() != null) {
    		   lrs = r.getSplitPath();
    		   topR = r.getTopReplicator();
    		   if (!u2.isReplicatedBy(topR)) {
    			   topR = null; 
    		   }
    		   break;
    		}    		
    	}
    	
		for (HLinkToReplicator l : lrs) {
			if (topR == null) {
				HReplicator rr = ((HReplicatorSplit)l.getReplicated()).getOwnerReplicator();
				if (u2.isReplicatedBy(rr)) {
					topR = rr;
				}
			} else {
    			HReplicatorSplit s = (HReplicatorSplit)l.getReplicated();
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

//		u1.align((HPrimUnit)u2);
		
    		//		   JOptionPane.showMessageDialog(null, "The unit u1 is not replicated by the topR of u2" ,"HUnit.alignUnit", JOptionPane.ERROR_MESSAGE);
    	
    	
		return new Pair<IHPrimUnit,IHPrimUnit>(u1,u2);
	}


   private void forceUpdateName() {
		listeners.firePropertyChange(UPDATE_NAME, null, name); //$NON-NLS-2$//$NON-NLS-1$	
		listeners.firePropertyChange(NEW_COMPONENT, null, name); //$NON-NLS-2$//$NON-NLS-1$	
    }

    public void adviceChangeParameterName() {
		listeners.firePropertyChange(PROPERTY_IS_PARAMETER,null,this.getBounds());    	
    }
    
    public IComponent getSubTypeImageOf(HComponent c) {
    	
    	if (this.getComponentName().equals(c.getComponentName())) {   // They are the same components. Check parameteres.
    		
    		if (this.getParameters().size()==0) return this;  // MATCH !!!!!!!!    		
    		
    		if (this.getParameters().size() == c.getParameters().size()) {
    			// C[V1,V2,...,Vn] <: C[X1,X2,...,Xn]   iif  V1 <: X1 & V2 <: X2 & ... & Vn <: Xn
    			Iterator<Entry<String,List<HComponent>>> ps = c.getParameters().entrySet().iterator();
    			boolean checkParameters = true;
    			int pos = 0;
    			while (ps.hasNext() && checkParameters) {    				
    				Entry<String,List<HComponent>> valCEntry = ps.next();
    				String parId = valCEntry.getKey(); // (String) valC.getParameterIdentifier(this);
    				List<HComponent> valC = valCEntry.getValue();
    				List<HComponent> v = this.getParameterByName(parId);
    				if (v != null) {
    					// Check parameter subtyping
	    				checkParameters = v.get(0).isSubTypeOf(valC.get(0)) && checkParameters;
    				} else {
    	    			System.out.println("CONSISTENCY ERROR !!! (isSubTypeOf): Variable Name NOT found !");
    	    			return null;
    				}
    				pos++;
    			}
    			if (checkParameters) return this; // MATCH !!!!!
    		} else {
    			System.out.println("CONSISTENCY ERROR !!! (isSubTypeOf): Parameters does not Match");
    			return null;
    		}
    	}
    	
        // Check if they are of the same component kind (There is no subtype relation between component types of distinct kinds).
    	if (c.getClass() == this.getClass()) { 
	        // C = C1 # C2 # ... # Cn:       D <: C   if   D <: C1 | D <: C2 | ... |  D <: Cn
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
    
    /* (non-Javadoc)
	 * @see hPE.base.model.IComponent#getSuperType()
	 */
    public HComponent getSuperType() {
    	
    	for (HComponent sc : this.getComponents()) {
	    	if (sc.isSuperType() && (sc.allUnitsAreStubs() || sc.getUnits().size() == 0)) {
	    		return sc;
	    	}
	    }
	    return null;
    }
    
    private boolean superType = false;
    
	public final static String PROPERTY_IS_SUPERTYPE = "PROPERTY_IS_SUPERTYPE";
	
    protected void setSuperType(boolean superType) {
    	this.superType = superType;
		listeners.firePropertyChange(PROPERTY_IS_SUPERTYPE,null,this.getBounds());    	
    }
    
    public boolean isSuperType() {
    	return superType;
    }
    
    
    public HComponent getSubType() {
    	
    	List<HComponent> cs = this.getDirectParentConfigurations();
    	if (cs.size() == 1) { // TODO (getConfiguration) : if an inner component is a subtype component
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
    	while (subC.getSubType() != null) subC = subC.getSubType();
    	return subC;
    	
    }
   
    
    public boolean allUnitsAreStubs() {
    	
    	boolean yes = true;
    	
    	for (IHUnit u : this.getUnits()) 
    		if (!(u instanceof HUnitStub)) 
    			yes = false;    		
    	
    	
    	return yes;
    }
    
    
    /* (non-Javadoc)
	 * @see hPE.base.model.IComponent#isSubTypeOf(hPE.base.model.HComponent)
	 */
    public boolean isSubTypeOf(HComponent c) {
 
    	return getSubTypeImageOf2(c)!=null;
    	
		
    }
    
    /* (non-Javadoc)
	 * @see hPE.base.model.IComponent#isEquivalentTo(hPE.base.model.HComponent)
	 */
    public boolean isEquivalentTo(HComponent c) {
    	return this.isSubTypeOf(c) && c.isSubTypeOf(this);
    }

    public boolean accepts(IComponent c) {
    	return true;
    }
    
    /* (non-Javadoc)
	 * @see hPE.base.model.IComponent#kindString()
	 */
    public String kindString() {
    	return "?";
    }
     
    
    public List<Pair<HComponent,HComponent>> getSubTypeImageOf2(HComponent c) {
    	
 	   List<Pair<HComponent,HComponent>> lr = new ArrayList<Pair<HComponent,HComponent>>();
 	   
     	if (this.getComponentName().equals(c.getComponentName())) {   // They are the same components. Check parameteres.
     		
     		Map<String, List<HComponent>> lll1 = this.getParameters();
     		Map<String, List<HComponent>> lll2 = c.getParameters();
     		
     		if (lll1.size()==0) { 
     			lr.add(new Pair(c,this.getLeastSubType()));  // MATCH !!!!!!!!
     			return lr;
     		}
     		
     		//Collection i = this.getParameters();
     		//Collection j = c.getParameters();
     		
     		if (lll1.size() == lll2.size()) {
     			// C[V1,V2,...,Vn] <: C[X1,X2,...,Xn]   iif  V1 <: X1 & V2 <: X2 & ... & Vn <: Xn
     			Iterator<Entry<String,List<HComponent>>> ps = lll2.entrySet().iterator();
     			boolean checkParameters = true;
     			int pos = 0;
     			while (ps.hasNext() && checkParameters) {    				
     				Entry<String,List<HComponent>> valCEntry = ps.next();
     				String parId = valCEntry.getKey(); // (String) valC.getParameterIdentifier(this);
     				List<HComponent> valC = valCEntry.getValue(); 
     				List<HComponent> v = this.getParameterByName(parId);
     				HComponent v0 = v.get(0);
     				HComponent valC0 = valC.get(0);
     				if (v != null) {
     					// Check parameter subtyping  					     					
     					
 	    				checkParameters = v0.isSubTypeOf(valC0) && checkParameters;
 	    				if (checkParameters) {
 	    					lr.addAll(v0.getSubTypeImageOf2(valC0));
 	    				}
     				} else {
     	    			System.out.println("CONSISTENCY ERROR !!! (isSubTypeOf): Variable Name NOT found !");
     	    			return null;
     				}
     				pos++;
     			}
     			if (checkParameters) {
         			lr.add(new Pair(c,this.getLeastSubType()));  // MATCH !!!!!!!!
     				return lr; // MATCH !!!!!
     			}
     		} else {
     			System.out.println("CONSISTENCY ERROR !!! (isSubTypeOf): Parameters does not Match");
     			return null;
     		}
     	}
     	
         // Check if they are of the same component kind (There is no subtype relation between component types of distinct kinds).
     	if (c.getClass() == this.getClass()) { 
 	        // C = C1 # C2 # ... # Cn:       D <: C   if   D <: C1 | D <: C2 | ... |  D <: Cn
         	for (HComponent sc : this.getComponents()) {
 		    	if (sc.allUnitsAreStubs()) {
 		    		List<Pair<HComponent,HComponent>> c1 = sc.getSubTypeImageOf2(c);
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
    
    
     public Map<String,List<HComponent>> getVariablesSubTyping(HComponent c) {
    	 
    	 Map<String,List<HComponent>> ls = new HashMap<String,List<HComponent>>();
    	 
    	 for (Pair<HComponent,HComponent> p : this.getSubTypeImageOf2(c)) {
    		 HComponent c1 = p.fst();
    		 HComponent c2 = p.snd();
    		 if (c1.isParameter() && c.getSupplied() == null) {    			 
    			 String varName = c1.getVariableName();
    			 if (ls.containsKey(varName)) {
    				ls.get(varName).add(c2); 
    			 } else {
    				 List<HComponent> l = new ArrayList<HComponent>();
    				 l.add(c2);
    				 ls.put(c1.getVariableName(),l);	 
    			 }    			 
    			
    		    
    		 }
    	 }
    	 
    	 return ls;
    	 
    	 
     }
    

     public List<HComponent> getComponentsToSupply(String varName, HComponent model) {

    	 List<HComponent> componentsToSupply = new ArrayList<HComponent>();
    	    	 
    	 Collection<HComponent> allCs = this.getAllInnerConfigurations();
    	 
    	 for (HComponent c : allCs) {
	       	  if ((c.isParameter() && c.getSupplied()==null) && c.getVariableName().equals(varName)) {        		  
                   if (model.isSubTypeOf(c)) {
//	                   	if ((model.isParameter()  || !model.isParameter())
	         		           if (!componentsToSupply.contains(c)) componentsToSupply.add(c);
	//                   	else {
	  // 	                	JOptionPane.showMessageDialog(null, "Parameter identifiers does not match !", "Error in Supply Component Action", JOptionPane.ERROR_MESSAGE);
	   	//                	return null;
	                //   	}
                   } else {
	                	JOptionPane.showMessageDialog(null, "Supplied component does not match to the parameter.", "Error in Supply Component Action ", JOptionPane.ERROR_MESSAGE);
               	        return null;
                   }
	       	  }       	  
         }
         
         return componentsToSupply;
    	 
     }
     
     private Iterator<Entry<String,HComponent>> reverse (Iterator<Entry<String,HComponent>> is) {
    	 Stack<Entry<String,HComponent>> l = new Stack<Entry<String,HComponent>>();
    	 while (is.hasNext()) l.push(is.next());
    	 return l.iterator();
     }
     
     
     public void supplyParameter(String varName, HComponent model) {
     
          boolean abort = false;
          
          Collection<HComponent> allInnerModel = model.getAllInnerConfigurations();
    	 
   	      List<HComponent> componentsToSupply = this.getComponentsToSupply(varName,model);
   	      
   	      if (componentsToSupply == null || componentsToSupply.size() == 0) return;  
   	    	     
          Map<String,List<HComponent>> rs = new HashMap<String,List<HComponent>>();
          
          for (HComponent ct : componentsToSupply) {
        	  Map<String,List<HComponent>> vs = model.getVariablesSubTyping(ct);
        	  for (Entry<String,List<HComponent>> e : vs.entrySet()) {
        		  String key  = e.getKey();
        		  if (rs.containsKey(key)) {
        			 rs.get(key).addAll(e.getValue());  
        		  } else {
    				 rs.put(key,e.getValue());	 
        		  }
        	  } 
          }
          
          Map<String,HComponent> rsNext = new HashMap<String,HComponent>();
          
          for (Entry<String,List<HComponent>> e : rs.entrySet()) {
    		  String key  = e.getKey();
    		  HComponent c = peekThatOneThatIsSubTypeOfTheOthers(e.getValue());
    		  if (c!=null) {
    		     rsNext.put(key,c);
    		  } else {
               	 JOptionPane.showMessageDialog(null, "Impossible to match variables in supplyParameter. Look at: ".concat(rs.toString()), "Error in SupplyParameter", JOptionPane.ERROR_MESSAGE);
    			 abort = true;
    		  }
    	  }
    	      	  
    	  if (!abort) {
    		  
             Iterator<Entry<String,HComponent>> fs_ = rsNext.entrySet().iterator();
             Stack<Entry<String,HComponent>> fs = new Stack<Entry<String,HComponent>>();
             while (fs_.hasNext()) fs.push(fs_.next()); 
             
             
             while (!fs.empty()) {
             
            	 Entry<String,HComponent> f = fs.pop();
            	 
            	 String key = f.getKey();
            	 HComponent value = f.getValue();
            	 componentsToSupply = this.getComponentsToSupply(key,value);
            	 componentsToSupply.removeAll(allInnerModel);
            	 
          	     if (componentsToSupply != null && componentsToSupply.size() > 0) {  
            	 
		 	 		 int n = componentsToSupply.size();
			 		 List<HComponent> modelCopies = new ArrayList<HComponent>();
			 		 
			         for (int i=0; i<n; i++) {
			        	 HComponent modelCopy = getMyCopy(value); 
			        	 modelCopies.add(modelCopy);
			        	 modelCopy.unlinkFromConfiguration();
			         }
			         
			         Iterator mcs = modelCopies.iterator();
			         Iterator<HComponent> cs = componentsToSupply.iterator();
			         String newVarName = key + "@" + System.currentTimeMillis();
			         while (mcs.hasNext()) {
		         	      HComponent c = (HComponent) cs.next();
			        	  HComponent modelCopy = (HComponent) mcs.next();
			        	  for (HComponent pc : c.getDirectParentConfigurations()) {
			  		          pc.loadComponent(modelCopy,new Point(0,0));
			        	  }
		                  HComponent.supersede(c,modelCopy,newVarName);
			         }			         
			         this.invalidateInterfaceNames();
          	     }    	  
             }             
             this.rememberSupply(varName, model);
       	     this.removeComponent(model);
    	  }
    	  System.err.println("Supply OK ! " + varName + "=" + model.getComponentName());
     } 

     private void unlinkFromConfiguration() {
		this.configurations.clear();		
	}

	public IBindingTarget newStubFor(HUnit unit, boolean forSubTyping, boolean forImplements, HComponent topConfiguration) {
    	 
    	    if (!this.getDirectParentConfigurations().contains(topConfiguration)) {    	    	
    			JOptionPane.showMessageDialog(null, "(TODO) Cannot create a stub" ,"newStubFor", JOptionPane.ERROR_MESSAGE);
    			return null;
    	    }
    	     	 
	    	Rectangle bounds = unit.getBounds().getCopy();
	    	HUnitStub uStub = unit.createStub(topConfiguration);
	    	uStub.setBounds(bounds);
	    	int iu = this.getUnits().indexOf(unit); /* REMARK: new StubFor is now called only in subtyping or implements. There are no cloned unit */
	        unit.setConfiguration(topConfiguration);
	    	uStub.setConfiguration(this);
	    	this.getUnits().remove(uStub);
	    	this.getUnits().add(iu,uStub); // PLACE uStub in the same position of unit	    	
	    	
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
	    	
	    	// LIFT ALL REPLICATORS OF THE UNIT.
	    	for (HReplicator r : unit.getReplicators()) {
	    		if (!topConfiguration.gettReplicators().contains(r)) topConfiguration.newReplicator(r);
	    	}
	    	
	    	unit.hideSlices();
	    	unit.loadSavedBounds();
	    	return uStub;
     }
     
     
     public IBindingTarget newStubFor(HUnitStub unit, boolean forSubTyping, boolean forImplements, HComponent topConfiguration) {
    	 
	 	    if (!getDirectParentConfigurations().contains(topConfiguration)) {    	    	
	 			JOptionPane.showMessageDialog(null, "(TODO) Cannot create a stub" ,"newStubFor", JOptionPane.ERROR_MESSAGE);
	 			return null;
	 	    }
 	     	 
	    	Rectangle bounds = unit.getBounds().getCopy();
	    	HUnitStub uStub = ((HUnit)unit.getRealUnit()).createStub(topConfiguration);
	    	uStub.setBounds(bounds);
	    	uStub.setConfiguration(topConfiguration);
	    		    	
	    	return uStub;
  }
     
     public HComponent getMyCopy() {
    	 
    	 HComponent that =null;// this.createComponent();
    	 
    	 for (HComponent c : this.components) that.components.add(c.getMyCopy());    	 
    	 for (HComponent c : this.configurations) that.configurations.add(c);
    	 that.exposedFalsifiedContext = this.exposedFalsifiedContext;
    	 that.innerCRef = this.innerCRef;
    	 for (HInterface i : this.interfaces) that.interfaces.add(i); // TODO
    	 that.isExposed = this.isExposed;
    	 that.isParameter = this.isParameter;
    	 that.isRecursive = this.isRecursive;
    	 that.itImplements = this.itImplements.getMyCopy();
    	 that.libraryEntry = this.libraryEntry;
    	 for (HReplicator r : this.getReplicators())
			try {
				that.setReplicator(r);
			} catch (HPEUnmatchingEnumeratorsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 that.location = this.location;
		 for (Entry<HComponent,String> e : this.lOriginalInnerCRef.entrySet()) that.lOriginalInnerCRef.put(e.getKey(), e.getValue()); 
    	 that.parameterIdentifier.putAll(this.parameterIdentifier);
    	 that.ref = this.ref;
    	 that.replicatorRec = this.replicatorRec;
    	 for (HReplicator r : this.replicators) that.replicators.add(r);
    	 that.superType = this.superType;
    	 that.supplied = this.supplied;
    	 for (Pair<String,HComponent> sc : this.supplyMemory) that.supplyMemory.add(new Pair<String,HComponent>(sc.fst(),sc.snd()));
    	 //that.units;
    	 that.uri = this.uri;
    	 that.variableName = this.variableName;
    	 
    	 
    	 return null;
     }
     
     
     
  //   public abstract HComponent createComponent();

	private static HComponent getMyCopy(HComponent model) {

		  HComponent modelCopy = null;
		  
		  List<HComponent> l1c = model.configurations;
		  //List<HComponent> l2c = new ArrayList<HComponent>();
  		  //l2c.addAll(l1c);
  		  //model.configurations = null;
		  
		  //Collection<HReplicator> l1r = model.replicators;
		  //Collection<HReplicator> l2r = new ArrayList<HReplicator>();
  		  //l2r.addAll(l1r);
  		  
  		//  model.replicators = null;
  		  
		  try {
			    NullObject nullObj = new NullObject();
			    HComponent topC = (HComponent)model.getTopConfiguration();
			  
    		    ByteArrayOutputStream os = new ByteArrayOutputStream();
    			ObjectOutputStream_ oos = new ObjectOutputStream_(os,topC, nullObj);
    		
	  		    oos.writeObject(model);
	  		    oos.flush();
	  		    ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
	  			ObjectInputStream_ ois = new ObjectInputStream_(is,topC,nullObj);
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
 		   
           //for (HComponent c : l1c) model.setConfiguration(c);
           //modelCopy.configurations = l2c;

           //model.replicators = l1r;
           //modelCopy.replicators = l2r;
           
           return modelCopy;
	
}
     
     public HComponent peekThatOneThatIsSubTypeOfTheOthers(List<HComponent> cs) {
    
    	 // Among the components passed as parameters, peek the one that is subtype of the others. 
    	 // If such component does not exist, return null;
    	 
    	 // ASSUME SINGLE INHERITANCE
    	 
    	 HComponent c = cs.get(0);
    	 
    	 Iterator<HComponent> is = cs.iterator();
    	 
    	 while (is.hasNext()) {
    		 HComponent i = is.next();
    		 if (i.isSubTypeOf(c)) {
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
	   	 Iterator<HComponent> cs = this.innerOccurrencesOfSubTypesOf(this.getSuperType()).iterator();
		 
		 int res = 0;
		 while (cs.hasNext()) {
			 HComponent c = cs.next();
			 if (c.isRecursive()) res++;
		 } 
		 
		 return res;
     } else {
    	 return 0;
     }

    }
    
 	public final static String PROPERTY_HIDDEN_UNIT = "PROPERTY_HIDDEN_UNIT";

 	public List<HComponent> getComponentsToReplicateInRecursion() {  // TODO: ...
 		
 		List<HComponent> ls = new ArrayList<HComponent>();
 		List<HComponent> cs = new ArrayList<HComponent>();
 		cs.addAll(this.getComponents());
 		cs.addAll(this.getExposedComponents());
 		for (HComponent c : cs) {
 			if (!c.isRecursive() && c != this.getSuperType()) {
 			   if (!ls.contains(c)) ls.add(c);	
 			} if (c == this.getSuperType()) {
 				for (HComponent _c : c.getComponentsToReplicateInRecursion())
 					if (!ls.contains(_c)) ls.add(_c);
 			}
 		}
 		
 		return ls; 		
 	}
 	
 	public Pair<Map<HUnit,List<HUnit>>,Map<HUnit,Boolean>> calculateUnitCorrespondenceRecursion() {
 		
		Map<HUnit,Boolean> uRs = new HashMap<HUnit,Boolean>();		
		Map<HUnit,List<HUnit>> uCs = new HashMap<HUnit,List<HUnit>>();
	
   	 	HComponent cSuper = this.getSuperType();	 
   	 	List<HComponent> is = this.innerOccurrencesOfSubTypesOf(cSuper);
   	    List<IHUnit> ust = cSuper.getUnits();
   	    
   	    for (IHUnit u_ : ust) {
   	    	HUnit u = (HUnit) u_.getRealUnit();
   	    	uCs.put(u,new ArrayList<HUnit>());
   	    }

   	    for (HComponent c_ : is) {
			 if (c_.isRecursive()) {
				 HComponent c = (HComponent) c_.getSubTypeImageOf(cSuper);
				 Iterator<IHUnit> cus = c.getUnits().iterator();
				 int i = 0; 
				 while (cus.hasNext()) {
					 IHUnit cu_ = cus.next();
					 HUnit cu = (HUnit) cu_.getRealUnit();
					 HUnit base_cu = (HUnit) ust.get(i).getRealUnit();
					 uCs.get(base_cu).add(cu);
					 uRs.put(cu,!cu.getBindings().isEmpty()); // TODO: getBinding para getBindings
					 i++;
			     }
			 }
		}
		
		return new Pair<Map<HUnit,List<HUnit>>,Map<HUnit,Boolean>>(uCs,uRs);
	}
 	
 	public List<Pair<HUnit,Integer>> getUnitsToReplicateInRecursion() {

 		Pair<Map<HUnit,List<HUnit>>,Map<HUnit,Boolean>> pair = calculateUnitCorrespondenceRecursion();
 		
 		Map<HUnit,List<HUnit>> uCs = pair.fst(); 
 		Map<HUnit,Boolean> uRs = pair.snd();
 			
		List<Pair<HUnit,Integer>> replications = new ArrayList<Pair<HUnit,Integer>>();
		
		for (IHUnit _u : this.getUnits()) {
		      HUnit u = (HUnit) _u;
			  if (uCs.containsKey(u)) {
				  Iterator<HUnit> vs = uCs.get(u).iterator();
				  for (int j=1; vs.hasNext(); j++) {
					  HUnit v = vs.next();
					  if (!uRs.get(v)) {
						 // u is REPLICATED BY SUCH DIMENSION ...
						 replications.add(new Pair<HUnit,Integer>(u,j));						 
					  }	
					  /*
					   * IT IS REPLICATED BY LINK TO REPLICATOR IS INVISIBLE ...
					   */
					  else {
						 replications.add(new Pair<HUnit,Integer>(u,-j));
					  }
					  /*
					   * ...............................
					   */
				  }				  
			  } else {
				  // FULL REPLICATED (in all dimensions)
				  if (!u.hasStubs())
				     replications.add(new Pair<HUnit,Integer>(u,new Integer(0)));
				  else {
					 u.setHidden(true);
			     	 listeners.firePropertyChange(PROPERTY_HIDDEN_UNIT, null, name); //$NON-NLS-2$//$NON-NLS-1$		
				  }
			  }
		}

		return replications;
		
 	}
 	
 	/* SUPONDO QUE TODA RECURSAO E' LINEAR, so' ha' necessidadade de um unico replicador
 	 * para a recursao. Neste caso, e' retornado por getReplicatorRec. Supondo recursao nao linear,
 	 * replicatorRec nao faz sentido dessa forma.
 	 */
 	
 	HReplicator replicatorRec = null;
 	
 	public HReplicator getReplicatorRec() {
 		return this.replicatorRec;
 	}
 	
 	private void setReplicatorRec(HReplicator r) {
 		this.replicatorRec = r;
 	}
 	
 	/* ********************* */ 
 	
 	private int abs(int n) {
 		if (n>=0) return n;
 		else return -n;
 	}
 	
 	private HReplicator recEnumerator = null;
 	
 	public HReplicator getRecEnumerator() {
 		return recEnumerator;
 	}
 	
 	public void setRecEnumerator(HReplicator recEnumerator) {
 		this.recEnumerator = recEnumerator;
 	}
 	
 	private void configureRecursion() {
 		
 		List<Pair<HUnit,Integer>> replications = this.getUnitsToReplicateInRecursion();

		Map<Integer,HReplicator> replicators = new HashMap<Integer,HReplicator>();
		
		for (Pair<HUnit,Integer> l : replications) {
			HUnit u = l.fst();
			Integer i = l.snd();
			
			HReplicator r = null;
			if (!replicators.containsKey(0 /*abs(i)*/)) {
				r = new HReplicator((HComponent)this.getTopConfiguration(),new Point(0,0));
				// TODO (getConfiguration): de getConfiguration para getTopConfiguration. Is it safe ?
				this.setReplicatorRec(r); /* SUPONDO RECURSAO LINEAR (somente um replicador sera' efetivamente criado) */			
				r.setReplicatorOrigin(ReplicatorOrigin.RECURSION_CREATION);
				r.setRec(this);
			    this.setRecEnumerator(r);
				replicators.put(0/*abs(i)*/,r);
			} else {
				r = replicators.get(0/*abs(i)*/);
			}
			
			// REPLICATE u !
			try {			
			    u.setReplicator(r,true);		
			    if (i<0) 
			    	u.findLink(r).setInvisible(true);
     		} catch (HPEUnmatchingEnumeratorsException e) {
			   System.err.println("Unexpected Exception !" + e.getMessage());
		    }
			
			//u.findLink(r).setPermanent(true);			
		}

		for (HComponent c : this.getComponentsToReplicateInRecursion()) {
			try {
				HReplicator r = replicators.get(0);
				c.setReplicator(r,true);
				c.findLink(r).setInvisible(!c.getExposed());
			} catch (HPEUnmatchingEnumeratorsException e) {
			   System.err.println("Unexpected Exception !" + e.getMessage());
		    }
		}
	}
     
  /*   public void recurse(HComponent cBasis) throws NoInnerOcurrencesException {
    	 
    	 HComponent cSuper = this.getSuperType();
    	 
    	 List<HComponent> cs = this.innerOccurrencesOfSubTypesOf(cSuper);
    	 HashMap<IHUnit,Vertex> vTable = new HashMap<IHUnit,Vertex>();
    	 HashMap<Vertex,IHUnit> vTableInv = new HashMap<Vertex,IHUnit>();
    	 List<Arc2> rUnits = new ArrayList<Arc2>();
    	     	 
    	 Map<IHUnit,List<Pair<IHUnit,Boolean>>> recMap = new HashMap<IHUnit,List<Pair<IHUnit,Boolean>>>();
    	 
    	 if (!cs.isEmpty()) {
    		 
    		 DiGraph g = this.buildGraph(cBasis, cs, vTable, vTableInv, rUnits);

    		 // for each 
    		 Iterator<Arc2> as = rUnits.iterator();
    	     while (as.hasNext()) {
    	    	 Arc2 a = as.next();
    	    	 Vertex s = (Vertex) a.getTail();
    	    	 Vertex t = (Vertex) a.getHead();
    	    	 IHUnit us = vTableInv.get(s);
    	    	 IHUnit ut = vTableInv.get(t);
 
    	    	 KShortestPaths k_shortest = new KShortestPaths(g,1);
    	    	 KShortestPaths.NAME_OF_VALUE = "poids";
    	    	 k_shortest.run(t,s);
    	    	 k_shortest.printComputedPaths();
    	    	 
    	    	 if (!recMap.containsKey(us)) {
    	    	     recMap.put(us,new ArrayList<Pair<IHUnit,Boolean>>());	 
    	    	 }
    	    		 
    	    	 List<Pair<IHUnit,Boolean>> entry = recMap.get(us);
    	    	 entry.add(new Pair<IHUnit,Boolean>(ut,k_shortest.numberOfComputedPaths() > 0));
    	     }
    		 
    	     this.getUnits();
    	     
    	     
    	     
    	     
    	 } else {
    		 throw new NoInnerOcurrencesException();
    	 }
    	 
     }
     
     
     private DiGraph buildGraph(HComponent cBasis, 
    		                    List<HComponent> is, 
    		                    HashMap<IHUnit,Vertex> vTable,
    		                    HashMap<Vertex,IHUnit> vTableInv,
    		                    List<Arc2> rUnits) {
    	 
    	 HComponent cSuper = this.getSuperType();
    	 
    	 List<Pair<IHUnit,IHUnit>> arcsToDo = new ArrayList<Pair<IHUnit,IHUnit>>();
    	 
		 VertexSet V = new VertexSet();
		 ArcSet A = new ArcSet();
		 DiGraph g = new DiGraph(V,A);
		 
		 // CREATE VERTEXES 
		 Iterator<HComponent> cs = this.getComponents().iterator();
		 while (cs.hasNext()) {
			 HComponent c = cs.next();
			 Iterator<IHUnit> us = c.getUnits().iterator();
			 while (us.hasNext()) {
				 IHUnit u = us.next();
				 
				 if (u instanceof HUnitStub) {
					 u = u.getRealUnit();				     	 
				 } else if (u.getUnitSlice() != null){
                     arcsToDo.add(new Pair<IHUnit,IHUnit>(u,u.getUnitSlice().getUnit()));					 
				 }
				 
				 Vertex vu = new Vertex(); 
				 vu.setDoubleValue(DijkstraAdvanced.DIJKSTRADISTANCE,1.0);
				 V.add(vu);
				 vTable.put(u,vu);
				 vTableInv.put(vu,u);
			 }
		 }
		 
		 // Look for proper units of cStep that are not stubs from inner components.
		 Iterator<IHUnit> pus = this.getUnits().iterator();
		 while (pus.hasNext()) {			 
			 IHUnit pu = pus.next();
			 if (!vTable.containsKey(pu)) {
				 Vertex vu = new Vertex(); 
				 V.add(vu);
				 vTable.put(pu,vu);
			 }
		 }		 
		 
		 // CREATE Arc1 ARCS
		 Iterator<Pair<IHUnit,IHUnit>> as = arcsToDo.iterator();
		 while (as.hasNext()) {			 
			 Pair<IHUnit,IHUnit> a = as.next(); 
			 IHUnit tail = a.fst();
			 IHUnit head = a.snd();
			 Vertex tv = vTable.get(tail);
			 Vertex th = vTable.get(head);
			 Arc1 arc = new Arc1(tv,th);
			 // arc.setValue(KShortestPath.WEIGHT, "1");
			 arc.setDoubleValue(KShortestPaths.NAME_OF_VALUE,1.0);
			 A.add(arc);
		 }		 
		 
		 List<IHUnit> ust = cSuper.getUnits();
		 
		 Iterator<HComponent> iis = is.iterator(); 
		 while (iis.hasNext()) {
			 HComponent c = iis.next();
			 Iterator<IHUnit> cus = c.getUnits().iterator();
			 int i = 0; 
			 while (cus.hasNext()) {
				 IHUnit cu = cus.next();				
				 cu = cu.getRealUnit();
				 IHUnit base_cu = (IHUnit) ust.get(i);
				 base_cu = base_cu.getRealUnit();
				 Vertex tv = vTable.get(base_cu);
				 Vertex th = vTable.get(cu);
				 Arc2 arc = new Arc2(tv,th);			   
				 arc.setDoubleValue(KShortestPaths.NAME_OF_VALUE,1.0);
				 A.add(arc);				
				 rUnits.add(arc);
				 i++;
			 }
		 }
	
		 
		 return g;
    	 
     }
     
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
     // An Arc1 arc from a unit A to a unit B says that A is a slice of B.
     public class Arc1 extends Arc {    	
    	 public Arc1(AbstractVertex tail, AbstractVertex head) {
    		 super(tail,head);
    	 }
     }
     
     // An Arc2 arc from a unit A to a unit B says that A is a subtyping unit and B is a corresponding unit int
     // the recursive component.
     public class Arc2 extends Arc {    	
    	 public Arc2(AbstractVertex tail, AbstractVertex head) {
    		 super(tail,head);
    	 }
     }
   */
     
     public boolean someUnitIsReplicatedBy(HReplicator r) {
    	 
      	 Stack<IHUnit> us = new Stack<IHUnit>();
    	 us.addAll(this.getUnits());
    	 
    	 while (!us.isEmpty()) {
    	     IHUnit u = us.pop();    		 
    		 if (u.isReplicatedBy(r)) 
    			 return true;
    		 else 
    			 if (u.isCloned())
    				 for (IHPrimUnit u_ : u.getClones())
    				      us.push((IHUnit)u_);
    	 }
    	 
    	 return false;   	 
    	 
     }
     
     public boolean someUnitIsReplicatedByVarIdOf(HReplicator r) {
    	 
    	 Stack<IHUnit> us = new Stack<IHUnit>();
    	 us.addAll(this.getUnits());
    	 
    	 while (!us.isEmpty()) {
    	     IHUnit u = us.pop();    		 
    		 if (u.getReplicatorByVarId(r.getVarId()) != null && !(u instanceof HUnitStub)) 
    			 return true;
    		 else 
    			 if (u.isCloned())
    				 for (IHPrimUnit u_ : u.getClones())
    				      us.push((IHUnit)u_);
    	 }
    	 
    	 return false;   	 
    	 
     }
     
     public void cleanReplicators() {
    	 Iterator<HReplicator> rs = ((List)((ArrayList)this.gettReplicators()).clone()).iterator();
    	 while (rs.hasNext()) {
    		 HReplicator r = rs.next();
    		 if (r.getLinksToMe().size()==0)
    		    r.remove();
    	 }
     }
     
     
     
     // FOR XML GENERATION
     private List<HComponent> getComponentsSortedByRef() {
  		List<HComponent> ps = new ArrayList<HComponent>(this.getComponents());
        return HComponent.sortComponentsByRef(ps);    	 
     }
     
 	private static List<HComponent> sortComponentsByRef(List<HComponent> ps) {
		if (ps.size()>1) {
			HComponent pivot = ps.get(0);
			ps.remove(0);
			List<HComponent> ps_l = new ArrayList<HComponent>();
			List<HComponent> ps_r = new ArrayList<HComponent>();
			for (HComponent p : ps) {
				String ref = p.getRef();
				if (ref.compareTo(pivot.getRef())<0) {
					ps_l.add(p);
				} else {
					ps_r.add(p);
				}			 
			}
			List<HComponent> ps_l_ = sortComponentsByRef(ps_l);
			List<HComponent> ps_r_ = sortComponentsByRef(ps_r);
			ps_l_.add(pivot);
			ps_l_.addAll(ps_r_);
			return ps_l;
		}
		else 
			return ps;
		
	}
 
     
     private String ref = null;
     
     public String getRef() {
    	 return this.getName2();
    	 //if (ref == null) 
    	//	 ref = this.getComponentName() + "#" + System.currentTimeMillis() + "%" + this.hashCode();
    	// return ref;
    	 
     }

	public HReplicator lookForReplicator(String ref2) {
		for (HReplicator r : this.gettReplicators()) 
			if (r.getRef().equals(ref2)) 
				return r;
			
		return null;
	}

	public HReplicator lookForReplicator(String ref2, List<String> cRef) {
		for (HReplicator r : this.gettReplicators()) 
			if (r.getRef().equals(ref2)) {
				Iterator<String> iCRef = cRef.iterator();
				boolean found = true;
				HComponent c_ = null;
				for (HComponent c : r.getConfigurations()) {
					if (c != c.getTopConfiguration()) {
						String s = iCRef.next();
				    	String ref = c.getSavedName().containsKey(c_) ? 
			                         c.getSavedName().get(c_) : 
			                         c.getRef();						
						if (!ref.equals(s)) {
							found = false;
							break;
						}
					}
					c_ = c;
				}
				if (found) {
					return r;
				}
			}
			
		return null;
	}
	
	public HInterface fetchInterface(String iName) {
		
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
    	Iterator<Entry<String,List<HComponent>>> t = this.getParameters2().entrySet().iterator();
    	boolean b = true;
    	
    	while (t.hasNext()) {
    		Entry<String,List<HComponent>> e = t.next();    		
    		Iterator<HComponent> cs = e.getValue().iterator();
    		while (cs.hasNext()) {
    			HComponent c = cs.next();
    		    b = b && c.getSupplied()!=null;
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
							((HUnit)utop).updatePorts();
					       	HInterface i = (HInterface)utop.getInterface();
					       	if (!i.getHidden()) {
					       		utop.hideInterface();
					       		utop.showInterface();
					       	}
				       	}
			       	}
	   		   }
	   	   }

    }
    
    public void setExposed(boolean isExposed) {
    	if (this.isExposed != isExposed) {
	       boolean exposedBefore = this.isExposed;
	       this.isExposed = isExposed;	
	       if (exposedBefore && !isExposed && !this.isDirectSonOfTheTopConfiguration()) 
	    	   this.exposedFalsifiedContext = (HComponent) this.getTopConfiguration();
	       else 
	    	   this.exposedFalsifiedContext = null;
	
	       try {
			updatePorts();
		} catch (HPEAbortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	   	   listeners.firePropertyChange(this.PROPERTY_COLOR, null, name); //$NON-NLS-2$//$NON-NLS-1$

	   	   ((HComponent)this.getTopConfiguration()).updateConnections();
	   	   
		   for (HComponent c : this.getInnerTopConfigurations()) {
		     	c.updateConnections();
		   }
       }
   	   
    }
    
    public final static String UPDATE_CONNECTIONS = "update connections";
    
    protected void updateConnections() {
    	   listeners.firePropertyChange(this.UPDATE_CONNECTIONS, null, name); //$NON-NLS-2$//$NON-NLS-1$
    }
    
    public boolean getExposed() {
    	HComponent me = this.isSuperType() ?  (HComponent) this.getConfiguration() : this;
    	
    	return me.isExposed;
    }
    
    public boolean IsExposedFalsifiedContextTop() {
    	HComponent me = this.isSuperType() ?  (HComponent) this.getConfiguration() : this;
    	return !me.isDirectSonOfTheTopConfiguration() && 
    	            me.exposedFalsifiedContext == me.getTopConfiguration();
    }
     
    public boolean IsExposedFalsifiedContext(HComponent c) {
    	HComponent me = this.isSuperType() ?  (HComponent) this.getConfiguration() : this;
    	return me.exposedFalsifiedContext == c;
    }


    static public void supersede2(HComponent c1, HComponent c2) {

		// c2 <: c1;
	    // c2 will replace its c1-image.
     if (c1 != c2) {
    	
		for (HComponent c : c1.getDirectParentConfigurations()) {
			int i = c.getComponents().indexOf(c1);
			c.injectComponent(c2,i);
		}
	    	
	    if (c2.isParameter()) {
	 	   	//c2.setVariableName(c1.getVariableName());
		   	if (c1.isParameter())
		   		c2.parameterIdentifier.putAll(c1.parameterIdentifier);
	    } 
	    	
	    c2.setSavedName(c1.getSavedName());
	    c2.exposedFalsifiedContext = c1.exposedFalsifiedContext;
	    	
	    HComponent im_c1inc2 = (HComponent) c2.getSubTypeImageOf(c1);
	    Iterator us2 = ((ArrayList)((ArrayList)im_c1inc2.getEntries()).clone()).iterator();
	    Iterator us1 = ((ArrayList)((ArrayList)c1.getEntries()).clone()).iterator(); 
	    while (us1.hasNext() && us2.hasNext()) {
	    	IHPrimUnit u2 = (IHPrimUnit) us2.next();
	    	IHPrimUnit u1 = (IHPrimUnit) us1.next();
	    	    	
	    	Pair<IHPrimUnit,IHPrimUnit> pair = alignUnits(u1,u2);
	    	u1 = pair.fst(); u2 = pair.snd();
	    	
			List<Pair<IHPrimUnit,IHPrimUnit>> pairs = matchUnits(u1,u2);
	    	
	    	for (Pair<IHPrimUnit,IHPrimUnit> e : pairs) {
	    		u1 = e.fst();
	    		u2 = e.snd();
	    		HUnit.supersede(u1,u2);
	    	}
	    }
	    
	   for (Pair<HComponent,HComponent> p : c2.getSubTypeImageOf2(c1)) {
	    	HComponent c1_ = p.fst();
	    	HComponent c2_ = p.snd();
	    	if (c1 != c1_ && c2 != c2_) {
		    	c2_.parameterIdentifier.putAll(c1_.parameterIdentifier);
	    	}
	        
	    }
	  
	    HComponent.adjustReplicators(c1,c2);
	    
	    c2.setBounds(c1.getBounds().getCopy());
	
	    List<HComponent> l = new ArrayList<HComponent>(); for (HComponent c : c1.getDirectParentConfigurations()) l.add(c); 
	    for (HComponent c1_ : l) {
	         c1_.removeComponent2(c1);
	    }
	    
	    Iterator<HComponent> c2s = im_c1inc2.getComponentsSortedByRef().iterator();
	    Iterator<HComponent> c1s = c1.getComponentsSortedByRef().iterator();
	    while (c2s.hasNext() && c1s.hasNext()) {
	    	HComponent c1_ = c1s.next();
	    	HComponent c2_ = c2s.next();
	    	HComponent.supersede2(c1_, c2_);
	    }
	
	    // Update ports
	   //c2.setExposed(c1.getExposed());
	   //c2.updatePorts();
	
	    for (HComponent c2_ : c2.getAllParentConfigurations()) {
	        c2_.forceUpdateName();    	
	    }
	    
	    
	        
	/*    ((HComponent) c2.getTopConfiguration()).updateConnections(); 
	
	    for (HComponent c : c2.getInnerTopConfigurations()) {
	    	c.updateConnections();
	    } */
	
     }
}

    private static List<Pair<IHPrimUnit, IHPrimUnit>> matchUnits(IHPrimUnit u1, IHPrimUnit u2) {
		
    	List<Pair<IHPrimUnit,IHPrimUnit>> l = new ArrayList<Pair<IHPrimUnit,IHPrimUnit>>();
    	
		l.add(new Pair<IHPrimUnit,IHPrimUnit>(u1,u2));
    	
    	if (u1.isCloned()) {
    		
    		List<IHPrimUnit> us1 = new ArrayList<IHPrimUnit>(u1.getMyClonesSorted());
    	    //for (IHPrimUnit u : u1.getMyClones()) us1.add(u);
    		
    		if (!u2.isCloned()) {
    			u1 = alignClones(u1,u2);
    		} 
    		Iterator<IHPrimUnit> us2 = u2.getMyClonesSorted().iterator();
			for (IHPrimUnit u1_ : us1) {
			    IHPrimUnit u2_ = us2.next();
	    		l.addAll(matchUnits(u1_,u2_));
			}
			if (us2.hasNext()) {
	 			JOptionPane.showMessageDialog(null, "Something unexpected happened ! Unmatching units. " ,"HComponent.matchUnits", JOptionPane.ERROR_MESSAGE);
			}
    			
    	} else if (u2.isCloned()) { // Symetric case ... POG 
    		List<IHPrimUnit> us2 = new ArrayList<IHPrimUnit>(u2.getMyClonesSorted());
    	    // for (IHPrimUnit u : u2.getMyClones()) us2.add(u);
    		
    		if (!u1.isCloned()) {
    			u2 = alignClones(u2,u1);
    		}
       		Iterator<IHPrimUnit> us1 = u1.getMyClonesSorted().iterator();
   			for (IHPrimUnit u2_ : us2) {
   			    IHPrimUnit u1_ = us1.next();
	    		l.addAll(matchUnits(u1_,u2_));
   			}
   			if (us1.hasNext()) {
   	 			JOptionPane.showMessageDialog(null, "Something unexpected happened ! Unmatching units. " ,"HComponent.matchUnits", JOptionPane.ERROR_MESSAGE);
   			}    			
    	}
    	
		return l;
	}

	private static IHPrimUnit alignClones(IHPrimUnit u1, IHPrimUnit u2) {
		
		HReplicator r = u1.getCloneBySplit().getOwnerReplicator();
		
		if (u2.isReplicatedBy(r)) {
		   u2.splitBy(u1.getCloneBySplit()); 
		} else {
		   // try to align the units ...
		/*	for (IHPrimUnit u : u1.getClones()) {
				if (u.isCloned()) {
					HReplicator r1 = u.getCloneBySplit().getOwnerReplicator();
					if (u2.isReplicatedBy(r1)) {
						u1 = u;
						u2.splitBy(u1.getCloneBySplit());
						break;
					}
				}
			} */
			
		   //JOptionPane.showMessageDialog(null, "The cloned unit is not son of the replicator !!" ,"HComponent.adjustClones", JOptionPane.ERROR_MESSAGE);
		   u2.splitBy(u1.getCloneBySplit()); 
		}
		
		return u1;
		
	}

	private static void adjustReplicators(HComponent c1, HComponent c2) {
    	
    	for (HReplicator r : c1.getReplicators()) {
    		try {
    		   c2.setReplicator(r);
    		   Iterator<HComponent> ics1 = c1.getComponents().iterator(), ics2 = c2.getComponents().iterator();
    		   while (ics1.hasNext() & ics2.hasNext()) {
    			   HComponent c1_ = ics1.next();
    			   HComponent c2_ = ics2.next();
    			   HComponent.adjustReplicators(c1_, c2_);
    		   }
    		} catch (HPEUnmatchingEnumeratorsException e) {
    		   System.err.println("Unexpected Exception !" + e.getMessage());
    	    }
    	}
    	
    	c1.liftReplicatorLinks();
    	c2.liftReplicatorLinks();
		
	}

	private void liftReplicatorLinks() {
	
		Map<String,List<HReplicator>> allRs = new HashMap<String,List<HReplicator>>();
		
		for (HComponent c : this.getDirectParentConfigurations()) {
			List<HReplicator> allRsC = c.getCardinarlityReplicators();
			for (HReplicator r : allRsC) {
				String varId = r.getVarId();
				if (!allRs.containsKey(varId)) {
					List<HReplicator> rs = new ArrayList<HReplicator>();
					rs.add(r);
					allRs.put(varId, rs);
				} else {
					List<HReplicator> rs = allRs.get(varId);
					if (!rs.contains(r)) rs.add(r);
				}
			}
		}
		
		for (HReplicator r : this.getReplicators()) {
		    String varId = r.getVarId();
		    if (allRs.containsKey(varId)) {
                this.unSetReplicator(r);
		    }
			
		}	
		
	}

	static public boolean checkConsistencyOfUnitsInSuperseding(HComponent c1, HComponent c2) {
    
	    IComponent im_c1inc2 = c2.getSubTypeImageOf(c1);
	    HComponent topC = (HComponent)c1.getTopConfiguration();
	    Iterator us2 = ((ArrayList)((ArrayList)im_c1inc2.getEntries()).clone()).iterator();
	    Iterator us1 = ((ArrayList)((ArrayList)c1.getEntries()).clone()).iterator(); 
	    while (us1.hasNext() && us2.hasNext()) {
	    	IHUnit u2 = (IHUnit) us2.next();
	    	IHUnit u1 = (IHUnit) us1.next();
	    	
	    	// ALinhar unidades...
	    	Pair<IHPrimUnit,IHPrimUnit> pair = alignUnits(u1,u2);
	    	u1 = (IHUnit)pair.fst(); u2 = (IHUnit)pair.snd();
	    	
	    	IHUnit topU2 = (IHUnit) u2.getTopUnit(null);
	    	IHUnit topU1 = (IHUnit) u1.getTopUnit(null);
	    	HComponent topC1 = (HComponent)topU1.getConfiguration();
	    	HComponent topC2 = (HComponent)topU2.getConfiguration();
	    	
	    	if (!((topU1 == topU2 && topC1 == topC2 && topC2 == topC /*&& topU1.getInterface()==null*/) || 
	    		  (topU1 != topU2 && topC1 != topC2))) 
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
	
	if (configurations == null) configurations = new ArrayList<HComponent>();
	List<HComponent> l = new ArrayList<HComponent>();
	
	HComponent c = this;
	if (!c.isTopConfiguration()) {
	    for (HComponent c_ : configurations) {
		    if (!l.contains(c_)) l.add(c_);
		    for (HComponent c__ : c_.getAllParentConfigurations())
			     if (!l.contains(c__)) l.add(c__);
	    }
	} 
	
	return l;
}

public HComponent getExposedComponentByName(String name) {

	for (HComponent c : this.getExposedComponents()) {
		if (c.getName2().equals(name)) return c;
	}
	
	return null;
	
}

private List<Pair<String,HComponent>> supplyMemory = new ArrayList<Pair<String,HComponent>>();

public void rememberSupply(String varName, HComponent c) {
	if (supplyMemory == null) supplyMemory = new ArrayList<Pair<String,HComponent>>();
	supplyMemory.add(new Pair<String,HComponent>(varName, ((HComponent)c.getTopConfiguration()).getMyCopy(c)));
}

public List<Pair<String,HComponent>> getSupplierComponents() {
	 
	 /* Todos os components que foram usados na configuracao para suprir parametros de componentes internos.
	  * 
	  * 
	  */
	if (supplyMemory == null) supplyMemory = new ArrayList<Pair<String,HComponent>>();
	return supplyMemory;
	
}

public static boolean checkConsistencyOfCardinalityInSuperseding(HComponent c1, HComponent c2) {
	
	List<String> varIdsOfC1 = c1.getCardinarlityVars(); 
	List<String> varIdsOfC2 = c2.getCardinarlityVars(); 
	
	if (varIdsOfC1.size() != varIdsOfC2.size()) return false;
	
	for (String varId1 : varIdsOfC1) {
		if (!varIdsOfC2.contains(varId1) || varId1.equals(HReplicator.UNDEFINED_VAR)) return false;
	}
	
	return true;
}

private List<String> getCardinarlityVars() {

	List<String> vars = new ArrayList<String>();
	for (HReplicator r : this.getReplicators()) {
		if (!vars.contains(r.getVarId())) vars.add(r.getVarId());
	}
	
	for (HComponent c : this.getDirectParentConfigurations()) {
		for (String varId : c.getCardinarlityVars()) {
			if (!vars.contains(varId)) vars.add(varId);
		}
	}
	
	return vars;
}

private List<HReplicator> getCardinarlityReplicators() {

	List<HReplicator> rs = new ArrayList<HReplicator>();
	for (HReplicator r : this.getReplicators()) {
		if (!rs.contains(r)) rs.add(r);
	}
	
	for (HComponent c : this.getDirectParentConfigurations()) {
		for (HReplicator r : c.getCardinarlityReplicators()) {
			if (!rs.contains(r)) rs.add(r);
		}
	}
	
	return rs;
}

public void addLinkToReplicator(HLinkToReplicator linkToReplicator) {
	this.linkToReplicator.add(linkToReplicator);
	
}

@Override
public void removeLinkToReplicator(HLinkToReplicator linkToReplicator) {
	this.linkToReplicator.remove(linkToReplicator);
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
	if (this.hash_component_UID == null || this.hash_component_UID.equals("")) {
		this.hash_component_UID = this.getComponentName().toLowerCase();
	}
	
    return this.hash_component_UID;
}

public boolean isTransitiveInnerComponentIf(HComponent c2) {
    
	if (configurations == null) configurations = new ArrayList<HComponent>();
	
	HComponent c = this;
	if (!c.isTopConfiguration()) {
	    for (HComponent c_ : configurations) {
		    if (c_==c2 || c_.isTransitiveInnerComponentIf(c2)) return true;
	    }
	} 
	
	return false;
	
}

private Integer nextFreshRef=0;

private String generateFreshRef() {
	
	
	Integer max = 0; 
	
	max = (nextFreshRef++);
	
/*	for (HComponent c : this.getComponents()) {
		String name = c.getRef();
		if (name.matches("c[0-9]*")) {
			Integer v = null;
			try {
			  v = Integer.valueOf(name.substring(1));
			} catch (NumberFormatException e) {
			  v = 0;
			}
			max = v > max ? v : max;
		}				
	}
	*/
		
	return "c" + (max+1); 
}

private boolean checkLegalRef(String ref) {
	
/*	for (HComponent c : this.getExposedComponents()) {
		String name = c.getRef();
		if (name.equals(ref)) return false;
	}
	
	for (HComponent c : this.getComponents()) {
		String name = c.getRef();
		if (name.equals(ref)) return false;
	} */
		
	return true;
}

public boolean hasFreeVariables() {
	
	HComponent topC = (HComponent) this.getTopConfiguration();
	
	Map<String,List<HComponent>> params = this.getParameters2();
	
	for (Entry<String,List<HComponent>> entry : params.entrySet()) {
		List<HComponent> cs = entry.getValue();
		for (HComponent c : cs) {
			String parIdAtTopC = c.getParameterIdentifier(topC);
			if (parIdAtTopC.equals("type ?") && !c.isInnerOfFreeParameter() && c.getSupplied() == null) 
				return true;
		}
		
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

}