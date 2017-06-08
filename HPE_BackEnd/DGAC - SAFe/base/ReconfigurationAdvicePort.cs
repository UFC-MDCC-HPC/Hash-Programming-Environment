/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using br.ufc.pargo.hpe.basic;
using System;
using System.ServiceModel;

namespace br.ufc.pargo.hpe.ports
{
	public interface ReconfigurationAdvicePort : Port
    {
		[OperationContract]
        void changePort(string portName);
    }

}
