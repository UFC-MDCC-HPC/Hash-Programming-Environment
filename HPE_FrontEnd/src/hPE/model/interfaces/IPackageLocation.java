package hPE.model.interfaces;

import java.util.List;

public interface IPackageLocation {

	public String getSite();
	
	public String[] getPackage();
	
	public List fetchComponents();
	
}
