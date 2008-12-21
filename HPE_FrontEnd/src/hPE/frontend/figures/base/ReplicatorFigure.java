package hPE.frontend.figures.base;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;




public class ReplicatorFigure extends ConfigurationNodeFigure {

	private int factor = 0;
	
	public ReplicatorFigure() {
		super();		
	} 
	
	protected void drawFigure(Graphics g, Rectangle r) {
		
		g.fillOval(r);
		g.drawOval(r);
		 
	}
	
	public void setFactor(int factor) {
		this.factor = factor;
	}
	
	
}
	

