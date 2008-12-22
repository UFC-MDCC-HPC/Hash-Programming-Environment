package hPE.frontend.base.edits;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.figures.AltActionFigure;
import hPE.frontend.base.figures.SeqActionFigure;
import hPE.frontend.kinds.activate.model.protocol.HAction;


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
