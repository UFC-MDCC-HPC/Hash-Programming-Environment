
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

	public LinkToReplicatorFigure(HEnumeratorComponent ec) {
		super();
		this.ec = ec;
		init();
	}
	

	public LinkToReplicatorFigure() {
		super();
		init();
	}
	
	protected void init() {
   		this.setLineStyle(SWT.LINE_DASH);
		this.setForegroundColor(ColorConstants.lightGray);
		
	}
	
	 public void paintFigure(Graphics g) {
               super.paintFigure(g);			
			
			
    		
    		
    		
    		// PolygonDecoration d = new PolygonDecoration();
    		
    		if (this.ec != null) {

	       		this.setLineWidth(2);
    			if (ec.getColor() != ColorConstants.white) {
    				this.setForegroundColor(ec.getColor());
    			}
    			
    			Label ff = new Label(this.ec.getNameWithParameters(true, true, true));
    			Font font = new Font(null, "Arial", 8, SWT.NORMAL);
    			ff.setFont(font); 
    			
    			Rectangle r = new Rectangle(0,0,50,50);
    			
    			g.setBackgroundColor(ColorConstants.black);
    			g.fillRectangle(r);
    			g.drawRectangle(r);
    		    			
    			//d.add(ff);
    			
    			this.setToolTip(ff);
    			
    		}
	} 

	 private HEnumeratorComponent ec = null;
	
	public HEnumeratorComponent getPermutation() {
		return ec;
	}
	
    public void setPermutation(HEnumeratorComponent ec) {
    	this.ec = ec;
    }
}
