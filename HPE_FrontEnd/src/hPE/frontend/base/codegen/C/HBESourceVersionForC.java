package hPE.frontend.base.codegen.C;

import hPE.frontend.base.codegen.HBESourceVersion;

import java.util.List;
import java.util.ArrayList;

public class HBESourceVersionForC extends HBESourceVersion<HBECSource> {

	private HBECSourceCode src; 
	private HBECSourceHeader hdr;
	
	public HBESourceVersionForC(HBECSourceCode src, HBECSourceHeader hdr) {
		super();
		this.src = src;
		this.hdr = hdr;
	}

	public List<HBECSource> getFiles() {
		List<HBECSource> l = new ArrayList<HBECSource>();
		l.add(this.hdr);
		l.add(this.src);
		return l;
	}
	
	public  String getFileType() {
		return "C Language";
	}
	
	public HBECSourceCode getSource() {
	    return src;	
	}
	
	public HBECSourceHeader getHeader() {
	    return hdr;	
	}

	
	public void addFile(HBECSource f) throws Exception {
		if (f instanceof HBECSourceHeader) {
		   this.hdr = (HBECSourceHeader) f;
		} else if (f instanceof HBECSourceCode) {
		  this.src = (HBECSourceCode) f;
		} else {
			throw new Exception("HBESourceVersionForC:addFile - header and source already defined !");
		}
		
	}
}
