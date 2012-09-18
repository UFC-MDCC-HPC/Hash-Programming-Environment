package hPE.frontend.kinds.activate.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import org.eclipse.draw2d.ChopboxAnchor;

import hPE.frontend.base.figures.ConfigurationNodeFigure;
import hPE.frontend.base.figures.FixedConnectionAnchor;

import java.util.ArrayList;
import java.util.List;

public class ActionFigure extends ConfigurationNodeFigure {

	Label label = new Label();

	protected String text = "?"; 
	
	public ActionFigure() {
		super();
		//this.setBounds(new Rectangle(100,100,300,300));
		this.setBackgroundColor(ColorConstants.lightGray);
		label.setLocation(new Point(10,10));
		label.setFont(new Font(null,"Arial",8,SWT.BOLD));
		this.setLabelText(text);
		add(label);
				
	}
	
	public void setLabelText(String text) {
		label.setText(text);
		Rectangle r = label.getTextBounds();
		//label.setBounds(r.expand(0, this.getBounds().width));
		label.setBounds(label.getTextBounds());
		

	}

	@Override
	protected void drawFigure(Graphics g, Rectangle r) 
	{
		   g.setLineStyle(SWT.LINE_DOT);
			
		   g.fillRectangle(r);
		   g.drawRectangle(r);
		
	}
	
	@Override
	public void setName(String the_name)
	{
		
	}
	
/*	protected int repeat = 0;
	
	
	
	public void setRepeat(int repeat) {
		this.repeat = repeat;	
        if (repeat>0) { 
        	setLabelText("REPEAT ".concat(text));
        	this.setLineWidth(3);
        }
        else setLabelText(text);
		
		for (int i=0;i<this.repeat;i++) {
			
			FixedConnectionAnchor anchor_start = new FixedConnectionAnchor(this);
			FixedConnectionAnchor anchor_end = new FixedConnectionAnchor(this);
			
			anchor_start.setOffsetH(0);
			anchor_start.setOffsetV(10+8*i);
			
			anchor_end.setOffsetH(0);
			anchor_end.setOffsetV(30+8*i);
			
		    this.repeat_anchors_start.add(anchor_start);
		    this.repeat_anchors_end.add(anchor_end);
		}
	}

	public FixedConnectionAnchor getConnectionAnchorRepeatExit(int i) {
				
		return (FixedConnectionAnchor) this.repeat_anchors_end.get(i);
		
	}
	
	public FixedConnectionAnchor getConnectionAnchorRepeatEnter(int i) {
		
		return (FixedConnectionAnchor) this.repeat_anchors_start.get(i);
		
	}
	
	public ChopboxAnchor getConnectionAnchorStart() {
		
		return new ChopboxAnchor(this);
		
	}
	
	public ChopboxAnchor getConnectionAnchorEnd() {
		
		return new ChopboxAnchor(this);
		
	}
	*/
}
