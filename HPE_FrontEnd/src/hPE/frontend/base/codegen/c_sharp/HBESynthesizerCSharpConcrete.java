package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
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
import hPE.xml.component.VarianceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Path;

public class HBESynthesizerCSharpConcrete extends HBEAbstractSynthesizer<HBESourceCSharpClassDefinition,HBESourceVersionCSharp,HInterface> {

	public HBESynthesizerCSharpConcrete() {
		super();
	}
	
	// *******
	
    protected Map<String,List<HInterfaceSlice>> theSlices = null;

    protected Map<HInterfaceSlice,HPort> portMapping = null;
    
	private void fillPortSlices(HInterface i, List<String> varContext) {
		
		//this.theSlices.clear();
		
		try {
			((HComponent)i.getConfiguration()).updatePorts();
		} catch (HPEAbortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<HInterfaceSlice> slices = null;

		HComponent cc = (HComponent)i.getConfiguration();
		boolean isImplement = cc.getWhoItImplements() != null && cc.getSuperType() == null;

		List<HInterfaceSlice> iSlices = new ArrayList<HInterfaceSlice>();
		iSlices.addAll(i.getSlices());
		for (HPort port : i.getPorts()) {
        	if (!(port.isInherited() && !isImplement) && !iSlices.contains(port.getMainSlice())) {
		       iSlices.add(port.getMainSlice());
        	}
		    portMapping.put(port.getMainSlice(), port);        	
		}				
		
		for (HInterfaceSlice slice : iSlices) {
			if (!(slice.isInherited() && !isImplement)) {
				
				HComponent c = (HComponent)slice.getConfiguration();
				HInterface i_ = (HInterface)slice.getInterface();
				
				// Na linha a seguir, isAbstract2 foi substituido por isAbstract ...
				String sliceTypeName = i_.isParameter() ? c.getVariableName((HComponent) i.getConfiguration()).split("@")[0] :  i_.getName2(false,varContext, null);
				if (theSlices.containsKey(sliceTypeName)) {
					slices = theSlices.get(sliceTypeName);
				} else {
					slices = new ArrayList<HInterfaceSlice>(); 
					theSlices.put(sliceTypeName, slices);
				}
				
				boolean found = false;
				for (HInterfaceSlice s : slices) 
				{
					if (s.getName().equals(slice.getName())) 
					{
						found = true;
					}
				}
				
				if (!found)
					slices.add(slice);
			}
			
		}
		
	}
	


	public HBESourceVersionCSharp synthesize(HInterface i, String versionID) {
                
		this.setIsSubclass(i, versionID);        

		HBESourceCSharpClassDefinition baseClassDef = this.synthesizeBaseClass(i, versionID); 
		HBESourceCSharpClassDefinition userClassDef = this.synthesizeUserClass(i, versionID); 
		
        HBESourceVersion superVersion = i.getSourceVersion(versionID);

		HBESourceVersionCSharp version = createNewSourceVersion();
		version.setBaseSource(baseClassDef);
		version.setUserSource(userClassDef);
		version.setVersionID(versionID);

		if (this.getIsSubclass()) 
		   i.replaceSourceVersion(superVersion,version);		   
		else
		   i.addSourceVersion(version);
	    
		return version;
		
	    
	}

	private HBESourceCSharpClassDefinition synthesizeUserClass(HInterface i, String versionID) {
		
		String sourceCode = "";
		List<String> dependencies = new ArrayList<String>();
	    
	    List<String> varContext = new ArrayList<String>();
		theSlices = new HashMap<String,List<HInterfaceSlice>>();
		portMapping = new HashMap<HInterfaceSlice,HPort>();		      
                       
		List<Pair<String, HInterface>> interface_bounds = new ArrayList<Pair<String, HInterface>>();

		String programTextVarBounds = "";
        List<HInterface> paramBounds = new ArrayList<HInterface>();
        List<String> paramBoundsName = new ArrayList<String>();
        
        HComponent topC = (HComponent) i.getConfiguration().getTopConfiguration();
        
        List<Triple<String,HInterface,String>> pars = i.getParameters(topC);
        
        for (Triple<String,HInterface,String> p : pars) {
			String varName = p.fst(); 
			VarianceType variance_type = topC.getParameterVariance(p.trd());
 			if (!varContext.contains(varName) && variance_type.equals(VarianceType.CONTRAVARIANT)) {
	 			HInterface i1 = p.snd();
	 			HComponent c = (HComponent) i1.getCompliantUnits().get(0).getConfiguration();
	 		//	if (c.isParameter() && c.getSupplier() != null) {
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
	 		//	}
	 			varContext.add(varName.split("@")[0]);
 			}
 		}

 		for (Pair<String, HInterface> pair : interface_bounds) {
  		   String varName = pair.fst().split("@")[0];
  		   HInterface bound = pair.snd();
  		   programTextVarBounds += "where " + varName + ":" + bound.getName2(false, varContext, varName) + "\n";
  		}
 		
 		
 		fillPortSlices(i,varContext);
        
		String procName = i.getName2(true, varContext,null);
				
		String packageName = ((HComponent)i.getConfiguration()).getPackagePath().toString();
		String componentName = i.getConfiguration().getComponentName();
		
		sourceCode += "using System;\n";
		sourceCode += "using br.ufc.pargo.hpe.backend.DGAC;\n";
		sourceCode += "using br.ufc.pargo.hpe.basic;\n";
		sourceCode += "using br.ufc.pargo.hpe.kinds;\n";

 		Map<String, List<HInterfaceSlice>> tt = new HashMap<String, List<HInterfaceSlice>>();

 		List<String> usings = new ArrayList<String>();
 		List<String> refs = new ArrayList<String>();
		
		for (HInterface b : paramBounds) {
			HComponent cb = (HComponent) b.getConfiguration();
			String depStr = cb.getPackagePath().toString() + "." + cb.getComponentName() + "." + b.getPrimName();
			String useStr = depStr.substring(0, depStr.lastIndexOf("."));
			if (!usings.contains(useStr)) {
				usings.add(useStr);
			    sourceCode += "using " + useStr + ";\n";
			}
			if (!refs.contains(depStr)) {
				refs.add(depStr);
				dependencies.add(buildDependencyName(cb.getPackagePath().toString(), cb.getComponentName(), b.getPrimName()));
			}
		}


		String primInheritedName ="Base" + procName.split("<")[0];
        String pathD = "%WORKSPACE" + Path.SEPARATOR + buildDependencyName(packageName, componentName, primInheritedName);         		
        dependencies.add(pathD);
		
		String primInheritedName2 = i.getInheritedName().split("<")[0];
		String inheritedName = i.getName2(false, varContext,null).replaceFirst(i.getPrimName(), primInheritedName2);		
		HComponent cBase = ((HComponent) i.getConfiguration()).getWhoItImplements();
		String packageNameImplements = cBase.getPackagePath().toString();
		String componentNameImplements = cBase.getComponentName();
		
		sourceCode += "using " + packageNameImplements + "." + componentNameImplements + ";\n";
		dependencies.add(buildDependencyName(cBase.getPackagePath().toString(), cBase.getComponentName(), primInheritedName2));
		
		sourceCode += "\n";
		sourceCode += "namespace " + packageName + "." + componentName + "\n"; 
		sourceCode += "{\n";  // begin namespace		
		
		sourceCode += tabs(1) + "public class " + procName + " : " + "Base" + procName + ", " + inheritedName + "\n" ;  // begin class
		sourceCode += programTextVarBounds; 
		sourceCode += tabs(1) + "{\n";
        	        				            		        
        for (String methodCode : this.getUserDeclarations()) 
        	sourceCode += methodCode;
        
	    sourceCode += tabs(1) + "}\n"; // end main class	

		sourceCode += "}\n"; // end namespace		
		
	    String procFileName = i.getPrimName();		
		HComponent cc = (HComponent) i.getConfiguration();
		String l = cc.getRelativeLocation();
		
		HBESourceCSharpClassDefinition userClassDef = new HBESourceCSharpClassDefinition (procFileName + ".cs", sourceCode, l,versionID, i, "user");
		userClassDef.setDependencies(dependencies);

		return userClassDef;
	}



	private HBESourceCSharpClassDefinition synthesizeBaseClass(HInterface i, String versionID) {
		
		String sourceCode = "/* Automatically Generated Code */\n\n";
		List<String> dependencies = new ArrayList<String>();

	    List<String> varContext = new ArrayList<String>();
		theSlices = new HashMap<String,List<HInterfaceSlice>>();
		portMapping = new HashMap<HInterfaceSlice,HPort>();		
		
		List<Pair<String, HInterface>> interface_bounds = new ArrayList<Pair<String, HInterface>>();

		HComponent topC = (HComponent) i.getConfiguration().getTopConfiguration();
		
		String programTextVarBounds = "";
        List<HInterface> paramBounds = new ArrayList<HInterface>();
        List<String> paramBoundsName = new ArrayList<String>();
 		for (Triple<String,HInterface,String> p : i.getParameters(topC)) 
 		{
			String varName = p.fst(); 
			VarianceType variance_type = topC.getParameterVariance(p.trd());
			
 			if (!varContext.contains(varName) && variance_type.equals(VarianceType.CONTRAVARIANT)) 
 			{
	 			HInterface i1 = p.snd();
	 			HComponent c = (HComponent) i1.getCompliantUnits().get(0).getConfiguration();
	 			// if (c.isParameter() && c.getSupplier() != null) {
		 			   List<HInterface> bounds = new ArrayList<HInterface>();
		 			   HInterface bound = p.snd();
		 			   bounds.add(bound);
		 			   traverseParams(bound,bounds);
		 			   for (HInterface oneBound : bounds) 
		 			   {
		 				  if (!paramBoundsName.contains(oneBound.getPrimName())) 
		 				  {
		 					  paramBoundsName.add(oneBound.getPrimName());
		 					  paramBounds.add(oneBound);
		 				  }
		 			   }
		 		   interface_bounds.add(new Pair<String, HInterface>(varName, bound));   
	 			// }
	 			varContext.add(varName.split("@")[0]);
 			}
 		}
 		
 		for (Pair<String, HInterface> pair : interface_bounds) {
 		   String varName = pair.fst().split("@")[0];
 		   HInterface bound = pair.snd();
 		   programTextVarBounds += "\n"; 
 		   programTextVarBounds += tabs(2) + "where " + varName + ":" + bound.getName2(false, varContext, varName);
 		}

 		fillPortSlices(i,varContext);
        
		String procName = i.getName2(true, varContext,null);
				
		String packageName = ((HComponent)i.getConfiguration()).getPackagePath().toString();
		String componentName = i.getConfiguration().getComponentName();
		
		sourceCode += "using System;\n";
		sourceCode += "using br.ufc.pargo.hpe.backend.DGAC;\n";
		sourceCode += "using br.ufc.pargo.hpe.basic;\n";
		sourceCode += "using br.ufc.pargo.hpe.kinds;\n";

 		Map<String, List<HInterfaceSlice>> tt = new HashMap<String, List<HInterfaceSlice>>();

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
 					sourceCode += "using " + useStr + ";\n";
 				}
 				if (!refs.contains(depStr))
 				{
 					refs.add(depStr);
 					dependencies.add(buildDependencyName(cii.getPackagePath().toString(),cii.getComponentName(),ii.getPrimName()));
  				}
 			}
						
		    for (HInterfaceSlice slice: ss.getValue()) {
		    	if (slice instanceof HHasPortsInterfaceSlice && !slice.isPublic()  /* && slice.getMyPort() == null */) {		    	    
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
			    sourceCode += "using " + useStr + ";\n";
			}
			if (!refs.contains(depStr)) {
				refs.add(depStr);
				dependencies.add(buildDependencyName(cb.getPackagePath().toString(), cb.getComponentName(), b.getPrimName()));
			}
		}

		String primInheritedName = i.getInheritedName().split("<")[0];
		String inheritedName = i.getName2(false, varContext,null).replaceFirst(i.getPrimName(), primInheritedName);		
		HComponent cBase = ((HComponent) i.getConfiguration()).getWhoItImplements();
		String packageNameImplements = cBase.getPackagePath().toString();
		String componentNameImplements = cBase.getComponentName();
		
		sourceCode += "using " + packageNameImplements + "." + componentNameImplements + ";\n";
		dependencies.add(buildDependencyName(cBase.getPackagePath().toString(), cBase.getComponentName(), "Base" + primInheritedName));

		sourceCode += "\nnamespace " + packageName + "." + componentName; 
		sourceCode += " \n{\n";  
		sourceCode += tabs(1) + "public abstract class Base" + procName + ": " + i.getConfiguration().kindString().replace(" ", "") + ", Base" + inheritedName + this.getAdditionalExtendsListCode() + programTextVarBounds + "\n"; 
		sourceCode += tabs(1) + "{\n";  
        	        
 		Map<String, HInterfaceSlice> memSlices = new HashMap<String, HInterfaceSlice>();

 		for (Entry<String,List<HInterfaceSlice>> s : theSlices.entrySet()) {
		    String typeName = s.getKey();
		    for (HInterfaceSlice slice : s.getValue()) 
		    	//if (!memSlices.containsKey(slice.getName())) 
		    {
		    	String sliceName = slice.getName();
		    	memSlices.put(sliceName, slice);
		    	String defaultSliceName = slice.getOriginalName2();
		    

			    HPort portOfTheSlice = portMapping.get(slice); /*slice.getMyPort()*/;
			    boolean isPublic = ((portOfTheSlice != null && !portOfTheSlice.isPrivate()) /*|| (portOfTheSlice == null && slice.isPublic())*/) /*|| !(slice instanceof HActivateInterfaceSlice)*/;
		        
                defaultSliceName = defaultSliceName == null ? sliceName : defaultSliceName;
			    String id_inner = slice.getPortName();
			    
			    sourceCode += tabs(2) + "private " + typeName + " " + sliceName + (isParameter(typeName, varContext) != null ? " = default(" + typeName + ")" : " = null") + ";\n\n";
			    sourceCode += tabs(2) + (isPublic ? "public " : "protected ") + typeName + " " + firstUpper(sliceName) + "\n";
			    sourceCode += tabs(2) + "{\n";
			    sourceCode += tabs(3) + "get\n";
			    sourceCode += tabs(3) + "{\n";				    				    
			    sourceCode += tabs(4) + "if (this." + sliceName + " == null)\n";
				sourceCode += tabs(5) + "this." + sliceName + " = (" + typeName + ") Services.getPort(\"" + id_inner +  "\");\n";  ; // value;\n";
			    sourceCode += tabs(4) + "return this." + sliceName + ";\n";
			    sourceCode += tabs(3) + "}\n";
			    sourceCode += tabs(2) + "}\n";
			    
		    }			
		}
				    
        for (String methodCode : this.getBaseDeclarations())
        	sourceCode += methodCode;
        
	    sourceCode += tabs(1) + "}\n"; // end main class
		sourceCode += "}"; // end namespace
		
	    String procFileName = i.getPrimName();
		HComponent cc = (HComponent) i.getConfiguration();
		String l = cc.getRelativeLocation();

	    HBESourceCSharpClassDefinition baseClassDef = new HBESourceCSharpClassDefinition ("Base" + procFileName.concat(".cs"), sourceCode,l,versionID, i, "base");
		baseClassDef.setDependencies(dependencies);

		return baseClassDef;
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
		return "C# Class";
	}

	private List<String> additional_extends = null;
	
	public List<String> getAdditionalExtends() {
		if (additional_extends == null) additional_extends = new ArrayList<String>();
        return additional_extends;		
	}
	
	public void addAdditionalExtends(String extendsName) {
		if (additional_extends == null) additional_extends = new ArrayList<String>();
		
		additional_extends.add(extendsName);
	}
	
	public String getAdditionalExtendsListCode() {
		if (additional_extends == null) additional_extends = new ArrayList<String>();
		
		String result = "";
		for (String extendsName : this.getAdditionalExtends()) {
	     		result += ", " + extendsName;
		}
		
	    return result;
	}
	

	private List<String> methodsBase = null;
	private List<String> methodsUser = null;
	
	public List<String> getBaseDeclarations() {
		if (methodsBase == null) methodsBase = new ArrayList<String>();
        return methodsBase;		
	}
	
	public List<String> getUserDeclarations() {
		if (methodsUser == null) methodsUser = new ArrayList<String>();
        return methodsUser;		
	}

	public void addBaseDeclaration(String methodCode) {
		if (methodsBase == null) methodsBase = new ArrayList<String>();
		methodsBase.add(methodCode);
	}
	
	public void addUserDeclaration(String methodCode) {
		if (methodsUser == null) methodsUser = new ArrayList<String>();
		methodsUser.add(methodCode);
	}
	
	private boolean subclass = false;
	
	public void setIsSubclass(HInterface i, String versionID) {
		
        HBESourceVersion superVersion = i.getSourceVersion(versionID);
        subclass = i.hasSuperType() && superVersion.getFiles().isEmpty();

	}
	
    public boolean getIsSubclass() {
    	return subclass;
    }
	
	
}
