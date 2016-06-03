
using System;
using System.Collections.Generic;
using System.Runtime.Serialization;

namespace gov {	
	namespace cca {

        [DataContract]
		[KnownType(typeof(WorkerComponentIDImpl))]
        public abstract class WorkerComponentID : ComponentID
        {
        }

        [DataContract]
		public class WorkerComponentIDImpl : WorkerComponentID
        {
            #region attributes

			[DataMember]
            private string instanceNamePrim = null;

            #endregion

            #region constructors

            public WorkerComponentIDImpl(string instanceName) 
			{
				this.instanceNamePrim = instanceName;
            }

            #endregion

            #region ComponentID members

            public override string getInstanceName() 
			{
				return instanceNamePrim;
			}

            public override string getSerialization() 
			{
				return null; /* TODO: return a XML */
            }

            #endregion

            public override string ToString() 
			{
				return instanceNamePrim;
			}
			
        }
				
	}
}
