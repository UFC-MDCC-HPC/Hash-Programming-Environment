
using System;
using System.Collections.Generic;

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
            public abstract string[] WorkerUnitNames { get; set; }
            public abstract int[] WorkerUnitIndexes { get; set; }

           // public abstract WorkerComponentID WorkerComponentID { get; }
            public abstract WorkerComponentID getWorkerComponentID(int node);
			public abstract void registerWorkerComponentID(int node, WorkerComponentID wcid);
            public abstract int Id_functor_app { get; }
            public abstract int Kind { get; }
        }

        [Serializable]
        public class ManagerComponentIDImpl : ManagerComponentID
        {
            #region attributes

            private int[] nodes = null;
            private string[] unit_ids = null;
            private int[] indexes = null;
            private string instanceNamePrim = null;
            private string classNamePrim = null;

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
            public ManagerComponentIDImpl(string instanceName, int[] nodes, string[] unit_ids, int[] indexes, /*WorkerComponentID[] wcids,*/ int id_functor_app, int kind)
            {
                this.instanceNamePrim = instanceName;
                this.nodes = nodes;
                this.unit_ids = unit_ids;
                this.indexes = indexes;
                this.id_functor_app = id_functor_app;
                this.kind = kind;
                this.wcids = new Dictionary<int, WorkerComponentID>();
//                for (int i = 0; i < nodes.Length; i++)
//                {
 //                   this.wcids[i] = wcids[i];
  //              }
            }

            #endregion

            #region properties (for serialization purposes)

            public override string InstanceName
            {
                get { return instanceNamePrim; }
                set { this.instanceNamePrim = value; }
            }

            public override string ClassName
            {
                get { return classNamePrim; }
                set { this.classNamePrim = value; }
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
			
			public override void registerWorkerComponentID(int node, WorkerComponentID wcid)
            {
                wcids[node] = wcid;
            }
			
            public override WorkerComponentID getWorkerComponentID(int node)
            {
                WorkerComponentID wcid;
                wcids.TryGetValue(node, out wcid);
                return wcid;
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
