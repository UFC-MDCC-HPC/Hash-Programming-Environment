/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using System.Collections.Generic;
using System.Threading;
namespace br.ufc.pargo.hpe.backend.DGAC
{
    class ManagerServices 
    {

        public ManagerServices(ManagerComponentID cid)
        {

        }

 
        private IList<WorkerServices> worker_services_list = new List<WorkerServices>();

        internal void addWorkerServicesObject(int i, WorkerServices worker_services)
        {
            this.worker_services_list.Insert(i, worker_services);
        }

        public IList<WorkerServices> worker_services {get {return worker_services_list;}}

}


}
