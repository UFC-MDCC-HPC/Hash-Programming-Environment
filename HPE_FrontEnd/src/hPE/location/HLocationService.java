package hPE.location;


public interface HLocationService {		
	public String fetchPackages();	
	public String createPackage(String packageName);
	public String removePackage(String packageName);
	public String registerComponent(String packageName, String componentName);
	public String unregisterComponent(String packageName, String componentName);
	public String getComponent(String packageName, String componentName);
}
