package hPE.frontend.base.settings;

import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.model.HHasExternalReferences;

public class HPlatformSettingsFile extends HBEAbstractSourceCodeFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = -580839712232048477L;
	
	public HPlatformSettingsFile(String name, String contents, String path, String versionID, HHasExternalReferences i, String srcType) {
		super(name, contents, path, versionID, i, srcType);
	}
	
	public String getSourceExtension() {
		return "settings";
	}

	public String getBinaryExtension() {
		return "settings";
	}

	public String getFileType() {
		return getType();
	}
	
	public static String getType() {
		return "platform.settings";
	}



}
