package hPE.frontend.base.edits;

import hPE.frontend.base.figures.DoActionFigure;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ColorConstants;


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
