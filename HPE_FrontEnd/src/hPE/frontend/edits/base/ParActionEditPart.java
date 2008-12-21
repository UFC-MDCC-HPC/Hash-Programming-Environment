package hPE.frontend.edits.base;

import hPE.frontend.figures.base.AltActionFigure;
import hPE.frontend.figures.base.ParActionFigure;
import hPE.model.protocol.kinds.activate.HAction;

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
