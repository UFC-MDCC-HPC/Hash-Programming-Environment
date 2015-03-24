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
			Console.WriteLine ("Manager STARTED !!");
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
        public string hosts()
        {
            TextReader tr = new StreamReader(Constants.hosts_file);

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
				Console.WriteLine (sid);

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
				Console.WriteLine (sid);
		}

		// criar instância de componente

		// ligar portas

		// executar

		[WebMethod]
		public string[] runApplication(string instantiator_string, string session)
		{
			string[] str_output = null;
			BackEnd dgac = null;
			if (dgac != null) 
			{
				try 
				{
					str_output = dgac.runApplication (instantiator_string);
				} catch (Exception e) 
				{
					str_output = new String[1];
					str_output [0] = "-- Message -- \n " + e.Message + "\n\n -- Stack Trace --\n" + e.StackTrace + "\n\n -- Inner Exception -- \n" + e.InnerException;
				}
			}
			return str_output;
		}


		[WebMethod]
		public string[] createComponentInstance(string instantiator_string, string session)
		{
			string str_output = createInstance (instantiator_string, 0, session);
			return str_output;
		}

		[WebMethod]
		public void createComponentInstance(string instance_name, string instantiator_string, int facet, string session)
		{
			/* STORM: The GoPort pattern will not be adopted. The component will have an inner component
					 * representing the provides facet of a task port, as well as a set of inner components 
					 * representing the uses and provides facets of environment ports. Every Task and Environment
					 * port components will implement a communication protocol between the uses and provides facet
					 */

			/* For HPE, a version of these task and environment port components could exist for connecting
					 * the application to the Front-End.
					 */
			BackEnd dgac = null;
			if (dgac != null) 
			{
				try 
				{
					dgac.createApplicationInstance (instance_name, instantiator_string, facet);
				} 
				catch (Exception e) 
				{

				}
			}
		}





		#endregion Sessions



    }
}
