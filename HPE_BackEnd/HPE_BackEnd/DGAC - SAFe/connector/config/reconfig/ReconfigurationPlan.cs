/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System;

using br.ufc.pargo.hpe.connector.monitoring;

namespace br.ufc.pargo.hpe.connector.reconfig
{
	public abstract class ReconfigurationPlan
	{
		protected Situation situation;
		public Situation Situation {
			get {return situation;}
		}

		public ReconfigurationPlan (Situation situation)
		{
			this.situation = situation;
		}

		protected abstract ReconfigurationRequest CreateReconfigurationRequest();
		
		public ReconfigurationRequest EvaluateAndGetReconfigurationRequest()
		{
			
			if(situation.IsAchived())
			{
				return CreateReconfigurationRequest();
			}
			
			return null;
		}
	}
}

