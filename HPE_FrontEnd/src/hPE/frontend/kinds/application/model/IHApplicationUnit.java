package hPE.frontend.kinds.application.model;

import hPE.frontend.kinds.architecture.model.HArchitectureUnit;
import hPE.frontend.kinds.computation.model.IHComputationUnit;

public interface IHApplicationUnit extends IHComputationUnit {

	public HArchitectureUnit getProcessor();
	
}
