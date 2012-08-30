/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

namespace br.ufc.pargo.hpe.connector.monitoring {

   public interface IMonitorable {

      void NotifyStarted(int state, int transition, int actionId);
      
      void NotifyFinalized(int state, int transition, int actionId);
      
      void AddMonitor(IMonitor monitor);
   }
}
