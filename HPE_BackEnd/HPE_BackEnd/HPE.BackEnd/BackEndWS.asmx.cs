using System;
using System.Collections.Generic;
using System.Diagnostics;
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
			if (Trace.Listeners.Count <= 1) {
			    TextWriterTraceListener writer = new TextWriterTraceListener(System.Console.Out);
				Trace.Listeners.Add(writer);
			}

			BackEnd.startManager();
			Trace.WriteLine ("Manager STARTED !!");
		}

//		~BackEnd_WS()
//		{
//		BackEnd.stopManager();
//			Console.WriteLine ("Manager STOPED !!");
//		}

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
				string filename = Path.GetTempFileName();
				File.WriteAllBytes(filename,data);

                if (data != null)
                {
					ComponentType c = LoaderApp.DeserializeObject(filename);
					int res;
                    if (c.header.baseType != null && c.header.baseType.extensionType.ItemElementName == ItemChoiceType.implements)
                        res = BackEnd.registerConcreteComponentTransaction(c, userName, password, curDir);
                    else
                        res = BackEnd.registerAbstractComponentTransaction(c, userName, password, curDir);

					if (res>=0) 
					{
						string component_reference = c.header.packagePath + "." + c.header.name;
						File.Copy(filename,Constants.PATH_TEMP_WORKER + component_reference + ".hpe",true);
					}
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
			Trace.WriteLine ("deployHashConfiguration");
			Trace.WriteLine("hcl_data is null ? {0} ! {1}", hcl_data == null, data == null);

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
			Trace.WriteLine("Reading Environment");

            EnvironmentType env = br.ufc.pargo.hpe.backend.DGAC.BackEnd.readEnvironment();

            byte[] xmlEnv = LoaderApp.SerializeEnvironment(Constants.PATH_TEMP_WORKER + "environment.xml", env);

            return xmlEnv;
        }

 		[WebMethod]
        public string readCatalog()
        {
			Trace.WriteLine("Reading Component Catalog");

            CatalogType env = br.ufc.pargo.hpe.backend.DGAC.BackEnd.readCatalog();

            string xmlEnv = LoaderApp.SerializeCatalog(Constants.PATH_TEMP_WORKER + "catalog.xml", env);

            return xmlEnv;
        }


        [WebMethod]
        public string hosts()
        {
			TextReader tr = new StreamReader(Constants.HOSTS_FILE);

            string hstr = tr.ReadToEnd();
            tr.Close();
            return hstr;
        }

        #endregion


		#region Sessions

		[WebMethod]
		public string openSession(string session_id)
		{
			BackEnd.startSession(session_id);

			foreach (string sid in BackEnd.getSessions())
				Trace.WriteLine (sid);

			return session_id;
		}

		[WebMethod]
		public string[] getPorts(string session_id, string instance_id)
		{
			string[] ports = BackEnd.getPorts(session_id, instance_id);
			return ports;
		}

		[WebMethod]
		public void closeSession(string session_id)
		{
			BackEnd.finishSession (session_id);

			foreach (string sid in BackEnd.getSessions())
				Trace.WriteLine (sid);
		}

		// criar instância de componente

		// ligar portas

		// executar

		[WebMethod]
		public string[] runApplication(string instantiator_string, string session)
		{
			string[] str_output = null;

			try 
			{
				str_output = BackEnd.runApplication (instantiator_string, session);
			} catch (Exception e) 
			{
				str_output = new String[1];
				str_output [0] = "-- Message -- \n " + e.Message + "\n\n -- Stack Trace --\n" + e.StackTrace + "\n\n -- Inner Exception -- \n" + e.InnerException;
			}

			return str_output;
		}

		[WebMethod] 
		public void createApplicationInstance
			          (string session_id_string,     // Identification of the session of the application workflow.
			 		   string instance_name,         // Name of the component instance in the application.
			           string instantiator_string)   // Description of the component and its placement.
		{
			BackEnd.createSystemComponentInstance (null, instance_name, instantiator_string, session_id_string);
		}


		#endregion Sessions



    }
}
