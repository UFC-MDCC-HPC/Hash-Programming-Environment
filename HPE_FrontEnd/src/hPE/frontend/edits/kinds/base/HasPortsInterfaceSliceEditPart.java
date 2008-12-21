package hPE.frontend.edits.kinds.base;

import hPE.frontend.edits.base.InterfaceSliceEditPart;
import hPE.frontend.figures.base.InterfaceSliceFigure;
import hPE.model.base.HPort;
import hPE.model.kinds.base.HHasPortsInterfaceSlice;

import java.util.List;

public class HasPortsInterfaceSliceEditPart<ModelType extends HHasPortsInterfaceSlice, 
                                            FigureType extends InterfaceSliceFigure> 
             extends InterfaceSliceEditPart<ModelType,FigureType> {

	public HasPortsInterfaceSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List getModelSourceConnections() {
		
        List r = super.getModelSourceConnections();
        
		ModelType slice = (ModelType) getModel();
		
/*		List<IHProvidesPort> ps = new ArrayList<IHProvidesPort>();
		slice.getPorts(ps, null,"", ".",1);
				
		for (IHProvidesPort s : ps) {
			r.add("PortOwnership.".concat(slice.toString()).concat(s.toString()));
			s.addPortOwner(slice);			
		} */
		
		for (HPort port : slice.getPorts()) {
			r.add("PortOwnership.".concat(slice.toString()).concat(port.toString()));
		}
		
		return r;
	}
	
}
