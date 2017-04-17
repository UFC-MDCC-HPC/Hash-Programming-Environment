package hPE.frontend.base.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

public class EntryFigure extends NodeFigure {

	Label label = new Label();

	public EntryFigure() {
		super();
		this.setBackgroundColor(ColorConstants.blue);
		add(label);
	}

	public void setLabelText(String text) {
		label.setText(text);
		label.setFont(new Font(null,"Arial",6,SWT.BOLD));
		label.setBounds(this.getBounds());
	}

	boolean is_multiple = false;
	
	public void setMultiple(boolean is_open) {
		this.is_multiple = is_open;
	}
		
	public void paintFigure(Graphics g) {
		if (!is_multiple)
		{
		   super.paintFigure(g);
		} 
		else 
		{
			Rectangle r0 = getBounds().getCopy().shrink(1,1);
	 	    g.setLineStyle(SWT.LINE_SOLID);
			Rectangle r1 = r0.resize(-4,-4).translate(+4,0);
			g.fillRectangle(r1); g.drawRectangle(r1);
			Rectangle r2 = r1.translate(-2,+2);
			g.fillRectangle(r2); g.drawRectangle(r2);
			Rectangle r3 = r2.translate(-2,+2);
			g.fillRectangle(r3); g.drawRectangle(r3);
		}
	}
		
}
