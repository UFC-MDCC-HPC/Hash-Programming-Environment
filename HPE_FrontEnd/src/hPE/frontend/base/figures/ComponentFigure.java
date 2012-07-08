package hPE.frontend.base.figures;



import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.TextFlow;

public class ComponentFigure extends ConfigurationNodeFigure {

	public ComponentFigure() {
		super();
		
	}	
	
	private boolean is_multiple = false;	
	public void setMultiple(boolean hidden) { this.is_multiple = hidden; }
	protected boolean isMultiple() { return is_multiple;}

	protected void drawFigure(Graphics g, Rectangle r0) {
        if (isAbstract()) {
//			g.setAlpha(100);
			g.setLineStyle(SWT.LINE_DOT);
			g.setLineWidth(2);			
        } else {
//		    g.setAlpha(255);
		    g.setLineStyle(SWT.LINE_SOLID);
			g.setLineWidth(1);			
        }
        
        if (this.isSuperType) {
        	g.setLineWidth(2);
        }
        
        if (this.isExposed) {
        	g.setLineStyle(SWT.LINE_SOLID);
        } else {
        	g.setLineStyle(SWT.LINE_DASH);
        }
        
       if (!isPort) {
    	   if (!this.isMultiple()) 
    	   {
    		    g.fillOval(r0); g.drawOval(r0);
    	   } else
    	   {
    		   Rectangle r1 = r0.resize(-6,-6).translate(+6,0);
    		   g.fillOval(r1); g.drawOval(r1);
    		   Rectangle r2 = r1.translate(-3,+3);
    		   g.fillOval(r2); g.drawOval(r2);
    		   Rectangle r3 = r2.translate(-3,+3);
    		   g.fillOval(r3); g.drawOval(r3);
    	   }
       } else {
    	    //g.fillGradient(r, true);
    	   if (!this.isMultiple()) 
    	   {
    		   g.drawRoundRectangle(r0, 40, 40);
    	   }
    	   else 
    	   {
    		   Rectangle r1 = r0.resize(-6,-6).translate(+6,0);
    		   g.drawRoundRectangle(r1, 40, 40);
    		   Rectangle r2 = r1.translate(-3,+3);
    		   g.drawRoundRectangle(r2, 40, 40);
    		   Rectangle r3 = r2.translate(-3,+3);
    		   g.drawRoundRectangle(r3, 40, 40);
    	   }
       }
       
		
	}

	private boolean isPort = false;
	
	private boolean isParameter = false;
	
    public void setAbstract() {
    	isParameter = true;
    }
	    
    public void setNonAbstract() {
    	isParameter = false;
    }    
	    
    protected boolean isAbstract() {
     	return isParameter;
    }	
    
	private boolean isRecursion = false;
	
    
    public void setRecursive(boolean isRecursion) {
    	if (!this.isRecursion && isRecursion) {
    		this.getTextFlow().setForegroundColor(ColorConstants.red);
    	} else if (this.isRecursion && !isRecursion) {
    		this.getTextFlow().setForegroundColor(ColorConstants.black);
    	}
    	this.isRecursion = isRecursion;
    }
    
    public boolean isRecursive() {
    	return this.isRecursion;
    }

    private boolean isSuperType = false;
    
    public void setIsSuperType(boolean isSuperType) {
    	this.isSuperType = isSuperType;
    }
	
    private boolean isExposed = false;
    
    public void setExposed(boolean isExposed) {
    	this.isExposed = isExposed;
    }

	public void setPort(boolean isPort) {
		this.isPort = isPort;
	}

	public boolean isPort() {
		return isPort;
	}
       
//	private boolean existentialType = false;
	
// TODO: EXISTENTIAL TYPE
//    public void setExistentialType(boolean existentialType) {
//    	this.existentialType = existentialType;
//    }
	    	    
	// TODO: EXISTENTIAL TYPE
//    protected boolean isExistentialType() {
//     	return this.existentialType;
//    }	
}
