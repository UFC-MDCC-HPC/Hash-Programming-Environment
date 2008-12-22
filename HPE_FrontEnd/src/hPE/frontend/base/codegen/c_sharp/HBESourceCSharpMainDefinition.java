package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractFile;

public class HBESourceCSharpMainDefinition extends HBESourceCSharpClassDefinition {

	public HBESourceCSharpMainDefinition(String name, String contents, String path, String versionID) {
		super(name, contents, path, versionID);
	}
	
	public String getFileType() {
		return "exe";
	}
	
	public static String getType() {
		return "exe";
	}

}
