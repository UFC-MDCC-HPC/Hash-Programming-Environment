package hPE.model.base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;


public class HInterfaceSig implements Serializable, IHasColor  {

	static final long serialVersionUID = 1;
	
	/**
	 * @uml.property   name="name"
	 */
	private String name = null;

	/** 
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		if (name == null)
			return "<unamed>";
		else
			return name;
	}

	/**
	 */
	public void addSlice(HInterfaceSlice slice) {
		
		slices.add(slice);
		   
		// signalInterfaceUpdating();
		
	}

	/**
	 */
	public void removeSlice(HInterfaceSlice slice) {
		
		slices.remove(slice);
		
		signalInterfaceUpdating();
		   
	}
	
	private void signalInterfaceUpdating() {
		Iterator<HInterface> is = this.getComplying_interfaces().iterator();
		while (is.hasNext()) {
			HInterface i = is.next();
			if (i.getListeners() != null) i.getListeners().firePropertyChange(HInterface.PROPERTY_SIGNATURE,null,getName());
		}
	}
	
	/**
	 */
	public HInterfaceSig(String name) {
		super();
		this.name = name;
		
	}

	public HInterfaceSig() {
		super();
		
	}

	public HInterfaceSig(IHUnit u, Map<HUnitSlice,List<HPort>> ports) {
		super();
		buildSignature(u, ports);
		
	}

	/**
	 * @uml.property   name="complying_interfaces"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" inverse="signature:hPE.base.model.HInterface"
	 */
	private Collection complying_interfaces = new ArrayList();

	/** 
	 * Getter of the property <tt>complying_interfaces</tt>
	 * @return  Returns the complying_interfaces.
	 * @uml.property  name="complying_interfaces"
	 */
	public Collection getComplying_interfaces() {
		return complying_interfaces;
	}

	
	public void addComplyingInterface(HPrimInterface which_interface) {
		this.complying_interfaces.add(which_interface);
	}



	/**
	 * @uml.property  name="color"
	 */
	private MyColor color = new MyColor(ColorConstants.gray);  
	
		

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
	}


	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @uml.property   name="slices"
	 * @uml.associationEnd   multiplicity="(0 -1)" ordering="true" inverse="interface_sig:hPE.model.HSliceAbstraction"
	 */
	private List<HInterfaceSlice> slices = new ArrayList<HInterfaceSlice>();

	/** 
	 * Getter of the property <tt>slices</tt>
	 * @return  Returns the slices.
	 * @uml.property  name="slices"
	 */
	public List<HInterfaceSlice> getSlices() {
		return slices;
	}


	/** 
	 * Setter of the property <tt>slices</tt>
	 * @param slices  The slices to set.
	 * @uml.property  name="slices"
	 */
	public void setSlices(List<HInterfaceSlice> slices) {
		this.slices = slices;
	}

	public void replaceSlice (HInterfaceSlice s1, HInterfaceSlice s2) {
		
		this.slices.add(s1);
		this.slices.remove(s2);
		
		
	}

    private Map<HInterfaceSlice,List<HPort>> buildPortTable(Map<HUnitSlice,List<HPort>> ports1) {
    	
    	Map<HInterfaceSlice,List<HPort>> ports2 = new HashMap<HInterfaceSlice,List<HPort>>();
    	for (Entry<HUnitSlice,List<HPort>> e : ports1.entrySet()) {
    		ports2.put((HInterfaceSlice)e.getKey().getInterfaceSlice(),e.getValue());
    	}
    	
    	return ports2;
    }
	
    public void updatePorts(Map<HUnitSlice,List<HPort>> ports1) {
    	
    	// TODO: SAVE POSITION OF SLICES AND RECOVER AFTER 
    	Map<String, Rectangle> savedPos = new HashMap<String,Rectangle>();
    	List<HPort> ports = this.getPorts();
    	for (HPort port : ports) {
    		savedPos.put(port.getName(), port.getBounds());
    	}
    	
    	
		this.ports = new ArrayList<HPort>();
		
    	Map<HInterfaceSlice,List<HPort>> ports2 = buildPortTable(ports1);
    	
    	for (HInterfaceSlice s : this.getSlices()) {
    		updatePortsOfSlice(s,ports2);
    		for (HPort port : s.getPorts()) {
    			if (savedPos.containsKey(port.getName())) {
    				Rectangle bounds = savedPos.get(port.getName());
    				port.setBounds(bounds);
    			}
    		}
    	}
    	
    }
    
    private void updatePortsOfSlice(HInterfaceSlice s, Map<HInterfaceSlice,List<HPort>> ports2) {
    
		List<HPort> _ports = ports2.get(s);
		if (_ports != null) {
			s.setPorts(_ports);
			for (HPort _port : _ports) {
				_port.addOwner(s);
				this.addPort(_port);
				for (HInterfaceSlice slice_ : ((List<HInterfaceSlice>)((ArrayList<HInterfaceSlice>)_port.getInterfaceSlices()).clone())) {
					if (slice_ == null) slice_ = s;
					slice_.resetDefaultName();
					_port.addInterfaceSlice(s,slice_);
					slice_.setMyPort(_port);
					_port.removeNull();
				}
			}
		}
    }
	
	private void buildSignature(IHUnit u, Map<HUnitSlice,List<HPort>> ports) {
		
		this.ports = new ArrayList<HPort>();

		for (HUnitSlice usa : u.getSlices()) {
			
			HBinding binding = usa.getBinding();
			HInterfaceSlice s = usa.newInterfaceSlice(binding.getEntry().getName2(),this);
			
			s.resetDefaultName();
							
			s.addCompliantUnitSlice(usa);
			usa.setInterfaceSlice(s);
			
			s.setBounds(usa.getBounds());						
		}
		
		updatePorts(ports);
		
		
	}

	private List<HPort> ports = new ArrayList<HPort>();
	
	public void addPort(HPort port) {
		if (ports == null) ports = new ArrayList<HPort>(); 
		if (!ports.contains(port))
			ports.add(port);		
	}
	
	public List<HPort> getPorts() {
		if (ports == null) ports = new ArrayList<HPort>(); 
		return ports;
	}
	
	
}
