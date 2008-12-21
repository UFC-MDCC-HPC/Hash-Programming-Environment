package hPE.frontend.figures.base;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;


public abstract class ConfigurationNodeFigure extends Figure implements INameEditableFigure {

    private TextFlow name = new TextFlow();
	
    private FlowPage flowPage;
    
	protected EllipseAnchor ConnectionAnchor;
    
    
	public ConfigurationNodeFigure() {
		super();
		ConnectionAnchor = new EllipseAnchor(this);
			
		/* BEGIN edit label */		
		flowPage = new FlowPage();
		// flowPage.setHorizontalAligment(PositionConstants.CENTER);		
		
		name.setLayoutManager(new ParagraphTextLayout(name, ParagraphTextLayout.WORD_WRAP_SOFT));
				
		flowPage.add(name);
		/* END edit label */
		
		this.add(flowPage);
		name.setFocusTraversable(true);
		this.setBackgroundColor(ColorConstants.white);
		
	}

	protected FlowPage getFlowPage() {
		return flowPage;
	}
	
	protected TextFlow getTextFlow() {
		return name;
	}
	
	 protected void paintFigure(Graphics g) {
		Rectangle r = getBounds().getCopy();
		r.shrink(1,1);
		
		drawFigure(g,r);
		
	} 
		
	protected abstract void drawFigure(Graphics g, Rectangle r); 
	 
	public void setName(String the_name) {
		Label aux = new Label(the_name);
		aux.setFont(name.getFont());
		
		int nOfLines = ((aux.getTextBounds().width) / (this.getBounds().width)) + 1;

		int sy = (this.getBounds().height - (aux.getTextBounds().height)*nOfLines)/2;
		
		int sx = (this.getBounds().width - aux.getTextBounds().width)/2;
		
		sx = sx > 0 ? sx : 10;
		sy = sy > 0 ? sy : 10;
		
	    if (aux.getTextBounds() != null) flowPage.setBounds(this.getBounds().getCopy().shrink(sx,sy));
		
		int x = sx == 0 ? flowPage.getLocation().x + 10 : flowPage.getLocation().x;
		int y = sy == 0 ? flowPage.getLocation().y + 10 : flowPage.getLocation().y;

	//	flowPage.setLocation(new Point(x,y));
		name.setText(the_name);
	}
	
	public EllipseAnchor getConnectionAnchor() {
		
		return ConnectionAnchor;
		
	}
	
	public String getName() {
	   return name.getText();	
	}
	
	
}
