
using System;
using System.Collections.Generic;

namespace gov
{
    namespace cca
    {

        public abstract class WorkerConnectionID : ConnectionID
        {
            public abstract bool Fetched { get; }
            public abstract void setFetched();
            public abstract void unsetFetched();
            public abstract void blockFetched();
            public abstract void unblockFetched();
        }

        public class WorkerConnectionIDImpl : WorkerConnectionID
        {
            # region attribute

            private ComponentID provider;
            private string providesPortName;
            private ComponentID user;
            private string usesPortName;

            private string connectionString = null;

            #endregion

            #region ConnectionID members

            public override ComponentID getProvider() { return provider; }
            public override ComponentID getUser() { return user; }
            public override string getProviderPortName() { return providesPortName; }
            public override string getUserPortName() { return usesPortName; }

            #endregion

            #region constructor

            public WorkerConnectionIDImpl(ComponentID provider, string providesPortName, ComponentID user, string usesPortName)
            {
                this.provider = provider;
                this.providesPortName = providesPortName;
                this.user = user;
                this.usesPortName = usesPortName;
                connectionString = user + "." + usesPortName + "->" + provider + "." + providesPortName;
            }

            #endregion

            #region disconnection synchronization

            private bool block_fetch = false;
            private bool fetched = false;

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
