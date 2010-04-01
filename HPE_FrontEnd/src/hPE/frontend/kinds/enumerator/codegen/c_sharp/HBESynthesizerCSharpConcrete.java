package hPE.frontend.kinds.enumerator.codegen.c_sharp;

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
	    
	
	public HBESourceVersionCSharp synthesize(HInterface i, String versionID) {

		
		String methodCode = "";
		
		methodCode = "public " + i.getName2() + "(int N) : base(N) {}\n\n";

		super.addBaseDeclaration(methodCode);

		methodCode = "override protected void permute() {\n";
		methodCode += "    // write your permutation code here.";
		methodCode += "\n}\n";
		
		super.addBaseDeclaration(methodCode);
		
        return super.synthesize(i,versionID);
        		
	    
	}




	
	
}
