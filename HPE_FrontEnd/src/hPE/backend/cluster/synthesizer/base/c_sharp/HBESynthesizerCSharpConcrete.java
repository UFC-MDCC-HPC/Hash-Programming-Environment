package hPE.backend.cluster.synthesizer.base.c_sharp;

import hPE.backend.cluster.synthesizer.HBEAbstractFile;
import hPE.backend.cluster.synthesizer.HBEAbstractSynthesizer;
import hPE.backend.cluster.synthesizer.HBESourceVersion;
import hPE.backend.cluster.synthesizer.c_sharp.HBESourceCSharpClassDefinition;
import hPE.backend.cluster.synthesizer.c_sharp.HBESourceVersionCSharp;
import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HPort;
import hPE.model.kinds.activate.HActivateInterface;
import hPE.model.kinds.activate.HActivateInterfaceSlice;
import hPE.model.kinds.base.HHasPortsInterfaceSlice;
import hPE.util.Triple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;

public class HBESynthesizerCSharpConcrete extends HBEAbstractSynthesizer<HBESourceCSharpClassDefinition,HBESourceVersionCSharp,HInterface> {

	public HBESynthesizerCSharpConcrete() {
		super();
	}
	
	// *******
	
    protected Map<String,List<HInterfaceSlice>> theSlices = new HashMap<String,List<HInterfaceSlice>>();
    
	private void fillPortSlices(HInterface i, List<String> varContext) {
		
		//this.theSlices.clear();
		
		List<HInterfaceSlice> slices = null;
		
		List<HInterfaceSlice> iSlices = new ArrayList<HInterfaceSlice>();
		iSlices.addAll(i.getSlices());
		for (HPort port : i.getPorts()) {
        	if (!port.isInherited()) {
		       iSlices.add(port.getMainSlice());
        	}
		}		
		
		for (HInterfaceSlice slice : iSlices) {
			if (!slice.isInerited()) {
			//	String sliceTypeName = ((HInterface)slice.getInterface()).getName2(false,false,true, 1);
				String sliceTypeName = ((HInterface)slice.getInterface()).isAbstract2() ? ((HComponent)slice.getConfiguration()).getVariableName().split("@")[0] :  ((HInterface)slice.getInterface()).getName2(false, varContext);
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
	 			   HInterface bound = p.snd();	 			   
	 			   if (!paramBoundsName.contains(bound.getPrimName())) { 
	 				   paramBoundsName.add(bound.getPrimName());
	 				   paramBounds.add(bound);
	 			   }
	               programTextVarBounds += "where " + varName.split("@")[0] + ":" + bound.getName2(false, varContext) + "\n";
	 			}
	 			varContext.add(varName);
 			}
 		}

 		fillPortSlices(i,varContext);
        
		String procName = i.getName2(false,varContext);
		String programText = "";		
		
		String packageName = ((HComponent)i.getConfiguration()).getPackagePath().toString();
		String componentName = i.getConfiguration().getComponentName();
		

		programText += "using DGAC;\n";
		programText += "using hpe.basic;\n";

 		Map<String, List<HInterfaceSlice>> tt = new HashMap<String, List<HInterfaceSlice>>();

 		List<String> usings = new ArrayList<String>();
		for (Entry<String,List<HInterfaceSlice>> ss : theSlices.entrySet()) {
						
			HInterfaceSlice s = ss.getValue().get(0);
			
 			for (String dep : ((HInterface)s.getInterface()).getCompilationDependencies()) {
 				if (!usings.contains(dep)) {
 					usings.add(dep);
 					programText += "using " + dep + ";\n"; 				}
 			}
			
/*			HComponent config = (HComponent) s.getConfiguration();
			String packageNameUsing = config.getPackagePath().toString();
			String componentNameUsing = config.getComponentName();
			if (!usings.contains(typeName)) { 
				programText += "using " + packageNameUsing + "." + componentNameUsing + "." + typeName + ";\n";
			    usings.add(typeName); 
			} */
			
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
			String using = cb.getPackagePath().toString() + "." + cb.getComponentName() + "." + b.getPrimName();
			if (!usings.contains(using))
			    programText += "using " + using + ";\n";
		}

		String primInheritedName = i.getInheritedName().split("<")[0];
		String inheritedName = procName.replaceFirst(i.getPrimName(), primInheritedName); 
		
		HComponent cBase = ((HComponent) i.getConfiguration()).getWhoItImplements();
		String packageNameImplements = cBase.getPackagePath().toString();
		String componentNameImplements = cBase.getComponentName();
		
		programText += "using " + packageNameImplements + "." + componentNameImplements + "." + primInheritedName + ";\n";

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
		    	String defaultSliceName = slice.getDefaultName();
		    
			    programText += "private " + typeName + " " + sliceName + " = null;\n\n";

			    HPort portOfTheSlice = slice.getMyPort();
			    boolean isPublic = (portOfTheSlice != null && !portOfTheSlice.isPrivate()) /*|| !(slice instanceof HActivateInterfaceSlice)*/;
		        
                defaultSliceName = defaultSliceName == null ? sliceName : defaultSliceName;
                //if (isPublic) {
				    programText += (isPublic ? "public " : "private ") + typeName + " " + firstUpper(sliceName) + " {\n";
				    programText += tabs(1) + "set {\n";
				    programText += tabs(2) + "this." + sliceName + " = value;\n";				    
				    if (tt.containsKey(sliceName)) {
					    for (HInterfaceSlice ss : tt.get(sliceName)) {
					    	programText += tabs(2) + ss.getName() + "." + firstUpper(defaultSliceName) + " = value;\n";
					    }				    
				    }
				    programText += tabs(1) + "}\n";
				    programText += "}\n\n";
                //}
			    
		    }			
		}
				
		programText += "\n"; // end declaration of inner slices
		
        programText += procName.split("<")[0] + "() { \n\n"; // begin constructor signature
			
        if (subclass) {
        	programText += tabs(1) + "super();\n\n";
        }
        
    	HComponent c = (HComponent)i.getConfiguration();
    	String uid_concrete_component = c.getHashComponentUID();
    	
    	List<HInterfaceSlice> ss = getSorted(theSlices);
    	
	    for (HInterfaceSlice slice: ss) {
	    	HPort portOfTheSlice = slice.getMyPort();
	    	if (portOfTheSlice == null || (portOfTheSlice != null && portOfTheSlice.isPrivate()) || slice instanceof HActivateInterfaceSlice) {
		    	String sliceName = slice.getName();
			    
		    	HInterface iSlice = (HInterface)slice.getInterface();
		    	String unit_id = i.getCompliantUnits().get(0).getName2();
		    	String unit_slice_id = slice.getName();
		    	
		    	String typeName = ((HInterface)slice.getInterface()).isAbstract2() ? ((HComponent)slice.getConfiguration()).getVariableName().split("@")[0] :  ((HInterface)slice.getInterface()).getName2(false, varContext);		    	
		    	
		    	String cast = "(" + typeName + ")";
		    	programText += tabs(1) + "this." + firstUpper(sliceName) + " = " + cast + " BackEnd.createInstanceFor(\"" + cBase.getPackagePath() + "." + cBase.getComponentName() + "\",\"" + unit_id + "\",\"" + unit_slice_id  + "\");\n";
	    	} 
	    }			
        
                
        programText += "\n\n} // end constructor \n\n"; // end constructor body;

        for (String methodCode : this.getMethods()) {
        	programText += methodCode;
        }        
        
	    programText += "\n} // end main class \n"; // end main class	

		programText += "\n} // end namespace \n"; // end namespace
		
	    String l = i.getConfiguration().getLocation();
	    
	    String procFileName = i.getPrimName();
	    
		HBESourceCSharpClassDefinition sourceCode = new HBESourceCSharpClassDefinition (procFileName.concat(".cs"), programText,l,versionID);	
		HBESourceVersionCSharp version = createNewSourceVersion();
		version.setSource(sourceCode);
		version.setVersionID(versionID);

		if (subclass) 
		   i.replaceSourceVersion(superVersion,version);		   
		else
		   i.addSourceVersion(version);
	    
		return version;
		
	    
	}

	private class CompareSliceByDependence implements Comparator<HInterfaceSlice> {

		@Override
		public int compare(HInterfaceSlice o1, HInterfaceSlice o2) {
			HComponent c1 = (HComponent)o1.getConfiguration();
			HComponent c2 = (HComponent)o2.getConfiguration();
			if (c1.isTransitiveInnerComponentIf(c2)) {
				return +1;
			} else if (c2.isTransitiveInnerComponentIf(c1)) {
				return -1;
			} else			 
			    return c1.hashCode() < c2.hashCode() ? +1 : -1;
		}
		
	}
	
	private List<HInterfaceSlice> getSorted(Map<String, List<HInterfaceSlice>> theSlices2) {
		List<HInterfaceSlice> ss = new ArrayList<HInterfaceSlice>();
		
		for (List<HInterfaceSlice> ss_: theSlices.values()) {
			ss.addAll(ss_);
		}
		
		Comparator<HInterfaceSlice> comparator = new CompareSliceByDependence();
		
		Collections.sort(ss, comparator) ;
		
		return ss;
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
        subclass = i.hasSuperType() && superVersion.isInherit();

	}
	
    public boolean getIsSubclass() {
    	return subclass;
    }
	
	
}
