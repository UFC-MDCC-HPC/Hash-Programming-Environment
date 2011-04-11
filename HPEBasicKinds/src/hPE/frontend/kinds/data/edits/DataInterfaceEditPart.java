package hPE.frontend.kinds.data.edits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.base.edits.HasPortsInterfaceEditPart;
import hPE.frontend.kinds.data.figures.DataInterfaceFigure;
import hPE.frontend.kinds.data.model.HDataInterface;


public class DataInterfaceEditPart<ModelType extends HDataInterface, 
                                   FigureType extends DataInterfaceFigure> 
                  extends HasPortsInterfaceEditPart<ModelType,FigureType> {

	public DataInterfaceEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new DataInterfaceFigure();
	}


}
