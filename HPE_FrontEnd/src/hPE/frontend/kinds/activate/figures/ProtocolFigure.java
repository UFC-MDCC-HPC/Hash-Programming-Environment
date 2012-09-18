package hPE.frontend.kinds.activate.figures;

import hPE.frontend.base.figures.ConfigurationNodeFigure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

public class ProtocolFigure extends ConfigurationNodeFigure {

	Label label = new Label();

	protected String text = "?";
	
	public ProtocolFigure() {
		super();
		//this.setBounds(new Rectangle(10,10,50,50));
		this.setBackgroundColor(ColorConstants.lightGray);
		label.setLocation(new Point(10,10));
		this.setLabelText(text);
		add(label);
		
	}

	public void setLabelText(String text) {
		label.setText(text);
		label.setFont(new Font(null,"Arial",8,SWT.BOLD));
		//label.setLocation(new Point(10,10));
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
	
}
