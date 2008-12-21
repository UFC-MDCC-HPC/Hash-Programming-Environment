
package hPE.frontend.figures.base;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.SWT;
import org.eclipse.draw2d.ColorConstants;


public class LinkToReplicatorFigure extends PolylineConnection {

	public LinkToReplicatorFigure() {
		super();
		
		this.setLineStyle(SWT.LINE_DASH);
		this.setForegroundColor(ColorConstants.lightGray);
		
		PolygonDecoration d = new PolygonDecoration();
		// this.setTargetDecoration(d);
		
		
		
	}
	
	
	

}
