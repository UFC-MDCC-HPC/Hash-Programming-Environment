package hPE.frontend.kinds.base.edits;

import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.figures.InterfaceFigure;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HPort;
import hPE.frontend.base.model.HVisualElement;
import hPE.frontend.kinds.base.model.HHasPortsInterface;

import java.util.ArrayList;
import java.util.List;

public class HasPortsInterfaceEditPart<ModelType extends HHasPortsInterface,
                                       FigureType extends InterfaceFigure> 
             extends InterfaceEditPart<ModelType,FigureType> {

	public HasPortsInterfaceEditPart() {
		// TODO Auto-generated constructor stub
	}

	public List getModelChildren() { 
		
		List l = new ArrayList<HVisualElement>();
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
