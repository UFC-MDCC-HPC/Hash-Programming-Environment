/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.reconfig;
using br.ufc.pargo.hpe.connector.ports;

namespace br.ufc.pargo.hpe.connector.monitoring
{
	public class AutonomousAnalyzer
	{
		protected List<ReconfigurationPlan> plans;
		
		protected IConfigurationPort cmanager;

		public AutonomousAnalyzer (IConfigurationPort cmanager)
		{
			this.cmanager = cmanager;
			plans = new List<ReconfigurationPlan>();
		}
		
		public void AnalyzeAndApply()
		{
			ReconfigurationRequest request;
			foreach(ReconfigurationPlan plan in plans)
			{
				request = plan.EvaluateAndGetReconfigurationRequest();
				if(request != null) {
					if(cmanager.EvaluateReconfiguration(request))
					{
						cmanager.CommitReconfiguration();
					}
					else
					{
						cmanager.CancelReconfiguration();
					}
				}
			}
		}

		public void AddReconfigurationPlan(ReconfigurationPlan plan)
		{
			plans.Add (plan);
		}
		
		public void RemoveReconfigurationPlan(ReconfigurationPlan plan)
		{
			plans.Remove(plan);
		}
	}
}

