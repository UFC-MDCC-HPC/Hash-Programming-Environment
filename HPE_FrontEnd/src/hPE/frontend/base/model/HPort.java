package hPE.frontend.base.model;

import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class HPort extends HVisualElement implements IHasInterface, INamed {

	static final long serialVersionUID = 1;

	private PropertyChangeSupport listeners;
	
	public HPort() {
		super();
		
        listeners = new PropertyChangeSupport(this);

	}
		
	private Map<HInterfaceSlice,List<HInterfaceSlice>> ss = new HashMap<HInterfaceSlice,List<HInterfaceSlice>>();
	
	public void addInterfaceSlice(HInterfaceSlice sowner, HInterfaceSlice s) {
		
		if (sowner == null || sowner.hasSlice(s)) {

			if (ss.containsKey(s)) {
				List<HInterfaceSlice> l = ss.get(s);
				if (sowner != null) 
					l.add(sowner);
			} else {
				List<HInterfaceSlice> l = new ArrayList<HInterfaceSlice>();
				if (sowner != null)
					l.add(sowner);
				ss.put(s, l);
			}
			
		}
	}
	
	public List<HInterfaceSlice> getInterfaceSlices() {
		List<HInterfaceSlice> ss = new ArrayList<HInterfaceSlice>();
		ss.addAll(this.ss.keySet());
		return ss;
	}
	
	public void removeNull() {
		this.ss.remove(null);
	}
	
	private List<HInterfaceSlice> owners = new ArrayList<HInterfaceSlice>();
	
	public void addOwner(HInterfaceSlice slice) {
		owners.add(slice);
	}
	
	public List<HInterfaceSlice> getOwners() {
		return owners;
	}
	
	public boolean isPrivate() {
		try {
	   	  return !((HComponent)((HInterface)this.getMainSlice().getInterface()).getCompliantUnits().get(0).getConfiguration()).getExposed();
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}
	
	public HInterface getPortType() {
		return (HInterface)this.getInterfaceSlices().get(0).getInterface();
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}
	
	/**
	 * @uml.property  name="default_position"
	 */
	public static Point default_position = new Point(0,0) ;
	/**
	 * @uml.property  name="default_dimension"
	 */
	public static Dimension default_dimension = new Dimension (10,10);
	
	public final static String PROPERTY_BOUNDS = "port_bounds";

	public Rectangle getBounds() {
		if (super.getBounds() == null) {
			super.setBounds(new Rectangle(HPort.default_position,HPort.default_dimension));
		}
		return super.getBounds();
	}
	
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
				
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}

	public HInterfaceSlice getMainSlice() {
		return this.getInterfaceSlices().get(0);
	}
	
	@Override
	public IConfiguration getConfiguration() {
		return this.getMainSlice().getConfiguration();
	}

	@Override
	public IInterface getInterface() {
		return this.getMainSlice().getInterface();
	}

	@Override
	public HLinkToInterface getLinkToInterface() {
		return this.getMainSlice().getLinkToInterface();
	}

	@Override
	public void hideInterface() {
		this.getMainSlice().hideInterface();
	}

	@Override
	public void notifyColorChange() {
		this.getMainSlice().notifyColorChange();
	}

	@Override
	public void setInterface(HInterface the_interface) {
		 this.getMainSlice().setInterface(the_interface);

	}

	@Override
	public void showInterface() {
		this.getMainSlice().showInterface();
	}

	@Override
	public boolean visibleInterface() {
		return this.getMainSlice().visibleInterface();
	}

	@Override
	public String getName() {
		return this.getMainSlice().getName();
	}

	@Override
	public void setName(String name) {
       for (HInterfaceSlice s : this.getInterfaceSlices()) {
    	   s.setName(name);
       }
		
	}

	private boolean inherited = false;
	
	public boolean isInherited() {
		return this.inherited;
	}
	
	public void setInherited(boolean inherited) {
		this.inherited = inherited;
	}

	public String getOriginalName() {
		
		return this.getMainSlice().getDefaultName();
	}
	
	public String getOriginalNameOf(HInterfaceSlice sOwner) {
		
		for (Entry<HInterfaceSlice, List<HInterfaceSlice>> e : this.ss.entrySet()) {
		    HInterfaceSlice es = e.getKey();
			List<HInterfaceSlice> eos = e.getValue();
			for (HInterfaceSlice eo : eos) {
			    if (eo == sOwner) {
			    	return es.getDefaultName();
			    }
			}
		}
		
		return null;
	}
	
}


