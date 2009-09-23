package hPE.frontend.base.figures;

import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

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
	
	 public void paintFigure(Graphics g) {
        super.paintFigure(g);			
	} 	
}
