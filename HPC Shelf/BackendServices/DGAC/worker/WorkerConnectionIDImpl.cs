
using System;
using System.Collections.Generic;
using System.Runtime.Serialization;

namespace gov
{
    namespace cca
    {
		[DataContract]
		[KnownType(typeof(WorkerConnectionIDImpl))]
		public abstract class WorkerConnectionID : ConnectionID
        {
        }
		
		[DataContract]
        public class WorkerConnectionIDImpl : WorkerConnectionID
        {
            # region attribute

			[DataMember]
			private ComponentID provider;

			[DataMember]
            private string providesPortName;

			[DataMember]
            private ComponentID user;

			[DataMember]
            private string usesPortName;

			[DataMember]
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
