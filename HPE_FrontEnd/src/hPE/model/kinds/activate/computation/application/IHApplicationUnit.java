package hPE.model.kinds.activate.computation.application;

import hPE.model.kinds.activate.computation.IHComputationUnit;
import hPE.model.kinds.qualifier.architecture.HArchitectureUnit;

public interface IHApplicationUnit extends IHComputationUnit {

	public HArchitectureUnit getProcessor();
	
}
