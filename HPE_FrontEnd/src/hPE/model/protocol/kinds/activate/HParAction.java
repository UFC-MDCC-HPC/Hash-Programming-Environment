package hPE.model.protocol.kinds.activate;

import java.io.Serializable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hPE.model.interfaces.IActionCombinatorPar;

public class HParAction extends hPE.model.protocol.kinds.activate.HCombinatorAction  implements Serializable, IActionCombinatorPar {

	static final long serialVersionUID = 1;
	
	/**
	 */
	public HParAction(String label) {
		super(label);
	}

	public HParAction(String label, HProtocol protocol) {
		super(label, protocol);
	}
	/**
	 */
	public HParAction(String label, HCombinatorAction action_combinator) {
		super(label, action_combinator);
	}

/*	
	protected int default_hmargin = 10;
	protected int default_sep     = 5;
	protected int default_vmargin = 30;
	
	public Rectangle nextActionBounds() {
		
		int i = this.getActions().size();
		
		Point p = new Point(default_hmargin + i*(default_dimension.width + default_sep), default_vmargin);
		
		return new Rectangle(p, default_dimension);
	}
	
	public Rectangle adjustToFitNextAction () {
		
		
		return new Rectangle();
	}
	*/
	
	
	public Object getInnerActionTargetConnectionID(HAction action) {
		
		String l = this.getLabel().concat(".BEGIN");
		
		Iterator as = this.getActions().iterator();
		int i = 0;
		while (as.hasNext()) {
			HAction a = (HAction) as.next();
			if (a==action) return l.concat(a.getLabel() /* (new Integer(i)).toString() */);
			i++;
		}
		
		return l;
	}
	
	public Object getInnerActionSourceConnectionID(HAction action) {
		
		String l = this.getLabel().concat(".END");
		
		Iterator as = this.getActions().iterator();
		int i = 0;
		while (as.hasNext()) {
			HAction a = (HAction) as.next();
			if (a==action) return l.concat(a.getLabel() /*(new Integer(i)).toString() */);
			i++;
		}
		
		return l;
	}
	
	public List getEntryConnectionIDs() {
		   Iterator as = this.getActions().iterator();
		   List s = new ArrayList();
		   while (as.hasNext()) {
			   HAction a = (HAction) as.next();
			   s.add(this.getInnerActionTargetConnectionID(a));
		   }
	       return s;
	}
		
	public List getExitConnectionIDs() {
		   Iterator as = this.getActions().iterator();
		   List s = new ArrayList();
		   while (as.hasNext()) {
			   HAction a = (HAction) as.next();
			   s.add(this.getInnerActionSourceConnectionID(a));
		   }
	       return s;
	}
	
	private int sep_x = 10;
	private int sep_y = 30;
	
	public void organizeAction() {
		
		Iterator as = getActions().iterator();
		
		int x = sep_x;
		int y = sep_y;
		int height = 0;
		
		while (as.hasNext()) {			
			HAction a = (HAction) as.next();
			a.organizeAction();
			Rectangle b = a.getBounds().getCopy();
			b.setLocation(x,y);
			a.setBounds(b);
			x += b.width + sep_x;
			height = height > b.height ? height : b.height;
		}
		this.setBounds(new Rectangle(this.getBounds().getLocation(),new Dimension(x,height+sep_y*2)));
     }

}
