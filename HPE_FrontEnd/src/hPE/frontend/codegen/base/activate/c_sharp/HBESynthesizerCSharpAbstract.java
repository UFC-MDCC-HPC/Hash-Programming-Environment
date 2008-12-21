package hPE.frontend.codegen.base.activate.c_sharp;

import hPE.frontend.codegen.base.c_sharp.HBESourceVersionCSharp;
import hPE.frontend.codegen.syntaxtree.HBECommandBlock;
import hPE.frontend.codegen.syntaxtree.HBEConcurrentBlock;
import hPE.frontend.codegen.syntaxtree.HBEConditionBranch;
import hPE.frontend.codegen.syntaxtree.HBEProcedure;
import hPE.frontend.codegen.syntaxtree.HBEProcedureCall;
import hPE.frontend.codegen.syntaxtree.HBERepeatTestBranch;
import hPE.frontend.codegen.syntaxtree.HBESequentialBlock;
import hPE.frontend.codegen.syntaxtree.HBESimpleTestBranch;
import hPE.frontend.codegen.syntaxtree.HBESkipCommand;
import hPE.frontend.codegen.syntaxtree.HBESyntaxTree;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSlice;
import hPE.model.kinds.activate.HActivateInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;





public class HBESynthesizerCSharpAbstract extends hPE.frontend.codegen.base.c_sharp.HBESynthesizerCSharpAbstract {

	public HBESynthesizerCSharpAbstract() {
		super();
	}
	    
	private HBESyntaxTree p2p = null;
	
	
	private void fillActivationSlices(HActivateInterface i, Set<Entry<HInterface,HBEProcedureCall>> activations) {
		List<HInterfaceSlice> slices = null;
				
        for (Entry<HInterface,HBEProcedureCall> activation : activations) {
        	HBEProcedureCall call = activation.getValue();
        	if (call!=null && !call.getActivateSlice().isInerited()) {
	        	HInterface icall = activation.getKey();
				String sliceTypeName = icall.getName(false,true);
				if (theSlices.containsKey(sliceTypeName)) {
					slices = theSlices.get(sliceTypeName);
				} else {
					slices = new ArrayList<HInterfaceSlice>(); 
					theSlices.put(sliceTypeName, slices);
				}
				slices.add(call.getActivateSlice());
        	}
		}

	}	
	public HBESourceVersionCSharp synthesize(HActivateInterface i, String versionID) {

		
		this.setIsSubclass(i, versionID);
		
        return super.synthesize(i,versionID);
        		    
	}

	private String firstUpper(String s) {
		String fl = s.substring(0, 1).toUpperCase();
		
		return fl + s.substring(1);
	}


	private String translateBlockToC(int l, HBECommandBlock block) {

		String programText = "";
		boolean hasBranch = false;
		
		HBEConditionBranch branch = block.getBranch();
		if (branch != null) {
		   if (branch instanceof HBESimpleTestBranch) {
			   programText = programText.concat(tabs(l)).concat("if (");
			   
			   programText = programText.concat(") ");
		   } else if (branch instanceof HBERepeatTestBranch) {
			   programText = programText.concat(tabs(l)).concat("while (");
			   
			   programText = programText.concat(") ");
		   }
		   hasBranch = true;
		}
		
		
		if (block instanceof HBESequentialBlock) {
			HBESequentialBlock sBlock = (HBESequentialBlock) block;
			int numberOfBlocks = sBlock.getBlocks().size();
			int ll = l;
			if ( !((l==1) && (!hasBranch)) && numberOfBlocks > 1) { 
				programText = programText.concat(tabs(l)).concat("{\n");
				ll++;
			}
			Iterator bs = sBlock.getBlocks().iterator();
			while (bs.hasNext()) {
				HBECommandBlock iBlock = (HBECommandBlock) bs.next();
				programText = programText.concat(translateBlockToC(ll,iBlock));
			}
			if ( !((l==1) && (!hasBranch)) && numberOfBlocks > 1) programText = programText.concat(tabs(l)).concat("}\n");
		} else if (block instanceof HBEConcurrentBlock) {
		
			// TODO. openMP ?
			
					HBEConcurrentBlock sBlock = (HBEConcurrentBlock) block;
					int numberOfBlocks = sBlock.getBlocks().size();
					int ll = l;
					// if ( !((l==1) && (!hasBranch)) && numberOfBlocks > 1) { 
					    programText = programText.concat(tabs(l)).concat("#pragma omp parallel sections\n");
					    programText = programText.concat(tabs(l)).concat("{\n");
						ll++;
					//}
						
					for (HBECommandBlock iBlock : sBlock.getBlocks()) {	
						programText = programText.concat(tabs(ll)).concat("#pragma omp section\n");
						programText = programText.concat(translateBlockToC(ll,iBlock));
					}
					// if ( !((l==1) && (!hasBranch)) && numberOfBlocks > 1) 
						
						programText = programText.concat(tabs(l)).concat("}\n");
			
			
		} else if (block instanceof HBEProcedureCall) {
			HBEProcedureCall pc = (HBEProcedureCall) block;

			programText = programText.concat(hasBranch ? "" : tabs(l)) + pc.getName() + "." + ((HActivateInterface)pc.getActivateSlice().getInterface()).getActivateMethodName() + "();\n";
			
			
		} else if (block instanceof HBESkipCommand) {
			programText = programText.concat(hasBranch ? "" : tabs(l)).concat(";\n");
		}
		
		
		return programText;
		
	}

	
	
}
