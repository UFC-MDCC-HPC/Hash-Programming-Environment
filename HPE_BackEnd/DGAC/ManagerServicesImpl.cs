
using System;
using System.IO;
using System.Collections.Generic;
using br.ufc.hpe.basic;
using gov.cca;
using br.ufc.hpe.backend.DGAC.database;
using System.Reflection;
using br.ufc.hpe.backend.DGAC.utils;

namespace br.ufc.hpe.backend.DGAC
{
    public interface ManagerServices : gov.cca.Services
    {
        void addWorkerServicesObject(int node, WorkerServices worker_services);
        WorkerServices getWorkerServicesObject(int node);
    }

    public class ManagerServicesImpl : ManagerServices
    {
        private WorkerServices[] worker_services;
        private ManagerComponentID cid;
        private ManagerObject framework;
        public string instanceName;


        public ManagerServicesImpl(ManagerObject framework, ManagerComponentID cid)
        {
            this.cid = cid;
            this.instanceName = cid.getInstanceName();
            this.framework = framework;
        }

        public void addWorkerServicesObject(int node, WorkerServices worker_services)
        {
            this.worker_services[node] = worker_services;
        }

        public WorkerServices getWorkerServicesObject(int node)
        {
            return this.worker_services[node];
        }


        // SERVICES  ==============================================================================================

        public Port getPort(string portName)
        {
        }

        public Port getPortNonblocking(string portName)
        {
        }

        public void releasePort(string portName)
        {
        }

        public TypeMap createTypeMap()
        {
        }

        public void registerUsesPort(string portName, string type, TypeMap properties)
        {
        }

        public void unregisterUsesPort(string portName)
        {
        }


        public void addProvidesPort(Port inPort, string portName, string type, TypeMap properties)
        {
        }

        public TypeMap getPortProperties(string name)
        {
        }

        public void removeProvidesPort(string portName)
        {
        }

        public ComponentID getComponentID()
        {
        }


        public void registerForRelease(ComponentRelease callBack)
        {
        }



        ~ManagerServicesImpl()
        {

        }

    }
}
