package hPE.frontend.base.codegen;

import java.io.Serializable;
import java.util.List;

public abstract class HBESourceVersion implements Serializable {

	static final long serialVersionUID = 1;
	
	public HBESourceVersion() {
		super();
	}
	
	public abstract List<HBEAbstractSourceCodeFile> getFiles();
	
	public abstract void addFile(HBEAbstractSourceCodeFile f) throws Exception;
	
	public abstract String getFileType();
	
	public abstract String getSynthesizerType(boolean abs);
	
	private String versionID = ".";
	
	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}
	
	public String toString() {
		return versionID;
	}
				
	
}
