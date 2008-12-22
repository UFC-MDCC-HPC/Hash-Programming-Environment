package hPE.frontend.base.codegen.C;

import hPE.frontend.base.codegen.HBEAbstractFile;

public abstract class HBECSource extends HBEAbstractFile {

	public HBECSource(String name, String contents, String path, String versionID) {
		super(name, contents, path, versionID);
	}
	
	public String getFileType() {
		return "C";
	}

}
