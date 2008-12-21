package hPE.frontend.figures.kinds.data;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import hPE.frontend.figures.base.ComponentFigure;

public class DataComponentFigure extends ComponentFigure {

	public DataComponentFigure() {
		super();
	}

	protected void drawFigure(Graphics g, Rectangle r) {
        super.drawFigure(g,r);
		// g.fillOval(r);
		//g.drawOval(r.shrink(3,3));
	}

}
