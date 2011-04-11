package hPE.frontend.kinds.application.codegen.c_sharp;

import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpMainDefinition;
import hPE.frontend.base.codegen.syntaxtree.HBESyntaxTree;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.util.Triple;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;

public class HBESynthesizerCSharpMain extends hPE.frontend.kinds.activate.codegen.c_sharp.HBESynthesizerCSharpConcrete {

	public HBESynthesizerCSharpMain() {
		super();
	}
	
	protected HBESyntaxTree p2p = null;
	
	public hPE.frontend.base.codegen.c_sharp.HBESourceVersionCSharp synthesize(HInterface i, String versionID) {

		HBESourceVersionCSharp version = (HBESourceVersionCSharp) super.synthesize(i,versionID);
		        
	    String mainText = "";
		    
        HComponent c = (HComponent) i.getConfiguration();
        
		List<String> dependencies = new ArrayList<String>();
        
		mainText += "using DGAC;\n";
 		// mainText += "using " + c.getWhoItImplements().getPackagePath().toString() + "." + c.getWhoItImplements().getComponentName() + ";\n";

        String pathD = "%WORKSPACE" + Path.SEPARATOR + super.buildDependencyName(c.getPackagePath().toString(), c.getComponentName(), i.getPrimName());         		
        dependencies.add(pathD);
 		 		
        List<String> paramActualsName = new ArrayList<String>();
 		for (Triple<String,HInterface,String> p : i.getParameters()) {
 			HInterface i1_ = p.snd();
 			List<HInterface> l = new ArrayList<HInterface>();
 			l.add(i1_);
 			this.traverseParams(i1_, l);
 			for (HInterface i1 : l) { 
	 			if (!paramActualsName.contains(i1.getPrimName())) {
		 			paramActualsName.add(i1.getPrimName());
		 			HComponent c1 = (HComponent) i1.getConfiguration();
		 			mainText += "using " + c1.getPackagePath() + "." + c1.getComponentName() + ";\n";
		 			dependencies.add(buildDependencyName(c1.getPackagePath().toString(), c1.getComponentName(), i1.getPrimName()));
	 			}
 			}
 		}
 		
 		mainText += "\nnamespace " + c.getPackagePath() + "." + c.getComponentName() + " { \n\n";  // begin namespace

 		mainText += "\tpublic class " + i.getPrimName() + "Main {\n\n";  
        mainText += "\t\tstatic void Main(string [] args) {\n\n" ;
        
        String unitName = i.getCompliantUnits().get(0).getName2();;
        mainText += "\t\t\t" + i.getName(false,false) + " " + unitName + " = new " + i.getName(false,false) + "();\n\n";
        
        mainText += "\t\t\tBackEnd.DGACInit(\"" + c.getHashComponentUID() + "\",\"" + unitName + "\"," + unitName + "," + "args);\n";
        
        mainText += "\t\t\t" + unitName + ".createSlices();\n";
        
        mainText += "\t\t\t" + unitName + ".compute();\n";
        mainText += "\t\t\tBackEnd.DGACFinalize();\n";
        
        mainText += "\n\t\t}\n"; // end main method;        
        mainText += "\n\t}\n"; // end main class
        mainText += "\n}\n"; // end namespace

        String procName = i.getPrimName();
	    String l = i.getConfiguration().getLocalLocation();
        
		HBESourceCSharpMainDefinition mainCode = new HBESourceCSharpMainDefinition  (procName+"Main.cs", mainText, l, versionID, i, "main");
		mainCode.setDependencies(dependencies);
		version.setMainSource(mainCode);		
	
		return version;	    
	}
	
    
    protected hPE.frontend.base.codegen.c_sharp.HBESourceVersionCSharp createNewSourceVersion() {
    	return new HBESourceVersionCSharp();
    }
    
    
    
	public String toString() {
		return "C# Language Class";
	}
	
}
