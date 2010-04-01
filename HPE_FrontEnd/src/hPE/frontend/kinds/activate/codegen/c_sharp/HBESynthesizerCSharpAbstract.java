package hPE.frontend.kinds.activate.codegen.c_sharp;

import hPE.frontend.base.codegen.c_sharp.HBESourceVersionCSharp;
import hPE.frontend.kinds.activate.model.HActivateInterface;


public class HBESynthesizerCSharpAbstract extends hPE.frontend.base.codegen.c_sharp.HBESynthesizerCSharpAbstract {

	public HBESynthesizerCSharpAbstract() {
		super();
	}	
	
	public HBESourceVersionCSharp synthesize(HActivateInterface i, String versionID) {
		
		this.setIsSubclass(i, versionID);
		
        return super.synthesize(i,versionID);
        		    
	}

	
	
}
