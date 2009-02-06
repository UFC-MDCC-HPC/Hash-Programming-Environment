package hPE.frontend.base.codegen.C;

import hPE.frontend.base.codegen.*;
import hPE.frontend.base.codegen.syntaxtree.*;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.application.model.HApplicationInterface;


import java.util.Iterator;




public class HBESynthesizerForC extends HBEAbstractSynthesizer<HBECSource,HBESourceVersionForC,HActivateInterface> {

	public HBESynthesizerForC() {
		super();
	}
	
	protected HBESyntaxTree p2p = null;
	
	public HBESourceVersionForC synthesize(HActivateInterface i, String versionID) {

 
	    hPE.frontend.base.codegen.syntaxtree.HBESyntaxTree p2p = new hPE.frontend.base.codegen.syntaxtree.HBESyntaxTree(i);
	    this.p2p = p2p;
		
	    String programText = "";
		String headerText = "";
		
		Iterator procs = p2p.getExternalReferences().iterator();
		
		while (procs.hasNext()) {
			String sliceName = (String) procs.next();
			
			programText = programText.concat("#include \"").concat(sliceName).concat(".h\"\n");
			
		}
		
		programText = programText.concat("\n");
		
        HBEProcedure procedure = p2p.getMainProcedure(); 	
		
		String procName = procedure.getName();
		
		headerText = headerText.concat("void ").concat(/* i instanceof HApplicationInterface ? "main" :*/ procName).concat("(");
		
		Iterator pars = procedure.getParameters().iterator();
		
		while (pars.hasNext()) {
			HBEParameter p = (HBEParameter) pars.next();
			headerText = headerText.concat(p.getType()).concat(" ").concat(p.getName());
			if (pars.hasNext())	headerText = headerText.concat(", ");
		}		
		headerText = headerText.concat(")");
		
		programText = programText.concat(headerText).concat("\n");
		
		headerText = headerText.concat(";\n");
		
		
		// Local Variables
		
		programText = programText.concat("{\n");
		Iterator ls = procedure.getVariables().iterator();
		while (ls.hasNext()) {
			HBELocalVariable l = (HBELocalVariable) ls.next();
			programText = programText.concat(tabs(1)).concat(l.getType()).concat(" ").concat(l.getName()).concat(";\n");
		}
		
	    HBECommandBlock block = procedure.getMainBlock();
	    
	    programText = programText.concat(translateBlockToC(1,block));		
	
		programText = programText.concat("}\n\n");
		
		    
		// }
	    
	    String l = i.getConfiguration().getLocalLocation();
	    
		HBECSourceCode   sourceCode   = new HBECSourceCode  (procName.concat(".c"), programText,l,versionID);	
		HBECSourceHeader sourceHeader = new HBECSourceHeader(procName.concat(".h"), headerText,l,versionID);	

		HBESourceVersionForC version = new HBESourceVersionForC(sourceCode, sourceHeader);
		version.setVersionID(versionID);
		i.addSourceVersion(version);
	    
		return version;
	    
	}
	
    
    
    
    
	private static String tabs(int n) {
		String t = "";
		for (int i=0; i<n; i++) t = t.concat("\t");
		return t;
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
					Iterator bs = sBlock.getBlocks().iterator();
					while (bs.hasNext()) {
						HBECommandBlock iBlock = (HBECommandBlock) bs.next();
						programText = programText.concat(tabs(ll)).concat("#pragma omp section\n");
						programText = programText.concat(translateBlockToC(ll,iBlock));
					}
					// if ( !((l==1) && (!hasBranch)) && numberOfBlocks > 1) 
						
						programText = programText.concat(tabs(l)).concat("}\n");
			
			
		} else if (block instanceof HBEProcedureCall) {
			HBEProcedureCall pc = (HBEProcedureCall) block;
			String programText1;
			
			programText = programText.concat(hasBranch ? "" : tabs(l)).concat(pc.getName()).concat("(");
			
			Iterator ps = pc.getParameters().iterator();
			
			programText1 = programText;
			while (ps.hasNext()) {
				HBEVariable p = (HBEVariable) ps.next();
				programText1 = programText.concat(p.getName());
				programText = programText1.concat(",");
			}		
			programText = programText1;
			
			
			programText = programText.concat(");\n");
			
		} else if (block instanceof HBESkipCommand) {
			programText = programText.concat(hasBranch ? "" : tabs(l)).concat("skip;\n");
		}
		
		
		return programText;
		
	}

	public String toString() {
		return "C Language";
	}
	
}
