package hPE.frontend.base.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import hPE.frontend.base.model.HInterface;

import org.eclipse.swt.SWT;


public class UnitFigure extends ConfigurationNodeFigure {

	
	public UnitFigure() {
		super();
		
	}
	
	private boolean hidden = false;
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	protected boolean getHidden() {
		return hidden;
	}
	
	protected void drawFigure(Graphics g, Rectangle r) {
			
		if (getHidden()) {
		   g.setLineStyle(SWT.LINE_DOT);
		   // g.setAlpha(100);
		} else {
		   g.setLineStyle(SWT.LINE_SOLID);
		   //g.setAlpha(255);
		}
		
		g.fillRectangle(r);
		g.drawRectangle(r);
	}
	
	
	
}
	

