/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using br.ufc.pargo.hpe.basic;
using System.ServiceModel;
using gov.cca.ports;

namespace br.ufc.pargo.hpe.ports
{
	[ServiceContract]
	[ServiceKnownType(typeof(InitializePortWrapper))]
	public interface MultipleGoPort : GoPort
	{
        void addPort(GoPort port);
	}
}
