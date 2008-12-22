package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractFile;

public class HBESourceCSharpClassDefinition extends HBEAbstractFile {

	public HBESourceCSharpClassDefinition(String name, String contents, String path, String versionID) {
		super(name, contents, path, versionID);
	}
	
	public String getFileType() {
		return "dll";
	}
	
	public static String getType() {
		return "dll";
	}

}
