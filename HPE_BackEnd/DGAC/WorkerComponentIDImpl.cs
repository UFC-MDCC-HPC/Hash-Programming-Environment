
using System;
using System.Collections.Generic;

namespace gov {	
	namespace cca {

        [Serializable]
        public abstract class WorkerComponentID : ComponentID
        {
        }

        [Serializable]
		public class WorkerComponentIDImpl : WorkerComponentID
        {
            #region attributes

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
