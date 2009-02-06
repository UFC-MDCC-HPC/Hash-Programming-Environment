package hPE.frontend.base.codegen.c_sharp;

import java.util.List;

import hPE.frontend.base.codegen.HBEAbstractFile;

public class HBESourceCSharpClassDefinition extends HBEAbstractFile {

	public HBESourceCSharpClassDefinition(String name, String contents, String path, String versionID) {
		super(name, contents, path, versionID);
	}
	
	public String getSourceExtension() {
		return "cs";
	}

	public String getBinaryExtension() {
		return "dll";
	}

	public String getFileType() {
		return getType();
	}
	
	public static String getType() {
		return "library";
	}


}
