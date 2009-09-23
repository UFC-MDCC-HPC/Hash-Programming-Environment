
package hPE.frontend.base.figures;

import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;


public class LinkToReplicatorFigure extends PolylineConnection {

	public LinkToReplicatorFigure() {
		super();
		init();
	}
	

	
	protected void init() {
   		this.setLineStyle(SWT.LINE_DASH);
		this.setForegroundColor(ColorConstants.lightGray);
		
	}
	

}
