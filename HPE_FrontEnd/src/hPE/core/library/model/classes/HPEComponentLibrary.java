package hPE.core.library.model.classes;

import hPE.core.library.HPELocationEntry;
import hPE.core.library.model.interfaces.IHPEComponentLibrary;
import hPE.core.library.model.interfaces.IHPEComponentLibraryItem;
import hPE.core.library.model.interfaces.ILPackage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

import org.eclipse.emf.common.util.URI;

public class HPEComponentLibrary extends HPEComponentLibraryItem implements IHPEComponentLibrary {

	private boolean showObsolete = false;
	
	public HPEComponentLibrary(List<URI> locationNameList, boolean showObsolete) {
		super();
		this.showObsolete = showObsolete;
		readFrom(locationNameList);
	}
		
	protected void readFrom(Object model) {
	    readLibrary((List<URI>) model);
	}
	
	private List<String> packageNames = new ArrayList<String>();
	
	public List<String> getPackageNames() {
		return packageNames;
	}

	public void readLibrary(List<URI> locationNameList) {
		// Takes a set of location names and builds location objects.
				
		Map<String,ILPackage> allPks = new HashMap<String,ILPackage>();
		
		clearChildren();
		
		for (URI locationSite : locationNameList) {
		
		    List<String> pks=null;
			try {
				pks = HPELocationEntry.fetchPackagesFromLocation(locationSite, showObsolete);
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null, "Unable to reach location at \n" + locationSite, "Location Fetch Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			if (pks!=null) {			
			   	for (String pkName : pks) {			    			    	
				    if (allPks.containsKey(pkName)) {
				       allPks.get(pkName).addLocation(locationSite);			       
			        } else {
			        	packageNames.add(pkName);
			        	ILPackage pk = new LPackage(this,pkName.split(":"));
			        	pk.addLocation(locationSite);
			        	addChild(pk);
			        }
			    }
			}
		}
	}
	
	public List getLocations() {
		return getChildren();
	}
	
	
	private boolean registerLocation(String location) {
		// Register a new location in the environment. It is appended to the system file locations.xml
		// Returns true if the location is already registered, false otherwise.
		
		// TODO: library (registerLocation)
		
		return true;
	}
	
	private boolean unregisterLocation(String location) {
		// Unregister a location from the environment. It is removed from the system file locations.xml
		// Returns true if the location is registered, false otherwise.
		
		// TODO: library (unregisterLocation)
		
		return true;
	}
	
	public String getTitle() {		
		return "HPE Component Library";
	}
	
	public IHPEComponentLibraryItem getParent() {
		return null; // it is the root of the hierarchy.
	}
	
	public String getSystemLocation() {
		return "";
	}

	
}
