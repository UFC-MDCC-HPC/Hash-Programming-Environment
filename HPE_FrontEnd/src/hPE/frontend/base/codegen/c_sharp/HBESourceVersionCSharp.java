package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.codegen.HBESourceVersion;

import java.util.List;
import java.util.ArrayList;

public class HBESourceVersionCSharp extends HBESourceVersion {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1915974147641117394L;
	private HBESourceCSharpClassDefinition src_base = null; 
	private HBESourceCSharpClassDefinition src_user = null; 
	private List<HBEAbstractSourceCodeFile> src_otherfiles = null;
	
	public HBESourceVersionCSharp() {
		super();
	}
	
	public void setBaseSource(HBEAbstractSourceCodeFile src) {
		this.src_base = (HBESourceCSharpClassDefinition) src;
	}

	public void setUserSource(HBEAbstractSourceCodeFile src) {
		this.src_user = (HBESourceCSharpClassDefinition) src;
	}
	
	public void addSource(HBEAbstractSourceCodeFile src) 
	{
		if (this.src_otherfiles == null)
			this.src_otherfiles = new ArrayList<HBEAbstractSourceCodeFile>();
		
		this.src_otherfiles.add(src);
	}

	public List<HBEAbstractSourceCodeFile> getFiles() {
		List<HBEAbstractSourceCodeFile> l = new ArrayList<HBEAbstractSourceCodeFile>();
		if (this.src_base != null)
		    l.add(this.src_base);
		if (this.src_user != null)
			l.add(this.src_user);
		if (this.src_otherfiles != null)
			l.addAll(this.src_otherfiles);
		return l;
	}
	
	public  String getFileType() {
		return getType();
	}
	
	public String getSynthesizerType(boolean abs) {
		return abs ? "C# Interface" : "C# Class";
	}
	
	public static String getType() {
		return "C# Language";
	}
	
	public HBESourceCSharpClassDefinition getBaseSource() {
	    return src_base;	
	}

	public HBESourceCSharpClassDefinition getUserSource() {
	    return src_user;	
	}
	
	public void addFile(HBEAbstractSourceCodeFile f) throws Exception 
	{
	      if (this.src_base == null && (f.getSrcType() == null || f.getSrcType().equals("base"))) this.setBaseSource(f);
	      else if (this.src_user == null && (f.getSrcType() != null && f.getSrcType().equals("user"))) this.setUserSource(f);
	      else  
	    	  this.addSource(f);	      
//	      else 
//	    	  throw new Exception("HBESourceVersionCSharp.addFile: Source already defined !");
	}
	
	
	
}
