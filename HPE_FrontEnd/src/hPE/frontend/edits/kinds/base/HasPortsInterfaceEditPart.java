package hPE.frontend.edits.kinds.base;

import hPE.frontend.edits.base.InterfaceEditPart;
import hPE.frontend.figures.base.InterfaceFigure;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HPort;
import hPE.model.kinds.base.HHasPortsInterface;

import java.util.ArrayList;
import java.util.List;

public class HasPortsInterfaceEditPart<ModelType extends HHasPortsInterface,
                                       FigureType extends InterfaceFigure> 
             extends InterfaceEditPart<ModelType,FigureType> {

	public HasPortsInterfaceEditPart() {
		// TODO Auto-generated constructor stub
	}

	public List getModelChildren() { 
		
		List l = new ArrayList();
		List l1 = new ArrayList();
		
		ModelType i = (ModelType) getModel();

		List<HInterfaceSlice> slices = super.getModelChildren();
		
		l.addAll(slices);
		
		for (HInterfaceSlice s : slices) {
			for (HPort port : s.getPorts()) {
				if (!l.contains(port)) 
					l.add(port);
			}
		}
		
//		i.getPorts(l1, null, "", ".",1);
		
//		l.addAll(wrapPorts(l1));		
		
		return l;
	}	

	
}
