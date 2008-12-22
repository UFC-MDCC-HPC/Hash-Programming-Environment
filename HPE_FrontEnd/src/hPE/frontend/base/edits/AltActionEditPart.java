package hPE.frontend.base.edits;

import hPE.frontend.base.figures.AltActionFigure;
import hPE.frontend.base.figures.DoActionFigure;
import hPE.frontend.kinds.activate.model.protocol.HAction;

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
