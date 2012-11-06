/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using br.ufc.pargo.hpe.connector.config;

using System.Collections.Generic;
using System.Threading;
using System;

using br.ufc.pargo.hpe.ConnectorImpl;

namespace br.ufc.pargo.hpe.connector.meta {

   //Classe que representa os metadados de uma ação (action) de uma unidade de um componente hash.
   public class MetaAction : MetaHashEntity {

      //Declaração de um delegate que simboliza as ações dos componentes nativos (escritos em c#).
      //As configurações terão referencias à esses métodos a partir de uma instância de DAction.
      public delegate void DAction();

      protected List<string> references;
      public List<string> References {
         get {return references;}
         set {references = value;}
      }
		
		public new string Name {
			get { return name.Equals("go") ? "main" : name;}
			set { name = value;}
		}
		
		
      //Representação do autômato de execução da ação. Este protocolo só terá valor quando a ação for
      //descrita em HCL. Caso contrário, quando a ação for descrita em linguagem nativa, o seu valor
      //será nulo.
      protected Configuration protocol;
      public Configuration Protocol {
         get {return protocol;}
         set {protocol = value;}
      }

      public bool IsNative {
         get {return ((father.Entity as IConnectorImpl) == null);}
      }

      public void Run() {
         if(IsNative) {
            DAction runnable = (DAction) Entity;
			Console.WriteLine("[MetaAction.Run] RUNNING {0} - {1}", this.Name, this.Father.Name);
            runnable(); //chamada da função via delegate.   
         } else {
			Console.WriteLine("[MetaAction.Run] RUNNING FOR COMPONENT {0} - {1}", this.Name, this.Father.Name);
            ((IConnectorImpl) father.Entity).perform_action(Name);
            //TODO Solucao para manter no mesmo ConfigurationManager suspensa.
            //WaitHandle.WaitAll(new ManualResetEvent[] {protocol.doneEvent}); 
         }
      }
   }   
}
