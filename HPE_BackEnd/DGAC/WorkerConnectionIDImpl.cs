
using System;
using System.Collections.Generic;

namespace gov
{
    namespace cca
    {
		[Serializable]
        public abstract class WorkerConnectionID : ConnectionID
        {
        }
		
		[Serializable]
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
