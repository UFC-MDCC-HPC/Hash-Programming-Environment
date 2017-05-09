using System.Threading;
using System;
using br.ufc.pargo.hpe.kinds;

namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic{


public  class LogicActionCompute : LogicAction{

		String port_id;
	    String action_id;
        public CerificationResult result;

		//ITaskPort<IVerifyPortType> v;
		public LogicActionCompute( String compId, String port_id, String action_id, String handleId){

		this.compId=compId;
			this.port_id = port_id;
		this.action_id = action_id;	
			this.handleId=handleId;
		

		
		}

		public override void start() {
			_thread = new Thread((ThreadStart)delegate() 
			                        {
						
				
					run();
				
			});

			_thread.Start ();


		
		
		} public override void run() {
			     int compid=Convert.ToInt32(compId);
		

				
			Console.WriteLine("Computing action " +  action_id + " of port " + port_id + " of component " + compid 
				+" whose handleid informed is "+handleId);
			ITaskBindingKind v = (ITaskBindingKind) Certifier.services.getPort(port_id);
	

				//Certifier.verify_actions.TryGetValue(compid, out v);																																																																																																																																																																																																																																																																										
				//v.invoke (IVerify.VERIFY_PERFORM);
			v.invoke(action_id);
		  	IActionFutureSet future_iteration = null;

			IActionFuture future_conclusive = null; 
			//v.invoke (IVerify.VERIFY_CONCLUSIVE, out future_conclusive);
			v.invoke ("verify_conclusive", out future_conclusive);
			future_iteration = future_conclusive.createSet ();

			IActionFuture future_inconclusive = null; 
			//v.invoke (IVerify.VERIFY_INCONCLUSIVE, out future_inconclusive);
			v.invoke ("verify_inconclusive", out future_inconclusive);
			future_iteration.addAction (future_inconclusive);

		    IActionFuture r = future_iteration.waitAny ();

			result = r == future_conclusive ? CerificationResult.Conclusive : CerificationResult.Inconclusive;
			}

				
				
				
		
		}

					












}