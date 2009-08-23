package hPE.frontend.base.figures;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;




public class ReplicatorFigure extends ConfigurationNodeFigure {

	private int factor = 0;
	
	public ReplicatorFigure() {
		super();		
	} 
	
	protected void drawFigure(Graphics g, Rectangle r) {
		
	//	if (hasPermutation) {
	//		g.setBackgroundColor(color);
	//	}
		if (lColor != null)
		dx = dy = (lColor.size()-1)*(-3);
		
		Rectangle rr = r;
		for (Color c : lColor) {
			g.setBackgroundColor(c);
			g.fillOval(rr);
			g.drawOval(rr);			
			rr = rr.getResized(-3, -3);
		}
			
		 
	}
	
	public void setFactor(int factor) {
		this.factor = factor;
	}
	
	private List<Color> lColor = null;
	
	public void addFusedReplicator(Color color) {
		if (lColor==null) lColor = new ArrayList<Color>();
	    this.lColor.add(color); 
	}
	
	public void clean() {
		lColor = null;
	}
	
}
	

