package hPE.frontend.kinds.activate.figures;

import hPE.frontend.base.figures.ConfigurationNodeFigure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

public class NullProtocolFigure extends ConfigurationNodeFigure {

	Label label = new Label();

	protected String text = "right-click to configure a protocol ..."; 
	
	public NullProtocolFigure() {
		super();
		this.setBounds(new Rectangle(100,100,300,50));
		this.setBackgroundColor(ColorConstants.yellow);
		label.setLocation(new Point(10,10));		
		label.setFont(new Font(null,"Arial",8,SWT.BOLD));
		this.setLabelText(text);
		add(label);
				
	}
	
	public void setLabelText(String text) {
		Rectangle r = label.getTextBounds();
		//label.setBounds(r.expand(0, this.getBounds().width));
		label.setBounds(this.getBounds());
		label.setText(text);
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
