package hPE.core.library;

//import hPE.core.HLocationService;
//import hPE.core.LocationService;
import hPE.HPEProperties;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterface;
import hPE.location.HPE_Location_Server;
import hPE.location.HPE_Location_ServerService;
import hPE.location.HPE_Location_ServerServiceLocator;
import hPE.ui.preferences.PreferenceConstants;
import hPE.util.CommandLine;
import hPE.xml.component.ComponentType;
import hPE.xml.factory.HComponentFactory;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedRefInnerException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedSliceNamesException;
import hPE.xml.factory.HComponentFactoryImpl.UndefinedRefInnerException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

//TODO ja refatorado para o Properties.
public class HPELocationEntry {

	public static Hashtable<String, String> htable = new Hashtable<String, String>();

	@Deprecated
	//Use LocationManager Class
	public static List<String> fetchPackagesFromLocation(URI locationSite,
			boolean showObsolete) throws RemoteException, ServiceException {
		try {
			// Dada a uri de uma location, retorne a lista de packages.
			List<String> packagesList = new ArrayList<String>();

			String urlWS = locationSite.toString(); // EX:
			// "http://localhost:8080/WSLocationServer/services/LocationService";

			URL url = new URL(urlWS);

			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();

			HPE_Location_Server server = locationServerService.getHPE_Location_Server(url);

			String str = server.fetchPackages(showObsolete);

			/**
			 * o valor dessa string retornada pelo webservice � algo do
			 * seguinte formato: package1 ( component1 component2 ... ) package2
			 * ( ) package3 ( component1 ) ... cada package � seguida pelo
			 * conjunto de components que possui. Se houver algum erro, o valor
			 * da str ser� null
			 */
			if (str != null) {

				StringTokenizer token = new StringTokenizer(str);
				String p;
				String c = "";
				String aux;

				while (token.hasMoreTokens()) {
					p = token.nextToken(); // package

					aux = token.nextToken(); // aux recebe (
					aux = token.nextToken(); // aux recebe ) ou Component

					while (token.hasMoreTokens() && !aux.equals(")")) {
						c += aux + " "; // vai armazenar os components de um
						// package separados por espa�o
						aux = token.nextToken(); // aux recebe ) ou Component
					}
					packagesList.add(p);
					htable.put(p, c); // adiciona uma chave package e seus
					// components
					c = "";
				}
			}
			return packagesList;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> fetchComponents(URI locationSite,
			String[] packagePath) {
		/**
		 * retorne a lista de componentes de uma package relativa a uma location
		 * (lembre-se que uma package pode estar espalhada em varias locations)
		 */

		List<String> componentsList = new ArrayList<String>();

		String pk = "";
		pk = packagePath[0];
		for (int i = 1; i < packagePath.length; i++) {
			pk += "." + packagePath[i];
		}

		if (!htable.containsKey(pk)) { // se a package ainda n�o est� na
			// tabelahash devemos fzr um
			// fetchpackages para adiciona-la
			try {
				fetchPackagesFromLocation(locationSite, false);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		String str = htable.get(pk); // retorna todos o components numa string
		// separados por espa�o

		if (str != null) {
			StringTokenizer token = new StringTokenizer(str);
			String c;
			while (token.hasMoreTokens()) {
				c = token.nextToken();
				componentsList.add(c);
			}
		}

		return componentsList;
	}

	public static java.io.File getComponent(String[] pkName,
			String componentName, String version, URI locationSite)
			throws HPEComponentFileNotFound {
		java.io.File file = null;
		try {
			/**
			 * o codigo que escrevi abaixo pega o conteudo do component e
			 * escreve num arquivo xml nomeado como: packagename.component
			 */
			String pk = "";
			pk = pkName[0];
			for (int i = 1; i < pkName.length; i++) {
				pk += "." + pkName[i];
			}

			file = HComponentFactoryImpl.getCachePath(pk, componentName);

			if (!file.exists()) {

				URL url = new URL(locationSite.toString());

				HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
				HPE_Location_Server server = locationServerService
						.getHPE_Location_Server(url);
				String contents = server.getComponent(pk, componentName,
						version);

				if (!(contents == null)) {
					try {
						file.createNewFile();

						String fname = file.getAbsolutePath();
						BufferedWriter out = new BufferedWriter(new FileWriter(
								fname));
						out.write(contents);
						out.close();

					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					throw new HPEComponentFileNotFound();
				}
			}

		} catch (RemoteException e) {
			e.printStackTrace();

		} catch (ServiceException e) {
			e.printStackTrace();

			// } catch (HPEInvalidComponentResourceException e) {
			// e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}

	public static void getBinaryFile(String packageName, String componentName,
			String versionID, HBEAbstractFile binFile, URI locationSite) {

		try {
			URL url = new URL(locationSite.toString());

			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			HPE_Location_Server server = locationServerService
					.getHPE_Location_Server(url);
			String fileName = (new Path(binFile.getFileName()))
					.removeFileExtension().addFileExtension(
							binFile.getBinaryExtension()).toString();
			byte[] contents = server.getBinaryFile(packageName, componentName,
					versionID, fileName);

			File file = binFile.getBinaryPath().toFile();

			String path = file.getParent();
			File folder = new File(path);
			if (!folder.exists()) {
				folder.mkdir();
			}

			if (!file.exists()) {
				try {
					file.createNewFile();
					FileOutputStream fos = new FileOutputStream(file
							.getAbsolutePath());
					fos.write(contents);
					fos.close();

					String gacutil_path = HPEProperties.getInstance().getValue(
							PreferenceConstants.GACUTIL_PATH);
					// TODO sysout! usando o novo preference. Verificar o valor
					// retornado.
					System.out.println(PreferenceConstants.GACUTIL_PATH + ": "
							+ gacutil_path);

					// TODO refatorar de forma a criar um executor de comandos e
					// evitar esse tipo de c�digo espalhado.
					CommandLine.runCommand(new String[] { gacutil_path, "-i",
							fileName }, folder);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static String registerComponent(HComponent c, URI uri,
			String version, boolean freeSource) throws ServiceException,
			UndefinedRefInnerException, DuplicatedRefInnerException,
			DuplicatedSliceNamesException, IOException, CoreException,
			UncompiledSourcesException, InexistentSourcesException {

		String message;

		if (c.versionSupplied(version == null ? "1.0.0.0" : version)) {
			if (c.versionCompiled(version == null ? "1.0.0.0" : version)) {

				String urlWS = uri.toString(); // EX:
				// "http://localhost:8080/WSLocationServer/services/LocationService";

				URL url;
				url = new URL(urlWS);

				HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();

				HPE_Location_Server server = locationServerService
						.getHPE_Location_Server(url);

				String pkName = c.getPackagePath().toString();
				String ctName = c.getComponentName();
				String savedUri = c.getRemoteLocation();
				c.setRemoteURI(uri);

				HComponentFactory factory = HComponentFactoryImpl.eInstance;
				ComponentType cX = factory.marshallComponent(c);
				prepareForRegistering(cX, freeSource);
				IPath filePath = (new Path(c.getLocalLocation()))
						.removeLastSegments(1).append("temp")
						.append("temp.xml");
				// IFile file =
				// ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
				// /*TODO: Which file ?*/
				java.io.File file = HComponentFactoryImpl
						.getFileInWorkspace(filePath);
				factory.saveComponent(cX, file, null);
				String contents = readTextFile(file);
				file.delete();

				HashMap<String, byte[]> resources = new HashMap<String, byte[]>();
				fillWithBinaries(c, version == null ? "1.0.0.0" : version,
						resources);

				message = server.registerComponent(pkName, ctName, version,
						contents, resources);

				if (savedUri != null) {
					c.setRemoteURI(URI.createURI(savedUri));
				} else {
					c.setRemoteURI(null);
				}

			} else {
				throw new UncompiledSourcesException();
			}
		} else {
			throw new InexistentSourcesException();
		}

		return message;

	}

	private static void fillWithBinaries(HComponent c, String version,
			HashMap<String, byte[]> resources) throws CoreException,
			IOException {

		for (HInterface i : c.getInterfaces()) {
			if (i.getConfiguration() == c) {
				HBESourceVersion srcVersion = i.getSourceVersion(version);
				for (Object objFile : srcVersion.getFiles()) {
					HBEAbstractFile file = (HBEAbstractFile) objFile;
					IPath binPath = file.getBinaryPath();
					// IFile binFile =
					// ResourcesPlugin.getWorkspace().getRoot().getFile(binPath);
					java.io.File binFile = HComponentFactoryImpl
							.getFileInWorkspace(binPath);
					InputStream is = new FileInputStream(binFile);
					byte[] contents = new byte[is.available()];
					is.read(contents);
					String fileID = makeFileID(i, file);
					resources.put(fileID, contents);
					is.close();
				}
			}

		}
	}

	private static String makeFileID(HHasExternalReferences i,
			HBEAbstractFile file) {
		IPath filePath = new Path(file.getFileName());
		String fileName = filePath.removeFileExtension().addFileExtension(
				file.getBinaryExtension()).toString();

		return fileName;
	}

	private static String readTextFile(java.io.File file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		String texto = "";
		String str = in.readLine();
		while (str != null) {
			texto += str + "\n";
			str = in.readLine();
		}
		in.close();
		return texto;
	}

	private static void prepareForRegistering(ComponentType cx,
			boolean freeSource) {
		// TODO Auto-generated method stub

	}

	public static String fetchLocationName(URI uri)
			throws MalformedURLException, RemoteException, ServiceException {
		String name = null;

		List<String> packagesList = new ArrayList<String>();

		String urlWS = uri.toString(); // EX:
		// "http://localhost:8080/WSLocationServer/services/LocationService";

		URL url;
		url = new URL(urlWS);

		HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();

		HPE_Location_Server server = locationServerService
				.getHPE_Location_Server(url);

		name = server.getName();

		return name;
	}

	public static String getLocationPresentationMessage(URI uri)
			throws RemoteException, ServiceException, MalformedURLException {

		String message = "fail";

		List<String> packagesList = new ArrayList<String>();

		String urlWS = uri.toString(); // EX:
		// "http://localhost:8080/WSLocationServer/services/LocationService";

		URL url;
		url = new URL(urlWS);

		HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();

		HPE_Location_Server server = locationServerService
				.getHPE_Location_Server(url);

		message = server.getPresentationMessage();

		return message;
	}

	public static String markAsObsolete(HComponent c, URI uri, String version)
			throws RemoteException, ServiceException, MalformedURLException {
		String urlWS = uri.toString(); // EX:
		// "http://localhost:8080/WSLocationServer/services/LocationService";

		URL url = new URL(urlWS);

		HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();

		HPE_Location_Server server = locationServerService
				.getHPE_Location_Server(url);

		String pkName = c.getPackagePath().toString();
		String ctName = c.getComponentName();

		String message = server.markAsObsolete(pkName, ctName, version);

		return message;
	}

	public static String unregisterComponent(HComponent c, URI uri,
			String version) throws MalformedURLException, ServiceException,
			RemoteException {
		String message = "";

		String urlWS = uri.toString(); // EX:
		// "http://localhost:8080/WSLocationServer/services/LocationService";

		URL url = new URL(urlWS);

		HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();

		HPE_Location_Server server = locationServerService
				.getHPE_Location_Server(url);

		String pkName = c.getPackagePath().toString();
		String ctName = c.getComponentName();

		message = server.unregisterComponent(pkName, ctName, version);

		return message;
	}

}
