package hPE.frontend.base.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.draw2d.Ellipse;

public class EntryFigure extends NodeFigure {

	public EntryFigure() {
		super();
		this.setBackgroundColor(ColorConstants.blue);
		
	}

	boolean is_open = false;
	
	public void setOpen(boolean is_open) {
		this.is_open = is_open;
	}
		
}
