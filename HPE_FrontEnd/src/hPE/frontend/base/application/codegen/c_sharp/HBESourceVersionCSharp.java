package hPE.frontend.base.application.codegen.c_sharp;


import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpClassDefinition;
import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpMainDefinition;

import java.util.List;


public class HBESourceVersionCSharp extends hPE.frontend.base.codegen.c_sharp.HBESourceVersionCSharp {

	private HBESourceCSharpMainDefinition mainSrc; 
	
	public HBESourceVersionCSharp() {
		super();
	}

	public void setMainSource(HBESourceCSharpMainDefinition mainSrc) {
		this.mainSrc = mainSrc;
	}
	
	public List<HBESourceCSharpClassDefinition> getFiles() {
		List<HBESourceCSharpClassDefinition> l = super.getFiles();
		l.add(this.mainSrc);
		return l;
	}
			
	public  String getFileType() {
		return "C# Executable";
	}
	
	public static String getType() {
		return "C# Executable";
	}
	
	public HBESourceCSharpMainDefinition getMainSource() {
	    return mainSrc;	
	}
	
	public void addFile(HBESourceCSharpClassDefinition f) throws Exception {
	      if (f instanceof HBESourceCSharpMainDefinition && this.mainSrc ==null) 
	    	  this.mainSrc = (HBESourceCSharpMainDefinition) f;
	      else if (this.getSource()==null) 
	    	  this.setSource(f);
	      else 
	    	  throw new Exception("HBESourceVersionCSharp.addFile: Source already defined !");
	}
}
