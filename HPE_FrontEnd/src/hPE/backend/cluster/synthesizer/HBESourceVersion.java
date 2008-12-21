package hPE.backend.cluster.synthesizer;

import java.io.Serializable;
import java.util.List;

public abstract class HBESourceVersion<FileType extends HBEAbstractFile> implements Serializable {

	static final long serialVersionUID = 1;
	
	public HBESourceVersion() {
		super();
	}
	
	public abstract List<FileType> getFiles();
	
	public abstract void addFile(FileType f) throws Exception;
	
	public abstract String getFileType();
	
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
	
	public void setInherit(boolean inherit) {
		this.inherit = inherit;
	}

	public boolean isInherit() {
		return inherit;
	}

	private boolean inherit = false;
	
	public void setImplement(boolean implement) {
		this.implement = implement;
	}

	public boolean isImplement() {
		return implement;
	}

	private boolean implement = false;
	
	
}
