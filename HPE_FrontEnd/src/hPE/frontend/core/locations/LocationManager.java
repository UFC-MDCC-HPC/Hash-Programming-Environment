package hPE.frontend.core.locations;

import hPE.HPEPlugin;
import hPE.frontend.backend.locations.Location;
import hPE.frontend.backend.locations.LocationsFactory;
import hPE.frontend.backend.locations.impl.LocationsFactoryImpl;
import hPE.frontend.base.model.HPackage;
import hPE.location.HPE_Location_Server;
import hPE.location.HPE_Location_ServerService;
import hPE.location.HPE_Location_ServerServiceLocator;
import hPE.ui.preferences.DuplicateLocationException;
import hPE.ui.preferences.HPEPreferenceStore;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.rpc.ServiceException;

/**
 * 
 * @author Juliano Efson Sales
 * @since 15 Jul 2011
 * 
 */
public class LocationManager {

	protected static LocationManager instance;

	protected HPEPreferenceStore pStore;

	private HPE_Location_ServerService locationServerService;

	private LocationsFactory factory;

	private Map<String, Location> connectedLocations;

	protected LocationManager() {
		pStore = (HPEPreferenceStore) HPEPlugin.getDefault()
				.getPreferenceStore();

		locationServerService = new HPE_Location_ServerServiceLocator();
		factory = new LocationsFactoryImpl();
		connectedLocations = new HashMap<String, Location>();
	}

	public static LocationManager getInstance() {
		if (instance == null) {
			instance = new LocationManager();
		}
		return instance;
	}

	public Map<String, Location> getBackendLocations() {

		return pStore.getBackendSet();
	}

	public Map<String, Location> getCoreLocations() {

		return pStore.getLocationsSet();
	}

	public void addCoreLocation(String key, Location l)
			throws DuplicateLocationException {
		pStore.addLocation(key, l);
	}

	public void addBackendLocation(String key, Location l)
			throws DuplicateLocationException {
		pStore.addBackend(key, l);
	}

	public void removeLocation(String key) {
		pStore.removeLocation(key);
	}

	public void removeBackend(String key) {
		pStore.removeBackend(key);
	}

	public Location addConnectedLocation(String key) {
		Location l = getCoreLocations().get(key);
		connectedLocations.put(key, l);

		return l;
	}

	public Collection<Location> getConnectedLocations() {
		return connectedLocations.values();
	}

	public void removeConnectedLocation(String key) {
		connectedLocations.remove(key);
	}

	public void removeAllConnectedLocation() {
		connectedLocations.clear();
	}

	/**
	 * Test the location connection and return the server name if connection is
	 * ok.
	 * 
	 * @return server name.
	 */
	public String testConnection(Location location)
			throws MalformedURLException, Exception {

		String serverName = null;

		if (location != null && location.getUri() != null) {

			URL url = new URL(location.getUri());
			HPE_Location_Server server = locationServerService
					.getHPE_Location_Server(url);

			serverName = server.getName();
		}

		return serverName;
	}

	public String testConnection(String key) throws MalformedURLException,
			Exception {
		return testConnection(pStore.getLocationsSet().get(key));
	}

	public Location createNewLocation() {
		return factory.createLocation();
	}

	public List<HPackage> fetchPackagesFromLocation(Location location,
			boolean showObsolete) throws RemoteException,
			MalformedURLException, ServiceException {
		List<HPackage> packageList = null;

		if (location != null && location.getUri() != null) {
			packageList = new ArrayList<HPackage>();

			URL url = new URL(location.getUri());
			HPE_Location_Server server = locationServerService
					.getHPE_Location_Server(url);

			/*
			 * ATUALIZACAO: ISSO NAO E VERDADE. HA MAIS INFORMACOES TODO Esse
			 * servidor deveria retornar um XML. o valor dessa string retornada
			 * pelo webservice Ž algo do seguinte formato: package1 ( component1
			 * component2 ... ) package2 ( ) package3 ( component1 ) ... cada
			 * package Ž seguida pelo conjunto de components que possui. Se
			 * houver algum erro, o valor da str Ž null.
			 */
			String str = server.fetchPackages(showObsolete);

			if (str != null) {

				StringTokenizer token = new StringTokenizer(str);
				String aux;

				HPackage hPackage;
				while (token.hasMoreTokens()) {
					hPackage = new HPackage();
					hPackage.setPath(token.nextToken()); // package

					aux = token.nextToken(); // aux recebe "("
					aux = token.nextToken(); // aux recebe ")" ou Component

					while (!aux.equals(")")) {
						hPackage.addComponent(aux);
						aux = token.nextToken();
					}

					packageList.add(hPackage);
				}
			}
		}

		return packageList;
	}
}
