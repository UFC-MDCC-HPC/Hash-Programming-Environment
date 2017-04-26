using System.Threading;
using System;
using br.ufc.pargo.hpe.kinds;
using br.ufc.mdcc.hpc.shelf.tactical.task.VerifyPortType;
using br.ufc.mdcc.hpc.storm.binding.task.TaskBindingBase;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic{


public  class LogicActionCompute : LogicAction{

	
	String action_id;
		ITaskPort<IVerifyPortType> v;
		public LogicActionCompute( String compId, String action_id, String handleId){

		this.compId=compId;
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
		
				
				
				Console.WriteLine("Computing action " +  action_id + " of component " + compid + 	" "+																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																 
				Certifier.tactical_names[compid] +" whose handleid informed is "+handleId);
				
	

				Certifier.verify_actions.TryGetValue(compid, out v);																																																																																																																																																																																																																																																																										
				v.invoke (IVerify.VERIFY_PERFORM);

		  	IActionFutureSet future_iteration = null;

			IActionFuture future_conclusive = null; 
			v.invoke (IVerify.VERIFY_CONCLUSIVE, out future_conclusive);

			future_iteration = future_conclusive.createSet ();

			IActionFuture future_inconclusive = null; 
			v.invoke (IVerify.VERIFY_INCONCLUSIVE, out future_inconclusive);
			future_iteration.addAction (future_inconclusive);

		future_iteration.waitAny ();

			
			}

				
				
				
		
		}

					












}