
using System;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;

namespace gov
{
    namespace cca
    {
        public abstract class ManagerConnectionID : ConnectionID
        {
            #region attributes

            protected ComponentID provider;
            protected string providesPortName;
            protected ComponentID user;
            protected string usesPortName;

            protected string connectionString = null;

            #endregion

            public ManagerConnectionID()
            {
                connectionString = User + "." + UsesPortName + "->" + Provider + "." + ProvidesPortName;
            }

            public ManagerConnectionID(ComponentID provider, string providesPortName, ComponentID user, string usesPortName)
            {
                this.provider = provider;
                this.providesPortName = providesPortName;
                this.user = user;
                this.usesPortName = usesPortName;

                connectionString = User + "." + UsesPortName + "->" + Provider + "." + ProvidesPortName;
            }

            #region ConnectionID Members

            public override ComponentID getProvider() { return provider; }
            public override ComponentID getUser() { return user; }
            public override string getProviderPortName() { return providesPortName; }
            public override string getUserPortName() { return usesPortName; }

            #endregion

            #region properties (for serialization purposes)

            public ComponentID Provider
            {
                get { return this.provider; }
                set { this.provider = value; }
            }

            public string ProvidesPortName
            {
                get { return this.providesPortName; }
                set { this.providesPortName = value; }
            }

            public ComponentID User
            {
                get { return this.user; }
                set { this.user = value; }
            }

            public string UsesPortName
            {
                get { return usesPortName; }
                set { this.usesPortName = value; }
            }
            #endregion

            public override string ToString()
            {
                return connectionString;
            }

            public override int GetHashCode()
            {
                return connectionString.GetHashCode();
            }

        }

        public class ManagerDirectConnectionID : ManagerConnectionID
        {

            #region attributes

            private int[] nodes;

            #endregion

            #region properties (for serialization purposes)

            public int[] Nodes { get { return nodes; } set { this.nodes = value; } }

            #endregion
            
            #region constructors


            public ManagerDirectConnectionID(ComponentID provider, string providesPortName, ComponentID user, string usesPortName, int[] nodes) 
                :  base(provider, providesPortName,user,usesPortName)
            {
                this.nodes = nodes;
            }

            #endregion            

            #region disconnection synchronization

            private bool fetched = false;
            private bool block_fetch = false;


            public bool Fetched { get { return fetched; } }

            public void setFetched()
            {
                if (!this.canSetFetched())
                {
                    throw new CCAExceptionImpl(CCAExceptionType.PortNotConnected);
                }

                fetched = true;
            }

            public void unsetFetched()
            {
                fetched = false;
            }

            public void blockFetched()
            {
                block_fetch = true;
            }

            public void unblockFetched()
            {
                block_fetch = false;
            }

            private bool canSetFetched()
            {
                return !block_fetch;
            }

            #endregion

            public WorkerConnectionID WorkerConnectionID
            {
                get
                {
                    WorkerComponentID wProvider = ((ManagerComponentID)Provider).WorkerComponentID;
                    WorkerComponentID wUser = ((ManagerComponentID)User).WorkerComponentID;
                    return new WorkerConnectionIDImpl(wProvider, providesPortName, wUser, usesPortName);
                }
            }

        }


        public class ManagerIndirectConnectionID : ManagerConnectionID
        {

            #region attributes

            private ComponentID binding;

            private int[] nodes_user;
            private int[] nodes_provider;

            #endregion

            #region ConnectionID Members

            public ComponentID getBinding() { return user; }

            #endregion

            public ComponentID Binding
            {
                get { return binding; }
                set { this.binding = value; }
            }

            public int[] NodesUser { get { return nodes_user; } set { this.nodes_user = value; } }
            public int[] NodesProvider { get { return nodes_provider; } set { this.nodes_provider = value; } }

            public ManagerConnectionID conn_user;
            public ManagerConnectionID conn_prov;
            
            #region constructors


            public ManagerIndirectConnectionID(ComponentID provider, string providesPortName, ComponentID user, string usesPortName, ComponentID binding, ManagerConnectionID conn_user, ManagerConnectionID conn_prov, int[] nodes_user, int[] nodes_provider)
                : base(provider, providesPortName, user, usesPortName)
            {
                this.nodes_user = nodes_user;
                this.nodes_provider = nodes_provider;
                this.binding = binding;
                this.conn_user = conn_user;
                this.conn_prov = conn_prov;
            }

            #endregion            

            public WorkerConnectionID WorkerConnectionID_user
            {
                get
                {
                    WorkerComponentID wUser = ((ManagerComponentID)User).WorkerComponentID;
                    WorkerComponentID wBinding = ((ManagerComponentID)Binding).WorkerComponentID;
                    return new WorkerConnectionIDImpl(wBinding, Constants.DEFAULT_PROVIDES_PORT_SERVICE, wUser, usesPortName);
                }
            }

            public WorkerConnectionID WorkerConnectionID_provider
            {
                get
                {
                    WorkerComponentID wBinding = ((ManagerComponentID)Binding).WorkerComponentID;
                    WorkerComponentID wProvider = ((ManagerComponentID)Provider).WorkerComponentID;
                    return new WorkerConnectionIDImpl(wProvider, providesPortName, wBinding, Constants.DEFAULT_USES_PORT_SERVICE);
                }
            }

        }
    }
}
