package hPE.frontend.base.figures;

import org.eclipse.draw2d.ColorConstants;

public class SeqActionFigure extends ActionFigure {

	public SeqActionFigure() {
		super();
		
		this.setBackgroundColor(ColorConstants.orange);
	    text = "SEQ";
		if (repeat==0) this.setLabelText(text);
	            else this.setLabelText("REPEAT ".concat(text));
		
		
	}

}
