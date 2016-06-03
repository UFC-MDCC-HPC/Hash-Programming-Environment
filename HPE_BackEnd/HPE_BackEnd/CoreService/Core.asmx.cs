using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend;


namespace br.ufc.mdcc.hpe.CoreService
{
    /// <summary>
    /// Summary description for Service1
    /// </summary>
    [WebService(Namespace = "http://ComponentRepository.hpe.mdcc.ufc.br/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    //[System.Xml.Serialization.XmlInclude(typeof(ConcreteComponentDescriptionImpl))]
	
    public class Core : System.Web.Services.WebService
    {
 
        #region Service Methods

        [WebMethod]
		public string[] resolve (string contract)
        {
			Instantiator.ComponentFunctorApplicationType contextual_type = LoaderApp.deserialize<Instantiator.ComponentFunctorApplicationType> (contract);
			AbstractComponentFunctorApplication acfaRef = BackEnd.loadACFAFromInstantiator(contextual_type);

			string[] cdesc_list = null;
			try{

			br.ufc.pargo.hpe.backend.DGAC.database.Component[] cs = Resolution.findHashComponentAll(acfaRef); 			
			cdesc_list = buildComponentDescription (cs);

			}catch (Exception e) 
			{
				Console.WriteLine (e.Message);
				throw e;
			}


			return cdesc_list;           
        }
			

		/* A operação deploy tem o comportamento dependente da espécie do componente que recebe. 
		 * 1) Caso se trata de um componente plataforma, deve ler o arquivo SAFeSWL para gerar os componentes do sistema computacional. 
		 *    Para isso, chama a operação LoaderSystem.deploySystemComponent, que já está prototipada.
		 *    Para descobrir o endereço do Back-End, deve consultar o catálogo do componente, buscando o componente escolhido.
		 *    Finalmente, invoca a operação deploy para implantar os componentes do sistema computacional na plataforma.
		 * 2) Caso se trate de um componente de computação ou conector, deve ler o arquivo SAFeSWL para descobrir os endereços dos serviços Platform das plataformas
		 *    nas quais as facetas do componente irão ser instaladas. Então, invoca a operaçao deploy de cada serviço Platform, passando como argumento os arquivos 
		 *    ".hpe" dos componentes necessários para carregar o componente na instanciação. Inclusive, deve implantar as facetas dos bindings com a aplicação no serviço
		 *    Platform do lado do SAFe. 
		 */

		[WebMethod]
		public string deploy (string arch_desc_xml,   // código SAFeSWL arquitetural.
			                  string arch_ref,        // referência do componente no código arquitetural.
			                  string[] c_ids,         // c_contracts[i] is the contract of c_ids[i]
							  string[] c_contracts, 
							  string[] c_choices, 
						      string[] c_unitmapping,
			                  string platform_address_SAFe)   
		{
			SAFeSWL.Architecture arch_desc = CoreServiceUtils.readArchitecture (arch_desc_xml);
			bool is_platform = CoreServiceUtils.checkIsPlatform (arch_desc, arch_ref);

			IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts = new Dictionary<string, Instantiator.ComponentFunctorApplicationType> ();
			IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping = new Dictionary<string, Instantiator.UnitMappingType[]> ();
			IDictionary<string,string> choices = new Dictionary<string, string> ();
			for (int i = 0; i < c_ids.Length; i++) 
			{
				contracts [c_ids [i]] = LoaderApp.deserialize<Instantiator.ComponentFunctorApplicationType> (c_contracts [i]);
				choices [c_ids [i]] = c_choices [i];
				if (c_unitmapping [i] != null)
					unit_mapping [c_ids [i]] = LoaderApp.deserialize<Instantiator.UnitMappingDescriptionType> (c_unitmapping [i]).unit;
			}
			
			if (is_platform)
				deployPlatform (arch_desc, contracts, choices, unit_mapping, arch_ref);
			else
				deployComponent (arch_desc, contracts, choices, arch_ref, platform_address_SAFe);

			return null;
		}

		private string deployPlatform(SAFeSWL.Architecture arch_desc, 
			                          IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, 
			                          IDictionary<string,string> choices, 
								      IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping, 
			                          string arch_ref)
		{
			string component_ref = choices [arch_ref];

			// descobrir o endereço do Back-End do mantenedor que ofereceu esse componente plataforma
			string[] config = CoreServiceUtils.fetchPlatformConfiguration (component_ref);

			string backend_address = config[0];

			// criar a plataforma
			string platform_address = CoreServiceUtils.invokeBackEndDeploy (backend_address, config);   

			// Deploy component contracts and system component.
			CoreServiceUtils.invokeDeployPlatform (arch_desc, contracts, choices, unit_mapping, arch_ref, platform_address);

			return platform_address;
		}

		private string deployComponent(SAFeSWL.Architecture arch_desc, IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts, IDictionary<string,string> choices, string arch_ref, string platform_address_SAFe)
		{
			string component_ref = choices [arch_ref];

			// determinar as plataformas onde cada componente da arquitetura deve instanciar suas facetas.
			IDictionary<string,Tuple<int,string>[]> platform_placement_list = LoaderSystem.placementOfComponents (arch_desc);
			// determinar quais as plataformas para o componente identificado como arch_ref no código arquitetural.
			Tuple<int,string>[] platform_placement = platform_placement_list [arch_ref];

			// determinar os endereços dos serviços Platform de cada plataforma.
			IDictionary<string,string> platform_address_list = CoreServiceUtils.readPlatformAddresses (arch_desc);

			for (int facet_instance = 0; facet_instance < platform_placement.Length; facet_instance++) 
			{
				string platform_ref = platform_placement [facet_instance].Item2;

				// determinar qual o endereço da plataforma onde deve ser instanciada a facet-ésima faceta do componente arch_ref.
				string platform_address = platform_address_list [platform_ref];

				string config_filename = Constants.PATH_TEMP_WORKER + component_ref + ".hpe";
				string config_contents = File.ReadAllText (config_filename);

				// invocar o serviço de implantação na plataforma do endereço platform_address para cada componente.
				CoreServiceUtils.invokeDeployComponent (platform_address, config_contents);
			}
				
			return "deployed";
		}


		[WebMethod]
		public string instantiate (string arch_desc_xml, string arch_ref, string platform_address_SAFe)
		{
			SAFeSWL.Architecture arch_desc = CoreServiceUtils.readArchitecture (arch_desc_xml);
			bool is_platform = CoreServiceUtils.checkIsPlatform (arch_desc, arch_ref);
			if (is_platform)
				instantiatePlatform (arch_desc, arch_ref);
			else
				instantiateComponent (arch_desc, arch_ref, platform_address_SAFe);

			return null;
		}


		private string instantiatePlatform(SAFeSWL.Architecture arch_desc, string arch_ref)
		{			
			// determinar os endereços dos serviços Platform de cada plataforma.
			IDictionary<string,string> platform_address_list = CoreServiceUtils.readPlatformAddresses (arch_desc);

			// determinar qual o endereço da plataforma arch_ref.
			string platform_address = platform_address_list [arch_ref];

			// determinar component_ref do componente de sistema implantado
			string system_ref = "system"; //ServiceUtils.determineSystemComponentRef(arch_desc);

			// Efetuar a invocação da operação instantiate do componente sistema na plataforma platform_address.
			CoreServiceUtils.invokeInstantiatePlatform (system_ref, platform_address);

			return "instantiated";
		}

		private string instantiateComponent(SAFeSWL.Architecture arch_desc, string arch_ref, string platform_address_SAFe)
		{
			// determinar as plataformas onde cada componente da arquitetura deve instanciar suas facetas.
			IDictionary<string,Tuple<int,string>[]> platform_placement_list = LoaderSystem.placementOfComponents (arch_desc);

			// determinar quais as plataformas para o componente identificado como arch_ref no código arquitetural.
			Tuple<int,string>[] platform_placement = platform_placement_list [arch_ref];

			// determinar os endereços dos serviços Platform de cada plataforma.
			IDictionary<string,string> platform_address_list = CoreServiceUtils.readPlatformAddresses (arch_desc);

			int[] facet = new int[platform_placement.Length];
			string[] facet_address = new string[platform_placement.Length];
			for (int facet_instance = 0; facet_instance < platform_placement.Length; facet_instance++) 
			{
				facet[facet_instance] = platform_placement [facet_instance].Item1;
				string platform_ref = platform_placement [facet_instance].Item2;

				// determinar qual o endereço da plataforma onde deve ser instanciada a facet-ésima faceta do componente arch_ref.
				facet_address[facet_instance] = platform_address_list [platform_ref];
			}

			for (int facet_instance = 0; facet_instance < platform_placement.Length; facet_instance++) 
			{				
				string platform_address = facet_address [facet_instance];
				CoreServiceUtils.invokeInstantiateComponent (platform_address, arch_ref, facet_instance, facet, facet_address);
			}

		//	ServiceUtils.invokeInstantiateApplicationBindings (arch_desc, arch_ref, platform_address_SAFe);

			return "instantiated";
		}

        #endregion
		
		
		private string[] buildComponentDescription (br.ufc.pargo.hpe.backend.DGAC.database.Component[] cs)
		{
			IList<string> cDescList = new List<string> ();

			foreach (br.ufc.pargo.hpe.backend.DGAC.database.Component c in cs) 
			{
				Instantiator.ComponentFunctorApplicationType contract;

				AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve (c.Id_functor_app);
				contract = BackEnd.saveACFAToInstantiator (acfa);

				ComponentReference.ComponentReference cref = new ComponentReference.ComponentReference ();
				cref.component_ref = c.Library_path;
				cref.contract = contract;

				string cref_string = LoaderApp.serialize<ComponentReference.ComponentReference> (cref);

				//Tuple<string,string> cDesc = new Tuple<string,string> (c.Library_path, contract_string);
				cDescList.Add (cref_string);
			}

			string[] cDescArr = new  string[cDescList.Count];
			cDescList.CopyTo (cDescArr, 0);
			return cDescArr;
		}

	}
		


		
}
