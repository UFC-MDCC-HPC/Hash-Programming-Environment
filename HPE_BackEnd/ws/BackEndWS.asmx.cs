using System;
using System.Collections.Generic;
using System.Data;
using System.Web;
using System.Collections;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;

using br.ufc.pargo.hpe.backend.DGAC.database;
using HPE_DGAC_LoadDB;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.IO;
using Catalog;
using br.ufc.pargo.hpe.backend.DGAC;

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
		  	
	    public BackEnd_WS()
		{

		}

		[WebMethod]
		public string getSiteName()
		{
			return br.ufc.pargo.hpe.backend.DGAC.BackEnd.getSiteName();
		}

     	#region Deploy

	
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
                    if (c.header.baseType != null && c.header.baseType.extensionType.ItemElementName == ItemChoiceType1.implements)
                        BackEnd.registerConcreteComponent(c, userName, password, curDir);
                    else
                        BackEnd.registerAbstractComponent(c, userName, password, curDir);
                }
            } 
			catch (Exception e) 
			{
                Console.WriteLine(e.Message);
                return "-- Message -- \n " + e.Message + "\n\n -- Stack Trace --\n" + e.StackTrace + "\n\n -- Inner Exception -- \n" + e.InnerException;
            }

            return null;
        }

        [WebMethod]
        /*
         * XML é visto como um array de bytes, chamado data.
         * esse array é salvo em "path" e lido por AppLoader gerando um objeto Component Type,
         * passado ao DGAC 
         */
        public string deployHashConfiguration(byte[] data, byte[] hcl_data, string userName, string password, string curDir)
        {
			Console.WriteLine ("deployHashConfiguration");
			Console.WriteLine("hcl_data is null ? {0} ! {1}", hcl_data == null, data == null);

            try
            {
				string filename = "newConfig";
                string path = Constants.PATH_TEMP_WORKER + filename + ".xml";
                if (data != null)
                {
                    FileUtil.saveByteArrayIntoFile(data, path);
                    ComponentType c = LoaderApp.DeserializeObject(path);
                    int id_abstract = BackEnd.registerAbstractComponent(c, userName, password, curDir);
					BackEnd.updateConfiguration(id_abstract, hcl_data);
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

            EnvironmentType env = br.ufc.pargo.hpe.backend.DGAC.BackEnd.readEnvironment();

            byte[] xmlEnv = LoaderApp.SerializeEnvironment(Constants.PATH_TEMP_WORKER + "environment.xml", env);

            return xmlEnv;
        }

 		[WebMethod]
        public /*byte[]*/ string readCatalog()
        {
            Console.WriteLine("Reading Component Catalog");

            CatalogType env = br.ufc.pargo.hpe.backend.DGAC.BackEnd.readCatalog();

           string xmlEnv = LoaderApp.SerializeCatalog(Constants.PATH_TEMP_WORKER + "catalog.xml", env);

            return xmlEnv;
        }


        [WebMethod]
        public string[] runApplication(int id_concrete, string[] eIds, int[] eVls, string userName, string password, string curDir)
        {
		
            Console.WriteLine("STEP -1");	
            string[] str_output = null;
            try
            {
                str_output = null; //dgac.runApplication(id_concrete, eIds, eVls, userName, password, curDir);
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


		#region Sessions

		private IDictionary<SessionID, BackEnd> dgac_sessions = null;

		[WebMethod]
		public SessionID openSession()
		{
			if (dgac_sessions == null)
				dgac_sessions = new Dictionary<SessionID, BackEnd> ();

			BackEnd dgac = new BackEnd();

			SessionID session_id = new SessionID();
			dgac_sessions.Add (session_id, dgac);

			return session_id;
		}

		[Serializable]
		public class SessionID
		{
		}

		// criar instância de componente

		// ligar portas

		// executar



		#endregion Sessions



    }
}
