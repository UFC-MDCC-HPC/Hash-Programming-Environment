using br.ufc.pargo.hpe.connector;
/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/


namespace br.ufc.pargo.hpe.connector.monitoring {
   
   public class MonitorEvent : IMonitorEvent {
      protected int _state;
      public int state {
         get {return _state;}
         set {_state = value;}
      }
      protected int _transation;
      public int transation {
         get {return _transation;}
         set {_transation = value;}
      }

      public MonitorEvent(int state, int transation) {
         this.state = state;
         this.transation = transation;
      }
   }
}
