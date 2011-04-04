using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
//using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
// using System.Xml.Linq;
using System.Runtime.Remoting.Channels.Ipc;
using br.ufc.pargo.hpe.backend.DGAC;
using gov.cca;
using System.Xml.Serialization;


namespace br.ufc.pargo.hpe.cca.ports.BuilderService
{
    /// <summary>
    /// Summary description for Service1
    /// </summary>
    [WebService(Namespace = "http://BuilderService.ports.cca.hpe.pargo.ufc.br/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [ToolboxItem(false)]    
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]    
    //[System.Xml.Serialization.XmlInclude(typeof(System.Collections.Generic.Dictionary<string, object>))]
    [System.Xml.Serialization.XmlInclude(typeof(gov.cca.TypeMapImplWS))]
    [System.Xml.Serialization.XmlInclude(typeof(gov.cca.ManagerComponentIDImpl))]
    [System.Xml.Serialization.XmlInclude(typeof(gov.cca.ManagerConnectionID))]
    public class BuilderService : System.Web.Services.WebService, gov.cca.ports.BuilderService
    {
        private IpcClientChannel ch;

        #region BuilderService Members

        [WebMethod]
        public gov.cca.ComponentID createInstance(string instanceName, string className, gov.cca.TypeMap properties)
        {
            gov.cca.ComponentID cid = null;

            try
            {
                ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

                TypeMap map = new TypeMapImpl(properties);

                cid = manager.createInstance(instanceName, className, map);

            }
            catch (Exception e)
            {
                Console.Error.WriteLine("ERROR Creating Instance !");
            }
            finally
            {
                backend.DGAC.BackEnd.releaseManager(ch);
            }

            return cid;
        }

        [WebMethod]
        public gov.cca.ComponentID[] getComponentIDs()
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.ComponentID[] cids = manager.getComponentIDs();

            backend.DGAC.BackEnd.releaseManager(ch);

            return cids;
        }

        [WebMethod]
        public gov.cca.TypeMap getComponentProperties(gov.cca.ComponentID cid)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.TypeMap properties = manager.getComponentProperties(cid);

            backend.DGAC.BackEnd.releaseManager(ch);

            return properties;
        }

        [WebMethod]
        public void setComponentProperties(gov.cca.ComponentID cid, gov.cca.TypeMap map)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            manager.setComponentProperties(cid, new TypeMapImpl(map));

            backend.DGAC.BackEnd.releaseManager(ch);
        }

        [WebMethod]
        public gov.cca.ComponentID getDeserialization(string s)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.ComponentID cid = manager.getDeserialization(s);

            backend.DGAC.BackEnd.releaseManager(ch);

            return cid;
        }
        
        [WebMethod]
        public gov.cca.ComponentID getComponentID(string componentInstanceName)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.ComponentID cid = manager.getComponentID(componentInstanceName);

            backend.DGAC.BackEnd.releaseManager(ch);

            return cid;
        }

        [WebMethod]
        public void destroyInstance(gov.cca.ComponentID toDie, float timeout)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            manager.destroyInstance(toDie, timeout);

            backend.DGAC.BackEnd.releaseManager(ch);
        }

        [WebMethod]
        public string[] getProvidedPortNames(gov.cca.ComponentID cid)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            string[] names = manager.getProvidedPortNames(cid);

            backend.DGAC.BackEnd.releaseManager(ch);

            return names;
        }

        [WebMethod]
        public string[] getUsedPortNames(gov.cca.ComponentID cid)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            string[] names = manager.getUsedPortNames(cid);

            backend.DGAC.BackEnd.releaseManager(ch);

            return names;
        }

        [WebMethod]
        public gov.cca.TypeMap getPortProperties(gov.cca.ComponentID cid, string portName)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.TypeMap properties = manager.getPortProperties(cid, portName);

            backend.DGAC.BackEnd.releaseManager(ch);

            return properties;
        }

        [WebMethod]
        public void setPortProperties(gov.cca.ComponentID cid, string portName, gov.cca.TypeMap map)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            manager.setPortProperties(cid, portName, new TypeMapImpl(map));

            backend.DGAC.BackEnd.releaseManager(ch);
        }

        [WebMethod]
        public gov.cca.ConnectionID connect(gov.cca.ComponentID user, string usingPortName, gov.cca.ComponentID provider, string providingPortName)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.ConnectionID conn_id = manager.connect(user, usingPortName, provider, providingPortName);

            backend.DGAC.BackEnd.releaseManager(ch);

            return conn_id;
        }

        [WebMethod]
        public gov.cca.ConnectionID[] getConnectionIDs(gov.cca.ComponentID[] componentList)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.ConnectionID[] conn_ids = manager.getConnectionIDs(componentList);

            backend.DGAC.BackEnd.releaseManager(ch);

            return conn_ids;
        }

        [WebMethod]
        public gov.cca.TypeMap getConnectionProperties(gov.cca.ConnectionID connID)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            gov.cca.TypeMap properties = manager.getConnectionProperties(connID);

            backend.DGAC.BackEnd.releaseManager(ch);

            return properties;
        }

        [WebMethod]
        public void setConnectionProperties(gov.cca.ConnectionID connID, gov.cca.TypeMap map)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            manager.setConnectionProperties(connID, new TypeMapImpl(map));

            backend.DGAC.BackEnd.releaseManager(ch);
        }

        [WebMethod]
        public void disconnect(gov.cca.ConnectionID connID, float timeout)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            manager.disconnect(connID, timeout);

            backend.DGAC.BackEnd.releaseManager(ch);
        }

        [WebMethod]
        public void disconnectAll(gov.cca.ComponentID id1, gov.cca.ComponentID id2, float timeout)
        {
            ManagerObject manager = backend.DGAC.BackEnd.connectToManager(out ch);

            manager.disconnectAll(id1, id2, timeout);

            backend.DGAC.BackEnd.releaseManager(ch);
        }

        #endregion
    }
}
