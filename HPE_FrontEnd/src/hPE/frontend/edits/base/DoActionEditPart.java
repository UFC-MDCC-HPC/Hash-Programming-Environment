package hPE.frontend.edits.base;

import hPE.frontend.figures.base.DoActionFigure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ColorConstants;

import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSlice;
import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HDoAction;

public class DoActionEditPart extends ActionEditPart {

	public DoActionEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		DoActionFigure f = new DoActionFigure();
		f.setRepeat(((HAction) getModel()).getRepeatDepth());
		return f;
	}
	
	public void refreshVisuals() {
		super.refreshVisuals();
		HInterfaceSlice s = (HInterfaceSlice)((HDoAction) getModel()).getSliceAbstraction();
		DoActionFigure f = (DoActionFigure) getFigure();
		f.setActivatedName(s.getName());
		f.setBackgroundColor(((HInterface)s.getInterface()).getColor());
		f.checkColor();
	}
	
	
}
