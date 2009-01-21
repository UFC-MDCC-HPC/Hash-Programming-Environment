package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractFile;

public class HBESourceCSharpMainDefinition extends HBESourceCSharpClassDefinition {

	public HBESourceCSharpMainDefinition(String name, String contents, String path, String versionID) {
		super(name, contents, path, versionID);
	}
	
	public String getBinaryExtension() {
		return "exe";
	}

	public String getFileType() {
		return getType();
	}
	
	public static String getType() {
		return "exe";
	}

}
