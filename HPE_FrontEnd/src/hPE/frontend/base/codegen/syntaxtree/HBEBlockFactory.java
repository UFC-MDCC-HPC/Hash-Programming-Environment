package hPE.frontend.base.codegen.syntaxtree;

import hPE.frontend.base.model.*;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;
import hPE.frontend.kinds.activate.model.protocol.HSkipAction;

public class HBEBlockFactory {

	public HBEBlockFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public static HBECommandBlock newCommandBlock(HAction action) {
		
		HBECommandBlock b = null;
		
		if (action instanceof HSeqAction) {
		   	b = new HBESequentialBlock();
		} else if (action instanceof HParAction) {
		   	b = new HBEConcurrentBlock();
		} else if (action instanceof HDoAction) {
		   	b = new HBEProcedureCall();
		} else if (action instanceof HSkipAction) {
			b = new HBESkipCommand();
		}
		
		return b;
		
	}
	
}
