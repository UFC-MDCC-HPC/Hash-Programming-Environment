package hPE.frontend.base.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

public class DoActionFigure extends ActionFigure {

	Label sa_name = new Label();
	
	public DoActionFigure() {
		super();
		this.setBackgroundColor(ColorConstants.lightGray);
	    text = "DO";
		if (repeat==0) this.setLabelText(text);
	            else  this.setLabelText("REPEAT ".concat(text));
		add(sa_name);
		sa_name.setForegroundColor(ColorConstants.yellow);
	}

	public void checkColor() {
		if (getBackgroundColor().getRGB().equals(sa_name.getForegroundColor().getRGB())) {
			sa_name.setForegroundColor(ColorConstants.black);
		}
	}
	
	public void setActivatedName(String text) {
		sa_name.setText(text);
		sa_name.setFont(new Font(null,"Arial",8,SWT.ITALIC));
		sa_name.setBounds(this.getBounds());
	}
	
}
