package hPE.frontend.library.model.classes;

import hPE.frontend.library.HPELocationEntry;
import hPE.frontend.library.model.interfaces.IHPEComponentLibrary;
import hPE.frontend.library.model.interfaces.IHPEComponentLibraryItem;
import hPE.frontend.library.model.interfaces.ILPackage;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.eclipse.emf.common.util.URI;

public class HPEComponentLibrary extends HPEComponentLibraryItem implements IHPEComponentLibrary {

	public HPEComponentLibrary(List<URI> locationNameList) {
		super();
		readFrom(locationNameList);
	}
		
	protected void readFrom(Object model) {
	    readLibrary((List<URI>) model);
	}
	
	public void readLibrary(List<URI> locationNameList) {
		// Takes a set of location names and builds location objects.
				
		Map<String,ILPackage> allPks = new HashMap<String,ILPackage>();
		
		clearChildren();
		
		for (URI locationSite : locationNameList) {
		
		    List<String> pks=null;
			try {
				pks = HPELocationEntry.fetchPackagesFromLocation(locationSite);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			Iterator<String> ipks = pks.iterator();
		    while (ipks.hasNext()) {
		    
		    	String pkName = ipks.next();
		    	
			    if (allPks.containsKey(pkName)) {
			       allPks.get(pkName).addLocation(locationSite);			       
		        } else {
		        	ILPackage pk = new LPackage(this,pkName.split(":"));
		        	pk.addLocation(locationSite);
		        	addChild(pk);
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
