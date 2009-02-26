using System;
using System.Data;
using System.Web;
using System.Collections;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;

using DGAC.database;
using HPE_DGAC_LoadDB;
using DGAC.utils;

namespace Back_End_WS
{
    /// <summary>
    /// Web Service de entrada para o Back-End do HPE.
    /// </summary>
    [WebService(Namespace = "http://backend.hPE/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [ToolboxItem(false)]
    public class BackEnd_WS : System.Web.Services.WebService
    {

	    static DGAC.IBackEnd dgac = null;
    	
	    public BackEnd_WS(){

              dgac = new DGAC.BackEnd();
    	
	    }
    	
        [WebMethod]
        /*
         * XML é visto como um array de bytes, chamado data.
         * esse array é salvo em "path" e lido por AppLoader gerando um objeto Component Type,
         * passado ao DGAC 
         */
        public String deployHashComponent(byte[] data)
        {
            try
            {
                string filename = "newConfig";
                string path = Constants.PATH_TEMP_WORKER + filename + ".xml";
                if (data != null)
                {
                    FileUtil.saveByteArrayIntoFile(data, path);
                    ComponentType c = LoaderApp.DeserializeObject(path);
                    if (c.header.baseType != null && c.header.baseType.extensionType.ItemElementName == ItemChoiceType.implements)
                        dgac.registerConcreteComponent(c);
                    else
                        dgac.registerAbstractComponent(c);
                }
            } catch (Exception e) {
                Console.WriteLine(e.Message);
                return "-- Message -- \n " + e.Message + "\n\n -- Stack Trace --\n" + e.StackTrace + "\n\n -- Inner Exception -- \n" + e.InnerException;
            }

            return null;
        }

        [WebMethod]
        public byte[] readEnvironment()
        {
            EnvironmentType env = dgac.readEnvironment();

            byte[] xmlEnv = LoaderApp.SerializeObject(Constants.PATH_TEMP_WORKER + "environment.xml", env);

            return xmlEnv;
        }

        [WebMethod]
        public String runApplication(int id_concrete, String[] eIds, int[] eVls)
        {
            try
            {
                return dgac.runApplication(id_concrete, eIds, eVls);
            }
            catch (Exception e)
            {
                return "-- Message -- \n " + e.Message + "\n\n -- Stack Trace --\n" + e.StackTrace + "\n\n -- Inner Exception -- \n" + e.InnerException;
            }

        }


        [WebMethod]
        public String touchBackEnd(string message)
        {
            return message + " - Hi Client !";
        }
    }
}
