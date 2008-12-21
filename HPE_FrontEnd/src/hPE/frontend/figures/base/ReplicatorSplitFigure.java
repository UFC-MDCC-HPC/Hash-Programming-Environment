package hPE.frontend.figures.base;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.XYLayout;

public class ReplicatorSplitFigure extends Ellipse {

	protected EllipseAnchor ConnectionAnchor;
	protected XYLayout layout;
	
	public ReplicatorSplitFigure() {
		super();
		
		layout = new XYLayout();
		setLayoutManager(layout);
		setBackgroundColor(ColorConstants.black);		
		
		ConnectionAnchor = new EllipseAnchor(this);
	}

	public EllipseAnchor getConnectionAnchor() {
		
		return ConnectionAnchor;
		
	}
}
