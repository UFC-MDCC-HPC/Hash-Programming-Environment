package hPE.frontend.base.codegen.c_sharp;

import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.model.HHasExternalReferences;

public class HBESourceCSharpClassDefinition extends HBEAbstractSourceCodeFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3477616353489779498L;

	/**
	 * 
	 */
	
	public HBESourceCSharpClassDefinition(String name, String contents, String path, String versionID, HHasExternalReferences i, String srcType) {
		super(name, contents, path, versionID, i, srcType);
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
