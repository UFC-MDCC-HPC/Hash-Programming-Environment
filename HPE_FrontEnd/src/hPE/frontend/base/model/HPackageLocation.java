package hPE.frontend.base.model;

import hPE.frontend.base.interfaces.IPackageLocation;

import java.util.List;

public class HPackageLocation implements IPackageLocation {

	String theSite;
	String[] thePackage;
	
	public HPackageLocation(String theSite, String[] thePackage) {
		this.theSite = theSite;
		this.thePackage = thePackage;
	}
	
	public String getSite() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPackage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List fetchComponents() {
		// TODO: model (fetchComponents)
		return null;
	}

}
