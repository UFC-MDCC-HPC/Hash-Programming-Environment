
using System;
using System.IO;
using System.Collections.Generic;
using br.ufc.pargo.hpe.basic;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Reflection;
using br.ufc.pargo.hpe.backend.DGAC.utils;

namespace br.ufc.pargo.hpe.backend.DGAC
{
    public interface WorkerServices : gov.cca.Services
    {

    }

    public class WorkerServicesImpl : WorkerServices
    {
        private WorkerObject framework;
        private ComponentID cid;
        private string instanceName;

        public WorkerServicesImpl(WorkerObject framework, ComponentID cid, IUnit unit)
        {
            this.cid = cid;
            this.instanceName = cid.getInstanceName();
            this.framework = framework;
            unit.CID = cid;
            framework.registerComponentID(cid, this, unit);
        }

        public WorkerServicesImpl(WorkerObject framework, ComponentID cid)
        {
            this.cid = cid;
            this.instanceName = cid.getInstanceName();
            this.framework = framework;
            framework.registerComponentID(this.getComponentID(), this);
        }

        public WorkerServicesImpl(WorkerObject framework, ComponentID cid, string hash_component_uid, string my_id_unit, IUnit pmain, string[] args)
        {
            this.cid = cid;
            this.instanceName = cid.getInstanceName();
            this.framework = framework;
            framework.Init(hash_component_uid, my_id_unit, pmain, args);
        }


        private string mkPortName(string portName)
        {
            return this.instanceName + ":" + portName;
        }


        // SERVICES  ==============================================================================================

        public Port getPort(string portName)
        {
            return framework.getPort(mkPortName(portName));
        }

        public Port getPortNonblocking(string portName)
        {
            return framework.getPortNonblocking(mkPortName(portName));
        }

        public void releasePort(string portName)
        {
            framework.releasePort(mkPortName(portName));
        }

        public TypeMap createTypeMap()
        {
            return framework.createTypeMap();
        }

        public void registerUsesPort(string portName, string type, TypeMap properties)
        {
            framework.registerUsesPort(mkPortName(portName), type, properties);
        }

        public void unregisterUsesPort(string portName)
        {
            framework.unregisterUsesPort(mkPortName(portName));
        }


        public void addProvidesPort(Port inPort, string portName, string type, TypeMap properties)
        {
            framework.addProvidesPort(inPort, mkPortName(portName), type, properties);
        }

        public TypeMap getPortProperties(string name)
        {
            return framework.getPortProperties(mkPortName(name));
        }

        public void removeProvidesPort(string portName)
        {
            framework.removeProvidesPort(mkPortName(portName));
        }

        public ComponentID getComponentID()
        {
            return this.cid;
        }

        private ComponentRelease callBack = null;

        public void registerForRelease(ComponentRelease callBack)
        {
            this.callBack = callBack;
            this.framework.registerForRelease(this, callBack);
        }

        // ==============================================================================================

        //   private IList<IUnit> slices = null;


        ~WorkerServicesImpl()
        {
            //    Console.WriteLine("DESTRUCTOR " + session_id);
            //    foreach (hpe.basic.IUnit slice in slices)
            //    {
            //        slice.destroySlice();
            //    }

            //    Connector.closeConnection();
            //    if (open_log_out)
            //        log_out.Close();

        }

        //        private StreamWriter log_out = null;
        //        private string output_log_filename = "output";
        //        private bool open_log_out = true;




      /*  public IUnit autoConnect(IUnit unit,
                                 string portName,
                                 string hash_component_uid,
                                 string id_inner,
                                 string id_interface
                                )
        {
            return framework.autoConnect(unit, portName, hash_component_uid, id_inner, id_interface);
        }
    */



    }
}
