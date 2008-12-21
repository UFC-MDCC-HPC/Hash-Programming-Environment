package hPE.model.protocol.kinds.activate;

import java.io.Serializable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hPE.model.interfaces.IActionCombinatorSeq;

public class HSeqAction extends hPE.model.protocol.kinds.activate.HCombinatorAction  
       implements Serializable, IActionCombinatorSeq {

	static final long serialVersionUID = 1;


	
	public HSeqAction(String label) {
		super(label);
	}

	public HSeqAction(String label, HProtocol protocol) {
		super(label, protocol);
	}

	/**
	 */
	public HSeqAction(String label, HCombinatorAction action_combinator) {
		super(label, action_combinator);
	}
	
/*	
	
	protected int default_hmargin = 20;
	protected int default_sep = 10;
	protected int default_vmargin = default_sep;
	
	public Rectangle nextActionBounds() {
		
		int i = this.getActions().size();
		
		Point p = new Point(default_vmargin + i*(default_dimension.height + default_sep), default_hmargin);
		
		return new Rectangle(p, default_dimension);
	}
	
	*/

	public Object getInnerActionTargetConnectionID(HAction action) {
		
		Iterator as = this.getActions().iterator();		
		HAction a, old_a;
		
		if (as.hasNext()) {
			a = (HAction) as.next();
			if (a==action) return this.getLabel().concat(".BEGIN.").concat(a.getLabel());	
			while (as.hasNext()) {
				old_a = a;
				a = (HAction) as.next();
				if (a==action) return old_a.getLabel().concat(".SEQ.").concat(a.getLabel());
			}
		}
		
		return null;
	}
	
	public Object getInnerActionSourceConnectionID(HAction action) {
		
		HAction a;
		Iterator as = this.getActions().iterator();		
		while (as.hasNext()) {
			a = (HAction) as.next();
			if (a==action) {
				if (as.hasNext()) { 
					HAction next_a = (HAction) as.next();
					return a.getLabel().concat(".SEQ.").concat(next_a.getLabel());
				} else 
					return a.getLabel().concat(".END.").concat(this.getLabel());
				
				
			}
		}
		
		return null;
	}
	
	public List getEntryConnectionIDs() {
		   List s = new ArrayList();
    	   if (!getActions().isEmpty()) {
				HAction a = (HAction) this.getActions().get(0);
		        s.add(this.getInnerActionTargetConnectionID(a));
    	   }
	       return s;
		}
		
	public List getExitConnectionIDs() {
        List s = new ArrayList();
		if (!getActions().isEmpty()) {
		   int n = this.getActions().size();
		   HAction a = (HAction) this.getActions().get(n-1);
		   s.add(this.getInnerActionSourceConnectionID(a));
		}
		return s;
	}

	private int sep_x = 10;
	private int sep_y = 20;
	
	public void organizeAction() {
		
		Iterator as = getActions().iterator();
		
		int x = sep_x;
		int y = sep_y;
		int width = 0;
		
		while (as.hasNext()) {			
			HAction a = (HAction) as.next();
			a.organizeAction();
			Rectangle b = a.getBounds().getCopy();
			b.setLocation(x,y);
			a.setBounds(b);
			y += b.height + sep_y;
			width = width > b.width ? width : b.width;
		}
		this.setBounds(new Rectangle(this.getBounds().getLocation(),new Dimension(width + sep_x*2,y)));
     }
		
	
	
}
