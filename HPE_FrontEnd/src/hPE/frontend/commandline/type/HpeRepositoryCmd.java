package hPE.frontend.commandline.type;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import hPE.core.library.HPEComponentLibraryView;
import hPE.core.library.HPELocationEntry;
import hPE.core.library.HPELocationFileTraversor;
import hPE.core.library.InexistentSourcesException;
import hPE.core.library.UncompiledSourcesException;
import hPE.core.library.model.classes.HPEComponentLibrary;
import hPE.frontend.CoreLocationList;
import hPE.frontend.CoreLocationList.CoreLocationInfo;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.commandline.exception.ArgException;
import hPE.frontend.commandline.exception.CmdException;
import hPE.frontend.commandline.util.HpePrinter;
import hPE.frontend.commandline.util.Utilities;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HPEInvalidComponentResourceException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedRefInnerException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedSliceNamesException;
import hPE.xml.factory.HComponentFactoryImpl.UndefinedRefInnerException;

public class HpeRepositoryCmd implements HpeGenericCmd{

	public static int REPOSITORY_LIST_COMMAND_INDEX = 0;
	public static int REPOSITORY_REGISTER_COMMAND_INDEX = 0;
	public static int REPOSITORY_UNREGISTER_COMMAND_INDEX = 0;
	public static int REPOSITORY_OBSOLETE_COMMAND_INDEX = 0;
	public static int REPOSITORY_LOCATION_COMMAND_INDEX = 0;
	public static int REPOSITORY_LOCATION_ADD_COMMAND_INDEX = 1;
	public static int REPOSITORY_LOCATION_REMOVE_COMMAND_INDEX = 1;
	public static int REPOSITORY_LOCATION_LIST_COMMAND_INDEX = 1;

	public static String REPOSITORY_LIST_COMMAND_TOKEN = "list";
	public static String REPOSITORY_REGISTER_COMMAND_TOKEN = "register";
	public static String REPOSITORY_UNREGISTER_COMMAND_TOKEN = "unregister";
	public static String REPOSITORY_OBSOLETE_COMMAND_TOKEN = "obsolete";
	public static String REPOSITORY_LOCATION_COMMAND_TOKEN = "location";
	public static String REPOSITORY_LOCATION_ADD_COMMAND_TOKEN = "add";
	public static String REPOSITORY_LOCATION_REMOVE_COMMAND_TOKEN = "remove";
	public static String REPOSITORY_LOCATION_LIST_COMMAND_TOKEN = "list";
	
	
	@Override
	public void action(String[] args) throws ArgException, CmdException{

		if (args == null || args.length == 0) {
			HpePrinter.out(help());
			throw new ArgException();
		}
		
		if (args[REPOSITORY_LIST_COMMAND_INDEX].equals(REPOSITORY_LIST_COMMAND_TOKEN)) {
		   action_list(args);	
		} else if (args[REPOSITORY_REGISTER_COMMAND_INDEX].equals(REPOSITORY_REGISTER_COMMAND_TOKEN)) {
		   action_register(args);
		} else if (args[REPOSITORY_UNREGISTER_COMMAND_INDEX].equals(REPOSITORY_UNREGISTER_COMMAND_TOKEN)) {
		   action_unregister(args);
		} else if (args[REPOSITORY_OBSOLETE_COMMAND_INDEX].equals(REPOSITORY_OBSOLETE_COMMAND_TOKEN)) {
		   action_obsolete(args);
		} else if (args[REPOSITORY_LOCATION_COMMAND_INDEX].equals(REPOSITORY_LOCATION_COMMAND_TOKEN)) {
		   action_location(args);
		} else {
		   HpePrinter.out(this.help());
		   throw new ArgException("unrecognized repository command.");
		}
		
	}

   private void action_location(String[] args) throws ArgException, CmdException {
	   
	   if (args[REPOSITORY_LOCATION_ADD_COMMAND_INDEX].equals(REPOSITORY_LOCATION_ADD_COMMAND_TOKEN)) {
		   action_location_add(args);	
		} else if (args[REPOSITORY_LOCATION_REMOVE_COMMAND_INDEX].equals(REPOSITORY_LOCATION_REMOVE_COMMAND_TOKEN)) {
		   action_location_remove(args);
		} else if (args[REPOSITORY_LOCATION_LIST_COMMAND_INDEX].equals(REPOSITORY_LOCATION_LIST_COMMAND_TOKEN)) {
		   action_location_list(args);
		} else {
		   HpePrinter.out(this.help());
		   throw new ArgException("unrecognized repository location command.");
		}		
	}

   private void action_location_add(String[] args) throws ArgException, CmdException 
   {
	   try {
//		 String loc_uri = args[REPOSITORY_LOCATION_ADD_URI_INDEX];
	   
		 List<String> allowedArgs = new ArrayList<String>();
		 allowedArgs.add("-uri");		
		 Map<String, String> options_register = traverseOptions(args, allowedArgs, 2);
	   
		 String loc_uri = null;
		 if (options_register.containsKey("uri")) {
			 loc_uri = options_register.get("uri");
		 } else {
		     String msg = "Location address must be specified after '-uri'\n";
		     throw new ArgException(msg);
		 }
		
		 String loc_name = HPELocationEntry.fetchLocationName(URI.createURI(loc_uri));
		 String message = HPELocationEntry.getLocationPresentationMessage(URI.createURI(loc_uri));
		 
		 Map<String,CoreLocationInfo> coreLocations = new HashMap<String,CoreLocationInfo>();
		 CoreLocationList.readCoreLocationsFile(coreLocations);
		 if (coreLocations.containsKey(loc_name)) {
			 HpePrinter.out("A locations named " + loc_name + " is already registered.");
		 } else {
			 CoreLocationInfo new_loc = new CoreLocationInfo();
			 new_loc.name = loc_name;
			 new_loc.locURI = loc_uri;
			 coreLocations.put(loc_name, new_loc);	 
			 CoreLocationList.saveData(coreLocations);
			 HpePrinter.out("Location " + loc_name + " added !");
		     HpePrinter.out(message);
		 }
	   } catch (ServiceException e) {
		   String msg = "Connection error when fetching location information.";
		   CmdException ee = new CmdException(msg);
		   ee.initCause(e);
		   throw ee;
	   } catch (MalformedURLException e) {
		   String msg = "Bad location address";
		   CmdException ee = new CmdException(msg);
		   ee.initCause(e);
		   throw ee;
		   
	   } catch (RemoteException e) {
		   String msg = "Connection error when fetching location information.";
		   CmdException ee = new CmdException(msg);
		   ee.initCause(e);
		   throw ee;
	   }
		 
   }

   private void action_location_list(String[] args) throws ArgException {
	 
		List<String> allowedArgs = new ArrayList<String>();
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 2);

		Map<String,CoreLocationInfo> coreLocations = new HashMap<String,CoreLocationInfo>();
	    CoreLocationList.readCoreLocationsFile(coreLocations);
	    for (Entry<String, CoreLocationInfo> cl : coreLocations.entrySet()) {
		    CoreLocationInfo loc_info = cl.getValue();
		    HpePrinter.out(loc_info.name + " at " + loc_info.locURI);
	    }
	 	 
   }

   private void action_location_remove(String[] args) throws ArgException {
	   
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-name");
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 2);

		 String loc_name = null;
		 if (options_register.containsKey("name")) {
			 loc_name = options_register.get("name");
		 } else {
		     String msg = "Location name must be specified after '-name'\n";
		     throw new ArgException(msg);
		 }
	   
		 Map<String,CoreLocationInfo> coreLocations = new HashMap<String,CoreLocationInfo>();
		 CoreLocationList.readCoreLocationsFile(coreLocations);
		 if (!coreLocations.containsKey(loc_name)) {
			 HpePrinter.out("A locations named " + loc_name + " is not registered.");
		 } else {
			 coreLocations.remove(loc_name);	 
			 CoreLocationList.saveData(coreLocations);
		     HpePrinter.out("Location " + loc_name + " removed.");
		 }	   
   }


private void action_obsolete(String[] args) throws CmdException, ArgException {
	List<String> allowedArgs = new ArrayList<String>();
	allowedArgs.add("-version");
	allowedArgs.add("-location");
	allowedArgs.add("-component");
	Map<String, String> options_register = traverseOptions(args, allowedArgs, 1);
    	
		String version = null;
		if (options_register.containsKey("version")) {
			version = options_register.get("version");
		}
		
		URI location = null;
		String location_name = null;
		if (options_register.containsKey("location")) {
			location_name = options_register.get("location");
			location = CoreLocationList.fetchURI(location_name);
			if (location == null) {
				String msg = "Location " + location_name + " not registered.";
				HpePrinter.out(msg);
				throw new ArgException(msg);
			}
			
		} else {
			throw new ArgException("A location is required to be specified by using -location.");
		}
		
		String cName = null;
		if (options_register.containsKey("component")) {
			cName = options_register.get("component");
		} else {
			throw new ArgException("A component is required to be specified by using '-component'.");
		}
		
		try {

			URI innerUri = URI.createURI(Path.SEPARATOR + cName + Path.SEPARATOR + cName.substring(cName.lastIndexOf('.') + 1,cName.length()) + ".hpe");

			HComponent c = (new HComponentFactoryImpl()).loadComponent(innerUri ,false, false, false, false, true);
		
			String message = HPELocationEntry.markAsObsolete(c, location, version);
			
			HpePrinter.out(message);
			
		} catch (ServiceException e) {
			throw new CmdException("");
		} catch (IOException e) {
			CmdException ee = new CmdException("Error unregisteting component");
			ee.initCause(e);
			throw ee;
		} catch (HPEInvalidComponentResourceException e) {
			CmdException ee = new CmdException("Error loading component before unregistering.");
			ee.initCause(e);
			throw ee;
		}
		
	}


/*
	* repository unregister <qualified_cref>  
	* 
	* 
	*/
	private void action_unregister(String[] args) throws ArgException, CmdException {

		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-version");
		allowedArgs.add("-location");
		allowedArgs.add("-component");
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 1);
    	
		String version = null;
		if (options_register.containsKey("version")) {
			version = options_register.get("version");
		}
		
		URI location = null;
		String location_name = null;
		if (options_register.containsKey("location")) {
			location_name = options_register.get("location");
			location = CoreLocationList.fetchURI(location_name);
			if (location == null) {
				String msg = "Location " + location_name + " not registered.";
				HpePrinter.out(msg);
				throw new ArgException(msg);
			}
			
		} else {
			throw new ArgException("A location is required to be specified by using -location.");
		}
		
		String cName = null;
		if (options_register.containsKey("component")) {
			cName = options_register.get("component");
		} else {
			throw new ArgException("A component is required to be specified by using '-component'.");
		}
		
		try {

			URI innerUri = URI.createURI(Path.SEPARATOR + cName + Path.SEPARATOR + cName.substring(cName.lastIndexOf('.') + 1,cName.length()) + ".hpe");

			HComponent c = (new HComponentFactoryImpl()).loadComponent(innerUri ,false, false, false, false, true);
		
			String message = HPELocationEntry.unregisterComponent(c, location, version);
			
			HpePrinter.out(message);
			
		} catch (ServiceException e) {
			throw new CmdException("");
		} catch (IOException e) {
			CmdException ee = new CmdException("Error unregisteting component");
			ee.initCause(e);
			throw ee;
		} catch (HPEInvalidComponentResourceException e) {
			CmdException ee = new CmdException("Error loading component before unregistering.");
			ee.initCause(e);
			throw ee;
		}
	}

/*
	* repository register <qualified_cref> -component <qualified_name> -location <uri> [-version <version> -free_source]  
	* 
	* 
	*/
    private void action_register(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-free_source");
		allowedArgs.add("-version");
		allowedArgs.add("-location");
		allowedArgs.add("-component");
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 1);
    	
		boolean free_source = options_register.containsKey("free_source");
		
		String version = null;
		if (options_register.containsKey("version")) {
			version = options_register.get("version");
		}
		
		URI location = null;
		String location_name = null;
		if (options_register.containsKey("location")) {
			location_name = options_register.get("location");
			location = CoreLocationList.fetchURI(location_name);
			if (location == null) {
				String msg = "Location " + location_name + " not registered.";
				HpePrinter.out(msg);
				throw new ArgException(msg);
			}
			
		} else {
			throw new ArgException("A location is required to be specified by using -location.");
		}
		
		String cName = null;
		if (options_register.containsKey("component")) {
			cName = options_register.get("component");
		} else {
			throw new ArgException("A component is required to be specified by using '-component'.");
		}
		
		try {

			URI innerUri = URI.createURI(Path.SEPARATOR + cName + Path.SEPARATOR + cName.substring(cName.lastIndexOf('.') + 1,cName.length()) + ".hpe");

			HComponent c = (new HComponentFactoryImpl()).loadComponent(innerUri ,false, false, false, false, true);
		
			String message = HPELocationEntry.registerComponent(c, location, version, free_source);
			
			HpePrinter.out(message);
			
		} catch (ServiceException e) {
			throw new CmdException("");
		} catch (UndefinedRefInnerException e) {
			CmdException ee = new CmdException("Error loading component before registering.");
			ee.initCause(e);
			throw ee;
		} catch (DuplicatedRefInnerException e) {
			CmdException ee = new CmdException("Error loading component before registering.");
			ee.initCause(e);
			throw ee;
		} catch (DuplicatedSliceNamesException e) {
			CmdException ee = new CmdException("Error loading component before registering.");
			ee.initCause(e);
			throw ee;
		} catch (IOException e) {
			CmdException ee = new CmdException("Error registeting component");
			ee.initCause(e);
			throw ee;
		} catch (CoreException e) {
			CmdException ee = new CmdException("Error registeting component");
			ee.initCause(e);
			throw ee;
		} catch (UncompiledSourcesException e) {
			CmdException ee = new CmdException("Component has uncompiled sources.");
			ee.initCause(e);
			throw ee;
		} catch (InexistentSourcesException e) {
			CmdException ee = new CmdException("Component does not have some required sources.");
			ee.initCause(e);
			throw ee;
		} catch (HPEInvalidComponentResourceException e) {
			CmdException ee = new CmdException("Error loading component before registering.");
			ee.initCause(e);
			throw ee;
		}
    	
	}
    
/*
	* repository list [-package <qualified_pattern_cref>] [-kind <kind_ref>] [-show_obsolete]  
	* 
	* 
	*/
	private void action_list(String[] args) throws ArgException {

		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-package");
		allowedArgs.add("-show_obsolete");
		Map<String, String> options_list = traverseOptions(args, allowedArgs, 1);
		
		boolean showObsolete = options_list.containsKey("show_obsolete");
		// HPEComponentLibrary lib = HPEComponentLibraryView.getInitialInput(showObsolete);
		
		String pattern = "*";
		if (options_list.containsKey("package")) {
			pattern = options_list.get("package");
		}
		
		List<URI> locations = CoreLocationList.fetchLocations();
		for (URI locationSite : locations) {		
		     List<String> pks = null;
			try {
				pks = HPELocationEntry.fetchPackagesFromLocation(locationSite, showObsolete);
				for (String pk : pks) {
					List<String> cs = HPELocationEntry.fetchComponents(locationSite, pk.split("[.]"));
					for (String c_ : cs) {
						String[] cc = c_.split(":");
						
						String pkName = pk + "." + cc[0]; 
						if (Utilities.match(pkName, pattern) && (showObsolete || (!showObsolete && cc[2].equals("active")))) {
						   HpePrinter.out(pkName + (cc[1].equals("") ? "" : " - version " + cc[1]) + (showObsolete ? " - " + cc[2] : "") + "\n");
						}
					}
				}
				
			} catch (RemoteException e) {
				HpePrinter.out("Location "+ locationSite + " not reachable !");
				// e.printStackTrace();
			} catch (ServiceException e) {
				HpePrinter.out("Location "+ locationSite + " not reachable !");
				// e.printStackTrace();
			}
		}
		
				
	}
	private Map<String, String> traverseOptions(String[] args, List<String> allowedArgs, int beginIndex) throws ArgException {
		
		Map<String, String> options_register = new HashMap<String,String>();
				
		for (int i=beginIndex; i<args.length; i++) 
		{
			String arg = args[i];
			if (allowedArgs.contains(arg)) {
			    if (arg.equals("-version")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException();
			    	}
			       options_register.put("version", args[++i]);
			    }
			    else if (arg.equals("-component")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException();
			    	}
				   options_register.put("component", args[++i]);
			    }
			    else if (arg.equals("-uri")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException();
			    	}
				   options_register.put("uri", args[++i]);
			    }
				else if (arg.equals("-location")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException();
			    	}
				   options_register.put("location", args[++i]);    	
			    } else if (arg.equals("-free_source")) {
			       options_register.put("free_source", "true");
			    } else if (arg.equals("-package")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException();
			    	}
			    	options_register.put("package", args[++i]);    	
			    } else if (arg.equals("-kind")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException();
			    	}
			    	options_register.put("kind", args[++i]);
			    } else if (arg.equals("-name")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException();
			    	}
			    	options_register.put("name", args[++i]);
			    } else if (arg.equals("-show_obsolete")) {
			    	options_register.put("show_obsolete", "true");
			    }

				else {
			    	System.err.println("UNEXPECTED ERROR: argument is not included in the list of allowed arguments.");
					throw new ArgException("unknown argument: " + arg);
			    }
			}
			else {
				HpePrinter.out(help());
				throw new ArgException("unknown argument: " + arg + "\n");
		    }
		}
				
		return options_register;
	}

	
	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "\n" +
		       " repository register -component <component_id> -location <location_name> [-version <version_id>] [-free_source] \n" +
		       " repository unregister -component <component_id> -location <location_name> [-version <version_id>] \n" +
		       " repository obsolete -component <component_id> -location <location_name> [-version <version_id>] \n" +
		       " repository list [-package <pattern>] [-kind <kind>] [-show_obsolete] \n" + 
		       " repository location add <location_name> <uri> \n" + 
		       " repository location remove <location_name>  \n" + 
		       " \n" +
		       " where:\n" +
		       " \n" +
		       "  * <component_id> is a qualified name of a component (ex: skeleton.farm.Collector)\n" + 
		       "  * <uri> is the uri address of the location \n" +
		       "  * <version_id> is the version of component, whose format is \"X.X.X.X\" \n" + 
		       "  * <pattern> is a <component_id> with the wildcard '*' \n\n";
	}

}
