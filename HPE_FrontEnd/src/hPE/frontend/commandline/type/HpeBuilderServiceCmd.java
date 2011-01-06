package hPE.frontend.commandline.type;

//import hPE.backend.BackEnd_WSLocator;
//import hPE.backend.BackEnd_WSSoap;
//import hPE.core.library.HPELocationEntry;

import hPE.frontend.commandline.exception.ArgException;
import hPE.frontend.commandline.exception.CmdException;
import hPE.frontend.commandline.util.HpePrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceLocator;
import br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap;
import br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID;
import br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID;
import br.ufc.pargo.hpe.cca.ports.BuilderService.Property;
import br.ufc.pargo.hpe.cca.ports.BuilderService.Type;
import br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap;
import br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMapImplWS;

public class HpeBuilderServiceCmd implements HpeGenericCmd{

	public static int BUILDERSERVICE_COMPONENT_COMMAND_INDEX = 0;
	public static int BUILDERSERVICE_CONNECTION_COMMAND_INDEX = 0;
	public static int BUILDERSERVICE_PORT_COMMAND_INDEX = 0;
	public static int BUILDERSERVICE_GET_COMMAND_INDEX = 1;
	public static int BUILDERSERVICE_SET_COMMAND_INDEX = 1;
	public static int BUILDERSERVICE_PROVIDES_COMMAND_INDEX = 1;
	public static int BUILDERSERVICE_USES_COMMAND_INDEX = 1;
	public static int BUILDERSERVICE_DESTROY_COMMAND_INDEX = 1;
	public static int BUILDERSERVICE_ID_COMMAND_INDEX = 2;
	public static int BUILDERSERVICE_CREATEINSTANCE_COMMAND_INDEX = 1;           // builderservice component instantiate
	public static int BUILDERSERVICE_DESTROYINSTANCE_COMMAND_INDEX = 1;          // builderservice component destroy
	public static int BUILDERSERVICE_GETCOMPONENTID_COMMAND_INDEX = 2;           // builderservice component get id
	public static int BUILDERSERVICE_GETCOMPONENTIDS_COMMAND_INDEX = 3;          // builderservice component get id all
	public static int BUILDERSERVICE_GETCOMPONENTPROPERTIES_COMMAND_INDEX = 2;   // builderservice component get properties 
	public static int BUILDERSERVICE_SETCOMPONENTPROPERTIES_COMMAND_INDEX = 2;   // builderservice component set properties
	public static int BUILDERSERVICE_GETDESERIALIZATION_COMMAND_INDEX = 2;       // builderservice component new id
	public static int BUILDERSERVICE_CONNECT_COMMAND_INDEX = 1;                  // builderservice connection create
	public static int BUILDERSERVICE_DISCONNECT_COMMAND_INDEX = 1;               // builderservice connection destroy
	public static int BUILDERSERVICE_DISCONNECTALL_COMMAND_INDEX = 2;            // builderservice connection destroy all
	public static int BUILDERSERVICE_GETCONNECTIONIDS_COMMAND_INDEX = 3;         // builderservice connection get id all
	public static int BUILDERSERVICE_GETCONNECTIONPROPERTIES_COMMAND_INDEX = 2;  // builderservice connection get properties
	public static int BUILDERSERVICE_SETCONNECTIONPROPERTIES_COMMAND_INDEX = 2;  // builderservice connection set properties
	public static int BUILDERSERVICE_GETPORTPROPERTIES_COMMAND_INDEX = 1;        // builderservice port properties
	public static int BUILDERSERVICE_GETPROVIDEDPORTNAMES_COMMAND_INDEX = 2;     // builderservice port provides names
	public static int BUILDERSERVICE_GETUSEDPORTNAMES_COMMAND_INDEX = 2;         // builderservice port uses names
	public static int BUILDERSERVICE_SETPORTPROPERTIES_COMMAND_INDEX = 2;        // builderservice port set properties
	
	

	public static String BUILDERSERVICE_COMPONENT_COMMAND_TOKEN = "component";
	public static String BUILDERSERVICE_CONNECTION_COMMAND_TOKEN = "connection";
	public static String BUILDERSERVICE_PORT_COMMAND_TOKEN = "port";
	public static String BUILDERSERVICE_GET_COMMAND_TOKEN = "get";
	public static String BUILDERSERVICE_SET_COMMAND_TOKEN = "set";
	public static String BUILDERSERVICE_PROVIDES_COMMAND_TOKEN = "provides";
	public static String BUILDERSERVICE_USES_COMMAND_TOKEN = "uses";
	public static String BUILDERSERVICE_DESTROY_COMMAND_TOKEN = "destroy";
	public static String BUILDERSERVICE_ID_COMMAND_TOKEN = "id";
	public static String BUILDERSERVICE_CREATEINSTANCE_COMMAND_TOKEN = "instantiate";         // builderservice component instantiate -instancename <iname> -component <cname> [-property <key> <value>]* < -location <location_name>
	public static String BUILDERSERVICE_DESTROYINSTANCE_COMMAND_TOKEN = "destroy";            // builderservice component destroy -instancename <cname> -timeout <milliseconds> -location <location_name>
	public static String BUILDERSERVICE_GETCOMPONENTID_COMMAND_TOKEN = "id";                  // builderservice component get id -instancename <cname> -location <location_name>
	public static String BUILDERSERVICE_GETCOMPONENTIDS_COMMAND_TOKEN = "all";                // builderservice component get id all -location <location_name>
	public static String BUILDERSERVICE_GETCOMPONENTPROPERTIES_COMMAND_TOKEN = "properties";  // builderservice component get properties -instancename <cname>  -location <location_name>
	public static String BUILDERSERVICE_SETCOMPONENTPROPERTIES_COMMAND_TOKEN = "properties";  // builderservice component set properties -instancename <cname> -properties <key>:<value>, <key>:<value>, ..., <key>:<value> -location <location_name>
	public static String BUILDERSERVICE_GETDESERIALIZATION_COMMAND_TOKEN = "id";              // builderservice component deserialize -string <serialization> -location <location_name>
	public static String BUILDERSERVICE_CONNECT_COMMAND_TOKEN = "create";                     // builderservice connection create -user <cname> -usesport <pname> -provider <cname> -providesport <pname> -location <location_name>
	public static String BUILDERSERVICE_DISCONNECT_COMMAND_TOKEN = "destroy";                 // builderservice connection destroy -connection <connid> --timeout <milliseconds> -location <location_name>
	public static String BUILDERSERVICE_DISCONNECTALL_COMMAND_TOKEN = "all";                  // builderservice connection destroy all -endpoints <cname>, <cname> -location <location_name>
	public static String BUILDERSERVICE_GETCONNECTIONIDS_COMMAND_TOKEN = "all";               // builderservice connection get id all [-instancename <cname>]* -location <location_name>
	public static String BUILDERSERVICE_GETCONNECTIONPROPERTIES_COMMAND_TOKEN = "properties"; // builderservice connection get properties -connection <connid> -location <location_name>
	public static String BUILDERSERVICE_SETCONNECTIONPROPERTIES_COMMAND_TOKEN = "properties"; // builderservice connection set properties -connection <connid> -property <key> <value> -location <location_name>
	public static String BUILDERSERVICE_GETPORTPROPERTIES_COMMAND_TOKEN = "properties";       // builderservice port get properties -instancename <cname> -portname <pname> -location <location_name>
	public static String BUILDERSERVICE_SETPORTPROPERTIES_COMMAND_TOKEN = "properties";       // builderservice port set properties -instancename <cname> -portname <pname> -property <key> <value> -location <location_name>
	public static String BUILDERSERVICE_GETPROVIDEDPORTNAMES_COMMAND_TOKEN = "names";         // builderservice port provides names -instancename <cname> -location <location_name>
	public static String BUILDERSERVICE_GETUSEDPORTNAMES_COMMAND_TOKEN = "names";             // builderservice port uses names -instancename <cname> -location <location_name>
	
	
	private BuilderServiceSoap backend = null;	
	private String locationURI = "http://localhost:62822/BuilderService.asmx";
	private HashMap<String, ComponentID> instances = null;
	private HashMap<String, ConnectionID> connections = null;
	
	public HpeBuilderServiceCmd() {

		instances = new HashMap<String,ComponentID>();
		BuilderServiceLocator server = new BuilderServiceLocator();
		server.setBuilderServiceSoapEndpointAddress(locationURI);
		
		try {
			backend = server.getBuilderServiceSoap();
		} catch (ServiceException e) {
			System.err.print("Error instantiating BuilderService.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void action(String[] args) throws ArgException, CmdException {

		if (args == null || args.length == 0) {
			HpePrinter.out(help());
			throw new ArgException();
		}
		
		if (args[BUILDERSERVICE_COMPONENT_COMMAND_INDEX].equals(BUILDERSERVICE_COMPONENT_COMMAND_TOKEN)) {
			if (args[BUILDERSERVICE_CREATEINSTANCE_COMMAND_INDEX].equals(BUILDERSERVICE_CREATEINSTANCE_COMMAND_TOKEN)) {
   			       action_createinstance(args);
			} else if (args[BUILDERSERVICE_DESTROYINSTANCE_COMMAND_INDEX].equals(BUILDERSERVICE_DESTROYINSTANCE_COMMAND_TOKEN)) {
			       action_destroyinstance(args);
			} else if (args[BUILDERSERVICE_GET_COMMAND_INDEX].equals(BUILDERSERVICE_GET_COMMAND_TOKEN)) {
				if (args[BUILDERSERVICE_GETCOMPONENTID_COMMAND_INDEX].equals(BUILDERSERVICE_CREATEINSTANCE_COMMAND_TOKEN)) {
	   			       action_getcomponentid(args);
				} else if (args[BUILDERSERVICE_GETCOMPONENTIDS_COMMAND_INDEX].equals(BUILDERSERVICE_GETCOMPONENTIDS_COMMAND_TOKEN)) {
				       action_getcomponentids(args);
				} else if (args[BUILDERSERVICE_GETCOMPONENTPROPERTIES_COMMAND_INDEX].equals(BUILDERSERVICE_GETCOMPONENTPROPERTIES_COMMAND_TOKEN)) {
				       action_getcomponentproperties(args);
				} else {
				   HpePrinter.out(this.help());
				   throw new ArgException("unrecognized platform command.");
				}
			} else if (args[BUILDERSERVICE_GETDESERIALIZATION_COMMAND_INDEX].equals(BUILDERSERVICE_GETDESERIALIZATION_COMMAND_TOKEN)) {
				action_getdeserialization(args);
			} else if (args[BUILDERSERVICE_SET_COMMAND_INDEX].equals(BUILDERSERVICE_SET_COMMAND_TOKEN) && 
					   args[BUILDERSERVICE_SETCOMPONENTPROPERTIES_COMMAND_INDEX].equals(BUILDERSERVICE_SETCOMPONENTPROPERTIES_COMMAND_TOKEN)) {
				action_setcomponentproperties(args);
			} else {
			   HpePrinter.out(this.help());
			   throw new ArgException("unrecognized platform command.");
			}
		} else if (args[BUILDERSERVICE_CONNECT_COMMAND_INDEX].equals(BUILDERSERVICE_CONNECTION_COMMAND_TOKEN)) {
			if (args[BUILDERSERVICE_CONNECT_COMMAND_INDEX].equals(BUILDERSERVICE_CONNECT_COMMAND_TOKEN)) {
			       action_connect(args);
			} else if (args[BUILDERSERVICE_DESTROY_COMMAND_INDEX].equals(BUILDERSERVICE_DESTROY_COMMAND_TOKEN)) {
				if (args[BUILDERSERVICE_DISCONNECTALL_COMMAND_INDEX].equals(BUILDERSERVICE_DISCONNECTALL_COMMAND_TOKEN)) {
				   action_disconnect_all(args);
				} else {
				   action_disconnect(args);
				}			       
			} else if (args[BUILDERSERVICE_GET_COMMAND_INDEX].equals(BUILDERSERVICE_GET_COMMAND_TOKEN)) {
				if (args[BUILDERSERVICE_GETCONNECTIONIDS_COMMAND_INDEX].equals(BUILDERSERVICE_GETCONNECTIONIDS_COMMAND_TOKEN)) {
				       action_getconnectionids(args);
				} else if (args[BUILDERSERVICE_GETCONNECTIONPROPERTIES_COMMAND_INDEX].equals(BUILDERSERVICE_GETCONNECTIONPROPERTIES_COMMAND_TOKEN)) {
				       action_getconnectionproperties(args);
				} else {
				   HpePrinter.out(this.help());
				   throw new ArgException("unrecognized platform command.");
				}
			} else if (args[BUILDERSERVICE_SET_COMMAND_INDEX].equals(BUILDERSERVICE_SET_COMMAND_TOKEN) && 
					   args[BUILDERSERVICE_SETCONNECTIONPROPERTIES_COMMAND_INDEX].equals(BUILDERSERVICE_SETCONNECTIONPROPERTIES_COMMAND_TOKEN)) {
				            action_setconnectionproperties(args);
			} else {
			   HpePrinter.out(this.help());
			   throw new ArgException("unrecognized platform command.");
			}
		} else if (args[BUILDERSERVICE_PORT_COMMAND_INDEX].equals(BUILDERSERVICE_PORT_COMMAND_TOKEN)) {
			if (args[BUILDERSERVICE_GET_COMMAND_INDEX].equals(BUILDERSERVICE_GET_COMMAND_TOKEN) && 
				args[BUILDERSERVICE_GETPORTPROPERTIES_COMMAND_INDEX].equals(BUILDERSERVICE_GETPORTPROPERTIES_COMMAND_TOKEN)) {
				action_getportproperties(args);
			} else if (args[BUILDERSERVICE_SET_COMMAND_INDEX].equals(BUILDERSERVICE_SET_COMMAND_TOKEN) && 
					   args[BUILDERSERVICE_SETPORTPROPERTIES_COMMAND_INDEX].equals(BUILDERSERVICE_SETPORTPROPERTIES_COMMAND_TOKEN)) {
                action_setportproperties(args);				
			} else if (args[BUILDERSERVICE_PROVIDES_COMMAND_INDEX].equals(BUILDERSERVICE_PROVIDES_COMMAND_TOKEN)&& 
				       args[BUILDERSERVICE_GETPROVIDEDPORTNAMES_COMMAND_INDEX].equals(BUILDERSERVICE_GETPROVIDEDPORTNAMES_COMMAND_TOKEN)) {
				action_getprovidedportnames(args);
			} else if (args[BUILDERSERVICE_USES_COMMAND_INDEX].equals(BUILDERSERVICE_USES_COMMAND_TOKEN) && 
					   args[BUILDERSERVICE_GETUSEDPORTNAMES_COMMAND_INDEX].equals(BUILDERSERVICE_GETUSEDPORTNAMES_COMMAND_TOKEN)) {
				action_getusedportnames(args);
			} else {			
				HpePrinter.out(this.help());
				throw new ArgException("unrecognized builderservice command.");
			}
		} else {
		   HpePrinter.out(this.help());
		   throw new ArgException("unrecognized builderservice command.");
		}
	}

	// builderservice port uses names -instancename <cname> -location <location_name>
	private void action_getusedportnames(String[] args) throws ArgException, CmdException {
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
		
		try {
			ComponentID cid = backend.getComponentID(instanceName);
			String[] portNames = backend.getUsedPortNames(cid );
		} catch (IOException e) {
			CmdException ee = new CmdException("Error creating instance (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
		
	}

	// builderservice port provides names -instancename <cname> -location <location_name>
	private void action_getprovidedportnames(String[] args) throws ArgException, CmdException {
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
		
		try {
			ComponentID cid = backend.getComponentID(instanceName);
			String[] portNames = backend.getProvidedPortNames(cid);
		} catch (IOException e) {
			CmdException ee = new CmdException("Error creating instance (CCA BuilderService)");
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

	// builderservice component instantiate -instancename <iname> -component <cname> [-property <key> <value>]* < -location <location_name>
	private void action_createinstance(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		allowedArgs.add("-componentname");
		allowedArgs.add("-property");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 2);
    	
		String instanceName = options_register.get("instancename").get(0);
		String cName = options_register.get("componentname").get(0);
		TypeMap properties_map = null;
		if (options_register.containsKey("property")) {
		    List<String> properties_list = options_register.get("property"); 
		    properties_map = collectProperties(properties_list);
		}
		
		Map<String, Integer> enumerators = readEnumerators(args);
		
/*		URI location = null;
		String location_name = null;
		if (options_register.containsKey("location")) {
			location_name = options_register.get("location").get(0);
			location = BackEndLocationList.fetchURI(location_name);
			if (location == null) {
				String msg = "Location " + location_name + " not registered.";
				throw new ArgException(msg);
			}
			
		} else {
			throw new ArgException("A location is required to be specified by using -location.");
		} */
		
		try {			
			
			ComponentID cid = backend.createInstance(instanceName, cName, properties_map);
						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error creating instance (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice component destroy -instancename <cname> -timeout <milliseconds> -location <location_name>
	private void action_destroyinstance(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		allowedArgs.add("-timeout");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 2);
    	
		String instanceName = options_register.get("instancename").get(0);
		int timeout = Integer.parseInt(options_register.get("timeout").get(0));
				
		try {						
			ComponentID toDie = backend.getComponentID(instanceName);
			backend.destroyInstance(toDie, timeout);						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error destroying instance (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}
	
	// builderservice component get id -instancename <cname> -location <location_name>
	private void action_getcomponentid(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
				
		try {						
			backend.getComponentID(instanceName);						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error getting component id of instanceName (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice component get id all -location <location_name>
	private void action_getcomponentids(String[] args) throws ArgException, CmdException {
		
		try {						
			ComponentID[] cids = backend.getComponentIDs();						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error getting component ids (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice component get properties -instancename <cname>  -location <location_name>
	private void action_getcomponentproperties(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
				
		try {						
			ComponentID cid = backend.getComponentID(instanceName);
			TypeMap properties = backend.getComponentProperties(cid);						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error getting component properties (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice connection get properties -connection <connid> -location <location_name>
	private void action_getconnectionproperties(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-connection");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String connectionName = options_register.get("connection").get(0);
				
		try {						
			ConnectionID connID = connections.get(connectionName);
			TypeMap properties = backend.getConnectionProperties(connID);						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error getting connection properties (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice component deserialize -string <serialization> -location <location_name>
	private void action_getdeserialization(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-string");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 2);
    	
		String instanceName = options_register.get("string").get(0);
				
		try {						
			ComponentID cid = backend.getDeserialization(instanceName);						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error fetching component id from serialized string (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	private TypeMap collectProperties(List<String> actualProperties) {    	
    	
		TypeMapImplWS map = new TypeMapImplWS();
		List<Property> propertiesList = new ArrayList<Property>();
		
		for (String actualProperty : actualProperties) 
    	{
    	    String[] property_split = actualProperty.split("-");
    	    String key = property_split[0];
    	    String value = property_split[1];
    	    String type = property_split[2];
    	    Property property = new Property();
    	    property.setKey(key);
    	    property.setValue(value);
    	    property.setType(Type.fromValue(type)); 
    	    propertiesList.add(property);    	    
    	}
		Property[] properties = new Property[propertiesList.size()]; 
		properties = propertiesList.toArray(properties);
	    map.setProperties(properties);
    	return map;
	}
	

	private void addOption(Map<String, List<String>> options_register, String key, String value) {
    	if (options_register.containsKey(key)) {
    		options_register.get(key).add(value);    		
    	} else {
    		List<String> l = new ArrayList<String>();
    		l.add(value);
    		options_register.put(key, l);
    	}
    }
    
 // builderservice component set properties -instancename <cname> -properties <key>:<value>, <key>:<value>, ..., <key>:<value> -location <location_name>
	private void action_setcomponentproperties(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		allowedArgs.add("-property");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
		List<String> properties_list = options_register.get("property"); 
		TypeMap properties = collectProperties(properties_list);
		
		try {			
			
			ComponentID cid = backend.getComponentID(instanceName);
			backend.setComponentProperties(cid, properties);
						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error getting component properties (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}
    
	// builderservice connection set properties -connection <connid> -property <key> <value> -location <location_name>
	private void action_setconnectionproperties(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		allowedArgs.add("-property");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
		List<String> properties_list = options_register.get("property"); 
		TypeMap properties = collectProperties(properties_list);
		
		try {			
			
			ComponentID cid = backend.getComponentID(instanceName);
			backend.setComponentProperties(cid, properties);
						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error getting component properties (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice port set properties -instancename <cname> -portname <pname> -property <key> <value> -location <location_name>
	private void action_setportproperties(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		allowedArgs.add("-portname");
		allowedArgs.add("-property");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
		String portname = options_register.get("portname").get(0);
		List<String> properties_list = options_register.get("property"); 
		TypeMap properties = collectProperties(properties_list);
		
		try {			
			
			ComponentID cid = backend.getComponentID(instanceName);
			backend.setPortProperties(cid , portname, properties);
						
		} catch (IOException e) {
			CmdException ee = new CmdException("Error setting component properties (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice connection create -user <cname> -usesport <pname> -provider <cname> -providesport <pname> -location <location_name>
	private void action_connect(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-connection");
		allowedArgs.add("-user");
		allowedArgs.add("-provider");
		allowedArgs.add("-usesport");
		allowedArgs.add("-providesport");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 2);
    	
		String connection_name = options_register.get("connection").get(0);
		String userInstanceName = options_register.get("user").get(0);
		String providerInstanceName = options_register.get("provider").get(0);
		String usingPortName = options_register.get("usesport").get(0);
		String providingPortName = options_register.get("providesport").get(0);
		
		try {			
			ComponentID provider = backend.getComponentID(providerInstanceName);
			ComponentID user = backend.getComponentID(userInstanceName);
			ConnectionID connid = backend.connect(user, usingPortName, provider, providingPortName);
			connections.put(connection_name, connid);
		} catch (IOException e) {
			CmdException ee = new CmdException("Error connecting ports (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}
    
	// builderservice connection destroy -connection <connid> --timeout <milliseconds> -location <location_name>
	private void action_disconnect(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-connection");
		allowedArgs.add("-timeout");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 2);
    	
		String connection_name = options_register.get("connection").get(0);
		int timeout = Integer.parseInt(options_register.get("timeout").get(0));
		
		try {			
			ConnectionID connid = connections.get(connection_name);
			backend.disconnect(connid, timeout);
		} catch (IOException e) {
			CmdException ee = new CmdException("Error connecting ports (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice connection destroy all -endpoints <cname>, <cname> -location <location_name>
	private void action_disconnect_all(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-endpoints");
		allowedArgs.add("-timeout");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String cids[] = options_register.get("endpoints").get(0).split(",");
		int timeout = Integer.parseInt(options_register.get("timeout").get(0));
		
		
		try {			
			ComponentID id1 = backend.getComponentID(cids[0]);
			ComponentID id2 = backend.getComponentID(cids[1]);
			backend.disconnectAll(id1, id2, timeout);
		} catch (IOException e) {
			CmdException ee = new CmdException("Error connecting ports (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice connection get id all [-instancename <cname>]* -location <location_name>
	private void action_getconnectionids(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 4);
    	
		List<String> cList = options_register.get("instancename");

		try {			
			ComponentID[] componentList = new ComponentID[cList.size()];
			componentList = cList.toArray(componentList);		
			ConnectionID[] connids = backend.getConnectionIDs(componentList);
		} catch (IOException e) {
			CmdException ee = new CmdException("Error connecting ports (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}

	// builderservice port get properties -instancename <cname> -portname <pname> -location <location_name>
	private void action_getportproperties(String[] args) throws ArgException, CmdException {
		
		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-instancename");
		allowedArgs.add("-portname");
		Map<String, List<String>> options_register = traverseOptions(args, allowedArgs, 3);
    	
		String instanceName = options_register.get("instancename").get(0);
		String portname = options_register.get("portname").get(0);

		try {			
			
			ComponentID cid = backend.getComponentID(instanceName);
			TypeMap properties = backend.getPortProperties(cid, portname);
		} catch (IOException e) {
			CmdException ee = new CmdException("Error connecting ports (CCA BuilderService)");
			ee.initCause(e);
			throw ee;
		} 
	}
	
	private Map<String, List<String>> traverseOptions(String[] args, List<String> allowedArgs, int beginIndex) throws ArgException {
		
		Map<String, List<String>> options_register = new HashMap<String,List<String>>();
				
		for (int i=beginIndex; i<args.length; i++) 
		{
			String arg = args[i];
			if (allowedArgs.contains(arg)) {
			    if (arg.equals("-instancename")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("An instance name is mandatory after '-instancename'.");
			    	}
			       addOption(options_register, "instancename", args[++i]);
			    }
			    else if (arg.equals("-componentname")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("A timeout (in milliseconds) must be specificed after '-componentname'");
			    	}
			    	addOption(options_register, "componentname", args[++i]);
			    }
			    else if (arg.equals("-enumerator")) {
					   options_register.put("enumerator", null);
					   i+=2;
				}
			    else if (arg.equals("-timeout")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("A timeout (in milliseconds) must be specificed after '-timeout'");
			    	}
			    	addOption(options_register, "timeout", args[++i]);
			    }
			    else if (arg.equals("-portname")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("A port name must be specified after '-portname'");
			    	}
			    	addOption(options_register, "portname", args[++i]);
			    }
			    else if (arg.equals("-string")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("A serialized string must be specified after '-string'");
			    	}
			    	addOption(options_register, "portname", args[++i]);
			    }
			    else if (arg.equals("-user")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("The instance name of the user component must be specified after '-user'");
			    	}
			    	addOption(options_register, "user", args[++i]);
			    }
			    else if (arg.equals("-provider")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("The instance name of the provider component must be specified after '-provider'");
			    	}
			    	addOption(options_register, "provider", args[++i]);
			    }
			    else if (arg.equals("-usesport")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("The name of a uses port of the user component must be specified after '-usesport'");
			    	}
			    	addOption(options_register, "usesport", args[++i]);
			    }
			    else if (arg.equals("-providesport")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("The name of a provides port of the provider component must be specified after '-usesport'");
			    	}
			    	addOption(options_register, "providesport", args[++i]);
			    }
			    else if (arg.equals("-connection")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("The connection identification must be specified after '-connection'");
			    	}
			    	addOption(options_register, "connection", args[++i]);
			    }
			    else if (arg.equals("-property")) {
			    	if (i+3 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("A pair in the form '<key> <value>' must be specified after '-property'");
			    	}
			    	addOption(options_register, "property", args[i+1] + "-" + args[i+2] + "-" + args[i+3]);
				   i+=3;
			    }
				else if (arg.equals("-location")) {
			    	if (i+1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("Back-End location name expected after '-location'");
			    	}
			    	addOption(options_register, "location", args[++i]);    	
			    }
			    else if (arg.equals("-endpoints")) {
			    	if (i+2 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("The instance name of two components must be specified after '-endpoints'");
			    	}
			    	addOption(options_register, "endpoints", args[i] + "," + args[i+1]);
				   i+=2;
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
		return "BuilderService interface - CCA";
	}

}
