package hPE.core.library.model.classes;

import hPE.core.library.model.interfaces.IHPEComponentLibrary;
import hPE.frontend.backend.locations.Location;
import hPE.frontend.base.model.HPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

//Faz o papel de raiz da arvore de pacotes.
public class HPEComponentLibrary extends HPEComponentLibraryItem implements
		IHPEComponentLibrary {

	private Map<String, LPackage> packagesMap;

	public HPEComponentLibrary() {
		super();
		title = "HPE Component Library";
		packagesMap = new HashMap<String, LPackage>();
		// readFrom(locationNameList);
	}

	@Deprecated
	protected void readFrom(Object model) {

	}

	public void showPackages(List<HPackage> packageList, Location location, boolean showObsolete) {
		if (packageList != null) {
			String name;
			for (HPackage hPackage : packageList) {
				name = hPackage.getPath();
				LPackage lp = packagesMap.get(name);
				if (lp == null) {
					lp = new LPackage(this, name.split(":"));
					packagesMap.put(name, lp);

					addChild(lp);
				}

				lp.addLocation(URI.createURI(location.getUri()));
			}
		}
	}

	//TODO Apagar
//	public void readLibrary(List<URI> locationNameList) {
//		// Takes a set of location names and builds location objects.
//
//		Map<String, ILPackage> allPks = new HashMap<String, ILPackage>();
//
//		clearChildren();
//
//		for (URI locationSite : locationNameList) {
//
//			List<String> pks = null;
//			try {
//				pks = HPELocationEntry.fetchPackagesFromLocation(locationSite,
//						showObsolete);
//			} catch (RemoteException e) {
//
//				MessageDialog message = new MessageDialog(
//						HPEComponentLibraryView.getLast().getSite().getShell(),
//						"Location Fetch Error", null,
//						"Unable to reach location at \n" + locationSite,
//						MessageDialog.ERROR, new String[] { "Ok" }, 0);
//				message.open();
//				message.close();
//				e.printStackTrace();
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			}
//
//			if (pks != null) {
//				for (String pkName : pks) {
//					if (allPks.containsKey(pkName)) {
//						allPks.get(pkName).addLocation(locationSite);
//					} else {
//						packageNames.add(pkName);
//						ILPackage pk = new LPackage(this, pkName.split(":"));
//						pk.addLocation(locationSite);
//						addChild(pk);
//					}
//				}
//			}
//		}
//	}

	@Deprecated //TODO remover assim que puder.
	public List getLocations() {
		return getChildren();
	}

	@Deprecated //TODO remover assim que puder.
	public String getSystemLocation() {
		return "";
	}

	@Override
	public void clearChildren() {
		packagesMap.clear();
		super.clearChildren();
	}

	

}
