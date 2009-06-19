package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HPort;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.HActivateInterfaceSlice;
import hPE.frontend.kinds.base.model.HHasPortsInterfaceSlice;
import hPE.util.Pair;
import hPE.util.Triple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;

import org.eclipse.core.runtime.Path;

public class HBESynthesizerCSharpConcrete extends HBEAbstractSynthesizer<HBESourceCSharpClassDefinition,HBESourceVersionCSharp,HInterface> {

	public HBESynthesizerCSharpConcrete() {
		super();
	}
	
	// *******
	
    protected Map<String,List<HInterfaceSlice>> theSlices = new HashMap<String,List<HInterfaceSlice>>();

    protected Map<HInterfaceSlice,HPort> portMapping = new HashMap<HInterfaceSlice,HPort>();
    
	private void fillPortSlices(HInterface i, List<String> varContext) {
		
		//this.theSlices.clear();
		
		List<HInterfaceSlice> slices = null;
		
		List<HInterfaceSlice> iSlices = new ArrayList<HInterfaceSlice>();
		iSlices.addAll(i.getSlices());
		for (HPort port : i.getPorts()) {
        	if (!port.isInherited() && !iSlices.contains(port.getMainSlice())) {
		       iSlices.add(port.getMainSlice());
		       portMapping.put(port.getMainSlice(), port);
        	}
		}		
		
		for (HInterfaceSlice slice : iSlices) {
			if (!slice.isInerited()) {
				
				HComponent c = (HComponent)slice.getConfiguration();
				HInterface i_ = (HInterface)slice.getInterface();
				
				// Na linha a seguir, isAbstract2 foi substituido por isAbstract ...
				String sliceTypeName = i_.isAbstract() ? c.getVariableName().split("@")[0] :  i_.getName2(false, varContext);
				if (theSlices.containsKey(sliceTypeName)) {
					slices = theSlices.get(sliceTypeName);
				} else {
					slices = new ArrayList<HInterfaceSlice>(); 
					theSlices.put(sliceTypeName, slices);
				}
				slices.add(slice);
			}
			
		}
		
	}
	


	public HBESourceVersionCSharp synthesize(HInterface i, String versionID) {
                
		List<String> varContext = new ArrayList<String>();
		
        HBESourceVersion<HBEAbstractFile> superVersion = i.getSourceVersion(versionID);
        
        this.setIsSubclass(i, versionID);        
                       
        // List<String> t = i.getCompilationDependencies();
        
		String programTextVarBounds = "";
        List<HInterface> paramBounds = new ArrayList<HInterface>();
        List<String> paramBoundsName = new ArrayList<String>();
 		for (Triple<String,HInterface,String> p : i.getParameters3()) {
			String varName = p.fst(); 
 			if (!varContext.contains(varName)) {
	 			HInterface i1 = p.snd();
	 			HComponent c = (HComponent) i1.getCompliantUnits().get(0).getConfiguration();
	 			if (c.isParameter() && c.getSupplied() != null) {
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
/*	 			   HInterface bound = p.snd();	 			   
	 			   if (!paramBoundsName.contains(bound.getPrimName())) { 
	 				   paramBoundsName.add(bound.getPrimName());
	 				   paramBounds.add(bound);
	 			   } */
	               programTextVarBounds += "where " + varName.split("@")[0] + ":" + bound.getName2(false, varContext) + "\n";
	 			}
	 			varContext.add(varName);
 			}
 		}

 		fillPortSlices(i,varContext);
        
		String procName = i.getName2(false,varContext);
		String programText = "";
		
		List<String> dependencies = new ArrayList<String>();
		
		String packageName = ((HComponent)i.getConfiguration()).getPackagePath().toString();
		String componentName = i.getConfiguration().getComponentName();
		
		programText += "using System;\n";
		programText += "using DGAC;\n";
		programText += "using hpe.basic;\n";

 		Map<String, List<HInterfaceSlice>> tt = new HashMap<String, List<HInterfaceSlice>>();

 		List<String> usings = new ArrayList<String>();
 		List<String> refs = new ArrayList<String>();
 		
		for (Entry<String,List<HInterfaceSlice>> ss : theSlices.entrySet()) {
						
			HInterfaceSlice s = ss.getValue().get(0);
			
 			for (Pair<String,HInterface> dep : ((HInterface)s.getInterface()).getCompilationDependencies3()) {
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
 					refs.add(depStr);
 					dependencies.add(buildDependencyName(cii.getPackagePath().toString(),cii.getComponentName(),ii.getPrimName()));
  				}
 			}
						
		    for (HInterfaceSlice slice: ss.getValue()) {
		    	if (slice instanceof HHasPortsInterfaceSlice && slice.getMyPort() == null) {		    	    
		    		// set ports
		    		HHasPortsInterfaceSlice sliceWithPorts = (HHasPortsInterfaceSlice) slice;
				    List<HPort> ps = sliceWithPorts.getPorts();
				    for (HPort port : ps) {
				    	if (!port.getInterfaceSlices().contains(slice)) {
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
		}
		
		for (HInterface b : paramBounds) {
			HComponent cb = (HComponent) b.getConfiguration();
			String depStr = cb.getPackagePath().toString() + "." + cb.getComponentName() + "." + b.getPrimName();
			String useStr = depStr.substring(0, depStr.lastIndexOf("."));
			if (!usings.contains(useStr)) {
				usings.add(useStr);
			    programText += "using " + useStr + ";\n";
			}
			if (!refs.contains(depStr)) {
				refs.add(depStr);
				dependencies.add(buildDependencyName(cb.getPackagePath().toString(), cb.getComponentName(), b.getPrimName()));
			}
		}

		String primInheritedName = i.getInheritedName().split("<")[0];
		String inheritedName = procName.replaceFirst(i.getPrimName(), primInheritedName); 
		
		HComponent cBase = ((HComponent) i.getConfiguration()).getWhoItImplements();
		String packageNameImplements = cBase.getPackagePath().toString();
		String componentNameImplements = cBase.getComponentName();
		
		programText += "using " + packageNameImplements + "." + componentNameImplements + ";\n";
		dependencies.add(buildDependencyName(cBase.getPackagePath().toString(), cBase.getComponentName(), primInheritedName));

		programText += "\nnamespace " + packageName + "." + componentName + " { \n\n";  // begin namespace

		programText += "public class " + procName + ": Unit, " + inheritedName + "\n" + programTextVarBounds + "{\n\n";  // begin class
        	
		// por enquanto, a mudan�a do nome da interface est� bloqueada... assim, o nome da classe ser� sempre o nome da interface com um 
		// underscore. 		
 		
/* 		Map<String, List<HInterfaceSlice>> tt = new HashMap<String, List<HInterfaceSlice>>();
        
        for (Entry<String,List<HInterfaceSlice>> s: theSlices.entrySet()) {
		    for (HInterfaceSlice slice: s.getValue()) {
		    	if (slice instanceof HHasPortsInterfaceSlice && slice.getMyPort() == null) {		    	    
		    		// set ports
		    		HHasPortsInterfaceSlice sliceWithPorts = (HHasPortsInterfaceSlice) slice;
				    List<HPort> ps = sliceWithPorts.getPorts();
				    for (HPort port : ps) {
				    	if (!port.getInterfaceSlices().contains(slice)) {
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
		} */		

        
        for (Entry<String,List<HInterfaceSlice>> s : theSlices.entrySet()) {
		    String typeName = s.getKey();
		    for (HInterfaceSlice slice : s.getValue()) {
		    	String sliceName = slice.getName();
		    	String defaultSliceName = slice.getOriginalName2();
		    
			    programText += "private " + typeName + " " + sliceName + (isParameter(typeName, varContext) != null ? " = default(" + typeName + ")" : " = null") + ";\n\n";

			    HPort portOfTheSlice = portMapping.get(slice); /*slice.getMyPort()*/;
			    boolean isPublic = (portOfTheSlice != null && !portOfTheSlice.isPrivate()) /*|| !(slice instanceof HActivateInterfaceSlice)*/;
		        
                defaultSliceName = defaultSliceName == null ? sliceName : defaultSliceName;
                //if (isPublic) {
				    programText += (isPublic ? "public " : "private ") + typeName + " " + firstUpper(sliceName) + " {\n";
				    programText += tabs(1) + "set {\n";
				    programText += tabs(2) + "this." + sliceName + " = value;\n";				    
				    if (tt.containsKey(sliceName)) {
					    for (HInterfaceSlice ss : i.getSortedSlices(tt.get(sliceName))) {
					    	programText += tabs(2) + ss.getName() + "." + firstUpper(portOfTheSlice.getOriginalNameOf2(ss)) + " = value;\n";
					    }				    
				    }
				    programText += tabs(1) + "}\n";
				    programText += "}\n\n";
                //}
			    
		    }			
		}
				
		programText += "\n"; // end declaration of inner slices
		
        programText += "public " + procName.split("<")[0] + "() { \n"; // begin constructor signature
			
        if (subclass) {
        	programText += tabs(1) + "super();\n";
        }
        
        programText += "\n} \n\n"; // end constructor body;
        
        HComponent c = (HComponent)i.getConfiguration();

        programText += "public static string UID = \"" + c.getHashComponentUID() + "\";\n\n";

        programText += "override public void createSlices() {\n"; // begin constructor signature

        programText += tabs(1) + "base.createSlices();\n";
        
        
		List<HInterfaceSlice> ss0 = new ArrayList<HInterfaceSlice>();
        
		for (List<HInterfaceSlice> ss_: theSlices.values()) {
			ss0.addAll(ss_);
		}
        
    	List<HInterfaceSlice> ss = i.getSortedSlices(ss0);	
    	
	    for (HInterfaceSlice slice: ss) {
	    	HPort portOfTheSlice = slice.getMyPort();
	    	if (portOfTheSlice == null || (portOfTheSlice != null && portOfTheSlice.isPrivate()) || slice instanceof HActivateInterfaceSlice) {
		    	HInterface iSlice = (HInterface)slice.getInterface();
		    	
		    	String sliceName = slice.getName();			    
		    	String unit_id = iSlice.getCompliantUnits().get(0).getConfiguration().getRef();
		    	String unit_slice_id = iSlice.getCompliantUnits().get(0).getSupersededName();// slice.getName();		
		    	
		    	String typeName = iSlice.isAbstract() ? ((HComponent)slice.getConfiguration()).getVariableName().split("@")[0] :  ((HInterface)slice.getInterface()).getName2(false, varContext);
	    		
		    	List<String> varContext_ = new ArrayList<String>();
	    		varContext_.addAll(varContext);
	    		String typeName2 = ((HInterface)slice.getInterface()).getName2(false, varContext_);		    		
	    		String typeName2_ = isParameter(typeName2,varContext_);
	    		while (typeName2_ != null) {
		    		varContext_.remove(typeName2_);
		    		typeName2 = ((HInterface)slice.getInterface()).getName2(false, varContext_);		    		
		    		typeName2_ = isParameter(typeName2,varContext_);
		    	} 
		    	
		    	String[] params = extractParameters(typeName2);
		    	
		    	String paramsStr = "";
		    	for (int counter = 0; counter < params.length - 1; counter++) {
		    		paramsStr += "typeof(" + params[counter] + "),";
		    	}
		    	if (params.length > 0)
		    		paramsStr += "typeof(" + params[params.length - 1].trim() + ")";
		    	
		    	String typeParams = "new Type[] {" + paramsStr + "}";
		    	
		    	String cast = "(" + typeName + ")";
		    	programText += tabs(1) + "this." + firstUpper(sliceName) + " = " + cast + " BackEnd.createSlice(this, UID,\"" + unit_id + "\",\"" + unit_slice_id + "\"," + typeParams + ");\n";
	    	} 
	    }			
        
                
        programText += "} \n\n"; // end createSlices body;

        for (String methodCode : this.getMethods()) {
        	programText += methodCode;
        }        
        
	    programText += "\n}\n"; // end main class	

		programText += "\n}\n"; // end namespace
		
	    String l = i.getConfiguration().getLocalLocation();
	    
	    String procFileName = i.getPrimName();
	    
		HBESourceCSharpClassDefinition sourceCode = new HBESourceCSharpClassDefinition (procFileName.concat(".cs"), programText,l,versionID);
		sourceCode.setDependencies(dependencies);
		HBESourceVersionCSharp version = createNewSourceVersion();
		version.setSource(sourceCode);
		version.setVersionID(versionID);

		if (subclass) 
		   i.replaceSourceVersion(superVersion,version);		   
		else
		   i.addSourceVersion(version);
	    
		return version;
		
	    
	}

	protected void traverseParams(HInterface bound, List<HInterface> bounds) {
		for (Triple<String,HInterface,String> p : bound.getParameters()) {
			HInterface bound_ = p.snd();
			bounds.add(bound_);
			traverseParams(bound_, bounds);
		}		
	}



	private String isParameter(String typeName2, List<String> varContext_) {

        for (String s : varContext_) {
        	if (typeName2.equals(s.split("@")[0])) return s;
        }
		
		return null;
	}



	private String[] extractParameters(String typeName) {
		
		if (typeName.indexOf('<') >= 0) {
		    String pars = typeName.substring(typeName.indexOf('<')+1, typeName.length()-1).trim();            
            boolean stop = false; 
            int i = 0;
            List<String> thePars = new ArrayList<String>();
		    while (!stop && !pars.equals("")) {			
		    	 char thisChar = pars.charAt(i);
		    	 if (thisChar == '<') {
		    	    int split = enterParameter(pars,i);
		    	    thePars.add(pars.substring(0,split));
		    	    if (split < pars.length()) {
		    	       pars = pars.substring(split + 1);
		    	    } else {
		    	    	pars = pars.substring(split);
		    	    }
		    	    i = 0;
		    	 } else if (thisChar == ',') {
		    		thePars.add(pars.substring(0,i));
		    		pars = pars.substring(i+2);
		    		i = -1;
		    	 } else if (thisChar == '>') {
		    		 stop = true;
		    		 thePars.add(pars.substring(0,i));
		    	 } else if (i+1 >= pars.length()) {
		    	     thePars.add(pars.substring(0,i+1));	 
		    	     stop = true;
		    	 }
		         i++; 
		    }
		    return thePars.toArray(new String[] {});
		}
		else {
			   return new String[] {};
			
		}
				
	}



	private int enterParameter(String pars, int i) {
		
		int level = -1;
		boolean stop = false;
		int j=i;
		do {
			if (pars.charAt(j) == '<') {
				level ++;
			} else if (pars.charAt(j) == '>') {
				if (level == 0) {
					stop = true;
				} else {
					level--;
				}
			} 
			
			j++;
		} while (!stop);
		return j;
	}



	protected String buildDependencyName(String package_, String componentName, String moduleName) {
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
		return "C# Language Class";
	}

	private List<String> methods = null;
	
	public List<String> getMethods() {
		if (methods == null) methods = new ArrayList<String>();
        return methods;		
	}
	
	public void addMethod(String methodCode) {
		if (methods == null) methods = new ArrayList<String>();
		
		methods.add(methodCode);
	}
	
	private boolean subclass = false;
	
	public void setIsSubclass(HInterface i, String versionID) {
		
        HBESourceVersion<HBEAbstractFile> superVersion = i.getSourceVersion(versionID);
        subclass = i.hasSuperType() && superVersion.getFiles().isEmpty();

	}
	
    public boolean getIsSubclass() {
    	return subclass;
    }
	
	
}
