/*=============================================================
(c) all rights reserved
================================================================*/

using System;
using gov.cca;


namespace br.ufc.pargo.hpe.backend.DGAC
{
    public interface ManagerServices : gov.cca.Services 
	{
		WorkerServices WorkerServices { get; set; }
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
		
		private WorkerServices worker_services = null;

		public WorkerServices WorkerServices {
			get 
			{
				return worker_services;
			}
			set 
			{
				worker_services = value;
                this.cid.WorkerComponentID = (WorkerComponentID) worker_services.getComponentID();
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
			//		Console.WriteLine ("RELEASE PORT 2 - ");
					gov.cca.Services ws = WorkerServices;
					try {
						ws.releasePort(portName);
					}
					catch (Exception e)
				    {
				//		Console.WriteLine ("RELEASE PORT 3");
						//if (e.getCCAExceptionType () != CCAExceptionType.PortNotDefined)
						//	throw e;
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
					gov.cca.Services ws = WorkerServices;
					ws.registerUsesPort(portName, type, properties);
			}
			frw.registerUsesPort(mkPortName(portName), type, properties);
		}

		void Services.unregisterUsesPort (string portName)
		{
			ComponentID cid_inner = frw.getComponentID (mkPortName(portName));
			if (!(cid_inner is ManagerIgnoredComponentID))
			{
				gov.cca.Services ws = WorkerServices;
				try
				{
					ws.unregisterUsesPort(portName);
				}
				catch (Exception e)
				{
					//if (e.getCCAExceptionType () != CCAExceptionType.PortNotDefined)
					//	throw e;
				}
			}
			frw.unregisterUsesPort(mkPortName(portName));
		}
		
		void Services.addProvidesPort (Port inPort, string portName, string type, gov.cca.TypeMap properties)
		{
			ComponentID cid_inner = frw.getComponentID (mkPortName(portName));
			if (!(cid_inner is ManagerIgnoredComponentID))
			{
					gov.cca.Services ws = WorkerServices;				
					ws.addProvidesPort(inPort, portName, type, properties);
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
					gov.cca.Services ws = WorkerServices;
					try 
					{
						ws.removeProvidesPort(portName);
					}
					catch (Exception e)
					{
						//if (e.getCCAExceptionType () != CCAExceptionType.PortNotDefined)
						//	throw e;
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
