package hPE.frontend.kinds.base.edits;

import hPE.frontend.base.edits.InterfaceSliceEditPart;
import hPE.frontend.base.figures.InterfaceSliceFigure;
import hPE.frontend.base.model.HPort;
import hPE.frontend.kinds.base.model.HHasPortsInterfaceSlice;

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
