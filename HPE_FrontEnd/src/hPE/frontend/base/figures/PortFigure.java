package hPE.frontend.base.figures;


import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FreeformLayout;

public abstract class PortFigure extends RectangleFigure {

	public PortFigure() {
		super();
		this.setBackgroundColor(ColorConstants.black);
		this.setLayoutManager(new FreeformLayout());
	
	}
	
	public abstract void paintFigure(Graphics g);
	
	private boolean isPrivate = false;
	
	protected boolean getPrivate() { return isPrivate; }
	
	
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

}
