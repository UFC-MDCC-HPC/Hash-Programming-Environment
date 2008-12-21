package hPE.frontend.codegen.base.syntaxtree;

import hPE.model.base.*;
import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HDoAction;
import hPE.model.protocol.kinds.activate.HParAction;
import hPE.model.protocol.kinds.activate.HSeqAction;
import hPE.model.protocol.kinds.activate.HSkipAction;

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
