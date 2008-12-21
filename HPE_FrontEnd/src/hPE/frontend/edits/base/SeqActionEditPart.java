package hPE.frontend.edits.base;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.figures.base.AltActionFigure;
import hPE.frontend.figures.base.SeqActionFigure;
import hPE.model.protocol.kinds.activate.HAction;


public class SeqActionEditPart extends CombinatorActionEditPart {

	public SeqActionEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		SeqActionFigure f = new SeqActionFigure();
		f.setRepeat(((HAction) getModel()).getRepeatDepth());
		return f;
	}
	
}
