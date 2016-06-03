using System;
using System.Web;
using System.Web.Services;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.pargo.hpe.backend.DGAC;
using System.IO;
using System.Collections.Generic;
using System.Diagnostics;

namespace PlatformService
{
	public class Platform : System.Web.Services.WebService
	{
		/* config_contents is the contents of the .hpe file */

		private int number_of_nodes;

		[WebMethod]
		public int getNumberOfNodes()
		{
			return number_of_nodes;
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

		/* component_ref é a referência do componente no sistema computacional (identificador do componente aninhado do componente de sistema).
		 * A plataforma já possui o componente de sistema previamente instanciado. 
		 */

		[WebMethod]
		public string instantiate(string component_ref, int facet_instance, int[] facet, string[] facet_address /*Tuple<int,string>[] facet_address_list*/)
		{
			if (component_ref.EndsWith ("System"))  // app_name + ".System"
				instantiateSystemComponent (component_ref);
			else {
				Tuple<int,string>[] facet_address_list = new Tuple<int, string>[facet.Length];
				for (int i = 0; i < facet.Length; i++)
					facet_address_list[i] = new Tuple<int, string> (facet[i],facet_address[i]);				
				instantiateSolutionComponentOrBinding (component_ref, facet_instance, facet_address_list);
			}

			return null;
		}

		// Search for the single Application component deployed in the platform and instantiate it.
		private void instantiateSystemComponent(string component_ref /* <app_name>.System */)
		{
			IList<AbstractComponentFunctor> acf_list = BackEnd.acfdao.listByKind (Constants.KIND_APPLICATION_NAME);
			Debug.Assert (acf_list.Count == 1);

			string instantiator_string = buildInstantiatorStringOfSystem (component_ref, acf_list [0]);

			string session_id_string = "system";
			BackEnd.runApplication (instantiator_string, session_id_string);
		}

		private string buildInstantiatorStringOfSystem(string component_ref, AbstractComponentFunctor acf)
		{
			Instantiator.InstanceType instantiator = new Instantiator.InstanceType();
			Instantiator.ComponentFunctorApplicationType contract = new Instantiator.ComponentFunctorApplicationType();
			contract.component_ref = component_ref;

			//instantiator.facet_address;  // TODO
			instantiator.unit_mapping = new Instantiator.UnitMappingType[1];
			instantiator.unit_mapping [0].unit_id = "peer";

			int number_of_nodes = getNumberOfNodes ();
			instantiator.unit_mapping [0].node = new int[number_of_nodes];
			for (int n = 0; n < number_of_nodes; n++)
				instantiator.unit_mapping [0].node [n] = n;

			return LoaderApp.serializeInstantiator (instantiator);
		}

		/* - component_ref is the name of the component in the architectural code
		*  - In the BackEnd, there is a list of threads that instantiate the solution component when started,
		*    which is indexed by component_ref. In fact, it executes the procedure of instantiating an inner component
		*    of the <app_name>.System component instance (including connection and initialization.
		*/
		private void instantiateSolutionComponentOrBinding(string component_ref, int facet_instance, Tuple<int,string>[] facet_address_list)
		{
			BackEnd.instantiateSolutionComponentOrBinding (component_ref, facet_instance, facet_address_list);
		}

	}
}

