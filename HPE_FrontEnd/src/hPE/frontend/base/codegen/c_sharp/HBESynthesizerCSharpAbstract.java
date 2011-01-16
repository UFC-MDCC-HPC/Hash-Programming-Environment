package hPE.frontend.base.codegen.c_sharp;


import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HPort;
import hPE.frontend.kinds.base.model.HHasPortsInterfaceSlice;
import hPE.util.Pair;
import hPE.util.Triple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;





public class HBESynthesizerCSharpAbstract extends HBEAbstractSynthesizer<HBESourceCSharpClassDefinition,HBESourceVersionCSharp,HInterface> {

	public HBESynthesizerCSharpAbstract() {
		super();
	}
	
	// *******
	
    protected Map<String,List<HInterfaceSlice>> theSlices = new HashMap<String,List<HInterfaceSlice>>();
    
	private void fillPortSlices(HInterface i, List<String> varContext) {
		List<HInterfaceSlice> slices = null;
		
		
		try {
			((HComponent)i.getConfiguration()).updatePorts();
		} catch (HPEAbortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    List<HPort> ports = i.getPorts();
		
        for (HPort port : ports) {
        	if (!port.isInherited()) {
                HComponent pc = (HComponent)port.getConfiguration();
        		String sliceTypeName = ((HInterface)port.getInterface()).isParameter() ? pc.getVariableName((HComponent) i.getConfiguration()):  ((HInterface)port.getInterface()).getName2(false,varContext, null);
				if (theSlices.containsKey(sliceTypeName)) {
					slices = theSlices.get(sliceTypeName);
				} else {
					slices = new ArrayList<HInterfaceSlice>(); 
					theSlices.put(sliceTypeName, slices);
				}
				slices.add(port.getMainSlice());
        	}
		}

	}
	


	public HBESourceVersionCSharp synthesize(HInterface i, String versionID) {
                
        this.setIsSubclass(i, versionID);        

        HBESourceCSharpClassDefinition baseInterfaceDef = this.synthesizeBaseInterface(i, versionID);
        HBESourceCSharpClassDefinition userInterfaceDef = this.synthesizeUserInterface(i, versionID);
		        
        HBESourceVersion<HBEAbstractFile> superVersion = i.getSourceVersion(versionID);
        
		HBESourceVersionCSharp version = createNewSourceVersion();
		version.setBaseSource(baseInterfaceDef);
		version.setUserSource(userInterfaceDef);
		version.setVersionID(versionID);

		if (subclass) 
		   i.replaceSourceVersion(superVersion,version);		   
		else
		   i.addSourceVersion(version);
	    
		return version;
		
	    
	}
	
	private HBESourceCSharpClassDefinition synthesizeUserInterface(HInterface i, String versionID) {
		
		String programText = "";
		List<String> dependencies = new ArrayList<String>();
        List<String> varContext = new ArrayList<String>();
	    
        String programTextVarBounds = "";
        List<HInterface> paramBounds = new ArrayList<HInterface>();
        List<String> paramBoundsName = new ArrayList<String>();
                
		List<Pair<String, HInterface>> interface_bounds = new ArrayList<Pair<String, HInterface>>();
		HComponent topC = (HComponent) i.getConfiguration().getTopConfiguration();
		
		for (Triple<String,HInterface,String> p : i.getParameters(topC)) {
 			String varName = p.fst();
 			if (!varContext.contains(varName)) {
	 			HInterface i1 = p.snd();
	 			HComponent c = (HComponent) i1.getCompliantUnits().get(0).getConfiguration();
	 			//if (c.isParameter() && c.getSupplier() == null) {
	 			   List<HInterface> bounds = new ArrayList<HInterface>();
	 			   HInterface bound = p.snd();
	 			   bounds.add(bound);
	 			   traverseParams(bound,bounds);
	 			   for (HInterface oneBound : bounds) {
	 				  if (!paramBoundsName.contains(oneBound.getPrimName())) {
	 					  paramBoundsName.add(oneBound.getPrimName());
	 					  paramBounds.add(oneBound);
	 				  }
	 			   }
		 		   interface_bounds.add(new Pair<String, HInterface>(varName, bound));
	 			//}
	 			varContext.add(varName);
 			}
 		} 
		
 		for (Pair<String, HInterface> pair : interface_bounds) {
   		   String varName = pair.fst().split("@")[0];
   		   HInterface bound = pair.snd();
   		   programTextVarBounds += "where " + varName + ":" + bound.getName2(false, varContext, varName) + "\n";
   		}
		
        
        fillPortSlices(i,varContext);
        
		String procName = i.getName(false,false);
		
		String packageName = ((HComponent)i.getConfiguration()).getPackagePath().toString();
		String componentName = i.getConfiguration().getComponentName();
		

		programText += "using br.ufc.pargo.hpe.kinds;\n";

		// GET REFERENCES - Begin ...
		
 		List<String> usings = new ArrayList<String>();
 		List<String> refs = new ArrayList<String>();
				
		for (HInterface b : paramBounds) {
			HComponent cb = (HComponent) b.getConfiguration();
			String useStr = cb.getPackagePath() + "." + cb.getComponentName();
			if (!usings.contains(useStr)) {
				usings.add(useStr);
			    programText += "using " + cb.getPackagePath().toString() + "." + cb.getComponentName() + ";\n";
			}
			String depStr = buildDependencyName(cb.getPackagePath().toString(), cb.getComponentName(), b.getPrimName());
			if (!refs.contains(depStr))
			{
				refs.add(depStr);
				dependencies.add(depStr);
			}
		}
		
		String primInheritedName = procName != null ? "Base" + procName.split("<")[0] : null;
		
		if (primInheritedName != null) {
	        String pathD = "%WORKSPACE" + Path.SEPARATOR + buildDependencyName(packageName, componentName, primInheritedName);         		
	        dependencies.add(pathD);
		}
		
		String inheritedName2 = null;
		String primInheritedName2 = i.hasSuperType() ? i.getInheritedName().split("<")[0] : null;
		
		if (primInheritedName2 != null) {
			inheritedName2 = procName.replaceFirst(i.getPrimName(), primInheritedName2); 
			HComponent cBase = ((HComponent) i.getConfiguration()).getSuperType();
			String packageNameExtends = cBase.getPackagePath().toString();
			String componentNameExtends = cBase.getComponentName();			
			
			programText += "using " + packageNameExtends + "." + componentNameExtends + ";\n";
		    dependencies.add(buildDependencyName(packageNameExtends, componentNameExtends, primInheritedName2));
		}
		
		
		// GET REFERENCES - ... End 
		
		programText += "\n";	
		
 		programText = programText += "namespace " + packageName + "." + componentName + " { \n\n";  // begin namespace

		programText += "public interface " + procName + " : " + "Base" + procName + (inheritedName2!=null ? ", " + inheritedName2 : "" ) + "\n";  // begin class

 		programText += programTextVarBounds;
 		
 		programText += "{\n\n";
 								
       // for (String methodCode : this.getMethodSignatures()) {
       // 	programText += methodCode;
       // }        
        
	    programText += "\n} // end main interface \n"; // end main class	

		programText += "\n} // end namespace \n"; // end namespace
		
		
		
//		String l = i.getConfiguration().getLocalLocation();
		HComponent c = (HComponent) i.getConfiguration();
		String l = c.getRelativeLocation();
		
		
	    String procFileName = i.getPrimName();		
		
		HBESourceCSharpClassDefinition userInterfaceDef = new HBESourceCSharpClassDefinition (procFileName + ".cs", programText, l,versionID, i, "user");
		userInterfaceDef.setDependencies(dependencies);

		return userInterfaceDef;
		
	}
	
	private HBESourceCSharpClassDefinition synthesizeBaseInterface(HInterface i, String versionID) {
		
        List<String> varContext = new ArrayList<String>();
		List<String> dependencies = new ArrayList<String>();
		String programText = "/* AUTOMATICALLY GENERATE CODE */\n\n";
                       
        String programTextVarBounds = "";
        List<HInterface> paramBounds = new ArrayList<HInterface>();
        List<String> paramBoundsName = new ArrayList<String>();
                
		List<Pair<String, HInterface>> interface_bounds = new ArrayList<Pair<String, HInterface>>();
		HComponent topC = (HComponent) i.getConfiguration().getTopConfiguration();
		for (Triple<String,HInterface,String> p : i.getParameters(topC)) {
 			String varName = p.fst();
 			if (!varContext.contains(varName)) {
	 			HInterface i1 = p.snd();
	 			HComponent c = (HComponent) i1.getCompliantUnits().get(0).getConfiguration();
	 			//if (c.isParameter() && c.getSupplier() == null) {
	 			   List<HInterface> bounds = new ArrayList<HInterface>();
	 			   HInterface bound = p.snd();
	 			   bounds.add(bound);
	 			   traverseParams(bound,bounds);
	 			   for (HInterface oneBound : bounds) {
	 				  if (!paramBoundsName.contains(oneBound.getPrimName())) {
	 					  paramBoundsName.add(oneBound.getPrimName());
	 					  paramBounds.add(oneBound);
	 				  }
	 			  // }
	 				
	 			  interface_bounds.add(new Pair<String, HInterface>(varName, bound));   
	               // programTextVarBounds += "where " + varName + ":" + bound.getName2(false,varContext, null) + "\n";
	 			}
	 			varContext.add(varName);
 			}
 		} 
 		
 		for (Pair<String, HInterface> pair : interface_bounds) {
   		   String varName = pair.fst().split("@")[0];
   		   HInterface bound = pair.snd();
   		   programTextVarBounds += "where " + varName + ":" + bound.getName2(false, varContext, varName) + "\n";
   		}

        
        fillPortSlices(i,varContext);
        
		String procName = i.getName(false,false);
		
		String packageName = ((HComponent)i.getConfiguration()).getPackagePath().toString();
		String componentName = i.getConfiguration().getComponentName();
		

		programText += "using br.ufc.pargo.hpe.kinds;\n";

		// GET REFERENCES - Begin ...
		
 		List<String> usings = new ArrayList<String>();
 		List<String> refs = new ArrayList<String>();

		for (Entry<String,List<HInterfaceSlice>> ss : theSlices.entrySet()) {
			
			HInterfaceSlice s = ss.getValue().get(0);

			for (Pair<String,HInterface> dep : ((HInterface)s.getInterface()).getCompilationDependencies()) {
				String depStr = dep.fst();
 				String useStr = depStr.substring(0, depStr.lastIndexOf("."));
				HInterface ii = dep.snd();
				HComponent cii = (HComponent) ii.getConfiguration();
				if (!usings.contains(useStr)) {
					usings.add(useStr);
					programText += "using " + useStr + ";\n";
				}
				if (!refs.contains(depStr))
				{
					dependencies.add(buildDependencyName(cii.getPackagePath().toString(),cii.getComponentName(),ii.getPrimName()));
				}
			}
		}
		
		
/*		for (List<HInterfaceSlice> ss : theSlices.values()) {
			HInterfaceSlice s = ss.get(0);
			String typeName = s.getInterface().getPrimName();
			HComponent config = (HComponent) s.getConfiguration();
			String packageNameUsing = config.getPackagePath().toString();
			String componentNameUsing = config.getComponentName();
			if (!usings.contains(typeName)) {
				programText += "using " + packageNameUsing + "." + componentNameUsing + "." + typeName + ";\n";
			    dependencies.add(buildDependencyName(packageNameUsing, componentNameUsing, typeName));
			}
			usings.add(typeName);
		} */
		
		for (HInterface b : paramBounds) {
			HComponent cb = (HComponent) b.getConfiguration();
			String useStr = cb.getPackagePath() + "." + cb.getComponentName();
			if (!usings.contains(useStr)) {
				usings.add(useStr);
			    programText += "using " + cb.getPackagePath().toString() + "." + cb.getComponentName() + ";\n";
			}
			String depStr = buildDependencyName(cb.getPackagePath().toString(), cb.getComponentName(), b.getPrimName());
			if (!refs.contains(depStr))
			{
				refs.add(depStr);
				dependencies.add(depStr);
			}
		}
		
		String inheritedName = null;
		String primInheritedName = i.hasSuperType() ? i.getInheritedName().split("<")[0] : null;
		
		if (primInheritedName != null) {
			inheritedName = procName.replaceFirst(i.getPrimName(), primInheritedName); 
			HComponent cBase = ((HComponent) i.getConfiguration()).getSuperType();
			String packageNameExtends = cBase.getPackagePath().toString();
			String componentNameExtends = cBase.getComponentName();			
			
			programText += "using " + packageNameExtends + "." + componentNameExtends + ";\n";
		    dependencies.add(buildDependencyName(packageNameExtends, componentNameExtends, "Base" + primInheritedName));
		}
		
		// GET REFERENCES - ... End 
		
		programText += "\n";	
		
 		programText = programText += "namespace " + packageName + "." + componentName + " { \n\n";  // begin namespace

		programText += "public interface Base" + procName + " : " + (inheritedName!=null ? "Base" + inheritedName + ", " : "" )  + "I" + i.getConfiguration().kindString().replace(" ", "") + "Kind \n";  // begin class

 		programText += programTextVarBounds;
 		
 		programText += "{\n\n";
 		
		// por enquanto, a mudan�a do nome da interface est� bloqueada... assim, o nome da classe ser� sempre o nome da interface com um 
		// underscore.

        Map<String, List<HInterfaceSlice>> tt = new HashMap<String, List<HInterfaceSlice>>();
        
        for (Entry<String,List<HInterfaceSlice>> s: theSlices.entrySet()) {
		    for (HInterfaceSlice slice: s.getValue()) {
		    	if (slice instanceof HHasPortsInterfaceSlice) {
		    	    
		    		// set ports
		    		HHasPortsInterfaceSlice sliceWithPorts = (HHasPortsInterfaceSlice) slice;
				    List<HPort> ps = sliceWithPorts.getPorts();
				    for (HPort port : ps) {
				    	 String portName = port.getName();
				    	 if (tt.containsKey(portName)) {
				    		 tt.get(portName).add(slice);
				    	 } else {
				    		 List<HInterfaceSlice> l = new ArrayList<HInterfaceSlice>();
				    		 l.add(slice);
				    		 tt.put(portName, l);
				    	 }
			        }	
		    	}
		    }			
		}		

        
        for (Entry<String,List<HInterfaceSlice>> s : theSlices.entrySet()) {
		    String typeName = s.getKey();
		    for (HInterfaceSlice slice : s.getValue()) {
		    	String sliceName = slice.getName();
		    	String defaultSliceName = slice.getDefaultName();
		    
		    	HPort portOfTheSlice = slice.getMyPort();
		    	
			    boolean isPublic = !portOfTheSlice.isPrivate(); //|| !(slice instanceof HActivateInterfaceSlice);
		        
                defaultSliceName = defaultSliceName == null ? sliceName : defaultSliceName;
                
			    if (isPublic) 
			    	programText += tabs(1) + typeName + " " + firstUpper(sliceName) + " {set;}\n";
			    			    
		    }			
		}
				
		programText += "\n"; // end declaration of inner slices
		
        for (String methodCode : this.getMethodSignatures()) {
        	programText += methodCode;
        }
        
        
	    programText += "\n} // end main interface \n"; // end main class	

		programText += "\n} // end namespace \n"; // end namespace
		
		HComponent c = (HComponent) i.getConfiguration();
		String l = c.getRelativeLocation();
	    
	    String procFileName = i.getPrimName();
	    
		HBESourceCSharpClassDefinition sourceCode   = new HBESourceCSharpClassDefinition ("Base" + procFileName.concat(".cs"), programText,l,versionID,i, "base");
		sourceCode.setDependencies(dependencies);

		return sourceCode;
		
	}
	
	private void traverseParams(HInterface bound, List<HInterface> bounds) {
		for (Triple<String,HInterface,String> p : bound.getParameters()) {
			HInterface bound_ = p.snd();
			bounds.add(bound_);
			traverseParams(bound_, bounds);
		}		
	}



	private String buildDependencyName(String package_, String componentName, String moduleName) {
		return package_ + "." + componentName
	       + Path.SEPARATOR + "bin" 
	       + Path.SEPARATOR + "1.0.0.0" 
	       + Path.SEPARATOR + moduleName + ".dll";
	}

	
	private String firstUpper(String s) {
		String fl = s.substring(0, 1).toUpperCase();
		
		return fl + s.substring(1);
	}
	
	// *******
	

	
	
    protected HBESourceVersionCSharp createNewSourceVersion() {
    	return new HBESourceVersionCSharp();
    }
    
   
    
	protected static String tabs(int n) {
		String t = "";
		for (int i=0; i<n; i++) t = t.concat("\t");
		return t;
	}



	public String toString() {
		return "C# Language Interface";
	}

	private List<String> methods = null;
	
	public List<String> getMethodSignatures() {
		if (methods == null) methods = new ArrayList<String>();
        return methods;		
	}
	
	public void addMethodSignature(String methodCode) {
		if (methods == null) methods = new ArrayList<String>();
		
		methods.add(methodCode);
	}
	
	private boolean subclass = false;
	
	public void setIsSubclass(HInterface i, String versionID) {
		
        HBESourceVersion<HBEAbstractFile> superVersion = i.getSourceVersion(versionID);
        subclass = i.hasSuperType() && superVersion.getFiles().isEmpty();

	}
	
	
	
}
