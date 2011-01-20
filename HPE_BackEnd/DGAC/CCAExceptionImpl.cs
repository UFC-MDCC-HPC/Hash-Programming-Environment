using System;
using System.Collections.Generic;
using System.Runtime.Serialization;

namespace gov
{
    namespace cca
    {
        [Serializable]
        class CCAExceptionImpl : Exception, CCAException
        {
            private CCAExceptionType etype = gov.cca.CCAExceptionType.Nonstandard;

            protected CCAExceptionImpl(SerializationInfo info, StreamingContext context)
                : base(info, context)
            {

            }

            public CCAExceptionImpl(CCAExceptionType etype)
                : base(etype.ToString())
            {
                this.etype = etype;
            }

            public CCAExceptionImpl(string message)
                : base(message)
            {
            }

            public CCAExceptionImpl(string message, Exception inner_exception)
                : base(message, inner_exception)
            {
            }

            public CCAExceptionType getCCAExceptionType()
            {
                return etype;
            }
        }
    }
}