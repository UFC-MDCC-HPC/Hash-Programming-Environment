using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
//using System.Xml.Linq;
using System.Runtime.Remoting.Channels.Ipc;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;

namespace br.ufc.mdcc.hpe.Core
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
        private IpcClientChannel ch;

        #region ComponentRepository Members

        [WebMethod]
		public string[] resolve (string contract)
        {
			AbstractComponentFunctorApplication acfa = build_contract (contract);

			string[] cs = BackEnd.resolveUnit(contract); 			
            return cs;           
        }

		[WebMethod]
		public string deploy (string deploy_info)
		{
			string result = BackEnd.deploy (deploy_info);
			return result;           
		}

		[WebMethod]
		public string instantiate (string instance_info)
		{
			string result = BackEnd.instantiate (instance_info);
			return result;           
		}


        #endregion
		
		
    }
		
}
