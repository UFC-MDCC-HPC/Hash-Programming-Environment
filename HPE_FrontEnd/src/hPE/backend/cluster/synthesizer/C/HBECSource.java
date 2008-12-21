package hPE.backend.cluster.synthesizer.C;

import hPE.backend.cluster.synthesizer.HBEAbstractFile;

public abstract class HBECSource extends HBEAbstractFile {

	public HBECSource(String name, String contents, String path, String versionID) {
		super(name, contents, path, versionID);
	}
	
	public String getFileType() {
		return "C";
	}

}
