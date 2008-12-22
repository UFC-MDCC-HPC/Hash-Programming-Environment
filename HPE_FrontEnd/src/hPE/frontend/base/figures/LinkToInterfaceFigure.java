package hPE.frontend.base.figures;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.SWT;
import org.eclipse.draw2d.ColorConstants;


public class LinkToInterfaceFigure extends PolylineConnection {

	public LinkToInterfaceFigure() {
		super();
		
		this.setLineStyle(SWT.LINE_DOT);
		this.setForegroundColor(ColorConstants.lightGray);
		
		PolygonDecoration d = new PolygonDecoration();
		
		
		this.setTargetDecoration(d);
		
	}

}
