/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using System.Collections.Generic;
using System.Threading;
using System;
using System.Runtime.Remoting.Channels.Tcp;
using System.Runtime.Remoting.Channels;
using System.Diagnostics;
using System.Runtime.Serialization;


namespace br.ufc.pargo.hpe.backend.DGAC
{
	public interface ManagerServices : gov.cca.Services 
	{
		IDictionary<int, WorkerServices> WorkerServices {get;}
		void registerWorkerService(int i, WorkerServices worker_service);
	}

    public class ManagerServicesImpl : ManagerServices
    {		
		private ManagerObject frw = null;
		private ManagerComponentID cid = null;
		
		
        public ManagerServicesImpl(ManagerObject frw, ManagerComponentID cid)
        {
			this.frw = frw;
			this.cid = cid;
        }

			
		private string InstanceName { get { return cid.getInstanceName(); } }
		
        private IDictionary<int, WorkerServices> worker_services_list = new Dictionary<int, WorkerServices>();

        public void registerWorkerService(int i, WorkerServices worker_services)
		{
            Console.WriteLine("REGISTER WORKER SERVICES {0} ", i);
            if (!worker_services_list.ContainsKey(i))
                worker_services_list[i] = worker_services;
            else
                throw new Exception("registerWorkerService: worker_services[" + i + "] already exists !");

            this.cid.registerWorkerComponentID(i, (WorkerComponentID) worker_services.getComponentID());
        }

		public IDictionary<int, WorkerServices> WorkerServices {
			get 
			{
				return worker_services_list;
			}
		}

		private string mkPortName(string portName)
		{
			return InstanceName + ":" +  portName;
		}
		
		#region Services implementation
		Port Services.getPort (string portName)
		{
			Port port = frw.getServicePort(cid, mkPortName(portName));
			
			return port == null ? frw.getPort(mkPortName(portName)) : port;
		}

		Port Services.getPortNonblocking (string portName)
		{
			Port port = frw.getServicePort(cid, portName);
			return  port == null ?  frw.getPortNonblocking(mkPortName(portName)) : port;
		}

		void Services.releasePort (string portName)
		{
		//	Console.WriteLine ("RELEASE PORT 1.0 " + portName + "/" + mkPortName(portName) + " --- " + cid.getInstanceName());
			ComponentID cid_inner = frw.getComponentID (mkPortName(portName));
		//	Console.WriteLine ("RELEASE PORT 1.1 " + portName +  " --- " + (cid_inner == null ? "NULL" : cid_inner.getInstanceName()));
			if (!(cid_inner is ManagerIgnoredComponentID))
			{
				int[] nodes = cid.WorkerNodes;
				//for (int i=0; i<nodes.Length; i++)
                foreach (int i in WorkerServices.Keys)
				{
                    //		Console.WriteLine ("RELEASE PORT 2 - i=" + i + " - nodes[i]=" + nodes[i]  /*+ " - " + WorkerServices.Length + " - " + nodes.Length*/);
                    gov.cca.Services ws = WorkerServices[i];
                    ws.releasePort(portName);
				}
			}
		//	Console.WriteLine ("RELEASE PORT 4 " + portName);
			frw.releasePort(mkPortName(portName));
		//	Console.WriteLine ("RELEASE PORT 5 " + portName);
		}

		gov.cca.TypeMap Services.createTypeMap ()
		{
			return new TypeMapImpl();
		}

		void Services.registerUsesPort (string portName, string type, gov.cca.TypeMap properties)
		{
			ComponentID cid_inner = frw.getComponentID (mkPortName(portName));
			if (!(cid_inner is ManagerIgnoredComponentID))
			{
				int[] nodes = cid.WorkerNodes;
                //for (int i=0; i<nodes.Length; i++)
                foreach (int i in WorkerServices.Keys)
				{
                    gov.cca.Services ws = WorkerServices[i];
					ws.registerUsesPort(portName, type, properties);
				}
			}
			frw.registerUsesPort(mkPortName(portName), type, properties);
		}

		void Services.unregisterUsesPort (string portName)
		{
			ComponentID cid_inner = frw.getComponentID (mkPortName(portName));
			if (!(cid_inner is ManagerIgnoredComponentID))
			{
				int[] nodes = cid.WorkerNodes;
				//for (int i=0; i<nodes.Length; i++)
                foreach (int i in WorkerServices.Keys)
				{
                    gov.cca.Services ws = WorkerServices[i];
                    ws.unregisterUsesPort(portName);
				}
			}
			frw.unregisterUsesPort(mkPortName(portName));
		}
		
		void Services.addProvidesPort (Port inPort, string portName, string type, gov.cca.TypeMap properties)
		{
			ComponentID cid_inner = frw.getComponentID (mkPortName(portName));
			if (!(cid_inner is ManagerIgnoredComponentID))
			{
				int[] nodes = cid.WorkerNodes;
				//for (int i=0; i<nodes.Length; i++)
                foreach (int i in WorkerServices.Keys)
				{
                    gov.cca.Services ws = WorkerServices[i];				
					ws.addProvidesPort(inPort, portName, type, properties);
				}
			}
			frw.addProvidesPort(inPort, mkPortName(portName), type, properties);
		}

		gov.cca.TypeMap Services.getPortProperties (string name)
		{
			return frw.getPortProperties(mkPortName(name));
		}

		void Services.removeProvidesPort (string portName)
		{
			ComponentID cid_inner = frw.getComponentID (mkPortName(portName));
			if (!(cid_inner is ManagerIgnoredComponentID))
			{
				int[] nodes = cid.WorkerNodes;
				//for (int i=0; i<nodes.Length; i++)
                foreach (int i in WorkerServices.Keys)
				{
                    gov.cca.Services ws = WorkerServices[i];
					ws.removeProvidesPort(portName);
				}
			}
			frw.removeProvidesPort(mkPortName(portName));
		}

		ComponentID Services.getComponentID ()
		{
			return cid;
		}

		void Services.registerForRelease (ComponentRelease callBack)
		{
			frw.registerForRelease(callBack);
		}
		
		#endregion
}


}
