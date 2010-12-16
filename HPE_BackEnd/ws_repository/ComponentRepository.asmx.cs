using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml.Linq;
using System.Runtime.Remoting.Channels.Ipc;
using br.ufc.pargo.hpe.backend.DGAC;

namespace br.ufc.pargo.hpe.cca.ports.ComponentRepository
{
    /// <summary>
    /// Summary description for Service1
    /// </summary>
    [WebService(Namespace = "http://ComponentRepository.ports.cca.hpe.pargo.ufc.br/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]


    [System.Xml.Serialization.XmlInclude(typeof(gov.cca.ManagerComponentClassDescriptionImpl))]
    public class ComponentRepository : System.Web.Services.WebService, gov.cca.ports.ComponentRepository
    {
        private IpcClientChannel ch;

        #region ComponentRepository Members

        [WebMethod]
        public gov.cca.ComponentClassDescription[] getAvailableComponentClasses()
        {
            ManagerObject manager = br.ufc.pargo.hpe.backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.ComponentClassDescription[] cs = manager.getAvailableComponentClasses();

            br.ufc.pargo.hpe.backend.DGAC.BackEnd.releaseManager(ch);

            return cs;           
        }

        #endregion
    }
}
