package hPE.location.interfaces;

import java.util.Map;


public interface HLocationService {	
	public String getName();
	public String getPresentationMessage();
	public String fetchPackages();	
	public String registerComponent(String packageName, String componentName, String contentsConfig, Map<String, byte[]> binaries);
	public String unregisterComponent(String packageName, String componentName);
	public String getComponent(String packageName, String componentName);
}
