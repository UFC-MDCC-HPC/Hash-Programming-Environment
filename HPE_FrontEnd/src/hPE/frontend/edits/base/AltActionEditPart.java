package hPE.frontend.edits.base;

import hPE.frontend.figures.base.AltActionFigure;
import hPE.frontend.figures.base.DoActionFigure;
import hPE.model.protocol.kinds.activate.HAction;

import org.eclipse.draw2d.IFigure;

public class AltActionEditPart extends CombinatorActionEditPart {

	public AltActionEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		AltActionFigure f = new AltActionFigure();
		f.setRepeat(((HAction) getModel()).getRepeatDepth());
		return f;
	}
	
}
