
using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace gov
{
	namespace cca
	{
		[Serializable]
		public abstract class ManagerIgnoredComponentID : ManagerComponentID
		{
		}


		[Serializable]
		public class ManagerIgnoredComponentIDImpl : ManagerIgnoredComponentID
		{
			#region attributes

			private int[] nodes = null;
			private string[] unit_ids = null;
			private int[] indexes = null;
			private string instanceNamePrim = null;
			private string classNamePrim = null;
			private int version;
			private string portName;

			#endregion

			#region constructors

			//public ManagerComponentIDImpl()
			//{
			//}

			// For registering a Host Program
			public ManagerIgnoredComponentIDImpl(string instanceName, string className)
			{
				this.instanceNamePrim = instanceName;
				this.classNamePrim = className;
				this.wcids = new Dictionary<int, WorkerComponentID>();
				this.unit_ids = new string[0];
				this.nodes = new int[0];
			}

			// For registering a #-component
			public ManagerIgnoredComponentIDImpl(string instanceName, string className, int id_functor_app, int kind, string portName)
			{
				this.instanceNamePrim = instanceName;
				this.classNamePrim = className;
				this.id_functor_app = id_functor_app;
				this.kind = kind;
				this.wcids = new Dictionary<int, WorkerComponentID>();
				this.nodes = new int[0];
				this.unit_ids = new string[0];
				this.portName = portName;	
			}

			#endregion

			#region properties (for serialization purposes)

			public override string InstanceName
			{
				get { return instanceNamePrim; }
				set { this.instanceNamePrim = value; }
			}

			public override int Version
			{
				get { return version; }
				set { this.version = value; }
			}

			public override string ClassName
			{
				get { return classNamePrim; }
				set { this.classNamePrim = value; }
			}

			public override string PortName
			{
				get { return portName; }
				set { this.portName = value; }
			}

			public override int[] WorkerNodes
			{
				get { return nodes; }
				set { this.nodes = value; }
			}

			public override string[] WorkerUnitNames
			{
				get { return unit_ids; }
				set { this.unit_ids = value; }
			}

			public override int[] WorkerUnitIndexes
			{
				get { return indexes; }
				set { this.indexes = value; }
			}

			#endregion 

			#region ComponentID members

			public override string getInstanceName()
			{
				return instanceNamePrim;
			}

			public override string getSerialization()
			{
				return this.ToString(); /* TODO: return a XML */
			}

			#endregion

			private IDictionary<int, WorkerComponentID> wcids = new Dictionary<int,WorkerComponentID>();

			public override void registerWorkerComponentID(int i, WorkerComponentID wcid)
			{

				if (!wcids.ContainsKey(i))
					wcids[i] = wcid;
				else
                    throw new Exception("registerWorkerService (ignored): wcids[" + i + "] already exists !");
			}

			public override WorkerComponentID getWorkerComponentID(int i)
			{
				return wcids [i];
			}

			public override string ToString()
			{
				return instanceNamePrim;
			}

			private int id_functor_app;

			public override int Id_functor_app
			{
				get { return id_functor_app; }
			}

			private int kind;

			public override int Kind
			{
				get { return kind; }
			}
		}

	}
}
