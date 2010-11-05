using System;
using System.Collections.Generic;

namespace gov {	
  namespace cca {
		class CCAExceptionImpl : Exception, CCAException
		{
			private CCAExceptionType etype = gov.cca.CCAExceptionType.Nonstandard;
				
			public CCAExceptionImpl(CCAExceptionType etype) : base(etype.ToString())
			{				
				this.etype = etype;
			}
			
			public CCAExceptionImpl(string message) : base(message)
			{				
				this.etype = etype;
			}
			
			public CCAExceptionType getCCAExceptionType() 
			{
				return etype;
			}
		}
  }
}