using System;
using gov.cca;
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.ports
{
	public interface IMonitorPort : Port
	{
      List<IMonitorEvent> Events {get;}

      Dictionary<int, int> Running {get;}
	}
}

