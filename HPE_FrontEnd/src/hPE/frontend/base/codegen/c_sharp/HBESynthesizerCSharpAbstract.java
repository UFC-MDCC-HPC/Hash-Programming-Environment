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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;





public class HBESynthesizerCSharpAbstract extends HBEAbstractSynthesizer<HBESourceCSharpClassDefinition,HBESourceVersionCSharp,HInterface> {

	public HBESynthesizerCSharpAbstract() {
		super();
	}
	
	// *******
	
    protected Map<String,List<HInterfaceSlice>> theSlices = new HashMap<String,List<HInterfaceSlice>>();
    
	private void fillPortSlices(HInterface i, List<String> varContext) {
		List<HInterfaceSlice> slices = null;
		
	    List<HPort> ports = i.getPorts();
		
        for (HPort port : ports) {
        	if (!port.isInherited()) {
				String sliceTypeName = ((HInterface)port.getInterface()).isAbstract() ? ((HComponent)port.getConfiguration()).getVariableName():  ((HInterface)port.getInterface()).getName2(false,varContext);
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
                
        HBESourceVersion<HBEAbstractFile> superVersion = i.getSourceVersion(versionID);
        
        List<String> varContext = new ArrayList<String>();
        
        this.setIsSubclass(i, versionID);        
                       
        String programTextVarBounds = "";
        List<HInterface> paramBounds = new ArrayList<HInterface>();
        List<String> paramBoundsName = new ArrayList<String>();
                
 		for (Triple<String,HInterface,String> p : i.getParameters()) {
 			String varName = p.fst();
 			if (!varContext.contains(varName)) {
	 			HInterface i1 = p.snd();
	 			HComponent c = (HComponent) i1.getCompliantUnits().get(0).getConfiguration();
	 			if (c.isParameter() && c.getSupplied() == null) {
	 			   HInterface bound = p.snd();
	 			   if (!paramBoundsName.contains(bound.getPrimName())) { 
	 				   paramBoundsName.add(bound.getPrimName());
	 				   paramBounds.add(bound);
	 			   }
	               programTextVarBounds += "where " + varName + ":" + bound.getName2(false,varContext) + "\n";
	 			}
	 			varContext.add(varName);
 			}
 		} 
        
        fillPortSlices(i,varContext);
        
		String procName = i.getName(false,false);
		String programText = "";		
		
		String packageName = ((HComponent)i.getConfiguration()).getPackagePath().toString();
		String componentName = i.getConfiguration().getComponentName();
		

		programText += "using hpe.kinds.I" + i.getConfiguration().kindString() + "Kind;\n";
		
		List<String> usings = new ArrayList<String>();
		for (List<HInterfaceSlice> ss : theSlices.values()) {
			HInterfaceSlice s = ss.get(0);
			String typeName = s.getInterface().getPrimName();
			HComponent config = (HComponent) s.getConfiguration();
			String packageNameUsing = config.getPackagePath().toString();
			String componentNameUsing = config.getComponentName();
			if (!usings.contains(typeName)) 
				programText += "using " + packageNameUsing + "." + componentNameUsing + "." + typeName + ";\n";
			usings.add(typeName);
		}
		
		for (HInterface b : paramBounds) {
			HComponent cb = (HComponent) b.getConfiguration(); 
			if (!usings.contains(b.getPrimName()))
			    programText += "using " + cb.getPackagePath().toString() + "." + cb.getComponentName() + "." + b.getPrimName() + ";\n";
		}
		
		String inheritedName = i.getInheritedName();
		
		if (inheritedName != null) {
			HComponent cBase = ((HComponent) i.getConfiguration()).getSuperType();
			String packageNameExtends = cBase.getPackagePath().toString();
			String componentNameExtends = cBase.getComponentName();			
			programText += "using " + packageNameExtends + "." + componentNameExtends + "." + inheritedName + ";\n";
		}
		
		programText += "\n";	
		
		programText = programText += "namespace " + packageName + "." + componentName + " { \n\n";  // begin namespace

		programText += "public interface " + procName + " : " + (inheritedName!=null ? inheritedName + ", " : "" )  + i.getConfiguration().kindString().replace(" ", "_") + "Kind \n";  // begin class

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
		
	    String l = i.getConfiguration().getLocation();
	    
	    String procFileName = i.getPrimName();
	    
		HBESourceCSharpClassDefinition sourceCode   = new HBESourceCSharpClassDefinition (procFileName.concat(".cs"), programText,l,versionID);	
		HBESourceVersionCSharp version = createNewSourceVersion();
		version.setSource(sourceCode);
		version.setVersionID(versionID);

		if (subclass) 
		   i.replaceSourceVersion(superVersion,version);		   
		else
		   i.addSourceVersion(version);
	    
		return version;
		
	    
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
        subclass = i.hasSuperType() && superVersion.isInherit();

	}
	
    public boolean getIsSubclass() {
    	return subclass;
    }
	
	
}
