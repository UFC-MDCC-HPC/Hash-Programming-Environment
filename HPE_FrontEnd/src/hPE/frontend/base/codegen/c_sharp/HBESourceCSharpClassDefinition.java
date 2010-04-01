package hPE.frontend.base.codegen.c_sharp;

import java.util.List;

import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.dialogs.AddReferencesDialog.Reference;
import hPE.frontend.base.model.HHasExternalReferences;

public class HBESourceCSharpClassDefinition extends HBEAbstractFile {

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
