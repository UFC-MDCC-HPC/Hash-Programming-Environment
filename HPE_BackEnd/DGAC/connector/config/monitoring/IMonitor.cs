/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System.Collections.Generic;
using br.ufc.pargo.hpe.connector.ports;


namespace br.ufc.pargo.hpe.connector.monitoring {
   
   public interface IMonitor : IMonitorPort {

      void Started(int state, int transation, int actionId);

      void Finalized(int state, int transation, int actionId);

      bool isRunning(List<int> actions);
      
      bool isRunning(int initialState, int finalState);
   }

}
