package hPE.frontend.figures.base;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import org.eclipse.draw2d.ChopboxAnchor;
import java.util.ArrayList;
import java.util.List;

public class ActionFigure extends RectangleFigure {

	Label label = new Label();

	protected String text = "?"; 
	
	List repeat_anchors_start = new ArrayList();
	List repeat_anchors_end = new ArrayList();
	
	public ActionFigure() {
		super();
		this.setBackgroundColor(ColorConstants.lightGray);
		label.setLocation(new Point(10,10));
		this.setLabelText(text);
		add(label);
				
	}
	
	protected void setLabelText(String text) {
		label.setText(text);
		label.setFont(new Font(null,"Arial",8,SWT.BOLD));
		label.setBounds(label.getTextBounds());
	}
	
	protected int repeat = 0;
	
	
	
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
	
}
