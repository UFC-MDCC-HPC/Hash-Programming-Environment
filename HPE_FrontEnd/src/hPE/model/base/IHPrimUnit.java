package hPE.model.base;

import hPE.model.base.exceptions.HPEAbortException;
import hPE.model.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IConfiguration;
import hPE.model.interfaces.IInterface;
import hPE.model.interfaces.IInterfaceSlice;
import hPE.model.interfaces.IReplicator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public interface IHPrimUnit extends IHasInterface, IReplicatedElement, IPropertyChangeListener, HNamed, Serializable {

	public final static String REMOVE_UNIT = "remove_unit";

	/** 
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public abstract String getName2();

	/**
	 */
	public abstract void addPropertyChangeListener(
			PropertyChangeListener listener);

	/**
	 */
	public abstract void removePropertyChangeListener(
			PropertyChangeListener listener);

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public abstract void setName(String name);

	public abstract void remove();

	/** 
	 * Getter of the property <tt>configuration</tt>
	 * @return  Returns the configuration.
	 * @uml.property  name="configuration"
	 */
	public abstract IConfiguration getConfiguration();

	public final static String PROPERTY_BOUNDS = "unit_bounds";

	/**
	 */
	public abstract List<HReplicator> getReplicators();

	public final static String REPLICATED = "replicated";

	/**
	 */
	public abstract void setReplicator(HReplicator the_replicator) throws HPEUnmatchingEnumeratorsException;

	public abstract void setReplicator(HReplicator the_replicator,
			boolean permanent) throws HPEUnmatchingEnumeratorsException;

	public abstract void unSetReplicator(HReplicator which_replicator);

	public abstract void unsetAllReplicators();

	
	/**
	 */
	public abstract boolean isReplicated();

	/**
	 */
	public abstract boolean isReplicatorFactorDetermined(
			HReplicator which_replicator);

	/**
	 */
	public abstract int getReplicationFactor(HReplicator which_replicator);

	/** 
	 * @uml.property  name="linkToReplicator"
	 */
	public abstract List<HLinkToReplicator> getLinksToVisibleReplicators();

	public abstract void addLinkToReplicator(HLinkToReplicator l);
	
	public abstract List<HLinkToReplicator> getLinksToReplicators();
	/** 
	 * Setter of the property <tt>linkToReplicator</tt>
	 * @param linkToReplicator  The replicator to set.
	 * @uml.property  name="linkToReplicator"
	 */
	public abstract void setLinkToReplicator(Collection<HLinkToReplicator> linkToReplicator);

	public abstract boolean isReplicatedBy(IReplicator which_replicator);

	/**
	 * Getter of the property <tt>observable</tt>
	 * @return  Returns the observable.
	 * @uml.property  name="observable"
	 */
	public abstract boolean getObservable();

	/**
	 * Setter of the property <tt>observable</tt>
	 * @param observable  The observable to set.
	 * @uml.property  name="observable"
	 */
	public abstract void setObservable(boolean observable);

	public final static String PROPERTY_COLOR = "Change Color";

	public abstract void notifyColorChange();

	/**
	 * Getter of the property <tt>mapped_to_slice</tt>
	 * @return  Returns the mapped_to_slice.
	 * @uml.property  name="mapped_to_slice"
	 */
	public abstract HInterfaceSlice getMappedToSlice();

	/**
	 * Setter of the property <tt>mapped_to_slice</tt>
	 * @param mapped_to_slice  The mapped_to_slice to set.
	 * @uml.property  name="mapped_to_slice"
	 */
	public abstract void setMappedToSlice(HInterfaceSlice mapped_to_slice);

	public final static String CHANGING_PORTS = "changing_ports";

	public abstract void adviceChangingPorts();

	public abstract boolean isRepetitive();

	// public abstract List getPorts();

	public abstract PropertyChangeSupport getListeners();

	public final static String BINDING_CREATE_SOURCE = "binding_create_source";

	/**
	 * Getter of the property <tt>binding</tt>
	 * @return  Returns the binding.
	 * @uml.property  name="binding"
	 */
	public abstract HBinding getBinding();

	public abstract List<HBinding> getBindings();
	/**
	 * Setter of the property <tt>binding</tt>
	 * @param binding  The binding to set.
	 * @uml.property  name="binding"
	 */
	public abstract void setBinding(HBinding binding);

	public abstract void addBinding(HBinding binding);
	
	public abstract void unsetBinding();
	
	public abstract void removeBinding(HBinding b);

	public abstract IComponent getComponent();

	public abstract IHUnit getAncestor();

	public abstract void setAncestor(IHUnit unit);

	public abstract boolean isEntry();

	public abstract void setBounds(Rectangle bounds);

	public abstract void attachToInterface(HInterface which_interface);

	public abstract boolean matchForAttachment(HInterface which_interface);

	public abstract void detachFromInterface();

	/** 
	 * Getter of the property <tt>linkToInterface</tt>
	 * @return  Returns the linkToInterface.
	 * @uml.property  name="linkToInterface"
	 */
	public abstract HLinkToInterface getLinkToInterface();

	/**
	 * Setter of the property <tt>linkToInterface</tt>
	 * @param linkToInterface  The linkToInterface to set.
	 * @uml.property  name="linkToInterface"
	 */
	public abstract void setLinkToInterface(HLinkToInterface linkToInterface);

	public abstract HInterface createInterface(Point location) throws HPEAbortException;

	public abstract IInterface getInterface();

	public abstract boolean visibleInterface();

	public final static String INTERFACE_SHOW = "show_interface";

	public final static String INTERFACE_HIDE = "hide_interface";

	public abstract void showInterface();

	public abstract void hideInterface();

	public abstract void setInterface(HInterface which_interface);

	/*
	 public String toString() {
	 return this.getConfiguration().toString().concat(".u.").concat(this.getName());
	 } */


	public abstract HPrimUnit createReplica(int i);

//	public abstract IHPrimUnit getCopy(HComponent newConfiguration,
	//		Rectangle bounds);

	public abstract void setHiddenSlices(boolean h);

	public final static String PROPERTY_HIDDEN_SLICES = "PROPERTY_HIDDEN_SLICES";

	public abstract boolean getHiddenSlices();
	
	public Rectangle getBounds();
	
	public final static String HIDDEN_PROPERTY = "HIDDEN_PROPERTY";

	public void setHidden (boolean hidden);
	
	public boolean getHidden();
	
	public void setHiddenBlocked (boolean hiddenBlocked);
	
	public boolean getHiddenBlocked();
	
	public void setInterfaceEditable (boolean editable);
	
	public boolean isInterfaceEditable();

	public HPrimUnit getTopUnit(Map<HPrimUnit,Integer> path);
	
	public List<HPrimUnit> getTopUnits(Map<HPrimUnit,Integer> path);
	
	public IHPrimUnit getRealUnit();

	public boolean isClone();
	
	public HReplicatorSplit getCloneBySplit();
	
	public void setCloneBySplit(HReplicatorSplit cloneBySplit);
	
	public abstract List<IHPrimUnit> getClones();

	public abstract List<IHPrimUnit> getMyClones();
	
	public IHPrimUnit getClone(int i);
	
	public IHPrimUnit cloneOf();
	
	public boolean isCloned();
	
	public int getIndexOfClone(IHPrimUnit u);

	public abstract HReplicatorSplit splitBy(HReplicatorSplit cloneBySplit);

	public abstract void align(HPrimUnit u1);

	public abstract List<IHPrimUnit> getMyClonesSorted();
}