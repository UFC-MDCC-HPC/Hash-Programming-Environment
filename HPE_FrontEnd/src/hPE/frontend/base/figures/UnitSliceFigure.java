package hPE.frontend.base.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;



public class UnitSliceFigure extends NodeFigure {

	Label label = new Label();

	public UnitSliceFigure() {
		super();
		add(label);
	}
	
	public void setLabelText(String text) {
		label.setText(text);
		label.setFont(new Font(null,"Arial",6,SWT.BOLD));
		label.setBounds(this.getBounds());
	}
	
}
	

