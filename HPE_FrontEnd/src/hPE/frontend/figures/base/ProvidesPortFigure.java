package hPE.frontend.figures.base;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class ProvidesPortFigure extends PortFigure {

	public void paintFigure(Graphics g) {
		
		Rectangle s = this.getBounds().getCopy();
		g.fillOval(s.shrink(0,0));
		   
	}
		
}
	
	
	


