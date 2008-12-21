package hPE.frontend.figures.base;

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;


public class NodeFigure extends RectangleFigure {

	protected EllipseAnchor ConnectionAnchor;
	protected XYLayout layout;
	
	public NodeFigure() {
		layout = new XYLayout();
		setLayoutManager(layout);
		setBackgroundColor(ColorConstants.black);
		// setOpaque(false);
		ConnectionAnchor = new EllipseAnchor(this);
	}
	
	public EllipseAnchor getConnectionAnchor() {
		
		return ConnectionAnchor;
		
	}
	
	public void paintFigure(Graphics g) {
		
		Rectangle s = getBounds().getCopy().shrink(1,1);
 	    g.setLineStyle(SWT.LINE_SOLID);
		g.fillRectangle(s); 
		g.drawRectangle(s); 
	}
	
	}
