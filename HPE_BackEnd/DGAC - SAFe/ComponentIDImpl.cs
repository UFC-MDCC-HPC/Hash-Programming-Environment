
using System;
using System.Collections.Generic;

namespace gov {	
	namespace cca {
		
		public class ComponentIDImpl : ComponentID
		{
			
			public ComponentIDImpl(string instanceName) 
			{
				this.instanceName = instanceName;
			}
			
			private string instanceName = null;
			
	        public string getInstanceName() 
			{
				return instanceName;
			}

            public string getSerialization() 
			{
				return null; /* TODO: return a XML */
			}
			
		}
		
		
	}
}
