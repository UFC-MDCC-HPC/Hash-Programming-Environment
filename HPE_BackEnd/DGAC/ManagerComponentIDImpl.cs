
using System;
using System.Collections.Generic;

namespace gov
{
    namespace cca
    {

        public abstract class ManagerComponentID : ComponentID
        {
            public abstract string InstanceName { get; set; }
            public abstract int[] WorkerNodes { get; set; }
            public abstract string[] WorkerUnitNames { get; set; }
            public abstract int[] WorkerUnitIndexes { get; set; }

            public abstract WorkerComponentID WorkerComponentID { get; }

            // public abstract WorkerComponentID getWorkerComponentID();
        }

        public class ManagerComponentIDImpl : ManagerComponentID
        {
            #region attributes

            private int[] nodes = null;
            private string[] unit_ids = null;
            private int[] indexes = null;
            private string instanceNamePrim = null;

            #endregion

            #region constructors

            public ManagerComponentIDImpl()
            {
            }

            public ManagerComponentIDImpl(string instanceName)
            {
                this.instanceNamePrim = instanceName;
            }

            public ManagerComponentIDImpl(string instanceName, int[] nodes, string[] unit_ids, int[] indexes)
            {
                this.instanceNamePrim = instanceName;
                this.nodes = nodes;
                this.unit_ids = unit_ids;
                this.indexes = indexes;
            }

            #endregion

            #region properties (for serialization purposes)

            public override string InstanceName
            {
                get { return instanceNamePrim; }
                set { this.instanceNamePrim = value; }
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

            public override WorkerComponentID WorkerComponentID
            {
                get { return new WorkerComponentIDImpl(this.getInstanceName()); }
            }

            public override string ToString()
            {
                return instanceNamePrim;
            }

            public override int GetHashCode()
            {
                return instanceNamePrim.GetHashCode();
            }

        }

    }
}
