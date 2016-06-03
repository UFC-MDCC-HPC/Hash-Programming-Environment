package hPE.frontend.base.settings;

import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpClassDefinition;

import java.util.List;
import java.util.ArrayList;

public class HPlatformSettingsFileSet extends HBESourceVersion {

	/**
	 * 
	 */
	private List<HBEAbstractSourceCodeFile> files = null;

	private static final long serialVersionUID = -1915974147641117394L;
	private HBEAbstractSourceCodeFile platform_settings_file = null; 
	
	public HPlatformSettingsFileSet() {
		super();
	}
	
	public void setPlatformSettingsFile(HBEAbstractSourceCodeFile src) {
		this.platform_settings_file = src;
	}
	
	public List<HBEAbstractSourceCodeFile> getFiles() {
		List<HBEAbstractSourceCodeFile> l = new ArrayList<HBEAbstractSourceCodeFile>();
		if (this.platform_settings_file != null)
			l.add(this.platform_settings_file);
		return l;
	}
	
	public  String getFileType() {
		return getType();
	}
	
	public String getSynthesizerType(boolean abs) {
		return "Platform.Settings";
	}
	
	public static String getType() {
		return "Platform.Settings";
	}
	
	public HBEAbstractSourceCodeFile getPlatformSettingsFile() {
	    return platform_settings_file;	
	}
	
	public void addFile(HBEAbstractSourceCodeFile f) throws Exception 
	{
	    this.addSource(f);	      
	}
	
	public void addSource(HBEAbstractSourceCodeFile src) 
	{
		if (this.files == null)
			this.files = new ArrayList<HBEAbstractSourceCodeFile>();
		
		this.files.add(src);
	}


	
}
