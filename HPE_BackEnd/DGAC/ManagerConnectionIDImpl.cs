
using System;
using System.Collections.Generic;

namespace gov
{
    namespace cca
    {

        public abstract class ManagerConnectionID : ConnectionID
        {
            public abstract bool Fetched { get; }
            public abstract void setFetched();
            public abstract void unsetFetched();
            public abstract void blockFetched();
            public abstract void unblockFetched();

            public abstract int[] Nodes { get; set; }

            public abstract ComponentID Provider { get; set; }
            public abstract string ProvidesPortName { get; set; }
            public abstract ComponentID User { get; set; }
            public abstract string UsesPortName { get; set; }

            public abstract WorkerConnectionID WorkerConnectionID { get; }
        }

        public class ManagerConnectionIDImpl : ManagerConnectionID
        {

            #region attributes

            private ComponentID provider;
            private string providesPortName;
            private ComponentID user;
            private string usesPortName;

            private int[] nodes;

            private string connectionString = null;

            #endregion

            #region ConnectionID Members

            public override ComponentID getProvider() { return provider; }
            public override ComponentID getUser() { return user; }
            public override string getProviderPortName() { return providesPortName; }
            public override string getUserPortName() { return usesPortName; }

            #endregion

            #region properties (for serialization purposes)

            public override ComponentID Provider
            {
                get { return this.provider; }
                set { this.provider = value; }
            }

            public override string ProvidesPortName
            {
                get { return this.providesPortName; }
                set { this.providesPortName = value; }
            }

            public override ComponentID User
            {
                get { return this.user; }
                set { this.user = value; }
            }

            public override string UsesPortName
            {
                get { return usesPortName; }
                set { this.usesPortName = value; }
            }

            public override int[] Nodes { get { return nodes; } set { this.nodes = value; } }

            #endregion
            
            #region constructors

            public ManagerConnectionIDImpl()
            {
                connectionString = User + "." + UsesPortName + "->" + Provider + "." + ProvidesPortName;
            }

            public ManagerConnectionIDImpl(ComponentID provider, string providesPortName, ComponentID user, string usesPortName, int[] nodes)
            {
                this.provider = provider;
                this.providesPortName = providesPortName;
                this.user = user;
                this.usesPortName = usesPortName;
                this.nodes = nodes;

                connectionString = User + "." + UsesPortName + "->" + Provider + "." + ProvidesPortName;
            }

            #endregion            

            #region disconnection synchronization

            private bool fetched = false;
            private bool block_fetch = false;


            public override bool Fetched { get { return fetched; } }

            public override void setFetched()
            {
                if (!this.canSetFetched())
                {
                    throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
                }

                fetched = true;
            }

            public override void unsetFetched()
            {
                fetched = false;
            }

            public override void blockFetched()
            {
                block_fetch = true;
            }

            public override void unblockFetched()
            {
                block_fetch = false;
            }

            private bool canSetFetched()
            {
                return !block_fetch;
            }

            #endregion

            public override WorkerConnectionID WorkerConnectionID
            {
                get
                {
                    WorkerComponentID wProvider = ((ManagerComponentID)Provider).WorkerComponentID;
                    WorkerComponentID wUser = ((ManagerComponentID)User).WorkerComponentID;
                    return new WorkerConnectionIDImpl(wProvider, providesPortName, wUser, usesPortName);
                }
            }

            public override string ToString()
            {
                return connectionString;
            }

            public override int GetHashCode()
            {
                return connectionString.GetHashCode();
            }

        }
    }
}
