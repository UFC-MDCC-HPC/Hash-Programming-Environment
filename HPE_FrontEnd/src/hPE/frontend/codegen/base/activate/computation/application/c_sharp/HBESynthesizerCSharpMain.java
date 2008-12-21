package hPE.frontend.codegen.base.activate.computation.application.c_sharp;

import java.util.ArrayList;
import java.util.List;

import hPE.frontend.codegen.c_sharp.HBESourceCSharpClassDefinition;
import hPE.frontend.codegen.c_sharp.HBESourceCSharpMainDefinition;
import hPE.frontend.codegen.syntaxtree.HBESyntaxTree;
import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.kinds.activate.HActivateInterface;
import hPE.util.Triple;




public class HBESynthesizerCSharpMain extends hPE.frontend.codegen.base.activate.c_sharp.HBESynthesizerCSharpConcrete {

	public HBESynthesizerCSharpMain() {
		super();
	}
	
	protected HBESyntaxTree p2p = null;
	
	public hPE.frontend.codegen.c_sharp.HBESourceVersionCSharp synthesize(HInterface i, String versionID) {

		HBESourceVersionCSharp version = (HBESourceVersionCSharp) super.synthesize(i,versionID);
		        
	    String mainText = "";
		    
        HComponent c = (HComponent) i.getConfiguration();
        
        
 		mainText += "using " + i.getPrimName() + ";\n";

        List<String> paramActualsName = new ArrayList<String>();
 		for (Triple<String,HInterface,String> p : i.getParameters3()) {
 			HInterface i1 = p.snd();
 			if (!paramActualsName.contains(i1.getPrimName())) {
	 			paramActualsName.add(i1.getPrimName());
	 			HComponent c1 = (HComponent) i1.getConfiguration();
	 			mainText += "using " + c1.getPackagePath() + "." + c1.getComponentName() + "."+ i1.getPrimName() + ";\n";
 			}
 		}
 		
 		mainText += "\nnamespace " + c.getPackagePath() + "." + c.getComponentName() + " { \n\n";  // begin namespace

 		mainText += "\tpublic class " + i.getPrimName() + "Main {\n\n";  
        mainText += "\t\tstatic void Main(string [] args) {\n\n" ;
        
        String unitName = i.getCompliantUnits().get(0).getName2();;
        mainText += "\t\t\t" + i.getName(false,false) + " " + unitName + " = new " + i.getName(false,false) + "();\n";
        mainText += "\t\t\t" + unitName + ".compute();\n";
        
        mainText += "\n\t\t}\n"; // end main method;        
        mainText += "\n\t}\n"; // end main class
        mainText += "\n}\n"; // end namespace

        String procName = i.getPrimName();
	    String l = i.getConfiguration().getLocation();
        
		HBESourceCSharpMainDefinition mainCode = new HBESourceCSharpMainDefinition  (procName+"Main.cs", mainText, l, versionID);
		version.setMainSource(mainCode);
	
		return version;
	    
	}
	
    
    protected hPE.frontend.codegen.c_sharp.HBESourceVersionCSharp createNewSourceVersion() {
    	return new HBESourceVersionCSharp();
    }
    
    
    
	public String toString() {
		return "C# Language";
	}
	
}
