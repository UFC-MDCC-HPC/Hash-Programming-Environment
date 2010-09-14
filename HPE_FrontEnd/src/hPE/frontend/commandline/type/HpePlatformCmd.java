package hPE.frontend.commandline.type;

import hPE.core.library.HPELocationEntry;

import hPE.frontend.BackEndLocationList;
import hPE.frontend.HPEKinds;
import hPE.frontend.BackEndLocationList.BackEndLocationInfo;
import hPE.frontend.BackEndLocationList.DeployedComponentInfo;
import hPE.frontend.BackEndLocationList.DeployedComponentInfoParameter;
import hPE.frontend.CoreLocationList.CoreLocationInfo;
import hPE.frontend.backend.HPEPlatform;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.commandline.exception.ArgException;
import hPE.frontend.commandline.exception.CmdException;
import hPE.frontend.commandline.util.HpePrinter;
import hPE.frontend.commandline.util.Utilities;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HPEInvalidComponentResourceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class HpePlatformCmd implements HpeGenericCmd{

	public static int PLATFORM_DEPLOY_COMMAND_INDEX = 0;
	public static int PLATFORM_RUN_COMMAND_INDEX = 0;
	public static int PLATFORM_LIST_COMMAND_INDEX = 0;
	public static int PLATFORM_LOCATION_COMMAND_INDEX = 0;
	public static int PLATFORM_LOCATION_ADD_COMMAND_INDEX = 1;
	public static int PLATFORM_LOCATION_REMOVE_COMMAND_INDEX = 1;
	public static int PLATFORM_LOCATION_LIST_COMMAND_INDEX = 1;

	public static String PLATFORM_DEPLOY_COMMAND_TOKEN = "deploy";
	public static String PLATFORM_RUN_COMMAND_TOKEN = "run";
	public static String PLATFORM_LIST_COMMAND_TOKEN = "list";
	public static String PLATFORM_LOCATION_COMMAND_TOKEN = "location";
	public static String PLATFORM_LOCATION_ADD_COMMAND_TOKEN = "add";
	public static String PLATFORM_LOCATION_REMOVE_COMMAND_TOKEN = "remove";
	public static String PLATFORM_LOCATION_LIST_COMMAND_TOKEN = "list";

	@Override
	public void action(String[] args) throws ArgException, CmdException {

		if (args == null || args.length == 0) {
			HpePrinter.out(help());
			throw new ArgException();
		}
		
		if (args[PLATFORM_DEPLOY_COMMAND_INDEX].equals(PLATFORM_DEPLOY_COMMAND_TOKEN)) {
		   action_deploy(args);	
		} else if (args[PLATFORM_RUN_COMMAND_INDEX].equals(PLATFORM_RUN_COMMAND_TOKEN)) {
		   action_run(args);
		} else if (args[PLATFORM_LIST_COMMAND_INDEX].equals(PLATFORM_LIST_COMMAND_TOKEN)) {
		   action_list(args);
		} else if (args[PLATFORM_LOCATION_COMMAND_INDEX].equals(PLATFORM_LOCATION_COMMAND_TOKEN)) {
		   action_location(args);
		} else {
		   HpePrinter.out(this.help());
		   throw new ArgException("unrecognized platform command.");
		}
	}

	private void action_location(String[] args) throws ArgException {
		
		   if (PLATFORM_LOCATION_ADD_COMMAND_INDEX >= args.length) {
			  String msg = "What to do ? add, remove or list ?";
			  throw new ArgException(msg);
		   }		
		
		   if (args[PLATFORM_LOCATION_ADD_COMMAND_INDEX].equals(PLATFORM_LOCATION_ADD_COMMAND_TOKEN)) {
			   action_location_add(args);	
			} else if (args[PLATFORM_LOCATION_REMOVE_COMMAND_INDEX].equals(PLATFORM_LOCATION_REMOVE_COMMAND_TOKEN)) {
			   action_location_remove(args);
			} else if (args[PLATFORM_LOCATION_REMOVE_COMMAND_INDEX].equals(PLATFORM_LOCATION_LIST_COMMAND_TOKEN)) {
			   action_location_list(args);
			} else {
			   HpePrinter.out(this.help());
			   throw new ArgException("unrecognized repository location command.");
			}		
		
	}

	private void action_location_list(String[] args) throws ArgException {

		 List<String> allowedArgs = new ArrayList<String>();
		 Map<String, String> options_register = traverseOptions(args, allowedArgs, 2);
		
		 Map<String, BackEndLocationInfo> coreLocations = new HashMap<String,BackEndLocationInfo>();
		 BackEndLocationList.loadBackEndsInfo(coreLocations);
		 for (Entry<String, BackEndLocationInfo> cl : coreLocations.entrySet()) {
			 BackEndLocationInfo loc_info = cl.getValue();
			 HpePrinter.out(loc_info.name + " @ " + loc_info.locURI + "\n");
		 }

	}

	private void action_list(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-kind");
		allowedArgs.add("-enumerators");
		allowedArgs.add("-context");
		allowedArgs.add("-only_abstract");
		allowedArgs.add("-only_concrete");
		allowedArgs.add("-location");
		allowedArgs.add("-package");
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 1);

		String which_kind = null;
		if (options_register.containsKey("kind")) {
			which_kind = options_register.get("kind");
		}

		boolean show_enumerators = options_register.containsKey("enumerators");
		boolean show_context = options_register.containsKey("context");

		boolean show_abstract = options_register.containsKey("only_abstract");
		boolean show_concrete = options_register.containsKey("only_concrete");
		if (!show_abstract && !show_concrete) {
			show_abstract = show_concrete = true;
		} else if (show_abstract && show_concrete) {
			String msg = "Do not use both '-only_abstract' and '-only_concrete'";
			HpePrinter.out(msg);
			throw new ArgException(msg);
		}
		
		URI location = null;
		String location_name = null;
		if (options_register.containsKey("location")) {
			location_name = options_register.get("location");
			location = BackEndLocationList.fetchURI(location_name);
			if (location == null) {
				String msg = "Location " + location_name + " not registered.";
				HpePrinter.out(msg);
				throw new ArgException(msg);
			}
			
		} else {
			throw new ArgException("A location is required to be specified by using '-location'.");
		}

		String pattern = "*";
		if (options_register.containsKey("package")) {
			pattern = options_register.get("package");
		}
		
		Map<Integer, DeployedComponentInfo> dcListConcrete = new HashMap<Integer, DeployedComponentInfo>();
		Map<Integer, DeployedComponentInfo> dcListAbstract = new HashMap<Integer, DeployedComponentInfo>();
		
		try {
			BackEndLocationList.loadDeployedComponentsInfo(location.toString(), dcListAbstract, dcListConcrete);
			
			HpePrinter.out("\n--- Abstract Components ---\n");
			if (show_abstract) {
				action_list_components(dcListAbstract, which_kind, pattern, show_enumerators, show_context);
				
			} 
			
			HpePrinter.out("\n--- Concrete Components ---\n");
			if (show_concrete) {
				action_list_components(dcListConcrete, which_kind, pattern, show_enumerators, show_context);
			}
			
			
		} catch (IOException e) {
			String msg = "Error loading deployed components in " + location_name + ".";
			HpePrinter.out(msg);
			CmdException ee = new CmdException(msg);
			ee.initCause(e);
			throw ee;
		} catch (ServiceException e) {
			String msg = "Error loading deployed components in " + location_name + ".";
			HpePrinter.out(msg);
			CmdException ee = new CmdException(msg);
			ee.initCause(e);
			throw ee;
		}
		

	}

	private void action_list_components(
			Map<Integer, DeployedComponentInfo> dcListAbstract, String which_kind, String pattern, boolean show_enumerators, boolean show_context) {
		
		for (DeployedComponentInfo cAbs : dcListAbstract.values()) {
			String qname = buildQName(cAbs.thePackage, cAbs.name);
			String kind = HPEKinds.kind(cAbs.kind);
			if (which_kind == null || kind.equals(which_kind)) {
				if (Utilities.match(qname,pattern)) {
					
					String parameters = "";
					if (show_context && cAbs.parameters.length > 0) {
						parameters += " [";
						for (DeployedComponentInfoParameter c : cAbs.parameters) {
							parameters += c.parameter_id /*+ ":"+ c.component_name */ + ", ";
						}
						parameters += "]";
					}

					String enumerators = "";
					if (show_enumerators && cAbs.enumerators.length > 0) {
						enumerators += " - ";
						for (String e : cAbs.enumerators) {
							enumerators += e;	
						}
					}
					
					HpePrinter.out(kind + " " + qname + parameters + enumerators + "\n");
				}						
			}
		}
		
	}

	private String buildQName(String[] thePackage, String name) {

		String qcname = "";
		int i = 0;
		for (i=0; i < thePackage.length; i++) {			
		    	qcname = thePackage[i] + ".";
		}
		
		return qcname + name;
	}

	
    private void action_location_remove(String[] args) throws ArgException {

		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-name");
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 2);

		 String loc_name = null;
		 if (options_register.containsKey("name")) {
			 loc_name = options_register.get("name");
		 } else {
		     String msg = "Back-End name must be specified after '-name'\n";
		     throw new ArgException(msg);
		 }
    	
		 Map<String, BackEndLocationInfo> backendLocations = new HashMap<String, BackEndLocationInfo>();
		 BackEndLocationList.loadBackEndsInfo(backendLocations);
		 if (!backendLocations.containsKey(loc_name)) {
			 HpePrinter.out("A Back-End named " + loc_name + " is not registered.");
		 } else {
			 backendLocations.remove(loc_name);	 
			 BackEndLocationList.saveData(backendLocations);
		     HpePrinter.out("Back-End " + loc_name + " removed.");
		 }
		 
	}

	private void action_location_add(String[] args) throws ArgException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-user");
		allowedArgs.add("-password");
		allowedArgs.add("-dir");
		allowedArgs.add("-uri");		
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 2);

		 String loc_uri = null;
		 if (options_register.containsKey("uri")) {
			 loc_uri = options_register.get("uri");
		 } else {
		     String msg = "Back-End address must be specified after '-uri'\n";
		     throw new ArgException(msg);
		 }
		 
    	// String loc_uri = args[PLATFORM_LOCATION_ADD_COMMAND_INDEX + 1];
		
		 String login = null;
		 if (options_register.containsKey("user")) {
	 		login = options_register.get("user");
		 }
		
		 String password = null;
 		 if (options_register.containsKey("password")) {
	 		password = options_register.get("password");
		 }

		 IPath curdir = null;
 		 if (options_register.containsKey("dir")) {
	 		curdir = new Path(options_register.get("dir"));
		 }		
				 
		 String loc_name = BackEndLocationList.fetchLocationName(URI.createURI(loc_uri));
		 String message = BackEndLocationList.getLocationPresentationMessage(URI.createURI(loc_uri));

		 Map<String, BackEndLocationInfo> backendLocations = new HashMap<String,BackEndLocationInfo>();
		 BackEndLocationList.loadBackEndsInfo(backendLocations);
		 if (backendLocations.containsKey(loc_name)) {
			 HpePrinter.out("A locations named " + loc_name + " is already registered.\n");
		 } else {
			 BackEndLocationInfo new_loc = new BackEndLocationInfo();
			 new_loc.name = loc_name;
			 new_loc.locURI = loc_uri;
			 new_loc.login = login;
			 new_loc.curdir = curdir;
			 new_loc.password = password;
			 backendLocations.put(loc_name, new_loc);	 
			 BackEndLocationList.saveData(backendLocations);
			 HpePrinter.out("Location " + loc_name + " added !\n");
		     HpePrinter.out(message);
		 }
		
	}

	private void action_run(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-user");
		allowedArgs.add("-password");
		allowedArgs.add("-dir");
		allowedArgs.add("-version");		
		allowedArgs.add("-location");		
		allowedArgs.add("-component");		
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 1);

		Map<String, Integer> enumerators = readEnumerators(args);
    	
		String version = null;
		if (options_register.containsKey("version")) {
			version = options_register.get("version");
		}
		
		String user_name = null;
		if (options_register.containsKey("user")) {
			user_name = options_register.get("user");
		}
		
		String password = null;
		if (options_register.containsKey("password")) {
			password = options_register.get("password");
		}

		String dir = null;
		if (options_register.containsKey("dir")) {
			dir = options_register.get("dir");
		}
		
		URI location = null;
		String location_name = null;
		if (options_register.containsKey("location")) {
			location_name = options_register.get("location");
			location = BackEndLocationList.fetchURI(location_name);
			if (location == null) {
				String msg = "Location " + location_name + " not registered.";
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
		
			int[] eVal = new int[enumerators.values().size()];
			int i = 0;
			for (Integer n : enumerators.values()) {
				eVal[i++] = n;
			}
			
			String[] msgs = HPEPlatform.run(
					location.toString(), 
					Integer.parseInt(c.getLocalLocation()),                     
					enumerators.keySet().toArray(new String[0]), 
					eVal, 
					user_name, 
					password, 
					dir
			);
			
			for (String m : msgs) {
			   HpePrinter.out(m);
			}
		
			
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

	private void action_deploy(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-user");
		allowedArgs.add("-password");
		allowedArgs.add("-dir");
		allowedArgs.add("-version");
		allowedArgs.add("-location");
		allowedArgs.add("-component");
		Map<String, String> options_register = traverseOptions(args, allowedArgs, 1);
    	
		String user_name = null;
		if (options_register.containsKey("user")) {
			user_name = options_register.get("user");
		}

		String password = null;
		if (options_register.containsKey("password")) {
			password = options_register.get("password");
		}

		String dir = null;
		if (options_register.containsKey("dir")) {
			dir = options_register.get("dir");
		}

		String version = null;
		if (options_register.containsKey("version")) {
			version = options_register.get("version");
		}
		
		URI location = null;
		String location_name = null;
		if (options_register.containsKey("location")) {
			location_name = options_register.get("location");
			location = BackEndLocationList.fetchURI(location_name);
			if (location == null) {
				String msg = "Location " + location_name + " not registered.";				
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
		
			String message = HPEPlatform.deploy(location.toString(), c, user_name, password, dir);
			
			if (message != null) {
			   HpePrinter.out(message);
			} else {
				HpePrinter.out("The component " + c.getComponentName() + " has been succesfully deployed !");
			}
			
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

    private Map<String, Integer> readEnumerators(String[] args) throws ArgException {
		Map<String, Integer> enumerators = new HashMap<String,Integer>();
		 
		int i = 0;
		for (String arg : args) {
		    if (arg.equals("-enumerator")) {
		    	if (i+2 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
		       enumerators.put(args[i+1], Integer.parseInt(args[i+2]));
		    }
		    i++;
		}		
		
		return enumerators;
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
						throw new ArgException("Version expected after '-version'");
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
			    else if (arg.equals("-enumerators")) {
					   options_register.put("enumerators", "");
				    }
			    else if (arg.equals("-enumerator")) {
					   options_register.put("enumerator", "");
					   i+=2;
				    }
			    else if (arg.equals("-context")) {
					   options_register.put("context", "");
				    }
			    else if (arg.equals("-only_abstract")) {
				   options_register.put("only_abstract", "");
			    }
			    else if (arg.equals("-only_concrete")) {
				   options_register.put("only_concrete", "");
			    }
			    else if (arg.equals("-kind")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("Kind expected after '-kind'");
			    	}
				   options_register.put("kind", args[++i]);
			    }
			    else if (arg.equals("-uri")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("URI expected after '-uri'");
			    	}
				   options_register.put("uri", args[++i]);
			    }
			    else if (arg.equals("-name")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("Back-End name expected after '-name'");
			    	}
				   options_register.put("name", args[++i]);
			    }
			    else if (arg.equals("-user")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("User name expected after '-user'");
			    	}
				   options_register.put("user", args[++i]);
			    }
			    else if (arg.equals("-password")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("User password expected after '-password'");
			    	}
				   options_register.put("password", args[++i]);
			    }
			    else if (arg.equals("-dir")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("Path expected after '-dir'");
			    	}
				   options_register.put("dir", args[++i]);
			    }
				else if (arg.equals("-location")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("Back-End location name expected after '-location'");
			    	}
				   options_register.put("location", args[++i]);    	
			    }
				else if (arg.equals("-package")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("Package pattern expected after '-location'");
			    	}
				   options_register.put("package", args[++i]);    	
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
    
/*	private Map<String, String> traverseOptions2(String[] args) throws ArgException {
		Map<String, String> options_register = new HashMap<String,String>();
		 
		int i = 0;
		for (String arg : args) {
		    if (arg.equals("-version")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
		       options_register.put("version", args[i+1]);
		    }
		    else if (arg.equals("-component")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
			   options_register.put("component", args[i+1]);
		    }
		    else if (arg.equals("-enumerators")) {
				   options_register.put("enumerators", "");
			    }
		    else if (arg.equals("-context")) {
				   options_register.put("context", "");
			    }
		    else if (arg.equals("-only_abstract")) {
			   options_register.put("only_abstract", "");
		    }
		    else if (arg.equals("-only_concrete")) {
			   options_register.put("only_concrete", "");
		    }
		    else if (arg.equals("-kind")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
			   options_register.put("kind", args[i+1]);
		    }
		    else if (arg.equals("-user")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
			   options_register.put("user", args[i+1]);
		    }
		    else if (arg.equals("-password")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
			   options_register.put("password", args[i+1]);
		    }
		    else if (arg.equals("-dir")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
			   options_register.put("dir", args[i+1]);
		    }
			else if (arg.equals("-location")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
			   options_register.put("location", args[i+1]);    	
		    }
			else if (arg.equals("-package")) {
		    	if (i+1 >= args.length) {
					HpePrinter.out(help());
					throw new ArgException();
		    	}
			   options_register.put("package", args[i+1]);    	
		    }
		    i++;
		}		
		
		return options_register;
	}
*/
	
	@Override
	public String help() {
		return "\n" +
	       " platform deploy -component <component_id> -location <location_name> [-version <version_id>] [-user <user_name>] [-password <password>] [-dir <path>] \n" +
	       " platform run -component <component_id> -location <location_name> [-version <version_id>] [-user <user_name>] [-password <password>] [-dir <path>]\n" +
	       " platform list [-package <pattern>] [-kind <kind>] [-only_concrete | -only_abstract] [-enumerators] [-context] [-location <uri>]  \n" + 
	       " platform location add -uri <uri> \n" + 
	       " platform location remove -name <location_name>  \n" + 
	       " platform location list \n" + 
	       " \n" +
	       " where:\n" +
	       " \n" +
	       "  * <component_id> is a qualified name of a component (ex: skeleton.farm.Collector)\n" + 
	       "  * <uri> is the uri address of the location \n" +
	       "  * <pattern> is a <component_id> with the wildcard '*' \n"+
	       "  * <version_id> is the version of component, whose format is \"X.X.X.X\" \n";
	}

}
