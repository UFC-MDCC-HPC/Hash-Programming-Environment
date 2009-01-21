package hPE.frontend.base.codegen.C;

public class HBECSourceHeader extends HBECSource {

	public HBECSourceHeader(String name, String contents, String path, String versionID) {
		super(name,contents,path, versionID);
		
	}

	@Override
	public String getBinaryExtension() {
		return "o";
	}

	@Override
	public String getSourceExtension() {
		return "h";
	}

}
