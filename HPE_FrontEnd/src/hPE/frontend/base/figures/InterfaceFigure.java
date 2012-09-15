package hPE.frontend.base.figures;

import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;




public class InterfaceFigure extends ConfigurationNodeFigure {

	
	public InterfaceFigure() {
		super();		
	} 
		
	protected void drawFigure(Graphics g, Rectangle r) {
		if (editable) g.setLineStyle(SWT.LINE_SOLID); 
			     else g.setLineStyle(SWT.LINE_DASH);
		g.setForegroundColor(this.getBackgroundColor());
		g.setLineWidth(2);
		g.drawRectangle(r);
	}

	private boolean editable = true;
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
}
	

