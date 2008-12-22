package hPE.frontend.kinds.qualifier.edits;

import java.util.List;

import hPE.frontend.base.edits.InterfaceSliceEditPart;
import hPE.frontend.kinds.base.edits.HasPortsInterfaceSliceEditPart;
import hPE.frontend.kinds.data.model.HDataInterfaceSlice;
import hPE.frontend.kinds.qualifier.figures.QualifierInterfaceSliceFigure;
import hPE.frontend.kinds.qualifier.model.HQualifierInterfaceSlice;

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
