package hPE.frontend.base.codegen.C;

public class HBECSourceCode extends HBECSource {

	public HBECSourceCode(String name, String contents, String path, String versionID) {
		super(name,contents,path,versionID);
		
	}

	@Override
	public String getBinaryExtension() {
		return "o";
	}

	@Override
	public String getSourceExtension() {
		return "c";
	}

}
