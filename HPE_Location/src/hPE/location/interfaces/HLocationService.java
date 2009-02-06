package hPE.location.interfaces;

import java.util.Map;


public interface HLocationService {	
	public String getName();
	public String getPresentationMessage();
	public String fetchPackages(boolean showObsolete);	
	public String registerComponent(String packageName, String componentName, String version, String contentsConfig, Map<String, byte[]> binaries);
	public String unregisterComponent(String packageName, String componentName, String version);
	public String getComponent(String packageName, String componentName, String version);
	public byte[] getBinaryFile(String packageName, String componentName, String version, String filePath);
	public String markAsObsolete(String packageName, String componentName, String version);
}
