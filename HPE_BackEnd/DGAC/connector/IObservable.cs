/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

namespace br.ufc.pargo.hpe.connector {
   
   public interface IObservable {

      void Add(IObserver ob);

      void Remove(IObserver ob);
   }
}
