package hPE.frontend.kinds.activate.codegen.c_sharp;

import hPE.frontend.base.codegen.c_sharp.HBESourceVersionCSharp;
import hPE.frontend.base.codegen.syntaxtree.HBECommandBlock;
import hPE.frontend.base.codegen.syntaxtree.HBEConcurrentBlock;
import hPE.frontend.base.codegen.syntaxtree.HBEConditionBranch;
import hPE.frontend.base.codegen.syntaxtree.HBEProcedure;
import hPE.frontend.base.codegen.syntaxtree.HBEProcedureCall;
import hPE.frontend.base.codegen.syntaxtree.HBERepeatTestBranch;
import hPE.frontend.base.codegen.syntaxtree.HBESequentialBlock;
import hPE.frontend.base.codegen.syntaxtree.HBESimpleTestBranch;
import hPE.frontend.base.codegen.syntaxtree.HBESkipCommand;
import hPE.frontend.base.codegen.syntaxtree.HBESyntaxTree;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.kinds.activate.model.HActivateInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class HBESynthesizerCSharpConcrete extends hPE.frontend.base.codegen.c_sharp.HBESynthesizerCSharpConcrete {

	public HBESynthesizerCSharpConcrete() {
		super();
	}
	    
	private HBESyntaxTree p2p = null;
	
	
	private void fillActivationSlices(HHasExternalReferences i, Set<Entry<HInterface,HBEProcedureCall>> activations) {
		List<HInterfaceSlice> slices = null;
				
        for (Entry<HInterface,HBEProcedureCall> activation : activations) {
        	HBEProcedureCall call = activation.getValue();
        	if (call!=null && !call.getActivateSlice().isInherited()) {
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
	public HBESourceVersionCSharp synthesize(HInterface i, String versionID) {

		
	    hPE.frontend.base.codegen.syntaxtree.HBESyntaxTree p2p = new hPE.frontend.base.codegen.syntaxtree.HBESyntaxTree((HActivateInterface)i);
	    this.p2p = p2p;
		// fillActivationSlices(i,p2p.getActivations().entrySet());      
		this.setIsSubclass(i, versionID);
		boolean subClass = super.getIsSubclass();
		if (!subClass) {
			
        	// activate method signature (base class)						
			String baseActivateMethod = "abstract public void " + ((HActivateInterface)i).getActivateMethodName() + "(); \n\n";
    		super.addBaseDeclaration(baseActivateMethod);
    		
        	// activate method signature
			String userActivateMethod = "public override void " + ((HActivateInterface)i).getActivateMethodName() + "() { \n";			
	        HBEProcedure procedure = p2p.getMainProcedure(); 		
		    HBECommandBlock block = procedure.getMainBlock();		    
		    userActivateMethod += translateBlockToC(1,block);	
		    userActivateMethod += "\n} // end activate method \n"; // end activate method
    		super.addUserDeclaration(userActivateMethod);
		}
		
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
            if (pc.getActivateSlice() != null)
            	programText = programText.concat(hasBranch ? "" : tabs(l)) + pc.getName() + "." + ((HActivateInterface)pc.getActivateSlice().getInterface()).getActivateMethodName() + "();\n";
			
			
		} else if (block instanceof HBESkipCommand) {
			programText = programText.concat(hasBranch ? "" : tabs(l)).concat(";\n");
		}
		
		
		return programText;
		
	}

	
	
}
