package hPE.frontend.edits.kinds.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.base.InterfaceEditPart;
import hPE.frontend.edits.kinds.base.HasPortsInterfaceEditPart;
import hPE.frontend.figures.kinds.data.DataInterfaceFigure;
import hPE.model.base.HLinkToInterface;
import hPE.model.kinds.activate.HActivateInterface;
import hPE.model.kinds.data.HDataInterface;


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
