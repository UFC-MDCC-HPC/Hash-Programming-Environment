/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

namespace br.ufc.pargo.hpe.connector.reconfig {

   public class Interval {

      protected int initialState;
      public int InitialState {
         get {return initialState;}
         set {initialState = value;}
      }

      protected int finalState;
      public int FinalState {
         get {return finalState;}
         set {finalState = value;}
      }

      public Interval(int initialState, int finalState) {
         this.initialState = initialState;
         this.finalState = finalState;
      }
   }
}   