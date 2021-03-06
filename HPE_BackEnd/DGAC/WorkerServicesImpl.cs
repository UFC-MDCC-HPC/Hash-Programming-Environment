﻿
using System;
using System.IO;
using System.Collections.Generic;
using br.ufc.pargo.hpe.basic;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Reflection;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Diagnostics;
using System.Runtime.Serialization;
using System.ServiceModel;
using br.ufc.pargo.hpe.ports;

namespace br.ufc.pargo.hpe.backend.DGAC
{
	[ServiceContract]	
	//[ServiceKnownType(typeof(WorkerServicesImpl2))]
	//[ServiceKnownType(typeof(TypeMapImpl))]
	public interface WorkerServices : gov.cca.Services
    {

    }

	[DataContract]
	[ServiceBehavior(InstanceContextMode=InstanceContextMode.Single,
		ConcurrencyMode=ConcurrencyMode.Multiple)]
	public class WorkerServicesImpl : WorkerServices
    {
		[DataMember]
        private IWorkerObject framework;

		[DataMember]
		private ComponentID cid;

		[DataMember]
        private string instanceName;

		[DataMember]
		private string unitName = "";

		public WorkerServicesImpl(IWorkerObject framework, ComponentID cid, IUnit unit)
        {
			this.cid = cid;
            this.instanceName = cid.getInstanceName();
            this.framework = framework;
            unit.CID = cid;
            this.unitName = unit.Id_unit;
            framework.registerComponentID_unit(cid, this, unit);
        }

        public WorkerServicesImpl(IWorkerObject framework, ComponentID cid)
        {
			this.cid = cid;
            this.instanceName = cid.getInstanceName();
            this.framework = framework;
            framework.registerComponentID(this.getComponentID(), this);
        }


        private string mkPortName(string portName)
        {
			Console.WriteLine ("mkPortName 1: " + this.GetHashCode() + ":" + this.instanceName + ":" + portName.Trim() /*+ unitName.Trim()*/);
            return /*this.GetHashCode() + ":" +*/  this.instanceName + ":" + portName.Trim() /*+ unitName.Trim()*/;
        }


        // SERVICES  ==============================================================================================

		[ServiceKnownType(typeof(GoPortWrapper))]
        public Port getPort(string portName)
        {
			Port port = framework.getServicePort(cid, mkPortName(portName));
			if (port == null) 
			{
				port = framework.getPort (mkPortName(portName));
			}
			return port;
        }

		[ServiceKnownType(typeof(GoPortWrapper))]
        public Port getPortNonblocking(string portName)
        {
			Port port = framework.getServicePort(cid, mkPortName(portName));
			if (port==null) 
			{
                Console.WriteLine("getPortNonBlocking port==null --- {0}", portName);
				port = framework.getPortNonblocking (mkPortName (portName));
			}
			return port;
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
			Console.WriteLine ("WorkerServicesImpl - registerUserPort 1 - " + portName);
            framework.registerUsesPort(mkPortName(portName), type, properties);
			Console.WriteLine ("WorkerServicesImpl - registerUserPort 2 - " + portName);
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

		[DataMember]
		private ComponentRelease callBack = null;

        public void registerForRelease(ComponentRelease callBack)
        {
            this.callBack = callBack;
            this.framework.registerForReleaseServices(this, callBack);
        }
	
    }
	public class RemoteWorkerServicesImpl : WorkerServices
	{		
		private RemoteWorkerObject framework;
		private ComponentID cid;
		private string instanceName;
		private static int fresh_key = 0;
		private int my_key;

		public RemoteWorkerServicesImpl(IWorkerObject framework, ComponentID cid)
		{
			this.cid = cid;
			this.instanceName = cid.getInstanceName();
			this.framework = (RemoteWorkerObject) framework;
			framework.registerComponentID(this.getComponentID(), this);

			my_key = fresh_key++;
		}

		public int RemoteKey { get { return my_key; } }

		[ServiceKnownType(typeof(GoPortWrapper))]
		public Port getPort(string portName)
		{
			Port port = framework.getServicePort(cid, mkPortName(portName));
			if (port == null) 
			{
				port = framework.getPort (mkPortName(portName));
			}
			return port;
		}

		[ServiceKnownType(typeof(GoPortWrapper))]
		public Port getPortNonblocking(string portName)
		{
			Port port = framework.getServicePort(cid, mkPortName(portName));
			if (port==null) 
			{
				Console.WriteLine("getPortNonBlocking remote port==null --- {0}", portName);
				port = framework.getPortNonblocking (mkPortName (portName));
			}
			return port;
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
		//	Console.WriteLine ("RemoteItemChoiceType - " + portName);
			framework.registerUsesPort(mkPortName(portName), type, properties);
		//	Console.WriteLine ("RemoteWorkerServicesImpl - registerUserPort 2 - " + portName);
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
			this.framework.registerForReleaseServices(this, callBack);
		}

		private string mkPortName(string portName)
		{
            int hash_code = framework.getServicesHashCode(RemoteKey);
            
			Console.WriteLine("mkPortName 2: " + hash_code + ":" + this.instanceName + ":" + portName.Trim() /*+ unitName.Trim()*/);
			return /*hash_code + ":" +*/ this.instanceName + ":" + portName.Trim() /*+ unitName.Trim()*/;
		}
	}

	[DataContract]
	public class RemoteGoPort :gov.cca.ports.GoPort
	{
		[DataMember] 
		private int id;

		public RemoteGoPort(int id)
		{
			this.id = id;
		}

		public RemoteGoPort() {}

		private IWorkerObject framework;
		public IWorkerObject Framework {set { this.framework = value; } }

		public int go()
		{
			return framework.perform_go (id);
			//IAsyncResult res = framework.BeginPerformGo (id, null, null);
			//res.AsyncWaitHandle.WaitOne ();
			//return framework.EndPerformGo (res);
		}
	}

	[DataContract]
	public class RemoteInitializePort : InitializePort
	{
		[DataMember] 
		private int id;

		public RemoteInitializePort(int id)
		{
			this.id = id;
		}

		public RemoteInitializePort() {}

		private RemoteWorkerObject framework;
		public RemoteWorkerObject Framework {set { this.framework = value; } }

		public void on_initialize()
		{
			framework.perform_on_initialize (id);
		}

		public void after_initialize()
		{
			framework.perform_after_initialize (id);
		}
	}

}
