package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.model.HHasExternalReferences;

public class HBESourceCSharpMainDefinition extends HBESourceCSharpClassDefinition {

	public HBESourceCSharpMainDefinition(String name, String contents, String path, String versionID, HHasExternalReferences i, String srcType) {
		super(name, contents, path, versionID, i, srcType);
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
