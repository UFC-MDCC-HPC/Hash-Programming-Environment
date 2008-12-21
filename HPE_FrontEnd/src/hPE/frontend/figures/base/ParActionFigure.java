package hPE.frontend.figures.base;

import org.eclipse.draw2d.ColorConstants;

public class ParActionFigure extends ActionFigure {

	
	public ParActionFigure() {
		super();
		this.setBackgroundColor(ColorConstants.yellow);
	    text = "PAR";
		if (repeat==0) this.setLabelText(text);
	           else this.setLabelText("REPEAT ".concat(text));
	}

}
