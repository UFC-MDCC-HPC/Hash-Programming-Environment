/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;
using gov.cca;

namespace br.ufc.pargo.hpe.connector.ports
{
	public interface IConfigurationPort: Port
	{
      void LoadComponent(string xml);

      bool EvaluateReconfiguration(string xml);
      
      bool CommitReconfiguration();

      void CancelReconfiguration();
      
      void PersistConfiguration();
	}
}

