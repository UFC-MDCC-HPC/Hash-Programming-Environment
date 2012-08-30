/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

namespace br.ufc.pargo.hpe.connector.load{

   public class IdGenerator {
      protected int count;

      public IdGenerator() {
         count = 0;
      }

      public int genId() {
         return count++;
      }

      public void setInitialCode(int code) {
         count = code;
      }

      public int getCurrentCode() {
         return count;
      }
   }
}
