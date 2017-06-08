/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System;
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.monitoring
{
	public interface Situation
	{
		bool IsAchived();
		
		List<object> GetAditionalInformation();
	}
}

