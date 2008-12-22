package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBESourceVersion;

import java.util.List;
import java.util.ArrayList;

public class HBESourceVersionCSharp extends HBESourceVersion<HBESourceCSharpClassDefinition> {

	private HBESourceCSharpClassDefinition src = null; 
	
	public HBESourceVersionCSharp() {
		super();
	}
	
	public void setSource(HBESourceCSharpClassDefinition src) {
		this.src = src;
	}

	public List<HBESourceCSharpClassDefinition> getFiles() {
		List<HBESourceCSharpClassDefinition> l = new ArrayList<HBESourceCSharpClassDefinition>();
		l.add(this.src);
		return l;
	}
	
	public  String getFileType() {
		return "C# Language";
	}
	
	public static String getType() {
		return "C# Language";
	}
	
	public HBESourceCSharpClassDefinition getSource() {
	    return src;	
	}

	public void addFile(HBESourceCSharpClassDefinition f) throws Exception {
	      if (this.src ==null) this.src = f;
	      else throw new Exception("HBESourceVersionCSharp.addFile: Source already defined !");
	}
	
}
