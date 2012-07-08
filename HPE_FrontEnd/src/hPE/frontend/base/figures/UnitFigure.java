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
	
	private boolean is_multiple = false;	
	public void setMultiple(boolean hidden) { this.is_multiple = hidden; }
	protected boolean isMultiple() { return is_multiple;}

	protected void drawFigure(Graphics g, Rectangle r0) {
			
		if (getHidden()) {
		   g.setLineStyle(SWT.LINE_DOT);
		   // g.setAlpha(100);
		} else {
		   g.setLineStyle(SWT.LINE_SOLID);
		   //g.setAlpha(255);
		}
		
		if (!this.isMultiple())
		{
		  g.fillRectangle(r0);
		  g.drawRectangle(r0);
		} 
		else if (this.isMultiple()) 
		{
			Rectangle r1 = r0.resize(-6,-6).translate(+6,0);
			g.fillRectangle(r1); g.drawRectangle(r1);
			Rectangle r2 = r1.translate(-3,+3);
			g.fillRectangle(r2); g.drawRectangle(r2);
			Rectangle r3 = r2.translate(-3,+3);
			g.fillRectangle(r3); g.drawRectangle(r3);
        }		
		
	}
	
	
	
}
	

