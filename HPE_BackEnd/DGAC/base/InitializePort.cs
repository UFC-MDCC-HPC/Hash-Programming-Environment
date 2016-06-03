/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using br.ufc.pargo.hpe.basic;
using System;
using System.ServiceModel;

namespace br.ufc.pargo.hpe.ports
{
	[ServiceContract]
	[ServiceKnownType(typeof(InitializePortWrapper))]
    public interface InitializePort : Port
    {
		[OperationContract]
        void on_initialize();

		[OperationContract]
     	void after_initialize();
    }

}
