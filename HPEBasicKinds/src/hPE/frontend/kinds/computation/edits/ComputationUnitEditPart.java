package hPE.frontend.kinds.computation.edits;

import java.util.ArrayList;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.kinds.computation.figures.ComputationUnitFigure;
import hPE.frontend.kinds.computation.model.HComputationInterface;
import hPE.frontend.kinds.computation.model.IHComputationUnit;

public class ComputationUnitEditPart<ModelType extends IHComputationUnit, FigureType extends ComputationUnitFigure> extends UnitEditPart<ModelType,FigureType> {

	public ComputationUnitEditPart() {
		super();
	}

	protected IFigure createFigure() {
	      return new ComputationUnitFigure();
    }
	
	protected void refreshVisuals() {
		super.refreshVisuals();

		ModelType unit = (ModelType) getModel();
		FigureType unit_figure = (FigureType) getFigure();
		
		// HComputationInterface i = (HComputationInterface) unit.getInterface();
		
        //if (unit.getInterface() != null) {
        	//if (unit.getInterface() instanceof HInterface) {
               // unit_figure.setPorts(i.getPorts());
        	//} else
              // unit_figure.setPorts(unit.getInterface().getPublicPorts());
        		
        //} else {
        	// if (!unit_figure.getPorts().isEmpty())
          //      unit_figure.setPorts(new ArrayList());
        //}
		
	}
}
