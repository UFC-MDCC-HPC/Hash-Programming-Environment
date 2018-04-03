
using System;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Diagnostics;

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

            public ManagerConnectionID(ComponentID provider, string providesPortName, ComponentID user, string usesPortName, WorkerConnectionID worker_connection)
            {
                this.provider = provider;
                this.providesPortName = providesPortName;
                this.user = user;
                this.usesPortName = usesPortName;
				this.worker_connection = worker_connection;

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

			private WorkerConnectionID worker_connection = null;
			
            public WorkerConnectionID WorkerConnectionID
            {
				get {
					return worker_connection;
				}
            }
        }

        public class ManagerConnectionIDImpl : ManagerConnectionID
        {

            #region attributes

            private int[] nodes;
			private bool ignore = false;

            #endregion

            #region properties (for serialization purposes)

            public int[] Nodes { get { return nodes; } set { this.nodes = value; } }

            #endregion
            
            #region constructors


            public ManagerConnectionIDImpl(ComponentID provider, 
			                                 string providesPortName, 
			                                 ComponentID user, 
			                                 string usesPortName, 
			                                 WorkerConnectionID worker_connections) 
                :  base(provider, providesPortName,user,usesPortName, worker_connections)
            {
                this.nodes = nodes;
				this.ignore = false;
            }

			public ManagerConnectionIDImpl(ComponentID provider, 
				string providesPortName, 
				ComponentID user, 
				string usesPortName) 
				:  base(provider, providesPortName,user,usesPortName, null)
			{
				this.ignore = true;
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

			public bool Ignore { get { return this.ignore; } }

            #endregion
			

        }


	}
}