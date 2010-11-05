using System;
using System.Data;
using System.Web;
using System.Collections;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;

using br.ufc.lia.hpe.backend.DGAC.database;
using HPE_DGAC_LoadDB;
using br.ufc.lia.hpe.backend.DGAC.utils;
using System.IO;

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

	    static br.ufc.lia.hpe.backend.DGAC.BackEnd dgac = null;
    	
	    public BackEnd_WS(){

              dgac = new br.ufc.lia.hpe.backend.DGAC.BackEnd();
    	
	    }

        #region BackEndFacade Members

        [WebMethod]
        /*
         * XML é visto como um array de bytes, chamado data.
         * esse array é salvo em "path" e lido por AppLoader gerando um objeto Component Type,
         * passado ao DGAC 
         */
        public string deployHashComponent(byte[] data, string userName, string password, string curDir)
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
                        dgac.registerConcreteComponent(c, userName, password, curDir);
                    else
                        dgac.registerAbstractComponent(c, userName, password, curDir);
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
            Console.WriteLine("Reading Environment");

            EnvironmentType env = dgac.readEnvironment();

            byte[] xmlEnv = LoaderApp.SerializeObject(Constants.PATH_TEMP_WORKER + "environment.xml", env);

            return xmlEnv;
        }

        [WebMethod]
        public string[] runApplication(int id_concrete, string[] eIds, int[] eVls, string userName, string password, string curDir)
        {
		
            Console.WriteLine("STEP -1");	
            string[] str_output = null;
            try
            {
                str_output = dgac.runApplication(id_concrete, eIds, eVls, userName, password, curDir);
            }
            catch (Exception e)
            {
                str_output = new String[1];
                str_output[0] = "-- Message -- \n " + e.Message + "\n\n -- Stack Trace --\n" + e.StackTrace + "\n\n -- Inner Exception -- \n" + e.InnerException;
            }
            return str_output;
        }


        [WebMethod]
        public string hosts()
        {
            TextReader tr = new StreamReader(Constants.hosts_file);

            string hstr = tr.ReadToEnd();
            tr.Close();
            return hstr;
        }

        #endregion

    }
}
