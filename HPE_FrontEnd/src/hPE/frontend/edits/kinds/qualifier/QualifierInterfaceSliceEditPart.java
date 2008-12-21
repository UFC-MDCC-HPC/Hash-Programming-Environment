package hPE.frontend.edits.kinds.qualifier;

import java.util.List;

import hPE.frontend.edits.base.InterfaceSliceEditPart;
import hPE.frontend.edits.kinds.base.HasPortsInterfaceSliceEditPart;
import hPE.frontend.figures.kinds.qualifier.QualifierInterfaceSliceFigure;
import hPE.model.kinds.data.HDataInterfaceSlice;
import hPE.model.kinds.qualifier.HQualifierInterfaceSlice;

public class QualifierInterfaceSliceEditPart<ModelType extends HQualifierInterfaceSlice,
FigureType extends QualifierInterfaceSliceFigure> extends HasPortsInterfaceSliceEditPart<ModelType,FigureType> {

	public QualifierInterfaceSliceEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

/*	public List getModelSourceConnections() {
	     List r = super.getModelSourceConnections();	
		 	
	     HQualifierInterfaceSlice s = (HQualifierInterfaceSlice) this.getModel();
	     
	     r.add("PortOwnership.".concat(s.toString()).concat(s.toString()));
	     s.addPortOwner(s);
	     
	     return r;
	
	} */
}
