package hPE.model.protocol.kinds.activate;

import java.util.List;
import org.eclipse.draw2d.geometry.Rectangle;
import java.util.Iterator;
import java.util.ArrayList;

import java.io.Serializable;

public abstract class HCombinatorAction extends hPE.model.protocol.kinds.activate.HAction  implements Serializable {

	static final long serialVersionUID = 1;
	
	/**
	 * @uml.property   name="actions"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" ordering="true" inverse="action_combinator:hPE.kinds.computation.model.protocol.HAction"
	 */
	private List<HAction> actions = new ArrayList<HAction>();

	/** 
	 * Getter of the property <tt>actions</tt>
	 * @return  Returns the actions.
	 * @uml.property  name="actions"
	 */
	public List<HAction> getActions() {
		return actions;
	}


	public HCombinatorAction(String label) {
		super(label);
	}
	
	/**
	 */
	public HCombinatorAction(String label, HProtocol protocol) {
		super(label, protocol);
	}

	/**
	 * 
	 */
	public HCombinatorAction(String label, HCombinatorAction action_combinator) {
		super(label, action_combinator);
	}

	public abstract Object getInnerActionSourceConnectionID(HAction action);
	public abstract Object getInnerActionTargetConnectionID(HAction action);
	public abstract List getEntryConnectionIDs();
	public abstract List getExitConnectionIDs();
	
	public Object getBeginConnectionID() {
		return this.getLabel().concat(".BEGIN");
	}
	
	public Object getEndConnectionID() {
		return this.getLabel().concat(".END");
	}
	
	/*
	public abstract Rectangle nextActionBounds();
	public abstract Rectangle adjustToFitNextAction ();
	*/
	
	public HAction getCopy(HCombinatorAction top_action) {
		
		try {
			HCombinatorAction copy = (HCombinatorAction) this.clone();
			copy.setLabel(copy.toString());
			copy.newListener();
			copy.setBounds(copy.getBounds().getCopy());
			copy.action_combinator = top_action;
			copy.protocol = null;
			copy.setActions(new ArrayList());
			copy.combinatorEntry = new HActionEntry(copy);
			copy.combinatorExit = new HActionExit(copy);
			
			Iterator old_actions = this.getActions().iterator();
			while (old_actions.hasNext()) {
				HAction a = (HAction) old_actions.next();
				copy.getActions().add(a.getCopy(copy));
			}
			
			
			
			
			return copy;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
		
	}
	
	void setActions(List actions) {
		this.actions = actions;
	}

	
	public final static String UNFOLD_ACTION = "unfold action";
	
	public HAction unfoldAction(HDoAction do_action) {
		
		HAction action;
				
		int i = actions.indexOf(do_action);
		
		this.removeAction(do_action);
		
		action = (HAction) do_action.getEncapsulatedAction();
		action.setCombinatorAction(do_action.getActionCombinator());
		actions.add(i,action);
		
		listeners.firePropertyChange(UNFOLD_ACTION,null,getBounds());
		
		return action;
	}
	
	public HDoAction foldAction(HAction action) {
		
		HDoAction do_action;
		
		int i = actions.indexOf(action);
		
		do_action = action.getEncapsulatingDoAction();
		do_action.setCombinatorAction(action.getActionCombinator());
		actions.set(i,do_action);
		
		listeners.firePropertyChange(UNFOLD_ACTION,null,getBounds());
		
		return do_action;
	}
	
	public final static String LIFT_ACTION = "lift action";
	
	public List liftAction(HCombinatorAction action) {
	
		List<HAction> actions = this.getActions();
		Iterator<HAction> as = ((ArrayList<HAction>)((ArrayList<HAction>)actions).clone()).iterator();
		List undo_info = new ArrayList();
		
		int i = 0;
		while (as.hasNext()) {
			HAction a = (HAction) as.next();
			if (a == action) {
				undo_info.add(new Integer(i));
				undo_info.add(action);
				removeAction(action);
				for (HAction inner_a : action.getActions()) {
					inner_a.setCombinatorAction(this);
					undo_info.add(inner_a);
					undo_info.add(inner_a.getBounds().getCopy());
					inner_a.getBounds().setLocation(inner_a.getBounds().getLocation().getTranslated(a.getBounds().getLocation()));
					this.addAction(i++,inner_a);
					//actions.add(i++,inner_a);
				}
				listeners.firePropertyChange(LIFT_ACTION,null,getBounds());
				return undo_info;
			}
			i++;
		}
		
		return undo_info;
	}
	
	public void unliftAction(List unlift_info) {
		
		Iterator ui = unlift_info.iterator();
		
		int pos = ((Integer) ui.next()).intValue();
		HCombinatorAction action = (HCombinatorAction) ui.next();
		
		while (ui.hasNext()) {
			HAction a = (HAction) ui.next();
			Rectangle bounds = (Rectangle) ui.next();
			a.setBounds(bounds);
			a.setCombinatorAction(action);
			removeAction(a);			
		}
		
		actions.add(pos,action);
		listeners.firePropertyChange(LIFT_ACTION,null,getBounds());
		
		return;
	}
	
	private static int mw = 10;
	private static int mh = 20;
	
	public void adjustBoundsToNewChild(HAction action) {

		if (this.getActions().size() == 1) {
			this.getBounds().setLocation(action.getBounds().getLocation().translate(-mw,-mh));
			this.getBounds().setSize(action.getBounds().getSize().expand(mw*2,mh*2));
			action.getBounds().setLocation(mw,mh);
		} else {
		
			int x1__ = this.getBounds().getTopLeft().x;
			int y1__ = this.getBounds().getTopLeft().y; 
			int x2__ = this.getBounds().getBottomRight().x;
			int y2__ = this.getBounds().getBottomRight().y;
			
			int x1_ = action.getBounds().getTopLeft().x;
			int y1_ = action.getBounds().getTopLeft().y; 
			int x2_ = action.getBounds().getBottomRight().x;
			int y2_ = action.getBounds().getBottomRight().y;
			
			int x1 = x1__ + mw < x1_ ? x1__ : x1_ - mw;
			int y1 = y1__ + mh < y1_ ? y1__ : y1_ - mh;
			int x2 = x2__ - mw > x2_ ? x2__ : x2_ + mw;
			int y2 = y2__ - mh > y2_ ? y2__ : y2_ + mh;
			
			int width  = x2 - x1;
			int height = y2 - y1;
			
			this.setBounds(new Rectangle(x1,y1,width,height));
			action.getBounds().translate(-x1,-y1);
			
			Iterator as = getActions().iterator();
			while (as.hasNext()) {
				HAction a = (HAction) as.next();
				if (a != action) {
					a.getBounds().translate(x1__- x1, y1__ - y1);
				}
			}
			
		}
		
		listeners.firePropertyChange(LIFT_ACTION,null,getBounds());
		
		
	}
	
	
	public void adjustBoundsToChildren() {
		
		Iterator as = getActions().iterator();
		while (as.hasNext()) {
			HAction a = (HAction) as.next();
			adjustBoundsToNewChild(a);
		}
		
	}
	
	public void sinalizeRefresh() {
		listeners.firePropertyChange(LIFT_ACTION,null,getBounds());
	}

	
	HActionEntry combinatorEntry = new HActionEntry(this);
	HActionExit combinatorExit = new HActionExit(this);
	
	public HActionEntry getCombinatorEntry() {
		  if (combinatorEntry == null) {
			  combinatorEntry = new HActionEntry(this);
		  }
	      return combinatorEntry;	
	}
	
	public HActionExit getCombinatorExit() {
		  if (combinatorExit == null) {
			  combinatorExit = new HActionExit(this);
		  }
	      return combinatorExit;	
	}
	
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		if (combinatorExit != null) 
		   combinatorExit.setLocation(this.getBounds().getBottom().getTranslated(0,-12));
		if (combinatorEntry != null)
		   combinatorEntry.setLocation(this.getBounds().getTop().getTranslated(0,12));
		
	}
	
	public final static String UPDATE_ACTIONS = "update actions";
	
	public void removeAction(HAction action) {
          this.getActions().remove(action);
    	  listeners.firePropertyChange(UPDATE_ACTIONS,null,getBounds());
	}
	
	public void replaceAction(HAction action1, HAction action2) {
		int i = this.getActions().indexOf(action1);
        this.getActions().set(i,action2);
  	    listeners.firePropertyChange(UPDATE_ACTIONS,null,getBounds());
	}
	
	/**
	 */
	public void addAction(HAction action) {
		actions.add(action);
		if (action.getActionCombinator() != this) {
			action.setCombinatorAction(this);
		}
		
   	    // listeners.firePropertyChange(UPDATE_ACTIONS,null,getBounds());
	}
	
	/**
	 */
	public void addAction(List<HAction> actions) {
		this.actions.addAll(actions);
		for (HAction action : actions) {
			if (action.getActionCombinator() != this) {
				action.setCombinatorAction(this);
			}
		}
   	    // listeners.firePropertyChange(UPDATE_ACTIONS,null,getBounds());
	}
	/**
	 */
	public void addAction(int i, HAction action) {
		if (actions.contains(action)) {
			actions.remove(action);
		}
 	    actions.add(i,action);
 	    if (action.getActionCombinator() != this) {
 	       action.setCombinatorAction(this);
 	    }
   	    // listeners.firePropertyChange(UPDATE_ACTIONS,null,getBounds());
	}
	
	
}
