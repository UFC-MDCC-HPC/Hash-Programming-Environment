package hPE.frontend.kinds.activate.model.protocol;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import hPE.frontend.base.interfaces.IAction;
import hPE.frontend.base.interfaces.IActionRepeat;
import hPE.frontend.base.model.HVisualElement;


public class HAction extends HVisualElement 
             implements Serializable, Cloneable, IAction {

	static final long serialVersionUID = 1;
	
	private boolean repeat = false;
	private int depth = 0;
	
	public final static String PROPERTY_REPEAT = "property_repeat";
	
	public void setRepeat(int depth) {
		this.repeat = depth > 0;
		this.depth = depth;
		listeners.firePropertyChange(PROPERTY_REPEAT,null,getLabel());
	}	
	
	public boolean isRepeat() {
		return this.repeat;
	}
	
	public int getRepeatDepth() {
		return this.depth;
	}
	
	/**
	 * @uml.property   name="protocol"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="action:hPE.kinds.computation.model.protocol.HProtocol"
	 */
	protected HProtocol protocol ;

	/** 
	 * Getter of the property <tt>protocol</tt>
	 * @return  Returns the protocol.
	 * @uml.property  name="protocol"
	 */
	public HProtocol getProtocol() {
		return protocol;
	}

	/**
	 * @uml.property  name="label"
	 */
	protected String label = "";

	/**
	 * Getter of the property <tt>label</tt>
	 * @return  Returns the label.
	 * @uml.property  name="label"
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Setter of the property <tt>label</tt>
	 * @param label  The label to set.
	 * @uml.property  name="label"
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public final static String PROPERTY_BOUNDS = "action_bounds";
	
	protected PropertyChangeSupport listeners;

	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
//		if (this.getAction_combinator() != null)
//		   checkAndAdjustParentBounds(this.getAction_combinator());
		
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
		
	}
	
	protected void checkAndAdjustParentBounds(HCombinatorAction parent_action) {
	
		// TODO: model (checkAndAdjustParentBounds)
		
		int sep_w = 10;
		int sep_h = 10;
		
		int x1 = this.getBounds().x;
		int y1 = this.getBounds().y;
		int w = this.getBounds().width;
		int h = this.getBounds().height;
		
		if (saved_bounds == null && x1 + sep_w > w) {
		
//			int width = x1 + sep_w;
		}
		
		if (saved_bounds == null && y1 + sep_h > h) {
			
		}
		
		
		
		
	}

	Rectangle saved_bounds = null;
	
	private void configureAction(Rectangle bounds) {		
		
		listeners = new PropertyChangeSupport(this);
		this.label = this.toString();
		setBounds(bounds);
	}
	
	protected static Dimension default_dimension = new Dimension(50,50); 
	
	public HAction(String label) {
		super();
		
		// Default position and dimension for top action
		Rectangle bounds = protocol.getBounds().getCopy();
		bounds.setLocation((bounds.width  - default_dimension.width )/2, 
				           (bounds.height - default_dimension.height)/2);
		bounds.setSize(default_dimension);
		
		configureAction(bounds);
	}

	/** CONSTRUCTOR FOR TOP ACTION.
	 */
	public HAction(String label, HProtocol protocol) {
		super();
		
		// Default position and dimension for top action
		Rectangle bounds = protocol.getBounds().getCopy();
		bounds.setLocation((bounds.width  - default_dimension.width )/2, 
				           (bounds.height - default_dimension.height)/2);
		bounds.setSize(default_dimension);
		
		configureAction(bounds);
		this.protocol = protocol;
		protocol.setAction(this);
	}

	/** CONSTRUCTOR FOR INNER ACTION.
	 */
	public HAction(String label, HCombinatorAction action_combinator) {
		super();
		
		// Default position and dimension for action inside combinator
		Rectangle bounds = new Rectangle(action_combinator.getBounds().getLocation(), new Dimension(default_dimension));// action_combinator.nextActionBounds();
		
		configureAction(bounds);
		this.action_combinator = action_combinator;
		action_combinator.addAction(this);
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
	
	/**
	 * @uml.property   name="action_combinator"
	 * @uml.associationEnd   readOnly="true" inverse="actions:hPE.kinds.computation.model.protocol.HCombinatorAction"
	 */
	protected HCombinatorAction action_combinator;

	/**
	 * Getter of the property <tt>action_combinator</tt>
	 * @return  Returns the action_combinator.
	 * @uml.property  name="action_combinator"
	 */
	public HCombinatorAction getActionCombinator() {
		return action_combinator;
	}
	
	public HAction getCopy(HCombinatorAction top_action) {
		
		try {
			HAction copy = (HAction) this.clone();
			copy.setLabel(copy.toString());
			copy.newListener();
			copy.action_combinator = top_action;
			copy.protocol = null;
			copy.setBounds(copy.getBounds().getCopy());
			return copy;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
		
	}

	protected void newListener() {
		listeners = new PropertyChangeSupport(this);
	}

	private HDoAction encapsulatingDoAction = null;
	
	public HDoAction getEncapsulatingDoAction() {
		return encapsulatingDoAction;
	}
	
	public void setEncapsulatingDoAction(HDoAction encapsulatingDoAction) {
		this.encapsulatingDoAction = encapsulatingDoAction;
	}
	
	
	public void setCombinatorAction(HCombinatorAction action) {
		this.action_combinator = action;
		if (!action_combinator.getActions().contains(this)) {
		    this.action_combinator.addAction(this);
		}
		this.protocol = null;
	}
	
	public void setCombinatorAction(HCombinatorAction action, int i) {
		this.action_combinator = action;
		this.action_combinator.addAction(i,this);
		this.protocol = null;
	}
	
	public final static String PROPERTY_PROTOCOL = "property_protocol";
	
	public void setProtocol(HProtocol protocol) {
	//	if (action_combinator != null) {
	//	   this.action_combinator.removeAction(this);
  		   this.action_combinator = null;
	//	}
		this.protocol = protocol;
		protocol.setAction(this);
		listeners.firePropertyChange(PROPERTY_PROTOCOL,null,protocol);
	}
	
	public HAction getTopActionCopy() {
		
		HAction action = this;
		HAction top_action_copy;
		
		while (action.getActionCombinator() != null) {
			action = action.getActionCombinator(); 
		}
		
		top_action_copy = action.getCopy(null);
		top_action_copy.setProtocol(action.getProtocol());
		
		return top_action_copy;
		
	}
	
	public void organizeAction() {
		// Nothing todo ...
	}
	
	public IActionRepeat getRepeatAction() {
		if (this.isRepeat()) return (IActionRepeat) this;
		else return null;
	}
	
}
