using System;
using System.Web;
using System.Web.Services;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.pargo.hpe.backend.DGAC;
using System.IO;
using System.Collections.Generic;
using System.Diagnostics;
using gov.cca;
using System.Threading;

namespace br.ufc.mdcc.hpcshelf.backend.platform
{
	public interface IPlatformServices 
	{
		int    getNumberOfNodes   ();
		int    getBaseBindingPort ();
		string deploy             (string config_contents);
		void   setPlatformRef     (string arch_ref);
		string getPlatformRef     ();
		string instantiate        (string app_name, string component_ref, int facet_instance, int[] facet, string[] facet_address, int[] nodes);
		void   run                (string component_ref);
		string getStatus          ();
	}

	public class PlatformServices : System.Web.Services.WebService, IPlatformServices
	{
		/* config_contents is the contents of the .hpe file */

		[WebMethod]
		public int getNumberOfNodes()
		{
			string path_hosts_file = System.Environment.GetEnvironmentVariable ("PATH_HOSTS_FILE");
			if (path_hosts_file == null || path_hosts_file.Equals(""))
				path_hosts_file = System.Environment.GetEnvironmentVariable("HOME") + Path.PathSeparator + "hpe_nodes";

			string[] contents = File.ReadAllLines (path_hosts_file);
			int size = contents.Length;

			Trace.WriteLine ("getNumberOfNodes was called and returned {0}", size);

			return size - 1;
		}

		[WebMethod]
		public int getBaseBindingPort()
		{
			int base_binding_port = -1;

			try
			{
				base_binding_port = Constants.BASE_BINDING_FACET_PORT;
			}
			catch (Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				Console.Error.WriteLine (e.StackTrace);
				if (e.InnerException != null) 
				{
					Console.Error.WriteLine (e.InnerException.Message);
					Console.Error.WriteLine (e.InnerException.StackTrace);
				}
			}
			return base_binding_port;
		}

		[WebMethod]
		public string deploy(string config_contents)
		{
			int res = -1;
			try
			{
				string filename = Path.GetTempFileName();
				File.WriteAllText(filename,config_contents);

				ComponentType c = LoaderApp.DeserializeObject(filename);
				if (c.header.baseType != null && c.header.baseType.extensionType.ItemElementName == ItemChoiceType.implements)
					res = BackEnd.registerConcreteComponentTransaction(c, null, null, "");
				else
					res = BackEnd.registerAbstractComponentTransaction(c, null, null, "");

				if (res>=0) 
				{
					string component_reference = c.header.packagePath + "." + c.header.name;
					File.Copy(filename,Constants.PATH_TEMP_WORKER + component_reference + ".hpe",true);
				}

			} 
			catch (Exception e) 
			{
				Console.WriteLine(e.Message);
				return "-- Message -- \n " + e.Message + "\n\n -- Stack Trace --\n" + e.StackTrace + "\n\n -- Inner Exception -- \n" + e.InnerException;
			}

			return "deployed " + res;
		}

		private static string platform_ref = null;

		[WebMethod]
		public void setPlatformRef(string arch_ref)
		{
			platform_ref = arch_ref;
		}

		[WebMethod]
		public string getPlatformRef()
		{
			return platform_ref;
		}

		/* component_ref é a referência do componente no sistema computacional (identificador do componente aninhado do componente de sistema).
		 * A plataforma já possui o componente de sistema previamente instanciado. 
		 */ 

		[WebMethod]
		public string instantiate(string app_name, string component_ref, int facet_instance, int[] facet, string[] facet_address, int[] nodes)
		{
			try
			{
				Connector.openConnection ();

				Tuple<int,string>[] facet_address_list = new Tuple<int, string>[facet_address.Length];
				for (int i = 0; i < facet_address.Length; i++)
					facet_address_list [i] = new Tuple<int, string> (facet [i], facet_address [i]);	

				Trace.WriteLine("INSTANTIATE -- " + platform_ref + " / " + component_ref + " / " + facet_address[facet_instance]);

				if (platform_ref.Equals(component_ref))
					instantiateSystemComponent (app_name, facet_instance, facet_address_list, nodes);

				instantiateSolutionComponent (component_ref);

				Connector.closeConnection ();
			} 
			catch(Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				
			}

			string result = "instantiated";

			return result;
		}
			
		private static ManagerComponentID app_cid = null;
		private static br.ufc.pargo.hpe.backend.DGAC.BackEnd.ISession session = null;

		// Search for the single Application component deployed in the platform and instantiate it.
		private void instantiateSystemComponent(string app_name, int facet_instance, Tuple<int,string>[] facet_address_list, int[] nodes)
		{
			try{
				string instantiator_string = buildInstantiatorStringOfSystem (app_name + ".System", facet_instance, facet_address_list, nodes);
				Trace.WriteLine (instantiator_string);

				string session_id_string = "system";
				session = BackEnd.startSession(session_id_string);
				//gov.cca.Services frwServices = session.Services;

				// INSTANTIATE THE APPLICATION
				Trace.WriteLine("Creating an instance of the application");
				app_cid = (ManagerComponentID) BackEnd.createSystemComponentInstance ("app", instantiator_string, session_id_string);

			} 
			catch (Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				if (e.InnerException != null)
					Console.Error.WriteLine (e.InnerException.Message);
			}
		}


		private string buildInstantiatorStringOfSystem(string component_ref, int facet_instance, Tuple<int,string>[] facet_address_list, int[] nodes)
		{
			IList<AbstractComponentFunctor> acf_list = BackEnd.acfdao.listByKind (Constants.KIND_APPLICATION_NAME);
			AbstractComponentFunctor acf = acf_list [0];

			Instantiator.InstanceType instantiator = new Instantiator.InstanceType();
			Instantiator.ComponentFunctorApplicationType contract = new Instantiator.ComponentFunctorApplicationType();
			contract.component_ref = component_ref;
			contract.argument = new Instantiator.ContextArgumentType[0];

			instantiator.contextual_type = contract;
			instantiator.facet_instanceSpecified = true;
			instantiator.facet_instance = facet_instance;

			IList<Interface> units = BackEnd.idao.list (acf.Id_abstract);
			instantiator.unit_mapping = new Instantiator.UnitMappingType[units.Count];

			int iu = 0;
			foreach (Interface u in units) 
			{
				instantiator.unit_mapping [iu] = new Instantiator.UnitMappingType ();

				instantiator.unit_mapping [iu].unit_id = u.Id_interface;
				instantiator.unit_mapping [iu].unit_index = 0;

				instantiator.unit_mapping [iu].facet_instanceSpecified = true;
				instantiator.unit_mapping [iu].facet_instance = instantiator.unit_mapping [iu].facet = u.Facet;

				int number_of_nodes = nodes[instantiator.unit_mapping [iu].facet_instance];
				instantiator.unit_mapping [iu].node = new int[number_of_nodes];
				for (int n = 0; n < number_of_nodes; n++)
					instantiator.unit_mapping [iu].node [n] = n;

				iu++;
			}
				
			instantiator.facet_address = new Instantiator.FacetAddressType[facet_address_list.Length];
			for (int i = 0; i < facet_address_list.Length; i++) 
			{
				instantiator.facet_address [i] = new Instantiator.FacetAddressType ();
				instantiator.facet_address [i].facet_instanceSpecified = true;
				instantiator.facet_address [i].facet_instance = instantiator.facet_address [i].facet = facet_address_list[i].Item1;
				instantiator.facet_address [i].facetSpecified = true;
				instantiator.facet_address [i].facet = instantiator.facet_address [i].facet_instance;

				Uri uri = new Uri (facet_address_list [i].Item2);

				instantiator.facet_address [i].address = uri.Host;
				instantiator.facet_address [i].portSpecified = true;
				instantiator.facet_address [i].port = uri.Port;
			}


			string instantiator_string = LoaderApp.serializeInstantiator (instantiator);

			return instantiator_string;
		}

		/* - component_ref is the name of the component in the architectural code
		*  - In the BackEnd, there is a list of threads that instantiate the solution component when started,
		*    which is indexed by component_ref. In fact, it executes the procedure of instantiating an inner component
		*    of the <app_name>.System component instance (including connection and initialization.
		*/
		private void instantiateSolutionComponent(string component_ref)
		{
			int count = BackEnd.instantiateSolutionComponent (component_ref);
			Trace.WriteLine ("instantiateSolutionComponent COUNTER=" + count);
			status += (count + ":" + component_ref + "/");
		}
			
		private static string status = "";

		[WebMethod]
		public string getStatus()
		{
			return status;
		}

		[WebMethod]
		public void run (string component_ref)
		{
			status += platform_ref + ": * GO!!! BEGIN " + component_ref + "\n";

			BackEnd.runSolutionComponent (session.Services, component_ref);

			status += platform_ref + ": * GO!!! STARTED " + component_ref + "\n";
		}
			
	}
}

