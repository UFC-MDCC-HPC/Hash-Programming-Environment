package hPE.backend.cluster.synthesizer.base.activate.computation.application.c_sharp;


import hPE.backend.cluster.synthesizer.c_sharp.HBESourceCSharpClassDefinition;
import hPE.backend.cluster.synthesizer.c_sharp.HBESourceCSharpMainDefinition;

import java.util.List;


public class HBESourceVersionCSharp extends hPE.backend.cluster.synthesizer.c_sharp.HBESourceVersionCSharp {

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
