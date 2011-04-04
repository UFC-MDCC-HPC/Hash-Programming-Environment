/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using System.Collections.Generic;
using System.Threading;
namespace br.ufc.pargo.hpe.backend.DGAC
{
    class ManagerServices : gov.cca.Services
    {

        public ManagerServices(ManagerComponentID cid)
        {

        }

        #region Services Members

        public gov.cca.Port getPort(string portName)
        {
            throw new System.NotImplementedException();

        }

        public gov.cca.Port getPortNonblocking(string portName)
        {
            throw new System.NotImplementedException();
        }

        public void releasePort(string portName)
        {
            throw new System.NotImplementedException();
        }

        public gov.cca.TypeMap createTypeMap()
        {
            throw new System.NotImplementedException();
        }

        public void registerUsesPort(string portName, string type, gov.cca.TypeMap properties)
        {
            throw new System.NotImplementedException();
        }

        public void unregisterUsesPort(string portName)
        {
            throw new System.NotImplementedException();
        }

        public void addProvidesPort(gov.cca.Port inPort, string portName, string type, gov.cca.TypeMap properties)
        {
            throw new System.NotImplementedException();
        }

        public gov.cca.TypeMap getPortProperties(string name)
        {
            throw new System.NotImplementedException();
        }

        public void removeProvidesPort(string portName)
        {
            throw new System.NotImplementedException();
        }

        public gov.cca.ComponentID getComponentID()
        {
            throw new System.NotImplementedException();
        }

        public void registerForRelease(gov.cca.ComponentRelease callBack)
        {
            throw new System.NotImplementedException();
        }

        #endregion

        private IList<WorkerServices> worker_services_list = new List<WorkerServices>();

        internal void addWorkerServicesObject(int i, WorkerServices worker_services)
        {
            this.worker_services_list.Insert(i, worker_services);
        }

        public IList<WorkerServices> worker_services {get {return worker_services_list;}}

}


}
