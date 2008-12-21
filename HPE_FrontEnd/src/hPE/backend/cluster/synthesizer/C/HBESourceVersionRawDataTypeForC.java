package hPE.backend.cluster.synthesizer.C;

import java.util.ArrayList;
import java.util.List;

import hPE.backend.cluster.synthesizer.HBEAbstractFile;
import hPE.backend.cluster.synthesizer.HBESourceVersion;

public class HBESourceVersionRawDataTypeForC extends HBESourceVersion<HBECSource> {

	static final long serialVersionUID = -9020477748236430004L;
	
	private HBECSourceHeader hdr;
	private HBECSourceCode   src;
	
	public HBESourceVersionRawDataTypeForC(HBECSourceCode src, HBECSourceHeader hdr) {
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
		return "C Language - Raw Data Type";
	}
	
	public HBECSourceHeader getHeader() {
		return hdr;
	}

	public HBECSourceCode getSource() {
		return src;
	}

	public void addFile(HBECSource f) throws Exception {
		if (f instanceof HBECSourceHeader) {
		   this.hdr = (HBECSourceHeader) f;
		} else if (f instanceof HBECSourceCode) {
		  this.src = (HBECSourceCode) f;
		} else {
			throw new Exception("HBESourceVersionRawDataTypeForC:addFile - header and source already defined !");
		}
		
	}
}
