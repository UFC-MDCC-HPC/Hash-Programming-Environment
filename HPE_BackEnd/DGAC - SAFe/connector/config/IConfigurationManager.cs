/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.ports;

namespace br.ufc.pargo.hpe.connector.config
{

   public interface IConfigurationManager : IConfigurationPort {

      MetaUnit Unit {get;}
      
      void Run();
      
      void Run(string actionName);
      
      void Run(MetaAction action);  
   }
   
   
}
