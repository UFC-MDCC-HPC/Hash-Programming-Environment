package hPE.frontend.kinds.application.model;

import hPE.frontend.kinds.computation.model.IHComputationUnit;
import hPE.frontend.kinds.platform.model.HPlatformUnit;

public interface IHApplicationUnit extends IHComputationUnit {

	public HPlatformUnit getProcessor();
	
}
