package hPE.frontend.figures.base;



import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.TextFlow;

public class ComponentFigure extends ConfigurationNodeFigure {

	public ComponentFigure() {
		super();
		
	}	
	
	protected void drawFigure(Graphics g, Rectangle r) {
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
			g.fillOval(r);
			g.drawOval(r);
       } else {
    	    //g.fillGradient(r, true);
    	    g.drawRoundRectangle(r, 40, 40);
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
