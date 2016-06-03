
using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace gov
{
    namespace cca
    {
        [Serializable]
        public abstract class ManagerComponentID : ComponentID
        {
            public abstract string InstanceName { get; set; }
			public abstract string ClassName { get; set; }
            public abstract int[] WorkerNodes { get; set; }
            public abstract IList<string>[] WorkerUnitNames { get; set; }
            public abstract int[] WorkerUnitIndexes { get; set; }
			public abstract int Version {get; set;}

           // public abstract WorkerComponentID WorkerComponentID { get; }
            public abstract WorkerComponentID getWorkerComponentID(int node);
			public abstract void registerWorkerComponentID(int node, WorkerComponentID wcid);
            public abstract int Id_functor_app { get; }
			public abstract string PortName {get; set;}
            public abstract int Kind { get; }
        }


        [Serializable]
        public class ManagerComponentIDImpl : ManagerComponentID
        {
            #region attributes

            private int[] nodes = null;
            private IList<string>[] unit_ids = null;
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
            public ManagerComponentIDImpl(string instanceName, string className, int[] nodes)
            {
                this.instanceNamePrim = instanceName;
				this.classNamePrim = className;
				this.WorkerNodes = nodes;
                this.wcids = new Dictionary<int, WorkerComponentID>();
            }
			
			// For registering a #-component
            public ManagerComponentIDImpl(string instanceName, string className, int[] nodes, IList<string>[] unit_ids, int[] indexes, /*WorkerComponentID[] wcids,*/ int id_functor_app, int kind, string portName)
            {
                this.instanceNamePrim = instanceName;
				this.classNamePrim = className;
                this.nodes = nodes;
                this.unit_ids = unit_ids;
                this.indexes = indexes;
                this.id_functor_app = id_functor_app;
                this.kind = kind;
                this.wcids = new Dictionary<int, WorkerComponentID>();
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

            public override IList<string>[] WorkerUnitNames
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
			
			public override void registerWorkerComponentID(int node, WorkerComponentID wcid)
            {
                wcids[node] = wcid;
            }
			
            public override WorkerComponentID getWorkerComponentID(int node)
            {
				Trace.WriteLine ("getWorkerComponentID - SIZE=" + wcids.Count + " --- node=" + node);
				foreach (KeyValuePair<int,WorkerComponentID> t in wcids)
					Trace.WriteLine ("getWorkerComponentID - KEY=" + t.Key + ", VALUE=" + t.Value.getInstanceName());

				return wcids [node];
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
