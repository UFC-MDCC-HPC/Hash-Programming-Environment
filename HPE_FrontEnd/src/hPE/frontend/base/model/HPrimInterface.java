package hPE.frontend.base.model;

import hPE.frontend.base.interfaces.IComputationConfiguration;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public abstract class HPrimInterface extends HVisualElement implements Serializable, HNamed, IHasColor {

	public final static String PROPERTY_COLOR = "interface_color";
	
	static final long serialVersionUID = 1;


	/**
	 * @uml.property   name="configuration"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="interfaces:hPE.base.model.HComponent"
	 */
	private HComponent configuration;

	/** 
	 * Getter of the property <tt>configuration</tt>
	 * @return  Returns the configuration.
	 * @uml.property  name="configuration"
	 */
	public IComputationConfiguration getConfiguration() {
		return configuration;
	}

    private List<IHPrimUnit> compliantUnits = new ArrayList<IHPrimUnit>();
    
    public void addCompliantUnit(IHPrimUnit unit) {
    	if (!compliantUnits.contains(unit)) compliantUnits.add(unit);
    }
    
    public void removeCompliantUnit(IHPrimUnit unit) {
    	compliantUnits.remove(unit);
    }
    
    public List<IHPrimUnit> getCompliantUnits () {
    	return this.compliantUnits;
    }
   
    

	

	/**
	 * @uml.property  name="default_position"
	 */
	public static Point default_position = new Point(100,100) ;
	/**
	 * @uml.property  name="default_dimension"
	 */
	public static Dimension default_dimension = new Dimension (80,40);
	
	/**
	 */
	public HPrimInterface(HComponent configuration, HInterfaceSig signature, IHPrimUnit unit, Point where) {
		super();
		
		listeners = new PropertyChangeSupport(this);
		this.addCompliantUnit(unit);
		this.signature = signature;
		signature.addComplyingInterface(this);
		
		Rectangle r = new Rectangle(HInterface.default_position,HInterface.default_dimension);
		r.setLocation(where);
		this.setBounds(r);

		this.configuration = configuration;
		configuration.newInterface((HInterface)this);
	
		
		
		
	}

	private String indexName = null;
	
	public String getIndexName() {
		if (indexName!=null) return indexName;
		else return this.toString();
	}
	
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	
	/**
	 * @uml.property   name="signature"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="complying_interfaces:hPE.base.model.HInterfaceSig"
	 */
	private HInterfaceSig signature = null ;

	/** 
	 * Getter of the property <tt>signature</tt>
	 * @return  Returns the signature.
	 * @uml.property  name="signature"
	 */
	protected HInterfaceSig getSignature() {
		return signature;
	}
	
	public final static String PROPERTY_SIGNATURE = "PROPERTY_SIGNATURE";
	
	protected void setSignature(HInterfaceSig signature) {
		this.signature = signature;
		if (!this.getName2().equals(signature.getName())) {
			this.getSignature().setName(this.getName2());
		}
		this.getListeners().firePropertyChange(PROPERTY_SIGNATURE, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$

	}

	public List<HInterfaceSlice> getSlices() {		
		if (this.getSignature() != null) {
		    return this.getSignature().getSlices();
		} else {
			return new ArrayList<HInterfaceSlice>();
		}
	}
	

	
	public final static String PROPERTY_BOUNDS = "interface_bounds";
	public final static String REMOVE_INTERFACE = "remove_interface";
	public final static String INTERFACE_HIDE = "hide_interface";
	public final static String INTERFACE_SHOW = "show_interface";
	
	private PropertyChangeSupport listeners;

	protected PropertyChangeSupport getListeners() {
		return listeners;
	}

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
	
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}


	/**
	 * @uml.property  name="hidden"
	 */
	private boolean hidden = false;

	/**
	 * Getter of the property <tt>hidden</tt>
	 * @return  Returns the hidden.
	 * @uml.property  name="hidden"
	 */
	public boolean getHidden() {
		return hidden;
	}


	/**
	 * Setter of the property <tt>hidden</tt>
	 * @param hidden  The hidden to set.
	 * @uml.property  name="hidden"
	 */
	private void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public void show() {
		this.setHidden(false);
		listeners.firePropertyChange(INTERFACE_SHOW, null, this); //$NON-NLS-2$//$NON-NLS-1$
	}
	
	public void hide() {
		
	    boolean r = true;
		
		// CHECKS IF THERE IS SOMEONE VIEWING THE INTERFACE.
        for (HLinkToInterface link : this.getLinksToTheInterface()) {
        	if (link.visibleInterface()) r = false;
        }        	
		
		this.setHidden(r);
		
		
		listeners.firePropertyChange(INTERFACE_HIDE, null, this); //$NON-NLS-2$//$NON-NLS-1$
		
	}
	
	public void forceHide() {
		
		// CHECKS IF THERE IS SOMEONE VIEWING THE INTERFACE.
		for (HLinkToInterface link : this.getLinksToTheInterface()) {
        	link.hide_interface();
        }        	
		
		this.setHidden(true);
	}

	/**
	 */
	public void addLinkToInterface(HLinkToInterface link) {
		if (!linksToTheInterface.contains(link))
		    linksToTheInterface.add(link);	
	}

	public void removeLinkToInterface(HLinkToInterface link) {
		linksToTheInterface.remove(link);	
	}
	
	/**
	 * @uml.property   name="linksToTheInterface"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="which_interface:hPE.base.model.HLinkToInterface"
	 */
	private Collection<HLinkToInterface> linksToTheInterface = new ArrayList<HLinkToInterface>();

	/**
	 * Getter of the property <tt>linksToTheInterface</tt>
	 * @return  Returns the linksToTheInterface.
	 * @uml.property  name="linksToTheInterface"
	 */
	public Collection<HLinkToInterface> getLinksToTheInterface() {
		return linksToTheInterface;
	}




	/**
	 * Setter of the property <tt>linksToTheInterface</tt>
	 * @param linksToTheInterface  The linksToTheInterface to set.
	 * @uml.property  name="linksToTheInterface"
	 */
	public void setLinksToTheInterface(Collection<HLinkToInterface> linksToTheInterface) {
		this.linksToTheInterface = linksToTheInterface;
	}
	

	

	public final static String EDITABLE_PROPERTY = "EDITABLE_PROPERTY";
	
	private boolean editable = false;
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	    listeners.firePropertyChange(EDITABLE_PROPERTY,null,getName2());
	}
	
	public boolean isEditable() {
		return this.editable;
	}
	
	
//	boolean loadedFormalPorts = false;
	
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
		this.signature.setColor(color);
		listeners.firePropertyChange(PROPERTY_COLOR, null, color);
	}
	
	
	private String name = null;

	public String getPrimName() {
		if (this.name == null)
			return "<unamed>";
		else
			return this.name;		
	}

	public String getName2 () {
		return getPrimName();
	}
	
	private void setPrimName(String name) {
		    this.name = name;
		    //((HConfiguration)this.getConfiguration()).updateInterfaceName(this);		    
			listeners.firePropertyChange("labelContents", null, name); //$NON-NLS-2$//$NON-NLS-1$
	}
	
	public void setName(String name) {
		this.setPrimName(name);
		if (this.getSignature()!=null)
		  this.getSignature().setName(name);
	}
	
	public boolean isUnamed() {
		return this.name == null;
	}
	
	public String toString() {
		String r = this.getConfiguration().toString().concat(".i.").concat(this.getPrimName());
		return r;
	}
	
	public void setConfiguration(HComponent configuration) {
	    this.configuration = configuration;	
	}
	
	public boolean isNewNameValid(String name) {
		return true;
	}
}

