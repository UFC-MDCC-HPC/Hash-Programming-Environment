package hPE.frontend.base.edits;

import hPE.frontend.base.figures.AltActionFigure;
import hPE.frontend.base.figures.ParActionFigure;
import hPE.frontend.kinds.activate.model.protocol.HAction;

import org.eclipse.draw2d.IFigure;

public class ParActionEditPart extends CombinatorActionEditPart {

	public ParActionEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected IFigure createFigure() {
		ParActionFigure f = new ParActionFigure();
		f.setRepeat(((HAction) getModel()).getRepeatDepth());
		return f;
	}

}
